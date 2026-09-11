package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class zzvf {
    private static final zzvf zzcac;
    private static final zzvf zzcad;

    static {
        zzvg zzvgVar = null;
        zzcac = new zzvh();
        zzcad = new zzvi();
    }

    private zzvf() {
    }

    static zzvf zzxd() {
        return zzcac;
    }

    static zzvf zzxe() {
        return zzcad;
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);
}
