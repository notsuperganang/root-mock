package com.google.android.gms.internal.places;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
final class zzjj<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzxj;
    private final /* synthetic */ zzjb zzxk;
    private boolean zzxo;

    private zzjj(zzjb zzjbVar) {
        this.zzxk = zzjbVar;
        this.pos = -1;
    }

    /* synthetic */ zzjj(zzjb zzjbVar, zzjc zzjcVar) {
        this(zzjbVar);
    }

    private final Iterator<Map.Entry<K, V>> zzgl() {
        if (this.zzxj == null) {
            this.zzxj = this.zzxk.zzxf.entrySet().iterator();
        }
        return this.zzxj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos + 1 < this.zzxk.zzxe.size() || (!this.zzxk.zzxf.isEmpty() && zzgl().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzxo = true;
        int i = this.pos + 1;
        this.pos = i;
        return i < this.zzxk.zzxe.size() ? (Map.Entry) this.zzxk.zzxe.get(this.pos) : zzgl().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzxo) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzxo = false;
        this.zzxk.zzgj();
        if (this.pos >= this.zzxk.zzxe.size()) {
            zzgl().remove();
            return;
        }
        zzjb zzjbVar = this.zzxk;
        int i = this.pos;
        this.pos = i - 1;
        zzjbVar.zzbo(i);
    }
}
