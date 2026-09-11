package com.google.android.gms.common;

import com.google.firebase.iid.FirebaseInstanceId;

/* JADX INFO: loaded from: classes.dex */
public class zzu {
    public static String zza() {
        try {
            return FirebaseInstanceId.getInstance().getToken();
        } catch (Exception e) {
            return null;
        }
    }
}
