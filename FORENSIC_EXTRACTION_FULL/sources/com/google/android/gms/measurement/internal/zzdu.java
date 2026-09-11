package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
@MainThread
final class zzdu implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzda zzarh;

    private zzdu(zzda zzdaVar) {
        this.zzarh = zzdaVar;
    }

    /* synthetic */ zzdu(zzda zzdaVar, zzdb zzdbVar) {
        this(zzdaVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Uri data;
        boolean z = true;
        try {
            this.zzarh.zzgt().zzjo().zzby("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                if (bundle == null) {
                    Bundle bundleZza = this.zzarh.zzgr().zza(data);
                    this.zzarh.zzgr();
                    String str = zzfx.zzc(intent) ? "gs" : "auto";
                    if (bundleZza != null) {
                        this.zzarh.logEvent(str, "_cmp", bundleZza);
                    }
                }
                String queryParameter = data.getQueryParameter("referrer");
                if (TextUtils.isEmpty(queryParameter)) {
                    return;
                }
                if (!queryParameter.contains("gclid") || (!queryParameter.contains("utm_campaign") && !queryParameter.contains("utm_source") && !queryParameter.contains("utm_medium") && !queryParameter.contains("utm_term") && !queryParameter.contains("utm_content"))) {
                    z = false;
                }
                if (!z) {
                    this.zzarh.zzgt().zzjn().zzby("Activity created with data 'referrer' param without gclid and at least one utm field");
                    return;
                } else {
                    this.zzarh.zzgt().zzjn().zzg("Activity created with referrer", queryParameter);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        this.zzarh.zzb("auto", "_ldl", (Object) queryParameter, true);
                    }
                }
            }
        } catch (Exception e) {
            this.zzarh.zzgt().zzjg().zzg("Throwable caught in onActivityCreated", e);
        }
        this.zzarh.zzgm().onActivityCreated(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zzarh.zzgm().onActivityDestroyed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.zzarh.zzgm().onActivityPaused(activity);
        zzfd zzfdVarZzgo = this.zzarh.zzgo();
        zzfdVarZzgo.zzgs().zzc(new zzfh(zzfdVarZzgo, zzfdVarZzgo.zzbx().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityResumed(Activity activity) {
        this.zzarh.zzgm().onActivityResumed(activity);
        zzfd zzfdVarZzgo = this.zzarh.zzgo();
        zzfdVarZzgo.zzgs().zzc(new zzfg(zzfdVarZzgo, zzfdVarZzgo.zzbx().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zzarh.zzgm().onActivitySaveInstanceState(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
