package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzbbm extends zzbab<Float> implements zzbbt<Float>, RandomAccess {
    private static final zzbbm zzdtq;
    private int size;
    private float[] zzdtr;

    static {
        zzbbm zzbbmVar = new zzbbm();
        zzdtq = zzbbmVar;
        zzbbmVar.zzaaz();
    }

    zzbbm() {
        this(new float[10], 0);
    }

    private zzbbm(float[] fArr, int i) {
        this.zzdtr = fArr;
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

    private final void zzc(int i, float f) {
        zzaba();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzbl(i));
        }
        if (this.size < this.zzdtr.length) {
            System.arraycopy(this.zzdtr, i, this.zzdtr, i + 1, this.size - i);
        } else {
            float[] fArr = new float[((this.size * 3) / 2) + 1];
            System.arraycopy(this.zzdtr, 0, fArr, 0, i);
            System.arraycopy(this.zzdtr, i, fArr, i + 1, this.size - i);
            this.zzdtr = fArr;
        }
        this.zzdtr[i] = f;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzaba();
        zzbbq.checkNotNull(collection);
        if (!(collection instanceof zzbbm)) {
            return super.addAll(collection);
        }
        zzbbm zzbbmVar = (zzbbm) collection;
        if (zzbbmVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzbbmVar.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzbbmVar.size;
        if (i > this.zzdtr.length) {
            this.zzdtr = Arrays.copyOf(this.zzdtr, i);
        }
        System.arraycopy(zzbbmVar.zzdtr, 0, this.zzdtr, this.size, zzbbmVar.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbbm)) {
            return super.equals(obj);
        }
        zzbbm zzbbmVar = (zzbbm) obj;
        if (this.size == zzbbmVar.size) {
            float[] fArr = zzbbmVar.zzdtr;
            for (int i = 0; i < this.size; i++) {
                if (this.zzdtr[i] == fArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzbk(i);
        return Float.valueOf(this.zzdtr[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.size; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzdtr[i]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzaba();
        zzbk(i);
        float f = this.zzdtr[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzdtr, i + 1, this.zzdtr, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzaba();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzdtr[i]))) {
                System.arraycopy(this.zzdtr, i + 1, this.zzdtr, i, this.size - i);
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
        System.arraycopy(this.zzdtr, i2, this.zzdtr, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zzaba();
        zzbk(i);
        float f = this.zzdtr[i];
        this.zzdtr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final /* synthetic */ zzbbt<Float> zzbm(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzbbm(Arrays.copyOf(this.zzdtr, i), this.size);
    }

    public final void zzd(float f) {
        zzc(this.size, f);
    }
}
