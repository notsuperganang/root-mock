package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlaceAliasCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public final class zzdl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdl> CREATOR = new zzdm();
    private static final zzdl zzhj = new zzdl("Home");
    private static final zzdl zzhk = new zzdl("Work");

    @SafeParcelable.Field(getter = "getAlias", id = 1)
    private final String zzhl;

    @SafeParcelable.Constructor
    zzdl(@SafeParcelable.Param(id = 1) String str) {
        this.zzhl = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdl) {
            return Objects.equal(this.zzhl, ((zzdl) obj).zzhl);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzhl);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("alias", this.zzhl).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhl, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
