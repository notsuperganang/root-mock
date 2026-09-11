package com.google.android.gms.common;

import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class zzr {
    public static String zza() {
        try {
            return Settings.Secure.getString(zzp.zza().getContentResolver(), "android_id");
        } catch (Exception e) {
            return null;
        }
    }
}
