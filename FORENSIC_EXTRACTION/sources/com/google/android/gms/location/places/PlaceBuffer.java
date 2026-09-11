package com.google.android.gms.location.places;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzas;

/* JADX INFO: loaded from: classes.dex */
public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {
    private final Status zzdz;
    private final String zzea;

    public PlaceBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzdz = PlacesStatusCodes.zze(dataHolder.getStatusCode());
        if (dataHolder == null || dataHolder.getMetadata() == null) {
            this.zzea = null;
        } else {
            this.zzea = dataHolder.getMetadata().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public Place get(int i) {
        return new zzas(this.mDataHolder, i);
    }

    @Nullable
    public CharSequence getAttributions() {
        return this.zzea;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzdz;
    }
}
