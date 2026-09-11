package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzeg implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zzagg;
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;

    zzeg(zzeb zzebVar, zzk zzkVar, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zzasl = zzebVar;
        this.zzaqn = zzkVar;
        this.zzagg = zzdqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                zzaj zzajVar = this.zzasl.zzasf;
                if (zzajVar == null) {
                    this.zzasl.zzgt().zzjg().zzby("Failed to get app instance id");
                    this.zzasl.zzgr().zzb(this.zzagg, null);
                    return;
                }
                String strZzc = zzajVar.zzc(this.zzaqn);
                if (strZzc != null) {
                    this.zzasl.zzgj().zzcp(strZzc);
                    this.zzasl.zzgu().zzanj.zzcd(strZzc);
                }
                this.zzasl.zzcy();
                this.zzasl.zzgr().zzb(this.zzagg, strZzc);
            } catch (RemoteException e) {
                this.zzasl.zzgt().zzjg().zzg("Failed to get app instance id", e);
                this.zzasl.zzgr().zzb(this.zzagg, null);
            }
        } catch (Throwable th) {
            this.zzasl.zzgr().zzb(this.zzagg, null);
            throw th;
        }
    }
}
