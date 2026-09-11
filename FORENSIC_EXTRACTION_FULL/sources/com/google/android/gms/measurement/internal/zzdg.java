package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzdg implements Runnable {
    private final /* synthetic */ zzda zzarh;
    private final /* synthetic */ long zzarn;

    zzdg(zzda zzdaVar, long j) {
        this.zzarh = zzdaVar;
        this.zzarn = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzda zzdaVar = this.zzarh;
        long j = this.zzarn;
        zzdaVar.zzaf();
        zzdaVar.zzgg();
        zzdaVar.zzcl();
        zzdaVar.zzgt().zzjn().zzby("Resetting analytics data (FE)");
        zzdaVar.zzgo().zzln();
        if (zzdaVar.zzgv().zzbc(zzdaVar.zzgk().zzal())) {
            zzdaVar.zzgu().zzanh.set(j);
        }
        boolean zIsEnabled = zzdaVar.zzada.isEnabled();
        if (!zzdaVar.zzgv().zzhz()) {
            zzdaVar.zzgu().zzi(!zIsEnabled);
        }
        zzdaVar.zzgl().resetAnalyticsData();
        zzdaVar.zzarf = zIsEnabled ? false : true;
        if (this.zzarh.zzgv().zza(zzai.zzald)) {
            this.zzarh.zzgl().zza(new AtomicReference<>());
        }
    }
}
