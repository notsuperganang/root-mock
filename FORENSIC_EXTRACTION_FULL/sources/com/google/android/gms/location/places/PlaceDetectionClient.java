package com.google.android.gms.location.places;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public class PlaceDetectionClient extends GoogleApi<PlacesOptions> {
    PlaceDetectionClient(@NonNull Activity activity, @NonNull PlacesOptions placesOptions) {
        super(activity, Places.PLACE_DETECTION_API, placesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @VisibleForTesting
    private PlaceDetectionClient(@NonNull Context context, @NonNull Api<PlacesOptions> api, @NonNull PlacesOptions placesOptions) {
        super(context, api, placesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    PlaceDetectionClient(@NonNull Context context, @NonNull PlacesOptions placesOptions) {
        this(context, Places.PLACE_DETECTION_API, placesOptions);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public Task<PlaceLikelihoodBufferResponse> getCurrentPlace(@Nullable PlaceFilter placeFilter) {
        return PendingResultUtil.toResponseTask(Places.PlaceDetectionApi.getCurrentPlace(asGoogleApiClient(), placeFilter), new PlaceLikelihoodBufferResponse());
    }

    public Task<Void> reportDeviceAtPlace(@NonNull PlaceReport placeReport) {
        return PendingResultUtil.toVoidTask(Places.PlaceDetectionApi.reportDeviceAtPlace(asGoogleApiClient(), placeReport));
    }
}
