package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzfp extends zzfk<Boolean> implements zzhg<Boolean>, RandomAccess {
    private static final zzfp zznr;
    private int size;
    private boolean[] zzns;

    static {
        zzfp zzfpVar = new zzfp();
        zznr = zzfpVar;
        zzfpVar.zzbb();
    }

    zzfp() {
        this(new boolean[10], 0);
    }

    private zzfp(boolean[] zArr, int i) {
        this.zzns = zArr;
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

    private final void zzb(int i, boolean z) {
        zzbc();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzad(i));
        }
        if (this.size < this.zzns.length) {
            System.arraycopy(this.zzns, i, this.zzns, i + 1, this.size - i);
        } else {
            boolean[] zArr = new boolean[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzns, 0, zArr, 0, i);
            System.arraycopy(this.zzns, i, zArr, i + 1, this.size - i);
            this.zzns = zArr;
        }
        this.zzns[i] = z;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzb(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbc();
        zzhb.checkNotNull(collection);
        if (!(collection instanceof zzfp)) {
            return super.addAll(collection);
        }
        zzfp zzfpVar = (zzfp) collection;
        if (zzfpVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzfpVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzfpVar.size;
        if (i > this.zzns.length) {
            this.zzns = Arrays.copyOf(this.zzns, i);
        }
        System.arraycopy(zzfpVar.zzns, 0, this.zzns, this.size, zzfpVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final void addBoolean(boolean z) {
        zzb(this.size, z);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfp)) {
            return super.equals(obj);
        }
        zzfp zzfpVar = (zzfp) obj;
        if (this.size != zzfpVar.size) {
            return false;
        }
        boolean[] zArr = zzfpVar.zzns;
        for (int i = 0; i < this.size; i++) {
            if (this.zzns[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzac(i);
        return Boolean.valueOf(this.zzns[i]);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzf = 1;
        for (int i = 0; i < this.size; i++) {
            iZzf = (iZzf * 31) + zzhb.zzf(this.zzns[i]);
        }
        return iZzf;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbc();
        zzac(i);
        boolean z = this.zzns[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzns, i + 1, this.zzns, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbc();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzns[i]))) {
                System.arraycopy(this.zzns, i + 1, this.zzns, i, this.size - i);
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
        System.arraycopy(this.zzns, i2, this.zzns, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzbc();
        zzac(i);
        boolean z = this.zzns[i];
        this.zzns[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.places.zzhg
    public final /* synthetic */ zzhg<Boolean> zzae(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzfp(Arrays.copyOf(this.zzns, i), this.size);
    }
}
