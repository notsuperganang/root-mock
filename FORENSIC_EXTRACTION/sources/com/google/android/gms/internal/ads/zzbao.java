package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class zzbao extends zzban {
    protected final byte[] zzdpw;

    zzbao(byte[] bArr) {
        this.zzdpw = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzbah) && size() == ((zzbah) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof zzbao)) {
                return obj.equals(this);
            }
            int iZzabg = zzabg();
            int iZzabg2 = ((zzbao) obj).zzabg();
            if (iZzabg == 0 || iZzabg2 == 0 || iZzabg == iZzabg2) {
                return zza((zzbao) obj, 0, size());
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public int size() {
        return this.zzdpw.length;
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    protected final String zza(Charset charset) {
        return new String(this.zzdpw, zzabh(), size(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    final void zza(zzbag zzbagVar) throws IOException {
        zzbagVar.zzb(this.zzdpw, zzabh(), size());
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    protected void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzdpw, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    final boolean zza(zzbah zzbahVar, int i, int i2) {
        if (i2 > zzbahVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(size()).toString());
        }
        if (i2 > zzbahVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: 0, ").append(i2).append(", ").append(zzbahVar.size()).toString());
        }
        if (!(zzbahVar instanceof zzbao)) {
            return zzbahVar.zzk(0, i2).equals(zzk(0, i2));
        }
        zzbao zzbaoVar = (zzbao) zzbahVar;
        byte[] bArr = this.zzdpw;
        byte[] bArr2 = zzbaoVar.zzdpw;
        int iZzabh = zzabh();
        int iZzabh2 = zzabh();
        int iZzabh3 = zzbaoVar.zzabh();
        while (iZzabh2 < iZzabh + i2) {
            if (bArr[iZzabh2] != bArr2[iZzabh3]) {
                return false;
            }
            iZzabh2++;
            iZzabh3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final boolean zzabe() {
        int iZzabh = zzabh();
        return zzbem.zzf(this.zzdpw, iZzabh, size() + iZzabh);
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final zzbaq zzabf() {
        return zzbaq.zza(this.zzdpw, zzabh(), size(), true);
    }

    protected int zzabh() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public byte zzbn(int i) {
        return this.zzdpw[i];
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    protected final int zzc(int i, int i2, int i3) {
        return zzbbq.zza(i, this.zzdpw, zzabh(), i3);
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final zzbah zzk(int i, int i2) {
        int iZzd = zzd(0, i2, size());
        return iZzd == 0 ? zzbah.zzdpq : new zzbak(this.zzdpw, zzabh(), iZzd);
    }
}
