package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfk extends zzyc<zzfk> {
    private static volatile zzfk[] zzavr;
    public zzfn zzavs = null;
    public zzfl zzavt = null;
    public Boolean zzavu = null;
    public String zzavv = null;

    public zzfk() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfk[] zzmt() {
        if (zzavr == null) {
            synchronized (zzyg.zzcfe) {
                if (zzavr == null) {
                    zzavr = new zzfk[0];
                }
            }
        }
        return zzavr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfk)) {
            return false;
        }
        zzfk zzfkVar = (zzfk) obj;
        if (this.zzavs == null) {
            if (zzfkVar.zzavs != null) {
                return false;
            }
        } else if (!this.zzavs.equals(zzfkVar.zzavs)) {
            return false;
        }
        if (this.zzavt == null) {
            if (zzfkVar.zzavt != null) {
                return false;
            }
        } else if (!this.zzavt.equals(zzfkVar.zzavt)) {
            return false;
        }
        if (this.zzavu == null) {
            if (zzfkVar.zzavu != null) {
                return false;
            }
        } else if (!this.zzavu.equals(zzfkVar.zzavu)) {
            return false;
        }
        if (this.zzavv == null) {
            if (zzfkVar.zzavv != null) {
                return false;
            }
        } else if (!this.zzavv.equals(zzfkVar.zzavv)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfkVar.zzcev == null || zzfkVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfkVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        zzfn zzfnVar = this.zzavs;
        int iHashCode3 = zzfnVar == null ? 0 : zzfnVar.hashCode();
        zzfl zzflVar = this.zzavt;
        int iHashCode4 = zzflVar == null ? 0 : zzflVar.hashCode();
        int iHashCode5 = this.zzavu == null ? 0 : this.zzavu.hashCode();
        int iHashCode6 = this.zzavv == null ? 0 : this.zzavv.hashCode();
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
                case 10:
                    if (this.zzavs == null) {
                        this.zzavs = new zzfn();
                    }
                    zzxzVar.zza(this.zzavs);
                    break;
                case 18:
                    if (this.zzavt == null) {
                        this.zzavt = new zzfl();
                    }
                    zzxzVar.zza(this.zzavt);
                    break;
                case 24:
                    this.zzavu = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 34:
                    this.zzavv = zzxzVar.readString();
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
        if (this.zzavs != null) {
            zzyaVar.zza(1, this.zzavs);
        }
        if (this.zzavt != null) {
            zzyaVar.zza(2, this.zzavt);
        }
        if (this.zzavu != null) {
            zzyaVar.zzb(3, this.zzavu.booleanValue());
        }
        if (this.zzavv != null) {
            zzyaVar.zzb(4, this.zzavv);
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzavs != null) {
            iZzf += zzya.zzb(1, this.zzavs);
        }
        if (this.zzavt != null) {
            iZzf += zzya.zzb(2, this.zzavt);
        }
        if (this.zzavu != null) {
            this.zzavu.booleanValue();
            iZzf += zzya.zzbd(3) + 1;
        }
        return this.zzavv != null ? iZzf + zzya.zzc(4, this.zzavv) : iZzf;
    }
}
