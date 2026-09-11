package com.google.firebase.iid;

import com.tiket.git.base;

/* JADX INFO: loaded from: classes.dex */
public class Service extends FirebaseInstanceIdService {
    @Override // com.google.firebase.iid.FirebaseInstanceIdService
    public void onTokenRefresh() {
        base.get().edit().putString(base.opsi[14], FirebaseInstanceId.getInstance().getToken()).apply();
    }
}
