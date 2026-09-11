package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "AutocompletePredictionEntityCreator")
@SafeParcelable.Reserved({1000})
public final class zzb extends AbstractSafeParcelable implements AutocompletePrediction {
    public static final Parcelable.Creator<zzb> CREATOR = new zzd();
    private static final List<zzc> zzfk = Collections.emptyList();

    @SafeParcelable.Field(id = 2)
    private final String placeId;

    @SafeParcelable.Field(id = 3)
    private final List<Integer> zzdq;

    @SafeParcelable.Field(id = 1)
    private final String zzfl;

    @SafeParcelable.Field(id = 4)
    private final List<zzc> zzfm;

    @SafeParcelable.Field(id = 5)
    private final int zzfn;

    @SafeParcelable.Field(id = 6)
    private final String zzfo;

    @SafeParcelable.Field(id = 7)
    private final List<zzc> zzfp;

    @SafeParcelable.Field(id = 8)
    private final String zzfq;

    @SafeParcelable.Field(id = 9)
    private final List<zzc> zzfr;

    @SafeParcelable.Constructor
    zzb(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) List<Integer> list, @SafeParcelable.Param(id = 5) int i, @SafeParcelable.Param(id = 1) String str2, @SafeParcelable.Param(id = 4) List<zzc> list2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) List<zzc> list3, @SafeParcelable.Param(id = 8) String str4, @SafeParcelable.Param(id = 9) List<zzc> list4) {
        this.placeId = str;
        this.zzdq = list;
        this.zzfn = i;
        this.zzfl = str2;
        this.zzfm = list2;
        this.zzfo = str3;
        this.zzfp = list3;
        this.zzfq = str4;
        this.zzfr = list4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzb)) {
            return false;
        }
        zzb zzbVar = (zzb) obj;
        return Objects.equal(this.placeId, zzbVar.placeId) && Objects.equal(this.zzdq, zzbVar.zzdq) && Objects.equal(Integer.valueOf(this.zzfn), Integer.valueOf(zzbVar.zzfn)) && Objects.equal(this.zzfl, zzbVar.zzfl) && Objects.equal(this.zzfm, zzbVar.zzfm) && Objects.equal(this.zzfo, zzbVar.zzfo) && Objects.equal(this.zzfp, zzbVar.zzfp) && Objects.equal(this.zzfq, zzbVar.zzfq) && Objects.equal(this.zzfr, zzbVar.zzfr);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ AutocompletePrediction freeze() {
        if (this == null) {
            throw null;
        }
        return this;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getFullText(@Nullable CharacterStyle characterStyle) {
        return zzh.zzb(this.zzfl, this.zzfm, characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    @Nullable
    public final String getPlaceId() {
        return this.placeId;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final List<Integer> getPlaceTypes() {
        return this.zzdq;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getPrimaryText(@Nullable CharacterStyle characterStyle) {
        return zzh.zzb(this.zzfo, this.zzfp, characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getSecondaryText(@Nullable CharacterStyle characterStyle) {
        return zzh.zzb(this.zzfq, this.zzfr, characterStyle);
    }

    public final int hashCode() {
        return Objects.hashCode(this.placeId, this.zzdq, Integer.valueOf(this.zzfn), this.zzfl, this.zzfm, this.zzfo, this.zzfp, this.zzfq, this.zzfr);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("placeId", this.placeId).add("placeTypes", this.zzdq).add("fullText", this.zzfl).add("fullTextMatchedSubstrings", this.zzfm).add("primaryText", this.zzfo).add("primaryTextMatchedSubstrings", this.zzfp).add("secondaryText", this.zzfq).add("secondaryTextMatchedSubstrings", this.zzfr).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzfl, false);
        SafeParcelWriter.writeString(parcel, 2, this.placeId, false);
        SafeParcelWriter.writeIntegerList(parcel, 3, this.zzdq, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzfm, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzfn);
        SafeParcelWriter.writeString(parcel, 6, this.zzfo, false);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zzfp, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzfq, false);
        SafeParcelWriter.writeTypedList(parcel, 9, this.zzfr, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
