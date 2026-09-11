package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzel implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;

    zzel(zzeb zzebVar, zzk zzkVar) {
        this.zzasl = zzebVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar = this.zzasl.zzasf;
        if (zzajVar == null) {
            this.zzasl.zzgt().zzjg().zzby("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzajVar.zzb(this.zzaqn);
            this.zzasl.zzcy();
        } catch (RemoteException e) {
            this.zzasl.zzgt().zzjg().zzg("Failed to send measurementEnabled to the service", e);
        }
    }
}
