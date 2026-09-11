package com.google.android.gms.common.internal;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;

/* JADX INFO: loaded from: classes.dex */
public class zzu {
    public static void zza(Activity activity) {
        try {
            ActivityCompat.startActivity(activity);
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
