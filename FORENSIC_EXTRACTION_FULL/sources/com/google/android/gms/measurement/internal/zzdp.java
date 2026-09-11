package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzdp implements Runnable {
    private final /* synthetic */ AtomicReference zzarg;
    private final /* synthetic */ zzda zzarh;

    zzdp(zzda zzdaVar, AtomicReference atomicReference) {
        this.zzarh = zzdaVar;
        this.zzarg = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzarg) {
            try {
                this.zzarg.set(Double.valueOf(this.zzarh.zzgv().zzc(this.zzarh.zzgk().zzal(), zzai.zzakf)));
                this.zzarg.notify();
            } catch (Throwable th) {
                this.zzarg.notify();
                throw th;
            }
        }
    }
}
