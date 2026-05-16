# Custom Fake GPS App - For Security Research

**⚠️ DISCLAIMER: For Educational & Security Research Only**

This application is developed for **security research purposes** to understand how fake GPS bypass works and to develop countermeasures (antidote/detection system). 

**DO NOT use this for actual GPS spoofing or fraud.**

---

## Purpose

Memahami perbedaan fundamental antara:
1. **App Play Store** (GPS JoyStick, Fake GPS GO, dll) - menggunakan official Mock Location API
2. **App Custom** (ini) - menggunakan root access untuk system-level injection

Tujuan: Develop detection system yang efektif untuk mencegah fake GPS abuse.

---

## Key Differences

### Play Store Apps
```
✗ Require Developer Options ON
✗ Require "Allow Mock Locations" enabled
✗ Use official Android Mock Location API
✗ TERDETEKSI oleh app yang cek developer settings
✗ Location.isFromMockProvider() returns TRUE
```

### This Custom App
```
✓ Developer Options bisa OFF
✓ Tidak perlu "Allow Mock Locations"
✓ Use ROOT command untuk inject GPS
✓ BYPASS detection yang cek developer settings
✓ Location.isFromMockProvider() returns FALSE (dengan LSPosed)
```

---

## Requirements

### Development Environment
- Android Studio Arctic Fox (2020.3.1) or newer
- Android SDK API 21-34
- JDK 8 or newer
- Gradle 7.0+

### Testing Device
**CRITICAL**: App ini HARUS ditest di HP yang sudah:
- ✅ **ROOTED** (Magisk v27.0+)
- ✅ **Bootloader UNLOCKED**
- ✅ **LSPosed Framework installed**
- ✅ **LSPosed Modules active:**
  - Mock Mock Locations
  - LocationReportEnabler

**Tanpa setup ini, app TIDAK AKAN BERFUNGSI!**

---

## Project Structure

```
FakeGPS_Custom/
├── app/
│   ├── src/main/
│   │   ├── java/com/research/fakegps/
│   │   │   ├── MainActivity.java          # UI & app logic
│   │   │   ├── GPSInjector.java          # CORE: GPS injection via root
│   │   │   └── RootChecker.java          # Verify root access
│   │   ├── res/
│   │   │   └── layout/
│   │   │       └── activity_main.xml     # UI layout
│   │   └── AndroidManifest.xml           # CRITICAL: No ACCESS_MOCK_LOCATION!
│   └── build.gradle                       # App dependencies
└── README.md                              # This file
```

---

## Build Instructions

### 1. Open Project
```bash
# Clone/download project
cd FakeGPS_Custom

# Open dengan Android Studio
# File → Open → Select FakeGPS_Custom folder
```

### 2. Sync Dependencies
```
Android Studio akan auto-sync Gradle
Wait sampai "Gradle sync finished"
```

### 3. Build APK
```
Build → Build Bundle(s) / APK(s) → Build APK(s)

Output:
app/build/outputs/apk/debug/app-debug.apk
```

---

## Installation

### Method 1: Via ADB (Recommended)
```bash
# Connect HP via USB (enable USB debugging)
adb devices

# Install APK
adb install app/build/outputs/apk/debug/app-debug.apk

# Launch app
adb shell am start -n com.research.fakegps/.MainActivity
```

### Method 2: Manual Install
```
1. Copy app-debug.apk ke HP
2. Buka file dengan File Manager
3. Install (perlu enable "Install from Unknown Sources")
4. Launch app
```

---

## Testing Guide

### Pre-Test Checklist
- [ ] HP sudah rooted (Magisk installed)
- [ ] LSPosed Framework installed
- [ ] LSPosed Modules active
- [ ] App custom installed

### Test Scenario 1: Basic Functionality
```
1. Open app
2. Check "Root Status" → Should show "✓ ROOTED (Ready)"
3. Enter coordinates (default: -6.2088, 106.8456)
4. Click "Set Fake Location"
5. Check status → Should show "✓ ACTIVE"
```

### Test Scenario 2: Verify Bypass
```
1. Set fake GPS via app
2. Check Settings → Developer Options
   Expected: Should be OFF atau tidak ada mock location enabled
3. Open Maps atau app lain yang pakai GPS
   Expected: Should show fake location
4. Open app absensi yang detect developer mode
   Expected: Should NOT detect (bypass successful!)
```

### Test Scenario 3: Compare with Play Store App
```
1. Install GPS JoyStick dari Play Store
2. Try set fake GPS
3. Observe: GPS JoyStick MINTA Developer Options ON
4. Open app custom
5. Set fake GPS
6. Observe: App custom TIDAK minta Developer Options ON
```

---

## How It Works (Technical)

### Play Store App Flow
```
User set coordinates
    ↓
App call: locationManager.setTestProviderLocation(...)
    ↓
Android require: Developer Options ON
    ↓
System set flag: DEVELOPMENT_SETTINGS_ENABLED = 1
    ↓
Location flag: isFromMockProvider = TRUE
    ↓
App absensi detect → BLOCKED!
```

### Custom App Flow (This App)
```
User set coordinates
    ↓
App call: Runtime.exec("su") → Root command
    ↓
Command: "am broadcast -a android.location.GPS_FIX_CHANGE ..."
    ↓
System inject GPS (bypass official API)
    ↓
LSPosed hook system calls:
    - DEVELOPMENT_SETTINGS_ENABLED → return 0 (bohong!)
    - isFromMockProvider() → return FALSE (bohong!)
    ↓
App absensi check → Looks normal → ACCEPTED! (bypass)
```

### Critical Files Analysis

**AndroidManifest.xml:**
```xml
<!-- APP PLAY STORE -->
<uses-permission android:name="android.permission.ACCESS_MOCK_LOCATION" />
<!-- Ini trigger requirement Developer Options ON -->

<!-- APP CUSTOM (This) -->
<!-- TIDAK ada ACCESS_MOCK_LOCATION permission! -->
<!-- Makanya tidak trigger requirement Developer Options -->
```

**GPSInjector.java:**
```java
// APP PLAY STORE
locationManager.setTestProviderLocation(...);
// → Official API, require Developer Options

// APP CUSTOM (This)
Process process = Runtime.getRuntime().exec("su");
DataOutputStream os = new DataOutputStream(process.getOutputStream());
os.writeBytes("am broadcast -a android.location.GPS_FIX_CHANGE ...\n");
// → Root command, BYPASS Developer Options requirement
```

---

## Troubleshooting

### Issue: "Root Status: NOT ROOTED"
**Solution:**
- Verify Magisk installed: Open Magisk Manager
- Check su binary: `adb shell su` (should not error)
- Reinstall Magisk if needed

### Issue: "Failed to set fake GPS"
**Possible causes:**
1. Root access denied
   - Check Magisk: Grant root permission to app
2. LSPosed not working
   - Verify LSPosed installed: Open LSPosed Manager
   - Check modules active
3. SELinux blocking
   - Check: `adb shell getenforce`
   - If "Enforcing" → might block some commands
   - Not recommended to set Permissive (security risk)

### Issue: "Fake GPS works but still detected"
**Diagnosis:**
- LSPosed modules not active
- Open LSPosed Manager → Modules
- Ensure "Mock Mock Locations" is ✅ checked
- Scope: Select "system_framework" and app absensi
- Reboot phone

---

## Development Notes

### For Further Development

If you want to extend this app:

**Add Map View:**
```gradle
// build.gradle
implementation 'com.google.android.gms:play-services-maps:18.1.0'

// MainActivity.java
GoogleMap googleMap;
googleMap.setOnMapClickListener(latLng -> {
    setFakeLocation(latLng.latitude, latLng.longitude);
});
```

**Add Favorites:**
```java
// SQLite database untuk save koordinat favorit
public class DatabaseHelper extends SQLiteOpenHelper {
    // Save favorite locations
    // Load favorites
}
```

**Add Joystick Control:**
```java
// Virtual joystick untuk control movement
// Gradual location change (simulate walking/driving)
```

---

## Security Implications

### This App Demonstrates:
✅ How sophisticated fake GPS bypass works
✅ Why simple detection (check Developer Options) fails
✅ Attack vector yang perlu di-mitigate

### For Defense (Antidote Development):
Based on understanding this app, detection methods:
1. **Knox Check (Samsung)**: Cannot be bypassed
2. **Bootloader Check**: Very hard to bypass
3. **GPS Pattern Analysis**: Behavioral detection
4. **Environmental Check**: WiFi/Cell tower verification
5. **Multi-factor**: Combine multiple methods

---

## Legal & Ethical Notice

⚠️ **THIS APP IS FOR SECURITY RESEARCH ONLY**

**Prohibited Uses:**
- ❌ Actual GPS spoofing untuk fraud
- ❌ Fake absensi di perusahaan
- ❌ Cheat di games (Pokemon Go, dll)
- ❌ Location spoofing untuk illegal purposes

**Allowed Uses:**
- ✅ Security research
- ✅ Understanding bypass mechanism
- ✅ Developing detection/antidote system
- ✅ Educational purposes (cybersecurity courses)
- ✅ Testing own security systems

**Consequences of Misuse:**
- Employment termination (jika untuk fake absensi)
- Legal action (fraud, breach of contract)
- Violation of service terms (games, apps)

**Use Responsibly!**

---

## Contributing

This is a research project. If you want to contribute:

### Areas for Contribution:
1. Improve GPS injection methods
2. Add more detection evasion techniques
3. Document new bypass patterns
4. Develop antidote/detection algorithms

### Contribution Guidelines:
- Document all changes
- Explain technical rationale
- Include test cases
- Update README

---

## License

**Educational Use Only - No Warranty**

This code is provided "as is" for educational and security research purposes.
The authors are not responsible for misuse or damages.

---

## References

### Technical Documentation:
- Android Location API: https://developer.android.com/reference/android/location/Location
- Magisk Documentation: https://topjohnwu.github.io/Magisk/
- LSPosed Framework: https://github.com/LSPosed/LSPosed

### Related Research:
- Mock Location Detection Techniques
- Root Detection & Bypass Methods
- GPS Spoofing Attack Vectors

---

## Contact

For questions regarding security research:
- Project Lead: [Your Name]
- Email: [Your Email]
- Purpose: Security Research & Antidote Development

---

**Remember: With great power comes great responsibility. Use this knowledge ethically.**

---

Last Updated: 2025
Version: 1.0-research
Status: For Internal Security Research Only
