package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzgp {
    private static final zzgm<?> zzph = new zzgn();
    private static final zzgm<?> zzpi = zzdc();

    private static zzgm<?> zzdc() {
        try {
            return (zzgm) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    static zzgm<?> zzdd() {
        return zzph;
    }

    static zzgm<?> zzde() {
        if (zzpi == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return zzpi;
    }
}
