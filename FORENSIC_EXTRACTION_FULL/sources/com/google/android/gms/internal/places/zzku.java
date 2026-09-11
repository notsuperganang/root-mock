package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzku {
    protected volatile int zzaap = -1;

    public static final <T extends zzku> T zzb(T t, byte[] bArr) throws zzkt {
        return (T) zzb(t, bArr, 0, bArr.length);
    }

    private static final <T extends zzku> T zzb(T t, byte[] bArr, int i, int i2) throws zzkt {
        try {
            zzkl zzklVarZzk = zzkl.zzk(bArr, 0, i2);
            t.zzb(zzklVarZzk);
            zzklVarZzk.zzah(0);
            return t;
        } catch (zzkt e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final byte[] zzd(zzku zzkuVar) {
        byte[] bArr = new byte[zzkuVar.zzdg()];
        try {
            zzkm zzkmVarZzl = zzkm.zzl(bArr, 0, bArr.length);
            zzkuVar.zzb(zzkmVarZzl);
            zzkmVarZzl.zzhd();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return zzkv.zze(this);
    }

    protected int zzal() {
        return 0;
    }

    public abstract zzku zzb(zzkl zzklVar) throws IOException;

    public void zzb(zzkm zzkmVar) throws IOException {
    }

    public final int zzdg() {
        int iZzal = zzal();
        this.zzaap = iZzal;
        return iZzal;
    }

    @Override // 
    /* JADX INFO: renamed from: zzhe, reason: merged with bridge method [inline-methods] */
    public zzku clone() throws CloneNotSupportedException {
        return (zzku) super.clone();
    }
}
