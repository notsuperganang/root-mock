package com.tiket.git;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.zza;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class Start extends Service {
    public static double Lat;
    public static double Lng;
    public static LocationManager m;
    public LocationClient mClient;

    public class Ran extends Thread {
        private int i = 1;
        private Start mStart;

        public Ran(Start start) {
            this.mStart = start;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (!base.get().getBoolean(base.opsi[20], true)) {
                try {
                    if (base.Ran() != null) {
                        String[] strArrSplit = base.Ran().getString(2).split(",");
                        Start.Lat = Double.parseDouble(strArrSplit[0]);
                        Start.Lng = Double.parseDouble(strArrSplit[1]);
                        if (base.get().getInt("random", 0) == 0) {
                            Thread.sleep(this.i * 30000);
                        } else {
                            Thread.sleep(base.get().getInt("random", 0) * 60000);
                        }
                    } else {
                        Start.Lat = Double.parseDouble(base.Latlng()[0]);
                        Start.Lng = Double.parseDouble(base.Latlng()[1]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Run extends Thread {
        private int i = 1;

        public Run() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (base.get().getBoolean("mock", true)) {
                try {
                    Random random = new Random();
                    random.setSeed(System.currentTimeMillis());
                    Iterator<String> it = Start.m.getAllProviders().iterator();
                    while (it.hasNext()) {
                        Start.this.run(it.next(), random.nextFloat() * 5.0f, 360.0f * random.nextFloat(), 5.0d * random.nextDouble(), random.nextFloat() * 5.0f);
                    }
                    Thread.sleep(this.i * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run(String str, float f, float f2, double d, float f3) {
        Location location = new Location(str);
        if (base.get().getBoolean("Start", true)) {
            location.setLatitude(Lat);
            location.setLongitude(Lng);
        } else {
            LatLng latLngRand = base.rand(Lng, Lat, base.get().getInt("start", 0));
            location.setLatitude(latLngRand.latitude);
            location.setLongitude(latLngRand.longitude);
        }
        location.setProvider(str);
        if (base.get().getBoolean("Accuracy", true)) {
            location.setAccuracy(f);
        } else {
            location.setAccuracy(base.get().getInt("accuracy", 0));
        }
        if (base.get().getBoolean("Bearing", true)) {
            location.setBearing(f2);
        } else {
            location.setBearing(base.get().getInt("bearing", 0));
        }
        if (base.get().getBoolean("Tinggi", true)) {
            location.setAltitude(d);
        } else {
            location.setAltitude(base.get().getInt("tinggi", 0));
        }
        if (base.get().getBoolean("Speed", true)) {
            location.setSpeed(f3);
        } else {
            location.setSpeed(base.get().getInt("speed", 0));
        }
        location.setTime(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 17) {
            location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
        }
        try {
            if (base.get().getBoolean("Mode", true)) {
                this.mClient.removeLocationUpdates();
                m.setTestProviderLocation(str, location);
            } else if (base.allow()) {
                this.mClient.setMockLocation(location);
                this.mClient.setMockMode(true);
            } else {
                this.mClient.removeLocationUpdates();
                m.setTestProviderLocation(str, location);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.mClient.removeLocationUpdates();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        zza.zzb(this);
        this.mClient.requestLocationUpdates();
        if (!base.get().getBoolean("Floating", true)) {
            stopService(new Intent(this, (Class<?>) Floating.class));
        }
        for (String str : m.getAllProviders()) {
            try {
                if (base.get().getBoolean("Mode", true)) {
                    m.setTestProviderEnabled(str, false);
                    m.removeTestProvider(str);
                } else if (base.allow()) {
                    this.mClient.setMockMode(false);
                } else {
                    m.setTestProviderEnabled(str, false);
                    m.removeTestProvider(str);
                    this.mClient.requestLocationUpdates();
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.mClient.requestLocationUpdates();
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.mClient == null) {
            this.mClient = new LocationClient(this);
        }
        if (base.get().getBoolean(base.opsi[20], true)) {
            Lat = Double.parseDouble(base.Latlng()[0]);
            Lng = Double.parseDouble(base.Latlng()[1]);
        } else {
            new Ran(this).start();
        }
        m = (LocationManager) getSystemService(FirebaseAnalytics.Param.LOCATION);
        for (String str : m.getAllProviders()) {
            try {
                LocationProvider provider = m.getProvider(str);
                m.addTestProvider(str, provider.requiresNetwork(), provider.requiresSatellite(), provider.requiresCell(), provider.hasMonetaryCost(), provider.supportsAltitude(), provider.supportsSpeed(), provider.supportsBearing(), provider.getPowerRequirement(), provider.getAccuracy());
                m.setTestProviderEnabled(str, true);
                m.setTestProviderStatus(str, 2, null, System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Notification notificationBuild;
        if (!base.get().getBoolean("Floating", true)) {
            startService(new Intent(this, (Class<?>) Floating.class));
        }
        if (this.mClient == null) {
            this.mClient = new LocationClient(this);
        }
        new Run().start();
        if (Build.VERSION.SDK_INT >= 26) {
            notificationBuild = new Notification.Builder(this, getPackageName()).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(getApplicationInfo().loadLabel(getPackageManager()).toString()).setContentText(base.Tikor()).setAutoCancel(false).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 0)).build();
        } else {
            notificationBuild = new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(getApplicationInfo().loadLabel(getPackageManager()).toString()).setContentText(base.Tikor()).setAutoCancel(false).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 0)).build();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel(getPackageName(), getApplicationInfo().loadLabel(getPackageManager()).toString(), 2));
        }
        startForeground(9999, notificationBuild);
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
