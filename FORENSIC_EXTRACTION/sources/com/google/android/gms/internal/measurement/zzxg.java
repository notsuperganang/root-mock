package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzxg extends AbstractList<String> implements zzve, RandomAccess {
    private final zzve zzccj;

    public zzxg(zzve zzveVar) {
        this.zzccj = zzveVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zzccj.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzxi(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzxh(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzccj.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final Object zzbp(int i) {
        return this.zzccj.zzbp(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final void zzc(zzte zzteVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final List<?> zzxb() {
        return this.zzccj.zzxb();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final zzve zzxc() {
        return this;
    }
}
