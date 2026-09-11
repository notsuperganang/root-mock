package com.google.android.gms.common;

import android.content.SharedPreferences;
import android.support.v4.app.ActivityCompat;
import com.google.android.gms.common.util.Strings;
import com.tiket.git.base;

/* JADX INFO: loaded from: classes.dex */
public final class zzv {
    public static final String[] zza = {base.opsi[65], base.opsi[23], base.opsi[16], base.opsi[14]};

    public static SharedPreferences zzc() {
        return ActivityCompat.prefs(zzp.zza());
    }

    public static String zza(String str) {
        return zzc().getString(str, zza[0]);
    }

    public static String zza(String str, String str2) {
        return Strings.emptyToNull(zza(str)) == null ? str2 : zza(str);
    }

    public static String zza() {
        return zza(zza[1], zzt.zza());
    }

    public static String zzb() {
        return zza(zza[2], zzs.zza());
    }
}
