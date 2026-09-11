package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import com.tiket.git.R;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class zzan {
    private final Context zzac;

    @GuardedBy("this")
    private String zzcm;

    @GuardedBy("this")
    private String zzcn;

    @GuardedBy("this")
    private int zzco;

    @GuardedBy("this")
    private int zzcp = 0;

    public zzan(Context context) {
        this.zzac = context;
    }

    public static String zza(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] strArrSplit = applicationId.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String zza(KeyPair keyPair) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            bArrDigest[0] = (byte) ((bArrDigest[0] & 15) + R.styleable.AppCompatTheme_seekBarStyle);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private final void zzag() {
        synchronized (this) {
            PackageInfo packageInfoZze = zze(this.zzac.getPackageName());
            if (packageInfoZze != null) {
                this.zzcm = Integer.toString(packageInfoZze.versionCode);
                this.zzcn = packageInfoZze.versionName;
            }
        }
    }

    private final PackageInfo zze(String str) {
        try {
            return this.zzac.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("Failed to find package ").append(strValueOf).toString());
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004b A[Catch: all -> 0x0023, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0006, B:9:0x000a, B:11:0x001b, B:16:0x0026, B:18:0x002c, B:20:0x003f, B:22:0x0045, B:23:0x004b, B:25:0x005e, B:27:0x0064, B:28:0x006a, B:30:0x0077, B:31:0x007a, B:32:0x007d), top: B:34:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x006a A[Catch: all -> 0x0023, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0006, B:9:0x000a, B:11:0x001b, B:16:0x0026, B:18:0x002c, B:20:0x003f, B:22:0x0045, B:23:0x004b, B:25:0x005e, B:27:0x0064, B:28:0x006a, B:30:0x0077, B:31:0x007a, B:32:0x007d), top: B:34:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0077 A[Catch: all -> 0x0023, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0006, B:9:0x000a, B:11:0x001b, B:16:0x0026, B:18:0x002c, B:20:0x003f, B:22:0x0045, B:23:0x004b, B:25:0x005e, B:27:0x0064, B:28:0x006a, B:30:0x0077, B:31:0x007a, B:32:0x007d), top: B:34:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007d A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0006, B:9:0x000a, B:11:0x001b, B:16:0x0026, B:18:0x002c, B:20:0x003f, B:22:0x0045, B:23:0x004b, B:25:0x005e, B:27:0x0064, B:28:0x006a, B:30:0x0077, B:31:0x007a, B:32:0x007d), top: B:34:0x0002 }] */
    public final int zzac() {
        List<ResolveInfo> listQueryBroadcastReceivers;
        int i = 0;
        synchronized (this) {
            if (this.zzcp != 0) {
                i = this.zzcp;
            } else {
                PackageManager packageManager = this.zzac.getPackageManager();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                    Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
                } else if (PlatformVersion.isAtLeastO()) {
                    Intent intent = new Intent("com.google.iid.TOKEN_REQUEST");
                    intent.setPackage("com.google.android.gms");
                    listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
                    if (listQueryBroadcastReceivers != null) {
                        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
                        if (PlatformVersion.isAtLeastO()) {
                            this.zzcp = 2;
                        } else {
                            this.zzcp = 1;
                        }
                        i = this.zzcp;
                    } else {
                        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
                        if (PlatformVersion.isAtLeastO()) {
                            this.zzcp = 2;
                        } else {
                            this.zzcp = 1;
                        }
                        i = this.zzcp;
                    }
                } else {
                    Intent intent2 = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent2.setPackage("com.google.android.gms");
                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent2, 0);
                    if (listQueryIntentServices == null || listQueryIntentServices.size() <= 0) {
                        Intent intent3 = new Intent("com.google.iid.TOKEN_REQUEST");
                        intent3.setPackage("com.google.android.gms");
                        listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent3, 0);
                        if (listQueryBroadcastReceivers != null || listQueryBroadcastReceivers.size() <= 0) {
                            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
                            if (PlatformVersion.isAtLeastO()) {
                                this.zzcp = 2;
                            } else {
                                this.zzcp = 1;
                            }
                            i = this.zzcp;
                        } else {
                            this.zzcp = 2;
                            i = this.zzcp;
                        }
                    } else {
                        this.zzcp = 1;
                        i = this.zzcp;
                    }
                }
            }
        }
        return i;
    }

    public final String zzad() {
        String str;
        synchronized (this) {
            if (this.zzcm == null) {
                zzag();
            }
            str = this.zzcm;
        }
        return str;
    }

    public final String zzae() {
        String str;
        synchronized (this) {
            if (this.zzcn == null) {
                zzag();
            }
            str = this.zzcn;
        }
        return str;
    }

    public final int zzaf() {
        int i;
        PackageInfo packageInfoZze;
        synchronized (this) {
            if (this.zzco == 0 && (packageInfoZze = zze("com.google.android.gms")) != null) {
                this.zzco = packageInfoZze.versionCode;
            }
            i = this.zzco;
        }
        return i;
    }
}
