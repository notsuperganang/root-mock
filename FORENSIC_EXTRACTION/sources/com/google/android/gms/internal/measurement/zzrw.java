package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zzrw {
    private static volatile UserManager zzbrb;
    private static volatile boolean zzbrc;

    static {
        zzbrc = !zztj();
    }

    private zzrw() {
    }

    public static boolean isUserUnlocked(Context context) {
        return !zztj() || zzab(context);
    }

    @RequiresApi(24)
    @TargetApi(24)
    private static boolean zzab(Context context) {
        boolean z;
        NullPointerException e;
        boolean z2 = zzbrc;
        if (z2) {
            return z2;
        }
        int i = 1;
        boolean z3 = z2;
        while (true) {
            if (i > 2) {
                z = z3;
                break;
            }
            UserManager userManagerZzac = zzac(context);
            if (userManagerZzac == null) {
                zzbrc = true;
                return true;
            }
            try {
                boolean z4 = userManagerZzac.isUserUnlocked() || !userManagerZzac.isUserRunning(Process.myUserHandle());
                try {
                    zzbrc = z4;
                    z = z4;
                    break;
                } catch (NullPointerException e2) {
                    e = e2;
                    z3 = z4;
                }
            } catch (NullPointerException e3) {
                e = e3;
            }
            Log.w("DirectBootUtils", "Failed to check if user is unlocked", e);
            zzbrb = null;
            i++;
        }
        if (!z) {
            return z;
        }
        zzbrb = null;
        return z;
    }

    @VisibleForTesting
    @RequiresApi(24)
    @TargetApi(24)
    private static UserManager zzac(Context context) {
        UserManager userManager = zzbrb;
        if (userManager == null) {
            synchronized (zzrw.class) {
                try {
                    userManager = zzbrb;
                    if (userManager == null) {
                        userManager = (UserManager) context.getSystemService(UserManager.class);
                        zzbrb = userManager;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return userManager;
    }

    public static boolean zztj() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
