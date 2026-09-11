package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzfu extends zzfy {
    private final int zznx;
    private final int zzny;

    zzfu(byte[] bArr, int i, int i2) {
        super(bArr);
        zzc(i, i + i2, bArr.length);
        this.zznx = i;
        this.zzny = i2;
    }

    @Override // com.google.android.gms.internal.places.zzfy, com.google.android.gms.internal.places.zzfr
    public final int size() {
        return this.zzny;
    }

    @Override // com.google.android.gms.internal.places.zzfy, com.google.android.gms.internal.places.zzfr
    public final byte zzaf(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzoa[this.zznx + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i).toString());
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i).append(", ").append(size).toString());
    }

    @Override // com.google.android.gms.internal.places.zzfy, com.google.android.gms.internal.places.zzfr
    protected final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzoa, zzcg(), bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.places.zzfy
    protected final int zzcg() {
        return this.zznx;
    }
}
