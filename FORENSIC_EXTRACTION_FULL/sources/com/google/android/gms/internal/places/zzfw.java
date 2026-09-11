package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzfw {
    private final byte[] buffer;
    private final zzgf zznz;

    private zzfw(int i) {
        this.buffer = new byte[i];
        this.zznz = zzgf.zzd(this.buffer);
    }

    /* synthetic */ zzfw(int i, zzfs zzfsVar) {
        this(i);
    }

    public final zzfr zzch() {
        if (this.zznz.zzcs() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        return new zzfy(this.buffer);
    }

    public final zzgf zzci() {
        return this.zznz;
    }
}
