package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class zzbd extends zzcs {

    @VisibleForTesting
    static final Pair<String, Long> zzana = new Pair<>("", 0L);
    private SharedPreferences zzabr;
    public zzbh zzanb;
    public final zzbg zzanc;
    public final zzbg zzand;
    public final zzbg zzane;
    public final zzbg zzanf;
    public final zzbg zzang;
    public final zzbg zzanh;
    public final zzbg zzani;
    public final zzbi zzanj;
    private String zzank;
    private boolean zzanl;
    private long zzanm;
    public final zzbg zzann;
    public final zzbg zzano;
    public final zzbf zzanp;
    public final zzbg zzanq;
    public final zzbg zzanr;
    public boolean zzans;
    public zzbf zzant;

    zzbd(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzanc = new zzbg(this, "last_upload", 0L);
        this.zzand = new zzbg(this, "last_upload_attempt", 0L);
        this.zzane = new zzbg(this, "backoff", 0L);
        this.zzanf = new zzbg(this, "last_delete_stale", 0L);
        this.zzann = new zzbg(this, "time_before_start", 10000L);
        this.zzano = new zzbg(this, "session_timeout", 1800000L);
        this.zzanp = new zzbf(this, "start_new_session", true);
        this.zzanq = new zzbg(this, "last_pause_time", 0L);
        this.zzanr = new zzbg(this, "time_active", 0L);
        this.zzang = new zzbg(this, "midnight_offset", 0L);
        this.zzanh = new zzbg(this, "first_open_time", 0L);
        this.zzani = new zzbg(this, "app_install_time", 0L);
        this.zzanj = new zzbi(this, "app_instance_id", null);
        this.zzant = new zzbf(this, "app_backgrounded", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final SharedPreferences zzju() {
        zzaf();
        zzcl();
        return this.zzabr;
    }

    @WorkerThread
    final void setMeasurementEnabled(boolean z) {
        zzaf();
        zzgt().zzjo().zzg("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzju().edit();
        editorEdit.putBoolean("measurement_enabled", z);
        editorEdit.apply();
    }

    final boolean zzaf(long j) {
        return j - this.zzano.get() > this.zzanq.get();
    }

    @WorkerThread
    @NonNull
    final Pair<String, Boolean> zzbz(String str) {
        zzaf();
        long jElapsedRealtime = zzbx().elapsedRealtime();
        if (this.zzank != null && jElapsedRealtime < this.zzanm) {
            return new Pair<>(this.zzank, Boolean.valueOf(this.zzanl));
        }
        this.zzanm = jElapsedRealtime + zzgv().zza(str, zzai.zzaiv);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.zzank = advertisingIdInfo.getId();
                this.zzanl = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzank == null) {
                this.zzank = "";
            }
        } catch (Exception e) {
            zzgt().zzjn().zzg("Unable to get advertising id", e);
            this.zzank = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzank, Boolean.valueOf(this.zzanl));
    }

    @WorkerThread
    final String zzca(String str) {
        zzaf();
        String str2 = (String) zzbz(str).first;
        MessageDigest messageDigest = zzfx.getMessageDigest();
        if (messageDigest == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest(str2.getBytes())));
    }

    @WorkerThread
    final void zzcb(String str) {
        zzaf();
        SharedPreferences.Editor editorEdit = zzju().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    @WorkerThread
    final void zzcc(String str) {
        zzaf();
        SharedPreferences.Editor editorEdit = zzju().edit();
        editorEdit.putString("admob_app_id", str);
        editorEdit.apply();
    }

    @WorkerThread
    final void zzg(boolean z) {
        zzaf();
        zzgt().zzjo().zzg("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzju().edit();
        editorEdit.putBoolean("use_service", z);
        editorEdit.apply();
    }

    @Override // com.google.android.gms.measurement.internal.zzcs
    protected final boolean zzgy() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzcs
    @WorkerThread
    protected final void zzgz() {
        this.zzabr = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzans = this.zzabr.getBoolean("has_been_opened", false);
        if (!this.zzans) {
            SharedPreferences.Editor editorEdit = this.zzabr.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.zzanb = new zzbh(this, "health_monitor", Math.max(0L, zzai.zzaiw.get().longValue()));
    }

    @WorkerThread
    final boolean zzh(boolean z) {
        zzaf();
        return zzju().getBoolean("measurement_enabled", z);
    }

    @WorkerThread
    final void zzi(boolean z) {
        zzaf();
        zzgt().zzjo().zzg("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzju().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    @WorkerThread
    final String zzjv() {
        zzaf();
        return zzju().getString("gmp_app_id", null);
    }

    @WorkerThread
    final String zzjw() {
        zzaf();
        return zzju().getString("admob_app_id", null);
    }

    @WorkerThread
    final Boolean zzjx() {
        zzaf();
        if (zzju().contains("use_service")) {
            return Boolean.valueOf(zzju().getBoolean("use_service", false));
        }
        return null;
    }

    @WorkerThread
    final void zzjy() {
        zzaf();
        zzgt().zzjo().zzby("Clearing collection preferences.");
        if (zzgv().zza(zzai.zzale)) {
            Boolean boolZzjz = zzjz();
            SharedPreferences.Editor editorEdit = zzju().edit();
            editorEdit.clear();
            editorEdit.apply();
            if (boolZzjz != null) {
                setMeasurementEnabled(boolZzjz.booleanValue());
                return;
            }
            return;
        }
        boolean zContains = zzju().contains("measurement_enabled");
        boolean zZzh = zContains ? zzh(true) : true;
        SharedPreferences.Editor editorEdit2 = zzju().edit();
        editorEdit2.clear();
        editorEdit2.apply();
        if (zContains) {
            setMeasurementEnabled(zZzh);
        }
    }

    @WorkerThread
    final Boolean zzjz() {
        zzaf();
        if (zzju().contains("measurement_enabled")) {
            return Boolean.valueOf(zzju().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @WorkerThread
    protected final String zzka() {
        zzaf();
        String string = zzju().getString("previous_os_version", null);
        zzgp().zzcl();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = zzju().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    @WorkerThread
    final boolean zzkb() {
        zzaf();
        return zzju().getBoolean("deferred_analytics_collection", false);
    }

    @WorkerThread
    final boolean zzkc() {
        return this.zzabr.contains("deferred_analytics_collection");
    }
}
