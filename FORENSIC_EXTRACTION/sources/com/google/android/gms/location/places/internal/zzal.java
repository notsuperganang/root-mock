package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

/* JADX INFO: loaded from: classes.dex */
public final class zzal extends zzav implements PlaceLikelihood {
    public zzal(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ PlaceLikelihood freeze() {
        PlaceEntity placeEntity = (PlaceEntity) getPlace().freeze();
        return new zzaj((PlaceEntity) Preconditions.checkNotNull(placeEntity), getLikelihood());
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public final float getLikelihood() {
        return zzb("place_likelihood", -1.0f);
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public final Place getPlace() {
        return new zzas(this.mDataHolder, this.mDataRow);
    }
}
