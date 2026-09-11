package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzxr extends zzek implements zzxq {
    public zzxr() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzek
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzxt zzxvVar;
        zzxt zzxvVar2;
        zzxt zzxvVar3;
        zzxt zzxvVar4 = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzjn zzjnVar = (zzjn) zzel.zza(parcel, zzjn.CREATOR);
                zzjj zzjjVar = (zzjj) zzel.zza(parcel, zzjj.CREATOR);
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzxvVar3 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxvVar3 = iInterfaceQueryLocalInterface instanceof zzxt ? (zzxt) iInterfaceQueryLocalInterface : new zzxv(strongBinder);
                }
                zza(iObjectWrapperAsInterface, zzjnVar, zzjjVar, string, zzxvVar3);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper view = getView();
                parcel2.writeNoException();
                zzel.zza(parcel2, view);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzjj zzjjVar2 = (zzjj) zzel.zza(parcel, zzjj.CREATOR);
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxvVar4 = iInterfaceQueryLocalInterface2 instanceof zzxt ? (zzxt) iInterfaceQueryLocalInterface2 : new zzxv(strongBinder2);
                }
                zza(iObjectWrapperAsInterface2, zzjjVar2, string2, zzxvVar4);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzjn zzjnVar2 = (zzjn) zzel.zza(parcel, zzjn.CREATOR);
                zzjj zzjjVar3 = (zzjj) zzel.zza(parcel, zzjj.CREATOR);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxvVar4 = iInterfaceQueryLocalInterface3 instanceof zzxt ? (zzxt) iInterfaceQueryLocalInterface3 : new zzxv(strongBinder3);
                }
                zza(iObjectWrapperAsInterface3, zzjnVar2, zzjjVar3, string3, string4, zzxvVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzjj zzjjVar4 = (zzjj) zzel.zza(parcel, zzjj.CREATOR);
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 == null) {
                    zzxvVar2 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxvVar2 = iInterfaceQueryLocalInterface4 instanceof zzxt ? (zzxt) iInterfaceQueryLocalInterface4 : new zzxv(strongBinder4);
                }
                zza(iObjectWrapperAsInterface4, zzjjVar4, string5, string6, zzxvVar2);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzjj) zzel.zza(parcel, zzjj.CREATOR), parcel.readString(), zzaid.zzaa(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zzc((zzjj) zzel.zza(parcel, zzjj.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zIsInitialized = isInitialized();
                parcel2.writeNoException();
                zzel.zza(parcel2, zIsInitialized);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzjj zzjjVar5 = (zzjj) zzel.zza(parcel, zzjj.CREATOR);
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 == null) {
                    zzxvVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxvVar = iInterfaceQueryLocalInterface5 instanceof zzxt ? (zzxt) iInterfaceQueryLocalInterface5 : new zzxv(strongBinder5);
                }
                zza(iObjectWrapperAsInterface5, zzjjVar5, string7, string8, zzxvVar, (zzpl) zzel.zza(parcel, zzpl.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzxz zzxzVarZzmo = zzmo();
                parcel2.writeNoException();
                zzel.zza(parcel2, zzxzVarZzmo);
                return true;
            case 16:
                zzyc zzycVarZzmp = zzmp();
                parcel2.writeNoException();
                zzel.zza(parcel2, zzycVarZzmp);
                return true;
            case 17:
                Bundle bundleZzmq = zzmq();
                parcel2.writeNoException();
                zzel.zzb(parcel2, bundleZzmq);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzel.zzb(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle bundleZzmr = zzmr();
                parcel2.writeNoException();
                zzel.zzb(parcel2, bundleZzmr);
                return true;
            case 20:
                zza((zzjj) zzel.zza(parcel, zzjj.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                zzi(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zZzms = zzms();
                parcel2.writeNoException();
                zzel.zza(parcel2, zZzms);
                return true;
            case 23:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzaid.zzaa(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzqs zzqsVarZzmt = zzmt();
                parcel2.writeNoException();
                zzel.zza(parcel2, zzqsVarZzmt);
                return true;
            case 25:
                setImmersiveMode(zzel.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzlo videoController = getVideoController();
                parcel2.writeNoException();
                zzel.zza(parcel2, videoController);
                return true;
            case 27:
                zzyf zzyfVarZzmu = zzmu();
                parcel2.writeNoException();
                zzel.zza(parcel2, zzyfVarZzmu);
                return true;
            default:
                return false;
        }
    }
}
