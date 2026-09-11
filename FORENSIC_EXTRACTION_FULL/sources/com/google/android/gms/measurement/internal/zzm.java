package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzya;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
final class zzm extends zzfm {
    zzm(zzfn zzfnVar) {
        super(zzfnVar);
    }

    private final Boolean zza(double d, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        try {
            return zza(new BigDecimal(d), zzflVar, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean zza(long j, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        try {
            return zza(new BigDecimal(j), zzflVar, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Boolean zza(com.google.android.gms.internal.measurement.zzfj zzfjVar, String str, com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr, long j) {
        Boolean boolZza;
        if (zzfjVar.zzavq != null) {
            Boolean boolZza2 = zza(j, zzfjVar.zzavq);
            if (boolZza2 == null) {
                return null;
            }
            if (!boolZza2.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (com.google.android.gms.internal.measurement.zzfk zzfkVar : zzfjVar.zzavo) {
            if (TextUtils.isEmpty(zzfkVar.zzavv)) {
                zzgt().zzjj().zzg("null or empty param name in filter. event", zzgq().zzbt(str));
                return null;
            }
            hashSet.add(zzfkVar.zzavv);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzfuVarArr) {
            if (hashSet.contains(zzfuVar.name)) {
                if (zzfuVar.zzaxg != null) {
                    arrayMap.put(zzfuVar.name, zzfuVar.zzaxg);
                } else if (zzfuVar.zzaup != null) {
                    arrayMap.put(zzfuVar.name, zzfuVar.zzaup);
                } else {
                    if (zzfuVar.zzamn == null) {
                        zzgt().zzjj().zze("Unknown value for param. event, param", zzgq().zzbt(str), zzgq().zzbu(zzfuVar.name));
                        return null;
                    }
                    arrayMap.put(zzfuVar.name, zzfuVar.zzamn);
                }
            }
        }
        for (com.google.android.gms.internal.measurement.zzfk zzfkVar2 : zzfjVar.zzavo) {
            boolean zEquals = Boolean.TRUE.equals(zzfkVar2.zzavu);
            String str2 = zzfkVar2.zzavv;
            if (TextUtils.isEmpty(str2)) {
                zzgt().zzjj().zzg("Event has empty param name. event", zzgq().zzbt(str));
                return null;
            }
            V v = arrayMap.get(str2);
            if (v instanceof Long) {
                if (zzfkVar2.zzavt == null) {
                    zzgt().zzjj().zze("No number filter for long param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                Boolean boolZza3 = zza(((Long) v).longValue(), zzfkVar2.zzavt);
                if (boolZza3 == null) {
                    return null;
                }
                if ((!boolZza3.booleanValue()) ^ zEquals) {
                    return false;
                }
            } else if (v instanceof Double) {
                if (zzfkVar2.zzavt == null) {
                    zzgt().zzjj().zze("No number filter for double param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                Boolean boolZza4 = zza(((Double) v).doubleValue(), zzfkVar2.zzavt);
                if (boolZza4 == null) {
                    return null;
                }
                if ((!boolZza4.booleanValue()) ^ zEquals) {
                    return false;
                }
            } else {
                if (!(v instanceof String)) {
                    if (v == 0) {
                        zzgt().zzjo().zze("Missing param for filter. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                        return false;
                    }
                    zzgt().zzjj().zze("Unknown param type. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                if (zzfkVar2.zzavs != null) {
                    boolZza = zza((String) v, zzfkVar2.zzavs);
                } else {
                    if (zzfkVar2.zzavt == null) {
                        zzgt().zzjj().zze("No filter for String param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                        return null;
                    }
                    if (!zzft.zzcs((String) v)) {
                        zzgt().zzjj().zze("Invalid param value for number filter. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                        return null;
                    }
                    boolZza = zza((String) v, zzfkVar2.zzavt);
                }
                if (boolZza == null) {
                    return null;
                }
                if ((!boolZza.booleanValue()) ^ zEquals) {
                    return false;
                }
            }
        }
        return true;
    }

    private final Boolean zza(com.google.android.gms.internal.measurement.zzfm zzfmVar, com.google.android.gms.internal.measurement.zzfz zzfzVar) {
        com.google.android.gms.internal.measurement.zzfk zzfkVar = zzfmVar.zzawd;
        if (zzfkVar == null) {
            zzgt().zzjj().zzg("Missing property filter. property", zzgq().zzbv(zzfzVar.name));
            return null;
        }
        boolean zEquals = Boolean.TRUE.equals(zzfkVar.zzavu);
        if (zzfzVar.zzaxg != null) {
            if (zzfkVar.zzavt != null) {
                return zza(zza(zzfzVar.zzaxg.longValue(), zzfkVar.zzavt), zEquals);
            }
            zzgt().zzjj().zzg("No number filter for long property. property", zzgq().zzbv(zzfzVar.name));
            return null;
        }
        if (zzfzVar.zzaup != null) {
            if (zzfkVar.zzavt != null) {
                return zza(zza(zzfzVar.zzaup.doubleValue(), zzfkVar.zzavt), zEquals);
            }
            zzgt().zzjj().zzg("No number filter for double property. property", zzgq().zzbv(zzfzVar.name));
            return null;
        }
        if (zzfzVar.zzamn == null) {
            zzgt().zzjj().zzg("User property has no value, property", zzgq().zzbv(zzfzVar.name));
            return null;
        }
        if (zzfkVar.zzavs != null) {
            return zza(zza(zzfzVar.zzamn, zzfkVar.zzavs), zEquals);
        }
        if (zzfkVar.zzavt == null) {
            zzgt().zzjj().zzg("No string or number filter defined. property", zzgq().zzbv(zzfzVar.name));
            return null;
        }
        if (zzft.zzcs(zzfzVar.zzamn)) {
            return zza(zza(zzfzVar.zzamn, zzfkVar.zzavt), zEquals);
        }
        zzgt().zzjj().zze("Invalid user property value for Numeric number filter. property, value", zzgq().zzbv(zzfzVar.name), zzfzVar.zzamn);
        return null;
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException e) {
                    zzgt().zzjj().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(String str, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        if (!zzft.zzcs(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzflVar, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @VisibleForTesting
    private final Boolean zza(String str, com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        List<String> arrayList;
        Preconditions.checkNotNull(zzfnVar);
        if (str == null || zzfnVar.zzawe == null || zzfnVar.zzawe.intValue() == 0) {
            return null;
        }
        if (zzfnVar.zzawe.intValue() == 6) {
            if (zzfnVar.zzawh == null || zzfnVar.zzawh.length == 0) {
                return null;
            }
        } else if (zzfnVar.zzawf == null) {
            return null;
        }
        int iIntValue = zzfnVar.zzawe.intValue();
        boolean z = zzfnVar.zzawg != null && zzfnVar.zzawg.booleanValue();
        String upperCase = (z || iIntValue == 1 || iIntValue == 6) ? zzfnVar.zzawf : zzfnVar.zzawf.toUpperCase(Locale.ENGLISH);
        if (zzfnVar.zzawh == null) {
            arrayList = null;
        } else {
            String[] strArr = zzfnVar.zzawh;
            if (z) {
                arrayList = Arrays.asList(strArr);
            } else {
                arrayList = new ArrayList<>();
                for (String str2 : strArr) {
                    arrayList.add(str2.toUpperCase(Locale.ENGLISH));
                }
            }
        }
        return zza(str, iIntValue, z, upperCase, arrayList, iIntValue == 1 ? upperCase : null);
    }

    @VisibleForTesting
    private static Boolean zza(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzfl zzflVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzflVar);
        if (zzflVar.zzavw == null || zzflVar.zzavw.intValue() == 0) {
            return null;
        }
        if (zzflVar.zzavw.intValue() == 4) {
            if (zzflVar.zzavz == null || zzflVar.zzawa == null) {
                return null;
            }
        } else if (zzflVar.zzavy == null) {
            return null;
        }
        int iIntValue = zzflVar.zzavw.intValue();
        if (zzflVar.zzavw.intValue() == 4) {
            if (!zzft.zzcs(zzflVar.zzavz) || !zzft.zzcs(zzflVar.zzawa)) {
                return null;
            }
            try {
                bigDecimal4 = new BigDecimal(zzflVar.zzavz);
                bigDecimal3 = new BigDecimal(zzflVar.zzawa);
                bigDecimal2 = null;
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            if (!zzft.zzcs(zzflVar.zzavy)) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzflVar.zzavy);
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException e2) {
                return null;
            }
        }
        if (iIntValue != 4) {
            if (bigDecimal2 != null) {
            }
            return null;
        }
        if (bigDecimal4 == null) {
            return null;
        }
        switch (iIntValue) {
            case 1:
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == -1);
            case 2:
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 1);
            case 3:
                if (d != 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            case 4:
                return Boolean.valueOf((bigDecimal.compareTo(bigDecimal4) == -1 || bigDecimal.compareTo(bigDecimal3) == 1) ? false : true);
            default:
                return null;
        }
    }

    private static void zza(Map<Integer, Long> map, int i, long j) {
        Long l = map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    private static void zzb(Map<Integer, List<Long>> map, int i, long j) {
        List<Long> arrayList = map.get(Integer.valueOf(i));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(Integer.valueOf(i), arrayList);
        }
        arrayList.add(Long.valueOf(j / 1000));
    }

    private static com.google.android.gms.internal.measurement.zzfs[] zzb(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        com.google.android.gms.internal.measurement.zzfs[] zzfsVarArr = new com.google.android.gms.internal.measurement.zzfs[map.size()];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return zzfsVarArr;
            }
            Integer next = it.next();
            com.google.android.gms.internal.measurement.zzfs zzfsVar = new com.google.android.gms.internal.measurement.zzfs();
            zzfsVar.zzawz = next;
            zzfsVar.zzaxa = map.get(next);
            zzfsVarArr[i2] = zzfsVar;
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0398  */
    /* JADX WARN: Code duplicated, block: B:115:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:117:0x040a  */
    /* JADX WARN: Code duplicated, block: B:119:0x043d  */
    /* JADX WARN: Code duplicated, block: B:123:0x046f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0480  */
    /* JADX WARN: Code duplicated, block: B:307:0x0a50  */
    /* JADX WARN: Code duplicated, block: B:308:0x0a5b  */
    /* JADX WARN: Code duplicated, block: B:309:0x0a5f  */
    /* JADX WARN: Code duplicated, block: B:311:0x0a6b  */
    /* JADX WARN: Code duplicated, block: B:341:0x03c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:342:0x0319 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0295  */
    /* JADX WARN: Code duplicated, block: B:92:0x02de  */
    /* JADX WARN: Code duplicated, block: B:94:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:99:0x0303  */
    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    final com.google.android.gms.internal.measurement.zzfr[] zza(String str, com.google.android.gms.internal.measurement.zzft[] zzftVarArr, com.google.android.gms.internal.measurement.zzfz[] zzfzVarArr) {
        com.google.android.gms.internal.measurement.zzfy[] zzfyVarArr;
        Map<Integer, List<com.google.android.gms.internal.measurement.zzfm>> map;
        Map map2;
        Map arrayMap;
        long j;
        com.google.android.gms.internal.measurement.zzft zzftVar;
        Long l;
        com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr;
        String str2;
        zzac zzacVarZzg;
        zzac zzacVar;
        Map<Integer, List<com.google.android.gms.internal.measurement.zzfj>> map3;
        Map<Integer, List<com.google.android.gms.internal.measurement.zzfj>> map4;
        Iterator<Integer> it;
        int iIntValue;
        com.google.android.gms.internal.measurement.zzfr zzfrVar;
        BitSet bitSet;
        BitSet bitSet2;
        Map map5;
        Map map6;
        Map map7;
        Map map8;
        Iterator<com.google.android.gms.internal.measurement.zzfj> it2;
        com.google.android.gms.internal.measurement.zzfj next;
        Map<Integer, List<com.google.android.gms.internal.measurement.zzfj>> mapZzl;
        int i;
        ArrayMap arrayMap2;
        Preconditions.checkNotEmpty(str);
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        ArrayMap arrayMap5 = new ArrayMap();
        ArrayMap arrayMap6 = new ArrayMap();
        ArrayMap arrayMap7 = new ArrayMap();
        boolean zZzbb = zzgv().zzbb(str);
        Map<Integer, com.google.android.gms.internal.measurement.zzfx> mapZzbp = zzjt().zzbp(str);
        if (mapZzbp != null) {
            Iterator<Integer> it3 = mapZzbp.keySet().iterator();
            while (it3.hasNext()) {
                int iIntValue2 = it3.next().intValue();
                com.google.android.gms.internal.measurement.zzfx zzfxVar = mapZzbp.get(Integer.valueOf(iIntValue2));
                BitSet bitSet3 = (BitSet) arrayMap4.get(Integer.valueOf(iIntValue2));
                BitSet bitSet4 = (BitSet) arrayMap5.get(Integer.valueOf(iIntValue2));
                if (zZzbb) {
                    ArrayMap arrayMap8 = new ArrayMap();
                    if (zzfxVar != null && zzfxVar.zzayr != null) {
                        for (com.google.android.gms.internal.measurement.zzfs zzfsVar : zzfxVar.zzayr) {
                            if (zzfsVar.zzawz != null) {
                                arrayMap8.put(zzfsVar.zzawz, zzfsVar.zzaxa);
                            }
                        }
                    }
                    arrayMap6.put(Integer.valueOf(iIntValue2), arrayMap8);
                    arrayMap2 = arrayMap8;
                } else {
                    arrayMap2 = null;
                }
                if (bitSet3 == null) {
                    bitSet3 = new BitSet();
                    arrayMap4.put(Integer.valueOf(iIntValue2), bitSet3);
                    bitSet4 = new BitSet();
                    arrayMap5.put(Integer.valueOf(iIntValue2), bitSet4);
                }
                for (int i2 = 0; i2 < (zzfxVar.zzayp.length << 6); i2++) {
                    boolean z = false;
                    if (zzft.zza(zzfxVar.zzayp, i2)) {
                        zzgt().zzjo().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue2), Integer.valueOf(i2));
                        bitSet4.set(i2);
                        if (zzft.zza(zzfxVar.zzayq, i2)) {
                            bitSet3.set(i2);
                            z = true;
                        }
                    }
                    if (arrayMap2 != null && !z) {
                        arrayMap2.remove(Integer.valueOf(i2));
                    }
                }
                com.google.android.gms.internal.measurement.zzfr zzfrVar2 = new com.google.android.gms.internal.measurement.zzfr();
                arrayMap3.put(Integer.valueOf(iIntValue2), zzfrVar2);
                zzfrVar2.zzawx = false;
                zzfrVar2.zzaww = zzfxVar;
                zzfrVar2.zzawv = new com.google.android.gms.internal.measurement.zzfx();
                zzfrVar2.zzawv.zzayq = zzft.zza(bitSet3);
                zzfrVar2.zzawv.zzayp = zzft.zza(bitSet4);
                if (zZzbb) {
                    zzfrVar2.zzawv.zzayr = zzb(arrayMap2);
                    arrayMap7.put(Integer.valueOf(iIntValue2), new ArrayMap());
                }
            }
        }
        if (zzftVarArr != null) {
            com.google.android.gms.internal.measurement.zzft zzftVar2 = null;
            long jLongValue = 0;
            Long l2 = null;
            ArrayMap arrayMap9 = new ArrayMap();
            int length = zzftVarArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                com.google.android.gms.internal.measurement.zzft zzftVar3 = zzftVarArr[i4];
                String str3 = zzftVar3.name;
                com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr2 = zzftVar3.zzaxc;
                if (zzgv().zzd(str, zzai.zzaki)) {
                    zzjr();
                    Long l3 = (Long) zzft.zzb(zzftVar3, "_eid");
                    boolean z2 = l3 != null;
                    if (z2 && str3.equals("_ep")) {
                        zzjr();
                        String str4 = (String) zzft.zzb(zzftVar3, "_en");
                        if (TextUtils.isEmpty(str4)) {
                            zzgt().zzjg().zzg("Extra parameter without an event name. eventId", l3);
                        } else {
                            if (zzftVar2 == null || l2 == null || l3.longValue() != l2.longValue()) {
                                Pair<com.google.android.gms.internal.measurement.zzft, Long> pairZza = zzjt().zza(str, l3);
                                if (pairZza == null || pairZza.first == null) {
                                    zzgt().zzjg().zze("Extra parameter without existing main event. eventName, eventId", str4, l3);
                                } else {
                                    com.google.android.gms.internal.measurement.zzft zzftVar4 = (com.google.android.gms.internal.measurement.zzft) pairZza.first;
                                    jLongValue = ((Long) pairZza.second).longValue();
                                    zzjr();
                                    zzftVar2 = zzftVar4;
                                    l2 = (Long) zzft.zzb(zzftVar4, "_eid");
                                }
                            }
                            long j2 = jLongValue - 1;
                            if (j2 <= 0) {
                                zzt zztVarZzjt = zzjt();
                                zztVarZzjt.zzaf();
                                zztVarZzjt.zzgt().zzjo().zzg("Clearing complex main event info. appId", str);
                                try {
                                    zztVarZzjt.getWritableDatabase().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                                } catch (SQLiteException e) {
                                    zztVarZzjt.zzgt().zzjg().zzg("Error clearing complex main event", e);
                                }
                            } else {
                                zzjt().zza(str, l3, j2, zzftVar2);
                            }
                            com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr3 = new com.google.android.gms.internal.measurement.zzfu[zzftVar2.zzaxc.length + zzfuVarArr2.length];
                            int i5 = 0;
                            com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr4 = zzftVar2.zzaxc;
                            int length2 = zzfuVarArr4.length;
                            int i6 = 0;
                            while (i6 < length2) {
                                com.google.android.gms.internal.measurement.zzfu zzfuVar = zzfuVarArr4[i6];
                                zzjr();
                                if (zzft.zza(zzftVar3, zzfuVar.name) == null) {
                                    i = i5 + 1;
                                    zzfuVarArr3[i5] = zzfuVar;
                                } else {
                                    i = i5;
                                }
                                i6++;
                                i5 = i;
                            }
                            if (i5 > 0) {
                                int length3 = zzfuVarArr2.length;
                                int i7 = 0;
                                while (i7 < length3) {
                                    zzfuVarArr3[i5] = zzfuVarArr2[i7];
                                    i7++;
                                    i5++;
                                }
                                if (i5 != zzfuVarArr3.length) {
                                    zzfuVarArr3 = (com.google.android.gms.internal.measurement.zzfu[]) Arrays.copyOf(zzfuVarArr3, i5);
                                }
                                j = j2;
                                zzftVar = zzftVar2;
                                l = l2;
                                zzfuVarArr = zzfuVarArr3;
                                str2 = str4;
                            } else {
                                zzgt().zzjj().zzg("No unique parameters in main event. eventName", str4);
                                j = j2;
                                zzftVar = zzftVar2;
                                l = l2;
                                zzfuVarArr = zzfuVarArr2;
                                str2 = str4;
                            }
                        }
                    } else if (z2) {
                        zzjr();
                        Object objZzb = zzft.zzb(zzftVar3, "_epc");
                        long jLongValue2 = ((Long) (objZzb != null ? objZzb : 0L)).longValue();
                        if (jLongValue2 <= 0) {
                            zzgt().zzjj().zzg("Complex event with zero extra param count. eventName", str3);
                            j = jLongValue2;
                            zzftVar = zzftVar3;
                            l = l3;
                            zzfuVarArr = zzfuVarArr2;
                            str2 = str3;
                        } else {
                            zzjt().zza(str, l3, jLongValue2, zzftVar3);
                            j = jLongValue2;
                            zzftVar = zzftVar3;
                            l = l3;
                            zzfuVarArr = zzfuVarArr2;
                            str2 = str3;
                        }
                    } else {
                        j = jLongValue;
                        zzftVar = zzftVar2;
                        l = l2;
                        zzfuVarArr = zzfuVarArr2;
                        str2 = str3;
                    }
                    zzacVarZzg = zzjt().zzg(str, zzftVar3.name);
                    if (zzacVarZzg == null) {
                        zzgt().zzjj().zze("Event aggregate wasn't created during raw event logging. appId, event", zzas.zzbw(str), zzgq().zzbt(str2));
                        zzacVar = new zzac(str, zzftVar3.name, 1L, 1L, zzftVar3.zzaxd.longValue(), 0L, null, null, null, null);
                    } else {
                        zzacVar = new zzac(zzacVarZzg.zztt, zzacVarZzg.name, 1 + zzacVarZzg.zzahv, 1 + zzacVarZzg.zzahw, zzacVarZzg.zzahx, zzacVarZzg.zzahy, zzacVarZzg.zzahz, zzacVarZzg.zzaia, zzacVarZzg.zzaib, zzacVarZzg.zzaic);
                    }
                    zzjt().zza(zzacVar);
                    long j3 = zzacVar.zzahv;
                    map3 = (Map) arrayMap9.get(str2);
                    if (map3 == null) {
                        mapZzl = zzjt().zzl(str, str2);
                        if (mapZzl == null) {
                            mapZzl = new ArrayMap<>();
                        }
                        arrayMap9.put(str2, mapZzl);
                        map4 = mapZzl;
                    } else {
                        map4 = map3;
                    }
                    it = map4.keySet().iterator();
                    while (it.hasNext()) {
                        iIntValue = it.next().intValue();
                        if (hashSet.contains(Integer.valueOf(iIntValue))) {
                            zzgt().zzjo().zzg("Skipping failed audience ID", Integer.valueOf(iIntValue));
                        } else {
                            zzfrVar = (com.google.android.gms.internal.measurement.zzfr) arrayMap3.get(Integer.valueOf(iIntValue));
                            bitSet = (BitSet) arrayMap4.get(Integer.valueOf(iIntValue));
                            bitSet2 = (BitSet) arrayMap5.get(Integer.valueOf(iIntValue));
                            map5 = null;
                            map6 = null;
                            if (zZzbb) {
                                map5 = (Map) arrayMap6.get(Integer.valueOf(iIntValue));
                                map6 = (Map) arrayMap7.get(Integer.valueOf(iIntValue));
                            }
                            if (zzfrVar == null) {
                                com.google.android.gms.internal.measurement.zzfr zzfrVar3 = new com.google.android.gms.internal.measurement.zzfr();
                                arrayMap3.put(Integer.valueOf(iIntValue), zzfrVar3);
                                zzfrVar3.zzawx = true;
                                bitSet = new BitSet();
                                arrayMap4.put(Integer.valueOf(iIntValue), bitSet);
                                bitSet2 = new BitSet();
                                arrayMap5.put(Integer.valueOf(iIntValue), bitSet2);
                                if (zZzbb) {
                                    ArrayMap arrayMap10 = new ArrayMap();
                                    arrayMap6.put(Integer.valueOf(iIntValue), arrayMap10);
                                    ArrayMap arrayMap11 = new ArrayMap();
                                    arrayMap7.put(Integer.valueOf(iIntValue), arrayMap11);
                                    map7 = arrayMap11;
                                    map8 = arrayMap10;
                                } else {
                                    map7 = map6;
                                    map8 = map5;
                                }
                            } else {
                                map7 = map6;
                                map8 = map5;
                            }
                            it2 = map4.get(Integer.valueOf(iIntValue)).iterator();
                            while (it2.hasNext()) {
                                next = it2.next();
                                if (zzgt().isLoggable(2)) {
                                    zzgt().zzjo().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(iIntValue), next.zzavm, zzgq().zzbt(next.zzavn));
                                    zzgt().zzjo().zzg("Filter definition", zzjr().zza(next));
                                }
                                if (next.zzavm != null || next.zzavm.intValue() > 256) {
                                    zzgt().zzjj().zze("Invalid event filter ID. appId, id", zzas.zzbw(str), String.valueOf(next.zzavm));
                                } else if (zZzbb) {
                                    boolean z3 = (next == null || next.zzavj == null || !next.zzavj.booleanValue()) ? false : true;
                                    boolean z4 = (next == null || next.zzavk == null || !next.zzavk.booleanValue()) ? false : true;
                                    if (!bitSet.get(next.zzavm.intValue()) || z3 || z4) {
                                        Boolean boolZza = zza(next, str2, zzfuVarArr, j3);
                                        zzgt().zzjo().zzg("Event filter result", boolZza == null ? "null" : boolZza);
                                        if (boolZza == null) {
                                            hashSet.add(Integer.valueOf(iIntValue));
                                        } else {
                                            bitSet2.set(next.zzavm.intValue());
                                            if (boolZza.booleanValue()) {
                                                bitSet.set(next.zzavm.intValue());
                                                if (z3 || z4) {
                                                    if (zzftVar3.zzaxd != null) {
                                                        if (z4) {
                                                            zzb(map7, next.zzavm.intValue(), zzftVar3.zzaxd.longValue());
                                                        } else {
                                                            zza((Map<Integer, Long>) map8, next.zzavm.intValue(), zzftVar3.zzaxd.longValue());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        zzgt().zzjo().zze("Event filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID", Integer.valueOf(iIntValue), next.zzavm);
                                    }
                                } else if (bitSet.get(next.zzavm.intValue())) {
                                    zzgt().zzjo().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(iIntValue), next.zzavm);
                                } else {
                                    Boolean boolZza2 = zza(next, str2, zzfuVarArr, j3);
                                    zzgt().zzjo().zzg("Event filter result", boolZza2 == null ? "null" : boolZza2);
                                    if (boolZza2 == null) {
                                        hashSet.add(Integer.valueOf(iIntValue));
                                    } else {
                                        bitSet2.set(next.zzavm.intValue());
                                        if (boolZza2.booleanValue()) {
                                            bitSet.set(next.zzavm.intValue());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    jLongValue = j;
                    zzftVar2 = zzftVar;
                    l2 = l;
                } else {
                    j = jLongValue;
                    zzftVar = zzftVar2;
                    l = l2;
                    zzfuVarArr = zzfuVarArr2;
                    str2 = str3;
                    zzacVarZzg = zzjt().zzg(str, zzftVar3.name);
                    if (zzacVarZzg == null) {
                        zzgt().zzjj().zze("Event aggregate wasn't created during raw event logging. appId, event", zzas.zzbw(str), zzgq().zzbt(str2));
                        zzacVar = new zzac(str, zzftVar3.name, 1L, 1L, zzftVar3.zzaxd.longValue(), 0L, null, null, null, null);
                    } else {
                        zzacVar = new zzac(zzacVarZzg.zztt, zzacVarZzg.name, 1 + zzacVarZzg.zzahv, 1 + zzacVarZzg.zzahw, zzacVarZzg.zzahx, zzacVarZzg.zzahy, zzacVarZzg.zzahz, zzacVarZzg.zzaia, zzacVarZzg.zzaib, zzacVarZzg.zzaic);
                    }
                    zzjt().zza(zzacVar);
                    long j4 = zzacVar.zzahv;
                    map3 = (Map) arrayMap9.get(str2);
                    if (map3 == null) {
                        mapZzl = zzjt().zzl(str, str2);
                        if (mapZzl == null) {
                            mapZzl = new ArrayMap<>();
                        }
                        arrayMap9.put(str2, mapZzl);
                        map4 = mapZzl;
                    } else {
                        map4 = map3;
                    }
                    it = map4.keySet().iterator();
                    while (it.hasNext()) {
                        iIntValue = it.next().intValue();
                        if (hashSet.contains(Integer.valueOf(iIntValue))) {
                            zzgt().zzjo().zzg("Skipping failed audience ID", Integer.valueOf(iIntValue));
                        } else {
                            zzfrVar = (com.google.android.gms.internal.measurement.zzfr) arrayMap3.get(Integer.valueOf(iIntValue));
                            bitSet = (BitSet) arrayMap4.get(Integer.valueOf(iIntValue));
                            bitSet2 = (BitSet) arrayMap5.get(Integer.valueOf(iIntValue));
                            map5 = null;
                            map6 = null;
                            if (zZzbb) {
                                map5 = (Map) arrayMap6.get(Integer.valueOf(iIntValue));
                                map6 = (Map) arrayMap7.get(Integer.valueOf(iIntValue));
                            }
                            if (zzfrVar == null) {
                                com.google.android.gms.internal.measurement.zzfr zzfrVar4 = new com.google.android.gms.internal.measurement.zzfr();
                                arrayMap3.put(Integer.valueOf(iIntValue), zzfrVar4);
                                zzfrVar4.zzawx = true;
                                bitSet = new BitSet();
                                arrayMap4.put(Integer.valueOf(iIntValue), bitSet);
                                bitSet2 = new BitSet();
                                arrayMap5.put(Integer.valueOf(iIntValue), bitSet2);
                                if (zZzbb) {
                                    ArrayMap arrayMap12 = new ArrayMap();
                                    arrayMap6.put(Integer.valueOf(iIntValue), arrayMap12);
                                    ArrayMap arrayMap13 = new ArrayMap();
                                    arrayMap7.put(Integer.valueOf(iIntValue), arrayMap13);
                                    map7 = arrayMap13;
                                    map8 = arrayMap12;
                                } else {
                                    map7 = map6;
                                    map8 = map5;
                                }
                            } else {
                                map7 = map6;
                                map8 = map5;
                            }
                            it2 = map4.get(Integer.valueOf(iIntValue)).iterator();
                            while (it2.hasNext()) {
                                next = it2.next();
                                if (zzgt().isLoggable(2)) {
                                    zzgt().zzjo().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(iIntValue), next.zzavm, zzgq().zzbt(next.zzavn));
                                    zzgt().zzjo().zzg("Filter definition", zzjr().zza(next));
                                }
                                if (next.zzavm != null) {
                                }
                                zzgt().zzjj().zze("Invalid event filter ID. appId, id", zzas.zzbw(str), String.valueOf(next.zzavm));
                            }
                        }
                    }
                    jLongValue = j;
                    zzftVar2 = zzftVar;
                    l2 = l;
                }
                i3 = i4 + 1;
            }
        }
        if (zzfzVarArr != null) {
            ArrayMap arrayMap14 = new ArrayMap();
            for (com.google.android.gms.internal.measurement.zzfz zzfzVar : zzfzVarArr) {
                Map<Integer, List<com.google.android.gms.internal.measurement.zzfm>> map9 = (Map) arrayMap14.get(zzfzVar.name);
                if (map9 == null) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.zzfm>> mapZzm = zzjt().zzm(str, zzfzVar.name);
                    if (mapZzm == null) {
                        mapZzm = new ArrayMap<>();
                    }
                    arrayMap14.put(zzfzVar.name, mapZzm);
                    map = mapZzm;
                } else {
                    map = map9;
                }
                Iterator<Integer> it4 = map.keySet().iterator();
                while (it4.hasNext()) {
                    int iIntValue3 = it4.next().intValue();
                    if (hashSet.contains(Integer.valueOf(iIntValue3))) {
                        zzgt().zzjo().zzg("Skipping failed audience ID", Integer.valueOf(iIntValue3));
                    } else {
                        com.google.android.gms.internal.measurement.zzfr zzfrVar5 = (com.google.android.gms.internal.measurement.zzfr) arrayMap3.get(Integer.valueOf(iIntValue3));
                        BitSet bitSet5 = (BitSet) arrayMap4.get(Integer.valueOf(iIntValue3));
                        BitSet bitSet6 = (BitSet) arrayMap5.get(Integer.valueOf(iIntValue3));
                        Map map10 = null;
                        Map map11 = null;
                        if (zZzbb) {
                            map10 = (Map) arrayMap6.get(Integer.valueOf(iIntValue3));
                            map11 = (Map) arrayMap7.get(Integer.valueOf(iIntValue3));
                        }
                        if (zzfrVar5 == null) {
                            com.google.android.gms.internal.measurement.zzfr zzfrVar6 = new com.google.android.gms.internal.measurement.zzfr();
                            arrayMap3.put(Integer.valueOf(iIntValue3), zzfrVar6);
                            zzfrVar6.zzawx = true;
                            bitSet5 = new BitSet();
                            arrayMap4.put(Integer.valueOf(iIntValue3), bitSet5);
                            bitSet6 = new BitSet();
                            arrayMap5.put(Integer.valueOf(iIntValue3), bitSet6);
                            if (zZzbb) {
                                ArrayMap arrayMap15 = new ArrayMap();
                                arrayMap6.put(Integer.valueOf(iIntValue3), arrayMap15);
                                arrayMap = new ArrayMap();
                                arrayMap7.put(Integer.valueOf(iIntValue3), arrayMap);
                                map2 = arrayMap15;
                            } else {
                                map2 = map10;
                                arrayMap = map11;
                            }
                        } else {
                            map2 = map10;
                            arrayMap = map11;
                        }
                        Iterator<com.google.android.gms.internal.measurement.zzfm> it5 = map.get(Integer.valueOf(iIntValue3)).iterator();
                        while (it5.hasNext()) {
                            com.google.android.gms.internal.measurement.zzfm next2 = it5.next();
                            if (zzgt().isLoggable(2)) {
                                zzgt().zzjo().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue3), next2.zzavm, zzgq().zzbv(next2.zzawc));
                                zzgt().zzjo().zzg("Filter definition", zzjr().zza(next2));
                            }
                            if (next2.zzavm == null || next2.zzavm.intValue() > 256) {
                                zzgt().zzjj().zze("Invalid property filter ID. appId, id", zzas.zzbw(str), String.valueOf(next2.zzavm));
                                hashSet.add(Integer.valueOf(iIntValue3));
                                break;
                            }
                            if (zZzbb) {
                                boolean z5 = (next2 == null || next2.zzavj == null || !next2.zzavj.booleanValue()) ? false : true;
                                boolean z6 = (next2 == null || next2.zzavk == null || !next2.zzavk.booleanValue()) ? false : true;
                                if (!bitSet5.get(next2.zzavm.intValue()) || z5 || z6) {
                                    Boolean boolZza3 = zza(next2, zzfzVar);
                                    zzgt().zzjo().zzg("Property filter result", boolZza3 == null ? "null" : boolZza3);
                                    if (boolZza3 == null) {
                                        hashSet.add(Integer.valueOf(iIntValue3));
                                    } else {
                                        bitSet6.set(next2.zzavm.intValue());
                                        bitSet5.set(next2.zzavm.intValue(), boolZza3.booleanValue());
                                        if (boolZza3.booleanValue() && (z5 || z6)) {
                                            if (zzfzVar.zzayw != null) {
                                                if (z6) {
                                                    zzb(arrayMap, next2.zzavm.intValue(), zzfzVar.zzayw.longValue());
                                                } else {
                                                    zza((Map<Integer, Long>) map2, next2.zzavm.intValue(), zzfzVar.zzayw.longValue());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    zzgt().zzjo().zze("Property filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID", Integer.valueOf(iIntValue3), next2.zzavm);
                                }
                            } else if (bitSet5.get(next2.zzavm.intValue())) {
                                zzgt().zzjo().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(iIntValue3), next2.zzavm);
                            } else {
                                Boolean boolZza4 = zza(next2, zzfzVar);
                                zzgt().zzjo().zzg("Property filter result", boolZza4 == null ? "null" : boolZza4);
                                if (boolZza4 == null) {
                                    hashSet.add(Integer.valueOf(iIntValue3));
                                } else {
                                    bitSet6.set(next2.zzavm.intValue());
                                    if (boolZza4.booleanValue()) {
                                        bitSet5.set(next2.zzavm.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.android.gms.internal.measurement.zzfr[] zzfrVarArr = new com.google.android.gms.internal.measurement.zzfr[arrayMap4.size()];
        Iterator it6 = arrayMap4.keySet().iterator();
        int i8 = 0;
        while (it6.hasNext()) {
            int iIntValue4 = ((Integer) it6.next()).intValue();
            if (!hashSet.contains(Integer.valueOf(iIntValue4))) {
                com.google.android.gms.internal.measurement.zzfr zzfrVar7 = (com.google.android.gms.internal.measurement.zzfr) arrayMap3.get(Integer.valueOf(iIntValue4));
                com.google.android.gms.internal.measurement.zzfr zzfrVar8 = zzfrVar7 == null ? new com.google.android.gms.internal.measurement.zzfr() : zzfrVar7;
                int i9 = i8 + 1;
                zzfrVarArr[i8] = zzfrVar8;
                zzfrVar8.zzavg = Integer.valueOf(iIntValue4);
                zzfrVar8.zzawv = new com.google.android.gms.internal.measurement.zzfx();
                zzfrVar8.zzawv.zzayq = zzft.zza((BitSet) arrayMap4.get(Integer.valueOf(iIntValue4)));
                zzfrVar8.zzawv.zzayp = zzft.zza((BitSet) arrayMap5.get(Integer.valueOf(iIntValue4)));
                if (zZzbb) {
                    zzfrVar8.zzawv.zzayr = zzb((Map) arrayMap6.get(Integer.valueOf(iIntValue4)));
                    com.google.android.gms.internal.measurement.zzfx zzfxVar2 = zzfrVar8.zzawv;
                    Map map12 = (Map) arrayMap7.get(Integer.valueOf(iIntValue4));
                    if (map12 == null) {
                        zzfyVarArr = new com.google.android.gms.internal.measurement.zzfy[0];
                    } else {
                        com.google.android.gms.internal.measurement.zzfy[] zzfyVarArr2 = new com.google.android.gms.internal.measurement.zzfy[map12.size()];
                        Iterator it7 = map12.keySet().iterator();
                        int i10 = 0;
                        while (true) {
                            int i11 = i10;
                            if (!it7.hasNext()) {
                                break;
                            }
                            Integer num = (Integer) it7.next();
                            com.google.android.gms.internal.measurement.zzfy zzfyVar = new com.google.android.gms.internal.measurement.zzfy();
                            zzfyVar.zzawz = num;
                            List list = (List) map12.get(num);
                            if (list != null) {
                                Collections.sort(list);
                                long[] jArr = new long[list.size()];
                                int i12 = 0;
                                Iterator it8 = list.iterator();
                                while (it8.hasNext()) {
                                    jArr[i12] = ((Long) it8.next()).longValue();
                                    i12++;
                                }
                                zzfyVar.zzayu = jArr;
                            }
                            zzfyVarArr2[i11] = zzfyVar;
                            i10 = i11 + 1;
                        }
                        zzfyVarArr = zzfyVarArr2;
                    }
                    zzfxVar2.zzays = zzfyVarArr;
                }
                zzt zztVarZzjt2 = zzjt();
                com.google.android.gms.internal.measurement.zzfx zzfxVar3 = zzfrVar8.zzawv;
                zztVarZzjt2.zzcl();
                zztVarZzjt2.zzaf();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfxVar3);
                try {
                    byte[] bArr = new byte[zzfxVar3.zzvx()];
                    zzya zzyaVarZzk = zzya.zzk(bArr, 0, bArr.length);
                    zzfxVar3.zza(zzyaVarZzk);
                    zzyaVarZzk.zzza();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("audience_id", Integer.valueOf(iIntValue4));
                    contentValues.put("current_results", bArr);
                    try {
                        if (zztVarZzjt2.getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                            zztVarZzjt2.zzgt().zzjg().zzg("Failed to insert filter results (got -1). appId", zzas.zzbw(str));
                        }
                        i8 = i9;
                    } catch (SQLiteException e2) {
                        zztVarZzjt2.zzgt().zzjg().zze("Error storing filter results. appId", zzas.zzbw(str), e2);
                        i8 = i9;
                    }
                } catch (IOException e3) {
                    zztVarZzjt2.zzgt().zzjg().zze("Configuration loss. Failed to serialize filter results. appId", zzas.zzbw(str), e3);
                    i8 = i9;
                }
            }
        }
        return (com.google.android.gms.internal.measurement.zzfr[]) Arrays.copyOf(zzfrVarArr, i8);
    }

    @Override // com.google.android.gms.measurement.internal.zzfm
    protected final boolean zzgy() {
        return false;
    }
}
