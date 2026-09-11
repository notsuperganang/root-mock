package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class zzem implements Runnable {
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;
    private final /* synthetic */ boolean zzasn;
    private final /* synthetic */ boolean zzaso;

    zzem(zzeb zzebVar, boolean z, boolean z2, zzag zzagVar, zzk zzkVar, String str) {
        this.zzasl = zzebVar;
        this.zzasn = z;
        this.zzaso = z2;
        this.zzagi = zzagVar;
        this.zzaqn = zzkVar;
        this.zzagj = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar = this.zzasl.zzasf;
        if (zzajVar == null) {
            this.zzasl.zzgt().zzjg().zzby("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zzasn) {
            this.zzasl.zza(zzajVar, this.zzaso ? null : this.zzagi, this.zzaqn);
        } else {
            try {
                if (TextUtils.isEmpty(this.zzagj)) {
                    zzajVar.zza(this.zzagi, this.zzaqn);
                } else {
                    zzajVar.zza(this.zzagi, this.zzagj, this.zzasl.zzgt().zzjq());
                }
            } catch (RemoteException e) {
                this.zzasl.zzgt().zzjg().zzg("Failed to send event to the service", e);
            }
        }
        this.zzasl.zzcy();
    }
}
