package com.google.android.gms.internal.ads;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzeai' uses external variables
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
public class zzbes {
    public static final zzbes zzeaa = new zzbes("DOUBLE", 0, zzbex.DOUBLE, 1);
    public static final zzbes zzeab = new zzbes("FLOAT", 1, zzbex.FLOAT, 5);
    public static final zzbes zzeac = new zzbes("INT64", 2, zzbex.LONG, 0);
    public static final zzbes zzead = new zzbes("UINT64", 3, zzbex.LONG, 0);
    public static final zzbes zzeae = new zzbes("INT32", 4, zzbex.INT, 0);
    public static final zzbes zzeaf = new zzbes("FIXED64", 5, zzbex.LONG, 1);
    public static final zzbes zzeag = new zzbes("FIXED32", 6, zzbex.INT, 5);
    public static final zzbes zzeah = new zzbes("BOOL", 7, zzbex.BOOLEAN, 0);
    public static final zzbes zzeai;
    public static final zzbes zzeaj;
    public static final zzbes zzeak;
    public static final zzbes zzeal;
    public static final zzbes zzeam;
    public static final zzbes zzean;
    public static final zzbes zzeao;
    public static final zzbes zzeap;
    public static final zzbes zzeaq;
    public static final zzbes zzear;
    private static final /* synthetic */ zzbes[] zzeau;
    private final zzbex zzeas;
    private final int zzeat;

    static {
        final int i = 3;
        final int i2 = 2;
        final String str = "STRING";
        final int i3 = 8;
        final zzbex zzbexVar = zzbex.STRING;
        zzeai = new zzbes(str, i3, zzbexVar, i2) { // from class: com.google.android.gms.internal.ads.zzbet
            {
                int i4 = 8;
                int i5 = 2;
                zzber zzberVar = null;
            }
        };
        final String str2 = "GROUP";
        final int i4 = 9;
        final zzbex zzbexVar2 = zzbex.MESSAGE;
        zzeaj = new zzbes(str2, i4, zzbexVar2, i) { // from class: com.google.android.gms.internal.ads.zzbeu
            {
                int i5 = 9;
                int i6 = 3;
                zzber zzberVar = null;
            }
        };
        final String str3 = "MESSAGE";
        final int i5 = 10;
        final zzbex zzbexVar3 = zzbex.MESSAGE;
        zzeak = new zzbes(str3, i5, zzbexVar3, i2) { // from class: com.google.android.gms.internal.ads.zzbev
            {
                int i6 = 10;
                int i7 = 2;
                zzber zzberVar = null;
            }
        };
        final String str4 = "BYTES";
        final int i6 = 11;
        final zzbex zzbexVar4 = zzbex.BYTE_STRING;
        zzeal = new zzbes(str4, i6, zzbexVar4, i2) { // from class: com.google.android.gms.internal.ads.zzbew
            {
                int i7 = 11;
                int i8 = 2;
                zzber zzberVar = null;
            }
        };
        zzeam = new zzbes("UINT32", 12, zzbex.INT, 0);
        zzean = new zzbes("ENUM", 13, zzbex.ENUM, 0);
        zzeao = new zzbes("SFIXED32", 14, zzbex.INT, 5);
        zzeap = new zzbes("SFIXED64", 15, zzbex.LONG, 1);
        zzeaq = new zzbes("SINT32", 16, zzbex.INT, 0);
        zzear = new zzbes("SINT64", 17, zzbex.LONG, 0);
        zzeau = new zzbes[]{zzeaa, zzeab, zzeac, zzead, zzeae, zzeaf, zzeag, zzeah, zzeai, zzeaj, zzeak, zzeal, zzeam, zzean, zzeao, zzeap, zzeaq, zzear};
    }

    private zzbes(String str, int i, zzbex zzbexVar, int i2) {
        super(str, i);
        this.zzeas = zzbexVar;
        this.zzeat = i2;
    }

    /* synthetic */ zzbes(String str, int i, zzbex zzbexVar, int i2, zzber zzberVar) {
        this(str, i, zzbexVar, i2);
    }

    public static zzbes[] values() {
        return (zzbes[]) zzeau.clone();
    }

    public final zzbex zzagl() {
        return this.zzeas;
    }

    public final int zzagm() {
        return this.zzeat;
    }
}
