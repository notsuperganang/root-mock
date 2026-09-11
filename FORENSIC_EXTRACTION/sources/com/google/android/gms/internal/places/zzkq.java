package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
public final class zzkq implements Cloneable {
    private static final zzkr zzaai = new zzkr();
    private int mSize;
    private boolean zzaaj;
    private int[] zzaak;
    private zzkr[] zzaal;

    zzkq() {
        this(10);
    }

    private zzkq(int i) {
        this.zzaaj = false;
        int iIdealIntArraySize = idealIntArraySize(i);
        this.zzaak = new int[iIdealIntArraySize];
        this.zzaal = new zzkr[iIdealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    private final int zzbw(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzaak[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return i2 ^ (-1);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzkq zzkqVar = new zzkq(i);
        System.arraycopy(this.zzaak, 0, zzkqVar.zzaak, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzaal[i2] != null) {
                zzkqVar.zzaal[i2] = (zzkr) this.zzaal[i2].clone();
            }
        }
        zzkqVar.mSize = i;
        return zzkqVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkq)) {
            return false;
        }
        zzkq zzkqVar = (zzkq) obj;
        if (this.mSize != zzkqVar.mSize) {
            return false;
        }
        int[] iArr = this.zzaak;
        int[] iArr2 = zzkqVar.zzaak;
        int i = this.mSize;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            }
            if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            }
            i2++;
        }
        if (z) {
            zzkr[] zzkrVarArr = this.zzaal;
            zzkr[] zzkrVarArr2 = zzkqVar.zzaal;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!zzkrVarArr[i4].equals(zzkrVarArr2[i4])) {
                    z2 = false;
                    break;
                }
                i4++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 17;
        for (int i = 0; i < this.mSize; i++) {
            iHashCode = (((iHashCode * 31) + this.zzaak[i]) * 31) + this.zzaal[i].hashCode();
        }
        return iHashCode;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    final int size() {
        return this.mSize;
    }

    final void zzb(int i, zzkr zzkrVar) {
        int iZzbw = zzbw(i);
        if (iZzbw >= 0) {
            this.zzaal[iZzbw] = zzkrVar;
            return;
        }
        int i2 = iZzbw ^ (-1);
        if (i2 < this.mSize && this.zzaal[i2] == zzaai) {
            this.zzaak[i2] = i;
            this.zzaal[i2] = zzkrVar;
            return;
        }
        if (this.mSize >= this.zzaak.length) {
            int iIdealIntArraySize = idealIntArraySize(this.mSize + 1);
            int[] iArr = new int[iIdealIntArraySize];
            zzkr[] zzkrVarArr = new zzkr[iIdealIntArraySize];
            System.arraycopy(this.zzaak, 0, iArr, 0, this.zzaak.length);
            System.arraycopy(this.zzaal, 0, zzkrVarArr, 0, this.zzaal.length);
            this.zzaak = iArr;
            this.zzaal = zzkrVarArr;
        }
        if (this.mSize - i2 != 0) {
            System.arraycopy(this.zzaak, i2, this.zzaak, i2 + 1, this.mSize - i2);
            System.arraycopy(this.zzaal, i2, this.zzaal, i2 + 1, this.mSize - i2);
        }
        this.zzaak[i2] = i;
        this.zzaal[i2] = zzkrVar;
        this.mSize++;
    }

    final zzkr zzbu(int i) {
        int iZzbw = zzbw(i);
        if (iZzbw < 0 || this.zzaal[iZzbw] == zzaai) {
            return null;
        }
        return this.zzaal[iZzbw];
    }

    final zzkr zzbv(int i) {
        return this.zzaal[i];
    }
}
