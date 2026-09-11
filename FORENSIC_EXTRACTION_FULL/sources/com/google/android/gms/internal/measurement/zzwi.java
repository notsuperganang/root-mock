package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzwi<E> extends zzta<E> {
    private static final zzwi<Object> zzcbo;
    private final List<E> zzcab;

    static {
        zzwi<Object> zzwiVar = new zzwi<>();
        zzcbo = zzwiVar;
        zzwiVar.zzsw();
    }

    zzwi() {
        this(new ArrayList(10));
    }

    private zzwi(List<E> list) {
        this.zzcab = list;
    }

    public static <E> zzwi<E> zzxu() {
        return (zzwi<E>) zzcbo;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        zzua();
        this.zzcab.add(i, e);
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.zzcab.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzua();
        E eRemove = this.zzcab.remove(i);
        this.modCount++;
        return eRemove;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zzua();
        E e2 = this.zzcab.set(i, e);
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzcab.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu zzal(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzcab);
        return new zzwi(arrayList);
    }
}
