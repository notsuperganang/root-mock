package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzbn implements Runnable {
    private final /* synthetic */ zzbw zzaoh;
    private final /* synthetic */ zzas zzaoi;

    zzbn(zzbm zzbmVar, zzbw zzbwVar, zzas zzasVar) {
        this.zzaoh = zzbwVar;
        this.zzaoi = zzasVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzaoh.zzkk() == null) {
            this.zzaoi.zzjg().zzby("Install Referrer Reporter is null");
            return;
        }
        zzbj zzbjVarZzkk = this.zzaoh.zzkk();
        zzbjVarZzkk.zzada.zzgg();
        zzbjVarZzkk.zzce(zzbjVarZzkk.zzada.getContext().getPackageName());
    }
}
