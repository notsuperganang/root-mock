package com.research.fakegps;

import android.content.Context;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Handles GPS location injection via root shell commands.
 *
 * Attempts three injection methods in order of reliability, falling back
 * to the next if the previous fails. Requires root (su) access on the device.
 *
 * @see docs/TECHNICAL_ANALYSIS.md for a full breakdown of each injection method.
 */
public class GPSInjector {

    private static final String TAG = "GPSInjector";
    private Context context;
    private boolean isFakeGPSActive = false;

    public GPSInjector(Context context) {
        this.context = context;
    }

    /**
     * Injects a fake GPS location using the most reliable available method.
     *
     * @param latitude  Target latitude (-90 to 90)
     * @param longitude Target longitude (-180 to 180)
     * @return true if injection succeeded, false if all methods failed
     */
    public boolean setFakeLocation(double latitude, double longitude) {
        Log.d(TAG, String.format("Setting fake location: %.6f, %.6f", latitude, longitude));

        boolean success = injectViaSystemBroadcast(latitude, longitude);

        if (!success) {
            success = injectViaLocationProvider(latitude, longitude);
        }

        if (!success) {
            success = injectViaSystemProperty(latitude, longitude);
        }

        if (success) {
            isFakeGPSActive = true;
            Log.i(TAG, "Fake GPS activated successfully");
        } else {
            Log.e(TAG, "All injection methods failed");
        }

        return success;
    }

    /** Method 1: Send a GPS_FIX_CHANGE broadcast with spoofed coordinates. */
    private boolean injectViaSystemBroadcast(double latitude, double longitude) {
        try {
            String command = String.format(
                "am broadcast -a android.location.GPS_FIX_CHANGE " +
                "--ef latitude %f --ef longitude %f " +
                "--ef accuracy 1.0 --ef altitude 100.0 " +
                "--ef bearing 0.0 --ef speed 0.0 --el time %d",
                latitude, longitude, System.currentTimeMillis()
            );
            return executeRootCommand(command);
        } catch (Exception e) {
            Log.e(TAG, "Broadcast injection failed", e);
            return false;
        }
    }

    /** Method 2: Write coordinates to a file and trigger a location provider reload. */
    private boolean injectViaLocationProvider(double latitude, double longitude) {
        try {
            String command = String.format(
                "echo 'lat=%f,lon=%f,acc=1.0,time=%d' > /data/local/tmp/gps_override.txt && " +
                "chmod 666 /data/local/tmp/gps_override.txt",
                latitude, longitude, System.currentTimeMillis()
            );
            boolean success = executeRootCommand(command);
            if (success) {
                executeRootCommand("am broadcast -a com.android.internal.location.LOCATION_CHANGED");
            }
            return success;
        } catch (Exception e) {
            Log.e(TAG, "Provider injection failed", e);
            return false;
        }
    }

    /** Method 3: Set a system property with the spoofed coordinates (legacy fallback). */
    private boolean injectViaSystemProperty(double latitude, double longitude) {
        try {
            String command = String.format(
                "setprop persist.sys.mock.location '%f,%f'", latitude, longitude
            );
            return executeRootCommand(command);
        } catch (Exception e) {
            Log.e(TAG, "Property injection failed", e);
            return false;
        }
    }

    /** Stops fake GPS by cleaning up override files and system properties. */
    public boolean stopFakeLocation() {
        Log.d(TAG, "Stopping fake GPS");
        try {
            String cleanupCommand =
                "rm -f /data/local/tmp/gps_override.txt && " +
                "setprop persist.sys.mock.location ''";
            boolean success = executeRootCommand(cleanupCommand);
            if (success) {
                isFakeGPSActive = false;
                executeRootCommand("am broadcast -a android.location.PROVIDERS_CHANGED");
                Log.i(TAG, "Fake GPS stopped successfully");
            }
            return success;
        } catch (Exception e) {
            Log.e(TAG, "Failed to stop fake GPS", e);
            return false;
        }
    }

    /** Executes a shell command with superuser privileges. */
    private boolean executeRootCommand(String command) {
        Process process = null;
        DataOutputStream outputStream = null;
        try {
            process = Runtime.getRuntime().exec("su");
            outputStream = new DataOutputStream(process.getOutputStream());
            outputStream.writeBytes(command + "\n");
            outputStream.flush();
            outputStream.writeBytes("exit\n");
            outputStream.flush();
            int exitValue = process.waitFor();
            return exitValue == 0;
        } catch (IOException e) {
            Log.e(TAG, "IO error executing root command", e);
            return false;
        } catch (InterruptedException e) {
            Log.e(TAG, "Root command interrupted", e);
            return false;
        } finally {
            try {
                if (outputStream != null) outputStream.close();
                if (process != null) process.destroy();
            } catch (IOException e) {
                Log.e(TAG, "Error closing streams", e);
            }
        }
    }

    public boolean isFakeGPSActive() {
        return isFakeGPSActive;
    }

    public void cleanup() {
        if (isFakeGPSActive) {
            stopFakeLocation();
        }
    }
}
