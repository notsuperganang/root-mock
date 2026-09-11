package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzjq<T, B> {
    zzjq() {
    }

    abstract void zzb(B b, int i, long j);

    abstract void zzb(B b, int i, zzfr zzfrVar);

    abstract void zzb(B b, int i, T t);

    abstract void zzb(T t, zzkk zzkkVar) throws IOException;

    abstract boolean zzb(zzix zzixVar);

    final boolean zzb(B b, zzix zzixVar) throws IOException {
        int tag = zzixVar.getTag();
        int i = tag >>> 3;
        switch (tag & 7) {
            case 0:
                zzb(b, i, zzixVar.zzbj());
                return true;
            case 1:
                zzc(b, i, zzixVar.zzbl());
                return true;
            case 2:
                zzb((Object) b, i, zzixVar.zzbp());
                return true;
            case 3:
                B bZzgo = zzgo();
                int i2 = (i << 3) | 4;
                while (zzixVar.zzbg() != Integer.MAX_VALUE && zzb(bZzgo, zzixVar)) {
                }
                if (i2 != zzixVar.getTag()) {
                    throw zzhh.zzec();
                }
                zzb(b, i, zzk(bZzgo));
                return true;
            case 4:
                return false;
            case 5:
                zzd(b, i, zzixVar.zzbm());
                return true;
            default:
                throw zzhh.zzed();
        }
    }

    abstract void zzc(B b, int i, long j);

    abstract void zzd(Object obj);

    abstract void zzd(B b, int i, int i2);

    abstract void zzd(T t, zzkk zzkkVar) throws IOException;

    abstract void zzf(Object obj, T t);

    abstract void zzg(Object obj, B b);

    abstract B zzgo();

    abstract T zzh(T t, T t2);

    abstract T zzk(B b);

    abstract int zzn(T t);

    abstract T zzq(Object obj);

    abstract B zzr(Object obj);

    abstract int zzs(T t);
}
