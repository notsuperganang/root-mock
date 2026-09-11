package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcc implements Runnable {
    private final /* synthetic */ zzby zzaqo;
    private final /* synthetic */ zzo zzaqp;

    zzcc(zzby zzbyVar, zzo zzoVar) {
        this.zzaqo = zzbyVar;
        this.zzaqp = zzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzaqo.zzamx.zzme();
        this.zzaqo.zzamx.zzf(this.zzaqp);
    }
}
