package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.location.places.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class zze extends zzx {
    private final zzg zzdx;
    private final zzf zzdy;

    public zze(zzf zzfVar) {
        this.zzdx = null;
        this.zzdy = zzfVar;
    }

    public zze(zzg zzgVar) {
        this.zzdx = zzgVar;
        this.zzdy = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzw
    public final void zzb(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
        this.zzdx.setResult(placePhotoMetadataResult);
    }

    @Override // com.google.android.gms.location.places.internal.zzw
    public final void zzb(PlacePhotoResult placePhotoResult) throws RemoteException {
        this.zzdy.setResult(placePhotoResult);
    }
}
