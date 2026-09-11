package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzci implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzby zzaqo;

    zzci(zzby zzbyVar, zzk zzkVar) {
        this.zzaqo = zzbyVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzaqo.zzamx.zzme();
        this.zzaqo.zzamx.zzd(this.zzaqn);
    }
}
