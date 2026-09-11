package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzdp implements Parcelable.Creator<zzdn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdn createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        String strCreateString = null;
        String strCreateString2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                case 4:
                case 5:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 6:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzdl.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzdn(strCreateString2, strCreateString, arrayListCreateTypedList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdn[] newArray(int i) {
        return new zzdn[i];
    }
}
