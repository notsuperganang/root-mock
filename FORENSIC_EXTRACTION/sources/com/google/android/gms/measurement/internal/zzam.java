package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.WorkerThread;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.InstantApps;

/* JADX INFO: loaded from: classes.dex */
public final class zzam extends zzf {
    private String zzafi;
    private String zzafp;
    private long zzafs;
    private String zzafv;
    private int zzagp;
    private int zzalm;
    private long zzaln;
    private String zztr;
    private String zzts;
    private String zztt;

    zzam(zzbw zzbwVar) {
        super(zzbwVar);
    }

    @WorkerThread
    @VisibleForTesting
    private final String zzjc() {
        try {
            Class<?> clsLoadClass = getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, getContext());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                } catch (Exception e) {
                    zzgt().zzjl().zzby("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception e2) {
                zzgt().zzjk().zzby("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException e3) {
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    final String getGmpAppId() {
        zzcl();
        return this.zzafi;
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    final String zzal() {
        zzcl();
        return this.zztt;
    }

    @WorkerThread
    final zzk zzbs(String str) {
        zzaf();
        zzgg();
        String strZzal = zzal();
        String gmpAppId = getGmpAppId();
        zzcl();
        String str2 = this.zzts;
        long jZzjd = zzjd();
        zzcl();
        String str3 = this.zzafp;
        long jZzhh = zzgv().zzhh();
        zzcl();
        zzaf();
        if (this.zzaln == 0) {
            this.zzaln = this.zzada.zzgr().zzd(getContext(), getContext().getPackageName());
        }
        long j = this.zzaln;
        boolean zIsEnabled = this.zzada.isEnabled();
        boolean z = !zzgu().zzans;
        zzaf();
        zzgg();
        String strZzjc = (!zzgv().zzaz(this.zztt) || this.zzada.isEnabled()) ? zzjc() : null;
        zzcl();
        long j2 = this.zzafs;
        long jZzkt = this.zzada.zzkt();
        int iZzje = zzje();
        zzq zzqVarZzgv = zzgv();
        zzqVarZzgv.zzgg();
        Boolean boolZzar = zzqVarZzgv.zzar("google_analytics_adid_collection_enabled");
        boolean zBooleanValue = Boolean.valueOf(boolZzar == null || boolZzar.booleanValue()).booleanValue();
        zzq zzqVarZzgv2 = zzgv();
        zzqVarZzgv2.zzgg();
        Boolean boolZzar2 = zzqVarZzgv2.zzar("google_analytics_ssaid_collection_enabled");
        return new zzk(strZzal, gmpAppId, str2, jZzjd, str3, jZzhh, j, str, zIsEnabled, z, strZzjc, j2, jZzkt, iZzje, zBooleanValue, Boolean.valueOf(boolZzar2 == null || boolZzar2.booleanValue()).booleanValue(), zzgu().zzkb(), zzhb());
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zza zzgi() {
        return super.zzgi();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzda zzgj() {
        return super.zzgj();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzam zzgk() {
        return super.zzgk();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzeb zzgl() {
        return super.zzgl();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzdy zzgm() {
        return super.zzgm();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzao zzgn() {
        return super.zzgn();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzfd zzgo() {
        return super.zzgo();
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

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzgy() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0206  */
    @Override // com.google.android.gms.measurement.internal.zzf
    protected final void zzgz() {
        boolean z;
        String installerPackageName = EnvironmentCompat.MEDIA_UNKNOWN;
        String str = "Unknown";
        int i = Integer.MIN_VALUE;
        String string = "Unknown";
        String packageName = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager == null) {
            zzgt().zzjg().zzg("PackageManager is null, app identity information might be inaccurate. appId", zzas.zzbw(packageName));
        } else {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                zzgt().zzjg().zzg("Error retrieving app installer package name. appId", zzas.zzbw(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    string = TextUtils.isEmpty(applicationLabel) ? "Unknown" : applicationLabel.toString();
                    str = packageInfo.versionName;
                    i = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                zzgt().zzjg().zze("Error retrieving package info. appId, appName", zzas.zzbw(packageName), string);
            }
        }
        this.zztt = packageName;
        this.zzafp = installerPackageName;
        this.zzts = str;
        this.zzalm = i;
        this.zztr = string;
        this.zzaln = 0L;
        zzgw();
        Status statusInitialize = GoogleServices.initialize(getContext());
        boolean z2 = (statusInitialize != null && statusInitialize.isSuccess()) | (!TextUtils.isEmpty(this.zzada.zzko()) && "am".equals(this.zzada.zzkp()));
        if (!z2) {
            if (statusInitialize == null) {
                zzgt().zzjg().zzby("GoogleService failed to initialize (no status)");
            } else {
                zzgt().zzjg().zze("GoogleService failed to initialize, status", Integer.valueOf(statusInitialize.getStatusCode()), statusInitialize.getStatusMessage());
            }
        }
        if (z2) {
            Boolean boolZzia = zzgv().zzia();
            if (zzgv().zzhz()) {
                if (this.zzada.zzkn()) {
                    zzgt().zzjm().zzby("Collection disabled with firebase_analytics_collection_deactivated=1");
                    z = false;
                } else {
                    z = false;
                }
            } else if (boolZzia == null || boolZzia.booleanValue()) {
                if (boolZzia == null && GoogleServices.isMeasurementExplicitlyDisabled()) {
                    zzgt().zzjm().zzby("Collection disabled with google_app_measurement_enable=0");
                    z = false;
                } else {
                    zzgt().zzjo().zzby("Collection enabled");
                    z = true;
                }
            } else if (this.zzada.zzkn()) {
                zzgt().zzjm().zzby("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.zzafi = "";
        this.zzafv = "";
        this.zzafs = 0L;
        zzgw();
        if (!TextUtils.isEmpty(this.zzada.zzko()) && "am".equals(this.zzada.zzkp())) {
            this.zzafv = this.zzada.zzko();
        }
        try {
            String googleAppId = GoogleServices.getGoogleAppId();
            this.zzafi = TextUtils.isEmpty(googleAppId) ? "" : googleAppId;
            if (!TextUtils.isEmpty(googleAppId)) {
                this.zzafv = new StringResourceValueReader(getContext()).getString("admob_app_id");
            }
            if (z) {
                zzgt().zzjo().zze("App package, google app id", this.zztt, this.zzafi);
            }
        } catch (IllegalStateException e3) {
            zzgt().zzjg().zze("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzas.zzbw(packageName), e3);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.zzagp = InstantApps.isInstantApp(getContext()) ? 1 : 0;
        } else {
            this.zzagp = 0;
        }
    }

    final String zzhb() {
        zzcl();
        return this.zzafv;
    }

    final int zzjd() {
        zzcl();
        return this.zzalm;
    }

    final int zzje() {
        zzcl();
        return this.zzagp;
    }
}
