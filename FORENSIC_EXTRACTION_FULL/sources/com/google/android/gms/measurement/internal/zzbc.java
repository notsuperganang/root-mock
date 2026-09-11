package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzbc implements Runnable {
    private final /* synthetic */ boolean zzamy;
    private final /* synthetic */ zzbb zzamz;

    zzbc(zzbb zzbbVar, boolean z) {
        this.zzamz = zzbbVar;
        this.zzamy = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzamz.zzamx.zzm(this.zzamy);
    }
}
