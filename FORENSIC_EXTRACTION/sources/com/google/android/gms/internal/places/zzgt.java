package com.google.android.gms.internal.places;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public enum zzgt {
    DOUBLE(0, zzgv.SCALAR, zzhj.DOUBLE),
    FLOAT(1, zzgv.SCALAR, zzhj.FLOAT),
    INT64(2, zzgv.SCALAR, zzhj.LONG),
    UINT64(3, zzgv.SCALAR, zzhj.LONG),
    INT32(4, zzgv.SCALAR, zzhj.INT),
    FIXED64(5, zzgv.SCALAR, zzhj.LONG),
    FIXED32(6, zzgv.SCALAR, zzhj.INT),
    BOOL(7, zzgv.SCALAR, zzhj.BOOLEAN),
    STRING(8, zzgv.SCALAR, zzhj.STRING),
    MESSAGE(9, zzgv.SCALAR, zzhj.MESSAGE),
    BYTES(10, zzgv.SCALAR, zzhj.BYTE_STRING),
    UINT32(11, zzgv.SCALAR, zzhj.INT),
    ENUM(12, zzgv.SCALAR, zzhj.ENUM),
    SFIXED32(13, zzgv.SCALAR, zzhj.INT),
    SFIXED64(14, zzgv.SCALAR, zzhj.LONG),
    SINT32(15, zzgv.SCALAR, zzhj.INT),
    SINT64(16, zzgv.SCALAR, zzhj.LONG),
    GROUP(17, zzgv.SCALAR, zzhj.MESSAGE),
    DOUBLE_LIST(18, zzgv.VECTOR, zzhj.DOUBLE),
    FLOAT_LIST(19, zzgv.VECTOR, zzhj.FLOAT),
    INT64_LIST(20, zzgv.VECTOR, zzhj.LONG),
    UINT64_LIST(21, zzgv.VECTOR, zzhj.LONG),
    INT32_LIST(22, zzgv.VECTOR, zzhj.INT),
    FIXED64_LIST(23, zzgv.VECTOR, zzhj.LONG),
    FIXED32_LIST(24, zzgv.VECTOR, zzhj.INT),
    BOOL_LIST(25, zzgv.VECTOR, zzhj.BOOLEAN),
    STRING_LIST(26, zzgv.VECTOR, zzhj.STRING),
    MESSAGE_LIST(27, zzgv.VECTOR, zzhj.MESSAGE),
    BYTES_LIST(28, zzgv.VECTOR, zzhj.BYTE_STRING),
    UINT32_LIST(29, zzgv.VECTOR, zzhj.INT),
    ENUM_LIST(30, zzgv.VECTOR, zzhj.ENUM),
    SFIXED32_LIST(31, zzgv.VECTOR, zzhj.INT),
    SFIXED64_LIST(32, zzgv.VECTOR, zzhj.LONG),
    SINT32_LIST(33, zzgv.VECTOR, zzhj.INT),
    SINT64_LIST(34, zzgv.VECTOR, zzhj.LONG),
    DOUBLE_LIST_PACKED(35, zzgv.PACKED_VECTOR, zzhj.DOUBLE),
    FLOAT_LIST_PACKED(36, zzgv.PACKED_VECTOR, zzhj.FLOAT),
    INT64_LIST_PACKED(37, zzgv.PACKED_VECTOR, zzhj.LONG),
    UINT64_LIST_PACKED(38, zzgv.PACKED_VECTOR, zzhj.LONG),
    INT32_LIST_PACKED(39, zzgv.PACKED_VECTOR, zzhj.INT),
    FIXED64_LIST_PACKED(40, zzgv.PACKED_VECTOR, zzhj.LONG),
    FIXED32_LIST_PACKED(41, zzgv.PACKED_VECTOR, zzhj.INT),
    BOOL_LIST_PACKED(42, zzgv.PACKED_VECTOR, zzhj.BOOLEAN),
    UINT32_LIST_PACKED(43, zzgv.PACKED_VECTOR, zzhj.INT),
    ENUM_LIST_PACKED(44, zzgv.PACKED_VECTOR, zzhj.ENUM),
    SFIXED32_LIST_PACKED(45, zzgv.PACKED_VECTOR, zzhj.INT),
    SFIXED64_LIST_PACKED(46, zzgv.PACKED_VECTOR, zzhj.LONG),
    SINT32_LIST_PACKED(47, zzgv.PACKED_VECTOR, zzhj.INT),
    SINT64_LIST_PACKED(48, zzgv.PACKED_VECTOR, zzhj.LONG),
    GROUP_LIST(49, zzgv.VECTOR, zzhj.MESSAGE),
    MAP(50, zzgv.MAP, zzhj.VOID);

    private static final zzgt[] zzrr;
    private static final Type[] zzrs = new Type[0];
    private final int id;
    private final zzhj zzrn;
    private final zzgv zzro;
    private final Class<?> zzrp;
    private final boolean zzrq;

    static {
        zzgt[] zzgtVarArrValues = values();
        zzrr = new zzgt[zzgtVarArrValues.length];
        for (zzgt zzgtVar : zzgtVarArrValues) {
            zzrr[zzgtVar.id] = zzgtVar;
        }
    }

    zzgt(int i, zzgv zzgvVar, zzhj zzhjVar) {
        this.id = i;
        this.zzro = zzgvVar;
        this.zzrn = zzhjVar;
        switch (zzgvVar) {
            case MAP:
                this.zzrp = zzhjVar.zzeh();
                break;
            case VECTOR:
                this.zzrp = zzhjVar.zzeh();
                break;
            default:
                this.zzrp = null;
                break;
        }
        boolean z = false;
        if (zzgvVar == zzgv.SCALAR) {
            switch (zzhjVar) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.zzrq = z;
    }

    public final int id() {
        return this.id;
    }
}
