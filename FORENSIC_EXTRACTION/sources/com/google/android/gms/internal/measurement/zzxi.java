package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzxi implements Iterator<String> {
    private final /* synthetic */ zzxg zzccm;
    private Iterator<String> zzccn;

    zzxi(zzxg zzxgVar) {
        this.zzccm = zzxgVar;
        this.zzccn = this.zzccm.zzccj.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzccn.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzccn.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
