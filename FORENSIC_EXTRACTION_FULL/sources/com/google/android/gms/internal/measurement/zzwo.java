package com.google.android.gms.internal.measurement;

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
class zzwo<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzbqa;
    private final int zzcbt;
    private List<zzwv> zzcbu;
    private Map<K, V> zzcbv;
    private volatile zzwx zzcbw;
    private Map<K, V> zzcbx;
    private volatile zzwr zzcby;

    private zzwo(int i) {
        this.zzcbt = i;
        this.zzcbu = Collections.emptyList();
        this.zzcbv = Collections.emptyMap();
        this.zzcbx = Collections.emptyMap();
    }

    /* synthetic */ zzwo(int i, zzwp zzwpVar) {
        this(i);
    }

    private final int zza(K k) {
        int i = 0;
        int size = this.zzcbu.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo((Comparable) this.zzcbu.get(size).getKey());
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
            int iCompareTo2 = k.compareTo((Comparable) this.zzcbu.get(i3).getKey());
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

    static <FieldDescriptorType extends zzuh<FieldDescriptorType>> zzwo<FieldDescriptorType, Object> zzbw(int i) {
        return new zzwp(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzby(int i) {
        zzyf();
        V v = (V) this.zzcbu.remove(i).getValue();
        if (!this.zzcbv.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzyg().entrySet().iterator();
            this.zzcbu.add(new zzwv(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzyf() {
        if (this.zzbqa) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzyg() {
        zzyf();
        if (this.zzcbv.isEmpty() && !(this.zzcbv instanceof TreeMap)) {
            this.zzcbv = new TreeMap();
            this.zzcbx = ((TreeMap) this.zzcbv).descendingMap();
        }
        return (SortedMap) this.zzcbv;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzyf();
        if (!this.zzcbu.isEmpty()) {
            this.zzcbu.clear();
        }
        if (this.zzcbv.isEmpty()) {
            return;
        }
        this.zzcbv.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzcbv.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzcbw == null) {
            this.zzcbw = new zzwx(this, null);
        }
        return this.zzcbw;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof zzwo)) {
                return super.equals(obj);
            }
            zzwo zzwoVar = (zzwo) obj;
            int size = size();
            if (size != zzwoVar.size()) {
                return false;
            }
            int iZzyc = zzyc();
            if (iZzyc != zzwoVar.zzyc()) {
                return entrySet().equals(zzwoVar.entrySet());
            }
            for (int i = 0; i < iZzyc; i++) {
                if (!zzbx(i).equals(zzwoVar.zzbx(i))) {
                    return false;
                }
            }
            if (iZzyc != size) {
                return this.zzcbv.equals(zzwoVar.zzcbv);
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        return iZza >= 0 ? (V) this.zzcbu.get(iZza).getValue() : this.zzcbv.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZzyc = zzyc();
        int iHashCode = 0;
        for (int i = 0; i < iZzyc; i++) {
            iHashCode += this.zzcbu.get(i).hashCode();
        }
        return this.zzcbv.size() > 0 ? this.zzcbv.hashCode() + iHashCode : iHashCode;
    }

    public final boolean isImmutable() {
        return this.zzbqa;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzyf();
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        if (iZza >= 0) {
            return zzby(iZza);
        }
        if (this.zzcbv.isEmpty()) {
            return null;
        }
        return this.zzcbv.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzcbu.size() + this.zzcbv.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzyf();
        int iZza = zza(k);
        if (iZza >= 0) {
            return (V) this.zzcbu.get(iZza).setValue(v);
        }
        zzyf();
        if (this.zzcbu.isEmpty() && !(this.zzcbu instanceof ArrayList)) {
            this.zzcbu = new ArrayList(this.zzcbt);
        }
        int i = -(iZza + 1);
        if (i >= this.zzcbt) {
            return zzyg().put(k, v);
        }
        if (this.zzcbu.size() == this.zzcbt) {
            zzwv zzwvVarRemove = this.zzcbu.remove(this.zzcbt - 1);
            zzyg().put((Comparable) zzwvVarRemove.getKey(), zzwvVarRemove.getValue());
        }
        this.zzcbu.add(i, new zzwv(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zzbx(int i) {
        return this.zzcbu.get(i);
    }

    public void zzsw() {
        if (this.zzbqa) {
            return;
        }
        this.zzcbv = this.zzcbv.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzcbv);
        this.zzcbx = this.zzcbx.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzcbx);
        this.zzbqa = true;
    }

    public final int zzyc() {
        return this.zzcbu.size();
    }

    public final Iterable<Map.Entry<K, V>> zzyd() {
        return this.zzcbv.isEmpty() ? zzws.zzyi() : this.zzcbv.entrySet();
    }

    final Set<Map.Entry<K, V>> zzye() {
        if (this.zzcby == null) {
            this.zzcby = new zzwr(this, null);
        }
        return this.zzcby;
    }
}
