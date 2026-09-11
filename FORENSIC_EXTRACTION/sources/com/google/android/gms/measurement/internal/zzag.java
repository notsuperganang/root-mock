package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();

    @SafeParcelable.Field(id = 2)
    public final String name;

    @SafeParcelable.Field(id = 4)
    public final String origin;

    @SafeParcelable.Field(id = 3)
    public final zzad zzahu;

    @SafeParcelable.Field(id = 5)
    public final long zzaig;

    zzag(zzag zzagVar, long j) {
        Preconditions.checkNotNull(zzagVar);
        this.name = zzagVar.name;
        this.zzahu = zzagVar.zzahu;
        this.origin = zzagVar.origin;
        this.zzaig = j;
    }

    @SafeParcelable.Constructor
    public zzag(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) zzad zzadVar, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) long j) {
        this.name = str;
        this.zzahu = zzadVar;
        this.origin = str2;
        this.zzaig = j;
    }

    public final String toString() {
        String str = this.origin;
        String str2 = this.name;
        String strValueOf = String.valueOf(this.zzahu);
        return new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(strValueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(strValueOf).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzahu, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.origin, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzaig);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
