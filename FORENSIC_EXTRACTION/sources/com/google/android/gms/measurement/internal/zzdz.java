package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzdz implements Runnable {
    private final /* synthetic */ boolean zzarz;
    private final /* synthetic */ zzdx zzasa;
    private final /* synthetic */ zzdx zzasb;
    private final /* synthetic */ zzdy zzasc;

    zzdz(zzdy zzdyVar, boolean z, zzdx zzdxVar, zzdx zzdxVar2) {
        this.zzasc = zzdyVar;
        this.zzarz = z;
        this.zzasa = zzdxVar;
        this.zzasb = zzdxVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        if (this.zzasc.zzgv().zzbk(this.zzasc.zzgk().zzal())) {
            z = this.zzarz && this.zzasc.zzart != null;
            if (z) {
                this.zzasc.zza(this.zzasc.zzart, true);
            }
        } else {
            if (this.zzarz && this.zzasc.zzart != null) {
                this.zzasc.zza(this.zzasc.zzart, true);
            }
            z = false;
        }
        if ((this.zzasa != null && this.zzasa.zzarr == this.zzasb.zzarr && zzfx.zzv(this.zzasa.zzarq, this.zzasb.zzarq) && zzfx.zzv(this.zzasa.zzuw, this.zzasb.zzuw)) ? false : true) {
            Bundle bundle = new Bundle();
            zzdy.zza(this.zzasb, bundle, true);
            if (this.zzasa != null) {
                if (this.zzasa.zzuw != null) {
                    bundle.putString("_pn", this.zzasa.zzuw);
                }
                bundle.putString("_pc", this.zzasa.zzarq);
                bundle.putLong("_pi", this.zzasa.zzarr);
            }
            if (this.zzasc.zzgv().zzbk(this.zzasc.zzgk().zzal()) && z) {
                long jZzlp = this.zzasc.zzgo().zzlp();
                if (jZzlp > 0) {
                    this.zzasc.zzgr().zza(bundle, jZzlp);
                }
            }
            this.zzasc.zzgj().zza("auto", "_vs", bundle);
        }
        this.zzasc.zzart = this.zzasb;
        this.zzasc.zzgl().zza(this.zzasb);
    }
}
