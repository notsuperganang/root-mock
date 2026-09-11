package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
final class zzeu implements Runnable {
    private final /* synthetic */ ComponentName val$name;
    private final /* synthetic */ zzes zzasu;

    zzeu(zzes zzesVar, ComponentName componentName) {
        this.zzasu = zzesVar;
        this.val$name = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzasu.zzasl.onServiceDisconnected(this.val$name);
    }
}
