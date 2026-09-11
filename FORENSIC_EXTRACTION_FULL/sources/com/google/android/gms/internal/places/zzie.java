package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzie {
    private static final zzic zzux = zzeu();
    private static final zzic zzuy = new zzid();

    static zzic zzes() {
        return zzux;
    }

    static zzic zzet() {
        return zzuy;
    }

    private static zzic zzeu() {
        try {
            return (zzic) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
