package com.google.android.gms.internal.places;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzid implements zzic {
    zzid() {
    }

    @Override // com.google.android.gms.internal.places.zzic
    public final int zzc(int i, Object obj, Object obj2) {
        zzib zzibVar = (zzib) obj;
        if (!zzibVar.isEmpty()) {
            Iterator it = zzibVar.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                entry.getKey();
                entry.getValue();
                throw new NoSuchMethodError();
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.places.zzic
    public final Object zzc(Object obj, Object obj2) {
        zzib zzibVarZzeq = (zzib) obj;
        zzib zzibVar = (zzib) obj2;
        if (!zzibVar.isEmpty()) {
            if (!zzibVarZzeq.isMutable()) {
                zzibVarZzeq = zzibVarZzeq.zzeq();
            }
            zzibVarZzeq.zzb(zzibVar);
        }
        return zzibVarZzeq;
    }

    @Override // com.google.android.gms.internal.places.zzic
    public final Map<?, ?> zzh(Object obj) {
        return (zzib) obj;
    }

    @Override // com.google.android.gms.internal.places.zzic
    public final Map<?, ?> zzi(Object obj) {
        return (zzib) obj;
    }

    @Override // com.google.android.gms.internal.places.zzic
    public final boolean zzj(Object obj) {
        return !((zzib) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.places.zzic
    public final Object zzk(Object obj) {
        ((zzib) obj).zzbb();
        return obj;
    }

    @Override // com.google.android.gms.internal.places.zzic
    public final Object zzl(Object obj) {
        return zzib.zzep().zzeq();
    }

    @Override // com.google.android.gms.internal.places.zzic
    public final zzia<?, ?> zzm(Object obj) {
        throw new NoSuchMethodError();
    }
}
