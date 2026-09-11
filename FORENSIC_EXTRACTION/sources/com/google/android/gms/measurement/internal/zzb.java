package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzb implements Runnable {
    private final /* synthetic */ String zzaee;
    private final /* synthetic */ long zzafe;
    private final /* synthetic */ zza zzaff;

    zzb(zza zzaVar, String str, long j) {
        this.zzaff = zzaVar;
        this.zzaee = str;
        this.zzafe = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaff.zza(this.zzaee, this.zzafe);
    }
}
