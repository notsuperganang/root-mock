package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzadc implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzcca;
    private final /* synthetic */ zzadb zzccb;

    zzadc(zzadb zzadbVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzccb = zzadbVar;
        this.zzcca = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzccb.zza(thread, th);
        } catch (Throwable th2) {
            zzane.e("AdMob exception reporter failed reporting the exception.");
        } finally {
            if (this.zzcca != null) {
                this.zzcca.uncaughtException(thread, th);
            }
        }
    }
}
