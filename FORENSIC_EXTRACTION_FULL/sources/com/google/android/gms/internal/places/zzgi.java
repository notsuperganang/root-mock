package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzgi extends zzfk<Double> implements zzhg<Double>, RandomAccess {
    private static final zzgi zzoz;
    private int size;
    private double[] zzpa;

    static {
        zzgi zzgiVar = new zzgi();
        zzoz = zzgiVar;
        zzgiVar.zzbb();
    }

    zzgi() {
        this(new double[10], 0);
    }

    private zzgi(double[] dArr, int i) {
        this.zzpa = dArr;
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

    private final void zzd(int i, double d) {
        zzbc();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzad(i));
        }
        if (this.size < this.zzpa.length) {
            System.arraycopy(this.zzpa, i, this.zzpa, i + 1, this.size - i);
        } else {
            double[] dArr = new double[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzpa, 0, dArr, 0, i);
            System.arraycopy(this.zzpa, i, dArr, i + 1, this.size - i);
            this.zzpa = dArr;
        }
        this.zzpa[i] = d;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzd(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzbc();
        zzhb.checkNotNull(collection);
        if (!(collection instanceof zzgi)) {
            return super.addAll(collection);
        }
        zzgi zzgiVar = (zzgi) collection;
        if (zzgiVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzgiVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzgiVar.size;
        if (i > this.zzpa.length) {
            this.zzpa = Arrays.copyOf(this.zzpa, i);
        }
        System.arraycopy(zzgiVar.zzpa, 0, this.zzpa, this.size, zzgiVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgi)) {
            return super.equals(obj);
        }
        zzgi zzgiVar = (zzgi) obj;
        if (this.size != zzgiVar.size) {
            return false;
        }
        double[] dArr = zzgiVar.zzpa;
        for (int i = 0; i < this.size; i++) {
            if (this.zzpa[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzac(i);
        return Double.valueOf(this.zzpa[i]);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzo = 1;
        for (int i = 0; i < this.size; i++) {
            iZzo = (iZzo * 31) + zzhb.zzo(Double.doubleToLongBits(this.zzpa[i]));
        }
        return iZzo;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbc();
        zzac(i);
        double d = this.zzpa[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzpa, i + 1, this.zzpa, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbc();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzpa[i]))) {
                System.arraycopy(this.zzpa, i + 1, this.zzpa, i, this.size - i);
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
        System.arraycopy(this.zzpa, i2, this.zzpa, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzbc();
        zzac(i);
        double d = this.zzpa[i];
        this.zzpa[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.places.zzhg
    public final /* synthetic */ zzhg<Double> zzae(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzgi(Arrays.copyOf(this.zzpa, i), this.size);
    }

    public final void zzd(double d) {
        zzd(this.size, d);
    }
}
