package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzek extends zzy {
    private final /* synthetic */ zzeb zzasl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzek(zzeb zzebVar, zzct zzctVar) {
        super(zzctVar);
        this.zzasl = zzebVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final void run() {
        this.zzasl.zzgt().zzjj().zzby("Tasks have been queued for a long time");
    }
}
