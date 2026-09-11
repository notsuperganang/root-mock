package com.google.android.gms.internal.measurement;

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
final class zzxj {
    private static final boolean zzbuo;
    private static final zzd zzccq;
    private static final boolean zzccr;
    private static final long zzccs;
    private static final long zzcct;
    private static final long zzccu;
    private static final long zzccv;
    private static final long zzccw;
    private static final long zzccx;
    private static final long zzccy;
    private static final long zzccz;
    private static final long zzcda;
    private static final long zzcdb;
    private static final long zzcdc;
    private static final long zzcdd;
    private static final long zzcde;
    private static final long zzcdf;
    private static final boolean zzcdg;
    private static final Logger logger = Logger.getLogger(zzxj.class.getName());
    private static final Unsafe zzcar = zzyq();
    private static final Class<?> zzbto = zztb.zzuc();
    private static final boolean zzcco = zzn(Long.TYPE);
    private static final boolean zzccp = zzn(Integer.TYPE);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(long j, byte b) {
            Memory.pokeByte((int) ((-1) & j), b);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzxj.zzcdg) {
                zzxj.zzb(obj, j, z);
            } else {
                zzxj.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) ((-1) & j2), bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzxj.zzcdg) {
                zzxj.zza(obj, j, b);
            } else {
                zzxj.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final boolean zzm(Object obj, long j) {
            return zzxj.zzcdg ? zzxj.zzs(obj, j) : zzxj.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final byte zzy(Object obj, long j) {
            return zzxj.zzcdg ? zzxj.zzq(obj, j) : zzxj.zzr(obj, j);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzxj.zzcdg) {
                zzxj.zzb(obj, j, z);
            } else {
                zzxj.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzxj.zzcdg) {
                zzxj.zza(obj, j, b);
            } else {
                zzxj.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final boolean zzm(Object obj, long j) {
            return zzxj.zzcdg ? zzxj.zzs(obj, j) : zzxj.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final byte zzy(Object obj, long j) {
            return zzxj.zzcdg ? zzxj.zzq(obj, j) : zzxj.zzr(obj, j);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(long j, byte b) {
            this.zzcdh.putByte(j, b);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzcdh.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzcdh.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzcdh.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzcdh.copyMemory(bArr, zzxj.zzccs + j, (Object) null, j2, j3);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzcdh.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zzcdh.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final float zzn(Object obj, long j) {
            return this.zzcdh.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final double zzo(Object obj, long j) {
            return this.zzcdh.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzxj.zzd
        public final byte zzy(Object obj, long j) {
            return this.zzcdh.getByte(obj, j);
        }
    }

    static abstract class zzd {
        Unsafe zzcdh;

        zzd(Unsafe unsafe) {
            this.zzcdh = unsafe;
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, long j2) {
            this.zzcdh.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public final void zzb(Object obj, long j, int i) {
            this.zzcdh.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b);

        public final int zzk(Object obj, long j) {
            return this.zzcdh.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zzcdh.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    static {
        zzd zzcVar = null;
        if (zzcar != null) {
            if (!zztb.zzub()) {
                zzcVar = new zzc(zzcar);
            } else if (zzcco) {
                zzcVar = new zzb(zzcar);
            } else if (zzccp) {
                zzcVar = new zza(zzcar);
            }
        }
        zzccq = zzcVar;
        zzccr = zzys();
        zzbuo = zzyr();
        zzccs = zzl(byte[].class);
        zzcct = zzl(boolean[].class);
        zzccu = zzm(boolean[].class);
        zzccv = zzl(int[].class);
        zzccw = zzm(int[].class);
        zzccx = zzl(long[].class);
        zzccy = zzm(long[].class);
        zzccz = zzl(float[].class);
        zzcda = zzm(float[].class);
        zzcdb = zzl(double[].class);
        zzcdc = zzm(double[].class);
        zzcdd = zzl(Object[].class);
        zzcde = zzm(Object[].class);
        Field fieldZzyt = zzyt();
        zzcdf = (fieldZzyt == null || zzccq == null) ? -1L : zzccq.zzcdh.objectFieldOffset(fieldZzyt);
        zzcdg = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzxj() {
    }

    static byte zza(byte[] bArr, long j) {
        return zzccq.zzy(bArr, zzccs + j);
    }

    static void zza(long j, byte b) {
        zzccq.zza(j, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        int i = ((((int) j) ^ (-1)) & 3) << 3;
        zzb(obj, (-4) & j, (zzk(obj, j & (-4)) & ((255 << i) ^ (-1))) | ((b & 255) << i));
    }

    static void zza(Object obj, long j, double d) {
        zzccq.zza(obj, j, d);
    }

    static void zza(Object obj, long j, float f) {
        zzccq.zza(obj, j, f);
    }

    static void zza(Object obj, long j, long j2) {
        zzccq.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzccq.zzcdh.putObject(obj, j, obj2);
    }

    static void zza(Object obj, long j, boolean z) {
        zzccq.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzccq.zze(bArr, zzccs + j, b);
    }

    static void zza(byte[] bArr, long j, long j2, long j3) {
        zzccq.zza(bArr, j, j2, j3);
    }

    static long zzb(ByteBuffer byteBuffer) {
        return zzccq.zzl(byteBuffer, zzcdf);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        int i = (((int) j) & 3) << 3;
        zzb(obj, (-4) & j, (zzk(obj, j & (-4)) & ((255 << i) ^ (-1))) | ((b & 255) << i));
    }

    static void zzb(Object obj, long j, int i) {
        zzccq.zzb(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, (byte) (z ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, (byte) (z ? 1 : 0));
    }

    static int zzk(Object obj, long j) {
        return zzccq.zzk(obj, j);
    }

    static <T> T zzk(Class<T> cls) {
        try {
            return (T) zzcar.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzl(Class<?> cls) {
        if (zzbuo) {
            return zzccq.zzcdh.arrayBaseOffset(cls);
        }
        return -1;
    }

    static long zzl(Object obj, long j) {
        return zzccq.zzl(obj, j);
    }

    private static int zzm(Class<?> cls) {
        if (zzbuo) {
            return zzccq.zzcdh.arrayIndexScale(cls);
        }
        return -1;
    }

    static boolean zzm(Object obj, long j) {
        return zzccq.zzm(obj, j);
    }

    static float zzn(Object obj, long j) {
        return zzccq.zzn(obj, j);
    }

    private static boolean zzn(Class<?> cls) {
        if (!zztb.zzub()) {
            return false;
        }
        try {
            Class<?> cls2 = zzbto;
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

    static double zzo(Object obj, long j) {
        return zzccq.zzo(obj, j);
    }

    static Object zzp(Object obj, long j) {
        return zzccq.zzcdh.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) ((((-1) ^ j) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) ((3 & j) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    static boolean zzyo() {
        return zzbuo;
    }

    static boolean zzyp() {
        return zzccr;
    }

    static Unsafe zzyq() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzxk());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzyr() {
        if (zzcar == null) {
            return false;
        }
        try {
            Class<?> cls = zzcar.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zztb.zzub()) {
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

    private static boolean zzys() {
        if (zzcar == null) {
            return false;
        }
        try {
            Class<?> cls = zzcar.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzyt() == null) {
                return false;
            }
            if (zztb.zzub()) {
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

    private static Field zzyt() {
        Field fieldZzb;
        if (zztb.zzub() && (fieldZzb = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldZzb;
        }
        Field fieldZzb2 = zzb(Buffer.class, "address");
        if (fieldZzb2 == null || fieldZzb2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzb2;
    }
}
