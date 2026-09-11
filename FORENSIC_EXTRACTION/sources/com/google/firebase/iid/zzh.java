package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.GuardedBy;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements ServiceConnection {
    private final Context zzac;
    private final Intent zzad;
    private final ScheduledExecutorService zzae;
    private final Queue<zzd> zzaf;
    private zzf zzag;

    @GuardedBy("this")
    private boolean zzah;

    public zzh(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    @VisibleForTesting
    private zzh(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zzaf = new ArrayDeque();
        this.zzah = false;
        this.zzac = context.getApplicationContext();
        this.zzad = new Intent(str).setPackage(this.zzac.getPackageName());
        this.zzae = scheduledExecutorService;
    }

    private final void zzd() {
        synchronized (this) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "flush queue called");
            }
            while (!this.zzaf.isEmpty()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "found intent to be delivered");
                }
                if (this.zzag == null || !this.zzag.isBinderAlive()) {
                    if (Log.isLoggable("EnhancedIntentService", 3)) {
                        Log.d("EnhancedIntentService", new StringBuilder(39).append("binder is dead. start connection? ").append(!this.zzah).toString());
                    }
                    if (this.zzah) {
                        break;
                    }
                    this.zzah = true;
                    try {
                        if (!ConnectionTracker.getInstance().bindService(this.zzac, this.zzad, this, 65)) {
                            Log.e("EnhancedIntentService", "binding to the service failed");
                            this.zzah = false;
                            zze();
                            break;
                        }
                        break;
                    } catch (SecurityException e) {
                        Log.e("EnhancedIntentService", "Exception while binding the service", e);
                    }
                } else {
                    if (Log.isLoggable("EnhancedIntentService", 3)) {
                        Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
                    }
                    this.zzag.zza(this.zzaf.poll());
                }
            }
        }
    }

    @GuardedBy("this")
    private final void zze() {
        while (!this.zzaf.isEmpty()) {
            this.zzaf.poll().finish();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String strValueOf = String.valueOf(componentName);
                Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(strValueOf).length() + 20).append("onServiceConnected: ").append(strValueOf).toString());
            }
            this.zzah = false;
            if (iBinder instanceof zzf) {
                this.zzag = (zzf) iBinder;
                zzd();
            } else {
                String strValueOf2 = String.valueOf(iBinder);
                Log.e("EnhancedIntentService", new StringBuilder(String.valueOf(strValueOf2).length() + 28).append("Invalid service connection: ").append(strValueOf2).toString());
                zze();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String strValueOf = String.valueOf(componentName);
            Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("onServiceDisconnected: ").append(strValueOf).toString());
        }
        zzd();
    }

    public final void zza(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        synchronized (this) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
            }
            this.zzaf.add(new zzd(intent, pendingResult, this.zzae));
            zzd();
        }
    }
}
