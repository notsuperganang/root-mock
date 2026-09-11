package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzfb implements Runnable {
    private final /* synthetic */ Runnable zzacf;
    private final /* synthetic */ zzfn zzata;

    zzfb(zzey zzeyVar, zzfn zzfnVar, Runnable runnable) {
        this.zzata = zzfnVar;
        this.zzacf = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzata.zzme();
        this.zzata.zzg(this.zzacf);
        this.zzata.zzlz();
    }
}
