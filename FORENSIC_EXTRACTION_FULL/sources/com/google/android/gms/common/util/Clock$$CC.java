package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class Clock$$CC {
    @KeepForSdk
    public static long currentThreadTimeMillis(Clock clock) {
        return SystemClock.currentThreadTimeMillis();
    }
}
