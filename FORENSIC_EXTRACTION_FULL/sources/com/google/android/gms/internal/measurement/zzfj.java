package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfj extends zzyc<zzfj> {
    private static volatile zzfj[] zzavl;
    public Integer zzavm = null;
    public String zzavn = null;
    public zzfk[] zzavo = zzfk.zzmt();
    private Boolean zzavp = null;
    public zzfl zzavq = null;
    public Boolean zzavj = null;
    public Boolean zzavk = null;

    public zzfj() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfj[] zzms() {
        if (zzavl == null) {
            synchronized (zzyg.zzcfe) {
                if (zzavl == null) {
                    zzavl = new zzfj[0];
                }
            }
        }
        return zzavl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfj)) {
            return false;
        }
        zzfj zzfjVar = (zzfj) obj;
        if (this.zzavm == null) {
            if (zzfjVar.zzavm != null) {
                return false;
            }
        } else if (!this.zzavm.equals(zzfjVar.zzavm)) {
            return false;
        }
        if (this.zzavn == null) {
            if (zzfjVar.zzavn != null) {
                return false;
            }
        } else if (!this.zzavn.equals(zzfjVar.zzavn)) {
            return false;
        }
        if (!zzyg.equals(this.zzavo, zzfjVar.zzavo)) {
            return false;
        }
        if (this.zzavp == null) {
            if (zzfjVar.zzavp != null) {
                return false;
            }
        } else if (!this.zzavp.equals(zzfjVar.zzavp)) {
            return false;
        }
        if (this.zzavq == null) {
            if (zzfjVar.zzavq != null) {
                return false;
            }
        } else if (!this.zzavq.equals(zzfjVar.zzavq)) {
            return false;
        }
        if (this.zzavj == null) {
            if (zzfjVar.zzavj != null) {
                return false;
            }
        } else if (!this.zzavj.equals(zzfjVar.zzavj)) {
            return false;
        }
        if (this.zzavk == null) {
            if (zzfjVar.zzavk != null) {
                return false;
            }
        } else if (!this.zzavk.equals(zzfjVar.zzavk)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfjVar.zzcev == null || zzfjVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfjVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzavm == null ? 0 : this.zzavm.hashCode();
        int iHashCode4 = this.zzavn == null ? 0 : this.zzavn.hashCode();
        int iHashCode5 = zzyg.hashCode(this.zzavo);
        int iHashCode6 = this.zzavp == null ? 0 : this.zzavp.hashCode();
        zzfl zzflVar = this.zzavq;
        int iHashCode7 = zzflVar == null ? 0 : zzflVar.hashCode();
        int iHashCode8 = this.zzavj == null ? 0 : this.zzavj.hashCode();
        int iHashCode9 = this.zzavk == null ? 0 : this.zzavk.hashCode();
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((((((((((((iHashCode3 + ((iHashCode2 + 527) * 31)) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 8:
                    this.zzavm = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 18:
                    this.zzavn = zzxzVar.readString();
                    break;
                case 26:
                    int iZzb = zzyl.zzb(zzxzVar, 26);
                    int length = this.zzavo == null ? 0 : this.zzavo.length;
                    zzfk[] zzfkVarArr = new zzfk[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzavo, 0, zzfkVarArr, 0, length);
                    }
                    while (length < zzfkVarArr.length - 1) {
                        zzfkVarArr[length] = new zzfk();
                        zzxzVar.zza(zzfkVarArr[length]);
                        zzxzVar.zzuj();
                        length++;
                    }
                    zzfkVarArr[length] = new zzfk();
                    zzxzVar.zza(zzfkVarArr[length]);
                    this.zzavo = zzfkVarArr;
                    break;
                case 32:
                    this.zzavp = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 42:
                    if (this.zzavq == null) {
                        this.zzavq = new zzfl();
                    }
                    zzxzVar.zza(this.zzavq);
                    break;
                case 48:
                    this.zzavj = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 56:
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
        if (this.zzavm != null) {
            zzyaVar.zzd(1, this.zzavm.intValue());
        }
        if (this.zzavn != null) {
            zzyaVar.zzb(2, this.zzavn);
        }
        if (this.zzavo != null && this.zzavo.length > 0) {
            for (int i = 0; i < this.zzavo.length; i++) {
                zzfk zzfkVar = this.zzavo[i];
                if (zzfkVar != null) {
                    zzyaVar.zza(3, zzfkVar);
                }
            }
        }
        if (this.zzavp != null) {
            zzyaVar.zzb(4, this.zzavp.booleanValue());
        }
        if (this.zzavq != null) {
            zzyaVar.zza(5, this.zzavq);
        }
        if (this.zzavj != null) {
            zzyaVar.zzb(6, this.zzavj.booleanValue());
        }
        if (this.zzavk != null) {
            zzyaVar.zzb(7, this.zzavk.booleanValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzavm != null) {
            iZzf += zzya.zzh(1, this.zzavm.intValue());
        }
        if (this.zzavn != null) {
            iZzf += zzya.zzc(2, this.zzavn);
        }
        if (this.zzavo != null && this.zzavo.length > 0) {
            int iZzb = iZzf;
            for (int i = 0; i < this.zzavo.length; i++) {
                zzfk zzfkVar = this.zzavo[i];
                if (zzfkVar != null) {
                    iZzb += zzya.zzb(3, zzfkVar);
                }
            }
            iZzf = iZzb;
        }
        if (this.zzavp != null) {
            this.zzavp.booleanValue();
            iZzf += zzya.zzbd(4) + 1;
        }
        if (this.zzavq != null) {
            iZzf += zzya.zzb(5, this.zzavq);
        }
        if (this.zzavj != null) {
            this.zzavj.booleanValue();
            iZzf += zzya.zzbd(6) + 1;
        }
        if (this.zzavk == null) {
            return iZzf;
        }
        this.zzavk.booleanValue();
        return iZzf + zzya.zzbd(7) + 1;
    }
}
