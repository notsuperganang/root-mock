package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbac {
    private static final Class<?> zzdpj = zzel("libcore.io.Memory");
    private static final boolean zzdpk;

    static {
        zzdpk = zzel("org.robolectric.Robolectric") != null;
    }

    static boolean zzabb() {
        return (zzdpj == null || zzdpk) ? false : true;
    }

    static Class<?> zzabc() {
        return zzdpj;
    }

    private static <T> Class<T> zzel(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
