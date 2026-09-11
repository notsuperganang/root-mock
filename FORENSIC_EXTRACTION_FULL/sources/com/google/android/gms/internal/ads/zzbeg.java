package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzbeg extends zzbee<zzbef, zzbef> {
    zzbeg() {
    }

    private static void zza(Object obj, zzbef zzbefVar) {
        ((zzbbo) obj).zzdtt = zzbefVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ void zza(zzbef zzbefVar, int i, long j) {
        zzbefVar.zzb(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ void zza(zzbef zzbefVar, int i, zzbah zzbahVar) {
        zzbefVar.zzb((i << 3) | 2, zzbahVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ void zza(zzbef zzbefVar, int i, zzbef zzbefVar2) {
        zzbefVar.zzb((i << 3) | 3, zzbefVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ void zza(zzbef zzbefVar, zzbey zzbeyVar) throws IOException {
        zzbefVar.zzb(zzbeyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final boolean zza(zzbdl zzbdlVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ zzbef zzac(Object obj) {
        return ((zzbbo) obj).zzdtt;
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ zzbef zzad(Object obj) {
        zzbef zzbefVar = ((zzbbo) obj).zzdtt;
        if (zzbefVar != zzbef.zzagc()) {
            return zzbefVar;
        }
        zzbef zzbefVarZzagd = zzbef.zzagd();
        zza(obj, zzbefVarZzagd);
        return zzbefVarZzagd;
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ int zzae(zzbef zzbefVar) {
        return zzbefVar.zzage();
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ zzbef zzagb() {
        return zzbef.zzagd();
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ void zzb(zzbef zzbefVar, int i, long j) {
        zzbefVar.zzb((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ void zzc(zzbef zzbefVar, int i, int i2) {
        zzbefVar.zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ void zzc(zzbef zzbefVar, zzbey zzbeyVar) throws IOException {
        zzbefVar.zza(zzbeyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ void zze(Object obj, zzbef zzbefVar) {
        zza(obj, zzbefVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ void zzf(Object obj, zzbef zzbefVar) {
        zza(obj, zzbefVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ zzbef zzg(zzbef zzbefVar, zzbef zzbefVar2) {
        zzbef zzbefVar3 = zzbefVar;
        zzbef zzbefVar4 = zzbefVar2;
        return zzbefVar4.equals(zzbef.zzagc()) ? zzbefVar3 : zzbef.zza(zzbefVar3, zzbefVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final void zzo(Object obj) {
        ((zzbbo) obj).zzdtt.zzaaz();
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ zzbef zzv(zzbef zzbefVar) {
        zzbef zzbefVar2 = zzbefVar;
        zzbefVar2.zzaaz();
        return zzbefVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    final /* synthetic */ int zzy(zzbef zzbefVar) {
        return zzbefVar.zzacw();
    }
}
