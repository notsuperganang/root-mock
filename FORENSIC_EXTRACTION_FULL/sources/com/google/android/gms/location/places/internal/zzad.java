package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import java.util.Locale;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class zzad extends GmsClient<zzs> {
    private final Locale locale;
    private final zzat zzgc;

    private zzad(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 67, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.locale = Locale.getDefault();
        this.zzgc = new zzat(str, this.locale, clientSettings.getAccount() != null ? clientSettings.getAccount().name : null, null, 0);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
        return iInterfaceQueryLocalInterface instanceof zzs ? (zzs) iInterfaceQueryLocalInterface : new zzt(iBinder);
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, @Nullable PlaceFilter placeFilter) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzz();
        }
        ((zzs) getService()).zzb(placeFilter, this.zzgc, zzmVar);
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, PlaceReport placeReport) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        ((zzs) getService()).zzb(placeReport, this.zzgc, zzmVar);
    }
}
