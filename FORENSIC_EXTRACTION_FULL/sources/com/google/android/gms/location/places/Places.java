package com.google.android.gms.location.places;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.places.internal.zzaa;
import com.google.android.gms.location.places.internal.zzad;
import com.google.android.gms.location.places.internal.zzaf;
import com.google.android.gms.location.places.internal.zzr;

/* JADX INFO: loaded from: classes.dex */
public class Places {
    private static final Api.ClientKey<com.google.android.gms.location.places.internal.zzp> zzev = new Api.ClientKey<>();
    private static final Api.ClientKey<zzad> zzew = new Api.ClientKey<>();
    public static final Api<PlacesOptions> GEO_DATA_API = new Api<>("Places.GEO_DATA_API", new zzr(), zzev);
    public static final Api<PlacesOptions> PLACE_DETECTION_API = new Api<>("Places.PLACE_DETECTION_API", new zzaf(), zzew);
    public static final GeoDataApi GeoDataApi = new com.google.android.gms.location.places.internal.zzi();
    public static final PlaceDetectionApi PlaceDetectionApi = new zzaa();

    private Places() {
    }

    public static GeoDataClient getGeoDataClient(@NonNull Activity activity) {
        return getGeoDataClient(activity, (PlacesOptions) null);
    }

    @Deprecated
    public static GeoDataClient getGeoDataClient(@NonNull Activity activity, @Nullable PlacesOptions placesOptions) {
        if (placesOptions == null) {
            placesOptions = new PlacesOptions.Builder().build();
        }
        return new GeoDataClient(activity, placesOptions);
    }

    public static GeoDataClient getGeoDataClient(@NonNull Context context) {
        return getGeoDataClient(context, (PlacesOptions) null);
    }

    @Deprecated
    public static GeoDataClient getGeoDataClient(@NonNull Context context, @Nullable PlacesOptions placesOptions) {
        if (placesOptions == null) {
            placesOptions = new PlacesOptions.Builder().build();
        }
        return new GeoDataClient(context, placesOptions);
    }

    public static PlaceDetectionClient getPlaceDetectionClient(@NonNull Activity activity) {
        return getPlaceDetectionClient(activity, (PlacesOptions) null);
    }

    @Deprecated
    public static PlaceDetectionClient getPlaceDetectionClient(@NonNull Activity activity, @Nullable PlacesOptions placesOptions) {
        if (placesOptions == null) {
            placesOptions = new PlacesOptions.Builder().build();
        }
        return new PlaceDetectionClient(activity, placesOptions);
    }

    public static PlaceDetectionClient getPlaceDetectionClient(@NonNull Context context) {
        return getPlaceDetectionClient(context, (PlacesOptions) null);
    }

    @Deprecated
    public static PlaceDetectionClient getPlaceDetectionClient(@NonNull Context context, @Nullable PlacesOptions placesOptions) {
        if (placesOptions == null) {
            placesOptions = new PlacesOptions.Builder().build();
        }
        return new PlaceDetectionClient(context, placesOptions);
    }
}
