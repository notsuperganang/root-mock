package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
abstract class zzth implements zztl {
    zzth() {
    }

    @Override // java.util.Iterator
    public /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
