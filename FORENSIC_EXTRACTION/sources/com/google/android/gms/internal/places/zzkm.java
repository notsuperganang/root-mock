package com.google.android.gms.internal.places;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: loaded from: classes.dex */
public final class zzkm {
    private zzgf zzaad;
    private int zzaae;
    private final ByteBuffer zzot;

    private zzkm(ByteBuffer byteBuffer) {
        this.zzot = byteBuffer;
        this.zzot.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzkm(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzas(int i) {
        return zzba(i << 3);
    }

    public static int zzat(int i) {
        if (i >= 0) {
            return zzba(i);
        }
        return 10;
    }

    private static int zzb(CharSequence charSequence) {
        int i;
        int i2 = 0;
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 < length) {
                char cCharAt = charSequence.charAt(i3);
                if (cCharAt >= 2048) {
                    int length2 = charSequence.length();
                    while (i3 < length2) {
                        char cCharAt2 = charSequence.charAt(i3);
                        if (cCharAt2 < 2048) {
                            i2 += (127 - cCharAt2) >>> 31;
                        } else {
                            i2 += 2;
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                                if (Character.codePointAt(charSequence, i3) < 65536) {
                                    throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3).toString());
                                }
                                i3++;
                            }
                        }
                        i3++;
                    }
                    i = i4 + i2;
                    break;
                }
                i4 += (127 - cCharAt) >>> 31;
                i3++;
            } else {
                i = i4;
                break;
            }
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(((long) i) + 4294967296L).toString());
    }

    public static int zzba(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    private final void zzbs(int i) throws IOException {
        byte b = (byte) i;
        if (!this.zzot.hasRemaining()) {
            throw new zzkn(this.zzot.position(), this.zzot.limit());
        }
        this.zzot.put(b);
    }

    public static int zzc(int i, zzku zzkuVar) {
        int iZzas = zzas(i);
        int iZzdg = zzkuVar.zzdg();
        return iZzas + iZzdg + zzba(iZzdg);
    }

    public static int zzc(int i, String str) {
        return zzas(i) + zzl(str);
    }

    public static int zze(int i, long j) {
        int i2;
        int iZzas = zzas(i);
        if (((-128) & j) == 0) {
            i2 = 1;
        } else if (((-16384) & j) == 0) {
            i2 = 2;
        } else if (((-2097152) & j) == 0) {
            i2 = 3;
        } else if (((-268435456) & j) == 0) {
            i2 = 4;
        } else if (((-34359738368L) & j) == 0) {
            i2 = 5;
        } else if (((-4398046511104L) & j) == 0) {
            i2 = 6;
        } else if (((-562949953421312L) & j) == 0) {
            i2 = 7;
        } else if (((-72057594037927936L) & j) == 0) {
            i2 = 8;
        } else {
            i2 = (Long.MIN_VALUE & j) == 0 ? 9 : 10;
        }
        return i2 + iZzas;
    }

    private static void zze(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3 = 0;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            int length = charSequence.length();
            while (i3 < length) {
                char cCharAt = charSequence.charAt(i3);
                if (cCharAt < 128) {
                    byteBuffer.put((byte) cCharAt);
                } else if (cCharAt < 2048) {
                    byteBuffer.put((byte) ((cCharAt >>> 6) | 960));
                    byteBuffer.put((byte) ((cCharAt & '?') | 128));
                } else {
                    if (cCharAt >= 55296 && 57343 >= cCharAt) {
                        if (i3 + 1 != charSequence.length()) {
                            i3++;
                            char cCharAt2 = charSequence.charAt(i3);
                            if (Character.isSurrogatePair(cCharAt, cCharAt2)) {
                                int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                                byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint & 63) | 128));
                            }
                        }
                        throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3 - 1).toString());
                    }
                    byteBuffer.put((byte) ((cCharAt >>> '\f') | 480));
                    byteBuffer.put((byte) (((cCharAt >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((cCharAt & '?') | 128));
                }
                i3++;
            }
            return;
        }
        try {
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            int length2 = charSequence.length();
            int i4 = iArrayOffset + iRemaining;
            while (i3 < length2 && i3 + iArrayOffset < i4) {
                char cCharAt3 = charSequence.charAt(i3);
                if (cCharAt3 >= 128) {
                    break;
                }
                bArrArray[iArrayOffset + i3] = (byte) cCharAt3;
                i3++;
            }
            if (i3 == length2) {
                i = iArrayOffset + length2;
            } else {
                int i5 = iArrayOffset + i3;
                while (i3 < length2) {
                    char cCharAt4 = charSequence.charAt(i3);
                    if (cCharAt4 < 128 && i5 < i4) {
                        i2 = i5 + 1;
                        bArrArray[i5] = (byte) cCharAt4;
                    } else if (cCharAt4 < 2048 && i5 <= i4 - 2) {
                        int i6 = i5 + 1;
                        bArrArray[i5] = (byte) ((cCharAt4 >>> 6) | 960);
                        i2 = i6 + 1;
                        bArrArray[i6] = (byte) ((cCharAt4 & '?') | 128);
                    } else {
                        if ((cCharAt4 >= 55296 && 57343 >= cCharAt4) || i5 > i4 - 3) {
                            if (i5 > i4 - 4) {
                                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(cCharAt4).append(" at index ").append(i5).toString());
                            }
                            if (i3 + 1 != charSequence.length()) {
                                i3++;
                                char cCharAt5 = charSequence.charAt(i3);
                                if (Character.isSurrogatePair(cCharAt4, cCharAt5)) {
                                    int codePoint2 = Character.toCodePoint(cCharAt4, cCharAt5);
                                    int i7 = i5 + 1;
                                    bArrArray[i5] = (byte) ((codePoint2 >>> 18) | 240);
                                    int i8 = i7 + 1;
                                    bArrArray[i7] = (byte) (((codePoint2 >>> 12) & 63) | 128);
                                    int i9 = i8 + 1;
                                    bArrArray[i8] = (byte) (((codePoint2 >>> 6) & 63) | 128);
                                    i2 = i9 + 1;
                                    bArrArray[i9] = (byte) ((codePoint2 & 63) | 128);
                                }
                            }
                            throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3 - 1).toString());
                        }
                        int i10 = i5 + 1;
                        bArrArray[i5] = (byte) ((cCharAt4 >>> '\f') | 480);
                        int i11 = i10 + 1;
                        bArrArray[i10] = (byte) (((cCharAt4 >>> 6) & 63) | 128);
                        i2 = i11 + 1;
                        bArrArray[i11] = (byte) ((cCharAt4 & '?') | 128);
                    }
                    i3++;
                    i5 = i2;
                }
                i = i5;
            }
            byteBuffer.position(i - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    private final zzgf zzhc() throws IOException {
        if (this.zzaad == null) {
            this.zzaad = zzgf.zzb(this.zzot);
            this.zzaae = this.zzot.position();
        } else if (this.zzaae != this.zzot.position()) {
            this.zzaad.write(this.zzot.array(), this.zzaae, this.zzot.position() - this.zzaae);
            this.zzaae = this.zzot.position();
        }
        return this.zzaad;
    }

    public static int zzi(int i, int i2) {
        return zzas(i) + zzat(i2);
    }

    public static zzkm zzi(byte[] bArr) {
        return zzl(bArr, 0, bArr.length);
    }

    public static int zzj(byte[] bArr) {
        return zzba(bArr.length) + bArr.length;
    }

    public static int zzl(String str) {
        int iZzb = zzb(str);
        return iZzb + zzba(iZzb);
    }

    public static zzkm zzl(byte[] bArr, int i, int i2) {
        return new zzkm(bArr, 0, i2);
    }

    private final void zzq(long j) throws IOException {
        while (((-128) & j) != 0) {
            zzbs((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzbs((int) j);
    }

    public final void zzb(int i, double d) throws IOException {
        zzd(i, 1);
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        if (this.zzot.remaining() < 8) {
            throw new zzkn(this.zzot.position(), this.zzot.limit());
        }
        this.zzot.putLong(jDoubleToLongBits);
    }

    public final void zzb(int i, zzku zzkuVar) throws IOException {
        zzd(i, 2);
        zzc(zzkuVar);
    }

    public final void zzb(int i, String str) throws IOException {
        zzd(i, 2);
        try {
            int iZzba = zzba(str.length());
            if (iZzba != zzba(str.length() * 3)) {
                zzbt(zzb(str));
                zze(str, this.zzot);
                return;
            }
            int iPosition = this.zzot.position();
            if (this.zzot.remaining() < iZzba) {
                throw new zzkn(iZzba + iPosition, this.zzot.limit());
            }
            this.zzot.position(iPosition + iZzba);
            zze(str, this.zzot);
            int iPosition2 = this.zzot.position();
            this.zzot.position(iPosition);
            zzbt((iPosition2 - iPosition) - iZzba);
            this.zzot.position(iPosition2);
        } catch (BufferOverflowException e) {
            zzkn zzknVar = new zzkn(this.zzot.position(), this.zzot.limit());
            zzknVar.initCause(e);
            throw zzknVar;
        }
    }

    public final void zzb(int i, byte[] bArr) throws IOException {
        zzd(3, 2);
        zzbt(bArr.length);
        zzk(bArr);
    }

    public final void zzbt(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzbs((i & 127) | 128);
            i >>>= 7;
        }
        zzbs(i);
    }

    public final void zzc(byte b) throws IOException {
        if (!this.zzot.hasRemaining()) {
            throw new zzkn(this.zzot.position(), this.zzot.limit());
        }
        this.zzot.put(b);
    }

    public final void zzc(int i, float f) throws IOException {
        zzd(i, 5);
        int iFloatToIntBits = Float.floatToIntBits(f);
        if (this.zzot.remaining() < 4) {
            throw new zzkn(this.zzot.position(), this.zzot.limit());
        }
        this.zzot.putInt(iFloatToIntBits);
    }

    public final void zzc(zzku zzkuVar) throws IOException {
        if (zzkuVar.zzaap < 0) {
            zzkuVar.zzdg();
        }
        zzbt(zzkuVar.zzaap);
        zzkuVar.zzb(this);
    }

    public final void zzd(int i, int i2) throws IOException {
        zzbt((i << 3) | i2);
    }

    public final void zze(int i, int i2) throws IOException {
        zzd(i, 0);
        if (i2 >= 0) {
            zzbt(i2);
        } else {
            zzq(i2);
        }
    }

    public final void zzf(int i, zzih zzihVar) throws IOException {
        zzgf zzgfVarZzhc = zzhc();
        zzgfVarZzhc.zzb(6, zzihVar);
        zzgfVarZzhc.flush();
        this.zzaae = this.zzot.position();
    }

    public final void zzhd() {
        if (this.zzot.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.zzot.remaining())));
        }
    }

    public final void zzj(int i, long j) throws IOException {
        zzd(i, 0);
        zzq(j);
    }

    public final void zzk(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzot.remaining() < length) {
            throw new zzkn(this.zzot.position(), this.zzot.limit());
        }
        this.zzot.put(bArr, 0, length);
    }
}
