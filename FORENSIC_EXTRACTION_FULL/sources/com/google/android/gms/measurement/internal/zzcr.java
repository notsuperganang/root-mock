package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
class zzcr implements zzct {
    protected final zzbw zzada;

    zzcr(zzbw zzbwVar) {
        Preconditions.checkNotNull(zzbwVar);
        this.zzada = zzbwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public Context getContext() {
        return this.zzada.getContext();
    }

    public void zzaf() {
        this.zzada.zzgs().zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public Clock zzbx() {
        return this.zzada.zzbx();
    }

    public void zzgf() {
        this.zzada.zzgf();
    }

    public void zzgg() {
        this.zzada.zzgg();
    }

    public void zzgh() {
        this.zzada.zzgs().zzgh();
    }

    public zzaa zzgp() {
        return this.zzada.zzgp();
    }

    public zzaq zzgq() {
        return this.zzada.zzgq();
    }

    public zzfx zzgr() {
        return this.zzada.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public zzbr zzgs() {
        return this.zzada.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public zzas zzgt() {
        return this.zzada.zzgt();
    }

    public zzbd zzgu() {
        return this.zzada.zzgu();
    }

    public zzq zzgv() {
        return this.zzada.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public zzn zzgw() {
        return this.zzada.zzgw();
    }
}
