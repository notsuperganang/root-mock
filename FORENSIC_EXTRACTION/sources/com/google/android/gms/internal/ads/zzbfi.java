package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbfi {
    protected volatile int zzebt = -1;

    public static final <T extends zzbfi> T zza(T t, byte[] bArr) throws zzbfh {
        return (T) zza(t, bArr, 0, bArr.length);
    }

    private static final <T extends zzbfi> T zza(T t, byte[] bArr, int i, int i2) throws zzbfh {
        try {
            zzbez zzbezVarZzi = zzbez.zzi(bArr, 0, i2);
            t.zza(zzbezVarZzi);
            zzbezVarZzi.zzbp(0);
            return t;
        } catch (zzbfh e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final byte[] zzb(zzbfi zzbfiVar) {
        byte[] bArr = new byte[zzbfiVar.zzacw()];
        try {
            zzbfa zzbfaVarZzj = zzbfa.zzj(bArr, 0, bArr.length);
            zzbfiVar.zza(zzbfaVarZzj);
            zzbfaVarZzj.zzacl();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return zzbfj.zzc(this);
    }

    public abstract zzbfi zza(zzbez zzbezVar) throws IOException;

    public void zza(zzbfa zzbfaVar) throws IOException {
    }

    public final int zzacw() {
        int iZzr = zzr();
        this.zzebt = iZzr;
        return iZzr;
    }

    @Override // 
    /* JADX INFO: renamed from: zzago, reason: merged with bridge method [inline-methods] */
    public zzbfi clone() throws CloneNotSupportedException {
        return (zzbfi) super.clone();
    }

    protected int zzr() {
        return 0;
    }
}
