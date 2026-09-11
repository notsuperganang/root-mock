package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzxe {
    private static final zzxe zzcch = new zzxe(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzbtn;
    private int zzbyg;
    private Object[] zzcat;
    private int[] zzcci;

    private zzxe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzxe(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzbyg = -1;
        this.count = i;
        this.zzcci = iArr;
        this.zzcat = objArr;
        this.zzbtn = z;
    }

    static zzxe zza(zzxe zzxeVar, zzxe zzxeVar2) {
        int i = zzxeVar.count + zzxeVar2.count;
        int[] iArrCopyOf = Arrays.copyOf(zzxeVar.zzcci, i);
        System.arraycopy(zzxeVar2.zzcci, 0, iArrCopyOf, zzxeVar.count, zzxeVar2.count);
        Object[] objArrCopyOf = Arrays.copyOf(zzxeVar.zzcat, i);
        System.arraycopy(zzxeVar2.zzcat, 0, objArrCopyOf, zzxeVar.count, zzxeVar2.count);
        return new zzxe(i, iArrCopyOf, objArrCopyOf, true);
    }

    private static void zzb(int i, Object obj, zzxy zzxyVar) throws IOException {
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                zzxyVar.zzi(i2, ((Long) obj).longValue());
                return;
            case 1:
                zzxyVar.zzc(i2, ((Long) obj).longValue());
                return;
            case 2:
                zzxyVar.zza(i2, (zzte) obj);
                return;
            case 3:
                if (zzxyVar.zzvm() == zzuo.zze.zzbyx) {
                    zzxyVar.zzbm(i2);
                    ((zzxe) obj).zzb(zzxyVar);
                    zzxyVar.zzbn(i2);
                    return;
                } else {
                    zzxyVar.zzbn(i2);
                    ((zzxe) obj).zzb(zzxyVar);
                    zzxyVar.zzbm(i2);
                    return;
                }
            case 4:
            default:
                throw new RuntimeException(zzuv.zzwu());
            case 5:
                zzxyVar.zzg(i2, ((Integer) obj).intValue());
                return;
        }
    }

    public static zzxe zzyl() {
        return zzcch;
    }

    static zzxe zzym() {
        return new zzxe();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this != obj) {
            if (obj == null || !(obj instanceof zzxe)) {
                return false;
            }
            zzxe zzxeVar = (zzxe) obj;
            if (this.count != zzxeVar.count) {
                return false;
            }
            int[] iArr = this.zzcci;
            int[] iArr2 = zzxeVar.zzcci;
            int i = this.count;
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
            Object[] objArr = this.zzcat;
            Object[] objArr2 = zzxeVar.zzcat;
            int i3 = this.count;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!objArr[i4].equals(objArr2[i4])) {
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
        int i = this.count;
        int[] iArr = this.zzcci;
        int i2 = this.count;
        int i3 = 17;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        Object[] objArr = this.zzcat;
        int i5 = this.count;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode = (iHashCode * 31) + objArr[i6].hashCode();
        }
        return ((((i + 527) * 31) + i3) * 31) + iHashCode;
    }

    final void zza(zzxy zzxyVar) throws IOException {
        if (zzxyVar.zzvm() == zzuo.zze.zzbyy) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzxyVar.zza(this.zzcci[i] >>> 3, this.zzcat[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzxyVar.zza(this.zzcci[i2] >>> 3, this.zzcat[i2]);
        }
    }

    final void zzb(int i, Object obj) {
        if (!this.zzbtn) {
            throw new UnsupportedOperationException();
        }
        if (this.count == this.zzcci.length) {
            int i2 = (this.count < 4 ? 8 : this.count >> 1) + this.count;
            this.zzcci = Arrays.copyOf(this.zzcci, i2);
            this.zzcat = Arrays.copyOf(this.zzcat, i2);
        }
        this.zzcci[this.count] = i;
        this.zzcat[this.count] = obj;
        this.count++;
    }

    public final void zzb(zzxy zzxyVar) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (zzxyVar.zzvm() == zzuo.zze.zzbyx) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zzcci[i], this.zzcat[i], zzxyVar);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zzcci[i2], this.zzcat[i2], zzxyVar);
        }
    }

    final void zzb(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzvy.zzb(sb, i, String.valueOf(this.zzcci[i2] >>> 3), this.zzcat[i2]);
        }
    }

    public final void zzsw() {
        this.zzbtn = false;
    }

    public final int zzvx() {
        int iZzvx;
        int i = this.zzbyg;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zzcci[i3];
            int i5 = i4 >>> 3;
            switch (i4 & 7) {
                case 0:
                    iZzvx = zztv.zze(i5, ((Long) this.zzcat[i3]).longValue());
                    break;
                case 1:
                    iZzvx = zztv.zzg(i5, ((Long) this.zzcat[i3]).longValue());
                    break;
                case 2:
                    iZzvx = zztv.zzc(i5, (zzte) this.zzcat[i3]);
                    break;
                case 3:
                    iZzvx = ((zzxe) this.zzcat[i3]).zzvx() + (zztv.zzbd(i5) << 1);
                    break;
                case 4:
                default:
                    throw new IllegalStateException(zzuv.zzwu());
                case 5:
                    iZzvx = zztv.zzk(i5, ((Integer) this.zzcat[i3]).intValue());
                    break;
            }
            i2 += iZzvx;
        }
        this.zzbyg = i2;
        return i2;
    }

    public final int zzyn() {
        int i = this.zzbyg;
        if (i != -1) {
            return i;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < this.count; i2++) {
            iZzd += zztv.zzd(this.zzcci[i2] >>> 3, (zzte) this.zzcat[i2]);
        }
        this.zzbyg = iZzd;
        return iZzd;
    }
}
