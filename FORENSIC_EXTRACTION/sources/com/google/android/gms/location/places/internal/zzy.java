package com.google.android.gms.location.places.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public interface zzy extends IInterface {
    void zzb(DataHolder dataHolder) throws RemoteException;

    void zzc(DataHolder dataHolder) throws RemoteException;

    void zzd(DataHolder dataHolder) throws RemoteException;

    void zze(Status status) throws RemoteException;

    void zze(DataHolder dataHolder) throws RemoteException;
}
