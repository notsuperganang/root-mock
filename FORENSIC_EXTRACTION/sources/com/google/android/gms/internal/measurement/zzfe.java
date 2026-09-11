package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzfe {

    public static final class zza extends zzuo<zza, C0005zza> implements zzvx {
        private static final zza zzauy = new zza();
        private static volatile zzwf<zza> zznw;
        private String zzauw = "";
        private long zzaux;
        private int zznr;

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfe$zza$zza, reason: collision with other inner class name */
        public static final class C0005zza extends zzuo.zza<zza, C0005zza> implements zzvx {
            private C0005zza() {
                super(zza.zzauy);
            }

            /* synthetic */ C0005zza(zzff zzffVar) {
                this();
            }

            public final C0005zza zzan(long j) {
                zzwk();
                ((zza) this.zzbyj).zzam(j);
                return this;
            }

            public final C0005zza zzda(String str) {
                zzwk();
                ((zza) this.zzbyj).setName(str);
                return this;
            }
        }

        static {
            zzuo.zza((Class<zza>) zza.class, zzauy);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zznr |= 1;
            this.zzauw = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzam(long j) {
            this.zznr |= 2;
            this.zzaux = j;
        }

        public static C0005zza zzmn() {
            return (C0005zza) ((zzuo.zza) zzauy.zza(zzuo.zze.zzbyq, (Object) null, (Object) null));
        }

        @Override // com.google.android.gms.internal.measurement.zzuo
        protected final Object zza(int i, Object obj, Object obj2) {
            zzwf zzbVar;
            zzff zzffVar = null;
            switch (zzff.zznq[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0005zza(zzffVar);
                case 3:
                    return zza(zzauy, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zznr", "zzauw", "zzaux"});
                case 4:
                    return zzauy;
                case 5:
                    zzwf<zza> zzwfVar = zznw;
                    if (zzwfVar != null) {
                        return zzwfVar;
                    }
                    synchronized (zza.class) {
                        try {
                            zzbVar = zznw;
                            if (zzbVar == null) {
                                zzbVar = new zzuo.zzb(zzauy);
                                zznw = zzbVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return zzbVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzb extends zzuo<zzb, zza> implements zzvx {
        private static final zzb zzavb = new zzb();
        private static volatile zzwf<zzb> zznw;
        private int zzauz = 1;
        private zzuu<zza> zzava = zzwg();
        private int zznr;

        public static final class zza extends zzuo.zza<zzb, zza> implements zzvx {
            private zza() {
                super(zzb.zzavb);
            }

            /* synthetic */ zza(zzff zzffVar) {
                this();
            }

            public final zza zzb(zza zzaVar) {
                zzwk();
                ((zzb) this.zzbyj).zza(zzaVar);
                return this;
            }
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfe$zzb$zzb, reason: collision with other inner class name */
        public enum EnumC0006zzb implements zzur {
            RADS(1),
            PROVISIONING(2);

            private static final zzus<EnumC0006zzb> zzoa = new zzfg();
            private final int value;

            EnumC0006zzb(int i) {
                this.value = i;
            }

            public static zzut zzd() {
                return zzfh.zzoc;
            }

            public static EnumC0006zzb zzt(int i) {
                switch (i) {
                    case 1:
                        return RADS;
                    case 2:
                        return PROVISIONING;
                    default:
                        return null;
                }
            }

            @Override // com.google.android.gms.internal.measurement.zzur
            public final int zzc() {
                return this.value;
            }
        }

        static {
            zzuo.zza((Class<zzb>) zzb.class, zzavb);
        }

        private zzb() {
        }

        public static zzwf<zzb> zza() {
            return (zzwf) zzavb.zza(zzuo.zze.zzbys, (Object) null, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            if (zzaVar == null) {
                throw new NullPointerException();
            }
            if (!this.zzava.zztz()) {
                zzuu<zza> zzuuVar = this.zzava;
                int size = zzuuVar.size();
                this.zzava = zzuuVar.zzal(size == 0 ? 10 : size << 1);
            }
            this.zzava.add(zzaVar);
        }

        public static zza zzmp() {
            return (zza) ((zzuo.zza) zzavb.zza(zzuo.zze.zzbyq, (Object) null, (Object) null));
        }

        @Override // com.google.android.gms.internal.measurement.zzuo
        protected final Object zza(int i, Object obj, Object obj2) {
            zzwf zzbVar;
            zzff zzffVar = null;
            switch (zzff.zznq[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzffVar);
                case 3:
                    return zza(zzavb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zznr", "zzauz", EnumC0006zzb.zzd(), "zzava", zza.class});
                case 4:
                    return zzavb;
                case 5:
                    zzwf<zzb> zzwfVar = zznw;
                    if (zzwfVar != null) {
                        return zzwfVar;
                    }
                    synchronized (zzb.class) {
                        try {
                            zzbVar = zznw;
                            if (zzbVar == null) {
                                zzbVar = new zzuo.zzb(zzavb);
                                zznw = zzbVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return zzbVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
