package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class MapsInitializer {

    @GuardedBy("MapsInitializer.class")
    private static boolean zzbm = false;

    private MapsInitializer() {
    }

    public static int initialize(Context context) {
        int i = 0;
        synchronized (MapsInitializer.class) {
            try {
                Preconditions.checkNotNull(context, "Context is null");
                if (!zzbm) {
                    try {
                        com.google.android.gms.maps.internal.zze zzeVarZza = zzbz.zza(context);
                        try {
                            CameraUpdateFactory.zza(zzeVarZza.zze());
                            BitmapDescriptorFactory.zza(zzeVarZza.zzf());
                            zzbm = true;
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    } catch (GooglePlayServicesNotAvailableException e2) {
                        i = e2.errorCode;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }
}
