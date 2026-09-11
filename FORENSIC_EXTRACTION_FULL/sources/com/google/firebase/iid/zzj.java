package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzj implements ThreadFactory {
    static final ThreadFactory zzaj = new zzj();

    private zzj() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return zzi.zza(runnable);
    }
}
