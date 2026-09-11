package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzko;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzkp<M extends zzko<M>, T> {
    private final int tag;
    private final int type;
    protected final Class<T> zzaag;
    protected final boolean zzaah;
    private final zzgz<?, ?> zzsj;

    private zzkp(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, i2, false);
    }

    private zzkp(int i, Class<T> cls, zzgz<?, ?> zzgzVar, int i2, boolean z) {
        this.type = i;
        this.zzaag = cls;
        this.tag = i2;
        this.zzaah = false;
        this.zzsj = null;
    }

    private final Object zzab(zzkl zzklVar) {
        Class componentType = this.zzaah ? this.zzaag.getComponentType() : this.zzaag;
        try {
            switch (this.type) {
                case 10:
                    zzku zzkuVar = (zzku) componentType.newInstance();
                    zzklVar.zzb(zzkuVar, this.tag >>> 3);
                    return zzkuVar;
                case 11:
                    zzku zzkuVar2 = (zzku) componentType.newInstance();
                    zzklVar.zzb(zzkuVar2);
                    return zzkuVar2;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            String strValueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 33).append("Error creating instance of class ").append(strValueOf).toString(), e2);
        } catch (InstantiationException e3) {
            String strValueOf2 = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf2).length() + 33).append("Error creating instance of class ").append(strValueOf2).toString(), e3);
        }
    }

    public static <M extends zzko<M>, T extends zzku> zzkp<M, T> zzb(int i, Class<T> cls, long j) {
        return new zzkp<>(11, cls, (int) j, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkp)) {
            return false;
        }
        zzkp zzkpVar = (zzkp) obj;
        return this.type == zzkpVar.type && this.zzaag == zzkpVar.zzaag && this.tag == zzkpVar.tag && this.zzaah == zzkpVar.zzaah;
    }

    public final int hashCode() {
        return (this.zzaah ? 1 : 0) + ((((((this.type + 1147) * 31) + this.zzaag.hashCode()) * 31) + this.tag) * 31);
    }

    final T zzae(List<zzkw> list) {
        if (list == null) {
            return null;
        }
        if (!this.zzaah) {
            if (list.isEmpty()) {
                return null;
            }
            return this.zzaag.cast(zzab(zzkl.zzh(list.get(list.size() - 1).zzoa)));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzkw zzkwVar = list.get(i);
            if (zzkwVar.zzoa.length != 0) {
                arrayList.add(zzab(zzkl.zzh(zzkwVar.zzoa)));
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T tCast = this.zzaag.cast(Array.newInstance(this.zzaag.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(tCast, i2, arrayList.get(i2));
        }
        return tCast;
    }

    protected final void zzb(Object obj, zzkm zzkmVar) {
        try {
            zzkmVar.zzbt(this.tag);
            switch (this.type) {
                case 10:
                    int i = this.tag >>> 3;
                    ((zzku) obj).zzb(zzkmVar);
                    zzkmVar.zzd(i, 4);
                    return;
                case 11:
                    zzkmVar.zzc((zzku) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    protected final int zzt(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzkm.zzas(i) << 1) + ((zzku) obj).zzdg();
            case 11:
                return zzkm.zzc(i, (zzku) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
        }
    }
}
