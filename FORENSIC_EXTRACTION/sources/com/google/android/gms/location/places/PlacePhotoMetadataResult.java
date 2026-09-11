package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlacePhotoMetadataResultCreator")
@SafeParcelable.Reserved({1000})
public class PlacePhotoMetadataResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzk();

    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status zzdz;

    @SafeParcelable.Field(id = 2)
    private final DataHolder zzep;
    private final PlacePhotoMetadataBuffer zzeq;

    @SafeParcelable.Constructor
    public PlacePhotoMetadataResult(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) DataHolder dataHolder) {
        this.zzdz = status;
        this.zzep = dataHolder;
        if (dataHolder == null) {
            this.zzeq = null;
        } else {
            this.zzeq = new PlacePhotoMetadataBuffer(this.zzep);
        }
    }

    public PlacePhotoMetadataBuffer getPhotoMetadata() {
        return this.zzeq;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzdz;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzep, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
