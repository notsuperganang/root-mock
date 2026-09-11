package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfn extends zzyc<zzfn> {
    public Integer zzawe = null;
    public String zzawf = null;
    public Boolean zzawg = null;
    public String[] zzawh = zzyl.zzcfo;

    public zzfn() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzyi
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzfn zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 8:
                    int position = zzxzVar.getPosition();
                    try {
                        int iZzvb = zzxzVar.zzvb();
                        if (iZzvb < 0 || iZzvb > 6) {
                            throw new IllegalArgumentException(new StringBuilder(41).append(iZzvb).append(" is not a valid enum MatchType").toString());
                        }
                        this.zzawe = Integer.valueOf(iZzvb);
                    } catch (IllegalArgumentException e) {
                        zzxzVar.zzcb(position);
                        zza(zzxzVar, iZzuj);
                    }
                    break;
                case 18:
                    this.zzawf = zzxzVar.readString();
                    break;
                case 24:
                    this.zzawg = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 34:
                    int iZzb = zzyl.zzb(zzxzVar, 34);
                    int length = this.zzawh == null ? 0 : this.zzawh.length;
                    String[] strArr = new String[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzawh, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzxzVar.readString();
                        zzxzVar.zzuj();
                        length++;
                    }
                    strArr[length] = zzxzVar.readString();
                    this.zzawh = strArr;
                    break;
                default:
                    if (!super.zza(zzxzVar, iZzuj)) {
                    }
                    break;
            }
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfn)) {
            return false;
        }
        zzfn zzfnVar = (zzfn) obj;
        if (this.zzawe == null) {
            if (zzfnVar.zzawe != null) {
                return false;
            }
        } else if (!this.zzawe.equals(zzfnVar.zzawe)) {
            return false;
        }
        if (this.zzawf == null) {
            if (zzfnVar.zzawf != null) {
                return false;
            }
        } else if (!this.zzawf.equals(zzfnVar.zzawf)) {
            return false;
        }
        if (this.zzawg == null) {
            if (zzfnVar.zzawg != null) {
                return false;
            }
        } else if (!this.zzawg.equals(zzfnVar.zzawg)) {
            return false;
        }
        if (!zzyg.equals(this.zzawh, zzfnVar.zzawh)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfnVar.zzcev == null || zzfnVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfnVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iIntValue = this.zzawe == null ? 0 : this.zzawe.intValue();
        int iHashCode3 = this.zzawf == null ? 0 : this.zzawf.hashCode();
        int iHashCode4 = this.zzawg == null ? 0 : this.zzawg.hashCode();
        int iHashCode5 = zzyg.hashCode(this.zzawh);
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((((((iIntValue + ((iHashCode2 + 527) * 31)) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        if (this.zzawe != null) {
            zzyaVar.zzd(1, this.zzawe.intValue());
        }
        if (this.zzawf != null) {
            zzyaVar.zzb(2, this.zzawf);
        }
        if (this.zzawg != null) {
            zzyaVar.zzb(3, this.zzawg.booleanValue());
        }
        if (this.zzawh != null && this.zzawh.length > 0) {
            for (int i = 0; i < this.zzawh.length; i++) {
                String str = this.zzawh[i];
                if (str != null) {
                    zzyaVar.zzb(4, str);
                }
            }
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzawe != null) {
            iZzf += zzya.zzh(1, this.zzawe.intValue());
        }
        if (this.zzawf != null) {
            iZzf += zzya.zzc(2, this.zzawf);
        }
        if (this.zzawg != null) {
            this.zzawg.booleanValue();
            iZzf += zzya.zzbd(3) + 1;
        }
        if (this.zzawh == null || this.zzawh.length <= 0) {
            return iZzf;
        }
        int i = 0;
        int iZzgc = 0;
        for (int i2 = 0; i2 < this.zzawh.length; i2++) {
            String str = this.zzawh[i2];
            if (str != null) {
                i++;
                iZzgc += zzya.zzgc(str);
            }
        }
        return iZzf + iZzgc + (i * 1);
    }
}
