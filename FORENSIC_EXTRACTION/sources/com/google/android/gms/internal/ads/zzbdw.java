package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
final class zzbdw<K, V> implements Comparable<zzbdw>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzbdp zzdyq;

    /* JADX INFO: Incorrect field signature: TK; */
    private final Comparable zzdyt;

    /* JADX WARN: Multi-variable type inference failed */
    zzbdw(zzbdp zzbdpVar, K k, V v) {
        this.zzdyq = zzbdpVar;
        this.zzdyt = k;
        this.value = v;
    }

    zzbdw(zzbdp zzbdpVar, Map.Entry<K, V> entry) {
        this(zzbdpVar, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzbdw zzbdwVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzbdwVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!equals(this.zzdyt, entry.getKey()) || !equals(this.value, entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzdyt;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return (this.zzdyt == null ? 0 : this.zzdyt.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzdyq.zzafv();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzdyt);
        String strValueOf2 = String.valueOf(this.value);
        return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length()).append(strValueOf).append("=").append(strValueOf2).toString();
    }
}
