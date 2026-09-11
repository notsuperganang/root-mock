package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzul extends zzta<Float> implements zzuu<Float>, zzwg, RandomAccess {
    private static final zzul zzbyb;
    private int size;
    private float[] zzbyc;

    static {
        zzul zzulVar = new zzul();
        zzbyb = zzulVar;
        zzulVar.zzsw();
    }

    zzul() {
        this(new float[10], 0);
    }

    private zzul(float[] fArr, int i) {
        this.zzbyc = fArr;
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

    private final void zzc(int i, float f) {
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbyc.length) {
            System.arraycopy(this.zzbyc, i, this.zzbyc, i + 1, this.size - i);
        } else {
            float[] fArr = new float[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzbyc, 0, fArr, 0, i);
            System.arraycopy(this.zzbyc, i, fArr, i + 1, this.size - i);
            this.zzbyc = fArr;
        }
        this.zzbyc[i] = f;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzul)) {
            return super.addAll(collection);
        }
        zzul zzulVar = (zzul) collection;
        if (zzulVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzulVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzulVar.size;
        if (i > this.zzbyc.length) {
            this.zzbyc = Arrays.copyOf(this.zzbyc, i);
        }
        System.arraycopy(zzulVar.zzbyc, 0, this.zzbyc, this.size, zzulVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzul)) {
            return super.equals(obj);
        }
        zzul zzulVar = (zzul) obj;
        if (this.size == zzulVar.size) {
            float[] fArr = zzulVar.zzbyc;
            for (int i = 0; i < this.size; i++) {
                if (Float.floatToIntBits(this.zzbyc[i]) == Float.floatToIntBits(fArr[i])) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Float.valueOf(this.zzbyc[i]);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.size; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzbyc[i]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        float f = this.zzbyc[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbyc, i + 1, this.zzbyc, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzbyc[i]))) {
                System.arraycopy(this.zzbyc, i + 1, this.zzbyc, i, (this.size - i) - 1);
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
        System.arraycopy(this.zzbyc, i2, this.zzbyc, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zzua();
        zzaj(i);
        float f = this.zzbyc[i];
        this.zzbyc[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Float> zzal(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzul(Arrays.copyOf(this.zzbyc, i), this.size);
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }
}
