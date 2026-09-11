package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int murmurhash3_x86_32(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = i + (i2 & (-4));
        int i6 = i3;
        while (i < i5) {
            int i7 = ((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | (bArr[i + 3] << 24)) * (-862048943);
            int i8 = i6 ^ (((i7 << 15) | (i7 >>> 17)) * 461845907);
            i6 = (((i8 << 13) | (i8 >>> 19)) * 5) - 430675100;
            i += 4;
        }
        switch (i2 & 3) {
            case 3:
                i4 = (bArr[i5 + 2] & 255) << 16;
            case 2:
                i4 |= (bArr[i5 + 1] & 255) << 8;
            case 1:
                int i9 = (i4 | (bArr[i5] & 255)) * (-862048943);
                i6 ^= ((i9 << 15) | (i9 >>> 17)) * 461845907;
                break;
        }
        int i10 = i6 ^ i2;
        int i11 = (i10 ^ (i10 >>> 16)) * (-2048144789);
        int i12 = (i11 ^ (i11 >>> 13)) * (-1028477387);
        return i12 ^ (i12 >>> 16);
    }
}
