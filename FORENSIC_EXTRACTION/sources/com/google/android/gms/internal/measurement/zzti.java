package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzti implements zztk {
    private zzti() {
    }

    /* synthetic */ zzti(zztf zztfVar) {
        this();
    }

    @Override // com.google.android.gms.internal.measurement.zztk
    public final byte[] zzc(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i + i2);
    }
}
