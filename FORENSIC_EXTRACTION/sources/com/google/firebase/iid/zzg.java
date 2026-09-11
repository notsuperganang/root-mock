package com.google.firebase.iid;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzg implements Runnable {
    private final /* synthetic */ zzd zzaa;
    private final /* synthetic */ zzf zzab;

    zzg(zzf zzfVar, zzd zzdVar) {
        this.zzab = zzfVar;
        this.zzaa = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.zzab.zzz.zzd(this.zzaa.intent);
        this.zzaa.finish();
    }
}
