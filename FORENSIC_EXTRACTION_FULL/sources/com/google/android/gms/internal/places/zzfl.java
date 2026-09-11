package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzfl {
    private static final Class<?> zznl = zzi("libcore.io.Memory");
    private static final boolean zznm;

    static {
        zznm = zzi("org.robolectric.Robolectric") != null;
    }

    static boolean zzbd() {
        return (zznl == null || zznm) ? false : true;
    }

    static Class<?> zzbe() {
        return zznl;
    }

    private static <T> Class<T> zzi(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
