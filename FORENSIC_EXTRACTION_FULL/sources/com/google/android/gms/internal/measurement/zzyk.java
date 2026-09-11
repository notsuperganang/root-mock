package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzyk {
    final int tag;
    final byte[] zzbtz;

    zzyk(int i, byte[] bArr) {
        this.tag = i;
        this.zzbtz = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof zzyk)) {
                return false;
            }
            zzyk zzykVar = (zzyk) obj;
            if (this.tag != zzykVar.tag || !Arrays.equals(this.zzbtz, zzykVar.zzbtz)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzbtz);
    }
}
