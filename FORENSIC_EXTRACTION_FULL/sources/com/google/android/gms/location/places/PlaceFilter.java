package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlaceFilterCreator")
@SafeParcelable.Reserved({1000, 2, 5})
public final class PlaceFilter extends com.google.android.gms.location.places.zzb {
    public static final Parcelable.Creator<PlaceFilter> CREATOR = new zzi();
    private static final PlaceFilter zzeb = new PlaceFilter();

    @Nullable
    @SafeParcelable.Field(id = 1)
    private final List<Integer> zzec;

    @SafeParcelable.Field(id = 3)
    private final boolean zzed;

    @Nullable
    @SafeParcelable.Field(id = 4)
    private final List<zzo> zzee;

    @Nullable
    @SafeParcelable.Field(id = 6)
    private final List<String> zzef;

    @NonNull
    private final Set<Integer> zzeg;

    @NonNull
    private final Set<zzo> zzeh;

    @NonNull
    private final Set<String> zzei;

    @Deprecated
    public static final class zzb {
        private boolean zzed;
        private Collection<Integer> zzej;
        private Collection<zzo> zzek;
        private String[] zzel;

        private zzb() {
            this.zzej = null;
            this.zzed = false;
            this.zzek = null;
            this.zzel = null;
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    private PlaceFilter(@Nullable Collection<Integer> collection, boolean z, @Nullable Collection<String> collection2, @Nullable Collection<zzo> collection3) {
        this((List<Integer>) zzf(null), z, (List<String>) zzf(collection2), (List<zzo>) zzf(null));
    }

    @SafeParcelable.Constructor
    PlaceFilter(@SafeParcelable.Param(id = 1) @Nullable List<Integer> list, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 6) @Nullable List<String> list2, @SafeParcelable.Param(id = 4) @Nullable List<zzo> list3) {
        this.zzec = list;
        this.zzed = z;
        this.zzee = list3;
        this.zzef = list2;
        this.zzeg = zzb(this.zzec);
        this.zzeh = zzb(this.zzee);
        this.zzei = zzb(this.zzef);
    }

    public PlaceFilter(boolean z, @Nullable Collection<String> collection) {
        this((Collection<Integer>) null, z, collection, (Collection<zzo>) null);
    }

    @Deprecated
    public static PlaceFilter zzz() {
        new zzb();
        return new PlaceFilter((List<Integer>) null, false, (List<String>) null, (List<zzo>) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.zzeg.equals(placeFilter.zzeg) && this.zzed == placeFilter.zzed && this.zzeh.equals(placeFilter.zzeh) && this.zzei.equals(placeFilter.zzei);
    }

    @Override // com.google.android.gms.location.places.zzb
    public final Set<String> getPlaceIds() {
        return this.zzei;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzeg, Boolean.valueOf(this.zzed), this.zzeh, this.zzei);
    }

    @Override // com.google.android.gms.location.places.zzb
    public final boolean isRestrictedToPlacesOpenNow() {
        return this.zzed;
    }

    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        if (!this.zzeg.isEmpty()) {
            stringHelper.add("types", this.zzeg);
        }
        stringHelper.add("requireOpenNow", Boolean.valueOf(this.zzed));
        if (!this.zzei.isEmpty()) {
            stringHelper.add("placeIds", this.zzei);
        }
        if (!this.zzeh.isEmpty()) {
            stringHelper.add("requestedUserDataTypes", this.zzeh);
        }
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.zzec, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzed);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzee, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzef, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
