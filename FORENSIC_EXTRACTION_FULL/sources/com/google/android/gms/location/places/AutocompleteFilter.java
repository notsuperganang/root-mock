package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "AutocompleteFilterCreator")
public class AutocompleteFilter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AutocompleteFilter> CREATOR = new zzd();
    public static final int TYPE_FILTER_ADDRESS = 2;
    public static final int TYPE_FILTER_CITIES = 5;
    public static final int TYPE_FILTER_ESTABLISHMENT = 34;
    public static final int TYPE_FILTER_GEOCODE = 1007;
    public static final int TYPE_FILTER_NONE = 0;
    public static final int TYPE_FILTER_REGIONS = 4;

    @SafeParcelable.VersionField(id = 1000)
    private final int versionCode;

    @SafeParcelable.Field(id = 1)
    private final boolean zzdt;

    @SafeParcelable.Field(id = 2)
    private final List<Integer> zzdu;

    @SafeParcelable.Field(id = 3)
    private final String zzdv;
    private final int zzdw;

    public static final class Builder {
        private boolean zzdt = false;
        private int zzdw = 0;
        private String zzdv = "";

        public final AutocompleteFilter build() {
            return new AutocompleteFilter(1, false, Arrays.asList(Integer.valueOf(this.zzdw)), this.zzdv);
        }

        public final Builder setCountry(String str) {
            this.zzdv = str;
            return this;
        }

        public final Builder setTypeFilter(int i) {
            this.zzdw = i;
            return this;
        }
    }

    @SafeParcelable.Constructor
    AutocompleteFilter(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) List<Integer> list, @SafeParcelable.Param(id = 3) String str) {
        this.versionCode = i;
        this.zzdu = list;
        this.zzdw = (list == null || list.isEmpty()) ? 0 : list.iterator().next().intValue();
        this.zzdv = str;
        if (this.versionCode <= 0) {
            this.zzdt = z ? false : true;
        } else {
            this.zzdt = z;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        return this.zzdw == autocompleteFilter.zzdw && this.zzdt == autocompleteFilter.zzdt && this.zzdv == autocompleteFilter.zzdv;
    }

    public int getTypeFilter() {
        return this.zzdw;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zzdt), Integer.valueOf(this.zzdw), this.zzdv);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("includeQueryPredictions", Boolean.valueOf(this.zzdt)).add("typeFilter", Integer.valueOf(this.zzdw)).add("country", this.zzdv).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzdt);
        SafeParcelWriter.writeIntegerList(parcel, 2, this.zzdu, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdv, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
