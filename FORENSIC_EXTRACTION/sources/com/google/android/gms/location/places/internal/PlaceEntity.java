package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlaceEntityCreator")
@SafeParcelable.Reserved({1000, 2, 3, 12, 13, 16, 18})
public final class PlaceEntity extends AbstractSafeParcelable implements ReflectedParcelable, Place {
    public static final Parcelable.Creator<PlaceEntity> CREATOR = new zzag();

    @SafeParcelable.Field(getter = "getLatLng", id = 4)
    private final LatLng latLng;
    private Locale locale;

    @SafeParcelable.Field(getter = "getName", id = 19)
    private final String name;

    @SafeParcelable.Field(getter = "getAddress", id = 14)
    private final String zzdp;

    @SafeParcelable.Field(getter = "getPlaceTypes", id = 20)
    private final List<Integer> zzdq;

    @SafeParcelable.Field(getter = "getPhoneNumber", id = 15)
    private final String zzdr;

    @SafeParcelable.Field(getter = "getWebsiteUri", id = 8)
    private final Uri zzds;

    @SafeParcelable.Field(getter = "getId", id = 1)
    private final String zzgf;

    @SafeParcelable.Field(getter = "getLevelNumber", id = 5)
    private final float zzgg;

    @SafeParcelable.Field(getter = "getViewport", id = 6)
    private final LatLngBounds zzgh;

    @SafeParcelable.Field(getter = "getTimeZoneId", id = 7)
    private final String zzgi;

    @SafeParcelable.Field(getter = "isPermanentlyClosed", id = 9)
    private final boolean zzgj;

    @SafeParcelable.Field(getter = "getRating", id = 10)
    private final float zzgk;

    @SafeParcelable.Field(getter = "getPriceLevel", id = 11)
    private final int zzgl;

    @SafeParcelable.Field(getter = "getAttributionsList", id = 17)
    private final List<String> zzgm;

    @SafeParcelable.Field(getter = "getPlaceOpeningHours", id = 21)
    private final zzam zzgn;

    @SafeParcelable.Field(getter = "getExtendedDetails", id = 22)
    private final zzah zzgo;

    @SafeParcelable.Field(getter = "getAdrAddress", id = 23)
    private final String zzgp;

    public static class zzb {
        private LatLng latLng;
        private String name;
        private String zzdp;
        private String zzdr;
        private Uri zzds;
        private String zzgf;
        private float zzgg;
        private LatLngBounds zzgh;
        private boolean zzgj;
        private List<String> zzgm;
        private zzam zzgn;
        private String zzgp;
        private List<Integer> zzgq;
        private zzah zzgr;
        private int zzgl = -1;
        private float zzgk = -1.0f;

        public final PlaceEntity zzag() {
            return new PlaceEntity(this.zzgf, this.zzgq, this.name, this.zzdp, this.zzdr, this.zzgm, this.latLng, this.zzgg, this.zzgh, null, this.zzds, this.zzgj, this.zzgk, this.zzgl, this.zzgn, this.zzgr, this.zzgp);
        }

        public final zzb zzb(float f) {
            this.zzgg = f;
            return this;
        }

        public final zzb zzb(Uri uri) {
            this.zzds = uri;
            return this;
        }

        public final zzb zzb(zzah zzahVar) {
            this.zzgr = zzahVar;
            return this;
        }

        public final zzb zzb(zzam zzamVar) {
            this.zzgn = zzamVar;
            return this;
        }

        public final zzb zzb(LatLng latLng) {
            this.latLng = latLng;
            return this;
        }

        public final zzb zzb(LatLngBounds latLngBounds) {
            this.zzgh = latLngBounds;
            return this;
        }

        public final zzb zzb(boolean z) {
            this.zzgj = z;
            return this;
        }

        public final zzb zzc(float f) {
            this.zzgk = f;
            return this;
        }

        public final zzb zzc(String str) {
            this.zzgf = str;
            return this;
        }

        public final zzb zzc(List<Integer> list) {
            this.zzgq = list;
            return this;
        }

        public final zzb zzd(String str) {
            this.name = str;
            return this;
        }

        public final zzb zzd(List<String> list) {
            this.zzgm = list;
            return this;
        }

        public final zzb zze(String str) {
            this.zzdp = str;
            return this;
        }

        public final zzb zzf(int i) {
            this.zzgl = i;
            return this;
        }

        public final zzb zzf(String str) {
            this.zzdr = str;
            return this;
        }

        public final zzb zzg(String str) {
            this.zzgp = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    PlaceEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 20) List<Integer> list, @SafeParcelable.Param(id = 19) String str2, @SafeParcelable.Param(id = 14) String str3, @SafeParcelable.Param(id = 15) String str4, @SafeParcelable.Param(id = 17) List<String> list2, @SafeParcelable.Param(id = 4) LatLng latLng, @SafeParcelable.Param(id = 5) float f, @SafeParcelable.Param(id = 6) LatLngBounds latLngBounds, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) Uri uri, @SafeParcelable.Param(id = 9) boolean z, @SafeParcelable.Param(id = 10) float f2, @SafeParcelable.Param(id = 11) int i, @SafeParcelable.Param(id = 21) zzam zzamVar, @SafeParcelable.Param(id = 22) zzah zzahVar, @SafeParcelable.Param(id = 23) String str6) {
        this.zzgf = str;
        this.zzdq = Collections.unmodifiableList(list);
        this.name = str2;
        this.zzdp = str3;
        this.zzdr = str4;
        this.zzgm = list2 == null ? Collections.emptyList() : list2;
        this.latLng = latLng;
        this.zzgg = f;
        this.zzgh = latLngBounds;
        this.zzgi = str5 == null ? "UTC" : str5;
        this.zzds = uri;
        this.zzgj = z;
        this.zzgk = f2;
        this.zzgl = i;
        this.locale = null;
        this.zzgn = zzamVar;
        this.zzgo = zzahVar;
        this.zzgp = str6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceEntity)) {
            return false;
        }
        PlaceEntity placeEntity = (PlaceEntity) obj;
        return this.zzgf.equals(placeEntity.zzgf) && Objects.equal(this.locale, placeEntity.locale);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Place freeze() {
        if (this == null) {
            throw null;
        }
        return this;
    }

    @Override // com.google.android.gms.location.places.Place
    public final /* synthetic */ CharSequence getAddress() {
        return this.zzdp;
    }

    @Override // com.google.android.gms.location.places.Place
    @Nullable
    public final CharSequence getAttributions() {
        return zzh.zzg(this.zzgm);
    }

    @Override // com.google.android.gms.location.places.Place
    @VisibleForTesting
    public final String getId() {
        return this.zzgf;
    }

    @Override // com.google.android.gms.location.places.Place
    public final LatLng getLatLng() {
        return this.latLng;
    }

    @Override // com.google.android.gms.location.places.Place
    public final Locale getLocale() {
        return this.locale;
    }

    @Override // com.google.android.gms.location.places.Place
    public final /* synthetic */ CharSequence getName() {
        return this.name;
    }

    @Override // com.google.android.gms.location.places.Place
    public final /* synthetic */ CharSequence getPhoneNumber() {
        return this.zzdr;
    }

    @Override // com.google.android.gms.location.places.Place
    public final List<Integer> getPlaceTypes() {
        return this.zzdq;
    }

    @Override // com.google.android.gms.location.places.Place
    public final int getPriceLevel() {
        return this.zzgl;
    }

    @Override // com.google.android.gms.location.places.Place
    public final float getRating() {
        return this.zzgk;
    }

    @Override // com.google.android.gms.location.places.Place
    public final LatLngBounds getViewport() {
        return this.zzgh;
    }

    @Override // com.google.android.gms.location.places.Place
    public final Uri getWebsiteUri() {
        return this.zzds;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzgf, this.locale);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @VisibleForTesting
    public final void setLocale(Locale locale) {
        this.locale = locale;
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return Objects.toStringHelper(this).add("id", this.zzgf).add("placeTypes", this.zzdq).add("locale", this.locale).add("name", this.name).add("address", this.zzdp).add("phoneNumber", this.zzdr).add("latlng", this.latLng).add("viewport", this.zzgh).add("websiteUri", this.zzds).add("isPermanentlyClosed", Boolean.valueOf(this.zzgj)).add("priceLevel", Integer.valueOf(this.zzgl)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getLatLng(), i, false);
        SafeParcelWriter.writeFloat(parcel, 5, this.zzgg);
        SafeParcelWriter.writeParcelable(parcel, 6, getViewport(), i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzgi, false);
        SafeParcelWriter.writeParcelable(parcel, 8, getWebsiteUri(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzgj);
        SafeParcelWriter.writeFloat(parcel, 10, getRating());
        SafeParcelWriter.writeInt(parcel, 11, getPriceLevel());
        SafeParcelWriter.writeString(parcel, 14, (String) getAddress(), false);
        SafeParcelWriter.writeString(parcel, 15, (String) getPhoneNumber(), false);
        SafeParcelWriter.writeStringList(parcel, 17, this.zzgm, false);
        SafeParcelWriter.writeString(parcel, 19, (String) getName(), false);
        SafeParcelWriter.writeIntegerList(parcel, 20, getPlaceTypes(), false);
        SafeParcelWriter.writeParcelable(parcel, 21, this.zzgn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 22, this.zzgo, i, false);
        SafeParcelWriter.writeString(parcel, 23, this.zzgp, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
