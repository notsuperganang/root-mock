package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zztx implements zzxy {
    private final zztv zzbty;

    private zztx(zztv zztvVar) {
        this.zzbty = (zztv) zzuq.zza(zztvVar, "output");
        this.zzbty.zzbup = this;
    }

    public static zztx zza(zztv zztvVar) {
        return zztvVar.zzbup != null ? zztvVar.zzbup : new zztx(zztvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, double d) throws IOException {
        this.zzbty.zza(i, d);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, float f) throws IOException {
        this.zzbty.zza(i, f);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, long j) throws IOException {
        this.zzbty.zza(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, zzte zzteVar) throws IOException {
        this.zzbty.zza(i, zzteVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final <K, V> void zza(int i, zzvo<K, V> zzvoVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzbty.zzc(i, 2);
            this.zzbty.zzba(zzvn.zza(zzvoVar, entry.getKey(), entry.getValue()));
            zzvn.zza(this.zzbty, zzvoVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzte) {
            this.zzbty.zzb(i, (zzte) obj);
        } else {
            this.zzbty.zzb(i, (zzvv) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, Object obj, zzwl zzwlVar) throws IOException {
        this.zzbty.zza(i, (zzvv) obj, zzwlVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzve)) {
            while (i2 < list.size()) {
                this.zzbty.zzb(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzve zzveVar = (zzve) list;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            Object objZzbp = zzveVar.zzbp(i3);
            if (objZzbp instanceof String) {
                this.zzbty.zzb(i, (String) objZzbp);
            } else {
                this.zzbty.zza(i, (zzte) objZzbp);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, List<?> list, zzwl zzwlVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzwlVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zzd(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int iZzbe = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzbe += zztv.zzbe(list.get(i3).intValue());
        }
        this.zzbty.zzba(iZzbe);
        while (i2 < list.size()) {
            this.zzbty.zzaz(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, long j) throws IOException {
        this.zzbty.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, Object obj, zzwl zzwlVar) throws IOException {
        zztv zztvVar = this.zzbty;
        zztvVar.zzc(i, 3);
        zzwlVar.zza((zzvv) obj, zztvVar.zzbup);
        zztvVar.zzc(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, String str) throws IOException {
        this.zzbty.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, List<zzte> list) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            this.zzbty.zza(i, list.get(i3));
            i2 = i3 + 1;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, List<?> list, zzwl zzwlVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzwlVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzbh = zztv.zzbh(list.get(i4).intValue()) + i3;
            i4++;
            i3 = iZzbh;
        }
        this.zzbty.zzba(i3);
        while (i2 < list.size()) {
            this.zzbty.zzbc(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, boolean z) throws IOException {
        this.zzbty.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzbm(int i) throws IOException {
        this.zzbty.zzc(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzbn(int i) throws IOException {
        this.zzbty.zzc(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzc(int i, long j) throws IOException {
        this.zzbty.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int iZzaw = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzaw += zztv.zzaw(list.get(i3).longValue());
        }
        this.zzbty.zzba(iZzaw);
        while (i2 < list.size()) {
            this.zzbty.zzat(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzd(int i, int i2) throws IOException {
        this.zzbty.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzax = zztv.zzax(list.get(i4).longValue()) + i3;
            i4++;
            i3 = iZzax;
        }
        this.zzbty.zzba(i3);
        while (i2 < list.size()) {
            this.zzbty.zzat(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zze(int i, int i2) throws IOException {
        this.zzbty.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int iZzaz = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzaz += zztv.zzaz(list.get(i3).longValue());
        }
        this.zzbty.zzba(iZzaz);
        while (i2 < list.size()) {
            this.zzbty.zzav(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzf(int i, int i2) throws IOException {
        this.zzbty.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zza(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzb = zztv.zzb(list.get(i4).floatValue()) + i3;
            i4++;
            i3 = iZzb;
        }
        this.zzbty.zzba(i3);
        while (i2 < list.size()) {
            this.zzbty.zza(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzg(int i, int i2) throws IOException {
        this.zzbty.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zza(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int iZzc = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzc += zztv.zzc(list.get(i3).doubleValue());
        }
        this.zzbty.zzba(iZzc);
        while (i2 < list.size()) {
            this.zzbty.zzb(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zzd(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzbj = zztv.zzbj(list.get(i4).intValue()) + i3;
            i4++;
            i3 = iZzbj;
        }
        this.zzbty.zzba(i3);
        while (i2 < list.size()) {
            this.zzbty.zzaz(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzi(int i, long j) throws IOException {
        this.zzbty.zza(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zzb(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzt = zztv.zzt(list.get(i4).booleanValue()) + i3;
            i4++;
            i3 = iZzt;
        }
        this.zzbty.zzba(i3);
        while (i2 < list.size()) {
            this.zzbty.zzs(list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzj(int i, long j) throws IOException {
        this.zzbty.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zze(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int iZzbf = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzbf += zztv.zzbf(list.get(i3).intValue());
        }
        this.zzbty.zzba(iZzbf);
        while (i2 < list.size()) {
            this.zzbty.zzba(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int iZzbi = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzbi += zztv.zzbi(list.get(i3).intValue());
        }
        this.zzbty.zzba(iZzbi);
        while (i2 < list.size()) {
            this.zzbty.zzbc(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int iZzba = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzba += zztv.zzba(list.get(i3).longValue());
        }
        this.zzbty.zzba(iZzba);
        while (i2 < list.size()) {
            this.zzbty.zzav(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zzf(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int iZzbg = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzbg += zztv.zzbg(list.get(i3).intValue());
        }
        this.zzbty.zzba(iZzbg);
        while (i2 < list.size()) {
            this.zzbty.zzbb(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzn(int i, int i2) throws IOException {
        this.zzbty.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzbty.zzb(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzbty.zzc(i, 2);
        int iZzay = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzay += zztv.zzay(list.get(i3).longValue());
        }
        this.zzbty.zzba(iZzay);
        while (i2 < list.size()) {
            this.zzbty.zzau(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzo(int i, int i2) throws IOException {
        this.zzbty.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final int zzvm() {
        return zzuo.zze.zzbyx;
    }
}
