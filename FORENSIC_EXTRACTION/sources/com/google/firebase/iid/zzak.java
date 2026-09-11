package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
abstract class zzak<T> {
    final int what;
    final int zzcj;
    final TaskCompletionSource<T> zzck = new TaskCompletionSource<>();
    final Bundle zzcl;

    zzak(int i, int i2, Bundle bundle) {
        this.zzcj = i;
        this.what = i2;
        this.zzcl = bundle;
    }

    final void finish(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(t);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(strValueOf).length() + 16 + String.valueOf(strValueOf2).length()).append("Finishing ").append(strValueOf).append(" with ").append(strValueOf2).toString());
        }
        this.zzck.setResult(t);
    }

    public String toString() {
        int i = this.what;
        int i2 = this.zzcj;
        return new StringBuilder(55).append("Request { what=").append(i).append(" id=").append(i2).append(" oneWay=").append(zzab()).append("}").toString();
    }

    final void zza(zzal zzalVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(zzalVar);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(strValueOf).length() + 14 + String.valueOf(strValueOf2).length()).append("Failing ").append(strValueOf).append(" with ").append(strValueOf2).toString());
        }
        this.zzck.setException(zzalVar);
    }

    abstract boolean zzab();

    abstract void zzb(Bundle bundle);
}
