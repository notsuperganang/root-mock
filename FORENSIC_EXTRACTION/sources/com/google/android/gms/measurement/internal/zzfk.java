package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzfk extends zzy {
    private final /* synthetic */ zzfn zzata;
    private final /* synthetic */ zzfj zzath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfk(zzfj zzfjVar, zzct zzctVar, zzfn zzfnVar) {
        super(zzctVar);
        this.zzath = zzfjVar;
        this.zzata = zzfnVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final void run() {
        this.zzath.cancel();
        this.zzath.zzgt().zzjo().zzby("Starting upload from DelayedRunnable");
        this.zzata.zzlz();
    }
}
