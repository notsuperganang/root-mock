package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PatternItemCreator")
@SafeParcelable.Reserved({1})
public class PatternItem extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getType", id = 2)
    private final int type;

    @Nullable
    @SafeParcelable.Field(getter = "getLength", id = 3)
    private final Float zzdv;
    private static final String TAG = PatternItem.class.getSimpleName();
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzi();

    @SafeParcelable.Constructor
    public PatternItem(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) @Nullable Float f) {
        boolean z = true;
        if (i != 1 && (f == null || f.floatValue() < 0.0f)) {
            z = false;
        }
        String strValueOf = String.valueOf(f);
        Preconditions.checkArgument(z, new StringBuilder(String.valueOf(strValueOf).length() + 45).append("Invalid PatternItem: type=").append(i).append(" length=").append(strValueOf).toString());
        this.type = i;
        this.zzdv = f;
    }

    @Nullable
    static List<PatternItem> zza(@Nullable List<PatternItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PatternItem gap : list) {
            if (gap != null) {
                switch (gap.type) {
                    case 0:
                        gap = new Dash(gap.zzdv.floatValue());
                        break;
                    case 1:
                        gap = new Dot();
                        break;
                    case 2:
                        gap = new Gap(gap.zzdv.floatValue());
                        break;
                    default:
                        Log.w(TAG, new StringBuilder(37).append("Unknown PatternItem type: ").append(gap.type).toString());
                        break;
                }
            } else {
                gap = null;
            }
            arrayList.add(gap);
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof PatternItem)) {
                return false;
            }
            PatternItem patternItem = (PatternItem) obj;
            if (this.type != patternItem.type || !Objects.equal(this.zzdv, patternItem.zzdv)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.type), this.zzdv);
    }

    public String toString() {
        int i = this.type;
        String strValueOf = String.valueOf(this.zzdv);
        return new StringBuilder(String.valueOf(strValueOf).length() + 39).append("[PatternItem: type=").append(i).append(" length=").append(strValueOf).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.type);
        SafeParcelWriter.writeFloatObject(parcel, 3, this.zzdv, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
