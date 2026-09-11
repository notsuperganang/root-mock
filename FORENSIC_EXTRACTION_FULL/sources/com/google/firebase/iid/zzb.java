package com.google.firebase.iid;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzb extends android.app.Service {
    private final Object lock;

    @VisibleForTesting
    final ExecutorService zzn;
    private Binder zzo;
    private int zzp;
    private int zzq;

    public zzb() {
        com.google.android.gms.internal.firebase_messaging.zza zzaVarZza = com.google.android.gms.internal.firebase_messaging.zzb.zza();
        String strValueOf = String.valueOf(getClass().getSimpleName());
        this.zzn = zzaVarZza.zza(new NamedThreadFactory(strValueOf.length() != 0 ? "Firebase-".concat(strValueOf) : new String("Firebase-")), com.google.android.gms.internal.firebase_messaging.zze.zzd);
        this.lock = new Object();
        this.zzq = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.lock) {
            this.zzq--;
            if (this.zzq == 0) {
                stopSelfResult(this.zzp);
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Binder binder;
        synchronized (this) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.zzo == null) {
                this.zzo = new zzf(this);
            }
            binder = this.zzo;
        }
        return binder;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.lock) {
            this.zzp = i2;
            this.zzq++;
        }
        Intent intentZzb = zzb(intent);
        if (intentZzb == null) {
            zza(intent);
            return 2;
        }
        if (zzc(intentZzb)) {
            zza(intent);
            return 2;
        }
        this.zzn.execute(new zzc(this, intentZzb, intent));
        return 3;
    }

    protected Intent zzb(Intent intent) {
        return intent;
    }

    public boolean zzc(Intent intent) {
        return false;
    }

    public abstract void zzd(Intent intent);
}
