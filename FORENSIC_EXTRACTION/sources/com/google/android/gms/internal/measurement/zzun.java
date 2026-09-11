package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzun implements zzvu {
    private static final zzun zzbye = new zzun();

    private zzun() {
    }

    public static zzun zzwe() {
        return zzbye;
    }

    @Override // com.google.android.gms.internal.measurement.zzvu
    public final boolean zze(Class<?> cls) {
        return zzuo.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zzvu
    public final zzvt zzf(Class<?> cls) {
        if (!zzuo.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzvt) zzuo.zzg(cls.asSubclass(zzuo.class)).zza(zzuo.zze.zzbyo, (Object) null, (Object) null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
