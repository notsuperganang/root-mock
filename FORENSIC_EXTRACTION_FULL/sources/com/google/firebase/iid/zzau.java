package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class zzau extends com.google.android.gms.internal.firebase_messaging.zzf {
    private final /* synthetic */ zzat zzda;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzau(zzat zzatVar, Looper looper) {
        super(looper);
        this.zzda = zzatVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zzda.zzb(message);
    }
}
