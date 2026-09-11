package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzm extends com.google.android.gms.location.places.zzm.zzd<zzp> {
    private final /* synthetic */ String[] zzfy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzm(zzi zziVar, Api api, GoogleApiClient googleApiClient, String[] strArr) {
        super(api, googleApiClient);
        this.zzfy = strArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzp) anyClient).zzb(new com.google.android.gms.location.places.zzm(this), Arrays.asList(this.zzfy));
    }
}
