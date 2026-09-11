package com.google.firebase.messaging;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.support.annotation.WorkerThread;
import com.tiket.git.MainActivity;
import com.tiket.git.R;

/* JADX INFO: loaded from: classes.dex */
public class Messaging extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    @WorkerThread
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getNotification() != null) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            Notification.Builder contentIntent = new Notification.Builder(this, getPackageName()).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(remoteMessage.getNotification().getTitle()).setContentText(remoteMessage.getNotification().getBody()).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setOnlyAlertOnce(true).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class).addFlags(67108864), 0));
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel(getPackageName(), getApplicationInfo().loadLabel(getPackageManager()).toString(), 4));
            }
            notificationManager.notify(0, contentIntent.build());
        }
    }
}
