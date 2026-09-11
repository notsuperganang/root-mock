package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzgd implements zzix {
    private int tag;
    private int zznq;
    private final zzga zzom;
    private int zzon = 0;

    private zzgd(zzga zzgaVar) {
        this.zzom = (zzga) zzhb.zzb(zzgaVar, "input");
        this.zzom.zzoe = this;
    }

    private static void zzaa(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzhh.zzef();
        }
    }

    private final void zzab(int i) throws IOException {
        if (this.zzom.zzcl() != i) {
            throw zzhh.zzdz();
        }
    }

    public static zzgd zzb(zzga zzgaVar) {
        return zzgaVar.zzoe != null ? zzgaVar.zzoe : new zzgd(zzgaVar);
    }

    private final Object zzb(zzke zzkeVar, Class<?> cls, zzgl zzglVar) throws IOException {
        switch (zzge.zznn[zzkeVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbn());
            case 2:
                return zzbp();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbr());
            case 5:
                return Integer.valueOf(zzbm());
            case 6:
                return Long.valueOf(zzbl());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbk());
            case 9:
                return Long.valueOf(zzbj());
            case 10:
                return zzb(cls, zzglVar);
            case 11:
                return Integer.valueOf(zzbs());
            case 12:
                return Long.valueOf(zzbt());
            case 13:
                return Integer.valueOf(zzbu());
            case 14:
                return Long.valueOf(zzbv());
            case 15:
                return zzbo();
            case 16:
                return Integer.valueOf(zzbq());
            case 17:
                return Long.valueOf(zzbi());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zzb(List<String> list, boolean z) throws IOException {
        int iZzcj;
        int iZzcj2;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzed();
        }
        if (!(list instanceof zzhq) || z) {
            do {
                list.add(z ? zzbo() : readString());
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzhq zzhqVar = (zzhq) list;
        do {
            zzhqVar.zzd(zzbp());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    private final <T> T zzc(zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        int iZzbq = this.zzom.zzbq();
        if (this.zzom.zzob >= this.zzom.zzoc) {
            throw zzhh.zzee();
        }
        int iZzak = this.zzom.zzak(iZzbq);
        T tNewInstance = zziyVar.newInstance();
        this.zzom.zzob++;
        zziyVar.zzb(tNewInstance, this, zzglVar);
        zziyVar.zzd(tNewInstance);
        this.zzom.zzah(0);
        this.zzom.zzob--;
        this.zzom.zzal(iZzak);
        return tNewInstance;
    }

    private final <T> T zze(zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        int i = this.zznq;
        this.zznq = ((this.tag >>> 3) << 3) | 4;
        try {
            T tNewInstance = zziyVar.newInstance();
            zziyVar.zzb(tNewInstance, this, zzglVar);
            zziyVar.zzd(tNewInstance);
            if (this.tag != this.zznq) {
                throw zzhh.zzef();
            }
            this.zznq = i;
            return tNewInstance;
        } catch (Throwable th) {
            this.zznq = i;
            throw th;
        }
    }

    private final void zzy(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhh.zzed();
        }
    }

    private static void zzz(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzhh.zzef();
        }
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final double readDouble() throws IOException {
        zzy(1);
        return this.zzom.readDouble();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final float readFloat() throws IOException {
        zzy(5);
        return this.zzom.readFloat();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final String readString() throws IOException {
        zzy(2);
        return this.zzom.readString();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void readStringList(List<String> list) throws IOException {
        zzb(list, false);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final <T> T zzb(zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        zzy(2);
        return (T) zzc(zziyVar, zzglVar);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final <T> T zzb(Class<T> cls, zzgl zzglVar) throws IOException {
        zzy(2);
        return (T) zzc(zzis.zzfc().zzg(cls), zzglVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.places.zzix
    public final <T> void zzb(List<T> list, zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        int iZzcj;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzed();
        }
        int i = this.tag;
        do {
            list.add(zzc(zziyVar, zzglVar));
            if (this.zzom.zzbf() || this.zzon != 0) {
                return;
            } else {
                iZzcj = this.zzom.zzcj();
            }
        } while (iZzcj == i);
        this.zzon = iZzcj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.places.zzix
    public final <K, V> void zzb(Map<K, V> map, zzia<K, V> zziaVar, zzgl zzglVar) throws IOException {
        zzy(2);
        int iZzak = this.zzom.zzak(this.zzom.zzbq());
        Object objZzb = zziaVar.zzuu;
        Object objZzb2 = zziaVar.zzss;
        while (true) {
            try {
                int iZzbg = zzbg();
                if (iZzbg != Integer.MAX_VALUE && !this.zzom.zzbf()) {
                    switch (iZzbg) {
                        case 1:
                            objZzb = zzb(zziaVar.zzut, (Class<?>) null, (zzgl) null);
                            continue;
                        case 2:
                            objZzb2 = zzb(zziaVar.zzuv, zziaVar.zzss.getClass(), zzglVar);
                            continue;
                        default:
                            try {
                                if (!zzbh()) {
                                    throw new zzhh("Unable to parse map entry.");
                                }
                                continue;
                            } catch (zzhi e) {
                                if (!zzbh()) {
                                    throw new zzhh("Unable to parse map entry.");
                                }
                            }
                    }
                    this.zzom.zzal(iZzak);
                    throw th;
                }
            } catch (Throwable th) {
                this.zzom.zzal(iZzak);
                throw th;
            }
        }
        map.put(objZzb, objZzb2);
        this.zzom.zzal(iZzak);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbg() throws IOException {
        if (this.zzon != 0) {
            this.tag = this.zzon;
            this.zzon = 0;
        } else {
            this.tag = this.zzom.zzcj();
        }
        if (this.tag == 0 || this.tag == this.zznq) {
            return Integer.MAX_VALUE;
        }
        return this.tag >>> 3;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final boolean zzbh() throws IOException {
        if (this.zzom.zzbf() || this.tag == this.zznq) {
            return false;
        }
        return this.zzom.zzai(this.tag);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbi() throws IOException {
        zzy(0);
        return this.zzom.zzbi();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbj() throws IOException {
        zzy(0);
        return this.zzom.zzbj();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbk() throws IOException {
        zzy(0);
        return this.zzom.zzbk();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbl() throws IOException {
        zzy(1);
        return this.zzom.zzbl();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbm() throws IOException {
        zzy(5);
        return this.zzom.zzbm();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final boolean zzbn() throws IOException {
        zzy(0);
        return this.zzom.zzbn();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final String zzbo() throws IOException {
        zzy(2);
        return this.zzom.zzbo();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final zzfr zzbp() throws IOException {
        zzy(2);
        return this.zzom.zzbp();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbq() throws IOException {
        zzy(0);
        return this.zzom.zzbq();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbr() throws IOException {
        zzy(0);
        return this.zzom.zzbr();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbs() throws IOException {
        zzy(5);
        return this.zzom.zzbs();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbt() throws IOException {
        zzy(1);
        return this.zzom.zzbt();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbu() throws IOException {
        zzy(0);
        return this.zzom.zzbu();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbv() throws IOException {
        zzy(0);
        return this.zzom.zzbv();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final <T> T zzc(Class<T> cls, zzgl zzglVar) throws IOException {
        zzy(3);
        return (T) zze(zzis.zzfc().zzg(cls), zzglVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.places.zzix
    public final <T> void zzc(List<T> list, zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        int iZzcj;
        if ((this.tag & 7) != 3) {
            throw zzhh.zzed();
        }
        int i = this.tag;
        do {
            list.add(zze(zziyVar, zzglVar));
            if (this.zzom.zzbf() || this.zzon != 0) {
                return;
            } else {
                iZzcj = this.zzom.zzcj();
            }
        } while (iZzcj == i);
        this.zzon = iZzcj;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final <T> T zzd(zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        zzy(3);
        return (T) zze(zziyVar, zzglVar);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zze(List<Double> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzgi)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzbq = this.zzom.zzbq();
                    zzz(iZzbq);
                    int iZzcl = iZzbq + this.zzom.zzcl();
                    do {
                        list.add(Double.valueOf(this.zzom.readDouble()));
                    } while (this.zzom.zzcl() < iZzcl);
                    return;
                default:
                    throw zzhh.zzed();
            }
            do {
                list.add(Double.valueOf(this.zzom.readDouble()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzgi zzgiVar = (zzgi) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzbq2 = this.zzom.zzbq();
                zzz(iZzbq2);
                int iZzcl2 = iZzbq2 + this.zzom.zzcl();
                do {
                    zzgiVar.zzd(this.zzom.readDouble());
                } while (this.zzom.zzcl() < iZzcl2);
                return;
            default:
                throw zzhh.zzed();
        }
        do {
            zzgiVar.zzd(this.zzom.readDouble());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzf(List<Float> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzgw)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzbq = this.zzom.zzbq();
                    zzaa(iZzbq);
                    int iZzcl = iZzbq + this.zzom.zzcl();
                    do {
                        list.add(Float.valueOf(this.zzom.readFloat()));
                    } while (this.zzom.zzcl() < iZzcl);
                    return;
                case 3:
                case 4:
                default:
                    throw zzhh.zzed();
                case 5:
                    break;
            }
            do {
                list.add(Float.valueOf(this.zzom.readFloat()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzgw zzgwVar = (zzgw) list;
        switch (this.tag & 7) {
            case 2:
                int iZzbq2 = this.zzom.zzbq();
                zzaa(iZzbq2);
                int iZzcl2 = iZzbq2 + this.zzom.zzcl();
                do {
                    zzgwVar.zzf(this.zzom.readFloat());
                } while (this.zzom.zzcl() < iZzcl2);
                return;
            case 3:
            case 4:
            default:
                throw zzhh.zzed();
            case 5:
                break;
        }
        do {
            zzgwVar.zzf(this.zzom.readFloat());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzg(List<Long> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbq = this.zzom.zzbq() + this.zzom.zzcl();
                    do {
                        list.add(Long.valueOf(this.zzom.zzbi()));
                    } while (this.zzom.zzcl() < iZzbq);
                    zzab(iZzbq);
                    return;
            }
            do {
                list.add(Long.valueOf(this.zzom.zzbi()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbq2 = this.zzom.zzbq() + this.zzom.zzcl();
                do {
                    zzhvVar.zzp(this.zzom.zzbi());
                } while (this.zzom.zzcl() < iZzbq2);
                zzab(iZzbq2);
                return;
        }
        do {
            zzhvVar.zzp(this.zzom.zzbi());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzh(List<Long> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbq = this.zzom.zzbq() + this.zzom.zzcl();
                    do {
                        list.add(Long.valueOf(this.zzom.zzbj()));
                    } while (this.zzom.zzcl() < iZzbq);
                    zzab(iZzbq);
                    return;
            }
            do {
                list.add(Long.valueOf(this.zzom.zzbj()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbq2 = this.zzom.zzbq() + this.zzom.zzcl();
                do {
                    zzhvVar.zzp(this.zzom.zzbj());
                } while (this.zzom.zzcl() < iZzbq2);
                zzab(iZzbq2);
                return;
        }
        do {
            zzhvVar.zzp(this.zzom.zzbj());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzi(List<Integer> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbq = this.zzom.zzbq() + this.zzom.zzcl();
                    do {
                        list.add(Integer.valueOf(this.zzom.zzbk()));
                    } while (this.zzom.zzcl() < iZzbq);
                    zzab(iZzbq);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzom.zzbk()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbq2 = this.zzom.zzbq() + this.zzom.zzcl();
                do {
                    zzhaVar.zzbe(this.zzom.zzbk());
                } while (this.zzom.zzcl() < iZzbq2);
                zzab(iZzbq2);
                return;
        }
        do {
            zzhaVar.zzbe(this.zzom.zzbk());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzj(List<Long> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzbq = this.zzom.zzbq();
                    zzz(iZzbq);
                    int iZzcl = iZzbq + this.zzom.zzcl();
                    do {
                        list.add(Long.valueOf(this.zzom.zzbl()));
                    } while (this.zzom.zzcl() < iZzcl);
                    return;
                default:
                    throw zzhh.zzed();
            }
            do {
                list.add(Long.valueOf(this.zzom.zzbl()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzbq2 = this.zzom.zzbq();
                zzz(iZzbq2);
                int iZzcl2 = iZzbq2 + this.zzom.zzcl();
                do {
                    zzhvVar.zzp(this.zzom.zzbl());
                } while (this.zzom.zzcl() < iZzcl2);
                return;
            default:
                throw zzhh.zzed();
        }
        do {
            zzhvVar.zzp(this.zzom.zzbl());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzk(List<Integer> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzbq = this.zzom.zzbq();
                    zzaa(iZzbq);
                    int iZzcl = iZzbq + this.zzom.zzcl();
                    do {
                        list.add(Integer.valueOf(this.zzom.zzbm()));
                    } while (this.zzom.zzcl() < iZzcl);
                    return;
                case 3:
                case 4:
                default:
                    throw zzhh.zzed();
                case 5:
                    break;
            }
            do {
                list.add(Integer.valueOf(this.zzom.zzbm()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 2:
                int iZzbq2 = this.zzom.zzbq();
                zzaa(iZzbq2);
                int iZzcl2 = iZzbq2 + this.zzom.zzcl();
                do {
                    zzhaVar.zzbe(this.zzom.zzbm());
                } while (this.zzom.zzcl() < iZzcl2);
                return;
            case 3:
            case 4:
            default:
                throw zzhh.zzed();
            case 5:
                break;
        }
        do {
            zzhaVar.zzbe(this.zzom.zzbm());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzl(List<Boolean> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzfp)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbq = this.zzom.zzbq() + this.zzom.zzcl();
                    do {
                        list.add(Boolean.valueOf(this.zzom.zzbn()));
                    } while (this.zzom.zzcl() < iZzbq);
                    zzab(iZzbq);
                    return;
            }
            do {
                list.add(Boolean.valueOf(this.zzom.zzbn()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzfp zzfpVar = (zzfp) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbq2 = this.zzom.zzbq() + this.zzom.zzcl();
                do {
                    zzfpVar.addBoolean(this.zzom.zzbn());
                } while (this.zzom.zzcl() < iZzbq2);
                zzab(iZzbq2);
                return;
        }
        do {
            zzfpVar.addBoolean(this.zzom.zzbn());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzm(List<String> list) throws IOException {
        zzb(list, true);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzn(List<zzfr> list) throws IOException {
        int iZzcj;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzed();
        }
        do {
            list.add(zzbp());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj = this.zzom.zzcj();
            }
        } while (iZzcj == this.tag);
        this.zzon = iZzcj;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzo(List<Integer> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbq = this.zzom.zzbq() + this.zzom.zzcl();
                    do {
                        list.add(Integer.valueOf(this.zzom.zzbq()));
                    } while (this.zzom.zzcl() < iZzbq);
                    zzab(iZzbq);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzom.zzbq()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbq2 = this.zzom.zzbq() + this.zzom.zzcl();
                do {
                    zzhaVar.zzbe(this.zzom.zzbq());
                } while (this.zzom.zzcl() < iZzbq2);
                zzab(iZzbq2);
                return;
        }
        do {
            zzhaVar.zzbe(this.zzom.zzbq());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzp(List<Integer> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbq = this.zzom.zzbq() + this.zzom.zzcl();
                    do {
                        list.add(Integer.valueOf(this.zzom.zzbr()));
                    } while (this.zzom.zzcl() < iZzbq);
                    zzab(iZzbq);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzom.zzbr()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbq2 = this.zzom.zzbq() + this.zzom.zzcl();
                do {
                    zzhaVar.zzbe(this.zzom.zzbr());
                } while (this.zzom.zzcl() < iZzbq2);
                zzab(iZzbq2);
                return;
        }
        do {
            zzhaVar.zzbe(this.zzom.zzbr());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzq(List<Integer> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzbq = this.zzom.zzbq();
                    zzaa(iZzbq);
                    int iZzcl = iZzbq + this.zzom.zzcl();
                    do {
                        list.add(Integer.valueOf(this.zzom.zzbs()));
                    } while (this.zzom.zzcl() < iZzcl);
                    return;
                case 3:
                case 4:
                default:
                    throw zzhh.zzed();
                case 5:
                    break;
            }
            do {
                list.add(Integer.valueOf(this.zzom.zzbs()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 2:
                int iZzbq2 = this.zzom.zzbq();
                zzaa(iZzbq2);
                int iZzcl2 = iZzbq2 + this.zzom.zzcl();
                do {
                    zzhaVar.zzbe(this.zzom.zzbs());
                } while (this.zzom.zzcl() < iZzcl2);
                return;
            case 3:
            case 4:
            default:
                throw zzhh.zzed();
            case 5:
                break;
        }
        do {
            zzhaVar.zzbe(this.zzom.zzbs());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzr(List<Long> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzbq = this.zzom.zzbq();
                    zzz(iZzbq);
                    int iZzcl = iZzbq + this.zzom.zzcl();
                    do {
                        list.add(Long.valueOf(this.zzom.zzbt()));
                    } while (this.zzom.zzcl() < iZzcl);
                    return;
                default:
                    throw zzhh.zzed();
            }
            do {
                list.add(Long.valueOf(this.zzom.zzbt()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzbq2 = this.zzom.zzbq();
                zzz(iZzbq2);
                int iZzcl2 = iZzbq2 + this.zzom.zzcl();
                do {
                    zzhvVar.zzp(this.zzom.zzbt());
                } while (this.zzom.zzcl() < iZzcl2);
                return;
            default:
                throw zzhh.zzed();
        }
        do {
            zzhvVar.zzp(this.zzom.zzbt());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzs(List<Integer> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbq = this.zzom.zzbq() + this.zzom.zzcl();
                    do {
                        list.add(Integer.valueOf(this.zzom.zzbu()));
                    } while (this.zzom.zzcl() < iZzbq);
                    zzab(iZzbq);
                    return;
            }
            do {
                list.add(Integer.valueOf(this.zzom.zzbu()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbq2 = this.zzom.zzbq() + this.zzom.zzcl();
                do {
                    zzhaVar.zzbe(this.zzom.zzbu());
                } while (this.zzom.zzcl() < iZzbq2);
                zzab(iZzbq2);
                return;
        }
        do {
            zzhaVar.zzbe(this.zzom.zzbu());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzt(List<Long> list) throws IOException {
        int iZzcj;
        int iZzcj2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbq = this.zzom.zzbq() + this.zzom.zzcl();
                    do {
                        list.add(Long.valueOf(this.zzom.zzbv()));
                    } while (this.zzom.zzcl() < iZzbq);
                    zzab(iZzbq);
                    return;
            }
            do {
                list.add(Long.valueOf(this.zzom.zzbv()));
                if (this.zzom.zzbf()) {
                    return;
                } else {
                    iZzcj = this.zzom.zzcj();
                }
            } while (iZzcj == this.tag);
            this.zzon = iZzcj;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbq2 = this.zzom.zzbq() + this.zzom.zzcl();
                do {
                    zzhvVar.zzp(this.zzom.zzbv());
                } while (this.zzom.zzcl() < iZzbq2);
                zzab(iZzbq2);
                return;
        }
        do {
            zzhvVar.zzp(this.zzom.zzbv());
            if (this.zzom.zzbf()) {
                return;
            } else {
                iZzcj2 = this.zzom.zzcj();
            }
        } while (iZzcj2 == this.tag);
        this.zzon = iZzcj2;
    }
}
