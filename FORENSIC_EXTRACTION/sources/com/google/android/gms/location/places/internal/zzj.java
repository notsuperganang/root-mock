package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AddPlaceRequest;

/* JADX INFO: loaded from: classes.dex */
final class zzj extends com.google.android.gms.location.places.zzm.zzd<zzp> {
    private final /* synthetic */ AddPlaceRequest zzfs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzj(zzi zziVar, Api api, GoogleApiClient googleApiClient, AddPlaceRequest addPlaceRequest) {
        super(api, googleApiClient);
        this.zzfs = addPlaceRequest;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzp) anyClient).zzb(new com.google.android.gms.location.places.zzm(this), this.zzfs);
    }
}
