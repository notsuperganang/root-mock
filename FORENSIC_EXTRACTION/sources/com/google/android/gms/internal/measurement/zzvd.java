package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzvd extends zzta<String> implements zzve, RandomAccess {
    private static final zzvd zzbzz;
    private static final zzve zzcaa;
    private final List<Object> zzcab;

    static {
        zzvd zzvdVar = new zzvd();
        zzbzz = zzvdVar;
        zzvdVar.zzsw();
        zzcaa = zzbzz;
    }

    public zzvd() {
        this(10);
    }

    public zzvd(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzvd(ArrayList<Object> arrayList) {
        this.zzcab = arrayList;
    }

    private static String zzaa(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof zzte ? ((zzte) obj).zzud() : zzuq.zzm((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzua();
        this.zzcab.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzua();
        if (collection instanceof zzve) {
            collection = ((zzve) collection).zzxb();
        }
        boolean zAddAll = this.zzcab.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzua();
        this.zzcab.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzcab.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzte) {
            zzte zzteVar = (zzte) obj;
            String strZzud = zzteVar.zzud();
            if (zzteVar.zzue()) {
                this.zzcab.set(i, strZzud);
            }
            return strZzud;
        }
        byte[] bArr = (byte[]) obj;
        String strZzm = zzuq.zzm(bArr);
        if (zzuq.zzl(bArr)) {
            this.zzcab.set(i, strZzm);
        }
        return strZzm;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        Object objRemove = this.zzcab.remove(i);
        this.modCount++;
        return zzaa(objRemove);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzta, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzua();
        return zzaa(this.zzcab.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzcab.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu zzal(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzcab);
        return new zzvd((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final Object zzbp(int i) {
        return this.zzcab.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final void zzc(zzte zzteVar) {
        zzua();
        this.zzcab.add(zzteVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta, com.google.android.gms.internal.measurement.zzuu
    public final /* bridge */ /* synthetic */ boolean zztz() {
        return super.zztz();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final List<?> zzxb() {
        return Collections.unmodifiableList(this.zzcab);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final zzve zzxc() {
        return zztz() ? new zzxg(this) : this;
    }
}
