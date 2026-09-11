package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzmp implements Runnable {
    private final /* synthetic */ zzmo zzatm;

    zzmp(zzmo zzmoVar) {
        this.zzatm = zzmoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzatm.zzatl != null) {
            try {
                this.zzatm.zzatl.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzane.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
