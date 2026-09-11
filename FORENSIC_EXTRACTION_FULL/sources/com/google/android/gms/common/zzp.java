package com.google.android.gms.common;

import android.content.Context;
import com.google.firebase.FirebaseApp;

/* JADX INFO: loaded from: classes.dex */
public class zzp {
    public static Context zza() {
        try {
            return FirebaseApp.getInstance().getApplicationContext();
        } catch (Exception e) {
            return null;
        }
    }
}
