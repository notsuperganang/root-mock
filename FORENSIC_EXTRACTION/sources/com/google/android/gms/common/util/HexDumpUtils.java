package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class HexDumpUtils {
    @KeepForSdk
    public static String dump(byte[] bArr, int i, int i2, boolean z) {
        if (bArr == null || bArr.length == 0 || i < 0 || i2 <= 0 || i + i2 > bArr.length) {
            return null;
        }
        StringBuilder sb = new StringBuilder((z ? 75 : 57) * (((i2 + 16) - 1) / 16));
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i5 > 0) {
            if (i3 == 0) {
                if (i2 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i6)));
                    i4 = i6;
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i6)));
                    i4 = i6;
                }
            } else if (i3 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i6] & 255)));
            int i7 = i5 - 1;
            int i8 = i3 + 1;
            if (z && (i8 == 16 || i7 == 0)) {
                int i9 = 16 - i8;
                if (i9 > 0) {
                    for (int i10 = 0; i10 < i9; i10++) {
                        sb.append("   ");
                    }
                }
                if (i9 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i11 = 0; i11 < i8; i11++) {
                    char c = (char) bArr[i4 + i11];
                    if (c < ' ' || c > '~') {
                        c = '.';
                    }
                    sb.append(c);
                }
            }
            if (i8 == 16 || i7 == 0) {
                sb.append('\n');
                i3 = 0;
            } else {
                i3 = i8;
            }
            i6++;
            i5 = i7;
        }
        return sb.toString();
    }
}
