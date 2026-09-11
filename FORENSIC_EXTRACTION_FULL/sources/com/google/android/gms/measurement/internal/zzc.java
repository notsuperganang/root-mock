package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzc implements Runnable {
    private final /* synthetic */ String zzaee;
    private final /* synthetic */ long zzafe;
    private final /* synthetic */ zza zzaff;

    zzc(zza zzaVar, String str, long j) {
        this.zzaff = zzaVar;
        this.zzaee = str;
        this.zzafe = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaff.zzb(this.zzaee, this.zzafe);
    }
}
