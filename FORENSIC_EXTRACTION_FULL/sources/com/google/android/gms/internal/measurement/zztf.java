package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zztf extends zzth {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzte zzbtv;

    zztf(zzte zzteVar) {
        this.zzbtv = zzteVar;
        this.limit = this.zzbtv.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.measurement.zztl
    public final byte nextByte() {
        int i = this.position;
        if (i >= this.limit) {
            throw new NoSuchElementException();
        }
        this.position = i + 1;
        return this.zzbtv.zzan(i);
    }
}
