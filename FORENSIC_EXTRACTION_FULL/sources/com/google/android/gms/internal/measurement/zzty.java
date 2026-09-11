package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzty extends zzta<Double> implements zzuu<Double>, zzwg, RandomAccess {
    private static final zzty zzbuz;
    private int size;
    private double[] zzbva;

    static {
        zzty zztyVar = new zzty();
        zzbuz = zztyVar;
        zztyVar.zzsw();
    }

    zzty() {
        this(new double[10], 0);
    }

    private zzty(double[] dArr, int i) {
        this.zzbva = dArr;
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

    private final void zzc(int i, double d) {
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbva.length) {
            System.arraycopy(this.zzbva, i, this.zzbva, i + 1, this.size - i);
        } else {
            double[] dArr = new double[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzbva, 0, dArr, 0, i);
            System.arraycopy(this.zzbva, i, dArr, i + 1, this.size - i);
            this.zzbva = dArr;
        }
        this.zzbva[i] = d;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzty)) {
            return super.addAll(collection);
        }
        zzty zztyVar = (zzty) collection;
        if (zztyVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zztyVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zztyVar.size;
        if (i > this.zzbva.length) {
            this.zzbva = Arrays.copyOf(this.zzbva, i);
        }
        System.arraycopy(zztyVar.zzbva, 0, this.zzbva, this.size, zztyVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzty)) {
            return super.equals(obj);
        }
        zzty zztyVar = (zzty) obj;
        if (this.size == zztyVar.size) {
            double[] dArr = zztyVar.zzbva;
            for (int i = 0; i < this.size; i++) {
                if (Double.doubleToLongBits(this.zzbva[i]) == Double.doubleToLongBits(dArr[i])) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Double.valueOf(this.zzbva[i]);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzbd = 1;
        for (int i = 0; i < this.size; i++) {
            iZzbd = (iZzbd * 31) + zzuq.zzbd(Double.doubleToLongBits(this.zzbva[i]));
        }
        return iZzbd;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        double d = this.zzbva[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbva, i + 1, this.zzbva, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzbva[i]))) {
                System.arraycopy(this.zzbva, i + 1, this.zzbva, i, (this.size - i) - 1);
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
        System.arraycopy(this.zzbva, i2, this.zzbva, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzua();
        zzaj(i);
        double d = this.zzbva[i];
        this.zzbva[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Double> zzal(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzty(Arrays.copyOf(this.zzbva, i), this.size);
    }

    public final void zzd(double d) {
        zzc(this.size, d);
    }
}
