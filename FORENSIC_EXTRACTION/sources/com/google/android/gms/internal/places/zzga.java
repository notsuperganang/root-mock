package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzga {
    private static volatile boolean zzog;
    int zzob;
    int zzoc;
    private int zzod;
    zzgd zzoe;
    private boolean zzof;

    static {
        zzog = false;
        zzog = true;
    }

    private zzga() {
        this.zzoc = 100;
        this.zzod = Integer.MAX_VALUE;
        this.zzof = false;
    }

    public static int zzan(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    static zzga zzb(byte[] bArr, int i, int i2, boolean z) {
        zzgc zzgcVar = new zzgc(bArr, i, i2, false);
        try {
            zzgcVar.zzak(i2);
            return zzgcVar;
        } catch (zzhh e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzd(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzga zzf(byte[] bArr, int i, int i2) {
        return zzb(bArr, i, i2, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract void zzah(int i) throws zzhh;

    public abstract boolean zzai(int i) throws IOException;

    public final int zzaj(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(47).append("Recursion limit cannot be negative: ").append(i).toString());
        }
        int i2 = this.zzoc;
        this.zzoc = i;
        return i2;
    }

    public abstract int zzak(int i) throws zzhh;

    public abstract void zzal(int i);

    public abstract void zzam(int i) throws IOException;

    public abstract <T extends zzih> T zzb(zzir<T> zzirVar, zzgl zzglVar) throws IOException;

    public abstract boolean zzbf() throws IOException;

    public abstract long zzbi() throws IOException;

    public abstract long zzbj() throws IOException;

    public abstract int zzbk() throws IOException;

    public abstract long zzbl() throws IOException;

    public abstract int zzbm() throws IOException;

    public abstract boolean zzbn() throws IOException;

    public abstract String zzbo() throws IOException;

    public abstract zzfr zzbp() throws IOException;

    public abstract int zzbq() throws IOException;

    public abstract int zzbr() throws IOException;

    public abstract int zzbs() throws IOException;

    public abstract long zzbt() throws IOException;

    public abstract int zzbu() throws IOException;

    public abstract long zzbv() throws IOException;

    public abstract int zzcj() throws IOException;

    abstract long zzck() throws IOException;

    public abstract int zzcl();
}
