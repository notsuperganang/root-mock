package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzbaf extends zzbab<Boolean> implements zzbbt<Boolean>, RandomAccess {
    private static final zzbaf zzdpo;
    private int size;
    private boolean[] zzdpp;

    static {
        zzbaf zzbafVar = new zzbaf();
        zzdpo = zzbafVar;
        zzbafVar.zzaaz();
    }

    zzbaf() {
        this(new boolean[10], 0);
    }

    private zzbaf(boolean[] zArr, int i) {
        this.zzdpp = zArr;
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

    private final void zze(int i, boolean z) {
        zzaba();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzbl(i));
        }
        if (this.size < this.zzdpp.length) {
            System.arraycopy(this.zzdpp, i, this.zzdpp, i + 1, this.size - i);
        } else {
            boolean[] zArr = new boolean[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzdpp, 0, zArr, 0, i);
            System.arraycopy(this.zzdpp, i, zArr, i + 1, this.size - i);
            this.zzdpp = zArr;
        }
        this.zzdpp[i] = z;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zze(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzaba();
        zzbbq.checkNotNull(collection);
        if (!(collection instanceof zzbaf)) {
            return super.addAll(collection);
        }
        zzbaf zzbafVar = (zzbaf) collection;
        if (zzbafVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzbafVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzbafVar.size;
        if (i > this.zzdpp.length) {
            this.zzdpp = Arrays.copyOf(this.zzdpp, i);
        }
        System.arraycopy(zzbafVar.zzdpp, 0, this.zzdpp, this.size, zzbafVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final void addBoolean(boolean z) {
        zze(this.size, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbaf)) {
            return super.equals(obj);
        }
        zzbaf zzbafVar = (zzbaf) obj;
        if (this.size == zzbafVar.size) {
            boolean[] zArr = zzbafVar.zzdpp;
            for (int i = 0; i < this.size; i++) {
                if (this.zzdpp[i] == zArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzbk(i);
        return Boolean.valueOf(this.zzdpp[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzar = 1;
        for (int i = 0; i < this.size; i++) {
            iZzar = (iZzar * 31) + zzbbq.zzar(this.zzdpp[i]);
        }
        return iZzar;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzaba();
        zzbk(i);
        boolean z = this.zzdpp[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzdpp, i + 1, this.zzdpp, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzaba();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzdpp[i]))) {
                System.arraycopy(this.zzdpp, i + 1, this.zzdpp, i, this.size - i);
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
        System.arraycopy(this.zzdpp, i2, this.zzdpp, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzaba();
        zzbk(i);
        boolean z = this.zzdpp[i];
        this.zzdpp[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final /* synthetic */ zzbbt<Boolean> zzbm(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzbaf(Arrays.copyOf(this.zzdpp, i), this.size);
    }
}
