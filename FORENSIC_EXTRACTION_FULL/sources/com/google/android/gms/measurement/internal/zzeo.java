package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzeo implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzk zzaqn;
    private final /* synthetic */ zzeb zzasl;
    private final /* synthetic */ AtomicReference zzasm;

    zzeo(zzeb zzebVar, AtomicReference atomicReference, String str, String str2, String str3, zzk zzkVar) {
        this.zzasl = zzebVar;
        this.zzasm = atomicReference;
        this.zzagj = str;
        this.zzads = str2;
        this.zzadz = str3;
        this.zzaqn = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzasm) {
            try {
                try {
                    zzaj zzajVar = this.zzasl.zzasf;
                    if (zzajVar == null) {
                        this.zzasl.zzgt().zzjg().zzd("Failed to get conditional properties", zzas.zzbw(this.zzagj), this.zzads, this.zzadz);
                        this.zzasm.set(Collections.emptyList());
                        this.zzasm.notify();
                    } else {
                        if (TextUtils.isEmpty(this.zzagj)) {
                            this.zzasm.set(zzajVar.zza(this.zzads, this.zzadz, this.zzaqn));
                        } else {
                            this.zzasm.set(zzajVar.zze(this.zzagj, this.zzads, this.zzadz));
                        }
                        this.zzasl.zzcy();
                        this.zzasm.notify();
                    }
                } catch (RemoteException e) {
                    this.zzasl.zzgt().zzjg().zzd("Failed to get conditional properties", zzas.zzbw(this.zzagj), this.zzads, e);
                    this.zzasm.set(Collections.emptyList());
                    this.zzasm.notify();
                }
            } catch (Throwable th) {
                this.zzasm.notify();
                throw th;
            }
        }
    }
}
