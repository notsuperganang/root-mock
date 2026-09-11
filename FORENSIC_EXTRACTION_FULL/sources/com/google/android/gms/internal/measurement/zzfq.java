package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfq extends zzyc<zzfq> {
    private static volatile zzfq[] zzawt;
    public String zzoj = null;
    public String value = null;

    public zzfq() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfq[] zzmw() {
        if (zzawt == null) {
            synchronized (zzyg.zzcfe) {
                if (zzawt == null) {
                    zzawt = new zzfq[0];
                }
            }
        }
        return zzawt;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfq)) {
            return false;
        }
        zzfq zzfqVar = (zzfq) obj;
        if (this.zzoj == null) {
            if (zzfqVar.zzoj != null) {
                return false;
            }
        } else if (!this.zzoj.equals(zzfqVar.zzoj)) {
            return false;
        }
        if (this.value == null) {
            if (zzfqVar.value != null) {
                return false;
            }
        } else if (!this.value.equals(zzfqVar.value)) {
            return false;
        }
        if (this.zzcev == null || this.zzcev.isEmpty()) {
            return zzfqVar.zzcev == null || zzfqVar.zzcev.isEmpty();
        }
        return this.zzcev.equals(zzfqVar.zzcev);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzoj == null ? 0 : this.zzoj.hashCode();
        int iHashCode4 = this.value == null ? 0 : this.value.hashCode();
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
                case 10:
                    this.zzoj = zzxzVar.readString();
                    break;
                case 18:
                    this.value = zzxzVar.readString();
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
        if (this.zzoj != null) {
            zzyaVar.zzb(1, this.zzoj);
        }
        if (this.value != null) {
            zzyaVar.zzb(2, this.value);
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzoj != null) {
            iZzf += zzya.zzc(1, this.zzoj);
        }
        return this.value != null ? iZzf + zzya.zzc(2, this.value) : iZzf;
    }
}
