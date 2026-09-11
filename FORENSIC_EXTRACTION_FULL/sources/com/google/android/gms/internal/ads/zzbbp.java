package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzbbp extends zzbab<Integer> implements zzbbt<Integer>, RandomAccess {
    private static final zzbbp zzduo;
    private int size;
    private int[] zzdup;

    static {
        zzbbp zzbbpVar = new zzbbp();
        zzduo = zzbbpVar;
        zzbbpVar.zzaaz();
    }

    zzbbp() {
        this(new int[10], 0);
    }

    private zzbbp(int[] iArr, int i) {
        this.zzdup = iArr;
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

    private final void zzy(int i, int i2) {
        zzaba();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzbl(i));
        }
        if (this.size < this.zzdup.length) {
            System.arraycopy(this.zzdup, i, this.zzdup, i + 1, this.size - i);
        } else {
            int[] iArr = new int[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzdup, 0, iArr, 0, i);
            System.arraycopy(this.zzdup, i, iArr, i + 1, this.size - i);
            this.zzdup = iArr;
        }
        this.zzdup[i] = i2;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzy(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzaba();
        zzbbq.checkNotNull(collection);
        if (!(collection instanceof zzbbp)) {
            return super.addAll(collection);
        }
        zzbbp zzbbpVar = (zzbbp) collection;
        if (zzbbpVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzbbpVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzbbpVar.size;
        if (i > this.zzdup.length) {
            this.zzdup = Arrays.copyOf(this.zzdup, i);
        }
        System.arraycopy(zzbbpVar.zzdup, 0, this.zzdup, this.size, zzbbpVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbbp)) {
            return super.equals(obj);
        }
        zzbbp zzbbpVar = (zzbbp) obj;
        if (this.size == zzbbpVar.size) {
            int[] iArr = zzbbpVar.zzdup;
            for (int i = 0; i < this.size; i++) {
                if (this.zzdup[i] == iArr[i]) {
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
        zzbk(i);
        return this.zzdup[i];
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzdup[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzaba();
        zzbk(i);
        int i2 = this.zzdup[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzdup, i + 1, this.zzdup, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzaba();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzdup[i]))) {
                System.arraycopy(this.zzdup, i + 1, this.zzdup, i, this.size - i);
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
        System.arraycopy(this.zzdup, i2, this.zzdup, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zzaba();
        zzbk(i);
        int i2 = this.zzdup[i];
        this.zzdup[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final /* synthetic */ zzbbt<Integer> zzbm(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzbbp(Arrays.copyOf(this.zzdup, i), this.size);
    }

    public final void zzco(int i) {
        zzy(this.size, i);
    }
}
