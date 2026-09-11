package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbbe extends zzbbd<Object> {
    zzbbe() {
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final int zza(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final Object zza(zzbbb zzbbbVar, zzbcu zzbcuVar, int i) {
        return zzbbbVar.zza(zzbcuVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final <UT, UB> UB zza(zzbdl zzbdlVar, Object obj, zzbbb zzbbbVar, zzbbg<Object> zzbbgVar, UB ub, zzbee<UT, UB> zzbeeVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final void zza(zzbah zzbahVar, Object obj, zzbbb zzbbbVar, zzbbg<Object> zzbbgVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final void zza(zzbdl zzbdlVar, Object obj, zzbbb zzbbbVar, zzbbg<Object> zzbbgVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final void zza(zzbey zzbeyVar, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final void zza(Object obj, zzbbg<Object> zzbbgVar) {
        ((zzbbo.zzc) obj).zzdtz = zzbbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final boolean zzh(zzbcu zzbcuVar) {
        return zzbcuVar instanceof zzbbo.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final zzbbg<Object> zzm(Object obj) {
        return ((zzbbo.zzc) obj).zzdtz;
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final zzbbg<Object> zzn(Object obj) {
        zzbbg<Object> zzbbgVarZzm = zzm(obj);
        if (!zzbbgVarZzm.isImmutable()) {
            return zzbbgVarZzm;
        }
        zzbbg<Object> zzbbgVar = (zzbbg) zzbbgVarZzm.clone();
        zza(obj, zzbbgVar);
        return zzbbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    final void zzo(Object obj) {
        zzm(obj).zzaaz();
    }
}
