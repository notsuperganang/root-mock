package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdy extends zzf {

    @VisibleForTesting
    protected zzdx zzart;
    private volatile zzdx zzaru;
    private zzdx zzarv;
    private final Map<Activity, zzdx> zzarw;
    private zzdx zzarx;
    private String zzary;

    public zzdy(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzarw = new ArrayMap();
    }

    @MainThread
    private final void zza(Activity activity, zzdx zzdxVar, boolean z) {
        zzdx zzdxVar2 = this.zzaru == null ? this.zzarv : this.zzaru;
        if (zzdxVar.zzarq == null) {
            zzdxVar = new zzdx(zzdxVar.zzuw, zzcq(activity.getClass().getCanonicalName()), zzdxVar.zzarr);
        }
        this.zzarv = this.zzaru;
        this.zzaru = zzdxVar;
        zzgs().zzc(new zzdz(this, z, zzdxVar2, zzdxVar));
    }

    public static void zza(zzdx zzdxVar, Bundle bundle, boolean z) {
        if (bundle != null && zzdxVar != null && (!bundle.containsKey("_sc") || z)) {
            if (zzdxVar.zzuw != null) {
                bundle.putString("_sn", zzdxVar.zzuw);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzdxVar.zzarq);
            bundle.putLong("_si", zzdxVar.zzarr);
            return;
        }
        if (bundle != null && zzdxVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zza(@NonNull zzdx zzdxVar, boolean z) {
        zzgi().zzm(zzbx().elapsedRealtime());
        if (zzgo().zza(zzdxVar.zzars, z)) {
            zzdxVar.zzars = false;
        }
    }

    @VisibleForTesting
    private static String zzcq(String str) {
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    private final zzdx zze(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzdx zzdxVar = this.zzarw.get(activity);
        if (zzdxVar != null) {
            return zzdxVar;
        }
        zzdx zzdxVar2 = new zzdx(null, zzcq(activity.getClass().getCanonicalName()), zzgr().zzmj());
        this.zzarw.put(activity, zzdxVar2);
        return zzdxVar2;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @MainThread
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzarw.put(activity, new zzdx(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    @MainThread
    public final void onActivityDestroyed(Activity activity) {
        this.zzarw.remove(activity);
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        zzdx zzdxVarZze = zze(activity);
        this.zzarv = this.zzaru;
        this.zzaru = null;
        zzgs().zzc(new zzea(this, zzdxVarZze));
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        zza(activity, zze(activity), false);
        zza zzaVarZzgi = zzgi();
        zzaVarZzgi.zzgs().zzc(new zzd(zzaVarZzgi, zzaVarZzgi.zzbx().elapsedRealtime()));
    }

    @MainThread
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzdx zzdxVar;
        if (bundle == null || (zzdxVar = this.zzarw.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzdxVar.zzarr);
        bundle2.putString("name", zzdxVar.zzuw);
        bundle2.putString("referrer_name", zzdxVar.zzarq);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void setCurrentScreen(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        if (this.zzaru == null) {
            zzgt().zzjj().zzby("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzarw.get(activity) == null) {
            zzgt().zzjj().zzby("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zzcq(activity.getClass().getCanonicalName());
        }
        boolean zEquals = this.zzaru.zzarq.equals(str2);
        boolean zZzv = zzfx.zzv(this.zzaru.zzuw, str);
        if (zEquals && zZzv) {
            zzgt().zzjl().zzby("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            zzgt().zzjj().zzg("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            zzgt().zzjj().zzg("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzgt().zzjo().zze("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzdx zzdxVar = new zzdx(str, str2, zzgr().zzmj());
        this.zzarw.put(activity, zzdxVar);
        zza(activity, zzdxVar, true);
    }

    @WorkerThread
    public final void zza(String str, zzdx zzdxVar) {
        zzaf();
        synchronized (this) {
            if (this.zzary == null || this.zzary.equals(str) || zzdxVar != null) {
                this.zzary = str;
                this.zzarx = zzdxVar;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
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
        return false;
    }

    @WorkerThread
    public final zzdx zzle() {
        zzcl();
        zzaf();
        return this.zzart;
    }

    public final zzdx zzlf() {
        zzgg();
        return this.zzaru;
    }
}
