package com.google.android.gms.location.places.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzv extends com.google.android.gms.internal.places.zzb implements zzu {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.places.internal.IGooglePlacesService");
    }

    @Override // com.google.android.gms.location.places.internal.zzu
    public final void zzb(AddPlaceRequest addPlaceRequest, zzat zzatVar, zzy zzyVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, addPlaceRequest);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzatVar);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzyVar);
        transactAndReadExceptionReturnVoid(14, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.location.places.internal.zzu
    public final void zzb(String str, int i, int i2, int i3, zzat zzatVar, zzw zzwVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        parcelObtainAndWriteInterfaceToken.writeInt(i2);
        parcelObtainAndWriteInterfaceToken.writeInt(i3);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzatVar);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzwVar);
        transactAndReadExceptionReturnVoid(20, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.location.places.internal.zzu
    public final void zzb(String str, zzat zzatVar, zzw zzwVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzatVar);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzwVar);
        transactAndReadExceptionReturnVoid(19, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.location.places.internal.zzu
    public final void zzb(String str, LatLngBounds latLngBounds, int i, AutocompleteFilter autocompleteFilter, zzat zzatVar, zzy zzyVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, latLngBounds);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, autocompleteFilter);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzatVar);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzyVar);
        transactAndReadExceptionReturnVoid(28, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.location.places.internal.zzu
    public final void zzb(List<String> list, zzat zzatVar, zzy zzyVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeStringList(list);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzatVar);
        com.google.android.gms.internal.places.zzd.zzb(parcelObtainAndWriteInterfaceToken, zzyVar);
        transactAndReadExceptionReturnVoid(17, parcelObtainAndWriteInterfaceToken);
    }
}
