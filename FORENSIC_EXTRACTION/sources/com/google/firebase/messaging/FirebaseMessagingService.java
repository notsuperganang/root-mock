package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.firebase_messaging.zzac;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzab;
import com.google.firebase.iid.zzav;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessagingService extends com.google.firebase.iid.zzb {
    private static final Queue<String> zzdv = new ArrayDeque(10);

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(String str) {
    }

    @WorkerThread
    public void onNewToken(String str) {
    }

    @WorkerThread
    public void onSendError(String str, Exception exc) {
    }

    @Override // com.google.firebase.iid.zzb
    protected final Intent zzb(Intent intent) {
        return zzav.zzai().zzaj();
    }

    @Override // com.google.firebase.iid.zzb
    public final boolean zzc(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (MessagingAnalytics.shouldUploadMetrics(intent)) {
            MessagingAnalytics.logNotificationOpen(intent);
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0043  */
    @Override // com.google.firebase.iid.zzb
    public final void zzd(Intent intent) {
        Task<Void> taskZza;
        boolean z;
        byte b = 0;
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(action) && !"com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(action)) {
                if (MessagingAnalytics.shouldUploadMetrics(intent)) {
                    MessagingAnalytics.logNotificationDismiss(intent);
                    return;
                }
                return;
            } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                onNewToken(intent.getStringExtra("token"));
                return;
            } else {
                String strValueOf = String.valueOf(intent.getAction());
                Log.d("FirebaseMessaging", strValueOf.length() != 0 ? "Unknown intent action: ".concat(strValueOf) : new String("Unknown intent action: "));
                return;
            }
        }
        String stringExtra = intent.getStringExtra("google.message_id");
        if (TextUtils.isEmpty(stringExtra)) {
            taskZza = Tasks.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            taskZza = zzab.zzc(this).zza(2, bundle);
        }
        if (TextUtils.isEmpty(stringExtra)) {
            z = false;
        } else if (zzdv.contains(stringExtra)) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String strValueOf2 = String.valueOf(stringExtra);
                Log.d("FirebaseMessaging", strValueOf2.length() != 0 ? "Received duplicate message: ".concat(strValueOf2) : new String("Received duplicate message: "));
            }
            z = true;
        } else {
            if (zzdv.size() >= 10) {
                zzdv.remove();
            }
            zzdv.add(stringExtra);
            z = false;
        }
        if (!z) {
            String stringExtra2 = intent.getStringExtra("message_type");
            if (stringExtra2 == null) {
                stringExtra2 = "gcm";
            }
            switch (stringExtra2.hashCode()) {
                case -2062414158:
                    if (!stringExtra2.equals("deleted_messages")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 102161:
                    if (!stringExtra2.equals("gcm")) {
                        b = -1;
                    }
                    break;
                case 814694033:
                    if (!stringExtra2.equals("send_error")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 814800675:
                    if (!stringExtra2.equals("send_event")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    if (MessagingAnalytics.shouldUploadMetrics(intent)) {
                        MessagingAnalytics.logNotificationReceived(intent);
                    }
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    extras.remove("android.support.content.wakelockid");
                    if (!zzac.zzj(extras)) {
                        onMessageReceived(new RemoteMessage(extras));
                    } else if (!new zza(this, extras).zzar()) {
                        if (MessagingAnalytics.shouldUploadMetrics(intent)) {
                            MessagingAnalytics.logNotificationForeground(intent);
                        }
                        onMessageReceived(new RemoteMessage(extras));
                    }
                    break;
                case 1:
                    onDeletedMessages();
                    break;
                case 2:
                    onMessageSent(intent.getStringExtra("google.message_id"));
                    break;
                case 3:
                    String stringExtra3 = intent.getStringExtra("google.message_id");
                    if (stringExtra3 == null) {
                        stringExtra3 = intent.getStringExtra("message_id");
                    }
                    onSendError(stringExtra3, new SendException(intent.getStringExtra("error")));
                    break;
                default:
                    String strValueOf3 = String.valueOf(stringExtra2);
                    Log.w("FirebaseMessaging", strValueOf3.length() != 0 ? "Received message with unknown type: ".concat(strValueOf3) : new String("Received message with unknown type: "));
                    break;
            }
        }
        try {
            Tasks.await(taskZza, 1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            String strValueOf4 = String.valueOf(e);
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(strValueOf4).length() + 20).append("Message ack failed: ").append(strValueOf4).toString());
        }
    }
}
