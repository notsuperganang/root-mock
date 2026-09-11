package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class zzto extends zztn {
    protected final byte[] zzbtz;

    zzto(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.zzbtz = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzte) && size() == ((zzte) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof zzto)) {
                return obj.equals(this);
            }
            int iZzuf = zzuf();
            int iZzuf2 = ((zzto) obj).zzuf();
            if (iZzuf == 0 || iZzuf2 == 0 || iZzuf == iZzuf2) {
                return zza((zzto) obj, 0, size());
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public int size() {
        return this.zzbtz.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    protected final int zza(int i, int i2, int i3) {
        return zzuq.zza(i, this.zzbtz, zzug(), i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    protected final String zza(Charset charset) {
        return new String(this.zzbtz, zzug(), size(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    final void zza(zztd zztdVar) throws IOException {
        zztdVar.zza(this.zzbtz, zzug(), size());
    }

    @Override // com.google.android.gms.internal.measurement.zztn
    final boolean zza(zzte zzteVar, int i, int i2) {
        if (i2 > zzteVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(size()).toString());
        }
        if (i2 > zzteVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: 0, ").append(i2).append(", ").append(zzteVar.size()).toString());
        }
        if (!(zzteVar instanceof zzto)) {
            return zzteVar.zzb(0, i2).equals(zzb(0, i2));
        }
        zzto zztoVar = (zzto) zzteVar;
        byte[] bArr = this.zzbtz;
        byte[] bArr2 = zztoVar.zzbtz;
        int iZzug = zzug();
        int iZzug2 = zzug();
        int iZzug3 = zztoVar.zzug();
        while (iZzug2 < iZzug + i2) {
            if (bArr[iZzug2] != bArr2[iZzug3]) {
                return false;
            }
            iZzug2++;
            iZzug3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public byte zzam(int i) {
        return this.zzbtz[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    byte zzan(int i) {
        return this.zzbtz[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final zzte zzb(int i, int i2) {
        int iZzb = zzb(0, i2, size());
        return iZzb == 0 ? zzte.zzbts : new zztj(this.zzbtz, zzug(), iZzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final boolean zzue() {
        int iZzug = zzug();
        return zzxl.zzf(this.zzbtz, iZzug, size() + iZzug);
    }

    protected int zzug() {
        return 0;
    }
}
