package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

/* JADX INFO: loaded from: classes.dex */
final class zzsc implements Runnable {
    private final /* synthetic */ PublisherAdView zzblg;
    private final /* synthetic */ zzks zzblh;
    private final /* synthetic */ zzsb zzbli;

    zzsc(zzsb zzsbVar, PublisherAdView publisherAdView, zzks zzksVar) {
        this.zzbli = zzsbVar;
        this.zzblg = publisherAdView;
        this.zzblh = zzksVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzblg.zza(this.zzblh)) {
            this.zzbli.zzblf.onPublisherAdViewLoaded(this.zzblg);
        } else {
            zzane.zzdk("Could not bind.");
        }
    }
}
