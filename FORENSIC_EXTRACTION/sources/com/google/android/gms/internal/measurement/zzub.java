package com.google.android.gms.internal.measurement;

import android.support.v4.internal.view.SupportMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzub {
    private static volatile zzub zzbve;
    private final Map<zza, zzuo.zzd<?, ?>> zzbvg;
    private static volatile boolean zzbvc = false;
    private static final Class<?> zzbvd = zzvq();
    static final zzub zzbvf = new zzub(true);

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.object == zzaVar.object && this.number == zzaVar.number;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }
    }

    zzub() {
        this.zzbvg = new HashMap();
    }

    private zzub(boolean z) {
        this.zzbvg = Collections.emptyMap();
    }

    static zzub zzvp() {
        return zzum.zzd(zzub.class);
    }

    private static Class<?> zzvq() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzub zzvr() {
        return zzua.zzvo();
    }

    public static zzub zzvs() {
        zzub zzubVarZzvp = zzbve;
        if (zzubVarZzvp == null) {
            synchronized (zzub.class) {
                try {
                    zzubVarZzvp = zzbve;
                    if (zzubVarZzvp == null) {
                        zzubVarZzvp = zzua.zzvp();
                        zzbve = zzubVarZzvp;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzubVarZzvp;
    }

    public final <ContainingType extends zzvv> zzuo.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzuo.zzd) this.zzbvg.get(new zza(containingtype, i));
    }
}
