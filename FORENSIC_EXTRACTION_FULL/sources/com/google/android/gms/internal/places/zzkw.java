package com.google.android.gms.internal.places;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzkw {
    final int tag;
    final byte[] zzoa;

    zzkw(int i, byte[] bArr) {
        this.tag = i;
        this.zzoa = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkw)) {
            return false;
        }
        zzkw zzkwVar = (zzkw) obj;
        return this.tag == zzkwVar.tag && Arrays.equals(this.zzoa, zzkwVar.zzoa);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzoa);
    }
}
