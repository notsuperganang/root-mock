package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
final class zzwh {
    private static final zzwh zzcbl = new zzwh();
    private final ConcurrentMap<Class<?>, zzwl<?>> zzcbn = new ConcurrentHashMap();
    private final zzwm zzcbm = new zzvk();

    private zzwh() {
    }

    public static zzwh zzxt() {
        return zzcbl;
    }

    public final <T> zzwl<T> zzak(T t) {
        return zzi(t.getClass());
    }

    public final <T> zzwl<T> zzi(Class<T> cls) {
        zzuq.zza(cls, "messageType");
        zzwl<T> zzwlVar = (zzwl) this.zzcbn.get(cls);
        if (zzwlVar != null) {
            return zzwlVar;
        }
        zzwl<T> zzwlVarZzh = this.zzcbm.zzh(cls);
        zzuq.zza(cls, "messageType");
        zzuq.zza(zzwlVarZzh, "schema");
        zzwl<T> zzwlVar2 = (zzwl) this.zzcbn.putIfAbsent(cls, zzwlVarZzh);
        return zzwlVar2 != null ? zzwlVar2 : zzwlVarZzh;
    }
}
