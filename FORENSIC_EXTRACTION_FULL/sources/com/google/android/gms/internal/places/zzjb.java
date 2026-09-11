package com.google.android.gms.internal.places;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class zzjb<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzpk;
    private final int zzxd;
    private List<zzji> zzxe;
    private Map<K, V> zzxf;
    private volatile zzjk zzxg;
    private Map<K, V> zzxh;
    private volatile zzje zzxi;

    private zzjb(int i) {
        this.zzxd = i;
        this.zzxe = Collections.emptyList();
        this.zzxf = Collections.emptyMap();
        this.zzxh = Collections.emptyMap();
    }

    /* synthetic */ zzjb(int i, zzjc zzjcVar) {
        this(i);
    }

    private final int zzb(K k) {
        int i = 0;
        int size = this.zzxe.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo((Comparable) this.zzxe.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i2 = size;
        while (i <= i2) {
            int i3 = (i + i2) / 2;
            int iCompareTo2 = k.compareTo((Comparable) this.zzxe.get(i3).getKey());
            if (iCompareTo2 < 0) {
                i2 = i3 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i3;
                }
                i = i3 + 1;
            }
        }
        return -(i + 1);
    }

    static <FieldDescriptorType extends zzgs<FieldDescriptorType>> zzjb<FieldDescriptorType, Object> zzbm(int i) {
        return new zzjc(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzbo(int i) {
        zzgj();
        V v = (V) this.zzxe.remove(i).getValue();
        if (!this.zzxf.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzgk().entrySet().iterator();
            this.zzxe.add(new zzji(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzgj() {
        if (this.zzpk) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzgk() {
        zzgj();
        if (this.zzxf.isEmpty() && !(this.zzxf instanceof TreeMap)) {
            this.zzxf = new TreeMap();
            this.zzxh = ((TreeMap) this.zzxf).descendingMap();
        }
        return (SortedMap) this.zzxf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzgj();
        if (!this.zzxe.isEmpty()) {
            this.zzxe.clear();
        }
        if (this.zzxf.isEmpty()) {
            return;
        }
        this.zzxf.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzb(comparable) >= 0 || this.zzxf.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzxg == null) {
            this.zzxg = new zzjk(this, null);
        }
        return this.zzxg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjb)) {
            return super.equals(obj);
        }
        zzjb zzjbVar = (zzjb) obj;
        int size = size();
        if (size != zzjbVar.size()) {
            return false;
        }
        int iZzgg = zzgg();
        if (iZzgg != zzjbVar.zzgg()) {
            return entrySet().equals(zzjbVar.entrySet());
        }
        for (int i = 0; i < iZzgg; i++) {
            if (!zzbn(i).equals(zzjbVar.zzbn(i))) {
                return false;
            }
        }
        if (iZzgg != size) {
            return this.zzxf.equals(zzjbVar.zzxf);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZzb = zzb(comparable);
        return iZzb >= 0 ? (V) this.zzxe.get(iZzb).getValue() : this.zzxf.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZzgg = zzgg();
        int iHashCode = 0;
        for (int i = 0; i < iZzgg; i++) {
            iHashCode += this.zzxe.get(i).hashCode();
        }
        return this.zzxf.size() > 0 ? this.zzxf.hashCode() + iHashCode : iHashCode;
    }

    public final boolean isImmutable() {
        return this.zzpk;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzgj();
        Comparable comparable = (Comparable) obj;
        int iZzb = zzb(comparable);
        if (iZzb >= 0) {
            return zzbo(iZzb);
        }
        if (this.zzxf.isEmpty()) {
            return null;
        }
        return this.zzxf.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzxe.size() + this.zzxf.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzgj();
        int iZzb = zzb(k);
        if (iZzb >= 0) {
            return (V) this.zzxe.get(iZzb).setValue(v);
        }
        zzgj();
        if (this.zzxe.isEmpty() && !(this.zzxe instanceof ArrayList)) {
            this.zzxe = new ArrayList(this.zzxd);
        }
        int i = -(iZzb + 1);
        if (i >= this.zzxd) {
            return zzgk().put(k, v);
        }
        if (this.zzxe.size() == this.zzxd) {
            zzji zzjiVarRemove = this.zzxe.remove(this.zzxd - 1);
            zzgk().put((Comparable) zzjiVarRemove.getKey(), zzjiVarRemove.getValue());
        }
        this.zzxe.add(i, new zzji(this, k, v));
        return null;
    }

    public void zzbb() {
        if (this.zzpk) {
            return;
        }
        this.zzxf = this.zzxf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzxf);
        this.zzxh = this.zzxh.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzxh);
        this.zzpk = true;
    }

    public final Map.Entry<K, V> zzbn(int i) {
        return this.zzxe.get(i);
    }

    public final int zzgg() {
        return this.zzxe.size();
    }

    public final Iterable<Map.Entry<K, V>> zzgh() {
        return this.zzxf.isEmpty() ? zzjf.zzgm() : this.zzxf.entrySet();
    }

    final Set<Map.Entry<K, V>> zzgi() {
        if (this.zzxi == null) {
            this.zzxi = new zzje(this, null);
        }
        return this.zzxi;
    }
}
