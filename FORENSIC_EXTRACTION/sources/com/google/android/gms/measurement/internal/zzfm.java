package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class zzfm extends zzfl {
    private boolean zzvz;

    zzfm(zzfn zzfnVar) {
        super(zzfnVar);
        this.zzamx.zzb(this);
    }

    final boolean isInitialized() {
        return this.zzvz;
    }

    protected final void zzcl() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    protected abstract boolean zzgy();

    public final void zzq() {
        if (this.zzvz) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzgy();
        this.zzamx.zzmg();
        this.zzvz = true;
    }
}
