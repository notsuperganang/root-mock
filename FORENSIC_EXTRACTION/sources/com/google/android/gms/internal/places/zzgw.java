package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzgw extends zzfk<Float> implements zzhg<Float>, RandomAccess {
    private static final zzgw zzsc;
    private int size;
    private float[] zzsd;

    static {
        zzgw zzgwVar = new zzgw();
        zzsc = zzgwVar;
        zzgwVar.zzbb();
    }

    zzgw() {
        this(new float[10], 0);
    }

    private zzgw(float[] fArr, int i) {
        this.zzsd = fArr;
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

    private final void zze(int i, float f) {
        zzbc();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzad(i));
        }
        if (this.size < this.zzsd.length) {
            System.arraycopy(this.zzsd, i, this.zzsd, i + 1, this.size - i);
        } else {
            float[] fArr = new float[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzsd, 0, fArr, 0, i);
            System.arraycopy(this.zzsd, i, fArr, i + 1, this.size - i);
            this.zzsd = fArr;
        }
        this.zzsd[i] = f;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zze(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzbc();
        zzhb.checkNotNull(collection);
        if (!(collection instanceof zzgw)) {
            return super.addAll(collection);
        }
        zzgw zzgwVar = (zzgw) collection;
        if (zzgwVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzgwVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzgwVar.size;
        if (i > this.zzsd.length) {
            this.zzsd = Arrays.copyOf(this.zzsd, i);
        }
        System.arraycopy(zzgwVar.zzsd, 0, this.zzsd, this.size, zzgwVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgw)) {
            return super.equals(obj);
        }
        zzgw zzgwVar = (zzgw) obj;
        if (this.size != zzgwVar.size) {
            return false;
        }
        float[] fArr = zzgwVar.zzsd;
        for (int i = 0; i < this.size; i++) {
            if (this.zzsd[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzac(i);
        return Float.valueOf(this.zzsd[i]);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.size; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzsd[i]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbc();
        zzac(i);
        float f = this.zzsd[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzsd, i + 1, this.zzsd, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbc();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzsd[i]))) {
                System.arraycopy(this.zzsd, i + 1, this.zzsd, i, this.size - i);
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
        System.arraycopy(this.zzsd, i2, this.zzsd, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zzbc();
        zzac(i);
        float f = this.zzsd[i];
        this.zzsd[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.places.zzhg
    public final /* synthetic */ zzhg<Float> zzae(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzgw(Arrays.copyOf(this.zzsd, i), this.size);
    }

    public final void zzf(float f) {
        zze(this.size, f);
    }
}
