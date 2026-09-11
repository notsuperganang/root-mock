package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzyi {
    protected volatile int zzcff = -1;

    public static final <T extends zzyi> T zza(T t, byte[] bArr) throws zzyh {
        return (T) zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzyi zzyiVar, byte[] bArr, int i, int i2) {
        try {
            zzya zzyaVarZzk = zzya.zzk(bArr, 0, i2);
            zzyiVar.zza(zzyaVarZzk);
            zzyaVarZzk.zzza();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    private static final <T extends zzyi> T zzb(T t, byte[] bArr, int i, int i2) throws zzyh {
        try {
            zzxz zzxzVarZzj = zzxz.zzj(bArr, 0, i2);
            t.zza(zzxzVarZzj);
            zzxzVarZzj.zzap(0);
            return t;
        } catch (zzyh e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return zzyj.zzc(this);
    }

    public abstract zzyi zza(zzxz zzxzVar) throws IOException;

    public void zza(zzya zzyaVar) throws IOException {
    }

    protected int zzf() {
        return 0;
    }

    public final int zzvx() {
        int iZzf = zzf();
        this.zzcff = iZzf;
        return iZzf;
    }

    @Override // 
    /* JADX INFO: renamed from: zzzb, reason: merged with bridge method [inline-methods] */
    public zzyi clone() throws CloneNotSupportedException {
        return (zzyi) super.clone();
    }

    public final int zzzh() {
        if (this.zzcff < 0) {
            zzvx();
        }
        return this.zzcff;
    }
}
