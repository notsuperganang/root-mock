package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzvb<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzbzv;

    public zzvb(Iterator<Map.Entry<K, Object>> it) {
        this.zzbzv = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzbzv.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzbzv.next();
        return next.getValue() instanceof zzuy ? new zzva(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzbzv.remove();
    }
}
