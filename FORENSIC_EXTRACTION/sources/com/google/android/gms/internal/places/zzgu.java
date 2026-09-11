package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzgu {
    static final /* synthetic */ int[] zzru;
    static final /* synthetic */ int[] zzrv = new int[zzhj.values().length];

    static {
        try {
            zzrv[zzhj.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzrv[zzhj.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzrv[zzhj.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        zzru = new int[zzgv.values().length];
        try {
            zzru[zzgv.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzru[zzgv.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            zzru[zzgv.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
    }
}
