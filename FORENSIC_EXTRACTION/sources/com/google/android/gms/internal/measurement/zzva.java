package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzva<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzuy> zzbzu;

    private zzva(Map.Entry<K, zzuy> entry) {
        this.zzbzu = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzbzu.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzbzu.getValue() == null) {
            return null;
        }
        return zzuy.zzwz();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzvv) {
            return this.zzbzu.getValue().zzi((zzvv) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzuy zzxa() {
        return this.zzbzu.getValue();
    }
}
