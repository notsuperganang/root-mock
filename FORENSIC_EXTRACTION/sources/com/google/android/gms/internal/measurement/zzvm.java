package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzvm implements zzvu {
    private zzvu[] zzcaj;

    zzvm(zzvu... zzvuVarArr) {
        this.zzcaj = zzvuVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzvu
    public final boolean zze(Class<?> cls) {
        for (zzvu zzvuVar : this.zzcaj) {
            if (zzvuVar.zze(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzvu
    public final zzvt zzf(Class<?> cls) {
        for (zzvu zzvuVar : this.zzcaj) {
            if (zzvuVar.zze(cls)) {
                return zzvuVar.zzf(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
