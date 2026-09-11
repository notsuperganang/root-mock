package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlacesParamsCreator")
@SafeParcelable.Reserved({1000, 5})
public final class zzat extends AbstractSafeParcelable {

    @SafeParcelable.Field(id = 3)
    private final String zzcx;

    @SafeParcelable.Field(id = 4)
    private final String zzfd;

    @SafeParcelable.Field(id = 7)
    private final int zzfe;

    @SafeParcelable.Field(id = 1)
    private final String zzhg;

    @SafeParcelable.Field(id = 2)
    private final String zzhh;

    @SafeParcelable.Field(id = 6)
    private final int zzhi;
    private static final zzat zzhf = new zzat("com.google.android.gms", Locale.getDefault(), null);
    public static final Parcelable.Creator<zzat> CREATOR = new zzau();

    @SafeParcelable.Constructor
    public zzat(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 6) int i, @SafeParcelable.Param(id = 7) int i2) {
        this.zzhg = str;
        this.zzhh = str2;
        this.zzcx = str3;
        this.zzfd = str4;
        this.zzhi = i;
        this.zzfe = i2;
    }

    private zzat(String str, Locale locale, String str2) {
        this(str, locale.toString(), null, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, 0);
    }

    public zzat(String str, Locale locale, String str2, String str3, int i) {
        this(str, locale.toString(), str2, str3, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        return this.zzhi == zzatVar.zzhi && this.zzfe == zzatVar.zzfe && this.zzhh.equals(zzatVar.zzhh) && this.zzhg.equals(zzatVar.zzhg) && Objects.equal(this.zzcx, zzatVar.zzcx) && Objects.equal(this.zzfd, zzatVar.zzfd);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzhg, this.zzhh, this.zzcx, this.zzfd, Integer.valueOf(this.zzhi), Integer.valueOf(this.zzfe));
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return Objects.toStringHelper(this).add("clientPackageName", this.zzhg).add("locale", this.zzhh).add("accountName", this.zzcx).add("gCoreClientName", this.zzfd).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhg, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzhh, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcx, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzfd, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzhi);
        SafeParcelWriter.writeInt(parcel, 7, this.zzfe);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
