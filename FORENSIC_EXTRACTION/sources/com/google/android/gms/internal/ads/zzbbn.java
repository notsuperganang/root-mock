package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbbn implements zzbct {
    private static final zzbbn zzdts = new zzbbn();

    private zzbbn() {
    }

    public static zzbbn zzadc() {
        return zzdts;
    }

    @Override // com.google.android.gms.internal.ads.zzbct
    public final boolean zza(Class<?> cls) {
        return zzbbo.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzbct
    public final zzbcs zzb(Class<?> cls) {
        if (!zzbbo.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzbcs) zzbbo.zzc(cls.asSubclass(zzbbo.class)).zza(zzbbo.zze.zzduc, (Object) null, (Object) null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
