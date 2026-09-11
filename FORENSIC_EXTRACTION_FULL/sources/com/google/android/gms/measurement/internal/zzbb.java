package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
class zzbb extends BroadcastReceiver {

    @VisibleForTesting
    private static final String zzabi = zzbb.class.getName();
    private boolean zzabj;
    private boolean zzabk;
    private final zzfn zzamx;

    zzbb(zzfn zzfnVar) {
        Preconditions.checkNotNull(zzfnVar);
        this.zzamx = zzfnVar;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.zzamx.zzlx();
        String action = intent.getAction();
        this.zzamx.zzgt().zzjo().zzg("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.zzamx.zzgt().zzjj().zzg("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zZzfb = this.zzamx.zzlt().zzfb();
        if (this.zzabk != zZzfb) {
            this.zzabk = zZzfb;
            this.zzamx.zzgs().zzc(new zzbc(this, zZzfb));
        }
    }

    @WorkerThread
    public final void unregister() {
        this.zzamx.zzlx();
        this.zzamx.zzgs().zzaf();
        this.zzamx.zzgs().zzaf();
        if (this.zzabj) {
            this.zzamx.zzgt().zzjo().zzby("Unregistering connectivity change receiver");
            this.zzabj = false;
            this.zzabk = false;
            try {
                this.zzamx.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzamx.zzgt().zzjg().zzg("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @WorkerThread
    public final void zzey() {
        this.zzamx.zzlx();
        this.zzamx.zzgs().zzaf();
        if (this.zzabj) {
            return;
        }
        this.zzamx.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzabk = this.zzamx.zzlt().zzfb();
        this.zzamx.zzgt().zzjo().zzg("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzabk));
        this.zzabj = true;
    }
}
