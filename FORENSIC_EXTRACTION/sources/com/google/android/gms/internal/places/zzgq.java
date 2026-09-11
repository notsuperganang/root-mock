package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzgs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzgq<FieldDescriptorType extends zzgs<FieldDescriptorType>> {
    private static final zzgq zzpm = new zzgq(true);
    private boolean zzpk;
    private boolean zzpl = false;
    private final zzjb<FieldDescriptorType, Object> zzpj = zzjb.zzbm(16);

    private zzgq() {
    }

    private zzgq(boolean z) {
        zzbb();
    }

    static int zzb(zzke zzkeVar, int i, Object obj) {
        int i2;
        int iZzas = zzgf.zzas(i);
        if (zzkeVar == zzke.zzzc) {
            zzhb.zzg((zzih) obj);
            i2 = iZzas << 1;
        } else {
            i2 = iZzas;
        }
        return i2 + zzc(zzkeVar, obj);
    }

    static void zzb(zzgf zzgfVar, zzke zzkeVar, int i, Object obj) throws IOException {
        if (zzkeVar == zzke.zzzc) {
            zzhb.zzg((zzih) obj);
            zzgfVar.zzd(i, 3);
            ((zzih) obj).zzc(zzgfVar);
            zzgfVar.zzd(i, 4);
        }
        zzgfVar.zzd(i, zzkeVar.zzha());
        switch (zzgr.zznn[zzkeVar.ordinal()]) {
            case 1:
                zzgfVar.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zzgfVar.zzd(((Float) obj).floatValue());
                break;
            case 3:
                zzgfVar.zze(((Long) obj).longValue());
                break;
            case 4:
                zzgfVar.zze(((Long) obj).longValue());
                break;
            case 5:
                zzgfVar.zzao(((Integer) obj).intValue());
                break;
            case 6:
                zzgfVar.zzg(((Long) obj).longValue());
                break;
            case 7:
                zzgfVar.zzar(((Integer) obj).intValue());
                break;
            case 8:
                zzgfVar.zzd(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzih) obj).zzc(zzgfVar);
                break;
            case 10:
                zzgfVar.zzc((zzih) obj);
                break;
            case 11:
                if (!(obj instanceof zzfr)) {
                    zzgfVar.zzk((String) obj);
                } else {
                    zzgfVar.zzb((zzfr) obj);
                }
                break;
            case 12:
                if (!(obj instanceof zzfr)) {
                    byte[] bArr = (byte[]) obj;
                    zzgfVar.zzg(bArr, 0, bArr.length);
                } else {
                    zzgfVar.zzb((zzfr) obj);
                }
                break;
            case 13:
                zzgfVar.zzap(((Integer) obj).intValue());
                break;
            case 14:
                zzgfVar.zzar(((Integer) obj).intValue());
                break;
            case 15:
                zzgfVar.zzg(((Long) obj).longValue());
                break;
            case 16:
                zzgfVar.zzaq(((Integer) obj).intValue());
                break;
            case 17:
                zzgfVar.zzf(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof zzhc)) {
                    zzgfVar.zzao(((Integer) obj).intValue());
                } else {
                    zzgfVar.zzao(((zzhc) obj).zzap());
                }
                break;
        }
    }

    private static void zzb(zzke zzkeVar, Object obj) {
        boolean z = false;
        zzhb.checkNotNull(obj);
        switch (zzgr.zzpn[zzkeVar.zzgz().ordinal()]) {
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
                if ((obj instanceof zzfr) || (obj instanceof byte[])) {
                    z = true;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzhc)) {
                    z = true;
                }
                break;
            case 9:
                if ((obj instanceof zzih) || (obj instanceof zzhk)) {
                    z = true;
                }
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static int zzc(zzgs<?> zzgsVar, Object obj) {
        int iZzb = 0;
        zzke zzkeVarZzdi = zzgsVar.zzdi();
        int iZzap = zzgsVar.zzap();
        if (!zzgsVar.zzdk()) {
            return zzb(zzkeVarZzdi, iZzap, obj);
        }
        if (!zzgsVar.zzdl()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iZzb += zzb(zzkeVarZzdi, iZzap, it.next());
            }
            return iZzb;
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iZzb += zzc(zzkeVarZzdi, it2.next());
        }
        return zzgf.zzba(iZzb) + zzgf.zzas(iZzap) + iZzb;
    }

    private static int zzc(zzke zzkeVar, Object obj) {
        switch (zzgr.zznn[zzkeVar.ordinal()]) {
            case 1:
                return zzgf.zzc(((Double) obj).doubleValue());
            case 2:
                return zzgf.zze(((Float) obj).floatValue());
            case 3:
                return zzgf.zzh(((Long) obj).longValue());
            case 4:
                return zzgf.zzi(((Long) obj).longValue());
            case 5:
                return zzgf.zzat(((Integer) obj).intValue());
            case 6:
                return zzgf.zzk(((Long) obj).longValue());
            case 7:
                return zzgf.zzaw(((Integer) obj).intValue());
            case 8:
                return zzgf.zze(((Boolean) obj).booleanValue());
            case 9:
                return zzgf.zze((zzih) obj);
            case 10:
                return obj instanceof zzhk ? zzgf.zzb((zzhk) obj) : zzgf.zzd((zzih) obj);
            case 11:
                return obj instanceof zzfr ? zzgf.zzc((zzfr) obj) : zzgf.zzl((String) obj);
            case 12:
                return obj instanceof zzfr ? zzgf.zzc((zzfr) obj) : zzgf.zze((byte[]) obj);
            case 13:
                return zzgf.zzau(((Integer) obj).intValue());
            case 14:
                return zzgf.zzax(((Integer) obj).intValue());
            case 15:
                return zzgf.zzl(((Long) obj).longValue());
            case 16:
                return zzgf.zzav(((Integer) obj).intValue());
            case 17:
                return zzgf.zzj(((Long) obj).longValue());
            case 18:
                return obj instanceof zzhc ? zzgf.zzay(((zzhc) obj).zzap()) : zzgf.zzay(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzdj() == zzkj.MESSAGE) {
            if (key.zzdk()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzih) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzih)) {
                    if (value instanceof zzhk) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzih) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzhk) {
            value = zzhk.zzei();
        }
        if (key.zzdk()) {
            Object objZzb = zzb(key);
            if (objZzb == null) {
                objZzb = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZzb).add(zze(it.next()));
            }
            this.zzpj.put(key, objZzb);
            return;
        }
        if (key.zzdj() != zzkj.MESSAGE) {
            this.zzpj.put(key, zze(value));
            return;
        }
        Object objZzb2 = zzb(key);
        if (objZzb2 == null) {
            this.zzpj.put(key, zze(value));
        } else {
            this.zzpj.put(key, objZzb2 instanceof zzin ? key.zzb((zzin) objZzb2, (zzin) value) : key.zzb(((zzih) objZzb2).zzdq(), (zzih) value).zzdx());
        }
    }

    public static <T extends zzgs<T>> zzgq<T> zzdf() {
        return zzpm;
    }

    private static int zze(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzdj() != zzkj.MESSAGE || key.zzdk() || key.zzdl()) {
            return zzc((zzgs<?>) key, value);
        }
        return value instanceof zzhk ? zzgf.zzc(entry.getKey().zzap(), (zzhk) value) : zzgf.zze(entry.getKey().zzap(), (zzih) value);
    }

    private static Object zze(Object obj) {
        if (obj instanceof zzin) {
            return ((zzin) obj).zzey();
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
        zzgq zzgqVar = new zzgq();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzpj.zzgg()) {
                break;
            }
            Map.Entry<K, Object> entryZzbn = this.zzpj.zzbn(i2);
            zzgqVar.zzb((zzgs) entryZzbn.getKey(), entryZzbn.getValue());
            i = i2 + 1;
        }
        Iterator it = this.zzpj.zzgh().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzgqVar.zzb((zzgs) entry.getKey(), entry.getValue());
        }
        zzgqVar.zzpl = this.zzpl;
        return zzgqVar;
    }

    final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        return this.zzpl ? new zzhn(this.zzpj.zzgi().iterator()) : this.zzpj.zzgi().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgq) {
            return this.zzpj.equals(((zzgq) obj).zzpj);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzpj.hashCode();
    }

    final boolean isEmpty() {
        return this.zzpj.isEmpty();
    }

    public final boolean isImmutable() {
        return this.zzpk;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzpj.zzgg(); i++) {
            if (!zzc(this.zzpj.zzbn(i))) {
                return false;
            }
        }
        Iterator it = this.zzpj.zzgh().iterator();
        while (it.hasNext()) {
            if (!zzc((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzpl ? new zzhn(this.zzpj.entrySet().iterator()) : this.zzpj.entrySet().iterator();
    }

    public final Object zzb(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzpj.get(fielddescriptortype);
        return obj instanceof zzhk ? zzhk.zzei() : obj;
    }

    public final void zzb(zzgq<FieldDescriptorType> zzgqVar) {
        for (int i = 0; i < zzgqVar.zzpj.zzgg(); i++) {
            zzd(zzgqVar.zzpj.zzbn(i));
        }
        Iterator it = zzgqVar.zzpj.zzgh().iterator();
        while (it.hasNext()) {
            zzd((Map.Entry) it.next());
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
    public final void zzb(FieldDescriptorType fielddescriptortype, Object obj) {
        ?? arrayList;
        if (!fielddescriptortype.zzdk()) {
            zzb(fielddescriptortype.zzdi(), obj);
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
                zzb(fielddescriptortype.zzdi(), obj2);
            }
        }
        if (arrayList instanceof zzhk) {
            this.zzpl = true;
        }
        this.zzpj.put(fielddescriptortype, arrayList);
    }

    public final void zzbb() {
        if (this.zzpk) {
            return;
        }
        this.zzpj.zzbb();
        this.zzpk = true;
    }

    public final int zzdg() {
        int iZzc = 0;
        for (int i = 0; i < this.zzpj.zzgg(); i++) {
            Map.Entry<K, Object> entryZzbn = this.zzpj.zzbn(i);
            iZzc += zzc((zzgs<?>) entryZzbn.getKey(), entryZzbn.getValue());
        }
        Iterator it = this.zzpj.zzgh().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iZzc += zzc((zzgs<?>) entry.getKey(), entry.getValue());
        }
        return iZzc;
    }

    public final int zzdh() {
        int iZze;
        int iZze2 = 0;
        int i = 0;
        while (true) {
            iZze = iZze2;
            if (i >= this.zzpj.zzgg()) {
                break;
            }
            iZze2 = zze((Map.Entry) this.zzpj.zzbn(i)) + iZze;
            i++;
        }
        Iterator it = this.zzpj.zzgh().iterator();
        while (it.hasNext()) {
            iZze += zze((Map.Entry) it.next());
        }
        return iZze;
    }
}
