package com.google.android.gms.location.places.internal;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public final class zzi implements GeoDataApi {
    @Override // com.google.android.gms.location.places.GeoDataApi
    public final PendingResult<PlaceBuffer> addPlace(@NonNull GoogleApiClient googleApiClient, @NonNull AddPlaceRequest addPlaceRequest) {
        Preconditions.checkNotNull(addPlaceRequest, "userAddedPlace == null");
        return googleApiClient.execute(new zzj(this, Places.GEO_DATA_API, googleApiClient, addPlaceRequest));
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public final PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(@NonNull GoogleApiClient googleApiClient, @Nullable String str, @Nullable LatLngBounds latLngBounds, @Nullable AutocompleteFilter autocompleteFilter) {
        return googleApiClient.enqueue(new zzo(this, Places.GEO_DATA_API, googleApiClient, str, latLngBounds, autocompleteFilter));
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public final PendingResult<PlaceBuffer> getPlaceById(@NonNull GoogleApiClient googleApiClient, @NonNull String... strArr) {
        Preconditions.checkArgument(strArr != null, "placeIds == null");
        Preconditions.checkArgument(strArr.length > 0, "placeIds is empty");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Preconditions.checkArgument(str != null, "placeId == null");
            Preconditions.checkArgument(!str.isEmpty(), "placeId is empty");
        }
        return googleApiClient.enqueue(new zzm(this, Places.GEO_DATA_API, googleApiClient, strArr));
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public final PendingResult<PlacePhotoMetadataResult> getPlacePhotos(@NonNull GoogleApiClient googleApiClient, @NonNull String str) {
        Preconditions.checkNotNull(str, "placeId == null");
        Preconditions.checkArgument(!str.isEmpty(), "placeId is empty");
        return googleApiClient.enqueue(new zzk(this, Places.GEO_DATA_API, googleApiClient, str));
    }

    public final PendingResult<PlacePhotoResult> zzb(@NonNull GoogleApiClient googleApiClient, @NonNull PlacePhotoMetadata placePhotoMetadata, @IntRange(from = 1) int i, @IntRange(from = 1) int i2) {
        Preconditions.checkNotNull(placePhotoMetadata, "photo == null");
        Preconditions.checkArgument(i > 0, "width <= 0");
        Preconditions.checkArgument(i2 > 0, "height <= 0");
        zzaq zzaqVar = (zzaq) placePhotoMetadata.freeze();
        String strZzah = zzaqVar.zzah();
        int index = zzaqVar.getIndex();
        Preconditions.checkNotNull(strZzah, "fifeUrl == null");
        return googleApiClient.enqueue(new zzl(this, Places.GEO_DATA_API, googleApiClient, strZzah, i, i2, index));
    }

    public final PendingResult<AutocompletePredictionBuffer> zzb(GoogleApiClient googleApiClient, @Nullable String str, @Nullable LatLngBounds latLngBounds, int i, @Nullable AutocompleteFilter autocompleteFilter) {
        return googleApiClient.enqueue(new zzn(this, Places.GEO_DATA_API, googleApiClient, str, latLngBounds, i, autocompleteFilter));
    }
}
