package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzev implements Runnable {
    private final /* synthetic */ zzes zzasu;
    private final /* synthetic */ zzaj zzasv;

    zzev(zzes zzesVar, zzaj zzajVar) {
        this.zzasu = zzesVar;
        this.zzasv = zzajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzasu) {
            zzes.zza(this.zzasu, false);
            if (!this.zzasu.zzasl.isConnected()) {
                this.zzasu.zzasl.zzgt().zzjn().zzby("Connected to remote service");
                this.zzasu.zzasl.zza(this.zzasv);
            }
        }
    }
}
