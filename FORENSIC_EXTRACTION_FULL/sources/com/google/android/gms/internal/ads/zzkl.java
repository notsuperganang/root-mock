package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzkl extends zzek implements zzkk {
    public zzkl() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzek
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzd((zzjj) zzel.zza(parcel, zzjj.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 3:
                boolean zIsLoading = isLoading();
                parcel2.writeNoException();
                zzel.zza(parcel2, zIsLoading);
                return true;
            case 4:
                String strZzck = zzck();
                parcel2.writeNoException();
                parcel2.writeString(strZzck);
                return true;
            case 5:
                zza((zzjj) zzel.zza(parcel, zzjj.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
