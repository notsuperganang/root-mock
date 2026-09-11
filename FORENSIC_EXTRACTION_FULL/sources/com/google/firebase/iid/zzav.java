package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class zzav {
    private static zzav zzdb;

    @GuardedBy("serviceClassNames")
    private final SimpleArrayMap<String, String> zzdc = new SimpleArrayMap<>();
    private Boolean zzdd = null;
    private Boolean zzde = null;
    final Queue<Intent> zzdf = new ArrayDeque();
    private final Queue<Intent> zzdg = new ArrayDeque();

    private zzav() {
    }

    private static Intent zza(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, (Class<?>) FirebaseInstanceIdReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    public static zzav zzai() {
        zzav zzavVar;
        synchronized (zzav.class) {
            try {
                if (zzdb == null) {
                    zzdb = new zzav();
                }
                zzavVar = zzdb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzavVar;
    }

    public static void zzb(Context context, Intent intent) {
        context.sendBroadcast(zza(context, "com.google.firebase.INSTANCE_ID_EVENT", intent));
    }

    public static void zzc(Context context, Intent intent) {
        context.sendBroadcast(zza(context, "com.google.firebase.MESSAGING_EVENT", intent));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ea  */
    private final int zzd(Context context, Intent intent) {
        String strConcat;
        String strValueOf;
        String str;
        ComponentName componentNameStartService;
        synchronized (this.zzdc) {
            strConcat = this.zzdc.get(intent.getAction());
        }
        if (strConcat != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                strValueOf = String.valueOf(strConcat);
                if (strValueOf.length() != 0) {
                    str = "Restricting intent to a specific service: ".concat(strValueOf);
                } else {
                    str = new String("Restricting intent to a specific service: ");
                }
                Log.d("FirebaseInstanceId", str);
            }
            intent.setClassName(context.getPackageName(), strConcat);
        } else {
            ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveInfoResolveService == null || resolveInfoResolveService.serviceInfo == null) {
                Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
            } else {
                ServiceInfo serviceInfo = resolveInfoResolveService.serviceInfo;
                if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                    String str2 = serviceInfo.packageName;
                    String str3 = serviceInfo.name;
                    Log.e("FirebaseInstanceId", new StringBuilder(String.valueOf(str2).length() + 94 + String.valueOf(str3).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(str2).append("/").append(str3).toString());
                } else {
                    strConcat = serviceInfo.name;
                    if (strConcat.startsWith(".")) {
                        String strValueOf2 = String.valueOf(context.getPackageName());
                        String strValueOf3 = String.valueOf(strConcat);
                        strConcat = strValueOf3.length() != 0 ? strValueOf2.concat(strValueOf3) : new String(strValueOf2);
                    }
                    synchronized (this.zzdc) {
                        this.zzdc.put(intent.getAction(), strConcat);
                    }
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        strValueOf = String.valueOf(strConcat);
                        if (strValueOf.length() != 0) {
                            str = "Restricting intent to a specific service: ".concat(strValueOf);
                        } else {
                            str = new String("Restricting intent to a specific service: ");
                        }
                        Log.d("FirebaseInstanceId", str);
                    }
                    intent.setClassName(context.getPackageName(), strConcat);
                }
            }
        }
        try {
            if (zzd(context)) {
                componentNameStartService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (IllegalStateException e) {
            String strValueOf4 = String.valueOf(e);
            Log.e("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf4).length() + 45).append("Failed to start service while in background: ").append(strValueOf4).toString());
            return 402;
        } catch (SecurityException e2) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e2);
            return 401;
        }
    }

    public final Intent zzaj() {
        return this.zzdg.poll();
    }

    public final int zzb(Context context, String str, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf = String.valueOf(str);
            Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Starting service: ".concat(strValueOf) : new String("Starting service: "));
        }
        switch (str) {
            case "com.google.firebase.INSTANCE_ID_EVENT":
                this.zzdf.offer(intent);
                break;
            case "com.google.firebase.MESSAGING_EVENT":
                this.zzdg.offer(intent);
                break;
            default:
                String strValueOf2 = String.valueOf(str);
                Log.w("FirebaseInstanceId", strValueOf2.length() != 0 ? "Unknown service action: ".concat(strValueOf2) : new String("Unknown service action: "));
                return 500;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return zzd(context, intent2);
    }

    final boolean zzd(Context context) {
        if (this.zzdd == null) {
            this.zzdd = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.zzdd.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.zzdd.booleanValue();
    }

    final boolean zze(Context context) {
        if (this.zzde == null) {
            this.zzde = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.zzdd.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.zzde.booleanValue();
    }
}
