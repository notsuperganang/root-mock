package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.MainThread;

/* JADX INFO: loaded from: classes.dex */
public final class zzbk implements ServiceConnection {
    private final String packageName;
    final /* synthetic */ zzbj zzaoc;

    zzbk(zzbj zzbjVar, String str) {
        this.zzaoc = zzbjVar;
        this.packageName = str;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zzaoc.zzada.zzgt().zzjj().zzby("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzu zzuVarZza = com.google.android.gms.internal.measurement.zzv.zza(iBinder);
            if (zzuVarZza == null) {
                this.zzaoc.zzada.zzgt().zzjj().zzby("Install Referrer Service implementation was not found");
            } else {
                this.zzaoc.zzada.zzgt().zzjm().zzby("Install Referrer Service connected");
                this.zzaoc.zzada.zzgs().zzc(new zzbl(this, zzuVarZza, this));
            }
        } catch (Exception e) {
            this.zzaoc.zzada.zzgt().zzjj().zzg("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zzaoc.zzada.zzgt().zzjm().zzby("Install Referrer Service disconnected");
    }
}
