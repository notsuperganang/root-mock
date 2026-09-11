package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlaceFilter;

/* JADX INFO: loaded from: classes.dex */
final class zzab extends com.google.android.gms.location.places.zzm.zze<zzad> {
    private final /* synthetic */ PlaceFilter zzgd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzab(zzaa zzaaVar, Api api, GoogleApiClient googleApiClient, PlaceFilter placeFilter) {
        super(api, googleApiClient);
        this.zzgd = placeFilter;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzad) anyClient).zzb(new com.google.android.gms.location.places.zzm(this), this.zzgd);
    }
}
