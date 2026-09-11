package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzlf extends zzej implements zzld {
    zzlf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzkn createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzxn zzxnVar, int i) throws RemoteException {
        zzkn zzkpVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzxnVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(3, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzkpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzkpVar = iInterfaceQueryLocalInterface instanceof zzkn ? (zzkn) iInterfaceQueryLocalInterface : new zzkp(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzkpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzaap createAdOverlay(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel parcelTransactAndReadException = transactAndReadException(8, parcelObtainAndWriteInterfaceToken);
        zzaap zzaapVarZzu = zzaaq.zzu(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzaapVarZzu;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzks createBannerAdManager(IObjectWrapper iObjectWrapper, zzjn zzjnVar, String str, zzxn zzxnVar, int i) throws RemoteException {
        zzks zzkuVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjnVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzxnVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzkuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkuVar = iInterfaceQueryLocalInterface instanceof zzks ? (zzks) iInterfaceQueryLocalInterface : new zzku(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzkuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzaaz createInAppPurchaseManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel parcelTransactAndReadException = transactAndReadException(7, parcelObtainAndWriteInterfaceToken);
        zzaaz zzaazVarZzw = zzaba.zzw(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzaazVarZzw;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzks createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzjn zzjnVar, String str, zzxn zzxnVar, int i) throws RemoteException {
        zzks zzkuVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjnVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzxnVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(2, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzkuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkuVar = iInterfaceQueryLocalInterface instanceof zzks ? (zzks) iInterfaceQueryLocalInterface : new zzku(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzkuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzqa createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper2);
        Parcel parcelTransactAndReadException = transactAndReadException(5, parcelObtainAndWriteInterfaceToken);
        zzqa zzqaVarZzi = zzqb.zzi(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzqaVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzqf createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper2);
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper3);
        Parcel parcelTransactAndReadException = transactAndReadException(11, parcelObtainAndWriteInterfaceToken);
        zzqf zzqfVarZzj = zzqg.zzj(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzqfVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzagz createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzxn zzxnVar, int i) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzxnVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(6, parcelObtainAndWriteInterfaceToken);
        zzagz zzagzVarZzy = zzaha.zzy(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzagzVarZzy;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzks createSearchAdManager(IObjectWrapper iObjectWrapper, zzjn zzjnVar, String str, int i) throws RemoteException {
        zzks zzkuVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzel.zza(parcelObtainAndWriteInterfaceToken, zzjnVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(10, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzkuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkuVar = iInterfaceQueryLocalInterface instanceof zzks ? (zzks) iInterfaceQueryLocalInterface : new zzku(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzkuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzlj getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzlj zzllVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel parcelTransactAndReadException = transactAndReadException(4, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzllVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzllVar = iInterfaceQueryLocalInterface instanceof zzlj ? (zzlj) iInterfaceQueryLocalInterface : new zzll(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzllVar;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final zzlj getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzlj zzllVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzel.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(9, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzllVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzllVar = iInterfaceQueryLocalInterface instanceof zzlj ? (zzlj) iInterfaceQueryLocalInterface : new zzll(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzllVar;
    }
}
