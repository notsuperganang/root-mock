package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zztm {
    private final byte[] buffer;
    private final zztv zzbty;

    private zztm(int i) {
        this.buffer = new byte[i];
        this.zzbty = zztv.zzj(this.buffer);
    }

    /* synthetic */ zztm(int i, zztf zztfVar) {
        this(i);
    }

    public final zzte zzuh() {
        if (this.zzbty.zzvj() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        return new zzto(this.buffer);
    }

    public final zztv zzui() {
        return this.zzbty;
    }
}
