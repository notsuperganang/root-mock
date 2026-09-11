package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzdd implements Runnable {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzads;
    private final /* synthetic */ zzda zzarh;
    private final /* synthetic */ long zzari;
    private final /* synthetic */ Object zzarm;

    zzdd(zzda zzdaVar, String str, String str2, Object obj, long j) {
        this.zzarh = zzdaVar;
        this.zzads = str;
        this.val$name = str2;
        this.zzarm = obj;
        this.zzari = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarh.zza(this.zzads, this.val$name, this.zzarm, this.zzari);
    }
}
