package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzdm implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ AtomicReference zzarg;
    private final /* synthetic */ zzda zzarh;

    zzdm(zzda zzdaVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zzarh = zzdaVar;
        this.zzarg = atomicReference;
        this.zzagj = str;
        this.zzads = str2;
        this.zzadz = str3;
        this.zzaeg = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zzada.zzgl().zza(this.zzarg, this.zzagj, this.zzads, this.zzadz, this.zzaeg);
    }
}
