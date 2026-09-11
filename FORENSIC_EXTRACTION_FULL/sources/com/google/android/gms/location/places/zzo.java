package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "UserDataTypeCreator")
@SafeParcelable.Reserved({1000})
public final class zzo extends AbstractSafeParcelable {

    @SafeParcelable.Field(id = 1)
    private final String type;

    @SafeParcelable.Field(id = 2)
    private final int zzfj;
    private static final zzo zzff = zzb("test_type", 1);
    private static final zzo zzfg = zzb("labeled_place", 6);
    private static final zzo zzfh = zzb("here_content", 7);
    private static final Set<zzo> zzfi = CollectionUtils.setOf(zzff, zzfg, zzfh);
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    @SafeParcelable.Constructor
    zzo(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i) {
        Preconditions.checkNotEmpty(str);
        this.type = str;
        this.zzfj = i;
    }

    private static zzo zzb(String str, int i) {
        return new zzo(str, i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzoVar = (zzo) obj;
        return this.type.equals(zzoVar.type) && this.zzfj == zzoVar.zzfj;
    }

    public final int hashCode() {
        return this.type.hashCode();
    }

    public final String toString() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.type, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzfj);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
