package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlaceLikelihoodEntityCreator")
@SafeParcelable.Reserved({1000})
public final class zzaj extends AbstractSafeParcelable implements PlaceLikelihood {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();

    @SafeParcelable.Field(id = 1)
    private final PlaceEntity zzgs;

    @SafeParcelable.Field(id = 2)
    private final float zzgt;

    @SafeParcelable.Constructor
    zzaj(@SafeParcelable.Param(id = 1) PlaceEntity placeEntity, @SafeParcelable.Param(id = 2) float f) {
        this.zzgs = placeEntity;
        this.zzgt = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzajVar = (zzaj) obj;
        return this.zzgs.equals(zzajVar.zzgs) && this.zzgt == zzajVar.zzgt;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ PlaceLikelihood freeze() {
        if (this == null) {
            throw null;
        }
        return this;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public final float getLikelihood() {
        return this.zzgt;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public final Place getPlace() {
        return this.zzgs;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzgs, Float.valueOf(this.zzgt));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("place", this.zzgs).add("likelihood", Float.valueOf(this.zzgt)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzgs, i, false);
        SafeParcelWriter.writeFloat(parcel, 2, this.zzgt);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
