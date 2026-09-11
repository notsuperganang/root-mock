package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzbad {
    static int zza(int i, byte[] bArr, int i2, int i3, zzbae zzbaeVar) throws zzbbu {
        if ((i >>> 3) == 0) {
            throw zzbbu.zzado();
        }
        switch (i & 7) {
            case 0:
                return zzb(bArr, i2, zzbaeVar);
            case 1:
                return i2 + 8;
            case 2:
                return zza(bArr, i2, zzbaeVar) + zzbaeVar.zzdpl;
            case 3:
                int i4 = (i & (-8)) | 4;
                int i5 = 0;
                int iZza = i2;
                while (iZza < i3) {
                    iZza = zza(bArr, iZza, zzbaeVar);
                    i5 = zzbaeVar.zzdpl;
                    if (i5 == i4) {
                        if (iZza <= i3 || i5 != i4) {
                            throw zzbbu.zzadr();
                        }
                        return iZza;
                    }
                    iZza = zza(i5, bArr, iZza, i3, zzbaeVar);
                }
                if (iZza <= i3) {
                }
                throw zzbbu.zzadr();
            case 4:
            default:
                throw zzbbu.zzado();
            case 5:
                return i2 + 4;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzbbt<?> zzbbtVar, zzbae zzbaeVar) {
        zzbbp zzbbpVar = (zzbbp) zzbbtVar;
        int iZza = zza(bArr, i2, zzbaeVar);
        zzbbpVar.zzco(zzbaeVar.zzdpl);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzbaeVar);
            if (i != zzbaeVar.zzdpl) {
                break;
            }
            iZza = zza(bArr, iZza2, zzbaeVar);
            zzbbpVar.zzco(zzbaeVar.zzdpl);
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzbef zzbefVar, zzbae zzbaeVar) throws IOException {
        if ((i >>> 3) == 0) {
            throw zzbbu.zzado();
        }
        switch (i & 7) {
            case 0:
                int iZzb = zzb(bArr, i2, zzbaeVar);
                zzbefVar.zzb(i, Long.valueOf(zzbaeVar.zzdpm));
                return iZzb;
            case 1:
                zzbefVar.zzb(i, Long.valueOf(zzf(bArr, i2)));
                return i2 + 8;
            case 2:
                int iZza = zza(bArr, i2, zzbaeVar);
                int i4 = zzbaeVar.zzdpl;
                if (i4 == 0) {
                    zzbefVar.zzb(i, zzbah.zzdpq);
                } else {
                    zzbefVar.zzb(i, zzbah.zzc(bArr, iZza, i4));
                }
                return iZza + i4;
            case 3:
                zzbef zzbefVarZzagd = zzbef.zzagd();
                int i5 = (i & (-8)) | 4;
                int i6 = 0;
                int iZza2 = i2;
                while (iZza2 < i3) {
                    int iZza3 = zza(bArr, iZza2, zzbaeVar);
                    i6 = zzbaeVar.zzdpl;
                    if (i6 == i5) {
                        iZza2 = iZza3;
                        if (iZza2 <= i3 || i6 != i5) {
                            throw zzbbu.zzadr();
                        }
                        zzbefVar.zzb(i, zzbefVarZzagd);
                        return iZza2;
                    }
                    iZza2 = zza(i6, bArr, iZza3, i3, zzbefVarZzagd, zzbaeVar);
                }
                if (iZza2 <= i3) {
                }
                throw zzbbu.zzadr();
            case 4:
            default:
                throw zzbbu.zzado();
            case 5:
                zzbefVar.zzb(i, Integer.valueOf(zze(bArr, i2)));
                return i2 + 4;
        }
    }

    static int zza(int i, byte[] bArr, int i2, zzbae zzbaeVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzbaeVar.zzdpl = i3 | (b << 7);
            return i4;
        }
        int i5 = ((b & 127) << 7) | i3;
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzbaeVar.zzdpl = (b2 << 14) | i5;
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzbaeVar.zzdpl = (b3 << 21) | i7;
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzbaeVar.zzdpl = (b4 << 28) | i9;
            return i10;
        }
        while (true) {
            int i11 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzbaeVar.zzdpl = ((b4 & 127) << 28) | i9;
                return i11;
            }
            i10 = i11;
        }
    }

    static int zza(byte[] bArr, int i, zzbae zzbaeVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzbaeVar);
        }
        zzbaeVar.zzdpl = b;
        return i2;
    }

    static int zza(byte[] bArr, int i, zzbbt<?> zzbbtVar, zzbae zzbaeVar) throws IOException {
        zzbbp zzbbpVar = (zzbbp) zzbbtVar;
        int iZza = zza(bArr, i, zzbaeVar);
        int i2 = zzbaeVar.zzdpl + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzbaeVar);
            zzbbpVar.zzco(zzbaeVar.zzdpl);
        }
        if (iZza != i2) {
            throw zzbbu.zzadl();
        }
        return iZza;
    }

    static int zzb(byte[] bArr, int i, zzbae zzbaeVar) {
        int i2 = 7;
        int i3 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzbaeVar.zzdpm = j;
        } else {
            byte b = bArr[i3];
            long j2 = (j & 127) | (((long) (b & 127)) << 7);
            i3++;
            while (b < 0) {
                b = bArr[i3];
                i2 += 7;
                j2 |= ((long) (b & 127)) << i2;
                i3++;
            }
            zzbaeVar.zzdpm = j2;
        }
        return i3;
    }

    static int zzc(byte[] bArr, int i, zzbae zzbaeVar) {
        int iZza = zza(bArr, i, zzbaeVar);
        int i2 = zzbaeVar.zzdpl;
        if (i2 == 0) {
            zzbaeVar.zzdpn = "";
            return iZza;
        }
        zzbaeVar.zzdpn = new String(bArr, iZza, i2, zzbbq.UTF_8);
        return iZza + i2;
    }

    static int zzd(byte[] bArr, int i, zzbae zzbaeVar) throws IOException {
        int iZza = zza(bArr, i, zzbaeVar);
        int i2 = zzbaeVar.zzdpl;
        if (i2 == 0) {
            zzbaeVar.zzdpn = "";
            return iZza;
        }
        if (!zzbem.zzf(bArr, iZza, iZza + i2)) {
            throw zzbbu.zzads();
        }
        zzbaeVar.zzdpn = new String(bArr, iZza, i2, zzbbq.UTF_8);
        return iZza + i2;
    }

    static int zze(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    static int zze(byte[] bArr, int i, zzbae zzbaeVar) {
        int iZza = zza(bArr, i, zzbaeVar);
        int i2 = zzbaeVar.zzdpl;
        if (i2 == 0) {
            zzbaeVar.zzdpn = zzbah.zzdpq;
            return iZza;
        }
        zzbaeVar.zzdpn = zzbah.zzc(bArr, iZza, i2);
        return iZza + i2;
    }

    static long zzf(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    static double zzg(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzf(bArr, i));
    }

    static float zzh(byte[] bArr, int i) {
        return Float.intBitsToFloat(zze(bArr, i));
    }
}
