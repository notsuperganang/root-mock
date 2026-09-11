package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public enum zzux {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzte.class, zzte.class, zzte.zzbts),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> zzbzq;
    private final Class<?> zzbzr;
    private final Object zzbzs;

    zzux(Class cls, Class cls2, Object obj) {
        this.zzbzq = cls;
        this.zzbzr = cls2;
        this.zzbzs = obj;
    }

    public final Class<?> zzwy() {
        return this.zzbzr;
    }
}
