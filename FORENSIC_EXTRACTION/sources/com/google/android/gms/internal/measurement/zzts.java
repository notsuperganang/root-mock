package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzts extends zztq {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzbuf;
    private int zzbug;
    private int zzbuh;
    private int zzbui;
    private int zzbuj;

    private zzts(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzbuj = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i + i2;
        this.pos = i;
        this.zzbuh = this.pos;
        this.zzbuf = z;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0072 A[PHI: r2
      0x0072: PHI (r2v7 int) = (r2v6 int), (r2v9 int), (r2v11 int) binds: [B:21:0x004c, B:25:0x0058, B:29:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        if (r3[r2] < 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzvb() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L6c
            byte[] r3 = r5.buffer
            int r2 = r0 + 1
            r0 = r3[r0]
            if (r0 < 0) goto L11
            r5.pos = r2
        L10:
            return r0
        L11:
            int r1 = r5.limit
            int r1 = r1 - r2
            r4 = 9
            if (r1 < r4) goto L6c
            int r1 = r2 + 1
            r2 = r3[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L26
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
        L23:
            r5.pos = r1
            goto L10
        L26:
            int r2 = r1 + 1
            r1 = r3[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L33
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            r1 = r2
            goto L23
        L33:
            int r1 = r2 + 1
            r2 = r3[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L41
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L23
        L41:
            int r2 = r1 + 1
            r1 = r3[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L72
            int r1 = r2 + 1
            r2 = r3[r2]
            if (r2 >= 0) goto L23
            int r2 = r1 + 1
            r1 = r3[r1]
            if (r1 >= 0) goto L72
            int r1 = r2 + 1
            r2 = r3[r2]
            if (r2 >= 0) goto L23
            int r2 = r1 + 1
            r1 = r3[r1]
            if (r1 >= 0) goto L72
            int r1 = r2 + 1
            r2 = r3[r2]
            if (r2 >= 0) goto L23
        L6c:
            long r0 = r5.zzuy()
            int r0 = (int) r0
            goto L10
        L72:
            r1 = r2
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzts.zzvb():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b2, code lost:
    
        if (r4[r3] < 0) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzvc() throws java.io.IOException {
        /*
            r10 = this;
            r8 = 0
            int r0 = r10.pos
            int r1 = r10.limit
            if (r1 == r0) goto Lb4
            byte[] r4 = r10.buffer
            int r1 = r0 + 1
            r0 = r4[r0]
            if (r0 < 0) goto L14
            r10.pos = r1
            long r0 = (long) r0
        L13:
            return r0
        L14:
            int r2 = r10.limit
            int r2 = r2 - r1
            r3 = 9
            if (r2 < r3) goto Lb4
            int r2 = r1 + 1
            r1 = r4[r1]
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L2a
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            long r0 = (long) r0
        L27:
            r10.pos = r2
            goto L13
        L2a:
            int r3 = r2 + 1
            r1 = r4[r2]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L38
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r2 = r3
            goto L27
        L38:
            int r2 = r3 + 1
            r1 = r4[r3]
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L47
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            long r0 = (long) r0
            goto L27
        L47:
            long r0 = (long) r0
            int r3 = r2 + 1
            r2 = r4[r2]
            long r6 = (long) r2
            r2 = 28
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L5b
            r4 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r0 = r0 ^ r4
            r2 = r3
            goto L27
        L5b:
            int r2 = r3 + 1
            r3 = r4[r3]
            long r6 = (long) r3
            r3 = 35
            long r6 = r6 << r3
            long r0 = r0 ^ r6
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L6f
            r4 = -34093383808(0xfffffff80fe03f80, double:NaN)
            long r0 = r0 ^ r4
            goto L27
        L6f:
            int r3 = r2 + 1
            r2 = r4[r2]
            long r6 = (long) r2
            r2 = 42
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L84
            r4 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            long r0 = r0 ^ r4
            r2 = r3
            goto L27
        L84:
            int r2 = r3 + 1
            r3 = r4[r3]
            long r6 = (long) r3
            r3 = 49
            long r6 = r6 << r3
            long r0 = r0 ^ r6
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L98
            r4 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            long r0 = r0 ^ r4
            goto L27
        L98:
            int r3 = r2 + 1
            r2 = r4[r2]
            long r6 = (long) r2
            r2 = 56
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            r6 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto Lba
            int r2 = r3 + 1
            r3 = r4[r3]
            long r4 = (long) r3
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 >= 0) goto L27
        Lb4:
            long r0 = r10.zzuy()
            goto L13
        Lba:
            r2 = r3
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzts.zzvc():long");
    }

    private final int zzvd() throws IOException {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzuv.zzwq();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzve() throws IOException {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzuv.zzwq();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((255 & ((long) bArr[i + 2])) << 16) | ((255 & ((long) bArr[i + 3])) << 24) | ((255 & ((long) bArr[i + 4])) << 32) | ((255 & ((long) bArr[i + 5])) << 40) | ((255 & ((long) bArr[i + 6])) << 48);
    }

    private final void zzvf() {
        this.limit += this.zzbug;
        int i = this.limit - this.zzbuh;
        if (i <= this.zzbuj) {
            this.zzbug = 0;
        } else {
            this.zzbug = i - this.zzbuj;
            this.limit -= this.zzbug;
        }
    }

    private final byte zzvg() throws IOException {
        if (this.pos == this.limit) {
            throw zzuv.zzwq();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzve());
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzvd());
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final String readString() throws IOException {
        int iZzvb = zzvb();
        if (iZzvb > 0 && iZzvb <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, iZzvb, zzuq.UTF_8);
            this.pos = iZzvb + this.pos;
            return str;
        }
        if (iZzvb == 0) {
            return "";
        }
        if (iZzvb < 0) {
            throw zzuv.zzwr();
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final <T extends zzvv> T zza(zzwf<T> zzwfVar, zzub zzubVar) throws IOException {
        int iZzvb = zzvb();
        if (this.zzbua >= this.zzbub) {
            throw zzuv.zzwv();
        }
        int iZzas = zzas(iZzvb);
        this.zzbua++;
        T tZza = zzwfVar.zza(this, zzubVar);
        zzap(0);
        this.zzbua--;
        zzat(iZzas);
        return tZza;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final void zzap(int i) throws zzuv {
        if (this.zzbui != i) {
            throw zzuv.zzwt();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final boolean zzaq(int i) throws IOException {
        int iZzuj;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos < 10) {
                    while (i2 < 10) {
                        if (zzvg() >= 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzuv.zzws();
                }
                while (i2 < 10) {
                    byte[] bArr = this.buffer;
                    int i3 = this.pos;
                    this.pos = i3 + 1;
                    if (bArr[i3] >= 0) {
                        return true;
                    }
                    i2++;
                }
                throw zzuv.zzws();
            case 1:
                zzau(8);
                return true;
            case 2:
                zzau(zzvb());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzau(4);
                return true;
            default:
                throw zzuv.zzwu();
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

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzas(int i) throws zzuv {
        if (i < 0) {
            throw zzuv.zzwr();
        }
        int iZzva = zzva() + i;
        int i2 = this.zzbuj;
        if (iZzva > i2) {
            throw zzuv.zzwq();
        }
        this.zzbuj = iZzva;
        zzvf();
        return i2;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final void zzat(int i) {
        this.zzbuj = i;
        zzvf();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final void zzau(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else {
            if (i >= 0) {
                throw zzuv.zzwq();
            }
            throw zzuv.zzwr();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuj() throws IOException {
        if (zzuz()) {
            this.zzbui = 0;
            return 0;
        }
        this.zzbui = zzvb();
        if ((this.zzbui >>> 3) == 0) {
            throw new zzuv("Protocol message contained an invalid tag (zero).");
        }
        return this.zzbui;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzuk() throws IOException {
        return zzvc();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzul() throws IOException {
        return zzvc();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzum() throws IOException {
        return zzvb();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzun() throws IOException {
        return zzve();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuo() throws IOException {
        return zzvd();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final boolean zzup() throws IOException {
        return zzvc() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final String zzuq() throws IOException {
        int iZzvb = zzvb();
        if (iZzvb > 0 && iZzvb <= this.limit - this.pos) {
            String strZzh = zzxl.zzh(this.buffer, this.pos, iZzvb);
            this.pos = iZzvb + this.pos;
            return strZzh;
        }
        if (iZzvb == 0) {
            return "";
        }
        if (iZzvb <= 0) {
            throw zzuv.zzwr();
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final zzte zzur() throws IOException {
        byte[] bArrCopyOfRange;
        int iZzvb = zzvb();
        if (iZzvb > 0 && iZzvb <= this.limit - this.pos) {
            zzte zzteVarZzb = zzte.zzb(this.buffer, this.pos, iZzvb);
            this.pos = iZzvb + this.pos;
            return zzteVarZzb;
        }
        if (iZzvb == 0) {
            return zzte.zzbts;
        }
        if (iZzvb > 0 && iZzvb <= this.limit - this.pos) {
            int i = this.pos;
            this.pos = iZzvb + this.pos;
            bArrCopyOfRange = Arrays.copyOfRange(this.buffer, i, this.pos);
        } else {
            if (iZzvb > 0) {
                throw zzuv.zzwq();
            }
            if (iZzvb != 0) {
                throw zzuv.zzwr();
            }
            bArrCopyOfRange = zzuq.zzbzc;
        }
        return zzte.zzi(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzus() throws IOException {
        return zzvb();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzut() throws IOException {
        return zzvb();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuu() throws IOException {
        return zzvd();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzuv() throws IOException {
        return zzve();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuw() throws IOException {
        int iZzvb = zzvb();
        return (iZzvb >>> 1) ^ (-(iZzvb & 1));
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzux() throws IOException {
        long jZzvc = zzvc();
        return (jZzvc >>> 1) ^ (-(1 & jZzvc));
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    final long zzuy() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzvg = zzvg();
            j |= ((long) (bZzvg & 127)) << i;
            if ((bZzvg & 128) == 0) {
                return j;
            }
        }
        throw zzuv.zzws();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final boolean zzuz() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzva() {
        return this.pos - this.zzbuh;
    }
}
