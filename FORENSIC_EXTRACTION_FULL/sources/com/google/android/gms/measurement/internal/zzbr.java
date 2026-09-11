package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzbr extends zzcs {
    private static final AtomicLong zzapc = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService zzadl;
    private zzbv zzaot;
    private zzbv zzaou;
    private final PriorityBlockingQueue<zzbu<?>> zzaov;
    private final BlockingQueue<zzbu<?>> zzaow;
    private final Thread.UncaughtExceptionHandler zzaox;
    private final Thread.UncaughtExceptionHandler zzaoy;
    private final Object zzaoz;
    private final Semaphore zzapa;
    private volatile boolean zzapb;

    zzbr(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzaoz = new Object();
        this.zzapa = new Semaphore(2);
        this.zzaov = new PriorityBlockingQueue<>();
        this.zzaow = new LinkedBlockingQueue();
        this.zzaox = new zzbt(this, "Thread death: Uncaught exception on worker thread");
        this.zzaoy = new zzbt(this, "Thread death: Uncaught exception on network thread");
    }

    static /* synthetic */ zzbv zza(zzbr zzbrVar, zzbv zzbvVar) {
        zzbrVar.zzaot = null;
        return null;
    }

    private final void zza(zzbu<?> zzbuVar) {
        synchronized (this.zzaoz) {
            this.zzaov.add(zzbuVar);
            if (this.zzaot == null) {
                this.zzaot = new zzbv(this, "Measurement Worker", this.zzaov);
                this.zzaot.setUncaughtExceptionHandler(this.zzaox);
                this.zzaot.start();
            } else {
                this.zzaot.zzki();
            }
        }
    }

    static /* synthetic */ zzbv zzb(zzbr zzbrVar, zzbv zzbvVar) {
        zzbrVar.zzaou = null;
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    final <T> T zza(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzgs().zzc(runnable);
            try {
                atomicReference.wait(15000L);
            } catch (InterruptedException e) {
                zzau zzauVarZzjj = zzgt().zzjj();
                String strValueOf = String.valueOf(str);
                zzauVarZzjj.zzby(strValueOf.length() != 0 ? "Interrupted waiting for ".concat(strValueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzau zzauVarZzjj2 = zzgt().zzjj();
            String strValueOf2 = String.valueOf(str);
            zzauVarZzjj2.zzby(strValueOf2.length() != 0 ? "Timed out waiting for ".concat(strValueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final void zzaf() {
        if (Thread.currentThread() != this.zzaot) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzcl();
        Preconditions.checkNotNull(callable);
        zzbu<?> zzbuVar = new zzbu<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzaot) {
            if (!this.zzaov.isEmpty()) {
                zzgt().zzjj().zzby("Callable skipped the worker queue.");
            }
            zzbuVar.run();
        } else {
            zza(zzbuVar);
        }
        return zzbuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final <V> Future<V> zzc(Callable<V> callable) throws IllegalStateException {
        zzcl();
        Preconditions.checkNotNull(callable);
        zzbu<?> zzbuVar = new zzbu<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzaot) {
            zzbuVar.run();
        } else {
            zza(zzbuVar);
        }
        return zzbuVar;
    }

    public final void zzc(Runnable runnable) throws IllegalStateException {
        zzcl();
        Preconditions.checkNotNull(runnable);
        zza(new zzbu<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzd(Runnable runnable) throws IllegalStateException {
        zzcl();
        Preconditions.checkNotNull(runnable);
        zzbu<?> zzbuVar = new zzbu<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzaoz) {
            this.zzaow.add(zzbuVar);
            if (this.zzaou == null) {
                this.zzaou = new zzbv(this, "Measurement Network", this.zzaow);
                this.zzaou.setUncaughtExceptionHandler(this.zzaoy);
                this.zzaou.start();
            } else {
                this.zzaou.zzki();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final void zzgh() {
        if (Thread.currentThread() != this.zzaou) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfx zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.zzcs
    protected final boolean zzgy() {
        return false;
    }

    public final boolean zzkf() {
        return Thread.currentThread() == this.zzaot;
    }

    public final ExecutorService zzkg() {
        ExecutorService executorService;
        synchronized (this.zzaoz) {
            if (this.zzadl == null) {
                this.zzadl = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.zzadl;
        }
        return executorService;
    }
}
