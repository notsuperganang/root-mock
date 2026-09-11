package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzgs;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgm<T extends zzgs<T>> {
    zzgm() {
    }

    abstract int zzb(Map.Entry<?, ?> entry);

    abstract zzgq<T> zzb(Object obj);

    abstract Object zzb(zzgl zzglVar, zzih zzihVar, int i);

    abstract <UT, UB> UB zzb(zzix zzixVar, Object obj, zzgl zzglVar, zzgq<T> zzgqVar, UB ub, zzjq<UT, UB> zzjqVar) throws IOException;

    abstract void zzb(zzfr zzfrVar, Object obj, zzgl zzglVar, zzgq<T> zzgqVar) throws IOException;

    abstract void zzb(zzix zzixVar, Object obj, zzgl zzglVar, zzgq<T> zzgqVar) throws IOException;

    abstract void zzb(zzkk zzkkVar, Map.Entry<?, ?> entry) throws IOException;

    abstract void zzb(Object obj, zzgq<T> zzgqVar);

    abstract zzgq<T> zzc(Object obj);

    abstract void zzd(Object obj);

    abstract boolean zzf(zzih zzihVar);
}
