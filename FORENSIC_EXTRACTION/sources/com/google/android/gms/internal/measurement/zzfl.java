package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfl extends zzyc<zzfl> {
    public Integer zzavw = null;
    public Boolean zzavx = null;
    public String zzavy = null;
    public String zzavz = null;
    public String zzawa = null;

    public zzfl() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzyi
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzfl zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 8:
                    int position = zzxzVar.getPosition();
                    try {
                        int iZzvb = zzxzVar.zzvb();
                        if (iZzvb < 0 || iZzvb > 4) {
                            throw new IllegalArgumentException(new StringBuilder(46).append(iZzvb).append(" is not a valid enum ComparisonType").toString());
                        }
                        this.zzavw = Integer.valueOf(iZzvb);
                    } catch (IllegalArgumentException e) {
                        zzxzVar.zzcb(position);
                        zza(zzxzVar, iZzuj);
                    }
                    break;
                case 16:
                    this.zzavx = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 26:
                    this.zzavy = zzxzVar.readString();
                    break;
                case 34:
                    this.zzavz = zzxzVar.readString();
                    break;
                case 42:
                    this.zzawa = zzxzVar.readString();
                    break;
                default:
                    if (!super.zza(zzxzVar, iZzuj)) {
                    }
                    break;
            }
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfl)) {
            return false;
        }
        zzfl zzflVar = (zzfl) obj;
        if (this.zzavw == null) {
            if (zzflVar.zzavw != null) {
                return false;
            }
        } else if (!this.zzavw.equals(zzflVar.zzavw)) {
            return false;
        }
        if (this.zzavx == null) {
            if (zzflVar.zzavx != null) {
                return false;
            }
        } else if (!this.zzavx.equals(zzflVar.zzavx)) {
            return false;
        }
        if (this.zzavy == null) {
            if (zzflVar.zzavy != null) {
                return false;
            }
        } else if (!this.zzavy.equals(zzflVar.zzavy)) {
            return false;
        }
        if (this.zzavz == null) {
            if (zzflVar.zzavz != null) {
                return false;
            }
        } else if (!this.zzavz.equals(zzflVar.zzavz)) {
            return false;
        }
        if (this.zzawa == null) {
            if (zzflVar.zzawa != null) {
                return false;
            }
        } else if (!this.zzawa.equals(zzflVar.zzawa)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzflVar.zzcev == null || zzflVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzflVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iIntValue = this.zzavw == null ? 0 : this.zzavw.intValue();
        int iHashCode3 = this.zzavx == null ? 0 : this.zzavx.hashCode();
        int iHashCode4 = this.zzavy == null ? 0 : this.zzavy.hashCode();
        int iHashCode5 = this.zzavz == null ? 0 : this.zzavz.hashCode();
        int iHashCode6 = this.zzawa == null ? 0 : this.zzawa.hashCode();
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((((((((iIntValue + ((iHashCode2 + 527) * 31)) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        if (this.zzavw != null) {
            zzyaVar.zzd(1, this.zzavw.intValue());
        }
        if (this.zzavx != null) {
            zzyaVar.zzb(2, this.zzavx.booleanValue());
        }
        if (this.zzavy != null) {
            zzyaVar.zzb(3, this.zzavy);
        }
        if (this.zzavz != null) {
            zzyaVar.zzb(4, this.zzavz);
        }
        if (this.zzawa != null) {
            zzyaVar.zzb(5, this.zzawa);
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzavw != null) {
            iZzf += zzya.zzh(1, this.zzavw.intValue());
        }
        if (this.zzavx != null) {
            this.zzavx.booleanValue();
            iZzf += zzya.zzbd(2) + 1;
        }
        if (this.zzavy != null) {
            iZzf += zzya.zzc(3, this.zzavy);
        }
        if (this.zzavz != null) {
            iZzf += zzya.zzc(4, this.zzavz);
        }
        return this.zzawa != null ? iZzf + zzya.zzc(5, this.zzawa) : iZzf;
    }
}
