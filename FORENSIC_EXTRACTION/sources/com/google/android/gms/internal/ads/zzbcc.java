package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcc extends zzbab<String> implements zzbcd, RandomAccess {
    private static final zzbcc zzdvn;
    private static final zzbcd zzdvo;
    private final List<Object> zzdvp;

    static {
        zzbcc zzbccVar = new zzbcc();
        zzdvn = zzbccVar;
        zzbccVar.zzaaz();
        zzdvo = zzdvn;
    }

    public zzbcc() {
        this(10);
    }

    public zzbcc(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzbcc(ArrayList<Object> arrayList) {
        this.zzdvp = arrayList;
    }

    private static String zzq(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof zzbah ? ((zzbah) obj).zzabd() : zzbbq.zzt((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzaba();
        this.zzdvp.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzaba();
        if (collection instanceof zzbcd) {
            collection = ((zzbcd) collection).zzadw();
        }
        boolean zAddAll = this.zzdvp.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzaba();
        this.zzdvp.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzdvp.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbah) {
            zzbah zzbahVar = (zzbah) obj;
            String strZzabd = zzbahVar.zzabd();
            if (zzbahVar.zzabe()) {
                this.zzdvp.set(i, strZzabd);
            }
            return strZzabd;
        }
        byte[] bArr = (byte[]) obj;
        String strZzt = zzbbq.zzt(bArr);
        if (zzbbq.zzs(bArr)) {
            this.zzdvp.set(i, strZzt);
        }
        return strZzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzaba();
        Object objRemove = this.zzdvp.remove(i);
        this.modCount++;
        return zzq(objRemove);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzbab, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzaba();
        return zzq(this.zzdvp.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzdvp.size();
    }

    @Override // com.google.android.gms.internal.ads.zzbab, com.google.android.gms.internal.ads.zzbbt
    public final /* bridge */ /* synthetic */ boolean zzaay() {
        return super.zzaay();
    }

    @Override // com.google.android.gms.internal.ads.zzbcd
    public final List<?> zzadw() {
        return Collections.unmodifiableList(this.zzdvp);
    }

    @Override // com.google.android.gms.internal.ads.zzbcd
    public final zzbcd zzadx() {
        return zzaay() ? new zzbeh(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.zzbcd
    public final void zzap(zzbah zzbahVar) {
        zzaba();
        this.zzdvp.add(zzbahVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzdvp);
        return new zzbcc((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzbcd
    public final Object zzcp(int i) {
        return this.zzdvp.get(i);
    }
}
