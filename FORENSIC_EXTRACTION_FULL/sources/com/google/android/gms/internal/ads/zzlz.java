package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzlz extends zzkd {
    private final /* synthetic */ zzly zzatc;

    zzlz(zzly zzlyVar) {
        this.zzatc = zzlyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkd, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        this.zzatc.zzasv.zza(this.zzatc.zzbc());
        super.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkd, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.zzatc.zzasv.zza(this.zzatc.zzbc());
        super.onAdLoaded();
    }
}
