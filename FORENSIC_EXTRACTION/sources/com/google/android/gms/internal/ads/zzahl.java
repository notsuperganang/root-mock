package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class zzahl implements Parcelable.Creator<zzahk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahk createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzjj zzjjVar = null;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    zzjjVar = (zzjj) SafeParcelReader.createParcelable(parcel, header, zzjj.CREATOR);
                    break;
                case 3:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzahk(zzjjVar, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahk[] newArray(int i) {
        return new zzahk[i];
    }
}
