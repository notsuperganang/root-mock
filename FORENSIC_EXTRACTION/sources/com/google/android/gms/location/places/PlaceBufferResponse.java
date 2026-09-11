package com.google.android.gms.location.places;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.DataBufferResponse;

/* JADX INFO: loaded from: classes.dex */
public class PlaceBufferResponse extends DataBufferResponse<Place, PlaceBuffer> {
    PlaceBufferResponse() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public CharSequence getAttributions() {
        return ((PlaceBuffer) getResult()).getAttributions();
    }
}
