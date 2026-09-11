package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzmi implements Runnable {
    private final /* synthetic */ zzmh zzatj;

    zzmi(zzmh zzmhVar) {
        this.zzatj = zzmhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzatj.zzati.zzxs != null) {
            try {
                this.zzatj.zzati.zzxs.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzane.zzc("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
