package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public class zzzo {
    public static zzzj zzbs(String str) throws RemoteException {
        try {
            return new zzzp((zzatg) Class.forName(str, false, zzzo.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable th) {
            throw new RemoteException();
        }
    }
}
