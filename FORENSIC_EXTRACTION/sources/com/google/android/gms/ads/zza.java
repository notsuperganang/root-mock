package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class zza {
    public static AdView zza(Context context) {
        AdView adView = new AdView(context);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(zzx.zza());
        AdRequest adRequestBuild = new AdRequest.Builder().build();
        if (adView != null) {
            adView.loadAd(adRequestBuild);
        }
        return adView;
    }
}
