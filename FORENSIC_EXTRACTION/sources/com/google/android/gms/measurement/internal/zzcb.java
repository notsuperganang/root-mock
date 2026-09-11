package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcb implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzby zzaqo;
    private final /* synthetic */ zzo zzaqp;

    zzcb(zzby zzbyVar, zzo zzoVar, zzk zzkVar) {
        this.zzaqo = zzbyVar;
        this.zzaqp = zzoVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzaqo.zzamx.zzme();
        this.zzaqo.zzamx.zzb(this.zzaqp, this.zzaqn);
    }
}
