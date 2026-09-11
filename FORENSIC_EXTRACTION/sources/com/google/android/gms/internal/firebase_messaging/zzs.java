package com.google.android.gms.internal.firebase_messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class zzs {
    private final int targetSdkVersion;

    @NonNull
    private final Bundle zzcl;

    @NonNull
    private final String zzeq;

    @IdRes
    private final int zzer;
    private final CharSequence zzes;

    @Nullable
    private final Intent zzet;

    @NonNull
    private final Bundle zzeu;
    private final Resources zzev;

    @NonNull
    private final String zzew;
    private final zzx zzex;
    private final zzv zzey;
    private final zzy zzez;
    private final zzw zzfa;

    private zzs(zzu zzuVar) {
        this.zzcl = zzuVar.zzcl;
        this.zzeq = zzuVar.zzeq;
        this.zzer = zzuVar.zzer;
        this.targetSdkVersion = zzuVar.targetSdkVersion;
        this.zzes = zzuVar.zzes;
        this.zzet = zzuVar.zzet;
        this.zzeu = zzuVar.zzeu;
        this.zzev = zzuVar.zzev;
        this.zzey = zzuVar.zzey;
        this.zzfa = zzuVar.zzfa;
        this.zzez = zzuVar.zzez;
        this.zzew = zzuVar.zzew;
        this.zzex = zzuVar.zzex;
    }

    @NonNull
    public final CharSequence getAppLabel() {
        return this.zzes;
    }

    @NonNull
    public final Bundle getData() {
        return this.zzcl;
    }

    @NonNull
    public final String getPackageName() {
        return this.zzeq;
    }

    @Nullable
    final String zzat() {
        return this.zzfa.zzat();
    }

    @Nullable
    final PendingIntent zzau() {
        return this.zzez.zzau();
    }

    @NonNull
    public final Resources zzay() {
        return this.zzev;
    }

    @NonNull
    public final Bundle zzaz() {
        return this.zzeu;
    }

    @Nullable
    public final Integer zzb(@ColorRes int i) {
        return this.zzey.zzb(i);
    }

    @Nullable
    public final Intent zzba() {
        return this.zzet;
    }

    @IdRes
    public final int zzbb() {
        return this.zzer;
    }

    public final int zzbc() {
        return this.targetSdkVersion;
    }

    @NonNull
    public final String zzbd() {
        return this.zzew;
    }

    @Nullable
    final PendingIntent zze(Intent intent) {
        return this.zzez.zze(intent);
    }

    public final boolean zzl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.zzex.zzl(str);
    }
}
