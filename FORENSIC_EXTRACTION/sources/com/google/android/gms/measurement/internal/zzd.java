package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzd implements Runnable {
    private final /* synthetic */ zza zzaff;
    private final /* synthetic */ long zzafg;

    zzd(zza zzaVar, long j) {
        this.zzaff = zzaVar;
        this.zzafg = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaff.zzn(this.zzafg);
    }
}
