package com.google.android.gms.internal.places;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzje extends zzjk {
    private final /* synthetic */ zzjb zzxk;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzje(zzjb zzjbVar) {
        super(zzjbVar, null);
        this.zzxk = zzjbVar;
    }

    /* synthetic */ zzje(zzjb zzjbVar, zzjc zzjcVar) {
        this(zzjbVar);
    }

    @Override // com.google.android.gms.internal.places.zzjk, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzjd(this.zzxk, null);
    }
}
