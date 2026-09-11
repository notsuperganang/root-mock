package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzed implements Runnable {
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;
    private final /* synthetic */ AtomicReference zzasm;

    zzed(zzeb zzebVar, AtomicReference atomicReference, zzk zzkVar, boolean z) {
        this.zzasl = zzebVar;
        this.zzasm = atomicReference;
        this.zzaqn = zzkVar;
        this.zzaeg = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzasm) {
            try {
                try {
                    zzaj zzajVar = this.zzasl.zzasf;
                    if (zzajVar == null) {
                        this.zzasl.zzgt().zzjg().zzby("Failed to get user properties");
                        this.zzasm.notify();
                    } else {
                        this.zzasm.set(zzajVar.zza(this.zzaqn, this.zzaeg));
                        this.zzasl.zzcy();
                        this.zzasm.notify();
                    }
                } catch (RemoteException e) {
                    this.zzasl.zzgt().zzjg().zzg("Failed to get user properties", e);
                    this.zzasm.notify();
                }
            } catch (Throwable th) {
                this.zzasm.notify();
                throw th;
            }
        }
    }
}
