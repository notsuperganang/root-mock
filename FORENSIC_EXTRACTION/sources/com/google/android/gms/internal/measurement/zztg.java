package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zztg implements Comparator<zzte> {
    zztg() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzte zzteVar, zzte zzteVar2) {
        zzte zzteVar3 = zzteVar;
        zzte zzteVar4 = zzteVar2;
        zztl zztlVar = (zztl) zzteVar3.iterator();
        zztl zztlVar2 = (zztl) zzteVar4.iterator();
        while (zztlVar.hasNext() && zztlVar2.hasNext()) {
            int iCompare = Integer.compare(zzte.zza(zztlVar.nextByte()), zzte.zza(zztlVar2.nextByte()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzteVar3.size(), zzteVar4.size());
    }
}
