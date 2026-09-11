package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlaceExtendedDetailsEntityCreator")
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();

    @SafeParcelable.Field(getter = "getPlaceTypes", id = 1)
    private final List<Integer> zzdq;

    @SafeParcelable.Field(getter = "getPhoneNumber", id = 2)
    private final String zzdr;

    @SafeParcelable.Field(getter = "getWebsiteUri", id = 3)
    private final Uri zzds;

    @SafeParcelable.Field(getter = "getRating", id = 4)
    private final float zzgk;

    @SafeParcelable.Field(getter = "getPriceLevel", id = 5)
    private final int zzgl;

    @SafeParcelable.Constructor
    zzah(@SafeParcelable.Param(id = 1) List<Integer> list, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) Uri uri, @SafeParcelable.Param(id = 4) float f, @SafeParcelable.Param(id = 5) int i) {
        this.zzdq = Collections.unmodifiableList(list);
        this.zzdr = str;
        this.zzds = uri;
        this.zzgk = f;
        this.zzgl = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.zzdq, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdr, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzds, i, false);
        SafeParcelWriter.writeFloat(parcel, 4, this.zzgk);
        SafeParcelWriter.writeInt(parcel, 5, this.zzgl);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
