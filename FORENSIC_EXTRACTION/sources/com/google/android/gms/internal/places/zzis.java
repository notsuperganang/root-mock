package com.google.android.gms.internal.places;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
final class zzis {
    private static final zzis zzvu = new zzis();
    private final zziz zzvv;
    private final ConcurrentMap<Class<?>, zziy<?>> zzvw = new ConcurrentHashMap();

    private zzis() {
        zziz zzizVarZzp = null;
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        for (int i = 0; i <= 0; i++) {
            zzizVarZzp = zzp(strArr[0]);
            if (zzizVarZzp != null) {
                break;
            }
        }
        this.zzvv = zzizVarZzp == null ? new zzhw() : zzizVarZzp;
    }

    public static zzis zzfc() {
        return zzvu;
    }

    private static zziz zzp(String str) {
        try {
            return (zziz) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public final <T> zziy<T> zzg(Class<T> cls) {
        zzhb.zzb(cls, "messageType");
        zziy<T> zziyVar = (zziy) this.zzvw.get(cls);
        if (zziyVar != null) {
            return zziyVar;
        }
        zziy<T> zziyVarZzf = this.zzvv.zzf(cls);
        zzhb.zzb(cls, "messageType");
        zzhb.zzb(zziyVarZzf, "schema");
        zziy<T> zziyVar2 = (zziy) this.zzvw.putIfAbsent(cls, zziyVarZzf);
        return zziyVar2 != null ? zziyVar2 : zziyVarZzf;
    }

    public final <T> zziy<T> zzp(T t) {
        return zzg(t.getClass());
    }
}
