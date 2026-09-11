package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzcdr' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public class zzxs {
    public static final zzxs zzcdj = new zzxs("DOUBLE", 0, zzxx.DOUBLE, 1);
    public static final zzxs zzcdk = new zzxs("FLOAT", 1, zzxx.FLOAT, 5);
    public static final zzxs zzcdl = new zzxs("INT64", 2, zzxx.LONG, 0);
    public static final zzxs zzcdm = new zzxs("UINT64", 3, zzxx.LONG, 0);
    public static final zzxs zzcdn = new zzxs("INT32", 4, zzxx.INT, 0);
    public static final zzxs zzcdo = new zzxs("FIXED64", 5, zzxx.LONG, 1);
    public static final zzxs zzcdp = new zzxs("FIXED32", 6, zzxx.INT, 5);
    public static final zzxs zzcdq = new zzxs("BOOL", 7, zzxx.BOOLEAN, 0);
    public static final zzxs zzcdr;
    public static final zzxs zzcds;
    public static final zzxs zzcdt;
    public static final zzxs zzcdu;
    public static final zzxs zzcdv;
    public static final zzxs zzcdw;
    public static final zzxs zzcdx;
    public static final zzxs zzcdy;
    public static final zzxs zzcdz;
    public static final zzxs zzcea;
    private static final /* synthetic */ zzxs[] zzced;
    private final zzxx zzceb;
    private final int zzcec;

    static {
        final int i = 3;
        final int i2 = 2;
        final String str = "STRING";
        final int i3 = 8;
        final zzxx zzxxVar = zzxx.STRING;
        zzcdr = new zzxs(str, i3, zzxxVar, i2) { // from class: com.google.android.gms.internal.measurement.zzxt
            {
                int i4 = 8;
                int i5 = 2;
                zzxr zzxrVar = null;
            }
        };
        final String str2 = "GROUP";
        final int i4 = 9;
        final zzxx zzxxVar2 = zzxx.MESSAGE;
        zzcds = new zzxs(str2, i4, zzxxVar2, i) { // from class: com.google.android.gms.internal.measurement.zzxu
            {
                int i5 = 9;
                int i6 = 3;
                zzxr zzxrVar = null;
            }
        };
        final String str3 = "MESSAGE";
        final int i5 = 10;
        final zzxx zzxxVar3 = zzxx.MESSAGE;
        zzcdt = new zzxs(str3, i5, zzxxVar3, i2) { // from class: com.google.android.gms.internal.measurement.zzxv
            {
                int i6 = 10;
                int i7 = 2;
                zzxr zzxrVar = null;
            }
        };
        final String str4 = "BYTES";
        final int i6 = 11;
        final zzxx zzxxVar4 = zzxx.BYTE_STRING;
        zzcdu = new zzxs(str4, i6, zzxxVar4, i2) { // from class: com.google.android.gms.internal.measurement.zzxw
            {
                int i7 = 11;
                int i8 = 2;
                zzxr zzxrVar = null;
            }
        };
        zzcdv = new zzxs("UINT32", 12, zzxx.INT, 0);
        zzcdw = new zzxs("ENUM", 13, zzxx.ENUM, 0);
        zzcdx = new zzxs("SFIXED32", 14, zzxx.INT, 5);
        zzcdy = new zzxs("SFIXED64", 15, zzxx.LONG, 1);
        zzcdz = new zzxs("SINT32", 16, zzxx.INT, 0);
        zzcea = new zzxs("SINT64", 17, zzxx.LONG, 0);
        zzced = new zzxs[]{zzcdj, zzcdk, zzcdl, zzcdm, zzcdn, zzcdo, zzcdp, zzcdq, zzcdr, zzcds, zzcdt, zzcdu, zzcdv, zzcdw, zzcdx, zzcdy, zzcdz, zzcea};
    }

    private zzxs(String str, int i, zzxx zzxxVar, int i2) {
        super(str, i);
        this.zzceb = zzxxVar;
        this.zzcec = i2;
    }

    /* synthetic */ zzxs(String str, int i, zzxx zzxxVar, int i2, zzxr zzxrVar) {
        this(str, i, zzxxVar, i2);
    }

    public static zzxs[] values() {
        return (zzxs[]) zzced.clone();
    }

    public final zzxx zzyv() {
        return this.zzceb;
    }

    public final int zzyw() {
        return this.zzcec;
    }
}
