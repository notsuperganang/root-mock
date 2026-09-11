package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfu extends zzyc<zzfu> {
    private static volatile zzfu[] zzaxf;
    public String name = null;
    public String zzamn = null;
    public Long zzaxg = null;
    private Float zzauo = null;
    public Double zzaup = null;

    public zzfu() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfu[] zzna() {
        if (zzaxf == null) {
            synchronized (zzyg.zzcfe) {
                if (zzaxf == null) {
                    zzaxf = new zzfu[0];
                }
            }
        }
        return zzaxf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfu)) {
            return false;
        }
        zzfu zzfuVar = (zzfu) obj;
        if (this.name == null) {
            if (zzfuVar.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzfuVar.name)) {
            return false;
        }
        if (this.zzamn == null) {
            if (zzfuVar.zzamn != null) {
                return false;
            }
        } else if (!this.zzamn.equals(zzfuVar.zzamn)) {
            return false;
        }
        if (this.zzaxg == null) {
            if (zzfuVar.zzaxg != null) {
                return false;
            }
        } else if (!this.zzaxg.equals(zzfuVar.zzaxg)) {
            return false;
        }
        if (this.zzauo == null) {
            if (zzfuVar.zzauo != null) {
                return false;
            }
        } else if (!this.zzauo.equals(zzfuVar.zzauo)) {
            return false;
        }
        if (this.zzaup == null) {
            if (zzfuVar.zzaup != null) {
                return false;
            }
        } else if (!this.zzaup.equals(zzfuVar.zzaup)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfuVar.zzcev == null || zzfuVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfuVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.name == null ? 0 : this.name.hashCode();
        int iHashCode4 = this.zzamn == null ? 0 : this.zzamn.hashCode();
        int iHashCode5 = this.zzaxg == null ? 0 : this.zzaxg.hashCode();
        int iHashCode6 = this.zzauo == null ? 0 : this.zzauo.hashCode();
        int iHashCode7 = this.zzaup == null ? 0 : this.zzaup.hashCode();
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
                case 10:
                    this.name = zzxzVar.readString();
                    break;
                case 18:
                    this.zzamn = zzxzVar.readString();
                    break;
                case 24:
                    this.zzaxg = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 37:
                    this.zzauo = Float.valueOf(Float.intBitsToFloat(zzxzVar.zzvd()));
                    break;
                case 41:
                    this.zzaup = Double.valueOf(Double.longBitsToDouble(zzxzVar.zzve()));
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
        if (this.name != null) {
            zzyaVar.zzb(1, this.name);
        }
        if (this.zzamn != null) {
            zzyaVar.zzb(2, this.zzamn);
        }
        if (this.zzaxg != null) {
            zzyaVar.zzi(3, this.zzaxg.longValue());
        }
        if (this.zzauo != null) {
            zzyaVar.zza(4, this.zzauo.floatValue());
        }
        if (this.zzaup != null) {
            zzyaVar.zza(5, this.zzaup.doubleValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.name != null) {
            iZzf += zzya.zzc(1, this.name);
        }
        if (this.zzamn != null) {
            iZzf += zzya.zzc(2, this.zzamn);
        }
        if (this.zzaxg != null) {
            iZzf += zzya.zzd(3, this.zzaxg.longValue());
        }
        if (this.zzauo != null) {
            this.zzauo.floatValue();
            iZzf += zzya.zzbd(4) + 4;
        }
        if (this.zzaup == null) {
            return iZzf;
        }
        this.zzaup.doubleValue();
        return iZzf + zzya.zzbd(5) + 8;
    }
}
