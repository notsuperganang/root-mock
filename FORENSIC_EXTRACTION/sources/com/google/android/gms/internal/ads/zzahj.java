package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzahj extends zzahf {

    @Nullable
    private RewardedVideoAdListener zzhc;

    public zzahj(@Nullable RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzhc = rewardedVideoAdListener;
    }

    @Nullable
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        return this.zzhc;
    }

    @Override // com.google.android.gms.internal.ads.zzahe
    public final void onRewardedVideoAdClosed() {
        if (this.zzhc != null) {
            this.zzhc.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahe
    public final void onRewardedVideoAdFailedToLoad(int i) {
        if (this.zzhc != null) {
            this.zzhc.onRewardedVideoAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahe
    public final void onRewardedVideoAdLeftApplication() {
        if (this.zzhc != null) {
            this.zzhc.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahe
    public final void onRewardedVideoAdLoaded() {
        if (this.zzhc != null) {
            this.zzhc.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahe
    public final void onRewardedVideoAdOpened() {
        if (this.zzhc != null) {
            this.zzhc.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahe
    public final void onRewardedVideoCompleted() {
        if (this.zzhc != null) {
            this.zzhc.onRewardedVideoCompleted();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahe
    public final void onRewardedVideoStarted() {
        if (this.zzhc != null) {
            this.zzhc.onRewardedVideoStarted();
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzhc = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzahe
    public final void zza(zzagu zzaguVar) {
        if (this.zzhc != null) {
            this.zzhc.onRewarded(new zzahh(zzaguVar));
        }
    }
}
