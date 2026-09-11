package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzjs extends zzjq<zzjr, zzjr> {
    zzjs() {
    }

    private static void zzb(Object obj, zzjr zzjrVar) {
        ((zzgz) obj).zzsg = zzjrVar;
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ void zzb(zzjr zzjrVar, int i, long j) {
        zzjrVar.zzc(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ void zzb(zzjr zzjrVar, int i, zzfr zzfrVar) {
        zzjrVar.zzc((i << 3) | 2, zzfrVar);
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ void zzb(zzjr zzjrVar, int i, zzjr zzjrVar2) {
        zzjrVar.zzc((i << 3) | 3, zzjrVar2);
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ void zzb(zzjr zzjrVar, zzkk zzkkVar) throws IOException {
        zzjrVar.zzc(zzkkVar);
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final boolean zzb(zzix zzixVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ void zzc(zzjr zzjrVar, int i, long j) {
        zzjrVar.zzc((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final void zzd(Object obj) {
        ((zzgz) obj).zzsg.zzbb();
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ void zzd(zzjr zzjrVar, int i, int i2) {
        zzjrVar.zzc((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ void zzd(zzjr zzjrVar, zzkk zzkkVar) throws IOException {
        zzjrVar.zzb(zzkkVar);
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ void zzf(Object obj, zzjr zzjrVar) {
        zzb(obj, zzjrVar);
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ void zzg(Object obj, zzjr zzjrVar) {
        zzb(obj, zzjrVar);
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ zzjr zzgo() {
        return zzjr.zzgq();
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ zzjr zzh(zzjr zzjrVar, zzjr zzjrVar2) {
        zzjr zzjrVar3 = zzjrVar;
        zzjr zzjrVar4 = zzjrVar2;
        return zzjrVar4.equals(zzjr.zzgp()) ? zzjrVar3 : zzjr.zzb(zzjrVar3, zzjrVar4);
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ zzjr zzk(zzjr zzjrVar) {
        zzjr zzjrVar2 = zzjrVar;
        zzjrVar2.zzbb();
        return zzjrVar2;
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ int zzn(zzjr zzjrVar) {
        return zzjrVar.zzdg();
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ zzjr zzq(Object obj) {
        return ((zzgz) obj).zzsg;
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ zzjr zzr(Object obj) {
        zzjr zzjrVar = ((zzgz) obj).zzsg;
        if (zzjrVar != zzjr.zzgp()) {
            return zzjrVar;
        }
        zzjr zzjrVarZzgq = zzjr.zzgq();
        zzb(obj, zzjrVarZzgq);
        return zzjrVarZzgq;
    }

    @Override // com.google.android.gms.internal.places.zzjq
    final /* synthetic */ int zzs(zzjr zzjrVar) {
        return zzjrVar.zzgr();
    }
}
