package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzbci extends zzbab<Long> implements zzbbt<Long>, RandomAccess {
    private static final zzbci zzdvt;
    private int size;
    private long[] zzdvu;

    static {
        zzbci zzbciVar = new zzbci();
        zzdvt = zzbciVar;
        zzbciVar.zzaaz();
    }

    zzbci() {
        this(new long[10], 0);
    }

    private zzbci(long[] jArr, int i) {
        this.zzdvu = jArr;
        this.size = i;
    }

    private final void zzbk(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzbl(i));
        }
    }

    private final String zzbl(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.size).toString();
    }

    private final void zzk(int i, long j) {
        zzaba();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzbl(i));
        }
        if (this.size < this.zzdvu.length) {
            System.arraycopy(this.zzdvu, i, this.zzdvu, i + 1, this.size - i);
        } else {
            long[] jArr = new long[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzdvu, 0, jArr, 0, i);
            System.arraycopy(this.zzdvu, i, jArr, i + 1, this.size - i);
            this.zzdvu = jArr;
        }
        this.zzdvu[i] = j;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzk(i, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzaba();
        zzbbq.checkNotNull(collection);
        if (!(collection instanceof zzbci)) {
            return super.addAll(collection);
        }
        zzbci zzbciVar = (zzbci) collection;
        if (zzbciVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzbciVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzbciVar.size;
        if (i > this.zzdvu.length) {
            this.zzdvu = Arrays.copyOf(this.zzdvu, i);
        }
        System.arraycopy(zzbciVar.zzdvu, 0, this.zzdvu, this.size, zzbciVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbci)) {
            return super.equals(obj);
        }
        zzbci zzbciVar = (zzbci) obj;
        if (this.size == zzbciVar.size) {
            long[] jArr = zzbciVar.zzdvu;
            for (int i = 0; i < this.size; i++) {
                if (this.zzdvu[i] == jArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        zzbk(i);
        return this.zzdvu[i];
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzv = 1;
        for (int i = 0; i < this.size; i++) {
            iZzv = (iZzv * 31) + zzbbq.zzv(this.zzdvu[i]);
        }
        return iZzv;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzaba();
        zzbk(i);
        long j = this.zzdvu[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzdvu, i + 1, this.zzdvu, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzaba();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzdvu[i]))) {
                System.arraycopy(this.zzdvu, i + 1, this.zzdvu, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzaba();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzdvu, i2, this.zzdvu, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzaba();
        zzbk(i);
        long j = this.zzdvu[i];
        this.zzdvu[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final /* synthetic */ zzbbt<Long> zzbm(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzbci(Arrays.copyOf(this.zzdvu, i), this.size);
    }

    public final void zzw(long j) {
        zzk(this.size, j);
    }
}
