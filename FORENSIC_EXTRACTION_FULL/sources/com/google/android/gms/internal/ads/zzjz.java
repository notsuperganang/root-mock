package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
final class zzjz extends zzjr.zza<zzagz> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzxn zzars;
    private final /* synthetic */ zzjr zzart;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjz(zzjr zzjrVar, Context context, zzxn zzxnVar) {
        super();
        this.zzart = zzjrVar;
        this.val$context = context;
        this.zzars = zzxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzagz zza(zzld zzldVar) throws RemoteException {
        return zzldVar.createRewardedVideoAd(ObjectWrapper.wrap(this.val$context), this.zzars, 12451000);
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzagz zzib() throws RemoteException {
        zzagz zzagzVarZza = this.zzart.zzarn.zza(this.val$context, this.zzars);
        if (zzagzVarZza != null) {
            return zzagzVarZza;
        }
        zzjr zzjrVar = this.zzart;
        zzjr.zza(this.val$context, "rewarded_video");
        return new zzmo();
    }
}
