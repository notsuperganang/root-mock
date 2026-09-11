package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class zzxq extends zzxn {
    zzxq() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zzxl.zzbz(i);
            case 1:
                return zzxl.zzq(i, zzxj.zza(bArr, j));
            case 2:
                return zzxl.zzc(i, zzxj.zza(bArr, j), zzxj.zza(bArr, 1 + j));
            default:
                throw new AssertionError();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxn
    final int zzb(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        byte bZza;
        int i5;
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j2 = i2;
        int i6 = (int) (((long) i3) - j2);
        if (i6 >= 16) {
            i4 = 0;
            long j3 = j2;
            while (true) {
                if (i4 >= i6) {
                    i4 = i6;
                    break;
                }
                if (zzxj.zza(bArr, j3) < 0) {
                    break;
                }
                i4++;
                j3++;
            }
        } else {
            i4 = 0;
        }
        long j4 = ((long) i4) + j2;
        int i7 = i6 - i4;
        long j5 = j4;
        while (true) {
            byte b = 0;
            long j6 = j5;
            int i8 = i7;
            while (true) {
                if (i8 <= 0) {
                    j = j6;
                    bZza = b;
                    break;
                }
                long j7 = 1 + j6;
                bZza = zzxj.zza(bArr, j6);
                if (bZza < 0) {
                    j = j7;
                    break;
                }
                j6 = j7;
                i8--;
                b = bZza;
            }
            if (i8 == 0) {
                return 0;
            }
            int i9 = i8 - 1;
            if (bZza < -32) {
                if (i9 == 0) {
                    return bZza;
                }
                i5 = i9 - 1;
                if (bZza >= -62) {
                    j5 = 1 + j;
                    if (zzxj.zza(bArr, j) > -65) {
                    }
                }
                return -1;
            }
            if (bZza >= -16) {
                if (i9 < 3) {
                    return zza(bArr, bZza, j, i9);
                }
                i5 = i9 - 3;
                long j8 = 1 + j;
                byte bZza2 = zzxj.zza(bArr, j);
                if (bZza2 <= -65 && (((bZza << 28) + (bZza2 + 112)) >> 30) == 0) {
                    long j9 = 1 + j8;
                    if (zzxj.zza(bArr, j8) <= -65) {
                        j5 = 1 + j9;
                        if (zzxj.zza(bArr, j9) > -65) {
                        }
                    }
                }
                return -1;
            }
            if (i9 < 2) {
                return zza(bArr, bZza, j, i9);
            }
            i5 = i9 - 2;
            long j10 = 1 + j;
            byte bZza3 = zzxj.zza(bArr, j);
            if (bZza3 <= -65 && ((bZza != -32 || bZza3 >= -96) && (bZza != -19 || bZza3 < -96))) {
                j5 = 1 + j10;
                if (zzxj.zza(bArr, j10) > -65) {
                }
            }
            return -1;
            i7 = i5;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxn
    final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2 = i;
        long j3 = j2 + ((long) i2);
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(length - 1)).append(" at index ").append(i + i2).toString());
        }
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt >= 128) {
                break;
            }
            zzxj.zza(bArr, j2, (byte) cCharAt);
            i3++;
            j2++;
        }
        if (i3 == length) {
            return (int) j2;
        }
        long j4 = j2;
        while (i3 < length) {
            char cCharAt2 = charSequence.charAt(i3);
            if (cCharAt2 < 128 && j4 < j3) {
                j = 1 + j4;
                zzxj.zza(bArr, j4, (byte) cCharAt2);
            } else if (cCharAt2 < 2048 && j4 <= j3 - 2) {
                long j5 = j4 + 1;
                zzxj.zza(bArr, j4, (byte) ((cCharAt2 >>> 6) | 960));
                j = 1 + j5;
                zzxj.zza(bArr, j5, (byte) ((cCharAt2 & '?') | 128));
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j4 > j3 - 3) {
                    if (j4 > j3 - 4) {
                        if (55296 > cCharAt2 || cCharAt2 > 57343 || (i3 + 1 != length && Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3 + 1)))) {
                            throw new ArrayIndexOutOfBoundsException(new StringBuilder(46).append("Failed writing ").append(cCharAt2).append(" at index ").append(j4).toString());
                        }
                        throw new zzxp(i3, length);
                    }
                    if (i3 + 1 != length) {
                        i3++;
                        char cCharAt3 = charSequence.charAt(i3);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            long j6 = 1 + j4;
                            zzxj.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                            long j7 = 1 + j6;
                            zzxj.zza(bArr, j6, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j8 = j7 + 1;
                            zzxj.zza(bArr, j7, (byte) (((codePoint >>> 6) & 63) | 128));
                            j = 1 + j8;
                            zzxj.zza(bArr, j8, (byte) ((codePoint & 63) | 128));
                        }
                    }
                    throw new zzxp(i3 - 1, length);
                }
                long j9 = 1 + j4;
                zzxj.zza(bArr, j4, (byte) ((cCharAt2 >>> '\f') | 480));
                long j10 = 1 + j9;
                zzxj.zza(bArr, j9, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                j = 1 + j10;
                zzxj.zza(bArr, j10, (byte) ((cCharAt2 & '?') | 128));
            }
            i3++;
            j4 = j;
        }
        return (int) j4;
    }

    @Override // com.google.android.gms.internal.measurement.zzxn
    final void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        long j;
        long jZzb = zzxj.zzb(byteBuffer);
        long jPosition = jZzb + ((long) byteBuffer.position());
        long jLimit = jZzb + ((long) byteBuffer.limit());
        int length = charSequence.length();
        if (length > jLimit - jPosition) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(length - 1)).append(" at index ").append(byteBuffer.limit()).toString());
        }
        int i = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt >= 128) {
                break;
            }
            zzxj.zza(jPosition, (byte) cCharAt);
            i++;
            jPosition++;
        }
        if (i == length) {
            byteBuffer.position((int) (jPosition - jZzb));
            return;
        }
        long j2 = jPosition;
        while (i < length) {
            char cCharAt2 = charSequence.charAt(i);
            if (cCharAt2 < 128 && j2 < jLimit) {
                j = 1 + j2;
                zzxj.zza(j2, (byte) cCharAt2);
            } else if (cCharAt2 < 2048 && j2 <= jLimit - 2) {
                long j3 = j2 + 1;
                zzxj.zza(j2, (byte) ((cCharAt2 >>> 6) | 960));
                j = 1 + j3;
                zzxj.zza(j3, (byte) ((cCharAt2 & '?') | 128));
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j2 > jLimit - 3) {
                    if (j2 > jLimit - 4) {
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && (i + 1 == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i + 1)))) {
                            throw new zzxp(i, length);
                        }
                        throw new ArrayIndexOutOfBoundsException(new StringBuilder(46).append("Failed writing ").append(cCharAt2).append(" at index ").append(j2).toString());
                    }
                    if (i + 1 != length) {
                        i++;
                        char cCharAt3 = charSequence.charAt(i);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            long j4 = 1 + j2;
                            zzxj.zza(j2, (byte) ((codePoint >>> 18) | 240));
                            long j5 = 1 + j4;
                            zzxj.zza(j4, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j6 = j5 + 1;
                            zzxj.zza(j5, (byte) (((codePoint >>> 6) & 63) | 128));
                            j = 1 + j6;
                            zzxj.zza(j6, (byte) ((codePoint & 63) | 128));
                        }
                    }
                    throw new zzxp(i - 1, length);
                }
                long j7 = 1 + j2;
                zzxj.zza(j2, (byte) ((cCharAt2 >>> '\f') | 480));
                long j8 = 1 + j7;
                zzxj.zza(j7, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                j = 1 + j8;
                zzxj.zza(j8, (byte) ((cCharAt2 & '?') | 128));
            }
            i++;
            j2 = j;
        }
        byteBuffer.position((int) (j2 - jZzb));
    }

    @Override // com.google.android.gms.internal.measurement.zzxn
    final String zzh(byte[] bArr, int i, int i2) throws zzuv {
        int i3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i4 = i + i2;
        char[] cArr = new char[i2];
        int i5 = i;
        int i6 = 0;
        while (i5 < i4) {
            byte bZza = zzxj.zza(bArr, i5);
            if (!zzxm.zzd(bZza)) {
                break;
            }
            i5++;
            zzxm.zza(bZza, cArr, i6);
            i6++;
        }
        int i7 = i5;
        while (i7 < i4) {
            int i8 = i7 + 1;
            byte bZza2 = zzxj.zza(bArr, i7);
            if (zzxm.zzd(bZza2)) {
                zzxm.zza(bZza2, cArr, i6);
                i3 = i6 + 1;
                while (i8 < i4) {
                    byte bZza3 = zzxj.zza(bArr, i8);
                    if (!zzxm.zzd(bZza3)) {
                        break;
                    }
                    i8++;
                    zzxm.zza(bZza3, cArr, i3);
                    i3++;
                }
            } else if (zzxm.zze(bZza2)) {
                if (i8 >= i4) {
                    throw zzuv.zzwx();
                }
                i7 = i8 + 1;
                zzxm.zza(bZza2, zzxj.zza(bArr, i8), cArr, i6);
                i6++;
            } else if (zzxm.zzf(bZza2)) {
                if (i8 >= i4 - 1) {
                    throw zzuv.zzwx();
                }
                int i9 = i8 + 1;
                zzxm.zza(bZza2, zzxj.zza(bArr, i8), zzxj.zza(bArr, i9), cArr, i6);
                i6++;
                i7 = i9 + 1;
            } else {
                if (i8 >= i4 - 2) {
                    throw zzuv.zzwx();
                }
                int i10 = i8 + 1;
                int i11 = i10 + 1;
                zzxm.zza(bZza2, zzxj.zza(bArr, i8), zzxj.zza(bArr, i10), zzxj.zza(bArr, i11), cArr, i6);
                i3 = i6 + 1 + 1;
                i8 = i11 + 1;
            }
            i7 = i8;
            i6 = i3;
        }
        return new String(cArr, 0, i6);
    }
}
