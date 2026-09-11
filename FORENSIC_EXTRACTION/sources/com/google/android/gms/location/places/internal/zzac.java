package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlaceReport;

/* JADX INFO: loaded from: classes.dex */
final class zzac extends com.google.android.gms.location.places.zzm.zzg<zzad> {
    private final /* synthetic */ PlaceReport zzge;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzac(zzaa zzaaVar, Api api, GoogleApiClient googleApiClient, PlaceReport placeReport) {
        super(api, googleApiClient);
        this.zzge = placeReport;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzad) anyClient).zzb(new com.google.android.gms.location.places.zzm(this), this.zzge);
    }
}
