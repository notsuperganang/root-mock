package com.google.android.gms.internal.places;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class zzfy extends zzfx {
    protected final byte[] zzoa;

    zzfy(byte[] bArr) {
        this.zzoa = bArr;
    }

    @Override // com.google.android.gms.internal.places.zzfr
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfr) && size() == ((zzfr) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof zzfy)) {
                return obj.equals(this);
            }
            int iZzcf = zzcf();
            int iZzcf2 = ((zzfy) obj).zzcf();
            if (iZzcf == 0 || iZzcf2 == 0 || iZzcf == iZzcf2) {
                return zzb((zzfy) obj, 0, size());
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.places.zzfr
    public int size() {
        return this.zzoa.length;
    }

    @Override // com.google.android.gms.internal.places.zzfr
    public byte zzaf(int i) {
        return this.zzoa[i];
    }

    @Override // com.google.android.gms.internal.places.zzfr
    protected final int zzb(int i, int i2, int i3) {
        return zzhb.zzb(i, this.zzoa, zzcg(), i3);
    }

    @Override // com.google.android.gms.internal.places.zzfr
    protected final String zzb(Charset charset) {
        return new String(this.zzoa, zzcg(), size(), charset);
    }

    @Override // com.google.android.gms.internal.places.zzfr
    final void zzb(zzfq zzfqVar) throws IOException {
        zzfqVar.zzb(this.zzoa, zzcg(), size());
    }

    @Override // com.google.android.gms.internal.places.zzfr
    protected void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzoa, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.places.zzfx
    final boolean zzb(zzfr zzfrVar, int i, int i2) {
        if (i2 > zzfrVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(size()).toString());
        }
        if (i2 > zzfrVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: 0, ").append(i2).append(", ").append(zzfrVar.size()).toString());
        }
        if (!(zzfrVar instanceof zzfy)) {
            return zzfrVar.zzc(0, i2).equals(zzc(0, i2));
        }
        zzfy zzfyVar = (zzfy) zzfrVar;
        byte[] bArr = this.zzoa;
        byte[] bArr2 = zzfyVar.zzoa;
        int iZzcg = zzcg() + i2;
        int iZzcg2 = zzcg();
        int iZzcg3 = zzfyVar.zzcg();
        while (iZzcg2 < iZzcg) {
            if (bArr[iZzcg2] != bArr2[iZzcg3]) {
                return false;
            }
            iZzcg2++;
            iZzcg3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.places.zzfr
    public final zzfr zzc(int i, int i2) {
        int iZzc = zzc(0, i2, size());
        return iZzc == 0 ? zzfr.zznt : new zzfu(this.zzoa, zzcg(), iZzc);
    }

    @Override // com.google.android.gms.internal.places.zzfr
    public final boolean zzce() {
        int iZzcg = zzcg();
        return zzjy.zzh(this.zzoa, iZzcg, size() + iZzcg);
    }

    protected int zzcg() {
        return 0;
    }
}
