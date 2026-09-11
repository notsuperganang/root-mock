package com.google.android.gms.measurement.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
final class zzbu<V> extends FutureTask<V> implements Comparable<zzbu> {
    private final String zzapd;
    private final /* synthetic */ zzbr zzape;
    private final long zzapf;
    final boolean zzapg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbu(zzbr zzbrVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzape = zzbrVar;
        Preconditions.checkNotNull(str);
        this.zzapf = zzbr.zzapc.getAndIncrement();
        this.zzapd = str;
        this.zzapg = false;
        if (this.zzapf == Long.MAX_VALUE) {
            zzbrVar.zzgt().zzjg().zzby("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbu(zzbr zzbrVar, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzape = zzbrVar;
        Preconditions.checkNotNull(str);
        this.zzapf = zzbr.zzapc.getAndIncrement();
        this.zzapd = str;
        this.zzapg = z;
        if (this.zzapf == Long.MAX_VALUE) {
            zzbrVar.zzgt().zzjg().zzby("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(@NonNull zzbu zzbuVar) {
        zzbu zzbuVar2 = zzbuVar;
        if (this.zzapg != zzbuVar2.zzapg) {
            if (!this.zzapg) {
                return 1;
            }
        } else if (this.zzapf >= zzbuVar2.zzapf) {
            if (this.zzapf > zzbuVar2.zzapf) {
                return 1;
            }
            this.zzape.zzgt().zzjh().zzg("Two tasks share the same index. index", Long.valueOf(this.zzapf));
            return 0;
        }
        return -1;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.zzape.zzgt().zzjg().zzg(this.zzapd, th);
        if (th instanceof zzbs) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
