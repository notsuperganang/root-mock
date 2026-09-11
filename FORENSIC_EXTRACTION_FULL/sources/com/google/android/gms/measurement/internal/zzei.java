package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzei implements Runnable {
    private final /* synthetic */ zzdx zzasd;
    private final /* synthetic */ zzeb zzasl;

    zzei(zzeb zzebVar, zzdx zzdxVar) {
        this.zzasl = zzebVar;
        this.zzasd = zzdxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar = this.zzasl.zzasf;
        if (zzajVar == null) {
            this.zzasl.zzgt().zzjg().zzby("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zzasd == null) {
                zzajVar.zza(0L, (String) null, (String) null, this.zzasl.getContext().getPackageName());
            } else {
                zzajVar.zza(this.zzasd.zzarr, this.zzasd.zzuw, this.zzasd.zzarq, this.zzasl.getContext().getPackageName());
            }
            this.zzasl.zzcy();
        } catch (RemoteException e) {
            this.zzasl.zzgt().zzjg().zzg("Failed to send current screen to the service", e);
        }
    }
}
