package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.app.NotificationCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzda extends zzf {

    @VisibleForTesting
    protected zzdu zzara;
    private zzcx zzarb;
    private final Set<zzcy> zzarc;
    private boolean zzard;
    private final AtomicReference<String> zzare;

    @VisibleForTesting
    protected boolean zzarf;

    protected zzda(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzarc = new CopyOnWriteArraySet();
        this.zzarf = true;
        this.zzare = new AtomicReference<>();
    }

    private final void zza(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long jCurrentTimeMillis = zzbx().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = jCurrentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgr().zzcv(str) != 0) {
            zzgt().zzjg().zzg("Invalid conditional user property name", zzgq().zzbv(str));
            return;
        }
        if (zzgr().zzi(str, obj) != 0) {
            zzgt().zzjg().zze("Invalid conditional user property value", zzgq().zzbv(str), obj);
            return;
        }
        Object objZzj = zzgr().zzj(str, obj);
        if (objZzj == null) {
            zzgt().zzjg().zze("Unable to normalize conditional user property value", zzgq().zzbv(str), obj);
            return;
        }
        conditionalUserProperty.mValue = objZzj;
        long j = conditionalUserProperty.mTriggerTimeout;
        if (!TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) && (j > 15552000000L || j < 1)) {
            zzgt().zzjg().zze("Invalid conditional user property timeout", zzgq().zzbv(str), Long.valueOf(j));
            return;
        }
        long j2 = conditionalUserProperty.mTimeToLive;
        if (j2 > 15552000000L || j2 < 1) {
            zzgt().zzjg().zze("Invalid conditional user property time to live", zzgq().zzbv(str), Long.valueOf(j2));
        } else {
            zzgs().zzc(new zzdi(this, conditionalUserProperty));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int length;
        int i;
        Preconditions.checkNotEmpty(str);
        if (!zzgv().zze(str3, zzai.zzali)) {
            Preconditions.checkNotEmpty(str2);
        }
        Preconditions.checkNotNull(bundle);
        zzaf();
        zzcl();
        if (!this.zzada.isEnabled()) {
            zzgt().zzjn().zzby("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.zzard) {
            this.zzard = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", Context.class).invoke(null, getContext());
                } catch (Exception e) {
                    zzgt().zzjj().zzg("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException e2) {
                zzgt().zzjm().zzby("Tag Manager is not found and thus will not be used");
            }
        }
        if (z3) {
            zzgw();
            if (!"_iap".equals(str2)) {
                zzfx zzfxVarZzgr = this.zzada.zzgr();
                if (!zzfxVarZzgr.zzs(NotificationCompat.CATEGORY_EVENT, str2)) {
                    i = 2;
                } else if (zzfxVarZzgr.zza(NotificationCompat.CATEGORY_EVENT, zzcu.zzaqt, str2)) {
                    i = !zzfxVarZzgr.zza(NotificationCompat.CATEGORY_EVENT, 40, str2) ? 2 : 0;
                } else {
                    i = 13;
                }
                if (i != 0) {
                    zzgt().zzji().zzg("Invalid public event name. Event will not be logged (FE)", zzgq().zzbt(str2));
                    this.zzada.zzgr();
                    this.zzada.zzgr().zza(i, "_ev", zzfx.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzgw();
        zzdx zzdxVarZzle = zzgm().zzle();
        if (zzdxVarZzle != null && !bundle.containsKey("_sc")) {
            zzdxVarZzle.zzars = true;
        }
        zzdy.zza(zzdxVarZzle, bundle, z && z3);
        boolean zEquals = "am".equals(str);
        boolean zZzcy = zzfx.zzcy(str2);
        if (z && this.zzarb != null && !zZzcy && !zEquals) {
            zzgt().zzjn().zze("Passing event to registered event handler (FE)", zzgq().zzbt(str2), zzgq().zzd(bundle));
            this.zzarb.interceptEvent(str, str2, bundle, j);
            return;
        }
        if (this.zzada.zzkv()) {
            int iZzcu = zzgr().zzcu(str2);
            if (iZzcu != 0) {
                zzgt().zzji().zzg("Invalid event name. Event will not be logged (FE)", zzgq().zzbt(str2));
                zzgr();
                this.zzada.zzgr().zza(str3, iZzcu, "_ev", zzfx.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            List<String> listListOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
            Bundle bundleZza = zzgr().zza(str3, str2, bundle, listListOf, z3, true);
            zzdx zzdxVar = (bundleZza != null && bundleZza.containsKey("_sc") && bundleZza.containsKey("_si")) ? new zzdx(bundleZza.getString("_sn"), bundleZza.getString("_sc"), Long.valueOf(bundleZza.getLong("_si")).longValue()) : null;
            zzdx zzdxVar2 = zzdxVar == null ? zzdxVarZzle : zzdxVar;
            if (zzgv().zzbk(str3)) {
                zzgw();
                if (zzgm().zzle() != null && AppMeasurement.Event.APP_EXCEPTION.equals(str2)) {
                    long jZzlp = zzgo().zzlp();
                    if (jZzlp > 0) {
                        zzgr().zza(bundleZza, jZzlp);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleZza);
            long jNextLong = zzgr().zzmk().nextLong();
            if (zzgv().zze(zzgk().zzal(), zzai.zzaky) && zzgu().zzanq.get() > 0 && zzgu().zzaf(j) && zzgu().zzant.get()) {
                zzgt().zzjo().zzby("Current session is expired, remove the session number and Id");
                if (zzgv().zze(zzgk().zzal(), zzai.zzaku)) {
                    zza("auto", "_sid", (Object) null, zzbx().currentTimeMillis());
                }
                if (zzgv().zze(zzgk().zzal(), zzai.zzakv)) {
                    zza("auto", "_sno", (Object) null, zzbx().currentTimeMillis());
                }
            }
            if (zzgv().zzbj(zzgk().zzal()) && bundleZza.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0L) == 1) {
                zzgt().zzjo().zzby("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.zzada.zzgo().zza(j, true);
            }
            int i2 = 0;
            String[] strArr = (String[]) bundleZza.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr);
            int length2 = strArr.length;
            int i3 = 0;
            while (i3 < length2) {
                String str4 = strArr[i3];
                Object obj = bundleZza.get(str4);
                zzgr();
                Bundle[] bundleArrZzf = zzfx.zzf(obj);
                if (bundleArrZzf != null) {
                    bundleZza.putInt(str4, bundleArrZzf.length);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bundleArrZzf.length) {
                            break;
                        }
                        Bundle bundle2 = bundleArrZzf[i5];
                        zzdy.zza(zzdxVar2, bundle2, true);
                        Bundle bundleZza2 = zzgr().zza(str3, "_ep", bundle2, listListOf, z3, false);
                        bundleZza2.putString("_en", str2);
                        bundleZza2.putLong("_eid", jNextLong);
                        bundleZza2.putString("_gn", str4);
                        bundleZza2.putInt("_ll", bundleArrZzf.length);
                        bundleZza2.putInt("_i", i5);
                        arrayList.add(bundleZza2);
                        i4 = i5 + 1;
                    }
                    length = bundleArrZzf.length + i2;
                } else {
                    length = i2;
                }
                i3++;
                i2 = length;
            }
            if (i2 != 0) {
                bundleZza.putLong("_eid", jNextLong);
                bundleZza.putInt("_epc", i2);
            }
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                Bundle bundle3 = (Bundle) arrayList.get(i7);
                String str5 = i7 != 0 ? "_ep" : str2;
                bundle3.putString("_o", str);
                Bundle bundleZze = z2 ? zzgr().zze(bundle3) : bundle3;
                zzgt().zzjn().zze("Logging event (FE)", zzgq().zzbt(str2), zzgq().zzd(bundleZze));
                zzgl().zzc(new zzag(str5, new zzad(bundleZze), str, j), str3);
                if (!zEquals) {
                    Iterator<zzcy> it = this.zzarc.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str2, new Bundle(bundleZze), j);
                    }
                }
                i6 = i7 + 1;
            }
            zzgw();
            if (zzgm().zzle() == null || !AppMeasurement.Event.APP_EXCEPTION.equals(str2)) {
                return;
            }
            zzgo().zza(true, true);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzgs().zzc(new zzdd(this, str, str2, obj, j));
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long jCurrentTimeMillis = zzbx().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = jCurrentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgs().zzc(new zzdj(this, conditionalUserProperty));
    }

    @Nullable
    private final String zzah(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzgs().zzc(new zzdf(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzgt().zzjj().zzby("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzada.zzgs().zzc(new zzdm(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e) {
                zzgt().zzjj().zzg("Interrupted waiting for get user properties", e);
            }
        }
        List<zzfu> list = (List) atomicReference.get();
        if (list == null) {
            zzgt().zzjj().zzby("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzfu zzfuVar : list) {
            arrayMap.put(zzfuVar.name, zzfuVar.getValue());
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzb(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        if (!this.zzada.isEnabled()) {
            zzgt().zzjn().zzby("Conditional property not sent since collection is disabled");
            return;
        }
        zzfu zzfuVar = new zzfu(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            zzag zzagVarZza = zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0L, true, false);
            zzgl().zzd(new zzo(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzfuVar, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0L, true, false), conditionalUserProperty.mTriggerTimeout, zzagVarZza, conditionalUserProperty.mTimeToLive, zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0L, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzgs().zzc(new zzdc(this, str, str2, j, zzfx.zzf(bundle), z, z2, z3, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzc(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        if (!this.zzada.isEnabled()) {
            zzgt().zzjn().zzby("Conditional property not cleared since collection is disabled");
            return;
        }
        try {
            zzgl().zzd(new zzo(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, new zzfu(conditionalUserProperty.mName, 0L, null, null), conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    @VisibleForTesting
    private final List<AppMeasurement.ConditionalUserProperty> zzf(String str, String str2, String str3) {
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzada.zzgs().zzc(new zzdk(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e) {
                zzgt().zzjj().zze("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List<zzo> list = (List) atomicReference.get();
        if (list == null) {
            zzgt().zzjj().zzg("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zzo zzoVar : list) {
            AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
            conditionalUserProperty.mAppId = zzoVar.packageName;
            conditionalUserProperty.mOrigin = zzoVar.origin;
            conditionalUserProperty.mCreationTimestamp = zzoVar.creationTimestamp;
            conditionalUserProperty.mName = zzoVar.zzags.name;
            conditionalUserProperty.mValue = zzoVar.zzags.getValue();
            conditionalUserProperty.mActive = zzoVar.active;
            conditionalUserProperty.mTriggerEventName = zzoVar.triggerEventName;
            if (zzoVar.zzagt != null) {
                conditionalUserProperty.mTimedOutEventName = zzoVar.zzagt.name;
                if (zzoVar.zzagt.zzahu != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzoVar.zzagt.zzahu.zziy();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzoVar.triggerTimeout;
            if (zzoVar.zzagu != null) {
                conditionalUserProperty.mTriggeredEventName = zzoVar.zzagu.name;
                if (zzoVar.zzagu.zzahu != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzoVar.zzagu.zzahu.zziy();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzoVar.zzags.zzaum;
            conditionalUserProperty.mTimeToLive = zzoVar.timeToLive;
            if (zzoVar.zzagv != null) {
                conditionalUserProperty.mExpiredEventName = zzoVar.zzagv.name;
                if (zzoVar.zzagv.zzahu != null) {
                    conditionalUserProperty.mExpiredEventParams = zzoVar.zzagv.zzahu.zziy();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzj(boolean z) {
        zzaf();
        zzgg();
        zzcl();
        zzgt().zzjn().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgu().setMeasurementEnabled(z);
        zzlc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzlc() {
        if (zzgv().zzba(zzgk().zzal()) && this.zzada.isEnabled() && this.zzarf) {
            zzgt().zzjn().zzby("Recording app launch after enabling measurement for the first time (FE)");
            zzld();
        } else {
            zzgt().zzjn().zzby("Updating Scion state (FE)");
            zzgl().zzlg();
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzgg();
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzgf();
        zza(str, str2, str3, bundle);
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        zzgg();
        return zzf(null, str, str2);
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzgf();
        return zzf(str, str2, str3);
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Nullable
    public final String getCurrentScreenClass() {
        zzdx zzdxVarZzlf = this.zzada.zzgm().zzlf();
        if (zzdxVarZzlf != null) {
            return zzdxVarZzlf.zzarq;
        }
        return null;
    }

    @Nullable
    public final String getCurrentScreenName() {
        zzdx zzdxVarZzlf = this.zzada.zzgm().zzlf();
        if (zzdxVarZzlf != null) {
            return zzdxVarZzlf.zzuw;
        }
        return null;
    }

    @Nullable
    public final String getGmpAppId() {
        if (this.zzada.zzko() != null) {
            return this.zzada.zzko();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzada.zzgt().zzjg().zzg("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzgg();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzgf();
        return zzb(str, str2, str3, z);
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        logEvent(str, str2, bundle, true, true, zzbx().currentTimeMillis());
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzgg();
        zzb(str == null ? "app" : str, str2, j, bundle == null ? new Bundle() : bundle, z2, !z2 || this.zzarb == null || zzfx.zzcy(str2), !z, null);
    }

    public final void resetAnalyticsData(long j) {
        if (zzgv().zza(zzai.zzald)) {
            zzcp(null);
        }
        zzgs().zzc(new zzdg(this, j));
    }

    public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zzgg();
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzgt().zzjj().zzby("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzgf();
        zza(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }

    public final void setMeasurementEnabled(boolean z) {
        zzcl();
        zzgg();
        zzgs().zzc(new zzdq(this, z));
    }

    public final void setMinimumSessionDuration(long j) {
        zzgg();
        zzgs().zzc(new zzds(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzgg();
        zzgs().zzc(new zzdt(this, j));
    }

    @WorkerThread
    public final void zza(zzcx zzcxVar) {
        zzaf();
        zzgg();
        zzcl();
        if (zzcxVar != null && zzcxVar != this.zzarb) {
            Preconditions.checkState(this.zzarb == null, "EventInterceptor already set.");
        }
        this.zzarb = zzcxVar;
    }

    public final void zza(zzcy zzcyVar) {
        zzgg();
        zzcl();
        Preconditions.checkNotNull(zzcyVar);
        if (this.zzarc.add(zzcyVar)) {
            return;
        }
        zzgt().zzjj().zzby("OnEventListener already registered");
    }

    @WorkerThread
    final void zza(String str, String str2, long j, Bundle bundle) {
        zzgg();
        zzaf();
        zza(str, str2, j, bundle, true, this.zzarb == null || zzfx.zzcy(str2), false, null);
    }

    @WorkerThread
    final void zza(String str, String str2, Bundle bundle) {
        zzgg();
        zzaf();
        zza(str, str2, zzbx().currentTimeMillis(), bundle);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        logEvent(str, str2, bundle, false, true, zzbx().currentTimeMillis());
    }

    @WorkerThread
    final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzgg();
        zzcl();
        if (!this.zzada.isEnabled()) {
            zzgt().zzjn().zzby("User property not set since app measurement is disabled");
        } else if (this.zzada.zzkv()) {
            zzgt().zzjn().zze("Setting user property (FE)", zzgq().zzbt(str2), obj);
            zzgl().zzb(new zzfu(str2, j, obj, str));
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        int iZzcv = 6;
        String str3 = str == null ? "app" : str;
        if (z) {
            iZzcv = zzgr().zzcv(str2);
        } else {
            zzfx zzfxVarZzgr = zzgr();
            if (zzfxVarZzgr.zzs("user property", str2)) {
                if (!zzfxVarZzgr.zza("user property", zzcw.zzaqx, str2)) {
                    iZzcv = 15;
                } else if (zzfxVarZzgr.zza("user property", 24, str2)) {
                    iZzcv = 0;
                }
            }
        }
        if (iZzcv != 0) {
            zzgr();
            this.zzada.zzgr().zza(iZzcv, "_ev", zzfx.zza(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj == null) {
            zza(str3, str2, j, (Object) null);
            return;
        }
        int iZzi = zzgr().zzi(str2, obj);
        if (iZzi != 0) {
            zzgr();
            this.zzada.zzgr().zza(iZzi, "_ev", zzfx.zza(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
        } else {
            Object objZzj = zzgr().zzj(str2, obj);
            if (objZzj != null) {
                zza(str3, str2, j, objZzj);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @Nullable
    public final String zzag(long j) {
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot retrieve app instance id from analytics worker thread");
            return null;
        }
        if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot retrieve app instance id from main thread");
            return null;
        }
        long jElapsedRealtime = zzbx().elapsedRealtime();
        String strZzah = zzah(120000L);
        long jElapsedRealtime2 = zzbx().elapsedRealtime() - jElapsedRealtime;
        return (strZzah != null || jElapsedRealtime2 >= 120000) ? strZzah : zzah(120000 - jElapsedRealtime2);
    }

    public final void zzb(zzcy zzcyVar) {
        zzgg();
        zzcl();
        Preconditions.checkNotNull(zzcyVar);
        if (this.zzarc.remove(zzcyVar)) {
            return;
        }
        zzgt().zzjj().zzby("OnEventListener had not been registered");
    }

    public final void zzb(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzbx().currentTimeMillis());
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    final void zzcp(@Nullable String str) {
        this.zzare.set(str);
    }

    public final void zzd(boolean z) {
        zzcl();
        zzgg();
        zzgs().zzc(new zzdr(this, z));
    }

    @Nullable
    public final String zzgc() {
        zzgg();
        return this.zzare.get();
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

    public final List<zzfu> zzk(boolean z) {
        zzgg();
        zzcl();
        zzgt().zzjn().zzby("Fetching user attributes (FE)");
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzada.zzgs().zzc(new zzde(this, atomicReference, z));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e) {
                zzgt().zzjj().zzg("Interrupted waiting for get user properties", e);
            }
        }
        List<zzfu> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzgt().zzjj().zzby("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public final void zzkw() {
        if (getContext().getApplicationContext() instanceof Application) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzara);
        }
    }

    public final Boolean zzkx() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzgs().zza(atomicReference, 15000L, "boolean test flag value", new zzdb(this, atomicReference));
    }

    public final String zzky() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzgs().zza(atomicReference, 15000L, "String test flag value", new zzdl(this, atomicReference));
    }

    public final Long zzkz() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzgs().zza(atomicReference, 15000L, "long test flag value", new zzdn(this, atomicReference));
    }

    public final Integer zzla() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzgs().zza(atomicReference, 15000L, "int test flag value", new zzdo(this, atomicReference));
    }

    public final Double zzlb() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzgs().zza(atomicReference, 15000L, "double test flag value", new zzdp(this, atomicReference));
    }

    @WorkerThread
    public final void zzld() {
        zzaf();
        zzgg();
        zzcl();
        if (this.zzada.zzkv()) {
            zzgl().zzld();
            this.zzarf = false;
            String strZzka = zzgu().zzka();
            if (TextUtils.isEmpty(strZzka)) {
                return;
            }
            zzgp().zzcl();
            if (strZzka.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzka);
            logEvent("auto", "_ou", bundle);
        }
    }
}
