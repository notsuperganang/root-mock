package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzz extends com.google.android.gms.internal.places.zzc implements zzy {
    public zzz() {
        super("com.google.android.gms.location.places.internal.IPlacesCallbacks");
    }

    @Override // com.google.android.gms.internal.places.zzc
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzb((DataHolder) com.google.android.gms.internal.places.zzd.zzb(parcel, DataHolder.CREATOR));
                return true;
            case 2:
                zzc((DataHolder) com.google.android.gms.internal.places.zzd.zzb(parcel, DataHolder.CREATOR));
                return true;
            case 3:
                zzd((DataHolder) com.google.android.gms.internal.places.zzd.zzb(parcel, DataHolder.CREATOR));
                return true;
            case 4:
                zze((Status) com.google.android.gms.internal.places.zzd.zzb(parcel, Status.CREATOR));
                return true;
            case 5:
                zze((DataHolder) com.google.android.gms.internal.places.zzd.zzb(parcel, DataHolder.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
