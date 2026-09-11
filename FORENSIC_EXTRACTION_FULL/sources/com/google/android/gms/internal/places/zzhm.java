package com.google.android.gms.internal.places;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzhm<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzhk> zzud;

    private zzhm(Map.Entry<K, zzhk> entry) {
        this.zzud = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzud.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzud.getValue() == null) {
            return null;
        }
        return zzhk.zzei();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzih) {
            return this.zzud.getValue().zzj((zzih) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzhk zzej() {
        return this.zzud.getValue();
    }
}
