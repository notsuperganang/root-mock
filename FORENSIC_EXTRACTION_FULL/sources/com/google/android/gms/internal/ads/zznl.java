package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zznl implements Callable<Void> {
    private final /* synthetic */ Context val$context;

    zznl(Context context) {
        this.val$context = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        zzkb.zzik().initialize(this.val$context);
        return null;
    }
}
