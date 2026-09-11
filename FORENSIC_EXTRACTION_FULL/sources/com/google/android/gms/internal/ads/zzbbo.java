package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;
import com.google.android.gms.internal.ads.zzbbo.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbbo<MessageType extends zzbbo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzazy<MessageType, BuilderType> {
    private static Map<Object, zzbbo<?, ?>> zzdtv = new ConcurrentHashMap();
    protected zzbef zzdtt = zzbef.zzagc();
    private int zzdtu = -1;

    public static class zza<MessageType extends zzbbo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzazz<MessageType, BuilderType> {
        private final MessageType zzdtw;
        protected MessageType zzdtx;
        private boolean zzdty = false;

        protected zza(MessageType messagetype) {
            this.zzdtw = messagetype;
            this.zzdtx = (MessageType) messagetype.zza(zze.zzdud, null, null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzbdg.zzaeo().zzab(messagetype).zzc(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.ads.zzazz
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            MessageType messagetype;
            zza zzaVar = (zza) this.zzdtw.zza(zze.zzdue, null, null);
            if (this.zzdty) {
                messagetype = this.zzdtx;
            } else {
                MessageType messagetype2 = this.zzdtx;
                zzbdg.zzaeo().zzab(messagetype2).zzo(messagetype2);
                this.zzdty = true;
                messagetype = this.zzdtx;
            }
            zzaVar.zza((zzbbo) messagetype);
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcw
        public final boolean isInitialized() {
            return zzbbo.zza(this.zzdtx, false);
        }

        @Override // com.google.android.gms.internal.ads.zzazz
        public final BuilderType zza(MessageType messagetype) {
            zzadh();
            zza(this.zzdtx, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.ads.zzazz
        /* JADX INFO: renamed from: zzaax */
        public final /* synthetic */ zzazz clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzbcw
        public final /* synthetic */ zzbcu zzadg() {
            return this.zzdtw;
        }

        protected final void zzadh() {
            if (this.zzdty) {
                MessageType messagetype = (MessageType) this.zzdtx.zza(zze.zzdud, null, null);
                zza(messagetype, this.zzdtx);
                this.zzdtx = messagetype;
                this.zzdty = false;
            }
        }

        public final MessageType zzadi() {
            MessageType messagetype;
            boolean z;
            if (this.zzdty) {
                messagetype = this.zzdtx;
            } else {
                MessageType messagetype2 = this.zzdtx;
                zzbdg.zzaeo().zzab(messagetype2).zzo(messagetype2);
                this.zzdty = true;
                messagetype = this.zzdtx;
            }
            MessageType messagetype3 = messagetype;
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) messagetype3.zza(zze.zzdua, null, null)).byteValue();
            if (bByteValue == 1) {
                z = true;
            } else if (bByteValue == 0) {
                z = false;
            } else {
                boolean zZzaa = zzbdg.zzaeo().zzab(messagetype3).zzaa(messagetype3);
                if (zBooleanValue) {
                    messagetype3.zza(zze.zzdub, zZzaa ? messagetype3 : null, null);
                }
                z = zZzaa;
            }
            if (z) {
                return messagetype3;
            }
            throw new zzbed(messagetype3);
        }

        @Override // com.google.android.gms.internal.ads.zzbcv
        public final /* synthetic */ zzbcu zzadj() {
            if (this.zzdty) {
                return this.zzdtx;
            }
            MessageType messagetype = this.zzdtx;
            zzbdg.zzaeo().zzab(messagetype).zzo(messagetype);
            this.zzdty = true;
            return this.zzdtx;
        }

        @Override // com.google.android.gms.internal.ads.zzbcv
        public final /* synthetic */ zzbcu zzadk() {
            MessageType messagetype;
            boolean z;
            if (this.zzdty) {
                messagetype = this.zzdtx;
            } else {
                MessageType messagetype2 = this.zzdtx;
                zzbdg.zzaeo().zzab(messagetype2).zzo(messagetype2);
                this.zzdty = true;
                messagetype = this.zzdtx;
            }
            MessageType messagetype3 = messagetype;
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) messagetype3.zza(zze.zzdua, null, null)).byteValue();
            if (bByteValue == 1) {
                z = true;
            } else if (bByteValue == 0) {
                z = false;
            } else {
                boolean zZzaa = zzbdg.zzaeo().zzab(messagetype3).zzaa(messagetype3);
                if (zBooleanValue) {
                    messagetype3.zza(zze.zzdub, zZzaa ? messagetype3 : null, null);
                }
                z = zZzaa;
            }
            if (z) {
                return messagetype3;
            }
            throw new zzbed(messagetype3);
        }
    }

    public static final class zzb<T extends zzbbo<T, ?>> extends zzbaa<T> {
        private T zzdtw;

        public zzb(T t) {
            this.zzdtw = t;
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzbbo<MessageType, BuilderType> implements zzbcw {
        protected zzbbg<Object> zzdtz = zzbbg.zzacv();
    }

    public static final class zzd<ContainingType extends zzbcu, Type> extends zzbaz<ContainingType, Type> {
    }

    public static final enum zze {
        public static final int zzdua = 1;
        public static final int zzdub = 2;
        public static final int zzduc = 3;
        public static final int zzdud = 4;
        public static final int zzdue = 5;
        public static final int zzduf = 6;
        public static final int zzdug = 7;
        private static final /* synthetic */ int[] zzduh = {zzdua, zzdub, zzduc, zzdud, zzdue, zzduf, zzdug};
        public static final int zzdui = 1;
        public static final int zzduj = 2;
        private static final /* synthetic */ int[] zzduk = {zzdui, zzduj};
        public static final int zzdul = 1;
        public static final int zzdum = 2;
        private static final /* synthetic */ int[] zzdun = {zzdul, zzdum};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzduh.clone();
        }
    }

    protected static <T extends zzbbo<T, ?>> T zza(T t, zzbah zzbahVar) throws zzbbu {
        boolean z;
        boolean z2;
        zzc zzcVar = (T) zza(t, zzbahVar, zzbbb.zzacr());
        if (zzcVar != null) {
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) zzcVar.zza(zze.zzdua, (Object) null, (Object) null)).byteValue();
            if (bByteValue == 1) {
                z2 = true;
            } else if (bByteValue == 0) {
                z2 = false;
            } else {
                boolean zZzaa = zzbdg.zzaeo().zzab(zzcVar).zzaa(zzcVar);
                if (zBooleanValue) {
                    zzcVar.zza(zze.zzdub, zZzaa ? zzcVar : null, (Object) null);
                }
                z2 = zZzaa;
            }
            if (!z2) {
                throw new zzbed(zzcVar).zzaga().zzj(zzcVar);
            }
        }
        if (zzcVar != null) {
            boolean zBooleanValue2 = Boolean.TRUE.booleanValue();
            byte bByteValue2 = ((Byte) zzcVar.zza(zze.zzdua, (Object) null, (Object) null)).byteValue();
            if (bByteValue2 == 1) {
                z = true;
            } else if (bByteValue2 == 0) {
                z = false;
            } else {
                boolean zZzaa2 = zzbdg.zzaeo().zzab(zzcVar).zzaa(zzcVar);
                if (zBooleanValue2) {
                    zzcVar.zza(zze.zzdub, zZzaa2 ? zzcVar : null, (Object) null);
                }
                z = zZzaa2;
            }
            if (!z) {
                throw new zzbed(zzcVar).zzaga().zzj(zzcVar);
            }
        }
        return zzcVar;
    }

    private static <T extends zzbbo<T, ?>> T zza(T t, zzbah zzbahVar, zzbbb zzbbbVar) throws zzbbu {
        try {
            zzbaq zzbaqVarZzabf = zzbahVar.zzabf();
            T t2 = (T) zza(t, zzbaqVarZzabf, zzbbbVar);
            try {
                zzbaqVarZzabf.zzbp(0);
                return t2;
            } catch (zzbbu e) {
                throw e.zzj(t2);
            }
        } catch (zzbbu e2) {
            throw e2;
        }
    }

    private static <T extends zzbbo<T, ?>> T zza(T t, zzbaq zzbaqVar, zzbbb zzbbbVar) throws zzbbu {
        T t2 = (T) t.zza(zze.zzdud, null, null);
        try {
            zzbdg.zzaeo().zzab(t2).zza(t2, zzbat.zza(zzbaqVar), zzbbbVar);
            zzbdg.zzaeo().zzab(t2).zzo(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzbbu) {
                throw ((zzbbu) e.getCause());
            }
            throw new zzbbu(e.getMessage()).zzj(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzbbu) {
                throw ((zzbbu) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzbbo<T, ?>> T zza(T t, byte[] bArr) throws zzbbu {
        T t2 = (T) t.zza(zze.zzdud, null, null);
        try {
            zzbdg.zzaeo().zzab(t2).zza(t2, bArr, 0, bArr.length, new zzbae());
            zzbdg.zzaeo().zzab(t2).zzo(t2);
            if (t2.zzdpf != 0) {
                throw new RuntimeException();
            }
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzbbu) {
                throw ((zzbbu) e.getCause());
            }
            throw new zzbbu(e.getMessage()).zzj(t2);
        } catch (IndexOutOfBoundsException e2) {
            throw zzbbu.zzadl().zzj(t2);
        }
    }

    protected static Object zza(zzbcu zzbcuVar, String str, Object[] objArr) {
        return new zzbdi(zzbcuVar, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static <T extends zzbbo<?, ?>> void zza(Class<T> cls, T t) {
        zzdtv.put(cls, t);
    }

    protected static final <T extends zzbbo<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zze.zzdua, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        return zzbdg.zzaeo().zzab(t).zzaa(t);
    }

    protected static <E> zzbbt<E> zzadd() {
        return zzbdh.zzaep();
    }

    protected static <T extends zzbbo<T, ?>> T zzb(T t, byte[] bArr) throws zzbbu {
        boolean z;
        zzc zzcVar = (T) zza(t, bArr);
        if (zzcVar != null) {
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) zzcVar.zza(zze.zzdua, (Object) null, (Object) null)).byteValue();
            if (bByteValue == 1) {
                z = true;
            } else if (bByteValue == 0) {
                z = false;
            } else {
                boolean zZzaa = zzbdg.zzaeo().zzab(zzcVar).zzaa(zzcVar);
                if (zBooleanValue) {
                    zzcVar.zza(zze.zzdub, zZzaa ? zzcVar : null, (Object) null);
                }
                z = zZzaa;
            }
            if (!z) {
                throw new zzbed(zzcVar).zzaga().zzj(zzcVar);
            }
        }
        return zzcVar;
    }

    static <T extends zzbbo<?, ?>> T zzc(Class<T> cls) {
        T t = (T) zzdtv.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzdtv.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(strValueOf.length() != 0 ? "Unable to get default instance for: ".concat(strValueOf) : new String("Unable to get default instance for: "));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzbbo) zza(zze.zzduf, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return zzbdg.zzaeo().zzab(this).equals(this, (zzbbo) obj);
        }
        return false;
    }

    public int hashCode() {
        if (this.zzdpf != 0) {
            return this.zzdpf;
        }
        this.zzdpf = zzbdg.zzaeo().zzab(this).hashCode(this);
        return this.zzdpf;
    }

    @Override // com.google.android.gms.internal.ads.zzbcw
    public final boolean isInitialized() {
        boolean zBooleanValue = Boolean.TRUE.booleanValue();
        byte bByteValue = ((Byte) zza(zze.zzdua, (Object) null, (Object) null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzaa = zzbdg.zzaeo().zzab(this).zzaa(this);
        if (!zBooleanValue) {
            return zZzaa;
        }
        zza(zze.zzdub, zZzaa ? this : null, (Object) null);
        return zZzaa;
    }

    public String toString() {
        return zzbcx.zza(this, super.toString());
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzazy
    final int zzaaw() {
        return this.zzdtu;
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final int zzacw() {
        if (this.zzdtu == -1) {
            this.zzdtu = zzbdg.zzaeo().zzab(this).zzy(this);
        }
        return this.zzdtu;
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final /* synthetic */ zzbcv zzade() {
        zza zzaVar = (zza) zza(zze.zzdue, (Object) null, (Object) null);
        zzaVar.zza(this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final /* synthetic */ zzbcv zzadf() {
        return (zza) zza(zze.zzdue, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzbcw
    public final /* synthetic */ zzbcu zzadg() {
        return (zzbbo) zza(zze.zzduf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final void zzb(zzbav zzbavVar) throws IOException {
        zzbdg.zzaeo().zze(getClass()).zza(this, zzbax.zza(zzbavVar));
    }

    @Override // com.google.android.gms.internal.ads.zzazy
    final void zzbj(int i) {
        this.zzdtu = i;
    }
}
