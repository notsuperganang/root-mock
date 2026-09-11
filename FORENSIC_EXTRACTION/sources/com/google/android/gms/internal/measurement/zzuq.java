package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class zzuq {
    public static final byte[] zzbzc;
    private static final ByteBuffer zzbzd;
    private static final zztq zzbze;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zzbzc = bArr;
        zzbzd = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzbzc;
        zzbze = zztq.zza(bArr2, 0, bArr2.length, false);
    }

    static <T> T checkNotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static <T> T zza(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    static Object zzb(Object obj, Object obj2) {
        return ((zzvv) obj).zzwh().zza((zzvv) obj2).zzwn();
    }

    public static int zzbd(long j) {
        return (int) ((j >>> 32) ^ j);
    }

    static boolean zzf(zzvv zzvvVar) {
        return false;
    }

    public static boolean zzl(byte[] bArr) {
        return zzxl.zzl(bArr);
    }

    public static String zzm(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int zzu(boolean z) {
        return z ? 1231 : 1237;
    }
}
