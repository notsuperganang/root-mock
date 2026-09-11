package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
interface zzwl<T> {
    boolean equals(T t, T t2);

    int hashCode(T t);

    T newInstance();

    void zza(T t, zzwk zzwkVar, zzub zzubVar) throws IOException;

    void zza(T t, zzxy zzxyVar) throws IOException;

    int zzai(T t);

    boolean zzaj(T t);

    void zzd(T t, T t2);

    void zzy(T t);
}
