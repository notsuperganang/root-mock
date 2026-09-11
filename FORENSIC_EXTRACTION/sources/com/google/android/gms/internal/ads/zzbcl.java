package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbcl implements zzbct {
    private zzbct[] zzdvx;

    zzbcl(zzbct... zzbctVarArr) {
        this.zzdvx = zzbctVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbct
    public final boolean zza(Class<?> cls) {
        for (zzbct zzbctVar : this.zzdvx) {
            if (zzbctVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbct
    public final zzbcs zzb(Class<?> cls) {
        for (zzbct zzbctVar : this.zzdvx) {
            if (zzbctVar.zza(cls)) {
                return zzbctVar.zzb(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
