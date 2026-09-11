package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;

/* JADX INFO: loaded from: classes.dex */
final class zzz {
    private final KeyPair zzbv;
    private final long zzbw;

    @VisibleForTesting
    zzz(KeyPair keyPair, long j) {
        this.zzbv = keyPair;
        this.zzbw = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzv() {
        return Base64.encodeToString(this.zzbv.getPublic().getEncoded(), 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzw() {
        return Base64.encodeToString(this.zzbv.getPrivate().getEncoded(), 11);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzz)) {
            return false;
        }
        zzz zzzVar = (zzz) obj;
        return this.zzbw == zzzVar.zzbw && this.zzbv.getPublic().equals(zzzVar.zzbv.getPublic()) && this.zzbv.getPrivate().equals(zzzVar.zzbv.getPrivate());
    }

    final long getCreationTime() {
        return this.zzbw;
    }

    final KeyPair getKeyPair() {
        return this.zzbv;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbv.getPublic(), this.zzbv.getPrivate(), Long.valueOf(this.zzbw));
    }
}
