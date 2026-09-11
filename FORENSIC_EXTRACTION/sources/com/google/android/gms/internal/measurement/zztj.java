package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zztj extends zzto {
    private final int zzbtw;
    private final int zzbtx;

    zztj(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzbtw = i;
        this.zzbtx = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzto, com.google.android.gms.internal.measurement.zzte
    public final int size() {
        return this.zzbtx;
    }

    @Override // com.google.android.gms.internal.measurement.zzto, com.google.android.gms.internal.measurement.zzte
    public final byte zzam(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzbtz[this.zzbtw + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i).toString());
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i).append(", ").append(size).toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzto, com.google.android.gms.internal.measurement.zzte
    final byte zzan(int i) {
        return this.zzbtz[this.zzbtw + i];
    }

    @Override // com.google.android.gms.internal.measurement.zzto
    protected final int zzug() {
        return this.zzbtw;
    }
}
