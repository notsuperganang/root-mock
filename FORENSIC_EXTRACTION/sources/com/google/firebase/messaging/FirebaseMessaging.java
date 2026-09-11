package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final Pattern zzdt = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private static FirebaseMessaging zzdu;
    private final FirebaseInstanceId zzdo;

    private FirebaseMessaging(FirebaseInstanceId firebaseInstanceId) {
        this.zzdo = firebaseInstanceId;
    }

    public static FirebaseMessaging getInstance() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            try {
                if (zzdu == null) {
                    zzdu = new FirebaseMessaging(FirebaseInstanceId.getInstance());
                }
                firebaseMessaging = zzdu;
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseMessaging;
    }

    public boolean isAutoInitEnabled() {
        return this.zzdo.zzq();
    }

    public void send(RemoteMessage remoteMessage) {
        if (TextUtils.isEmpty(remoteMessage.getTo())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        Intent intent2 = new Intent();
        intent2.setPackage("com.google.example.invalidpackage");
        intent.putExtra("app", PendingIntent.getBroadcast(applicationContext, 0, intent2, 0));
        intent.setPackage("com.google.android.gms");
        intent.putExtras(remoteMessage.zzdw);
        applicationContext.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public void setAutoInitEnabled(boolean z) {
        this.zzdo.zzb(z);
    }

    public Task<Void> subscribeToTopic(String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
            str = str.substring(8);
        }
        if (str == null || !zzdt.matcher(str).matches()) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 78).append("Invalid topic name: ").append(str).append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}").toString());
        }
        FirebaseInstanceId firebaseInstanceId = this.zzdo;
        String strValueOf = String.valueOf("S!");
        String strValueOf2 = String.valueOf(str);
        return firebaseInstanceId.zza(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
    }

    public Task<Void> unsubscribeFromTopic(String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in unsubscribeFromTopic.");
            str = str.substring(8);
        }
        if (str == null || !zzdt.matcher(str).matches()) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 78).append("Invalid topic name: ").append(str).append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}").toString());
        }
        FirebaseInstanceId firebaseInstanceId = this.zzdo;
        String strValueOf = String.valueOf("U!");
        String strValueOf2 = String.valueOf(str);
        return firebaseInstanceId.zza(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
    }
}
