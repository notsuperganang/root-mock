package com.google.android.gms.internal.places;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzzb' uses external variables
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
public class zzke {
    public static final zzke zzyt = new zzke("DOUBLE", 0, zzkj.DOUBLE, 1);
    public static final zzke zzyu = new zzke("FLOAT", 1, zzkj.FLOAT, 5);
    public static final zzke zzyv = new zzke("INT64", 2, zzkj.LONG, 0);
    public static final zzke zzyw = new zzke("UINT64", 3, zzkj.LONG, 0);
    public static final zzke zzyx = new zzke("INT32", 4, zzkj.INT, 0);
    public static final zzke zzyy = new zzke("FIXED64", 5, zzkj.LONG, 1);
    public static final zzke zzyz = new zzke("FIXED32", 6, zzkj.INT, 5);
    public static final zzke zzza = new zzke("BOOL", 7, zzkj.BOOLEAN, 0);
    public static final zzke zzzb;
    public static final zzke zzzc;
    public static final zzke zzzd;
    public static final zzke zzze;
    public static final zzke zzzf;
    public static final zzke zzzg;
    public static final zzke zzzh;
    public static final zzke zzzi;
    public static final zzke zzzj;
    public static final zzke zzzk;
    private static final /* synthetic */ zzke[] zzzn;
    private final zzkj zzzl;
    private final int zzzm;

    static {
        final int i = 3;
        final int i2 = 2;
        final String str = "STRING";
        final int i3 = 8;
        final zzkj zzkjVar = zzkj.STRING;
        zzzb = new zzke(str, i3, zzkjVar, i2) { // from class: com.google.android.gms.internal.places.zzkf
            {
                int i4 = 8;
                int i5 = 2;
                zzkd zzkdVar = null;
            }
        };
        final String str2 = "GROUP";
        final int i4 = 9;
        final zzkj zzkjVar2 = zzkj.MESSAGE;
        zzzc = new zzke(str2, i4, zzkjVar2, i) { // from class: com.google.android.gms.internal.places.zzkg
            {
                int i5 = 9;
                int i6 = 3;
                zzkd zzkdVar = null;
            }
        };
        final String str3 = "MESSAGE";
        final int i5 = 10;
        final zzkj zzkjVar3 = zzkj.MESSAGE;
        zzzd = new zzke(str3, i5, zzkjVar3, i2) { // from class: com.google.android.gms.internal.places.zzkh
            {
                int i6 = 10;
                int i7 = 2;
                zzkd zzkdVar = null;
            }
        };
        final String str4 = "BYTES";
        final int i6 = 11;
        final zzkj zzkjVar4 = zzkj.BYTE_STRING;
        zzze = new zzke(str4, i6, zzkjVar4, i2) { // from class: com.google.android.gms.internal.places.zzki
            {
                int i7 = 11;
                int i8 = 2;
                zzkd zzkdVar = null;
            }
        };
        zzzf = new zzke("UINT32", 12, zzkj.INT, 0);
        zzzg = new zzke("ENUM", 13, zzkj.ENUM, 0);
        zzzh = new zzke("SFIXED32", 14, zzkj.INT, 5);
        zzzi = new zzke("SFIXED64", 15, zzkj.LONG, 1);
        zzzj = new zzke("SINT32", 16, zzkj.INT, 0);
        zzzk = new zzke("SINT64", 17, zzkj.LONG, 0);
        zzzn = new zzke[]{zzyt, zzyu, zzyv, zzyw, zzyx, zzyy, zzyz, zzza, zzzb, zzzc, zzzd, zzze, zzzf, zzzg, zzzh, zzzi, zzzj, zzzk};
    }

    private zzke(String str, int i, zzkj zzkjVar, int i2) {
        super(str, i);
        this.zzzl = zzkjVar;
        this.zzzm = i2;
    }

    /* synthetic */ zzke(String str, int i, zzkj zzkjVar, int i2, zzkd zzkdVar) {
        this(str, i, zzkjVar, i2);
    }

    public static zzke[] values() {
        return (zzke[]) zzzn.clone();
    }

    public final zzkj zzgz() {
        return this.zzzl;
    }

    public final int zzha() {
        return this.zzzm;
    }
}
