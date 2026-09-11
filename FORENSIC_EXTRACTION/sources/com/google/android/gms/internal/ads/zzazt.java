package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class zzazt {
    private final ConcurrentHashMap<zzazu, List<Throwable>> zzdoy = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzdoz = new ReferenceQueue<>();

    zzazt() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> referencePoll = this.zzdoz.poll();
        while (referencePoll != null) {
            this.zzdoy.remove(referencePoll);
            referencePoll = this.zzdoz.poll();
        }
        return this.zzdoy.get(new zzazu(th, null));
    }
}
