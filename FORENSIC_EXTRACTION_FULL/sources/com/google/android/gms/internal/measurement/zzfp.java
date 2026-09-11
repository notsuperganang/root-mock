package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfp extends zzyc<zzfp> {
    public Long zzawm = null;
    public String zzafi = null;
    private Integer zzawn = null;
    public zzfq[] zzawo = zzfq.zzmw();
    public zzfo[] zzawp = zzfo.zzmv();
    public zzfi[] zzawq = zzfi.zzmr();
    private String zzawr = null;
    private Boolean zzaws = null;

    public zzfp() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfp)) {
            return false;
        }
        zzfp zzfpVar = (zzfp) obj;
        if (this.zzawm == null) {
            if (zzfpVar.zzawm != null) {
                return false;
            }
        } else if (!this.zzawm.equals(zzfpVar.zzawm)) {
            return false;
        }
        if (this.zzafi == null) {
            if (zzfpVar.zzafi != null) {
                return false;
            }
        } else if (!this.zzafi.equals(zzfpVar.zzafi)) {
            return false;
        }
        if (this.zzawn == null) {
            if (zzfpVar.zzawn != null) {
                return false;
            }
        } else if (!this.zzawn.equals(zzfpVar.zzawn)) {
            return false;
        }
        if (zzyg.equals(this.zzawo, zzfpVar.zzawo) && zzyg.equals(this.zzawp, zzfpVar.zzawp) && zzyg.equals(this.zzawq, zzfpVar.zzawq)) {
            if (this.zzawr == null) {
                if (zzfpVar.zzawr != null) {
                    return false;
                }
            } else if (!this.zzawr.equals(zzfpVar.zzawr)) {
                return false;
            }
            if (this.zzaws == null) {
                if (zzfpVar.zzaws != null) {
                    return false;
                }
            } else if (!this.zzaws.equals(zzfpVar.zzaws)) {
                return false;
            }
            if (this.zzcev == null || this.zzcev.isEmpty()) {
                return zzfpVar.zzcev == null || zzfpVar.zzcev.isEmpty();
            }
            return this.zzcev.equals(zzfpVar.zzcev);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzawm == null ? 0 : this.zzawm.hashCode();
        int iHashCode4 = this.zzafi == null ? 0 : this.zzafi.hashCode();
        int iHashCode5 = this.zzawn == null ? 0 : this.zzawn.hashCode();
        int iHashCode6 = zzyg.hashCode(this.zzawo);
        int iHashCode7 = zzyg.hashCode(this.zzawp);
        int iHashCode8 = zzyg.hashCode(this.zzawq);
        int iHashCode9 = this.zzawr == null ? 0 : this.zzawr.hashCode();
        int iHashCode10 = this.zzaws == null ? 0 : this.zzaws.hashCode();
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((((((((((((((iHashCode3 + ((iHashCode2 + 527) * 31)) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 8:
                    this.zzawm = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 18:
                    this.zzafi = zzxzVar.readString();
                    break;
                case 24:
                    this.zzawn = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 34:
                    int iZzb = zzyl.zzb(zzxzVar, 34);
                    int length = this.zzawo == null ? 0 : this.zzawo.length;
                    zzfq[] zzfqVarArr = new zzfq[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzawo, 0, zzfqVarArr, 0, length);
                    }
                    while (length < zzfqVarArr.length - 1) {
                        zzfqVarArr[length] = new zzfq();
                        zzxzVar.zza(zzfqVarArr[length]);
                        zzxzVar.zzuj();
                        length++;
                    }
                    zzfqVarArr[length] = new zzfq();
                    zzxzVar.zza(zzfqVarArr[length]);
                    this.zzawo = zzfqVarArr;
                    break;
                case 42:
                    int iZzb2 = zzyl.zzb(zzxzVar, 42);
                    int length2 = this.zzawp == null ? 0 : this.zzawp.length;
                    zzfo[] zzfoVarArr = new zzfo[iZzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzawp, 0, zzfoVarArr, 0, length2);
                    }
                    while (length2 < zzfoVarArr.length - 1) {
                        zzfoVarArr[length2] = new zzfo();
                        zzxzVar.zza(zzfoVarArr[length2]);
                        zzxzVar.zzuj();
                        length2++;
                    }
                    zzfoVarArr[length2] = new zzfo();
                    zzxzVar.zza(zzfoVarArr[length2]);
                    this.zzawp = zzfoVarArr;
                    break;
                case 50:
                    int iZzb3 = zzyl.zzb(zzxzVar, 50);
                    int length3 = this.zzawq == null ? 0 : this.zzawq.length;
                    zzfi[] zzfiVarArr = new zzfi[iZzb3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzawq, 0, zzfiVarArr, 0, length3);
                    }
                    while (length3 < zzfiVarArr.length - 1) {
                        zzfiVarArr[length3] = new zzfi();
                        zzxzVar.zza(zzfiVarArr[length3]);
                        zzxzVar.zzuj();
                        length3++;
                    }
                    zzfiVarArr[length3] = new zzfi();
                    zzxzVar.zza(zzfiVarArr[length3]);
                    this.zzawq = zzfiVarArr;
                    break;
                case 58:
                    this.zzawr = zzxzVar.readString();
                    break;
                case 64:
                    this.zzaws = Boolean.valueOf(zzxzVar.zzup());
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
        if (this.zzawm != null) {
            zzyaVar.zzi(1, this.zzawm.longValue());
        }
        if (this.zzafi != null) {
            zzyaVar.zzb(2, this.zzafi);
        }
        if (this.zzawn != null) {
            zzyaVar.zzd(3, this.zzawn.intValue());
        }
        if (this.zzawo != null && this.zzawo.length > 0) {
            for (int i = 0; i < this.zzawo.length; i++) {
                zzfq zzfqVar = this.zzawo[i];
                if (zzfqVar != null) {
                    zzyaVar.zza(4, zzfqVar);
                }
            }
        }
        if (this.zzawp != null && this.zzawp.length > 0) {
            for (int i2 = 0; i2 < this.zzawp.length; i2++) {
                zzfo zzfoVar = this.zzawp[i2];
                if (zzfoVar != null) {
                    zzyaVar.zza(5, zzfoVar);
                }
            }
        }
        if (this.zzawq != null && this.zzawq.length > 0) {
            for (int i3 = 0; i3 < this.zzawq.length; i3++) {
                zzfi zzfiVar = this.zzawq[i3];
                if (zzfiVar != null) {
                    zzyaVar.zza(6, zzfiVar);
                }
            }
        }
        if (this.zzawr != null) {
            zzyaVar.zzb(7, this.zzawr);
        }
        if (this.zzaws != null) {
            zzyaVar.zzb(8, this.zzaws.booleanValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzawm != null) {
            iZzf += zzya.zzd(1, this.zzawm.longValue());
        }
        if (this.zzafi != null) {
            iZzf += zzya.zzc(2, this.zzafi);
        }
        if (this.zzawn != null) {
            iZzf += zzya.zzh(3, this.zzawn.intValue());
        }
        if (this.zzawo != null && this.zzawo.length > 0) {
            for (int i = 0; i < this.zzawo.length; i++) {
                zzfq zzfqVar = this.zzawo[i];
                if (zzfqVar != null) {
                    iZzf += zzya.zzb(4, zzfqVar);
                }
            }
        }
        if (this.zzawp != null && this.zzawp.length > 0) {
            for (int i2 = 0; i2 < this.zzawp.length; i2++) {
                zzfo zzfoVar = this.zzawp[i2];
                if (zzfoVar != null) {
                    iZzf += zzya.zzb(5, zzfoVar);
                }
            }
        }
        if (this.zzawq != null && this.zzawq.length > 0) {
            for (int i3 = 0; i3 < this.zzawq.length; i3++) {
                zzfi zzfiVar = this.zzawq[i3];
                if (zzfiVar != null) {
                    iZzf += zzya.zzb(6, zzfiVar);
                }
            }
        }
        if (this.zzawr != null) {
            iZzf += zzya.zzc(7, this.zzawr);
        }
        if (this.zzaws == null) {
            return iZzf;
        }
        this.zzaws.booleanValue();
        return iZzf + zzya.zzbd(8) + 1;
    }
}
