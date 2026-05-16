# Architecture Overview

## Component Diagram

```
┌─────────────────────────────────────────────┐
│                MainActivity                  │
│                                             │
│  ┌──────────────┐    ┌───────────────────┐  │
│  │  OSMDroid    │    │  Coordinate Input  │  │
│  │  MapView     │───▶│  (Lat / Lon fields)│  │
│  │  (tap event) │    └────────┬──────────┘  │
│  └──────────────┘             │             │
│                               ▼             │
│                     ┌─────────────────┐     │
│                     │   GPSInjector   │     │
│                     └────────┬────────┘     │
│                              │              │
│  ┌───────────────┐           │              │
│  │  RootChecker  │           │              │
│  └───────┬───────┘           │              │
└──────────┼───────────────────┼──────────────┘
           │                   │
           ▼                   ▼
     Root Access          Root Shell (su)
     Detection            Command Execution
```

## Components

### `MainActivity`
The single Activity of the application. Responsibilities:
- Initialize and configure the OSMDroid `MapView`
- Handle tap events on the map and synchronize coordinates to input fields
- Gate the injection button based on root status at startup
- Delegate injection and cleanup to `GPSInjector`

### `GPSInjector`
Handles the core GPS spoofing logic. On `setFakeLocation()`, it attempts three injection methods sequentially, stopping at the first success. See [TECHNICAL_ANALYSIS.md](TECHNICAL_ANALYSIS.md) for method details.

### `RootChecker`
Detects root access using three independent checks: su binary presence, Magisk directory presence, and su command executability. The UI gates injection functionality on the result of `isDeviceRooted()`.

## Data Flow

```
User taps map
     │
     ▼
GeoPoint (lat, lon)
     │
     ├──▶ Update EditText fields
     └──▶ Move marker on MapView
                │
         User presses SET LOKASI
                │
                ▼
         GPSInjector.setFakeLocation(lat, lon)
                │
                ├──▶ Method 1: system broadcast  ──▶ success? return
                ├──▶ Method 2: file + broadcast  ──▶ success? return
                └──▶ Method 3: system property   ──▶ return result
                │
                ▼
         Root shell (su) executes command
                │
                ▼
         System location updated
```

## Dependencies

| Library | Version | Purpose |
|---------|---------|---------|
| `androidx.appcompat` | 1.6.1 | Base Activity support |
| `com.google.android.material` | 1.11.0 | UI components |
| `androidx.cardview` | 1.0.0 | Card layout containers |
| `org.osmdroid:osmdroid-android` | 6.1.18 | Offline-capable OpenStreetMap tiles |
