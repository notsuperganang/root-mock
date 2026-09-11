package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzzq implements zzatd<Object, Object> {
    private final /* synthetic */ zzzf zzbvj;
    private final /* synthetic */ zzxt zzbvk;

    zzzq(zzzp zzzpVar, zzzf zzzfVar, zzxt zzxtVar) {
        this.zzbvj = zzzfVar;
        this.zzbvk = zzxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatd
    public final void zzau(String str) {
        try {
            this.zzbvj.zzbr(str);
        } catch (RemoteException e) {
            zzane.zzb("", e);
        }
    }
}
