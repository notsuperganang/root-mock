package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzfr implements Callable<String> {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzfn zzaug;

    zzfr(zzfn zzfnVar, zzk zzkVar) {
        this.zzaug = zzfnVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        zzg zzgVarZzg = this.zzaug.zzgv().zzba(this.zzaqn.packageName) ? this.zzaug.zzg(this.zzaqn) : this.zzaug.zzjt().zzbm(this.zzaqn.packageName);
        if (zzgVarZzg != null) {
            return zzgVarZzg.getAppInstanceId();
        }
        this.zzaug.zzgt().zzjj().zzby("App info was null when attempting to get app instance id");
        return null;
    }
}
