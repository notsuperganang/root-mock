package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzeq implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zzagg;
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;

    zzeq(zzeb zzebVar, String str, String str2, boolean z, zzk zzkVar, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zzasl = zzebVar;
        this.zzads = str;
        this.zzadz = str2;
        this.zzaeg = z;
        this.zzaqn = zzkVar;
        this.zzagg = zzdqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            try {
                zzaj zzajVar = this.zzasl.zzasf;
                if (zzajVar == null) {
                    this.zzasl.zzgt().zzjg().zze("Failed to get user properties", this.zzads, this.zzadz);
                    this.zzasl.zzgr().zza(this.zzagg, bundle);
                } else {
                    bundle = zzfx.zzd(zzajVar.zza(this.zzads, this.zzadz, this.zzaeg, this.zzaqn));
                    this.zzasl.zzcy();
                    this.zzasl.zzgr().zza(this.zzagg, bundle);
                }
            } catch (RemoteException e) {
                this.zzasl.zzgt().zzjg().zze("Failed to get user properties", this.zzads, e);
                this.zzasl.zzgr().zza(this.zzagg, bundle);
            }
        } catch (Throwable th) {
            this.zzasl.zzgr().zza(this.zzagg, bundle);
            throw th;
        }
    }
}
