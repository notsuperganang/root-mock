package com.google.android.gms.location.places;

import com.google.android.gms.common.api.DataBufferResponse;

/* JADX INFO: loaded from: classes.dex */
public class AutocompletePredictionBufferResponse extends DataBufferResponse<AutocompletePrediction, AutocompletePredictionBuffer> {
    AutocompletePredictionBufferResponse() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        return ((AutocompletePredictionBuffer) getResult()).toString();
    }
}
