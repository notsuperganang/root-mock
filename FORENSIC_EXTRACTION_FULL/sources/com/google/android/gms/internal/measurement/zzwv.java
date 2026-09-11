package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
final class zzwv<K, V> implements Comparable<zzwv>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzwo zzcca;

    /* JADX INFO: Incorrect field signature: TK; */
    private final Comparable zzccd;

    /* JADX WARN: Multi-variable type inference failed */
    zzwv(zzwo zzwoVar, K k, V v) {
        this.zzcca = zzwoVar;
        this.zzccd = k;
        this.value = v;
    }

    zzwv(zzwo zzwoVar, Map.Entry<K, V> entry) {
        this(zzwoVar, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzwv zzwvVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzwvVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!equals(this.zzccd, entry.getKey()) || !equals(this.value, entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzccd;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return (this.zzccd == null ? 0 : this.zzccd.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzcca.zzyf();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzccd);
        String strValueOf2 = String.valueOf(this.value);
        return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length()).append(strValueOf).append("=").append(strValueOf2).toString();
    }
}
