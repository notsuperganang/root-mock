package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzae implements Iterator<String> {
    private Iterator<String> zzaie;
    private final /* synthetic */ zzad zzaif;

    zzae(zzad zzadVar) {
        this.zzaif = zzadVar;
        this.zzaie = this.zzaif.zzaid.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzaie.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzaie.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
