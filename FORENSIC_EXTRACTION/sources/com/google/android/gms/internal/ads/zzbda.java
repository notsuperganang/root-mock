package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzbda<T> implements zzbdm<T> {
    private final zzbcu zzdwl;
    private final boolean zzdwm;
    private final zzbee<?, ?> zzdwv;
    private final zzbbd<?> zzdww;

    private zzbda(zzbee<?, ?> zzbeeVar, zzbbd<?> zzbbdVar, zzbcu zzbcuVar) {
        this.zzdwv = zzbeeVar;
        this.zzdwm = zzbbdVar.zzh(zzbcuVar);
        this.zzdww = zzbbdVar;
        this.zzdwl = zzbcuVar;
    }

    static <T> zzbda<T> zza(zzbee<?, ?> zzbeeVar, zzbbd<?> zzbbdVar, zzbcu zzbcuVar) {
        return new zzbda<>(zzbeeVar, zzbbdVar, zzbcuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final boolean equals(T t, T t2) {
        if (!this.zzdwv.zzac(t).equals(this.zzdwv.zzac(t2))) {
            return false;
        }
        if (this.zzdwm) {
            return this.zzdww.zzm(t).equals(this.zzdww.zzm(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final int hashCode(T t) {
        int iHashCode = this.zzdwv.zzac(t).hashCode();
        return this.zzdwm ? (iHashCode * 53) + this.zzdww.zzm(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final T newInstance() {
        return (T) this.zzdwl.zzadf().zzadj();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:? A[LOOP:0: B:45:0x0010->B:53:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zza(T t, zzbdl zzbdlVar, zzbbb zzbbbVar) throws IOException {
        boolean zZzacj;
        zzbee<?, ?> zzbeeVar = this.zzdwv;
        zzbbd<?> zzbbdVar = this.zzdww;
        Object objZzad = zzbeeVar.zzad(t);
        zzbbg<T> zzbbgVarZzn = zzbbdVar.zzn(t);
        while (zzbdlVar.zzaci() != Integer.MAX_VALUE) {
            try {
                int tag = zzbdlVar.getTag();
                if (tag != 11) {
                    if ((tag & 7) == 2) {
                        Object objZza = zzbbdVar.zza(zzbbbVar, this.zzdwl, tag >>> 3);
                        if (objZza != null) {
                            zzbbdVar.zza(zzbdlVar, objZza, zzbbbVar, zzbbgVarZzn);
                        } else {
                            zZzacj = zzbeeVar.zza(objZzad, zzbdlVar);
                        }
                    } else {
                        zZzacj = zzbdlVar.zzacj();
                    }
                    if (!zZzacj) {
                        zzbeeVar.zzf(t, objZzad);
                        return;
                    }
                } else {
                    int iZzabt = 0;
                    Object objZza2 = null;
                    zzbah zzbahVarZzabs = null;
                    while (zzbdlVar.zzaci() != Integer.MAX_VALUE) {
                        int tag2 = zzbdlVar.getTag();
                        if (tag2 == 16) {
                            iZzabt = zzbdlVar.zzabt();
                            objZza2 = zzbbdVar.zza(zzbbbVar, this.zzdwl, iZzabt);
                        } else if (tag2 == 26) {
                            if (objZza2 != null) {
                                zzbbdVar.zza(zzbdlVar, objZza2, zzbbbVar, zzbbgVarZzn);
                            } else {
                                zzbahVarZzabs = zzbdlVar.zzabs();
                            }
                        } else if (!zzbdlVar.zzacj()) {
                            break;
                        }
                    }
                    if (zzbdlVar.getTag() != 12) {
                        throw zzbbu.zzadp();
                    }
                    if (zzbahVarZzabs != null) {
                        if (objZza2 != null) {
                            zzbbdVar.zza(zzbahVarZzabs, objZza2, zzbbbVar, zzbbgVarZzn);
                        } else {
                            zzbeeVar.zza(objZzad, iZzabt, zzbahVarZzabs);
                        }
                    }
                }
                zZzacj = true;
                if (!zZzacj) {
                    zzbeeVar.zzf(t, objZzad);
                    return;
                }
            } catch (Throwable th) {
                zzbeeVar.zzf(t, objZzad);
                throw th;
            }
        }
        zzbeeVar.zzf(t, objZzad);
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zza(T t, zzbey zzbeyVar) throws IOException {
        for (T t2 : this.zzdww.zzm(t)) {
            zzbbi zzbbiVar = (zzbbi) t2.getKey();
            if (zzbbiVar.zzacz() != zzbex.MESSAGE || zzbbiVar.zzada() || zzbbiVar.zzadb()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (t2 instanceof zzbbz) {
                zzbeyVar.zza(zzbbiVar.zzhq(), (Object) ((zzbbz) t2).zzadv().zzaav());
            } else {
                zzbeyVar.zza(zzbbiVar.zzhq(), t2.getValue());
            }
        }
        zzbee<?, ?> zzbeeVar = this.zzdwv;
        zzbeeVar.zzc(zzbeeVar.zzac(t), zzbeyVar);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0048  */
    /* JADX WARN: Code duplicated, block: B:41:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0041. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zza(T t, byte[] bArr, int i, int i2, zzbae zzbaeVar) throws IOException {
        int iZza;
        zzbef zzbefVarZzagd = ((zzbbo) t).zzdtt;
        if (zzbefVarZzagd == zzbef.zzagc()) {
            zzbefVarZzagd = zzbef.zzagd();
            ((zzbbo) t).zzdtt = zzbefVarZzagd;
        }
        while (i < i2) {
            int iZza2 = zzbad.zza(bArr, i, zzbaeVar);
            int i3 = zzbaeVar.zzdpl;
            if (i3 != 11) {
                i = (i3 & 7) == 2 ? zzbad.zza(i3, bArr, iZza2, i2, zzbefVarZzagd, zzbaeVar) : zzbad.zza(i3, bArr, iZza2, i2, zzbaeVar);
            } else {
                zzbah zzbahVar = null;
                int i4 = 0;
                int iZza3 = iZza2;
                while (true) {
                    if (iZza3 < i2) {
                        iZza = zzbad.zza(bArr, iZza3, zzbaeVar);
                        int i5 = zzbaeVar.zzdpl;
                        int i6 = i5 & 7;
                        switch (i5 >>> 3) {
                            case 2:
                                if (i6 == 0) {
                                    iZza3 = zzbad.zza(bArr, iZza, zzbaeVar);
                                    i4 = zzbaeVar.zzdpl;
                                } else if (i5 != 12) {
                                    iZza3 = zzbad.zza(i5, bArr, iZza, i2, zzbaeVar);
                                }
                                break;
                            case 3:
                                if (i6 == 2) {
                                    iZza3 = zzbad.zze(bArr, iZza, zzbaeVar);
                                    zzbahVar = (zzbah) zzbaeVar.zzdpn;
                                } else if (i5 != 12) {
                                    iZza3 = zzbad.zza(i5, bArr, iZza, i2, zzbaeVar);
                                }
                                break;
                            default:
                                if (i5 != 12) {
                                    iZza3 = zzbad.zza(i5, bArr, iZza, i2, zzbaeVar);
                                }
                                break;
                        }
                    } else {
                        iZza = iZza3;
                    }
                }
                if (zzbahVar != null) {
                    zzbefVarZzagd.zzb((i4 << 3) | 2, zzbahVar);
                }
                i = iZza;
            }
        }
        if (i != i2) {
            throw zzbbu.zzadr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final boolean zzaa(T t) {
        return this.zzdww.zzm(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zzc(T t, T t2) {
        zzbdo.zza(this.zzdwv, t, t2);
        if (this.zzdwm) {
            zzbdo.zza(this.zzdww, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zzo(T t) {
        this.zzdwv.zzo(t);
        this.zzdww.zzo(t);
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final int zzy(T t) {
        zzbee<?, ?> zzbeeVar = this.zzdwv;
        int iZzae = zzbeeVar.zzae(zzbeeVar.zzac(t)) + 0;
        return this.zzdwm ? iZzae + this.zzdww.zzm(t).zzacx() : iZzae;
    }
}
