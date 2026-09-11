package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
final class zzl extends com.google.android.gms.location.places.zzf<zzp> {
    private final /* synthetic */ String zzfu;
    private final /* synthetic */ int zzfv;
    private final /* synthetic */ int zzfw;
    private final /* synthetic */ int zzfx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzl(zzi zziVar, Api api, GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        super(api, googleApiClient);
        this.zzfu = str;
        this.zzfv = i;
        this.zzfw = i2;
        this.zzfx = i3;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzp) anyClient).zzb(new com.google.android.gms.location.places.zze(this), this.zzfu, this.zzfv, this.zzfw, this.zzfx);
    }
}
