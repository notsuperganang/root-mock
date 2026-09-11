package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzef implements Runnable {
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;
    private final /* synthetic */ AtomicReference zzasm;

    zzef(zzeb zzebVar, AtomicReference atomicReference, zzk zzkVar) {
        this.zzasl = zzebVar;
        this.zzasm = atomicReference;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzasm) {
            try {
                try {
                    zzaj zzajVar = this.zzasl.zzasf;
                    if (zzajVar == null) {
                        this.zzasl.zzgt().zzjg().zzby("Failed to get app instance id");
                        this.zzasm.notify();
                        return;
                    }
                    this.zzasm.set(zzajVar.zzc(this.zzaqn));
                    String str = (String) this.zzasm.get();
                    if (str != null) {
                        this.zzasl.zzgj().zzcp(str);
                        this.zzasl.zzgu().zzanj.zzcd(str);
                    }
                    this.zzasl.zzcy();
                    this.zzasm.notify();
                } catch (RemoteException e) {
                    this.zzasl.zzgt().zzjg().zzg("Failed to get app instance id", e);
                    this.zzasm.notify();
                }
            } catch (Throwable th) {
                this.zzasm.notify();
                throw th;
            }
        }
    }
}
