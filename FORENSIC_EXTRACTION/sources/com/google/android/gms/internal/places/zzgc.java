package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzgc extends zzga {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzoh;
    private int zzoi;
    private int zzoj;
    private int zzok;
    private int zzol;

    private zzgc(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzol = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i + i2;
        this.pos = i;
        this.zzoj = this.pos;
        this.zzoh = z;
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
    private final int zzcm() throws java.io.IOException {
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
            long r0 = r5.zzck()
            int r0 = (int) r0
            goto L10
        L72:
            r1 = r2
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzgc.zzcm():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b2, code lost:
    
        if (r4[r3] < 0) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzcn() throws java.io.IOException {
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
            long r0 = r10.zzck()
            goto L13
        Lba:
            r2 = r3
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzgc.zzcn():long");
    }

    private final int zzco() throws IOException {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzhh.zzdz();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzcp() throws IOException {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzhh.zzdz();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzcq() {
        this.limit += this.zzoi;
        int i = this.limit - this.zzoj;
        if (i <= this.zzol) {
            this.zzoi = 0;
        } else {
            this.zzoi = i - this.zzol;
            this.limit -= this.zzoi;
        }
    }

    private final byte zzcr() throws IOException {
        if (this.pos == this.limit) {
            throw zzhh.zzdz();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzcp());
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzco());
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final String readString() throws IOException {
        int iZzcm = zzcm();
        if (iZzcm > 0 && iZzcm <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, iZzcm, zzhb.UTF_8);
            this.pos = iZzcm + this.pos;
            return str;
        }
        if (iZzcm == 0) {
            return "";
        }
        if (iZzcm < 0) {
            throw zzhh.zzea();
        }
        throw zzhh.zzdz();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final void zzah(int i) throws zzhh {
        if (this.zzok != i) {
            throw zzhh.zzec();
        }
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final boolean zzai(int i) throws IOException {
        int iZzcj;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos < 10) {
                    while (i2 < 10) {
                        if (zzcr() >= 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzhh.zzeb();
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
                throw zzhh.zzeb();
            case 1:
                zzam(8);
                return true;
            case 2:
                zzam(zzcm());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzam(4);
                return true;
            default:
                throw zzhh.zzed();
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

    @Override // com.google.android.gms.internal.places.zzga
    public final int zzak(int i) throws zzhh {
        if (i < 0) {
            throw zzhh.zzea();
        }
        int iZzcl = zzcl() + i;
        int i2 = this.zzol;
        if (iZzcl > i2) {
            throw zzhh.zzdz();
        }
        this.zzol = iZzcl;
        zzcq();
        return i2;
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final void zzal(int i) {
        this.zzol = i;
        zzcq();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final void zzam(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else {
            if (i >= 0) {
                throw zzhh.zzdz();
            }
            throw zzhh.zzea();
        }
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final <T extends zzih> T zzb(zzir<T> zzirVar, zzgl zzglVar) throws IOException {
        int iZzcm = zzcm();
        if (this.zzob >= this.zzoc) {
            throw zzhh.zzee();
        }
        int iZzak = zzak(iZzcm);
        this.zzob++;
        T tZzb = zzirVar.zzb(this, zzglVar);
        zzah(0);
        this.zzob--;
        zzal(iZzak);
        return tZzb;
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final boolean zzbf() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final long zzbi() throws IOException {
        return zzcn();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final long zzbj() throws IOException {
        return zzcn();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final int zzbk() throws IOException {
        return zzcm();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final long zzbl() throws IOException {
        return zzcp();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final int zzbm() throws IOException {
        return zzco();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final boolean zzbn() throws IOException {
        return zzcn() != 0;
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final String zzbo() throws IOException {
        int iZzcm = zzcm();
        if (iZzcm <= 0 || iZzcm > this.limit - this.pos) {
            if (iZzcm == 0) {
                return "";
            }
            if (iZzcm <= 0) {
                throw zzhh.zzea();
            }
            throw zzhh.zzdz();
        }
        if (!zzjy.zzh(this.buffer, this.pos, this.pos + iZzcm)) {
            throw zzhh.zzeg();
        }
        int i = this.pos;
        this.pos += iZzcm;
        return new String(this.buffer, i, iZzcm, zzhb.UTF_8);
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final zzfr zzbp() throws IOException {
        byte[] bArrCopyOfRange;
        int iZzcm = zzcm();
        if (iZzcm > 0 && iZzcm <= this.limit - this.pos) {
            zzfr zzfrVarZzc = zzfr.zzc(this.buffer, this.pos, iZzcm);
            this.pos = iZzcm + this.pos;
            return zzfrVarZzc;
        }
        if (iZzcm == 0) {
            return zzfr.zznt;
        }
        if (iZzcm > 0 && iZzcm <= this.limit - this.pos) {
            int i = this.pos;
            this.pos = iZzcm + this.pos;
            bArrCopyOfRange = Arrays.copyOfRange(this.buffer, i, this.pos);
        } else {
            if (iZzcm > 0) {
                throw zzhh.zzdz();
            }
            if (iZzcm != 0) {
                throw zzhh.zzea();
            }
            bArrCopyOfRange = zzhb.zztl;
        }
        return zzfr.zzc(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final int zzbq() throws IOException {
        return zzcm();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final int zzbr() throws IOException {
        return zzcm();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final int zzbs() throws IOException {
        return zzco();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final long zzbt() throws IOException {
        return zzcp();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final int zzbu() throws IOException {
        return zzan(zzcm());
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final long zzbv() throws IOException {
        return zzd(zzcn());
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final int zzcj() throws IOException {
        if (zzbf()) {
            this.zzok = 0;
            return 0;
        }
        this.zzok = zzcm();
        if ((this.zzok >>> 3) == 0) {
            throw new zzhh("Protocol message contained an invalid tag (zero).");
        }
        return this.zzok;
    }

    @Override // com.google.android.gms.internal.places.zzga
    final long zzck() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzcr = zzcr();
            j |= ((long) (bZzcr & 127)) << i;
            if ((bZzcr & 128) == 0) {
                return j;
            }
        }
        throw zzhh.zzeb();
    }

    @Override // com.google.android.gms.internal.places.zzga
    public final int zzcl() {
        return this.pos - this.zzoj;
    }
}
