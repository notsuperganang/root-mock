package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbax implements zzbey {
    private final zzbav zzdpv;

    private zzbax(zzbav zzbavVar) {
        this.zzdpv = (zzbav) zzbbq.zza(zzbavVar, "output");
        this.zzdpv.zzdqn = this;
    }

    public static zzbax zza(zzbav zzbavVar) {
        return zzbavVar.zzdqn != null ? zzbavVar.zzdqn : new zzbax(zzbavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(int i, double d) throws IOException {
        this.zzdpv.zza(i, d);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(int i, float f) throws IOException {
        this.zzdpv.zza(i, f);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(int i, long j) throws IOException {
        this.zzdpv.zza(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(int i, zzbah zzbahVar) throws IOException {
        this.zzdpv.zza(i, zzbahVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final <K, V> void zza(int i, zzbcn<K, V> zzbcnVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzdpv.zzl(i, 2);
            this.zzdpv.zzca(zzbcm.zza(zzbcnVar, entry.getKey(), entry.getValue()));
            zzbcm.zza(this.zzdpv, zzbcnVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzbah) {
            this.zzdpv.zzb(i, (zzbah) obj);
        } else {
            this.zzdpv.zza(i, (zzbcu) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(int i, Object obj, zzbdm zzbdmVar) throws IOException {
        this.zzdpv.zza(i, (zzbcu) obj, zzbdmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbcd)) {
            while (i2 < list.size()) {
                this.zzdpv.zzf(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzbcd zzbcdVar = (zzbcd) list;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            Object objZzcp = zzbcdVar.zzcp(i3);
            if (objZzcp instanceof String) {
                this.zzdpv.zzf(i, (String) objZzcp);
            } else {
                this.zzdpv.zza(i, (zzbah) objZzcp);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(int i, List<?> list, zzbdm zzbdmVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzbdmVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzm(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzce = zzbav.zzce(list.get(i4).intValue()) + i3;
            i4++;
            i3 = iZzce;
        }
        this.zzdpv.zzca(i3);
        while (i2 < list.size()) {
            this.zzdpv.zzbz(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final int zzacn() {
        return zzbbo.zze.zzdul;
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzb(int i, long j) throws IOException {
        this.zzdpv.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzb(int i, Object obj, zzbdm zzbdmVar) throws IOException {
        zzbav zzbavVar = this.zzdpv;
        zzbavVar.zzl(i, 3);
        zzbdmVar.zza((zzbcu) obj, zzbavVar.zzdqn);
        zzbavVar.zzl(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzb(int i, List<zzbah> list) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            this.zzdpv.zza(i, list.get(i3));
            i2 = i3 + 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzb(int i, List<?> list, zzbdm zzbdmVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzbdmVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzp(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzch = zzbav.zzch(list.get(i4).intValue()) + i3;
            i4++;
            i3 = iZzch;
        }
        this.zzdpv.zzca(i3);
        while (i2 < list.size()) {
            this.zzdpv.zzcc(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzc(int i, long j) throws IOException {
        this.zzdpv.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzp = zzbav.zzp(list.get(i4).longValue()) + i3;
            i4++;
            i3 = iZzp;
        }
        this.zzdpv.zzca(i3);
        while (i2 < list.size()) {
            this.zzdpv.zzm(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzcm(int i) throws IOException {
        this.zzdpv.zzl(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzcn(int i) throws IOException {
        this.zzdpv.zzl(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzq = zzbav.zzq(list.get(i4).longValue()) + i3;
            i4++;
            i3 = iZzq;
        }
        this.zzdpv.zzca(i3);
        while (i2 < list.size()) {
            this.zzdpv.zzm(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int iZzs = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzs += zzbav.zzs(list.get(i3).longValue());
        }
        this.zzdpv.zzca(iZzs);
        while (i2 < list.size()) {
            this.zzdpv.zzo(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzf(int i, String str) throws IOException {
        this.zzdpv.zzf(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zza(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int iZzc = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzc += zzbav.zzc(list.get(i3).floatValue());
        }
        this.zzdpv.zzca(iZzc);
        while (i2 < list.size()) {
            this.zzdpv.zzb(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzf(int i, boolean z) throws IOException {
        this.zzdpv.zzf(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zza(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzc = zzbav.zzc(list.get(i4).doubleValue()) + i3;
            i4++;
            i3 = iZzc;
        }
        this.zzdpv.zzca(i3);
        while (i2 < list.size()) {
            this.zzdpv.zzb(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzm(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzcj = zzbav.zzcj(list.get(i4).intValue()) + i3;
            i4++;
            i3 = iZzcj;
        }
        this.zzdpv.zzca(i3);
        while (i2 < list.size()) {
            this.zzdpv.zzbz(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzi(int i, long j) throws IOException {
        this.zzdpv.zza(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzf(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int iZzaq = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzaq += zzbav.zzaq(list.get(i3).booleanValue());
        }
        this.zzdpv.zzca(iZzaq);
        while (i2 < list.size()) {
            this.zzdpv.zzap(list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzj(int i, long j) throws IOException {
        this.zzdpv.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzn(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzcf = zzbav.zzcf(list.get(i4).intValue()) + i3;
            i4++;
            i3 = iZzcf;
        }
        this.zzdpv.zzca(i3);
        while (i2 < list.size()) {
            this.zzdpv.zzca(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzp(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int iZzci = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzci += zzbav.zzci(list.get(i3).intValue());
        }
        this.zzdpv.zzca(iZzci);
        while (i2 < list.size()) {
            this.zzdpv.zzcc(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int iZzt = zzbav.zzt(list.get(i4).longValue()) + i3;
            i4++;
            i3 = iZzt;
        }
        this.zzdpv.zzca(i3);
        while (i2 < list.size()) {
            this.zzdpv.zzo(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzm(int i, int i2) throws IOException {
        this.zzdpv.zzm(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzo(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int iZzcg = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzcg += zzbav.zzcg(list.get(i3).intValue());
        }
        this.zzdpv.zzca(iZzcg);
        while (i2 < list.size()) {
            this.zzdpv.zzcb(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzn(int i, int i2) throws IOException {
        this.zzdpv.zzn(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzdpv.zzb(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzdpv.zzl(i, 2);
        int iZzr = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzr += zzbav.zzr(list.get(i3).longValue());
        }
        this.zzdpv.zzca(iZzr);
        while (i2 < list.size()) {
            this.zzdpv.zzn(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzo(int i, int i2) throws IOException {
        this.zzdpv.zzo(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzp(int i, int i2) throws IOException {
        this.zzdpv.zzp(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzw(int i, int i2) throws IOException {
        this.zzdpv.zzp(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzx(int i, int i2) throws IOException {
        this.zzdpv.zzm(i, i2);
    }
}
