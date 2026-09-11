package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfc;

/* JADX INFO: loaded from: classes.dex */
public final class zzey<T extends Context & zzfc> {
    private final T zzaby;

    public zzey(T t) {
        Preconditions.checkNotNull(t);
        this.zzaby = t;
    }

    private final void zzb(Runnable runnable) {
        zzfn zzfnVarZzn = zzfn.zzn(this.zzaby);
        zzfnVarZzn.zzgs().zzc(new zzfb(this, zzfnVarZzn, runnable));
    }

    private final zzas zzgt() {
        return zzbw.zza(this.zzaby, (zzan) null).zzgt();
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            zzgt().zzjg().zzby("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzby(zzfn.zzn(this.zzaby));
        }
        zzgt().zzjj().zzg("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final void onCreate() {
        zzbw zzbwVarZza = zzbw.zza(this.zzaby, (zzan) null);
        zzas zzasVarZzgt = zzbwVarZza.zzgt();
        zzbwVarZza.zzgw();
        zzasVarZzgt.zzjo().zzby("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void onDestroy() {
        zzbw zzbwVarZza = zzbw.zza(this.zzaby, (zzan) null);
        zzas zzasVarZzgt = zzbwVarZza.zzgt();
        zzbwVarZza.zzgw();
        zzasVarZzgt.zzjo().zzby("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final void onRebind(Intent intent) {
        if (intent == null) {
            zzgt().zzjg().zzby("onRebind called with null intent");
        } else {
            zzgt().zzjo().zzg("onRebind called. action", intent.getAction());
        }
    }

    @MainThread
    public final int onStartCommand(final Intent intent, int i, final int i2) {
        zzbw zzbwVarZza = zzbw.zza(this.zzaby, (zzan) null);
        final zzas zzasVarZzgt = zzbwVarZza.zzgt();
        if (intent == null) {
            zzasVarZzgt.zzjj().zzby("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzbwVarZza.zzgw();
        zzasVarZzgt.zzjo().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        zzb(new Runnable(this, i2, zzasVarZzgt, intent) { // from class: com.google.android.gms.measurement.internal.zzez
            private final int zzacb;
            private final zzey zzasw;
            private final zzas zzasx;
            private final Intent zzasy;

            {
                this.zzasw = this;
                this.zzacb = i2;
                this.zzasx = zzasVarZzgt;
                this.zzasy = intent;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzasw.zza(this.zzacb, this.zzasx, this.zzasy);
            }
        });
        return 2;
    }

    @TargetApi(24)
    @MainThread
    public final boolean onStartJob(final JobParameters jobParameters) {
        zzbw zzbwVarZza = zzbw.zza(this.zzaby, (zzan) null);
        final zzas zzasVarZzgt = zzbwVarZza.zzgt();
        String string = jobParameters.getExtras().getString("action");
        zzbwVarZza.zzgw();
        zzasVarZzgt.zzjo().zzg("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zzb(new Runnable(this, zzasVarZzgt, jobParameters) { // from class: com.google.android.gms.measurement.internal.zzfa
            private final JobParameters zzace;
            private final zzey zzasw;
            private final zzas zzasz;

            {
                this.zzasw = this;
                this.zzasz = zzasVarZzgt;
                this.zzace = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzasw.zza(this.zzasz, this.zzace);
            }
        });
        return true;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzgt().zzjg().zzby("onUnbind called with null intent");
            return true;
        }
        zzgt().zzjo().zzg("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    final /* synthetic */ void zza(int i, zzas zzasVar, Intent intent) {
        if (this.zzaby.callServiceStopSelfResult(i)) {
            zzasVar.zzjo().zzg("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzgt().zzjo().zzby("Completed wakeful intent.");
            this.zzaby.zza(intent);
        }
    }

    final /* synthetic */ void zza(zzas zzasVar, JobParameters jobParameters) {
        zzasVar.zzjo().zzby("AppMeasurementJobService processed last upload request.");
        this.zzaby.zza(jobParameters, false);
    }
}
