package com.research.fakegps;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * ROOT CHECKER
 * 
 * Verify apakah HP sudah di-root atau belum
 * App ini WAJIB root untuk bisa jalan
 */
public class RootChecker {

    private static final String TAG = "RootChecker";

    /**
     * Check if device is rooted
     * 
     * Multiple checks untuk reliability
     */
    public boolean isDeviceRooted() {
        return checkSuBinary() || checkMagisk() || checkSuCommand();
    }

    /**
     * CHECK 1: Cek apakah su binary ada
     */
    private boolean checkSuBinary() {
        String[] paths = {
            "/system/bin/su",
            "/system/xbin/su",
            "/sbin/su",
            "/system/su",
            "/system/bin/.ext/.su",
            "/system/usr/we-need-root/su-backup",
            "/system/xbin/mu"
        };

        for (String path : paths) {
            if (new File(path).exists()) {
                Log.d(TAG, "Root detected: su binary found at " + path);
                return true;
            }
        }

        return false;
    }

    /**
     * CHECK 2: Cek apakah Magisk terinstall
     */
    private boolean checkMagisk() {
        String[] magiskPaths = {
            "/data/adb/magisk",
            "/sbin/.magisk",
            "/data/adb/modules"
        };

        for (String path : magiskPaths) {
            if (new File(path).exists()) {
                Log.d(TAG, "Root detected: Magisk found at " + path);
                return true;
            }
        }

        return false;
    }

    /**
     * CHECK 3: Test execute su command
     * 
     * Cara paling reliable - langsung coba jalankan
     */
    private boolean checkSuCommand() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            BufferedReader in = new BufferedReader(
                new InputStreamReader(process.getInputStream())
            );
            
            // If we can execute su, device is rooted
            if (in != null) {
                Log.d(TAG, "Root detected: su command executable");
                return true;
            }
        } catch (Exception e) {
            Log.d(TAG, "Root not detected: Cannot execute su command");
        } finally {
            if (process != null) {
                process.destroy();
            }
        }

        return false;
    }

    /**
     * Get detailed root info (for debugging)
     */
    public String getRootInfo() {
        StringBuilder info = new StringBuilder();
        
        info.append("Root Status Check:\n");
        info.append("─────────────────────\n");
        info.append("Su Binary: ").append(checkSuBinary() ? "✓ Found" : "✗ Not found").append("\n");
        info.append("Magisk: ").append(checkMagisk() ? "✓ Found" : "✗ Not found").append("\n");
        info.append("Su Command: ").append(checkSuCommand() ? "✓ Executable" : "✗ Not executable").append("\n");
        info.append("─────────────────────\n");
        info.append("Overall: ").append(isDeviceRooted() ? "✓ ROOTED" : "✗ NOT ROOTED");
        
        return info.toString();
    }
}
