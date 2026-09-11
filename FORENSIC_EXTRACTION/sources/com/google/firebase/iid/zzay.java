package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzay implements Runnable {
    private final zzba zzav;
    private final long zzdm;
    private final PowerManager.WakeLock zzdn = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId zzdo;

    @VisibleForTesting
    zzay(FirebaseInstanceId firebaseInstanceId, zzan zzanVar, zzba zzbaVar, long j) {
        this.zzdo = firebaseInstanceId;
        this.zzav = zzbaVar;
        this.zzdm = j;
        this.zzdn.setReferenceCounted(false);
    }

    @VisibleForTesting
    private final boolean zzam() {
        zzax zzaxVarZzk = this.zzdo.zzk();
        if (!this.zzdo.zzr() && !this.zzdo.zza(zzaxVarZzk)) {
            return true;
        }
        try {
            String strZzl = this.zzdo.zzl();
            if (strZzl == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (zzaxVarZzk != null && (zzaxVarZzk == null || strZzl.equals(zzaxVarZzk.zzbu))) {
                return true;
            }
            Context context = getContext();
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", strZzl);
            zzav.zzc(context, intent);
            zzav.zzb(context, new Intent("com.google.firebase.iid.TOKEN_REFRESH"));
            return true;
        } catch (IOException | SecurityException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseInstanceId", strValueOf.length() != 0 ? "Token retrieval failed: ".concat(strValueOf) : new String("Token retrieval failed: "));
            return false;
        }
    }

    final Context getContext() {
        return this.zzdo.zzi().getApplicationContext();
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public final void run() {
        boolean zZzd;
        try {
            if (zzav.zzai().zzd(getContext())) {
                this.zzdn.acquire();
            }
            this.zzdo.zza(true);
            if (!this.zzdo.zzo()) {
                this.zzdo.zza(false);
            } else {
                if (zzav.zzai().zze(getContext()) && !zzan()) {
                    new zzaz(this).zzao();
                    if (zZzd) {
                        return;
                    } else {
                        return;
                    }
                }
                if (zzam() && this.zzav.zzc(this.zzdo)) {
                    this.zzdo.zza(false);
                } else {
                    this.zzdo.zza(this.zzdm);
                }
            }
        } finally {
            if (zzav.zzai().zzd(getContext())) {
                this.zzdn.release();
            }
        }
    }

    final boolean zzan() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
