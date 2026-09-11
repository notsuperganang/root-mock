package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzdt implements Runnable {
    private final /* synthetic */ zzda zzarh;
    private final /* synthetic */ long zzarp;

    zzdt(zzda zzdaVar, long j) {
        this.zzarh = zzdaVar;
        this.zzarp = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zzgu().zzano.set(this.zzarp);
        this.zzarh.zzgt().zzjn().zzg("Session timeout duration set", Long.valueOf(this.zzarp));
    }
}
