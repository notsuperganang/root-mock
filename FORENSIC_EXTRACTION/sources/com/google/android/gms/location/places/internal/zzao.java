package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "ExceptionalHoursCreator")
@SafeParcelable.Reserved({1000})
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzg();

    @SafeParcelable.Field(id = 4)
    private final int endYear;

    @SafeParcelable.Field(id = 1)
    private final int startYear;

    @SafeParcelable.Field(id = 2)
    private final int zzgy;

    @SafeParcelable.Field(id = 3)
    private final int zzgz;

    @SafeParcelable.Field(id = 5)
    private final int zzha;

    @SafeParcelable.Field(id = 6)
    private final int zzhb;

    @SafeParcelable.Field(id = 7)
    private final List<zzan> zzhc;

    @SafeParcelable.Constructor
    zzao(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) int i5, @SafeParcelable.Param(id = 6) int i6, @SafeParcelable.Param(id = 7) List<zzan> list) {
        this.startYear = i;
        this.zzgy = i2;
        this.zzgz = i3;
        this.endYear = i4;
        this.zzha = i5;
        this.zzhb = i6;
        this.zzhc = Collections.unmodifiableList(list);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.startYear);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgy);
        SafeParcelWriter.writeInt(parcel, 3, this.zzgz);
        SafeParcelWriter.writeInt(parcel, 4, this.endYear);
        SafeParcelWriter.writeInt(parcel, 5, this.zzha);
        SafeParcelWriter.writeInt(parcel, 6, this.zzhb);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zzhc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
