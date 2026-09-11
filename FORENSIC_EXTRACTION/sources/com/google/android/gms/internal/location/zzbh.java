package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
@SafeParcelable.Class(creator = "ParcelableGeofenceCreator")
@SafeParcelable.Reserved({1000})
public final class zzbh extends AbstractSafeParcelable implements Geofence {
    public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();

    @SafeParcelable.Field(getter = "getRequestId", id = 1)
    private final String zzad;

    @SafeParcelable.Field(getter = "getTransitionTypes", id = 7)
    private final int zzae;

    @SafeParcelable.Field(getter = "getType", id = 3)
    private final short zzag;

    @SafeParcelable.Field(getter = "getLatitude", id = 4)
    private final double zzah;

    @SafeParcelable.Field(getter = "getLongitude", id = 5)
    private final double zzai;

    @SafeParcelable.Field(getter = "getRadius", id = 6)
    private final float zzaj;

    @SafeParcelable.Field(defaultValue = "0", getter = "getNotificationResponsiveness", id = 8)
    private final int zzak;

    @SafeParcelable.Field(defaultValue = "-1", getter = "getLoiteringDelay", id = 9)
    private final int zzal;

    @SafeParcelable.Field(getter = "getExpirationTime", id = 2)
    private final long zzdo;

    @SafeParcelable.Constructor
    public zzbh(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 3) short s, @SafeParcelable.Param(id = 4) double d, @SafeParcelable.Param(id = 5) double d2, @SafeParcelable.Param(id = 6) float f, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 8) int i2, @SafeParcelable.Param(id = 9) int i3) {
        if (str == null || str.length() > 100) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "requestId is null or too long: ".concat(strValueOf) : new String("requestId is null or too long: "));
        }
        if (f <= 0.0f) {
            throw new IllegalArgumentException(new StringBuilder(31).append("invalid radius: ").append(f).toString());
        }
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException(new StringBuilder(42).append("invalid latitude: ").append(d).toString());
        }
        if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException(new StringBuilder(43).append("invalid longitude: ").append(d2).toString());
        }
        int i4 = i & 7;
        if (i4 == 0) {
            throw new IllegalArgumentException(new StringBuilder(46).append("No supported transition specified: ").append(i).toString());
        }
        this.zzag = s;
        this.zzad = str;
        this.zzah = d;
        this.zzai = d2;
        this.zzaj = f;
        this.zzdo = j;
        this.zzae = i4;
        this.zzak = i2;
        this.zzal = i3;
    }

    public static zzbh zza(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        zzbh zzbhVarCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return zzbhVarCreateFromParcel;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || !(obj instanceof zzbh)) {
                return false;
            }
            zzbh zzbhVar = (zzbh) obj;
            if (this.zzaj != zzbhVar.zzaj || this.zzah != zzbhVar.zzah || this.zzai != zzbhVar.zzai || this.zzag != zzbhVar.zzag) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.location.Geofence
    public final String getRequestId() {
        return this.zzad;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.zzah);
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.zzai);
        return ((((((((i + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzaj)) * 31) + this.zzag) * 31) + this.zzae;
    }

    public final String toString() {
        String str;
        Locale locale = Locale.US;
        switch (this.zzag) {
            case 1:
                str = "CIRCLE";
                break;
            default:
                str = null;
                break;
        }
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", str, this.zzad.replaceAll("\\p{C}", "?"), Integer.valueOf(this.zzae), Double.valueOf(this.zzah), Double.valueOf(this.zzai), Float.valueOf(this.zzaj), Integer.valueOf(this.zzak / 1000), Integer.valueOf(this.zzal), Long.valueOf(this.zzdo));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getRequestId(), false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzdo);
        SafeParcelWriter.writeShort(parcel, 3, this.zzag);
        SafeParcelWriter.writeDouble(parcel, 4, this.zzah);
        SafeParcelWriter.writeDouble(parcel, 5, this.zzai);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzaj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzae);
        SafeParcelWriter.writeInt(parcel, 8, this.zzak);
        SafeParcelWriter.writeInt(parcel, 9, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
