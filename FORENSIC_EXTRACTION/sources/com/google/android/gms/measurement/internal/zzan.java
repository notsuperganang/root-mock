package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzan {
    public final String origin;
    public final long zzade;
    public final long zzadf;
    public final boolean zzadg;
    public final String zzadh;
    public final String zzadi;
    public final Bundle zzadj;

    zzan(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.zzade = j;
        this.zzadf = j2;
        this.zzadg = z;
        this.zzadh = str;
        this.origin = str2;
        this.zzadi = str3;
        this.zzadj = bundle;
    }

    public static final zzan zzc(Bundle bundle) {
        return new zzan(0L, 0L, true, null, null, null, bundle);
    }
}
