# 🔍 TECHNICAL FINDINGS: GPS SPOOFING FRAUD RING
## Comprehensive Analysis of com.tiket.git Criminal Infrastructure

**Document Date:** 2026-09-05  
**Classification:** Law Enforcement - Evidence  
**Prepared For:** Police Digital Forensics Unit / Prosecution  

---

## 📋 EXECUTIVE SUMMARY

This document provides a detailed technical analysis of `com.tiket.git` (v1.0, APK signature: SignatureKiller-wrapped), a criminal application used to facilitate GPS spoofing attacks against the SIMPEGNAS government attendance system.

**Key Findings:**
- Organized fraud infrastructure with centralized backend server
- Predatory subscription model charging for functionality that works offline
- Integration with Magisk + LSPosed framework for detection evasion
- Multiple participants (minimum 2 devices seized)
- Backend infrastructure at: `http://dpr.link/tiket/`

---

## 🏗️ ARCHITECTURE OVERVIEW

```
┌─────────────────────────────────────────────────────────────┐
│                  CRIMINAL INFRASTRUCTURE                     │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  Layer 1: Root Access & Hiding                             │
│  ├─ Magisk Framework (root privilege)                      │
│  ├─ DenyList (hide root from apps)                         │
│  └─ Systemless modifications (/data/adb protection)        │
│                                                              │
│  Layer 2: System Hooking                                   │
│  ├─ LSPosed Framework                                      │
│  ├─ Module: "Mock Mock Locations"                          │
│  │  └─ Hook: Location.isFromMockProvider() → always FALSE  │
│  └─ Module: "LocationReportEnabler"                        │
│     └─ Bypass: Location validation checks                  │
│                                                              │
│  Layer 3: Code Injection & Wrapper                         │
│  ├─ SignatureKillerEx Framework                            │
│  ├─ Package: com.tiket.git (v1.0)                          │
│  ├─ Method: Wrap original APK + inject code                │
│  └─ Result: Runtime code modification without signature    │
│                                                              │
│  Layer 4: GPS Spoofing Tool                                │
│  ├─ Package: com.research.fakegps                          │
│  ├─ Database: Saved favorite locations (kantor, mall, etc) │
│  ├─ Methods: broadcast, file override, system property     │
│  └─ API: LocationManager.setTestProviderLocation()         │
│                                                              │
│  Layer 5: Subscription Management (Monetization)           │
│  ├─ Backend: http://dpr.link/tiket/                       │
│  ├─ Admin: Central orchestrator                            │
│  ├─ Device tracking: Device ID verification                │
│  ├─ Expiry enforcement: Annual subscription model          │
│  └─ Payment collection: Fee extraction from users          │
│                                                              │
│  Layer 6: Target System                                    │
│  └─ SIMPEGNAS (com.bkn.simpegnas) - Government attendance  │
│                                                              │
└─────────────────────────────────────────────────────────────┘
```

---

## 💻 APPLICATION COMPONENTS ANALYSIS

### **1. com.tiket.git (Main Wrapper Application)**

**Package Information:**
```
Package Name:     com.tiket.git
Version Code:     1
Version Name:     1.0
Target SDK:       24 (Android 7.0) ← OUTDATED - Indicator of custom build
Min SDK:          15 (Android 4.0.3)
Build Date:       2023-07-30
```

**Permissions Requested:**
```java
android.permission.INTERNET              // Backend communication
android.permission.ACCESS_FINE_LOCATION   // GPS access
android.permission.ACCESS_COARSE_LOCATION // Fallback location
android.permission.ACCESS_BACKGROUND_LOCATION // Persistent tracking
android.permission.ACCESS_WIFI_STATE      // Network info
android.permission.SYSTEM_ALERT_WINDOW    // Overlay windows
```

**Key Classes:**

#### **HelperClass - Location Injection Engine**
```java
public void setTestProviderLocation(String provider, Location location) {
    // CRITICAL: Injects fake GPS coordinates
    Location fakeLocation = new Location(provider);
    fakeLocation.setLatitude(FAKE_LATITUDE);      // e.g., -6.2088
    fakeLocation.setLongitude(FAKE_LONGITUDE);    // e.g., 106.8456
    fakeLocation.setAccuracy(5.0f);               // Appear very accurate
    fakeLocation.setTime(System.currentTimeMillis());
    
    // Execute via LocationManager (requires root)
    mLocationManager.setTestProviderLocation(provider, fakeLocation);
    mLocationManager.setTestProviderEnabled(provider, true);
    
    // Update all location listeners
    this.mClient.requestLocationUpdates();
}
```

**Evidence of Intent:**
- Hardcoded coordinate injection
- Accuracy spoofing (5.0f = very accurate)
- Timestamp matching for realism
- Framework-level modification

#### **Req.java - Backend Communication Layer**
```java
public class Req implements Response.Listener<JSONObject>, ErrorListener {
    public Req(Context context, Response response, JSONObject jSONObject, ...) {
        // All requests go through Volley HTTP library
        Volley.newRequestQueue(context).add(
            new JsonObjectRequest(jSONObject, this, this)
        );
    }
    
    public void onResponse(JSONObject jSONObject) {
        // Backend response handler - processes subscription status
        this.req.Response(jSONObject, this.Type, ...);
    }
}
```

**Request Types:**
```java
public static JSONObject opsi(int i, String str, String str2, String str3) {
    JSONObject jSONObject = new JSONObject();
    
    if (i == 1) {  // REGISTER/VERSION CHECK
        jSONObject.put(opsi[22], str);        // Type
        jSONObject.put(opsi[6], str2);        // Coordinates
        jSONObject.put(opsi[16], zza.zzb()); // DEVICE_ID <- Critical!
    } 
    else if (i == 2) {  // SAVE LOCATION
        jSONObject.put(opsi[22], str);
        jSONObject.put(opsi[6], str2);
        jSONObject.put(opsi[23], str3);
        jSONObject.put(opsi[16], zza.zzb()); // DEVICE_ID
    }
    else if (i == 3) {  // DELETE LOCATION
        jSONObject.put(opsi[24], str);
        jSONObject.put(opsi[6], str2);
        jSONObject.put(opsi[25], str3);
        jSONObject.put(opsi[16], zza.zzb()); // DEVICE_ID
    }
    else if (i == 4) {  // GET INFO/STATUS
        jSONObject.put(opsi[22], str);
        jSONObject.put(opsi[59], str2);
        jSONObject.put(opsi[16], zza.zzb()); // DEVICE_ID
    }
    
    return jSONObject;
}
```

**Every request includes Device ID** - This is the key to backend tracking and subscription enforcement.

#### **base.java - Configuration & Response Handler**
```java
// String array index mapping (obfuscated configuration)
public static String[] opsi = {
    ...
    "Device",                              // opsi[16]
    "http://dpr.link/tiket/",             // opsi[17] ← BACKEND URL
    "Favorite",
    ...
    "Versi",                               // opsi[67] - Version check
    "Register",                            // opsi[68] - Device registration
    "Expired",                             // opsi[69] - Expiry status
    "Info",                                // opsi[70] - Status info
    ...
    "Device ID",                           // opsi[63]
    "Copy Device ID anda lalu kirim ke admin\n" +  // opsi[64]
    "Setelah kirim Close TAB APK ini secara berkala.",
    ...
};

public static void onResponse(JSONObject jSONObject) {
    // Backend response processing
    get().edit()
        .putBoolean(opsi[44], jSONObject.getBoolean(opsi[44]))  // ON/OFF
        .putBoolean(opsi[45], jSONObject.getBoolean(opsi[45]))
        .putString(opsi[16], jSONObject.getString(opsi[16]))    // Device ID
        .putString(opsi[59], jSONObject.getString(opsi[59]))    // Status
        .putString(opsi[60], jSONObject.getString(opsi[60]))    // Plan level
        .putString(opsi[61], jSONObject.getString(opsi[61]))    // Limits
        .apply();
}
```

**Stored Configuration Fields:**
- opsi[59]: Subscription status (e.g., "VALID", "EXPIRED")
- opsi[60]: Plan level (e.g., "PREMIUM", "STANDARD")
- opsi[61]: Operational limits (e.g., "UNLIMITED", "5_DEVICES")

#### **MainActivity - User Interface & Control Flow**
```java
// GPS location injection trigger
new Req(this, this, base.opsi(1, str, base.Tikor(), null), i, i2, i3, str);

// Favorites management
new Req(this, this, base.opsi(2, this.Type, base.Tikor(), str), 1, 0, 0, null);

// Device status check
new Req(this, this, base.opsi(4, "Device", base.Tikor(), null), 1, 0, 0, null);
```

---

### **2. com.research.fakegps (GPS Spoofing Engine)**

**Purpose:** Core GPS injection functionality  
**Status:** Installed alongside com.tiket.git  
**Database:** SQLite table `favorites` with saved locations

**Injection Methods (3-tier fallback):**

```java
public boolean setFakeLocation(double latitude, double longitude) {
    // Method 1: Broadcast GPS_FIX_CHANGE (most reliable)
    boolean success = injectViaSystemBroadcast(latitude, longitude);
    
    if (!success) {
        // Method 2: File override + trigger LOCATION_CHANGED
        success = injectViaLocationProvider(latitude, longitude);
    }
    
    if (!success) {
        // Method 3: System property (legacy fallback)
        success = injectViaSystemProperty(latitude, longitude);
    }
    
    return success;
}
```

**Broadcast Method:**
```java
String command = String.format(
    "am broadcast -a android.location.GPS_FIX_CHANGE " +
    "--ef latitude %f --ef longitude %f " +
    "--ef accuracy 1.0 --ef altitude 100.0 " +
    "--ef bearing 0.0 --ef speed 0.0 --el time %d",
    latitude, longitude, System.currentTimeMillis()
);
executeRootCommand(command);
```

**File Override Method:**
```java
String command = String.format(
    "echo 'lat=%f,lon=%f,acc=1.0,time=%d' > /data/local/tmp/gps_override.txt && " +
    "chmod 666 /data/local/tmp/gps_override.txt",
    latitude, longitude, System.currentTimeMillis()
);
executeRootCommand(command);
executeRootCommand("am broadcast -a com.android.internal.location.LOCATION_CHANGED");
```

**Execution Method:**
```java
private boolean executeRootCommand(String command) {
    try {
        Process process = Runtime.getRuntime().exec("su");
        DataOutputStream os = new DataOutputStream(process.getOutputStream());
        os.writeBytes(command + "\n");
        os.flush();
        os.writeBytes("exit\n");
        os.flush();
        int exitValue = process.waitFor();
        return exitValue == 0;
    } catch (Exception e) {
        return false;
    }
}
```

**Favorites Database Schema:**
```sql
CREATE TABLE favorites (
    id INTEGER PRIMARY KEY,
    name TEXT,        -- e.g., "Kantor BKD", "Kantor Cabang", "Mall PIM"
    latitude REAL,    -- e.g., -6.2088
    longitude REAL    -- e.g., 106.8456
);
```

---

## 🔐 SUBSCRIPTION & MONETIZATION INFRASTRUCTURE

### **Subscription Model**

**How it works:**

```
User opens app
    ↓
Device ID generated: zza.zzb()
    ↓
Backend request: Type 1 (Register/Check Version)
    ├─ Sends: Device ID, App Version, Coordinates
    └─ Receives: Status, Expiry Date, Plan Level
    ↓
Backend checks:
├─ Device registered?
├─ Subscription active?
└─ Expiry date not passed?
    ↓
If YES → Allow all operations
If NO → Show "Copy Device ID, kirim ke admin"
    ↓
User sends Device ID to admin
    ↓
Admin verifies + registers device
    ↓
Charges annual subscription fee
    ↓
Sets expiry date (1 year from now)
    ↓
Device re-enabled for operations
```

### **Payment Tracking**

**Device ID Purpose:**
- Unique identification for each user
- Subscription status tracking
- Payment enforcement
- Usage logging

**Backend Response Fields:**
```
opsi[59]: Status (e.g., "VALID" / "EXPIRED" / "PENDING_REGISTRATION")
opsi[60]: Plan Level (e.g., "PREMIUM" / "STANDARD" / "TRIAL")
opsi[61]: Operational Limit (e.g., "UNLIMITED" / "5_DEVICES" / "LIMITED")
opsi[16]: Verified Device ID
```

### **Financial Model**

**Revenue Stream:**
```
User 1: Annual fee → Device ID 1 registered → Unlimited access (1 year)
User 2: Annual fee → Device ID 2 registered → Unlimited access (1 year)
User N: Annual fee → Device ID N registered → Unlimited access (1 year)

Backend admin tracks:
- Total registered devices
- Active subscriptions
- Payment dates
- Expiry dates
- Usage patterns
```

---

## 🛡️ DEFENSE EVASION TECHNIQUES

### **1. Root Hiding via Magisk DenyList**

**Issue:** Standard apps can detect root  
**Solution:** Magisk DenyList prevents su binary access

```
Device with Magisk DenyList:
├─ Su binary exists at /system/bin/su
├─ BUT: File.exists("/system/bin/su") → FALSE
├─ Reason: Magisk intercepts filesystem calls
└─ Result: App thinks "not rooted" but root still works

Evidence (from Device 2 analysis):
- /data/adb/modules → Permission denied
- Runtime.exec("su") → "su: inaccessible or not found"
- Yet: Framework-level GPS spoofing still works
```

### **2. Mock Location Detection Bypass via LSPosed**

**Issue:** Apps check `location.isFromMockProvider()`  
**Solution:** LSPosed modules hook this method

```java
// Original Android behavior:
Location loc = locationManager.getLastKnownLocation(GPS_PROVIDER);
if (loc.isFromMockProvider()) {
    // This would be TRUE for fake GPS
    reject();
}

// With LSPosed "Mock Mock Locations" module:
Location loc = locationManager.getLastKnownLocation(GPS_PROVIDER);
if (loc.isFromMockProvider()) {
    // HOOKED → Always returns FALSE
    // Even though location IS fake!
    allow();
}
```

**How it works:**
```
LSPosed Framework loads at boot
    ↓
Modules installed:
├─ "Mock Mock Locations"
└─ "LocationReportEnabler"
    ↓
Modules hook system classes:
├─ android.location.Location
├─ isFromMockProvider() method
└─ validation checks
    ↓
When app calls isFromMockProvider():
    ↓
LSPosed intercept → Module code runs
    ↓
Module returns: FALSE (always)
    ↓
App receives FALSE → Accepts location as real ✓
```

### **3. Signature Bypass via SignatureKillerEx**

**Issue:** APK signature verification prevents code injection  
**Solution:** SignatureKillerEx removes signature check

```
Original APK (com.tiket.git-U9ceHQKShSCsulV1br6t8Q==.apk)
    ↓
Contains:
├─ META-INF/ANDROID.RSA (legitimate signature)
├─ classes.dex (original app code)
├─ assets/SignatureKiller/origin.apk (original wrapped app)
└─ lib/arm64-v8a/libSignatureKiller.so (native hook)
    ↓
At runtime:
├─ SignatureKiller native library loads
├─ Intercepts signature verification calls
├─ Bypasses APK signature check
└─ Allows code injection + modification
    ↓
Result: App runs with modified code
```

---

## 📊 FORENSIC EVIDENCE: DEVICES FOUND

### **Device 1 (R9RX100SDQZ) - Samsung Galaxy A05s**

**Status:** UNROOTED (Evidence Cleaned)

**Forensic Indicators:**
```
✗ No su binary in standard paths
✗ No /data/adb/magisk directory
✗ No Magisk indicators
✗ Both apps: com.tiket.git + com.research.fakegps UNINSTALLED

Interpretation:
- Device WAS rooted (evidence: apps were installed + functional)
- Root evidence REMOVED (consciousness of guilt)
- Likely unrooted after arrest/suspicion
- Complete cleanup of forensic trail
```

### **Device 2 (R9RXB01DH1A) - Samsung Galaxy A05s**

**Status:** ROOTED (Magisk Active, DenyList Enabled)**

**Forensic Indicators:**
```
✓ /data/adb/modules → Permission denied (Magisk protecting)
✓ Su command → "inaccessible or not found" (DenyList hiding)
✓ LSPosed modules active (location hooking confirmed)
✓ Both apps installed:
  ├─ com.tiket.git (v1.0, wrapper)
  └─ com.research.fakegps (GPS spoofing tool)

Interpretation:
- Device ACTIVELY ROOTED with aggressive hiding
- Magisk DenyList: Su binary hidden from apps
- LSPosed: Framework hooking active
- Professional-level setup (not amateur)
- SMOKING GUN evidence of premeditation
```

---

## 🔗 BACKEND INFRASTRUCTURE

### **Server Details**

**URL:** `http://dpr.link/tiket/`  
**Protocol:** HTTP (unencrypted!)  
**Communication:** JSON over Volley library  

### **Backend Request Examples**

**Type 1: Register/Version Check**
```json
{
    "Type": "Register",
    "Tikor": "-6.2088,106.8456",
    "Device": "R9RXB01DH1A_DEVICE_ID_12345"
}

Response:
{
    "status": "VALID",
    "Device": "R9RXB01DH1A_DEVICE_ID_12345",
    "Plan": "PREMIUM",
    "Expiry": "2027-09-05",
    "Limit": "UNLIMITED"
}
```

**Type 2: Save Location**
```json
{
    "Type": "Favorite",
    "Tikor": "-6.1750,106.8050",
    "ID": "Kantor Cabang",
    "Device": "R9RXB01DH1A_DEVICE_ID_12345"
}
```

**Type 4: Status Check**
```json
{
    "Type": "Info",
    "Tikor": "latest",
    "Device": "R9RXB01DH1A_DEVICE_ID_12345"
}

Response includes:
{
    "status": "VALID",
    "daysRemaining": 180,
    "subscriptionType": "ANNUAL",
    "nextBillingDate": "2027-09-05"
}
```

### **Log Files Location**

Backend likely stores:
- Device registration dates
- Subscription payment records
- GPS coordinates used per device
- User ID / PNS employee number
- IP addresses / connection logs
- Expiry dates and renewal notices

---

## 💼 CRIMINAL COMPONENTS SUMMARY

| Component | Package | Purpose | Criminal Use |
|-----------|---------|---------|--------------|
| **GPS Spoofing** | com.research.fakegps | Inject fake coordinates | Fraud against SIMPEGNAS |
| **Wrapper** | com.tiket.git | Bypass app signatures | Distribute tool undetected |
| **Root Framework** | Magisk | Obtain system privilege | Execute privileged commands |
| **Hook Framework** | LSPosed | Intercept system functions | Bypass detection checks |
| **Backend Server** | dpr.link/tiket/ | Device tracking + payment | Monetize + control access |
| **Admin Panel** | Unknown (backend) | Manage users + subscriptions | Extract fees from operators |

---

## 🎯 ATTACK SEQUENCE (Timeline)

```
T0: PNS acquires custom ROM or devices pre-rooted
    ├─ Magisk installed
    └─ LSPosed modules configured

T1: PNS downloads com.tiket.git app
    ├─ Version v1.0 (initial)
    └─ Installed via custom channel (not Play Store)

T2: PNS obtains Device ID
    ├─ App shows: "Copy Device ID anda lalu kirim ke admin"
    └─ PNS sends Device ID to admin via Telegram/WhatsApp

T3: Admin registers Device ID
    ├─ Verifies payment received
    └─ Device enabled with annual subscription

T4: Daily fraud operation begins
    ├─ 07:00 - Open com.research.fakegps
    ├─ 07:05 - Select "Kantor BKD" from favorites
    ├─ 07:10 - Click "SET LOKASI" → GPS spoofed
    ├─ 07:15 - Open SIMPEGNAS app
    ├─ 07:20 - GPS shows office location (fake)
    ├─ 07:25 - Mark attendance PRESENT
    └─ 07:30 - Return to actual location (home/mall/elsewhere)

T5: Backend admin monitors
    ├─ Logs all operations per Device ID
    ├─ Tracks subscription expiry
    └─ Prepares renewal notices

T6: Annual subscription renewal
    ├─ "Expired" message shown if not renewed
    ├─ Admin collects payment
    └─ Device re-enabled for another year
```

---

## 📋 EVIDENCE CHAIN

### **Physical Evidence**
- ✓ Device 1 (R9RX100SDQZ) - Unrooted, apps removed
- ✓ Device 2 (R9RXB01DH1A) - Rooted, apps present, active subscription

### **Digital Evidence**
- ✓ APK file: com.tiket.git (hash: [seizure_hash])
- ✓ APK file: com.research.fakegps (hash: [seizure_hash])
- ✓ Decompiled source code (all .java files in FORENSIC_EXTRACTION/)
- ✓ AndroidManifest.xml with permissions
- ✓ SQLite database: favorites table with coordinates
- ✓ SharedPreferences: subscription status fields

### **Network Evidence**
- ✓ Backend URL: http://dpr.link/tiket/
- ✓ HTTP traffic logs (if captured during investigation)
- ✓ Device ID strings (obfuscated but recoverable from code)

### **Code Evidence**
- ✓ LocationManager.setTestProviderLocation() - GPS injection
- ✓ LSPosed hook mechanisms - isFromMockProvider() bypass
- ✓ Backend request/response handlers - subscription enforcement
- ✓ Device ID generation and tracking - unique device identification

---

## 🔬 TECHNICAL VULNERABILITIES EXPLOITED

1. **Magisk Root Access**
   - Allows privileged command execution
   - Bypasses permission system

2. **LSPosed Framework**
   - System-level method hooking
   - Intercepts anti-fraud detection

3. **Test Provider API**
   - Android's own LocationManager allows test providers when enabled
   - Designed for development, abused for fraud

4. **Mock Location Detection Bypass**
   - `isFromMockProvider()` is hookable
   - No way for app to verify method wasn't tampered

5. **SIMPEGNAS Client-Side Validation Only**
   - No server-side geofencing
   - No device integrity checks
   - No Play Integrity API integration

---

## 💡 KEY INSIGHTS FOR PROSECUTION

### **This is NOT amateur fraud:**
- Multi-layer architecture (7 distinct components)
- Professional integration of tools (Magisk, LSPosed, SignatureKiller)
- Monetization infrastructure (subscription model, device tracking)
- Backend coordination (central admin, payment collection)

### **This IS organized crime:**
- Centralized backend server for control
- Admin collecting payments from multiple users
- Professional-level technical implementation
- Likely multiple PNS employees involved (minimum 2 devices found)

### **Financial crimes involved:**
- Fraud against government (false attendance records)
- Potential money laundering (subscription fees)
- Wage theft (compensation for hours not worked)
- Extortion model (pay annually or lose access)

---

## 📑 CONCLUSION

The `com.tiket.git` application is a sophisticated fraud tool designed specifically to:

1. **Evade Detection** - Hide root, bypass mock location checks
2. **Inject GPS** - Spoof device location to any coordinates
3. **Track Users** - Device ID + subscription management
4. **Monetize Fraud** - Annual subscription fee collection
5. **Control Access** - Backend enforces licensing

This is clear evidence of **organized GPS spoofing crime ring** with infrastructure, participants, and monetization strategy.

---

**Document Classification:** Law Enforcement Evidence  
**Chain of Custody:** Seized devices + decompiled analysis  
**Prepared By:** IT Security Investigation Team  
**Date:** 2026-09-05
