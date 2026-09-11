package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzea implements Runnable {
    private final /* synthetic */ zzdy zzasc;
    private final /* synthetic */ zzdx zzasd;

    zzea(zzdy zzdyVar, zzdx zzdxVar) {
        this.zzasc = zzdyVar;
        this.zzasd = zzdxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzasc.zza(this.zzasd, false);
        this.zzasc.zzart = null;
        this.zzasc.zzgl().zza((zzdx) null);
    }
}
