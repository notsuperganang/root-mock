package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzjr {
    private static final zzjr zzxr = new zzjr(0, new int[0], new Object[0], false);
    private int count;
    private boolean zznk;
    private int zzsh;
    private Object[] zzvb;
    private int[] zzxs;

    private zzjr() {
        this(0, new int[8], new Object[8], true);
    }

    private zzjr(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzsh = -1;
        this.count = i;
        this.zzxs = iArr;
        this.zzvb = objArr;
        this.zznk = z;
    }

    static zzjr zzb(zzjr zzjrVar, zzjr zzjrVar2) {
        int i = zzjrVar.count + zzjrVar2.count;
        int[] iArrCopyOf = Arrays.copyOf(zzjrVar.zzxs, i);
        System.arraycopy(zzjrVar2.zzxs, 0, iArrCopyOf, zzjrVar.count, zzjrVar2.count);
        Object[] objArrCopyOf = Arrays.copyOf(zzjrVar.zzvb, i);
        System.arraycopy(zzjrVar2.zzvb, 0, objArrCopyOf, zzjrVar.count, zzjrVar2.count);
        return new zzjr(i, iArrCopyOf, objArrCopyOf, true);
    }

    private static void zzc(int i, Object obj, zzkk zzkkVar) throws IOException {
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                zzkkVar.zzj(i2, ((Long) obj).longValue());
                return;
            case 1:
                zzkkVar.zzd(i2, ((Long) obj).longValue());
                return;
            case 2:
                zzkkVar.zzb(i2, (zzfr) obj);
                return;
            case 3:
                if (zzkkVar.zzcv() == zzgz.zzh.zztg) {
                    zzkkVar.zzbb(i2);
                    ((zzjr) obj).zzc(zzkkVar);
                    zzkkVar.zzbc(i2);
                    return;
                } else {
                    zzkkVar.zzbc(i2);
                    ((zzjr) obj).zzc(zzkkVar);
                    zzkkVar.zzbb(i2);
                    return;
                }
            case 4:
            default:
                throw new RuntimeException(zzhh.zzed());
            case 5:
                zzkkVar.zzh(i2, ((Integer) obj).intValue());
                return;
        }
    }

    public static zzjr zzgp() {
        return zzxr;
    }

    static zzjr zzgq() {
        return new zzjr();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzjr)) {
            zzjr zzjrVar = (zzjr) obj;
            if (this.count == zzjrVar.count) {
                int[] iArr = this.zzxs;
                int[] iArr2 = zzjrVar.zzxs;
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
                if (z) {
                    Object[] objArr = this.zzvb;
                    Object[] objArr2 = zzjrVar.zzvb;
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
                    if (z2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 17;
        int i = (this.count + 527) * 31;
        int[] iArr = this.zzxs;
        int i2 = this.count;
        int i3 = 17;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i + i3) * 31;
        Object[] objArr = this.zzvb;
        int i6 = this.count;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    final void zzb(zzkk zzkkVar) throws IOException {
        if (zzkkVar.zzcv() == zzgz.zzh.zzth) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzkkVar.zzb(this.zzxs[i] >>> 3, this.zzvb[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzkkVar.zzb(this.zzxs[i2] >>> 3, this.zzvb[i2]);
        }
    }

    final void zzb(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzik.zzb(sb, i, String.valueOf(this.zzxs[i2] >>> 3), this.zzvb[i2]);
        }
    }

    public final void zzbb() {
        this.zznk = false;
    }

    final void zzc(int i, Object obj) {
        if (!this.zznk) {
            throw new UnsupportedOperationException();
        }
        if (this.count == this.zzxs.length) {
            int i2 = (this.count < 4 ? 8 : this.count >> 1) + this.count;
            this.zzxs = Arrays.copyOf(this.zzxs, i2);
            this.zzvb = Arrays.copyOf(this.zzvb, i2);
        }
        this.zzxs[this.count] = i;
        this.zzvb[this.count] = obj;
        this.count++;
    }

    public final void zzc(zzkk zzkkVar) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (zzkkVar.zzcv() == zzgz.zzh.zztg) {
            for (int i = 0; i < this.count; i++) {
                zzc(this.zzxs[i], this.zzvb[i], zzkkVar);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzc(this.zzxs[i2], this.zzvb[i2], zzkkVar);
        }
    }

    public final int zzdg() {
        int iZzdg;
        int i = this.zzsh;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                int i3 = this.zzxs[i2];
                int i4 = i3 >>> 3;
                switch (i3 & 7) {
                    case 0:
                        iZzdg = zzgf.zzf(i4, ((Long) this.zzvb[i2]).longValue());
                        break;
                    case 1:
                        iZzdg = zzgf.zzh(i4, ((Long) this.zzvb[i2]).longValue());
                        break;
                    case 2:
                        iZzdg = zzgf.zzd(i4, (zzfr) this.zzvb[i2]);
                        break;
                    case 3:
                        iZzdg = ((zzjr) this.zzvb[i2]).zzdg() + (zzgf.zzas(i4) << 1);
                        break;
                    case 4:
                    default:
                        throw new IllegalStateException(zzhh.zzed());
                    case 5:
                        iZzdg = zzgf.zzl(i4, ((Integer) this.zzvb[i2]).intValue());
                        break;
                }
                i += iZzdg;
            }
            this.zzsh = i;
        }
        return i;
    }

    public final int zzgr() {
        int iZze = this.zzsh;
        if (iZze == -1) {
            iZze = 0;
            for (int i = 0; i < this.count; i++) {
                iZze += zzgf.zze(this.zzxs[i] >>> 3, (zzfr) this.zzvb[i]);
            }
            this.zzsh = iZze;
        }
        return iZze;
    }
}
