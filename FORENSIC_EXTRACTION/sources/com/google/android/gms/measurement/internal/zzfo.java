package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzfo implements Runnable {
    private final /* synthetic */ zzfs zzauf;
    private final /* synthetic */ zzfn zzaug;

    zzfo(zzfn zzfnVar, zzfs zzfsVar) {
        this.zzaug = zzfnVar;
        this.zzauf = zzfsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaug.zza(this.zzauf);
        this.zzaug.start();
    }
}
