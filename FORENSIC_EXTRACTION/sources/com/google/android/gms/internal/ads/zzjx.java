package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
final class zzjx extends zzjr.zza<zzqa> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzjr zzart;
    private final /* synthetic */ FrameLayout zzaru;
    private final /* synthetic */ FrameLayout zzarv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjx(zzjr zzjrVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        super();
        this.zzart = zzjrVar;
        this.zzaru = frameLayout;
        this.zzarv = frameLayout2;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzqa zza(zzld zzldVar) throws RemoteException {
        return zzldVar.createNativeAdViewDelegate(ObjectWrapper.wrap(this.zzaru), ObjectWrapper.wrap(this.zzarv));
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzqa zzib() throws RemoteException {
        zzqa zzqaVarZzb = this.zzart.zzarm.zzb(this.val$context, this.zzaru, this.zzarv);
        if (zzqaVarZzb != null) {
            return zzqaVarZzb;
        }
        zzjr zzjrVar = this.zzart;
        zzjr.zza(this.val$context, "native_ad_view_delegate");
        return new zzmm();
    }
}
