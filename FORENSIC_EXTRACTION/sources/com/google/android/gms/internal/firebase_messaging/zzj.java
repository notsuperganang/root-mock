package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class zzj {
    private final ConcurrentHashMap<zzk, List<Throwable>> zzj = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzk = new ReferenceQueue<>();

    zzj() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> referencePoll = this.zzk.poll();
        while (referencePoll != null) {
            this.zzj.remove(referencePoll);
            referencePoll = this.zzk.poll();
        }
        List<Throwable> list = this.zzj.get(new zzk(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> listPutIfAbsent = this.zzj.putIfAbsent(new zzk(th, this.zzk), vector);
        return listPutIfAbsent == null ? vector : listPutIfAbsent;
    }
}
