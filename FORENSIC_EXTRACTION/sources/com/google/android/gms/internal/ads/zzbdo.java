package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzbdo {
    private static final Class<?> zzdyf = zzafq();
    private static final zzbee<?, ?> zzdyg = zzas(false);
    private static final zzbee<?, ?> zzdyh = zzas(true);
    private static final zzbee<?, ?> zzdyi = new zzbeg();

    static <UT, UB> UB zza(int i, int i2, UB ub, zzbee<UT, UB> zzbeeVar) {
        if (ub == null) {
            ub = zzbeeVar.zzagb();
        }
        zzbeeVar.zza(ub, i, i2);
        return ub;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzbbs<?> zzbbsVar, UB ub, zzbee<UT, UB> zzbeeVar) {
        int i2;
        if (zzbbsVar == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (zzbbsVar.zzq(iIntValue) == null) {
                    ub = (UB) zza(i, iIntValue, ub, zzbeeVar);
                    it.remove();
                }
            }
            return ub;
        }
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        UB ub2 = ub;
        while (i4 < size) {
            int iIntValue2 = list.get(i4).intValue();
            if (zzbbsVar.zzq(iIntValue2) != null) {
                if (i4 != i3) {
                    list.set(i3, Integer.valueOf(iIntValue2));
                }
                i2 = i3 + 1;
            } else {
                ub2 = (UB) zza(i, iIntValue2, ub2, zzbeeVar);
                i2 = i3;
            }
            i4++;
            i3 = i2;
        }
        if (i3 == size) {
            return ub2;
        }
        list.subList(i3, size).clear();
        return ub2;
    }

    public static void zza(int i, List<String> list, zzbey zzbeyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zza(i, list);
    }

    public static void zza(int i, List<?> list, zzbey zzbeyVar, zzbdm zzbdmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zza(i, list, zzbdmVar);
    }

    public static void zza(int i, List<Double> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzg(i, list, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T, FT extends zzbbi<FT>> void zza(zzbbd<FT> zzbbdVar, T t, T t2) {
        zzbbg<T> zzbbgVarZzm = zzbbdVar.zzm(t2);
        if (zzbbgVarZzm.isEmpty()) {
            return;
        }
        zzbbdVar.zzn(t).zza(zzbbgVarZzm);
    }

    static <T> void zza(zzbcp zzbcpVar, T t, T t2, long j) {
        zzbek.zza(t, j, zzbcpVar.zzb(zzbek.zzp(t, j), zzbek.zzp(t2, j)));
    }

    static <T, UT, UB> void zza(zzbee<UT, UB> zzbeeVar, T t, T t2) {
        zzbeeVar.zze(t, zzbeeVar.zzg(zzbeeVar.zzac(t), zzbeeVar.zzac(t2)));
    }

    static int zzaf(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbci)) {
            int iZzp = 0;
            for (int i = 0; i < size; i++) {
                iZzp += zzbav.zzp(list.get(i).longValue());
            }
            return iZzp;
        }
        zzbci zzbciVar = (zzbci) list;
        int iZzp2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzp2 += zzbav.zzp(zzbciVar.getLong(i2));
        }
        return iZzp2;
    }

    public static zzbee<?, ?> zzafn() {
        return zzdyg;
    }

    public static zzbee<?, ?> zzafo() {
        return zzdyh;
    }

    public static zzbee<?, ?> zzafp() {
        return zzdyi;
    }

    private static Class<?> zzafq() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzafr() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    static int zzag(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbci)) {
            int iZzq = 0;
            for (int i = 0; i < size; i++) {
                iZzq += zzbav.zzq(list.get(i).longValue());
            }
            return iZzq;
        }
        zzbci zzbciVar = (zzbci) list;
        int iZzq2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzq2 += zzbav.zzq(zzbciVar.getLong(i2));
        }
        return iZzq2;
    }

    static int zzah(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbci)) {
            int iZzr = 0;
            for (int i = 0; i < size; i++) {
                iZzr += zzbav.zzr(list.get(i).longValue());
            }
            return iZzr;
        }
        zzbci zzbciVar = (zzbci) list;
        int iZzr2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzr2 += zzbav.zzr(zzbciVar.getLong(i2));
        }
        return iZzr2;
    }

    static int zzai(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbbp)) {
            int iZzcj = 0;
            for (int i = 0; i < size; i++) {
                iZzcj += zzbav.zzcj(list.get(i).intValue());
            }
            return iZzcj;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        int iZzcj2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzcj2 += zzbav.zzcj(zzbbpVar.getInt(i2));
        }
        return iZzcj2;
    }

    static int zzaj(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbbp)) {
            int iZzce = 0;
            for (int i = 0; i < size; i++) {
                iZzce += zzbav.zzce(list.get(i).intValue());
            }
            return iZzce;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        int iZzce2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzce2 += zzbav.zzce(zzbbpVar.getInt(i2));
        }
        return iZzce2;
    }

    static int zzak(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbbp)) {
            int iZzcf = 0;
            for (int i = 0; i < size; i++) {
                iZzcf += zzbav.zzcf(list.get(i).intValue());
            }
            return iZzcf;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        int iZzcf2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzcf2 += zzbav.zzcf(zzbbpVar.getInt(i2));
        }
        return iZzcf2;
    }

    static int zzal(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbbp)) {
            int iZzcg = 0;
            for (int i = 0; i < size; i++) {
                iZzcg += zzbav.zzcg(list.get(i).intValue());
            }
            return iZzcg;
        }
        zzbbp zzbbpVar = (zzbbp) list;
        int iZzcg2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzcg2 += zzbav.zzcg(zzbbpVar.getInt(i2));
        }
        return iZzcg2;
    }

    static int zzam(List<?> list) {
        return list.size() << 2;
    }

    static int zzan(List<?> list) {
        return list.size() << 3;
    }

    static int zzao(List<?> list) {
        return list.size();
    }

    private static zzbee<?, ?> zzas(boolean z) {
        try {
            Class<?> clsZzafr = zzafr();
            if (clsZzafr == null) {
                return null;
            }
            return (zzbee) clsZzafr.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable th) {
            return null;
        }
    }

    public static void zzb(int i, List<zzbah> list, zzbey zzbeyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzb(i, list);
    }

    public static void zzb(int i, List<?> list, zzbey zzbeyVar, zzbdm zzbdmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzb(i, list, zzbdmVar);
    }

    public static void zzb(int i, List<Float> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzf(i, list, z);
    }

    static int zzc(int i, Object obj, zzbdm zzbdmVar) {
        return obj instanceof zzbcb ? zzbav.zza(i, (zzbcb) obj) : zzbav.zzb(i, (zzbcu) obj, zzbdmVar);
    }

    static int zzc(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzcd = zzbav.zzcd(i) * size;
        if (!(list instanceof zzbcd)) {
            int i2 = 0;
            while (i2 < size) {
                Object obj = list.get(i2);
                i2++;
                iZzcd = (obj instanceof zzbah ? zzbav.zzao((zzbah) obj) : zzbav.zzeo((String) obj)) + iZzcd;
            }
            return iZzcd;
        }
        zzbcd zzbcdVar = (zzbcd) list;
        int i3 = 0;
        while (i3 < size) {
            Object objZzcp = zzbcdVar.zzcp(i3);
            i3++;
            iZzcd = (objZzcp instanceof zzbah ? zzbav.zzao((zzbah) objZzcp) : zzbav.zzeo((String) objZzcp)) + iZzcd;
        }
        return iZzcd;
    }

    static int zzc(int i, List<?> list, zzbdm zzbdmVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzcd = zzbav.zzcd(i) * size;
        int i2 = 0;
        while (i2 < size) {
            Object obj = list.get(i2);
            i2++;
            iZzcd = (obj instanceof zzbcb ? zzbav.zza((zzbcb) obj) : zzbav.zza((zzbcu) obj, zzbdmVar)) + iZzcd;
        }
        return iZzcd;
    }

    public static void zzc(int i, List<Long> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzc(i, list, z);
    }

    static int zzd(int i, List<zzbah> list) {
        int i2 = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzcd = size * zzbav.zzcd(i);
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return iZzcd;
            }
            iZzcd += zzbav.zzao(list.get(i3));
            i2 = i3 + 1;
        }
    }

    static int zzd(int i, List<zzbcu> list, zzbdm zzbdmVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzbav.zzc(i, list.get(i2), zzbdmVar);
        }
        return iZzc;
    }

    public static void zzd(int i, List<Long> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzd(i, list, z);
    }

    static boolean zzd(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void zze(int i, List<Long> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzn(i, list, z);
    }

    public static boolean zze(int i, int i2, int i3) {
        return i2 < 40 || ((((long) i2) - ((long) i)) + 1) + 9 <= ((2 * ((long) i3)) + 3) + ((((long) i3) + 3) * 3);
    }

    public static void zzf(int i, List<Long> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zze(i, list, z);
    }

    public static void zzf(Class<?> cls) {
        if (!zzbbo.class.isAssignableFrom(cls) && zzdyf != null && !zzdyf.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzg(int i, List<Long> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzbey zzbeyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbeyVar.zzi(i, list, z);
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzaf(list) + (list.size() * zzbav.zzcd(i));
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.zzcd(i)) + zzag(list);
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.zzcd(i)) + zzah(list);
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.zzcd(i)) + zzai(list);
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.zzcd(i)) + zzaj(list);
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.zzcd(i)) + zzak(list);
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.zzcd(i)) + zzal(list);
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzbav.zzt(i, 0) * size;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbav.zzg(i, 0L);
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbav.zzg(i, true);
    }
}
