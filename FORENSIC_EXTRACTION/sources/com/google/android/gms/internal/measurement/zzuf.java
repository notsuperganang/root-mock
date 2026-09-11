package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzuf<FieldDescriptorType extends zzuh<FieldDescriptorType>> {
    private static final zzuf zzbvl = new zzuf(true);
    private boolean zzbqa;
    private boolean zzbvk = false;
    private final zzwo<FieldDescriptorType, Object> zzbvj = zzwo.zzbw(16);

    private zzuf() {
    }

    private zzuf(boolean z) {
        zzsw();
    }

    static int zza(zzxs zzxsVar, int i, Object obj) {
        int i2;
        int iZzbd = zztv.zzbd(i);
        if (zzxsVar == zzxs.zzcds) {
            zzuq.zzf((zzvv) obj);
            i2 = iZzbd << 1;
        } else {
            i2 = iZzbd;
        }
        return i2 + zzb(zzxsVar, obj);
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzbvj.get(fielddescriptortype);
        return obj instanceof zzuy ? zzuy.zzwz() : obj;
    }

    static void zza(zztv zztvVar, zzxs zzxsVar, int i, Object obj) throws IOException {
        if (zzxsVar == zzxs.zzcds) {
            zzuq.zzf((zzvv) obj);
            zztvVar.zzc(i, 3);
            ((zzvv) obj).zzb(zztvVar);
            zztvVar.zzc(i, 4);
        }
        zztvVar.zzc(i, zzxsVar.zzyw());
        switch (zzug.zzbun[zzxsVar.ordinal()]) {
            case 1:
                zztvVar.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zztvVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zztvVar.zzat(((Long) obj).longValue());
                break;
            case 4:
                zztvVar.zzat(((Long) obj).longValue());
                break;
            case 5:
                zztvVar.zzaz(((Integer) obj).intValue());
                break;
            case 6:
                zztvVar.zzav(((Long) obj).longValue());
                break;
            case 7:
                zztvVar.zzbc(((Integer) obj).intValue());
                break;
            case 8:
                zztvVar.zzs(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzvv) obj).zzb(zztvVar);
                break;
            case 10:
                zztvVar.zzb((zzvv) obj);
                break;
            case 11:
                if (!(obj instanceof zzte)) {
                    zztvVar.zzgb((String) obj);
                } else {
                    zztvVar.zza((zzte) obj);
                }
                break;
            case 12:
                if (!(obj instanceof zzte)) {
                    byte[] bArr = (byte[]) obj;
                    zztvVar.zze(bArr, 0, bArr.length);
                } else {
                    zztvVar.zza((zzte) obj);
                }
                break;
            case 13:
                zztvVar.zzba(((Integer) obj).intValue());
                break;
            case 14:
                zztvVar.zzbc(((Integer) obj).intValue());
                break;
            case 15:
                zztvVar.zzav(((Long) obj).longValue());
                break;
            case 16:
                zztvVar.zzbb(((Integer) obj).intValue());
                break;
            case 17:
                zztvVar.zzau(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof zzur)) {
                    zztvVar.zzaz(((Integer) obj).intValue());
                } else {
                    zztvVar.zzaz(((zzur) obj).zzc());
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        ?? arrayList;
        if (!fielddescriptortype.zzwb()) {
            zza(fielddescriptortype.zzvz(), obj);
            arrayList = obj;
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzvz(), obj2);
            }
        }
        if (arrayList instanceof zzuy) {
            this.zzbvk = true;
        }
        this.zzbvj.put(fielddescriptortype, arrayList);
    }

    private static void zza(zzxs zzxsVar, Object obj) {
        boolean z = false;
        zzuq.checkNotNull(obj);
        switch (zzug.zzbvm[zzxsVar.zzyv().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzte) || (obj instanceof byte[])) {
                    z = true;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzur)) {
                    z = true;
                }
                break;
            case 9:
                if ((obj instanceof zzvv) || (obj instanceof zzuy)) {
                    z = true;
                }
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static int zzb(zzuh<?> zzuhVar, Object obj) {
        int iZza = 0;
        zzxs zzxsVarZzvz = zzuhVar.zzvz();
        int iZzc = zzuhVar.zzc();
        if (!zzuhVar.zzwb()) {
            return zza(zzxsVarZzvz, iZzc, obj);
        }
        if (!zzuhVar.zzwc()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iZza += zza(zzxsVarZzvz, iZzc, it.next());
            }
            return iZza;
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iZza += zzb(zzxsVarZzvz, it2.next());
        }
        int iZzbd = zztv.zzbd(iZzc);
        return iZza + iZzbd + zztv.zzbl(iZza);
    }

    private static int zzb(zzxs zzxsVar, Object obj) {
        switch (zzug.zzbun[zzxsVar.ordinal()]) {
            case 1:
                return zztv.zzc(((Double) obj).doubleValue());
            case 2:
                return zztv.zzb(((Float) obj).floatValue());
            case 3:
                return zztv.zzaw(((Long) obj).longValue());
            case 4:
                return zztv.zzax(((Long) obj).longValue());
            case 5:
                return zztv.zzbe(((Integer) obj).intValue());
            case 6:
                return zztv.zzaz(((Long) obj).longValue());
            case 7:
                return zztv.zzbh(((Integer) obj).intValue());
            case 8:
                return zztv.zzt(((Boolean) obj).booleanValue());
            case 9:
                return zztv.zzd((zzvv) obj);
            case 10:
                return obj instanceof zzuy ? zztv.zza((zzuy) obj) : zztv.zzc((zzvv) obj);
            case 11:
                return obj instanceof zzte ? zztv.zzb((zzte) obj) : zztv.zzgc((String) obj);
            case 12:
                return obj instanceof zzte ? zztv.zzb((zzte) obj) : zztv.zzk((byte[]) obj);
            case 13:
                return zztv.zzbf(((Integer) obj).intValue());
            case 14:
                return zztv.zzbi(((Integer) obj).intValue());
            case 15:
                return zztv.zzba(((Long) obj).longValue());
            case 16:
                return zztv.zzbg(((Integer) obj).intValue());
            case 17:
                return zztv.zzay(((Long) obj).longValue());
            case 18:
                return obj instanceof zzur ? zztv.zzbj(((zzur) obj).zzc()) : zztv.zzbj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzwa() == zzxx.MESSAGE) {
            if (key.zzwb()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzvv) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzvv)) {
                    if (value instanceof zzuy) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzvv) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzuy) {
            value = zzuy.zzwz();
        }
        if (key.zzwb()) {
            Object objZza = zza(key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zzz(it.next()));
            }
            this.zzbvj.put(key, objZza);
            return;
        }
        if (key.zzwa() != zzxx.MESSAGE) {
            this.zzbvj.put(key, zzz(value));
            return;
        }
        Object objZza2 = zza(key);
        if (objZza2 == null) {
            this.zzbvj.put(key, zzz(value));
        } else {
            this.zzbvj.put(key, objZza2 instanceof zzwb ? key.zza((zzwb) objZza2, (zzwb) value) : key.zza(((zzvv) objZza2).zzwh(), (zzvv) value).zzwo());
        }
    }

    private static int zze(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzwa() != zzxx.MESSAGE || key.zzwb() || key.zzwc()) {
            return zzb((zzuh<?>) key, value);
        }
        return value instanceof zzuy ? zztv.zzb(entry.getKey().zzc(), (zzuy) value) : zztv.zzd(entry.getKey().zzc(), (zzvv) value);
    }

    public static <T extends zzuh<T>> zzuf<T> zzvw() {
        return zzbvl;
    }

    private static Object zzz(Object obj) {
        if (obj instanceof zzwb) {
            return ((zzwb) obj).zzxp();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzuf zzufVar = new zzuf();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzbvj.zzyc()) {
                break;
            }
            Map.Entry<K, Object> entryZzbx = this.zzbvj.zzbx(i2);
            zzufVar.zza((zzuh) entryZzbx.getKey(), entryZzbx.getValue());
            i = i2 + 1;
        }
        Iterator it = this.zzbvj.zzyd().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzufVar.zza((zzuh) entry.getKey(), entry.getValue());
        }
        zzufVar.zzbvk = this.zzbvk;
        return zzufVar;
    }

    final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        return this.zzbvk ? new zzvb(this.zzbvj.zzye().iterator()) : this.zzbvj.zzye().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzuf) {
            return this.zzbvj.equals(((zzuf) obj).zzbvj);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzbvj.hashCode();
    }

    final boolean isEmpty() {
        return this.zzbvj.isEmpty();
    }

    public final boolean isImmutable() {
        return this.zzbqa;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzbvj.zzyc(); i++) {
            if (!zzc(this.zzbvj.zzbx(i))) {
                return false;
            }
        }
        Iterator it = this.zzbvj.zzyd().iterator();
        while (it.hasNext()) {
            if (!zzc((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzbvk ? new zzvb(this.zzbvj.entrySet().iterator()) : this.zzbvj.entrySet().iterator();
    }

    public final void zza(zzuf<FieldDescriptorType> zzufVar) {
        for (int i = 0; i < zzufVar.zzbvj.zzyc(); i++) {
            zzd(zzufVar.zzbvj.zzbx(i));
        }
        Iterator it = zzufVar.zzbvj.zzyd().iterator();
        while (it.hasNext()) {
            zzd((Map.Entry) it.next());
        }
    }

    public final void zzsw() {
        if (this.zzbqa) {
            return;
        }
        this.zzbvj.zzsw();
        this.zzbqa = true;
    }

    public final int zzvx() {
        int iZzb = 0;
        int i = 0;
        while (i < this.zzbvj.zzyc()) {
            Map.Entry<K, Object> entryZzbx = this.zzbvj.zzbx(i);
            i++;
            iZzb = zzb((zzuh<?>) entryZzbx.getKey(), entryZzbx.getValue()) + iZzb;
        }
        Iterator it = this.zzbvj.zzyd().iterator();
        while (true) {
            int i2 = iZzb;
            if (!it.hasNext()) {
                return i2;
            }
            Map.Entry entry = (Map.Entry) it.next();
            iZzb = i2 + zzb((zzuh<?>) entry.getKey(), entry.getValue());
        }
    }

    public final int zzvy() {
        int i = 0;
        int iZze = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzbvj.zzyc()) {
                break;
            }
            i = i2 + 1;
            iZze += zze(this.zzbvj.zzbx(i2));
        }
        Iterator it = this.zzbvj.zzyd().iterator();
        while (true) {
            int i3 = iZze;
            if (!it.hasNext()) {
                return i3;
            }
            iZze = zze((Map.Entry) it.next()) + i3;
        }
    }
}
