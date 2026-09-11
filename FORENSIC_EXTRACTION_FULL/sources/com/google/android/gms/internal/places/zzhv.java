package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzhv extends zzfk<Long> implements zzhg<Long>, RandomAccess {
    private static final zzhv zzuo;
    private int size;
    private long[] zzup;

    static {
        zzhv zzhvVar = new zzhv();
        zzuo = zzhvVar;
        zzhvVar.zzbb();
    }

    zzhv() {
        this(new long[10], 0);
    }

    private zzhv(long[] jArr, int i) {
        this.zzup = jArr;
        this.size = i;
    }

    private final void zzac(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzad(i));
        }
    }

    private final String zzad(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.size).toString();
    }

    private final void zzl(int i, long j) {
        zzbc();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzad(i));
        }
        if (this.size < this.zzup.length) {
            System.arraycopy(this.zzup, i, this.zzup, i + 1, this.size - i);
        } else {
            long[] jArr = new long[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzup, 0, jArr, 0, i);
            System.arraycopy(this.zzup, i, jArr, i + 1, this.size - i);
            this.zzup = jArr;
        }
        this.zzup[i] = j;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzl(i, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzbc();
        zzhb.checkNotNull(collection);
        if (!(collection instanceof zzhv)) {
            return super.addAll(collection);
        }
        zzhv zzhvVar = (zzhv) collection;
        if (zzhvVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzhvVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzhvVar.size;
        if (i > this.zzup.length) {
            this.zzup = Arrays.copyOf(this.zzup, i);
        }
        System.arraycopy(zzhvVar.zzup, 0, this.zzup, this.size, zzhvVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhv)) {
            return super.equals(obj);
        }
        zzhv zzhvVar = (zzhv) obj;
        if (this.size != zzhvVar.size) {
            return false;
        }
        long[] jArr = zzhvVar.zzup;
        for (int i = 0; i < this.size; i++) {
            if (this.zzup[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        zzac(i);
        return this.zzup[i];
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzo = 1;
        for (int i = 0; i < this.size; i++) {
            iZzo = (iZzo * 31) + zzhb.zzo(this.zzup[i]);
        }
        return iZzo;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbc();
        zzac(i);
        long j = this.zzup[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzup, i + 1, this.zzup, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbc();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzup[i]))) {
                System.arraycopy(this.zzup, i + 1, this.zzup, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzbc();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzup, i2, this.zzup, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzbc();
        zzac(i);
        long j = this.zzup[i];
        this.zzup[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.places.zzhg
    public final /* synthetic */ zzhg<Long> zzae(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzhv(Arrays.copyOf(this.zzup, i), this.size);
    }

    public final void zzp(long j) {
        zzl(this.size, j);
    }
}
