package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbah implements Serializable, Iterable<Byte> {
    public static final zzbah zzdpq = new zzbao(zzbbq.zzduq);
    private static final zzbal zzdpr;
    private int zzdpa = 0;

    static {
        zzbai zzbaiVar = null;
        zzdpr = zzbac.zzabb() ? new zzbap(zzbaiVar) : new zzbaj(zzbaiVar);
    }

    zzbah() {
    }

    static zzbam zzbo(int i) {
        return new zzbam(i, null);
    }

    public static zzbah zzc(byte[] bArr, int i, int i2) {
        return new zzbao(zzdpr.zzd(bArr, i, i2));
    }

    static int zzd(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(i).append(" < 0").toString());
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(i).append(", ").append(i2).toString());
        }
        throw new IndexOutOfBoundsException(new StringBuilder(37).append("End index: ").append(i2).append(" >= ").append(i3).toString());
    }

    public static zzbah zzem(String str) {
        return new zzbao(str.getBytes(zzbbq.UTF_8));
    }

    public static zzbah zzo(byte[] bArr) {
        return zzc(bArr, 0, bArr.length);
    }

    static zzbah zzp(byte[] bArr) {
        return new zzbao(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzc = this.zzdpa;
        if (iZzc == 0) {
            int size = size();
            iZzc = zzc(size, 0, size);
            if (iZzc == 0) {
                iZzc = 1;
            }
            this.zzdpa = iZzc;
        }
        return iZzc;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzbai(this);
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzbbq.zzduq;
        }
        byte[] bArr = new byte[size];
        zza(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract String zza(Charset charset);

    abstract void zza(zzbag zzbagVar) throws IOException;

    protected abstract void zza(byte[] bArr, int i, int i2, int i3);

    public final String zzabd() {
        return size() == 0 ? "" : zza(zzbbq.UTF_8);
    }

    public abstract boolean zzabe();

    public abstract zzbaq zzabf();

    protected final int zzabg() {
        return this.zzdpa;
    }

    public abstract byte zzbn(int i);

    protected abstract int zzc(int i, int i2, int i3);

    public abstract zzbah zzk(int i, int i2);
}
