package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzxo extends zzek implements zzxn {
    public zzxo() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzxn zzr(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return iInterfaceQueryLocalInterface instanceof zzxn ? (zzxn) iInterfaceQueryLocalInterface : new zzxp(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzek
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzxq zzxqVarZzbm = zzbm(parcel.readString());
                parcel2.writeNoException();
                zzel.zza(parcel2, zzxqVarZzbm);
                return true;
            case 2:
                boolean zZzbn = zzbn(parcel.readString());
                parcel2.writeNoException();
                zzel.zza(parcel2, zZzbn);
                return true;
            case 3:
                zzzj zzzjVarZzbq = zzbq(parcel.readString());
                parcel2.writeNoException();
                zzel.zza(parcel2, zzzjVarZzbq);
                return true;
            default:
                return false;
        }
    }
}
