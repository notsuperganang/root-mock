package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzxz {
    private final byte[] buffer;
    private int zzbua;
    private int zzbug;
    private int zzbui;
    private final int zzceo;
    private final int zzcep;
    private int zzceq;
    private int zzcer;
    private zztq zzces;
    private int zzbuj = Integer.MAX_VALUE;
    private int zzbub = 64;
    private int zzbuc = 67108864;

    private zzxz(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzceo = i;
        int i3 = i + i2;
        this.zzceq = i3;
        this.zzcep = i3;
        this.zzcer = i;
    }

    private final void zzau(int i) throws IOException {
        if (i < 0) {
            throw zzyh.zzze();
        }
        if (this.zzcer + i > this.zzbuj) {
            zzau(this.zzbuj - this.zzcer);
            throw zzyh.zzzd();
        }
        if (i > this.zzceq - this.zzcer) {
            throw zzyh.zzzd();
        }
        this.zzcer += i;
    }

    public static zzxz zzj(byte[] bArr, int i, int i2) {
        return new zzxz(bArr, 0, i2);
    }

    public static zzxz zzn(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    private final void zzvf() {
        this.zzceq += this.zzbug;
        int i = this.zzceq;
        if (i <= this.zzbuj) {
            this.zzbug = 0;
        } else {
            this.zzbug = i - this.zzbuj;
            this.zzceq -= this.zzbug;
        }
    }

    private final byte zzvg() throws IOException {
        if (this.zzcer == this.zzceq) {
            throw zzyh.zzzd();
        }
        byte[] bArr = this.buffer;
        int i = this.zzcer;
        this.zzcer = i + 1;
        return bArr[i];
    }

    private final zztq zzyx() throws IOException {
        if (this.zzces == null) {
            this.zzces = zztq.zzd(this.buffer, this.zzceo, this.zzcep);
        }
        int iZzva = this.zzces.zzva();
        int i = this.zzcer - this.zzceo;
        if (iZzva > i) {
            throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(iZzva), Integer.valueOf(i)));
        }
        this.zzces.zzau(i - iZzva);
        this.zzces.zzar(this.zzbub - this.zzbua);
        return this.zzces;
    }

    public final int getPosition() {
        return this.zzcer - this.zzceo;
    }

    public final String readString() throws IOException {
        int iZzvb = zzvb();
        if (iZzvb < 0) {
            throw zzyh.zzze();
        }
        if (iZzvb > this.zzceq - this.zzcer) {
            throw zzyh.zzzd();
        }
        String str = new String(this.buffer, this.zzcer, iZzvb, zzyg.UTF_8);
        this.zzcer = iZzvb + this.zzcer;
        return str;
    }

    public final <T extends zzuo<T, ?>> T zza(zzwf<T> zzwfVar) throws IOException {
        try {
            T t = (T) zzyx().zza(zzwfVar, zzub.zzvs());
            zzaq(this.zzbui);
            return t;
        } catch (zzuv e) {
            throw new zzyh("", e);
        }
    }

    public final void zza(zzyi zzyiVar) throws IOException {
        int iZzvb = zzvb();
        if (this.zzbua >= this.zzbub) {
            throw zzyh.zzzg();
        }
        int iZzas = zzas(iZzvb);
        this.zzbua++;
        zzyiVar.zza(this);
        zzap(0);
        this.zzbua--;
        zzat(iZzas);
    }

    public final void zza(zzyi zzyiVar, int i) throws IOException {
        if (this.zzbua >= this.zzbub) {
            throw zzyh.zzzg();
        }
        this.zzbua++;
        zzyiVar.zza(this);
        zzap((i << 3) | 4);
        this.zzbua--;
    }

    public final void zzap(int i) throws zzyh {
        if (this.zzbui != i) {
            throw new zzyh("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzaq(int i) throws IOException {
        int iZzuj;
        switch (i & 7) {
            case 0:
                zzvb();
                return true;
            case 1:
                zzve();
                return true;
            case 2:
                zzau(zzvb());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzvd();
                return true;
            default:
                throw new zzyh("Protocol message tag had invalid wire type.");
        }
        do {
            iZzuj = zzuj();
            if (iZzuj != 0) {
            }
            zzap(((i >>> 3) << 3) | 4);
            return true;
        } while (zzaq(iZzuj));
        zzap(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzas(int i) throws zzyh {
        if (i < 0) {
            throw zzyh.zzze();
        }
        int i2 = this.zzcer + i;
        int i3 = this.zzbuj;
        if (i2 > i3) {
            throw zzyh.zzzd();
        }
        this.zzbuj = i2;
        zzvf();
        return i3;
    }

    public final void zzat(int i) {
        this.zzbuj = i;
        zzvf();
    }

    public final void zzcb(int i) {
        zzt(i, this.zzbui);
    }

    public final byte[] zzs(int i, int i2) {
        if (i2 == 0) {
            return zzyl.zzcfq;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzceo + i, bArr, 0, i2);
        return bArr;
    }

    final void zzt(int i, int i2) {
        if (i > this.zzcer - this.zzceo) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.zzcer - this.zzceo).toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        }
        this.zzcer = this.zzceo + i;
        this.zzbui = i2;
    }

    public final int zzuj() throws IOException {
        if (this.zzcer == this.zzceq) {
            this.zzbui = 0;
            return 0;
        }
        this.zzbui = zzvb();
        if (this.zzbui == 0) {
            throw new zzyh("Protocol message contained an invalid tag (zero).");
        }
        return this.zzbui;
    }

    public final boolean zzup() throws IOException {
        return zzvb() != 0;
    }

    public final int zzvb() throws IOException {
        byte bZzvg = zzvg();
        if (bZzvg >= 0) {
            return bZzvg;
        }
        int i = bZzvg & 127;
        byte bZzvg2 = zzvg();
        if (bZzvg2 >= 0) {
            return i | (bZzvg2 << 7);
        }
        int i2 = i | ((bZzvg2 & 127) << 7);
        byte bZzvg3 = zzvg();
        if (bZzvg3 >= 0) {
            return i2 | (bZzvg3 << 14);
        }
        int i3 = i2 | ((bZzvg3 & 127) << 14);
        byte bZzvg4 = zzvg();
        if (bZzvg4 >= 0) {
            return i3 | (bZzvg4 << 21);
        }
        byte bZzvg5 = zzvg();
        int i4 = i3 | ((bZzvg4 & 127) << 21) | (bZzvg5 << 28);
        if (bZzvg5 >= 0) {
            return i4;
        }
        for (int i5 = 0; i5 < 5; i5++) {
            if (zzvg() >= 0) {
                return i4;
            }
        }
        throw zzyh.zzzf();
    }

    public final long zzvc() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzvg = zzvg();
            j |= ((long) (bZzvg & 127)) << i;
            if ((bZzvg & 128) == 0) {
                return j;
            }
        }
        throw zzyh.zzzf();
    }

    public final int zzvd() throws IOException {
        return (zzvg() & 255) | ((zzvg() & 255) << 8) | ((zzvg() & 255) << 16) | ((zzvg() & 255) << 24);
    }

    public final long zzve() throws IOException {
        byte bZzvg = zzvg();
        return ((((long) zzvg()) & 255) << 8) | (((long) bZzvg) & 255) | ((((long) zzvg()) & 255) << 16) | ((((long) zzvg()) & 255) << 24) | ((((long) zzvg()) & 255) << 32) | ((((long) zzvg()) & 255) << 40) | ((((long) zzvg()) & 255) << 48) | ((((long) zzvg()) & 255) << 56);
    }

    public final int zzyy() {
        if (this.zzbuj == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbuj - this.zzcer;
    }
}
