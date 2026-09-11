package com.google.android.gms.internal.places;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzhu extends zzhr {
    private zzhu() {
        super();
    }

    private static <E> zzhg<E> zze(Object obj, long j) {
        return (zzhg) zzjw.zzq(obj, j);
    }

    @Override // com.google.android.gms.internal.places.zzhr
    final <L> List<L> zzb(Object obj, long j) {
        zzhg zzhgVarZze = zze(obj, j);
        if (zzhgVarZze.zzba()) {
            return zzhgVarZze;
        }
        int size = zzhgVarZze.size();
        zzhg zzhgVarZzae = zzhgVarZze.zzae(size == 0 ? 10 : size << 1);
        zzjw.zzb(obj, j, zzhgVarZzae);
        return zzhgVarZzae;
    }

    @Override // com.google.android.gms.internal.places.zzhr
    final <E> void zzb(Object obj, Object obj2, long j) {
        zzhg zzhgVarZze = zze(obj, j);
        zzhg zzhgVarZze2 = zze(obj2, j);
        int size = zzhgVarZze.size();
        int size2 = zzhgVarZze2.size();
        if (size > 0 && size2 > 0) {
            if (!zzhgVarZze.zzba()) {
                zzhgVarZze = zzhgVarZze.zzae(size2 + size);
            }
            zzhgVarZze.addAll(zzhgVarZze2);
        }
        if (size <= 0) {
            zzhgVarZze = zzhgVarZze2;
        }
        zzjw.zzb(obj, j, zzhgVarZze);
    }

    @Override // com.google.android.gms.internal.places.zzhr
    final void zzc(Object obj, long j) {
        zze(obj, j).zzbb();
    }
}
