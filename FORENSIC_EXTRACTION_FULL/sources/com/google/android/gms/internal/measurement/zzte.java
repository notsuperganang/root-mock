package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzte implements Serializable, Iterable<Byte> {
    public static final zzte zzbts = new zzto(zzuq.zzbzc);
    private static final zztk zzbtt;
    private static final Comparator<zzte> zzbtu;
    private int zzbsk = 0;

    static {
        zztf zztfVar = null;
        zzbtt = zztb.zzub() ? new zztp(zztfVar) : new zzti(zztfVar);
        zzbtu = new zztg();
    }

    zzte() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    static zztm zzao(int i) {
        return new zztm(i, null);
    }

    static int zzb(int i, int i2, int i3) {
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

    public static zzte zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzto(zzbtt.zzc(bArr, i, i2));
    }

    public static zzte zzga(String str) {
        return new zzto(str.getBytes(zzuq.UTF_8));
    }

    static zzte zzi(byte[] bArr) {
        return new zzto(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZza = this.zzbsk;
        if (iZza == 0) {
            int size = size();
            iZza = zza(size, 0, size);
            if (iZza == 0) {
                iZza = 1;
            }
            this.zzbsk = iZza;
        }
        return iZza;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zztf(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract int zza(int i, int i2, int i3);

    protected abstract String zza(Charset charset);

    abstract void zza(zztd zztdVar) throws IOException;

    public abstract byte zzam(int i);

    abstract byte zzan(int i);

    public abstract zzte zzb(int i, int i2);

    public final String zzud() {
        return size() == 0 ? "" : zza(zzuq.UTF_8);
    }

    public abstract boolean zzue();

    protected final int zzuf() {
        return this.zzbsk;
    }
}
