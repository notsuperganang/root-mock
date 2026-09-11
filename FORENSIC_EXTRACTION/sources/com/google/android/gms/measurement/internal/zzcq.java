package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcq implements Runnable {
    private final /* synthetic */ String zzaeb;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaqo;
    private final /* synthetic */ String zzaqr;
    private final /* synthetic */ long zzaqs;

    zzcq(zzby zzbyVar, String str, String str2, String str3, long j) {
        this.zzaqo = zzbyVar;
        this.zzaqr = str;
        this.zzagj = str2;
        this.zzaeb = str3;
        this.zzaqs = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzaqr == null) {
            this.zzaqo.zzamx.zzmh().zzgm().zza(this.zzagj, (zzdx) null);
        } else {
            this.zzaqo.zzamx.zzmh().zzgm().zza(this.zzagj, new zzdx(this.zzaeb, this.zzaqr, this.zzaqs));
        }
    }
}
