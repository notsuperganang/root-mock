package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzkt extends zzek implements zzks {
    public zzkt() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzks zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return iInterfaceQueryLocalInterface instanceof zzks ? (zzks) iInterfaceQueryLocalInterface : new zzku(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzek
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzkx zzkzVar = null;
        zzkh zzkjVar = null;
        zzla zzlcVar = null;
        zzke zzkgVar = null;
        zzlg zzliVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperZzbj = zzbj();
                parcel2.writeNoException();
                zzel.zza(parcel2, iObjectWrapperZzbj);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zIsReady = isReady();
                parcel2.writeNoException();
                zzel.zza(parcel2, zIsReady);
                return true;
            case 4:
                boolean zZzb = zzb((zzjj) zzel.zza(parcel, zzjj.CREATOR));
                parcel2.writeNoException();
                zzel.zza(parcel2, zZzb);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzkjVar = iInterfaceQueryLocalInterface instanceof zzkh ? (zzkh) iInterfaceQueryLocalInterface : new zzkj(strongBinder);
                }
                zza(zzkjVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzlcVar = iInterfaceQueryLocalInterface2 instanceof zzla ? (zzla) iInterfaceQueryLocalInterface2 : new zzlc(strongBinder2);
                }
                zza(zzlcVar);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                return true;
            case 11:
                zzbm();
                parcel2.writeNoException();
                return true;
            case 12:
                zzjn zzjnVarZzbk = zzbk();
                parcel2.writeNoException();
                zzel.zzb(parcel2, zzjnVarZzbk);
                return true;
            case 13:
                zza((zzjn) zzel.zza(parcel, zzjn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzaax.zzv(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zza(zzabd.zzx(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                zza(zzoe.zzf(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzkgVar = iInterfaceQueryLocalInterface3 instanceof zzke ? (zzke) iInterfaceQueryLocalInterface3 : new zzkg(strongBinder3);
                }
                zza(zzkgVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzliVar = iInterfaceQueryLocalInterface4 instanceof zzlg ? (zzlg) iInterfaceQueryLocalInterface4 : new zzli(strongBinder4);
                }
                zza(zzliVar);
                parcel2.writeNoException();
                return true;
            case 22:
                setManualImpressionsEnabled(zzel.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean zIsLoading = isLoading();
                parcel2.writeNoException();
                zzel.zza(parcel2, zIsLoading);
                return true;
            case 24:
                zza(zzahf.zzz(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzlo videoController = getVideoController();
                parcel2.writeNoException();
                zzel.zza(parcel2, videoController);
                return true;
            case 29:
                zza((zzmu) zzel.zza(parcel, zzmu.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                zza((zzlu) zzel.zza(parcel, zzlu.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String adUnitId = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(adUnitId);
                return true;
            case 32:
                zzla zzlaVarZzbw = zzbw();
                parcel2.writeNoException();
                zzel.zza(parcel2, zzlaVarZzbw);
                return true;
            case 33:
                zzkh zzkhVarZzbx = zzbx();
                parcel2.writeNoException();
                zzel.zza(parcel2, zzkhVarZzbx);
                return true;
            case 34:
                setImmersiveMode(zzel.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String strZzck = zzck();
                parcel2.writeNoException();
                parcel2.writeString(strZzck);
                return true;
            case 36:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzkzVar = iInterfaceQueryLocalInterface5 instanceof zzkx ? (zzkx) iInterfaceQueryLocalInterface5 : new zzkz(strongBinder5);
                }
                zza(zzkzVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle bundleZzba = zzba();
                parcel2.writeNoException();
                zzel.zzb(parcel2, bundleZzba);
                return true;
        }
    }
}
