package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends zzcr {
    private Boolean zzagw;

    @NonNull
    private zzs zzagx;
    private Boolean zzyk;

    zzq(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzagx = zzr.zzagy;
        zzai.zza(zzbwVar);
    }

    static String zzhy() {
        return zzai.zzaiu.get();
    }

    public static long zzib() {
        return zzai.zzajx.get().longValue();
    }

    public static long zzic() {
        return zzai.zzaix.get().longValue();
    }

    public static boolean zzie() {
        return zzai.zzait.get().booleanValue();
    }

    @WorkerThread
    static boolean zzig() {
        return zzai.zzakt.get().booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final long zza(String str, @NonNull zzai.zza<Long> zzaVar) {
        if (str == null) {
            return zzaVar.get().longValue();
        }
        String strZzf = this.zzagx.zzf(str, zzaVar.getKey());
        if (TextUtils.isEmpty(strZzf)) {
            return zzaVar.get().longValue();
        }
        try {
            return zzaVar.get(Long.valueOf(Long.parseLong(strZzf))).longValue();
        } catch (NumberFormatException e) {
            return zzaVar.get().longValue();
        }
    }

    final void zza(@NonNull zzs zzsVar) {
        this.zzagx = zzsVar;
    }

    public final boolean zza(zzai.zza<Boolean> zzaVar) {
        return zzd(null, zzaVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @WorkerThread
    public final int zzaq(@Size(min = 1) String str) {
        return zzb(str, zzai.zzaji);
    }

    @VisibleForTesting
    @Nullable
    final Boolean zzar(@Size(min = 1) String str) {
        Boolean boolValueOf = null;
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzgt().zzjg().zzby("Failed to load metadata: PackageManager is null");
            } else {
                ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
                if (applicationInfo == null) {
                    zzgt().zzjg().zzby("Failed to load metadata: ApplicationInfo is null");
                } else if (applicationInfo.metaData == null) {
                    zzgt().zzjg().zzby("Failed to load metadata: Metadata bundle is null");
                } else if (applicationInfo.metaData.containsKey(str)) {
                    boolValueOf = Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzgt().zzjg().zzg("Failed to load metadata: Package name not found", e);
        }
        return boolValueOf;
    }

    public final boolean zzas(String str) {
        return "1".equals(this.zzagx.zzf(str, "gaia_collection_enabled"));
    }

    public final boolean zzat(String str) {
        return "1".equals(this.zzagx.zzf(str, "measurement.event_sampling_enabled"));
    }

    @WorkerThread
    final boolean zzau(String str) {
        return zzd(str, zzai.zzakh);
    }

    @WorkerThread
    final boolean zzav(String str) {
        return zzd(str, zzai.zzakj);
    }

    @WorkerThread
    final boolean zzaw(String str) {
        return zzd(str, zzai.zzakk);
    }

    @WorkerThread
    final boolean zzax(String str) {
        return zzd(str, zzai.zzakb);
    }

    @WorkerThread
    final String zzay(String str) {
        zzai.zza<String> zzaVar = zzai.zzakc;
        return str == null ? zzaVar.get() : zzaVar.get(this.zzagx.zzf(str, zzaVar.getKey()));
    }

    final boolean zzaz(String str) {
        return zzd(str, zzai.zzakl);
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zzai.zza<Integer> zzaVar) {
        if (str == null) {
            return zzaVar.get().intValue();
        }
        String strZzf = this.zzagx.zzf(str, zzaVar.getKey());
        if (TextUtils.isEmpty(strZzf)) {
            return zzaVar.get().intValue();
        }
        try {
            return zzaVar.get(Integer.valueOf(Integer.parseInt(strZzf))).intValue();
        } catch (NumberFormatException e) {
            return zzaVar.get().intValue();
        }
    }

    @WorkerThread
    final boolean zzba(String str) {
        return zzd(str, zzai.zzakm);
    }

    final boolean zzbb(String str) {
        return zzd(str, zzai.zzako);
    }

    @WorkerThread
    final boolean zzbc(String str) {
        return zzd(str, zzai.zzakp);
    }

    @WorkerThread
    final boolean zzbd(String str) {
        return zzd(str, zzai.zzakq);
    }

    @WorkerThread
    final boolean zzbe(String str) {
        return zzd(str, zzai.zzaks);
    }

    @WorkerThread
    final boolean zzbf(String str) {
        return zzd(str, zzai.zzakr);
    }

    @WorkerThread
    final boolean zzbg(String str) {
        return zzd(str, zzai.zzaku);
    }

    @WorkerThread
    final boolean zzbh(String str) {
        return zzd(str, zzai.zzakv);
    }

    @WorkerThread
    final boolean zzbi(String str) {
        return zzd(str, zzai.zzakw);
    }

    @WorkerThread
    final boolean zzbj(String str) {
        return zzd(str, zzai.zzakx);
    }

    @WorkerThread
    final boolean zzbk(String str) {
        return zzd(str, zzai.zzalb);
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zzai.zza<Double> zzaVar) {
        if (str == null) {
            return zzaVar.get().doubleValue();
        }
        String strZzf = this.zzagx.zzf(str, zzaVar.getKey());
        if (TextUtils.isEmpty(strZzf)) {
            return zzaVar.get().doubleValue();
        }
        try {
            return zzaVar.get(Double.valueOf(Double.parseDouble(strZzf))).doubleValue();
        } catch (NumberFormatException e) {
            return zzaVar.get().doubleValue();
        }
    }

    @WorkerThread
    public final boolean zzd(String str, @NonNull zzai.zza<Boolean> zzaVar) {
        if (str == null) {
            return zzaVar.get().booleanValue();
        }
        String strZzf = this.zzagx.zzf(str, zzaVar.getKey());
        return TextUtils.isEmpty(strZzf) ? zzaVar.get().booleanValue() : zzaVar.get(Boolean.valueOf(Boolean.parseBoolean(strZzf))).booleanValue();
    }

    public final boolean zzdw() {
        if (this.zzyk == null) {
            synchronized (this) {
                if (this.zzyk == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzyk = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzyk == null) {
                        this.zzyk = Boolean.TRUE;
                        zzgt().zzjg().zzby("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzyk.booleanValue();
    }

    public final boolean zze(String str, zzai.zza<Boolean> zzaVar) {
        return zzd(str, zzaVar);
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

    public final long zzhh() {
        zzgw();
        return 14711L;
    }

    public final boolean zzhz() {
        zzgw();
        Boolean boolZzar = zzar("firebase_analytics_collection_deactivated");
        return boolZzar != null && boolZzar.booleanValue();
    }

    public final Boolean zzia() {
        zzgw();
        return zzar("firebase_analytics_collection_enabled");
    }

    public final String zzid() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
        } catch (ClassNotFoundException e) {
            zzgt().zzjg().zzg("Could not find SystemProperties class", e);
            return "";
        } catch (IllegalAccessException e2) {
            zzgt().zzjg().zzg("Could not access SystemProperties.get()", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            zzgt().zzjg().zzg("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (InvocationTargetException e4) {
            zzgt().zzjg().zzg("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    @WorkerThread
    final boolean zzif() {
        if (this.zzagw == null) {
            this.zzagw = zzar("app_measurement_lite");
            if (this.zzagw == null) {
                this.zzagw = false;
            }
        }
        return this.zzagw.booleanValue() || !this.zzada.zzkr();
    }
}
