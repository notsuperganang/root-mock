package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlaceOpeningHoursEntityCreator")
@SafeParcelable.Reserved({1000})
public final class zzam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzam> CREATOR = new zzap();

    @SafeParcelable.Field(id = 1)
    private final List<zzan> zzgu;

    @SafeParcelable.Field(id = 2)
    private final List<zzao> zzgv;

    @SafeParcelable.Constructor
    zzam(@SafeParcelable.Param(id = 1) List<zzan> list, @SafeParcelable.Param(id = 2) List<zzao> list2) {
        this.zzgu = Collections.unmodifiableList(list);
        this.zzgv = Collections.unmodifiableList(list2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zzgu, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzgv, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
