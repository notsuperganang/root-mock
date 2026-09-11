package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzdk implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ AtomicReference zzarg;
    private final /* synthetic */ zzda zzarh;

    zzdk(zzda zzdaVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzarh = zzdaVar;
        this.zzarg = atomicReference;
        this.zzagj = str;
        this.zzads = str2;
        this.zzadz = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zzada.zzgl().zza(this.zzarg, this.zzagj, this.zzads, this.zzadz);
    }
}
