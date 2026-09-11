package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzer implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzfu zzaqq;
    private final /* synthetic */ zzeb zzasl;
    private final /* synthetic */ boolean zzaso;

    zzer(zzeb zzebVar, boolean z, zzfu zzfuVar, zzk zzkVar) {
        this.zzasl = zzebVar;
        this.zzaso = z;
        this.zzaqq = zzfuVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar = this.zzasl.zzasf;
        if (zzajVar == null) {
            this.zzasl.zzgt().zzjg().zzby("Discarding data. Failed to set user attribute");
        } else {
            this.zzasl.zza(zzajVar, this.zzaso ? null : this.zzaqq, this.zzaqn);
            this.zzasl.zzcy();
        }
    }
}
