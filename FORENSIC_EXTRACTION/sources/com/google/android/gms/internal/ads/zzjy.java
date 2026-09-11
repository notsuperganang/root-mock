package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
final class zzjy extends zzjr.zza<zzqf> {
    private final /* synthetic */ zzjr zzart;
    private final /* synthetic */ View zzarw;
    private final /* synthetic */ HashMap zzarx;
    private final /* synthetic */ HashMap zzary;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjy(zzjr zzjrVar, View view, HashMap map, HashMap map2) {
        super();
        this.zzart = zzjrVar;
        this.zzarw = view;
        this.zzarx = map;
        this.zzary = map2;
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzqf zza(zzld zzldVar) throws RemoteException {
        return zzldVar.createNativeAdViewHolderDelegate(ObjectWrapper.wrap(this.zzarw), ObjectWrapper.wrap(this.zzarx), ObjectWrapper.wrap(this.zzary));
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzqf zzib() throws RemoteException {
        zzqf zzqfVarZzb = this.zzart.zzarp.zzb(this.zzarw, this.zzarx, this.zzary);
        if (zzqfVarZzb != null) {
            return zzqfVarZzb;
        }
        zzjr zzjrVar = this.zzart;
        zzjr.zza(this.zzarw.getContext(), "native_ad_view_holder_delegate");
        return new zzmn();
    }
}
