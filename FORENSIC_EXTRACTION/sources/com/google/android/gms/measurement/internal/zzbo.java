package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzbo implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbw zzaoh;
    private final /* synthetic */ zzas zzaoi;
    private final /* synthetic */ long zzaoj;
    private final /* synthetic */ Bundle zzaok;
    private final /* synthetic */ BroadcastReceiver.PendingResult zzrf;

    zzbo(zzbm zzbmVar, zzbw zzbwVar, long j, Bundle bundle, Context context, zzas zzasVar, BroadcastReceiver.PendingResult pendingResult) {
        this.zzaoh = zzbwVar;
        this.zzaoj = j;
        this.zzaok = bundle;
        this.val$context = context;
        this.zzaoi = zzasVar;
        this.zzrf = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j = this.zzaoh.zzgu().zzanh.get();
        long j2 = this.zzaoj;
        if (j > 0 && (j2 >= j || j2 <= 0)) {
            j2 = j - 1;
        }
        if (j2 > 0) {
            this.zzaok.putLong("click_timestamp", j2);
        }
        this.zzaok.putString("_cis", "referrer broadcast");
        zzbw.zza(this.val$context, (zzan) null).zzgj().logEvent("auto", "_cmp", this.zzaok);
        this.zzaoi.zzjo().zzby("Install campaign recorded");
        if (this.zzrf != null) {
            this.zzrf.finish();
        }
    }
}
