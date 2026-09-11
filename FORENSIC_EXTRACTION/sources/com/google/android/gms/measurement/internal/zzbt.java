package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class zzbt implements Thread.UncaughtExceptionHandler {
    private final String zzapd;
    private final /* synthetic */ zzbr zzape;

    public zzbt(zzbr zzbrVar, String str) {
        this.zzape = zzbrVar;
        Preconditions.checkNotNull(str);
        this.zzapd = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (this) {
            this.zzape.zzgt().zzjg().zzg(this.zzapd, th);
        }
    }
}
