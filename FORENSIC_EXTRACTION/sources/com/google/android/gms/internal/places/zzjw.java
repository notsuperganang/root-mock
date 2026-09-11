package com.google.android.gms.internal.places;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzjw {
    private static final boolean zzoo;
    private static final zze zzxz;
    private static final boolean zzya;
    private static final long zzyb;
    private static final long zzyc;
    private static final long zzyd;
    private static final long zzye;
    private static final long zzyf;
    private static final long zzyg;
    private static final long zzyh;
    private static final long zzyi;
    private static final long zzyj;
    private static final long zzyk;
    private static final long zzyl;
    private static final long zzym;
    private static final long zzyn;
    private static final long zzyo;
    private static final long zzyp;
    private static final boolean zzyq;
    private static final Logger logger = Logger.getLogger(zzjw.class.getName());
    private static final Unsafe zzuz = zzgu();
    private static final Class<?> zznl = zzfl.zzbe();
    private static final boolean zzxx = zzk(Long.TYPE);
    private static final boolean zzxy = zzk(Integer.TYPE);

    static final class zzb extends zze {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(long j, byte b) {
            Memory.pokeByte((int) ((-1) & j), b);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(Object obj, long j, double d) {
            zzb(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(Object obj, long j, float f) {
            zzc(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(Object obj, long j, boolean z) {
            if (zzjw.zzyq) {
                zzjw.zzc(obj, j, z);
            } else {
                zzjw.zzd(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) ((-1) & j2), bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzf(Object obj, long j, byte b) {
            if (zzjw.zzyq) {
                zzjw.zzb(obj, j, b);
            } else {
                zzjw.zzc(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final boolean zzn(Object obj, long j) {
            return zzjw.zzyq ? zzjw.zzt(obj, j) : zzjw.zzu(obj, j);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final float zzo(Object obj, long j) {
            return Float.intBitsToFloat(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final double zzp(Object obj, long j) {
            return Double.longBitsToDouble(zzm(obj, j));
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final byte zzz(Object obj, long j) {
            return zzjw.zzyq ? zzjw.zzr(obj, j) : zzjw.zzs(obj, j);
        }
    }

    static final class zzc extends zze {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(Object obj, long j, double d) {
            zzb(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(Object obj, long j, float f) {
            zzc(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(Object obj, long j, boolean z) {
            if (zzjw.zzyq) {
                zzjw.zzc(obj, j, z);
            } else {
                zzjw.zzd(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzf(Object obj, long j, byte b) {
            if (zzjw.zzyq) {
                zzjw.zzb(obj, j, b);
            } else {
                zzjw.zzc(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final boolean zzn(Object obj, long j) {
            return zzjw.zzyq ? zzjw.zzt(obj, j) : zzjw.zzu(obj, j);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final float zzo(Object obj, long j) {
            return Float.intBitsToFloat(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final double zzp(Object obj, long j) {
            return Double.longBitsToDouble(zzm(obj, j));
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final byte zzz(Object obj, long j) {
            return zzjw.zzyq ? zzjw.zzr(obj, j) : zzjw.zzs(obj, j);
        }
    }

    static final class zzd extends zze {
        zzd(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(long j, byte b) {
            this.zzyr.putByte(j, b);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(Object obj, long j, double d) {
            this.zzyr.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(Object obj, long j, float f) {
            this.zzyr.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(Object obj, long j, boolean z) {
            this.zzyr.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzb(byte[] bArr, long j, long j2, long j3) {
            this.zzyr.copyMemory(bArr, zzjw.zzyb + j, (Object) null, j2, j3);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final void zzf(Object obj, long j, byte b) {
            this.zzyr.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final boolean zzn(Object obj, long j) {
            return this.zzyr.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final float zzo(Object obj, long j) {
            return this.zzyr.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final double zzp(Object obj, long j) {
            return this.zzyr.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.places.zzjw.zze
        public final byte zzz(Object obj, long j) {
            return this.zzyr.getByte(obj, j);
        }
    }

    static abstract class zze {
        Unsafe zzyr;

        zze(Unsafe unsafe) {
            this.zzyr = unsafe;
        }

        public final long zzb(Field field) {
            return this.zzyr.objectFieldOffset(field);
        }

        public abstract void zzb(long j, byte b);

        public abstract void zzb(Object obj, long j, double d);

        public abstract void zzb(Object obj, long j, float f);

        public final void zzb(Object obj, long j, long j2) {
            this.zzyr.putLong(obj, j, j2);
        }

        public abstract void zzb(Object obj, long j, boolean z);

        public abstract void zzb(byte[] bArr, long j, long j2, long j3);

        public final void zzc(Object obj, long j, int i) {
            this.zzyr.putInt(obj, j, i);
        }

        public abstract void zzf(Object obj, long j, byte b);

        public final int zzl(Object obj, long j) {
            return this.zzyr.getInt(obj, j);
        }

        public final long zzm(Object obj, long j) {
            return this.zzyr.getLong(obj, j);
        }

        public abstract boolean zzn(Object obj, long j);

        public abstract float zzo(Object obj, long j);

        public abstract double zzp(Object obj, long j);

        public abstract byte zzz(Object obj, long j);
    }

    static {
        zze zzdVar;
        Field field = null;
        if (zzuz == null) {
            zzdVar = null;
        } else if (!zzfl.zzbd()) {
            zzdVar = new zzd(zzuz);
        } else if (zzxx) {
            zzdVar = new zzc(zzuz);
        } else {
            zzdVar = zzxy ? new zzb(zzuz) : null;
        }
        zzxz = zzdVar;
        zzya = zzgw();
        zzoo = zzgv();
        zzyb = zzi(byte[].class);
        zzyc = zzi(boolean[].class);
        zzyd = zzj(boolean[].class);
        zzye = zzi(int[].class);
        zzyf = zzj(int[].class);
        zzyg = zzi(long[].class);
        zzyh = zzj(long[].class);
        zzyi = zzi(float[].class);
        zzyj = zzj(float[].class);
        zzyk = zzi(double[].class);
        zzyl = zzj(double[].class);
        zzym = zzi(Object[].class);
        zzyn = zzj(Object[].class);
        zzyo = zzc(zzgx());
        Field fieldZzc = zzc(String.class, FirebaseAnalytics.Param.VALUE);
        if (fieldZzc != null && fieldZzc.getType() == char[].class) {
            field = fieldZzc;
        }
        zzyp = zzc(field);
        zzyq = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzjw() {
    }

    static byte zzb(byte[] bArr, long j) {
        return zzxz.zzz(bArr, zzyb + j);
    }

    static long zzb(Field field) {
        return zzxz.zzb(field);
    }

    static void zzb(long j, byte b) {
        zzxz.zzb(j, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        int i = ((((int) j) ^ (-1)) & 3) << 3;
        zzc(obj, j & (-4), (zzl(obj, j & (-4)) & ((255 << i) ^ (-1))) | ((b & 255) << i));
    }

    static void zzb(Object obj, long j, double d) {
        zzxz.zzb(obj, j, d);
    }

    static void zzb(Object obj, long j, float f) {
        zzxz.zzb(obj, j, f);
    }

    static void zzb(Object obj, long j, long j2) {
        zzxz.zzb(obj, j, j2);
    }

    static void zzb(Object obj, long j, Object obj2) {
        zzxz.zzyr.putObject(obj, j, obj2);
    }

    static void zzb(Object obj, long j, boolean z) {
        zzxz.zzb(obj, j, z);
    }

    static void zzb(byte[] bArr, long j, byte b) {
        zzxz.zzf(bArr, zzyb + j, b);
    }

    static void zzb(byte[] bArr, long j, long j2, long j3) {
        zzxz.zzb(bArr, j, j2, j3);
    }

    private static long zzc(Field field) {
        if (field == null || zzxz == null) {
            return -1L;
        }
        return zzxz.zzb(field);
    }

    static long zzc(ByteBuffer byteBuffer) {
        return zzxz.zzm(byteBuffer, zzyo);
    }

    private static Field zzc(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, byte b) {
        int i = (((int) j) & 3) << 3;
        zzc(obj, j & (-4), (zzl(obj, j & (-4)) & ((255 << i) ^ (-1))) | ((b & 255) << i));
    }

    static void zzc(Object obj, long j, int i) {
        zzxz.zzc(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, (byte) (z ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j, boolean z) {
        zzc(obj, j, (byte) (z ? 1 : 0));
    }

    static boolean zzgs() {
        return zzoo;
    }

    static boolean zzgt() {
        return zzya;
    }

    static Unsafe zzgu() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzjx());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzgv() {
        if (zzuz == null) {
            return false;
        }
        try {
            Class<?> cls = zzuz.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzfl.zzbd()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(strValueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(strValueOf).toString());
            return false;
        }
    }

    private static boolean zzgw() {
        if (zzuz == null) {
            return false;
        }
        try {
            Class<?> cls = zzuz.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzgx() == null) {
                return false;
            }
            if (zzfl.zzbd()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(strValueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(strValueOf).toString());
            return false;
        }
    }

    private static Field zzgx() {
        Field fieldZzc;
        if (zzfl.zzbd() && (fieldZzc = zzc(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldZzc;
        }
        Field fieldZzc2 = zzc(Buffer.class, "address");
        if (fieldZzc2 == null || fieldZzc2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzc2;
    }

    private static int zzi(Class<?> cls) {
        if (zzoo) {
            return zzxz.zzyr.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzoo) {
            return zzxz.zzyr.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzfl.zzbd()) {
            return false;
        }
        try {
            Class<?> cls2 = zznl;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    static int zzl(Object obj, long j) {
        return zzxz.zzl(obj, j);
    }

    static long zzm(Object obj, long j) {
        return zzxz.zzm(obj, j);
    }

    static boolean zzn(Object obj, long j) {
        return zzxz.zzn(obj, j);
    }

    static float zzo(Object obj, long j) {
        return zzxz.zzo(obj, j);
    }

    static double zzp(Object obj, long j) {
        return zzxz.zzp(obj, j);
    }

    static Object zzq(Object obj, long j) {
        return zzxz.zzyr.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzl(obj, (-4) & j) >>> ((int) ((((-1) ^ j) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzs(Object obj, long j) {
        return (byte) (zzl(obj, (-4) & j) >>> ((int) ((3 & j) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzu(Object obj, long j) {
        return zzs(obj, j) != 0;
    }
}
