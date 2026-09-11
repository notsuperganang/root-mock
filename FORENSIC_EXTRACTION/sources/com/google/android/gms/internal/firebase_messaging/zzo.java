package com.google.android.gms.internal.firebase_messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: loaded from: classes.dex */
public final class zzo implements zzw {
    private final Context zzac;

    public zzo(Context context) {
        this.zzac = context;
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzw
    @TargetApi(26)
    @Nullable
    public final String zzat() {
        boolean z;
        if (!PlatformVersion.isAtLeastO()) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.zzac.getSystemService(NotificationManager.class);
        if (PlatformVersion.isAtLeastO()) {
            z = (TextUtils.isEmpty("fcm_fallback_notification_channel") || notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) ? false : true;
        } else {
            z = true;
        }
        if (!z) {
            ((NotificationManager) this.zzac.getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.zzac.getString(this.zzac.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", this.zzac.getPackageName())), 3));
        }
        return "fcm_fallback_notification_channel";
    }
}
