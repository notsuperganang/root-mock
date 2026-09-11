package com.google.firebase.iid;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class zzaq {
    private final Executor executor;

    @GuardedBy("this")
    private final Map<Pair<String, String>, Task<InstanceIdResult>> zzcs = new ArrayMap();

    zzaq(Executor executor) {
        this.executor = executor;
    }

    final /* synthetic */ Task zza(Pair pair, Task task) throws Exception {
        synchronized (this) {
            this.zzcs.remove(pair);
        }
        return task;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final Task<InstanceIdResult> zza(String str, String str2, zzas zzasVar) {
        Task task;
        synchronized (this) {
            final Pair<String, String> pair = new Pair<>(str, str2);
            Task task2 = this.zzcs.get(pair);
            if (task2 == null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String strValueOf = String.valueOf(pair);
                    Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 24).append("Making new request for: ").append(strValueOf).toString());
                }
                Task taskContinueWithTask = zzasVar.zzs().continueWithTask(this.executor, new Continuation(this, pair) { // from class: com.google.firebase.iid.zzar
                    private final zzaq zzct;
                    private final Pair zzcu;

                    {
                        this.zzct = this;
                        this.zzcu = pair;
                    }

                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task3) {
                        return this.zzct.zza(this.zzcu, task3);
                    }
                });
                this.zzcs.put(pair, (Task<InstanceIdResult>) taskContinueWithTask);
                task = taskContinueWithTask;
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                task = task2;
                String strValueOf2 = String.valueOf(pair);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf2).length() + 29).append("Joining ongoing request for: ").append(strValueOf2).toString());
                task = task2;
            }
        }
        return task;
    }
}
