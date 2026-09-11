package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzvn<K, V> {
    static <K, V> int zza(zzvo<K, V> zzvoVar, K k, V v) {
        return zzuf.zza(zzvoVar.zzcak, 1, k) + zzuf.zza(zzvoVar.zzcam, 2, v);
    }

    static <K, V> void zza(zztv zztvVar, zzvo<K, V> zzvoVar, K k, V v) throws IOException {
        zzuf.zza(zztvVar, zzvoVar.zzcak, 1, k);
        zzuf.zza(zztvVar, zzvoVar.zzcam, 2, v);
    }
}
