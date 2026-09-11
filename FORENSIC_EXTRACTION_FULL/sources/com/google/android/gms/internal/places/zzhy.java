package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzhy implements zzig {
    private zzig[] zzus;

    zzhy(zzig... zzigVarArr) {
        this.zzus = zzigVarArr;
    }

    @Override // com.google.android.gms.internal.places.zzig
    public final boolean zzc(Class<?> cls) {
        for (zzig zzigVar : this.zzus) {
            if (zzigVar.zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.places.zzig
    public final zzif zzd(Class<?> cls) {
        for (zzig zzigVar : this.zzus) {
            if (zzigVar.zzc(cls)) {
                return zzigVar.zzd(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
