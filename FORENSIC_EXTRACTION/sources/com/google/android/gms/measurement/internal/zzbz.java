package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzbz implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzby zzaqo;

    zzbz(zzby zzbyVar, zzk zzkVar) {
        this.zzaqo = zzbyVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzaqo.zzamx.zzme();
        this.zzaqo.zzamx.zze(this.zzaqn);
    }
}
