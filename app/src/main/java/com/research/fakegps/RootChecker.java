package com.research.fakegps;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Verifies whether the device has root access.
 *
 * Uses three independent checks in combination to improve detection accuracy
 * across different root implementations (Magisk, SuperSU, etc.).
 */
public class RootChecker {

    private static final String TAG = "RootChecker";

    /** Returns true if any root indicator is found on the device. */
    public boolean isDeviceRooted() {
        return checkSuBinary() || checkMagisk() || checkSuCommand();
    }

    /** Check 1: Look for su binary in known system paths. */
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
                Log.d(TAG, "Root detected: su binary at " + path);
                return true;
            }
        }
        return false;
    }

    /** Check 2: Look for Magisk installation directories. */
    private boolean checkMagisk() {
        String[] magiskPaths = {
            "/data/adb/magisk",
            "/sbin/.magisk",
            "/data/adb/modules"
        };
        for (String path : magiskPaths) {
            if (new File(path).exists()) {
                Log.d(TAG, "Root detected: Magisk at " + path);
                return true;
            }
        }
        return false;
    }

    /** Check 3: Attempt to execute su — succeeds only on rooted devices. */
    private boolean checkSuCommand() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            if (in != null) {
                Log.d(TAG, "Root detected: su command executable");
                return true;
            }
        } catch (Exception e) {
            Log.d(TAG, "Root not detected: su command failed");
        } finally {
            if (process != null) process.destroy();
        }
        return false;
    }

    /** Returns a human-readable summary of all root checks. */
    public String getRootInfo() {
        return "Su Binary: " + (checkSuBinary() ? "Found" : "Not found") + "\n" +
               "Magisk:    " + (checkMagisk()   ? "Found" : "Not found") + "\n" +
               "Su Command:" + (checkSuCommand() ? "Executable" : "Not executable") + "\n" +
               "Overall:   " + (isDeviceRooted() ? "ROOTED" : "NOT ROOTED");
    }
}
