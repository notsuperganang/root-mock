package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
final class zzww<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzcbz;
    private final /* synthetic */ zzwo zzcca;
    private boolean zzcce;

    private zzww(zzwo zzwoVar) {
        this.zzcca = zzwoVar;
        this.pos = -1;
    }

    /* synthetic */ zzww(zzwo zzwoVar, zzwp zzwpVar) {
        this(zzwoVar);
    }

    private final Iterator<Map.Entry<K, V>> zzyh() {
        if (this.zzcbz == null) {
            this.zzcbz = this.zzcca.zzcbv.entrySet().iterator();
        }
        return this.zzcbz;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos + 1 < this.zzcca.zzcbu.size() || (!this.zzcca.zzcbv.isEmpty() && zzyh().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzcce = true;
        int i = this.pos + 1;
        this.pos = i;
        return i < this.zzcca.zzcbu.size() ? (Map.Entry) this.zzcca.zzcbu.get(this.pos) : zzyh().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzcce) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzcce = false;
        this.zzcca.zzyf();
        if (this.pos >= this.zzcca.zzcbu.size()) {
            zzyh().remove();
            return;
        }
        zzwo zzwoVar = this.zzcca;
        int i = this.pos;
        this.pos = i - 1;
        zzwoVar.zzby(i);
    }
}
