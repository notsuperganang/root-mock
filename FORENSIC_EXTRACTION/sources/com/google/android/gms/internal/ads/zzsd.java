package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzsd extends zzrm {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzblj;

    public zzsd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzblj = onUnifiedNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzrl
    public final void zza(zzrr zzrrVar) {
        this.zzblj.onUnifiedNativeAdLoaded(new zzru(zzrrVar));
    }
}
