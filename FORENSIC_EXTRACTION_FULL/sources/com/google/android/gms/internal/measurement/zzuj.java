package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzuj {
    static final /* synthetic */ int[] zzbxt;
    static final /* synthetic */ int[] zzbxu = new int[zzux.values().length];

    static {
        try {
            zzbxu[zzux.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzbxu[zzux.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzbxu[zzux.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        zzbxt = new int[zzuk.values().length];
        try {
            zzbxt[zzuk.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzbxt[zzuk.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            zzbxt[zzuk.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
    }
}
