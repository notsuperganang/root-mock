package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzahi extends RemoteCreator<zzahc> {
    public zzahi() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzahc getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return iInterfaceQueryLocalInterface instanceof zzahc ? (zzahc) iInterfaceQueryLocalInterface : new zzahd(iBinder);
    }

    public final zzagz zza(Context context, zzxn zzxnVar) {
        zzagz zzahbVar;
        try {
            IBinder iBinderZza = getRemoteCreatorInstance(context).zza(ObjectWrapper.wrap(context), zzxnVar, 12451000);
            if (iBinderZza == null) {
                zzahbVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinderZza.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                zzahbVar = iInterfaceQueryLocalInterface instanceof zzagz ? (zzagz) iInterfaceQueryLocalInterface : new zzahb(iBinderZza);
            }
            return zzahbVar;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzane.zzc("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }
}
