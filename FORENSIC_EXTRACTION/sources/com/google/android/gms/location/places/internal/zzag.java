package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzag implements Parcelable.Creator<PlaceEntity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceEntity createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        ArrayList<Integer> arrayListCreateIntegerList = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        ArrayList<String> arrayListCreateStringList = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String strCreateString5 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i = 0;
        zzam zzamVar = null;
        zzah zzahVar = null;
        String strCreateString6 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                case 3:
                case 12:
                case 13:
                case 16:
                case 18:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 4:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, header, LatLng.CREATOR);
                    break;
                case 5:
                    f = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) SafeParcelReader.createParcelable(parcel, header, LatLngBounds.CREATOR);
                    break;
                case 7:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 8:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, header, Uri.CREATOR);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    f2 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 11:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 15:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 17:
                    arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 19:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 20:
                    arrayListCreateIntegerList = SafeParcelReader.createIntegerList(parcel, header);
                    break;
                case 21:
                    zzamVar = (zzam) SafeParcelReader.createParcelable(parcel, header, zzam.CREATOR);
                    break;
                case 22:
                    zzahVar = (zzah) SafeParcelReader.createParcelable(parcel, header, zzah.CREATOR);
                    break;
                case 23:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PlaceEntity(strCreateString, arrayListCreateIntegerList, strCreateString2, strCreateString3, strCreateString4, arrayListCreateStringList, latLng, f, latLngBounds, strCreateString5, uri, z, f2, i, zzamVar, zzahVar, strCreateString6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceEntity[] newArray(int i) {
        return new PlaceEntity[i];
    }
}
