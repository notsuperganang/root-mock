package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzwa<T> implements zzwl<T> {
    private final zzvv zzcaw;
    private final boolean zzcax;
    private final zzxd<?, ?> zzcbg;
    private final zzuc<?> zzcbh;

    private zzwa(zzxd<?, ?> zzxdVar, zzuc<?> zzucVar, zzvv zzvvVar) {
        this.zzcbg = zzxdVar;
        this.zzcax = zzucVar.zze(zzvvVar);
        this.zzcbh = zzucVar;
        this.zzcaw = zzvvVar;
    }

    static <T> zzwa<T> zza(zzxd<?, ?> zzxdVar, zzuc<?> zzucVar, zzvv zzvvVar) {
        return new zzwa<>(zzxdVar, zzucVar, zzvvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final boolean equals(T t, T t2) {
        if (!this.zzcbg.zzal(t).equals(this.zzcbg.zzal(t2))) {
            return false;
        }
        if (this.zzcax) {
            return this.zzcbh.zzw(t).equals(this.zzcbh.zzw(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final int hashCode(T t) {
        int iHashCode = this.zzcbg.zzal(t).hashCode();
        return this.zzcax ? (iHashCode * 53) + this.zzcbh.zzw(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final T newInstance() {
        return (T) this.zzcaw.zzwi().zzwn();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:? A[LOOP:0: B:45:0x0010->B:53:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zza(T t, zzwk zzwkVar, zzub zzubVar) throws IOException {
        boolean zZzvi;
        zzxd<?, ?> zzxdVar = this.zzcbg;
        zzuc<?> zzucVar = this.zzcbh;
        Object objZzam = zzxdVar.zzam(t);
        zzuf<T> zzufVarZzx = zzucVar.zzx(t);
        while (zzwkVar.zzvh() != Integer.MAX_VALUE) {
            try {
                int tag = zzwkVar.getTag();
                if (tag != 11) {
                    if ((tag & 7) == 2) {
                        Object objZza = zzucVar.zza(zzubVar, this.zzcaw, tag >>> 3);
                        if (objZza != null) {
                            zzucVar.zza(zzwkVar, objZza, zzubVar, zzufVarZzx);
                        } else {
                            zZzvi = zzxdVar.zza(objZzam, zzwkVar);
                        }
                    } else {
                        zZzvi = zzwkVar.zzvi();
                    }
                    if (!zZzvi) {
                        zzxdVar.zzg(t, objZzam);
                        return;
                    }
                } else {
                    int iZzus = 0;
                    Object objZza2 = null;
                    zzte zzteVarZzur = null;
                    while (zzwkVar.zzvh() != Integer.MAX_VALUE) {
                        int tag2 = zzwkVar.getTag();
                        if (tag2 == 16) {
                            iZzus = zzwkVar.zzus();
                            objZza2 = zzucVar.zza(zzubVar, this.zzcaw, iZzus);
                        } else if (tag2 == 26) {
                            if (objZza2 != null) {
                                zzucVar.zza(zzwkVar, objZza2, zzubVar, zzufVarZzx);
                            } else {
                                zzteVarZzur = zzwkVar.zzur();
                            }
                        } else if (!zzwkVar.zzvi()) {
                            break;
                        }
                    }
                    if (zzwkVar.getTag() != 12) {
                        throw zzuv.zzwt();
                    }
                    if (zzteVarZzur != null) {
                        if (objZza2 != null) {
                            zzucVar.zza(zzteVarZzur, objZza2, zzubVar, zzufVarZzx);
                        } else {
                            zzxdVar.zza(objZzam, iZzus, zzteVarZzur);
                        }
                    }
                }
                zZzvi = true;
                if (!zZzvi) {
                    zzxdVar.zzg(t, objZzam);
                    return;
                }
            } catch (Throwable th) {
                zzxdVar.zzg(t, objZzam);
                throw th;
            }
        }
        zzxdVar.zzg(t, objZzam);
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zza(T t, zzxy zzxyVar) throws IOException {
        for (T t2 : this.zzcbh.zzw(t)) {
            zzuh zzuhVar = (zzuh) t2.getKey();
            if (zzuhVar.zzwa() != zzxx.MESSAGE || zzuhVar.zzwb() || zzuhVar.zzwc()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (t2 instanceof zzva) {
                zzxyVar.zza(zzuhVar.zzc(), (Object) ((zzva) t2).zzxa().zztw());
            } else {
                zzxyVar.zza(zzuhVar.zzc(), t2.getValue());
            }
        }
        zzxd<?, ?> zzxdVar = this.zzcbg;
        zzxdVar.zzc(zzxdVar.zzal(t), zzxyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final int zzai(T t) {
        zzxd<?, ?> zzxdVar = this.zzcbg;
        int iZzan = zzxdVar.zzan(zzxdVar.zzal(t)) + 0;
        return this.zzcax ? iZzan + this.zzcbh.zzw(t).zzvy() : iZzan;
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final boolean zzaj(T t) {
        return this.zzcbh.zzw(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zzd(T t, T t2) {
        zzwn.zza(this.zzcbg, t, t2);
        if (this.zzcax) {
            zzwn.zza(this.zzcbh, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zzy(T t) {
        this.zzcbg.zzy(t);
        this.zzcbh.zzy(t);
    }
}
