package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzp extends GmsClient<zzu> {
    private final zzat zzgc;

    private zzp(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 65, clientSettings, connectionCallbacks, onConnectionFailedListener);
        Locale locale = Locale.getDefault();
        if (placesOptions != null) {
        }
        this.zzgc = new zzat(str, locale, clientSettings.getAccount() != null ? clientSettings.getAccount().name : null, null, 0);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        return iInterfaceQueryLocalInterface instanceof zzu ? (zzu) iInterfaceQueryLocalInterface : new zzv(iBinder);
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    public final void zzb(com.google.android.gms.location.places.zze zzeVar, String str) throws RemoteException {
        Preconditions.checkNotNull(zzeVar, "callback cannot be null");
        ((zzu) getService()).zzb(str, this.zzgc, zzeVar);
    }

    public final void zzb(com.google.android.gms.location.places.zze zzeVar, String str, int i, int i2, int i3) throws RemoteException {
        Preconditions.checkNotNull(zzeVar, "callback cannot be null");
        ((zzu) getService()).zzb(str, i, i2, i3, this.zzgc, zzeVar);
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, AddPlaceRequest addPlaceRequest) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        ((zzu) getService()).zzb(addPlaceRequest, this.zzgc, zzmVar);
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, String str, @Nullable LatLngBounds latLngBounds, int i, @Nullable AutocompleteFilter autocompleteFilter) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        ((zzu) getService()).zzb(str == null ? "" : str, latLngBounds, i, autocompleteFilter == null ? new AutocompleteFilter.Builder().build() : autocompleteFilter, this.zzgc, zzmVar);
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, List<String> list) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        ((zzu) getService()).zzb(list, this.zzgc, zzmVar);
    }
}
