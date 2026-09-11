package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzbcg extends zzbce {
    private static final Class<?> zzdvs = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzbcg() {
        super();
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> listZzc = zzc(obj, j);
        if (listZzc.isEmpty()) {
            List<L> zzbccVar = listZzc instanceof zzbcd ? new zzbcc(i) : new ArrayList<>(i);
            zzbek.zza(obj, j, zzbccVar);
            return zzbccVar;
        }
        if (zzdvs.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList = new ArrayList(listZzc.size() + i);
            arrayList.addAll(listZzc);
            zzbek.zza(obj, j, arrayList);
            return arrayList;
        }
        if (!(listZzc instanceof zzbeh)) {
            return listZzc;
        }
        zzbcc zzbccVar2 = new zzbcc(listZzc.size() + i);
        zzbccVar2.addAll((zzbeh) listZzc);
        zzbek.zza(obj, j, zzbccVar2);
        return zzbccVar2;
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzbek.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbce
    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzbce
    final <E> void zza(Object obj, Object obj2, long j) {
        List listZzc = zzc(obj2, j);
        List listZza = zza(obj, j, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size > 0) {
            listZzc = listZza;
        }
        zzbek.zza(obj, j, listZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbce
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzbek.zzp(obj, j);
        if (list instanceof zzbcd) {
            objUnmodifiableList = ((zzbcd) list).zzadx();
        } else if (zzdvs.isAssignableFrom(list.getClass())) {
            return;
        } else {
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzbek.zza(obj, j, objUnmodifiableList);
    }
}
