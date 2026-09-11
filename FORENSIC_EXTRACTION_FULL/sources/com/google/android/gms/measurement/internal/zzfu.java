package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzfu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfu> CREATOR = new zzfv();

    @SafeParcelable.Field(id = 2)
    public final String name;

    @SafeParcelable.Field(id = 7)
    public final String origin;

    @SafeParcelable.Field(id = 1)
    private final int versionCode;

    @SafeParcelable.Field(id = 6)
    public final String zzamn;

    @SafeParcelable.Field(id = 3)
    public final long zzaum;

    @SafeParcelable.Field(id = 4)
    public final Long zzaun;

    @SafeParcelable.Field(id = 5)
    private final Float zzauo;

    @SafeParcelable.Field(id = 8)
    public final Double zzaup;

    @SafeParcelable.Constructor
    zzfu(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) Float f, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Double d) {
        this.versionCode = i;
        this.name = str;
        this.zzaum = j;
        this.zzaun = l;
        this.zzauo = null;
        if (i == 1) {
            this.zzaup = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.zzaup = d;
        }
        this.zzamn = str2;
        this.origin = str3;
    }

    zzfu(zzfw zzfwVar) {
        this(zzfwVar.name, zzfwVar.zzaum, zzfwVar.value, zzfwVar.origin);
    }

    zzfu(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.versionCode = 2;
        this.name = str;
        this.zzaum = j;
        this.origin = str2;
        if (obj == null) {
            this.zzaun = null;
            this.zzauo = null;
            this.zzaup = null;
            this.zzamn = null;
            return;
        }
        if (obj instanceof Long) {
            this.zzaun = (Long) obj;
            this.zzauo = null;
            this.zzaup = null;
            this.zzamn = null;
            return;
        }
        if (obj instanceof String) {
            this.zzaun = null;
            this.zzauo = null;
            this.zzaup = null;
            this.zzamn = (String) obj;
            return;
        }
        if (!(obj instanceof Double)) {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
        this.zzaun = null;
        this.zzauo = null;
        this.zzaup = (Double) obj;
        this.zzamn = null;
    }

    public final Object getValue() {
        if (this.zzaun != null) {
            return this.zzaun;
        }
        if (this.zzaup != null) {
            return this.zzaup;
        }
        if (this.zzamn != null) {
            return this.zzamn;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzaum);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzaun, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzamn, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzaup, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
