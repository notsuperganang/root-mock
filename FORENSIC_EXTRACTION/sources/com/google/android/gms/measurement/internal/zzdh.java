package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzdh implements Runnable {
    private final /* synthetic */ zzcx zzaef;
    private final /* synthetic */ zzda zzarh;

    zzdh(zzda zzdaVar, zzcx zzcxVar) {
        this.zzarh = zzdaVar;
        this.zzaef = zzcxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zza(this.zzaef);
    }
}
