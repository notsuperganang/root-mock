package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.firebase_messaging.zzaa;
import com.google.android.gms.internal.firebase_messaging.zzab;
import com.google.android.gms.internal.firebase_messaging.zzn;
import com.google.android.gms.internal.firebase_messaging.zzo;
import com.google.android.gms.internal.firebase_messaging.zzp;
import com.google.android.gms.internal.firebase_messaging.zzq;
import com.google.android.gms.internal.firebase_messaging.zzr;
import com.google.android.gms.internal.firebase_messaging.zzu;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zza {
    private final Context zzac;
    private final Bundle zzcl;

    public zza(Context context, Bundle bundle) {
        this.zzac = context.getApplicationContext();
        this.zzcl = bundle;
    }

    private final Bundle zzas() {
        try {
            Bundle bundle = this.zzac.getPackageManager().getApplicationInfo(this.zzac.getPackageName(), 128).metaData;
            return bundle != null ? bundle : Bundle.EMPTY;
        } catch (PackageManager.NameNotFoundException e) {
            return Bundle.EMPTY;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006b A[EDGE_INSN: B:24:0x006b->B:21:0x0065 BREAK  A[LOOP:0: B:14:0x004e->B:31:?]] */
    final boolean zzar() {
        boolean z;
        zzq zzqVar = new zzq("FirebaseMessaging", this.zzcl);
        if ("1".equals(zzqVar.getString("gcm.n.noui"))) {
            return true;
        }
        if (!((KeyguardManager) this.zzac.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                SystemClock.sleep(10L);
            }
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.zzac.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                z = false;
                break;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == iMyPid) {
                    if (next.importance != 100) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        if (z) {
            return false;
        }
        PackageManager packageManager = this.zzac.getPackageManager();
        String packageName = this.zzac.getPackageName();
        ApplicationInfo applicationInfo = this.zzac.getApplicationInfo();
        zzab zzabVarZzax = new zzr(this.zzac, new zzaa(new zzu(this.zzcl, packageName).zzc(applicationInfo.icon).zza(applicationInfo.loadLabel(packageManager)).zzf(packageManager.getLaunchIntentForPackage(packageName)).zza(new zzn(this.zzac)).zza(new zzo(this.zzac)).zza(new zzb(this, (NotificationManager) this.zzac.getSystemService("notification"))).zzq("FCM-Notification").zzi(zzas()).zza(this.zzac.getResources()).zza(new zzp(this.zzac, this.zzcl)).zzd(applicationInfo.targetSdkVersion).zzbe(), zzqVar)).zzax();
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.zzac.getSystemService("notification")).notify(zzabVarZzax.tag, 0, zzabVarZzax.zzfd.build());
        return true;
    }
}
