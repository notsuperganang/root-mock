package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzzk extends zzek implements zzzj {
    public zzzk() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzzj zzt(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzzj ? (zzzj) iInterfaceQueryLocalInterface : new zzzl(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzek
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzzm zzznVar;
        zzzh zzziVar = null;
        zzzf zzzgVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string = parcel.readString();
                Bundle bundle = (Bundle) zzel.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzznVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                    zzznVar = iInterfaceQueryLocalInterface instanceof zzzm ? (zzzm) iInterfaceQueryLocalInterface : new zzzn(strongBinder);
                }
                zza(iObjectWrapperAsInterface, string, bundle, zzznVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzzt zzztVarZznc = zznc();
                parcel2.writeNoException();
                zzel.zzb(parcel2, zzztVarZznc);
                return true;
            case 3:
                zzzt zzztVarZznd = zznd();
                parcel2.writeNoException();
                zzel.zzb(parcel2, zzztVarZznd);
                return true;
            case 4:
                byte[] bArrCreateByteArray = parcel.createByteArray();
                String string2 = parcel.readString();
                Bundle bundle2 = (Bundle) zzel.zza(parcel, Bundle.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    zzzgVar = iInterfaceQueryLocalInterface2 instanceof zzzf ? (zzzf) iInterfaceQueryLocalInterface2 : new zzzg(strongBinder2);
                }
                zza(bArrCreateByteArray, string2, bundle2, iObjectWrapperAsInterface2, zzzgVar, zzxu.zzs(parcel.readStrongBinder()), (zzjn) zzel.zza(parcel, zzjn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zzlo videoController = getVideoController();
                parcel2.writeNoException();
                zzel.zza(parcel2, videoController);
                return true;
            case 6:
                byte[] bArrCreateByteArray2 = parcel.createByteArray();
                String string3 = parcel.readString();
                Bundle bundle3 = (Bundle) zzel.zza(parcel, Bundle.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                    zzziVar = iInterfaceQueryLocalInterface3 instanceof zzzh ? (zzzh) iInterfaceQueryLocalInterface3 : new zzzi(strongBinder3);
                }
                zza(bArrCreateByteArray2, string3, bundle3, iObjectWrapperAsInterface3, zzziVar, zzxu.zzs(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
