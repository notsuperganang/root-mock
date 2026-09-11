package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzex implements Runnable {
    private final /* synthetic */ zzes zzasu;

    zzex(zzes zzesVar) {
        this.zzasu = zzesVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeb.zza(this.zzasu.zzasl, (zzaj) null);
        this.zzasu.zzasl.zzlj();
    }
}
