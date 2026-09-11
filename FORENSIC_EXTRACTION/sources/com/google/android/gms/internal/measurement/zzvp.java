package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzvp<K, V> extends LinkedHashMap<K, V> {
    private static final zzvp zzcan;
    private boolean zzbtn;

    static {
        zzvp zzvpVar = new zzvp();
        zzcan = zzvpVar;
        zzvpVar.zzbtn = false;
    }

    private zzvp() {
        this.zzbtn = true;
    }

    private zzvp(Map<K, V> map) {
        super(map);
        this.zzbtn = true;
    }

    private static int zzab(Object obj) {
        if (obj instanceof byte[]) {
            return zzuq.hashCode((byte[]) obj);
        }
        if (obj instanceof zzur) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    public static <K, V> zzvp<K, V> zzxg() {
        return zzcan;
    }

    private final void zzxi() {
        if (!this.zzbtn) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzxi();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean z;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    Iterator<Map.Entry<K, V>> it = entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                        Map.Entry<K, V> next = it.next();
                        if (!map.containsKey(next.getKey())) {
                            z = false;
                            break;
                        }
                        V value = next.getValue();
                        Object obj2 = map.get(next.getKey());
                        if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
            } else {
                z = true;
                break;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        int iZzab = 0;
        while (true) {
            int i = iZzab;
            if (!it.hasNext()) {
                return i;
            }
            Map.Entry<K, V> next = it.next();
            iZzab = (zzab(next.getValue()) ^ zzab(next.getKey())) + i;
        }
    }

    public final boolean isMutable() {
        return this.zzbtn;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zzxi();
        zzuq.checkNotNull(k);
        zzuq.checkNotNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzxi();
        for (K k : map.keySet()) {
            zzuq.checkNotNull(k);
            zzuq.checkNotNull(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzxi();
        return (V) super.remove(obj);
    }

    public final void zza(zzvp<K, V> zzvpVar) {
        zzxi();
        if (zzvpVar.isEmpty()) {
            return;
        }
        putAll(zzvpVar);
    }

    public final void zzsw() {
        this.zzbtn = false;
    }

    public final zzvp<K, V> zzxh() {
        return isEmpty() ? new zzvp<>() : new zzvp<>(this);
    }
}
