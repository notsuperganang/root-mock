package com.google.firebase.iid;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class zzc implements Runnable {
    private final /* synthetic */ Intent zzr;
    private final /* synthetic */ Intent zzs;
    private final /* synthetic */ zzb zzt;

    zzc(zzb zzbVar, Intent intent, Intent intent2) {
        this.zzt = zzbVar;
        this.zzr = intent;
        this.zzs = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzt.zzd(this.zzr);
        this.zzt.zza(this.zzs);
    }
}
