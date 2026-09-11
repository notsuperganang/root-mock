package com.google.android.gms.internal.places;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzht extends zzhr {
    private static final Class<?> zzun = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzht() {
        super();
    }

    private static <L> List<L> zzb(Object obj, long j, int i) {
        List<L> listZzd = zzd(obj, j);
        if (listZzd.isEmpty()) {
            List<L> zzhpVar = listZzd instanceof zzhq ? new zzhp(i) : new ArrayList<>(i);
            zzjw.zzb(obj, j, zzhpVar);
            return zzhpVar;
        }
        if (zzun.isAssignableFrom(listZzd.getClass())) {
            ArrayList arrayList = new ArrayList(listZzd.size() + i);
            arrayList.addAll(listZzd);
            zzjw.zzb(obj, j, arrayList);
            return arrayList;
        }
        if (!(listZzd instanceof zzjt)) {
            return listZzd;
        }
        zzhp zzhpVar2 = new zzhp(listZzd.size() + i);
        zzhpVar2.addAll((zzjt) listZzd);
        zzjw.zzb(obj, j, zzhpVar2);
        return zzhpVar2;
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzjw.zzq(obj, j);
    }

    @Override // com.google.android.gms.internal.places.zzhr
    final <L> List<L> zzb(Object obj, long j) {
        return zzb(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.places.zzhr
    final <E> void zzb(Object obj, Object obj2, long j) {
        List listZzd = zzd(obj2, j);
        List listZzb = zzb(obj, j, listZzd.size());
        int size = listZzb.size();
        int size2 = listZzd.size();
        if (size > 0 && size2 > 0) {
            listZzb.addAll(listZzd);
        }
        if (size <= 0) {
            listZzb = listZzd;
        }
        zzjw.zzb(obj, j, listZzb);
    }

    @Override // com.google.android.gms.internal.places.zzhr
    final void zzc(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzjw.zzq(obj, j);
        if (list instanceof zzhq) {
            objUnmodifiableList = ((zzhq) list).zzel();
        } else if (zzun.isAssignableFrom(list.getClass())) {
            return;
        } else {
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzjw.zzb(obj, j, objUnmodifiableList);
    }
}
