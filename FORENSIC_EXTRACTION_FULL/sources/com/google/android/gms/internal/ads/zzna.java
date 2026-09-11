package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public abstract class zzna<T> {
    private final T mDefaultValue;
    private final String mKey;
    private final int zzatr;

    private zzna(int i, String str, T t) {
        this.zzatr = i;
        this.mKey = str;
        this.mDefaultValue = t;
        zzkb.zzij().zza(this);
    }

    /* synthetic */ zzna(int i, String str, Object obj, zznb zznbVar) {
        this(i, str, obj);
    }

    public static zzna<String> zza(int i, String str) {
        zzna<String> zznaVarZza = zza(i, str, (String) null);
        zzkb.zzij().zzb(zznaVarZza);
        return zznaVarZza;
    }

    public static zzna<Float> zza(int i, String str, float f) {
        return new zzne(i, str, Float.valueOf(f));
    }

    public static zzna<Integer> zza(int i, String str, int i2) {
        return new zznc(i, str, Integer.valueOf(i2));
    }

    public static zzna<Long> zza(int i, String str, long j) {
        return new zznd(i, str, Long.valueOf(j));
    }

    public static zzna<Boolean> zza(int i, String str, Boolean bool) {
        return new zznb(i, str, bool);
    }

    public static zzna<String> zza(int i, String str, String str2) {
        return new zznf(i, str, str2);
    }

    public static zzna<String> zzb(int i, String str) {
        zzna<String> zznaVarZza = zza(i, str, (String) null);
        zzkb.zzij().zzc(zznaVarZza);
        return zznaVarZza;
    }

    public final String getKey() {
        return this.mKey;
    }

    public final int getSource() {
        return this.zzatr;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    protected abstract T zzb(JSONObject jSONObject);

    public final T zzja() {
        return this.mDefaultValue;
    }
}
