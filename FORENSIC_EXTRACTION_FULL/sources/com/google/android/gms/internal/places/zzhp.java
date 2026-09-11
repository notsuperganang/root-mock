package com.google.android.gms.internal.places;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzhp extends zzfk<String> implements zzhq, RandomAccess {
    private static final zzhp zzui;
    private static final zzhq zzuj;
    private final List<Object> zzuk;

    static {
        zzhp zzhpVar = new zzhp();
        zzui = zzhpVar;
        zzhpVar.zzbb();
        zzuj = zzui;
    }

    public zzhp() {
        this(10);
    }

    public zzhp(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzhp(ArrayList<Object> arrayList) {
        this.zzuk = arrayList;
    }

    private static String zzf(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof zzfr ? ((zzfr) obj).zzcd() : zzhb.zzg((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzbc();
        this.zzuk.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbc();
        if (collection instanceof zzhq) {
            collection = ((zzhq) collection).zzek();
        }
        boolean zAddAll = this.zzuk.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbc();
        this.zzuk.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzuk.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfr) {
            zzfr zzfrVar = (zzfr) obj;
            String strZzcd = zzfrVar.zzcd();
            if (zzfrVar.zzce()) {
                this.zzuk.set(i, strZzcd);
            }
            return strZzcd;
        }
        byte[] bArr = (byte[]) obj;
        String strZzg = zzhb.zzg(bArr);
        if (zzhb.zzf(bArr)) {
            this.zzuk.set(i, strZzg);
        }
        return strZzg;
    }

    @Override // com.google.android.gms.internal.places.zzhq
    public final Object getRaw(int i) {
        return this.zzuk.get(i);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbc();
        Object objRemove = this.zzuk.remove(i);
        this.modCount++;
        return zzf(objRemove);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.places.zzfk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzbc();
        return zzf(this.zzuk.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzuk.size();
    }

    @Override // com.google.android.gms.internal.places.zzhg
    public final /* synthetic */ zzhg zzae(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzuk);
        return new zzhp((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.places.zzfk, com.google.android.gms.internal.places.zzhg
    public final /* bridge */ /* synthetic */ boolean zzba() {
        return super.zzba();
    }

    @Override // com.google.android.gms.internal.places.zzhq
    public final void zzd(zzfr zzfrVar) {
        zzbc();
        this.zzuk.add(zzfrVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzhq
    public final List<?> zzek() {
        return Collections.unmodifiableList(this.zzuk);
    }

    @Override // com.google.android.gms.internal.places.zzhq
    public final zzhq zzel() {
        return zzba() ? new zzjt(this) : this;
    }
}
