package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzvr implements zzvq {
    zzvr() {
    }

    @Override // com.google.android.gms.internal.measurement.zzvq
    public final Map<?, ?> zzac(Object obj) {
        return (zzvp) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzvq
    public final Map<?, ?> zzad(Object obj) {
        return (zzvp) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzvq
    public final boolean zzae(Object obj) {
        return !((zzvp) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.measurement.zzvq
    public final Object zzaf(Object obj) {
        ((zzvp) obj).zzsw();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzvq
    public final Object zzag(Object obj) {
        return zzvp.zzxg().zzxh();
    }

    @Override // com.google.android.gms.internal.measurement.zzvq
    public final zzvo<?, ?> zzah(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzvq
    public final int zzb(int i, Object obj, Object obj2) {
        zzvp zzvpVar = (zzvp) obj;
        if (zzvpVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzvpVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzvq
    public final Object zzc(Object obj, Object obj2) {
        zzvp zzvpVarZzxh = (zzvp) obj;
        zzvp zzvpVar = (zzvp) obj2;
        if (!zzvpVar.isEmpty()) {
            if (!zzvpVarZzxh.isMutable()) {
                zzvpVarZzxh = zzvpVarZzxh.zzxh();
            }
            zzvpVarZzxh.zza(zzvpVar);
        }
        return zzvpVarZzxh;
    }
}
