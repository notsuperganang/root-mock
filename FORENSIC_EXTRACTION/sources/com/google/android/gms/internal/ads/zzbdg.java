package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
final class zzbdg {
    private static final zzbdg zzdxa = new zzbdg();
    private final zzbdn zzdxb;
    private final ConcurrentMap<Class<?>, zzbdm<?>> zzdxc = new ConcurrentHashMap();

    private zzbdg() {
        zzbdn zzbdnVarZzeq = null;
        for (int i = 0; i <= 0; i++) {
            zzbdnVarZzeq = zzeq(new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"}[0]);
            if (zzbdnVarZzeq != null) {
                break;
            }
        }
        this.zzdxb = zzbdnVarZzeq == null ? new zzbcj() : zzbdnVarZzeq;
    }

    public static zzbdg zzaeo() {
        return zzdxa;
    }

    private static zzbdn zzeq(String str) {
        try {
            return (zzbdn) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public final <T> zzbdm<T> zzab(T t) {
        return zze(t.getClass());
    }

    public final <T> zzbdm<T> zze(Class<T> cls) {
        zzbbq.zza(cls, "messageType");
        zzbdm<T> zzbdmVar = (zzbdm) this.zzdxc.get(cls);
        if (zzbdmVar != null) {
            return zzbdmVar;
        }
        zzbdm<T> zzbdmVarZzd = this.zzdxb.zzd(cls);
        zzbbq.zza(cls, "messageType");
        zzbbq.zza(zzbdmVarZzd, "schema");
        zzbdm<T> zzbdmVar2 = (zzbdm) this.zzdxc.putIfAbsent(cls, zzbdmVarZzd);
        return zzbdmVar2 != null ? zzbdmVar2 : zzbdmVarZzd;
    }
}
