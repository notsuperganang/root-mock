package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzvj extends zzta<Long> implements zzuu<Long>, zzwg, RandomAccess {
    private static final zzvj zzcaf;
    private int size;
    private long[] zzcag;

    static {
        zzvj zzvjVar = new zzvj();
        zzcaf = zzvjVar;
        zzvjVar.zzsw();
    }

    zzvj() {
        this(new long[10], 0);
    }

    private zzvj(long[] jArr, int i) {
        this.zzcag = jArr;
        this.size = i;
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
    }

    private final String zzak(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.size).toString();
    }

    private final void zzk(int i, long j) {
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzcag.length) {
            System.arraycopy(this.zzcag, i, this.zzcag, i + 1, this.size - i);
        } else {
            long[] jArr = new long[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzcag, 0, jArr, 0, i);
            System.arraycopy(this.zzcag, i, jArr, i + 1, this.size - i);
            this.zzcag = jArr;
        }
        this.zzcag[i] = j;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzk(i, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzvj)) {
            return super.addAll(collection);
        }
        zzvj zzvjVar = (zzvj) collection;
        if (zzvjVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzvjVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzvjVar.size;
        if (i > this.zzcag.length) {
            this.zzcag = Arrays.copyOf(this.zzcag, i);
        }
        System.arraycopy(zzvjVar.zzcag, 0, this.zzcag, this.size, zzvjVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvj)) {
            return super.equals(obj);
        }
        zzvj zzvjVar = (zzvj) obj;
        if (this.size == zzvjVar.size) {
            long[] jArr = zzvjVar.zzcag;
            for (int i = 0; i < this.size; i++) {
                if (this.zzcag[i] == jArr[i]) {
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
        zzaj(i);
        return this.zzcag[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzbd = 1;
        for (int i = 0; i < this.size; i++) {
            iZzbd = (iZzbd * 31) + zzuq.zzbd(this.zzcag[i]);
        }
        return iZzbd;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        long j = this.zzcag[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzcag, i + 1, this.zzcag, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzcag[i]))) {
                System.arraycopy(this.zzcag, i + 1, this.zzcag, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzua();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzcag, i2, this.zzcag, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzua();
        zzaj(i);
        long j = this.zzcag[i];
        this.zzcag[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Long> zzal(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzvj(Arrays.copyOf(this.zzcag, i), this.size);
    }

    public final void zzbe(long j) {
        zzk(this.size, j);
    }
}
