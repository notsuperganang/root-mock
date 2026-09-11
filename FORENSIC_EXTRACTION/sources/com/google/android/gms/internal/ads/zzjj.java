package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "AdRequestParcelCreator")
@zzadh
public final class zzjj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjj> CREATOR = new zzjl();

    @SafeParcelable.Field(id = 3)
    public final Bundle extras;

    @SafeParcelable.Field(id = 1)
    public final int versionCode;

    @SafeParcelable.Field(id = 2)
    public final long zzapw;

    @SafeParcelable.Field(id = 4)
    public final int zzapx;

    @SafeParcelable.Field(id = 5)
    public final List<String> zzapy;

    @SafeParcelable.Field(id = 6)
    public final boolean zzapz;

    @SafeParcelable.Field(id = 7)
    public final int zzaqa;

    @SafeParcelable.Field(id = 8)
    public final boolean zzaqb;

    @SafeParcelable.Field(id = 9)
    public final String zzaqc;

    @SafeParcelable.Field(id = 10)
    public final zzmq zzaqd;

    @SafeParcelable.Field(id = 11)
    public final Location zzaqe;

    @SafeParcelable.Field(id = 12)
    public final String zzaqf;

    @SafeParcelable.Field(id = 13)
    public final Bundle zzaqg;

    @SafeParcelable.Field(id = 14)
    public final Bundle zzaqh;

    @SafeParcelable.Field(id = 15)
    public final List<String> zzaqi;

    @SafeParcelable.Field(id = 16)
    public final String zzaqj;

    @SafeParcelable.Field(id = 17)
    public final String zzaqk;

    @SafeParcelable.Field(id = 18)
    public final boolean zzaql;

    @SafeParcelable.Constructor
    public zzjj(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) int i3, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) String str, @SafeParcelable.Param(id = 10) zzmq zzmqVar, @SafeParcelable.Param(id = 11) Location location, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 13) Bundle bundle2, @SafeParcelable.Param(id = 14) Bundle bundle3, @SafeParcelable.Param(id = 15) List<String> list2, @SafeParcelable.Param(id = 16) String str3, @SafeParcelable.Param(id = 17) String str4, @SafeParcelable.Param(id = 18) boolean z3) {
        this.versionCode = i;
        this.zzapw = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzapx = i2;
        this.zzapy = list;
        this.zzapz = z;
        this.zzaqa = i3;
        this.zzaqb = z2;
        this.zzaqc = str;
        this.zzaqd = zzmqVar;
        this.zzaqe = location;
        this.zzaqf = str2;
        this.zzaqg = bundle2 == null ? new Bundle() : bundle2;
        this.zzaqh = bundle3;
        this.zzaqi = list2;
        this.zzaqj = str3;
        this.zzaqk = str4;
        this.zzaql = z3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjj)) {
            return false;
        }
        zzjj zzjjVar = (zzjj) obj;
        return this.versionCode == zzjjVar.versionCode && this.zzapw == zzjjVar.zzapw && Objects.equal(this.extras, zzjjVar.extras) && this.zzapx == zzjjVar.zzapx && Objects.equal(this.zzapy, zzjjVar.zzapy) && this.zzapz == zzjjVar.zzapz && this.zzaqa == zzjjVar.zzaqa && this.zzaqb == zzjjVar.zzaqb && Objects.equal(this.zzaqc, zzjjVar.zzaqc) && Objects.equal(this.zzaqd, zzjjVar.zzaqd) && Objects.equal(this.zzaqe, zzjjVar.zzaqe) && Objects.equal(this.zzaqf, zzjjVar.zzaqf) && Objects.equal(this.zzaqg, zzjjVar.zzaqg) && Objects.equal(this.zzaqh, zzjjVar.zzaqh) && Objects.equal(this.zzaqi, zzjjVar.zzaqi) && Objects.equal(this.zzaqj, zzjjVar.zzaqj) && Objects.equal(this.zzaqk, zzjjVar.zzaqk) && this.zzaql == zzjjVar.zzaql;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzapw), this.extras, Integer.valueOf(this.zzapx), this.zzapy, Boolean.valueOf(this.zzapz), Integer.valueOf(this.zzaqa), Boolean.valueOf(this.zzaqb), this.zzaqc, this.zzaqd, this.zzaqe, this.zzaqf, this.zzaqg, this.zzaqh, this.zzaqi, this.zzaqj, this.zzaqk, Boolean.valueOf(this.zzaql));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzapw);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzapx);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzapy, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzapz);
        SafeParcelWriter.writeInt(parcel, 7, this.zzaqa);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzaqb);
        SafeParcelWriter.writeString(parcel, 9, this.zzaqc, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzaqd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzaqe, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzaqf, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzaqg, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzaqh, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzaqi, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzaqj, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzaqk, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzaql);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzjj zzhv() {
        Bundle bundle = this.zzaqg.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle == null) {
            bundle = this.extras;
            this.zzaqg.putBundle("com.google.ads.mediation.admob.AdMobAdapter", this.extras);
        }
        return new zzjj(this.versionCode, this.zzapw, bundle, this.zzapx, this.zzapy, this.zzapz, this.zzaqa, this.zzaqb, this.zzaqc, this.zzaqd, this.zzaqe, this.zzaqf, this.zzaqg, this.zzaqh, this.zzaqi, this.zzaqj, this.zzaqk, this.zzaql);
    }
}
