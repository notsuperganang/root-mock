package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfx extends zzyc<zzfx> {
    public long[] zzayp = zzyl.zzcfk;
    public long[] zzayq = zzyl.zzcfk;
    public zzfs[] zzayr = zzfs.zzmy();
    public zzfy[] zzays = zzfy.zznc();

    public zzfx() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        zzfx zzfxVar = (zzfx) obj;
        if (zzyg.equals(this.zzayp, zzfxVar.zzayp) && zzyg.equals(this.zzayq, zzfxVar.zzayq) && zzyg.equals(this.zzayr, zzfxVar.zzayr) && zzyg.equals(this.zzays, zzfxVar.zzays)) {
            if (this.zzcev == null || this.zzcev.isEmpty()) {
                return zzfxVar.zzcev == null || zzfxVar.zzcev.isEmpty();
            }
            return this.zzcev.equals(zzfxVar.zzcev);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = getClass().getName().hashCode();
        int iHashCode2 = zzyg.hashCode(this.zzayp);
        int iHashCode3 = zzyg.hashCode(this.zzayq);
        int iHashCode4 = zzyg.hashCode(this.zzayr);
        return ((this.zzcev == null || this.zzcev.isEmpty()) ? 0 : this.zzcev.hashCode()) + ((((((((((iHashCode + 527) * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + zzyg.hashCode(this.zzays)) * 31);
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 8:
                    int iZzb = zzyl.zzb(zzxzVar, 8);
                    int length = this.zzayp == null ? 0 : this.zzayp.length;
                    long[] jArr = new long[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzayp, 0, jArr, 0, length);
                    }
                    while (length < jArr.length - 1) {
                        jArr[length] = zzxzVar.zzvc();
                        zzxzVar.zzuj();
                        length++;
                    }
                    jArr[length] = zzxzVar.zzvc();
                    this.zzayp = jArr;
                    break;
                case 10:
                    int iZzas = zzxzVar.zzas(zzxzVar.zzvb());
                    int position = zzxzVar.getPosition();
                    int i = 0;
                    while (zzxzVar.zzyy() > 0) {
                        zzxzVar.zzvc();
                        i++;
                    }
                    zzxzVar.zzcb(position);
                    int length2 = this.zzayp == null ? 0 : this.zzayp.length;
                    long[] jArr2 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzayp, 0, jArr2, 0, length2);
                    }
                    while (length2 < jArr2.length) {
                        jArr2[length2] = zzxzVar.zzvc();
                        length2++;
                    }
                    this.zzayp = jArr2;
                    zzxzVar.zzat(iZzas);
                    break;
                case 16:
                    int iZzb2 = zzyl.zzb(zzxzVar, 16);
                    int length3 = this.zzayq == null ? 0 : this.zzayq.length;
                    long[] jArr3 = new long[iZzb2 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzayq, 0, jArr3, 0, length3);
                    }
                    while (length3 < jArr3.length - 1) {
                        jArr3[length3] = zzxzVar.zzvc();
                        zzxzVar.zzuj();
                        length3++;
                    }
                    jArr3[length3] = zzxzVar.zzvc();
                    this.zzayq = jArr3;
                    break;
                case 18:
                    int iZzas2 = zzxzVar.zzas(zzxzVar.zzvb());
                    int position2 = zzxzVar.getPosition();
                    int i2 = 0;
                    while (zzxzVar.zzyy() > 0) {
                        zzxzVar.zzvc();
                        i2++;
                    }
                    zzxzVar.zzcb(position2);
                    int length4 = this.zzayq == null ? 0 : this.zzayq.length;
                    long[] jArr4 = new long[i2 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.zzayq, 0, jArr4, 0, length4);
                    }
                    while (length4 < jArr4.length) {
                        jArr4[length4] = zzxzVar.zzvc();
                        length4++;
                    }
                    this.zzayq = jArr4;
                    zzxzVar.zzat(iZzas2);
                    break;
                case 26:
                    int iZzb3 = zzyl.zzb(zzxzVar, 26);
                    int length5 = this.zzayr == null ? 0 : this.zzayr.length;
                    zzfs[] zzfsVarArr = new zzfs[iZzb3 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.zzayr, 0, zzfsVarArr, 0, length5);
                    }
                    while (length5 < zzfsVarArr.length - 1) {
                        zzfsVarArr[length5] = new zzfs();
                        zzxzVar.zza(zzfsVarArr[length5]);
                        zzxzVar.zzuj();
                        length5++;
                    }
                    zzfsVarArr[length5] = new zzfs();
                    zzxzVar.zza(zzfsVarArr[length5]);
                    this.zzayr = zzfsVarArr;
                    break;
                case 34:
                    int iZzb4 = zzyl.zzb(zzxzVar, 34);
                    int length6 = this.zzays == null ? 0 : this.zzays.length;
                    zzfy[] zzfyVarArr = new zzfy[iZzb4 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.zzays, 0, zzfyVarArr, 0, length6);
                    }
                    while (length6 < zzfyVarArr.length - 1) {
                        zzfyVarArr[length6] = new zzfy();
                        zzxzVar.zza(zzfyVarArr[length6]);
                        zzxzVar.zzuj();
                        length6++;
                    }
                    zzfyVarArr[length6] = new zzfy();
                    zzxzVar.zza(zzfyVarArr[length6]);
                    this.zzays = zzfyVarArr;
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
        if (this.zzayp != null && this.zzayp.length > 0) {
            for (int i = 0; i < this.zzayp.length; i++) {
                zzyaVar.zza(1, this.zzayp[i]);
            }
        }
        if (this.zzayq != null && this.zzayq.length > 0) {
            for (int i2 = 0; i2 < this.zzayq.length; i2++) {
                zzyaVar.zza(2, this.zzayq[i2]);
            }
        }
        if (this.zzayr != null && this.zzayr.length > 0) {
            for (int i3 = 0; i3 < this.zzayr.length; i3++) {
                zzfs zzfsVar = this.zzayr[i3];
                if (zzfsVar != null) {
                    zzyaVar.zza(3, zzfsVar);
                }
            }
        }
        if (this.zzays != null && this.zzays.length > 0) {
            for (int i4 = 0; i4 < this.zzays.length; i4++) {
                zzfy zzfyVar = this.zzays[i4];
                if (zzfyVar != null) {
                    zzyaVar.zza(4, zzfyVar);
                }
            }
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzb;
        int iZzf = super.zzf();
        if (this.zzayp != null && this.zzayp.length > 0) {
            int iZzbg = 0;
            for (int i = 0; i < this.zzayp.length; i++) {
                iZzbg += zzya.zzbg(this.zzayp[i]);
            }
            iZzf = iZzbg + iZzf + (this.zzayp.length * 1);
        }
        if (this.zzayq == null || this.zzayq.length <= 0) {
            iZzb = iZzf;
        } else {
            int iZzbg2 = 0;
            for (int i2 = 0; i2 < this.zzayq.length; i2++) {
                iZzbg2 += zzya.zzbg(this.zzayq[i2]);
            }
            iZzb = iZzbg2 + iZzf + (this.zzayq.length * 1);
        }
        if (this.zzayr != null && this.zzayr.length > 0) {
            for (int i3 = 0; i3 < this.zzayr.length; i3++) {
                zzfs zzfsVar = this.zzayr[i3];
                if (zzfsVar != null) {
                    iZzb += zzya.zzb(3, zzfsVar);
                }
            }
        }
        if (this.zzays != null && this.zzays.length > 0) {
            for (int i4 = 0; i4 < this.zzays.length; i4++) {
                zzfy zzfyVar = this.zzays[i4];
                if (zzfyVar != null) {
                    iZzb += zzya.zzb(4, zzfyVar);
                }
            }
        }
        return iZzb;
    }
}
