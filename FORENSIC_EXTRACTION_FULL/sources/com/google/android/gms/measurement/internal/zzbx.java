package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzbx implements Runnable {
    private final /* synthetic */ zzcz zzaqj;
    private final /* synthetic */ zzbw zzaqk;

    zzbx(zzbw zzbwVar, zzcz zzczVar) {
        this.zzaqk = zzbwVar;
        this.zzaqj = zzczVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaqk.zza(this.zzaqj);
        this.zzaqk.start();
    }
}
