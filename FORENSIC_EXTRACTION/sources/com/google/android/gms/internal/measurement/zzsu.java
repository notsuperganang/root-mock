package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class zzsu extends WeakReference<Throwable> {
    private final int zzbsk;

    public zzsu(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzbsk = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzsu zzsuVar = (zzsu) obj;
        return this.zzbsk == zzsuVar.zzbsk && get() == zzsuVar.get();
    }

    public final int hashCode() {
        return this.zzbsk;
    }
}
