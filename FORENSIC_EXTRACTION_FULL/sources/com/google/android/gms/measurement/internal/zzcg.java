package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzcg implements Callable<List<zzo>> {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzby zzaqo;

    zzcg(zzby zzbyVar, zzk zzkVar, String str, String str2) {
        this.zzaqo = zzbyVar;
        this.zzaqn = zzkVar;
        this.zzads = str;
        this.zzadz = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzo> call() throws Exception {
        this.zzaqo.zzamx.zzme();
        return this.zzaqo.zzamx.zzjt().zzc(this.zzaqn.packageName, this.zzads, this.zzadz);
    }
}
