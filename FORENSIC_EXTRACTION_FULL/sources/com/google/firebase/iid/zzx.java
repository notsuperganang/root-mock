package com.google.firebase.iid;

/* JADX INFO: loaded from: classes.dex */
final class zzx implements InstanceIdResult {
    private final String zzbt;
    private final String zzbu;

    zzx(String str, String str2) {
        this.zzbt = str;
        this.zzbu = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getId() {
        return this.zzbt;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getToken() {
        return this.zzbu;
    }
}
