package com.google.android.gms.common;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes.dex */
public class zzq {
    public static String zza() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(zzp.zza()).getId();
        } catch (Exception e) {
            return null;
        }
    }
}
