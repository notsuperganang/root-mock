package com.google.android.gms.internal.places;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzit<E> extends zzfk<E> {
    private static final zzit<Object> zzvx;
    private final List<E> zzuk;

    static {
        zzit<Object> zzitVar = new zzit<>();
        zzvx = zzitVar;
        zzitVar.zzbb();
    }

    zzit() {
        this(new ArrayList(10));
    }

    private zzit(List<E> list) {
        this.zzuk = list;
    }

    public static <E> zzit<E> zzfd() {
        return (zzit<E>) zzvx;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        zzbc();
        this.zzuk.add(i, e);
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.zzuk.get(i);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzbc();
        E eRemove = this.zzuk.remove(i);
        this.modCount++;
        return eRemove;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zzbc();
        E e2 = this.zzuk.set(i, e);
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzuk.size();
    }

    @Override // com.google.android.gms.internal.places.zzhg
    public final /* synthetic */ zzhg zzae(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzuk);
        return new zzit(arrayList);
    }
}
