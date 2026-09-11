package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzxf extends zzxd<zzxe, zzxe> {
    zzxf() {
    }

    private static void zza(Object obj, zzxe zzxeVar) {
        ((zzuo) obj).zzbyf = zzxeVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ void zza(zzxe zzxeVar, int i, long j) {
        zzxeVar.zzb(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ void zza(zzxe zzxeVar, int i, zzte zzteVar) {
        zzxeVar.zzb((i << 3) | 2, zzteVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ void zza(zzxe zzxeVar, int i, zzxe zzxeVar2) {
        zzxeVar.zzb((i << 3) | 3, zzxeVar2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ void zza(zzxe zzxeVar, zzxy zzxyVar) throws IOException {
        zzxeVar.zzb(zzxyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final boolean zza(zzwk zzwkVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ zzxe zzaf(zzxe zzxeVar) {
        zzxe zzxeVar2 = zzxeVar;
        zzxeVar2.zzsw();
        return zzxeVar2;
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ int zzai(zzxe zzxeVar) {
        return zzxeVar.zzvx();
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ zzxe zzal(Object obj) {
        return ((zzuo) obj).zzbyf;
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ zzxe zzam(Object obj) {
        zzxe zzxeVar = ((zzuo) obj).zzbyf;
        if (zzxeVar != zzxe.zzyl()) {
            return zzxeVar;
        }
        zzxe zzxeVarZzym = zzxe.zzym();
        zza(obj, zzxeVarZzym);
        return zzxeVarZzym;
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ int zzan(zzxe zzxeVar) {
        return zzxeVar.zzyn();
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ void zzb(zzxe zzxeVar, int i, long j) {
        zzxeVar.zzb((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ void zzc(zzxe zzxeVar, int i, int i2) {
        zzxeVar.zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ void zzc(zzxe zzxeVar, zzxy zzxyVar) throws IOException {
        zzxeVar.zza(zzxyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ void zzf(Object obj, zzxe zzxeVar) {
        zza(obj, zzxeVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ void zzg(Object obj, zzxe zzxeVar) {
        zza(obj, zzxeVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ zzxe zzh(zzxe zzxeVar, zzxe zzxeVar2) {
        zzxe zzxeVar3 = zzxeVar;
        zzxe zzxeVar4 = zzxeVar2;
        return zzxeVar4.equals(zzxe.zzyl()) ? zzxeVar3 : zzxe.zza(zzxeVar3, zzxeVar4);
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final void zzy(Object obj) {
        ((zzuo) obj).zzbyf.zzsw();
    }

    @Override // com.google.android.gms.internal.measurement.zzxd
    final /* synthetic */ zzxe zzyk() {
        return zzxe.zzym();
    }
}
