package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzft extends zzyc<zzft> {
    private static volatile zzft[] zzaxb;
    public zzfu[] zzaxc = zzfu.zzna();
    public String name = null;
    public Long zzaxd = null;
    public Long zzaxe = null;
    public Integer count = null;

    public zzft() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzft[] zzmz() {
        if (zzaxb == null) {
            synchronized (zzyg.zzcfe) {
                if (zzaxb == null) {
                    zzaxb = new zzft[0];
                }
            }
        }
        return zzaxb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzftVar = (zzft) obj;
        if (!zzyg.equals(this.zzaxc, zzftVar.zzaxc)) {
            return false;
        }
        if (this.name == null) {
            if (zzftVar.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzftVar.name)) {
            return false;
        }
        if (this.zzaxd == null) {
            if (zzftVar.zzaxd != null) {
                return false;
            }
        } else if (!this.zzaxd.equals(zzftVar.zzaxd)) {
            return false;
        }
        if (this.zzaxe == null) {
            if (zzftVar.zzaxe != null) {
                return false;
            }
        } else if (!this.zzaxe.equals(zzftVar.zzaxe)) {
            return false;
        }
        if (this.count == null) {
            if (zzftVar.count != null) {
                return false;
            }
        } else if (!this.count.equals(zzftVar.count)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzftVar.zzcev == null || zzftVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzftVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = zzyg.hashCode(this.zzaxc);
        int iHashCode4 = this.name == null ? 0 : this.name.hashCode();
        int iHashCode5 = this.zzaxd == null ? 0 : this.zzaxd.hashCode();
        int iHashCode6 = this.zzaxe == null ? 0 : this.zzaxe.hashCode();
        int iHashCode7 = this.count == null ? 0 : this.count.hashCode();
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((((((iHashCode4 + ((((iHashCode2 + 527) * 31) + iHashCode3) * 31)) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode;
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
                    int length = this.zzaxc == null ? 0 : this.zzaxc.length;
                    zzfu[] zzfuVarArr = new zzfu[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzaxc, 0, zzfuVarArr, 0, length);
                    }
                    while (length < zzfuVarArr.length - 1) {
                        zzfuVarArr[length] = new zzfu();
                        zzxzVar.zza(zzfuVarArr[length]);
                        zzxzVar.zzuj();
                        length++;
                    }
                    zzfuVarArr[length] = new zzfu();
                    zzxzVar.zza(zzfuVarArr[length]);
                    this.zzaxc = zzfuVarArr;
                    break;
                case 18:
                    this.name = zzxzVar.readString();
                    break;
                case 24:
                    this.zzaxd = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 32:
                    this.zzaxe = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 40:
                    this.count = Integer.valueOf(zzxzVar.zzvb());
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
        if (this.zzaxc != null && this.zzaxc.length > 0) {
            for (int i = 0; i < this.zzaxc.length; i++) {
                zzfu zzfuVar = this.zzaxc[i];
                if (zzfuVar != null) {
                    zzyaVar.zza(1, zzfuVar);
                }
            }
        }
        if (this.name != null) {
            zzyaVar.zzb(2, this.name);
        }
        if (this.zzaxd != null) {
            zzyaVar.zzi(3, this.zzaxd.longValue());
        }
        if (this.zzaxe != null) {
            zzyaVar.zzi(4, this.zzaxe.longValue());
        }
        if (this.count != null) {
            zzyaVar.zzd(5, this.count.intValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzaxc != null && this.zzaxc.length > 0) {
            for (int i = 0; i < this.zzaxc.length; i++) {
                zzfu zzfuVar = this.zzaxc[i];
                if (zzfuVar != null) {
                    iZzf += zzya.zzb(1, zzfuVar);
                }
            }
        }
        if (this.name != null) {
            iZzf += zzya.zzc(2, this.name);
        }
        if (this.zzaxd != null) {
            iZzf += zzya.zzd(3, this.zzaxd.longValue());
        }
        if (this.zzaxe != null) {
            iZzf += zzya.zzd(4, this.zzaxe.longValue());
        }
        return this.count != null ? iZzf + zzya.zzh(5, this.count.intValue()) : iZzf;
    }
}
