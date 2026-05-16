# Custom Fake GPS — Forensic Research Tool

**For authorized security research and forensic demonstration only.**

This application was developed as part of a forensic audit to demonstrate that custom GPS spoofing tools can be built independently, without subscribing to third-party spoofing services. It is intended for use in legal proceedings and stakeholder briefings by authorized IT audit teams.

---

## Purpose

To demonstrate to stakeholders that:

1. GPS spoofing applications targeting attendance systems can be self-built with minimal resources.
2. Root-based injection bypasses standard detection methods that rely on Android's Mock Location API.
3. Effective countermeasures must operate at a deeper system level than checking Developer Options.

See [docs/TECHNICAL_ANALYSIS.md](docs/TECHNICAL_ANALYSIS.md) for the full technical breakdown.

---

## Requirements

### Development

| Tool | Version |
|------|---------|
| Android Studio | Arctic Fox (2020.3.1) or newer |
| Android SDK | API 21–36 |
| JDK | 8 or newer |
| Gradle | 8.6+ |

### Test Device

The GPS injection feature requires a device with:

- Root access via **Magisk v27.0+**
- **LSPosed Framework** installed
- LSPosed modules active: *Mock Mock Locations*, *LocationReportEnabler*

The app will install and run on any device. On non-rooted devices, the injection button is disabled and the map remains fully functional for demonstration purposes.

---

## Project Structure

```
app/src/main/
├── java/com/research/fakegps/
│   ├── MainActivity.java       # UI controller, map interaction, lifecycle
│   ├── GPSInjector.java        # Root-based GPS injection (3 methods)
│   └── RootChecker.java        # Root access detection
└── res/
    └── layout/
        └── activity_main.xml   # UI layout with OSMDroid MapView
docs/
├── TECHNICAL_ANALYSIS.md       # Injection methods, bypass mechanisms
└── ARCHITECTURE.md             # Component overview and data flow
```

---

## Build & Install

```bash
# Build debug APK
export ANDROID_HOME=$HOME/Android/Sdk
echo "sdk.dir=$HOME/Android/Sdk" > local.properties
./gradlew assembleDebug

# Install to connected device or emulator
adb install app/build/outputs/apk/debug/app-debug.apk
```

Output APK: `app/build/outputs/apk/debug/app-debug.apk`

---

## Usage

1. Open the app — the map centers on a default coordinate.
2. Tap anywhere on the map to place a marker and populate the coordinate fields.
3. Alternatively, type coordinates manually in the Latitude / Longitude fields.
4. Press **SET LOKASI** to activate GPS injection (requires root).
5. Press **STOP** to restore real GPS.

---

## Offline Map Support

The map uses OpenStreetMap tiles via [OSMDroid](https://github.com/osmdroid/osmdroid). Tiles are cached automatically on first use. Once cached, the map works without an internet connection — suitable for demonstration in areas with limited connectivity (3T regions).

For pre-downloaded offline tile packs, place a `.zip` archive in `/sdcard/osmdroid/` on the device.

---

## Legal Notice

This tool is provided strictly for:
- Forensic audit and legal proceedings
- Authorized security research
- Internal IT training and awareness

Any use for actual attendance fraud, game cheating, or unauthorized location spoofing is prohibited and may constitute a criminal offense.
