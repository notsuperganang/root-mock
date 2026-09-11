package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbak extends zzbao {
    private final int zzdpt;
    private final int zzdpu;

    zzbak(byte[] bArr, int i, int i2) {
        super(bArr);
        zzd(i, i + i2, bArr.length);
        this.zzdpt = i;
        this.zzdpu = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbao, com.google.android.gms.internal.ads.zzbah
    public final int size() {
        return this.zzdpu;
    }

    @Override // com.google.android.gms.internal.ads.zzbao, com.google.android.gms.internal.ads.zzbah
    protected final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzdpw, zzabh(), bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzbao
    protected final int zzabh() {
        return this.zzdpt;
    }

    @Override // com.google.android.gms.internal.ads.zzbao, com.google.android.gms.internal.ads.zzbah
    public final byte zzbn(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzdpw[this.zzdpt + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i).toString());
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i).append(", ").append(size).toString());
    }
}
