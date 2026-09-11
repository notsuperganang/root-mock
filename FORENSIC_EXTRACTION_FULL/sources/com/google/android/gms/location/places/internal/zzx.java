package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzx extends com.google.android.gms.internal.places.zzc implements zzw {
    public zzx() {
        super("com.google.android.gms.location.places.internal.IPhotosCallbacks");
    }

    @Override // com.google.android.gms.internal.places.zzc
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                zzb((PlacePhotoResult) com.google.android.gms.internal.places.zzd.zzb(parcel, PlacePhotoResult.CREATOR));
                return true;
            case 3:
                zzb((PlacePhotoMetadataResult) com.google.android.gms.internal.places.zzd.zzb(parcel, PlacePhotoMetadataResult.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
