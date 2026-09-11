package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zztb {
    private static final Class<?> zzbto = zzfz("libcore.io.Memory");
    private static final boolean zzbtp;

    static {
        zzbtp = zzfz("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> zzfz(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zzub() {
        return (zzbto == null || zzbtp) ? false : true;
    }

    static Class<?> zzuc() {
        return zzbto;
    }
}
