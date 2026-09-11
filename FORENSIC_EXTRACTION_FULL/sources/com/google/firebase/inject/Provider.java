package com.google.firebase.inject;

import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public interface Provider<T> {
    @KeepForSdk
    T get();
}
