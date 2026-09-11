package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfe implements Cloneable {
    private static final zzbff zzebm = new zzbff();
    private int mSize;
    private boolean zzebn;
    private int[] zzebo;
    private zzbff[] zzebp;

    zzbfe() {
        this(10);
    }

    private zzbfe(int i) {
        this.zzebn = false;
        int iIdealIntArraySize = idealIntArraySize(i);
        this.zzebo = new int[iIdealIntArraySize];
        this.zzebp = new zzbff[iIdealIntArraySize];
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

    private final int zzdh(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzebo[i4];
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
        zzbfe zzbfeVar = new zzbfe(i);
        System.arraycopy(this.zzebo, 0, zzbfeVar.zzebo, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzebp[i2] != null) {
                zzbfeVar.zzebp[i2] = (zzbff) this.zzebp[i2].clone();
            }
        }
        zzbfeVar.mSize = i;
        return zzbfeVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj != this) {
            if (!(obj instanceof zzbfe)) {
                return false;
            }
            zzbfe zzbfeVar = (zzbfe) obj;
            if (this.mSize != zzbfeVar.mSize) {
                return false;
            }
            int[] iArr = this.zzebo;
            int[] iArr2 = zzbfeVar.zzebo;
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
            if (!z) {
                return false;
            }
            zzbff[] zzbffVarArr = this.zzebp;
            zzbff[] zzbffVarArr2 = zzbfeVar.zzebp;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!zzbffVarArr[i4].equals(zzbffVarArr2[i4])) {
                    z2 = false;
                    break;
                }
                i4++;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 17;
        for (int i = 0; i < this.mSize; i++) {
            iHashCode = (((iHashCode * 31) + this.zzebo[i]) * 31) + this.zzebp[i].hashCode();
        }
        return iHashCode;
    }

    final int size() {
        return this.mSize;
    }

    final void zza(int i, zzbff zzbffVar) {
        int iZzdh = zzdh(i);
        if (iZzdh >= 0) {
            this.zzebp[iZzdh] = zzbffVar;
            return;
        }
        int i2 = iZzdh ^ (-1);
        if (i2 < this.mSize && this.zzebp[i2] == zzebm) {
            this.zzebo[i2] = i;
            this.zzebp[i2] = zzbffVar;
            return;
        }
        if (this.mSize >= this.zzebo.length) {
            int iIdealIntArraySize = idealIntArraySize(this.mSize + 1);
            int[] iArr = new int[iIdealIntArraySize];
            zzbff[] zzbffVarArr = new zzbff[iIdealIntArraySize];
            System.arraycopy(this.zzebo, 0, iArr, 0, this.zzebo.length);
            System.arraycopy(this.zzebp, 0, zzbffVarArr, 0, this.zzebp.length);
            this.zzebo = iArr;
            this.zzebp = zzbffVarArr;
        }
        if (this.mSize - i2 != 0) {
            System.arraycopy(this.zzebo, i2, this.zzebo, i2 + 1, this.mSize - i2);
            System.arraycopy(this.zzebp, i2, this.zzebp, i2 + 1, this.mSize - i2);
        }
        this.zzebo[i2] = i;
        this.zzebp[i2] = zzbffVar;
        this.mSize++;
    }

    final zzbff zzdf(int i) {
        int iZzdh = zzdh(i);
        if (iZzdh < 0 || this.zzebp[iZzdh] == zzebm) {
            return null;
        }
        return this.zzebp[iZzdh];
    }

    final zzbff zzdg(int i) {
        return this.zzebp[i];
    }
}
