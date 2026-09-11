package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfv extends zzyc<zzfv> {
    public zzfw[] zzaxh = zzfw.zznb();

    public zzfv() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfv)) {
            return false;
        }
        zzfv zzfvVar = (zzfv) obj;
        if (!zzyg.equals(this.zzaxh, zzfvVar.zzaxh)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfvVar.zzcev == null || zzfvVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfvVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = getClass().getName().hashCode();
        return ((this.zzcev == null || this.zzcev.isEmpty()) ? 0 : this.zzcev.hashCode()) + ((((iHashCode + 527) * 31) + zzyg.hashCode(this.zzaxh)) * 31);
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 10:
                    int iZzb = zzyl.zzb(zzxzVar, 10);
                    int length = this.zzaxh == null ? 0 : this.zzaxh.length;
                    zzfw[] zzfwVarArr = new zzfw[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzaxh, 0, zzfwVarArr, 0, length);
                    }
                    while (length < zzfwVarArr.length - 1) {
                        zzfwVarArr[length] = new zzfw();
                        zzxzVar.zza(zzfwVarArr[length]);
                        zzxzVar.zzuj();
                        length++;
                    }
                    zzfwVarArr[length] = new zzfw();
                    zzxzVar.zza(zzfwVarArr[length]);
                    this.zzaxh = zzfwVarArr;
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
        if (this.zzaxh != null && this.zzaxh.length > 0) {
            for (int i = 0; i < this.zzaxh.length; i++) {
                zzfw zzfwVar = this.zzaxh[i];
                if (zzfwVar != null) {
                    zzyaVar.zza(1, zzfwVar);
                }
            }
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzaxh != null && this.zzaxh.length > 0) {
            for (int i = 0; i < this.zzaxh.length; i++) {
                zzfw zzfwVar = this.zzaxh[i];
                if (zzfwVar != null) {
                    iZzf += zzya.zzb(1, zzfwVar);
                }
            }
        }
        return iZzf;
    }
}
