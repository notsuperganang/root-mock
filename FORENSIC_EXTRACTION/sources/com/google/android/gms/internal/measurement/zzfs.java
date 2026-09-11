package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfs extends zzyc<zzfs> {
    private static volatile zzfs[] zzawy;
    public Integer zzawz = null;
    public Long zzaxa = null;

    public zzfs() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfs[] zzmy() {
        if (zzawy == null) {
            synchronized (zzyg.zzcfe) {
                if (zzawy == null) {
                    zzawy = new zzfs[0];
                }
            }
        }
        return zzawy;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfs)) {
            return false;
        }
        zzfs zzfsVar = (zzfs) obj;
        if (this.zzawz == null) {
            if (zzfsVar.zzawz != null) {
                return false;
            }
        } else if (!this.zzawz.equals(zzfsVar.zzawz)) {
            return false;
        }
        if (this.zzaxa == null) {
            if (zzfsVar.zzaxa != null) {
                return false;
            }
        } else if (!this.zzaxa.equals(zzfsVar.zzaxa)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfsVar.zzcev == null || zzfsVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfsVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzawz == null ? 0 : this.zzawz.hashCode();
        int iHashCode4 = this.zzaxa == null ? 0 : this.zzaxa.hashCode();
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
                    this.zzaxa = Long.valueOf(zzxzVar.zzvc());
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
        if (this.zzaxa != null) {
            zzyaVar.zzi(2, this.zzaxa.longValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzawz != null) {
            iZzf += zzya.zzh(1, this.zzawz.intValue());
        }
        return this.zzaxa != null ? iZzf + zzya.zzd(2, this.zzaxa.longValue()) : iZzf;
    }
}
