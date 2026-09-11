package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzja {
    private static final Class<?> zzwz = zzge();
    private static final zzjq<?, ?> zzxa = zzg(false);
    private static final zzjq<?, ?> zzxb = zzg(true);
    private static final zzjq<?, ?> zzxc = new zzjs();

    static int zzaa(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzha)) {
            int iZzav = 0;
            for (int i = 0; i < size; i++) {
                iZzav += zzgf.zzav(list.get(i).intValue());
            }
            return iZzav;
        }
        zzha zzhaVar = (zzha) list;
        int iZzav2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzav2 += zzgf.zzav(zzhaVar.getInt(i2));
        }
        return iZzav2;
    }

    static int zzab(List<?> list) {
        return list.size() << 2;
    }

    static int zzac(List<?> list) {
        return list.size() << 3;
    }

    static int zzad(List<?> list) {
        return list.size();
    }

    static <UT, UB> UB zzb(int i, int i2, UB ub, zzjq<UT, UB> zzjqVar) {
        if (ub == null) {
            ub = zzjqVar.zzgo();
        }
        zzjqVar.zzb(ub, i, i2);
        return ub;
    }

    static <UT, UB> UB zzb(int i, List<Integer> list, zzhd<?> zzhdVar, UB ub, zzjq<UT, UB> zzjqVar) {
        Object objZzb;
        int i2;
        if (zzhdVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            objZzb = ub;
            while (i3 < size) {
                int iIntValue = list.get(i3).intValue();
                if (zzhdVar.zzi(iIntValue) != null) {
                    if (i3 != i4) {
                        list.set(i4, Integer.valueOf(iIntValue));
                    }
                    i2 = i4 + 1;
                } else {
                    objZzb = zzb(i, iIntValue, objZzb, zzjqVar);
                    i2 = i4;
                }
                i3++;
                i4 = i2;
            }
            if (i4 != size) {
                list.subList(i4, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (zzhdVar.zzi(iIntValue2) == null) {
                    ub = (UB) zzb(i, iIntValue2, ub, zzjqVar);
                    it.remove();
                }
            }
            objZzb = ub;
        }
        return (UB) objZzb;
    }

    public static void zzb(int i, List<String> list, zzkk zzkkVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzc(i, list);
    }

    public static void zzb(int i, List<?> list, zzkk zzkkVar, zziy zziyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzb(i, list, zziyVar);
    }

    public static void zzb(int i, List<Double> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzh(i, list, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T, FT extends zzgs<FT>> void zzb(zzgm<FT> zzgmVar, T t, T t2) {
        zzgq<T> zzgqVarZzb = zzgmVar.zzb(t2);
        if (zzgqVarZzb.isEmpty()) {
            return;
        }
        zzgmVar.zzc(t).zzb(zzgqVarZzb);
    }

    static <T> void zzb(zzic zzicVar, T t, T t2, long j) {
        zzjw.zzb(t, j, zzicVar.zzc(zzjw.zzq(t, j), zzjw.zzq(t2, j)));
    }

    static <T, UT, UB> void zzb(zzjq<UT, UB> zzjqVar, T t, T t2) {
        zzjqVar.zzf(t, zzjqVar.zzh(zzjqVar.zzq(t), zzjqVar.zzq(t2)));
    }

    public static void zzc(int i, List<zzfr> list, zzkk zzkkVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzd(i, list);
    }

    public static void zzc(int i, List<?> list, zzkk zzkkVar, zziy zziyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzc(i, list, zziyVar);
    }

    public static void zzc(int i, List<Float> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzg(i, list, z);
    }

    static int zzd(int i, Object obj, zziy zziyVar) {
        return obj instanceof zzho ? zzgf.zzb(i, (zzho) obj) : zzgf.zzc(i, (zzih) obj, zziyVar);
    }

    static int zzd(int i, List<?> list, zziy zziyVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzas = zzgf.zzas(i) * size;
        int i2 = 0;
        while (i2 < size) {
            Object obj = list.get(i2);
            i2++;
            iZzas = (obj instanceof zzho ? zzgf.zzb((zzho) obj) : zzgf.zzc((zzih) obj, zziyVar)) + iZzas;
        }
        return iZzas;
    }

    public static void zzd(int i, List<Long> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzd(i, list, z);
    }

    public static boolean zzd(int i, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        return ((((long) i2) - ((long) i)) + 1) + 9 <= ((2 * ((long) i3)) + 3) + ((((long) i3) + 3) * 3);
    }

    static int zze(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzas = zzgf.zzas(i) * size;
        if (!(list instanceof zzhq)) {
            int i2 = 0;
            while (i2 < size) {
                Object obj = list.get(i2);
                i2++;
                iZzas = (obj instanceof zzfr ? zzgf.zzc((zzfr) obj) : zzgf.zzl((String) obj)) + iZzas;
            }
            return iZzas;
        }
        zzhq zzhqVar = (zzhq) list;
        int i3 = 0;
        while (i3 < size) {
            Object raw = zzhqVar.getRaw(i3);
            i3++;
            iZzas = (raw instanceof zzfr ? zzgf.zzc((zzfr) raw) : zzgf.zzl((String) raw)) + iZzas;
        }
        return iZzas;
    }

    static int zze(int i, List<zzih> list, zziy zziyVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzd += zzgf.zzd(i, list.get(i2), zziyVar);
        }
        return iZzd;
    }

    public static void zze(int i, List<Long> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zze(i, list, z);
    }

    static boolean zze(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int zzf(int i, List<zzfr> list) {
        int i2 = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzas = zzgf.zzas(i) * size;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return iZzas;
            }
            iZzas += zzgf.zzc(list.get(i3));
            i2 = i3 + 1;
        }
    }

    public static void zzf(int i, List<Long> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzo(i, list, z);
    }

    private static zzjq<?, ?> zzg(boolean z) {
        try {
            Class<?> clsZzgf = zzgf();
            if (clsZzgf == null) {
                return null;
            }
            return (zzjq) clsZzgf.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable th) {
            return null;
        }
    }

    public static void zzg(int i, List<Long> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzf(i, list, z);
    }

    public static zzjq<?, ?> zzgb() {
        return zzxa;
    }

    public static zzjq<?, ?> zzgc() {
        return zzxb;
    }

    public static zzjq<?, ?> zzgd() {
        return zzxc;
    }

    private static Class<?> zzge() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzgf() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    public static void zzh(int i, List<Long> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzm(i, list, z);
    }

    public static void zzh(Class<?> cls) {
        if (!zzgz.class.isAssignableFrom(cls) && zzwz != null && !zzwz.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzi(int i, List<Integer> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzb(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzk(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzn(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzc(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzl(i, list, z);
    }

    public static void zzn(int i, List<Integer> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzi(i, list, z);
    }

    public static void zzo(int i, List<Boolean> list, zzkk zzkkVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzkkVar.zzj(i, list, z);
    }

    static int zzp(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzu(list) + (list.size() * zzgf.zzas(i));
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzgf.zzas(i)) + zzv(list);
    }

    static int zzr(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzgf.zzas(i)) + zzw(list);
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzgf.zzas(i)) + zzx(list);
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzgf.zzas(i)) + zzy(list);
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzgf.zzas(i)) + zzz(list);
    }

    static int zzu(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhv)) {
            int iZzh = 0;
            for (int i = 0; i < size; i++) {
                iZzh += zzgf.zzh(list.get(i).longValue());
            }
            return iZzh;
        }
        zzhv zzhvVar = (zzhv) list;
        int iZzh2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzh2 += zzgf.zzh(zzhvVar.getLong(i2));
        }
        return iZzh2;
    }

    static int zzv(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzgf.zzas(i)) + zzaa(list);
    }

    static int zzv(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhv)) {
            int iZzi = 0;
            for (int i = 0; i < size; i++) {
                iZzi += zzgf.zzi(list.get(i).longValue());
            }
            return iZzi;
        }
        zzhv zzhvVar = (zzhv) list;
        int iZzi2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzi2 += zzgf.zzi(zzhvVar.getLong(i2));
        }
        return iZzi2;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzgf.zzl(i, 0) * size;
    }

    static int zzw(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhv)) {
            int iZzj = 0;
            for (int i = 0; i < size; i++) {
                iZzj += zzgf.zzj(list.get(i).longValue());
            }
            return iZzj;
        }
        zzhv zzhvVar = (zzhv) list;
        int iZzj2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzj2 += zzgf.zzj(zzhvVar.getLong(i2));
        }
        return iZzj2;
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzh(i, 0L);
    }

    static int zzx(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzha)) {
            int iZzay = 0;
            for (int i = 0; i < size; i++) {
                iZzay += zzgf.zzay(list.get(i).intValue());
            }
            return iZzay;
        }
        zzha zzhaVar = (zzha) list;
        int iZzay2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzay2 += zzgf.zzay(zzhaVar.getInt(i2));
        }
        return iZzay2;
    }

    static int zzy(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzd(i, true);
    }

    static int zzy(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzha)) {
            int iZzat = 0;
            for (int i = 0; i < size; i++) {
                iZzat += zzgf.zzat(list.get(i).intValue());
            }
            return iZzat;
        }
        zzha zzhaVar = (zzha) list;
        int iZzat2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzat2 += zzgf.zzat(zzhaVar.getInt(i2));
        }
        return iZzat2;
    }

    static int zzz(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzha)) {
            int iZzau = 0;
            for (int i = 0; i < size; i++) {
                iZzau += zzgf.zzau(list.get(i).intValue());
            }
            return iZzau;
        }
        zzha zzhaVar = (zzha) list;
        int iZzau2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzau2 += zzgf.zzau(zzhaVar.getInt(i2));
        }
        return iZzau2;
    }
}
