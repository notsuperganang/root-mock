package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
abstract class zzy {
    private static volatile Handler handler;
    private final zzct zzahn;
    private final Runnable zzyo;
    private volatile long zzyp;

    zzy(zzct zzctVar) {
        Preconditions.checkNotNull(zzctVar);
        this.zzahn = zzctVar;
        this.zzyo = new zzz(this, zzctVar);
    }

    private final Handler getHandler() {
        Handler handler2;
        if (handler != null) {
            return handler;
        }
        synchronized (zzy.class) {
            try {
                if (handler == null) {
                    handler = new com.google.android.gms.internal.measurement.zzdl(this.zzahn.getContext().getMainLooper());
                }
                handler2 = handler;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler2;
    }

    static /* synthetic */ long zza(zzy zzyVar, long j) {
        zzyVar.zzyp = 0L;
        return 0L;
    }

    final void cancel() {
        this.zzyp = 0L;
        getHandler().removeCallbacks(this.zzyo);
    }

    public abstract void run();

    public final boolean zzej() {
        return this.zzyp != 0;
    }

    public final void zzh(long j) {
        cancel();
        if (j >= 0) {
            this.zzyp = this.zzahn.zzbx().currentTimeMillis();
            if (getHandler().postDelayed(this.zzyo, j)) {
                return;
            }
            this.zzahn.zzgt().zzjg().zzg("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }
}
