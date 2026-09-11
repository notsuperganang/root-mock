package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzd {
    final Intent intent;
    private final BroadcastReceiver.PendingResult zzu;
    private boolean zzv = false;
    private final ScheduledFuture<?> zzw;

    zzd(final Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.intent = intent;
        this.zzu = pendingResult;
        this.zzw = scheduledExecutorService.schedule(new Runnable(this, intent) { // from class: com.google.firebase.iid.zze
            private final zzd zzx;
            private final Intent zzy;

            {
                this.zzx = this;
                this.zzy = intent;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzd zzdVar = this.zzx;
                String action = this.zzy.getAction();
                Log.w("EnhancedIntentService", new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.").toString());
                zzdVar.finish();
            }
        }, 9000L, TimeUnit.MILLISECONDS);
    }

    final void finish() {
        synchronized (this) {
            if (!this.zzv) {
                this.zzu.finish();
                this.zzw.cancel(false);
                this.zzv = true;
            }
        }
    }
}
