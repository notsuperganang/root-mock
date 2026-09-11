package com.google.android.gms.internal.places;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzjv implements Iterator<String> {
    private final /* synthetic */ zzjt zzxv;
    private Iterator<String> zzxw;

    zzjv(zzjt zzjtVar) {
        this.zzxv = zzjtVar;
        this.zzxw = this.zzxv.zzxt.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzxw.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzxw.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
