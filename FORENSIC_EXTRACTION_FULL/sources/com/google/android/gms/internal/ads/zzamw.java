package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzamw extends Thread {
    private final /* synthetic */ String zzcce;

    zzamw(zzamv zzamvVar, String str) {
        this.zzcce = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzanf().zzcz(this.zzcce);
    }
}
