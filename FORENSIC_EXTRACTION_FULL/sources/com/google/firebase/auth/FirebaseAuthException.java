package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import com.google.firebase.annotations.PublicApi;

/* JADX INFO: loaded from: classes.dex */
@PublicApi
public class FirebaseAuthException extends FirebaseException {
    private final String errorCode;

    @PublicApi
    public FirebaseAuthException(@NonNull String str, @NonNull String str2) {
        super(str2);
        this.errorCode = Preconditions.checkNotEmpty(str);
    }

    @NonNull
    @PublicApi
    public String getErrorCode() {
        return this.errorCode;
    }
}
