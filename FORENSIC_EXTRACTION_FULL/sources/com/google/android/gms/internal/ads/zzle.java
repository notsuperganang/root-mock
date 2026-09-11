package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzle extends zzek implements zzld {
    public zzle() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    public static zzld asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        return iInterfaceQueryLocalInterface instanceof zzld ? (zzld) iInterfaceQueryLocalInterface : new zzlf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzek
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzks zzksVarCreateBannerAdManager = createBannerAdManager(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzjn) zzel.zza(parcel, zzjn.CREATOR), parcel.readString(), zzxo.zzr(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzel.zza(parcel2, zzksVarCreateBannerAdManager);
                return true;
            case 2:
                zzks zzksVarCreateInterstitialAdManager = createInterstitialAdManager(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzjn) zzel.zza(parcel, zzjn.CREATOR), parcel.readString(), zzxo.zzr(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzel.zza(parcel2, zzksVarCreateInterstitialAdManager);
                return true;
            case 3:
                zzkn zzknVarCreateAdLoaderBuilder = createAdLoaderBuilder(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzxo.zzr(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzel.zza(parcel2, zzknVarCreateAdLoaderBuilder);
                return true;
            case 4:
                zzlj mobileAdsSettingsManager = getMobileAdsSettingsManager(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzel.zza(parcel2, mobileAdsSettingsManager);
                return true;
            case 5:
                zzqa zzqaVarCreateNativeAdViewDelegate = createNativeAdViewDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzel.zza(parcel2, zzqaVarCreateNativeAdViewDelegate);
                return true;
            case 6:
                zzagz zzagzVarCreateRewardedVideoAd = createRewardedVideoAd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzxo.zzr(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzel.zza(parcel2, zzagzVarCreateRewardedVideoAd);
                return true;
            case 7:
                zzaaz zzaazVarCreateInAppPurchaseManager = createInAppPurchaseManager(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzel.zza(parcel2, zzaazVarCreateInAppPurchaseManager);
                return true;
            case 8:
                zzaap zzaapVarCreateAdOverlay = createAdOverlay(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzel.zza(parcel2, zzaapVarCreateAdOverlay);
                return true;
            case 9:
                zzlj mobileAdsSettingsManagerWithClientJarVersion = getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzel.zza(parcel2, mobileAdsSettingsManagerWithClientJarVersion);
                return true;
            case 10:
                zzks zzksVarCreateSearchAdManager = createSearchAdManager(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzjn) zzel.zza(parcel, zzjn.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzel.zza(parcel2, zzksVarCreateSearchAdManager);
                return true;
            case 11:
                zzqf zzqfVarCreateNativeAdViewHolderDelegate = createNativeAdViewHolderDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzel.zza(parcel2, zzqfVarCreateNativeAdViewHolderDelegate);
                return true;
            default:
                return false;
        }
    }
}
