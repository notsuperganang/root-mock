package com.google.android.gms.internal.places;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
final class zzjd<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzxj;
    private final /* synthetic */ zzjb zzxk;

    private zzjd(zzjb zzjbVar) {
        this.zzxk = zzjbVar;
        this.pos = this.zzxk.zzxe.size();
    }

    /* synthetic */ zzjd(zzjb zzjbVar, zzjc zzjcVar) {
        this(zzjbVar);
    }

    private final Iterator<Map.Entry<K, V>> zzgl() {
        if (this.zzxj == null) {
            this.zzxj = this.zzxk.zzxh.entrySet().iterator();
        }
        return this.zzxj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return (this.pos > 0 && this.pos <= this.zzxk.zzxe.size()) || zzgl().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzgl().hasNext()) {
            return zzgl().next();
        }
        List list = this.zzxk.zzxe;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
