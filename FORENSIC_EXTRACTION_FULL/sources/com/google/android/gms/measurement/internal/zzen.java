package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class zzen implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;
    private final /* synthetic */ boolean zzasn;
    private final /* synthetic */ boolean zzaso;
    private final /* synthetic */ zzo zzasp;
    private final /* synthetic */ zzo zzasq;

    zzen(zzeb zzebVar, boolean z, boolean z2, zzo zzoVar, zzk zzkVar, zzo zzoVar2) {
        this.zzasl = zzebVar;
        this.zzasn = z;
        this.zzaso = z2;
        this.zzasp = zzoVar;
        this.zzaqn = zzkVar;
        this.zzasq = zzoVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar = this.zzasl.zzasf;
        if (zzajVar == null) {
            this.zzasl.zzgt().zzjg().zzby("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zzasn) {
            this.zzasl.zza(zzajVar, this.zzaso ? null : this.zzasp, this.zzaqn);
        } else {
            try {
                if (TextUtils.isEmpty(this.zzasq.packageName)) {
                    zzajVar.zza(this.zzasp, this.zzaqn);
                } else {
                    zzajVar.zzb(this.zzasp);
                }
            } catch (RemoteException e) {
                this.zzasl.zzgt().zzjg().zzg("Failed to send conditional user property to the service", e);
            }
        }
        this.zzasl.zzcy();
    }
}
