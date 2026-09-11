package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzgy implements zzig {
    private static final zzgy zzsf = new zzgy();

    private zzgy() {
    }

    public static zzgy zzdn() {
        return zzsf;
    }

    @Override // com.google.android.gms.internal.places.zzig
    public final boolean zzc(Class<?> cls) {
        return zzgz.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.places.zzig
    public final zzif zzd(Class<?> cls) {
        if (!zzgz.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzif) zzgz.zze(cls.asSubclass(zzgz.class)).zzb(zzgz.zzh.zzsx, (Object) null, (Object) null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
