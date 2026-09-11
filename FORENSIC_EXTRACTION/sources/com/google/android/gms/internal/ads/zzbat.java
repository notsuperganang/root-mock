package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbat implements zzbdl {
    private int tag;
    private final zzbaq zzdqi;
    private int zzdqj;
    private int zzdqk = 0;

    private zzbat(zzbaq zzbaqVar) {
        this.zzdqi = (zzbaq) zzbbq.zza(zzbaqVar, "input");
        this.zzdqi.zzdqa = this;
    }

    public static zzbat zza(zzbaq zzbaqVar) {
        return zzbaqVar.zzdqa != null ? zzbaqVar.zzdqa : new zzbat(zzbaqVar);
    }

    private final Object zza(zzbes zzbesVar, Class<?> cls, zzbbb zzbbbVar) throws IOException {
        switch (zzbau.zzdql[zzbesVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzabq());
            case 2:
                return zzabs();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzabu());
            case 5:
                return Integer.valueOf(zzabp());
            case 6:
                return Long.valueOf(zzabo());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzabn());
            case 9:
                return Long.valueOf(zzabm());
            case 10:
                zzbv(2);
                return zzc(zzbdg.zzaeo().zze(cls), zzbbbVar);
            case 11:
                return Integer.valueOf(zzabv());
            case 12:
                return Long.valueOf(zzabw());
            case 13:
                return Integer.valueOf(zzabx());
            case 14:
                return Long.valueOf(zzaby());
            case 15:
                return zzabr();
            case 16:
                return Integer.valueOf(zzabt());
            case 17:
                return Long.valueOf(zzabl());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int iZzabk;
        int iZzabk2;
        if ((this.tag & 7) != 2) {
            throw zzbbu.zzadq();
        }
        if (!(list instanceof zzbcd) || z) {
            do {
                list.add(z ? zzabr() : readString());
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbcd zzbcdVar = (zzbcd) list;
        do {
            zzbcdVar.zzap(zzabs());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    private final void zzbv(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzbbu.zzadq();
        }
    }

    private static void zzbw(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzbbu.zzadr();
        }
    }

    private static void zzbx(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzbbu.zzadr();
        }
    }

    private final void zzby(int i) throws IOException {
        if (this.zzdqi.zzacb() != i) {
            throw zzbbu.zzadl();
        }
    }

    private final <T> T zzc(zzbdm<T> zzbdmVar, zzbbb zzbbbVar) throws IOException {
        int iZzabt = this.zzdqi.zzabt();
        if (this.zzdqi.zzdpx >= this.zzdqi.zzdpy) {
            throw new zzbbu("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzbr = this.zzdqi.zzbr(iZzabt);
        T tNewInstance = zzbdmVar.newInstance();
        this.zzdqi.zzdpx++;
        zzbdmVar.zza(tNewInstance, this, zzbbbVar);
        zzbdmVar.zzo(tNewInstance);
        this.zzdqi.zzbp(0);
        this.zzdqi.zzdpx--;
        this.zzdqi.zzbs(iZzbr);
        return tNewInstance;
    }

    private final <T> T zzd(zzbdm<T> zzbdmVar, zzbbb zzbbbVar) throws IOException {
        int i = this.zzdqj;
        this.zzdqj = ((this.tag >>> 3) << 3) | 4;
        try {
            T tNewInstance = zzbdmVar.newInstance();
            zzbdmVar.zza(tNewInstance, this, zzbbbVar);
            zzbdmVar.zzo(tNewInstance);
            if (this.tag != this.zzdqj) {
                throw zzbbu.zzadr();
            }
            this.zzdqj = i;
            return tNewInstance;
        } catch (Throwable th) {
            this.zzdqj = i;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final double readDouble() throws IOException {
        zzbv(1);
        return this.zzdqi.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final float readFloat() throws IOException {
        zzbv(5);
        return this.zzdqi.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final String readString() throws IOException {
        zzbv(2);
        return this.zzdqi.readString();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final <T> T zza(zzbdm<T> zzbdmVar, zzbbb zzbbbVar) throws IOException {
        zzbv(2);
        return (T) zzc(zzbdmVar, zzbbbVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbdl
    public final <T> void zza(List<T> list, zzbdm<T> zzbdmVar, zzbbb zzbbbVar) throws IOException {
        int iZzabk;
        if ((this.tag & 7) != 2) {
            throw zzbbu.zzadq();
        }
        int i = this.tag;
        do {
            list.add(zzc(zzbdmVar, zzbbbVar));
            if (this.zzdqi.zzaca() || this.zzdqk != 0) {
                return;
            } else {
                iZzabk = this.zzdqi.zzabk();
            }
        } while (iZzabk == i);
        this.zzdqk = iZzabk;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbdl
    public final <K, V> void zza(Map<K, V> map, zzbcn<K, V> zzbcnVar, zzbbb zzbbbVar) throws IOException {
        zzbv(2);
        int iZzbr = this.zzdqi.zzbr(this.zzdqi.zzabt());
        Object objZza = zzbcnVar.zzdvz;
        Object objZza2 = zzbcnVar.zzdwb;
        while (true) {
            try {
                int iZzaci = zzaci();
                if (iZzaci != Integer.MAX_VALUE && !this.zzdqi.zzaca()) {
                    switch (iZzaci) {
                        case 1:
                            objZza = zza(zzbcnVar.zzdvy, (Class<?>) null, (zzbbb) null);
                            continue;
                        case 2:
                            objZza2 = zza(zzbcnVar.zzdwa, zzbcnVar.zzdwb.getClass(), zzbbbVar);
                            continue;
                        default:
                            try {
                                if (!zzacj()) {
                                    throw new zzbbu("Unable to parse map entry.");
                                }
                                continue;
                            } catch (zzbbv e) {
                                if (!zzacj()) {
                                    throw new zzbbu("Unable to parse map entry.");
                                }
                            }
                    }
                    this.zzdqi.zzbs(iZzbr);
                    throw th;
                }
            } catch (Throwable th) {
                this.zzdqi.zzbs(iZzbr);
                throw th;
            }
        }
        map.put(objZza, objZza2);
        this.zzdqi.zzbs(iZzbr);
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzaa(List<Integer> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbbp)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzbbu.zzadq();
                case 2:
                    int iZzabt = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                    do {
                        list.add(Integer.valueOf(this.zzdqi.zzabu()));
                    } while (this.zzdqi.zzacb() < iZzabt);
                    zzby(iZzabt);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzdqi.zzabu()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzbbu.zzadq();
            case 2:
                int iZzabt2 = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                do {
                    zzbbpVar.zzco(this.zzdqi.zzabu());
                } while (this.zzdqi.zzacb() < iZzabt2);
                zzby(iZzabt2);
                return;
        }
        do {
            zzbbpVar.zzco(this.zzdqi.zzabu());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzab(List<Integer> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbbp)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzabt = this.zzdqi.zzabt();
                    zzbx(iZzabt);
                    int iZzacb = this.zzdqi.zzacb();
                    do {
                        list.add(Integer.valueOf(this.zzdqi.zzabv()));
                    } while (this.zzdqi.zzacb() < iZzabt + iZzacb);
                    return;
                case 3:
                case 4:
                default:
                    throw zzbbu.zzadq();
                case 5:
                    break;
            }
            do {
                list.add(Integer.valueOf(this.zzdqi.zzabv()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        switch (this.tag & 7) {
            case 2:
                int iZzabt2 = this.zzdqi.zzabt();
                zzbx(iZzabt2);
                int iZzacb2 = this.zzdqi.zzacb();
                do {
                    zzbbpVar.zzco(this.zzdqi.zzabv());
                } while (this.zzdqi.zzacb() < iZzabt2 + iZzacb2);
                return;
            case 3:
            case 4:
            default:
                throw zzbbu.zzadq();
            case 5:
                break;
        }
        do {
            zzbbpVar.zzco(this.zzdqi.zzabv());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final long zzabl() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabl();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final long zzabm() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabm();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final int zzabn() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabn();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final long zzabo() throws IOException {
        zzbv(1);
        return this.zzdqi.zzabo();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final int zzabp() throws IOException {
        zzbv(5);
        return this.zzdqi.zzabp();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final boolean zzabq() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabq();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final String zzabr() throws IOException {
        zzbv(2);
        return this.zzdqi.zzabr();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final zzbah zzabs() throws IOException {
        zzbv(2);
        return this.zzdqi.zzabs();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final int zzabt() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabt();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final int zzabu() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabu();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final int zzabv() throws IOException {
        zzbv(5);
        return this.zzdqi.zzabv();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final long zzabw() throws IOException {
        zzbv(1);
        return this.zzdqi.zzabw();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final int zzabx() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabx();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final long zzaby() throws IOException {
        zzbv(0);
        return this.zzdqi.zzaby();
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzac(List<Long> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbci)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzabt = this.zzdqi.zzabt();
                    zzbw(iZzabt);
                    int iZzacb = this.zzdqi.zzacb();
                    do {
                        list.add(Long.valueOf(this.zzdqi.zzabw()));
                    } while (this.zzdqi.zzacb() < iZzabt + iZzacb);
                    return;
                default:
                    throw zzbbu.zzadq();
            }
            do {
                list.add(Long.valueOf(this.zzdqi.zzabw()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbci zzbciVar = (zzbci) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzabt2 = this.zzdqi.zzabt();
                zzbw(iZzabt2);
                int iZzacb2 = this.zzdqi.zzacb();
                do {
                    zzbciVar.zzw(this.zzdqi.zzabw());
                } while (this.zzdqi.zzacb() < iZzabt2 + iZzacb2);
                return;
            default:
                throw zzbbu.zzadq();
        }
        do {
            zzbciVar.zzw(this.zzdqi.zzabw());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final int zzaci() throws IOException {
        if (this.zzdqk != 0) {
            this.tag = this.zzdqk;
            this.zzdqk = 0;
        } else {
            this.tag = this.zzdqi.zzabk();
        }
        if (this.tag == 0 || this.tag == this.zzdqj) {
            return Integer.MAX_VALUE;
        }
        return this.tag >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final boolean zzacj() throws IOException {
        if (this.zzdqi.zzaca() || this.tag == this.zzdqj) {
            return false;
        }
        return this.zzdqi.zzbq(this.tag);
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzad(List<Integer> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbbp)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzbbu.zzadq();
                case 2:
                    int iZzabt = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                    do {
                        list.add(Integer.valueOf(this.zzdqi.zzabx()));
                    } while (this.zzdqi.zzacb() < iZzabt);
                    zzby(iZzabt);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzdqi.zzabx()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzbbu.zzadq();
            case 2:
                int iZzabt2 = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                do {
                    zzbbpVar.zzco(this.zzdqi.zzabx());
                } while (this.zzdqi.zzacb() < iZzabt2);
                zzby(iZzabt2);
                return;
        }
        do {
            zzbbpVar.zzco(this.zzdqi.zzabx());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzae(List<Long> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbci)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzbbu.zzadq();
                case 2:
                    int iZzabt = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                    do {
                        list.add(Long.valueOf(this.zzdqi.zzaby()));
                    } while (this.zzdqi.zzacb() < iZzabt);
                    zzby(iZzabt);
                    return;
            }
            do {
                list.add(Long.valueOf(this.zzdqi.zzaby()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbci zzbciVar = (zzbci) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzbbu.zzadq();
            case 2:
                int iZzabt2 = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                do {
                    zzbciVar.zzw(this.zzdqi.zzaby());
                } while (this.zzdqi.zzacb() < iZzabt2);
                zzby(iZzabt2);
                return;
        }
        do {
            zzbciVar.zzw(this.zzdqi.zzaby());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final <T> T zzb(zzbdm<T> zzbdmVar, zzbbb zzbbbVar) throws IOException {
        zzbv(3);
        return (T) zzd(zzbdmVar, zzbbbVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbdl
    public final <T> void zzb(List<T> list, zzbdm<T> zzbdmVar, zzbbb zzbbbVar) throws IOException {
        int iZzabk;
        if ((this.tag & 7) != 3) {
            throw zzbbu.zzadq();
        }
        int i = this.tag;
        do {
            list.add(zzd(zzbdmVar, zzbbbVar));
            if (this.zzdqi.zzaca() || this.zzdqk != 0) {
                return;
            } else {
                iZzabk = this.zzdqi.zzabk();
            }
        } while (iZzabk == i);
        this.zzdqk = iZzabk;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzp(List<Double> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbay)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzabt = this.zzdqi.zzabt();
                    zzbw(iZzabt);
                    int iZzacb = this.zzdqi.zzacb();
                    do {
                        list.add(Double.valueOf(this.zzdqi.readDouble()));
                    } while (this.zzdqi.zzacb() < iZzabt + iZzacb);
                    return;
                default:
                    throw zzbbu.zzadq();
            }
            do {
                list.add(Double.valueOf(this.zzdqi.readDouble()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbay zzbayVar = (zzbay) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzabt2 = this.zzdqi.zzabt();
                zzbw(iZzabt2);
                int iZzacb2 = this.zzdqi.zzacb();
                do {
                    zzbayVar.zzd(this.zzdqi.readDouble());
                } while (this.zzdqi.zzacb() < iZzabt2 + iZzacb2);
                return;
            default:
                throw zzbbu.zzadq();
        }
        do {
            zzbayVar.zzd(this.zzdqi.readDouble());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzq(List<Float> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbbm)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzabt = this.zzdqi.zzabt();
                    zzbx(iZzabt);
                    int iZzacb = this.zzdqi.zzacb();
                    do {
                        list.add(Float.valueOf(this.zzdqi.readFloat()));
                    } while (this.zzdqi.zzacb() < iZzabt + iZzacb);
                    return;
                case 3:
                case 4:
                default:
                    throw zzbbu.zzadq();
                case 5:
                    break;
            }
            do {
                list.add(Float.valueOf(this.zzdqi.readFloat()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbbm zzbbmVar = (zzbbm) list;
        switch (this.tag & 7) {
            case 2:
                int iZzabt2 = this.zzdqi.zzabt();
                zzbx(iZzabt2);
                int iZzacb2 = this.zzdqi.zzacb();
                do {
                    zzbbmVar.zzd(this.zzdqi.readFloat());
                } while (this.zzdqi.zzacb() < iZzabt2 + iZzacb2);
                return;
            case 3:
            case 4:
            default:
                throw zzbbu.zzadq();
            case 5:
                break;
        }
        do {
            zzbbmVar.zzd(this.zzdqi.readFloat());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzr(List<Long> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbci)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzbbu.zzadq();
                case 2:
                    int iZzabt = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                    do {
                        list.add(Long.valueOf(this.zzdqi.zzabl()));
                    } while (this.zzdqi.zzacb() < iZzabt);
                    zzby(iZzabt);
                    return;
            }
            do {
                list.add(Long.valueOf(this.zzdqi.zzabl()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbci zzbciVar = (zzbci) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzbbu.zzadq();
            case 2:
                int iZzabt2 = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                do {
                    zzbciVar.zzw(this.zzdqi.zzabl());
                } while (this.zzdqi.zzacb() < iZzabt2);
                zzby(iZzabt2);
                return;
        }
        do {
            zzbciVar.zzw(this.zzdqi.zzabl());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzs(List<Long> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbci)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzbbu.zzadq();
                case 2:
                    int iZzabt = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                    do {
                        list.add(Long.valueOf(this.zzdqi.zzabm()));
                    } while (this.zzdqi.zzacb() < iZzabt);
                    zzby(iZzabt);
                    return;
            }
            do {
                list.add(Long.valueOf(this.zzdqi.zzabm()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbci zzbciVar = (zzbci) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzbbu.zzadq();
            case 2:
                int iZzabt2 = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                do {
                    zzbciVar.zzw(this.zzdqi.zzabm());
                } while (this.zzdqi.zzacb() < iZzabt2);
                zzby(iZzabt2);
                return;
        }
        do {
            zzbciVar.zzw(this.zzdqi.zzabm());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzt(List<Integer> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbbp)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzbbu.zzadq();
                case 2:
                    int iZzabt = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                    do {
                        list.add(Integer.valueOf(this.zzdqi.zzabn()));
                    } while (this.zzdqi.zzacb() < iZzabt);
                    zzby(iZzabt);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzdqi.zzabn()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzbbu.zzadq();
            case 2:
                int iZzabt2 = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                do {
                    zzbbpVar.zzco(this.zzdqi.zzabn());
                } while (this.zzdqi.zzacb() < iZzabt2);
                zzby(iZzabt2);
                return;
        }
        do {
            zzbbpVar.zzco(this.zzdqi.zzabn());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzu(List<Long> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbci)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzabt = this.zzdqi.zzabt();
                    zzbw(iZzabt);
                    int iZzacb = this.zzdqi.zzacb();
                    do {
                        list.add(Long.valueOf(this.zzdqi.zzabo()));
                    } while (this.zzdqi.zzacb() < iZzabt + iZzacb);
                    return;
                default:
                    throw zzbbu.zzadq();
            }
            do {
                list.add(Long.valueOf(this.zzdqi.zzabo()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbci zzbciVar = (zzbci) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzabt2 = this.zzdqi.zzabt();
                zzbw(iZzabt2);
                int iZzacb2 = this.zzdqi.zzacb();
                do {
                    zzbciVar.zzw(this.zzdqi.zzabo());
                } while (this.zzdqi.zzacb() < iZzabt2 + iZzacb2);
                return;
            default:
                throw zzbbu.zzadq();
        }
        do {
            zzbciVar.zzw(this.zzdqi.zzabo());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzv(List<Integer> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbbp)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzabt = this.zzdqi.zzabt();
                    zzbx(iZzabt);
                    int iZzacb = this.zzdqi.zzacb();
                    do {
                        list.add(Integer.valueOf(this.zzdqi.zzabp()));
                    } while (this.zzdqi.zzacb() < iZzabt + iZzacb);
                    return;
                case 3:
                case 4:
                default:
                    throw zzbbu.zzadq();
                case 5:
                    break;
            }
            do {
                list.add(Integer.valueOf(this.zzdqi.zzabp()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        switch (this.tag & 7) {
            case 2:
                int iZzabt2 = this.zzdqi.zzabt();
                zzbx(iZzabt2);
                int iZzacb2 = this.zzdqi.zzacb();
                do {
                    zzbbpVar.zzco(this.zzdqi.zzabp());
                } while (this.zzdqi.zzacb() < iZzabt2 + iZzacb2);
                return;
            case 3:
            case 4:
            default:
                throw zzbbu.zzadq();
            case 5:
                break;
        }
        do {
            zzbbpVar.zzco(this.zzdqi.zzabp());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzw(List<Boolean> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbaf)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzbbu.zzadq();
                case 2:
                    int iZzabt = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                    do {
                        list.add(Boolean.valueOf(this.zzdqi.zzabq()));
                    } while (this.zzdqi.zzacb() < iZzabt);
                    zzby(iZzabt);
                    return;
            }
            do {
                list.add(Boolean.valueOf(this.zzdqi.zzabq()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbaf zzbafVar = (zzbaf) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzbbu.zzadq();
            case 2:
                int iZzabt2 = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                do {
                    zzbafVar.addBoolean(this.zzdqi.zzabq());
                } while (this.zzdqi.zzacb() < iZzabt2);
                zzby(iZzabt2);
                return;
        }
        do {
            zzbafVar.addBoolean(this.zzdqi.zzabq());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzx(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzy(List<zzbah> list) throws IOException {
        int iZzabk;
        if ((this.tag & 7) != 2) {
            throw zzbbu.zzadq();
        }
        do {
            list.add(zzabs());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk = this.zzdqi.zzabk();
            }
        } while (iZzabk == this.tag);
        this.zzdqk = iZzabk;
    }

    @Override // com.google.android.gms.internal.ads.zzbdl
    public final void zzz(List<Integer> list) throws IOException {
        int iZzabk;
        int iZzabk2;
        if (!(list instanceof zzbbp)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzbbu.zzadq();
                case 2:
                    int iZzabt = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                    do {
                        list.add(Integer.valueOf(this.zzdqi.zzabt()));
                    } while (this.zzdqi.zzacb() < iZzabt);
                    zzby(iZzabt);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzdqi.zzabt()));
                if (this.zzdqi.zzaca()) {
                    return;
                } else {
                    iZzabk = this.zzdqi.zzabk();
                }
            } while (iZzabk == this.tag);
            this.zzdqk = iZzabk;
            return;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzbbu.zzadq();
            case 2:
                int iZzabt2 = this.zzdqi.zzabt() + this.zzdqi.zzacb();
                do {
                    zzbbpVar.zzco(this.zzdqi.zzabt());
                } while (this.zzdqi.zzacb() < iZzabt2);
                zzby(iZzabt2);
                return;
        }
        do {
            zzbbpVar.zzco(this.zzdqi.zzabt());
            if (this.zzdqi.zzaca()) {
                return;
            } else {
                iZzabk2 = this.zzdqi.zzabk();
            }
        } while (iZzabk2 == this.tag);
        this.zzdqk = iZzabk2;
    }
}
