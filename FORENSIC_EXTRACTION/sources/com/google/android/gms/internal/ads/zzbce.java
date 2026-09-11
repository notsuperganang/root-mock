package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class zzbce {
    private static final zzbce zzdvq;
    private static final zzbce zzdvr;

    static {
        zzbcf zzbcfVar = null;
        zzdvq = new zzbcg();
        zzdvr = new zzbch();
    }

    private zzbce() {
    }

    static zzbce zzady() {
        return zzdvq;
    }

    static zzbce zzadz() {
        return zzdvr;
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);
}
