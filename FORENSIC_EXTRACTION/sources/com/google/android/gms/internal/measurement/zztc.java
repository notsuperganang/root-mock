package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zztc extends zzta<Boolean> implements zzuu<Boolean>, zzwg, RandomAccess {
    private static final zztc zzbtq;
    private int size;
    private boolean[] zzbtr;

    static {
        zztc zztcVar = new zztc();
        zzbtq = zztcVar;
        zztcVar.zzsw();
    }

    zztc() {
        this(new boolean[10], 0);
    }

    private zztc(boolean[] zArr, int i) {
        this.zzbtr = zArr;
        this.size = i;
    }

    private final void zza(int i, boolean z) {
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbtr.length) {
            System.arraycopy(this.zzbtr, i, this.zzbtr, i + 1, this.size - i);
        } else {
            boolean[] zArr = new boolean[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzbtr, 0, zArr, 0, i);
            System.arraycopy(this.zzbtr, i, zArr, i + 1, this.size - i);
            this.zzbtr = zArr;
        }
        this.zzbtr[i] = z;
        this.size++;
        this.modCount++;
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
    }

    private final String zzak(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.size).toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zza(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zztc)) {
            return super.addAll(collection);
        }
        zztc zztcVar = (zztc) collection;
        if (zztcVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zztcVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zztcVar.size;
        if (i > this.zzbtr.length) {
            this.zzbtr = Arrays.copyOf(this.zzbtr, i);
        }
        System.arraycopy(zztcVar.zzbtr, 0, this.zzbtr, this.size, zztcVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final void addBoolean(boolean z) {
        zza(this.size, z);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zztc)) {
            return super.equals(obj);
        }
        zztc zztcVar = (zztc) obj;
        if (this.size == zztcVar.size) {
            boolean[] zArr = zztcVar.zzbtr;
            for (int i = 0; i < this.size; i++) {
                if (this.zzbtr[i] == zArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Boolean.valueOf(this.zzbtr[i]);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzu = 1;
        for (int i = 0; i < this.size; i++) {
            iZzu = (iZzu * 31) + zzuq.zzu(this.zzbtr[i]);
        }
        return iZzu;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        boolean z = this.zzbtr[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbtr, i + 1, this.zzbtr, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzbtr[i]))) {
                System.arraycopy(this.zzbtr, i + 1, this.zzbtr, i, (this.size - i) - 1);
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
        System.arraycopy(this.zzbtr, i2, this.zzbtr, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzua();
        zzaj(i);
        boolean z = this.zzbtr[i];
        this.zzbtr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Boolean> zzal(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zztc(Arrays.copyOf(this.zzbtr, i), this.size);
    }
}
