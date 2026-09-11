package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzds implements Runnable {
    private final /* synthetic */ zzda zzarh;
    private final /* synthetic */ long zzarp;

    zzds(zzda zzdaVar, long j) {
        this.zzarh = zzdaVar;
        this.zzarp = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zzgu().zzann.set(this.zzarp);
        this.zzarh.zzgt().zzjn().zzg("Minimum session duration set", Long.valueOf(this.zzarp));
    }
}
