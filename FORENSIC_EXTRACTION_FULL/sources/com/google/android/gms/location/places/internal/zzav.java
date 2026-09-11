package com.google.android.gms.location.places.internal;

import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.places.zzdq;
import com.google.android.gms.internal.places.zzkt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzav extends DataBufferRef {
    public zzav(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private final byte[] zzb(String str, byte[] bArr) {
        if (!hasColumn(str) || hasNull(str)) {
            return null;
        }
        return getByteArray(str);
    }

    protected final float zzb(String str, float f) {
        return (!hasColumn(str) || hasNull(str)) ? f : getFloat(str);
    }

    protected final <E extends SafeParcelable> E zzb(String str, Parcelable.Creator<E> creator) {
        byte[] bArrZzb = zzb(str, (byte[]) null);
        if (bArrZzb == null) {
            return null;
        }
        return (E) SafeParcelableSerializer.deserializeFromBytes(bArrZzb, creator);
    }

    protected final <E extends SafeParcelable> List<E> zzb(String str, Parcelable.Creator<E> creator, List<E> list) {
        byte[] bArrZzb = zzb(str, (byte[]) null);
        if (bArrZzb == null) {
            return list;
        }
        try {
            zzdq zzdqVarZzb = zzdq.zzb(bArrZzb);
            if (zzdqVarZzb.zzhy == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzdqVarZzb.zzhy.length);
            byte[][] bArr = zzdqVarZzb.zzhy;
            for (byte[] bArr2 : bArr) {
                arrayList.add(SafeParcelableSerializer.deserializeFromBytes(bArr2, creator));
            }
            return arrayList;
        } catch (zzkt e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected final List<Integer> zzb(String str, List<Integer> list) {
        byte[] bArrZzb = zzb(str, (byte[]) null);
        if (bArrZzb == null) {
            return list;
        }
        try {
            zzdq zzdqVarZzb = zzdq.zzb(bArrZzb);
            if (zzdqVarZzb.zzhx == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzdqVarZzb.zzhx.length);
            for (int i = 0; i < zzdqVarZzb.zzhx.length; i++) {
                arrayList.add(Integer.valueOf(zzdqVarZzb.zzhx[i]));
            }
            return arrayList;
        } catch (zzkt e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected final int zzc(String str, int i) {
        return (!hasColumn(str) || hasNull(str)) ? i : getInteger(str);
    }

    protected final String zzc(String str, String str2) {
        return (!hasColumn(str) || hasNull(str)) ? str2 : getString(str);
    }

    protected final List<String> zzc(String str, List<String> list) {
        byte[] bArrZzb = zzb(str, (byte[]) null);
        if (bArrZzb == null) {
            return list;
        }
        try {
            zzdq zzdqVarZzb = zzdq.zzb(bArrZzb);
            return zzdqVarZzb.zzhw != null ? Arrays.asList(zzdqVarZzb.zzhw) : list;
        } catch (zzkt e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }
}
