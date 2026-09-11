package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbj {
    final zzbw zzada;

    zzbj(zzbw zzbwVar) {
        this.zzada = zzbwVar;
    }

    @VisibleForTesting
    private final boolean zzke() {
        boolean z = false;
        try {
            PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(this.zzada.getContext());
            if (packageManagerWrapperPackageManager == null) {
                this.zzada.zzgt().zzjm().zzby("Failed to retrieve Package Manager to check Play Store compatibility");
            } else if (packageManagerWrapperPackageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                z = true;
            }
        } catch (Exception e) {
            this.zzada.zzgt().zzjm().zzg("Failed to retrieve Play Store version", e);
        }
        return z;
    }

    @WorkerThread
    @VisibleForTesting
    @Nullable
    final Bundle zza(String str, com.google.android.gms.internal.measurement.zzu zzuVar) {
        this.zzada.zzgs().zzaf();
        if (zzuVar == null) {
            this.zzada.zzgt().zzjj().zzby("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle bundleZza = zzuVar.zza(bundle);
            if (bundleZza != null) {
                return bundleZza;
            }
            this.zzada.zzgt().zzjg().zzby("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.zzada.zzgt().zzjg().zzg("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }

    @WorkerThread
    protected final void zzce(String str) {
        if (str == null || str.isEmpty()) {
            this.zzada.zzgt().zzjm().zzby("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.zzada.zzgs().zzaf();
        if (!zzke()) {
            this.zzada.zzgt().zzjm().zzby("Install Referrer Reporter is not available");
            return;
        }
        this.zzada.zzgt().zzjm().zzby("Install Referrer Reporter is initializing");
        zzbk zzbkVar = new zzbk(this, str);
        this.zzada.zzgs().zzaf();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.zzada.getContext().getPackageManager();
        if (packageManager == null) {
            this.zzada.zzgt().zzjj().zzby("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            this.zzada.zzgt().zzjm().zzby("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
        if (resolveInfo.serviceInfo != null) {
            String str2 = resolveInfo.serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str2) || !zzke()) {
                this.zzada.zzgt().zzjm().zzby("Play Store missing or incompatible. Version 8.3.73 or later required");
                return;
            }
            try {
                this.zzada.zzgt().zzjm().zzg("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.zzada.getContext(), new Intent(intent), zzbkVar, 1) ? "available" : "not available");
            } catch (Exception e) {
                this.zzada.zzgt().zzjg().zzg("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }
}
