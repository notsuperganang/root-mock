package com.google.android.gms.internal.places;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class zzhb {
    public static final byte[] zztl;
    private static final ByteBuffer zztm;
    private static final zzga zztn;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zztl = bArr;
        zztm = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zztl;
        zztn = zzga.zzb(bArr2, 0, bArr2.length, false);
    }

    static <T> T checkNotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int iZzb = zzb(length, bArr, 0, length);
        if (iZzb == 0) {
            return 1;
        }
        return iZzb;
    }

    static int zzb(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zzb(Object obj, Object obj2) {
        return ((zzih) obj).zzdq().zzb((zzih) obj2).zzdw();
    }

    static <T> T zzb(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    public static int zzf(boolean z) {
        return z ? 1231 : 1237;
    }

    public static boolean zzf(byte[] bArr) {
        return zzjy.zzf(bArr);
    }

    public static String zzg(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    static boolean zzg(zzih zzihVar) {
        return false;
    }

    public static int zzo(long j) {
        return (int) ((j >>> 32) ^ j);
    }
}
