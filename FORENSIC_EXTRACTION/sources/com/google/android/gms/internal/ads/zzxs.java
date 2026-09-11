package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzxs extends zzej implements zzxq {
    zzxs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void destroy() throws RemoteException {
        transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final Bundle getInterstitialAdapterInfo() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzel.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzlo getVideoController() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(26, obtainAndWriteInterfaceToken());
        zzlo zzloVarZze = zzlp.zze(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzloVarZze;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final IObjectWrapper getView() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean isInitialized() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken());
        boolean zZza = zzel.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void pause() throws RemoteException {
        transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void resume() throws RemoteException {
        transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, z);
        transactAndReadExceptionReturnVoid(25, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void showInterstitial() throws RemoteException {
        transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void showVideo() throws RemoteException {
        transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(IObjectWrapper iObjectWrapper, zzaic zzaicVar, List<String> list) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzaicVar);
        parcelObtainAndWriteInterfaceToken.writeStringList(list);
        transactAndReadExceptionReturnVoid(23, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzaic zzaicVar, String str2) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjjVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzaicVar);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        transactAndReadExceptionReturnVoid(10, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzxt zzxtVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjjVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzxtVar);
        transactAndReadExceptionReturnVoid(3, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzxt zzxtVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjjVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzxtVar);
        transactAndReadExceptionReturnVoid(7, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzxt zzxtVar, zzpl zzplVar, List<String> list) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjjVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzxtVar);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzplVar);
        parcelObtainAndWriteInterfaceToken.writeStringList(list);
        transactAndReadExceptionReturnVoid(14, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, zzxt zzxtVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjnVar);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjjVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzxtVar);
        transactAndReadExceptionReturnVoid(1, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, String str2, zzxt zzxtVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjnVar);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjjVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzxtVar);
        transactAndReadExceptionReturnVoid(6, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzjj zzjjVar, String str, String str2) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjjVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        transactAndReadExceptionReturnVoid(20, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzc(zzjj zzjjVar, String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjjVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(11, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        transactAndReadExceptionReturnVoid(21, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxz zzmo() throws RemoteException {
        zzxz zzybVar;
        Parcel parcelTransactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzybVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzybVar = iInterfaceQueryLocalInterface instanceof zzxz ? (zzxz) iInterfaceQueryLocalInterface : new zzyb(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzybVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzyc zzmp() throws RemoteException {
        zzyc zzyeVar;
        Parcel parcelTransactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzyeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzyeVar = iInterfaceQueryLocalInterface instanceof zzyc ? (zzyc) iInterfaceQueryLocalInterface : new zzye(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzyeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final Bundle zzmq() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzel.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final Bundle zzmr() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzel.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean zzms() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(22, obtainAndWriteInterfaceToken());
        boolean zZza = zzel.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzqs zzmt() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(24, obtainAndWriteInterfaceToken());
        zzqs zzqsVarZzk = zzqt.zzk(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzqsVarZzk;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzyf zzmu() throws RemoteException {
        zzyf zzyhVar;
        Parcel parcelTransactAndReadException = transactAndReadException(27, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzyhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzyhVar = iInterfaceQueryLocalInterface instanceof zzyf ? (zzyf) iInterfaceQueryLocalInterface : new zzyh(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzyhVar;
    }
}
