package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class zzab {

    @GuardedBy("MessengerIpcClient.class")
    private static zzab zzbx;
    private final Context zzac;
    private final ScheduledExecutorService zzby;

    @GuardedBy("this")
    private zzad zzbz = new zzad(this);

    @GuardedBy("this")
    private int zzca = 1;

    @VisibleForTesting
    private zzab(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzby = scheduledExecutorService;
        this.zzac = context.getApplicationContext();
    }

    private final <T> Task<T> zza(zzak<T> zzakVar) {
        Task<T> task;
        synchronized (this) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(zzakVar);
                Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(strValueOf).length() + 9).append("Queueing ").append(strValueOf).toString());
            }
            if (!this.zzbz.zzb(zzakVar)) {
                this.zzbz = new zzad(this);
                this.zzbz.zzb(zzakVar);
            }
            task = zzakVar.zzck.getTask();
        }
        return task;
    }

    public static zzab zzc(Context context) {
        zzab zzabVar;
        synchronized (zzab.class) {
            try {
                if (zzbx == null) {
                    zzbx = new zzab(context, com.google.android.gms.internal.firebase_messaging.zzb.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), com.google.android.gms.internal.firebase_messaging.zze.zzd));
                }
                zzabVar = zzbx;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzabVar;
    }

    private final int zzx() {
        int i;
        synchronized (this) {
            i = this.zzca;
            this.zzca = i + 1;
        }
        return i;
    }

    public final Task<Void> zza(int i, Bundle bundle) {
        return zza(new zzaj(zzx(), 2, bundle));
    }

    public final Task<Bundle> zzb(int i, Bundle bundle) {
        return zza(new zzam(zzx(), 1, bundle));
    }
}
