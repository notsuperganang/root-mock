package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuh;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class zzuc<T extends zzuh<T>> {
    zzuc() {
    }

    abstract Object zza(zzub zzubVar, zzvv zzvvVar, int i);

    abstract <UT, UB> UB zza(zzwk zzwkVar, Object obj, zzub zzubVar, zzuf<T> zzufVar, UB ub, zzxd<UT, UB> zzxdVar) throws IOException;

    abstract void zza(zzte zzteVar, Object obj, zzub zzubVar, zzuf<T> zzufVar) throws IOException;

    abstract void zza(zzwk zzwkVar, Object obj, zzub zzubVar, zzuf<T> zzufVar) throws IOException;

    abstract void zza(zzxy zzxyVar, Map.Entry<?, ?> entry) throws IOException;

    abstract int zzb(Map.Entry<?, ?> entry);

    abstract boolean zze(zzvv zzvvVar);

    abstract zzuf<T> zzw(Object obj);

    abstract zzuf<T> zzx(Object obj);

    abstract void zzy(Object obj);
}
