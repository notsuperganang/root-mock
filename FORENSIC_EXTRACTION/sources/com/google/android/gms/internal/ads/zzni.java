package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes.dex */
@ParametersAreNonnullByDefault
@zzadh
public final class zzni {
    private Context zzatx;
    private final Object mLock = new Object();
    private final ConditionVariable zzatv = new ConditionVariable();
    private volatile boolean zzzv = false;

    @Nullable
    private SharedPreferences zzatw = null;

    public final void initialize(Context context) {
        if (this.zzzv) {
            return;
        }
        synchronized (this.mLock) {
            if (this.zzzv) {
                return;
            }
            this.zzatx = context.getApplicationContext() == null ? context : context.getApplicationContext();
            try {
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext != null || context == null) {
                    context = remoteContext;
                } else {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (context == null) {
                    this.zzatv.open();
                    return;
                }
                zzkb.zzii();
                this.zzatw = context.getSharedPreferences("google_ads_flags", 0);
                this.zzzv = true;
                this.zzatv.open();
            } catch (Throwable th) {
                this.zzatv.open();
                throw th;
            }
        }
    }

    public final <T> T zzd(zzna<T> zznaVar) {
        if (!this.zzatv.block(5000L)) {
            throw new IllegalStateException("Flags.initialize() was not called!");
        }
        if (!this.zzzv || this.zzatw == null) {
            synchronized (this.mLock) {
                if (!this.zzzv || this.zzatw == null) {
                    return zznaVar.zzja();
                }
            }
        }
        return (T) zzaml.zza(this.zzatx, new zznj(this, zznaVar));
    }
}
