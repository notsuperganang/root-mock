package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzud extends zzuc<Object> {
    zzud() {
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final Object zza(zzub zzubVar, zzvv zzvvVar, int i) {
        return zzubVar.zza(zzvvVar, i);
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final <UT, UB> UB zza(zzwk zzwkVar, Object obj, zzub zzubVar, zzuf<Object> zzufVar, UB ub, zzxd<UT, UB> zzxdVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final void zza(zzte zzteVar, Object obj, zzub zzubVar, zzuf<Object> zzufVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final void zza(zzwk zzwkVar, Object obj, zzub zzubVar, zzuf<Object> zzufVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final void zza(zzxy zzxyVar, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final int zzb(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final boolean zze(zzvv zzvvVar) {
        return zzvvVar instanceof zzuo.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final zzuf<Object> zzw(Object obj) {
        return ((zzuo.zzc) obj).zzbyl;
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final zzuf<Object> zzx(Object obj) {
        zzuo.zzc zzcVar = (zzuo.zzc) obj;
        if (zzcVar.zzbyl.isImmutable()) {
            zzcVar.zzbyl = (zzuf) zzcVar.zzbyl.clone();
        }
        return zzcVar.zzbyl;
    }

    @Override // com.google.android.gms.internal.measurement.zzuc
    final void zzy(Object obj) {
        zzw(obj).zzsw();
    }
}
