package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfr extends zzyc<zzfr> {
    private static volatile zzfr[] zzawu;
    public Integer zzavg = null;
    public zzfx zzawv = null;
    public zzfx zzaww = null;
    public Boolean zzawx = null;

    public zzfr() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfr[] zzmx() {
        if (zzawu == null) {
            synchronized (zzyg.zzcfe) {
                if (zzawu == null) {
                    zzawu = new zzfr[0];
                }
            }
        }
        return zzawu;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfr)) {
            return false;
        }
        zzfr zzfrVar = (zzfr) obj;
        if (this.zzavg == null) {
            if (zzfrVar.zzavg != null) {
                return false;
            }
        } else if (!this.zzavg.equals(zzfrVar.zzavg)) {
            return false;
        }
        if (this.zzawv == null) {
            if (zzfrVar.zzawv != null) {
                return false;
            }
        } else if (!this.zzawv.equals(zzfrVar.zzawv)) {
            return false;
        }
        if (this.zzaww == null) {
            if (zzfrVar.zzaww != null) {
                return false;
            }
        } else if (!this.zzaww.equals(zzfrVar.zzaww)) {
            return false;
        }
        if (this.zzawx == null) {
            if (zzfrVar.zzawx != null) {
                return false;
            }
        } else if (!this.zzawx.equals(zzfrVar.zzawx)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfrVar.zzcev == null || zzfrVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfrVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzavg == null ? 0 : this.zzavg.hashCode();
        zzfx zzfxVar = this.zzawv;
        int iHashCode4 = zzfxVar == null ? 0 : zzfxVar.hashCode();
        zzfx zzfxVar2 = this.zzaww;
        int iHashCode5 = zzfxVar2 == null ? 0 : zzfxVar2.hashCode();
        int iHashCode6 = this.zzawx == null ? 0 : this.zzawx.hashCode();
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((((((iHashCode3 + ((iHashCode2 + 527) * 31)) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode;
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
                    if (this.zzawv == null) {
                        this.zzawv = new zzfx();
                    }
                    zzxzVar.zza(this.zzawv);
                    break;
                case 26:
                    if (this.zzaww == null) {
                        this.zzaww = new zzfx();
                    }
                    zzxzVar.zza(this.zzaww);
                    break;
                case 32:
                    this.zzawx = Boolean.valueOf(zzxzVar.zzup());
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
        if (this.zzawv != null) {
            zzyaVar.zza(2, this.zzawv);
        }
        if (this.zzaww != null) {
            zzyaVar.zza(3, this.zzaww);
        }
        if (this.zzawx != null) {
            zzyaVar.zzb(4, this.zzawx.booleanValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzavg != null) {
            iZzf += zzya.zzh(1, this.zzavg.intValue());
        }
        if (this.zzawv != null) {
            iZzf += zzya.zzb(2, this.zzawv);
        }
        if (this.zzaww != null) {
            iZzf += zzya.zzb(3, this.zzaww);
        }
        if (this.zzawx == null) {
            return iZzf;
        }
        this.zzawx.booleanValue();
        return iZzf + zzya.zzbd(4) + 1;
    }
}
