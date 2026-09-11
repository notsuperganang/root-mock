package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzz implements Runnable {
    private final /* synthetic */ zzct zzaho;
    private final /* synthetic */ zzy zzahp;

    zzz(zzy zzyVar, zzct zzctVar) {
        this.zzahp = zzyVar;
        this.zzaho = zzctVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaho.zzgw();
        if (zzn.isMainThread()) {
            this.zzaho.zzgs().zzc(this);
            return;
        }
        boolean zZzej = this.zzahp.zzej();
        zzy.zza(this.zzahp, 0L);
        if (zZzej) {
            this.zzahp.run();
        }
    }
}
