package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzck implements Runnable {
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaqo;

    zzck(zzby zzbyVar, zzag zzagVar, String str) {
        this.zzaqo = zzbyVar;
        this.zzagi = zzagVar;
        this.zzagj = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzaqo.zzamx.zzme();
        this.zzaqo.zzamx.zzd(this.zzagi, this.zzagj);
    }
}
