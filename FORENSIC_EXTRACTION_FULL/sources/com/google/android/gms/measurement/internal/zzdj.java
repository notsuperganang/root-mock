package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
final class zzdj implements Runnable {
    private final /* synthetic */ zzda zzarh;
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty zzaro;

    zzdj(zzda zzdaVar, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzarh = zzdaVar;
        this.zzaro = conditionalUserProperty;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zzc(this.zzaro);
    }
}
