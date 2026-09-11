package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfi extends zzyc<zzfi> {
    private static volatile zzfi[] zzavf;
    public Integer zzavg = null;
    public zzfm[] zzavh = zzfm.zzmu();
    public zzfj[] zzavi = zzfj.zzms();
    private Boolean zzavj = null;
    private Boolean zzavk = null;

    public zzfi() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfi[] zzmr() {
        if (zzavf == null) {
            synchronized (zzyg.zzcfe) {
                if (zzavf == null) {
                    zzavf = new zzfi[0];
                }
            }
        }
        return zzavf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfi)) {
            return false;
        }
        zzfi zzfiVar = (zzfi) obj;
        if (this.zzavg == null) {
            if (zzfiVar.zzavg != null) {
                return false;
            }
        } else if (!this.zzavg.equals(zzfiVar.zzavg)) {
            return false;
        }
        if (zzyg.equals(this.zzavh, zzfiVar.zzavh) && zzyg.equals(this.zzavi, zzfiVar.zzavi)) {
            if (this.zzavj == null) {
                if (zzfiVar.zzavj != null) {
                    return false;
                }
            } else if (!this.zzavj.equals(zzfiVar.zzavj)) {
                return false;
            }
            if (this.zzavk == null) {
                if (zzfiVar.zzavk != null) {
                    return false;
                }
            } else if (!this.zzavk.equals(zzfiVar.zzavk)) {
                return false;
            }
            if (this.zzcev == null || this.zzcev.isEmpty()) {
                return zzfiVar.zzcev == null || zzfiVar.zzcev.isEmpty();
            }
            return this.zzcev.equals(zzfiVar.zzcev);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzavg == null ? 0 : this.zzavg.hashCode();
        int iHashCode4 = zzyg.hashCode(this.zzavh);
        int iHashCode5 = zzyg.hashCode(this.zzavi);
        int iHashCode6 = this.zzavj == null ? 0 : this.zzavj.hashCode();
        int iHashCode7 = this.zzavk == null ? 0 : this.zzavk.hashCode();
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((((((((iHashCode3 + ((iHashCode2 + 527) * 31)) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 8:
                    this.zzavg = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 18:
                    int iZzb = zzyl.zzb(zzxzVar, 18);
                    int length = this.zzavh == null ? 0 : this.zzavh.length;
                    zzfm[] zzfmVarArr = new zzfm[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzavh, 0, zzfmVarArr, 0, length);
                    }
                    while (length < zzfmVarArr.length - 1) {
                        zzfmVarArr[length] = new zzfm();
                        zzxzVar.zza(zzfmVarArr[length]);
                        zzxzVar.zzuj();
                        length++;
                    }
                    zzfmVarArr[length] = new zzfm();
                    zzxzVar.zza(zzfmVarArr[length]);
                    this.zzavh = zzfmVarArr;
                    break;
                case 26:
                    int iZzb2 = zzyl.zzb(zzxzVar, 26);
                    int length2 = this.zzavi == null ? 0 : this.zzavi.length;
                    zzfj[] zzfjVarArr = new zzfj[iZzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzavi, 0, zzfjVarArr, 0, length2);
                    }
                    while (length2 < zzfjVarArr.length - 1) {
                        zzfjVarArr[length2] = new zzfj();
                        zzxzVar.zza(zzfjVarArr[length2]);
                        zzxzVar.zzuj();
                        length2++;
                    }
                    zzfjVarArr[length2] = new zzfj();
                    zzxzVar.zza(zzfjVarArr[length2]);
                    this.zzavi = zzfjVarArr;
                    break;
                case 32:
                    this.zzavj = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 40:
                    this.zzavk = Boolean.valueOf(zzxzVar.zzup());
                    break;
                default:
                    if (!super.zza(zzxzVar, iZzuj)) {
                    }
                    break;
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        if (this.zzavg != null) {
            zzyaVar.zzd(1, this.zzavg.intValue());
        }
        if (this.zzavh != null && this.zzavh.length > 0) {
            for (int i = 0; i < this.zzavh.length; i++) {
                zzfm zzfmVar = this.zzavh[i];
                if (zzfmVar != null) {
                    zzyaVar.zza(2, zzfmVar);
                }
            }
        }
        if (this.zzavi != null && this.zzavi.length > 0) {
            for (int i2 = 0; i2 < this.zzavi.length; i2++) {
                zzfj zzfjVar = this.zzavi[i2];
                if (zzfjVar != null) {
                    zzyaVar.zza(3, zzfjVar);
                }
            }
        }
        if (this.zzavj != null) {
            zzyaVar.zzb(4, this.zzavj.booleanValue());
        }
        if (this.zzavk != null) {
            zzyaVar.zzb(5, this.zzavk.booleanValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzavg != null) {
            iZzf += zzya.zzh(1, this.zzavg.intValue());
        }
        if (this.zzavh != null && this.zzavh.length > 0) {
            int iZzb = iZzf;
            for (int i = 0; i < this.zzavh.length; i++) {
                zzfm zzfmVar = this.zzavh[i];
                if (zzfmVar != null) {
                    iZzb += zzya.zzb(2, zzfmVar);
                }
            }
            iZzf = iZzb;
        }
        if (this.zzavi != null && this.zzavi.length > 0) {
            for (int i2 = 0; i2 < this.zzavi.length; i2++) {
                zzfj zzfjVar = this.zzavi[i2];
                if (zzfjVar != null) {
                    iZzf += zzya.zzb(3, zzfjVar);
                }
            }
        }
        if (this.zzavj != null) {
            this.zzavj.booleanValue();
            iZzf += zzya.zzbd(4) + 1;
        }
        if (this.zzavk == null) {
            return iZzf;
        }
        this.zzavk.booleanValue();
        return iZzf + zzya.zzbd(5) + 1;
    }
}
