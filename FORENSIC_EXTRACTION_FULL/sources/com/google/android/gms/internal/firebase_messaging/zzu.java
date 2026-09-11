package com.google.android.gms.internal.firebase_messaging;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class zzu {

    @NonNull
    private final Bundle zzcl;

    @NonNull
    private final String zzeq;
    private int zzer;
    private CharSequence zzes;
    private Intent zzet;
    private Resources zzev;
    private String zzew;
    private zzx zzex;
    private zzv zzey;
    private zzy zzez;
    private zzw zzfa;

    @NonNull
    private Bundle zzeu = Bundle.EMPTY;
    private int targetSdkVersion = -1;

    public zzu(@NonNull Bundle bundle, @NonNull String str) {
        this.zzcl = (Bundle) Preconditions.checkNotNull(bundle);
        this.zzeq = (String) Preconditions.checkNotNull(str);
    }

    public final zzu zza(@NonNull Resources resources) {
        this.zzev = (Resources) Preconditions.checkNotNull(resources);
        return this;
    }

    public final zzu zza(@NonNull zzv zzvVar) {
        this.zzey = (zzv) Preconditions.checkNotNull(zzvVar);
        return this;
    }

    public final zzu zza(@NonNull zzw zzwVar) {
        this.zzfa = (zzw) Preconditions.checkNotNull(zzwVar);
        return this;
    }

    public final zzu zza(zzx zzxVar) {
        this.zzex = zzxVar;
        return this;
    }

    public final zzu zza(@NonNull zzy zzyVar) {
        this.zzez = (zzy) Preconditions.checkNotNull(zzyVar);
        return this;
    }

    public final zzu zza(@NonNull CharSequence charSequence) {
        this.zzes = (CharSequence) Preconditions.checkNotNull(charSequence);
        return this;
    }

    public final zzs zzbe() {
        Preconditions.checkNotNull(this.zzcl, "data");
        Preconditions.checkNotNull(this.zzeq, "pkgName");
        Preconditions.checkNotNull(this.zzes, "appLabel");
        Preconditions.checkNotNull(this.zzeu, "pkgMetadata");
        Preconditions.checkNotNull(this.zzev, "pkgResources");
        Preconditions.checkNotNull(this.zzey, "colorGetter");
        Preconditions.checkNotNull(this.zzfa, "notificationChannelFallbackProvider");
        Preconditions.checkNotNull(this.zzez, "pendingIntentFactory");
        Preconditions.checkNotNull(this.zzex, "notificationChannelValidator");
        Preconditions.checkArgument(this.targetSdkVersion >= 0);
        return new zzs(this);
    }

    public final zzu zzc(int i) {
        this.zzer = i;
        return this;
    }

    public final zzu zzd(int i) {
        Preconditions.checkArgument(i > 0, new StringBuilder(36).append("Invalid targetSdkVersion ").append(i).toString());
        this.targetSdkVersion = i;
        return this;
    }

    public final zzu zzf(@Nullable Intent intent) {
        this.zzet = intent;
        return this;
    }

    public final zzu zzi(@NonNull Bundle bundle) {
        this.zzeu = (Bundle) Preconditions.checkNotNull(bundle);
        return this;
    }

    public final zzu zzq(@NonNull String str) {
        this.zzew = Preconditions.checkNotEmpty(str);
        return this;
    }
}
