package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zztq {
    int zzbua;
    int zzbub;
    private int zzbuc;
    zztt zzbud;
    private boolean zzbue;

    private zztq() {
        this.zzbub = 100;
        this.zzbuc = Integer.MAX_VALUE;
        this.zzbue = false;
    }

    static zztq zza(byte[] bArr, int i, int i2, boolean z) {
        zzts zztsVar = new zzts(bArr, i, i2, false);
        try {
            zztsVar.zzas(i2);
            return zztsVar;
        } catch (zzuv e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static zztq zzd(byte[] bArr, int i, int i2) {
        return zza(bArr, i, i2, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzvv> T zza(zzwf<T> zzwfVar, zzub zzubVar) throws IOException;

    public abstract void zzap(int i) throws zzuv;

    public abstract boolean zzaq(int i) throws IOException;

    public final int zzar(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(47).append("Recursion limit cannot be negative: ").append(i).toString());
        }
        int i2 = this.zzbub;
        this.zzbub = i;
        return i2;
    }

    public abstract int zzas(int i) throws zzuv;

    public abstract void zzat(int i);

    public abstract void zzau(int i) throws IOException;

    public abstract int zzuj() throws IOException;

    public abstract long zzuk() throws IOException;

    public abstract long zzul() throws IOException;

    public abstract int zzum() throws IOException;

    public abstract long zzun() throws IOException;

    public abstract int zzuo() throws IOException;

    public abstract boolean zzup() throws IOException;

    public abstract String zzuq() throws IOException;

    public abstract zzte zzur() throws IOException;

    public abstract int zzus() throws IOException;

    public abstract int zzut() throws IOException;

    public abstract int zzuu() throws IOException;

    public abstract long zzuv() throws IOException;

    public abstract int zzuw() throws IOException;

    public abstract long zzux() throws IOException;

    abstract long zzuy() throws IOException;

    public abstract boolean zzuz() throws IOException;

    public abstract int zzva();
}
