package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzim<T> implements zziy<T> {
    private final zzih zzvf;
    private final boolean zzvg;
    private final zzjq<?, ?> zzvp;
    private final zzgm<?> zzvq;

    private zzim(zzjq<?, ?> zzjqVar, zzgm<?> zzgmVar, zzih zzihVar) {
        this.zzvp = zzjqVar;
        this.zzvg = zzgmVar.zzf(zzihVar);
        this.zzvq = zzgmVar;
        this.zzvf = zzihVar;
    }

    static <T> zzim<T> zzb(zzjq<?, ?> zzjqVar, zzgm<?> zzgmVar, zzih zzihVar) {
        return new zzim<>(zzjqVar, zzgmVar, zzihVar);
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final boolean equals(T t, T t2) {
        if (!this.zzvp.zzq(t).equals(this.zzvp.zzq(t2))) {
            return false;
        }
        if (this.zzvg) {
            return this.zzvq.zzb(t).equals(this.zzvq.zzb(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final int hashCode(T t) {
        int iHashCode = this.zzvp.zzq(t).hashCode();
        return this.zzvg ? (iHashCode * 53) + this.zzvq.zzb(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final T newInstance() {
        return (T) this.zzvf.zzdr().zzdw();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:? A[LOOP:0: B:45:0x0010->B:53:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.places.zziy
    public final void zzb(T t, zzix zzixVar, zzgl zzglVar) throws IOException {
        boolean zZzbh;
        zzjq<?, ?> zzjqVar = this.zzvp;
        zzgm<?> zzgmVar = this.zzvq;
        Object objZzr = zzjqVar.zzr(t);
        zzgq<T> zzgqVarZzc = zzgmVar.zzc(t);
        while (zzixVar.zzbg() != Integer.MAX_VALUE) {
            try {
                int tag = zzixVar.getTag();
                if (tag != 11) {
                    if ((tag & 7) == 2) {
                        Object objZzb = zzgmVar.zzb(zzglVar, this.zzvf, tag >>> 3);
                        if (objZzb != null) {
                            zzgmVar.zzb(zzixVar, objZzb, zzglVar, zzgqVarZzc);
                        } else {
                            zZzbh = zzjqVar.zzb(objZzr, zzixVar);
                        }
                    } else {
                        zZzbh = zzixVar.zzbh();
                    }
                    if (!zZzbh) {
                        zzjqVar.zzg(t, objZzr);
                        return;
                    }
                } else {
                    int iZzbq = 0;
                    Object objZzb2 = null;
                    zzfr zzfrVarZzbp = null;
                    while (zzixVar.zzbg() != Integer.MAX_VALUE) {
                        int tag2 = zzixVar.getTag();
                        if (tag2 == 16) {
                            iZzbq = zzixVar.zzbq();
                            objZzb2 = zzgmVar.zzb(zzglVar, this.zzvf, iZzbq);
                        } else if (tag2 == 26) {
                            if (objZzb2 != null) {
                                zzgmVar.zzb(zzixVar, objZzb2, zzglVar, zzgqVarZzc);
                            } else {
                                zzfrVarZzbp = zzixVar.zzbp();
                            }
                        } else if (!zzixVar.zzbh()) {
                            break;
                        }
                    }
                    if (zzixVar.getTag() != 12) {
                        throw zzhh.zzec();
                    }
                    if (zzfrVarZzbp != null) {
                        if (objZzb2 != null) {
                            zzgmVar.zzb(zzfrVarZzbp, objZzb2, zzglVar, zzgqVarZzc);
                        } else {
                            zzjqVar.zzb(objZzr, iZzbq, zzfrVarZzbp);
                        }
                    }
                }
                zZzbh = true;
                if (!zZzbh) {
                    zzjqVar.zzg(t, objZzr);
                    return;
                }
            } catch (Throwable th) {
                zzjqVar.zzg(t, objZzr);
                throw th;
            }
        }
        zzjqVar.zzg(t, objZzr);
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final void zzb(T t, zzkk zzkkVar) throws IOException {
        for (T t2 : this.zzvq.zzb(t)) {
            zzgs zzgsVar = (zzgs) t2.getKey();
            if (zzgsVar.zzdj() != zzkj.MESSAGE || zzgsVar.zzdk() || zzgsVar.zzdl()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (t2 instanceof zzhm) {
                zzkkVar.zzb(zzgsVar.zzap(), (Object) ((zzhm) t2).zzej().zzax());
            } else {
                zzkkVar.zzb(zzgsVar.zzap(), t2.getValue());
            }
        }
        zzjq<?, ?> zzjqVar = this.zzvp;
        zzjqVar.zzd(zzjqVar.zzq(t), zzkkVar);
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final void zzd(T t) {
        this.zzvp.zzd(t);
        this.zzvq.zzd(t);
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final void zzd(T t, T t2) {
        zzja.zzb(this.zzvp, t, t2);
        if (this.zzvg) {
            zzja.zzb(this.zzvq, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final int zzn(T t) {
        zzjq<?, ?> zzjqVar = this.zzvp;
        int iZzs = zzjqVar.zzs(zzjqVar.zzq(t)) + 0;
        return this.zzvg ? iZzs + this.zzvq.zzb(t).zzdh() : iZzs;
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final boolean zzo(T t) {
        return this.zzvq.zzb(t).isInitialized();
    }
}
