package com.google.android.gms.location.places;

import com.google.android.gms.location.places.internal.zzaj;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zzj implements Comparator<zzaj> {
    zzj() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzaj zzajVar, zzaj zzajVar2) {
        return -Float.compare(zzajVar.getLikelihood(), zzajVar2.getLikelihood());
    }
}
