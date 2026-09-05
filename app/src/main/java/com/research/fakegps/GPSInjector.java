package com.research.fakegps;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.List;

/**
 * LSPosed Framework-integrated GPS location injection (based on tiket.git approach).
 *
 * Strategy: Mirror all existing location providers + CONTINUOUS UPDATES
 * The key: keep updating location in background thread so it doesn't revert.
 */
public class GPSInjector {

    private static final String TAG = "GPSInjector-LSPosed";
    private static final long UPDATE_INTERVAL_MS = 1000;  // Update every 1 second (like tiket.git)

    private Context context;
    private LocationManager locationManager;
    private boolean isFakeGPSActive = false;
    private LocationUpdateThread updateThread;
    private double currentLat;
    private double currentLon;

    public GPSInjector(Context context) {
        this.context = context;
        this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    /**
     * Injects fake location and starts continuous update thread (like tiket.git).
     * The key to persistence: keep updating location every second!
     *
     * @param latitude  Target latitude
     * @param longitude Target longitude
     * @return true if injection succeeded
     */
    public boolean setFakeLocation(double latitude, double longitude) {
        Log.d(TAG, String.format("Injecting fake location: %.6f, %.6f", latitude, longitude));

        try {
            if (locationManager == null) {
                Log.e(TAG, "LocationManager is null");
                return false;
            }

            // Store coordinates for continuous updates
            currentLat = latitude;
            currentLon = longitude;

            // Get all existing providers
            List<String> allProviders = locationManager.getAllProviders();
            Log.d(TAG, "Found " + allProviders.size() + " providers: " + allProviders.toString());

            // Create test version for each provider
            for (String providerName : allProviders) {
                try {
                    LocationProvider provider = locationManager.getProvider(providerName);
                    if (provider == null) continue;

                    locationManager.addTestProvider(
                        providerName,
                        provider.requiresNetwork(),
                        provider.requiresSatellite(),
                        provider.requiresCell(),
                        provider.hasMonetaryCost(),
                        provider.supportsAltitude(),
                        provider.supportsSpeed(),
                        provider.supportsBearing(),
                        provider.getPowerRequirement(),
                        provider.getAccuracy()
                    );

                    locationManager.setTestProviderEnabled(providerName, true);
                    locationManager.setTestProviderStatus(providerName, 2, null, System.currentTimeMillis());
                    Log.d(TAG, "Test provider enabled: " + providerName);

                } catch (Exception e) {
                    Log.d(TAG, "Failed to setup provider " + providerName + ": " + e.getMessage());
                }
            }

            // Update all providers once
            updateAllProviders();

            // Start background thread for continuous updates (KEY TO PERSISTENCE!)
            isFakeGPSActive = true;
            updateThread = new LocationUpdateThread();
            updateThread.start();
            Log.i(TAG, "Fake GPS injected + continuous update thread started");

            return true;

        } catch (Exception e) {
            Log.e(TAG, "Failed to inject fake location", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update all test providers with current fake location.
     */
    private void updateAllProviders() {
        if (locationManager == null) return;

        List<String> allProviders = locationManager.getAllProviders();
        for (String providerName : allProviders) {
            try {
                Location fakeLocation = new Location(providerName);
                fakeLocation.setLatitude(currentLat);
                fakeLocation.setLongitude(currentLon);
                fakeLocation.setProvider(providerName);
                fakeLocation.setAccuracy(1.0f);
                fakeLocation.setBearing(0.0f);
                fakeLocation.setAltitude(100.0);
                fakeLocation.setSpeed(0.0f);
                fakeLocation.setTime(System.currentTimeMillis());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    fakeLocation.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
                }

                locationManager.setTestProviderLocation(providerName, fakeLocation);

            } catch (Exception e) {
                Log.d(TAG, "Failed to update " + providerName + ": " + e.getMessage());
            }
        }
    }

    /**
     * Stops fake GPS injection and removes test providers.
     */
    public boolean stopFakeLocation() {
        Log.d(TAG, "Stopping fake GPS");
        try {
            isFakeGPSActive = false;

            // Stop update thread
            if (updateThread != null) {
                updateThread.interrupt();
                try {
                    updateThread.join(2000);  // Wait max 2 seconds
                } catch (InterruptedException e) {
                    Log.d(TAG, "Thread interrupt ignored");
                }
                updateThread = null;
            }

            if (locationManager == null) return false;

            List<String> allProviders = locationManager.getAllProviders();
            for (String providerName : allProviders) {
                try {
                    locationManager.setTestProviderEnabled(providerName, false);
                    locationManager.removeTestProvider(providerName);
                    Log.d(TAG, "Test provider removed: " + providerName);
                } catch (Exception e) {
                    Log.d(TAG, "Failed to remove provider " + providerName);
                }
            }

            Log.i(TAG, "Fake GPS stopped successfully");
            return true;

        } catch (Exception e) {
            Log.e(TAG, "Failed to stop fake GPS", e);
        }
        return false;
    }

    public boolean isFakeGPSActive() {
        return isFakeGPSActive;
    }

    public void cleanup() {
        if (isFakeGPSActive) {
            stopFakeLocation();
        }
    }

    /**
     * Background thread that continuously updates location (key to persistence).
     * Mimics tiket.git's Run thread - updates every second.
     */
    private class LocationUpdateThread extends Thread {
        @Override
        public void run() {
            Log.d(TAG, "LocationUpdateThread started");
            while (isFakeGPSActive) {
                try {
                    // Update all providers with current coordinates
                    updateAllProviders();

                    // Sleep 1 second before next update (like tiket.git)
                    Thread.sleep(UPDATE_INTERVAL_MS);

                } catch (InterruptedException e) {
                    Log.d(TAG, "LocationUpdateThread interrupted");
                    break;
                } catch (Exception e) {
                    Log.e(TAG, "Error in LocationUpdateThread", e);
                }
            }
            Log.d(TAG, "LocationUpdateThread ended");
        }
    }
}
