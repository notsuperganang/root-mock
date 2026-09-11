package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzsc {
    public static <V> V zza(zzsd<V> zzsdVar) {
        try {
            return zzsdVar.zzto();
        } catch (SecurityException e) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzsdVar.zzto();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
