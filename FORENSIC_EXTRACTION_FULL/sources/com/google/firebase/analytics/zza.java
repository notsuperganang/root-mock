package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zzbsq;

    zza(FirebaseAnalytics firebaseAnalytics) {
        this.zzbsq = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        String strZzgc = this.zzbsq.zzgc();
        if (strZzgc == null) {
            strZzgc = this.zzbsq.zzada.zzgj().zzag(120000L);
            if (strZzgc == null) {
                throw new TimeoutException();
            }
            this.zzbsq.zzcp(strZzgc);
        }
        return strZzgc;
    }
}
