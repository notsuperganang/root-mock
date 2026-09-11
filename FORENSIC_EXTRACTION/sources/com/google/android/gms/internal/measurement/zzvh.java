package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzvh extends zzvf {
    private static final Class<?> zzcae = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzvh() {
        super();
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> listZzal;
        List<L> listZzc = zzc(obj, j);
        if (listZzc.isEmpty()) {
            if (listZzc instanceof zzve) {
                listZzal = new zzvd(i);
            } else {
                listZzal = ((listZzc instanceof zzwg) && (listZzc instanceof zzuu)) ? ((zzuu) listZzc).zzal(i) : new ArrayList<>(i);
            }
            zzxj.zza(obj, j, listZzal);
            return listZzal;
        }
        if (zzcae.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList = new ArrayList(listZzc.size() + i);
            arrayList.addAll(listZzc);
            zzxj.zza(obj, j, arrayList);
            return arrayList;
        }
        if (listZzc instanceof zzxg) {
            zzvd zzvdVar = new zzvd(listZzc.size() + i);
            zzvdVar.addAll((zzxg) listZzc);
            zzxj.zza(obj, j, zzvdVar);
            return zzvdVar;
        }
        if (!(listZzc instanceof zzwg) || !(listZzc instanceof zzuu) || ((zzuu) listZzc).zztz()) {
            return listZzc;
        }
        zzuu zzuuVarZzal = ((zzuu) listZzc).zzal(listZzc.size() + i);
        zzxj.zza(obj, j, zzuuVarZzal);
        return zzuuVarZzal;
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzxj.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzvf
    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.measurement.zzvf
    final <E> void zza(Object obj, Object obj2, long j) {
        List listZzc = zzc(obj2, j);
        List listZza = zza(obj, j, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size <= 0) {
            listZza = listZzc;
        }
        zzxj.zza(obj, j, listZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzvf
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzxj.zzp(obj, j);
        if (list instanceof zzve) {
            objUnmodifiableList = ((zzve) list).zzxc();
        } else {
            if (zzcae.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzwg) && (list instanceof zzuu)) {
                if (((zzuu) list).zztz()) {
                    ((zzuu) list).zzsw();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzxj.zza(obj, j, objUnmodifiableList);
    }
}
