package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbcq implements zzbcp {
    zzbcq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final int zzb(int i, Object obj, Object obj2) {
        zzbco zzbcoVar = (zzbco) obj;
        if (zzbcoVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzbcoVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final Object zzb(Object obj, Object obj2) {
        zzbco zzbcoVarZzaec = (zzbco) obj;
        zzbco zzbcoVar = (zzbco) obj2;
        if (!zzbcoVar.isEmpty()) {
            if (!zzbcoVarZzaec.isMutable()) {
                zzbcoVarZzaec = zzbcoVarZzaec.zzaec();
            }
            zzbcoVarZzaec.zza(zzbcoVar);
        }
        return zzbcoVarZzaec;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final Map<?, ?> zzs(Object obj) {
        return (zzbco) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final Map<?, ?> zzt(Object obj) {
        return (zzbco) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final boolean zzu(Object obj) {
        return !((zzbco) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final Object zzv(Object obj) {
        ((zzbco) obj).zzaaz();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final Object zzw(Object obj) {
        return zzbco.zzaeb().zzaec();
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final zzbcn<?, ?> zzx(Object obj) {
        throw new NoSuchMethodError();
    }
}
