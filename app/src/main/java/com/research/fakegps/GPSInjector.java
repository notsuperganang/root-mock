package com.research.fakegps;

import android.content.Context;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * GPS INJECTOR - CORE COMPONENT
 * 
 * INI YANG MEMBEDAKAN APP CUSTOM VS APP PLAY STORE!
 * 
 * APP PLAY STORE (Official):
 * ────────────────────────────────────────────────────────────────
 * LocationManager locationManager = ...;
 * locationManager.addTestProvider(...);
 * locationManager.setTestProviderLocation(...);
 * 
 * PROBLEMS:
 * ✗ Require Developer Options ON
 * ✗ Require "Allow Mock Locations" enabled
 * ✗ App must be selected as mock location provider
 * ✗ Location.isFromMockProvider() returns TRUE (terdeteksi!)
 * ✗ Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED returns 1 (terdeteksi!)
 * 
 * APP CUSTOM INI (Root-based):
 * ────────────────────────────────────────────────────────────────
 * Process process = Runtime.getRuntime().exec("su");
 * DataOutputStream os = new DataOutputStream(process.getOutputStream());
 * os.writeBytes("command untuk inject GPS\n");
 * 
 * ADVANTAGES:
 * ✓ Developer Options tetap OFF (tidak terdeteksi!)
 * ✓ Location.isFromMockProvider() returns FALSE (dibohongi via LSPosed!)
 * ✓ Settings check returns 0 (dibohongi via LSPosed!)
 * ✓ Bypass semua detection method yang cek developer settings
 * 
 * TAPI BUTUH:
 * - Root access (Magisk)
 * - LSPosed Framework + modules untuk hide mock flag
 * - Bootloader unlocked
 */
public class GPSInjector {

    private static final String TAG = "GPSInjector";
    private Context context;
    private boolean isFakeGPSActive = false;

    public GPSInjector(Context context) {
        this.context = context;
    }

    /**
     * Set fake GPS location via ROOT command
     * 
     * METHOD YANG DIPAKAI:
     * Ada beberapa cara inject GPS via root, kita pakai yang paling reliable
     */
    public boolean setFakeLocation(double latitude, double longitude) {
        Log.d(TAG, String.format("Setting fake location: %.6f, %.6f", latitude, longitude));

        // Try multiple methods (fallback if one fails)
        boolean success = false;

        // METHOD 1: Via system broadcast (paling reliable)
        success = injectViaSystemBroadcast(latitude, longitude);
        
        if (!success) {
            // METHOD 2: Via location provider modification
            success = injectViaLocationProvider(latitude, longitude);
        }
        
        if (!success) {
            // METHOD 3: Via system property (legacy)
            success = injectViaSystemProperty(latitude, longitude);
        }

        if (success) {
            isFakeGPSActive = true;
            Log.i(TAG, "Fake GPS activated successfully");
        } else {
            Log.e(TAG, "All injection methods failed!");
        }

        return success;
    }

    /**
     * METHOD 1: Inject via system broadcast
     * 
     * Kirim broadcast ke system dengan koordinat fake
     * System akan treat ini sebagai GPS update yang sah
     */
    private boolean injectViaSystemBroadcast(double latitude, double longitude) {
        try {
            // Build command
            String command = String.format(
                "am broadcast -a android.location.GPS_FIX_CHANGE " +
                "--ef latitude %f --ef longitude %f " +
                "--ef accuracy 1.0 " +
                "--ef altitude 100.0 " +
                "--ef bearing 0.0 " +
                "--ef speed 0.0 " +
                "--el time %d",
                latitude, longitude, System.currentTimeMillis()
            );

            return executeRootCommand(command);
            
        } catch (Exception e) {
            Log.e(TAG, "Broadcast injection failed", e);
            return false;
        }
    }

    /**
     * METHOD 2: Inject via location provider modification
     * 
     * Modify location provider secara langsung via system files
     */
    private boolean injectViaLocationProvider(double latitude, double longitude) {
        try {
            // Command untuk modify location provider
            String command = String.format(
                "echo 'lat=%f,lon=%f,acc=1.0,time=%d' > /data/local/tmp/gps_override.txt && " +
                "chmod 666 /data/local/tmp/gps_override.txt",
                latitude, longitude, System.currentTimeMillis()
            );

            boolean success = executeRootCommand(command);
            
            if (success) {
                // Trigger location provider untuk baca file override
                String triggerCommand = 
                    "am broadcast -a com.android.internal.location.LOCATION_CHANGED";
                executeRootCommand(triggerCommand);
            }

            return success;
            
        } catch (Exception e) {
            Log.e(TAG, "Provider injection failed", e);
            return false;
        }
    }

    /**
     * METHOD 3: Inject via system property (legacy method)
     * 
     * Set system property langsung
     * Older method, might not work on newer Android versions
     */
    private boolean injectViaSystemProperty(double latitude, double longitude) {
        try {
            String command = String.format(
                "setprop persist.sys.mock.location '%f,%f'",
                latitude, longitude
            );

            return executeRootCommand(command);
            
        } catch (Exception e) {
            Log.e(TAG, "Property injection failed", e);
            return false;
        }
    }

    /**
     * Stop fake GPS and restore real location
     */
    public boolean stopFakeLocation() {
        Log.d(TAG, "Stopping fake GPS");

        try {
            // Clean up override files
            String cleanupCommand = 
                "rm -f /data/local/tmp/gps_override.txt && " +
                "setprop persist.sys.mock.location ''";
            
            boolean success = executeRootCommand(cleanupCommand);
            
            if (success) {
                isFakeGPSActive = false;
                
                // Broadcast location change untuk trigger refresh
                String refreshCommand = 
                    "am broadcast -a android.location.PROVIDERS_CHANGED";
                executeRootCommand(refreshCommand);
                
                Log.i(TAG, "Fake GPS stopped successfully");
            }

            return success;
            
        } catch (Exception e) {
            Log.e(TAG, "Failed to stop fake GPS", e);
            return false;
        }
    }

    /**
     * CORE FUNCTION: Execute command dengan ROOT access
     * 
     * INI YANG TIDAK MUNGKIN DILAKUKAN TANPA ROOT!
     * 
     * App Play Store tidak bisa exec "su" command
     * Hanya app dengan root access yang bisa
     */
    private boolean executeRootCommand(String command) {
        Process process = null;
        DataOutputStream outputStream = null;

        try {
            // Request superuser access
            // INI AKAN FAIL JIKA HP TIDAK ROOTED!
            process = Runtime.getRuntime().exec("su");
            
            outputStream = new DataOutputStream(process.getOutputStream());
            
            // Write command
            outputStream.writeBytes(command + "\n");
            outputStream.flush();
            
            // Exit su shell
            outputStream.writeBytes("exit\n");
            outputStream.flush();
            
            // Wait for command to complete
            int exitValue = process.waitFor();
            
            if (exitValue == 0) {
                Log.d(TAG, "Command executed successfully: " + command);
                return true;
            } else {
                Log.e(TAG, "Command failed with exit code: " + exitValue);
                return false;
            }
            
        } catch (IOException e) {
            Log.e(TAG, "IO Error executing command", e);
            return false;
        } catch (InterruptedException e) {
            Log.e(TAG, "Command interrupted", e);
            return false;
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (IOException e) {
                Log.e(TAG, "Error closing streams", e);
            }
        }
    }

    /**
     * Check if fake GPS is currently active
     */
    public boolean isFakeGPSActive() {
        return isFakeGPSActive;
    }

    /**
     * Cleanup resources
     */
    public void cleanup() {
        if (isFakeGPSActive) {
            stopFakeLocation();
        }
    }
}
