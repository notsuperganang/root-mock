package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
final class zzjv extends zzjr.zza<zzkn> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzarr;
    private final /* synthetic */ zzxn zzars;
    private final /* synthetic */ zzjr zzart;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjv(zzjr zzjrVar, Context context, String str, zzxn zzxnVar) {
        super();
        this.zzart = zzjrVar;
        this.val$context = context;
        this.zzarr = str;
        this.zzars = zzxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzkn zza(zzld zzldVar) throws RemoteException {
        return zzldVar.createAdLoaderBuilder(ObjectWrapper.wrap(this.val$context), this.zzarr, this.zzars, 12451000);
    }

    @Override // com.google.android.gms.internal.ads.zzjr.zza
    public final /* synthetic */ zzkn zzib() throws RemoteException {
        zzkn zzknVarZza = this.zzart.zzark.zza(this.val$context, this.zzarr, this.zzars);
        if (zzknVarZza != null) {
            return zzknVarZza;
        }
        zzjr zzjrVar = this.zzart;
        zzjr.zza(this.val$context, "native_ad");
        return new zzmf();
    }
}
