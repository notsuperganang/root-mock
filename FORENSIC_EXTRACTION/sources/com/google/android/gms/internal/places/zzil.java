package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzil<T> implements zziy<T> {
    private static final Unsafe zzuz = zzjw.zzgu();
    private final int[] zzva;
    private final Object[] zzvb;
    private final int zzvc;
    private final int zzvd;
    private final int zzve;
    private final zzih zzvf;
    private final boolean zzvg;
    private final boolean zzvh;
    private final boolean zzvi;
    private final boolean zzvj;
    private final int[] zzvk;
    private final int[] zzvl;
    private final int[] zzvm;
    private final zzio zzvn;
    private final zzhr zzvo;
    private final zzjq<?, ?> zzvp;
    private final zzgm<?> zzvq;
    private final zzic zzvr;

    private zzil(int[] iArr, Object[] objArr, int i, int i2, int i3, zzih zzihVar, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzio zzioVar, zzhr zzhrVar, zzjq<?, ?> zzjqVar, zzgm<?> zzgmVar, zzic zzicVar) {
        this.zzva = iArr;
        this.zzvb = objArr;
        this.zzvc = i;
        this.zzvd = i2;
        this.zzve = i3;
        this.zzvh = zzihVar instanceof zzgz;
        this.zzvi = z;
        this.zzvg = zzgmVar != null && zzgmVar.zzf(zzihVar);
        this.zzvj = false;
        this.zzvk = iArr2;
        this.zzvl = iArr3;
        this.zzvm = iArr4;
        this.zzvn = zzioVar;
        this.zzvo = zzhrVar;
        this.zzvp = zzjqVar;
        this.zzvq = zzgmVar;
        this.zzvf = zzihVar;
        this.zzvr = zzicVar;
    }

    private static <UT, UB> int zzb(zzjq<UT, UB> zzjqVar, T t) {
        return zzjqVar.zzn(zzjqVar.zzq(t));
    }

    static <T> zzil<T> zzb(Class<T> cls, zzif zzifVar, zzio zzioVar, zzhr zzhrVar, zzjq<?, ?> zzjqVar, zzgm<?> zzgmVar, zzic zzicVar) {
        int iZzff;
        int iZzfg;
        int iZzfk;
        int iZzb;
        int iZzb2;
        int iZzfv;
        if (!(zzifVar instanceof zziu)) {
            ((zzjl) zzifVar).zzev();
            throw new NoSuchMethodError();
        }
        zziu zziuVar = (zziu) zzifVar;
        boolean z = zziuVar.zzev() == zzgz.zzh.zzte;
        if (zziuVar.getFieldCount() == 0) {
            iZzff = 0;
            iZzfg = 0;
            iZzfk = 0;
        } else {
            iZzff = zziuVar.zzff();
            iZzfg = zziuVar.zzfg();
            iZzfk = zziuVar.zzfk();
        }
        int[] iArr = new int[iZzfk << 2];
        Object[] objArr = new Object[iZzfk << 1];
        int[] iArr2 = zziuVar.zzfh() > 0 ? new int[zziuVar.zzfh()] : null;
        int[] iArr3 = zziuVar.zzfi() > 0 ? new int[zziuVar.zzfi()] : null;
        int i = 0;
        int i2 = 0;
        zziv zzivVarZzfe = zziuVar.zzfe();
        if (zzivVarZzfe.next()) {
            int iZzbg = zzivVarZzfe.zzbg();
            int i3 = 0;
            while (true) {
                if (iZzbg >= zziuVar.zzfl() || i3 >= ((iZzbg - iZzff) << 2)) {
                    if (zzivVarZzfe.zzfp()) {
                        iZzb = (int) zzjw.zzb(zzivVarZzfe.zzfq());
                        iZzb2 = (int) zzjw.zzb(zzivVarZzfe.zzfr());
                        iZzfv = 0;
                    } else {
                        iZzb = (int) zzjw.zzb(zzivVarZzfe.zzfs());
                        if (zzivVarZzfe.zzft()) {
                            iZzb2 = (int) zzjw.zzb(zzivVarZzfe.zzfu());
                            iZzfv = zzivVarZzfe.zzfv();
                        } else {
                            iZzb2 = 0;
                            iZzfv = 0;
                        }
                    }
                    iArr[i3] = zzivVarZzfe.zzbg();
                    iArr[i3 + 1] = iZzb | (zzivVarZzfe.zzfx() ? 536870912 : 0) | (zzivVarZzfe.zzfw() ? 268435456 : 0) | (zzivVarZzfe.zzfn() << 20);
                    iArr[i3 + 2] = iZzb2 | (iZzfv << 20);
                    if (zzivVarZzfe.zzga() != null) {
                        objArr[(i3 / 4) << 1] = zzivVarZzfe.zzga();
                        if (zzivVarZzfe.zzfy() != null) {
                            objArr[((i3 / 4) << 1) + 1] = zzivVarZzfe.zzfy();
                        } else if (zzivVarZzfe.zzfz() != null) {
                            objArr[((i3 / 4) << 1) + 1] = zzivVarZzfe.zzfz();
                        }
                    } else if (zzivVarZzfe.zzfy() != null) {
                        objArr[((i3 / 4) << 1) + 1] = zzivVarZzfe.zzfy();
                    } else if (zzivVarZzfe.zzfz() != null) {
                        objArr[((i3 / 4) << 1) + 1] = zzivVarZzfe.zzfz();
                    }
                    int iZzfn = zzivVarZzfe.zzfn();
                    if (iZzfn == zzgt.MAP.ordinal()) {
                        iArr2[i] = i3;
                        i++;
                    } else if (iZzfn >= 18 && iZzfn <= 49) {
                        iArr3[i2] = iArr[i3 + 1] & 1048575;
                        i2++;
                    }
                    if (!zzivVarZzfe.next()) {
                        break;
                    }
                    iZzbg = zzivVarZzfe.zzbg();
                } else {
                    for (int i4 = 0; i4 < 4; i4++) {
                        iArr[i3 + i4] = -1;
                    }
                }
                i3 += 4;
            }
        }
        return new zzil<>(iArr, objArr, iZzff, iZzfg, zziuVar.zzfl(), zziuVar.zzex(), z, false, zziuVar.zzfj(), iArr2, iArr3, zzioVar, zzhrVar, zzjqVar, zzgmVar, zzicVar);
    }

    private final <K, V, UT, UB> UB zzb(int i, int i2, Map<K, V> map, zzhd<?> zzhdVar, UB ub, zzjq<UT, UB> zzjqVar) {
        zzia<?, ?> zziaVarZzm = this.zzvr.zzm(zzbg(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (zzhdVar.zzi(((Integer) next.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = zzjqVar.zzgo();
                }
                zzfw zzfwVarZzag = zzfr.zzag(zzhz.zzb(zziaVarZzm, next.getKey(), next.getValue()));
                try {
                    zzhz.zzb(zzfwVarZzag.zzci(), zziaVarZzm, next.getKey(), next.getValue());
                    zzjqVar.zzb(ub, i2, zzfwVarZzag.zzch());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB zzb(Object obj, int i, UB ub, zzjq<UT, UB> zzjqVar) {
        zzhd<?> zzhdVarZzbh;
        int i2 = this.zzva[i];
        Object objZzq = zzjw.zzq(obj, zzbi(i) & 1048575);
        return (objZzq == null || (zzhdVarZzbh = zzbh(i)) == null) ? ub : (UB) zzb(i, i2, this.zzvr.zzh(objZzq), zzhdVarZzbh, ub, zzjqVar);
    }

    private static void zzb(int i, Object obj, zzkk zzkkVar) throws IOException {
        if (obj instanceof String) {
            zzkkVar.zzb(i, (String) obj);
        } else {
            zzkkVar.zzb(i, (zzfr) obj);
        }
    }

    private static <UT, UB> void zzb(zzjq<UT, UB> zzjqVar, T t, zzkk zzkkVar) throws IOException {
        zzjqVar.zzb(zzjqVar.zzq(t), zzkkVar);
    }

    private final <K, V> void zzb(zzkk zzkkVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzkkVar.zzb(i, this.zzvr.zzm(zzbg(i2)), this.zzvr.zzi(obj));
        }
    }

    private final void zzb(Object obj, int i, zzix zzixVar) throws IOException {
        if (zzbk(i)) {
            zzjw.zzb(obj, i & 1048575, zzixVar.zzbo());
        } else if (this.zzvh) {
            zzjw.zzb(obj, i & 1048575, zzixVar.readString());
        } else {
            zzjw.zzb(obj, i & 1048575, zzixVar.zzbp());
        }
    }

    private final void zzb(T t, T t2, int i) {
        long jZzbi = zzbi(i) & 1048575;
        if (zzb(t2, i)) {
            Object objZzq = zzjw.zzq(t, jZzbi);
            Object objZzq2 = zzjw.zzq(t2, jZzbi);
            if (objZzq != null && objZzq2 != null) {
                zzjw.zzb(t, jZzbi, zzhb.zzb(objZzq, objZzq2));
                zzc(t, i);
            } else if (objZzq2 != null) {
                zzjw.zzb(t, jZzbi, objZzq2);
                zzc(t, i);
            }
        }
    }

    private final boolean zzb(T t, int i) {
        if (!this.zzvi) {
            int iZzbj = zzbj(i);
            return (zzjw.zzl(t, (long) (iZzbj & 1048575)) & (1 << (iZzbj >>> 20))) != 0;
        }
        int iZzbi = zzbi(i);
        long j = iZzbi & 1048575;
        switch ((iZzbi & 267386880) >>> 20) {
            case 0:
                return zzjw.zzp(t, j) != 0.0d;
            case 1:
                return zzjw.zzo(t, j) != 0.0f;
            case 2:
                return zzjw.zzm(t, j) != 0;
            case 3:
                return zzjw.zzm(t, j) != 0;
            case 4:
                return zzjw.zzl(t, j) != 0;
            case 5:
                return zzjw.zzm(t, j) != 0;
            case 6:
                return zzjw.zzl(t, j) != 0;
            case 7:
                return zzjw.zzn(t, j);
            case 8:
                Object objZzq = zzjw.zzq(t, j);
                if (objZzq instanceof String) {
                    return !((String) objZzq).isEmpty();
                }
                if (objZzq instanceof zzfr) {
                    return !zzfr.zznt.equals(objZzq);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzjw.zzq(t, j) != null;
            case 10:
                return !zzfr.zznt.equals(zzjw.zzq(t, j));
            case 11:
                return zzjw.zzl(t, j) != 0;
            case 12:
                return zzjw.zzl(t, j) != 0;
            case 13:
                return zzjw.zzl(t, j) != 0;
            case 14:
                return zzjw.zzm(t, j) != 0;
            case 15:
                return zzjw.zzl(t, j) != 0;
            case 16:
                return zzjw.zzm(t, j) != 0;
            case 17:
                return zzjw.zzq(t, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzb(T t, int i, int i2) {
        return zzjw.zzl(t, (long) (zzbj(i2) & 1048575)) == i;
    }

    private final boolean zzb(T t, int i, int i2, int i3) {
        if (this.zzvi) {
            return zzb(t, i);
        }
        return (i2 & i3) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzb(Object obj, int i, zziy zziyVar) {
        return zziyVar.zzo(zzjw.zzq(obj, 1048575 & i));
    }

    private final zziy zzbf(int i) {
        int i2 = (i / 4) << 1;
        zziy zziyVar = (zziy) this.zzvb[i2];
        if (zziyVar != null) {
            return zziyVar;
        }
        zziy<T> zziyVarZzg = zzis.zzfc().zzg((Class) this.zzvb[i2 + 1]);
        this.zzvb[i2] = zziyVarZzg;
        return zziyVarZzg;
    }

    private final Object zzbg(int i) {
        return this.zzvb[(i / 4) << 1];
    }

    private final zzhd<?> zzbh(int i) {
        return (zzhd) this.zzvb[((i / 4) << 1) + 1];
    }

    private final int zzbi(int i) {
        return this.zzva[i + 1];
    }

    private final int zzbj(int i) {
        return this.zzva[i + 2];
    }

    private static boolean zzbk(int i) {
        return (536870912 & i) != 0;
    }

    private final int zzbl(int i) {
        if (i >= this.zzvc) {
            if (i < this.zzve) {
                int i2 = (i - this.zzvc) << 2;
                if (this.zzva[i2] == i) {
                    return i2;
                }
                return -1;
            }
            if (i <= this.zzvd) {
                int i3 = this.zzve - this.zzvc;
                int length = (this.zzva.length / 4) - 1;
                while (i3 <= length) {
                    int i4 = (length + i3) >>> 1;
                    int i5 = i4 << 2;
                    int i6 = this.zzva[i5];
                    if (i == i6) {
                        return i5;
                    }
                    if (i < i6) {
                        length = i4 - 1;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    private final void zzc(T t, int i) {
        if (this.zzvi) {
            return;
        }
        int iZzbj = zzbj(i);
        long j = iZzbj & 1048575;
        zzjw.zzc(t, j, zzjw.zzl(t, j) | (1 << (iZzbj >>> 20)));
    }

    private final void zzc(T t, int i, int i2) {
        zzjw.zzc(t, zzbj(i2) & 1048575, i);
    }

    private final void zzc(T t, zzkk zzkkVar) throws IOException {
        int i;
        int i2;
        int i3;
        Iterator it = null;
        Map.Entry<?, ?> entry = null;
        if (this.zzvg) {
            zzgq<T> zzgqVarZzb = this.zzvq.zzb(t);
            if (!zzgqVarZzb.isEmpty()) {
                it = zzgqVarZzb.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int i4 = -1;
        int i5 = 0;
        int length = this.zzva.length;
        Unsafe unsafe = zzuz;
        int i6 = 0;
        Map.Entry<?, ?> entry2 = entry;
        while (i6 < length) {
            int iZzbi = zzbi(i6);
            int i7 = this.zzva[i6];
            int i8 = (267386880 & iZzbi) >>> 20;
            if (this.zzvi || i8 > 17) {
                i = 0;
                i2 = i5;
            } else {
                int i9 = this.zzva[i6 + 2];
                int i10 = i9 & 1048575;
                if (i10 != i4) {
                    i3 = unsafe.getInt(t, i10);
                } else {
                    i3 = i5;
                    i10 = i4;
                }
                i = 1 << (i9 >>> 20);
                i2 = i3;
                i4 = i10;
            }
            while (entry2 != null && this.zzvq.zzb(entry2) <= i7) {
                this.zzvq.zzb(zzkkVar, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = 1048575 & iZzbi;
            switch (i8) {
                case 0:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzb(i7, zzjw.zzp(t, j));
                    }
                    break;
                case 1:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzc(i7, zzjw.zzo(t, j));
                    }
                    break;
                case 2:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzj(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 3:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzb(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 4:
                    if ((i2 & i) != 0) {
                        zzkkVar.zze(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 5:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzd(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 6:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzh(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 7:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzc(i7, zzjw.zzn(t, j));
                    }
                    break;
                case 8:
                    if ((i2 & i) != 0) {
                        zzb(i7, unsafe.getObject(t, j), zzkkVar);
                    }
                    break;
                case 9:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzb(i7, unsafe.getObject(t, j), zzbf(i6));
                    }
                    break;
                case 10:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzb(i7, (zzfr) unsafe.getObject(t, j));
                    }
                    break;
                case 11:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzf(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 12:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzp(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 13:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzo(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 14:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzk(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 15:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzg(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 16:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzc(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 17:
                    if ((i2 & i) != 0) {
                        zzkkVar.zzc(i7, unsafe.getObject(t, j), zzbf(i6));
                    }
                    break;
                case 18:
                    zzja.zzb(this.zzva[i6], (List<Double>) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 19:
                    zzja.zzc(this.zzva[i6], (List<Float>) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 20:
                    zzja.zzd(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 21:
                    zzja.zze(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 22:
                    zzja.zzi(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 23:
                    zzja.zzg(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 24:
                    zzja.zzl(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 25:
                    zzja.zzo(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 26:
                    zzja.zzb(this.zzva[i6], (List<String>) unsafe.getObject(t, j), zzkkVar);
                    break;
                case 27:
                    zzja.zzb(this.zzva[i6], (List<?>) unsafe.getObject(t, j), zzkkVar, zzbf(i6));
                    break;
                case 28:
                    zzja.zzc(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar);
                    break;
                case 29:
                    zzja.zzj(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 30:
                    zzja.zzn(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 31:
                    zzja.zzm(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 32:
                    zzja.zzh(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 33:
                    zzja.zzk(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 34:
                    zzja.zzf(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, false);
                    break;
                case 35:
                    zzja.zzb(this.zzva[i6], (List<Double>) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 36:
                    zzja.zzc(this.zzva[i6], (List<Float>) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 37:
                    zzja.zzd(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 38:
                    zzja.zze(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 39:
                    zzja.zzi(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 40:
                    zzja.zzg(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 41:
                    zzja.zzl(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 42:
                    zzja.zzo(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 43:
                    zzja.zzj(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 44:
                    zzja.zzn(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 45:
                    zzja.zzm(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 46:
                    zzja.zzh(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 47:
                    zzja.zzk(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 48:
                    zzja.zzf(this.zzva[i6], (List) unsafe.getObject(t, j), zzkkVar, true);
                    break;
                case 49:
                    zzja.zzc(this.zzva[i6], (List<?>) unsafe.getObject(t, j), zzkkVar, zzbf(i6));
                    break;
                case 50:
                    zzb(zzkkVar, i7, unsafe.getObject(t, j), i6);
                    break;
                case 51:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzb(i7, zzg(t, j));
                    }
                    break;
                case 52:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzc(i7, zzh(t, j));
                    }
                    break;
                case 53:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzj(i7, zzj(t, j));
                    }
                    break;
                case 54:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzb(i7, zzj(t, j));
                    }
                    break;
                case 55:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zze(i7, zzi(t, j));
                    }
                    break;
                case 56:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzd(i7, zzj(t, j));
                    }
                    break;
                case 57:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzh(i7, zzi(t, j));
                    }
                    break;
                case 58:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzc(i7, zzk(t, j));
                    }
                    break;
                case 59:
                    if (zzb(t, i7, i6)) {
                        zzb(i7, unsafe.getObject(t, j), zzkkVar);
                    }
                    break;
                case 60:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzb(i7, unsafe.getObject(t, j), zzbf(i6));
                    }
                    break;
                case 61:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzb(i7, (zzfr) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzf(i7, zzi(t, j));
                    }
                    break;
                case 63:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzp(i7, zzi(t, j));
                    }
                    break;
                case 64:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzo(i7, zzi(t, j));
                    }
                    break;
                case 65:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzk(i7, zzj(t, j));
                    }
                    break;
                case 66:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzg(i7, zzi(t, j));
                    }
                    break;
                case 67:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzc(i7, zzj(t, j));
                    }
                    break;
                case 68:
                    if (zzb(t, i7, i6)) {
                        zzkkVar.zzc(i7, unsafe.getObject(t, j), zzbf(i6));
                    }
                    break;
            }
            i6 += 4;
            i5 = i2;
        }
        Map.Entry<?, ?> entry3 = entry2;
        while (entry3 != null) {
            this.zzvq.zzb(zzkkVar, entry3);
            entry3 = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zzb(this.zzvp, t, zzkkVar);
    }

    private final void zzc(T t, T t2, int i) {
        int iZzbi = zzbi(i);
        int i2 = this.zzva[i];
        long j = iZzbi & 1048575;
        if (zzb(t2, i2, i)) {
            Object objZzq = zzjw.zzq(t, j);
            Object objZzq2 = zzjw.zzq(t2, j);
            if (objZzq != null && objZzq2 != null) {
                zzjw.zzb(t, j, zzhb.zzb(objZzq, objZzq2));
                zzc(t, i2, i);
            } else if (objZzq2 != null) {
                zzjw.zzb(t, j, objZzq2);
                zzc(t, i2, i);
            }
        }
    }

    private final boolean zzd(T t, T t2, int i) {
        return zzb(t, i) == zzb(t2, i);
    }

    private static <E> List<E> zzf(Object obj, long j) {
        return (List) zzjw.zzq(obj, j);
    }

    private static <T> double zzg(T t, long j) {
        return ((Double) zzjw.zzq(t, j)).doubleValue();
    }

    private static <T> float zzh(T t, long j) {
        return ((Float) zzjw.zzq(t, j)).floatValue();
    }

    private static <T> int zzi(T t, long j) {
        return ((Integer) zzjw.zzq(t, j)).intValue();
    }

    private static <T> long zzj(T t, long j) {
        return ((Long) zzjw.zzq(t, j)).longValue();
    }

    private static <T> boolean zzk(T t, long j) {
        return ((Boolean) zzjw.zzq(t, j)).booleanValue();
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final boolean equals(T t, T t2) {
        boolean zZze;
        int length = this.zzva.length;
        for (int i = 0; i < length; i += 4) {
            int iZzbi = zzbi(i);
            long j = iZzbi & 1048575;
            switch ((iZzbi & 267386880) >>> 20) {
                case 0:
                    zZze = zzd(t, t2, i) && zzjw.zzm(t, j) == zzjw.zzm(t2, j);
                    break;
                case 1:
                    zZze = zzd(t, t2, i) && zzjw.zzl(t, j) == zzjw.zzl(t2, j);
                    break;
                case 2:
                    zZze = zzd(t, t2, i) && zzjw.zzm(t, j) == zzjw.zzm(t2, j);
                    break;
                case 3:
                    zZze = zzd(t, t2, i) && zzjw.zzm(t, j) == zzjw.zzm(t2, j);
                    break;
                case 4:
                    zZze = zzd(t, t2, i) && zzjw.zzl(t, j) == zzjw.zzl(t2, j);
                    break;
                case 5:
                    zZze = zzd(t, t2, i) && zzjw.zzm(t, j) == zzjw.zzm(t2, j);
                    break;
                case 6:
                    zZze = zzd(t, t2, i) && zzjw.zzl(t, j) == zzjw.zzl(t2, j);
                    break;
                case 7:
                    zZze = zzd(t, t2, i) && zzjw.zzn(t, j) == zzjw.zzn(t2, j);
                    break;
                case 8:
                    zZze = zzd(t, t2, i) && zzja.zze(zzjw.zzq(t, j), zzjw.zzq(t2, j));
                    break;
                case 9:
                    zZze = zzd(t, t2, i) && zzja.zze(zzjw.zzq(t, j), zzjw.zzq(t2, j));
                    break;
                case 10:
                    zZze = zzd(t, t2, i) && zzja.zze(zzjw.zzq(t, j), zzjw.zzq(t2, j));
                    break;
                case 11:
                    zZze = zzd(t, t2, i) && zzjw.zzl(t, j) == zzjw.zzl(t2, j);
                    break;
                case 12:
                    zZze = zzd(t, t2, i) && zzjw.zzl(t, j) == zzjw.zzl(t2, j);
                    break;
                case 13:
                    zZze = zzd(t, t2, i) && zzjw.zzl(t, j) == zzjw.zzl(t2, j);
                    break;
                case 14:
                    zZze = zzd(t, t2, i) && zzjw.zzm(t, j) == zzjw.zzm(t2, j);
                    break;
                case 15:
                    zZze = zzd(t, t2, i) && zzjw.zzl(t, j) == zzjw.zzl(t2, j);
                    break;
                case 16:
                    zZze = zzd(t, t2, i) && zzjw.zzm(t, j) == zzjw.zzm(t2, j);
                    break;
                case 17:
                    zZze = zzd(t, t2, i) && zzja.zze(zzjw.zzq(t, j), zzjw.zzq(t2, j));
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZze = zzja.zze(zzjw.zzq(t, j), zzjw.zzq(t2, j));
                    break;
                case 50:
                    zZze = zzja.zze(zzjw.zzq(t, j), zzjw.zzq(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    int iZzbj = zzbj(i);
                    zZze = zzjw.zzl(t, iZzbj & 1048575) == zzjw.zzl(t2, iZzbj & 1048575) && zzja.zze(zzjw.zzq(t, j), zzjw.zzq(t2, j));
                    break;
                default:
                    zZze = true;
                    break;
            }
            if (!zZze) {
                return false;
            }
        }
        if (!this.zzvp.zzq(t).equals(this.zzvp.zzq(t2))) {
            return false;
        }
        if (this.zzvg) {
            return this.zzvq.zzb(t).equals(this.zzvq.zzb(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final int hashCode(T t) {
        int length = this.zzva.length;
        int i = 0;
        int iHashCode = 0;
        while (i < length) {
            int iZzbi = zzbi(i);
            int i2 = this.zzva[i];
            long j = 1048575 & iZzbi;
            switch ((iZzbi & 267386880) >>> 20) {
                case 0:
                    iHashCode = (iHashCode * 53) + zzhb.zzo(Double.doubleToLongBits(zzjw.zzp(t, j)));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 1:
                    iHashCode = (iHashCode * 53) + Float.floatToIntBits(zzjw.zzo(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 2:
                    iHashCode = (iHashCode * 53) + zzhb.zzo(zzjw.zzm(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 3:
                    iHashCode = (iHashCode * 53) + zzhb.zzo(zzjw.zzm(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 4:
                    iHashCode = (iHashCode * 53) + zzjw.zzl(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 5:
                    iHashCode = (iHashCode * 53) + zzhb.zzo(zzjw.zzm(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 6:
                    iHashCode = (iHashCode * 53) + zzjw.zzl(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 7:
                    iHashCode = (iHashCode * 53) + zzhb.zzf(zzjw.zzn(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 8:
                    iHashCode = ((String) zzjw.zzq(t, j)).hashCode() + (iHashCode * 53);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 9:
                    Object objZzq = zzjw.zzq(t, j);
                    iHashCode = (objZzq != null ? objZzq.hashCode() : 37) + (iHashCode * 53);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 10:
                    iHashCode = (iHashCode * 53) + zzjw.zzq(t, j).hashCode();
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 11:
                    iHashCode = (iHashCode * 53) + zzjw.zzl(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 12:
                    iHashCode = (iHashCode * 53) + zzjw.zzl(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 13:
                    iHashCode = (iHashCode * 53) + zzjw.zzl(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 14:
                    iHashCode = (iHashCode * 53) + zzhb.zzo(zzjw.zzm(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 15:
                    iHashCode = (iHashCode * 53) + zzjw.zzl(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 16:
                    iHashCode = (iHashCode * 53) + zzhb.zzo(zzjw.zzm(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 17:
                    Object objZzq2 = zzjw.zzq(t, j);
                    iHashCode = (objZzq2 != null ? objZzq2.hashCode() : 37) + (iHashCode * 53);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    iHashCode = (iHashCode * 53) + zzjw.zzq(t, j).hashCode();
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 50:
                    iHashCode = (iHashCode * 53) + zzjw.zzq(t, j).hashCode();
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 51:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzhb.zzo(Double.doubleToLongBits(zzg(t, j)));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 52:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + Float.floatToIntBits(zzh(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 53:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzhb.zzo(zzj(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 54:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzhb.zzo(zzj(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 55:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzi(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 56:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzhb.zzo(zzj(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 57:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzi(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 58:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzhb.zzf(zzk(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 59:
                    if (zzb(t, i2, i)) {
                        iHashCode = ((String) zzjw.zzq(t, j)).hashCode() + (iHashCode * 53);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 60:
                    if (zzb(t, i2, i)) {
                        iHashCode = zzjw.zzq(t, j).hashCode() + (iHashCode * 53);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 61:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzjw.zzq(t, j).hashCode();
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 62:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzi(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 63:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzi(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 64:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzi(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 65:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzhb.zzo(zzj(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 66:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzi(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 67:
                    if (zzb(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzhb.zzo(zzj(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 68:
                    if (zzb(t, i2, i)) {
                        iHashCode = zzjw.zzq(t, j).hashCode() + (iHashCode * 53);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
            }
            i += 4;
            iHashCode = iHashCode;
        }
        int iHashCode2 = (iHashCode * 53) + this.zzvp.zzq(t).hashCode();
        return this.zzvg ? (iHashCode2 * 53) + this.zzvq.zzb(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final T newInstance() {
        return (T) this.zzvn.newInstance(this.zzvf);
    }

    /* JADX WARN: Code duplicated, block: B:176:0x068c  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f4 A[LOOP:5: B:71:0x00f2->B:72:0x00f4, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:70:0x00ee, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.places.zziy
    public final void zzb(T t, zzix zzixVar, zzgl zzglVar) throws IOException {
        int i;
        Object objZzl;
        if (zzglVar == null) {
            throw new NullPointerException();
        }
        zzjq<?, ?> zzjqVar = this.zzvp;
        zzgm<?> zzgmVar = this.zzvq;
        Object objZzb = null;
        zzgq zzgqVarZzc = null;
        while (true) {
            try {
                int iZzbg = zzixVar.zzbg();
                int iZzbl = zzbl(iZzbg);
                if (iZzbl >= 0) {
                    int iZzbi = zzbi(iZzbl);
                    switch ((267386880 & iZzbi) >>> 20) {
                        case 0:
                            zzjw.zzb(t, 1048575 & iZzbi, zzixVar.readDouble());
                            zzc(t, iZzbl);
                            continue;
                        case 1:
                            zzjw.zzb((Object) t, 1048575 & iZzbi, zzixVar.readFloat());
                            zzc(t, iZzbl);
                            continue;
                        case 2:
                            zzjw.zzb((Object) t, 1048575 & iZzbi, zzixVar.zzbj());
                            zzc(t, iZzbl);
                            continue;
                        case 3:
                            zzjw.zzb((Object) t, 1048575 & iZzbi, zzixVar.zzbi());
                            zzc(t, iZzbl);
                            continue;
                        case 4:
                            zzjw.zzc(t, 1048575 & iZzbi, zzixVar.zzbk());
                            zzc(t, iZzbl);
                            continue;
                        case 5:
                            zzjw.zzb((Object) t, 1048575 & iZzbi, zzixVar.zzbl());
                            zzc(t, iZzbl);
                            continue;
                        case 6:
                            zzjw.zzc(t, 1048575 & iZzbi, zzixVar.zzbm());
                            zzc(t, iZzbl);
                            continue;
                        case 7:
                            zzjw.zzb(t, 1048575 & iZzbi, zzixVar.zzbn());
                            zzc(t, iZzbl);
                            continue;
                        case 8:
                            zzb(t, iZzbi, zzixVar);
                            zzc(t, iZzbl);
                            continue;
                        case 9:
                            if (zzb(t, iZzbl)) {
                                zzjw.zzb(t, 1048575 & iZzbi, zzhb.zzb(zzjw.zzq(t, 1048575 & iZzbi), zzixVar.zzb(zzbf(iZzbl), zzglVar)));
                            } else {
                                zzjw.zzb(t, 1048575 & iZzbi, zzixVar.zzb(zzbf(iZzbl), zzglVar));
                                zzc(t, iZzbl);
                                continue;
                            }
                            break;
                        case 10:
                            zzjw.zzb(t, 1048575 & iZzbi, zzixVar.zzbp());
                            zzc(t, iZzbl);
                            continue;
                        case 11:
                            zzjw.zzc(t, 1048575 & iZzbi, zzixVar.zzbq());
                            zzc(t, iZzbl);
                            continue;
                        case 12:
                            int iZzbr = zzixVar.zzbr();
                            zzhd<?> zzhdVarZzbh = zzbh(iZzbl);
                            if (zzhdVarZzbh == null || zzhdVarZzbh.zzi(iZzbr) != null) {
                                zzjw.zzc(t, 1048575 & iZzbi, iZzbr);
                                zzc(t, iZzbl);
                                continue;
                            } else {
                                objZzb = zzja.zzb(iZzbg, iZzbr, objZzb, (zzjq<UT, Object>) zzjqVar);
                            }
                            break;
                        case 13:
                            zzjw.zzc(t, 1048575 & iZzbi, zzixVar.zzbs());
                            zzc(t, iZzbl);
                            continue;
                        case 14:
                            zzjw.zzb((Object) t, 1048575 & iZzbi, zzixVar.zzbt());
                            zzc(t, iZzbl);
                            continue;
                        case 15:
                            zzjw.zzc(t, 1048575 & iZzbi, zzixVar.zzbu());
                            zzc(t, iZzbl);
                            continue;
                        case 16:
                            zzjw.zzb((Object) t, 1048575 & iZzbi, zzixVar.zzbv());
                            zzc(t, iZzbl);
                            continue;
                        case 17:
                            if (zzb(t, iZzbl)) {
                                zzjw.zzb(t, 1048575 & iZzbi, zzhb.zzb(zzjw.zzq(t, 1048575 & iZzbi), zzixVar.zzd(zzbf(iZzbl), zzglVar)));
                            } else {
                                zzjw.zzb(t, 1048575 & iZzbi, zzixVar.zzd(zzbf(iZzbl), zzglVar));
                                zzc(t, iZzbl);
                                continue;
                            }
                            break;
                        case 18:
                            zzixVar.zze(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 19:
                            zzixVar.zzf(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 20:
                            zzixVar.zzh(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 21:
                            zzixVar.zzg(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 22:
                            zzixVar.zzi(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 23:
                            zzixVar.zzj(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 24:
                            zzixVar.zzk(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 25:
                            zzixVar.zzl(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 26:
                            if (zzbk(iZzbi)) {
                                zzixVar.zzm(this.zzvo.zzb(t, 1048575 & iZzbi));
                            } else {
                                zzixVar.readStringList(this.zzvo.zzb(t, 1048575 & iZzbi));
                                continue;
                            }
                            break;
                        case 27:
                            zzixVar.zzb(this.zzvo.zzb(t, 1048575 & iZzbi), zzbf(iZzbl), zzglVar);
                            continue;
                        case 28:
                            zzixVar.zzn(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 29:
                            zzixVar.zzo(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 30:
                            List<Integer> listZzb = this.zzvo.zzb(t, iZzbi & 1048575);
                            zzixVar.zzp(listZzb);
                            objZzb = zzja.zzb(iZzbg, listZzb, zzbh(iZzbl), objZzb, zzjqVar);
                            continue;
                        case 31:
                            zzixVar.zzq(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 32:
                            zzixVar.zzr(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 33:
                            zzixVar.zzs(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 34:
                            zzixVar.zzt(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 35:
                            zzixVar.zze(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 36:
                            zzixVar.zzf(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 37:
                            zzixVar.zzh(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 38:
                            zzixVar.zzg(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 39:
                            zzixVar.zzi(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 40:
                            zzixVar.zzj(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 41:
                            zzixVar.zzk(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 42:
                            zzixVar.zzl(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 43:
                            zzixVar.zzo(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 44:
                            List<Integer> listZzb2 = this.zzvo.zzb(t, iZzbi & 1048575);
                            zzixVar.zzp(listZzb2);
                            objZzb = zzja.zzb(iZzbg, listZzb2, zzbh(iZzbl), objZzb, zzjqVar);
                            continue;
                        case 45:
                            zzixVar.zzq(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 46:
                            zzixVar.zzr(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 47:
                            zzixVar.zzs(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 48:
                            zzixVar.zzt(this.zzvo.zzb(t, 1048575 & iZzbi));
                            continue;
                        case 49:
                            zzixVar.zzc(this.zzvo.zzb(t, 1048575 & iZzbi), zzbf(iZzbl), zzglVar);
                            continue;
                        case 50:
                            Object objZzbg = zzbg(iZzbl);
                            long jZzbi = zzbi(iZzbl) & 1048575;
                            Object objZzq = zzjw.zzq(t, jZzbi);
                            if (objZzq == null) {
                                objZzl = this.zzvr.zzl(objZzbg);
                                zzjw.zzb(t, jZzbi, objZzl);
                            } else if (this.zzvr.zzj(objZzq)) {
                                objZzl = this.zzvr.zzl(objZzbg);
                                this.zzvr.zzc(objZzl, objZzq);
                                zzjw.zzb(t, jZzbi, objZzl);
                            } else {
                                objZzl = objZzq;
                            }
                            zzixVar.zzb(this.zzvr.zzh(objZzl), this.zzvr.zzm(objZzbg), zzglVar);
                            continue;
                        case 51:
                            zzjw.zzb(t, iZzbi & 1048575, Double.valueOf(zzixVar.readDouble()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 52:
                            zzjw.zzb(t, iZzbi & 1048575, Float.valueOf(zzixVar.readFloat()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 53:
                            zzjw.zzb(t, iZzbi & 1048575, Long.valueOf(zzixVar.zzbj()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 54:
                            zzjw.zzb(t, iZzbi & 1048575, Long.valueOf(zzixVar.zzbi()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 55:
                            zzjw.zzb(t, iZzbi & 1048575, Integer.valueOf(zzixVar.zzbk()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 56:
                            zzjw.zzb(t, iZzbi & 1048575, Long.valueOf(zzixVar.zzbl()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 57:
                            zzjw.zzb(t, iZzbi & 1048575, Integer.valueOf(zzixVar.zzbm()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 58:
                            zzjw.zzb(t, iZzbi & 1048575, Boolean.valueOf(zzixVar.zzbn()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 59:
                            zzb(t, iZzbi, zzixVar);
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 60:
                            if (zzb(t, iZzbg, iZzbl)) {
                                zzjw.zzb(t, iZzbi & 1048575, zzhb.zzb(zzjw.zzq(t, 1048575 & iZzbi), zzixVar.zzb(zzbf(iZzbl), zzglVar)));
                            } else {
                                zzjw.zzb(t, iZzbi & 1048575, zzixVar.zzb(zzbf(iZzbl), zzglVar));
                                zzc(t, iZzbl);
                            }
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 61:
                            zzjw.zzb(t, iZzbi & 1048575, zzixVar.zzbp());
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 62:
                            zzjw.zzb(t, iZzbi & 1048575, Integer.valueOf(zzixVar.zzbq()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 63:
                            int iZzbr2 = zzixVar.zzbr();
                            zzhd<?> zzhdVarZzbh2 = zzbh(iZzbl);
                            if (zzhdVarZzbh2 == null || zzhdVarZzbh2.zzi(iZzbr2) != null) {
                                zzjw.zzb(t, iZzbi & 1048575, Integer.valueOf(iZzbr2));
                                zzc(t, iZzbg, iZzbl);
                                continue;
                            } else {
                                objZzb = zzja.zzb(iZzbg, iZzbr2, objZzb, (zzjq<UT, Object>) zzjqVar);
                            }
                            break;
                        case 64:
                            zzjw.zzb(t, iZzbi & 1048575, Integer.valueOf(zzixVar.zzbs()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 65:
                            zzjw.zzb(t, iZzbi & 1048575, Long.valueOf(zzixVar.zzbt()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 66:
                            zzjw.zzb(t, iZzbi & 1048575, Integer.valueOf(zzixVar.zzbu()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 67:
                            zzjw.zzb(t, iZzbi & 1048575, Long.valueOf(zzixVar.zzbv()));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        case 68:
                            zzjw.zzb(t, iZzbi & 1048575, zzixVar.zzd(zzbf(iZzbl), zzglVar));
                            zzc(t, iZzbg, iZzbl);
                            continue;
                        default:
                            if (objZzb == null) {
                                try {
                                    objZzb = zzjqVar.zzgo();
                                } catch (zzhi e) {
                                    zzjqVar.zzb(zzixVar);
                                    if (objZzb == null) {
                                        objZzb = zzjqVar.zzr(t);
                                    }
                                    if (!zzjqVar.zzb((Object) objZzb, zzixVar)) {
                                        if (this.zzvl != null) {
                                            for (int i2 : this.zzvl) {
                                                objZzb = zzb((Object) t, i2, objZzb, (zzjq<UT, Object>) zzjqVar);
                                            }
                                        }
                                        if (objZzb != null) {
                                            zzjqVar.zzg(t, (Object) objZzb);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                break;
                            }
                            if (!zzjqVar.zzb((Object) objZzb, zzixVar)) {
                                if (this.zzvl != null) {
                                    for (int i3 : this.zzvl) {
                                        objZzb = zzb((Object) t, i3, objZzb, (zzjq<UT, Object>) zzjqVar);
                                    }
                                }
                                if (objZzb != null) {
                                    zzjqVar.zzg(t, (Object) objZzb);
                                    return;
                                }
                                return;
                            }
                            break;
                            break;
                    }
                    if (this.zzvl != null) {
                        for (int i4 : this.zzvl) {
                            objZzb = zzb((Object) t, i4, objZzb, (zzjq<UT, Object>) zzjqVar);
                        }
                    }
                    if (objZzb != null) {
                        zzjqVar.zzg(t, (Object) objZzb);
                    }
                    throw th;
                }
                if (iZzbg == Integer.MAX_VALUE) {
                    if (this.zzvl != null) {
                        for (int i5 : this.zzvl) {
                            objZzb = zzb((Object) t, i5, objZzb, (zzjq<UT, Object>) zzjqVar);
                        }
                    }
                    if (objZzb != null) {
                        zzjqVar.zzg(t, (Object) objZzb);
                        return;
                    }
                    return;
                }
                Object objZzb2 = !this.zzvg ? null : zzgmVar.zzb(zzglVar, this.zzvf, iZzbg);
                if (objZzb2 != null) {
                    if (zzgqVarZzc == null) {
                        zzgqVarZzc = zzgmVar.zzc(t);
                    }
                    objZzb = zzgmVar.zzb(zzixVar, objZzb2, zzglVar, zzgqVarZzc, objZzb, zzjqVar);
                } else {
                    zzjqVar.zzb(zzixVar);
                    if (objZzb == null) {
                        objZzb = zzjqVar.zzr(t);
                    }
                    if (!zzjqVar.zzb((Object) objZzb, zzixVar)) {
                        if (this.zzvl != null) {
                            for (int i6 : this.zzvl) {
                                objZzb = zzb((Object) t, i6, objZzb, (zzjq<UT, Object>) zzjqVar);
                            }
                        }
                        if (objZzb != null) {
                            zzjqVar.zzg(t, (Object) objZzb);
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                if (this.zzvl != null) {
                    while (i < r3) {
                        objZzb = zzb((Object) t, i4, objZzb, (zzjq<UT, Object>) zzjqVar);
                    }
                }
                if (objZzb != null) {
                    zzjqVar.zzg(t, (Object) objZzb);
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final void zzb(T t, zzkk zzkkVar) throws IOException {
        if (zzkkVar.zzcv() == zzgz.zzh.zzth) {
            zzb(this.zzvp, t, zzkkVar);
            Iterator itDescendingIterator = null;
            Map.Entry<?, ?> entry = null;
            if (this.zzvg) {
                zzgq<T> zzgqVarZzb = this.zzvq.zzb(t);
                if (!zzgqVarZzb.isEmpty()) {
                    itDescendingIterator = zzgqVarZzb.descendingIterator();
                    entry = (Map.Entry) itDescendingIterator.next();
                }
            }
            int length = this.zzva.length - 4;
            while (length >= 0) {
                int iZzbi = zzbi(length);
                int i = this.zzva[length];
                Map.Entry<?, ?> entry2 = entry;
                while (entry2 != null && this.zzvq.zzb(entry2) > i) {
                    this.zzvq.zzb(zzkkVar, entry2);
                    entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
                }
                switch ((267386880 & iZzbi) >>> 20) {
                    case 0:
                        if (zzb(t, length)) {
                            zzkkVar.zzb(i, zzjw.zzp(t, 1048575 & iZzbi));
                        }
                        break;
                    case 1:
                        if (zzb(t, length)) {
                            zzkkVar.zzc(i, zzjw.zzo(t, 1048575 & iZzbi));
                        }
                        break;
                    case 2:
                        if (zzb(t, length)) {
                            zzkkVar.zzj(i, zzjw.zzm(t, 1048575 & iZzbi));
                        }
                        break;
                    case 3:
                        if (zzb(t, length)) {
                            zzkkVar.zzb(i, zzjw.zzm(t, 1048575 & iZzbi));
                        }
                        break;
                    case 4:
                        if (zzb(t, length)) {
                            zzkkVar.zze(i, zzjw.zzl(t, 1048575 & iZzbi));
                        }
                        break;
                    case 5:
                        if (zzb(t, length)) {
                            zzkkVar.zzd(i, zzjw.zzm(t, 1048575 & iZzbi));
                        }
                        break;
                    case 6:
                        if (zzb(t, length)) {
                            zzkkVar.zzh(i, zzjw.zzl(t, 1048575 & iZzbi));
                        }
                        break;
                    case 7:
                        if (zzb(t, length)) {
                            zzkkVar.zzc(i, zzjw.zzn(t, 1048575 & iZzbi));
                        }
                        break;
                    case 8:
                        if (zzb(t, length)) {
                            zzb(i, zzjw.zzq(t, 1048575 & iZzbi), zzkkVar);
                        }
                        break;
                    case 9:
                        if (zzb(t, length)) {
                            zzkkVar.zzb(i, zzjw.zzq(t, 1048575 & iZzbi), zzbf(length));
                        }
                        break;
                    case 10:
                        if (zzb(t, length)) {
                            zzkkVar.zzb(i, (zzfr) zzjw.zzq(t, 1048575 & iZzbi));
                        }
                        break;
                    case 11:
                        if (zzb(t, length)) {
                            zzkkVar.zzf(i, zzjw.zzl(t, 1048575 & iZzbi));
                        }
                        break;
                    case 12:
                        if (zzb(t, length)) {
                            zzkkVar.zzp(i, zzjw.zzl(t, 1048575 & iZzbi));
                        }
                        break;
                    case 13:
                        if (zzb(t, length)) {
                            zzkkVar.zzo(i, zzjw.zzl(t, 1048575 & iZzbi));
                        }
                        break;
                    case 14:
                        if (zzb(t, length)) {
                            zzkkVar.zzk(i, zzjw.zzm(t, 1048575 & iZzbi));
                        }
                        break;
                    case 15:
                        if (zzb(t, length)) {
                            zzkkVar.zzg(i, zzjw.zzl(t, 1048575 & iZzbi));
                        }
                        break;
                    case 16:
                        if (zzb(t, length)) {
                            zzkkVar.zzc(i, zzjw.zzm(t, 1048575 & iZzbi));
                        }
                        break;
                    case 17:
                        if (zzb(t, length)) {
                            zzkkVar.zzc(i, zzjw.zzq(t, 1048575 & iZzbi), zzbf(length));
                        }
                        break;
                    case 18:
                        zzja.zzb(this.zzva[length], (List<Double>) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 19:
                        zzja.zzc(this.zzva[length], (List<Float>) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 20:
                        zzja.zzd(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 21:
                        zzja.zze(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 22:
                        zzja.zzi(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 23:
                        zzja.zzg(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 24:
                        zzja.zzl(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 25:
                        zzja.zzo(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 26:
                        zzja.zzb(this.zzva[length], (List<String>) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar);
                        break;
                    case 27:
                        zzja.zzb(this.zzva[length], (List<?>) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, zzbf(length));
                        break;
                    case 28:
                        zzja.zzc(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar);
                        break;
                    case 29:
                        zzja.zzj(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 30:
                        zzja.zzn(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 31:
                        zzja.zzm(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 32:
                        zzja.zzh(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 33:
                        zzja.zzk(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 34:
                        zzja.zzf(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, false);
                        break;
                    case 35:
                        zzja.zzb(this.zzva[length], (List<Double>) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 36:
                        zzja.zzc(this.zzva[length], (List<Float>) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 37:
                        zzja.zzd(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 38:
                        zzja.zze(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 39:
                        zzja.zzi(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 40:
                        zzja.zzg(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 41:
                        zzja.zzl(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 42:
                        zzja.zzo(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 43:
                        zzja.zzj(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 44:
                        zzja.zzn(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 45:
                        zzja.zzm(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 46:
                        zzja.zzh(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 47:
                        zzja.zzk(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 48:
                        zzja.zzf(this.zzva[length], (List) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, true);
                        break;
                    case 49:
                        zzja.zzc(this.zzva[length], (List<?>) zzjw.zzq(t, 1048575 & iZzbi), zzkkVar, zzbf(length));
                        break;
                    case 50:
                        zzb(zzkkVar, i, zzjw.zzq(t, 1048575 & iZzbi), length);
                        break;
                    case 51:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzb(i, zzg(t, 1048575 & iZzbi));
                        }
                        break;
                    case 52:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzc(i, zzh(t, 1048575 & iZzbi));
                        }
                        break;
                    case 53:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzj(i, zzj(t, 1048575 & iZzbi));
                        }
                        break;
                    case 54:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzb(i, zzj(t, 1048575 & iZzbi));
                        }
                        break;
                    case 55:
                        if (zzb(t, i, length)) {
                            zzkkVar.zze(i, zzi(t, 1048575 & iZzbi));
                        }
                        break;
                    case 56:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzd(i, zzj(t, 1048575 & iZzbi));
                        }
                        break;
                    case 57:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzh(i, zzi(t, 1048575 & iZzbi));
                        }
                        break;
                    case 58:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzc(i, zzk(t, 1048575 & iZzbi));
                        }
                        break;
                    case 59:
                        if (zzb(t, i, length)) {
                            zzb(i, zzjw.zzq(t, 1048575 & iZzbi), zzkkVar);
                        }
                        break;
                    case 60:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzb(i, zzjw.zzq(t, 1048575 & iZzbi), zzbf(length));
                        }
                        break;
                    case 61:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzb(i, (zzfr) zzjw.zzq(t, 1048575 & iZzbi));
                        }
                        break;
                    case 62:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzf(i, zzi(t, 1048575 & iZzbi));
                        }
                        break;
                    case 63:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzp(i, zzi(t, 1048575 & iZzbi));
                        }
                        break;
                    case 64:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzo(i, zzi(t, 1048575 & iZzbi));
                        }
                        break;
                    case 65:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzk(i, zzj(t, 1048575 & iZzbi));
                        }
                        break;
                    case 66:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzg(i, zzi(t, 1048575 & iZzbi));
                        }
                        break;
                    case 67:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzc(i, zzj(t, 1048575 & iZzbi));
                        }
                        break;
                    case 68:
                        if (zzb(t, i, length)) {
                            zzkkVar.zzc(i, zzjw.zzq(t, 1048575 & iZzbi), zzbf(length));
                        }
                        break;
                }
                length -= 4;
                entry = entry2;
            }
            while (entry != null) {
                this.zzvq.zzb(zzkkVar, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            return;
        }
        if (!this.zzvi) {
            zzc(t, zzkkVar);
            return;
        }
        Iterator it = null;
        Map.Entry<?, ?> entry3 = null;
        if (this.zzvg) {
            zzgq<T> zzgqVarZzb2 = this.zzvq.zzb(t);
            if (!zzgqVarZzb2.isEmpty()) {
                it = zzgqVarZzb2.iterator();
                entry3 = (Map.Entry) it.next();
            }
        }
        int length2 = this.zzva.length;
        int i2 = 0;
        while (i2 < length2) {
            int iZzbi2 = zzbi(i2);
            int i3 = this.zzva[i2];
            Map.Entry<?, ?> entry4 = entry3;
            while (entry4 != null && this.zzvq.zzb(entry4) <= i3) {
                this.zzvq.zzb(zzkkVar, entry4);
                entry4 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch ((267386880 & iZzbi2) >>> 20) {
                case 0:
                    if (zzb(t, i2)) {
                        zzkkVar.zzb(i3, zzjw.zzp(t, 1048575 & iZzbi2));
                    }
                    break;
                case 1:
                    if (zzb(t, i2)) {
                        zzkkVar.zzc(i3, zzjw.zzo(t, 1048575 & iZzbi2));
                    }
                    break;
                case 2:
                    if (zzb(t, i2)) {
                        zzkkVar.zzj(i3, zzjw.zzm(t, 1048575 & iZzbi2));
                    }
                    break;
                case 3:
                    if (zzb(t, i2)) {
                        zzkkVar.zzb(i3, zzjw.zzm(t, 1048575 & iZzbi2));
                    }
                    break;
                case 4:
                    if (zzb(t, i2)) {
                        zzkkVar.zze(i3, zzjw.zzl(t, 1048575 & iZzbi2));
                    }
                    break;
                case 5:
                    if (zzb(t, i2)) {
                        zzkkVar.zzd(i3, zzjw.zzm(t, 1048575 & iZzbi2));
                    }
                    break;
                case 6:
                    if (zzb(t, i2)) {
                        zzkkVar.zzh(i3, zzjw.zzl(t, 1048575 & iZzbi2));
                    }
                    break;
                case 7:
                    if (zzb(t, i2)) {
                        zzkkVar.zzc(i3, zzjw.zzn(t, 1048575 & iZzbi2));
                    }
                    break;
                case 8:
                    if (zzb(t, i2)) {
                        zzb(i3, zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar);
                    }
                    break;
                case 9:
                    if (zzb(t, i2)) {
                        zzkkVar.zzb(i3, zzjw.zzq(t, 1048575 & iZzbi2), zzbf(i2));
                    }
                    break;
                case 10:
                    if (zzb(t, i2)) {
                        zzkkVar.zzb(i3, (zzfr) zzjw.zzq(t, 1048575 & iZzbi2));
                    }
                    break;
                case 11:
                    if (zzb(t, i2)) {
                        zzkkVar.zzf(i3, zzjw.zzl(t, 1048575 & iZzbi2));
                    }
                    break;
                case 12:
                    if (zzb(t, i2)) {
                        zzkkVar.zzp(i3, zzjw.zzl(t, 1048575 & iZzbi2));
                    }
                    break;
                case 13:
                    if (zzb(t, i2)) {
                        zzkkVar.zzo(i3, zzjw.zzl(t, 1048575 & iZzbi2));
                    }
                    break;
                case 14:
                    if (zzb(t, i2)) {
                        zzkkVar.zzk(i3, zzjw.zzm(t, 1048575 & iZzbi2));
                    }
                    break;
                case 15:
                    if (zzb(t, i2)) {
                        zzkkVar.zzg(i3, zzjw.zzl(t, 1048575 & iZzbi2));
                    }
                    break;
                case 16:
                    if (zzb(t, i2)) {
                        zzkkVar.zzc(i3, zzjw.zzm(t, 1048575 & iZzbi2));
                    }
                    break;
                case 17:
                    if (zzb(t, i2)) {
                        zzkkVar.zzc(i3, zzjw.zzq(t, 1048575 & iZzbi2), zzbf(i2));
                    }
                    break;
                case 18:
                    zzja.zzb(this.zzva[i2], (List<Double>) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 19:
                    zzja.zzc(this.zzva[i2], (List<Float>) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 20:
                    zzja.zzd(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 21:
                    zzja.zze(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 22:
                    zzja.zzi(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 23:
                    zzja.zzg(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 24:
                    zzja.zzl(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 25:
                    zzja.zzo(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 26:
                    zzja.zzb(this.zzva[i2], (List<String>) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar);
                    break;
                case 27:
                    zzja.zzb(this.zzva[i2], (List<?>) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, zzbf(i2));
                    break;
                case 28:
                    zzja.zzc(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar);
                    break;
                case 29:
                    zzja.zzj(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 30:
                    zzja.zzn(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 31:
                    zzja.zzm(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 32:
                    zzja.zzh(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 33:
                    zzja.zzk(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 34:
                    zzja.zzf(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, false);
                    break;
                case 35:
                    zzja.zzb(this.zzva[i2], (List<Double>) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 36:
                    zzja.zzc(this.zzva[i2], (List<Float>) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 37:
                    zzja.zzd(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 38:
                    zzja.zze(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 39:
                    zzja.zzi(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 40:
                    zzja.zzg(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 41:
                    zzja.zzl(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 42:
                    zzja.zzo(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 43:
                    zzja.zzj(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 44:
                    zzja.zzn(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 45:
                    zzja.zzm(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 46:
                    zzja.zzh(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 47:
                    zzja.zzk(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 48:
                    zzja.zzf(this.zzva[i2], (List) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, true);
                    break;
                case 49:
                    zzja.zzc(this.zzva[i2], (List<?>) zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar, zzbf(i2));
                    break;
                case 50:
                    zzb(zzkkVar, i3, zzjw.zzq(t, 1048575 & iZzbi2), i2);
                    break;
                case 51:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzb(i3, zzg(t, 1048575 & iZzbi2));
                    }
                    break;
                case 52:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzc(i3, zzh(t, 1048575 & iZzbi2));
                    }
                    break;
                case 53:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzj(i3, zzj(t, 1048575 & iZzbi2));
                    }
                    break;
                case 54:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzb(i3, zzj(t, 1048575 & iZzbi2));
                    }
                    break;
                case 55:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zze(i3, zzi(t, 1048575 & iZzbi2));
                    }
                    break;
                case 56:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzd(i3, zzj(t, 1048575 & iZzbi2));
                    }
                    break;
                case 57:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzh(i3, zzi(t, 1048575 & iZzbi2));
                    }
                    break;
                case 58:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzc(i3, zzk(t, 1048575 & iZzbi2));
                    }
                    break;
                case 59:
                    if (zzb(t, i3, i2)) {
                        zzb(i3, zzjw.zzq(t, 1048575 & iZzbi2), zzkkVar);
                    }
                    break;
                case 60:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzb(i3, zzjw.zzq(t, 1048575 & iZzbi2), zzbf(i2));
                    }
                    break;
                case 61:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzb(i3, (zzfr) zzjw.zzq(t, 1048575 & iZzbi2));
                    }
                    break;
                case 62:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzf(i3, zzi(t, 1048575 & iZzbi2));
                    }
                    break;
                case 63:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzp(i3, zzi(t, 1048575 & iZzbi2));
                    }
                    break;
                case 64:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzo(i3, zzi(t, 1048575 & iZzbi2));
                    }
                    break;
                case 65:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzk(i3, zzj(t, 1048575 & iZzbi2));
                    }
                    break;
                case 66:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzg(i3, zzi(t, 1048575 & iZzbi2));
                    }
                    break;
                case 67:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzc(i3, zzj(t, 1048575 & iZzbi2));
                    }
                    break;
                case 68:
                    if (zzb(t, i3, i2)) {
                        zzkkVar.zzc(i3, zzjw.zzq(t, 1048575 & iZzbi2), zzbf(i2));
                    }
                    break;
            }
            i2 += 4;
            entry3 = entry4;
        }
        while (entry3 != null) {
            this.zzvq.zzb(zzkkVar, entry3);
            entry3 = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zzb(this.zzvp, t, zzkkVar);
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final void zzd(T t) {
        if (this.zzvl != null) {
            for (int i : this.zzvl) {
                long jZzbi = zzbi(i) & 1048575;
                Object objZzq = zzjw.zzq(t, jZzbi);
                if (objZzq != null) {
                    zzjw.zzb(t, jZzbi, this.zzvr.zzk(objZzq));
                }
            }
        }
        if (this.zzvm != null) {
            for (int i2 : this.zzvm) {
                this.zzvo.zzc(t, i2);
            }
        }
        this.zzvp.zzd(t);
        if (this.zzvg) {
            this.zzvq.zzd(t);
        }
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final void zzd(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.zzva.length; i += 4) {
            int iZzbi = zzbi(i);
            long j = 1048575 & iZzbi;
            int i2 = this.zzva[i];
            switch ((iZzbi & 267386880) >>> 20) {
                case 0:
                    if (zzb(t2, i)) {
                        zzjw.zzb(t, j, zzjw.zzp(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 1:
                    if (zzb(t2, i)) {
                        zzjw.zzb((Object) t, j, zzjw.zzo(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 2:
                    if (zzb(t2, i)) {
                        zzjw.zzb((Object) t, j, zzjw.zzm(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 3:
                    if (zzb(t2, i)) {
                        zzjw.zzb((Object) t, j, zzjw.zzm(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 4:
                    if (zzb(t2, i)) {
                        zzjw.zzc(t, j, zzjw.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 5:
                    if (zzb(t2, i)) {
                        zzjw.zzb((Object) t, j, zzjw.zzm(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 6:
                    if (zzb(t2, i)) {
                        zzjw.zzc(t, j, zzjw.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 7:
                    if (zzb(t2, i)) {
                        zzjw.zzb(t, j, zzjw.zzn(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 8:
                    if (zzb(t2, i)) {
                        zzjw.zzb(t, j, zzjw.zzq(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 9:
                    zzb(t, t2, i);
                    break;
                case 10:
                    if (zzb(t2, i)) {
                        zzjw.zzb(t, j, zzjw.zzq(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 11:
                    if (zzb(t2, i)) {
                        zzjw.zzc(t, j, zzjw.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 12:
                    if (zzb(t2, i)) {
                        zzjw.zzc(t, j, zzjw.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 13:
                    if (zzb(t2, i)) {
                        zzjw.zzc(t, j, zzjw.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 14:
                    if (zzb(t2, i)) {
                        zzjw.zzb((Object) t, j, zzjw.zzm(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 15:
                    if (zzb(t2, i)) {
                        zzjw.zzc(t, j, zzjw.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 16:
                    if (zzb(t2, i)) {
                        zzjw.zzb((Object) t, j, zzjw.zzm(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 17:
                    zzb(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzvo.zzb(t, t2, j);
                    break;
                case 50:
                    zzja.zzb(this.zzvr, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzb(t2, i2, i)) {
                        zzjw.zzb(t, j, zzjw.zzq(t2, j));
                        zzc(t, i2, i);
                    }
                    break;
                case 60:
                    zzc(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzb(t2, i2, i)) {
                        zzjw.zzb(t, j, zzjw.zzq(t2, j));
                        zzc(t, i2, i);
                    }
                    break;
                case 68:
                    zzc(t, t2, i);
                    break;
            }
        }
        if (this.zzvi) {
            return;
        }
        zzja.zzb(this.zzvp, t, t2);
        if (this.zzvg) {
            zzja.zzb(this.zzvq, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.places.zziy
    public final int zzn(T t) {
        int i;
        if (this.zzvi) {
            Unsafe unsafe = zzuz;
            int iZzd = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.zzva.length) {
                    return zzb(this.zzvp, t) + iZzd;
                }
                int iZzbi = zzbi(i3);
                int i4 = (267386880 & iZzbi) >>> 20;
                int i5 = this.zzva[i3];
                long j = iZzbi & 1048575;
                int i6 = (i4 < zzgt.DOUBLE_LIST_PACKED.id() || i4 > zzgt.SINT64_LIST_PACKED.id()) ? 0 : this.zzva[i3 + 2] & 1048575;
                switch (i4) {
                    case 0:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzc(i5, 0.0d);
                        }
                        break;
                    case 1:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzd(i5, 0.0f);
                        }
                        break;
                    case 2:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zze(i5, zzjw.zzm(t, j));
                        }
                        break;
                    case 3:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzf(i5, zzjw.zzm(t, j));
                        }
                        break;
                    case 4:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzi(i5, zzjw.zzl(t, j));
                        }
                        break;
                    case 5:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzh(i5, 0L);
                        }
                        break;
                    case 6:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzl(i5, 0);
                        }
                        break;
                    case 7:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzd(i5, true);
                        }
                        break;
                    case 8:
                        if (zzb(t, i3)) {
                            Object objZzq = zzjw.zzq(t, j);
                            iZzd = !(objZzq instanceof zzfr) ? iZzd + zzgf.zzc(i5, (String) objZzq) : iZzd + zzgf.zzd(i5, (zzfr) objZzq);
                        }
                        break;
                    case 9:
                        if (zzb(t, i3)) {
                            iZzd += zzja.zzd(i5, zzjw.zzq(t, j), zzbf(i3));
                        }
                        break;
                    case 10:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzd(i5, (zzfr) zzjw.zzq(t, j));
                        }
                        break;
                    case 11:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzj(i5, zzjw.zzl(t, j));
                        }
                        break;
                    case 12:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzn(i5, zzjw.zzl(t, j));
                        }
                        break;
                    case 13:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzm(i5, 0);
                        }
                        break;
                    case 14:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzi(i5, 0L);
                        }
                        break;
                    case 15:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzk(i5, zzjw.zzl(t, j));
                        }
                        break;
                    case 16:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzg(i5, zzjw.zzm(t, j));
                        }
                        break;
                    case 17:
                        if (zzb(t, i3)) {
                            iZzd += zzgf.zzd(i5, (zzih) zzjw.zzq(t, j), zzbf(i3));
                        }
                        break;
                    case 18:
                        iZzd += zzja.zzx(i5, zzf(t, j), false);
                        break;
                    case 19:
                        iZzd += zzja.zzw(i5, zzf(t, j), false);
                        break;
                    case 20:
                        iZzd += zzja.zzp(i5, zzf(t, j), false);
                        break;
                    case 21:
                        iZzd += zzja.zzq(i5, zzf(t, j), false);
                        break;
                    case 22:
                        iZzd += zzja.zzt(i5, zzf(t, j), false);
                        break;
                    case 23:
                        iZzd += zzja.zzx(i5, zzf(t, j), false);
                        break;
                    case 24:
                        iZzd += zzja.zzw(i5, zzf(t, j), false);
                        break;
                    case 25:
                        iZzd += zzja.zzy(i5, zzf(t, j), false);
                        break;
                    case 26:
                        iZzd += zzja.zze(i5, (List<?>) zzf(t, j));
                        break;
                    case 27:
                        iZzd += zzja.zzd(i5, (List<?>) zzf(t, j), zzbf(i3));
                        break;
                    case 28:
                        iZzd += zzja.zzf(i5, zzf(t, j));
                        break;
                    case 29:
                        iZzd += zzja.zzu(i5, zzf(t, j), false);
                        break;
                    case 30:
                        iZzd += zzja.zzs(i5, zzf(t, j), false);
                        break;
                    case 31:
                        iZzd += zzja.zzw(i5, zzf(t, j), false);
                        break;
                    case 32:
                        iZzd += zzja.zzx(i5, zzf(t, j), false);
                        break;
                    case 33:
                        iZzd += zzja.zzv(i5, zzf(t, j), false);
                        break;
                    case 34:
                        iZzd += zzja.zzr(i5, zzf(t, j), false);
                        break;
                    case 35:
                        int iZzac = zzja.zzac((List) unsafe.getObject(t, j));
                        if (iZzac > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzac);
                            }
                            iZzd += iZzac + zzgf.zzas(i5) + zzgf.zzau(iZzac);
                        }
                        break;
                    case 36:
                        int iZzab = zzja.zzab((List) unsafe.getObject(t, j));
                        if (iZzab > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzab);
                            }
                            iZzd += iZzab + zzgf.zzas(i5) + zzgf.zzau(iZzab);
                        }
                        break;
                    case 37:
                        int iZzu = zzja.zzu((List) unsafe.getObject(t, j));
                        if (iZzu > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzu);
                            }
                            iZzd += iZzu + zzgf.zzas(i5) + zzgf.zzau(iZzu);
                        }
                        break;
                    case 38:
                        int iZzv = zzja.zzv((List) unsafe.getObject(t, j));
                        if (iZzv > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzv);
                            }
                            iZzd += iZzv + zzgf.zzas(i5) + zzgf.zzau(iZzv);
                        }
                        break;
                    case 39:
                        int iZzy = zzja.zzy((List) unsafe.getObject(t, j));
                        if (iZzy > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzy);
                            }
                            iZzd += iZzy + zzgf.zzas(i5) + zzgf.zzau(iZzy);
                        }
                        break;
                    case 40:
                        int iZzac2 = zzja.zzac((List) unsafe.getObject(t, j));
                        if (iZzac2 > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzac2);
                            }
                            iZzd += iZzac2 + zzgf.zzas(i5) + zzgf.zzau(iZzac2);
                        }
                        break;
                    case 41:
                        int iZzab2 = zzja.zzab((List) unsafe.getObject(t, j));
                        if (iZzab2 > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzab2);
                            }
                            iZzd += iZzab2 + zzgf.zzas(i5) + zzgf.zzau(iZzab2);
                        }
                        break;
                    case 42:
                        int iZzad = zzja.zzad((List) unsafe.getObject(t, j));
                        if (iZzad > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzad);
                            }
                            iZzd += iZzad + zzgf.zzas(i5) + zzgf.zzau(iZzad);
                        }
                        break;
                    case 43:
                        int iZzz = zzja.zzz((List) unsafe.getObject(t, j));
                        if (iZzz > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzz);
                            }
                            iZzd += iZzz + zzgf.zzas(i5) + zzgf.zzau(iZzz);
                        }
                        break;
                    case 44:
                        int iZzx = zzja.zzx((List) unsafe.getObject(t, j));
                        if (iZzx > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzx);
                            }
                            iZzd += iZzx + zzgf.zzas(i5) + zzgf.zzau(iZzx);
                        }
                        break;
                    case 45:
                        int iZzab3 = zzja.zzab((List) unsafe.getObject(t, j));
                        if (iZzab3 > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzab3);
                            }
                            iZzd += iZzab3 + zzgf.zzas(i5) + zzgf.zzau(iZzab3);
                        }
                        break;
                    case 46:
                        int iZzac3 = zzja.zzac((List) unsafe.getObject(t, j));
                        if (iZzac3 > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzac3);
                            }
                            iZzd += iZzac3 + zzgf.zzas(i5) + zzgf.zzau(iZzac3);
                        }
                        break;
                    case 47:
                        int iZzaa = zzja.zzaa((List) unsafe.getObject(t, j));
                        if (iZzaa > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzaa);
                            }
                            iZzd += iZzaa + zzgf.zzas(i5) + zzgf.zzau(iZzaa);
                        }
                        break;
                    case 48:
                        int iZzw = zzja.zzw((List) unsafe.getObject(t, j));
                        if (iZzw > 0) {
                            if (this.zzvj) {
                                unsafe.putInt(t, i6, iZzw);
                            }
                            iZzd += iZzw + zzgf.zzas(i5) + zzgf.zzau(iZzw);
                        }
                        break;
                    case 49:
                        iZzd += zzja.zze(i5, zzf(t, j), zzbf(i3));
                        break;
                    case 50:
                        iZzd += this.zzvr.zzc(i5, zzjw.zzq(t, j), zzbg(i3));
                        break;
                    case 51:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzc(i5, 0.0d);
                        }
                        break;
                    case 52:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzd(i5, 0.0f);
                        }
                        break;
                    case 53:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zze(i5, zzj(t, j));
                        }
                        break;
                    case 54:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzf(i5, zzj(t, j));
                        }
                        break;
                    case 55:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzi(i5, zzi(t, j));
                        }
                        break;
                    case 56:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzh(i5, 0L);
                        }
                        break;
                    case 57:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzl(i5, 0);
                        }
                        break;
                    case 58:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzd(i5, true);
                        }
                        break;
                    case 59:
                        if (zzb(t, i5, i3)) {
                            Object objZzq2 = zzjw.zzq(t, j);
                            iZzd = !(objZzq2 instanceof zzfr) ? iZzd + zzgf.zzc(i5, (String) objZzq2) : iZzd + zzgf.zzd(i5, (zzfr) objZzq2);
                        }
                        break;
                    case 60:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzja.zzd(i5, zzjw.zzq(t, j), zzbf(i3));
                        }
                        break;
                    case 61:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzd(i5, (zzfr) zzjw.zzq(t, j));
                        }
                        break;
                    case 62:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzj(i5, zzi(t, j));
                        }
                        break;
                    case 63:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzn(i5, zzi(t, j));
                        }
                        break;
                    case 64:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzm(i5, 0);
                        }
                        break;
                    case 65:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzi(i5, 0L);
                        }
                        break;
                    case 66:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzk(i5, zzi(t, j));
                        }
                        break;
                    case 67:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzg(i5, zzj(t, j));
                        }
                        break;
                    case 68:
                        if (zzb(t, i5, i3)) {
                            iZzd += zzgf.zzd(i5, (zzih) zzjw.zzq(t, j), zzbf(i3));
                        }
                        break;
                }
                i2 = i3 + 4;
            }
        } else {
            int iZzd2 = 0;
            Unsafe unsafe2 = zzuz;
            int i7 = -1;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= this.zzva.length) {
                    int iZzb = zzb(this.zzvp, t) + iZzd2;
                    return this.zzvg ? iZzb + this.zzvq.zzb(t).zzdg() : iZzb;
                }
                int iZzbi2 = zzbi(i10);
                int i11 = this.zzva[i10];
                int i12 = (267386880 & iZzbi2) >>> 20;
                int i13 = 0;
                if (i12 <= 17) {
                    i = this.zzva[i10 + 2];
                    int i14 = 1048575 & i;
                    int i15 = 1 << (i >>> 20);
                    if (i14 != i7) {
                        i8 = unsafe2.getInt(t, i14);
                        i7 = i14;
                    }
                    i13 = i15;
                } else {
                    i = (!this.zzvj || i12 < zzgt.DOUBLE_LIST_PACKED.id() || i12 > zzgt.SINT64_LIST_PACKED.id()) ? 0 : this.zzva[i10 + 2] & 1048575;
                }
                long j2 = 1048575 & iZzbi2;
                switch (i12) {
                    case 0:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzc(i11, 0.0d);
                        }
                        break;
                    case 1:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzd(i11, 0.0f);
                        }
                        break;
                    case 2:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zze(i11, unsafe2.getLong(t, j2));
                        }
                        break;
                    case 3:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzf(i11, unsafe2.getLong(t, j2));
                        }
                        break;
                    case 4:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzi(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 5:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzh(i11, 0L);
                        }
                        break;
                    case 6:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzl(i11, 0);
                        }
                        break;
                    case 7:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzd(i11, true);
                        }
                        break;
                    case 8:
                        if ((i13 & i8) != 0) {
                            Object object = unsafe2.getObject(t, j2);
                            iZzd2 = !(object instanceof zzfr) ? iZzd2 + zzgf.zzc(i11, (String) object) : iZzd2 + zzgf.zzd(i11, (zzfr) object);
                        }
                        break;
                    case 9:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzja.zzd(i11, unsafe2.getObject(t, j2), zzbf(i10));
                        }
                        break;
                    case 10:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzd(i11, (zzfr) unsafe2.getObject(t, j2));
                        }
                        break;
                    case 11:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzj(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 12:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzn(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 13:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzm(i11, 0);
                        }
                        break;
                    case 14:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzi(i11, 0L);
                        }
                        break;
                    case 15:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzk(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 16:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzg(i11, unsafe2.getLong(t, j2));
                        }
                        break;
                    case 17:
                        if ((i13 & i8) != 0) {
                            iZzd2 += zzgf.zzd(i11, (zzih) unsafe2.getObject(t, j2), zzbf(i10));
                        }
                        break;
                    case 18:
                        iZzd2 += zzja.zzx(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 19:
                        iZzd2 += zzja.zzw(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 20:
                        iZzd2 += zzja.zzp(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 21:
                        iZzd2 += zzja.zzq(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 22:
                        iZzd2 += zzja.zzt(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 23:
                        iZzd2 += zzja.zzx(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 24:
                        iZzd2 += zzja.zzw(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 25:
                        iZzd2 += zzja.zzy(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 26:
                        iZzd2 += zzja.zze(i11, (List<?>) unsafe2.getObject(t, j2));
                        break;
                    case 27:
                        iZzd2 += zzja.zzd(i11, (List<?>) unsafe2.getObject(t, j2), zzbf(i10));
                        break;
                    case 28:
                        iZzd2 += zzja.zzf(i11, (List) unsafe2.getObject(t, j2));
                        break;
                    case 29:
                        iZzd2 += zzja.zzu(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 30:
                        iZzd2 += zzja.zzs(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 31:
                        iZzd2 += zzja.zzw(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 32:
                        iZzd2 += zzja.zzx(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 33:
                        iZzd2 += zzja.zzv(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 34:
                        iZzd2 += zzja.zzr(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 35:
                        int iZzac4 = zzja.zzac((List) unsafe2.getObject(t, j2));
                        if (iZzac4 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzac4);
                            }
                            iZzd2 += iZzac4 + zzgf.zzas(i11) + zzgf.zzau(iZzac4);
                        }
                        break;
                    case 36:
                        int iZzab4 = zzja.zzab((List) unsafe2.getObject(t, j2));
                        if (iZzab4 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzab4);
                            }
                            iZzd2 += iZzab4 + zzgf.zzas(i11) + zzgf.zzau(iZzab4);
                        }
                        break;
                    case 37:
                        int iZzu2 = zzja.zzu((List) unsafe2.getObject(t, j2));
                        if (iZzu2 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzu2);
                            }
                            iZzd2 += iZzu2 + zzgf.zzas(i11) + zzgf.zzau(iZzu2);
                        }
                        break;
                    case 38:
                        int iZzv2 = zzja.zzv((List) unsafe2.getObject(t, j2));
                        if (iZzv2 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzv2);
                            }
                            iZzd2 += iZzv2 + zzgf.zzas(i11) + zzgf.zzau(iZzv2);
                        }
                        break;
                    case 39:
                        int iZzy2 = zzja.zzy((List) unsafe2.getObject(t, j2));
                        if (iZzy2 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzy2);
                            }
                            iZzd2 += iZzy2 + zzgf.zzas(i11) + zzgf.zzau(iZzy2);
                        }
                        break;
                    case 40:
                        int iZzac5 = zzja.zzac((List) unsafe2.getObject(t, j2));
                        if (iZzac5 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzac5);
                            }
                            iZzd2 += iZzac5 + zzgf.zzas(i11) + zzgf.zzau(iZzac5);
                        }
                        break;
                    case 41:
                        int iZzab5 = zzja.zzab((List) unsafe2.getObject(t, j2));
                        if (iZzab5 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzab5);
                            }
                            iZzd2 += iZzab5 + zzgf.zzas(i11) + zzgf.zzau(iZzab5);
                        }
                        break;
                    case 42:
                        int iZzad2 = zzja.zzad((List) unsafe2.getObject(t, j2));
                        if (iZzad2 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzad2);
                            }
                            iZzd2 += iZzad2 + zzgf.zzas(i11) + zzgf.zzau(iZzad2);
                        }
                        break;
                    case 43:
                        int iZzz2 = zzja.zzz((List) unsafe2.getObject(t, j2));
                        if (iZzz2 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzz2);
                            }
                            iZzd2 += iZzz2 + zzgf.zzas(i11) + zzgf.zzau(iZzz2);
                        }
                        break;
                    case 44:
                        int iZzx2 = zzja.zzx((List) unsafe2.getObject(t, j2));
                        if (iZzx2 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzx2);
                            }
                            iZzd2 += iZzx2 + zzgf.zzas(i11) + zzgf.zzau(iZzx2);
                        }
                        break;
                    case 45:
                        int iZzab6 = zzja.zzab((List) unsafe2.getObject(t, j2));
                        if (iZzab6 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzab6);
                            }
                            iZzd2 += iZzab6 + zzgf.zzas(i11) + zzgf.zzau(iZzab6);
                        }
                        break;
                    case 46:
                        int iZzac6 = zzja.zzac((List) unsafe2.getObject(t, j2));
                        if (iZzac6 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzac6);
                            }
                            iZzd2 += iZzac6 + zzgf.zzas(i11) + zzgf.zzau(iZzac6);
                        }
                        break;
                    case 47:
                        int iZzaa2 = zzja.zzaa((List) unsafe2.getObject(t, j2));
                        if (iZzaa2 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzaa2);
                            }
                            iZzd2 += iZzaa2 + zzgf.zzas(i11) + zzgf.zzau(iZzaa2);
                        }
                        break;
                    case 48:
                        int iZzw2 = zzja.zzw((List) unsafe2.getObject(t, j2));
                        if (iZzw2 > 0) {
                            if (this.zzvj) {
                                unsafe2.putInt(t, i, iZzw2);
                            }
                            iZzd2 += iZzw2 + zzgf.zzas(i11) + zzgf.zzau(iZzw2);
                        }
                        break;
                    case 49:
                        iZzd2 += zzja.zze(i11, (List) unsafe2.getObject(t, j2), zzbf(i10));
                        break;
                    case 50:
                        iZzd2 += this.zzvr.zzc(i11, unsafe2.getObject(t, j2), zzbg(i10));
                        break;
                    case 51:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzc(i11, 0.0d);
                        }
                        break;
                    case 52:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzd(i11, 0.0f);
                        }
                        break;
                    case 53:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zze(i11, zzj(t, j2));
                        }
                        break;
                    case 54:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzf(i11, zzj(t, j2));
                        }
                        break;
                    case 55:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzi(i11, zzi(t, j2));
                        }
                        break;
                    case 56:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzh(i11, 0L);
                        }
                        break;
                    case 57:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzl(i11, 0);
                        }
                        break;
                    case 58:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzd(i11, true);
                        }
                        break;
                    case 59:
                        if (zzb(t, i11, i10)) {
                            Object object2 = unsafe2.getObject(t, j2);
                            iZzd2 = !(object2 instanceof zzfr) ? iZzd2 + zzgf.zzc(i11, (String) object2) : iZzd2 + zzgf.zzd(i11, (zzfr) object2);
                        }
                        break;
                    case 60:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzja.zzd(i11, unsafe2.getObject(t, j2), zzbf(i10));
                        }
                        break;
                    case 61:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzd(i11, (zzfr) unsafe2.getObject(t, j2));
                        }
                        break;
                    case 62:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzj(i11, zzi(t, j2));
                        }
                        break;
                    case 63:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzn(i11, zzi(t, j2));
                        }
                        break;
                    case 64:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzm(i11, 0);
                        }
                        break;
                    case 65:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzi(i11, 0L);
                        }
                        break;
                    case 66:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzk(i11, zzi(t, j2));
                        }
                        break;
                    case 67:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzg(i11, zzj(t, j2));
                        }
                        break;
                    case 68:
                        if (zzb(t, i11, i10)) {
                            iZzd2 += zzgf.zzd(i11, (zzih) unsafe2.getObject(t, j2), zzbf(i10));
                        }
                        break;
                }
                i9 = i10 + 4;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0108  */
    /* JADX WARN: Code duplicated, block: B:70:0x0120 A[PHI: r0
      0x0120: PHI (r0v12 int) = (r0v11 int), (r0v59 int) binds: [B:11:0x0021, B:13:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31, types: [com.google.android.gms.internal.places.zziy] */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.google.android.gms.internal.places.zziy] */
    @Override // com.google.android.gms.internal.places.zziy
    public final boolean zzo(T t) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        if (this.zzvk == null || this.zzvk.length == 0) {
            return true;
        }
        int i3 = -1;
        int i4 = 0;
        int[] iArr = this.zzvk;
        int length = iArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = iArr[i5];
            int iZzbl = zzbl(i6);
            int iZzbi = zzbi(iZzbl);
            int i7 = 0;
            if (this.zzvi) {
                i = i7;
                i2 = i3;
            } else {
                int i8 = this.zzva[iZzbl + 2];
                i2 = i8 & 1048575;
                i7 = 1 << (i8 >>> 20);
                if (i2 != i3) {
                    i4 = zzuz.getInt(t, i2);
                    i = i7;
                } else {
                    i = i7;
                    i2 = i3;
                }
            }
            if (((268435456 & iZzbi) != 0) && !zzb(t, iZzbl, i4, i)) {
                return false;
            }
            switch ((267386880 & iZzbi) >>> 20) {
                case 9:
                case 17:
                    if (zzb(t, iZzbl, i4, i) && !zzb(t, iZzbi, zzbf(iZzbl))) {
                        return false;
                    }
                    break;
                    break;
                case 27:
                case 49:
                    List list = (List) zzjw.zzq(t, 1048575 & iZzbi);
                    if (list.isEmpty()) {
                        z2 = true;
                    } else {
                        ?? Zzbf = zzbf(iZzbl);
                        int i9 = 0;
                        while (true) {
                            if (i9 >= list.size()) {
                                z2 = true;
                            } else if (Zzbf.zzo(list.get(i9))) {
                                i9++;
                            } else {
                                z2 = false;
                            }
                        }
                    }
                    if (!z2) {
                        return false;
                    }
                    break;
                    break;
                case 50:
                    Map<?, ?> mapZzi = this.zzvr.zzi(zzjw.zzq(t, 1048575 & iZzbi));
                    if (mapZzi.isEmpty()) {
                        z = true;
                    } else {
                        if (this.zzvr.zzm(zzbg(iZzbl)).zzuv.zzgz() == zzkj.MESSAGE) {
                            ?? Zzg = 0;
                            Iterator<?> it = mapZzi.values().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object next = it.next();
                                    if (Zzg == 0) {
                                        Zzg = Zzg;
                                        Zzg = zzis.zzfc().zzg(next.getClass());
                                    }
                                    Zzg = Zzg;
                                    if (!Zzg.zzo(next)) {
                                        z = false;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        } else {
                            z = true;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                    break;
                    break;
                case 60:
                case 68:
                    if (zzb(t, i6, iZzbl) && !zzb(t, iZzbi, zzbf(iZzbl))) {
                        return false;
                    }
                    break;
                    break;
            }
            i5++;
            i3 = i2;
        }
        return !this.zzvg || this.zzvq.zzb(t).isInitialized();
    }
}
