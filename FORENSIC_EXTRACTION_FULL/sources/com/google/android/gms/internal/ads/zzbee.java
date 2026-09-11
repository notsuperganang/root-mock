package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzbee<T, B> {
    zzbee() {
    }

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzbah zzbahVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzbey zzbeyVar) throws IOException;

    abstract boolean zza(zzbdl zzbdlVar);

    final boolean zza(B b, zzbdl zzbdlVar) throws IOException {
        int tag = zzbdlVar.getTag();
        int i = tag >>> 3;
        switch (tag & 7) {
            case 0:
                zza(b, i, zzbdlVar.zzabm());
                return true;
            case 1:
                zzb(b, i, zzbdlVar.zzabo());
                return true;
            case 2:
                zza((Object) b, i, zzbdlVar.zzabs());
                return true;
            case 3:
                B bZzagb = zzagb();
                while (zzbdlVar.zzaci() != Integer.MAX_VALUE && zza(bZzagb, zzbdlVar)) {
                }
                if (((i << 3) | 4) != zzbdlVar.getTag()) {
                    throw zzbbu.zzadp();
                }
                zza(b, i, zzv(bZzagb));
                return true;
            case 4:
                return false;
            case 5:
                zzc(b, i, zzbdlVar.zzabp());
                return true;
            default:
                throw zzbbu.zzadq();
        }
    }

    abstract T zzac(Object obj);

    abstract B zzad(Object obj);

    abstract int zzae(T t);

    abstract B zzagb();

    abstract void zzb(B b, int i, long j);

    abstract void zzc(B b, int i, int i2);

    abstract void zzc(T t, zzbey zzbeyVar) throws IOException;

    abstract void zze(Object obj, T t);

    abstract void zzf(Object obj, B b);

    abstract T zzg(T t, T t2);

    abstract void zzo(Object obj);

    abstract T zzv(B b);

    abstract int zzy(T t);
}
