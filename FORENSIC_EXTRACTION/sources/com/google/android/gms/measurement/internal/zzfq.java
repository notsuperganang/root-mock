package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzfq implements zzay {
    private final /* synthetic */ zzfn zzaug;

    zzfq(zzfn zzfnVar) {
        this.zzaug = zzfnVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzaug.zzb(str, i, th, bArr, map);
    }
}
