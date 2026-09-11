package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;

/* JADX INFO: loaded from: classes.dex */
final class zzff extends zzy {
    private final /* synthetic */ zzfd zzatf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzff(zzfd zzfdVar, zzct zzctVar) {
        super(zzctVar);
        this.zzatf = zzfdVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    @WorkerThread
    public final void run() {
        this.zzatf.zzlq();
    }
}
