package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
final class zzbv extends Thread {
    private final /* synthetic */ zzbr zzape;
    private final Object zzaph;
    private final BlockingQueue<zzbu<?>> zzapi;

    public zzbv(zzbr zzbrVar, String str, BlockingQueue<zzbu<?>> blockingQueue) {
        this.zzape = zzbrVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzaph = new Object();
        this.zzapi = blockingQueue;
        setName(str);
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzape.zzgt().zzjj().zzg(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.zzape.zzapa.acquire();
                z = true;
            } catch (InterruptedException e) {
                zza(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzbu<?> zzbuVarPoll = this.zzapi.poll();
                if (zzbuVarPoll == null) {
                    synchronized (this.zzaph) {
                        if (this.zzapi.peek() == null && !this.zzape.zzapb) {
                            try {
                                this.zzaph.wait(30000L);
                            } catch (InterruptedException e2) {
                                zza(e2);
                            }
                        }
                    }
                    synchronized (this.zzape.zzaoz) {
                        if (this.zzapi.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(zzbuVarPoll.zzapg ? threadPriority : 10);
                    zzbuVarPoll.run();
                }
            }
            synchronized (this.zzape.zzaoz) {
                this.zzape.zzapa.release();
                this.zzape.zzaoz.notifyAll();
                if (this == this.zzape.zzaot) {
                    zzbr.zza(this.zzape, null);
                } else if (this == this.zzape.zzaou) {
                    zzbr.zzb(this.zzape, null);
                } else {
                    this.zzape.zzgt().zzjg().zzby("Current scheduler thread is neither worker nor network");
                }
            }
        } catch (Throwable th) {
            synchronized (this.zzape.zzaoz) {
                this.zzape.zzapa.release();
                this.zzape.zzaoz.notifyAll();
                if (this == this.zzape.zzaot) {
                    zzbr.zza(this.zzape, null);
                } else if (this == this.zzape.zzaou) {
                    zzbr.zzb(this.zzape, null);
                } else {
                    this.zzape.zzgt().zzjg().zzby("Current scheduler thread is neither worker nor network");
                }
                throw th;
            }
        }
    }

    public final void zzki() {
        synchronized (this.zzaph) {
            this.zzaph.notifyAll();
        }
    }
}
