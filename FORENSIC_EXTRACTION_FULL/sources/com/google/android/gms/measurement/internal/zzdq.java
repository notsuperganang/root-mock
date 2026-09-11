package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzdq implements Runnable {
    private final /* synthetic */ boolean zzaed;
    private final /* synthetic */ zzda zzarh;

    zzdq(zzda zzdaVar, boolean z) {
        this.zzarh = zzdaVar;
        this.zzaed = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zzj(this.zzaed);
    }
}
