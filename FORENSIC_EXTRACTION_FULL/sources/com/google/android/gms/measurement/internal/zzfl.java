package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
class zzfl extends zzcr implements zzct {
    protected final zzfn zzamx;

    zzfl(zzfn zzfnVar) {
        super(zzfnVar.zzmh());
        Preconditions.checkNotNull(zzfnVar);
        this.zzamx = zzfnVar;
    }

    public zzft zzjr() {
        return this.zzamx.zzjr();
    }

    public zzm zzjs() {
        return this.zzamx.zzjs();
    }

    public zzt zzjt() {
        return this.zzamx.zzjt();
    }
}
