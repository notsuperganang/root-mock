package com.research.fakegps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

/**
 * CUSTOM FAKE GPS APP - FOR SECURITY RESEARCH ONLY
 * 
 * PERBEDAAN UTAMA DENGAN APP PLAY STORE:
 * 1. TIDAK pakai Mock Location API (official Android API)
 * 2. PAKAI Root Access untuk inject GPS langsung ke system
 * 3. TIDAK require Developer Options ON
 * 4. BYPASS detection dari app yang cek developer mode
 * 
 * APP PLAY STORE:
 * - Pakai setTestProviderLocation() → Official API
 * - Require Developer Options ON + "Allow Mock Locations"
 * - TERDETEKSI oleh app yang cek developer settings
 * 
 * APP CUSTOM INI:
 * - Pakai root command untuk inject GPS
 * - TIDAK require Developer Options
 * - BYPASS detection (dengan bantuan Magisk + LSPosed)
 */
public class MainActivity extends AppCompatActivity {

    private EditText editLatitude;
    private EditText editLongitude;
    private Button btnSetLocation;
    private Button btnStopFake;
    private TextView tvStatus;
    private TextView tvRootStatus;
    
    private GPSInjector gpsInjector;
    private RootChecker rootChecker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
        initManagers();
        checkPermissions();
        checkRootStatus();
        setupListeners();
    }
    
    private void initViews() {
        editLatitude = findViewById(R.id.edit_latitude);
        editLongitude = findViewById(R.id.edit_longitude);
        btnSetLocation = findViewById(R.id.btn_set_location);
        btnStopFake = findViewById(R.id.btn_stop_fake);
        tvStatus = findViewById(R.id.tv_status);
        tvRootStatus = findViewById(R.id.tv_root_status);
        
        // Set default koordinat (kantor example)
        editLatitude.setText("-6.2088");
        editLongitude.setText("106.8456");
    }
    
    private void initManagers() {
        gpsInjector = new GPSInjector(this);
        rootChecker = new RootChecker();
    }
    
    private void checkRootStatus() {
        boolean isRooted = rootChecker.isDeviceRooted();
        
        if (isRooted) {
            tvRootStatus.setText("Root Status: ✓ ROOTED (Ready)");
            tvRootStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            btnSetLocation.setEnabled(true);
        } else {
            tvRootStatus.setText("Root Status: ✗ NOT ROOTED (App won't work!)");
            tvRootStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            btnSetLocation.setEnabled(false);
            
            Toast.makeText(this, 
                "ROOT REQUIRED! This app needs root access to work.", 
                Toast.LENGTH_LONG).show();
        }
    }
    
    private void checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, 
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }
    
    private void setupListeners() {
        btnSetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFakeLocation();
            }
        });
        
        btnStopFake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopFakeLocation();
            }
        });
    }
    
    private void setFakeLocation() {
        String latStr = editLatitude.getText().toString();
        String lonStr = editLongitude.getText().toString();
        
        if (latStr.isEmpty() || lonStr.isEmpty()) {
            Toast.makeText(this, "Please enter coordinates!", Toast.LENGTH_SHORT).show();
            return;
        }
        
        try {
            double latitude = Double.parseDouble(latStr);
            double longitude = Double.parseDouble(lonStr);
            
            // CRITICAL: Validate coordinates
            if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
                Toast.makeText(this, "Invalid coordinates range!", Toast.LENGTH_SHORT).show();
                return;
            }
            
            // Inject via ROOT (bukan Mock Location API!)
            boolean success = gpsInjector.setFakeLocation(latitude, longitude);
            
            if (success) {
                tvStatus.setText("Status: ✓ ACTIVE - Fake GPS Running");
                tvStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                
                Toast.makeText(this, 
                    String.format("Fake GPS set to:\nLat: %.6f\nLon: %.6f", latitude, longitude),
                    Toast.LENGTH_LONG).show();
                    
                btnStopFake.setEnabled(true);
            } else {
                tvStatus.setText("Status: ✗ FAILED - Check root access");
                tvStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                
                Toast.makeText(this, "Failed! Check root access.", Toast.LENGTH_SHORT).show();
            }
            
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format!", Toast.LENGTH_SHORT).show();
        }
    }
    
    private void stopFakeLocation() {
        boolean success = gpsInjector.stopFakeLocation();
        
        if (success) {
            tvStatus.setText("Status: ○ STOPPED - Using real GPS");
            tvStatus.setTextColor(getResources().getColor(android.R.color.darker_gray));
            
            Toast.makeText(this, "Fake GPS stopped. Using real location.", Toast.LENGTH_SHORT).show();
            btnStopFake.setEnabled(false);
        } else {
            Toast.makeText(this, "Failed to stop fake GPS!", Toast.LENGTH_SHORT).show();
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clean up
        gpsInjector.cleanup();
    }
}
