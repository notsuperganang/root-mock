package com.google.android.gms.location.places.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;

/* JADX INFO: loaded from: classes.dex */
public final class zzt extends com.google.android.gms.internal.places.zzb implements zzs {
    zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
    }

    @Override // com.google.android.gms.location.places.internal.zzs
    public final void zzb(PlaceFilter placeFilter, zzat zzatVar, zzy zzyVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, placeFilter);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzatVar);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzyVar);
        transactAndReadExceptionReturnVoid(6, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.location.places.internal.zzs
    public final void zzb(PlaceReport placeReport, zzat zzatVar, zzy zzyVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, placeReport);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzatVar);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzyVar);
        transactAndReadExceptionReturnVoid(7, parcelObtainAndWriteInterfaceToken);
    }
}
