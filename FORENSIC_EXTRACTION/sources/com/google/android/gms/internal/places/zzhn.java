package com.google.android.gms.internal.places;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzhn<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzue;

    public zzhn(Iterator<Map.Entry<K, Object>> it) {
        this.zzue = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzue.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzue.next();
        return next.getValue() instanceof zzhk ? new zzhm(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzue.remove();
    }
}
