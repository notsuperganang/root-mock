package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzco implements Callable<List<zzfw>> {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzby zzaqo;

    zzco(zzby zzbyVar, zzk zzkVar) {
        this.zzaqo = zzbyVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzfw> call() throws Exception {
        this.zzaqo.zzamx.zzme();
        return this.zzaqo.zzamx.zzjt().zzbl(this.zzaqn.packageName);
    }
}
