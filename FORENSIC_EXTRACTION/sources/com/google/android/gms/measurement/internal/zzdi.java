package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
final class zzdi implements Runnable {
    private final /* synthetic */ zzda zzarh;
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty zzaro;

    zzdi(zzda zzdaVar, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzarh = zzdaVar;
        this.zzaro = conditionalUserProperty;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zzb(this.zzaro);
    }
}
