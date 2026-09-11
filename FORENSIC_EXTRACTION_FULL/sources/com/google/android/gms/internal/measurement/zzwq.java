package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
final class zzwq<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzcbz;
    private final /* synthetic */ zzwo zzcca;

    private zzwq(zzwo zzwoVar) {
        this.zzcca = zzwoVar;
        this.pos = this.zzcca.zzcbu.size();
    }

    /* synthetic */ zzwq(zzwo zzwoVar, zzwp zzwpVar) {
        this(zzwoVar);
    }

    private final Iterator<Map.Entry<K, V>> zzyh() {
        if (this.zzcbz == null) {
            this.zzcbz = this.zzcca.zzcbx.entrySet().iterator();
        }
        return this.zzcbz;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return (this.pos > 0 && this.pos <= this.zzcca.zzcbu.size()) || zzyh().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzyh().hasNext()) {
            return zzyh().next();
        }
        List list = this.zzcca.zzcbu;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
