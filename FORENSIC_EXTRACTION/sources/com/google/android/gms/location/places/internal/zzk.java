package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
final class zzk extends com.google.android.gms.location.places.zzg<zzp> {
    private final /* synthetic */ String zzft;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzk(zzi zziVar, Api api, GoogleApiClient googleApiClient, String str) {
        super(api, googleApiClient);
        this.zzft = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzp) anyClient).zzb(new com.google.android.gms.location.places.zze(this), this.zzft);
    }
}
