package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzv;
import com.tiket.git.base;

/* JADX INFO: loaded from: classes.dex */
public class zzc {
    public static void zza(Context context) {
        if (zzv.zzc().getBoolean(base.opsi[44], true)) {
            InterstitialAd interstitialAd = new InterstitialAd(context);
            interstitialAd.setAdUnitId(zzx.zzb());
            interstitialAd.loadAd(new AdRequest.Builder().build());
            interstitialAd.setAdListener(new Listeners(interstitialAd));
            if (interstitialAd.isLoaded()) {
                interstitialAd.show();
            }
        }
    }
}
