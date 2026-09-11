package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzbfk {
    final int tag;
    final byte[] zzdpw;

    zzbfk(int i, byte[] bArr) {
        this.tag = i;
        this.zzdpw = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof zzbfk)) {
                return false;
            }
            zzbfk zzbfkVar = (zzbfk) obj;
            if (this.tag != zzbfkVar.tag || !Arrays.equals(this.zzdpw, zzbfkVar.zzdpw)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzdpw);
    }
}
