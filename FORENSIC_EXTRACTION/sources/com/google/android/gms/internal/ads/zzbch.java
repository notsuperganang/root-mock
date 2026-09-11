package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzbch extends zzbce {
    private zzbch() {
        super();
    }

    private static <E> zzbbt<E> zzd(Object obj, long j) {
        return (zzbbt) zzbek.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbce
    final <L> List<L> zza(Object obj, long j) {
        zzbbt zzbbtVarZzd = zzd(obj, j);
        if (zzbbtVarZzd.zzaay()) {
            return zzbbtVarZzd;
        }
        int size = zzbbtVarZzd.size();
        zzbbt zzbbtVarZzbm = zzbbtVarZzd.zzbm(size == 0 ? 10 : size << 1);
        zzbek.zza(obj, j, zzbbtVarZzbm);
        return zzbbtVarZzbm;
    }

    @Override // com.google.android.gms.internal.ads.zzbce
    final <E> void zza(Object obj, Object obj2, long j) {
        zzbbt zzbbtVarZzd = zzd(obj, j);
        zzbbt zzbbtVarZzd2 = zzd(obj2, j);
        int size = zzbbtVarZzd.size();
        int size2 = zzbbtVarZzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzbbtVarZzd.zzaay()) {
                zzbbtVarZzd = zzbbtVarZzd.zzbm(size2 + size);
            }
            zzbbtVarZzd.addAll(zzbbtVarZzd2);
        }
        if (size <= 0) {
            zzbbtVarZzd = zzbbtVarZzd2;
        }
        zzbek.zza(obj, j, zzbbtVarZzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbce
    final void zzb(Object obj, long j) {
        zzd(obj, j).zzaaz();
    }
}
