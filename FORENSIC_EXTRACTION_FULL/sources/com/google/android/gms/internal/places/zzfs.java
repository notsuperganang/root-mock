package com.google.android.gms.internal.places;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zzfs implements Iterator {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzfr zznw;

    zzfs(zzfr zzfrVar) {
        this.zznw = zzfrVar;
        this.limit = this.zznw.size();
    }

    private final byte nextByte() {
        try {
            zzfr zzfrVar = this.zznw;
            int i = this.position;
            this.position = i + 1;
            return zzfrVar.zzaf(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
