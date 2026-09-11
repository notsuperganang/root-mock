package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzade implements Runnable {
    private final /* synthetic */ zzanf zzccd;
    private final /* synthetic */ String zzcce;

    zzade(zzadb zzadbVar, zzanf zzanfVar, String str) {
        this.zzccd = zzanfVar;
        this.zzcce = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzccd.zzcz(this.zzcce);
    }
}
