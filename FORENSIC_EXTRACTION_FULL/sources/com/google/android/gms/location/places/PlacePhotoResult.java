package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PlacePhotoResultCreator")
@SafeParcelable.Reserved({1000})
public class PlacePhotoResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzl();

    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status zzdz;

    @SafeParcelable.Field(id = 2)
    private final BitmapTeleporter zzer;
    private final Bitmap zzes;

    @SafeParcelable.Constructor
    public PlacePhotoResult(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) BitmapTeleporter bitmapTeleporter) {
        this.zzdz = status;
        this.zzer = bitmapTeleporter;
        if (this.zzer != null) {
            this.zzes = bitmapTeleporter.get();
        } else {
            this.zzes = null;
        }
    }

    public Bitmap getBitmap() {
        return this.zzes;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzdz;
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzdz).add("bitmap", this.zzes).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzer, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
