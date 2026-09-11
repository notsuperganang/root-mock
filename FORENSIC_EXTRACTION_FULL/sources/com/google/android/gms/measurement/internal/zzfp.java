package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzfp implements zzay {
    private final /* synthetic */ zzfn zzaug;
    private final /* synthetic */ String zzauh;

    zzfp(zzfn zzfnVar, String str) {
        this.zzaug = zzfnVar;
        this.zzauh = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzaug.zza(i, th, bArr, this.zzauh);
    }
}
