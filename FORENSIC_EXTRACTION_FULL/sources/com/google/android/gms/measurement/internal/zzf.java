package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class zzf extends zze {
    private boolean zzvz;

    zzf(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzada.zzb(this);
    }

    final boolean isInitialized() {
        return this.zzvz;
    }

    protected final void zzcl() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzgx() {
        if (this.zzvz) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzgz();
        this.zzada.zzku();
        this.zzvz = true;
    }

    protected abstract boolean zzgy();

    protected void zzgz() {
    }

    public final void zzq() {
        if (this.zzvz) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzgy()) {
            return;
        }
        this.zzada.zzku();
        this.zzvz = true;
    }
}
