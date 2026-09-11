package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzxd<T, B> {
    zzxd() {
    }

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzte zzteVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzxy zzxyVar) throws IOException;

    abstract boolean zza(zzwk zzwkVar);

    final boolean zza(B b, zzwk zzwkVar) throws IOException {
        int tag = zzwkVar.getTag();
        int i = tag >>> 3;
        switch (tag & 7) {
            case 0:
                zza(b, i, zzwkVar.zzul());
                return true;
            case 1:
                zzb(b, i, zzwkVar.zzun());
                return true;
            case 2:
                zza((Object) b, i, zzwkVar.zzur());
                return true;
            case 3:
                B bZzyk = zzyk();
                while (zzwkVar.zzvh() != Integer.MAX_VALUE && zza(bZzyk, zzwkVar)) {
                }
                if (((i << 3) | 4) != zzwkVar.getTag()) {
                    throw zzuv.zzwt();
                }
                zza(b, i, zzaf(bZzyk));
                return true;
            case 4:
                return false;
            case 5:
                zzc(b, i, zzwkVar.zzuo());
                return true;
            default:
                throw zzuv.zzwu();
        }
    }

    abstract T zzaf(B b);

    abstract int zzai(T t);

    abstract T zzal(Object obj);

    abstract B zzam(Object obj);

    abstract int zzan(T t);

    abstract void zzb(B b, int i, long j);

    abstract void zzc(B b, int i, int i2);

    abstract void zzc(T t, zzxy zzxyVar) throws IOException;

    abstract void zzf(Object obj, T t);

    abstract void zzg(Object obj, B b);

    abstract T zzh(T t, T t2);

    abstract void zzy(Object obj);

    abstract B zzyk();
}
