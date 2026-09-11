package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlaceUserDataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public final class zzdn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdn> CREATOR = new zzdp();

    @SafeParcelable.Field(getter = "getPlaceId", id = 2)
    private final String placeId;

    @SafeParcelable.Field(getter = "getUserAccountName", id = 1)
    private final String zzcx;

    @SafeParcelable.Field(getter = "getPlaceAliases", id = 6)
    private final List<zzdl> zzhm;

    @SafeParcelable.Constructor
    zzdn(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 6) List<zzdl> list) {
        this.zzcx = str;
        this.placeId = str2;
        this.zzhm = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdn)) {
            return false;
        }
        zzdn zzdnVar = (zzdn) obj;
        return this.zzcx.equals(zzdnVar.zzcx) && this.placeId.equals(zzdnVar.placeId) && this.zzhm.equals(zzdnVar.zzhm);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzcx, this.placeId, this.zzhm);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("accountName", this.zzcx).add("placeId", this.placeId).add("placeAliases", this.zzhm).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcx, false);
        SafeParcelWriter.writeString(parcel, 2, this.placeId, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzhm, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
