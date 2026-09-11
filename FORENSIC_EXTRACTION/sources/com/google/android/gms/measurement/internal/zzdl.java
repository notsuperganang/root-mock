package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzdl implements Runnable {
    private final /* synthetic */ AtomicReference zzarg;
    private final /* synthetic */ zzda zzarh;

    zzdl(zzda zzdaVar, AtomicReference atomicReference) {
        this.zzarh = zzdaVar;
        this.zzarg = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzarg) {
            try {
                this.zzarg.set(this.zzarh.zzgv().zzay(this.zzarh.zzgk().zzal()));
                this.zzarg.notify();
            } catch (Throwable th) {
                this.zzarg.notify();
                throw th;
            }
        }
    }
}
