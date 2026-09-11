package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyc;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzyd<M extends zzyc<M>, T> {
    public final int tag;
    private final int type;
    private final zzuo<?, ?> zzbyi;
    protected final Class<T> zzcew;
    protected final boolean zzcex;

    private zzyd(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, 810, false);
    }

    private zzyd(int i, Class<T> cls, zzuo<?, ?> zzuoVar, int i2, boolean z) {
        this.type = i;
        this.zzcew = cls;
        this.tag = i2;
        this.zzcex = false;
        this.zzbyi = null;
    }

    public static <M extends zzyc<M>, T extends zzyi> zzyd<M, T> zza(int i, Class<T> cls, long j) {
        return new zzyd<>(11, cls, 810, false);
    }

    private final Object zze(zzxz zzxzVar) {
        Class componentType = this.zzcex ? this.zzcew.getComponentType() : this.zzcew;
        try {
            switch (this.type) {
                case 10:
                    zzyi zzyiVar = (zzyi) componentType.newInstance();
                    zzxzVar.zza(zzyiVar, this.tag >>> 3);
                    return zzyiVar;
                case 11:
                    zzyi zzyiVar2 = (zzyi) componentType.newInstance();
                    zzxzVar.zza(zzyiVar2);
                    return zzyiVar2;
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

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof zzyd)) {
                return false;
            }
            zzyd zzydVar = (zzyd) obj;
            if (this.type != zzydVar.type || this.zzcew != zzydVar.zzcew || this.tag != zzydVar.tag || this.zzcex != zzydVar.zzcex) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = this.type;
        int iHashCode = this.zzcew.hashCode();
        return (this.zzcex ? 1 : 0) + ((((((i + 1147) * 31) + iHashCode) * 31) + this.tag) * 31);
    }

    protected final void zza(Object obj, zzya zzyaVar) {
        try {
            zzyaVar.zzcd(this.tag);
            switch (this.type) {
                case 10:
                    int i = this.tag;
                    ((zzyi) obj).zza(zzyaVar);
                    zzyaVar.zzc(i >>> 3, 4);
                    return;
                case 11:
                    zzyaVar.zzb((zzyi) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    final T zzai(List<zzyk> list) {
        if (list == null) {
            return null;
        }
        if (!this.zzcex) {
            if (list.isEmpty()) {
                return null;
            }
            return this.zzcew.cast(zze(zzxz.zzn(list.get(list.size() - 1).zzbtz)));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzyk zzykVar = list.get(i);
            if (zzykVar.zzbtz.length != 0) {
                arrayList.add(zze(zzxz.zzn(zzykVar.zzbtz)));
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T tCast = this.zzcew.cast(Array.newInstance(this.zzcew.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(tCast, i2, arrayList.get(i2));
        }
        return tCast;
    }

    protected final int zzao(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzya.zzbd(i) << 1) + ((zzyi) obj).zzvx();
            case 11:
                return zzya.zzb(i, (zzyi) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
        }
    }
}
