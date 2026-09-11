package com.google.android.gms.security;

import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Hex;

/* JADX INFO: loaded from: classes.dex */
public class zzb {
    private static final String[] zza = {"CL4_XIOh3yCXXJUJpkfbaIYj3_s"};

    public static String zza() {
        try {
            return Hex.zza(Base64Utils.decodeUrlSafeNoPadding(zza[0]));
        } catch (Exception e) {
            return null;
        }
    }
}
