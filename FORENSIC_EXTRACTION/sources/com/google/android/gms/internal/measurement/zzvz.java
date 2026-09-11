package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzvz<T> implements zzwl<T> {
    private static final int[] zzcaq = new int[0];
    private static final Unsafe zzcar = zzxj.zzyq();
    private final int[] zzcas;
    private final Object[] zzcat;
    private final int zzcau;
    private final int zzcav;
    private final zzvv zzcaw;
    private final boolean zzcax;
    private final boolean zzcay;
    private final boolean zzcaz;
    private final boolean zzcba;
    private final int[] zzcbb;
    private final int zzcbc;
    private final int zzcbd;
    private final zzwc zzcbe;
    private final zzvf zzcbf;
    private final zzxd<?, ?> zzcbg;
    private final zzuc<?> zzcbh;
    private final zzvq zzcbi;

    private zzvz(int[] iArr, Object[] objArr, int i, int i2, zzvv zzvvVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzwc zzwcVar, zzvf zzvfVar, zzxd<?, ?> zzxdVar, zzuc<?> zzucVar, zzvq zzvqVar) {
        this.zzcas = iArr;
        this.zzcat = objArr;
        this.zzcau = i;
        this.zzcav = i2;
        this.zzcay = zzvvVar instanceof zzuo;
        this.zzcaz = z;
        this.zzcax = zzucVar != null && zzucVar.zze(zzvvVar);
        this.zzcba = false;
        this.zzcbb = iArr2;
        this.zzcbc = i3;
        this.zzcbd = i4;
        this.zzcbe = zzwcVar;
        this.zzcbf = zzvfVar;
        this.zzcbg = zzxdVar;
        this.zzcbh = zzucVar;
        this.zzcaw = zzvvVar;
        this.zzcbi = zzvqVar;
    }

    private static <UT, UB> int zza(zzxd<UT, UB> zzxdVar, T t) {
        return zzxdVar.zzai(zzxdVar.zzal(t));
    }

    static <T> zzvz<T> zza(Class<T> cls, zzvt zzvtVar, zzwc zzwcVar, zzvf zzvfVar, zzxd<?, ?> zzxdVar, zzuc<?> zzucVar, zzvq zzvqVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int iCharAt;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        char cCharAt;
        char cCharAt2;
        int i19;
        char cCharAt3;
        char cCharAt4;
        int i20;
        char cCharAt5;
        char cCharAt6;
        int i21;
        char cCharAt7;
        char cCharAt8;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i27;
        int i28;
        int i29;
        Field fieldZza;
        int i30;
        char cCharAt9;
        int i31;
        Field fieldZza2;
        Field fieldZza3;
        int i32;
        char cCharAt10;
        int i33;
        char cCharAt11;
        int i34;
        char cCharAt12;
        int i35;
        char cCharAt13;
        char cCharAt14;
        if (!(zzvtVar instanceof zzwj)) {
            ((zzwy) zzvtVar).zzxm();
            throw new NoSuchMethodError();
        }
        zzwj zzwjVar = (zzwj) zzvtVar;
        boolean z = zzwjVar.zzxm() == zzuo.zze.zzbyv;
        String strZzxv = zzwjVar.zzxv();
        int length = strZzxv.length();
        int i36 = 1;
        char cCharAt15 = strZzxv.charAt(0);
        if (cCharAt15 >= 55296) {
            int i37 = cCharAt15 & 8191;
            int i38 = 13;
            while (true) {
                i = i36 + 1;
                cCharAt14 = strZzxv.charAt(i36);
                if (cCharAt14 < 55296) {
                    break;
                }
                i37 |= (cCharAt14 & 8191) << i38;
                i38 += 13;
                i36 = i;
            }
            i2 = (cCharAt14 << i38) | i37;
        } else {
            i = 1;
            i2 = cCharAt15;
        }
        int i39 = i + 1;
        int iCharAt2 = strZzxv.charAt(i);
        if (iCharAt2 >= 55296) {
            int i40 = iCharAt2 & 8191;
            int i41 = 13;
            while (true) {
                i35 = i39 + 1;
                cCharAt13 = strZzxv.charAt(i39);
                if (cCharAt13 < 55296) {
                    break;
                }
                i40 |= (cCharAt13 & 8191) << i41;
                i41 += 13;
                i39 = i35;
            }
            iCharAt2 = i40 | (cCharAt13 << i41);
            i3 = i35;
        } else {
            i3 = i39;
        }
        if (iCharAt2 == 0) {
            iCharAt = 0;
            i16 = 0;
            i11 = 0;
            i18 = 0;
            iArr = zzcaq;
            i14 = 0;
            i15 = 0;
            i17 = 0;
        } else {
            int i42 = i3 + 1;
            int iCharAt3 = strZzxv.charAt(i3);
            if (iCharAt3 >= 55296) {
                int i43 = iCharAt3 & 8191;
                int i44 = 13;
                while (true) {
                    i4 = i42 + 1;
                    cCharAt8 = strZzxv.charAt(i42);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt8 & 8191) << i44;
                    i44 += 13;
                    i42 = i4;
                }
                iCharAt3 = (cCharAt8 << i44) | i43;
            } else {
                i4 = i42;
            }
            int i45 = i4 + 1;
            char cCharAt16 = strZzxv.charAt(i4);
            if (cCharAt16 >= 55296) {
                int i46 = cCharAt16 & 8191;
                int i47 = 13;
                while (true) {
                    i21 = i45 + 1;
                    cCharAt7 = strZzxv.charAt(i45);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt7 & 8191) << i47;
                    i47 += 13;
                    i45 = i21;
                }
                i5 = (cCharAt7 << i47) | i46;
                i6 = i21;
            } else {
                i5 = cCharAt16;
                i6 = i45;
            }
            int i48 = i6 + 1;
            iCharAt = strZzxv.charAt(i6);
            if (iCharAt >= 55296) {
                int i49 = iCharAt & 8191;
                int i50 = 13;
                while (true) {
                    i7 = i48 + 1;
                    cCharAt6 = strZzxv.charAt(i48);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt6 & 8191) << i50;
                    i50 += 13;
                    i48 = i7;
                }
                iCharAt = (cCharAt6 << i50) | i49;
            } else {
                i7 = i48;
            }
            int i51 = i7 + 1;
            char cCharAt17 = strZzxv.charAt(i7);
            if (cCharAt17 >= 55296) {
                int i52 = 13;
                int i53 = cCharAt17 & 8191;
                while (true) {
                    i20 = i51 + 1;
                    cCharAt5 = strZzxv.charAt(i51);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt5 & 8191) << i52;
                    i52 += 13;
                    i51 = i20;
                }
                i8 = (cCharAt5 << i52) | i53;
                i9 = i20;
            } else {
                i8 = cCharAt17;
                i9 = i51;
            }
            int i54 = i9 + 1;
            char cCharAt18 = strZzxv.charAt(i9);
            if (cCharAt18 >= 55296) {
                int i55 = cCharAt18 & 8191;
                int i56 = 13;
                int i57 = i55;
                while (true) {
                    i10 = i54 + 1;
                    cCharAt4 = strZzxv.charAt(i54);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt4 & 8191) << i56;
                    i56 += 13;
                    i54 = i10;
                }
                i11 = (cCharAt4 << i56) | i57;
            } else {
                i10 = i54;
                i11 = cCharAt18;
            }
            int i58 = i10 + 1;
            char cCharAt19 = strZzxv.charAt(i10);
            if (cCharAt19 >= 55296) {
                int i59 = cCharAt19 & 8191;
                int i60 = 13;
                while (true) {
                    i19 = i58 + 1;
                    cCharAt3 = strZzxv.charAt(i58);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i59 |= (cCharAt3 & 8191) << i60;
                    i60 += 13;
                    i58 = i19;
                }
                int i61 = i59 | (cCharAt3 << i60);
                i58 = i19;
                i12 = i61;
            } else {
                i12 = cCharAt19;
            }
            int i62 = i58 + 1;
            int iCharAt4 = strZzxv.charAt(i58);
            if (iCharAt4 >= 55296) {
                int i63 = iCharAt4 & 8191;
                int i64 = 13;
                while (true) {
                    i13 = i62 + 1;
                    cCharAt2 = strZzxv.charAt(i62);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i63 |= (cCharAt2 & 8191) << i64;
                    i64 += 13;
                    i62 = i13;
                }
                iCharAt4 = (cCharAt2 << i64) | i63;
            } else {
                i13 = i62;
            }
            int i65 = i13 + 1;
            int iCharAt5 = strZzxv.charAt(i13);
            if (iCharAt5 >= 55296) {
                int i66 = iCharAt5 & 8191;
                int i67 = 13;
                while (true) {
                    i3 = i65 + 1;
                    cCharAt = strZzxv.charAt(i65);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i66 |= (cCharAt & 8191) << i67;
                    i67 += 13;
                    i65 = i3;
                }
                iCharAt5 = i66 | (cCharAt << i67);
            } else {
                i3 = i65;
            }
            iArr = new int[iCharAt4 + iCharAt5 + i12];
            i14 = iCharAt3;
            i15 = i12;
            i16 = i8;
            i17 = (iCharAt3 << 1) + i5;
            i18 = iCharAt5;
        }
        Unsafe unsafe = zzcar;
        Object[] objArrZzxw = zzwjVar.zzxw();
        int i68 = 0;
        Class<?> cls2 = zzwjVar.zzxo().getClass();
        int[] iArr2 = new int[i11 * 3];
        Object[] objArr = new Object[i11 << 1];
        int i69 = i18 + i15;
        int i70 = 0;
        int i71 = i18;
        int i72 = i17;
        while (i3 < length) {
            int i73 = i3 + 1;
            char cCharAt20 = strZzxv.charAt(i3);
            if (cCharAt20 >= 55296) {
                int i74 = 13;
                int i75 = cCharAt20 & 8191;
                while (true) {
                    i34 = i73 + 1;
                    cCharAt12 = strZzxv.charAt(i73);
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i75 |= (cCharAt12 & 8191) << i74;
                    i74 += 13;
                    i73 = i34;
                }
                i22 = (cCharAt12 << i74) | i75;
                i23 = i34;
            } else {
                i22 = cCharAt20;
                i23 = i73;
            }
            int i76 = i23 + 1;
            char cCharAt21 = strZzxv.charAt(i23);
            if (cCharAt21 >= 55296) {
                int i77 = cCharAt21 & 8191;
                int i78 = 13;
                while (true) {
                    i33 = i76 + 1;
                    cCharAt11 = strZzxv.charAt(i76);
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i77 |= (cCharAt11 & 8191) << i78;
                    i78 += 13;
                    i76 = i33;
                }
                i24 = (cCharAt11 << i78) | i77;
                i25 = i33;
            } else {
                i24 = cCharAt21;
                i25 = i76;
            }
            int i79 = i24 & 255;
            if ((i24 & 1024) != 0) {
                iArr[i68] = i70;
                i68++;
            }
            if (i79 >= 51) {
                int i80 = i25 + 1;
                char cCharAt22 = strZzxv.charAt(i25);
                if (cCharAt22 >= 55296) {
                    int i81 = 13;
                    int i82 = cCharAt22 & 8191;
                    while (true) {
                        i32 = i80 + 1;
                        cCharAt10 = strZzxv.charAt(i80);
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i82 |= (cCharAt10 & 8191) << i81;
                        i81 += 13;
                        i80 = i32;
                    }
                    i31 = (cCharAt10 << i81) | i82;
                    i25 = i32;
                } else {
                    i31 = cCharAt22;
                    i25 = i80;
                }
                int i83 = i79 - 51;
                if (i83 == 9 || i83 == 17) {
                    objArr[((i70 / 3) << 1) + 1] = objArrZzxw[i72];
                    i26 = i72 + 1;
                } else if (i83 == 12 && (i2 & 1) == 1) {
                    objArr[((i70 / 3) << 1) + 1] = objArrZzxw[i72];
                    i26 = i72 + 1;
                } else {
                    i26 = i72;
                }
                int i84 = i31 << 1;
                Object obj = objArrZzxw[i84];
                if (obj instanceof Field) {
                    fieldZza2 = (Field) obj;
                } else {
                    fieldZza2 = zza(cls2, (String) obj);
                    objArrZzxw[i84] = fieldZza2;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza2);
                int i85 = i84 + 1;
                Object obj2 = objArrZzxw[i85];
                if (obj2 instanceof Field) {
                    fieldZza3 = (Field) obj2;
                } else {
                    fieldZza3 = zza(cls2, (String) obj2);
                    objArrZzxw[i85] = fieldZza3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                i27 = 0;
            } else {
                i26 = i72 + 1;
                Field fieldZza4 = zza(cls2, (String) objArrZzxw[i72]);
                if (i79 == 9 || i79 == 17) {
                    objArr[((i70 / 3) << 1) + 1] = fieldZza4.getType();
                } else if (i79 == 27 || i79 == 49) {
                    objArr[((i70 / 3) << 1) + 1] = objArrZzxw[i26];
                    i26++;
                } else if (i79 == 12 || i79 == 30 || i79 == 44) {
                    if ((i2 & 1) == 1) {
                        objArr[((i70 / 3) << 1) + 1] = objArrZzxw[i26];
                        i26++;
                    }
                } else if (i79 == 50) {
                    int i86 = i71 + 1;
                    iArr[i71] = i70;
                    int i87 = i26 + 1;
                    objArr[(i70 / 3) << 1] = objArrZzxw[i26];
                    if ((i24 & 2048) != 0) {
                        i26 = i87 + 1;
                        objArr[((i70 / 3) << 1) + 1] = objArrZzxw[i87];
                        i71 = i86;
                    } else {
                        i71 = i86;
                        i26 = i87;
                    }
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                if ((i2 & 1) != 1 || i79 > 17) {
                    iObjectFieldOffset2 = 0;
                    i27 = 0;
                } else {
                    int i88 = i25 + 1;
                    char cCharAt23 = strZzxv.charAt(i25);
                    if (cCharAt23 >= 55296) {
                        int i89 = 13;
                        int i90 = cCharAt23 & 8191;
                        while (true) {
                            i30 = i88 + 1;
                            cCharAt9 = strZzxv.charAt(i88);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i90 |= (cCharAt9 & 8191) << i89;
                            i89 += 13;
                            i88 = i30;
                        }
                        i28 = (cCharAt9 << i89) | i90;
                        i29 = i30;
                    } else {
                        i28 = cCharAt23;
                        i29 = i88;
                    }
                    int i91 = (i14 << 1) + (i28 / 32);
                    Object obj3 = objArrZzxw[i91];
                    if (obj3 instanceof Field) {
                        fieldZza = (Field) obj3;
                    } else {
                        fieldZza = zza(cls2, (String) obj3);
                        objArrZzxw[i91] = fieldZza;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                    i27 = i28 % 32;
                    i25 = i29;
                }
                if (i79 >= 18 && i79 <= 49) {
                    iArr[i69] = iObjectFieldOffset;
                    i69++;
                }
            }
            int i92 = i70 + 1;
            iArr2[i70] = i22;
            int i93 = i92 + 1;
            iArr2[i92] = iObjectFieldOffset | ((i24 & 256) != 0 ? 268435456 : 0) | ((i24 & 512) != 0 ? 536870912 : 0) | (i79 << 20);
            iArr2[i93] = iObjectFieldOffset2 | (i27 << 20);
            i70 = i93 + 1;
            i3 = i25;
            i72 = i26;
        }
        return new zzvz<>(iArr2, objArr, iCharAt, i16, zzwjVar.zzxo(), z, false, iArr, i18, i18 + i15, zzwcVar, zzvfVar, zzxdVar, zzucVar, zzvqVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzut zzutVar, UB ub, zzxd<UT, UB> zzxdVar) {
        zzvo<?, ?> zzvoVarZzah = this.zzcbi.zzah(zzbr(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        UB ub2 = ub;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzutVar.zzb(((Integer) next.getValue()).intValue())) {
                UB ubZzyk = ub2 == null ? zzxdVar.zzyk() : ub2;
                zztm zztmVarZzao = zzte.zzao(zzvn.zza(zzvoVarZzah, next.getKey(), next.getValue()));
                try {
                    zzvn.zza(zztmVarZzao.zzui(), zzvoVarZzah, next.getKey(), next.getValue());
                    zzxdVar.zza(ubZzyk, i2, zztmVarZzao.zzuh());
                    it.remove();
                    ub2 = ubZzyk;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub2;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzxd<UT, UB> zzxdVar) {
        zzut zzutVarZzbs;
        int i2 = this.zzcas[i];
        Object objZzp = zzxj.zzp(obj, zzbt(i) & 1048575);
        return (objZzp == null || (zzutVarZzbs = zzbs(i)) == null) ? ub : (UB) zza(i, i2, this.zzcbi.zzac(objZzp), zzutVarZzbs, ub, zzxdVar);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            throw new RuntimeException(new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length()).append("Field ").append(str).append(" for ").append(name).append(" not found. Known fields are ").append(string).toString());
        }
    }

    private static void zza(int i, Object obj, zzxy zzxyVar) throws IOException {
        if (obj instanceof String) {
            zzxyVar.zzb(i, (String) obj);
        } else {
            zzxyVar.zza(i, (zzte) obj);
        }
    }

    private static <UT, UB> void zza(zzxd<UT, UB> zzxdVar, T t, zzxy zzxyVar) throws IOException {
        zzxdVar.zza(zzxdVar.zzal(t), zzxyVar);
    }

    private final <K, V> void zza(zzxy zzxyVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzxyVar.zza(i, this.zzcbi.zzah(zzbr(i2)), this.zzcbi.zzad(obj));
        }
    }

    private final void zza(Object obj, int i, zzwk zzwkVar) throws IOException {
        if (zzbv(i)) {
            zzxj.zza(obj, i & 1048575, zzwkVar.zzuq());
        } else if (this.zzcay) {
            zzxj.zza(obj, i & 1048575, zzwkVar.readString());
        } else {
            zzxj.zza(obj, i & 1048575, zzwkVar.zzur());
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzbt = zzbt(i) & 1048575;
        if (zzb(t2, i)) {
            Object objZzp = zzxj.zzp(t, jZzbt);
            Object objZzp2 = zzxj.zzp(t2, jZzbt);
            if (objZzp != null && objZzp2 != null) {
                zzxj.zza(t, jZzbt, zzuq.zzb(objZzp, objZzp2));
                zzc(t, i);
            } else if (objZzp2 != null) {
                zzxj.zza(t, jZzbt, objZzp2);
                zzc(t, i);
            }
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzxj.zzk(t, (long) (zzbu(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzcaz) {
            return zzb(t, i);
        }
        return (i2 & i3) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzwl zzwlVar) {
        return zzwlVar.zzaj(zzxj.zzp(obj, 1048575 & i));
    }

    private final void zzb(T t, int i, int i2) {
        zzxj.zzb(t, zzbu(i2) & 1048575, i);
    }

    /* JADX WARN: Code duplicated, block: B:179:0x079f  */
    private final void zzb(T t, zzxy zzxyVar) throws IOException {
        Iterator it;
        int i;
        int i2;
        int i3;
        Map.Entry<?, ?> entry = null;
        if (this.zzcax) {
            zzuf<T> zzufVarZzw = this.zzcbh.zzw(t);
            if (zzufVarZzw.isEmpty()) {
                it = null;
            } else {
                it = zzufVarZzw.iterator();
                entry = (Map.Entry) it.next();
            }
        } else {
            it = null;
        }
        int i4 = -1;
        int i5 = 0;
        int length = this.zzcas.length;
        Unsafe unsafe = zzcar;
        int i6 = 0;
        Map.Entry<?, ?> entry2 = entry;
        while (i6 < length) {
            int iZzbt = zzbt(i6);
            int i7 = this.zzcas[i6];
            int i8 = (267386880 & iZzbt) >>> 20;
            if (this.zzcaz || i8 > 17) {
                i = 0;
                i2 = i5;
                i3 = i4;
            } else {
                int i9 = this.zzcas[i6 + 2];
                int i10 = 1048575 & i9;
                if (i10 != i4) {
                    i2 = unsafe.getInt(t, i10);
                } else {
                    i10 = i4;
                    i2 = i5;
                }
                i = 1 << (i9 >>> 20);
                i3 = i10;
            }
            while (entry2 != null && this.zzcbh.zzb(entry2) <= i7) {
                this.zzcbh.zza(zzxyVar, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = 1048575 & iZzbt;
            switch (i8) {
                case 0:
                    if ((i2 & i) != 0) {
                        zzxyVar.zza(i7, zzxj.zzo(t, j));
                    }
                    break;
                case 1:
                    if ((i2 & i) != 0) {
                        zzxyVar.zza(i7, zzxj.zzn(t, j));
                    }
                    break;
                case 2:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzi(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 3:
                    if ((i2 & i) != 0) {
                        zzxyVar.zza(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 4:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzd(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 5:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzc(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 6:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzg(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 7:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzb(i7, zzxj.zzm(t, j));
                    }
                    break;
                case 8:
                    if ((i2 & i) != 0) {
                        zza(i7, unsafe.getObject(t, j), zzxyVar);
                    }
                    break;
                case 9:
                    if ((i2 & i) != 0) {
                        zzxyVar.zza(i7, unsafe.getObject(t, j), zzbq(i6));
                    }
                    break;
                case 10:
                    if ((i2 & i) != 0) {
                        zzxyVar.zza(i7, (zzte) unsafe.getObject(t, j));
                    }
                    break;
                case 11:
                    if ((i2 & i) != 0) {
                        zzxyVar.zze(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 12:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzo(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 13:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzn(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 14:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzj(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 15:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzf(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 16:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzb(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 17:
                    if ((i2 & i) != 0) {
                        zzxyVar.zzb(i7, unsafe.getObject(t, j), zzbq(i6));
                    }
                    break;
                case 18:
                    zzwn.zza(this.zzcas[i6], (List<Double>) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 19:
                    zzwn.zzb(this.zzcas[i6], (List<Float>) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 20:
                    zzwn.zzc(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 21:
                    zzwn.zzd(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 22:
                    zzwn.zzh(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 23:
                    zzwn.zzf(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 24:
                    zzwn.zzk(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 25:
                    zzwn.zzn(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 26:
                    zzwn.zza(this.zzcas[i6], (List<String>) unsafe.getObject(t, j), zzxyVar);
                    break;
                case 27:
                    zzwn.zza(this.zzcas[i6], (List<?>) unsafe.getObject(t, j), zzxyVar, zzbq(i6));
                    break;
                case 28:
                    zzwn.zzb(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar);
                    break;
                case 29:
                    zzwn.zzi(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 30:
                    zzwn.zzm(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 31:
                    zzwn.zzl(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 32:
                    zzwn.zzg(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 33:
                    zzwn.zzj(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 34:
                    zzwn.zze(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, false);
                    break;
                case 35:
                    zzwn.zza(this.zzcas[i6], (List<Double>) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 36:
                    zzwn.zzb(this.zzcas[i6], (List<Float>) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 37:
                    zzwn.zzc(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 38:
                    zzwn.zzd(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 39:
                    zzwn.zzh(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 40:
                    zzwn.zzf(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 41:
                    zzwn.zzk(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 42:
                    zzwn.zzn(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 43:
                    zzwn.zzi(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 44:
                    zzwn.zzm(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 45:
                    zzwn.zzl(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 46:
                    zzwn.zzg(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 47:
                    zzwn.zzj(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 48:
                    zzwn.zze(this.zzcas[i6], (List) unsafe.getObject(t, j), zzxyVar, true);
                    break;
                case 49:
                    zzwn.zzb(this.zzcas[i6], (List<?>) unsafe.getObject(t, j), zzxyVar, zzbq(i6));
                    break;
                case 50:
                    zza(zzxyVar, i7, unsafe.getObject(t, j), i6);
                    break;
                case 51:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zza(i7, zzf(t, j));
                    }
                    break;
                case 52:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zza(i7, zzg(t, j));
                    }
                    break;
                case 53:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzi(i7, zzi(t, j));
                    }
                    break;
                case 54:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zza(i7, zzi(t, j));
                    }
                    break;
                case 55:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzd(i7, zzh(t, j));
                    }
                    break;
                case 56:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzc(i7, zzi(t, j));
                    }
                    break;
                case 57:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzg(i7, zzh(t, j));
                    }
                    break;
                case 58:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzb(i7, zzj(t, j));
                    }
                    break;
                case 59:
                    if (zza(t, i7, i6)) {
                        zza(i7, unsafe.getObject(t, j), zzxyVar);
                    }
                    break;
                case 60:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zza(i7, unsafe.getObject(t, j), zzbq(i6));
                    }
                    break;
                case 61:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zza(i7, (zzte) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zze(i7, zzh(t, j));
                    }
                    break;
                case 63:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzo(i7, zzh(t, j));
                    }
                    break;
                case 64:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzn(i7, zzh(t, j));
                    }
                    break;
                case 65:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzj(i7, zzi(t, j));
                    }
                    break;
                case 66:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzf(i7, zzh(t, j));
                    }
                    break;
                case 67:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzb(i7, zzi(t, j));
                    }
                    break;
                case 68:
                    if (zza(t, i7, i6)) {
                        zzxyVar.zzb(i7, unsafe.getObject(t, j), zzbq(i6));
                    }
                    break;
            }
            i6 += 3;
            i5 = i2;
            i4 = i3;
        }
        Map.Entry<?, ?> entry3 = entry2;
        while (entry3 != null) {
            this.zzcbh.zza(zzxyVar, entry3);
            entry3 = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzcbg, t, zzxyVar);
    }

    private final void zzb(T t, T t2, int i) {
        int iZzbt = zzbt(i);
        int i2 = this.zzcas[i];
        long j = iZzbt & 1048575;
        if (zza(t2, i2, i)) {
            Object objZzp = zzxj.zzp(t, j);
            Object objZzp2 = zzxj.zzp(t2, j);
            if (objZzp != null && objZzp2 != null) {
                zzxj.zza(t, j, zzuq.zzb(objZzp, objZzp2));
                zzb(t, i2, i);
            } else if (objZzp2 != null) {
                zzxj.zza(t, j, objZzp2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzb(T t, int i) {
        if (!this.zzcaz) {
            int iZzbu = zzbu(i);
            return ((1 << (iZzbu >>> 20)) & zzxj.zzk(t, (long) (1048575 & iZzbu))) != 0;
        }
        int iZzbt = zzbt(i);
        long j = 1048575 & iZzbt;
        switch ((iZzbt & 267386880) >>> 20) {
            case 0:
                return zzxj.zzo(t, j) != 0.0d;
            case 1:
                return zzxj.zzn(t, j) != 0.0f;
            case 2:
                return zzxj.zzl(t, j) != 0;
            case 3:
                return zzxj.zzl(t, j) != 0;
            case 4:
                return zzxj.zzk(t, j) != 0;
            case 5:
                return zzxj.zzl(t, j) != 0;
            case 6:
                return zzxj.zzk(t, j) != 0;
            case 7:
                return zzxj.zzm(t, j);
            case 8:
                Object objZzp = zzxj.zzp(t, j);
                if (objZzp instanceof String) {
                    return !((String) objZzp).isEmpty();
                }
                if (objZzp instanceof zzte) {
                    return !zzte.zzbts.equals(objZzp);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzxj.zzp(t, j) != null;
            case 10:
                return !zzte.zzbts.equals(zzxj.zzp(t, j));
            case 11:
                return zzxj.zzk(t, j) != 0;
            case 12:
                return zzxj.zzk(t, j) != 0;
            case 13:
                return zzxj.zzk(t, j) != 0;
            case 14:
                return zzxj.zzl(t, j) != 0;
            case 15:
                return zzxj.zzk(t, j) != 0;
            case 16:
                return zzxj.zzl(t, j) != 0;
            case 17:
                return zzxj.zzp(t, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final zzwl zzbq(int i) {
        int i2 = (i / 3) << 1;
        zzwl zzwlVar = (zzwl) this.zzcat[i2];
        if (zzwlVar != null) {
            return zzwlVar;
        }
        zzwl<T> zzwlVarZzi = zzwh.zzxt().zzi((Class) this.zzcat[i2 + 1]);
        this.zzcat[i2] = zzwlVarZzi;
        return zzwlVarZzi;
    }

    private final Object zzbr(int i) {
        return this.zzcat[(i / 3) << 1];
    }

    private final zzut zzbs(int i) {
        return (zzut) this.zzcat[((i / 3) << 1) + 1];
    }

    private final int zzbt(int i) {
        return this.zzcas[i + 1];
    }

    private final int zzbu(int i) {
        return this.zzcas[i + 2];
    }

    private static boolean zzbv(int i) {
        return (536870912 & i) != 0;
    }

    private final void zzc(T t, int i) {
        if (this.zzcaz) {
            return;
        }
        int iZzbu = zzbu(i);
        long j = 1048575 & iZzbu;
        zzxj.zzb(t, j, (1 << (iZzbu >>> 20)) | zzxj.zzk(t, j));
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzb(t, i) == zzb(t2, i);
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zzxj.zzp(obj, j);
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzxj.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzxj.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzxj.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzxj.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzxj.zzp(t, j)).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final boolean equals(T t, T t2) {
        boolean zZze;
        int length = this.zzcas.length;
        for (int i = 0; i < length; i += 3) {
            int iZzbt = zzbt(i);
            long j = iZzbt & 1048575;
            switch ((iZzbt & 267386880) >>> 20) {
                case 0:
                    zZze = zzc(t, t2, i) && Double.doubleToLongBits(zzxj.zzo(t, j)) == Double.doubleToLongBits(zzxj.zzo(t2, j));
                    break;
                case 1:
                    zZze = zzc(t, t2, i) && Float.floatToIntBits(zzxj.zzn(t, j)) == Float.floatToIntBits(zzxj.zzn(t2, j));
                    break;
                case 2:
                    zZze = zzc(t, t2, i) && zzxj.zzl(t, j) == zzxj.zzl(t2, j);
                    break;
                case 3:
                    zZze = zzc(t, t2, i) && zzxj.zzl(t, j) == zzxj.zzl(t2, j);
                    break;
                case 4:
                    zZze = zzc(t, t2, i) && zzxj.zzk(t, j) == zzxj.zzk(t2, j);
                    break;
                case 5:
                    zZze = zzc(t, t2, i) && zzxj.zzl(t, j) == zzxj.zzl(t2, j);
                    break;
                case 6:
                    zZze = zzc(t, t2, i) && zzxj.zzk(t, j) == zzxj.zzk(t2, j);
                    break;
                case 7:
                    zZze = zzc(t, t2, i) && zzxj.zzm(t, j) == zzxj.zzm(t2, j);
                    break;
                case 8:
                    zZze = zzc(t, t2, i) && zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j));
                    break;
                case 9:
                    zZze = zzc(t, t2, i) && zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j));
                    break;
                case 10:
                    zZze = zzc(t, t2, i) && zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j));
                    break;
                case 11:
                    zZze = zzc(t, t2, i) && zzxj.zzk(t, j) == zzxj.zzk(t2, j);
                    break;
                case 12:
                    zZze = zzc(t, t2, i) && zzxj.zzk(t, j) == zzxj.zzk(t2, j);
                    break;
                case 13:
                    zZze = zzc(t, t2, i) && zzxj.zzk(t, j) == zzxj.zzk(t2, j);
                    break;
                case 14:
                    zZze = zzc(t, t2, i) && zzxj.zzl(t, j) == zzxj.zzl(t2, j);
                    break;
                case 15:
                    zZze = zzc(t, t2, i) && zzxj.zzk(t, j) == zzxj.zzk(t2, j);
                    break;
                case 16:
                    zZze = zzc(t, t2, i) && zzxj.zzl(t, j) == zzxj.zzl(t2, j);
                    break;
                case 17:
                    zZze = zzc(t, t2, i) && zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j));
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZze = zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j));
                    break;
                case 50:
                    zZze = zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    int iZzbu = zzbu(i);
                    zZze = zzxj.zzk(t, iZzbu & 1048575) == zzxj.zzk(t2, iZzbu & 1048575) && zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j));
                    break;
                default:
                    zZze = true;
                    break;
            }
            if (!zZze) {
                return false;
            }
        }
        if (!this.zzcbg.zzal(t).equals(this.zzcbg.zzal(t2))) {
            return false;
        }
        if (this.zzcax) {
            return this.zzcbh.zzw(t).equals(this.zzcbh.zzw(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final int hashCode(T t) {
        int length = this.zzcas.length;
        int iHashCode = 0;
        int i = 0;
        while (i < length) {
            int iZzbt = zzbt(i);
            int i2 = this.zzcas[i];
            long j = 1048575 & iZzbt;
            switch ((iZzbt & 267386880) >>> 20) {
                case 0:
                    iHashCode = (iHashCode * 53) + zzuq.zzbd(Double.doubleToLongBits(zzxj.zzo(t, j)));
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 1:
                    iHashCode = (iHashCode * 53) + Float.floatToIntBits(zzxj.zzn(t, j));
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 2:
                    iHashCode = (iHashCode * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 3:
                    iHashCode = (iHashCode * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 4:
                    iHashCode = (iHashCode * 53) + zzxj.zzk(t, j);
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 5:
                    iHashCode = (iHashCode * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 6:
                    iHashCode = (iHashCode * 53) + zzxj.zzk(t, j);
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 7:
                    iHashCode = (iHashCode * 53) + zzuq.zzu(zzxj.zzm(t, j));
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 8:
                    iHashCode = ((String) zzxj.zzp(t, j)).hashCode() + (iHashCode * 53);
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 9:
                    Object objZzp = zzxj.zzp(t, j);
                    iHashCode = (objZzp != null ? objZzp.hashCode() : 37) + (iHashCode * 53);
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 10:
                    iHashCode = (iHashCode * 53) + zzxj.zzp(t, j).hashCode();
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 11:
                    iHashCode = (iHashCode * 53) + zzxj.zzk(t, j);
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 12:
                    iHashCode = (iHashCode * 53) + zzxj.zzk(t, j);
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 13:
                    iHashCode = (iHashCode * 53) + zzxj.zzk(t, j);
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 14:
                    iHashCode = (iHashCode * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 15:
                    iHashCode = (iHashCode * 53) + zzxj.zzk(t, j);
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 16:
                    iHashCode = (iHashCode * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 17:
                    Object objZzp2 = zzxj.zzp(t, j);
                    iHashCode = (objZzp2 != null ? objZzp2.hashCode() : 37) + (iHashCode * 53);
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    iHashCode = (iHashCode * 53) + zzxj.zzp(t, j).hashCode();
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 50:
                    iHashCode = (iHashCode * 53) + zzxj.zzp(t, j).hashCode();
                    continue;
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 51:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzuq.zzbd(Double.doubleToLongBits(zzf(t, j)));
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 52:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + Float.floatToIntBits(zzg(t, j));
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 53:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzuq.zzbd(zzi(t, j));
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 54:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzuq.zzbd(zzi(t, j));
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 55:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 56:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzuq.zzbd(zzi(t, j));
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 57:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 58:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzuq.zzu(zzj(t, j));
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 59:
                    if (zza(t, i2, i)) {
                        iHashCode = ((String) zzxj.zzp(t, j)).hashCode() + (iHashCode * 53);
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 60:
                    if (zza(t, i2, i)) {
                        iHashCode = zzxj.zzp(t, j).hashCode() + (iHashCode * 53);
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 61:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzxj.zzp(t, j).hashCode();
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 62:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 63:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 64:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 65:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzuq.zzbd(zzi(t, j));
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 66:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 67:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzuq.zzbd(zzi(t, j));
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
                case 68:
                    if (zza(t, i2, i)) {
                        iHashCode = zzxj.zzp(t, j).hashCode() + (iHashCode * 53);
                    }
                    i += 3;
                    iHashCode = iHashCode;
                    break;
            }
            i += 3;
            iHashCode = iHashCode;
        }
        int iHashCode2 = (iHashCode * 53) + this.zzcbg.zzal(t).hashCode();
        return this.zzcax ? (iHashCode2 * 53) + this.zzcbh.zzw(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final T newInstance() {
        return (T) this.zzcbe.newInstance(this.zzcaw);
    }

    /* JADX WARN: Code duplicated, block: B:182:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:204:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:365:0x000e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:386:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00de A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #3 {all -> 0x010a, blocks: (B:6:0x000e, B:8:0x0016, B:10:0x001a, B:12:0x0025, B:29:0x005d, B:34:0x0066, B:35:0x006a, B:37:0x0078, B:39:0x007d, B:36:0x0071, B:48:0x009e, B:52:0x00ac, B:63:0x00d9, B:65:0x00de, B:60:0x00cc, B:73:0x00fe, B:82:0x0124, B:83:0x0130, B:84:0x0141, B:85:0x0152, B:86:0x0163, B:87:0x0174, B:88:0x0185, B:89:0x018d, B:91:0x0193, B:92:0x01b2, B:93:0x01c7, B:94:0x01d8, B:95:0x01e9, B:97:0x01f3, B:100:0x0206, B:99:0x01f9, B:101:0x020c, B:102:0x021d, B:103:0x022e, B:104:0x023f, B:105:0x0250, B:107:0x0256, B:108:0x0275, B:109:0x028a, B:110:0x029a, B:111:0x02aa, B:112:0x02ba, B:113:0x02ca, B:114:0x02da, B:115:0x02ea, B:116:0x02fa, B:117:0x030a, B:119:0x0310, B:120:0x0320, B:121:0x0330, B:122:0x0344, B:123:0x0354, B:124:0x0364, B:125:0x037c, B:126:0x038c, B:127:0x039c, B:128:0x03ac, B:129:0x03bc, B:130:0x03cc, B:131:0x03dc, B:132:0x03ec, B:133:0x03fc, B:134:0x040c, B:135:0x041c, B:136:0x042c, B:137:0x043c, B:138:0x044c, B:139:0x0464, B:140:0x0474, B:141:0x0484, B:142:0x0494, B:143:0x04a4, B:144:0x04b8, B:146:0x04cb, B:147:0x04d4, B:148:0x04e5, B:150:0x04ed, B:151:0x04fc, B:152:0x0511, B:153:0x0526, B:154:0x053b, B:155:0x0550, B:156:0x0565, B:157:0x057a, B:158:0x058f, B:159:0x05a4, B:160:0x05ac, B:162:0x05b2, B:163:0x05cf, B:164:0x05d4, B:165:0x05e8, B:166:0x05f9, B:167:0x060e, B:169:0x0618, B:172:0x062f, B:171:0x061e, B:173:0x0635, B:174:0x064a, B:175:0x065f, B:176:0x0674, B:177:0x0689), top: B:197:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:71:0x00ee A[LOOP:2: B:69:0x00ea->B:71:0x00ee, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zza(T t, zzwk zzwkVar, zzub zzubVar) throws Throwable {
        Object obj;
        int i;
        int i2;
        Object objZzag;
        if (zzubVar == null) {
            throw new NullPointerException();
        }
        zzxd<?, ?> zzxdVar = this.zzcbg;
        zzuc<?> zzucVar = this.zzcbh;
        Object objZza = null;
        zzuf zzufVarZzx = null;
        while (true) {
            try {
                int iZzvh = zzwkVar.zzvh();
                if (iZzvh < this.zzcau || iZzvh > this.zzcav) {
                    i = -1;
                } else {
                    int i3 = 0;
                    int length = (this.zzcas.length / 3) - 1;
                    while (true) {
                        if (i3 > length) {
                            i = -1;
                        } else {
                            int i4 = (length + i3) >>> 1;
                            i = i4 * 3;
                            int i5 = this.zzcas[i];
                            if (iZzvh != i5) {
                                if (iZzvh < i5) {
                                    length = i4 - 1;
                                } else {
                                    i3 = i4 + 1;
                                }
                            }
                        }
                    }
                }
                if (i >= 0) {
                    int iZzbt = zzbt(i);
                    switch ((267386880 & iZzbt) >>> 20) {
                        case 0:
                            zzxj.zza(t, iZzbt & 1048575, zzwkVar.readDouble());
                            zzc(t, i);
                            break;
                        case 1:
                            zzxj.zza((Object) t, iZzbt & 1048575, zzwkVar.readFloat());
                            zzc(t, i);
                            break;
                        case 2:
                            zzxj.zza((Object) t, iZzbt & 1048575, zzwkVar.zzul());
                            zzc(t, i);
                            break;
                        case 3:
                            zzxj.zza((Object) t, iZzbt & 1048575, zzwkVar.zzuk());
                            zzc(t, i);
                            break;
                        case 4:
                            zzxj.zzb(t, iZzbt & 1048575, zzwkVar.zzum());
                            zzc(t, i);
                            break;
                        case 5:
                            zzxj.zza((Object) t, iZzbt & 1048575, zzwkVar.zzun());
                            zzc(t, i);
                            break;
                        case 6:
                            zzxj.zzb(t, iZzbt & 1048575, zzwkVar.zzuo());
                            zzc(t, i);
                            break;
                        case 7:
                            zzxj.zza(t, iZzbt & 1048575, zzwkVar.zzup());
                            zzc(t, i);
                            break;
                        case 8:
                            zza(t, iZzbt, zzwkVar);
                            zzc(t, i);
                            break;
                        case 9:
                            if (zzb(t, i)) {
                                zzxj.zza(t, iZzbt & 1048575, zzuq.zzb(zzxj.zzp(t, 1048575 & iZzbt), zzwkVar.zza(zzbq(i), zzubVar)));
                            } else {
                                zzxj.zza(t, iZzbt & 1048575, zzwkVar.zza(zzbq(i), zzubVar));
                                zzc(t, i);
                            }
                            break;
                        case 10:
                            zzxj.zza(t, iZzbt & 1048575, zzwkVar.zzur());
                            zzc(t, i);
                            break;
                        case 11:
                            zzxj.zzb(t, iZzbt & 1048575, zzwkVar.zzus());
                            zzc(t, i);
                            break;
                        case 12:
                            int iZzut = zzwkVar.zzut();
                            zzut zzutVarZzbs = zzbs(i);
                            if (zzutVarZzbs == null || zzutVarZzbs.zzb(iZzut)) {
                                zzxj.zzb(t, iZzbt & 1048575, iZzut);
                                zzc(t, i);
                            } else {
                                objZza = zzwn.zza(iZzvh, iZzut, objZza, (zzxd<UT, Object>) zzxdVar);
                            }
                            break;
                        case 13:
                            zzxj.zzb(t, iZzbt & 1048575, zzwkVar.zzuu());
                            zzc(t, i);
                            break;
                        case 14:
                            zzxj.zza((Object) t, iZzbt & 1048575, zzwkVar.zzuv());
                            zzc(t, i);
                            break;
                        case 15:
                            zzxj.zzb(t, iZzbt & 1048575, zzwkVar.zzuw());
                            zzc(t, i);
                            break;
                        case 16:
                            zzxj.zza((Object) t, iZzbt & 1048575, zzwkVar.zzux());
                            zzc(t, i);
                            break;
                        case 17:
                            if (zzb(t, i)) {
                                zzxj.zza(t, iZzbt & 1048575, zzuq.zzb(zzxj.zzp(t, 1048575 & iZzbt), zzwkVar.zzb(zzbq(i), zzubVar)));
                            } else {
                                zzxj.zza(t, iZzbt & 1048575, zzwkVar.zzb(zzbq(i), zzubVar));
                                zzc(t, i);
                            }
                            break;
                        case 18:
                            zzwkVar.zzi(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 19:
                            zzwkVar.zzj(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 20:
                            zzwkVar.zzl(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 21:
                            zzwkVar.zzk(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 22:
                            zzwkVar.zzm(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 23:
                            zzwkVar.zzn(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 24:
                            zzwkVar.zzo(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 25:
                            zzwkVar.zzp(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 26:
                            if (zzbv(iZzbt)) {
                                zzwkVar.zzq(this.zzcbf.zza(t, iZzbt & 1048575));
                            } else {
                                zzwkVar.readStringList(this.zzcbf.zza(t, iZzbt & 1048575));
                            }
                            break;
                        case 27:
                            zzwkVar.zza(this.zzcbf.zza(t, iZzbt & 1048575), zzbq(i), zzubVar);
                            break;
                        case 28:
                            zzwkVar.zzr(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 29:
                            zzwkVar.zzs(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 30:
                            List<Integer> listZza = this.zzcbf.zza(t, iZzbt & 1048575);
                            zzwkVar.zzt(listZza);
                            objZza = zzwn.zza(iZzvh, listZza, zzbs(i), objZza, zzxdVar);
                            break;
                        case 31:
                            zzwkVar.zzu(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 32:
                            zzwkVar.zzv(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 33:
                            zzwkVar.zzw(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 34:
                            zzwkVar.zzx(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 35:
                            zzwkVar.zzi(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 36:
                            zzwkVar.zzj(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 37:
                            zzwkVar.zzl(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 38:
                            zzwkVar.zzk(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 39:
                            zzwkVar.zzm(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 40:
                            zzwkVar.zzn(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 41:
                            zzwkVar.zzo(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 42:
                            zzwkVar.zzp(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 43:
                            zzwkVar.zzs(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 44:
                            List<Integer> listZza2 = this.zzcbf.zza(t, iZzbt & 1048575);
                            zzwkVar.zzt(listZza2);
                            objZza = zzwn.zza(iZzvh, listZza2, zzbs(i), objZza, zzxdVar);
                            break;
                        case 45:
                            zzwkVar.zzu(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 46:
                            zzwkVar.zzv(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 47:
                            zzwkVar.zzw(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 48:
                            zzwkVar.zzx(this.zzcbf.zza(t, iZzbt & 1048575));
                            break;
                        case 49:
                            zzwkVar.zzb(this.zzcbf.zza(t, iZzbt & 1048575), zzbq(i), zzubVar);
                            break;
                        case 50:
                            Object objZzbr = zzbr(i);
                            long jZzbt = zzbt(i) & 1048575;
                            Object objZzp = zzxj.zzp(t, jZzbt);
                            if (objZzp == null) {
                                objZzag = this.zzcbi.zzag(objZzbr);
                                zzxj.zza(t, jZzbt, objZzag);
                            } else if (this.zzcbi.zzae(objZzp)) {
                                objZzag = this.zzcbi.zzag(objZzbr);
                                this.zzcbi.zzc(objZzag, objZzp);
                                zzxj.zza(t, jZzbt, objZzag);
                            } else {
                                objZzag = objZzp;
                            }
                            zzwkVar.zza(this.zzcbi.zzac(objZzag), this.zzcbi.zzah(objZzbr), zzubVar);
                            break;
                        case 51:
                            zzxj.zza(t, iZzbt & 1048575, Double.valueOf(zzwkVar.readDouble()));
                            zzb(t, iZzvh, i);
                            break;
                        case 52:
                            zzxj.zza(t, iZzbt & 1048575, Float.valueOf(zzwkVar.readFloat()));
                            zzb(t, iZzvh, i);
                            break;
                        case 53:
                            zzxj.zza(t, iZzbt & 1048575, Long.valueOf(zzwkVar.zzul()));
                            zzb(t, iZzvh, i);
                            break;
                        case 54:
                            zzxj.zza(t, iZzbt & 1048575, Long.valueOf(zzwkVar.zzuk()));
                            zzb(t, iZzvh, i);
                            break;
                        case 55:
                            zzxj.zza(t, iZzbt & 1048575, Integer.valueOf(zzwkVar.zzum()));
                            zzb(t, iZzvh, i);
                            break;
                        case 56:
                            zzxj.zza(t, iZzbt & 1048575, Long.valueOf(zzwkVar.zzun()));
                            zzb(t, iZzvh, i);
                            break;
                        case 57:
                            zzxj.zza(t, iZzbt & 1048575, Integer.valueOf(zzwkVar.zzuo()));
                            zzb(t, iZzvh, i);
                            break;
                        case 58:
                            zzxj.zza(t, iZzbt & 1048575, Boolean.valueOf(zzwkVar.zzup()));
                            zzb(t, iZzvh, i);
                            break;
                        case 59:
                            zza(t, iZzbt, zzwkVar);
                            zzb(t, iZzvh, i);
                            break;
                        case 60:
                            if (zza(t, iZzvh, i)) {
                                zzxj.zza(t, iZzbt & 1048575, zzuq.zzb(zzxj.zzp(t, 1048575 & iZzbt), zzwkVar.zza(zzbq(i), zzubVar)));
                            } else {
                                zzxj.zza(t, iZzbt & 1048575, zzwkVar.zza(zzbq(i), zzubVar));
                                zzc(t, i);
                            }
                            zzb(t, iZzvh, i);
                            break;
                        case 61:
                            zzxj.zza(t, iZzbt & 1048575, zzwkVar.zzur());
                            zzb(t, iZzvh, i);
                            break;
                        case 62:
                            zzxj.zza(t, iZzbt & 1048575, Integer.valueOf(zzwkVar.zzus()));
                            zzb(t, iZzvh, i);
                            break;
                        case 63:
                            int iZzut2 = zzwkVar.zzut();
                            zzut zzutVarZzbs2 = zzbs(i);
                            if (zzutVarZzbs2 == null || zzutVarZzbs2.zzb(iZzut2)) {
                                zzxj.zza(t, iZzbt & 1048575, Integer.valueOf(iZzut2));
                                zzb(t, iZzvh, i);
                            } else {
                                objZza = zzwn.zza(iZzvh, iZzut2, objZza, (zzxd<UT, Object>) zzxdVar);
                            }
                            break;
                        case 64:
                            zzxj.zza(t, iZzbt & 1048575, Integer.valueOf(zzwkVar.zzuu()));
                            zzb(t, iZzvh, i);
                            break;
                        case 65:
                            zzxj.zza(t, iZzbt & 1048575, Long.valueOf(zzwkVar.zzuv()));
                            zzb(t, iZzvh, i);
                            break;
                        case 66:
                            zzxj.zza(t, iZzbt & 1048575, Integer.valueOf(zzwkVar.zzuw()));
                            zzb(t, iZzvh, i);
                            break;
                        case 67:
                            zzxj.zza(t, iZzbt & 1048575, Long.valueOf(zzwkVar.zzux()));
                            zzb(t, iZzvh, i);
                            break;
                        case 68:
                            zzxj.zza(t, iZzbt & 1048575, zzwkVar.zzb(zzbq(i), zzubVar));
                            zzb(t, iZzvh, i);
                            break;
                        default:
                            if (objZza == null) {
                                try {
                                    objZza = zzxdVar.zzyk();
                                } catch (zzuw e) {
                                    zzxdVar.zza(zzwkVar);
                                    if (objZza == null) {
                                        objZza = zzxdVar.zzam(t);
                                    }
                                    if (!zzxdVar.zza((Object) objZza, zzwkVar)) {
                                        for (i2 = this.zzcbc; i2 < this.zzcbd; i2++) {
                                            objZza = zza((Object) t, this.zzcbb[i2], objZza, (zzxd<UT, Object>) zzxdVar);
                                        }
                                        if (objZza != null) {
                                            zzxdVar.zzg(t, (Object) objZza);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            try {
                                if (!zzxdVar.zza((Object) objZza, zzwkVar)) {
                                    for (int i6 = this.zzcbc; i6 < this.zzcbd; i6++) {
                                        objZza = zza((Object) t, this.zzcbb[i6], objZza, (zzxd<UT, Object>) zzxdVar);
                                    }
                                    if (objZza != null) {
                                        zzxdVar.zzg(t, (Object) objZza);
                                        return;
                                    }
                                    return;
                                }
                            } catch (zzuw e2) {
                                zzxdVar.zza(zzwkVar);
                                if (objZza == null) {
                                    objZza = zzxdVar.zzam(t);
                                }
                                if (!zzxdVar.zza((Object) objZza, zzwkVar)) {
                                    while (i2 < this.zzcbd) {
                                        objZza = zza((Object) t, this.zzcbb[i2], objZza, (zzxd<UT, Object>) zzxdVar);
                                    }
                                    if (objZza != null) {
                                        zzxdVar.zzg(t, (Object) objZza);
                                        return;
                                    }
                                    return;
                                }
                            }
                    }
                } else {
                    if (iZzvh == Integer.MAX_VALUE) {
                        for (int i7 = this.zzcbc; i7 < this.zzcbd; i7++) {
                            objZza = zza((Object) t, this.zzcbb[i7], objZza, (zzxd<UT, Object>) zzxdVar);
                        }
                        if (objZza != null) {
                            zzxdVar.zzg(t, (Object) objZza);
                            return;
                        }
                        return;
                    }
                    Object objZza2 = !this.zzcax ? null : zzucVar.zza(zzubVar, this.zzcaw, iZzvh);
                    if (objZza2 != null) {
                        if (zzufVarZzx == null) {
                            zzufVarZzx = zzucVar.zzx(t);
                        }
                        objZza = zzucVar.zza(zzwkVar, objZza2, zzubVar, zzufVarZzx, objZza, zzxdVar);
                    } else {
                        zzxdVar.zza(zzwkVar);
                        if (objZza == null) {
                            objZza = zzxdVar.zzam(t);
                        }
                        try {
                            if (!zzxdVar.zza((Object) objZza, zzwkVar)) {
                                for (int i8 = this.zzcbc; i8 < this.zzcbd; i8++) {
                                    objZza = zza((Object) t, this.zzcbb[i8], objZza, (zzxd<UT, Object>) zzxdVar);
                                }
                                if (objZza != null) {
                                    zzxdVar.zzg(t, (Object) objZza);
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            obj = objZza;
                            Object objZza3 = obj;
                            for (int i9 = this.zzcbc; i9 < this.zzcbd; i9++) {
                                objZza3 = zza((Object) t, this.zzcbb[i9], objZza3, (zzxd<UT, Object>) zzxdVar);
                            }
                            if (objZza3 != null) {
                                zzxdVar.zzg(t, (Object) objZza3);
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = objZza;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:339:0x0c18  */
    /* JADX WARN: Code duplicated, block: B:340:0x0c1b  */
    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zza(T t, zzxy zzxyVar) throws IOException {
        Iterator it;
        Iterator itDescendingIterator;
        if (zzxyVar.zzvm() == zzuo.zze.zzbyy) {
            zza(this.zzcbg, t, zzxyVar);
            Map.Entry<?, ?> entry = null;
            if (this.zzcax) {
                zzuf<T> zzufVarZzw = this.zzcbh.zzw(t);
                if (zzufVarZzw.isEmpty()) {
                    itDescendingIterator = null;
                } else {
                    itDescendingIterator = zzufVarZzw.descendingIterator();
                    entry = (Map.Entry) itDescendingIterator.next();
                }
            } else {
                itDescendingIterator = null;
            }
            int length = this.zzcas.length - 3;
            Map.Entry<?, ?> entry2 = entry;
            while (length >= 0) {
                int iZzbt = zzbt(length);
                int i = this.zzcas[length];
                Map.Entry<?, ?> entry3 = entry2;
                while (entry3 != null && this.zzcbh.zzb(entry3) > i) {
                    this.zzcbh.zza(zzxyVar, entry3);
                    entry3 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
                }
                switch ((267386880 & iZzbt) >>> 20) {
                    case 0:
                        if (zzb(t, length)) {
                            zzxyVar.zza(i, zzxj.zzo(t, 1048575 & iZzbt));
                        }
                        break;
                    case 1:
                        if (zzb(t, length)) {
                            zzxyVar.zza(i, zzxj.zzn(t, 1048575 & iZzbt));
                        }
                        break;
                    case 2:
                        if (zzb(t, length)) {
                            zzxyVar.zzi(i, zzxj.zzl(t, 1048575 & iZzbt));
                        }
                        break;
                    case 3:
                        if (zzb(t, length)) {
                            zzxyVar.zza(i, zzxj.zzl(t, 1048575 & iZzbt));
                        }
                        break;
                    case 4:
                        if (zzb(t, length)) {
                            zzxyVar.zzd(i, zzxj.zzk(t, 1048575 & iZzbt));
                        }
                        break;
                    case 5:
                        if (zzb(t, length)) {
                            zzxyVar.zzc(i, zzxj.zzl(t, 1048575 & iZzbt));
                        }
                        break;
                    case 6:
                        if (zzb(t, length)) {
                            zzxyVar.zzg(i, zzxj.zzk(t, 1048575 & iZzbt));
                        }
                        break;
                    case 7:
                        if (zzb(t, length)) {
                            zzxyVar.zzb(i, zzxj.zzm(t, 1048575 & iZzbt));
                        }
                        break;
                    case 8:
                        if (zzb(t, length)) {
                            zza(i, zzxj.zzp(t, 1048575 & iZzbt), zzxyVar);
                        }
                        break;
                    case 9:
                        if (zzb(t, length)) {
                            zzxyVar.zza(i, zzxj.zzp(t, 1048575 & iZzbt), zzbq(length));
                        }
                        break;
                    case 10:
                        if (zzb(t, length)) {
                            zzxyVar.zza(i, (zzte) zzxj.zzp(t, 1048575 & iZzbt));
                        }
                        break;
                    case 11:
                        if (zzb(t, length)) {
                            zzxyVar.zze(i, zzxj.zzk(t, 1048575 & iZzbt));
                        }
                        break;
                    case 12:
                        if (zzb(t, length)) {
                            zzxyVar.zzo(i, zzxj.zzk(t, 1048575 & iZzbt));
                        }
                        break;
                    case 13:
                        if (zzb(t, length)) {
                            zzxyVar.zzn(i, zzxj.zzk(t, 1048575 & iZzbt));
                        }
                        break;
                    case 14:
                        if (zzb(t, length)) {
                            zzxyVar.zzj(i, zzxj.zzl(t, 1048575 & iZzbt));
                        }
                        break;
                    case 15:
                        if (zzb(t, length)) {
                            zzxyVar.zzf(i, zzxj.zzk(t, 1048575 & iZzbt));
                        }
                        break;
                    case 16:
                        if (zzb(t, length)) {
                            zzxyVar.zzb(i, zzxj.zzl(t, 1048575 & iZzbt));
                        }
                        break;
                    case 17:
                        if (zzb(t, length)) {
                            zzxyVar.zzb(i, zzxj.zzp(t, 1048575 & iZzbt), zzbq(length));
                        }
                        break;
                    case 18:
                        zzwn.zza(this.zzcas[length], (List<Double>) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 19:
                        zzwn.zzb(this.zzcas[length], (List<Float>) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 20:
                        zzwn.zzc(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 21:
                        zzwn.zzd(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 22:
                        zzwn.zzh(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 23:
                        zzwn.zzf(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 24:
                        zzwn.zzk(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 25:
                        zzwn.zzn(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 26:
                        zzwn.zza(this.zzcas[length], (List<String>) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar);
                        break;
                    case 27:
                        zzwn.zza(this.zzcas[length], (List<?>) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, zzbq(length));
                        break;
                    case 28:
                        zzwn.zzb(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar);
                        break;
                    case 29:
                        zzwn.zzi(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 30:
                        zzwn.zzm(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 31:
                        zzwn.zzl(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 32:
                        zzwn.zzg(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 33:
                        zzwn.zzj(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 34:
                        zzwn.zze(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, false);
                        break;
                    case 35:
                        zzwn.zza(this.zzcas[length], (List<Double>) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 36:
                        zzwn.zzb(this.zzcas[length], (List<Float>) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 37:
                        zzwn.zzc(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 38:
                        zzwn.zzd(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 39:
                        zzwn.zzh(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 40:
                        zzwn.zzf(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 41:
                        zzwn.zzk(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 42:
                        zzwn.zzn(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 43:
                        zzwn.zzi(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 44:
                        zzwn.zzm(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 45:
                        zzwn.zzl(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 46:
                        zzwn.zzg(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 47:
                        zzwn.zzj(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 48:
                        zzwn.zze(this.zzcas[length], (List) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, true);
                        break;
                    case 49:
                        zzwn.zzb(this.zzcas[length], (List<?>) zzxj.zzp(t, 1048575 & iZzbt), zzxyVar, zzbq(length));
                        break;
                    case 50:
                        zza(zzxyVar, i, zzxj.zzp(t, 1048575 & iZzbt), length);
                        break;
                    case 51:
                        if (zza(t, i, length)) {
                            zzxyVar.zza(i, zzf(t, 1048575 & iZzbt));
                        }
                        break;
                    case 52:
                        if (zza(t, i, length)) {
                            zzxyVar.zza(i, zzg(t, 1048575 & iZzbt));
                        }
                        break;
                    case 53:
                        if (zza(t, i, length)) {
                            zzxyVar.zzi(i, zzi(t, 1048575 & iZzbt));
                        }
                        break;
                    case 54:
                        if (zza(t, i, length)) {
                            zzxyVar.zza(i, zzi(t, 1048575 & iZzbt));
                        }
                        break;
                    case 55:
                        if (zza(t, i, length)) {
                            zzxyVar.zzd(i, zzh(t, 1048575 & iZzbt));
                        }
                        break;
                    case 56:
                        if (zza(t, i, length)) {
                            zzxyVar.zzc(i, zzi(t, 1048575 & iZzbt));
                        }
                        break;
                    case 57:
                        if (zza(t, i, length)) {
                            zzxyVar.zzg(i, zzh(t, 1048575 & iZzbt));
                        }
                        break;
                    case 58:
                        if (zza(t, i, length)) {
                            zzxyVar.zzb(i, zzj(t, 1048575 & iZzbt));
                        }
                        break;
                    case 59:
                        if (zza(t, i, length)) {
                            zza(i, zzxj.zzp(t, 1048575 & iZzbt), zzxyVar);
                        }
                        break;
                    case 60:
                        if (zza(t, i, length)) {
                            zzxyVar.zza(i, zzxj.zzp(t, 1048575 & iZzbt), zzbq(length));
                        }
                        break;
                    case 61:
                        if (zza(t, i, length)) {
                            zzxyVar.zza(i, (zzte) zzxj.zzp(t, 1048575 & iZzbt));
                        }
                        break;
                    case 62:
                        if (zza(t, i, length)) {
                            zzxyVar.zze(i, zzh(t, 1048575 & iZzbt));
                        }
                        break;
                    case 63:
                        if (zza(t, i, length)) {
                            zzxyVar.zzo(i, zzh(t, 1048575 & iZzbt));
                        }
                        break;
                    case 64:
                        if (zza(t, i, length)) {
                            zzxyVar.zzn(i, zzh(t, 1048575 & iZzbt));
                        }
                        break;
                    case 65:
                        if (zza(t, i, length)) {
                            zzxyVar.zzj(i, zzi(t, 1048575 & iZzbt));
                        }
                        break;
                    case 66:
                        if (zza(t, i, length)) {
                            zzxyVar.zzf(i, zzh(t, 1048575 & iZzbt));
                        }
                        break;
                    case 67:
                        if (zza(t, i, length)) {
                            zzxyVar.zzb(i, zzi(t, 1048575 & iZzbt));
                        }
                        break;
                    case 68:
                        if (zza(t, i, length)) {
                            zzxyVar.zzb(i, zzxj.zzp(t, 1048575 & iZzbt), zzbq(length));
                        }
                        break;
                }
                length -= 3;
                entry2 = entry3;
            }
            while (entry2 != null) {
                this.zzcbh.zza(zzxyVar, entry2);
                entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            return;
        }
        if (!this.zzcaz) {
            zzb(t, zzxyVar);
            return;
        }
        Map.Entry<?, ?> entry4 = null;
        if (this.zzcax) {
            zzuf<T> zzufVarZzw2 = this.zzcbh.zzw(t);
            if (zzufVarZzw2.isEmpty()) {
                it = null;
            } else {
                it = zzufVarZzw2.iterator();
                entry4 = (Map.Entry) it.next();
            }
        } else {
            it = null;
        }
        int length2 = this.zzcas.length;
        int i2 = 0;
        Map.Entry<?, ?> entry5 = entry4;
        while (i2 < length2) {
            int iZzbt2 = zzbt(i2);
            int i3 = this.zzcas[i2];
            Map.Entry<?, ?> entry6 = entry5;
            while (entry6 != null && this.zzcbh.zzb(entry6) <= i3) {
                this.zzcbh.zza(zzxyVar, entry6);
                entry6 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch ((267386880 & iZzbt2) >>> 20) {
                case 0:
                    if (zzb(t, i2)) {
                        zzxyVar.zza(i3, zzxj.zzo(t, 1048575 & iZzbt2));
                    }
                    break;
                case 1:
                    if (zzb(t, i2)) {
                        zzxyVar.zza(i3, zzxj.zzn(t, 1048575 & iZzbt2));
                    }
                    break;
                case 2:
                    if (zzb(t, i2)) {
                        zzxyVar.zzi(i3, zzxj.zzl(t, 1048575 & iZzbt2));
                    }
                    break;
                case 3:
                    if (zzb(t, i2)) {
                        zzxyVar.zza(i3, zzxj.zzl(t, 1048575 & iZzbt2));
                    }
                    break;
                case 4:
                    if (zzb(t, i2)) {
                        zzxyVar.zzd(i3, zzxj.zzk(t, 1048575 & iZzbt2));
                    }
                    break;
                case 5:
                    if (zzb(t, i2)) {
                        zzxyVar.zzc(i3, zzxj.zzl(t, 1048575 & iZzbt2));
                    }
                    break;
                case 6:
                    if (zzb(t, i2)) {
                        zzxyVar.zzg(i3, zzxj.zzk(t, 1048575 & iZzbt2));
                    }
                    break;
                case 7:
                    if (zzb(t, i2)) {
                        zzxyVar.zzb(i3, zzxj.zzm(t, 1048575 & iZzbt2));
                    }
                    break;
                case 8:
                    if (zzb(t, i2)) {
                        zza(i3, zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar);
                    }
                    break;
                case 9:
                    if (zzb(t, i2)) {
                        zzxyVar.zza(i3, zzxj.zzp(t, 1048575 & iZzbt2), zzbq(i2));
                    }
                    break;
                case 10:
                    if (zzb(t, i2)) {
                        zzxyVar.zza(i3, (zzte) zzxj.zzp(t, 1048575 & iZzbt2));
                    }
                    break;
                case 11:
                    if (zzb(t, i2)) {
                        zzxyVar.zze(i3, zzxj.zzk(t, 1048575 & iZzbt2));
                    }
                    break;
                case 12:
                    if (zzb(t, i2)) {
                        zzxyVar.zzo(i3, zzxj.zzk(t, 1048575 & iZzbt2));
                    }
                    break;
                case 13:
                    if (zzb(t, i2)) {
                        zzxyVar.zzn(i3, zzxj.zzk(t, 1048575 & iZzbt2));
                    }
                    break;
                case 14:
                    if (zzb(t, i2)) {
                        zzxyVar.zzj(i3, zzxj.zzl(t, 1048575 & iZzbt2));
                    }
                    break;
                case 15:
                    if (zzb(t, i2)) {
                        zzxyVar.zzf(i3, zzxj.zzk(t, 1048575 & iZzbt2));
                    }
                    break;
                case 16:
                    if (zzb(t, i2)) {
                        zzxyVar.zzb(i3, zzxj.zzl(t, 1048575 & iZzbt2));
                    }
                    break;
                case 17:
                    if (zzb(t, i2)) {
                        zzxyVar.zzb(i3, zzxj.zzp(t, 1048575 & iZzbt2), zzbq(i2));
                    }
                    break;
                case 18:
                    zzwn.zza(this.zzcas[i2], (List<Double>) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 19:
                    zzwn.zzb(this.zzcas[i2], (List<Float>) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 20:
                    zzwn.zzc(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 21:
                    zzwn.zzd(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 22:
                    zzwn.zzh(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 23:
                    zzwn.zzf(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 24:
                    zzwn.zzk(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 25:
                    zzwn.zzn(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 26:
                    zzwn.zza(this.zzcas[i2], (List<String>) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar);
                    break;
                case 27:
                    zzwn.zza(this.zzcas[i2], (List<?>) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, zzbq(i2));
                    break;
                case 28:
                    zzwn.zzb(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar);
                    break;
                case 29:
                    zzwn.zzi(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 30:
                    zzwn.zzm(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 31:
                    zzwn.zzl(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 32:
                    zzwn.zzg(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 33:
                    zzwn.zzj(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 34:
                    zzwn.zze(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, false);
                    break;
                case 35:
                    zzwn.zza(this.zzcas[i2], (List<Double>) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 36:
                    zzwn.zzb(this.zzcas[i2], (List<Float>) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 37:
                    zzwn.zzc(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 38:
                    zzwn.zzd(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 39:
                    zzwn.zzh(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 40:
                    zzwn.zzf(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 41:
                    zzwn.zzk(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 42:
                    zzwn.zzn(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 43:
                    zzwn.zzi(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 44:
                    zzwn.zzm(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 45:
                    zzwn.zzl(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 46:
                    zzwn.zzg(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 47:
                    zzwn.zzj(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 48:
                    zzwn.zze(this.zzcas[i2], (List) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, true);
                    break;
                case 49:
                    zzwn.zzb(this.zzcas[i2], (List<?>) zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar, zzbq(i2));
                    break;
                case 50:
                    zza(zzxyVar, i3, zzxj.zzp(t, 1048575 & iZzbt2), i2);
                    break;
                case 51:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zza(i3, zzf(t, 1048575 & iZzbt2));
                    }
                    break;
                case 52:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zza(i3, zzg(t, 1048575 & iZzbt2));
                    }
                    break;
                case 53:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzi(i3, zzi(t, 1048575 & iZzbt2));
                    }
                    break;
                case 54:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zza(i3, zzi(t, 1048575 & iZzbt2));
                    }
                    break;
                case 55:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzd(i3, zzh(t, 1048575 & iZzbt2));
                    }
                    break;
                case 56:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzc(i3, zzi(t, 1048575 & iZzbt2));
                    }
                    break;
                case 57:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzg(i3, zzh(t, 1048575 & iZzbt2));
                    }
                    break;
                case 58:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzb(i3, zzj(t, 1048575 & iZzbt2));
                    }
                    break;
                case 59:
                    if (zza(t, i3, i2)) {
                        zza(i3, zzxj.zzp(t, 1048575 & iZzbt2), zzxyVar);
                    }
                    break;
                case 60:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zza(i3, zzxj.zzp(t, 1048575 & iZzbt2), zzbq(i2));
                    }
                    break;
                case 61:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zza(i3, (zzte) zzxj.zzp(t, 1048575 & iZzbt2));
                    }
                    break;
                case 62:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zze(i3, zzh(t, 1048575 & iZzbt2));
                    }
                    break;
                case 63:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzo(i3, zzh(t, 1048575 & iZzbt2));
                    }
                    break;
                case 64:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzn(i3, zzh(t, 1048575 & iZzbt2));
                    }
                    break;
                case 65:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzj(i3, zzi(t, 1048575 & iZzbt2));
                    }
                    break;
                case 66:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzf(i3, zzh(t, 1048575 & iZzbt2));
                    }
                    break;
                case 67:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzb(i3, zzi(t, 1048575 & iZzbt2));
                    }
                    break;
                case 68:
                    if (zza(t, i3, i2)) {
                        zzxyVar.zzb(i3, zzxj.zzp(t, 1048575 & iZzbt2), zzbq(i2));
                    }
                    break;
            }
            i2 += 3;
            entry5 = entry6;
        }
        while (entry5 != null) {
            this.zzcbh.zza(zzxyVar, entry5);
            entry5 = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzcbg, t, zzxyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final int zzai(T t) {
        int i;
        if (this.zzcaz) {
            Unsafe unsafe = zzcar;
            int iZzc = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.zzcas.length) {
                    return zza(this.zzcbg, t) + iZzc;
                }
                int iZzbt = zzbt(i3);
                int i4 = (267386880 & iZzbt) >>> 20;
                int i5 = this.zzcas[i3];
                long j = iZzbt & 1048575;
                int i6 = (i4 < zzui.DOUBLE_LIST_PACKED.id() || i4 > zzui.SINT64_LIST_PACKED.id()) ? 0 : this.zzcas[i3 + 2] & 1048575;
                switch (i4) {
                    case 0:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzb(i5, 0.0d);
                        }
                        break;
                    case 1:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzb(i5, 0.0f);
                        }
                        break;
                    case 2:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzd(i5, zzxj.zzl(t, j));
                        }
                        break;
                    case 3:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zze(i5, zzxj.zzl(t, j));
                        }
                        break;
                    case 4:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzh(i5, zzxj.zzk(t, j));
                        }
                        break;
                    case 5:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzg(i5, 0L);
                        }
                        break;
                    case 6:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzk(i5, 0);
                        }
                        break;
                    case 7:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzc(i5, true);
                        }
                        break;
                    case 8:
                        if (zzb(t, i3)) {
                            Object objZzp = zzxj.zzp(t, j);
                            iZzc = !(objZzp instanceof zzte) ? iZzc + zztv.zzc(i5, (String) objZzp) : iZzc + zztv.zzc(i5, (zzte) objZzp);
                        }
                        break;
                    case 9:
                        if (zzb(t, i3)) {
                            iZzc += zzwn.zzc(i5, zzxj.zzp(t, j), zzbq(i3));
                        }
                        break;
                    case 10:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzc(i5, (zzte) zzxj.zzp(t, j));
                        }
                        break;
                    case 11:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzi(i5, zzxj.zzk(t, j));
                        }
                        break;
                    case 12:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzm(i5, zzxj.zzk(t, j));
                        }
                        break;
                    case 13:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzl(i5, 0);
                        }
                        break;
                    case 14:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzh(i5, 0L);
                        }
                        break;
                    case 15:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzj(i5, zzxj.zzk(t, j));
                        }
                        break;
                    case 16:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzf(i5, zzxj.zzl(t, j));
                        }
                        break;
                    case 17:
                        if (zzb(t, i3)) {
                            iZzc += zztv.zzc(i5, (zzvv) zzxj.zzp(t, j), zzbq(i3));
                        }
                        break;
                    case 18:
                        iZzc += zzwn.zzw(i5, zze(t, j), false);
                        break;
                    case 19:
                        iZzc += zzwn.zzv(i5, zze(t, j), false);
                        break;
                    case 20:
                        iZzc += zzwn.zzo(i5, zze(t, j), false);
                        break;
                    case 21:
                        iZzc += zzwn.zzp(i5, zze(t, j), false);
                        break;
                    case 22:
                        iZzc += zzwn.zzs(i5, zze(t, j), false);
                        break;
                    case 23:
                        iZzc += zzwn.zzw(i5, zze(t, j), false);
                        break;
                    case 24:
                        iZzc += zzwn.zzv(i5, zze(t, j), false);
                        break;
                    case 25:
                        iZzc += zzwn.zzx(i5, zze(t, j), false);
                        break;
                    case 26:
                        iZzc += zzwn.zzc(i5, zze(t, j));
                        break;
                    case 27:
                        iZzc += zzwn.zzc(i5, (List<?>) zze(t, j), zzbq(i3));
                        break;
                    case 28:
                        iZzc += zzwn.zzd(i5, zze(t, j));
                        break;
                    case 29:
                        iZzc += zzwn.zzt(i5, zze(t, j), false);
                        break;
                    case 30:
                        iZzc += zzwn.zzr(i5, zze(t, j), false);
                        break;
                    case 31:
                        iZzc += zzwn.zzv(i5, zze(t, j), false);
                        break;
                    case 32:
                        iZzc += zzwn.zzw(i5, zze(t, j), false);
                        break;
                    case 33:
                        iZzc += zzwn.zzu(i5, zze(t, j), false);
                        break;
                    case 34:
                        iZzc += zzwn.zzq(i5, zze(t, j), false);
                        break;
                    case 35:
                        int iZzag = zzwn.zzag((List) unsafe.getObject(t, j));
                        if (iZzag > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzag);
                            }
                            iZzc += iZzag + zztv.zzbd(i5) + zztv.zzbf(iZzag);
                        }
                        break;
                    case 36:
                        int iZzaf = zzwn.zzaf((List) unsafe.getObject(t, j));
                        if (iZzaf > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzaf);
                            }
                            iZzc += iZzaf + zztv.zzbd(i5) + zztv.zzbf(iZzaf);
                        }
                        break;
                    case 37:
                        int iZzy = zzwn.zzy((List) unsafe.getObject(t, j));
                        if (iZzy > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzy);
                            }
                            iZzc += iZzy + zztv.zzbd(i5) + zztv.zzbf(iZzy);
                        }
                        break;
                    case 38:
                        int iZzz = zzwn.zzz((List) unsafe.getObject(t, j));
                        if (iZzz > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzz);
                            }
                            iZzc += iZzz + zztv.zzbd(i5) + zztv.zzbf(iZzz);
                        }
                        break;
                    case 39:
                        int iZzac = zzwn.zzac((List) unsafe.getObject(t, j));
                        if (iZzac > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzac);
                            }
                            iZzc += iZzac + zztv.zzbd(i5) + zztv.zzbf(iZzac);
                        }
                        break;
                    case 40:
                        int iZzag2 = zzwn.zzag((List) unsafe.getObject(t, j));
                        if (iZzag2 > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzag2);
                            }
                            iZzc += iZzag2 + zztv.zzbd(i5) + zztv.zzbf(iZzag2);
                        }
                        break;
                    case 41:
                        int iZzaf2 = zzwn.zzaf((List) unsafe.getObject(t, j));
                        if (iZzaf2 > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzaf2);
                            }
                            iZzc += iZzaf2 + zztv.zzbd(i5) + zztv.zzbf(iZzaf2);
                        }
                        break;
                    case 42:
                        int iZzah = zzwn.zzah((List) unsafe.getObject(t, j));
                        if (iZzah > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzah);
                            }
                            iZzc += iZzah + zztv.zzbd(i5) + zztv.zzbf(iZzah);
                        }
                        break;
                    case 43:
                        int iZzad = zzwn.zzad((List) unsafe.getObject(t, j));
                        if (iZzad > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzad);
                            }
                            iZzc += iZzad + zztv.zzbd(i5) + zztv.zzbf(iZzad);
                        }
                        break;
                    case 44:
                        int iZzab = zzwn.zzab((List) unsafe.getObject(t, j));
                        if (iZzab > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzab);
                            }
                            iZzc += iZzab + zztv.zzbd(i5) + zztv.zzbf(iZzab);
                        }
                        break;
                    case 45:
                        int iZzaf3 = zzwn.zzaf((List) unsafe.getObject(t, j));
                        if (iZzaf3 > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzaf3);
                            }
                            iZzc += iZzaf3 + zztv.zzbd(i5) + zztv.zzbf(iZzaf3);
                        }
                        break;
                    case 46:
                        int iZzag3 = zzwn.zzag((List) unsafe.getObject(t, j));
                        if (iZzag3 > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzag3);
                            }
                            iZzc += iZzag3 + zztv.zzbd(i5) + zztv.zzbf(iZzag3);
                        }
                        break;
                    case 47:
                        int iZzae = zzwn.zzae((List) unsafe.getObject(t, j));
                        if (iZzae > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzae);
                            }
                            iZzc += iZzae + zztv.zzbd(i5) + zztv.zzbf(iZzae);
                        }
                        break;
                    case 48:
                        int iZzaa = zzwn.zzaa((List) unsafe.getObject(t, j));
                        if (iZzaa > 0) {
                            if (this.zzcba) {
                                unsafe.putInt(t, i6, iZzaa);
                            }
                            iZzc += iZzaa + zztv.zzbd(i5) + zztv.zzbf(iZzaa);
                        }
                        break;
                    case 49:
                        iZzc += zzwn.zzd(i5, zze(t, j), zzbq(i3));
                        break;
                    case 50:
                        iZzc += this.zzcbi.zzb(i5, zzxj.zzp(t, j), zzbr(i3));
                        break;
                    case 51:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzb(i5, 0.0d);
                        }
                        break;
                    case 52:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzb(i5, 0.0f);
                        }
                        break;
                    case 53:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzd(i5, zzi(t, j));
                        }
                        break;
                    case 54:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zze(i5, zzi(t, j));
                        }
                        break;
                    case 55:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzh(i5, zzh(t, j));
                        }
                        break;
                    case 56:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzg(i5, 0L);
                        }
                        break;
                    case 57:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzk(i5, 0);
                        }
                        break;
                    case 58:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzc(i5, true);
                        }
                        break;
                    case 59:
                        if (zza(t, i5, i3)) {
                            Object objZzp2 = zzxj.zzp(t, j);
                            iZzc = !(objZzp2 instanceof zzte) ? iZzc + zztv.zzc(i5, (String) objZzp2) : iZzc + zztv.zzc(i5, (zzte) objZzp2);
                        }
                        break;
                    case 60:
                        if (zza(t, i5, i3)) {
                            iZzc += zzwn.zzc(i5, zzxj.zzp(t, j), zzbq(i3));
                        }
                        break;
                    case 61:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzc(i5, (zzte) zzxj.zzp(t, j));
                        }
                        break;
                    case 62:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzi(i5, zzh(t, j));
                        }
                        break;
                    case 63:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzm(i5, zzh(t, j));
                        }
                        break;
                    case 64:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzl(i5, 0);
                        }
                        break;
                    case 65:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzh(i5, 0L);
                        }
                        break;
                    case 66:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzj(i5, zzh(t, j));
                        }
                        break;
                    case 67:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzf(i5, zzi(t, j));
                        }
                        break;
                    case 68:
                        if (zza(t, i5, i3)) {
                            iZzc += zztv.zzc(i5, (zzvv) zzxj.zzp(t, j), zzbq(i3));
                        }
                        break;
                }
                i2 = i3 + 3;
            }
        } else {
            int i7 = 0;
            Unsafe unsafe2 = zzcar;
            int i8 = -1;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                int iZzc2 = i7;
                if (i10 >= this.zzcas.length) {
                    int iZza = zza(this.zzcbg, t) + iZzc2;
                    return this.zzcax ? iZza + this.zzcbh.zzw(t).zzvx() : iZza;
                }
                int iZzbt2 = zzbt(i10);
                int i11 = this.zzcas[i10];
                int i12 = (267386880 & iZzbt2) >>> 20;
                int i13 = 0;
                if (i12 <= 17) {
                    i = this.zzcas[i10 + 2];
                    int i14 = 1048575 & i;
                    if (i14 != i8) {
                        i9 = unsafe2.getInt(t, i14);
                        i8 = i14;
                    }
                    i13 = 1 << (i >>> 20);
                } else {
                    i = (!this.zzcba || i12 < zzui.DOUBLE_LIST_PACKED.id() || i12 > zzui.SINT64_LIST_PACKED.id()) ? 0 : this.zzcas[i10 + 2] & 1048575;
                }
                long j2 = iZzbt2 & 1048575;
                switch (i12) {
                    case 0:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzb(i11, 0.0d);
                        }
                        break;
                    case 1:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzb(i11, 0.0f);
                        }
                        break;
                    case 2:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzd(i11, unsafe2.getLong(t, j2));
                        }
                        break;
                    case 3:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zze(i11, unsafe2.getLong(t, j2));
                        }
                        break;
                    case 4:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzh(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 5:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzg(i11, 0L);
                        }
                        break;
                    case 6:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzk(i11, 0);
                        }
                        break;
                    case 7:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzc(i11, true);
                        }
                        break;
                    case 8:
                        if ((i13 & i9) != 0) {
                            Object object = unsafe2.getObject(t, j2);
                            iZzc2 = !(object instanceof zzte) ? iZzc2 + zztv.zzc(i11, (String) object) : iZzc2 + zztv.zzc(i11, (zzte) object);
                        }
                        break;
                    case 9:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzwn.zzc(i11, unsafe2.getObject(t, j2), zzbq(i10));
                        }
                        break;
                    case 10:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzc(i11, (zzte) unsafe2.getObject(t, j2));
                        }
                        break;
                    case 11:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzi(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 12:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzm(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 13:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzl(i11, 0);
                        }
                        break;
                    case 14:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzh(i11, 0L);
                        }
                        break;
                    case 15:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzj(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 16:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzf(i11, unsafe2.getLong(t, j2));
                        }
                        break;
                    case 17:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zztv.zzc(i11, (zzvv) unsafe2.getObject(t, j2), zzbq(i10));
                        }
                        break;
                    case 18:
                        iZzc2 += zzwn.zzw(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 19:
                        iZzc2 += zzwn.zzv(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 20:
                        iZzc2 += zzwn.zzo(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 21:
                        iZzc2 += zzwn.zzp(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 22:
                        iZzc2 += zzwn.zzs(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 23:
                        iZzc2 += zzwn.zzw(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 24:
                        iZzc2 += zzwn.zzv(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 25:
                        iZzc2 += zzwn.zzx(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 26:
                        iZzc2 += zzwn.zzc(i11, (List) unsafe2.getObject(t, j2));
                        break;
                    case 27:
                        iZzc2 += zzwn.zzc(i11, (List<?>) unsafe2.getObject(t, j2), zzbq(i10));
                        break;
                    case 28:
                        iZzc2 += zzwn.zzd(i11, (List) unsafe2.getObject(t, j2));
                        break;
                    case 29:
                        iZzc2 += zzwn.zzt(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 30:
                        iZzc2 += zzwn.zzr(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 31:
                        iZzc2 += zzwn.zzv(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 32:
                        iZzc2 += zzwn.zzw(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 33:
                        iZzc2 += zzwn.zzu(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 34:
                        iZzc2 += zzwn.zzq(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 35:
                        int iZzag4 = zzwn.zzag((List) unsafe2.getObject(t, j2));
                        if (iZzag4 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzag4);
                            }
                            iZzc2 += iZzag4 + zztv.zzbd(i11) + zztv.zzbf(iZzag4);
                        }
                        break;
                    case 36:
                        int iZzaf4 = zzwn.zzaf((List) unsafe2.getObject(t, j2));
                        if (iZzaf4 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzaf4);
                            }
                            iZzc2 += iZzaf4 + zztv.zzbd(i11) + zztv.zzbf(iZzaf4);
                        }
                        break;
                    case 37:
                        int iZzy2 = zzwn.zzy((List) unsafe2.getObject(t, j2));
                        if (iZzy2 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzy2);
                            }
                            iZzc2 += iZzy2 + zztv.zzbd(i11) + zztv.zzbf(iZzy2);
                        }
                        break;
                    case 38:
                        int iZzz2 = zzwn.zzz((List) unsafe2.getObject(t, j2));
                        if (iZzz2 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzz2);
                            }
                            iZzc2 += iZzz2 + zztv.zzbd(i11) + zztv.zzbf(iZzz2);
                        }
                        break;
                    case 39:
                        int iZzac2 = zzwn.zzac((List) unsafe2.getObject(t, j2));
                        if (iZzac2 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzac2);
                            }
                            iZzc2 += iZzac2 + zztv.zzbd(i11) + zztv.zzbf(iZzac2);
                        }
                        break;
                    case 40:
                        int iZzag5 = zzwn.zzag((List) unsafe2.getObject(t, j2));
                        if (iZzag5 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzag5);
                            }
                            iZzc2 += iZzag5 + zztv.zzbd(i11) + zztv.zzbf(iZzag5);
                        }
                        break;
                    case 41:
                        int iZzaf5 = zzwn.zzaf((List) unsafe2.getObject(t, j2));
                        if (iZzaf5 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzaf5);
                            }
                            iZzc2 += iZzaf5 + zztv.zzbd(i11) + zztv.zzbf(iZzaf5);
                        }
                        break;
                    case 42:
                        int iZzah2 = zzwn.zzah((List) unsafe2.getObject(t, j2));
                        if (iZzah2 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzah2);
                            }
                            iZzc2 += iZzah2 + zztv.zzbd(i11) + zztv.zzbf(iZzah2);
                        }
                        break;
                    case 43:
                        int iZzad2 = zzwn.zzad((List) unsafe2.getObject(t, j2));
                        if (iZzad2 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzad2);
                            }
                            iZzc2 += iZzad2 + zztv.zzbd(i11) + zztv.zzbf(iZzad2);
                        }
                        break;
                    case 44:
                        int iZzab2 = zzwn.zzab((List) unsafe2.getObject(t, j2));
                        if (iZzab2 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzab2);
                            }
                            iZzc2 += iZzab2 + zztv.zzbd(i11) + zztv.zzbf(iZzab2);
                        }
                        break;
                    case 45:
                        int iZzaf6 = zzwn.zzaf((List) unsafe2.getObject(t, j2));
                        if (iZzaf6 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzaf6);
                            }
                            iZzc2 += iZzaf6 + zztv.zzbd(i11) + zztv.zzbf(iZzaf6);
                        }
                        break;
                    case 46:
                        int iZzag6 = zzwn.zzag((List) unsafe2.getObject(t, j2));
                        if (iZzag6 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzag6);
                            }
                            iZzc2 += iZzag6 + zztv.zzbd(i11) + zztv.zzbf(iZzag6);
                        }
                        break;
                    case 47:
                        int iZzae2 = zzwn.zzae((List) unsafe2.getObject(t, j2));
                        if (iZzae2 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzae2);
                            }
                            iZzc2 += iZzae2 + zztv.zzbd(i11) + zztv.zzbf(iZzae2);
                        }
                        break;
                    case 48:
                        int iZzaa2 = zzwn.zzaa((List) unsafe2.getObject(t, j2));
                        if (iZzaa2 > 0) {
                            if (this.zzcba) {
                                unsafe2.putInt(t, i, iZzaa2);
                            }
                            iZzc2 += iZzaa2 + zztv.zzbd(i11) + zztv.zzbf(iZzaa2);
                        }
                        break;
                    case 49:
                        iZzc2 += zzwn.zzd(i11, (List) unsafe2.getObject(t, j2), zzbq(i10));
                        break;
                    case 50:
                        iZzc2 += this.zzcbi.zzb(i11, unsafe2.getObject(t, j2), zzbr(i10));
                        break;
                    case 51:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzb(i11, 0.0d);
                        }
                        break;
                    case 52:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzb(i11, 0.0f);
                        }
                        break;
                    case 53:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzd(i11, zzi(t, j2));
                        }
                        break;
                    case 54:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zze(i11, zzi(t, j2));
                        }
                        break;
                    case 55:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzh(i11, zzh(t, j2));
                        }
                        break;
                    case 56:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzg(i11, 0L);
                        }
                        break;
                    case 57:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzk(i11, 0);
                        }
                        break;
                    case 58:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzc(i11, true);
                        }
                        break;
                    case 59:
                        if (zza(t, i11, i10)) {
                            Object object2 = unsafe2.getObject(t, j2);
                            iZzc2 = !(object2 instanceof zzte) ? iZzc2 + zztv.zzc(i11, (String) object2) : iZzc2 + zztv.zzc(i11, (zzte) object2);
                        }
                        break;
                    case 60:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzwn.zzc(i11, unsafe2.getObject(t, j2), zzbq(i10));
                        }
                        break;
                    case 61:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzc(i11, (zzte) unsafe2.getObject(t, j2));
                        }
                        break;
                    case 62:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzi(i11, zzh(t, j2));
                        }
                        break;
                    case 63:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzm(i11, zzh(t, j2));
                        }
                        break;
                    case 64:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzl(i11, 0);
                        }
                        break;
                    case 65:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzh(i11, 0L);
                        }
                        break;
                    case 66:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzj(i11, zzh(t, j2));
                        }
                        break;
                    case 67:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzf(i11, zzi(t, j2));
                        }
                        break;
                    case 68:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zztv.zzc(i11, (zzvv) unsafe2.getObject(t, j2), zzbq(i10));
                        }
                        break;
                }
                i7 = iZzc2;
                i10 += 3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00f0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.google.android.gms.internal.measurement.zzwl] */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r7v6, types: [com.google.android.gms.internal.measurement.zzwl] */
    @Override // com.google.android.gms.internal.measurement.zzwl
    public final boolean zzaj(T t) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzcbc) {
            int i6 = this.zzcbb[i5];
            int i7 = this.zzcas[i6];
            int iZzbt = zzbt(i6);
            if (this.zzcaz) {
                i = 0;
                i2 = i3;
            } else {
                int i8 = this.zzcas[i6 + 2];
                i2 = i8 & 1048575;
                i = 1 << (i8 >>> 20);
                if (i2 != i3) {
                    i4 = zzcar.getInt(t, i2);
                } else {
                    i2 = i3;
                }
            }
            if (((268435456 & iZzbt) != 0) && !zza(t, i6, i4, i)) {
                return false;
            }
            switch ((267386880 & iZzbt) >>> 20) {
                case 9:
                case 17:
                    if (zza(t, i6, i4, i) && !zza(t, iZzbt, zzbq(i6))) {
                        return false;
                    }
                    break;
                    break;
                case 27:
                case 49:
                    List list = (List) zzxj.zzp(t, iZzbt & 1048575);
                    if (list.isEmpty()) {
                        z2 = true;
                    } else {
                        ?? Zzbq = zzbq(i6);
                        int i9 = 0;
                        while (true) {
                            if (i9 >= list.size()) {
                                z2 = true;
                            } else if (Zzbq.zzaj(list.get(i9))) {
                                i9++;
                            } else {
                                z2 = false;
                            }
                        }
                    }
                    if (!z2) {
                        return false;
                    }
                    break;
                    break;
                case 50:
                    Map<?, ?> mapZzad = this.zzcbi.zzad(zzxj.zzp(t, iZzbt & 1048575));
                    if (mapZzad.isEmpty()) {
                        z = true;
                    } else {
                        if (this.zzcbi.zzah(zzbr(i6)).zzcam.zzyv() == zzxx.MESSAGE) {
                            ?? Zzi = 0;
                            Iterator<?> it = mapZzad.values().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object next = it.next();
                                    if (Zzi == 0) {
                                        Zzi = Zzi;
                                        Zzi = zzwh.zzxt().zzi(next.getClass());
                                    }
                                    Zzi = Zzi;
                                    if (!Zzi.zzaj(next)) {
                                        z = false;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        } else {
                            z = true;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                    break;
                    break;
                case 60:
                case 68:
                    if (zza(t, i7, i6) && !zza(t, iZzbt, zzbq(i6))) {
                        return false;
                    }
                    break;
                    break;
            }
            i5++;
            i3 = i2;
        }
        return !this.zzcax || this.zzcbh.zzw(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zzd(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.zzcas.length; i += 3) {
            int iZzbt = zzbt(i);
            long j = 1048575 & iZzbt;
            int i2 = this.zzcas[i];
            switch ((iZzbt & 267386880) >>> 20) {
                case 0:
                    if (zzb(t2, i)) {
                        zzxj.zza(t, j, zzxj.zzo(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 1:
                    if (zzb(t2, i)) {
                        zzxj.zza((Object) t, j, zzxj.zzn(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 2:
                    if (zzb(t2, i)) {
                        zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 3:
                    if (zzb(t2, i)) {
                        zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 4:
                    if (zzb(t2, i)) {
                        zzxj.zzb(t, j, zzxj.zzk(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 5:
                    if (zzb(t2, i)) {
                        zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 6:
                    if (zzb(t2, i)) {
                        zzxj.zzb(t, j, zzxj.zzk(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 7:
                    if (zzb(t2, i)) {
                        zzxj.zza(t, j, zzxj.zzm(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 8:
                    if (zzb(t2, i)) {
                        zzxj.zza(t, j, zzxj.zzp(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzb(t2, i)) {
                        zzxj.zza(t, j, zzxj.zzp(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 11:
                    if (zzb(t2, i)) {
                        zzxj.zzb(t, j, zzxj.zzk(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 12:
                    if (zzb(t2, i)) {
                        zzxj.zzb(t, j, zzxj.zzk(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 13:
                    if (zzb(t2, i)) {
                        zzxj.zzb(t, j, zzxj.zzk(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 14:
                    if (zzb(t2, i)) {
                        zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 15:
                    if (zzb(t2, i)) {
                        zzxj.zzb(t, j, zzxj.zzk(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 16:
                    if (zzb(t2, i)) {
                        zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                        zzc(t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzcbf.zza(t, t2, j);
                    break;
                case 50:
                    zzwn.zza(this.zzcbi, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza(t2, i2, i)) {
                        zzxj.zza(t, j, zzxj.zzp(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza(t2, i2, i)) {
                        zzxj.zza(t, j, zzxj.zzp(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        if (this.zzcaz) {
            return;
        }
        zzwn.zza(this.zzcbg, t, t2);
        if (this.zzcax) {
            zzwn.zza(this.zzcbh, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zzy(T t) {
        for (int i = this.zzcbc; i < this.zzcbd; i++) {
            long jZzbt = zzbt(this.zzcbb[i]) & 1048575;
            Object objZzp = zzxj.zzp(t, jZzbt);
            if (objZzp != null) {
                zzxj.zza(t, jZzbt, this.zzcbi.zzaf(objZzp));
            }
        }
        int length = this.zzcbb.length;
        for (int i2 = this.zzcbd; i2 < length; i2++) {
            this.zzcbf.zzb(t, this.zzcbb[i2]);
        }
        this.zzcbg.zzy(t);
        if (this.zzcax) {
            this.zzcbh.zzy(t);
        }
    }
}
