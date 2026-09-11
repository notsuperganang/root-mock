package com.google.android.gms.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class LocationClient extends LocationCallback implements android.location.LocationListener, OnSuccessListener<Location> {
    private LocationListeners Listener;
    private FusedLocationProviderClient mClient;
    private LocationManager mManager;
    private String mProvider;

    public interface LocationListeners {
        void onLocationChanged(Location location);
    }

    public LocationClient(Context context) {
        this.mClient = LocationServices.getFusedLocationProviderClient(context);
        this.mManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        Iterator<String> it = this.mManager.getAllProviders().iterator();
        while (it.hasNext()) {
            this.mProvider = it.next();
        }
    }

    public LocationClient(Context context, LocationListeners locationListeners) {
        this.mClient = LocationServices.getFusedLocationProviderClient(context);
        if (this.mClient.getLastLocation() != null) {
            this.mClient.getLastLocation().addOnSuccessListener(this);
        }
        this.mManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        Iterator<String> it = this.mManager.getAllProviders().iterator();
        while (it.hasNext()) {
            this.mProvider = it.next();
        }
        this.Listener = locationListeners;
    }

    public void removeLocationUpdates() {
        if (this.mClient != null) {
            this.mClient.removeLocationUpdates(this);
        } else if (this.mManager != null) {
            this.mManager.removeUpdates(this);
        }
    }

    public void requestLocationUpdates() {
        if (this.mClient != null) {
            this.mClient.requestLocationUpdates(request(), this, Looper.getMainLooper());
        } else if (this.mManager != null) {
            this.mManager.requestLocationUpdates(this.mProvider, 0L, 0.0f, this);
        }
    }

    public void setMockLocation(Location location) {
        if (this.mClient != null && location != null) {
            this.mClient.setMockLocation(location);
        }
    }

    public void setMockMode(boolean z) {
        if (this.mClient != null) {
            this.mClient.setMockMode(z);
        }
    }

    public LocationRequest request() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10L);
        locationRequest.setFastestInterval(10L);
        locationRequest.setPriority(100);
        return locationRequest;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location == null) {
            requestLocationUpdates();
        } else if (location != null && this.Listener != null) {
            this.Listener.onLocationChanged(location);
        }
        removeLocationUpdates();
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Location location) {
        if (location == null) {
            requestLocationUpdates();
        } else if (location != null && this.Listener != null) {
            this.Listener.onLocationChanged(location);
        }
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationResult(LocationResult locationResult) {
        if (locationResult != null) {
            for (Location location : locationResult.getLocations()) {
                if (location == null) {
                    requestLocationUpdates();
                } else if (location != null && this.Listener != null) {
                    this.Listener.onLocationChanged(location);
                }
            }
        }
        removeLocationUpdates();
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }
}
