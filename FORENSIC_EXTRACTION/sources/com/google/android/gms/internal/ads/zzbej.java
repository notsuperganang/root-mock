package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzbej implements Iterator<String> {
    private final /* synthetic */ zzbeh zzdzc;
    private Iterator<String> zzdzd;

    zzbej(zzbeh zzbehVar) {
        this.zzdzc = zzbehVar;
        this.zzdzd = this.zzdzc.zzdyz.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzdzd.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzdzd.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
