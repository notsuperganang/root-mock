package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
final class zzo extends com.google.android.gms.location.places.zzm.zzb<zzp> {
    private final /* synthetic */ String val$query;
    private final /* synthetic */ LatLngBounds zzfz;
    private final /* synthetic */ AutocompleteFilter zzgb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzo(zzi zziVar, Api api, GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        super(api, googleApiClient);
        this.val$query = str;
        this.zzfz = latLngBounds;
        this.zzgb = autocompleteFilter;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzp) anyClient).zzb(new com.google.android.gms.location.places.zzm(this), this.val$query, this.zzfz, 1, this.zzgb);
    }
}
