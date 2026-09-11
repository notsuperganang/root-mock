package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
final class zzka extends zzjr.zza<zzaap> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzjr zzart;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzka(zzjr zzjrVar, Activity activity) {
        super();
        this.zzart = zzjrVar;
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzaap zza(zzld zzldVar) throws RemoteException {
        return zzldVar.createAdOverlay(ObjectWrapper.wrap(this.val$activity));
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzaap zzib() throws RemoteException {
        zzaap zzaapVarZze = this.zzart.zzaro.zze(this.val$activity);
        if (zzaapVarZze != null) {
            return zzaapVarZze;
        }
        zzjr zzjrVar = this.zzart;
        zzjr.zza(this.val$activity, "ad_overlay");
        return null;
    }
}
