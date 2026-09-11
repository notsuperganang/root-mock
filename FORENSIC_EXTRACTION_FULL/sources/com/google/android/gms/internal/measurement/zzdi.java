package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(24)
public final class zzdi {

    @Nullable
    private static final Method zzacv = zzfu();

    @Nullable
    private static final Method zzacw = zzfv();
    private static volatile zzdk zzacx = zzdj.zzacy;
    private final JobScheduler zzacu;

    private zzdi(JobScheduler jobScheduler) {
        this.zzacu = jobScheduler;
    }

    private final int zza(JobInfo jobInfo, String str, int i, String str2) {
        if (zzacv != null) {
            try {
                return ((Integer) zzacv.invoke(this.zzacu, jobInfo, str, Integer.valueOf(i), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.e(str2, "error calling scheduleAsPackage", e);
            }
        }
        return this.zzacu.schedule(jobInfo);
    }

    public static int zza(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        return (zzacv != null && zzacx.zzfy() && context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0) ? new zzdi(jobScheduler).zza(jobInfo, str, zzfw(), str2) : jobScheduler.schedule(jobInfo);
    }

    @Nullable
    private static Method zzfu() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
            } catch (NoSuchMethodException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                }
            }
        }
        return null;
    }

    @Nullable
    private static Method zzfv() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return UserHandle.class.getDeclaredMethod("myUserId", null);
        } catch (NoSuchMethodException e) {
            if (!Log.isLoggable("JobSchedulerCompat", 6)) {
                return null;
            }
            Log.e("JobSchedulerCompat", "No myUserId method available");
            return null;
        }
    }

    private static int zzfw() {
        if (zzacw != null) {
            try {
                return ((Integer) zzacw.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
            }
        }
        return 0;
    }

    static final /* synthetic */ boolean zzfx() {
        return false;
    }
}
