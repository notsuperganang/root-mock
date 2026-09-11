package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzxc extends RuntimeException {
    private final List<String> zzccg;

    public zzxc(zzvv zzvvVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzccg = null;
    }
}
