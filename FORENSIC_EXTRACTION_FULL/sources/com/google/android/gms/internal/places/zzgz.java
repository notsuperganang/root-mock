package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzgz;
import com.google.android.gms.internal.places.zzgz.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgz<MessageType extends zzgz<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzfh<MessageType, BuilderType> {
    private static Map<Object, zzgz<?, ?>> zzsi = new ConcurrentHashMap();
    protected zzjr zzsg = zzjr.zzgp();
    private int zzsh = -1;

    public static abstract class zzb<MessageType extends zzgz<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzfi<MessageType, BuilderType> {
        private final MessageType zzsj;
        protected MessageType zzsk;
        protected boolean zzsl = false;

        protected zzb(MessageType messagetype) {
            this.zzsj = messagetype;
            this.zzsk = (MessageType) messagetype.zzb(zzh.zzsy, null, null);
        }

        private static void zzb(MessageType messagetype, MessageType messagetype2) {
            zzis.zzfc().zzp(messagetype).zzd(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.places.zzfi
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzsj.zzb(zzh.zzsz, null, null);
            zzbVar.zzb((zzgz) zzdw());
            return zzbVar;
        }

        @Override // com.google.android.gms.internal.places.zzij
        public final boolean isInitialized() {
            return zzgz.zzb(this.zzsk, false);
        }

        @Override // com.google.android.gms.internal.places.zzfi
        /* JADX INFO: renamed from: zzaz */
        public final /* synthetic */ zzfi clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.places.zzfi
        public final BuilderType zzb(MessageType messagetype) {
            zzdt();
            zzb(this.zzsk, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.places.zzij
        public final /* synthetic */ zzih zzds() {
            return this.zzsj;
        }

        protected void zzdt() {
            if (this.zzsl) {
                MessageType messagetype = (MessageType) this.zzsk.zzb(zzh.zzsy, null, null);
                zzb(messagetype, this.zzsk);
                this.zzsk = messagetype;
                this.zzsl = false;
            }
        }

        @Override // com.google.android.gms.internal.places.zzii
        /* JADX INFO: renamed from: zzdu, reason: merged with bridge method [inline-methods] */
        public MessageType zzdw() {
            if (this.zzsl) {
                return this.zzsk;
            }
            MessageType messagetype = this.zzsk;
            zzis.zzfc().zzp(messagetype).zzd(messagetype);
            this.zzsl = true;
            return this.zzsk;
        }

        public final MessageType zzdv() {
            boolean z;
            MessageType messagetype = (MessageType) zzdw();
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) messagetype.zzb(zzh.zzsv, null, null)).byteValue();
            if (bByteValue == 1) {
                z = true;
            } else if (bByteValue == 0) {
                z = false;
            } else {
                boolean zZzo = zzis.zzfc().zzp(messagetype).zzo(messagetype);
                if (zBooleanValue) {
                    messagetype.zzb(zzh.zzsw, zZzo ? messagetype : null, null);
                }
                z = zZzo;
            }
            if (z) {
                return messagetype;
            }
            throw new zzjp(messagetype);
        }

        @Override // com.google.android.gms.internal.places.zzii
        public final /* synthetic */ zzih zzdx() {
            boolean z;
            zzgz zzgzVar = (zzgz) zzdw();
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) zzgzVar.zzb(zzh.zzsv, (Object) null, (Object) null)).byteValue();
            if (bByteValue == 1) {
                z = true;
            } else if (bByteValue == 0) {
                z = false;
            } else {
                boolean zZzo = zzis.zzfc().zzp(zzgzVar).zzo(zzgzVar);
                if (zBooleanValue) {
                    zzgzVar.zzb(zzh.zzsw, zZzo ? zzgzVar : null, (Object) null);
                }
                z = zZzo;
            }
            if (z) {
                return zzgzVar;
            }
            throw new zzjp(zzgzVar);
        }
    }

    public static class zzc<T extends zzgz<T, ?>> extends zzfj<T> {
        private T zzsj;

        public zzc(T t) {
            this.zzsj = t;
        }

        @Override // com.google.android.gms.internal.places.zzir
        public final /* synthetic */ Object zzb(zzga zzgaVar, zzgl zzglVar) throws zzhh {
            return zzgz.zzb(this.zzsj, zzgaVar, zzglVar);
        }
    }

    public static abstract class zzd<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzb<MessageType, BuilderType> implements zzij {
        protected zzd(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.places.zzgz.zzb
        protected final void zzdt() {
            if (this.zzsl) {
                super.zzdt();
                ((zze) this.zzsk).zzsm = (zzgq) ((zze) this.zzsk).zzsm.clone();
            }
        }

        @Override // com.google.android.gms.internal.places.zzgz.zzb
        /* JADX INFO: renamed from: zzdu */
        public final /* synthetic */ zzgz zzdw() {
            return (zze) zzdw();
        }

        @Override // com.google.android.gms.internal.places.zzgz.zzb, com.google.android.gms.internal.places.zzii
        public final /* synthetic */ zzih zzdw() {
            if (this.zzsl) {
                return (zze) this.zzsk;
            }
            ((zze) this.zzsk).zzsm.zzbb();
            return (zze) super.zzdw();
        }
    }

    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzgz<MessageType, BuilderType> implements zzij {
        protected zzgq<zzf> zzsm = zzgq.zzdf();
    }

    static final class zzf implements zzgs<zzf> {
        final zzke zzso;
        final zzhd<?> zzsn = null;
        final int number = 77815057;
        final boolean zzsp = false;
        final boolean zzsq = false;

        zzf(zzhd<?> zzhdVar, int i, zzke zzkeVar, boolean z, boolean z2) {
            this.zzso = zzkeVar;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zzf) obj).number;
        }

        @Override // com.google.android.gms.internal.places.zzgs
        public final int zzap() {
            return this.number;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.places.zzgs
        public final zzii zzb(zzii zziiVar, zzih zzihVar) {
            return ((zzb) zziiVar).zzb((zzgz) zzihVar);
        }

        @Override // com.google.android.gms.internal.places.zzgs
        public final zzin zzb(zzin zzinVar, zzin zzinVar2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.places.zzgs
        public final zzke zzdi() {
            return this.zzso;
        }

        @Override // com.google.android.gms.internal.places.zzgs
        public final zzkj zzdj() {
            return this.zzso.zzgz();
        }

        @Override // com.google.android.gms.internal.places.zzgs
        public final boolean zzdk() {
            return false;
        }

        @Override // com.google.android.gms.internal.places.zzgs
        public final boolean zzdl() {
            return false;
        }
    }

    public static class zzg<ContainingType extends zzih, Type> extends zzgj<ContainingType, Type> {
        private final ContainingType zzsr;
        private final Type zzss;
        final zzih zzst;
        final zzf zzsu;

        zzg(ContainingType containingtype, Type type, zzih zzihVar, zzf zzfVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (zzfVar.zzso == zzke.zzzd && zzihVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.zzsr = containingtype;
            this.zzss = type;
            this.zzst = zzihVar;
            this.zzsu = zzfVar;
        }
    }

    public static final enum zzh {
        public static final int zzsv = 1;
        public static final int zzsw = 2;
        public static final int zzsx = 3;
        public static final int zzsy = 4;
        public static final int zzsz = 5;
        public static final int zzta = 6;
        public static final int zztb = 7;
        private static final /* synthetic */ int[] zztc = {zzsv, zzsw, zzsx, zzsy, zzsz, zzta, zztb};
        public static final int zztd = 1;
        public static final int zzte = 2;
        private static final /* synthetic */ int[] zztf = {zztd, zzte};
        public static final int zztg = 1;
        public static final int zzth = 2;
        private static final /* synthetic */ int[] zzti = {zztg, zzth};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zztc.clone();
        }
    }

    public static <ContainingType extends zzih, Type> zzg<ContainingType, Type> zzb(ContainingType containingtype, Type type, zzih zzihVar, zzhd<?> zzhdVar, int i, zzke zzkeVar, Class cls) {
        return new zzg<>(containingtype, type, zzihVar, new zzf(null, 77815057, zzkeVar, false, false), cls);
    }

    static <T extends zzgz<T, ?>> T zzb(T t, zzga zzgaVar, zzgl zzglVar) throws zzhh {
        T t2 = (T) t.zzb(zzh.zzsy, null, null);
        try {
            zzis.zzfc().zzp(t2).zzb(t2, zzgd.zzb(zzgaVar), zzglVar);
            zzis.zzfc().zzp(t2).zzd(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzhh) {
                throw ((zzhh) e.getCause());
            }
            throw new zzhh(e.getMessage()).zzh(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzhh) {
                throw ((zzhh) e2.getCause());
            }
            throw e2;
        }
    }

    protected static Object zzb(zzih zzihVar, String str, Object[] objArr) {
        return new zziu(zzihVar, str, objArr);
    }

    static Object zzb(Method method, Object obj, Object... objArr) {
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

    protected static <T extends zzgz<?, ?>> void zzb(Class<T> cls, T t) {
        zzsi.put(cls, t);
    }

    protected static final <T extends zzgz<T, ?>> boolean zzb(T t, boolean z) {
        byte bByteValue = ((Byte) t.zzb(zzh.zzsv, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        return zzis.zzfc().zzp(t).zzo(t);
    }

    protected static zzhe zzdo() {
        return zzha.zzdy();
    }

    protected static <E> zzhg<E> zzdp() {
        return zzit.zzfd();
    }

    static <T extends zzgz<?, ?>> T zze(Class<T> cls) {
        T t = (T) zzsi.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzsi.get(cls);
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
        if (((zzgz) zzb(zzh.zzta, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return zzis.zzfc().zzp(this).equals(this, (zzgz) obj);
        }
        return false;
    }

    public int hashCode() {
        if (this.zznh != 0) {
            return this.zznh;
        }
        this.zznh = zzis.zzfc().zzp(this).hashCode(this);
        return this.zznh;
    }

    @Override // com.google.android.gms.internal.places.zzij
    public final boolean isInitialized() {
        boolean zBooleanValue = Boolean.TRUE.booleanValue();
        byte bByteValue = ((Byte) zzb(zzh.zzsv, (Object) null, (Object) null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzo = zzis.zzfc().zzp(this).zzo(this);
        if (zBooleanValue) {
            zzb(zzh.zzsw, zZzo ? this : null, (Object) null);
        }
        return zZzo;
    }

    public String toString() {
        return zzik.zzb(this, super.toString());
    }

    @Override // com.google.android.gms.internal.places.zzfh
    final int zzay() {
        return this.zzsh;
    }

    protected abstract Object zzb(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.places.zzih
    public final void zzc(zzgf zzgfVar) throws IOException {
        zzis.zzfc().zzg(getClass()).zzb(this, zzgh.zzb(zzgfVar));
    }

    @Override // com.google.android.gms.internal.places.zzih
    public final int zzdg() {
        if (this.zzsh == -1) {
            this.zzsh = zzis.zzfc().zzp(this).zzn(this);
        }
        return this.zzsh;
    }

    @Override // com.google.android.gms.internal.places.zzih
    public final /* synthetic */ zzii zzdq() {
        zzb zzbVar = (zzb) zzb(zzh.zzsz, (Object) null, (Object) null);
        zzbVar.zzb(this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.places.zzih
    public final /* synthetic */ zzii zzdr() {
        return (zzb) zzb(zzh.zzsz, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.places.zzij
    public final /* synthetic */ zzih zzds() {
        return (zzgz) zzb(zzh.zzta, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.places.zzfh
    final void zzv(int i) {
        this.zzsh = i;
    }
}
