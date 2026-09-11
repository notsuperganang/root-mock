package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzdr implements Runnable {
    private final /* synthetic */ boolean zzaed;
    private final /* synthetic */ zzda zzarh;

    zzdr(zzda zzdaVar, boolean z) {
        this.zzarh = zzdaVar;
        this.zzaed = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zIsEnabled = this.zzarh.zzada.isEnabled();
        boolean zZzks = this.zzarh.zzada.zzks();
        this.zzarh.zzada.zzd(this.zzaed);
        if (zZzks == this.zzaed) {
            this.zzarh.zzada.zzgt().zzjo().zzg("Default data collection state already set to", Boolean.valueOf(this.zzaed));
        }
        if (this.zzarh.zzada.isEnabled() == zIsEnabled || this.zzarh.zzada.isEnabled() != this.zzarh.zzada.zzks()) {
            this.zzarh.zzada.zzgt().zzjl().zze("Default data collection is different than actual status", Boolean.valueOf(this.zzaed), Boolean.valueOf(zIsEnabled));
        }
        this.zzarh.zzlc();
    }
}
