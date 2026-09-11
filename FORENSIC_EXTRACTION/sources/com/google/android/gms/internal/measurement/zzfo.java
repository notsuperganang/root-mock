package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfo extends zzyc<zzfo> {
    private static volatile zzfo[] zzawi;
    public String name = null;
    public Boolean zzawj = null;
    public Boolean zzawk = null;
    public Integer zzawl = null;

    public zzfo() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfo[] zzmv() {
        if (zzawi == null) {
            synchronized (zzyg.zzcfe) {
                if (zzawi == null) {
                    zzawi = new zzfo[0];
                }
            }
        }
        return zzawi;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfo)) {
            return false;
        }
        zzfo zzfoVar = (zzfo) obj;
        if (this.name == null) {
            if (zzfoVar.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzfoVar.name)) {
            return false;
        }
        if (this.zzawj == null) {
            if (zzfoVar.zzawj != null) {
                return false;
            }
        } else if (!this.zzawj.equals(zzfoVar.zzawj)) {
            return false;
        }
        if (this.zzawk == null) {
            if (zzfoVar.zzawk != null) {
                return false;
            }
        } else if (!this.zzawk.equals(zzfoVar.zzawk)) {
            return false;
        }
        if (this.zzawl == null) {
            if (zzfoVar.zzawl != null) {
                return false;
            }
        } else if (!this.zzawl.equals(zzfoVar.zzawl)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfoVar.zzcev == null || zzfoVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfoVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.name == null ? 0 : this.name.hashCode();
        int iHashCode4 = this.zzawj == null ? 0 : this.zzawj.hashCode();
        int iHashCode5 = this.zzawk == null ? 0 : this.zzawk.hashCode();
        int iHashCode6 = this.zzawl == null ? 0 : this.zzawl.hashCode();
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
                    this.name = zzxzVar.readString();
                    break;
                case 16:
                    this.zzawj = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 24:
                    this.zzawk = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 32:
                    this.zzawl = Integer.valueOf(zzxzVar.zzvb());
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
        if (this.zzawj != null) {
            zzyaVar.zzb(2, this.zzawj.booleanValue());
        }
        if (this.zzawk != null) {
            zzyaVar.zzb(3, this.zzawk.booleanValue());
        }
        if (this.zzawl != null) {
            zzyaVar.zzd(4, this.zzawl.intValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.name != null) {
            iZzf += zzya.zzc(1, this.name);
        }
        if (this.zzawj != null) {
            this.zzawj.booleanValue();
            iZzf += zzya.zzbd(2) + 1;
        }
        if (this.zzawk != null) {
            this.zzawk.booleanValue();
            iZzf += zzya.zzbd(3) + 1;
        }
        return this.zzawl != null ? iZzf + zzya.zzh(4, this.zzawl.intValue()) : iZzf;
    }
}
