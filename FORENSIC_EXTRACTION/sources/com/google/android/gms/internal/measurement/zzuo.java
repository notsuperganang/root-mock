package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import com.google.android.gms.internal.measurement.zzuo.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzuo<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsx<MessageType, BuilderType> {
    private static Map<Object, zzuo<?, ?>> zzbyh = new ConcurrentHashMap();
    protected zzxe zzbyf = zzxe.zzyl();
    private int zzbyg = -1;

    public static class zza<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsy<MessageType, BuilderType> {
        private final MessageType zzbyi;
        protected MessageType zzbyj;
        private boolean zzbyk = false;

        protected zza(MessageType messagetype) {
            this.zzbyi = messagetype;
            this.zzbyj = (MessageType) messagetype.zza(zze.zzbyp, null, null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzwh.zzxt().zzak(messagetype).zzd(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzsy
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzbyi.zza(zze.zzbyq, null, null);
            zzaVar.zza((zzuo) zzwn());
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzvx
        public final boolean isInitialized() {
            return zzuo.zza(this.zzbyj, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzsy
        public final BuilderType zza(MessageType messagetype) {
            zzwk();
            zza(this.zzbyj, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.measurement.zzsy
        /* JADX INFO: renamed from: zzty */
        public final /* synthetic */ zzsy clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzvx
        public final /* synthetic */ zzvv zzwj() {
            return this.zzbyi;
        }

        protected final void zzwk() {
            if (this.zzbyk) {
                MessageType messagetype = (MessageType) this.zzbyj.zza(zze.zzbyp, null, null);
                zza(messagetype, this.zzbyj);
                this.zzbyj = messagetype;
                this.zzbyk = false;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzvw
        /* JADX INFO: renamed from: zzwl, reason: merged with bridge method [inline-methods] */
        public MessageType zzwn() {
            if (this.zzbyk) {
                return this.zzbyj;
            }
            MessageType messagetype = this.zzbyj;
            zzwh.zzxt().zzak(messagetype).zzy(messagetype);
            this.zzbyk = true;
            return this.zzbyj;
        }

        @Override // com.google.android.gms.internal.measurement.zzvw
        /* JADX INFO: renamed from: zzwm, reason: merged with bridge method [inline-methods] */
        public final MessageType zzwo() {
            boolean z;
            MessageType messagetype = (MessageType) zzwn();
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) messagetype.zza(zze.zzbym, null, null)).byteValue();
            if (bByteValue == 1) {
                z = true;
            } else if (bByteValue == 0) {
                z = false;
            } else {
                boolean zZzaj = zzwh.zzxt().zzak(messagetype).zzaj(messagetype);
                if (zBooleanValue) {
                    messagetype.zza(zze.zzbyn, zZzaj ? messagetype : null, null);
                }
                z = zZzaj;
            }
            if (z) {
                return messagetype;
            }
            throw new zzxc(messagetype);
        }
    }

    public static final class zzb<T extends zzuo<T, ?>> extends zzsz<T> {
        private final T zzbyi;

        public zzb(T t) {
            this.zzbyi = t;
        }

        @Override // com.google.android.gms.internal.measurement.zzwf
        public final /* synthetic */ Object zza(zztq zztqVar, zzub zzubVar) throws zzuv {
            return zzuo.zza(this.zzbyi, zztqVar, zzubVar);
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzuo<MessageType, BuilderType> implements zzvx {
        protected zzuf<Object> zzbyl = zzuf.zzvw();
    }

    public static final class zzd<ContainingType extends zzvv, Type> extends zztz<ContainingType, Type> {
    }

    public static final enum zze {
        public static final int zzbym = 1;
        public static final int zzbyn = 2;
        public static final int zzbyo = 3;
        public static final int zzbyp = 4;
        public static final int zzbyq = 5;
        public static final int zzbyr = 6;
        public static final int zzbys = 7;
        private static final /* synthetic */ int[] zzbyt = {zzbym, zzbyn, zzbyo, zzbyp, zzbyq, zzbyr, zzbys};
        public static final int zzbyu = 1;
        public static final int zzbyv = 2;
        private static final /* synthetic */ int[] zzbyw = {zzbyu, zzbyv};
        public static final int zzbyx = 1;
        public static final int zzbyy = 2;
        private static final /* synthetic */ int[] zzbyz = {zzbyx, zzbyy};

        public static int[] zzwp() {
            return (int[]) zzbyt.clone();
        }
    }

    static <T extends zzuo<T, ?>> T zza(T t, zztq zztqVar, zzub zzubVar) throws zzuv {
        T t2 = (T) t.zza(zze.zzbyp, null, null);
        try {
            zzwh.zzxt().zzak(t2).zza(t2, zztt.zza(zztqVar), zzubVar);
            zzwh.zzxt().zzak(t2).zzy(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzuv) {
                throw ((zzuv) e.getCause());
            }
            throw new zzuv(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzuv) {
                throw ((zzuv) e2.getCause());
            }
            throw e2;
        }
    }

    protected static Object zza(zzvv zzvvVar, String str, Object[] objArr) {
        return new zzwj(zzvvVar, str, objArr);
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

    protected static <T extends zzuo<?, ?>> void zza(Class<T> cls, T t) {
        zzbyh.put(cls, t);
    }

    protected static final <T extends zzuo<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zze.zzbym, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        return zzwh.zzxt().zzak(t).zzaj(t);
    }

    static <T extends zzuo<?, ?>> T zzg(Class<T> cls) {
        zzuo<?, ?> zzuoVar = zzbyh.get(cls);
        if (zzuoVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzuoVar = zzbyh.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzuoVar == null) {
            zzuoVar = (T) ((zzuo) zzxj.zzk(cls)).zza(zze.zzbyr, (Object) null, (Object) null);
            if (zzuoVar == null) {
                throw new IllegalStateException();
            }
            zzbyh.put(cls, zzuoVar);
        }
        return (T) zzuoVar;
    }

    protected static <E> zzuu<E> zzwg() {
        return zzwi.zzxu();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzuo) zza(zze.zzbyr, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return zzwh.zzxt().zzak(this).equals(this, (zzuo) obj);
        }
        return false;
    }

    public int hashCode() {
        if (this.zzbtk != 0) {
            return this.zzbtk;
        }
        this.zzbtk = zzwh.zzxt().zzak(this).hashCode(this);
        return this.zzbtk;
    }

    @Override // com.google.android.gms.internal.measurement.zzvx
    public final boolean isInitialized() {
        boolean zBooleanValue = Boolean.TRUE.booleanValue();
        byte bByteValue = ((Byte) zza(zze.zzbym, (Object) null, (Object) null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzaj = zzwh.zzxt().zzak(this).zzaj(this);
        if (!zBooleanValue) {
            return zZzaj;
        }
        zza(zze.zzbyn, zZzaj ? this : null, (Object) null);
        return zZzaj;
    }

    public String toString() {
        return zzvy.zza(this, super.toString());
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.zzsx
    final void zzai(int i) {
        this.zzbyg = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzvv
    public final void zzb(zztv zztvVar) throws IOException {
        zzwh.zzxt().zzi(getClass()).zza(this, zztx.zza(zztvVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    final int zztx() {
        return this.zzbyg;
    }

    @Override // com.google.android.gms.internal.measurement.zzvv
    public final int zzvx() {
        if (this.zzbyg == -1) {
            this.zzbyg = zzwh.zzxt().zzak(this).zzai(this);
        }
        return this.zzbyg;
    }

    public final BuilderType zzwf() {
        BuilderType buildertype = (BuilderType) zza(zze.zzbyq, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzvv
    public final /* synthetic */ zzvw zzwh() {
        zza zzaVar = (zza) zza(zze.zzbyq, (Object) null, (Object) null);
        zzaVar.zza(this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzvv
    public final /* synthetic */ zzvw zzwi() {
        return (zza) zza(zze.zzbyq, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzvx
    public final /* synthetic */ zzvv zzwj() {
        return (zzuo) zza(zze.zzbyr, (Object) null, (Object) null);
    }
}
