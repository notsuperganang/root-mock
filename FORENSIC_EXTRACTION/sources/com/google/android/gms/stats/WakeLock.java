package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.stats.StatsUtils;
import com.google.android.gms.common.stats.WakeLockTracker;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@ThreadSafe
@KeepForSdk
public class WakeLock {
    private static ScheduledExecutorService zzn;
    private static volatile zza zzo = new com.google.android.gms.stats.zza();
    private final Object zza;
    private final PowerManager.WakeLock zzb;
    private WorkSource zzc;
    private final int zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final Context zzh;
    private boolean zzi;
    private final Map<String, Integer[]> zzj;
    private final Set<Future<?>> zzk;
    private int zzl;
    private AtomicInteger zzm;

    public interface zza {
    }

    @KeepForSdk
    public WakeLock(@NonNull Context context, int i, @NonNull String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    private WakeLock(@NonNull Context context, int i, @NonNull String str, @Nullable String str2, @NonNull String str3) {
        this(context, i, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private WakeLock(@NonNull Context context, int i, @NonNull String str, @Nullable String str2, @NonNull String str3, @Nullable String str4) {
        this.zza = this;
        this.zzi = true;
        this.zzj = new HashMap();
        this.zzk = Collections.synchronizedSet(new HashSet());
        this.zzm = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        this.zzd = i;
        this.zzf = null;
        this.zzg = null;
        this.zzh = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.zze = str;
        } else {
            String strValueOf = String.valueOf("*gcore*:");
            String strValueOf2 = String.valueOf(str);
            this.zze = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        }
        this.zzb = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            this.zzc = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(str3) ? context.getPackageName() : str3);
            WorkSource workSource = this.zzc;
            if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzh)) {
                if (this.zzc != null) {
                    this.zzc.add(workSource);
                } else {
                    this.zzc = workSource;
                }
                try {
                    this.zzb.setWorkSource(this.zzc);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                    Log.wtf("WakeLock", e.toString());
                }
            }
        }
        if (zzn == null) {
            zzn = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        }
    }

    private final String zza(String str) {
        return (!this.zzi || TextUtils.isEmpty(str)) ? this.zzf : str;
    }

    private final List<String> zza() {
        return WorkSourceUtil.getNames(this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i) {
        if (this.zzb.isHeld()) {
            try {
                this.zzb.release();
            } catch (RuntimeException e) {
                if (!e.getClass().equals(RuntimeException.class)) {
                    throw e;
                }
                Log.e("WakeLock", String.valueOf(this.zze).concat(" was already released!"), e);
            }
            this.zzb.isHeld();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004c A[Catch: all -> 0x009f, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0017, B:11:0x002b, B:13:0x002f, B:15:0x0039, B:21:0x0054, B:22:0x0074, B:28:0x008f, B:17:0x004c, B:19:0x0050, B:8:0x001b, B:10:0x0023), top: B:32:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0054 A[Catch: all -> 0x009f, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0017, B:11:0x002b, B:13:0x002f, B:15:0x0039, B:21:0x0054, B:22:0x0074, B:28:0x008f, B:17:0x004c, B:19:0x0050, B:8:0x001b, B:10:0x0023), top: B:32:0x000f }] */
    @KeepForSdk
    public void acquire(long j) {
        boolean z;
        this.zzm.incrementAndGet();
        String strZza = zza((String) null);
        synchronized (this.zza) {
            if ((!this.zzj.isEmpty() || this.zzl > 0) && !this.zzb.isHeld()) {
                this.zzj.clear();
                this.zzl = 0;
            }
            if (this.zzi) {
                Integer[] numArr = this.zzj.get(strZza);
                if (numArr == null) {
                    this.zzj.put(strZza, new Integer[]{1});
                    z = true;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                    z = false;
                }
                if (z) {
                    WakeLockTracker.getInstance().registerEvent(this.zzh, StatsUtils.getEventKey(this.zzb, strZza), 7, this.zze, strZza, null, this.zzd, zza(), j);
                    this.zzl++;
                } else if (!this.zzi) {
                    WakeLockTracker.getInstance().registerEvent(this.zzh, StatsUtils.getEventKey(this.zzb, strZza), 7, this.zze, strZza, null, this.zzd, zza(), j);
                    this.zzl++;
                }
            } else if (!this.zzi && this.zzl == 0) {
                WakeLockTracker.getInstance().registerEvent(this.zzh, StatsUtils.getEventKey(this.zzb, strZza), 7, this.zze, strZza, null, this.zzd, zza(), j);
                this.zzl++;
            }
        }
        this.zzb.acquire();
        if (j > 0) {
            zzn.schedule(new zzb(this), j, TimeUnit.MILLISECONDS);
        }
    }

    @KeepForSdk
    public boolean isHeld() {
        return this.zzb.isHeld();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0034 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:7:0x0023, B:9:0x0027, B:17:0x003c, B:18:0x005c, B:22:0x0062, B:24:0x006a, B:25:0x0071, B:13:0x0034, B:15:0x0038), top: B:29:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x003c A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:7:0x0023, B:9:0x0027, B:17:0x003c, B:18:0x005c, B:22:0x0062, B:24:0x006a, B:25:0x0071, B:13:0x0034, B:15:0x0038), top: B:29:0x0023 }] */
    @KeepForSdk
    public void release() {
        boolean z;
        if (this.zzm.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.zze).concat(" release without a matched acquire!"));
        }
        String strZza = zza((String) null);
        synchronized (this.zza) {
            if (this.zzi) {
                Integer[] numArr = this.zzj.get(strZza);
                if (numArr == null) {
                    z = false;
                } else if (numArr[0].intValue() == 1) {
                    this.zzj.remove(strZza);
                    z = true;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                    z = false;
                }
                if (z) {
                    WakeLockTracker.getInstance().registerEvent(this.zzh, StatsUtils.getEventKey(this.zzb, strZza), 8, this.zze, strZza, null, this.zzd, zza());
                    this.zzl--;
                } else if (!this.zzi) {
                    WakeLockTracker.getInstance().registerEvent(this.zzh, StatsUtils.getEventKey(this.zzb, strZza), 8, this.zze, strZza, null, this.zzd, zza());
                    this.zzl--;
                }
            } else if (!this.zzi && this.zzl == 1) {
                WakeLockTracker.getInstance().registerEvent(this.zzh, StatsUtils.getEventKey(this.zzb, strZza), 8, this.zze, strZza, null, this.zzd, zza());
                this.zzl--;
            }
        }
        zza(0);
    }

    @KeepForSdk
    public void setReferenceCounted(boolean z) {
        this.zzb.setReferenceCounted(z);
        this.zzi = z;
    }
}
