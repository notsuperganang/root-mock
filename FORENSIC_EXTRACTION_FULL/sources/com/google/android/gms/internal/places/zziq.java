package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zziq {
    private static final zzio zzvs = zzfb();
    private static final zzio zzvt = new zzip();

    static zzio zzez() {
        return zzvs;
    }

    static zzio zzfa() {
        return zzvt;
    }

    private static zzio zzfb() {
        try {
            return (zzio) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
