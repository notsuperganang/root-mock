package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
final class zzbei implements ListIterator<String> {
    private ListIterator<String> zzdza;
    private final /* synthetic */ int zzdzb;
    private final /* synthetic */ zzbeh zzdzc;

    zzbei(zzbeh zzbehVar, int i) {
        this.zzdzc = zzbehVar;
        this.zzdzb = i;
        this.zzdza = this.zzdzc.zzdyz.listIterator(this.zzdzb);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzdza.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzdza.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzdza.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzdza.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzdza.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzdza.previousIndex();
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
