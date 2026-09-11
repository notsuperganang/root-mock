package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzaao extends RemoteCreator<zzaas> {
    public zzaao() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaas getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return iInterfaceQueryLocalInterface instanceof zzaas ? (zzaas) iInterfaceQueryLocalInterface : new zzaat(iBinder);
    }

    public final zzaap zze(Activity activity) {
        zzaap zzaarVar;
        try {
            IBinder iBinderZzp = getRemoteCreatorInstance(activity).zzp(ObjectWrapper.wrap(activity));
            if (iBinderZzp == null) {
                zzaarVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinderZzp.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                zzaarVar = iInterfaceQueryLocalInterface instanceof zzaap ? (zzaap) iInterfaceQueryLocalInterface : new zzaar(iBinderZzp);
            }
            return zzaarVar;
        } catch (RemoteException e) {
            zzane.zzc("Could not create remote AdOverlay.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            zzane.zzc("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}
