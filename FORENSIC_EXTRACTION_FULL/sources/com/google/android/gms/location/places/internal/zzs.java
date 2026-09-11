package com.google.android.gms.location.places.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;

/* JADX INFO: loaded from: classes.dex */
public interface zzs extends IInterface {
    void zzb(PlaceFilter placeFilter, zzat zzatVar, zzy zzyVar) throws RemoteException;

    void zzb(PlaceReport placeReport, zzat zzatVar, zzy zzyVar) throws RemoteException;
}
