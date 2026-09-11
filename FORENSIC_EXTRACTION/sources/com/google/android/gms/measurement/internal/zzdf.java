package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzdf implements Runnable {
    private final /* synthetic */ AtomicReference zzarg;
    private final /* synthetic */ zzda zzarh;

    zzdf(zzda zzdaVar, AtomicReference atomicReference) {
        this.zzarh = zzdaVar;
        this.zzarg = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zzgl().zza(this.zzarg);
    }
}
