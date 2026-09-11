package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzha extends zzfk<Integer> implements zzhe, RandomAccess {
    private static final zzha zztj;
    private int size;
    private int[] zztk;

    static {
        zzha zzhaVar = new zzha();
        zztj = zzhaVar;
        zzhaVar.zzbb();
    }

    zzha() {
        this(new int[10], 0);
    }

    private zzha(int[] iArr, int i) {
        this.zztk = iArr;
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

    public static zzha zzdy() {
        return zztj;
    }

    private final void zzq(int i, int i2) {
        zzbc();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzad(i));
        }
        if (this.size < this.zztk.length) {
            System.arraycopy(this.zztk, i, this.zztk, i + 1, this.size - i);
        } else {
            int[] iArr = new int[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zztk, 0, iArr, 0, i);
            System.arraycopy(this.zztk, i, iArr, i + 1, this.size - i);
            this.zztk = iArr;
        }
        this.zztk[i] = i2;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzq(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbc();
        zzhb.checkNotNull(collection);
        if (!(collection instanceof zzha)) {
            return super.addAll(collection);
        }
        zzha zzhaVar = (zzha) collection;
        if (zzhaVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzhaVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzhaVar.size;
        if (i > this.zztk.length) {
            this.zztk = Arrays.copyOf(this.zztk, i);
        }
        System.arraycopy(zzhaVar.zztk, 0, this.zztk, this.size, zzhaVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzha)) {
            return super.equals(obj);
        }
        zzha zzhaVar = (zzha) obj;
        if (this.size != zzhaVar.size) {
            return false;
        }
        int[] iArr = zzhaVar.zztk;
        for (int i = 0; i < this.size; i++) {
            if (this.zztk[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzac(i);
        return this.zztk[i];
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zztk[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbc();
        zzac(i);
        int i2 = this.zztk[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zztk, i + 1, this.zztk, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbc();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zztk[i]))) {
                System.arraycopy(this.zztk, i + 1, this.zztk, i, this.size - i);
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
        System.arraycopy(this.zztk, i2, this.zztk, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zzbc();
        zzac(i);
        int i2 = this.zztk[i];
        this.zztk[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.places.zzhg
    /* JADX INFO: renamed from: zzbd, reason: merged with bridge method [inline-methods] */
    public final zzhe zzae(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzha(Arrays.copyOf(this.zztk, i), this.size);
    }

    @Override // com.google.android.gms.internal.places.zzhe
    public final void zzbe(int i) {
        zzq(this.size, i);
    }
}
