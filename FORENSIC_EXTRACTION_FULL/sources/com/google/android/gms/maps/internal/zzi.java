package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzi extends com.google.android.gms.internal.maps.zzb implements zzh {
    public zzi() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperZzh = zzh(com.google.android.gms.internal.maps.zzu.zzg(parcel.readStrongBinder()));
                parcel2.writeNoException();
                com.google.android.gms.internal.maps.zzc.zza(parcel2, iObjectWrapperZzh);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperZzi = zzi(com.google.android.gms.internal.maps.zzu.zzg(parcel.readStrongBinder()));
                parcel2.writeNoException();
                com.google.android.gms.internal.maps.zzc.zza(parcel2, iObjectWrapperZzi);
                return true;
            default:
                return false;
        }
    }
}
