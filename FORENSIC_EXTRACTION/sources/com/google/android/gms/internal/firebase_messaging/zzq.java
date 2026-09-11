package com.google.android.gms.internal.firebase_messaging;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class zzq {
    private final Bundle zzcl;
    final String zzeo;

    public zzq(String str, Bundle bundle) {
        this.zzeo = (String) Preconditions.checkNotNull(str);
        this.zzcl = (Bundle) Preconditions.checkNotNull(bundle);
    }

    @Nullable
    private final String zza(String... strArr) {
        for (String str : strArr) {
            String string = getString(str);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object[] zzo(String str) {
        Bundle bundle = this.zzcl;
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf("_loc_args");
        String strZza = zzac.zza(bundle, strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        if (TextUtils.isEmpty(strZza)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(strZza);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException e) {
            String str2 = this.zzeo;
            String strValueOf3 = String.valueOf(str);
            String strValueOf4 = String.valueOf("_loc_args");
            String strSubstring = (strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3)).substring(6);
            Log.w(str2, new StringBuilder(String.valueOf(strSubstring).length() + 41 + String.valueOf(strZza).length()).append("Malformed ").append(strSubstring).append(": ").append(strZza).append("  Default value will be used.").toString());
            return null;
        }
    }

    public final String getString(String str) {
        return zzac.zza(this.zzcl, str);
    }

    @TargetApi(26)
    final boolean zza(Resources resources, int i) {
        if (Build.VERSION.SDK_INT == 26) {
            try {
                if (resources.getDrawable(i, null) instanceof AdaptiveIconDrawable) {
                    Log.e(this.zzeo, new StringBuilder(77).append("Adaptive icons cannot be used in notifications. Ignoring icon id: ").append(i).toString());
                    return false;
                }
            } catch (Resources.NotFoundException e) {
                Log.e(this.zzeo, new StringBuilder(66).append("Couldn't find resource ").append(i).append(", treating it as an invalid icon").toString());
                return false;
            }
        }
        return true;
    }

    public final String zzav() {
        return zza("gcm.n.sound2", "gcm.n.sound");
    }

    @Nullable
    public final Uri zzaw() {
        String strZza = zza("gcm.n.link_android", "gcm.n.link");
        if (TextUtils.isEmpty(strZza)) {
            return null;
        }
        return Uri.parse(strZza);
    }

    public final String[] zzn(String str) {
        Object[] objArrZzo = zzo(str);
        if (objArrZzo == null) {
            return null;
        }
        String[] strArr = new String[objArrZzo.length];
        for (int i = 0; i < objArrZzo.length; i++) {
            strArr[i] = String.valueOf(objArrZzo[i]);
        }
        return strArr;
    }

    public final String zzp(String str) {
        Bundle bundle = this.zzcl;
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf("_loc_key");
        return zzac.zza(bundle, strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
    }
}
