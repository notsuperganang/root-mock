package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzuo;
import com.google.android.gms.internal.measurement.zzya;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzdv extends zzfm {
    public zzdv(zzfn zzfnVar) {
        super(zzfnVar);
    }

    private static String zzr(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @WorkerThread
    public final byte[] zzb(@NonNull zzag zzagVar, @Size(min = 1) String str) {
        long j;
        zzac zzacVarZzae;
        zzfw next;
        zzaf();
        this.zzada.zzgf();
        Preconditions.checkNotNull(zzagVar);
        Preconditions.checkNotEmpty(str);
        if (!zzgv().zze(str, zzai.zzalh)) {
            zzgt().zzjn().zzg("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzagVar.name) && !"_iapx".equals(zzagVar.name)) {
            zzgt().zzjn().zze("Generating a payload for this event is not available. package_name, event_name", str, zzagVar.name);
            return null;
        }
        com.google.android.gms.internal.measurement.zzfv zzfvVar = new com.google.android.gms.internal.measurement.zzfv();
        zzjt().beginTransaction();
        try {
            zzg zzgVarZzbm = zzjt().zzbm(str);
            if (zzgVarZzbm == null) {
                zzgt().zzjn().zzg("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!zzgVarZzbm.isMeasurementEnabled()) {
                zzgt().zzjn().zzg("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            com.google.android.gms.internal.measurement.zzfw zzfwVar = new com.google.android.gms.internal.measurement.zzfw();
            zzfvVar.zzaxh = new com.google.android.gms.internal.measurement.zzfw[]{zzfwVar};
            zzfwVar.zzaxj = 1;
            zzfwVar.zzaxr = "android";
            zzfwVar.zztt = zzgVarZzbm.zzal();
            zzfwVar.zzafp = zzgVarZzbm.zzhg();
            zzfwVar.zzts = zzgVarZzbm.zzak();
            long jZzhf = zzgVarZzbm.zzhf();
            zzfwVar.zzayd = jZzhf == -2147483648L ? null : Integer.valueOf((int) jZzhf);
            zzfwVar.zzaxv = Long.valueOf(zzgVarZzbm.zzhh());
            zzfwVar.zzafi = zzgVarZzbm.getGmpAppId();
            if (TextUtils.isEmpty(zzfwVar.zzafi)) {
                zzfwVar.zzawr = zzgVarZzbm.zzhb();
            }
            zzfwVar.zzaxz = Long.valueOf(zzgVarZzbm.zzhi());
            if (this.zzada.isEnabled() && zzq.zzie() && zzgv().zzas(zzfwVar.zztt)) {
                zzfwVar.zzayj = null;
            }
            Pair<String, Boolean> pairZzbz = zzgu().zzbz(zzgVarZzbm.zzal());
            if (zzgVarZzbm.zzhw() && pairZzbz != null && !TextUtils.isEmpty((CharSequence) pairZzbz.first)) {
                zzfwVar.zzaxx = zzr((String) pairZzbz.first, Long.toString(zzagVar.zzaig));
                zzfwVar.zzaxy = (Boolean) pairZzbz.second;
            }
            zzgp().zzcl();
            zzfwVar.zzaxt = Build.MODEL;
            zzgp().zzcl();
            zzfwVar.zzaxs = Build.VERSION.RELEASE;
            zzfwVar.zzaxu = Integer.valueOf((int) zzgp().zziw());
            zzfwVar.zzahr = zzgp().zzix();
            zzfwVar.zzafh = zzr(zzgVarZzbm.getAppInstanceId(), Long.toString(zzagVar.zzaig));
            zzfwVar.zzafk = zzgVarZzbm.getFirebaseInstanceId();
            String str2 = zzfwVar.zztt;
            List<zzfw> listZzbl = zzjt().zzbl(str2);
            if (zzgv().zzau(str)) {
                Iterator<zzfw> it = listZzbl.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!"_lte".equals(next.name));
                if (next == null || next.value == null) {
                    zzfw zzfwVar2 = new zzfw(str2, "auto", "_lte", zzbx().currentTimeMillis(), 0L);
                    listZzbl.add(zzfwVar2);
                    zzjt().zza(zzfwVar2);
                }
            }
            com.google.android.gms.internal.measurement.zzfz[] zzfzVarArr = new com.google.android.gms.internal.measurement.zzfz[listZzbl.size()];
            for (int i = 0; i < listZzbl.size(); i++) {
                com.google.android.gms.internal.measurement.zzfz zzfzVar = new com.google.android.gms.internal.measurement.zzfz();
                zzfzVarArr[i] = zzfzVar;
                zzfzVar.name = listZzbl.get(i).name;
                zzfzVar.zzayw = Long.valueOf(listZzbl.get(i).zzaum);
                zzjr().zza(zzfzVar, listZzbl.get(i).value);
            }
            zzfwVar.zzaxl = zzfzVarArr;
            Bundle bundleZziy = zzagVar.zzahu.zziy();
            bundleZziy.putLong("_c", 1L);
            zzgt().zzjn().zzby("Marking in-app purchase as real-time");
            bundleZziy.putLong("_r", 1L);
            bundleZziy.putString("_o", zzagVar.origin);
            if (zzgr().zzcz(zzfwVar.zztt)) {
                zzgr().zza(bundleZziy, "_dbg", (Object) 1L);
                zzgr().zza(bundleZziy, "_r", (Object) 1L);
            }
            zzac zzacVarZzg = zzjt().zzg(str, zzagVar.name);
            if (zzacVarZzg == null) {
                j = 0;
                zzacVarZzae = new zzac(str, zzagVar.name, 0L, 0L, zzagVar.zzaig, 0L, null, null, null, null);
            } else {
                j = zzacVarZzg.zzahx;
                zzacVarZzae = zzacVarZzg.zzae(zzagVar.zzaig);
            }
            zzjt().zza(zzacVarZzae);
            zzab zzabVar = new zzab(this.zzada, zzagVar.origin, str, zzagVar.name, zzagVar.zzaig, j, bundleZziy);
            com.google.android.gms.internal.measurement.zzft zzftVar = new com.google.android.gms.internal.measurement.zzft();
            zzfwVar.zzaxk = new com.google.android.gms.internal.measurement.zzft[]{zzftVar};
            zzftVar.zzaxd = Long.valueOf(zzabVar.timestamp);
            zzftVar.name = zzabVar.name;
            zzftVar.zzaxe = Long.valueOf(zzabVar.zzaht);
            zzftVar.zzaxc = new com.google.android.gms.internal.measurement.zzfu[zzabVar.zzahu.size()];
            int i2 = 0;
            for (String str3 : zzabVar.zzahu) {
                com.google.android.gms.internal.measurement.zzfu zzfuVar = new com.google.android.gms.internal.measurement.zzfu();
                zzftVar.zzaxc[i2] = zzfuVar;
                zzfuVar.name = str3;
                zzjr().zza(zzfuVar, zzabVar.zzahu.get(str3));
                i2++;
            }
            zzfwVar.zzaym = (com.google.android.gms.internal.measurement.zzfe.zzb) ((zzuo) com.google.android.gms.internal.measurement.zzfe.zzb.zzmp().zzb((com.google.android.gms.internal.measurement.zzfe.zza) ((zzuo) com.google.android.gms.internal.measurement.zzfe.zza.zzmn().zzan(zzacVarZzae.zzahv).zzda(zzagVar.name).zzwo())).zzwo());
            zzfwVar.zzayc = zzjs().zza(zzgVarZzbm.zzal(), (com.google.android.gms.internal.measurement.zzft[]) null, zzfwVar.zzaxl);
            zzfwVar.zzaxn = zzftVar.zzaxd;
            zzfwVar.zzaxo = zzftVar.zzaxd;
            long jZzhe = zzgVarZzbm.zzhe();
            zzfwVar.zzaxq = jZzhe != 0 ? Long.valueOf(jZzhe) : null;
            long jZzhd = zzgVarZzbm.zzhd();
            if (jZzhd == 0) {
                jZzhd = jZzhe;
            }
            zzfwVar.zzaxp = jZzhd != 0 ? Long.valueOf(jZzhd) : null;
            zzgVarZzbm.zzhm();
            zzfwVar.zzaya = Integer.valueOf((int) zzgVarZzbm.zzhj());
            zzfwVar.zzaxw = Long.valueOf(zzgv().zzhh());
            zzfwVar.zzaxm = Long.valueOf(zzbx().currentTimeMillis());
            zzfwVar.zzayb = Boolean.TRUE;
            zzgVarZzbm.zzo(zzfwVar.zzaxn.longValue());
            zzgVarZzbm.zzp(zzfwVar.zzaxo.longValue());
            zzjt().zza(zzgVarZzbm);
            zzjt().setTransactionSuccessful();
            try {
                byte[] bArr = new byte[zzfvVar.zzvx()];
                zzya zzyaVarZzk = zzya.zzk(bArr, 0, bArr.length);
                zzfvVar.zza(zzyaVarZzk);
                zzyaVarZzk.zzza();
                return zzjr().zzb(bArr);
            } catch (IOException e) {
                zzgt().zzjg().zze("Data loss. Failed to bundle and serialize. appId", zzas.zzbw(str), e);
                return null;
            }
        } catch (SecurityException e2) {
            zzgt().zzjn().zzg("app instance id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            zzgt().zzjn().zzg("Resettable device id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            zzjt().endTransaction();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfm
    protected final boolean zzgy() {
        return false;
    }
}
