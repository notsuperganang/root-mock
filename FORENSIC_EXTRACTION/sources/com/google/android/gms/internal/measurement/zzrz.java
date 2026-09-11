package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
final class zzrz extends ContentObserver {
    private final /* synthetic */ zzrx zzbrk;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzrz(zzrx zzrxVar, Handler handler) {
        super(null);
        this.zzbrk = zzrxVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zzbrk.zztl();
    }
}
