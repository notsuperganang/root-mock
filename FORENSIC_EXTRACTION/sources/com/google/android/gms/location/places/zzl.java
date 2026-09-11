package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class zzl implements Parcelable.Creator<PlacePhotoResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlacePhotoResult createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        BitmapTeleporter bitmapTeleporter = null;
        Status status = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    status = (Status) SafeParcelReader.createParcelable(parcel, header, Status.CREATOR);
                    break;
                case 2:
                    bitmapTeleporter = (BitmapTeleporter) SafeParcelReader.createParcelable(parcel, header, BitmapTeleporter.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PlacePhotoResult(status, bitmapTeleporter);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlacePhotoResult[] newArray(int i) {
        return new PlacePhotoResult[i];
    }
}
