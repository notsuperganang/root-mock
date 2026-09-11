package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzsi;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class zzbw implements zzct {
    private static volatile zzbw zzapj;
    private final boolean zzadg;
    private final String zzadi;
    private final long zzago;
    private final zzn zzaih;
    private final String zzapk;
    private final String zzapl;
    private final zzq zzapm;
    private final zzbd zzapn;
    private final zzas zzapo;
    private final zzbr zzapp;
    private final zzfd zzapq;
    private final AppMeasurement zzapr;
    private final zzfx zzaps;
    private final zzaq zzapt;
    private final zzdy zzapu;
    private final zzda zzapv;
    private final zza zzapw;
    private zzao zzapx;
    private zzeb zzapy;
    private zzaa zzapz;
    private zzam zzaqa;
    private zzbj zzaqb;
    private Boolean zzaqc;
    private long zzaqd;
    private volatile Boolean zzaqe;

    @VisibleForTesting
    private Boolean zzaqf;

    @VisibleForTesting
    private Boolean zzaqg;
    private int zzaqh;
    private final Context zzri;
    private final Clock zzrz;
    private boolean zzvz = false;
    private AtomicInteger zzaqi = new AtomicInteger(0);

    private zzbw(zzcz zzczVar) {
        Preconditions.checkNotNull(zzczVar);
        this.zzaih = new zzn(zzczVar.zzri);
        zzai.zza(this.zzaih);
        this.zzri = zzczVar.zzri;
        this.zzadi = zzczVar.zzadi;
        this.zzapk = zzczVar.zzapk;
        this.zzapl = zzczVar.zzapl;
        this.zzadg = zzczVar.zzadg;
        this.zzaqe = zzczVar.zzaqe;
        zzan zzanVar = zzczVar.zzaqz;
        if (zzanVar != null && zzanVar.zzadj != null) {
            Object obj = zzanVar.zzadj.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzaqf = (Boolean) obj;
            }
            Object obj2 = zzanVar.zzadj.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzaqg = (Boolean) obj2;
            }
        }
        zzsi.zzae(this.zzri);
        this.zzrz = DefaultClock.getInstance();
        this.zzago = this.zzrz.currentTimeMillis();
        this.zzapm = new zzq(this);
        zzbd zzbdVar = new zzbd(this);
        zzbdVar.zzq();
        this.zzapn = zzbdVar;
        zzas zzasVar = new zzas(this);
        zzasVar.zzq();
        this.zzapo = zzasVar;
        zzfx zzfxVar = new zzfx(this);
        zzfxVar.zzq();
        this.zzaps = zzfxVar;
        zzaq zzaqVar = new zzaq(this);
        zzaqVar.zzq();
        this.zzapt = zzaqVar;
        this.zzapw = new zza(this);
        zzdy zzdyVar = new zzdy(this);
        zzdyVar.zzq();
        this.zzapu = zzdyVar;
        zzda zzdaVar = new zzda(this);
        zzdaVar.zzq();
        this.zzapv = zzdaVar;
        this.zzapr = new AppMeasurement(this);
        zzfd zzfdVar = new zzfd(this);
        zzfdVar.zzq();
        this.zzapq = zzfdVar;
        zzbr zzbrVar = new zzbr(this);
        zzbrVar.zzq();
        this.zzapp = zzbrVar;
        zzn zznVar = this.zzaih;
        if (this.zzri.getApplicationContext() instanceof Application) {
            zzda zzdaVarZzgj = zzgj();
            if (zzdaVarZzgj.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzdaVarZzgj.getContext().getApplicationContext();
                if (zzdaVarZzgj.zzara == null) {
                    zzdaVarZzgj.zzara = new zzdu(zzdaVarZzgj, null);
                }
                application.unregisterActivityLifecycleCallbacks(zzdaVarZzgj.zzara);
                application.registerActivityLifecycleCallbacks(zzdaVarZzgj.zzara);
                zzdaVarZzgj.zzgt().zzjo().zzby("Registered activity lifecycle callback");
            }
        } else {
            zzgt().zzjj().zzby("Application context is not an Application");
        }
        this.zzapp.zzc(new zzbx(this, zzczVar));
    }

    public static zzbw zza(Context context, zzan zzanVar) {
        if (zzanVar != null && (zzanVar.origin == null || zzanVar.zzadi == null)) {
            zzanVar = new zzan(zzanVar.zzade, zzanVar.zzadf, zzanVar.zzadg, zzanVar.zzadh, null, null, zzanVar.zzadj);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzapj == null) {
            synchronized (zzbw.class) {
                try {
                    if (zzapj == null) {
                        zzapj = new zzbw(new zzcz(context, zzanVar));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (zzanVar != null && zzanVar.zzadj != null && zzanVar.zzadj.containsKey("dataCollectionDefaultEnabled")) {
            zzapj.zzd(zzanVar.zzadj.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzapj;
    }

    private static void zza(zzcr zzcrVar) {
        if (zzcrVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzcs zzcsVar) {
        if (zzcsVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzcsVar.isInitialized()) {
            return;
        }
        String strValueOf = String.valueOf(zzcsVar.getClass());
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 27).append("Component not initialized: ").append(strValueOf).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzcz zzczVar) {
        zzau zzauVarZzjm;
        String strConcat;
        zzgs().zzaf();
        zzq.zzhy();
        zzaa zzaaVar = new zzaa(this);
        zzaaVar.zzq();
        this.zzapz = zzaaVar;
        zzam zzamVar = new zzam(this);
        zzamVar.zzq();
        this.zzaqa = zzamVar;
        zzao zzaoVar = new zzao(this);
        zzaoVar.zzq();
        this.zzapx = zzaoVar;
        zzeb zzebVar = new zzeb(this);
        zzebVar.zzq();
        this.zzapy = zzebVar;
        this.zzaps.zzgx();
        this.zzapn.zzgx();
        this.zzaqb = new zzbj(this);
        this.zzaqa.zzgx();
        zzgt().zzjm().zzg("App measurement is starting up, version", Long.valueOf(this.zzapm.zzhh()));
        zzn zznVar = this.zzaih;
        zzgt().zzjm().zzby("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzn zznVar2 = this.zzaih;
        String strZzal = zzamVar.zzal();
        if (TextUtils.isEmpty(this.zzadi)) {
            if (zzgr().zzcz(strZzal)) {
                zzauVarZzjm = zzgt().zzjm();
                strConcat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzauVarZzjm = zzgt().zzjm();
                String strValueOf = String.valueOf(strZzal);
                strConcat = strValueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(strValueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
            }
            zzauVarZzjm.zzby(strConcat);
        }
        zzgt().zzjn().zzby("Debug-level message logging enabled");
        if (this.zzaqh != this.zzaqi.get()) {
            zzgt().zzjg().zze("Not all components initialized", Integer.valueOf(this.zzaqh), Integer.valueOf(this.zzaqi.get()));
        }
        this.zzvz = true;
    }

    private static void zza(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzfVar.isInitialized()) {
            return;
        }
        String strValueOf = String.valueOf(zzfVar.getClass());
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 27).append("Component not initialized: ").append(strValueOf).toString());
    }

    private final void zzcl() {
        if (!this.zzvz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final Context getContext() {
        return this.zzri;
    }

    @WorkerThread
    public final boolean isEnabled() {
        boolean zBooleanValue;
        zzgs().zzaf();
        zzcl();
        if (!this.zzapm.zza(zzai.zzale)) {
            if (this.zzapm.zzhz()) {
                return false;
            }
            Boolean boolZzia = this.zzapm.zzia();
            if (boolZzia != null) {
                zBooleanValue = boolZzia.booleanValue();
            } else {
                boolean z = GoogleServices.isMeasurementExplicitlyDisabled() ? false : true;
                zBooleanValue = (z && this.zzaqe != null && zzai.zzala.get().booleanValue()) ? this.zzaqe.booleanValue() : z;
            }
            return zzgu().zzh(zBooleanValue);
        }
        if (this.zzapm.zzhz()) {
            return false;
        }
        if (this.zzaqg != null && this.zzaqg.booleanValue()) {
            return false;
        }
        Boolean boolZzjz = zzgu().zzjz();
        if (boolZzjz != null) {
            return boolZzjz.booleanValue();
        }
        Boolean boolZzia2 = this.zzapm.zzia();
        if (boolZzia2 != null) {
            return boolZzia2.booleanValue();
        }
        if (this.zzaqf != null) {
            return this.zzaqf.booleanValue();
        }
        if (GoogleServices.isMeasurementExplicitlyDisabled()) {
            return false;
        }
        if (!this.zzapm.zza(zzai.zzala) || this.zzaqe == null) {
            return true;
        }
        return this.zzaqe.booleanValue();
    }

    @WorkerThread
    protected final void start() {
        zzgs().zzaf();
        if (zzgu().zzanc.get() == 0) {
            zzgu().zzanc.set(this.zzrz.currentTimeMillis());
        }
        if (Long.valueOf(zzgu().zzanh.get()).longValue() == 0) {
            zzgt().zzjo().zzg("Persisting first open", Long.valueOf(this.zzago));
            zzgu().zzanh.set(this.zzago);
        }
        if (!zzkv()) {
            if (isEnabled()) {
                if (!zzgr().zzx("android.permission.INTERNET")) {
                    zzgt().zzjg().zzby("App is missing INTERNET permission");
                }
                if (!zzgr().zzx("android.permission.ACCESS_NETWORK_STATE")) {
                    zzgt().zzjg().zzby("App is missing ACCESS_NETWORK_STATE permission");
                }
                zzn zznVar = this.zzaih;
                if (!Wrappers.packageManager(this.zzri).isCallerInstantApp() && !this.zzapm.zzif()) {
                    if (!zzbm.zza(this.zzri)) {
                        zzgt().zzjg().zzby("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzfx.zza(this.zzri, false)) {
                        zzgt().zzjg().zzby("AppMeasurementService not registered/enabled");
                    }
                }
                zzgt().zzjg().zzby("Uploading is not possible. App measurement disabled");
                return;
            }
            return;
        }
        zzn zznVar2 = this.zzaih;
        if (!TextUtils.isEmpty(zzgk().getGmpAppId()) || !TextUtils.isEmpty(zzgk().zzhb())) {
            zzgr();
            if (zzfx.zza(zzgk().getGmpAppId(), zzgu().zzjv(), zzgk().zzhb(), zzgu().zzjw())) {
                zzgt().zzjm().zzby("Rechecking which service to use due to a GMP App Id change");
                zzgu().zzjy();
                zzgn().resetAnalyticsData();
                this.zzapy.disconnect();
                this.zzapy.zzdj();
                zzgu().zzanh.set(this.zzago);
                zzgu().zzanj.zzcd(null);
            }
            zzgu().zzcb(zzgk().getGmpAppId());
            zzgu().zzcc(zzgk().zzhb());
            if (this.zzapm.zzbi(zzgk().zzal())) {
                this.zzapq.zzaj(this.zzago);
            }
        }
        zzgj().zzcp(zzgu().zzanj.zzkd());
        zzn zznVar3 = this.zzaih;
        if (TextUtils.isEmpty(zzgk().getGmpAppId()) && TextUtils.isEmpty(zzgk().zzhb())) {
            return;
        }
        boolean zIsEnabled = isEnabled();
        if (!zzgu().zzkc() && !this.zzapm.zzhz()) {
            zzgu().zzi(zIsEnabled ? false : true);
        }
        if (!this.zzapm.zzba(zzgk().zzal()) || zIsEnabled) {
            zzgj().zzld();
        }
        zzgl().zza(new AtomicReference<>());
    }

    final void zzb(zzcs zzcsVar) {
        this.zzaqh++;
    }

    final void zzb(zzf zzfVar) {
        this.zzaqh++;
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final Clock zzbx() {
        return this.zzrz;
    }

    @WorkerThread
    final void zzd(boolean z) {
        this.zzaqe = Boolean.valueOf(z);
    }

    final void zzgf() {
        zzn zznVar = this.zzaih;
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void zzgg() {
        zzn zznVar = this.zzaih;
    }

    public final zza zzgi() {
        if (this.zzapw == null) {
            throw new IllegalStateException("Component not created");
        }
        return this.zzapw;
    }

    public final zzda zzgj() {
        zza((zzf) this.zzapv);
        return this.zzapv;
    }

    public final zzam zzgk() {
        zza((zzf) this.zzaqa);
        return this.zzaqa;
    }

    public final zzeb zzgl() {
        zza((zzf) this.zzapy);
        return this.zzapy;
    }

    public final zzdy zzgm() {
        zza((zzf) this.zzapu);
        return this.zzapu;
    }

    public final zzao zzgn() {
        zza((zzf) this.zzapx);
        return this.zzapx;
    }

    public final zzfd zzgo() {
        zza((zzf) this.zzapq);
        return this.zzapq;
    }

    public final zzaa zzgp() {
        zza((zzcs) this.zzapz);
        return this.zzapz;
    }

    public final zzaq zzgq() {
        zza((zzcr) this.zzapt);
        return this.zzapt;
    }

    public final zzfx zzgr() {
        zza((zzcr) this.zzaps);
        return this.zzaps;
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final zzbr zzgs() {
        zza((zzcs) this.zzapp);
        return this.zzapp;
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final zzas zzgt() {
        zza((zzcs) this.zzapo);
        return this.zzapo;
    }

    public final zzbd zzgu() {
        zza((zzcr) this.zzapn);
        return this.zzapn;
    }

    public final zzq zzgv() {
        return this.zzapm;
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final zzn zzgw() {
        return this.zzaih;
    }

    public final zzas zzkj() {
        if (this.zzapo == null || !this.zzapo.isInitialized()) {
            return null;
        }
        return this.zzapo;
    }

    public final zzbj zzkk() {
        return this.zzaqb;
    }

    final zzbr zzkl() {
        return this.zzapp;
    }

    public final AppMeasurement zzkm() {
        return this.zzapr;
    }

    public final boolean zzkn() {
        return TextUtils.isEmpty(this.zzadi);
    }

    public final String zzko() {
        return this.zzadi;
    }

    public final String zzkp() {
        return this.zzapk;
    }

    public final String zzkq() {
        return this.zzapl;
    }

    public final boolean zzkr() {
        return this.zzadg;
    }

    @WorkerThread
    public final boolean zzks() {
        return this.zzaqe != null && this.zzaqe.booleanValue();
    }

    final long zzkt() {
        Long lValueOf = Long.valueOf(zzgu().zzanh.get());
        return lValueOf.longValue() == 0 ? this.zzago : Math.min(this.zzago, lValueOf.longValue());
    }

    final void zzku() {
        this.zzaqi.incrementAndGet();
    }

    @WorkerThread
    protected final boolean zzkv() {
        zzcl();
        zzgs().zzaf();
        if (this.zzaqc == null || this.zzaqd == 0 || (this.zzaqc != null && !this.zzaqc.booleanValue() && Math.abs(this.zzrz.elapsedRealtime() - this.zzaqd) > 1000)) {
            this.zzaqd = this.zzrz.elapsedRealtime();
            zzn zznVar = this.zzaih;
            this.zzaqc = Boolean.valueOf(zzgr().zzx("android.permission.INTERNET") && zzgr().zzx("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzri).isCallerInstantApp() || this.zzapm.zzif() || (zzbm.zza(this.zzri) && zzfx.zza(this.zzri, false))));
            if (this.zzaqc.booleanValue()) {
                this.zzaqc = Boolean.valueOf(zzgr().zzu(zzgk().getGmpAppId(), zzgk().zzhb()) || !TextUtils.isEmpty(zzgk().zzhb()));
            }
        }
        return this.zzaqc.booleanValue();
    }
}
