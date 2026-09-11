package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzcl implements Callable<byte[]> {
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaqo;

    zzcl(zzby zzbyVar, zzag zzagVar, String str) {
        this.zzaqo = zzbyVar;
        this.zzagi = zzagVar;
        this.zzagj = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        this.zzaqo.zzamx.zzme();
        return this.zzaqo.zzamx.zzlw().zzb(this.zzagi, this.zzagj);
    }
}
