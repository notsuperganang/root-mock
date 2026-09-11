package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzej implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zzagg;
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzeb zzasl;

    zzej(zzeb zzebVar, zzag zzagVar, String str, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zzasl = zzebVar;
        this.zzagi = zzagVar;
        this.zzagj = str;
        this.zzagg = zzdqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrZza = null;
        try {
            try {
                zzaj zzajVar = this.zzasl.zzasf;
                if (zzajVar == null) {
                    this.zzasl.zzgt().zzjg().zzby("Discarding data. Failed to send event to service to bundle");
                    this.zzasl.zzgr().zza(this.zzagg, (byte[]) null);
                } else {
                    bArrZza = zzajVar.zza(this.zzagi, this.zzagj);
                    this.zzasl.zzcy();
                    this.zzasl.zzgr().zza(this.zzagg, bArrZza);
                }
            } catch (RemoteException e) {
                this.zzasl.zzgt().zzjg().zzg("Failed to send event to the service to bundle", e);
                this.zzasl.zzgr().zza(this.zzagg, bArrZza);
            }
        } catch (Throwable th) {
            this.zzasl.zzgr().zza(this.zzagg, bArrZza);
            throw th;
        }
    }
}
