package com.google.android.gms.internal.firebase_messaging;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class zzr {

    @NonNull
    private final Context zzac;

    @NonNull
    private final zzz zzep;

    public zzr(@NonNull Context context, @NonNull zzz zzzVar) {
        this.zzac = context;
        this.zzep = zzzVar;
    }

    public final zzab zzax() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.zzac, this.zzep.getChannelId());
        builder.setAutoCancel(true);
        builder.setContentTitle(this.zzep.getTitle());
        builder.setContentIntent(this.zzep.zzbh());
        builder.setSmallIcon(this.zzep.zzbj().intValue());
        PendingIntent pendingIntentZzbi = this.zzep.zzbi();
        if (pendingIntentZzbi != null) {
            builder.setDeleteIntent(pendingIntentZzbi);
        }
        Uri sound = this.zzep.getSound();
        if (sound != null) {
            builder.setSound(sound);
        }
        CharSequence charSequenceZzbf = this.zzep.zzbf();
        if (!TextUtils.isEmpty(charSequenceZzbf)) {
            builder.setContentText(charSequenceZzbf);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(charSequenceZzbf));
        }
        Integer numZzbg = this.zzep.zzbg();
        if (numZzbg != null) {
            builder.setColor(numZzbg.intValue());
        }
        return new zzab(builder, this.zzep.getTag(), 0);
    }
}
