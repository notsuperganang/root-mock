package com.google.android.gms.internal.places;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzjp extends RuntimeException {
    private final List<String> zzxq;

    public zzjp(zzih zzihVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzxq = null;
    }
}
