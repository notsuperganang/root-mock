package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzde implements Runnable {
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ AtomicReference zzarg;
    private final /* synthetic */ zzda zzarh;

    zzde(zzda zzdaVar, AtomicReference atomicReference, boolean z) {
        this.zzarh = zzdaVar;
        this.zzarg = atomicReference;
        this.zzaeg = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zzgl().zza(this.zzarg, this.zzaeg);
    }
}
