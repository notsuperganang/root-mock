package com.google.android.gms.internal.places;

import android.support.v4.internal.view.SupportMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzgl {
    private static volatile zzgl zzpe;
    private final Map<zzb, zzgz.zzg<?, ?>> zzpg;
    private static volatile boolean zzpc = false;
    private static final Class<?> zzpd = zzcz();
    static final zzgl zzpf = new zzgl(true);

    static final class zzb {
        private final int number;
        private final Object object;

        zzb(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            return this.object == zzbVar.object && this.number == zzbVar.number;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }
    }

    zzgl() {
        this.zzpg = new HashMap();
    }

    private zzgl(boolean z) {
        this.zzpg = Collections.emptyMap();
    }

    static zzgl zzcy() {
        return zzgx.zzb(zzgl.class);
    }

    private static Class<?> zzcz() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzgl zzda() {
        return zzgk.zzcx();
    }

    public static zzgl zzdb() {
        zzgl zzglVarZzcy = zzpe;
        if (zzglVarZzcy == null) {
            synchronized (zzgl.class) {
                zzglVarZzcy = zzpe;
                if (zzglVarZzcy == null) {
                    zzglVarZzcy = zzgk.zzcy();
                    zzpe = zzglVarZzcy;
                }
            }
        }
        return zzglVarZzcy;
    }

    public final <ContainingType extends zzih> zzgz.zzg<ContainingType, ?> zzb(ContainingType containingtype, int i) {
        return (zzgz.zzg) this.zzpg.get(new zzb(containingtype, i));
    }
}
