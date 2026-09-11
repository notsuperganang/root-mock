package com.google.android.gms.ads;

/* JADX INFO: loaded from: classes.dex */
public class Listeners extends AdListener {
    private static InterstitialAd Ad;

    public Listeners(InterstitialAd interstitialAd) {
        Ad = interstitialAd;
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i) {
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        Ad.show();
    }
}
