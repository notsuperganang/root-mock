package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzpv extends NativeAd.AdChoicesInfo {
    private final List<NativeAd.Image> zzbhf = new ArrayList();
    private final zzps zzbkk;
    private String zzbkl;

    public zzpv(zzps zzpsVar) {
        zzpw zzpyVar;
        IBinder iBinder;
        this.zzbkk = zzpsVar;
        try {
            this.zzbkl = this.zzbkk.getText();
        } catch (RemoteException e) {
            zzane.zzb("", e);
            this.zzbkl = "";
        }
        try {
            for (zzpw zzpwVar : zzpsVar.zzjr()) {
                if (!(zzpwVar instanceof IBinder) || (iBinder = (IBinder) zzpwVar) == null) {
                    zzpyVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzpyVar = iInterfaceQueryLocalInterface instanceof zzpw ? (zzpw) iInterfaceQueryLocalInterface : new zzpy(iBinder);
                }
                if (zzpyVar != null) {
                    this.zzbhf.add(new zzpz(zzpyVar));
                }
            }
        } catch (RemoteException e2) {
            zzane.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzbhf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzbkl;
    }
}
