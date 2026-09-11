package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "DetectedActivityCreator")
@SafeParcelable.Reserved({1000})
public class DetectedActivity extends AbstractSafeParcelable {
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;

    @SafeParcelable.Field(id = 1)
    private int zzi;

    @SafeParcelable.Field(id = 2)
    private int zzs;
    private static final Comparator<DetectedActivity> zzo = new zzh();
    private static final int[] zzp = {9, 10};
    private static final int[] zzq = {0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19};
    private static final int[] zzr = {0, 1, 2, 3, 7, 8, 16, 17};
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzi();

    @SafeParcelable.Constructor
    public DetectedActivity(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2) {
        this.zzi = i;
        this.zzs = i2;
    }

    public static void zzb(int i) {
        boolean z = false;
        for (int i2 : zzr) {
            if (i2 == i) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        Log.w("DetectedActivity", new StringBuilder(81).append(i).append(" is not a valid DetectedActivity supported by Activity Transition API.").toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.zzi == detectedActivity.zzi && this.zzs == detectedActivity.zzs;
    }

    public int getConfidence() {
        return this.zzs;
    }

    public int getType() {
        int i = this.zzi;
        if (i > 19 || i < 0) {
            return 4;
        }
        return i;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzi), Integer.valueOf(this.zzs));
    }

    public String toString() {
        String string;
        int type = getType();
        switch (type) {
            case 0:
                string = "IN_VEHICLE";
                break;
            case 1:
                string = "ON_BICYCLE";
                break;
            case 2:
                string = "ON_FOOT";
                break;
            case 3:
                string = "STILL";
                break;
            case 4:
                string = "UNKNOWN";
                break;
            case 5:
                string = "TILTING";
                break;
            case 6:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            default:
                string = Integer.toString(type);
                break;
            case 7:
                string = "WALKING";
                break;
            case 8:
                string = "RUNNING";
                break;
            case 16:
                string = "IN_ROAD_VEHICLE";
                break;
            case 17:
                string = "IN_RAIL_VEHICLE";
                break;
            case 18:
                string = "IN_TWO_WHEELER_VEHICLE";
                break;
            case 19:
                string = "IN_FOUR_WHEELER_VEHICLE";
                break;
        }
        return new StringBuilder(String.valueOf(string).length() + 48).append("DetectedActivity [type=").append(string).append(", confidence=").append(this.zzs).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzi);
        SafeParcelWriter.writeInt(parcel, 2, this.zzs);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
