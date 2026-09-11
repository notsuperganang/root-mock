package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzvi extends zzvf {
    private zzvi() {
        super();
    }

    private static <E> zzuu<E> zzd(Object obj, long j) {
        return (zzuu) zzxj.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzvf
    final <L> List<L> zza(Object obj, long j) {
        zzuu zzuuVarZzd = zzd(obj, j);
        if (zzuuVarZzd.zztz()) {
            return zzuuVarZzd;
        }
        int size = zzuuVarZzd.size();
        zzuu zzuuVarZzal = zzuuVarZzd.zzal(size == 0 ? 10 : size << 1);
        zzxj.zza(obj, j, zzuuVarZzal);
        return zzuuVarZzal;
    }

    @Override // com.google.android.gms.internal.measurement.zzvf
    final <E> void zza(Object obj, Object obj2, long j) {
        zzuu zzuuVarZzd = zzd(obj, j);
        zzuu zzuuVarZzd2 = zzd(obj2, j);
        int size = zzuuVarZzd.size();
        int size2 = zzuuVarZzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzuuVarZzd.zztz()) {
                zzuuVarZzd = zzuuVarZzd.zzal(size2 + size);
            }
            zzuuVarZzd.addAll(zzuuVarZzd2);
        }
        if (size <= 0) {
            zzuuVarZzd = zzuuVarZzd2;
        }
        zzxj.zza(obj, j, zzuuVarZzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzvf
    final void zzb(Object obj, long j) {
        zzd(obj, j).zzsw();
    }
}
