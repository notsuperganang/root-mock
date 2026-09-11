package com.google.android.gms.internal.places;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
final class zzju implements ListIterator<String> {
    private final /* synthetic */ int zzfx;
    private ListIterator<String> zzxu;
    private final /* synthetic */ zzjt zzxv;

    zzju(zzjt zzjtVar, int i) {
        this.zzxv = zzjtVar;
        this.zzfx = i;
        this.zzxu = this.zzxv.zzxt.listIterator(this.zzfx);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzxu.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzxu.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzxu.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzxu.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzxu.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzxu.previousIndex();
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
