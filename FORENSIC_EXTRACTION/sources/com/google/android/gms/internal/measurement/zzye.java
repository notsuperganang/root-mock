package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzye implements Cloneable {
    private static final zzyf zzcey = new zzyf();
    private int mSize;
    private boolean zzcez;
    private int[] zzcfa;
    private zzyf[] zzcfb;

    zzye() {
        this(10);
    }

    private zzye(int i) {
        this.zzcez = false;
        int iIdealIntArraySize = idealIntArraySize(i);
        this.zzcfa = new int[iIdealIntArraySize];
        this.zzcfb = new zzyf[iIdealIntArraySize];
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

    private final int zzcg(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzcfa[i4];
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
        zzye zzyeVar = new zzye(i);
        System.arraycopy(this.zzcfa, 0, zzyeVar.zzcfa, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzcfb[i2] != null) {
                zzyeVar.zzcfb[i2] = (zzyf) this.zzcfb[i2].clone();
            }
        }
        zzyeVar.mSize = i;
        return zzyeVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj != this) {
            if (!(obj instanceof zzye)) {
                return false;
            }
            zzye zzyeVar = (zzye) obj;
            if (this.mSize != zzyeVar.mSize) {
                return false;
            }
            int[] iArr = this.zzcfa;
            int[] iArr2 = zzyeVar.zzcfa;
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
            zzyf[] zzyfVarArr = this.zzcfb;
            zzyf[] zzyfVarArr2 = zzyeVar.zzcfb;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!zzyfVarArr[i4].equals(zzyfVarArr2[i4])) {
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
            iHashCode = (((iHashCode * 31) + this.zzcfa[i]) * 31) + this.zzcfb[i].hashCode();
        }
        return iHashCode;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    final int size() {
        return this.mSize;
    }

    final void zza(int i, zzyf zzyfVar) {
        int iZzcg = zzcg(i);
        if (iZzcg >= 0) {
            this.zzcfb[iZzcg] = zzyfVar;
            return;
        }
        int i2 = iZzcg ^ (-1);
        if (i2 < this.mSize && this.zzcfb[i2] == zzcey) {
            this.zzcfa[i2] = i;
            this.zzcfb[i2] = zzyfVar;
            return;
        }
        if (this.mSize >= this.zzcfa.length) {
            int iIdealIntArraySize = idealIntArraySize(this.mSize + 1);
            int[] iArr = new int[iIdealIntArraySize];
            zzyf[] zzyfVarArr = new zzyf[iIdealIntArraySize];
            System.arraycopy(this.zzcfa, 0, iArr, 0, this.zzcfa.length);
            System.arraycopy(this.zzcfb, 0, zzyfVarArr, 0, this.zzcfb.length);
            this.zzcfa = iArr;
            this.zzcfb = zzyfVarArr;
        }
        if (this.mSize - i2 != 0) {
            System.arraycopy(this.zzcfa, i2, this.zzcfa, i2 + 1, this.mSize - i2);
            System.arraycopy(this.zzcfb, i2, this.zzcfb, i2 + 1, this.mSize - i2);
        }
        this.zzcfa[i2] = i;
        this.zzcfb[i2] = zzyfVar;
        this.mSize++;
    }

    final zzyf zzce(int i) {
        int iZzcg = zzcg(i);
        if (iZzcg < 0 || this.zzcfb[iZzcg] == zzcey) {
            return null;
        }
        return this.zzcfb[iZzcg];
    }

    final zzyf zzcf(int i) {
        return this.zzcfb[i];
    }
}
