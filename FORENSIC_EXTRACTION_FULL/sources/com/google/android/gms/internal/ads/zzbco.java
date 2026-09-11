package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzbco<K, V> extends LinkedHashMap<K, V> {
    private static final zzbco zzdwc;
    private boolean zzdpi;

    static {
        zzbco zzbcoVar = new zzbco();
        zzdwc = zzbcoVar;
        zzbcoVar.zzdpi = false;
    }

    private zzbco() {
        this.zzdpi = true;
    }

    private zzbco(Map<K, V> map) {
        super(map);
        this.zzdpi = true;
    }

    public static <K, V> zzbco<K, V> zzaeb() {
        return zzdwc;
    }

    private final void zzaed() {
        if (!this.zzdpi) {
            throw new UnsupportedOperationException();
        }
    }

    private static int zzr(Object obj) {
        if (obj instanceof byte[]) {
            return zzbbq.hashCode((byte[]) obj);
        }
        if (obj instanceof zzbbr) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzaed();
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
        int iZzr = 0;
        while (true) {
            int i = iZzr;
            if (!it.hasNext()) {
                return i;
            }
            Map.Entry<K, V> next = it.next();
            iZzr = (zzr(next.getValue()) ^ zzr(next.getKey())) + i;
        }
    }

    public final boolean isMutable() {
        return this.zzdpi;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zzaed();
        zzbbq.checkNotNull(k);
        zzbbq.checkNotNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzaed();
        for (K k : map.keySet()) {
            zzbbq.checkNotNull(k);
            zzbbq.checkNotNull(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzaed();
        return (V) super.remove(obj);
    }

    public final void zza(zzbco<K, V> zzbcoVar) {
        zzaed();
        if (zzbcoVar.isEmpty()) {
            return;
        }
        putAll(zzbcoVar);
    }

    public final void zzaaz() {
        this.zzdpi = false;
    }

    public final zzbco<K, V> zzaec() {
        return isEmpty() ? new zzbco<>() : new zzbco<>(this);
    }
}
