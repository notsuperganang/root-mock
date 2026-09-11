package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzgh implements zzkk {
    private final zzgf zznz;

    private zzgh(zzgf zzgfVar) {
        this.zznz = (zzgf) zzhb.zzb(zzgfVar, "output");
        this.zznz.zzop = this;
    }

    public static zzgh zzb(zzgf zzgfVar) {
        return zzgfVar.zzop != null ? zzgfVar.zzop : new zzgh(zzgfVar);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzb(int i, double d) throws IOException {
        this.zznz.zzb(i, d);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzb(int i, long j) throws IOException {
        this.zznz.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzb(int i, zzfr zzfrVar) throws IOException {
        this.zznz.zzb(i, zzfrVar);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final <K, V> void zzb(int i, zzia<K, V> zziaVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zznz.zzd(i, 2);
            this.zznz.zzap(zzhz.zzb(zziaVar, entry.getKey(), entry.getValue()));
            zzhz.zzb(this.zznz, zziaVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzb(int i, Object obj) throws IOException {
        if (obj instanceof zzfr) {
            this.zznz.zzc(i, (zzfr) obj);
        } else {
            this.zznz.zzc(i, (zzih) obj);
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzb(int i, Object obj, zziy zziyVar) throws IOException {
        this.zznz.zzb(i, (zzih) obj, zziyVar);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzb(int i, String str) throws IOException {
        this.zznz.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzb(int i, List<?> list, zziy zziyVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zziyVar);
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zze(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzat = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzat += zzgf.zzat(list.get(i3).intValue());
        }
        this.zznz.zzap(iZzat);
        while (i2 < list.size()) {
            this.zznz.zzao(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzbb(int i) throws IOException {
        this.zznz.zzd(i, 3);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzbc(int i) throws IOException {
        this.zznz.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzc(int i, float f) throws IOException {
        this.zznz.zzc(i, f);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzc(int i, long j) throws IOException {
        this.zznz.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzc(int i, Object obj, zziy zziyVar) throws IOException {
        zzgf zzgfVar = this.zznz;
        zzgfVar.zzd(i, 3);
        zziyVar.zzb((zzih) obj, zzgfVar.zzop);
        zzgfVar.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzc(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhq)) {
            while (i2 < list.size()) {
                this.zznz.zzb(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzhq zzhqVar = (zzhq) list;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            Object raw = zzhqVar.getRaw(i3);
            if (raw instanceof String) {
                this.zznz.zzb(i, (String) raw);
            } else {
                this.zznz.zzb(i, (zzfr) raw);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzc(int i, List<?> list, zziy zziyVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzc(i, list.get(i2), zziyVar);
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzaw = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzaw += zzgf.zzaw(list.get(i3).intValue());
        }
        this.zznz.zzap(iZzaw);
        while (i2 < list.size()) {
            this.zznz.zzar(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzc(int i, boolean z) throws IOException {
        this.zznz.zzc(i, z);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final int zzcv() {
        return zzgz.zzh.zztg;
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzd(int i, long j) throws IOException {
        this.zznz.zzd(i, j);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzd(int i, List<zzfr> list) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            this.zznz.zzb(i, list.get(i3));
            i2 = i3 + 1;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzb(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzh = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzh += zzgf.zzh(list.get(i3).longValue());
        }
        this.zznz.zzap(iZzh);
        while (i2 < list.size()) {
            this.zznz.zze(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zze(int i, int i2) throws IOException {
        this.zznz.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzb(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzi = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzi += zzgf.zzi(list.get(i3).longValue());
        }
        this.zznz.zzap(iZzi);
        while (i2 < list.size()) {
            this.zznz.zze(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzf(int i, int i2) throws IOException {
        this.zznz.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzf(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzd(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzk = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzk += zzgf.zzk(list.get(i3).longValue());
        }
        this.zznz.zzap(iZzk);
        while (i2 < list.size()) {
            this.zznz.zzg(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzg(int i, int i2) throws IOException {
        this.zznz.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzg(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzc(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZze = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZze += zzgf.zze(list.get(i3).floatValue());
        }
        this.zznz.zzap(iZze);
        while (i2 < list.size()) {
            this.zznz.zzd(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzh(int i, int i2) throws IOException {
        this.zznz.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzh(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzb(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzc = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzc += zzgf.zzc(list.get(i3).doubleValue());
        }
        this.zznz.zzap(iZzc);
        while (i2 < list.size()) {
            this.zznz.zzb(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zze(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzay = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzay += zzgf.zzay(list.get(i3).intValue());
        }
        this.zznz.zzap(iZzay);
        while (i2 < list.size()) {
            this.zznz.zzao(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzj(int i, long j) throws IOException {
        this.zznz.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzj(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzc(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZze = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZze += zzgf.zze(list.get(i3).booleanValue());
        }
        this.zznz.zzap(iZze);
        while (i2 < list.size()) {
            this.zznz.zzd(list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzk(int i, long j) throws IOException {
        this.zznz.zzd(i, j);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzf(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzau = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzau += zzgf.zzau(list.get(i3).intValue());
        }
        this.zznz.zzap(iZzau);
        while (i2 < list.size()) {
            this.zznz.zzap(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzl(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzax = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzax += zzgf.zzax(list.get(i3).intValue());
        }
        this.zznz.zzap(iZzax);
        while (i2 < list.size()) {
            this.zznz.zzar(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzm(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzd(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzl = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzl += zzgf.zzl(list.get(i3).longValue());
        }
        this.zznz.zzap(iZzl);
        while (i2 < list.size()) {
            this.zznz.zzg(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzn(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzav = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzav += zzgf.zzav(list.get(i3).intValue());
        }
        this.zznz.zzap(iZzav);
        while (i2 < list.size()) {
            this.zznz.zzaq(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzo(int i, int i2) throws IOException {
        this.zznz.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzo(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznz.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zznz.zzd(i, 2);
        int iZzj = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzj += zzgf.zzj(list.get(i3).longValue());
        }
        this.zznz.zzap(iZzj);
        while (i2 < list.size()) {
            this.zznz.zzf(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzkk
    public final void zzp(int i, int i2) throws IOException {
        this.zznz.zze(i, i2);
    }
}
