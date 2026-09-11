package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzgk {
    private static final Class<?> zzpb = zzcw();

    private static Class<?> zzcw() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzgl zzcx() {
        if (zzpb != null) {
            try {
                return zzn("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzgl.zzpf;
    }

    static zzgl zzcy() {
        zzgl zzglVarZzn = null;
        if (zzpb != null) {
            try {
                zzglVarZzn = zzn("loadGeneratedRegistry");
            } catch (Exception e) {
            }
        }
        if (zzglVarZzn == null) {
            zzglVarZzn = zzgl.zzcy();
        }
        return zzglVarZzn == null ? zzcx() : zzglVarZzn;
    }

    private static final zzgl zzn(String str) throws Exception {
        return (zzgl) zzpb.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
