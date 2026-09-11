package com.google.firebase.iid;

import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzba {

    @GuardedBy("itself")
    private final zzaw zzao;

    @GuardedBy("this")
    private int zzdq = 0;

    @GuardedBy("this")
    private final Map<Integer, TaskCompletionSource<Void>> zzdr = new ArrayMap();

    zzba(zzaw zzawVar) {
        this.zzao = zzawVar;
    }

    @WorkerThread
    private static boolean zza(FirebaseInstanceId firebaseInstanceId, String str) {
        String[] strArrSplit = str.split("!");
        if (strArrSplit.length != 2) {
            return true;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        byte b = -1;
        try {
            switch (str2.hashCode()) {
                case 83:
                    if (str2.equals("S")) {
                        b = 0;
                    }
                    break;
                case 85:
                    if (str2.equals("U")) {
                        b = 1;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    firebaseInstanceId.zzb(str3);
                    if (!FirebaseInstanceId.zzm()) {
                        return true;
                    }
                    Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                    return true;
                case 1:
                    firebaseInstanceId.zzc(str3);
                    if (!FirebaseInstanceId.zzm()) {
                        return true;
                    }
                    Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                    return true;
                default:
                    return true;
            }
        } catch (IOException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseInstanceId", strValueOf.length() != 0 ? "Topic sync failed: ".concat(strValueOf) : new String("Topic sync failed: "));
            return false;
        }
    }

    @GuardedBy("this")
    @Nullable
    private final String zzaq() {
        String strZzak;
        synchronized (this.zzao) {
            strZzak = this.zzao.zzak();
        }
        if (!TextUtils.isEmpty(strZzak)) {
            String[] strArrSplit = strZzak.split(",");
            if (strArrSplit.length > 1 && !TextUtils.isEmpty(strArrSplit[1])) {
                return strArrSplit[1];
            }
        }
        return null;
    }

    private final boolean zzk(String str) {
        boolean z;
        synchronized (this) {
            synchronized (this.zzao) {
                String strZzak = this.zzao.zzak();
                String strValueOf = String.valueOf(",");
                String strValueOf2 = String.valueOf(str);
                if (strZzak.startsWith(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf))) {
                    String strValueOf3 = String.valueOf(",");
                    String strValueOf4 = String.valueOf(str);
                    this.zzao.zzf(strZzak.substring((strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3)).length()));
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    final Task<Void> zza(String str) {
        String strZzak;
        Task<Void> task;
        synchronized (this) {
            synchronized (this.zzao) {
                strZzak = this.zzao.zzak();
                this.zzao.zzf(new StringBuilder(String.valueOf(strZzak).length() + 1 + String.valueOf(str).length()).append(strZzak).append(",").append(str).toString());
            }
            TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
            this.zzdr.put(Integer.valueOf((TextUtils.isEmpty(strZzak) ? 0 : strZzak.split(",").length - 1) + this.zzdq), taskCompletionSource);
            task = taskCompletionSource.getTask();
        }
        return task;
    }

    final boolean zzap() {
        boolean z;
        synchronized (this) {
            z = zzaq() != null;
        }
        return z;
    }

    @WorkerThread
    final boolean zzc(FirebaseInstanceId firebaseInstanceId) {
        TaskCompletionSource<Void> taskCompletionSourceRemove;
        while (true) {
            synchronized (this) {
                String strZzaq = zzaq();
                if (strZzaq == null) {
                    if (FirebaseInstanceId.zzm()) {
                        Log.d("FirebaseInstanceId", "topic sync succeeded");
                    }
                    return true;
                }
                if (!zza(firebaseInstanceId, strZzaq)) {
                    return false;
                }
                synchronized (this) {
                    taskCompletionSourceRemove = this.zzdr.remove(Integer.valueOf(this.zzdq));
                    zzk(strZzaq);
                    this.zzdq++;
                }
                if (taskCompletionSourceRemove != null) {
                    taskCompletionSourceRemove.setResult(null);
                }
            }
        }
    }
}
