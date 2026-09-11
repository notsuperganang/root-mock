package com.google.android.gms.common;

import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

/* JADX INFO: loaded from: classes.dex */
public class zzt {
    public static String zza() {
        try {
            return Hex.zza(AndroidUtilsLight.getPackageCertificateHashBytes(zzp.zza(), zzp.zza().getPackageName()));
        } catch (Exception e) {
            return null;
        }
    }
}
