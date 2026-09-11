package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzbay extends zzbab<Double> implements zzbbt<Double>, RandomAccess {
    private static final zzbay zzdqo;
    private int size;
    private double[] zzdqp;

    static {
        zzbay zzbayVar = new zzbay();
        zzdqo = zzbayVar;
        zzbayVar.zzaaz();
    }

    zzbay() {
        this(new double[10], 0);
    }

    private zzbay(double[] dArr, int i) {
        this.zzdqp = dArr;
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

    private final void zzc(int i, double d) {
        zzaba();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzbl(i));
        }
        if (this.size < this.zzdqp.length) {
            System.arraycopy(this.zzdqp, i, this.zzdqp, i + 1, this.size - i);
        } else {
            double[] dArr = new double[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzdqp, 0, dArr, 0, i);
            System.arraycopy(this.zzdqp, i, dArr, i + 1, this.size - i);
            this.zzdqp = dArr;
        }
        this.zzdqp[i] = d;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzaba();
        zzbbq.checkNotNull(collection);
        if (!(collection instanceof zzbay)) {
            return super.addAll(collection);
        }
        zzbay zzbayVar = (zzbay) collection;
        if (zzbayVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzbayVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzbayVar.size;
        if (i > this.zzdqp.length) {
            this.zzdqp = Arrays.copyOf(this.zzdqp, i);
        }
        System.arraycopy(zzbayVar.zzdqp, 0, this.zzdqp, this.size, zzbayVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbay)) {
            return super.equals(obj);
        }
        zzbay zzbayVar = (zzbay) obj;
        if (this.size == zzbayVar.size) {
            double[] dArr = zzbayVar.zzdqp;
            for (int i = 0; i < this.size; i++) {
                if (this.zzdqp[i] == dArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzbk(i);
        return Double.valueOf(this.zzdqp[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzv = 1;
        for (int i = 0; i < this.size; i++) {
            iZzv = (iZzv * 31) + zzbbq.zzv(Double.doubleToLongBits(this.zzdqp[i]));
        }
        return iZzv;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzaba();
        zzbk(i);
        double d = this.zzdqp[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzdqp, i + 1, this.zzdqp, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzaba();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzdqp[i]))) {
                System.arraycopy(this.zzdqp, i + 1, this.zzdqp, i, this.size - i);
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
        System.arraycopy(this.zzdqp, i2, this.zzdqp, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzaba();
        zzbk(i);
        double d = this.zzdqp[i];
        this.zzdqp[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final /* synthetic */ zzbbt<Double> zzbm(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzbay(Arrays.copyOf(this.zzdqp, i), this.size);
    }

    public final void zzd(double d) {
        zzc(this.size, d);
    }
}
