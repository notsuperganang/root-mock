package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfy extends zzyc<zzfy> {
    private static volatile zzfy[] zzayt;
    public Integer zzawz = null;
    public long[] zzayu = zzyl.zzcfk;

    public zzfy() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfy[] zznc() {
        if (zzayt == null) {
            synchronized (zzyg.zzcfe) {
                if (zzayt == null) {
                    zzayt = new zzfy[0];
                }
            }
        }
        return zzayt;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfyVar = (zzfy) obj;
        if (this.zzawz == null) {
            if (zzfyVar.zzawz != null) {
                return false;
            }
        } else if (!this.zzawz.equals(zzfyVar.zzawz)) {
            return false;
        }
        if (!zzyg.equals(this.zzayu, zzfyVar.zzayu)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfyVar.zzcev == null || zzfyVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfyVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzawz == null ? 0 : this.zzawz.hashCode();
        int iHashCode4 = zzyg.hashCode(this.zzayu);
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((iHashCode3 + ((iHashCode2 + 527) * 31)) * 31) + iHashCode4) * 31) + iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 8:
                    this.zzawz = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 16:
                    int iZzb = zzyl.zzb(zzxzVar, 16);
                    int length = this.zzayu == null ? 0 : this.zzayu.length;
                    long[] jArr = new long[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzayu, 0, jArr, 0, length);
                    }
                    while (length < jArr.length - 1) {
                        jArr[length] = zzxzVar.zzvc();
                        zzxzVar.zzuj();
                        length++;
                    }
                    jArr[length] = zzxzVar.zzvc();
                    this.zzayu = jArr;
                    break;
                case 18:
                    int iZzas = zzxzVar.zzas(zzxzVar.zzvb());
                    int position = zzxzVar.getPosition();
                    int i = 0;
                    while (zzxzVar.zzyy() > 0) {
                        zzxzVar.zzvc();
                        i++;
                    }
                    zzxzVar.zzcb(position);
                    int length2 = this.zzayu == null ? 0 : this.zzayu.length;
                    long[] jArr2 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzayu, 0, jArr2, 0, length2);
                    }
                    while (length2 < jArr2.length) {
                        jArr2[length2] = zzxzVar.zzvc();
                        length2++;
                    }
                    this.zzayu = jArr2;
                    zzxzVar.zzat(iZzas);
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
        if (this.zzawz != null) {
            zzyaVar.zzd(1, this.zzawz.intValue());
        }
        if (this.zzayu != null && this.zzayu.length > 0) {
            for (int i = 0; i < this.zzayu.length; i++) {
                zzyaVar.zzi(2, this.zzayu[i]);
            }
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int i = 0;
        int iZzf = super.zzf();
        if (this.zzawz != null) {
            iZzf += zzya.zzh(1, this.zzawz.intValue());
        }
        if (this.zzayu == null || this.zzayu.length <= 0) {
            return iZzf;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= this.zzayu.length) {
                return iZzf + i3 + (this.zzayu.length * 1);
            }
            int iZzbg = zzya.zzbg(this.zzayu[i2]);
            i2++;
            i = iZzbg + i3;
        }
    }
}
