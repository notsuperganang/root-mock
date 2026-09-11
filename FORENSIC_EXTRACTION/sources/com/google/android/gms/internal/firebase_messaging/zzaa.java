package com.google.android.gms.internal.firebase_messaging;

import android.R;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Arrays;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa extends zzz {
    private final zzs zzfb;
    private final zzq zzfc;

    public zzaa(zzs zzsVar, zzq zzqVar) {
        this.zzfb = zzsVar;
        this.zzfc = zzqVar;
    }

    private static Integer zzb(CharSequence charSequence) {
        try {
            return Integer.valueOf(Color.parseColor(String.valueOf(charSequence)));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private final boolean zze(int i) {
        return i != 0 && this.zzfc.zza(this.zzfb.zzay(), i);
    }

    private final Intent zzr(String str) {
        return new Intent("android.intent.action.VIEW").setPackage(this.zzfb.getPackageName()).setData(Uri.parse(str));
    }

    private final String zzs(String str) {
        String string = this.zzfb.getData().getString(str);
        return string != null ? string : this.zzfb.getData().getString(str.replace("gcm.n.", "gcm.notification."));
    }

    private final String zzt(String str) {
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf("_loc_key");
        String strZzs = zzs(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        if (TextUtils.isEmpty(strZzs)) {
            return null;
        }
        int identifier = this.zzfb.zzay().getIdentifier(strZzs, "string", this.zzfb.getPackageName());
        if (identifier == 0) {
            String str2 = this.zzfc.zzeo;
            String strValueOf3 = String.valueOf(str);
            String strValueOf4 = String.valueOf("_loc_key");
            String strSubstring = (strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3)).substring(6);
            Log.w(str2, new StringBuilder(String.valueOf(strSubstring).length() + 49 + String.valueOf(str).length()).append(strSubstring).append(" resource not found: ").append(str).append(" Default value will be used.").toString());
            return null;
        }
        String[] strArrZzn = this.zzfc.zzn(str);
        if (strArrZzn == null) {
            return this.zzfb.zzay().getString(identifier);
        }
        try {
            return this.zzfb.zzay().getString(identifier, strArrZzn);
        } catch (MissingFormatArgumentException e) {
            String str3 = this.zzfc.zzeo;
            String string = Arrays.toString(strArrZzn);
            Log.w(str3, new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(string).length()).append("Missing format argument for ").append(str).append(": ").append(string).append(" Default value will be used.").toString(), e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzz
    @Nullable
    public final String getChannelId() {
        if (!PlatformVersion.isAtLeastO() || this.zzfb.zzbc() < 26) {
            return null;
        }
        String strZzs = zzs("gcm.n.android_channel_id");
        if (this.zzfb.zzl(strZzs)) {
            return strZzs;
        }
        if (!TextUtils.isEmpty("com.google.firebase.messaging.default_notification_channel_id")) {
            String string = this.zzfb.zzaz().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (this.zzfb.zzl(string)) {
                return string;
            }
        }
        String strZzat = this.zzfb.zzat();
        if (this.zzfb.zzl(strZzat)) {
            return strZzat;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0087  */
    @Override // com.google.android.gms.internal.firebase_messaging.zzz
    @Nullable
    public final Uri getSound() {
        Uri defaultUri;
        String strZzs = zzs("gcm.n.sound2");
        if (TextUtils.isEmpty(strZzs)) {
            strZzs = zzs("gcm.n.sound");
        }
        if (TextUtils.isEmpty(strZzs)) {
            return null;
        }
        if (TextUtils.isEmpty(strZzs)) {
            defaultUri = null;
        } else if ("default".equals(strZzs)) {
            defaultUri = RingtoneManager.getDefaultUri(2);
        } else {
            if (this.zzfb.zzay().getIdentifier(strZzs, "raw", this.zzfb.getPackageName()) != 0) {
                String packageName = this.zzfb.getPackageName();
                defaultUri = Uri.parse(new StringBuilder(String.valueOf(packageName).length() + 24 + String.valueOf(strZzs).length()).append("android.resource://").append(packageName).append("/raw/").append(strZzs).toString());
            } else {
                defaultUri = RingtoneManager.getDefaultUri(2);
            }
        }
        return defaultUri == null ? RingtoneManager.getDefaultUri(2) : defaultUri;
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzz
    @Nullable
    public final String getTag() {
        String strZzs = zzs("gcm.n.tag");
        if (!TextUtils.isEmpty(strZzs)) {
            return strZzs;
        }
        String strZzbd = this.zzfb.zzbd();
        return new StringBuilder(String.valueOf(strZzbd).length() + 21).append(strZzbd).append(":").append(SystemClock.uptimeMillis()).toString();
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzz
    @Nullable
    public final CharSequence getTitle() {
        String strZzs = zzs("gcm.n.title");
        if (!TextUtils.isEmpty(strZzs)) {
            return strZzs;
        }
        String strZzt = zzt("gcm.n.title");
        if (!TextUtils.isEmpty(strZzt)) {
            return strZzt;
        }
        CharSequence appLabel = this.zzfb.getAppLabel();
        return TextUtils.isEmpty(appLabel) ? "" : appLabel;
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzz
    @Nullable
    public final CharSequence zzbf() {
        String strZzs = zzs("gcm.n.body");
        if (!TextUtils.isEmpty(strZzs)) {
            return strZzs;
        }
        String strZzt = zzt("gcm.n.body");
        if (TextUtils.isEmpty(strZzt)) {
            return null;
        }
        return strZzt;
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzz
    @Nullable
    public final Integer zzbg() {
        int i;
        Integer numZzb;
        Integer numZzb2;
        String strZzs = zzs("gcm.n.color");
        if (!TextUtils.isEmpty(strZzs) && (numZzb2 = zzb(strZzs)) != null) {
            return numZzb2;
        }
        if (TextUtils.isEmpty("com.google.firebase.messaging.default_notification_color") || (i = this.zzfb.zzaz().getInt("com.google.firebase.messaging.default_notification_color", 0)) == 0 || (numZzb = this.zzfb.zzb(i)) == null) {
            return null;
        }
        return numZzb;
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzz
    @Nullable
    public final PendingIntent zzbh() {
        Intent intentZzr;
        String strZzs = zzs("gcm.n.click_action");
        if (TextUtils.isEmpty(strZzs)) {
            String strZzs2 = zzs("gcm.n.link_android");
            if (TextUtils.isEmpty(strZzs2)) {
                String strZzs3 = zzs("gcm.n.link");
                intentZzr = !TextUtils.isEmpty(strZzs3) ? zzr(strZzs3) : this.zzfb.zzba();
            } else {
                intentZzr = zzr(strZzs2);
            }
        } else {
            intentZzr = new Intent(strZzs).setPackage(this.zzfb.getPackageName()).setFlags(268435456);
        }
        if (intentZzr == null) {
            return null;
        }
        intentZzr.addFlags(67108864);
        Bundle bundle = new Bundle(this.zzfb.getData());
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && (next.startsWith("google.c.") || next.startsWith("gcm.n.") || next.startsWith("gcm.notification."))) {
                it.remove();
            }
        }
        intentZzr.putExtras(bundle);
        return this.zzfb.zze(intentZzr);
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzz
    @Nullable
    public final PendingIntent zzbi() {
        return this.zzfb.zzau();
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzz
    @Nullable
    public final Integer zzbj() {
        String strZzs = zzs("gcm.n.icon");
        if (!TextUtils.isEmpty(strZzs)) {
            for (int i = 0; i < 2; i++) {
                int identifier = this.zzfb.zzay().getIdentifier(strZzs, new String[]{"drawable", "mipmap"}[i], this.zzfb.getPackageName());
                if (zze(identifier)) {
                    return Integer.valueOf(identifier);
                }
            }
            Log.w(this.zzfc.zzeo, new StringBuilder(String.valueOf(strZzs).length() + 61).append("Icon resource ").append(strZzs).append(" not found. Notification will use default icon.").toString());
        }
        if (!TextUtils.isEmpty("com.google.firebase.messaging.default_notification_icon")) {
            int i2 = this.zzfb.zzaz().getInt("com.google.firebase.messaging.default_notification_icon", 0);
            if (zze(i2)) {
                return Integer.valueOf(i2);
            }
        }
        int iZzbb = this.zzfb.zzbb();
        return zze(iZzbb) ? Integer.valueOf(iZzbb) : Integer.valueOf(R.drawable.sym_def_app_icon);
    }
}
