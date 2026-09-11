package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzwn {
    private static final Class<?> zzcbp = zzya();
    private static final zzxd<?, ?> zzcbq = zzv(false);
    private static final zzxd<?, ?> zzcbr = zzv(true);
    private static final zzxd<?, ?> zzcbs = new zzxf();

    static <UT, UB> UB zza(int i, int i2, UB ub, zzxd<UT, UB> zzxdVar) {
        if (ub == null) {
            ub = zzxdVar.zzyk();
        }
        zzxdVar.zza(ub, i, i2);
        return ub;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzut zzutVar, UB ub, zzxd<UT, UB> zzxdVar) {
        Object objZza;
        int i2;
        if (zzutVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            objZza = ub;
            while (i4 < size) {
                int iIntValue = list.get(i4).intValue();
                if (zzutVar.zzb(iIntValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(iIntValue));
                    }
                    i2 = i3 + 1;
                } else {
                    objZza = zza(i, iIntValue, objZza, zzxdVar);
                    i2 = i3;
                }
                i4++;
                i3 = i2;
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!zzutVar.zzb(iIntValue2)) {
                    ub = (UB) zza(i, iIntValue2, ub, zzxdVar);
                    it.remove();
                }
            }
            objZza = ub;
        }
        return (UB) objZza;
    }

    public static void zza(int i, List<String> list, zzxy zzxyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zza(i, list);
    }

    public static void zza(int i, List<?> list, zzxy zzxyVar, zzwl zzwlVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zza(i, list, zzwlVar);
    }

    public static void zza(int i, List<Double> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzg(i, list, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T, FT extends zzuh<FT>> void zza(zzuc<FT> zzucVar, T t, T t2) {
        zzuf<T> zzufVarZzw = zzucVar.zzw(t2);
        if (zzufVarZzw.isEmpty()) {
            return;
        }
        zzucVar.zzx(t).zza(zzufVarZzw);
    }

    static <T> void zza(zzvq zzvqVar, T t, T t2, long j) {
        zzxj.zza(t, j, zzvqVar.zzc(zzxj.zzp(t, j), zzxj.zzp(t2, j)));
    }

    static <T, UT, UB> void zza(zzxd<UT, UB> zzxdVar, T t, T t2) {
        zzxdVar.zzf(t, zzxdVar.zzh(zzxdVar.zzal(t), zzxdVar.zzal(t2)));
    }

    static int zzaa(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzvj)) {
            int iZzay = 0;
            for (int i = 0; i < size; i++) {
                iZzay += zztv.zzay(list.get(i).longValue());
            }
            return iZzay;
        }
        zzvj zzvjVar = (zzvj) list;
        int iZzay2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzay2 += zztv.zzay(zzvjVar.getLong(i2));
        }
        return iZzay2;
    }

    static int zzab(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzup)) {
            int iZzbj = 0;
            for (int i = 0; i < size; i++) {
                iZzbj += zztv.zzbj(list.get(i).intValue());
            }
            return iZzbj;
        }
        zzup zzupVar = (zzup) list;
        int iZzbj2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzbj2 += zztv.zzbj(zzupVar.getInt(i2));
        }
        return iZzbj2;
    }

    static int zzac(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzup)) {
            int iZzbe = 0;
            for (int i = 0; i < size; i++) {
                iZzbe += zztv.zzbe(list.get(i).intValue());
            }
            return iZzbe;
        }
        zzup zzupVar = (zzup) list;
        int iZzbe2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzbe2 += zztv.zzbe(zzupVar.getInt(i2));
        }
        return iZzbe2;
    }

    static int zzad(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzup)) {
            int iZzbf = 0;
            for (int i = 0; i < size; i++) {
                iZzbf += zztv.zzbf(list.get(i).intValue());
            }
            return iZzbf;
        }
        zzup zzupVar = (zzup) list;
        int iZzbf2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzbf2 += zztv.zzbf(zzupVar.getInt(i2));
        }
        return iZzbf2;
    }

    static int zzae(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzup)) {
            int iZzbg = 0;
            for (int i = 0; i < size; i++) {
                iZzbg += zztv.zzbg(list.get(i).intValue());
            }
            return iZzbg;
        }
        zzup zzupVar = (zzup) list;
        int iZzbg2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzbg2 += zztv.zzbg(zzupVar.getInt(i2));
        }
        return iZzbg2;
    }

    static int zzaf(List<?> list) {
        return list.size() << 2;
    }

    static int zzag(List<?> list) {
        return list.size() << 3;
    }

    static int zzah(List<?> list) {
        return list.size();
    }

    public static void zzb(int i, List<zzte> list, zzxy zzxyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzb(i, list);
    }

    public static void zzb(int i, List<?> list, zzxy zzxyVar, zzwl zzwlVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzb(i, list, zzwlVar);
    }

    public static void zzb(int i, List<Float> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzf(i, list, z);
    }

    static int zzc(int i, Object obj, zzwl zzwlVar) {
        return obj instanceof zzvc ? zztv.zza(i, (zzvc) obj) : zztv.zzb(i, (zzvv) obj, zzwlVar);
    }

    static int zzc(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzbd = zztv.zzbd(i) * size;
        if (!(list instanceof zzve)) {
            int i2 = 0;
            while (i2 < size) {
                Object obj = list.get(i2);
                i2++;
                iZzbd = (obj instanceof zzte ? zztv.zzb((zzte) obj) : zztv.zzgc((String) obj)) + iZzbd;
            }
            return iZzbd;
        }
        zzve zzveVar = (zzve) list;
        int i3 = 0;
        while (i3 < size) {
            Object objZzbp = zzveVar.zzbp(i3);
            i3++;
            iZzbd = (objZzbp instanceof zzte ? zztv.zzb((zzte) objZzbp) : zztv.zzgc((String) objZzbp)) + iZzbd;
        }
        return iZzbd;
    }

    static int zzc(int i, List<?> list, zzwl zzwlVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzbd = zztv.zzbd(i) * size;
        int i2 = 0;
        while (i2 < size) {
            Object obj = list.get(i2);
            i2++;
            iZzbd = (obj instanceof zzvc ? zztv.zza((zzvc) obj) : zztv.zzb((zzvv) obj, zzwlVar)) + iZzbd;
        }
        return iZzbd;
    }

    public static void zzc(int i, List<Long> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzc(i, list, z);
    }

    static int zzd(int i, List<zzte> list) {
        int i2 = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzbd = size * zztv.zzbd(i);
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return iZzbd;
            }
            iZzbd += zztv.zzb(list.get(i3));
            i2 = i3 + 1;
        }
    }

    static int zzd(int i, List<zzvv> list, zzwl zzwlVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zztv.zzc(i, list.get(i2), zzwlVar);
        }
        return iZzc;
    }

    public static void zzd(int i, List<Long> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzn(i, list, z);
    }

    static boolean zze(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void zzf(int i, List<Long> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzm(i, list, z);
    }

    public static void zzj(Class<?> cls) {
        if (!zzuo.class.isAssignableFrom(cls) && zzcbp != null && !zzcbp.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzk(int i, List<Integer> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzxy zzxyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxyVar.zzi(i, list, z);
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzy(list) + (list.size() * zztv.zzbd(i));
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzz(list);
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzaa(list);
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzab(list);
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzac(list);
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzad(list);
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzae(list);
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zztv.zzk(i, 0) * size;
    }

    private static zzxd<?, ?> zzv(boolean z) {
        try {
            Class<?> clsZzyb = zzyb();
            if (clsZzyb == null) {
                return null;
            }
            return (zzxd) clsZzyb.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable th) {
            return null;
        }
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzg(i, 0L);
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzc(i, true);
    }

    public static zzxd<?, ?> zzxx() {
        return zzcbq;
    }

    public static zzxd<?, ?> zzxy() {
        return zzcbr;
    }

    public static zzxd<?, ?> zzxz() {
        return zzcbs;
    }

    static int zzy(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzvj)) {
            int iZzaw = 0;
            for (int i = 0; i < size; i++) {
                iZzaw += zztv.zzaw(list.get(i).longValue());
            }
            return iZzaw;
        }
        zzvj zzvjVar = (zzvj) list;
        int iZzaw2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzaw2 += zztv.zzaw(zzvjVar.getLong(i2));
        }
        return iZzaw2;
    }

    private static Class<?> zzya() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzyb() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    static int zzz(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzvj)) {
            int iZzax = 0;
            for (int i = 0; i < size; i++) {
                iZzax += zztv.zzax(list.get(i).longValue());
            }
            return iZzax;
        }
        zzvj zzvjVar = (zzvj) list;
        int iZzax2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzax2 += zztv.zzax(zzvjVar.getLong(i2));
        }
        return iZzax2;
    }
}
