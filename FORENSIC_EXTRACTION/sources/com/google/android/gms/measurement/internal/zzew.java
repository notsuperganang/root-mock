package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzew implements Runnable {
    private final /* synthetic */ zzes zzasu;

    zzew(zzes zzesVar) {
        this.zzasu = zzesVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeb zzebVar = this.zzasu.zzasl;
        Context context = this.zzasu.zzasl.getContext();
        this.zzasu.zzasl.zzgw();
        zzebVar.onServiceDisconnected(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
