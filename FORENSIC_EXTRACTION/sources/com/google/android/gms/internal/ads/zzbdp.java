package com.google.android.gms.internal.ads;

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
class zzbdp<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzdqy;
    private final int zzdyj;
    private List<zzbdw> zzdyk;
    private Map<K, V> zzdyl;
    private volatile zzbdy zzdym;
    private Map<K, V> zzdyn;
    private volatile zzbds zzdyo;

    private zzbdp(int i) {
        this.zzdyj = i;
        this.zzdyk = Collections.emptyList();
        this.zzdyl = Collections.emptyMap();
        this.zzdyn = Collections.emptyMap();
    }

    /* synthetic */ zzbdp(int i, zzbdq zzbdqVar) {
        this(i);
    }

    private final int zza(K k) {
        int i = 0;
        int size = this.zzdyk.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo((Comparable) this.zzdyk.get(size).getKey());
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
            int iCompareTo2 = k.compareTo((Comparable) this.zzdyk.get(i3).getKey());
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzafv() {
        if (this.zzdqy) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzafw() {
        zzafv();
        if (this.zzdyl.isEmpty() && !(this.zzdyl instanceof TreeMap)) {
            this.zzdyl = new TreeMap();
            this.zzdyn = ((TreeMap) this.zzdyl).descendingMap();
        }
        return (SortedMap) this.zzdyl;
    }

    static <FieldDescriptorType extends zzbbi<FieldDescriptorType>> zzbdp<FieldDescriptorType, Object> zzcx(int i) {
        return new zzbdq(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzcz(int i) {
        zzafv();
        V v = (V) this.zzdyk.remove(i).getValue();
        if (!this.zzdyl.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzafw().entrySet().iterator();
            this.zzdyk.add(new zzbdw(this, it.next()));
            it.remove();
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzafv();
        if (!this.zzdyk.isEmpty()) {
            this.zzdyk.clear();
        }
        if (this.zzdyl.isEmpty()) {
            return;
        }
        this.zzdyl.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzdyl.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzdym == null) {
            this.zzdym = new zzbdy(this, null);
        }
        return this.zzdym;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof zzbdp)) {
                return super.equals(obj);
            }
            zzbdp zzbdpVar = (zzbdp) obj;
            int size = size();
            if (size != zzbdpVar.size()) {
                return false;
            }
            int iZzafs = zzafs();
            if (iZzafs != zzbdpVar.zzafs()) {
                return entrySet().equals(zzbdpVar.entrySet());
            }
            for (int i = 0; i < iZzafs; i++) {
                if (!zzcy(i).equals(zzbdpVar.zzcy(i))) {
                    return false;
                }
            }
            if (iZzafs != size) {
                return this.zzdyl.equals(zzbdpVar.zzdyl);
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        return iZza >= 0 ? (V) this.zzdyk.get(iZza).getValue() : this.zzdyl.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZzafs = zzafs();
        int iHashCode = 0;
        for (int i = 0; i < iZzafs; i++) {
            iHashCode += this.zzdyk.get(i).hashCode();
        }
        return this.zzdyl.size() > 0 ? this.zzdyl.hashCode() + iHashCode : iHashCode;
    }

    public final boolean isImmutable() {
        return this.zzdqy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzafv();
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        if (iZza >= 0) {
            return zzcz(iZza);
        }
        if (this.zzdyl.isEmpty()) {
            return null;
        }
        return this.zzdyl.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzdyk.size() + this.zzdyl.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzafv();
        int iZza = zza(k);
        if (iZza >= 0) {
            return (V) this.zzdyk.get(iZza).setValue(v);
        }
        zzafv();
        if (this.zzdyk.isEmpty() && !(this.zzdyk instanceof ArrayList)) {
            this.zzdyk = new ArrayList(this.zzdyj);
        }
        int i = -(iZza + 1);
        if (i >= this.zzdyj) {
            return zzafw().put(k, v);
        }
        if (this.zzdyk.size() == this.zzdyj) {
            zzbdw zzbdwVarRemove = this.zzdyk.remove(this.zzdyj - 1);
            zzafw().put((Comparable) zzbdwVarRemove.getKey(), zzbdwVarRemove.getValue());
        }
        this.zzdyk.add(i, new zzbdw(this, k, v));
        return null;
    }

    public void zzaaz() {
        if (this.zzdqy) {
            return;
        }
        this.zzdyl = this.zzdyl.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzdyl);
        this.zzdyn = this.zzdyn.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzdyn);
        this.zzdqy = true;
    }

    public final int zzafs() {
        return this.zzdyk.size();
    }

    public final Iterable<Map.Entry<K, V>> zzaft() {
        return this.zzdyl.isEmpty() ? zzbdt.zzafy() : this.zzdyl.entrySet();
    }

    final Set<Map.Entry<K, V>> zzafu() {
        if (this.zzdyo == null) {
            this.zzdyo = new zzbds(this, null);
        }
        return this.zzdyo;
    }

    public final Map.Entry<K, V> zzcy(int i) {
        return this.zzdyk.get(i);
    }
}
