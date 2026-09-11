package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
abstract class zzxn {
    zzxn() {
    }

    static void zzc(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int iPosition = byteBuffer.position();
        int i = 0;
        while (i < length) {
            try {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= 128) {
                    break;
                }
                byteBuffer.put(iPosition + i, (byte) cCharAt);
                i++;
            } catch (IndexOutOfBoundsException e) {
                int iPosition2 = byteBuffer.position();
                int iMax = Math.max(i, (iPosition - byteBuffer.position()) + 1);
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(i)).append(" at index ").append(iMax + iPosition2).toString());
            }
        }
        if (i == length) {
            byteBuffer.position(iPosition + i);
            return;
        }
        int i2 = iPosition + i;
        while (i < length) {
            char cCharAt2 = charSequence.charAt(i);
            if (cCharAt2 < 128) {
                byteBuffer.put(i2, (byte) cCharAt2);
            } else if (cCharAt2 < 2048) {
                int i3 = i2 + 1;
                try {
                    byteBuffer.put(i2, (byte) ((cCharAt2 >>> 6) | 192));
                    byteBuffer.put(i3, (byte) ((cCharAt2 & '?') | 128));
                    i2 = i3;
                } catch (IndexOutOfBoundsException e2) {
                    iPosition = i3;
                    int iPosition3 = byteBuffer.position();
                    int iMax2 = Math.max(i, (iPosition - byteBuffer.position()) + 1);
                    throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(i)).append(" at index ").append(iMax2 + iPosition3).toString());
                }
            } else {
                if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                    if (i + 1 != length) {
                        i++;
                        char cCharAt3 = charSequence.charAt(i);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            int i4 = i2 + 1;
                            try {
                                byteBuffer.put(i2, (byte) ((codePoint >>> 18) | 240));
                                int i5 = i4 + 1;
                                try {
                                    byteBuffer.put(i4, (byte) (((codePoint >>> 12) & 63) | 128));
                                    i2 = i5 + 1;
                                    byteBuffer.put(i5, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i2, (byte) ((codePoint & 63) | 128));
                                } catch (IndexOutOfBoundsException e3) {
                                    iPosition = i5;
                                    int iPosition4 = byteBuffer.position();
                                    int iMax3 = Math.max(i, (iPosition - byteBuffer.position()) + 1);
                                    throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(i)).append(" at index ").append(iMax3 + iPosition4).toString());
                                }
                            } catch (IndexOutOfBoundsException e4) {
                                iPosition = i4;
                            }
                        }
                    }
                    throw new zzxp(i, length);
                }
                int i6 = i2 + 1;
                byteBuffer.put(i2, (byte) ((cCharAt2 >>> '\f') | 224));
                i2 = i6 + 1;
                byteBuffer.put(i6, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                byteBuffer.put(i2, (byte) ((cCharAt2 & '?') | 128));
            }
            i++;
            i2++;
        }
        byteBuffer.position(i2);
    }

    abstract int zzb(int i, byte[] bArr, int i2, int i3);

    abstract int zzb(CharSequence charSequence, byte[] bArr, int i, int i2);

    abstract void zzb(CharSequence charSequence, ByteBuffer byteBuffer);

    final boolean zzf(byte[] bArr, int i, int i2) {
        return zzb(0, bArr, i, i2) == 0;
    }

    abstract String zzh(byte[] bArr, int i, int i2) throws zzuv;
}
