package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<zzb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        ArrayList arrayListCreateTypedList = null;
        String strCreateString = null;
        ArrayList arrayListCreateTypedList2 = null;
        String strCreateString2 = null;
        ArrayList arrayListCreateTypedList3 = null;
        String strCreateString3 = null;
        ArrayList<Integer> arrayListCreateIntegerList = null;
        String strCreateString4 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    arrayListCreateIntegerList = SafeParcelReader.createIntegerList(parcel, header);
                    break;
                case 4:
                    arrayListCreateTypedList3 = SafeParcelReader.createTypedList(parcel, header, zzc.CREATOR);
                    break;
                case 5:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, zzc.CREATOR);
                    break;
                case 8:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 9:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzc.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzb(strCreateString4, arrayListCreateIntegerList, i, strCreateString3, arrayListCreateTypedList3, strCreateString2, arrayListCreateTypedList2, strCreateString, arrayListCreateTypedList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb[] newArray(int i) {
        return new zzb[i];
    }
}
