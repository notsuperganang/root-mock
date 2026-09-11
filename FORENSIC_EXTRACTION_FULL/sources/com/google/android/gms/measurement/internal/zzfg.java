package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzfg implements Runnable {
    private final /* synthetic */ long zzafg;
    private final /* synthetic */ zzfd zzatf;

    zzfg(zzfd zzfdVar, long j) {
        this.zzatf = zzfdVar;
        this.zzafg = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzatf.zzai(this.zzafg);
    }
}
