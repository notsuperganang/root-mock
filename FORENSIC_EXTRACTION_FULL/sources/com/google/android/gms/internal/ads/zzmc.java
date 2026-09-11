package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzmc implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzmb zzath;

    zzmc(zzmb zzmbVar, Context context) {
        this.zzath = zzmbVar;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzath.getRewardedVideoAdInstance(this.val$context);
    }
}
