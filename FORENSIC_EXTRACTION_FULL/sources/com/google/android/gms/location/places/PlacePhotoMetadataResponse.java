package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Response;

/* JADX INFO: loaded from: classes.dex */
public class PlacePhotoMetadataResponse extends Response<PlacePhotoMetadataResult> {
    PlacePhotoMetadataResponse() {
    }

    public PlacePhotoMetadataBuffer getPhotoMetadata() {
        return getResult().getPhotoMetadata();
    }
}
