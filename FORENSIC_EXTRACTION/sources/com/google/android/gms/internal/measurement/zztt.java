package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zztt implements zzwk {
    private int tag;
    private final zztq zzbuk;
    private int zzbul;
    private int zzbum = 0;

    private zztt(zztq zztqVar) {
        this.zzbuk = (zztq) zzuq.zza(zztqVar, "input");
        this.zzbuk.zzbud = this;
    }

    public static zztt zza(zztq zztqVar) {
        return zztqVar.zzbud != null ? zztqVar.zzbud : new zztt(zztqVar);
    }

    private final Object zza(zzxs zzxsVar, Class<?> cls, zzub zzubVar) throws IOException {
        switch (zztu.zzbun[zzxsVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzup());
            case 2:
                return zzur();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzut());
            case 5:
                return Integer.valueOf(zzuo());
            case 6:
                return Long.valueOf(zzun());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzum());
            case 9:
                return Long.valueOf(zzul());
            case 10:
                zzav(2);
                return zzc(zzwh.zzxt().zzi(cls), zzubVar);
            case 11:
                return Integer.valueOf(zzuu());
            case 12:
                return Long.valueOf(zzuv());
            case 13:
                return Integer.valueOf(zzuw());
            case 14:
                return Long.valueOf(zzux());
            case 15:
                return zzuq();
            case 16:
                return Integer.valueOf(zzus());
            case 17:
                return Long.valueOf(zzuk());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int iZzuj;
        int iZzuj2;
        if ((this.tag & 7) != 2) {
            throw zzuv.zzwu();
        }
        if (!(list instanceof zzve) || z) {
            do {
                list.add(z ? zzuq() : readString());
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzve zzveVar = (zzve) list;
        do {
            zzveVar.zzc(zzur());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    private final void zzav(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzuv.zzwu();
        }
    }

    private static void zzaw(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzuv.zzww();
        }
    }

    private static void zzax(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzuv.zzww();
        }
    }

    private final void zzay(int i) throws IOException {
        if (this.zzbuk.zzva() != i) {
            throw zzuv.zzwq();
        }
    }

    private final <T> T zzc(zzwl<T> zzwlVar, zzub zzubVar) throws IOException {
        int iZzus = this.zzbuk.zzus();
        if (this.zzbuk.zzbua >= this.zzbuk.zzbub) {
            throw zzuv.zzwv();
        }
        int iZzas = this.zzbuk.zzas(iZzus);
        T tNewInstance = zzwlVar.newInstance();
        this.zzbuk.zzbua++;
        zzwlVar.zza(tNewInstance, this, zzubVar);
        zzwlVar.zzy(tNewInstance);
        this.zzbuk.zzap(0);
        this.zzbuk.zzbua--;
        this.zzbuk.zzat(iZzas);
        return tNewInstance;
    }

    private final <T> T zzd(zzwl<T> zzwlVar, zzub zzubVar) throws IOException {
        int i = this.zzbul;
        this.zzbul = ((this.tag >>> 3) << 3) | 4;
        try {
            T tNewInstance = zzwlVar.newInstance();
            zzwlVar.zza(tNewInstance, this, zzubVar);
            zzwlVar.zzy(tNewInstance);
            if (this.tag != this.zzbul) {
                throw zzuv.zzww();
            }
            this.zzbul = i;
            return tNewInstance;
        } catch (Throwable th) {
            this.zzbul = i;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final double readDouble() throws IOException {
        zzav(1);
        return this.zzbuk.readDouble();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final float readFloat() throws IOException {
        zzav(5);
        return this.zzbuk.readFloat();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final String readString() throws IOException {
        zzav(2);
        return this.zzbuk.readString();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <T> T zza(zzwl<T> zzwlVar, zzub zzubVar) throws IOException {
        zzav(2);
        return (T) zzc(zzwlVar, zzubVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <T> void zza(List<T> list, zzwl<T> zzwlVar, zzub zzubVar) throws IOException {
        int iZzuj;
        if ((this.tag & 7) != 2) {
            throw zzuv.zzwu();
        }
        int i = this.tag;
        do {
            list.add(zzc(zzwlVar, zzubVar));
            if (this.zzbuk.zzuz() || this.zzbum != 0) {
                return;
            } else {
                iZzuj = this.zzbuk.zzuj();
            }
        } while (iZzuj == i);
        this.zzbum = iZzuj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <K, V> void zza(Map<K, V> map, zzvo<K, V> zzvoVar, zzub zzubVar) throws IOException {
        zzav(2);
        int iZzas = this.zzbuk.zzas(this.zzbuk.zzus());
        Object objZza = zzvoVar.zzcal;
        Object objZza2 = zzvoVar.zzbrr;
        while (true) {
            try {
                int iZzvh = zzvh();
                if (iZzvh != Integer.MAX_VALUE && !this.zzbuk.zzuz()) {
                    switch (iZzvh) {
                        case 1:
                            objZza = zza(zzvoVar.zzcak, (Class<?>) null, (zzub) null);
                            continue;
                        case 2:
                            objZza2 = zza(zzvoVar.zzcam, zzvoVar.zzbrr.getClass(), zzubVar);
                            continue;
                        default:
                            try {
                                if (!zzvi()) {
                                    throw new zzuv("Unable to parse map entry.");
                                }
                                continue;
                            } catch (zzuw e) {
                                if (!zzvi()) {
                                    throw new zzuv("Unable to parse map entry.");
                                }
                            }
                    }
                    this.zzbuk.zzat(iZzas);
                    throw th;
                }
            } catch (Throwable th) {
                this.zzbuk.zzat(iZzas);
                throw th;
            }
        }
        map.put(objZza, objZza2);
        this.zzbuk.zzat(iZzas);
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <T> T zzb(zzwl<T> zzwlVar, zzub zzubVar) throws IOException {
        zzav(3);
        return (T) zzd(zzwlVar, zzubVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <T> void zzb(List<T> list, zzwl<T> zzwlVar, zzub zzubVar) throws IOException {
        int iZzuj;
        if ((this.tag & 7) != 3) {
            throw zzuv.zzwu();
        }
        int i = this.tag;
        do {
            list.add(zzd(zzwlVar, zzubVar));
            if (this.zzbuk.zzuz() || this.zzbum != 0) {
                return;
            } else {
                iZzuj = this.zzbuk.zzuj();
            }
        } while (iZzuj == i);
        this.zzbum = iZzuj;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzi(List<Double> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzty)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzus = this.zzbuk.zzus();
                    zzaw(iZzus);
                    int iZzva = this.zzbuk.zzva();
                    do {
                        list.add(Double.valueOf(this.zzbuk.readDouble()));
                    } while (this.zzbuk.zzva() < iZzus + iZzva);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                list.add(Double.valueOf(this.zzbuk.readDouble()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzty zztyVar = (zzty) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzus2 = this.zzbuk.zzus();
                zzaw(iZzus2);
                int iZzva2 = this.zzbuk.zzva();
                do {
                    zztyVar.zzd(this.zzbuk.readDouble());
                } while (this.zzbuk.zzva() < iZzus2 + iZzva2);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            zztyVar.zzd(this.zzbuk.readDouble());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzj(List<Float> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzul)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzus = this.zzbuk.zzus();
                    zzax(iZzus);
                    int iZzva = this.zzbuk.zzva();
                    do {
                        list.add(Float.valueOf(this.zzbuk.readFloat()));
                    } while (this.zzbuk.zzva() < iZzus + iZzva);
                    return;
                case 3:
                case 4:
                default:
                    throw zzuv.zzwu();
                case 5:
                    break;
            }
            do {
                list.add(Float.valueOf(this.zzbuk.readFloat()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzul zzulVar = (zzul) list;
        switch (this.tag & 7) {
            case 2:
                int iZzus2 = this.zzbuk.zzus();
                zzax(iZzus2);
                int iZzva2 = this.zzbuk.zzva();
                do {
                    zzulVar.zzc(this.zzbuk.readFloat());
                } while (this.zzbuk.zzva() < iZzus2 + iZzva2);
                return;
            case 3:
            case 4:
            default:
                throw zzuv.zzwu();
            case 5:
                break;
        }
        do {
            zzulVar.zzc(this.zzbuk.readFloat());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzk(List<Long> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzvj)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzuv.zzwu();
                case 2:
                    int iZzus = this.zzbuk.zzus() + this.zzbuk.zzva();
                    do {
                        list.add(Long.valueOf(this.zzbuk.zzuk()));
                    } while (this.zzbuk.zzva() < iZzus);
                    zzay(iZzus);
                    return;
            }
            do {
                list.add(Long.valueOf(this.zzbuk.zzuk()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzvj zzvjVar = (zzvj) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzuv.zzwu();
            case 2:
                int iZzus2 = this.zzbuk.zzus() + this.zzbuk.zzva();
                do {
                    zzvjVar.zzbe(this.zzbuk.zzuk());
                } while (this.zzbuk.zzva() < iZzus2);
                zzay(iZzus2);
                return;
        }
        do {
            zzvjVar.zzbe(this.zzbuk.zzuk());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzl(List<Long> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzvj)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzuv.zzwu();
                case 2:
                    int iZzus = this.zzbuk.zzus() + this.zzbuk.zzva();
                    do {
                        list.add(Long.valueOf(this.zzbuk.zzul()));
                    } while (this.zzbuk.zzva() < iZzus);
                    zzay(iZzus);
                    return;
            }
            do {
                list.add(Long.valueOf(this.zzbuk.zzul()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzvj zzvjVar = (zzvj) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzuv.zzwu();
            case 2:
                int iZzus2 = this.zzbuk.zzus() + this.zzbuk.zzva();
                do {
                    zzvjVar.zzbe(this.zzbuk.zzul());
                } while (this.zzbuk.zzva() < iZzus2);
                zzay(iZzus2);
                return;
        }
        do {
            zzvjVar.zzbe(this.zzbuk.zzul());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzm(List<Integer> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzup)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzuv.zzwu();
                case 2:
                    int iZzus = this.zzbuk.zzus() + this.zzbuk.zzva();
                    do {
                        list.add(Integer.valueOf(this.zzbuk.zzum()));
                    } while (this.zzbuk.zzva() < iZzus);
                    zzay(iZzus);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzbuk.zzum()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzup zzupVar = (zzup) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzuv.zzwu();
            case 2:
                int iZzus2 = this.zzbuk.zzus() + this.zzbuk.zzva();
                do {
                    zzupVar.zzbo(this.zzbuk.zzum());
                } while (this.zzbuk.zzva() < iZzus2);
                zzay(iZzus2);
                return;
        }
        do {
            zzupVar.zzbo(this.zzbuk.zzum());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzn(List<Long> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzvj)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzus = this.zzbuk.zzus();
                    zzaw(iZzus);
                    int iZzva = this.zzbuk.zzva();
                    do {
                        list.add(Long.valueOf(this.zzbuk.zzun()));
                    } while (this.zzbuk.zzva() < iZzus + iZzva);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                list.add(Long.valueOf(this.zzbuk.zzun()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzvj zzvjVar = (zzvj) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzus2 = this.zzbuk.zzus();
                zzaw(iZzus2);
                int iZzva2 = this.zzbuk.zzva();
                do {
                    zzvjVar.zzbe(this.zzbuk.zzun());
                } while (this.zzbuk.zzva() < iZzus2 + iZzva2);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            zzvjVar.zzbe(this.zzbuk.zzun());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzo(List<Integer> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzup)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzus = this.zzbuk.zzus();
                    zzax(iZzus);
                    int iZzva = this.zzbuk.zzva();
                    do {
                        list.add(Integer.valueOf(this.zzbuk.zzuo()));
                    } while (this.zzbuk.zzva() < iZzus + iZzva);
                    return;
                case 3:
                case 4:
                default:
                    throw zzuv.zzwu();
                case 5:
                    break;
            }
            do {
                list.add(Integer.valueOf(this.zzbuk.zzuo()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzup zzupVar = (zzup) list;
        switch (this.tag & 7) {
            case 2:
                int iZzus2 = this.zzbuk.zzus();
                zzax(iZzus2);
                int iZzva2 = this.zzbuk.zzva();
                do {
                    zzupVar.zzbo(this.zzbuk.zzuo());
                } while (this.zzbuk.zzva() < iZzus2 + iZzva2);
                return;
            case 3:
            case 4:
            default:
                throw zzuv.zzwu();
            case 5:
                break;
        }
        do {
            zzupVar.zzbo(this.zzbuk.zzuo());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzp(List<Boolean> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zztc)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzuv.zzwu();
                case 2:
                    int iZzus = this.zzbuk.zzus() + this.zzbuk.zzva();
                    do {
                        list.add(Boolean.valueOf(this.zzbuk.zzup()));
                    } while (this.zzbuk.zzva() < iZzus);
                    zzay(iZzus);
                    return;
            }
            do {
                list.add(Boolean.valueOf(this.zzbuk.zzup()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zztc zztcVar = (zztc) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzuv.zzwu();
            case 2:
                int iZzus2 = this.zzbuk.zzus() + this.zzbuk.zzva();
                do {
                    zztcVar.addBoolean(this.zzbuk.zzup());
                } while (this.zzbuk.zzva() < iZzus2);
                zzay(iZzus2);
                return;
        }
        do {
            zztcVar.addBoolean(this.zzbuk.zzup());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzq(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzr(List<zzte> list) throws IOException {
        int iZzuj;
        if ((this.tag & 7) != 2) {
            throw zzuv.zzwu();
        }
        do {
            list.add(zzur());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj = this.zzbuk.zzuj();
            }
        } while (iZzuj == this.tag);
        this.zzbum = iZzuj;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzs(List<Integer> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzup)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzuv.zzwu();
                case 2:
                    int iZzus = this.zzbuk.zzus() + this.zzbuk.zzva();
                    do {
                        list.add(Integer.valueOf(this.zzbuk.zzus()));
                    } while (this.zzbuk.zzva() < iZzus);
                    zzay(iZzus);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzbuk.zzus()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzup zzupVar = (zzup) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzuv.zzwu();
            case 2:
                int iZzus2 = this.zzbuk.zzus() + this.zzbuk.zzva();
                do {
                    zzupVar.zzbo(this.zzbuk.zzus());
                } while (this.zzbuk.zzva() < iZzus2);
                zzay(iZzus2);
                return;
        }
        do {
            zzupVar.zzbo(this.zzbuk.zzus());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzt(List<Integer> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzup)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzuv.zzwu();
                case 2:
                    int iZzus = this.zzbuk.zzus() + this.zzbuk.zzva();
                    do {
                        list.add(Integer.valueOf(this.zzbuk.zzut()));
                    } while (this.zzbuk.zzva() < iZzus);
                    zzay(iZzus);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzbuk.zzut()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzup zzupVar = (zzup) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzuv.zzwu();
            case 2:
                int iZzus2 = this.zzbuk.zzus() + this.zzbuk.zzva();
                do {
                    zzupVar.zzbo(this.zzbuk.zzut());
                } while (this.zzbuk.zzva() < iZzus2);
                zzay(iZzus2);
                return;
        }
        do {
            zzupVar.zzbo(this.zzbuk.zzut());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzu(List<Integer> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzup)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzus = this.zzbuk.zzus();
                    zzax(iZzus);
                    int iZzva = this.zzbuk.zzva();
                    do {
                        list.add(Integer.valueOf(this.zzbuk.zzuu()));
                    } while (this.zzbuk.zzva() < iZzus + iZzva);
                    return;
                case 3:
                case 4:
                default:
                    throw zzuv.zzwu();
                case 5:
                    break;
            }
            do {
                list.add(Integer.valueOf(this.zzbuk.zzuu()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzup zzupVar = (zzup) list;
        switch (this.tag & 7) {
            case 2:
                int iZzus2 = this.zzbuk.zzus();
                zzax(iZzus2);
                int iZzva2 = this.zzbuk.zzva();
                do {
                    zzupVar.zzbo(this.zzbuk.zzuu());
                } while (this.zzbuk.zzva() < iZzus2 + iZzva2);
                return;
            case 3:
            case 4:
            default:
                throw zzuv.zzwu();
            case 5:
                break;
        }
        do {
            zzupVar.zzbo(this.zzbuk.zzuu());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzuk() throws IOException {
        zzav(0);
        return this.zzbuk.zzuk();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzul() throws IOException {
        zzav(0);
        return this.zzbuk.zzul();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzum() throws IOException {
        zzav(0);
        return this.zzbuk.zzum();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzun() throws IOException {
        zzav(1);
        return this.zzbuk.zzun();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzuo() throws IOException {
        zzav(5);
        return this.zzbuk.zzuo();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final boolean zzup() throws IOException {
        zzav(0);
        return this.zzbuk.zzup();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final String zzuq() throws IOException {
        zzav(2);
        return this.zzbuk.zzuq();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final zzte zzur() throws IOException {
        zzav(2);
        return this.zzbuk.zzur();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzus() throws IOException {
        zzav(0);
        return this.zzbuk.zzus();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzut() throws IOException {
        zzav(0);
        return this.zzbuk.zzut();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzuu() throws IOException {
        zzav(5);
        return this.zzbuk.zzuu();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzuv() throws IOException {
        zzav(1);
        return this.zzbuk.zzuv();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzuw() throws IOException {
        zzav(0);
        return this.zzbuk.zzuw();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzux() throws IOException {
        zzav(0);
        return this.zzbuk.zzux();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzv(List<Long> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzvj)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzus = this.zzbuk.zzus();
                    zzaw(iZzus);
                    int iZzva = this.zzbuk.zzva();
                    do {
                        list.add(Long.valueOf(this.zzbuk.zzuv()));
                    } while (this.zzbuk.zzva() < iZzus + iZzva);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                list.add(Long.valueOf(this.zzbuk.zzuv()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzvj zzvjVar = (zzvj) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzus2 = this.zzbuk.zzus();
                zzaw(iZzus2);
                int iZzva2 = this.zzbuk.zzva();
                do {
                    zzvjVar.zzbe(this.zzbuk.zzuv());
                } while (this.zzbuk.zzva() < iZzus2 + iZzva2);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            zzvjVar.zzbe(this.zzbuk.zzuv());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzvh() throws IOException {
        if (this.zzbum != 0) {
            this.tag = this.zzbum;
            this.zzbum = 0;
        } else {
            this.tag = this.zzbuk.zzuj();
        }
        if (this.tag == 0 || this.tag == this.zzbul) {
            return Integer.MAX_VALUE;
        }
        return this.tag >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final boolean zzvi() throws IOException {
        if (this.zzbuk.zzuz() || this.tag == this.zzbul) {
            return false;
        }
        return this.zzbuk.zzaq(this.tag);
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzw(List<Integer> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzup)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzuv.zzwu();
                case 2:
                    int iZzus = this.zzbuk.zzus() + this.zzbuk.zzva();
                    do {
                        list.add(Integer.valueOf(this.zzbuk.zzuw()));
                    } while (this.zzbuk.zzva() < iZzus);
                    zzay(iZzus);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzbuk.zzuw()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzup zzupVar = (zzup) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzuv.zzwu();
            case 2:
                int iZzus2 = this.zzbuk.zzus() + this.zzbuk.zzva();
                do {
                    zzupVar.zzbo(this.zzbuk.zzuw());
                } while (this.zzbuk.zzva() < iZzus2);
                zzay(iZzus2);
                return;
        }
        do {
            zzupVar.zzbo(this.zzbuk.zzuw());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzx(List<Long> list) throws IOException {
        int iZzuj;
        int iZzuj2;
        if (!(list instanceof zzvj)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzuv.zzwu();
                case 2:
                    int iZzus = this.zzbuk.zzus() + this.zzbuk.zzva();
                    do {
                        list.add(Long.valueOf(this.zzbuk.zzux()));
                    } while (this.zzbuk.zzva() < iZzus);
                    zzay(iZzus);
                    return;
            }
            do {
                list.add(Long.valueOf(this.zzbuk.zzux()));
                if (this.zzbuk.zzuz()) {
                    return;
                } else {
                    iZzuj = this.zzbuk.zzuj();
                }
            } while (iZzuj == this.tag);
            this.zzbum = iZzuj;
            return;
        }
        zzvj zzvjVar = (zzvj) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzuv.zzwu();
            case 2:
                int iZzus2 = this.zzbuk.zzus() + this.zzbuk.zzva();
                do {
                    zzvjVar.zzbe(this.zzbuk.zzux());
                } while (this.zzbuk.zzva() < iZzus2);
                zzay(iZzus2);
                return;
        }
        do {
            zzvjVar.zzbe(this.zzbuk.zzux());
            if (this.zzbuk.zzuz()) {
                return;
            } else {
                iZzuj2 = this.zzbuk.zzuj();
            }
        } while (iZzuj2 == this.tag);
        this.zzbum = iZzuj2;
    }
}
