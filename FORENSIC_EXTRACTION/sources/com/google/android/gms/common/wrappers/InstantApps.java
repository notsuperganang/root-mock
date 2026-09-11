package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class InstantApps {
    private static Context zzht;
    private static Boolean zzhu;

    @KeepForSdk
    public static boolean isInstantApp(Context context) {
        boolean zBooleanValue;
        synchronized (InstantApps.class) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (zzht == null || zzhu == null || zzht != applicationContext) {
                    zzhu = null;
                    if (PlatformVersion.isAtLeastO()) {
                        zzhu = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                    } else {
                        try {
                            context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                            zzhu = true;
                        } catch (ClassNotFoundException e) {
                            zzhu = false;
                        }
                    }
                    zzht = applicationContext;
                    zBooleanValue = zzhu.booleanValue();
                } else {
                    zBooleanValue = zzhu.booleanValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }
}
