package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzmk implements Runnable {
    private final /* synthetic */ zzmj zzatk;

    zzmk(zzmj zzmjVar) {
        this.zzatk = zzmjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzatk.zzxs != null) {
            try {
                this.zzatk.zzxs.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzane.zzc("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
