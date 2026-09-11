package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzjt extends AbstractList<String> implements zzhq, RandomAccess {
    private final zzhq zzxt;

    public zzjt(zzhq zzhqVar) {
        this.zzxt = zzhqVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zzxt.get(i);
    }

    @Override // com.google.android.gms.internal.places.zzhq
    public final Object getRaw(int i) {
        return this.zzxt.getRaw(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzjv(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzju(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzxt.size();
    }

    @Override // com.google.android.gms.internal.places.zzhq
    public final void zzd(zzfr zzfrVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.places.zzhq
    public final List<?> zzek() {
        return this.zzxt.zzek();
    }

    @Override // com.google.android.gms.internal.places.zzhq
    public final zzhq zzel() {
        return this;
    }
}
