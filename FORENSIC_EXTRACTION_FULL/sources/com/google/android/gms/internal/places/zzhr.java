package com.google.android.gms.internal.places;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class zzhr {
    private static final zzhr zzul;
    private static final zzhr zzum;

    static {
        zzhs zzhsVar = null;
        zzul = new zzht();
        zzum = new zzhu();
    }

    private zzhr() {
    }

    static zzhr zzem() {
        return zzul;
    }

    static zzhr zzen() {
        return zzum;
    }

    abstract <L> List<L> zzb(Object obj, long j);

    abstract <L> void zzb(Object obj, Object obj2, long j);

    abstract void zzc(Object obj, long j);
}
