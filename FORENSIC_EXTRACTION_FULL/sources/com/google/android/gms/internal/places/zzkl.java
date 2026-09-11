package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzkl {
    private final byte[] buffer;
    private int zzaaa;
    private int zzaab;
    private zzga zzaac;
    private int zzob;
    private int zzoi;
    private int zzok;
    private final int zzzy;
    private final int zzzz;
    private int zzol = Integer.MAX_VALUE;
    private int zzoc = 64;
    private int zzod = 67108864;

    private zzkl(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzzy = i;
        int i3 = i + i2;
        this.zzaaa = i3;
        this.zzzz = i3;
        this.zzaab = i;
    }

    private final void zzam(int i) throws IOException {
        if (i < 0) {
            throw zzkt.zzhh();
        }
        if (this.zzaab + i > this.zzol) {
            zzam(this.zzol - this.zzaab);
            throw zzkt.zzhg();
        }
        if (i > this.zzaaa - this.zzaab) {
            throw zzkt.zzhg();
        }
        this.zzaab += i;
    }

    private final void zzcq() {
        this.zzaaa += this.zzoi;
        int i = this.zzaaa;
        if (i <= this.zzol) {
            this.zzoi = 0;
        } else {
            this.zzoi = i - this.zzol;
            this.zzaaa -= this.zzoi;
        }
    }

    private final byte zzcr() throws IOException {
        if (this.zzaab == this.zzaaa) {
            throw zzkt.zzhg();
        }
        byte[] bArr = this.buffer;
        int i = this.zzaab;
        this.zzaab = i + 1;
        return bArr[i];
    }

    public static zzkl zzh(byte[] bArr) {
        return zzk(bArr, 0, bArr.length);
    }

    public static zzkl zzk(byte[] bArr, int i, int i2) {
        return new zzkl(bArr, 0, i2);
    }

    public final int getPosition() {
        return this.zzaab - this.zzzy;
    }

    public final byte[] readBytes() throws IOException {
        int iZzcm = zzcm();
        if (iZzcm < 0) {
            throw zzkt.zzhh();
        }
        if (iZzcm == 0) {
            return zzkx.zzabb;
        }
        if (iZzcm > this.zzaaa - this.zzaab) {
            throw zzkt.zzhg();
        }
        byte[] bArr = new byte[iZzcm];
        System.arraycopy(this.buffer, this.zzaab, bArr, 0, iZzcm);
        this.zzaab = iZzcm + this.zzaab;
        return bArr;
    }

    public final String readString() throws IOException {
        int iZzcm = zzcm();
        if (iZzcm < 0) {
            throw zzkt.zzhh();
        }
        if (iZzcm > this.zzaaa - this.zzaab) {
            throw zzkt.zzhg();
        }
        String str = new String(this.buffer, this.zzaab, iZzcm, zzks.UTF_8);
        this.zzaab = iZzcm + this.zzaab;
        return str;
    }

    public final void zzah(int i) throws zzkt {
        if (this.zzok != i) {
            throw new zzkt("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzai(int i) throws IOException {
        int iZzcj;
        switch (i & 7) {
            case 0:
                zzcm();
                return true;
            case 1:
                zzcp();
                return true;
            case 2:
                zzam(zzcm());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzco();
                return true;
            default:
                throw new zzkt("Protocol message tag had invalid wire type.");
        }
        do {
            iZzcj = zzcj();
            if (iZzcj != 0) {
            }
            zzah(((i >>> 3) << 3) | 4);
            return true;
        } while (zzai(iZzcj));
        zzah(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzak(int i) throws zzkt {
        if (i < 0) {
            throw zzkt.zzhh();
        }
        int i2 = this.zzaab + i;
        int i3 = this.zzol;
        if (i2 > i3) {
            throw zzkt.zzhg();
        }
        this.zzol = i2;
        zzcq();
        return i3;
    }

    public final void zzal(int i) {
        this.zzol = i;
        zzcq();
    }

    public final <T extends zzgz<T, ?>> T zzb(zzir<T> zzirVar) throws IOException {
        if (this.zzaac == null) {
            this.zzaac = zzga.zzf(this.buffer, this.zzzy, this.zzzz);
        }
        int iZzcl = this.zzaac.zzcl();
        int i = this.zzaab - this.zzzy;
        if (iZzcl > i) {
            throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(iZzcl), Integer.valueOf(i)));
        }
        this.zzaac.zzam(i - iZzcl);
        this.zzaac.zzaj(this.zzoc - this.zzob);
        T t = (T) this.zzaac.zzb(zzirVar, zzgl.zzdb());
        zzai(this.zzok);
        return t;
    }

    public final void zzb(zzku zzkuVar) throws IOException {
        int iZzcm = zzcm();
        if (this.zzob >= this.zzoc) {
            throw zzkt.zzhj();
        }
        int iZzak = zzak(iZzcm);
        this.zzob++;
        zzkuVar.zzb(this);
        zzah(0);
        this.zzob--;
        zzal(iZzak);
    }

    public final void zzb(zzku zzkuVar, int i) throws IOException {
        if (this.zzob >= this.zzoc) {
            throw zzkt.zzhj();
        }
        this.zzob++;
        zzkuVar.zzb(this);
        zzah((i << 3) | 4);
        this.zzob--;
    }

    public final void zzbr(int i) {
        zzu(i, this.zzok);
    }

    public final int zzcj() throws IOException {
        if (this.zzaab == this.zzaaa) {
            this.zzok = 0;
            return 0;
        }
        this.zzok = zzcm();
        if (this.zzok == 0) {
            throw new zzkt("Protocol message contained an invalid tag (zero).");
        }
        return this.zzok;
    }

    public final int zzcm() throws IOException {
        byte bZzcr = zzcr();
        if (bZzcr >= 0) {
            return bZzcr;
        }
        int i = bZzcr & 127;
        byte bZzcr2 = zzcr();
        if (bZzcr2 >= 0) {
            return i | (bZzcr2 << 7);
        }
        int i2 = i | ((bZzcr2 & 127) << 7);
        byte bZzcr3 = zzcr();
        if (bZzcr3 >= 0) {
            return i2 | (bZzcr3 << 14);
        }
        int i3 = i2 | ((bZzcr3 & 127) << 14);
        byte bZzcr4 = zzcr();
        if (bZzcr4 >= 0) {
            return i3 | (bZzcr4 << 21);
        }
        int i4 = i3 | ((bZzcr4 & 127) << 21);
        byte bZzcr5 = zzcr();
        int i5 = i4 | (bZzcr5 << 28);
        if (bZzcr5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (zzcr() >= 0) {
                return i5;
            }
        }
        throw zzkt.zzhi();
    }

    public final long zzcn() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzcr = zzcr();
            j |= ((long) (bZzcr & 127)) << i;
            if ((bZzcr & 128) == 0) {
                return j;
            }
        }
        throw zzkt.zzhi();
    }

    public final int zzco() throws IOException {
        return (zzcr() & 255) | ((zzcr() & 255) << 8) | ((zzcr() & 255) << 16) | ((zzcr() & 255) << 24);
    }

    public final long zzcp() throws IOException {
        byte bZzcr = zzcr();
        return ((((long) zzcr()) & 255) << 8) | (((long) bZzcr) & 255) | ((((long) zzcr()) & 255) << 16) | ((((long) zzcr()) & 255) << 24) | ((((long) zzcr()) & 255) << 32) | ((((long) zzcr()) & 255) << 40) | ((((long) zzcr()) & 255) << 48) | ((((long) zzcr()) & 255) << 56);
    }

    public final int zzhb() {
        if (this.zzol == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzol - this.zzaab;
    }

    public final byte[] zzt(int i, int i2) {
        if (i2 == 0) {
            return zzkx.zzabb;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzzy + i, bArr, 0, i2);
        return bArr;
    }

    final void zzu(int i, int i2) {
        if (i > this.zzaab - this.zzzy) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.zzaab - this.zzzy).toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        }
        this.zzaab = this.zzzy + i;
        this.zzok = i2;
    }
}
