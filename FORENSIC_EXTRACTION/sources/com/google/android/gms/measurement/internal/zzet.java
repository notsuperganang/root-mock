package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzet implements Runnable {
    private final /* synthetic */ zzaj zzast;
    private final /* synthetic */ zzes zzasu;

    zzet(zzes zzesVar, zzaj zzajVar) {
        this.zzasu = zzesVar;
        this.zzast = zzajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzasu) {
            zzes.zza(this.zzasu, false);
            if (!this.zzasu.zzasl.isConnected()) {
                this.zzasu.zzasl.zzgt().zzjo().zzby("Connected to service");
                this.zzasu.zzasl.zza(this.zzast);
            }
        }
    }
}
