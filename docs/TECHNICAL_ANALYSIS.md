# Technical Analysis: Root-Based GPS Injection vs. Mock Location API

## Overview

Android provides an official mechanism for GPS spoofing — the Mock Location API. However, this mechanism is intentionally designed to be detectable. Applications that depend on real location data (such as government attendance systems) can check whether a location is mocked and reject it.

This document explains why root-based injection bypasses those checks, and how each injection method works.

---

## Comparison: Mock Location API vs. Root-Based Injection

| Aspect | Play Store Apps (Mock Location API) | This App (Root-Based) |
|--------|--------------------------------------|-----------------------|
| API used | `LocationManager.setTestProviderLocation()` | `Runtime.exec("su")` + shell commands |
| Developer Options required | Yes — must be ON | No |
| `Allow Mock Locations` setting | Must be set manually by user | Not required |
| `Location.isFromMockProvider()` | Returns `true` (detectable) | Returns `false` (with LSPosed) |
| `DEVELOPMENT_SETTINGS_ENABLED` | Returns `1` (detectable) | Returns `0` (with LSPosed) |
| Root required | No | Yes (Magisk) |
| Detectable by attendance apps | Yes, trivially | No, with LSPosed modules active |

### Why Mock Location API Is Detectable

When an app calls `setTestProviderLocation()`, Android internally sets the mock flag on the `Location` object. Any app can call `location.isFromMockProvider()` and receive `true`. Additionally, using the Mock Location API requires Developer Options to be enabled — a setting that is also trivially checkable via `Settings.Secure.getInt(DEVELOPMENT_SETTINGS_ENABLED)`.

### Why Root-Based Injection Bypasses Detection

Root-based injection does not use the official API. It sends commands directly to system processes via a privileged shell. The system processes the location update as if it came from real hardware.

Without LSPosed, `isFromMockProvider()` may still return `true` in some configurations. LSPosed hooks intercept the relevant system calls and return falsified values:
- `isFromMockProvider()` → `false`
- `DEVELOPMENT_SETTINGS_ENABLED` → `0`

This combination makes the spoofed location indistinguishable from a real one at the API level.

---

## Injection Methods

### Method 1 — System Broadcast (`GPS_FIX_CHANGE`)

**Command:**
```bash
am broadcast -a android.location.GPS_FIX_CHANGE \
  --ef latitude <lat> --ef longitude <lon> \
  --ef accuracy 1.0 --ef altitude 100.0 \
  --ef bearing 0.0 --ef speed 0.0 --el time <epoch_ms>
```

**How it works:** Sends a broadcast intent that the system's GPS subsystem listens to. The system treats this as a legitimate GPS hardware event and propagates the coordinates to all location consumers.

**Reliability:** Highest. Works on most Android versions with root access.

---

### Method 2 — Override File + Broadcast

**Command:**
```bash
echo 'lat=<lat>,lon=<lon>,acc=1.0,time=<epoch_ms>' > /data/local/tmp/gps_override.txt
chmod 666 /data/local/tmp/gps_override.txt
am broadcast -a com.android.internal.location.LOCATION_CHANGED
```

**How it works:** Writes coordinates to a file in a root-accessible path, then triggers the location provider to re-read its configuration. Some system configurations poll this path.

**Reliability:** Medium. Depends on the Android build and whether the internal broadcast is honored.

---

### Method 3 — System Property (Legacy Fallback)

**Command:**
```bash
setprop persist.sys.mock.location '<lat>,<lon>'
```

**How it works:** Sets a persistent system property. Some older GPS drivers and location providers read this property as a coordinate override.

**Reliability:** Low on modern Android (API 29+). Retained as a last-resort fallback.

---

## LSPosed Module Requirements

Without LSPosed, the injected location may still be flagged as mocked by Android internals. Two modules are required:

| Module | Function |
|--------|----------|
| **Mock Mock Locations** | Hooks `isFromMockProvider()` to return `false` |
| **LocationReportEnabler** | Ensures location broadcasts reach all consumers regardless of privacy settings |

**Scope configuration:** Both modules must be scoped to `system_framework` and to the target attendance application. A device reboot is required after enabling or reconfiguring modules.

---

## Recommended Detection Countermeasures

Based on this analysis, the following detection methods are effective against root-based injection and cannot be trivially bypassed:

| Method | Effectiveness | Notes |
|--------|--------------|-------|
| Bootloader lock check | Very high | Unlocked bootloader is a prerequisite for Magisk |
| Knox attestation (Samsung) | Very high | Hardware-backed, cannot be spoofed |
| SafetyNet / Play Integrity API | High | Detects Magisk unless hidden via Shamiko |
| GPS behavioral analysis | Medium | Detects teleportation, impossible speed, perfect accuracy |
| Cell tower / Wi-Fi triangulation | Medium | Cross-references GPS with network location |
| Multi-factor combination | Highest | Combine two or more of the above |

Checking Developer Options or `isFromMockProvider()` alone is insufficient and should not be relied upon as a primary detection mechanism.
