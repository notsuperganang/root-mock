package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzlp extends zzek implements zzlo {
    public zzlp() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzlo zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return iInterfaceQueryLocalInterface instanceof zzlo ? (zzlo) iInterfaceQueryLocalInterface : new zzlq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzek
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzlr zzltVar;
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                return true;
            case 2:
                pause();
                parcel2.writeNoException();
                return true;
            case 3:
                mute(zzel.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zIsMuted = isMuted();
                parcel2.writeNoException();
                zzel.zza(parcel2, zIsMuted);
                return true;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                return true;
            case 6:
                float fZzim = zzim();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzim);
                return true;
            case 7:
                float fZzin = zzin();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzin);
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzltVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzltVar = iInterfaceQueryLocalInterface instanceof zzlr ? (zzlr) iInterfaceQueryLocalInterface : new zzlt(strongBinder);
                }
                zza(zzltVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                return true;
            case 10:
                boolean zIsCustomControlsEnabled = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzel.zza(parcel2, zIsCustomControlsEnabled);
                return true;
            case 11:
                zzlr zzlrVarZzio = zzio();
                parcel2.writeNoException();
                zzel.zza(parcel2, zzlrVarZzio);
                return true;
            case 12:
                boolean zIsClickToExpandEnabled = isClickToExpandEnabled();
                parcel2.writeNoException();
                zzel.zza(parcel2, zIsClickToExpandEnabled);
                return true;
            default:
                return false;
        }
    }
}
