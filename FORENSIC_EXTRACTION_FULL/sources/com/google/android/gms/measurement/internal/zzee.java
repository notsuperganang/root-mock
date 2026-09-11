package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzee implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;

    zzee(zzeb zzebVar, zzk zzkVar) {
        this.zzasl = zzebVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar = this.zzasl.zzasf;
        if (zzajVar == null) {
            this.zzasl.zzgt().zzjg().zzby("Failed to reset data on the service; null service");
            return;
        }
        try {
            zzajVar.zzd(this.zzaqn);
        } catch (RemoteException e) {
            this.zzasl.zzgt().zzjg().zzg("Failed to reset data on the service", e);
        }
        this.zzasl.zzcy();
    }
}
