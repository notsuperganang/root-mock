package com.google.android.gms.internal.places;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfr implements Serializable, Iterable<Byte> {
    public static final zzfr zznt = new zzfy(zzhb.zztl);
    private static final zzfv zznu;
    private int zznv = 0;

    static {
        zzfs zzfsVar = null;
        zznu = zzfl.zzbd() ? new zzfz(zzfsVar) : new zzft(zzfsVar);
    }

    zzfr() {
    }

    static zzfw zzag(int i) {
        return new zzfw(i, null);
    }

    static int zzc(int i, int i2, int i3) {
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

    static zzfr zzc(byte[] bArr) {
        return new zzfy(bArr);
    }

    public static zzfr zzc(byte[] bArr, int i, int i2) {
        return new zzfy(zznu.zze(bArr, i, i2));
    }

    static zzfr zzd(byte[] bArr, int i, int i2) {
        return new zzfu(bArr, i, i2);
    }

    public static zzfr zzj(String str) {
        return new zzfy(str.getBytes(zzhb.UTF_8));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzb = this.zznv;
        if (iZzb == 0) {
            int size = size();
            iZzb = zzb(size, 0, size);
            if (iZzb == 0) {
                iZzb = 1;
            }
            this.zznv = iZzb;
        }
        return iZzb;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzfs(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract byte zzaf(int i);

    protected abstract int zzb(int i, int i2, int i3);

    protected abstract String zzb(Charset charset);

    abstract void zzb(zzfq zzfqVar) throws IOException;

    protected abstract void zzb(byte[] bArr, int i, int i2, int i3);

    public abstract zzfr zzc(int i, int i2);

    public final String zzcd() {
        return size() == 0 ? "" : zzb(zzhb.UTF_8);
    }

    public abstract boolean zzce();

    protected final int zzcf() {
        return this.zznv;
    }
}
