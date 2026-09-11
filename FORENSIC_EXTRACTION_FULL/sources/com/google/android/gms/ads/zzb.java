package com.google.android.gms.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class zzb {
    public static AdView zza(Context context) {
        AdView adView = new AdView(context);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        AdRequest adRequestBuild = new AdRequest.Builder().build();
        if (adView != null) {
            adView.loadAd(adRequestBuild);
        }
        return adView;
    }
}
