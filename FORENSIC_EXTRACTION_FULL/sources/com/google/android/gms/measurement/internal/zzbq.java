package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzxz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbq extends zzfm implements zzs {

    @VisibleForTesting
    private static int zzaol = SupportMenu.USER_MASK;

    @VisibleForTesting
    private static int zzaom = 2;
    private final Map<String, Map<String, String>> zzaon;
    private final Map<String, Map<String, Boolean>> zzaoo;
    private final Map<String, Map<String, Boolean>> zzaop;
    private final Map<String, com.google.android.gms.internal.measurement.zzfp> zzaoq;
    private final Map<String, Map<String, Integer>> zzaor;
    private final Map<String, String> zzaos;

    zzbq(zzfn zzfnVar) {
        super(zzfnVar);
        this.zzaon = new ArrayMap();
        this.zzaoo = new ArrayMap();
        this.zzaop = new ArrayMap();
        this.zzaoq = new ArrayMap();
        this.zzaos = new ArrayMap();
        this.zzaor = new ArrayMap();
    }

    @WorkerThread
    private final com.google.android.gms.internal.measurement.zzfp zza(String str, byte[] bArr) {
        if (bArr == null) {
            return new com.google.android.gms.internal.measurement.zzfp();
        }
        zzxz zzxzVarZzj = zzxz.zzj(bArr, 0, bArr.length);
        com.google.android.gms.internal.measurement.zzfp zzfpVar = new com.google.android.gms.internal.measurement.zzfp();
        try {
            zzfpVar.zza(zzxzVarZzj);
            zzgt().zzjo().zze("Parsed config. version, gmp_app_id", zzfpVar.zzawm, zzfpVar.zzafi);
            return zzfpVar;
        } catch (IOException e) {
            zzgt().zzjj().zze("Unable to merge remote config. appId", zzas.zzbw(str), e);
            return new com.google.android.gms.internal.measurement.zzfp();
        }
    }

    private static Map<String, String> zza(com.google.android.gms.internal.measurement.zzfp zzfpVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzfpVar != null && zzfpVar.zzawo != null) {
            for (com.google.android.gms.internal.measurement.zzfq zzfqVar : zzfpVar.zzawo) {
                if (zzfqVar != null) {
                    arrayMap.put(zzfqVar.zzoj, zzfqVar.value);
                }
            }
        }
        return arrayMap;
    }

    private final void zza(String str, com.google.android.gms.internal.measurement.zzfp zzfpVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzfpVar != null && zzfpVar.zzawp != null) {
            for (com.google.android.gms.internal.measurement.zzfo zzfoVar : zzfpVar.zzawp) {
                if (TextUtils.isEmpty(zzfoVar.name)) {
                    zzgt().zzjj().zzby("EventConfig contained null event name");
                } else {
                    String strZzco = zzcu.zzco(zzfoVar.name);
                    if (!TextUtils.isEmpty(strZzco)) {
                        zzfoVar.name = strZzco;
                    }
                    arrayMap.put(zzfoVar.name, zzfoVar.zzawj);
                    arrayMap2.put(zzfoVar.name, zzfoVar.zzawk);
                    if (zzfoVar.zzawl != null) {
                        if (zzfoVar.zzawl.intValue() < zzaom || zzfoVar.zzawl.intValue() > zzaol) {
                            zzgt().zzjj().zze("Invalid sampling rate. Event name, sample rate", zzfoVar.name, zzfoVar.zzawl);
                        } else {
                            arrayMap3.put(zzfoVar.name, zzfoVar.zzawl);
                        }
                    }
                }
            }
        }
        this.zzaoo.put(str, arrayMap);
        this.zzaop.put(str, arrayMap2);
        this.zzaor.put(str, arrayMap3);
    }

    @WorkerThread
    private final void zzcf(String str) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        if (this.zzaoq.get(str) == null) {
            byte[] bArrZzbo = zzjt().zzbo(str);
            if (bArrZzbo != null) {
                com.google.android.gms.internal.measurement.zzfp zzfpVarZza = zza(str, bArrZzbo);
                this.zzaon.put(str, zza(zzfpVarZza));
                zza(str, zzfpVarZza);
                this.zzaoq.put(str, zzfpVarZza);
                this.zzaos.put(str, null);
                return;
            }
            this.zzaon.put(str, null);
            this.zzaoo.put(str, null);
            this.zzaop.put(str, null);
            this.zzaoq.put(str, null);
            this.zzaos.put(str, null);
            this.zzaor.put(str, null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    protected final boolean zza(String str, byte[] bArr, String str2) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzfp zzfpVarZza = zza(str, bArr);
        if (zzfpVarZza == null) {
            return false;
        }
        zza(str, zzfpVarZza);
        this.zzaoq.put(str, zzfpVarZza);
        this.zzaos.put(str, str2);
        this.zzaon.put(str, zza(zzfpVarZza));
        zzm zzmVarZzjs = zzjs();
        com.google.android.gms.internal.measurement.zzfi[] zzfiVarArr = zzfpVarZza.zzawq;
        Preconditions.checkNotNull(zzfiVarArr);
        for (com.google.android.gms.internal.measurement.zzfi zzfiVar : zzfiVarArr) {
            for (com.google.android.gms.internal.measurement.zzfj zzfjVar : zzfiVar.zzavi) {
                String strZzco = zzcu.zzco(zzfjVar.zzavn);
                if (strZzco != null) {
                    zzfjVar.zzavn = strZzco;
                }
                com.google.android.gms.internal.measurement.zzfk[] zzfkVarArr = zzfjVar.zzavo;
                for (com.google.android.gms.internal.measurement.zzfk zzfkVar : zzfkVarArr) {
                    String strZzco2 = zzcv.zzco(zzfkVar.zzavv);
                    if (strZzco2 != null) {
                        zzfkVar.zzavv = strZzco2;
                    }
                }
            }
            for (com.google.android.gms.internal.measurement.zzfm zzfmVar : zzfiVar.zzavh) {
                String strZzco3 = zzcw.zzco(zzfmVar.zzawc);
                if (strZzco3 != null) {
                    zzfmVar.zzawc = strZzco3;
                }
            }
        }
        zzmVarZzjs.zzjt().zza(str, zzfiVarArr);
        try {
            zzfpVarZza.zzawq = null;
            byte[] bArr2 = new byte[zzfpVarZza.zzvx()];
            zzfpVarZza.zza(zzya.zzk(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e) {
            zzgt().zzjj().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzas.zzbw(str), e);
        }
        zzt zztVarZzjt = zzjt();
        Preconditions.checkNotEmpty(str);
        zztVarZzjt.zzaf();
        zztVarZzjt.zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (zztVarZzjt.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zztVarZzjt.zzgt().zzjg().zzg("Failed to update remote config (got 0). appId", zzas.zzbw(str));
            }
        } catch (SQLiteException e2) {
            zztVarZzjt.zzgt().zzjg().zze("Error storing remote config. appId", zzas.zzbw(str), e2);
        }
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @WorkerThread
    protected final com.google.android.gms.internal.measurement.zzfp zzcg(String str) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        zzcf(str);
        return this.zzaoq.get(str);
    }

    @WorkerThread
    protected final String zzch(String str) {
        zzaf();
        return this.zzaos.get(str);
    }

    @WorkerThread
    protected final void zzci(String str) {
        zzaf();
        this.zzaos.put(str, null);
    }

    @WorkerThread
    final void zzcj(String str) {
        zzaf();
        this.zzaoq.remove(str);
    }

    @WorkerThread
    final long zzck(String str) {
        String strZzf = zzf(str, "measurement.account.time_zone_offset_minutes");
        if (!TextUtils.isEmpty(strZzf)) {
            try {
                return Long.parseLong(strZzf);
            } catch (NumberFormatException e) {
                zzgt().zzjj().zze("Unable to parse timezone offset. appId", zzas.zzbw(str), e);
            }
        }
        return 0L;
    }

    final boolean zzcl(String str) {
        return "1".equals(zzf(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzcm(String str) {
        return "1".equals(zzf(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.zzs
    @WorkerThread
    public final String zzf(String str, String str2) {
        zzaf();
        zzcf(str);
        Map<String, String> map = this.zzaon.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfx zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.zzfm
    protected final boolean zzgy() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzfl
    public final /* bridge */ /* synthetic */ zzft zzjr() {
        return super.zzjr();
    }

    @Override // com.google.android.gms.measurement.internal.zzfl
    public final /* bridge */ /* synthetic */ zzm zzjs() {
        return super.zzjs();
    }

    @Override // com.google.android.gms.measurement.internal.zzfl
    public final /* bridge */ /* synthetic */ zzt zzjt() {
        return super.zzjt();
    }

    @WorkerThread
    final boolean zzo(String str, String str2) {
        Boolean bool;
        zzaf();
        zzcf(str);
        if (zzcl(str) && zzfx.zzcy(str2)) {
            return true;
        }
        if (zzcm(str) && zzfx.zzct(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzaoo.get(str);
        if (map != null && (bool = map.get(str2)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @WorkerThread
    final boolean zzp(String str, String str2) {
        Boolean bool;
        zzaf();
        zzcf(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzaop.get(str);
        if (map != null && (bool = map.get(str2)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @WorkerThread
    final int zzq(String str, String str2) {
        Integer num;
        zzaf();
        zzcf(str);
        Map<String, Integer> map = this.zzaor.get(str);
        if (map != null && (num = map.get(str2)) != null) {
            return num.intValue();
        }
        return 1;
    }
}
