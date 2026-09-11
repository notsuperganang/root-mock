package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.location.places.PlacesOptions;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends Api.AbstractClientBuilder<zzp, PlacesOptions> {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        PlacesOptions placesOptions2 = placesOptions;
        return new zzp(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener, context.getPackageName(), placesOptions2 == null ? new PlacesOptions.Builder().build() : placesOptions2);
    }
}
