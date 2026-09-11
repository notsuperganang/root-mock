package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
final class zzbdx<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzdyp;
    private final /* synthetic */ zzbdp zzdyq;
    private boolean zzdyu;

    private zzbdx(zzbdp zzbdpVar) {
        this.zzdyq = zzbdpVar;
        this.pos = -1;
    }

    /* synthetic */ zzbdx(zzbdp zzbdpVar, zzbdq zzbdqVar) {
        this(zzbdpVar);
    }

    private final Iterator<Map.Entry<K, V>> zzafx() {
        if (this.zzdyp == null) {
            this.zzdyp = this.zzdyq.zzdyl.entrySet().iterator();
        }
        return this.zzdyp;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos + 1 < this.zzdyq.zzdyk.size() || (!this.zzdyq.zzdyl.isEmpty() && zzafx().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzdyu = true;
        int i = this.pos + 1;
        this.pos = i;
        return i < this.zzdyq.zzdyk.size() ? (Map.Entry) this.zzdyq.zzdyk.get(this.pos) : zzafx().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzdyu) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzdyu = false;
        this.zzdyq.zzafv();
        if (this.pos >= this.zzdyq.zzdyk.size()) {
            zzafx().remove();
            return;
        }
        zzbdp zzbdpVar = this.zzdyq;
        int i = this.pos;
        this.pos = i - 1;
        zzbdpVar.zzcz(i);
    }
}
