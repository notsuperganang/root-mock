package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
final class zzxh implements ListIterator<String> {
    private ListIterator<String> zzcck;
    private final /* synthetic */ int zzccl;
    private final /* synthetic */ zzxg zzccm;

    zzxh(zzxg zzxgVar, int i) {
        this.zzccm = zzxgVar;
        this.zzccl = i;
        this.zzcck = this.zzccm.zzccj.listIterator(this.zzccl);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzcck.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzcck.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzcck.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzcck.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzcck.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzcck.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
