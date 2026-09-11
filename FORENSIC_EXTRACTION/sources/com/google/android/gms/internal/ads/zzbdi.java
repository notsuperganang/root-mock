package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbdi implements zzbcs {
    private final String info;
    private final zzbcu zzdwl;
    private final zzbdj zzdxe;

    zzbdi(zzbcu zzbcuVar, String str, Object[] objArr) {
        this.zzdwl = zzbcuVar;
        this.info = str;
        this.zzdxe = new zzbdj(zzbcuVar.getClass(), str, objArr);
    }

    public final int getFieldCount() {
        return this.zzdxe.zzdxh;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzaeh() {
        return (this.zzdxe.flags & 1) == 1 ? zzbbo.zze.zzdui : zzbbo.zze.zzduj;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final boolean zzaei() {
        return (this.zzdxe.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final zzbcu zzaej() {
        return this.zzdwl;
    }

    final zzbdj zzaeq() {
        return this.zzdxe;
    }

    public final int zzaer() {
        return this.zzdxe.zzdwi;
    }

    public final int zzaes() {
        return this.zzdxe.zzdwj;
    }

    public final int zzaet() {
        return this.zzdxe.zzdxk;
    }

    public final int zzaeu() {
        return this.zzdxe.zzdxm;
    }

    final int[] zzaev() {
        return this.zzdxe.zzdwq;
    }

    public final int zzaew() {
        return this.zzdxe.zzdxl;
    }

    public final int zzaex() {
        return this.zzdxe.zzdwk;
    }
}
