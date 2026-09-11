package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "BusinessHoursIntervalCreator")
@SafeParcelable.Reserved({1000})
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new zzf();

    @SafeParcelable.Field(id = 1)
    private final int zzgw;

    @SafeParcelable.Field(id = 2)
    private final int zzgx;

    @SafeParcelable.Constructor
    zzan(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2) {
        this.zzgw = i;
        this.zzgx = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzgw);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgx);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
