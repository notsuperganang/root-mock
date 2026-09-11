package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbi;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class zzbbd<T extends zzbbi<T>> {
    zzbbd() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract Object zza(zzbbb zzbbbVar, zzbcu zzbcuVar, int i);

    abstract <UT, UB> UB zza(zzbdl zzbdlVar, Object obj, zzbbb zzbbbVar, zzbbg<T> zzbbgVar, UB ub, zzbee<UT, UB> zzbeeVar) throws IOException;

    abstract void zza(zzbah zzbahVar, Object obj, zzbbb zzbbbVar, zzbbg<T> zzbbgVar) throws IOException;

    abstract void zza(zzbdl zzbdlVar, Object obj, zzbbb zzbbbVar, zzbbg<T> zzbbgVar) throws IOException;

    abstract void zza(zzbey zzbeyVar, Map.Entry<?, ?> entry) throws IOException;

    abstract void zza(Object obj, zzbbg<T> zzbbgVar);

    abstract boolean zzh(zzbcu zzbcuVar);

    abstract zzbbg<T> zzm(Object obj);

    abstract zzbbg<T> zzn(Object obj);

    abstract void zzo(Object obj);
}
