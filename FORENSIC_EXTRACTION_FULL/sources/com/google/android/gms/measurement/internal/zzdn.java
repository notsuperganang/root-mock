package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzdn implements Runnable {
    private final /* synthetic */ AtomicReference zzarg;
    private final /* synthetic */ zzda zzarh;

    zzdn(zzda zzdaVar, AtomicReference atomicReference) {
        this.zzarh = zzdaVar;
        this.zzarg = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzarg) {
            try {
                this.zzarg.set(Long.valueOf(this.zzarh.zzgv().zza(this.zzarh.zzgk().zzal(), zzai.zzakd)));
                this.zzarg.notify();
            } catch (Throwable th) {
                this.zzarg.notify();
                throw th;
            }
        }
    }
}
