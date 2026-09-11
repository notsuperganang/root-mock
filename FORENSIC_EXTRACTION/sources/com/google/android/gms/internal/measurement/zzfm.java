package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfm extends zzyc<zzfm> {
    private static volatile zzfm[] zzawb;
    public Integer zzavm = null;
    public String zzawc = null;
    public zzfk zzawd = null;
    public Boolean zzavj = null;
    public Boolean zzavk = null;

    public zzfm() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfm[] zzmu() {
        if (zzawb == null) {
            synchronized (zzyg.zzcfe) {
                if (zzawb == null) {
                    zzawb = new zzfm[0];
                }
            }
        }
        return zzawb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfm)) {
            return false;
        }
        zzfm zzfmVar = (zzfm) obj;
        if (this.zzavm == null) {
            if (zzfmVar.zzavm != null) {
                return false;
            }
        } else if (!this.zzavm.equals(zzfmVar.zzavm)) {
            return false;
        }
        if (this.zzawc == null) {
            if (zzfmVar.zzawc != null) {
                return false;
            }
        } else if (!this.zzawc.equals(zzfmVar.zzawc)) {
            return false;
        }
        if (this.zzawd == null) {
            if (zzfmVar.zzawd != null) {
                return false;
            }
        } else if (!this.zzawd.equals(zzfmVar.zzawd)) {
            return false;
        }
        if (this.zzavj == null) {
            if (zzfmVar.zzavj != null) {
                return false;
            }
        } else if (!this.zzavj.equals(zzfmVar.zzavj)) {
            return false;
        }
        if (this.zzavk == null) {
            if (zzfmVar.zzavk != null) {
                return false;
            }
        } else if (!this.zzavk.equals(zzfmVar.zzavk)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfmVar.zzcev == null || zzfmVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfmVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzavm == null ? 0 : this.zzavm.hashCode();
        int iHashCode4 = this.zzawc == null ? 0 : this.zzawc.hashCode();
        zzfk zzfkVar = this.zzawd;
        int iHashCode5 = zzfkVar == null ? 0 : zzfkVar.hashCode();
        int iHashCode6 = this.zzavj == null ? 0 : this.zzavj.hashCode();
        int iHashCode7 = this.zzavk == null ? 0 : this.zzavk.hashCode();
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
                case 8:
                    this.zzavm = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 18:
                    this.zzawc = zzxzVar.readString();
                    break;
                case 26:
                    if (this.zzawd == null) {
                        this.zzawd = new zzfk();
                    }
                    zzxzVar.zza(this.zzawd);
                    break;
                case 32:
                    this.zzavj = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 40:
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
        if (this.zzawc != null) {
            zzyaVar.zzb(2, this.zzawc);
        }
        if (this.zzawd != null) {
            zzyaVar.zza(3, this.zzawd);
        }
        if (this.zzavj != null) {
            zzyaVar.zzb(4, this.zzavj.booleanValue());
        }
        if (this.zzavk != null) {
            zzyaVar.zzb(5, this.zzavk.booleanValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzavm != null) {
            iZzf += zzya.zzh(1, this.zzavm.intValue());
        }
        if (this.zzawc != null) {
            iZzf += zzya.zzc(2, this.zzawc);
        }
        if (this.zzawd != null) {
            iZzf += zzya.zzb(3, this.zzawd);
        }
        if (this.zzavj != null) {
            this.zzavj.booleanValue();
            iZzf += zzya.zzbd(4) + 1;
        }
        if (this.zzavk == null) {
            return iZzf;
        }
        this.zzavk.booleanValue();
        return iZzf + zzya.zzbd(5) + 1;
    }
}
