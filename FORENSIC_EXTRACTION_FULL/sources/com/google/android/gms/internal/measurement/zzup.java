package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzup extends zzta<Integer> implements zzuu<Integer>, zzwg, RandomAccess {
    private static final zzup zzbza;
    private int size;
    private int[] zzbzb;

    static {
        zzup zzupVar = new zzup();
        zzbza = zzupVar;
        zzupVar.zzsw();
    }

    zzup() {
        this(new int[10], 0);
    }

    private zzup(int[] iArr, int i) {
        this.zzbzb = iArr;
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

    private final void zzp(int i, int i2) {
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbzb.length) {
            System.arraycopy(this.zzbzb, i, this.zzbzb, i + 1, this.size - i);
        } else {
            int[] iArr = new int[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzbzb, 0, iArr, 0, i);
            System.arraycopy(this.zzbzb, i, iArr, i + 1, this.size - i);
            this.zzbzb = iArr;
        }
        this.zzbzb[i] = i2;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzp(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzup)) {
            return super.addAll(collection);
        }
        zzup zzupVar = (zzup) collection;
        if (zzupVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzupVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzupVar.size;
        if (i > this.zzbzb.length) {
            this.zzbzb = Arrays.copyOf(this.zzbzb, i);
        }
        System.arraycopy(zzupVar.zzbzb, 0, this.zzbzb, this.size, zzupVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzup)) {
            return super.equals(obj);
        }
        zzup zzupVar = (zzup) obj;
        if (this.size == zzupVar.size) {
            int[] iArr = zzupVar.zzbzb;
            for (int i = 0; i < this.size; i++) {
                if (this.zzbzb[i] == iArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzaj(i);
        return this.zzbzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzbzb[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        int i2 = this.zzbzb[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbzb, i + 1, this.zzbzb, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzbzb[i]))) {
                System.arraycopy(this.zzbzb, i + 1, this.zzbzb, i, (this.size - i) - 1);
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
        System.arraycopy(this.zzbzb, i2, this.zzbzb, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zzua();
        zzaj(i);
        int i2 = this.zzbzb[i];
        this.zzbzb[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Integer> zzal(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzup(Arrays.copyOf(this.zzbzb, i), this.size);
    }

    public final void zzbo(int i) {
        zzp(this.size, i);
    }
}
