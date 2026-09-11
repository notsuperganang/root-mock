package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzua {
    private static final Class<?> zzbvb = zzvn();

    private static final zzub zzge(String str) throws Exception {
        return (zzub) zzbvb.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }

    private static Class<?> zzvn() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzub zzvo() {
        if (zzbvb != null) {
            try {
                return zzge("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzub.zzbvf;
    }

    static zzub zzvp() {
        zzub zzubVarZzge = null;
        if (zzbvb != null) {
            try {
                zzubVarZzge = zzge("loadGeneratedRegistry");
            } catch (Exception e) {
            }
        }
        if (zzubVarZzge == null) {
            zzubVarZzge = zzub.zzvp();
        }
        return zzubVarZzge == null ? zzvo() : zzubVarZzge;
    }
}
