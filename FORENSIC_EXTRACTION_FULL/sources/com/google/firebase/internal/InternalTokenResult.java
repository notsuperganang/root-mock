package com.google.firebase.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class InternalTokenResult {
    private String token;

    @KeepForSdk
    public InternalTokenResult(@Nullable String str) {
        this.token = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalTokenResult) {
            return Objects.equal(this.token, ((InternalTokenResult) obj).token);
        }
        return false;
    }

    @KeepForSdk
    @Nullable
    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        return Objects.hashCode(this.token);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("token", this.token).toString();
    }
}
