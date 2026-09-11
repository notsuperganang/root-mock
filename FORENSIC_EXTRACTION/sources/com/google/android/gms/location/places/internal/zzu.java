package com.google.android.gms.location.places.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface zzu extends IInterface {
    void zzb(AddPlaceRequest addPlaceRequest, zzat zzatVar, zzy zzyVar) throws RemoteException;

    void zzb(String str, int i, int i2, int i3, zzat zzatVar, zzw zzwVar) throws RemoteException;

    void zzb(String str, zzat zzatVar, zzw zzwVar) throws RemoteException;

    void zzb(String str, LatLngBounds latLngBounds, int i, AutocompleteFilter autocompleteFilter, zzat zzatVar, zzy zzyVar) throws RemoteException;

    void zzb(List<String> list, zzat zzatVar, zzy zzyVar) throws RemoteException;
}
