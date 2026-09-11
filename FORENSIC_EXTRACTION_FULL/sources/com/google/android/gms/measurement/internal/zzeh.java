package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
final class zzeh implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;

    zzeh(zzeb zzebVar, zzk zzkVar) {
        this.zzasl = zzebVar;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar = this.zzasl.zzasf;
        if (zzajVar == null) {
            this.zzasl.zzgt().zzjg().zzby("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzajVar.zza(this.zzaqn);
            this.zzasl.zza(zzajVar, (AbstractSafeParcelable) null, this.zzaqn);
            this.zzasl.zzcy();
        } catch (RemoteException e) {
            this.zzasl.zzgt().zzjg().zzg("Failed to send app launch to the service", e);
        }
    }
}
