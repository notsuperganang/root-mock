package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzib<K, V> extends LinkedHashMap<K, V> {
    private static final zzib zzuw;
    private boolean zznk;

    static {
        zzib zzibVar = new zzib();
        zzuw = zzibVar;
        zzibVar.zznk = false;
    }

    private zzib() {
        this.zznk = true;
    }

    private zzib(Map<K, V> map) {
        super(map);
        this.zznk = true;
    }

    public static <K, V> zzib<K, V> zzep() {
        return zzuw;
    }

    private final void zzer() {
        if (!this.zznk) {
            throw new UnsupportedOperationException();
        }
    }

    private static int zzg(Object obj) {
        if (obj instanceof byte[]) {
            return zzhb.hashCode((byte[]) obj);
        }
        if (obj instanceof zzhc) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzer();
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
        int iZzg = 0;
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (true) {
            int i = iZzg;
            if (!it.hasNext()) {
                return i;
            }
            Map.Entry<K, V> next = it.next();
            iZzg = (zzg(next.getValue()) ^ zzg(next.getKey())) + i;
        }
    }

    public final boolean isMutable() {
        return this.zznk;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zzer();
        zzhb.checkNotNull(k);
        zzhb.checkNotNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzer();
        for (K k : map.keySet()) {
            zzhb.checkNotNull(k);
            zzhb.checkNotNull(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzer();
        return (V) super.remove(obj);
    }

    public final void zzb(zzib<K, V> zzibVar) {
        zzer();
        if (zzibVar.isEmpty()) {
            return;
        }
        putAll(zzibVar);
    }

    public final void zzbb() {
        this.zznk = false;
    }

    public final zzib<K, V> zzeq() {
        return isEmpty() ? new zzib<>() : new zzib<>(this);
    }
}
