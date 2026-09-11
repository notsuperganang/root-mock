package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfz extends zzyc<zzfz> {
    private static volatile zzfz[] zzayv;
    public Long zzayw = null;
    public String name = null;
    public String zzamn = null;
    public Long zzaxg = null;
    private Float zzauo = null;
    public Double zzaup = null;

    public zzfz() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfz[] zznd() {
        if (zzayv == null) {
            synchronized (zzyg.zzcfe) {
                if (zzayv == null) {
                    zzayv = new zzfz[0];
                }
            }
        }
        return zzayv;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfz)) {
            return false;
        }
        zzfz zzfzVar = (zzfz) obj;
        if (this.zzayw == null) {
            if (zzfzVar.zzayw != null) {
                return false;
            }
        } else if (!this.zzayw.equals(zzfzVar.zzayw)) {
            return false;
        }
        if (this.name == null) {
            if (zzfzVar.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzfzVar.name)) {
            return false;
        }
        if (this.zzamn == null) {
            if (zzfzVar.zzamn != null) {
                return false;
            }
        } else if (!this.zzamn.equals(zzfzVar.zzamn)) {
            return false;
        }
        if (this.zzaxg == null) {
            if (zzfzVar.zzaxg != null) {
                return false;
            }
        } else if (!this.zzaxg.equals(zzfzVar.zzaxg)) {
            return false;
        }
        if (this.zzauo == null) {
            if (zzfzVar.zzauo != null) {
                return false;
            }
        } else if (!this.zzauo.equals(zzfzVar.zzauo)) {
            return false;
        }
        if (this.zzaup == null) {
            if (zzfzVar.zzaup != null) {
                return false;
            }
        } else if (!this.zzaup.equals(zzfzVar.zzaup)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfzVar.zzcev == null || zzfzVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfzVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzayw == null ? 0 : this.zzayw.hashCode();
        int iHashCode4 = this.name == null ? 0 : this.name.hashCode();
        int iHashCode5 = this.zzamn == null ? 0 : this.zzamn.hashCode();
        int iHashCode6 = this.zzaxg == null ? 0 : this.zzaxg.hashCode();
        int iHashCode7 = this.zzauo == null ? 0 : this.zzauo.hashCode();
        int iHashCode8 = this.zzaup == null ? 0 : this.zzaup.hashCode();
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((((((((((iHashCode3 + ((iHashCode2 + 527) * 31)) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 8:
                    this.zzayw = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 18:
                    this.name = zzxzVar.readString();
                    break;
                case 26:
                    this.zzamn = zzxzVar.readString();
                    break;
                case 32:
                    this.zzaxg = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 45:
                    this.zzauo = Float.valueOf(Float.intBitsToFloat(zzxzVar.zzvd()));
                    break;
                case 49:
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
        if (this.zzayw != null) {
            zzyaVar.zzi(1, this.zzayw.longValue());
        }
        if (this.name != null) {
            zzyaVar.zzb(2, this.name);
        }
        if (this.zzamn != null) {
            zzyaVar.zzb(3, this.zzamn);
        }
        if (this.zzaxg != null) {
            zzyaVar.zzi(4, this.zzaxg.longValue());
        }
        if (this.zzauo != null) {
            zzyaVar.zza(5, this.zzauo.floatValue());
        }
        if (this.zzaup != null) {
            zzyaVar.zza(6, this.zzaup.doubleValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzayw != null) {
            iZzf += zzya.zzd(1, this.zzayw.longValue());
        }
        if (this.name != null) {
            iZzf += zzya.zzc(2, this.name);
        }
        if (this.zzamn != null) {
            iZzf += zzya.zzc(3, this.zzamn);
        }
        if (this.zzaxg != null) {
            iZzf += zzya.zzd(4, this.zzaxg.longValue());
        }
        if (this.zzauo != null) {
            this.zzauo.floatValue();
            iZzf += zzya.zzbd(5) + 4;
        }
        if (this.zzaup == null) {
            return iZzf;
        }
        this.zzaup.doubleValue();
        return iZzf + zzya.zzbd(6) + 8;
    }
}
