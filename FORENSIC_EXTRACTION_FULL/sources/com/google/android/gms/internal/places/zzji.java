package com.google.android.gms.internal.places;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
final class zzji<K, V> implements Comparable<zzji>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzjb zzxk;

    /* JADX INFO: Incorrect field signature: TK; */
    private final Comparable zzxn;

    /* JADX WARN: Multi-variable type inference failed */
    zzji(zzjb zzjbVar, K k, V v) {
        this.zzxk = zzjbVar;
        this.zzxn = k;
        this.value = v;
    }

    zzji(zzjb zzjbVar, Map.Entry<K, V> entry) {
        this(zzjbVar, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzji zzjiVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzjiVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzxn, entry.getKey()) && equals(this.value, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzxn;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return (this.zzxn == null ? 0 : this.zzxn.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzxk.zzgj();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzxn);
        String strValueOf2 = String.valueOf(this.value);
        return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length()).append(strValueOf).append("=").append(strValueOf2).toString();
    }
}
