package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzhz<K, V> {
    static <K, V> int zzb(zzia<K, V> zziaVar, K k, V v) {
        return zzgq.zzb(zziaVar.zzut, 1, k) + zzgq.zzb(zziaVar.zzuv, 2, v);
    }

    static <K, V> void zzb(zzgf zzgfVar, zzia<K, V> zziaVar, K k, V v) throws IOException {
        zzgq.zzb(zzgfVar, zziaVar.zzut, 1, k);
        zzgq.zzb(zzgfVar, zziaVar.zzuv, 2, v);
    }
}
