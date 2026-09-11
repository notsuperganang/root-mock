package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcm implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzby zzaqo;
    private final /* synthetic */ zzfu zzaqq;

    zzcm(zzby zzbyVar, zzfu zzfuVar, zzk zzkVar) {
        this.zzaqo = zzbyVar;
        this.zzaqq = zzfuVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzaqo.zzamx.zzme();
        this.zzaqo.zzamx.zzc(this.zzaqq, this.zzaqn);
    }
}
