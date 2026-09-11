package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzat implements Runnable {
    private final /* synthetic */ int zzamf;
    private final /* synthetic */ String zzamg;
    private final /* synthetic */ Object zzamh;
    private final /* synthetic */ Object zzami;
    private final /* synthetic */ Object zzamj;
    private final /* synthetic */ zzas zzamk;

    zzat(zzas zzasVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzamk = zzasVar;
        this.zzamf = i;
        this.zzamg = str;
        this.zzamh = obj;
        this.zzami = obj2;
        this.zzamj = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbd zzbdVarZzgu = this.zzamk.zzada.zzgu();
        if (!zzbdVarZzgu.isInitialized()) {
            this.zzamk.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzamk.zzalu == 0) {
            if (this.zzamk.zzgv().zzdw()) {
                zzas zzasVar = this.zzamk;
                this.zzamk.zzgw();
                zzasVar.zzalu = 'C';
            } else {
                zzas zzasVar2 = this.zzamk;
                this.zzamk.zzgw();
                zzasVar2.zzalu = 'c';
            }
        }
        if (this.zzamk.zzade < 0) {
            this.zzamk.zzade = this.zzamk.zzgv().zzhh();
        }
        char cCharAt = "01VDIWEA?".charAt(this.zzamf);
        char c = this.zzamk.zzalu;
        long j = this.zzamk.zzade;
        String strZza = zzas.zza(true, this.zzamg, this.zzamh, this.zzami, this.zzamj);
        String string = new StringBuilder(String.valueOf(strZza).length() + 24).append("2").append(cCharAt).append(c).append(j).append(":").append(strZza).toString();
        if (string.length() > 1024) {
            string = this.zzamg.substring(0, 1024);
        }
        zzbdVarZzgu.zzanb.zzc(string, 1L);
    }
}
