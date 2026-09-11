package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@KeepForSdk
public class Hex {
    private static final char[] zzgw = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] zzgx = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @KeepForSdk
    public static String bytesToStringUppercase(byte[] bArr) {
        return bytesToStringUppercase(bArr, false);
    }

    @KeepForSdk
    public static String bytesToStringUppercase(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length << 1);
        for (int i = 0; i < length && (!z || i != length - 1 || (bArr[i] & 255) != 0); i++) {
            sb.append(zzgw[(bArr[i] & 240) >>> 4]);
            sb.append(zzgw[bArr[i] & 15]);
        }
        return sb.toString();
    }

    @KeepForSdk
    public static byte[] stringToBytes(String str) throws IllegalArgumentException {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Hex string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, i + 2), 16);
        }
        return bArr;
    }

    public static String zza(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[bArr.length << 1];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= bArr.length) {
                return new String(cArr);
            }
            int i4 = bArr[i3] & 255;
            int i5 = i2 + 1;
            cArr[i2] = zzgx[i4 >>> 4];
            cArr[i5] = zzgx[i4 & 15];
            i = i3 + 1;
            i2 = i5 + 1;
        }
    }
}
