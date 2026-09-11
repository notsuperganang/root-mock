package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzbcy<T> implements zzbdm<T> {
    private static final Unsafe zzdwf = zzbek.zzagh();
    private final int[] zzdwg;
    private final Object[] zzdwh;
    private final int zzdwi;
    private final int zzdwj;
    private final int zzdwk;
    private final zzbcu zzdwl;
    private final boolean zzdwm;
    private final boolean zzdwn;
    private final boolean zzdwo;
    private final boolean zzdwp;
    private final int[] zzdwq;
    private final int[] zzdwr;
    private final int[] zzdws;
    private final zzbdc zzdwt;
    private final zzbce zzdwu;
    private final zzbee<?, ?> zzdwv;
    private final zzbbd<?> zzdww;
    private final zzbcp zzdwx;

    private zzbcy(int[] iArr, Object[] objArr, int i, int i2, int i3, zzbcu zzbcuVar, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzbdc zzbdcVar, zzbce zzbceVar, zzbee<?, ?> zzbeeVar, zzbbd<?> zzbbdVar, zzbcp zzbcpVar) {
        this.zzdwg = iArr;
        this.zzdwh = objArr;
        this.zzdwi = i;
        this.zzdwj = i2;
        this.zzdwk = i3;
        this.zzdwn = zzbcuVar instanceof zzbbo;
        this.zzdwo = z;
        this.zzdwm = zzbbdVar != null && zzbbdVar.zzh(zzbcuVar);
        this.zzdwp = false;
        this.zzdwq = iArr2;
        this.zzdwr = iArr3;
        this.zzdws = iArr4;
        this.zzdwt = zzbdcVar;
        this.zzdwu = zzbceVar;
        this.zzdwv = zzbeeVar;
        this.zzdww = zzbbdVar;
        this.zzdwl = zzbcuVar;
        this.zzdwx = zzbcpVar;
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzbae zzbaeVar) throws IOException {
        return zzbad.zza(i, bArr, i2, i3, zzz(obj), zzbaeVar);
    }

    private static int zza(zzbdm<?> zzbdmVar, int i, byte[] bArr, int i2, int i3, zzbbt<?> zzbbtVar, zzbae zzbaeVar) throws IOException {
        int iZza = zza((zzbdm) zzbdmVar, bArr, i2, i3, zzbaeVar);
        zzbbtVar.add(zzbaeVar.zzdpn);
        while (iZza < i3) {
            int iZza2 = zzbad.zza(bArr, iZza, zzbaeVar);
            if (i != zzbaeVar.zzdpl) {
                break;
            }
            iZza = zza((zzbdm) zzbdmVar, bArr, iZza2, i3, zzbaeVar);
            zzbbtVar.add(zzbaeVar.zzdpn);
        }
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzbdm zzbdmVar, byte[] bArr, int i, int i2, int i3, zzbae zzbaeVar) throws IOException {
        zzbcy zzbcyVar = (zzbcy) zzbdmVar;
        Object objNewInstance = zzbcyVar.newInstance();
        int iZza = zzbcyVar.zza(objNewInstance, bArr, i, i2, i3, zzbaeVar);
        zzbcyVar.zzo(objNewInstance);
        zzbaeVar.zzdpn = objNewInstance;
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzbdm zzbdmVar, byte[] bArr, int i, int i2, zzbae zzbaeVar) throws IOException {
        int i3;
        int iZza = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            iZza = zzbad.zza(i4, bArr, iZza, zzbaeVar);
            i3 = zzbaeVar.zzdpl;
        } else {
            i3 = i4;
        }
        if (i3 < 0 || i3 > i2 - iZza) {
            throw zzbbu.zzadl();
        }
        Object objNewInstance = zzbdmVar.newInstance();
        zzbdmVar.zza(objNewInstance, bArr, iZza, iZza + i3, zzbaeVar);
        zzbdmVar.zzo(objNewInstance);
        zzbaeVar.zzdpn = objNewInstance;
        return iZza + i3;
    }

    private static <UT, UB> int zza(zzbee<UT, UB> zzbeeVar, T t) {
        return zzbeeVar.zzy(zzbeeVar.zzac(t));
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzbae zzbaeVar) throws IOException {
        int iZza;
        Unsafe unsafe = zzdwf;
        long j2 = this.zzdwg[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(zzbad.zzg(bArr, i)));
                iZza = i + 8;
                break;
                break;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(zzbad.zzh(bArr, i)));
                iZza = i + 4;
                break;
                break;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iZza = zzbad.zzb(bArr, i, zzbaeVar);
                unsafe.putObject(t, j, Long.valueOf(zzbaeVar.zzdpm));
                break;
                break;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iZza = zzbad.zza(bArr, i, zzbaeVar);
                unsafe.putObject(t, j, Integer.valueOf(zzbaeVar.zzdpl));
                break;
                break;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(zzbad.zzf(bArr, i)));
                iZza = i + 8;
                break;
                break;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(zzbad.zze(bArr, i)));
                iZza = i + 4;
                break;
                break;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iZza = zzbad.zzb(bArr, i, zzbaeVar);
                unsafe.putObject(t, j, Boolean.valueOf(zzbaeVar.zzdpm != 0));
                break;
                break;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZza2 = zzbad.zza(bArr, i, zzbaeVar);
                int i9 = zzbaeVar.zzdpl;
                if (i9 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((536870912 & i6) != 0 && !zzbem.zzf(bArr, iZza2, iZza2 + i9)) {
                        throw zzbbu.zzads();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZza2, i9, zzbbq.UTF_8));
                    iZza2 += i9;
                }
                unsafe.putInt(t, j2, i4);
                return iZza2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZza3 = zza(zzcq(i8), bArr, i, i2, zzbaeVar);
                Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, zzbaeVar.zzdpn);
                } else {
                    unsafe.putObject(t, j, zzbbq.zza(object, zzbaeVar.zzdpn));
                }
                unsafe.putInt(t, j2, i4);
                return iZza3;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza4 = zzbad.zza(bArr, i, zzbaeVar);
                int i10 = zzbaeVar.zzdpl;
                if (i10 == 0) {
                    unsafe.putObject(t, j, zzbah.zzdpq);
                } else {
                    unsafe.putObject(t, j, zzbah.zzc(bArr, iZza4, i10));
                    iZza4 += i10;
                }
                unsafe.putInt(t, j2, i4);
                return iZza4;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                iZza = zzbad.zza(bArr, i, zzbaeVar);
                int i11 = zzbaeVar.zzdpl;
                zzbbs<?> zzbbsVarZzcs = zzcs(i8);
                if (zzbbsVarZzcs != null && zzbbsVarZzcs.zzq(i11) == null) {
                    zzz(t).zzb(i3, Long.valueOf(i11));
                    return iZza;
                }
                unsafe.putObject(t, j, Integer.valueOf(i11));
                break;
                break;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iZza = zzbad.zza(bArr, i, zzbaeVar);
                unsafe.putObject(t, j, Integer.valueOf(zzbaq.zzbu(zzbaeVar.zzdpl)));
                break;
                break;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iZza = zzbad.zzb(bArr, i, zzbaeVar);
                unsafe.putObject(t, j, Long.valueOf(zzbaq.zzl(zzbaeVar.zzdpm)));
                break;
                break;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                iZza = zza(zzcq(i8), bArr, i, i2, (i3 & (-8)) | 4, zzbaeVar);
                Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object2 != null) {
                    unsafe.putObject(t, j, zzbbq.zza(object2, zzbaeVar.zzdpn));
                } else {
                    unsafe.putObject(t, j, zzbaeVar.zzdpn);
                }
                break;
                break;
            default:
                return i;
        }
        unsafe.putInt(t, j2, i4);
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzbae zzbaeVar) throws IOException {
        zzbbt zzbbtVarZzbm;
        int iZza;
        zzbbt zzbbtVar = (zzbbt) zzdwf.getObject(t, j2);
        if (zzbbtVar.zzaay()) {
            zzbbtVarZzbm = zzbbtVar;
        } else {
            int size = zzbbtVar.size();
            zzbbtVarZzbm = zzbbtVar.zzbm(size == 0 ? 10 : size << 1);
            zzdwf.putObject(t, j2, zzbbtVarZzbm);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzbay zzbayVar = (zzbay) zzbbtVarZzbm;
                    int iZza2 = zzbad.zza(bArr, i, zzbaeVar);
                    int i8 = zzbaeVar.zzdpl + iZza2;
                    while (iZza2 < i8) {
                        zzbayVar.zzd(zzbad.zzg(bArr, iZza2));
                        iZza2 += 8;
                    }
                    if (iZza2 != i8) {
                        throw zzbbu.zzadl();
                    }
                    return iZza2;
                }
                if (i5 != 1) {
                    return i;
                }
                zzbay zzbayVar2 = (zzbay) zzbbtVarZzbm;
                zzbayVar2.zzd(zzbad.zzg(bArr, i));
                int i9 = i + 8;
                while (i9 < i2) {
                    int iZza3 = zzbad.zza(bArr, i9, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return i9;
                    }
                    zzbayVar2.zzd(zzbad.zzg(bArr, iZza3));
                    i9 = iZza3 + 8;
                }
                return i9;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzbbm zzbbmVar = (zzbbm) zzbbtVarZzbm;
                    int iZza4 = zzbad.zza(bArr, i, zzbaeVar);
                    int i10 = zzbaeVar.zzdpl + iZza4;
                    while (iZza4 < i10) {
                        zzbbmVar.zzd(zzbad.zzh(bArr, iZza4));
                        iZza4 += 4;
                    }
                    if (iZza4 != i10) {
                        throw zzbbu.zzadl();
                    }
                    return iZza4;
                }
                if (i5 != 5) {
                    return i;
                }
                zzbbm zzbbmVar2 = (zzbbm) zzbbtVarZzbm;
                zzbbmVar2.zzd(zzbad.zzh(bArr, i));
                int i11 = i + 4;
                while (i11 < i2) {
                    int iZza5 = zzbad.zza(bArr, i11, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return i11;
                    }
                    zzbbmVar2.zzd(zzbad.zzh(bArr, iZza5));
                    i11 = iZza5 + 4;
                }
                return i11;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzbci zzbciVar = (zzbci) zzbbtVarZzbm;
                    int iZza6 = zzbad.zza(bArr, i, zzbaeVar);
                    int i12 = zzbaeVar.zzdpl + iZza6;
                    while (iZza6 < i12) {
                        iZza6 = zzbad.zzb(bArr, iZza6, zzbaeVar);
                        zzbciVar.zzw(zzbaeVar.zzdpm);
                    }
                    if (iZza6 != i12) {
                        throw zzbbu.zzadl();
                    }
                    return iZza6;
                }
                if (i5 != 0) {
                    return i;
                }
                zzbci zzbciVar2 = (zzbci) zzbbtVarZzbm;
                int iZzb = zzbad.zzb(bArr, i, zzbaeVar);
                zzbciVar2.zzw(zzbaeVar.zzdpm);
                while (iZzb < i2) {
                    int iZza7 = zzbad.zza(bArr, iZzb, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return iZzb;
                    }
                    iZzb = zzbad.zzb(bArr, iZza7, zzbaeVar);
                    zzbciVar2.zzw(zzbaeVar.zzdpm);
                }
                return iZzb;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzbad.zza(bArr, i, (zzbbt<?>) zzbbtVarZzbm, zzbaeVar);
                }
                return i5 == 0 ? zzbad.zza(i3, bArr, i, i2, (zzbbt<?>) zzbbtVarZzbm, zzbaeVar) : i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzbci zzbciVar3 = (zzbci) zzbbtVarZzbm;
                    int iZza8 = zzbad.zza(bArr, i, zzbaeVar);
                    int i13 = zzbaeVar.zzdpl + iZza8;
                    while (iZza8 < i13) {
                        zzbciVar3.zzw(zzbad.zzf(bArr, iZza8));
                        iZza8 += 8;
                    }
                    if (iZza8 != i13) {
                        throw zzbbu.zzadl();
                    }
                    return iZza8;
                }
                if (i5 != 1) {
                    return i;
                }
                zzbci zzbciVar4 = (zzbci) zzbbtVarZzbm;
                zzbciVar4.zzw(zzbad.zzf(bArr, i));
                int i14 = i + 8;
                while (i14 < i2) {
                    int iZza9 = zzbad.zza(bArr, i14, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return i14;
                    }
                    zzbciVar4.zzw(zzbad.zzf(bArr, iZza9));
                    i14 = iZza9 + 8;
                }
                return i14;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzbbp zzbbpVar = (zzbbp) zzbbtVarZzbm;
                    int iZza10 = zzbad.zza(bArr, i, zzbaeVar);
                    int i15 = zzbaeVar.zzdpl + iZza10;
                    while (iZza10 < i15) {
                        zzbbpVar.zzco(zzbad.zze(bArr, iZza10));
                        iZza10 += 4;
                    }
                    if (iZza10 != i15) {
                        throw zzbbu.zzadl();
                    }
                    return iZza10;
                }
                if (i5 != 5) {
                    return i;
                }
                zzbbp zzbbpVar2 = (zzbbp) zzbbtVarZzbm;
                zzbbpVar2.zzco(zzbad.zze(bArr, i));
                int i16 = i + 4;
                while (i16 < i2) {
                    int iZza11 = zzbad.zza(bArr, i16, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return i16;
                    }
                    zzbbpVar2.zzco(zzbad.zze(bArr, iZza11));
                    i16 = iZza11 + 4;
                }
                return i16;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzbaf zzbafVar = (zzbaf) zzbbtVarZzbm;
                    int iZza12 = zzbad.zza(bArr, i, zzbaeVar);
                    int i17 = iZza12 + zzbaeVar.zzdpl;
                    while (iZza12 < i17) {
                        iZza12 = zzbad.zzb(bArr, iZza12, zzbaeVar);
                        zzbafVar.addBoolean(zzbaeVar.zzdpm != 0);
                    }
                    if (iZza12 != i17) {
                        throw zzbbu.zzadl();
                    }
                    return iZza12;
                }
                if (i5 != 0) {
                    return i;
                }
                zzbaf zzbafVar2 = (zzbaf) zzbbtVarZzbm;
                int iZzb2 = zzbad.zzb(bArr, i, zzbaeVar);
                zzbafVar2.addBoolean(zzbaeVar.zzdpm != 0);
                while (iZzb2 < i2) {
                    int iZza13 = zzbad.zza(bArr, iZzb2, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return iZzb2;
                    }
                    iZzb2 = zzbad.zzb(bArr, iZza13, zzbaeVar);
                    zzbafVar2.addBoolean(zzbaeVar.zzdpm != 0);
                }
                return iZzb2;
            case 26:
                if (i5 != 2) {
                    return i;
                }
                if ((536870912 & j) == 0) {
                    int iZza14 = zzbad.zza(bArr, i, zzbaeVar);
                    int i18 = zzbaeVar.zzdpl;
                    if (i18 == 0) {
                        zzbbtVarZzbm.add("");
                    } else {
                        zzbbtVarZzbm.add(new String(bArr, iZza14, i18, zzbbq.UTF_8));
                        iZza14 += i18;
                    }
                    while (iZza14 < i2) {
                        int iZza15 = zzbad.zza(bArr, iZza14, zzbaeVar);
                        if (i3 != zzbaeVar.zzdpl) {
                            return iZza14;
                        }
                        iZza14 = zzbad.zza(bArr, iZza15, zzbaeVar);
                        int i19 = zzbaeVar.zzdpl;
                        if (i19 == 0) {
                            zzbbtVarZzbm.add("");
                        } else {
                            zzbbtVarZzbm.add(new String(bArr, iZza14, i19, zzbbq.UTF_8));
                            iZza14 += i19;
                        }
                    }
                    return iZza14;
                }
                int iZza16 = zzbad.zza(bArr, i, zzbaeVar);
                int i20 = zzbaeVar.zzdpl;
                if (i20 == 0) {
                    zzbbtVarZzbm.add("");
                } else {
                    if (!zzbem.zzf(bArr, iZza16, iZza16 + i20)) {
                        throw zzbbu.zzads();
                    }
                    zzbbtVarZzbm.add(new String(bArr, iZza16, i20, zzbbq.UTF_8));
                    iZza16 += i20;
                }
                while (iZza16 < i2) {
                    int iZza17 = zzbad.zza(bArr, iZza16, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return iZza16;
                    }
                    iZza16 = zzbad.zza(bArr, iZza17, zzbaeVar);
                    int i21 = zzbaeVar.zzdpl;
                    if (i21 == 0) {
                        zzbbtVarZzbm.add("");
                    } else {
                        if (!zzbem.zzf(bArr, iZza16, iZza16 + i21)) {
                            throw zzbbu.zzads();
                        }
                        zzbbtVarZzbm.add(new String(bArr, iZza16, i21, zzbbq.UTF_8));
                        iZza16 += i21;
                    }
                }
                return iZza16;
            case 27:
                return i5 == 2 ? zza((zzbdm<?>) zzcq(i6), i3, bArr, i, i2, (zzbbt<?>) zzbbtVarZzbm, zzbaeVar) : i;
            case 28:
                if (i5 != 2) {
                    return i;
                }
                int iZza18 = zzbad.zza(bArr, i, zzbaeVar);
                int i22 = zzbaeVar.zzdpl;
                if (i22 == 0) {
                    zzbbtVarZzbm.add(zzbah.zzdpq);
                } else {
                    zzbbtVarZzbm.add(zzbah.zzc(bArr, iZza18, i22));
                    iZza18 += i22;
                }
                while (iZza18 < i2) {
                    int iZza19 = zzbad.zza(bArr, iZza18, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return iZza18;
                    }
                    iZza18 = zzbad.zza(bArr, iZza19, zzbaeVar);
                    int i23 = zzbaeVar.zzdpl;
                    if (i23 == 0) {
                        zzbbtVarZzbm.add(zzbah.zzdpq);
                    } else {
                        zzbbtVarZzbm.add(zzbah.zzc(bArr, iZza18, i23));
                        iZza18 += i23;
                    }
                }
                return iZza18;
            case 30:
            case 44:
                if (i5 == 2) {
                    iZza = zzbad.zza(bArr, i, (zzbbt<?>) zzbbtVarZzbm, zzbaeVar);
                } else {
                    if (i5 != 0) {
                        return i;
                    }
                    iZza = zzbad.zza(i3, bArr, i, i2, (zzbbt<?>) zzbbtVarZzbm, zzbaeVar);
                }
                zzbef zzbefVar = ((zzbbo) t).zzdtt;
                if (zzbefVar == zzbef.zzagc()) {
                    zzbefVar = null;
                }
                zzbef zzbefVar2 = (zzbef) zzbdo.zza(i4, zzbbtVarZzbm, zzcs(i6), zzbefVar, this.zzdwv);
                if (zzbefVar2 == null) {
                    return iZza;
                }
                ((zzbbo) t).zzdtt = zzbefVar2;
                return iZza;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzbbp zzbbpVar3 = (zzbbp) zzbbtVarZzbm;
                    int iZza20 = zzbad.zza(bArr, i, zzbaeVar);
                    int i24 = zzbaeVar.zzdpl + iZza20;
                    while (iZza20 < i24) {
                        iZza20 = zzbad.zza(bArr, iZza20, zzbaeVar);
                        zzbbpVar3.zzco(zzbaq.zzbu(zzbaeVar.zzdpl));
                    }
                    if (iZza20 != i24) {
                        throw zzbbu.zzadl();
                    }
                    return iZza20;
                }
                if (i5 != 0) {
                    return i;
                }
                zzbbp zzbbpVar4 = (zzbbp) zzbbtVarZzbm;
                int iZza21 = zzbad.zza(bArr, i, zzbaeVar);
                zzbbpVar4.zzco(zzbaq.zzbu(zzbaeVar.zzdpl));
                while (iZza21 < i2) {
                    int iZza22 = zzbad.zza(bArr, iZza21, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return iZza21;
                    }
                    iZza21 = zzbad.zza(bArr, iZza22, zzbaeVar);
                    zzbbpVar4.zzco(zzbaq.zzbu(zzbaeVar.zzdpl));
                }
                return iZza21;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzbci zzbciVar5 = (zzbci) zzbbtVarZzbm;
                    int iZza23 = zzbad.zza(bArr, i, zzbaeVar);
                    int i25 = zzbaeVar.zzdpl + iZza23;
                    while (iZza23 < i25) {
                        iZza23 = zzbad.zzb(bArr, iZza23, zzbaeVar);
                        zzbciVar5.zzw(zzbaq.zzl(zzbaeVar.zzdpm));
                    }
                    if (iZza23 != i25) {
                        throw zzbbu.zzadl();
                    }
                    return iZza23;
                }
                if (i5 != 0) {
                    return i;
                }
                zzbci zzbciVar6 = (zzbci) zzbbtVarZzbm;
                int iZzb3 = zzbad.zzb(bArr, i, zzbaeVar);
                zzbciVar6.zzw(zzbaq.zzl(zzbaeVar.zzdpm));
                while (iZzb3 < i2) {
                    int iZza24 = zzbad.zza(bArr, iZzb3, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return iZzb3;
                    }
                    iZzb3 = zzbad.zzb(bArr, iZza24, zzbaeVar);
                    zzbciVar6.zzw(zzbaq.zzl(zzbaeVar.zzdpm));
                }
                return iZzb3;
            case 49:
                if (i5 != 3) {
                    return i;
                }
                zzbdm zzbdmVarZzcq = zzcq(i6);
                int i26 = (i3 & (-8)) | 4;
                int iZza25 = zza(zzbdmVarZzcq, bArr, i, i2, i26, zzbaeVar);
                zzbbtVarZzbm.add(zzbaeVar.zzdpn);
                while (iZza25 < i2) {
                    int iZza26 = zzbad.zza(bArr, iZza25, zzbaeVar);
                    if (i3 != zzbaeVar.zzdpl) {
                        return iZza25;
                    }
                    iZza25 = zza(zzbdmVarZzcq, bArr, iZza26, i2, i26, zzbaeVar);
                    zzbbtVarZzbm.add(zzbaeVar.zzdpn);
                }
                return iZza25;
            default:
                return i;
        }
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, long j, zzbae zzbaeVar) throws IOException {
        Object objZzw;
        Unsafe unsafe = zzdwf;
        Object objZzcr = zzcr(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzdwx.zzu(object)) {
            objZzw = this.zzdwx.zzw(objZzcr);
            this.zzdwx.zzb(objZzw, object);
            unsafe.putObject(t, j, objZzw);
        } else {
            objZzw = object;
        }
        zzbcn<?, ?> zzbcnVarZzx = this.zzdwx.zzx(objZzcr);
        Map<?, ?> mapZzs = this.zzdwx.zzs(objZzw);
        int iZza = zzbad.zza(bArr, i, zzbaeVar);
        int i5 = zzbaeVar.zzdpl;
        if (i5 < 0 || i5 > i2 - iZza) {
            throw zzbbu.zzadl();
        }
        int i6 = iZza + i5;
        K k = zzbcnVarZzx.zzdvz;
        Object obj = zzbcnVarZzx.zzdwb;
        int iZza2 = iZza;
        Object obj2 = k;
        while (iZza2 < i6) {
            int iZza3 = iZza2 + 1;
            int i7 = bArr[iZza2];
            if (i7 < 0) {
                iZza3 = zzbad.zza(i7, bArr, iZza3, zzbaeVar);
                i7 = zzbaeVar.zzdpl;
            }
            int i8 = i7 & 7;
            switch (i7 >>> 3) {
                case 1:
                    if (i8 != zzbcnVarZzx.zzdvy.zzagm()) {
                        iZza2 = zzbad.zza(i7, bArr, iZza3, i2, zzbaeVar);
                    } else {
                        iZza2 = zza(bArr, iZza3, i2, zzbcnVarZzx.zzdvy, (Class<?>) null, zzbaeVar);
                        obj2 = zzbaeVar.zzdpn;
                    }
                    break;
                case 2:
                    if (i8 != zzbcnVarZzx.zzdwa.zzagm()) {
                        iZza2 = zzbad.zza(i7, bArr, iZza3, i2, zzbaeVar);
                    } else {
                        int iZza4 = zza(bArr, iZza3, i2, zzbcnVarZzx.zzdwa, zzbcnVarZzx.zzdwb.getClass(), zzbaeVar);
                        obj = zzbaeVar.zzdpn;
                        iZza2 = iZza4;
                    }
                    break;
                default:
                    iZza2 = zzbad.zza(i7, bArr, iZza3, i2, zzbaeVar);
                    break;
            }
        }
        if (iZza2 != i6) {
            throw zzbbu.zzadr();
        }
        mapZzs.put(obj2, obj);
        return i6;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x008b A[ADDED_TO_REGION] */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x007e. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, zzbae zzbaeVar) throws IOException {
        int i4;
        int i5;
        int i6;
        zzbbt zzbbtVarZzbm;
        Unsafe unsafe = zzdwf;
        int i7 = 0;
        int i8 = 0;
        int iZza = i;
        int i9 = -1;
        while (true) {
            if (iZza < i2) {
                int iZza2 = iZza + 1;
                i8 = bArr[iZza];
                if (i8 < 0) {
                    iZza2 = zzbad.zza(i8, bArr, iZza2, zzbaeVar);
                    i8 = zzbaeVar.zzdpl;
                }
                int i10 = (i8 == true ? 1 : 0) >>> 3;
                int i11 = (i8 == true ? 1 : 0) & 7;
                int iZzcw = zzcw(i10);
                if (iZzcw != -1) {
                    int i12 = this.zzdwg[iZzcw + 1];
                    int i13 = (267386880 & i12) >>> 20;
                    long j = 1048575 & i12;
                    if (i13 <= 17) {
                        int i14 = this.zzdwg[iZzcw + 2];
                        int i15 = 1 << (i14 >>> 20);
                        int i16 = i14 & 1048575;
                        if (i16 != i9) {
                            if (i9 != -1) {
                                unsafe.putInt(t, i9, i7);
                            }
                            i6 = unsafe.getInt(t, i16);
                        } else {
                            i6 = i7;
                            i16 = i9;
                        }
                        switch (i13) {
                            case 0:
                                if (i11 != 1) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3 || i3 == 0) {
                                        iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                        i9 = i5;
                                        i7 = i4;
                                    }
                                } else {
                                    zzbek.zza(t, j, zzbad.zzg(bArr, iZza2));
                                    iZza = iZza2 + 8;
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 1:
                                if (i11 != 5) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    zzbek.zza((Object) t, j, zzbad.zzh(bArr, iZza2));
                                    iZza = iZza2 + 4;
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 2:
                            case 3:
                                if (i11 != 0) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    iZza = zzbad.zzb(bArr, iZza2, zzbaeVar);
                                    unsafe.putLong(t, j, zzbaeVar.zzdpm);
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 4:
                            case 11:
                                if (i11 != 0) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    iZza = zzbad.zza(bArr, iZza2, zzbaeVar);
                                    unsafe.putInt(t, j, zzbaeVar.zzdpl);
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 5:
                            case 14:
                                if (i11 != 1) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    unsafe.putLong(t, j, zzbad.zzf(bArr, iZza2));
                                    iZza = iZza2 + 8;
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 6:
                            case 13:
                                if (i11 != 5) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    unsafe.putInt(t, j, zzbad.zze(bArr, iZza2));
                                    iZza = iZza2 + 4;
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 7:
                                if (i11 != 0) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    iZza = zzbad.zzb(bArr, iZza2, zzbaeVar);
                                    zzbek.zza(t, j, zzbaeVar.zzdpm != 0);
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 8:
                                if (i11 != 2) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    int iZzc = (536870912 & i12) == 0 ? zzbad.zzc(bArr, iZza2, zzbaeVar) : zzbad.zzd(bArr, iZza2, zzbaeVar);
                                    unsafe.putObject(t, j, zzbaeVar.zzdpn);
                                    i7 = i6 | i15;
                                    iZza = iZzc;
                                    i9 = i16;
                                }
                                break;
                            case 9:
                                if (i11 != 2) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    iZza = zza(zzcq(iZzcw), bArr, iZza2, i2, zzbaeVar);
                                    if ((i6 & i15) == 0) {
                                        unsafe.putObject(t, j, zzbaeVar.zzdpn);
                                    } else {
                                        unsafe.putObject(t, j, zzbbq.zza(unsafe.getObject(t, j), zzbaeVar.zzdpn));
                                    }
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 10:
                                if (i11 != 2) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    iZza = zzbad.zze(bArr, iZza2, zzbaeVar);
                                    unsafe.putObject(t, j, zzbaeVar.zzdpn);
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 12:
                                if (i11 != 0) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    iZza = zzbad.zza(bArr, iZza2, zzbaeVar);
                                    int i17 = zzbaeVar.zzdpl;
                                    zzbbs<?> zzbbsVarZzcs = zzcs(iZzcw);
                                    if (zzbbsVarZzcs != null && zzbbsVarZzcs.zzq(i17) == null) {
                                        zzz(t).zzb((i8 == true ? 1 : 0) == true ? 1 : 0, Long.valueOf(i17));
                                        i9 = i16;
                                        i7 = i6;
                                    } else {
                                        unsafe.putInt(t, j, i17);
                                        i7 = i6 | i15;
                                        i9 = i16;
                                    }
                                }
                                break;
                            case 15:
                                if (i11 != 0) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    iZza = zzbad.zza(bArr, iZza2, zzbaeVar);
                                    unsafe.putInt(t, j, zzbaq.zzbu(zzbaeVar.zzdpl));
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 16:
                                if (i11 != 0) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    iZza = zzbad.zzb(bArr, iZza2, zzbaeVar);
                                    unsafe.putLong(t, j, zzbaq.zzl(zzbaeVar.zzdpm));
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            case 17:
                                if (i11 != 3) {
                                    i5 = i16;
                                    iZza = iZza2;
                                    i4 = i6;
                                    if ((i8 == true ? 1 : 0) == i3) {
                                    }
                                    iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                    i9 = i5;
                                    i7 = i4;
                                } else {
                                    iZza = zza(zzcq(iZzcw), bArr, iZza2, i2, (i10 << 3) | 4, zzbaeVar);
                                    if ((i6 & i15) == 0) {
                                        unsafe.putObject(t, j, zzbaeVar.zzdpn);
                                    } else {
                                        unsafe.putObject(t, j, zzbbq.zza(unsafe.getObject(t, j), zzbaeVar.zzdpn));
                                    }
                                    i7 = i6 | i15;
                                    i9 = i16;
                                }
                                break;
                            default:
                                i5 = i16;
                                iZza = iZza2;
                                i4 = i6;
                                if ((i8 == true ? 1 : 0) == i3) {
                                }
                                iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                                i9 = i5;
                                i7 = i4;
                                break;
                        }
                    } else if (i13 == 27) {
                        if (i11 == 2) {
                            zzbbt zzbbtVar = (zzbbt) unsafe.getObject(t, j);
                            if (zzbbtVar.zzaay()) {
                                zzbbtVarZzbm = zzbbtVar;
                            } else {
                                int size = zzbbtVar.size();
                                zzbbtVarZzbm = zzbbtVar.zzbm(size == 0 ? 10 : size << 1);
                                unsafe.putObject(t, j, zzbbtVarZzbm);
                            }
                            iZza = zza((zzbdm<?>) zzcq(iZzcw), (i8 == true ? 1 : 0) == true ? 1 : 0, bArr, iZza2, i2, (zzbbt<?>) zzbbtVarZzbm, zzbaeVar);
                        }
                    } else if (i13 <= 49) {
                        iZza = zza(t, bArr, iZza2, i2, i8 == true ? 1 : 0, i10, i11, iZzcw, i12, i13, j, zzbaeVar);
                        if (iZza == iZza2) {
                            i5 = i9;
                            i4 = i7;
                            if ((i8 == true ? 1 : 0) == i3) {
                            }
                            iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                            i9 = i5;
                            i7 = i4;
                        } else {
                            continue;
                        }
                    } else if (i13 != 50) {
                        iZza = zza(t, bArr, iZza2, i2, (i8 == true ? 1 : 0) == true ? 1 : 0, i10, i11, i12, i13, j, iZzcw, zzbaeVar);
                        if (iZza == iZza2) {
                            i5 = i9;
                            i4 = i7;
                            if ((i8 == true ? 1 : 0) == i3) {
                            }
                            iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                            i9 = i5;
                            i7 = i4;
                        } else {
                            continue;
                        }
                    } else if (i11 == 2) {
                        iZza = zza(t, bArr, iZza2, i2, iZzcw, i10, j, zzbaeVar);
                        if (iZza == iZza2) {
                            i5 = i9;
                            i4 = i7;
                            if ((i8 == true ? 1 : 0) == i3) {
                            }
                            iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                            i9 = i5;
                            i7 = i4;
                        } else {
                            continue;
                        }
                    }
                }
                i5 = i9;
                iZza = iZza2;
                i4 = i7;
                if ((i8 == true ? 1 : 0) == i3) {
                }
                iZza = zza(i8 == true ? 1 : 0, bArr, iZza, i2, t, zzbaeVar);
                i9 = i5;
                i7 = i4;
            } else {
                i4 = i7;
                i5 = i9;
            }
        }
        if (i5 != -1) {
            unsafe.putInt(t, i5, i4);
        }
        if (this.zzdwr != null) {
            zzbef zzbefVar = null;
            int[] iArr = this.zzdwr;
            int length = iArr.length;
            int i18 = 0;
            while (i18 < length) {
                zzbef zzbefVar2 = (zzbef) zza(t, iArr[i18], zzbefVar, (zzbee<UT, zzbef>) this.zzdwv);
                i18++;
                zzbefVar = zzbefVar2;
            }
            if (zzbefVar != null) {
                this.zzdwv.zzf(t, zzbefVar);
            }
        }
        if (i3 == 0) {
            if (iZza != i2) {
                throw zzbbu.zzadr();
            }
        } else if (iZza > i2 || i8 != i3) {
            throw zzbbu.zzadr();
        }
        return iZza;
    }

    private static int zza(byte[] bArr, int i, int i2, zzbes zzbesVar, Class<?> cls, zzbae zzbaeVar) throws IOException {
        switch (zzbcz.zzdql[zzbesVar.ordinal()]) {
            case 1:
                int iZzb = zzbad.zzb(bArr, i, zzbaeVar);
                zzbaeVar.zzdpn = Boolean.valueOf(zzbaeVar.zzdpm != 0);
                return iZzb;
            case 2:
                return zzbad.zze(bArr, i, zzbaeVar);
            case 3:
                zzbaeVar.zzdpn = Double.valueOf(zzbad.zzg(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzbaeVar.zzdpn = Integer.valueOf(zzbad.zze(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzbaeVar.zzdpn = Long.valueOf(zzbad.zzf(bArr, i));
                return i + 8;
            case 8:
                zzbaeVar.zzdpn = Float.valueOf(zzbad.zzh(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZza = zzbad.zza(bArr, i, zzbaeVar);
                zzbaeVar.zzdpn = Integer.valueOf(zzbaeVar.zzdpl);
                return iZza;
            case 12:
            case 13:
                int iZzb2 = zzbad.zzb(bArr, i, zzbaeVar);
                zzbaeVar.zzdpn = Long.valueOf(zzbaeVar.zzdpm);
                return iZzb2;
            case 14:
                return zza((zzbdm) zzbdg.zzaeo().zze(cls), bArr, i, i2, zzbaeVar);
            case 15:
                int iZza2 = zzbad.zza(bArr, i, zzbaeVar);
                zzbaeVar.zzdpn = Integer.valueOf(zzbaq.zzbu(zzbaeVar.zzdpl));
                return iZza2;
            case 16:
                int iZzb3 = zzbad.zzb(bArr, i, zzbaeVar);
                zzbaeVar.zzdpn = Long.valueOf(zzbaq.zzl(zzbaeVar.zzdpm));
                return iZzb3;
            case 17:
                return zzbad.zzd(bArr, i, zzbaeVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    static <T> zzbcy<T> zza(Class<T> cls, zzbcs zzbcsVar, zzbdc zzbdcVar, zzbce zzbceVar, zzbee<?, ?> zzbeeVar, zzbbd<?> zzbbdVar, zzbcp zzbcpVar) {
        int iZzaer;
        int iZzaes;
        int iZzaew;
        int iZza;
        int iZza2;
        int iZzafh;
        if (!(zzbcsVar instanceof zzbdi)) {
            ((zzbdz) zzbcsVar).zzaeh();
            throw new NoSuchMethodError();
        }
        zzbdi zzbdiVar = (zzbdi) zzbcsVar;
        boolean z = zzbdiVar.zzaeh() == zzbbo.zze.zzduj;
        if (zzbdiVar.getFieldCount() == 0) {
            iZzaer = 0;
            iZzaes = 0;
            iZzaew = 0;
        } else {
            iZzaer = zzbdiVar.zzaer();
            iZzaes = zzbdiVar.zzaes();
            iZzaew = zzbdiVar.zzaew();
        }
        int[] iArr = new int[iZzaew << 2];
        Object[] objArr = new Object[iZzaew << 1];
        int[] iArr2 = zzbdiVar.zzaet() > 0 ? new int[zzbdiVar.zzaet()] : null;
        int[] iArr3 = zzbdiVar.zzaeu() > 0 ? new int[zzbdiVar.zzaeu()] : null;
        int i = 0;
        int i2 = 0;
        zzbdj zzbdjVarZzaeq = zzbdiVar.zzaeq();
        if (zzbdjVarZzaeq.next()) {
            int iZzaci = zzbdjVarZzaeq.zzaci();
            int i3 = 0;
            while (true) {
                if (iZzaci >= zzbdiVar.zzaex() || i3 >= ((iZzaci - iZzaer) << 2)) {
                    if (zzbdjVarZzaeq.zzafb()) {
                        iZza = (int) zzbek.zza(zzbdjVarZzaeq.zzafc());
                        iZza2 = (int) zzbek.zza(zzbdjVarZzaeq.zzafd());
                        iZzafh = 0;
                    } else {
                        iZza = (int) zzbek.zza(zzbdjVarZzaeq.zzafe());
                        if (zzbdjVarZzaeq.zzaff()) {
                            iZza2 = (int) zzbek.zza(zzbdjVarZzaeq.zzafg());
                            iZzafh = zzbdjVarZzaeq.zzafh();
                        } else {
                            iZza2 = 0;
                            iZzafh = 0;
                        }
                    }
                    iArr[i3] = zzbdjVarZzaeq.zzaci();
                    iArr[i3 + 1] = iZza | (zzbdjVarZzaeq.zzafj() ? 536870912 : 0) | (zzbdjVarZzaeq.zzafi() ? 268435456 : 0) | (zzbdjVarZzaeq.zzaez() << 20);
                    iArr[i3 + 2] = (iZzafh << 20) | iZza2;
                    if (zzbdjVarZzaeq.zzafm() != null) {
                        objArr[(i3 / 4) << 1] = zzbdjVarZzaeq.zzafm();
                        if (zzbdjVarZzaeq.zzafk() != null) {
                            objArr[((i3 / 4) << 1) + 1] = zzbdjVarZzaeq.zzafk();
                        } else if (zzbdjVarZzaeq.zzafl() != null) {
                            objArr[((i3 / 4) << 1) + 1] = zzbdjVarZzaeq.zzafl();
                        }
                    } else if (zzbdjVarZzaeq.zzafk() != null) {
                        objArr[((i3 / 4) << 1) + 1] = zzbdjVarZzaeq.zzafk();
                    } else if (zzbdjVarZzaeq.zzafl() != null) {
                        objArr[((i3 / 4) << 1) + 1] = zzbdjVarZzaeq.zzafl();
                    }
                    int iZzaez = zzbdjVarZzaeq.zzaez();
                    if (iZzaez == zzbbj.MAP.ordinal()) {
                        iArr2[i] = i3;
                        i++;
                    } else if (iZzaez >= 18 && iZzaez <= 49) {
                        iArr3[i2] = iArr[i3 + 1] & 1048575;
                        i2++;
                    }
                    if (!zzbdjVarZzaeq.next()) {
                        break;
                    }
                    iZzaci = zzbdjVarZzaeq.zzaci();
                } else {
                    for (int i4 = 0; i4 < 4; i4++) {
                        iArr[i3 + i4] = -1;
                    }
                }
                i3 += 4;
            }
        }
        return new zzbcy<>(iArr, objArr, iZzaer, iZzaes, zzbdiVar.zzaex(), zzbdiVar.zzaej(), z, false, zzbdiVar.zzaev(), iArr2, iArr3, zzbdcVar, zzbceVar, zzbeeVar, zzbbdVar, zzbcpVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzbbs<?> zzbbsVar, UB ub, zzbee<UT, UB> zzbeeVar) {
        zzbcn<?, ?> zzbcnVarZzx = this.zzdwx.zzx(zzcr(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        UB ub2 = ub;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (zzbbsVar.zzq(((Integer) next.getValue()).intValue()) == null) {
                UB ubZzagb = ub2 == null ? zzbeeVar.zzagb() : ub2;
                zzbam zzbamVarZzbo = zzbah.zzbo(zzbcm.zza(zzbcnVarZzx, next.getKey(), next.getValue()));
                try {
                    zzbcm.zza(zzbamVarZzbo.zzabj(), zzbcnVarZzx, next.getKey(), next.getValue());
                    zzbeeVar.zza(ubZzagb, i2, zzbamVarZzbo.zzabi());
                    it.remove();
                    ub2 = ubZzagb;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub2;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzbee<UT, UB> zzbeeVar) {
        zzbbs<?> zzbbsVarZzcs;
        int i2 = this.zzdwg[i];
        Object objZzp = zzbek.zzp(obj, zzct(i) & 1048575);
        return (objZzp == null || (zzbbsVarZzcs = zzcs(i)) == null) ? ub : (UB) zza(i, i2, this.zzdwx.zzs(objZzp), zzbbsVarZzcs, ub, zzbeeVar);
    }

    private static void zza(int i, Object obj, zzbey zzbeyVar) throws IOException {
        if (obj instanceof String) {
            zzbeyVar.zzf(i, (String) obj);
        } else {
            zzbeyVar.zza(i, (zzbah) obj);
        }
    }

    private static <UT, UB> void zza(zzbee<UT, UB> zzbeeVar, T t, zzbey zzbeyVar) throws IOException {
        zzbeeVar.zza(zzbeeVar.zzac(t), zzbeyVar);
    }

    private final <K, V> void zza(zzbey zzbeyVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzbeyVar.zza(i, this.zzdwx.zzx(zzcr(i2)), this.zzdwx.zzt(obj));
        }
    }

    private final void zza(Object obj, int i, zzbdl zzbdlVar) throws IOException {
        if (zzcv(i)) {
            zzbek.zza(obj, i & 1048575, zzbdlVar.zzabr());
        } else if (this.zzdwn) {
            zzbek.zza(obj, i & 1048575, zzbdlVar.readString());
        } else {
            zzbek.zza(obj, i & 1048575, zzbdlVar.zzabs());
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzct = zzct(i) & 1048575;
        if (zza(t2, i)) {
            Object objZzp = zzbek.zzp(t, jZzct);
            Object objZzp2 = zzbek.zzp(t2, jZzct);
            if (objZzp != null && objZzp2 != null) {
                zzbek.zza(t, jZzct, zzbbq.zza(objZzp, objZzp2));
                zzb(t, i);
            } else if (objZzp2 != null) {
                zzbek.zza(t, jZzct, objZzp2);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        if (!this.zzdwo) {
            int iZzcu = zzcu(i);
            return ((1 << (iZzcu >>> 20)) & zzbek.zzk(t, (long) (1048575 & iZzcu))) != 0;
        }
        int iZzct = zzct(i);
        long j = 1048575 & iZzct;
        switch ((iZzct & 267386880) >>> 20) {
            case 0:
                return zzbek.zzo(t, j) != 0.0d;
            case 1:
                return zzbek.zzn(t, j) != 0.0f;
            case 2:
                return zzbek.zzl(t, j) != 0;
            case 3:
                return zzbek.zzl(t, j) != 0;
            case 4:
                return zzbek.zzk(t, j) != 0;
            case 5:
                return zzbek.zzl(t, j) != 0;
            case 6:
                return zzbek.zzk(t, j) != 0;
            case 7:
                return zzbek.zzm(t, j);
            case 8:
                Object objZzp = zzbek.zzp(t, j);
                if (objZzp instanceof String) {
                    return !((String) objZzp).isEmpty();
                }
                if (objZzp instanceof zzbah) {
                    return !zzbah.zzdpq.equals(objZzp);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzbek.zzp(t, j) != null;
            case 10:
                return !zzbah.zzdpq.equals(zzbek.zzp(t, j));
            case 11:
                return zzbek.zzk(t, j) != 0;
            case 12:
                return zzbek.zzk(t, j) != 0;
            case 13:
                return zzbek.zzk(t, j) != 0;
            case 14:
                return zzbek.zzl(t, j) != 0;
            case 15:
                return zzbek.zzk(t, j) != 0;
            case 16:
                return zzbek.zzl(t, j) != 0;
            case 17:
                return zzbek.zzp(t, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzbek.zzk(t, (long) (zzcu(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzdwo) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzbdm zzbdmVar) {
        return zzbdmVar.zzaa(zzbek.zzp(obj, 1048575 & i));
    }

    private final void zzb(T t, int i) {
        if (this.zzdwo) {
            return;
        }
        int iZzcu = zzcu(i);
        long j = 1048575 & iZzcu;
        zzbek.zzb(t, j, (1 << (iZzcu >>> 20)) | zzbek.zzk(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzbek.zzb(t, zzcu(i2) & 1048575, i);
    }

    /* JADX WARN: Code duplicated, block: B:179:0x079f  */
    private final void zzb(T t, zzbey zzbeyVar) throws IOException {
        Iterator it;
        int i;
        int i2;
        int i3;
        Map.Entry<?, ?> entry = null;
        if (this.zzdwm) {
            zzbbg<T> zzbbgVarZzm = this.zzdww.zzm(t);
            if (zzbbgVarZzm.isEmpty()) {
                it = null;
            } else {
                it = zzbbgVarZzm.iterator();
                entry = (Map.Entry) it.next();
            }
        } else {
            it = null;
        }
        int i4 = -1;
        int i5 = 0;
        int length = this.zzdwg.length;
        Unsafe unsafe = zzdwf;
        int i6 = 0;
        Map.Entry<?, ?> entry2 = entry;
        while (i6 < length) {
            int iZzct = zzct(i6);
            int i7 = this.zzdwg[i6];
            int i8 = (267386880 & iZzct) >>> 20;
            if (this.zzdwo || i8 > 17) {
                i = 0;
                i2 = i5;
                i3 = i4;
            } else {
                int i9 = this.zzdwg[i6 + 2];
                int i10 = 1048575 & i9;
                if (i10 != i4) {
                    i2 = unsafe.getInt(t, i10);
                } else {
                    i10 = i4;
                    i2 = i5;
                }
                i = 1 << (i9 >>> 20);
                i3 = i10;
            }
            while (entry2 != null && this.zzdww.zza(entry2) <= i7) {
                this.zzdww.zza(zzbeyVar, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = 1048575 & iZzct;
            switch (i8) {
                case 0:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zza(i7, zzbek.zzo(t, j));
                    }
                    break;
                case 1:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zza(i7, zzbek.zzn(t, j));
                    }
                    break;
                case 2:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzi(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 3:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zza(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 4:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzm(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 5:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzc(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 6:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzp(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 7:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzf(i7, zzbek.zzm(t, j));
                    }
                    break;
                case 8:
                    if ((i2 & i) != 0) {
                        zza(i7, unsafe.getObject(t, j), zzbeyVar);
                    }
                    break;
                case 9:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zza(i7, unsafe.getObject(t, j), zzcq(i6));
                    }
                    break;
                case 10:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zza(i7, (zzbah) unsafe.getObject(t, j));
                    }
                    break;
                case 11:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzn(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 12:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzx(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 13:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzw(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 14:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzj(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 15:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzo(i7, unsafe.getInt(t, j));
                    }
                    break;
                case 16:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzb(i7, unsafe.getLong(t, j));
                    }
                    break;
                case 17:
                    if ((i2 & i) != 0) {
                        zzbeyVar.zzb(i7, unsafe.getObject(t, j), zzcq(i6));
                    }
                    break;
                case 18:
                    zzbdo.zza(this.zzdwg[i6], (List<Double>) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 19:
                    zzbdo.zzb(this.zzdwg[i6], (List<Float>) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 20:
                    zzbdo.zzc(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 21:
                    zzbdo.zzd(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 22:
                    zzbdo.zzh(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 23:
                    zzbdo.zzf(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 24:
                    zzbdo.zzk(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 25:
                    zzbdo.zzn(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 26:
                    zzbdo.zza(this.zzdwg[i6], (List<String>) unsafe.getObject(t, j), zzbeyVar);
                    break;
                case 27:
                    zzbdo.zza(this.zzdwg[i6], (List<?>) unsafe.getObject(t, j), zzbeyVar, zzcq(i6));
                    break;
                case 28:
                    zzbdo.zzb(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar);
                    break;
                case 29:
                    zzbdo.zzi(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 30:
                    zzbdo.zzm(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 31:
                    zzbdo.zzl(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 32:
                    zzbdo.zzg(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 33:
                    zzbdo.zzj(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 34:
                    zzbdo.zze(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, false);
                    break;
                case 35:
                    zzbdo.zza(this.zzdwg[i6], (List<Double>) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 36:
                    zzbdo.zzb(this.zzdwg[i6], (List<Float>) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 37:
                    zzbdo.zzc(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 38:
                    zzbdo.zzd(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 39:
                    zzbdo.zzh(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 40:
                    zzbdo.zzf(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 41:
                    zzbdo.zzk(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 42:
                    zzbdo.zzn(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 43:
                    zzbdo.zzi(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 44:
                    zzbdo.zzm(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 45:
                    zzbdo.zzl(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 46:
                    zzbdo.zzg(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 47:
                    zzbdo.zzj(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 48:
                    zzbdo.zze(this.zzdwg[i6], (List) unsafe.getObject(t, j), zzbeyVar, true);
                    break;
                case 49:
                    zzbdo.zzb(this.zzdwg[i6], (List<?>) unsafe.getObject(t, j), zzbeyVar, zzcq(i6));
                    break;
                case 50:
                    zza(zzbeyVar, i7, unsafe.getObject(t, j), i6);
                    break;
                case 51:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zza(i7, zzf(t, j));
                    }
                    break;
                case 52:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zza(i7, zzg(t, j));
                    }
                    break;
                case 53:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzi(i7, zzi(t, j));
                    }
                    break;
                case 54:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zza(i7, zzi(t, j));
                    }
                    break;
                case 55:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzm(i7, zzh(t, j));
                    }
                    break;
                case 56:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzc(i7, zzi(t, j));
                    }
                    break;
                case 57:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzp(i7, zzh(t, j));
                    }
                    break;
                case 58:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzf(i7, zzj(t, j));
                    }
                    break;
                case 59:
                    if (zza(t, i7, i6)) {
                        zza(i7, unsafe.getObject(t, j), zzbeyVar);
                    }
                    break;
                case 60:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zza(i7, unsafe.getObject(t, j), zzcq(i6));
                    }
                    break;
                case 61:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zza(i7, (zzbah) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzn(i7, zzh(t, j));
                    }
                    break;
                case 63:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzx(i7, zzh(t, j));
                    }
                    break;
                case 64:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzw(i7, zzh(t, j));
                    }
                    break;
                case 65:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzj(i7, zzi(t, j));
                    }
                    break;
                case 66:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzo(i7, zzh(t, j));
                    }
                    break;
                case 67:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzb(i7, zzi(t, j));
                    }
                    break;
                case 68:
                    if (zza(t, i7, i6)) {
                        zzbeyVar.zzb(i7, unsafe.getObject(t, j), zzcq(i6));
                    }
                    break;
            }
            i6 += 4;
            i5 = i2;
            i4 = i3;
        }
        Map.Entry<?, ?> entry3 = entry2;
        while (entry3 != null) {
            this.zzdww.zza(zzbeyVar, entry3);
            entry3 = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzdwv, t, zzbeyVar);
    }

    private final void zzb(T t, T t2, int i) {
        int iZzct = zzct(i);
        int i2 = this.zzdwg[i];
        long j = iZzct & 1048575;
        if (zza(t2, i2, i)) {
            Object objZzp = zzbek.zzp(t, j);
            Object objZzp2 = zzbek.zzp(t2, j);
            if (objZzp != null && objZzp2 != null) {
                zzbek.zza(t, j, zzbbq.zza(objZzp, objZzp2));
                zzb(t, i2, i);
            } else if (objZzp2 != null) {
                zzbek.zza(t, j, objZzp2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final zzbdm zzcq(int i) {
        int i2 = (i / 4) << 1;
        zzbdm zzbdmVar = (zzbdm) this.zzdwh[i2];
        if (zzbdmVar != null) {
            return zzbdmVar;
        }
        zzbdm<T> zzbdmVarZze = zzbdg.zzaeo().zze((Class) this.zzdwh[i2 + 1]);
        this.zzdwh[i2] = zzbdmVarZze;
        return zzbdmVarZze;
    }

    private final Object zzcr(int i) {
        return this.zzdwh[(i / 4) << 1];
    }

    private final zzbbs<?> zzcs(int i) {
        return (zzbbs) this.zzdwh[((i / 4) << 1) + 1];
    }

    private final int zzct(int i) {
        return this.zzdwg[i + 1];
    }

    private final int zzcu(int i) {
        return this.zzdwg[i + 2];
    }

    private static boolean zzcv(int i) {
        return (536870912 & i) != 0;
    }

    private final int zzcw(int i) {
        int i2;
        if (i < this.zzdwi) {
            return -1;
        }
        if (i >= this.zzdwk) {
            if (i > this.zzdwj) {
                return -1;
            }
            int i3 = this.zzdwk - this.zzdwi;
            int length = (this.zzdwg.length / 4) - 1;
            while (i3 <= length) {
                int i4 = (length + i3) >>> 1;
                i2 = i4 << 2;
                int i5 = this.zzdwg[i2];
                if (i != i5) {
                    if (i < i5) {
                        length = i4 - 1;
                    } else {
                        i3 = i4 + 1;
                    }
                }
            }
            return -1;
        }
        i2 = (i - this.zzdwi) << 2;
        if (this.zzdwg[i2] != i) {
            return -1;
        }
        return i2;
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zzbek.zzp(obj, j);
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzbek.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzbek.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzbek.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzbek.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzbek.zzp(t, j)).booleanValue();
    }

    private static zzbef zzz(Object obj) {
        zzbef zzbefVar = ((zzbbo) obj).zzdtt;
        if (zzbefVar != zzbef.zzagc()) {
            return zzbefVar;
        }
        zzbef zzbefVarZzagd = zzbef.zzagd();
        ((zzbbo) obj).zzdtt = zzbefVarZzagd;
        return zzbefVarZzagd;
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final boolean equals(T t, T t2) {
        boolean zZzd;
        int length = this.zzdwg.length;
        for (int i = 0; i < length; i += 4) {
            int iZzct = zzct(i);
            long j = iZzct & 1048575;
            switch ((iZzct & 267386880) >>> 20) {
                case 0:
                    zZzd = zzc(t, t2, i) && zzbek.zzl(t, j) == zzbek.zzl(t2, j);
                    break;
                case 1:
                    zZzd = zzc(t, t2, i) && zzbek.zzk(t, j) == zzbek.zzk(t2, j);
                    break;
                case 2:
                    zZzd = zzc(t, t2, i) && zzbek.zzl(t, j) == zzbek.zzl(t2, j);
                    break;
                case 3:
                    zZzd = zzc(t, t2, i) && zzbek.zzl(t, j) == zzbek.zzl(t2, j);
                    break;
                case 4:
                    zZzd = zzc(t, t2, i) && zzbek.zzk(t, j) == zzbek.zzk(t2, j);
                    break;
                case 5:
                    zZzd = zzc(t, t2, i) && zzbek.zzl(t, j) == zzbek.zzl(t2, j);
                    break;
                case 6:
                    zZzd = zzc(t, t2, i) && zzbek.zzk(t, j) == zzbek.zzk(t2, j);
                    break;
                case 7:
                    zZzd = zzc(t, t2, i) && zzbek.zzm(t, j) == zzbek.zzm(t2, j);
                    break;
                case 8:
                    zZzd = zzc(t, t2, i) && zzbdo.zzd(zzbek.zzp(t, j), zzbek.zzp(t2, j));
                    break;
                case 9:
                    zZzd = zzc(t, t2, i) && zzbdo.zzd(zzbek.zzp(t, j), zzbek.zzp(t2, j));
                    break;
                case 10:
                    zZzd = zzc(t, t2, i) && zzbdo.zzd(zzbek.zzp(t, j), zzbek.zzp(t2, j));
                    break;
                case 11:
                    zZzd = zzc(t, t2, i) && zzbek.zzk(t, j) == zzbek.zzk(t2, j);
                    break;
                case 12:
                    zZzd = zzc(t, t2, i) && zzbek.zzk(t, j) == zzbek.zzk(t2, j);
                    break;
                case 13:
                    zZzd = zzc(t, t2, i) && zzbek.zzk(t, j) == zzbek.zzk(t2, j);
                    break;
                case 14:
                    zZzd = zzc(t, t2, i) && zzbek.zzl(t, j) == zzbek.zzl(t2, j);
                    break;
                case 15:
                    zZzd = zzc(t, t2, i) && zzbek.zzk(t, j) == zzbek.zzk(t2, j);
                    break;
                case 16:
                    zZzd = zzc(t, t2, i) && zzbek.zzl(t, j) == zzbek.zzl(t2, j);
                    break;
                case 17:
                    zZzd = zzc(t, t2, i) && zzbdo.zzd(zzbek.zzp(t, j), zzbek.zzp(t2, j));
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzd = zzbdo.zzd(zzbek.zzp(t, j), zzbek.zzp(t2, j));
                    break;
                case 50:
                    zZzd = zzbdo.zzd(zzbek.zzp(t, j), zzbek.zzp(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    int iZzcu = zzcu(i);
                    zZzd = zzbek.zzk(t, iZzcu & 1048575) == zzbek.zzk(t2, iZzcu & 1048575) && zzbdo.zzd(zzbek.zzp(t, j), zzbek.zzp(t2, j));
                    break;
                default:
                    zZzd = true;
                    break;
            }
            if (!zZzd) {
                return false;
            }
        }
        if (!this.zzdwv.zzac(t).equals(this.zzdwv.zzac(t2))) {
            return false;
        }
        if (this.zzdwm) {
            return this.zzdww.zzm(t).equals(this.zzdww.zzm(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final int hashCode(T t) {
        int length = this.zzdwg.length;
        int iHashCode = 0;
        int i = 0;
        while (i < length) {
            int iZzct = zzct(i);
            int i2 = this.zzdwg[i];
            long j = 1048575 & iZzct;
            switch ((iZzct & 267386880) >>> 20) {
                case 0:
                    iHashCode = (iHashCode * 53) + zzbbq.zzv(Double.doubleToLongBits(zzbek.zzo(t, j)));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 1:
                    iHashCode = (iHashCode * 53) + Float.floatToIntBits(zzbek.zzn(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 2:
                    iHashCode = (iHashCode * 53) + zzbbq.zzv(zzbek.zzl(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 3:
                    iHashCode = (iHashCode * 53) + zzbbq.zzv(zzbek.zzl(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 4:
                    iHashCode = (iHashCode * 53) + zzbek.zzk(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 5:
                    iHashCode = (iHashCode * 53) + zzbbq.zzv(zzbek.zzl(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 6:
                    iHashCode = (iHashCode * 53) + zzbek.zzk(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 7:
                    iHashCode = (iHashCode * 53) + zzbbq.zzar(zzbek.zzm(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 8:
                    iHashCode = ((String) zzbek.zzp(t, j)).hashCode() + (iHashCode * 53);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 9:
                    Object objZzp = zzbek.zzp(t, j);
                    iHashCode = (objZzp != null ? objZzp.hashCode() : 37) + (iHashCode * 53);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 10:
                    iHashCode = (iHashCode * 53) + zzbek.zzp(t, j).hashCode();
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 11:
                    iHashCode = (iHashCode * 53) + zzbek.zzk(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 12:
                    iHashCode = (iHashCode * 53) + zzbek.zzk(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 13:
                    iHashCode = (iHashCode * 53) + zzbek.zzk(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 14:
                    iHashCode = (iHashCode * 53) + zzbbq.zzv(zzbek.zzl(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 15:
                    iHashCode = (iHashCode * 53) + zzbek.zzk(t, j);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 16:
                    iHashCode = (iHashCode * 53) + zzbbq.zzv(zzbek.zzl(t, j));
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 17:
                    Object objZzp2 = zzbek.zzp(t, j);
                    iHashCode = (objZzp2 != null ? objZzp2.hashCode() : 37) + (iHashCode * 53);
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    iHashCode = (iHashCode * 53) + zzbek.zzp(t, j).hashCode();
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 50:
                    iHashCode = (iHashCode * 53) + zzbek.zzp(t, j).hashCode();
                    continue;
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 51:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzbbq.zzv(Double.doubleToLongBits(zzf(t, j)));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 52:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + Float.floatToIntBits(zzg(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 53:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzbbq.zzv(zzi(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 54:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzbbq.zzv(zzi(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 55:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 56:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzbbq.zzv(zzi(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 57:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 58:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzbbq.zzar(zzj(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 59:
                    if (zza(t, i2, i)) {
                        iHashCode = ((String) zzbek.zzp(t, j)).hashCode() + (iHashCode * 53);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 60:
                    if (zza(t, i2, i)) {
                        iHashCode = zzbek.zzp(t, j).hashCode() + (iHashCode * 53);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 61:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzbek.zzp(t, j).hashCode();
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 62:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 63:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 64:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 65:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzbbq.zzv(zzi(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 66:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzh(t, j);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 67:
                    if (zza(t, i2, i)) {
                        iHashCode = (iHashCode * 53) + zzbbq.zzv(zzi(t, j));
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
                case 68:
                    if (zza(t, i2, i)) {
                        iHashCode = zzbek.zzp(t, j).hashCode() + (iHashCode * 53);
                    }
                    i += 4;
                    iHashCode = iHashCode;
                    break;
            }
            i += 4;
            iHashCode = iHashCode;
        }
        int iHashCode2 = (iHashCode * 53) + this.zzdwv.zzac(t).hashCode();
        return this.zzdwm ? (iHashCode2 * 53) + this.zzdww.zzm(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final T newInstance() {
        return (T) this.zzdwt.newInstance(this.zzdwl);
    }

    /* JADX WARN: Code duplicated, block: B:176:0x068c  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f4 A[LOOP:5: B:71:0x00f2->B:72:0x00f4, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:70:0x00ee, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zza(T t, zzbdl zzbdlVar, zzbbb zzbbbVar) throws IOException {
        int i;
        Object objZzw;
        if (zzbbbVar == null) {
            throw new NullPointerException();
        }
        zzbee<?, ?> zzbeeVar = this.zzdwv;
        zzbbd<?> zzbbdVar = this.zzdww;
        Object objZza = null;
        zzbbg zzbbgVarZzn = null;
        while (true) {
            try {
                int iZzaci = zzbdlVar.zzaci();
                int iZzcw = zzcw(iZzaci);
                if (iZzcw >= 0) {
                    int iZzct = zzct(iZzcw);
                    switch ((267386880 & iZzct) >>> 20) {
                        case 0:
                            zzbek.zza(t, 1048575 & iZzct, zzbdlVar.readDouble());
                            zzb(t, iZzcw);
                            continue;
                        case 1:
                            zzbek.zza((Object) t, 1048575 & iZzct, zzbdlVar.readFloat());
                            zzb(t, iZzcw);
                            continue;
                        case 2:
                            zzbek.zza((Object) t, 1048575 & iZzct, zzbdlVar.zzabm());
                            zzb(t, iZzcw);
                            continue;
                        case 3:
                            zzbek.zza((Object) t, 1048575 & iZzct, zzbdlVar.zzabl());
                            zzb(t, iZzcw);
                            continue;
                        case 4:
                            zzbek.zzb(t, 1048575 & iZzct, zzbdlVar.zzabn());
                            zzb(t, iZzcw);
                            continue;
                        case 5:
                            zzbek.zza((Object) t, 1048575 & iZzct, zzbdlVar.zzabo());
                            zzb(t, iZzcw);
                            continue;
                        case 6:
                            zzbek.zzb(t, 1048575 & iZzct, zzbdlVar.zzabp());
                            zzb(t, iZzcw);
                            continue;
                        case 7:
                            zzbek.zza(t, 1048575 & iZzct, zzbdlVar.zzabq());
                            zzb(t, iZzcw);
                            continue;
                        case 8:
                            zza(t, iZzct, zzbdlVar);
                            zzb(t, iZzcw);
                            continue;
                        case 9:
                            if (zza(t, iZzcw)) {
                                zzbek.zza(t, 1048575 & iZzct, zzbbq.zza(zzbek.zzp(t, 1048575 & iZzct), zzbdlVar.zza(zzcq(iZzcw), zzbbbVar)));
                            } else {
                                zzbek.zza(t, 1048575 & iZzct, zzbdlVar.zza(zzcq(iZzcw), zzbbbVar));
                                zzb(t, iZzcw);
                                continue;
                            }
                            break;
                        case 10:
                            zzbek.zza(t, 1048575 & iZzct, zzbdlVar.zzabs());
                            zzb(t, iZzcw);
                            continue;
                        case 11:
                            zzbek.zzb(t, 1048575 & iZzct, zzbdlVar.zzabt());
                            zzb(t, iZzcw);
                            continue;
                        case 12:
                            int iZzabu = zzbdlVar.zzabu();
                            zzbbs<?> zzbbsVarZzcs = zzcs(iZzcw);
                            if (zzbbsVarZzcs == null || zzbbsVarZzcs.zzq(iZzabu) != null) {
                                zzbek.zzb(t, 1048575 & iZzct, iZzabu);
                                zzb(t, iZzcw);
                                continue;
                            } else {
                                objZza = zzbdo.zza(iZzaci, iZzabu, objZza, (zzbee<UT, Object>) zzbeeVar);
                            }
                            break;
                        case 13:
                            zzbek.zzb(t, 1048575 & iZzct, zzbdlVar.zzabv());
                            zzb(t, iZzcw);
                            continue;
                        case 14:
                            zzbek.zza((Object) t, 1048575 & iZzct, zzbdlVar.zzabw());
                            zzb(t, iZzcw);
                            continue;
                        case 15:
                            zzbek.zzb(t, 1048575 & iZzct, zzbdlVar.zzabx());
                            zzb(t, iZzcw);
                            continue;
                        case 16:
                            zzbek.zza((Object) t, 1048575 & iZzct, zzbdlVar.zzaby());
                            zzb(t, iZzcw);
                            continue;
                        case 17:
                            if (zza(t, iZzcw)) {
                                zzbek.zza(t, 1048575 & iZzct, zzbbq.zza(zzbek.zzp(t, 1048575 & iZzct), zzbdlVar.zzb(zzcq(iZzcw), zzbbbVar)));
                            } else {
                                zzbek.zza(t, 1048575 & iZzct, zzbdlVar.zzb(zzcq(iZzcw), zzbbbVar));
                                zzb(t, iZzcw);
                                continue;
                            }
                            break;
                        case 18:
                            zzbdlVar.zzp(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 19:
                            zzbdlVar.zzq(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 20:
                            zzbdlVar.zzs(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 21:
                            zzbdlVar.zzr(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 22:
                            zzbdlVar.zzt(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 23:
                            zzbdlVar.zzu(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 24:
                            zzbdlVar.zzv(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 25:
                            zzbdlVar.zzw(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 26:
                            if (zzcv(iZzct)) {
                                zzbdlVar.zzx(this.zzdwu.zza(t, 1048575 & iZzct));
                            } else {
                                zzbdlVar.readStringList(this.zzdwu.zza(t, 1048575 & iZzct));
                                continue;
                            }
                            break;
                        case 27:
                            zzbdlVar.zza(this.zzdwu.zza(t, 1048575 & iZzct), zzcq(iZzcw), zzbbbVar);
                            continue;
                        case 28:
                            zzbdlVar.zzy(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 29:
                            zzbdlVar.zzz(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 30:
                            List<Integer> listZza = this.zzdwu.zza(t, iZzct & 1048575);
                            zzbdlVar.zzaa(listZza);
                            objZza = zzbdo.zza(iZzaci, listZza, zzcs(iZzcw), objZza, zzbeeVar);
                            continue;
                        case 31:
                            zzbdlVar.zzab(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 32:
                            zzbdlVar.zzac(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 33:
                            zzbdlVar.zzad(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 34:
                            zzbdlVar.zzae(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 35:
                            zzbdlVar.zzp(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 36:
                            zzbdlVar.zzq(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 37:
                            zzbdlVar.zzs(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 38:
                            zzbdlVar.zzr(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 39:
                            zzbdlVar.zzt(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 40:
                            zzbdlVar.zzu(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 41:
                            zzbdlVar.zzv(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 42:
                            zzbdlVar.zzw(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 43:
                            zzbdlVar.zzz(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 44:
                            List<Integer> listZza2 = this.zzdwu.zza(t, iZzct & 1048575);
                            zzbdlVar.zzaa(listZza2);
                            objZza = zzbdo.zza(iZzaci, listZza2, zzcs(iZzcw), objZza, zzbeeVar);
                            continue;
                        case 45:
                            zzbdlVar.zzab(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 46:
                            zzbdlVar.zzac(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 47:
                            zzbdlVar.zzad(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 48:
                            zzbdlVar.zzae(this.zzdwu.zza(t, 1048575 & iZzct));
                            continue;
                        case 49:
                            zzbdlVar.zzb(this.zzdwu.zza(t, 1048575 & iZzct), zzcq(iZzcw), zzbbbVar);
                            continue;
                        case 50:
                            Object objZzcr = zzcr(iZzcw);
                            long jZzct = zzct(iZzcw) & 1048575;
                            Object objZzp = zzbek.zzp(t, jZzct);
                            if (objZzp == null) {
                                objZzw = this.zzdwx.zzw(objZzcr);
                                zzbek.zza(t, jZzct, objZzw);
                            } else if (this.zzdwx.zzu(objZzp)) {
                                objZzw = this.zzdwx.zzw(objZzcr);
                                this.zzdwx.zzb(objZzw, objZzp);
                                zzbek.zza(t, jZzct, objZzw);
                            } else {
                                objZzw = objZzp;
                            }
                            zzbdlVar.zza(this.zzdwx.zzs(objZzw), this.zzdwx.zzx(objZzcr), zzbbbVar);
                            continue;
                        case 51:
                            zzbek.zza(t, iZzct & 1048575, Double.valueOf(zzbdlVar.readDouble()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 52:
                            zzbek.zza(t, iZzct & 1048575, Float.valueOf(zzbdlVar.readFloat()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 53:
                            zzbek.zza(t, iZzct & 1048575, Long.valueOf(zzbdlVar.zzabm()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 54:
                            zzbek.zza(t, iZzct & 1048575, Long.valueOf(zzbdlVar.zzabl()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 55:
                            zzbek.zza(t, iZzct & 1048575, Integer.valueOf(zzbdlVar.zzabn()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 56:
                            zzbek.zza(t, iZzct & 1048575, Long.valueOf(zzbdlVar.zzabo()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 57:
                            zzbek.zza(t, iZzct & 1048575, Integer.valueOf(zzbdlVar.zzabp()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 58:
                            zzbek.zza(t, iZzct & 1048575, Boolean.valueOf(zzbdlVar.zzabq()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 59:
                            zza(t, iZzct, zzbdlVar);
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 60:
                            if (zza(t, iZzaci, iZzcw)) {
                                zzbek.zza(t, iZzct & 1048575, zzbbq.zza(zzbek.zzp(t, 1048575 & iZzct), zzbdlVar.zza(zzcq(iZzcw), zzbbbVar)));
                            } else {
                                zzbek.zza(t, iZzct & 1048575, zzbdlVar.zza(zzcq(iZzcw), zzbbbVar));
                                zzb(t, iZzcw);
                            }
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 61:
                            zzbek.zza(t, iZzct & 1048575, zzbdlVar.zzabs());
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 62:
                            zzbek.zza(t, iZzct & 1048575, Integer.valueOf(zzbdlVar.zzabt()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 63:
                            int iZzabu2 = zzbdlVar.zzabu();
                            zzbbs<?> zzbbsVarZzcs2 = zzcs(iZzcw);
                            if (zzbbsVarZzcs2 == null || zzbbsVarZzcs2.zzq(iZzabu2) != null) {
                                zzbek.zza(t, iZzct & 1048575, Integer.valueOf(iZzabu2));
                                zzb(t, iZzaci, iZzcw);
                                continue;
                            } else {
                                objZza = zzbdo.zza(iZzaci, iZzabu2, objZza, (zzbee<UT, Object>) zzbeeVar);
                            }
                            break;
                        case 64:
                            zzbek.zza(t, iZzct & 1048575, Integer.valueOf(zzbdlVar.zzabv()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 65:
                            zzbek.zza(t, iZzct & 1048575, Long.valueOf(zzbdlVar.zzabw()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 66:
                            zzbek.zza(t, iZzct & 1048575, Integer.valueOf(zzbdlVar.zzabx()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 67:
                            zzbek.zza(t, iZzct & 1048575, Long.valueOf(zzbdlVar.zzaby()));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        case 68:
                            zzbek.zza(t, iZzct & 1048575, zzbdlVar.zzb(zzcq(iZzcw), zzbbbVar));
                            zzb(t, iZzaci, iZzcw);
                            continue;
                        default:
                            if (objZza == null) {
                                try {
                                    objZza = zzbeeVar.zzagb();
                                } catch (zzbbv e) {
                                    zzbeeVar.zza(zzbdlVar);
                                    if (objZza == null) {
                                        objZza = zzbeeVar.zzad(t);
                                    }
                                    if (!zzbeeVar.zza((Object) objZza, zzbdlVar)) {
                                        if (this.zzdwr != null) {
                                            for (int i2 : this.zzdwr) {
                                                objZza = zza((Object) t, i2, objZza, (zzbee<UT, Object>) zzbeeVar);
                                            }
                                        }
                                        if (objZza != null) {
                                            zzbeeVar.zzf(t, (Object) objZza);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                break;
                            }
                            if (!zzbeeVar.zza((Object) objZza, zzbdlVar)) {
                                if (this.zzdwr != null) {
                                    for (int i3 : this.zzdwr) {
                                        objZza = zza((Object) t, i3, objZza, (zzbee<UT, Object>) zzbeeVar);
                                    }
                                }
                                if (objZza != null) {
                                    zzbeeVar.zzf(t, (Object) objZza);
                                    return;
                                }
                                return;
                            }
                            break;
                            break;
                    }
                    if (this.zzdwr != null) {
                        for (int i4 : this.zzdwr) {
                            objZza = zza((Object) t, i4, objZza, (zzbee<UT, Object>) zzbeeVar);
                        }
                    }
                    if (objZza != null) {
                        zzbeeVar.zzf(t, (Object) objZza);
                    }
                    throw th;
                }
                if (iZzaci == Integer.MAX_VALUE) {
                    if (this.zzdwr != null) {
                        for (int i5 : this.zzdwr) {
                            objZza = zza((Object) t, i5, objZza, (zzbee<UT, Object>) zzbeeVar);
                        }
                    }
                    if (objZza != null) {
                        zzbeeVar.zzf(t, (Object) objZza);
                        return;
                    }
                    return;
                }
                Object objZza2 = !this.zzdwm ? null : zzbbdVar.zza(zzbbbVar, this.zzdwl, iZzaci);
                if (objZza2 != null) {
                    if (zzbbgVarZzn == null) {
                        zzbbgVarZzn = zzbbdVar.zzn(t);
                    }
                    objZza = zzbbdVar.zza(zzbdlVar, objZza2, zzbbbVar, zzbbgVarZzn, objZza, zzbeeVar);
                } else {
                    zzbeeVar.zza(zzbdlVar);
                    if (objZza == null) {
                        objZza = zzbeeVar.zzad(t);
                    }
                    if (!zzbeeVar.zza((Object) objZza, zzbdlVar)) {
                        if (this.zzdwr != null) {
                            for (int i6 : this.zzdwr) {
                                objZza = zza((Object) t, i6, objZza, (zzbee<UT, Object>) zzbeeVar);
                            }
                        }
                        if (objZza != null) {
                            zzbeeVar.zzf(t, (Object) objZza);
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                if (this.zzdwr != null) {
                    while (i < r3) {
                        objZza = zza((Object) t, i4, objZza, (zzbee<UT, Object>) zzbeeVar);
                    }
                }
                if (objZza != null) {
                    zzbeeVar.zzf(t, (Object) objZza);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:339:0x0c18  */
    /* JADX WARN: Code duplicated, block: B:340:0x0c1b  */
    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zza(T t, zzbey zzbeyVar) throws IOException {
        Iterator it;
        Iterator itDescendingIterator;
        if (zzbeyVar.zzacn() == zzbbo.zze.zzdum) {
            zza(this.zzdwv, t, zzbeyVar);
            Map.Entry<?, ?> entry = null;
            if (this.zzdwm) {
                zzbbg<T> zzbbgVarZzm = this.zzdww.zzm(t);
                if (zzbbgVarZzm.isEmpty()) {
                    itDescendingIterator = null;
                } else {
                    itDescendingIterator = zzbbgVarZzm.descendingIterator();
                    entry = (Map.Entry) itDescendingIterator.next();
                }
            } else {
                itDescendingIterator = null;
            }
            int length = this.zzdwg.length - 4;
            Map.Entry<?, ?> entry2 = entry;
            while (length >= 0) {
                int iZzct = zzct(length);
                int i = this.zzdwg[length];
                Map.Entry<?, ?> entry3 = entry2;
                while (entry3 != null && this.zzdww.zza(entry3) > i) {
                    this.zzdww.zza(zzbeyVar, entry3);
                    entry3 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
                }
                switch ((267386880 & iZzct) >>> 20) {
                    case 0:
                        if (zza(t, length)) {
                            zzbeyVar.zza(i, zzbek.zzo(t, 1048575 & iZzct));
                        }
                        break;
                    case 1:
                        if (zza(t, length)) {
                            zzbeyVar.zza(i, zzbek.zzn(t, 1048575 & iZzct));
                        }
                        break;
                    case 2:
                        if (zza(t, length)) {
                            zzbeyVar.zzi(i, zzbek.zzl(t, 1048575 & iZzct));
                        }
                        break;
                    case 3:
                        if (zza(t, length)) {
                            zzbeyVar.zza(i, zzbek.zzl(t, 1048575 & iZzct));
                        }
                        break;
                    case 4:
                        if (zza(t, length)) {
                            zzbeyVar.zzm(i, zzbek.zzk(t, 1048575 & iZzct));
                        }
                        break;
                    case 5:
                        if (zza(t, length)) {
                            zzbeyVar.zzc(i, zzbek.zzl(t, 1048575 & iZzct));
                        }
                        break;
                    case 6:
                        if (zza(t, length)) {
                            zzbeyVar.zzp(i, zzbek.zzk(t, 1048575 & iZzct));
                        }
                        break;
                    case 7:
                        if (zza(t, length)) {
                            zzbeyVar.zzf(i, zzbek.zzm(t, 1048575 & iZzct));
                        }
                        break;
                    case 8:
                        if (zza(t, length)) {
                            zza(i, zzbek.zzp(t, 1048575 & iZzct), zzbeyVar);
                        }
                        break;
                    case 9:
                        if (zza(t, length)) {
                            zzbeyVar.zza(i, zzbek.zzp(t, 1048575 & iZzct), zzcq(length));
                        }
                        break;
                    case 10:
                        if (zza(t, length)) {
                            zzbeyVar.zza(i, (zzbah) zzbek.zzp(t, 1048575 & iZzct));
                        }
                        break;
                    case 11:
                        if (zza(t, length)) {
                            zzbeyVar.zzn(i, zzbek.zzk(t, 1048575 & iZzct));
                        }
                        break;
                    case 12:
                        if (zza(t, length)) {
                            zzbeyVar.zzx(i, zzbek.zzk(t, 1048575 & iZzct));
                        }
                        break;
                    case 13:
                        if (zza(t, length)) {
                            zzbeyVar.zzw(i, zzbek.zzk(t, 1048575 & iZzct));
                        }
                        break;
                    case 14:
                        if (zza(t, length)) {
                            zzbeyVar.zzj(i, zzbek.zzl(t, 1048575 & iZzct));
                        }
                        break;
                    case 15:
                        if (zza(t, length)) {
                            zzbeyVar.zzo(i, zzbek.zzk(t, 1048575 & iZzct));
                        }
                        break;
                    case 16:
                        if (zza(t, length)) {
                            zzbeyVar.zzb(i, zzbek.zzl(t, 1048575 & iZzct));
                        }
                        break;
                    case 17:
                        if (zza(t, length)) {
                            zzbeyVar.zzb(i, zzbek.zzp(t, 1048575 & iZzct), zzcq(length));
                        }
                        break;
                    case 18:
                        zzbdo.zza(this.zzdwg[length], (List<Double>) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 19:
                        zzbdo.zzb(this.zzdwg[length], (List<Float>) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 20:
                        zzbdo.zzc(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 21:
                        zzbdo.zzd(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 22:
                        zzbdo.zzh(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 23:
                        zzbdo.zzf(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 24:
                        zzbdo.zzk(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 25:
                        zzbdo.zzn(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 26:
                        zzbdo.zza(this.zzdwg[length], (List<String>) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar);
                        break;
                    case 27:
                        zzbdo.zza(this.zzdwg[length], (List<?>) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, zzcq(length));
                        break;
                    case 28:
                        zzbdo.zzb(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar);
                        break;
                    case 29:
                        zzbdo.zzi(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 30:
                        zzbdo.zzm(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 31:
                        zzbdo.zzl(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 32:
                        zzbdo.zzg(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 33:
                        zzbdo.zzj(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 34:
                        zzbdo.zze(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, false);
                        break;
                    case 35:
                        zzbdo.zza(this.zzdwg[length], (List<Double>) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 36:
                        zzbdo.zzb(this.zzdwg[length], (List<Float>) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 37:
                        zzbdo.zzc(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 38:
                        zzbdo.zzd(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 39:
                        zzbdo.zzh(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 40:
                        zzbdo.zzf(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 41:
                        zzbdo.zzk(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 42:
                        zzbdo.zzn(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 43:
                        zzbdo.zzi(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 44:
                        zzbdo.zzm(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 45:
                        zzbdo.zzl(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 46:
                        zzbdo.zzg(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 47:
                        zzbdo.zzj(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 48:
                        zzbdo.zze(this.zzdwg[length], (List) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, true);
                        break;
                    case 49:
                        zzbdo.zzb(this.zzdwg[length], (List<?>) zzbek.zzp(t, 1048575 & iZzct), zzbeyVar, zzcq(length));
                        break;
                    case 50:
                        zza(zzbeyVar, i, zzbek.zzp(t, 1048575 & iZzct), length);
                        break;
                    case 51:
                        if (zza(t, i, length)) {
                            zzbeyVar.zza(i, zzf(t, 1048575 & iZzct));
                        }
                        break;
                    case 52:
                        if (zza(t, i, length)) {
                            zzbeyVar.zza(i, zzg(t, 1048575 & iZzct));
                        }
                        break;
                    case 53:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzi(i, zzi(t, 1048575 & iZzct));
                        }
                        break;
                    case 54:
                        if (zza(t, i, length)) {
                            zzbeyVar.zza(i, zzi(t, 1048575 & iZzct));
                        }
                        break;
                    case 55:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzm(i, zzh(t, 1048575 & iZzct));
                        }
                        break;
                    case 56:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzc(i, zzi(t, 1048575 & iZzct));
                        }
                        break;
                    case 57:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzp(i, zzh(t, 1048575 & iZzct));
                        }
                        break;
                    case 58:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzf(i, zzj(t, 1048575 & iZzct));
                        }
                        break;
                    case 59:
                        if (zza(t, i, length)) {
                            zza(i, zzbek.zzp(t, 1048575 & iZzct), zzbeyVar);
                        }
                        break;
                    case 60:
                        if (zza(t, i, length)) {
                            zzbeyVar.zza(i, zzbek.zzp(t, 1048575 & iZzct), zzcq(length));
                        }
                        break;
                    case 61:
                        if (zza(t, i, length)) {
                            zzbeyVar.zza(i, (zzbah) zzbek.zzp(t, 1048575 & iZzct));
                        }
                        break;
                    case 62:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzn(i, zzh(t, 1048575 & iZzct));
                        }
                        break;
                    case 63:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzx(i, zzh(t, 1048575 & iZzct));
                        }
                        break;
                    case 64:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzw(i, zzh(t, 1048575 & iZzct));
                        }
                        break;
                    case 65:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzj(i, zzi(t, 1048575 & iZzct));
                        }
                        break;
                    case 66:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzo(i, zzh(t, 1048575 & iZzct));
                        }
                        break;
                    case 67:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzb(i, zzi(t, 1048575 & iZzct));
                        }
                        break;
                    case 68:
                        if (zza(t, i, length)) {
                            zzbeyVar.zzb(i, zzbek.zzp(t, 1048575 & iZzct), zzcq(length));
                        }
                        break;
                }
                length -= 4;
                entry2 = entry3;
            }
            while (entry2 != null) {
                this.zzdww.zza(zzbeyVar, entry2);
                entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            return;
        }
        if (!this.zzdwo) {
            zzb(t, zzbeyVar);
            return;
        }
        Map.Entry<?, ?> entry4 = null;
        if (this.zzdwm) {
            zzbbg<T> zzbbgVarZzm2 = this.zzdww.zzm(t);
            if (zzbbgVarZzm2.isEmpty()) {
                it = null;
            } else {
                it = zzbbgVarZzm2.iterator();
                entry4 = (Map.Entry) it.next();
            }
        } else {
            it = null;
        }
        int length2 = this.zzdwg.length;
        int i2 = 0;
        Map.Entry<?, ?> entry5 = entry4;
        while (i2 < length2) {
            int iZzct2 = zzct(i2);
            int i3 = this.zzdwg[i2];
            Map.Entry<?, ?> entry6 = entry5;
            while (entry6 != null && this.zzdww.zza(entry6) <= i3) {
                this.zzdww.zza(zzbeyVar, entry6);
                entry6 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch ((267386880 & iZzct2) >>> 20) {
                case 0:
                    if (zza(t, i2)) {
                        zzbeyVar.zza(i3, zzbek.zzo(t, 1048575 & iZzct2));
                    }
                    break;
                case 1:
                    if (zza(t, i2)) {
                        zzbeyVar.zza(i3, zzbek.zzn(t, 1048575 & iZzct2));
                    }
                    break;
                case 2:
                    if (zza(t, i2)) {
                        zzbeyVar.zzi(i3, zzbek.zzl(t, 1048575 & iZzct2));
                    }
                    break;
                case 3:
                    if (zza(t, i2)) {
                        zzbeyVar.zza(i3, zzbek.zzl(t, 1048575 & iZzct2));
                    }
                    break;
                case 4:
                    if (zza(t, i2)) {
                        zzbeyVar.zzm(i3, zzbek.zzk(t, 1048575 & iZzct2));
                    }
                    break;
                case 5:
                    if (zza(t, i2)) {
                        zzbeyVar.zzc(i3, zzbek.zzl(t, 1048575 & iZzct2));
                    }
                    break;
                case 6:
                    if (zza(t, i2)) {
                        zzbeyVar.zzp(i3, zzbek.zzk(t, 1048575 & iZzct2));
                    }
                    break;
                case 7:
                    if (zza(t, i2)) {
                        zzbeyVar.zzf(i3, zzbek.zzm(t, 1048575 & iZzct2));
                    }
                    break;
                case 8:
                    if (zza(t, i2)) {
                        zza(i3, zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar);
                    }
                    break;
                case 9:
                    if (zza(t, i2)) {
                        zzbeyVar.zza(i3, zzbek.zzp(t, 1048575 & iZzct2), zzcq(i2));
                    }
                    break;
                case 10:
                    if (zza(t, i2)) {
                        zzbeyVar.zza(i3, (zzbah) zzbek.zzp(t, 1048575 & iZzct2));
                    }
                    break;
                case 11:
                    if (zza(t, i2)) {
                        zzbeyVar.zzn(i3, zzbek.zzk(t, 1048575 & iZzct2));
                    }
                    break;
                case 12:
                    if (zza(t, i2)) {
                        zzbeyVar.zzx(i3, zzbek.zzk(t, 1048575 & iZzct2));
                    }
                    break;
                case 13:
                    if (zza(t, i2)) {
                        zzbeyVar.zzw(i3, zzbek.zzk(t, 1048575 & iZzct2));
                    }
                    break;
                case 14:
                    if (zza(t, i2)) {
                        zzbeyVar.zzj(i3, zzbek.zzl(t, 1048575 & iZzct2));
                    }
                    break;
                case 15:
                    if (zza(t, i2)) {
                        zzbeyVar.zzo(i3, zzbek.zzk(t, 1048575 & iZzct2));
                    }
                    break;
                case 16:
                    if (zza(t, i2)) {
                        zzbeyVar.zzb(i3, zzbek.zzl(t, 1048575 & iZzct2));
                    }
                    break;
                case 17:
                    if (zza(t, i2)) {
                        zzbeyVar.zzb(i3, zzbek.zzp(t, 1048575 & iZzct2), zzcq(i2));
                    }
                    break;
                case 18:
                    zzbdo.zza(this.zzdwg[i2], (List<Double>) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 19:
                    zzbdo.zzb(this.zzdwg[i2], (List<Float>) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 20:
                    zzbdo.zzc(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 21:
                    zzbdo.zzd(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 22:
                    zzbdo.zzh(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 23:
                    zzbdo.zzf(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 24:
                    zzbdo.zzk(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 25:
                    zzbdo.zzn(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 26:
                    zzbdo.zza(this.zzdwg[i2], (List<String>) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar);
                    break;
                case 27:
                    zzbdo.zza(this.zzdwg[i2], (List<?>) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, zzcq(i2));
                    break;
                case 28:
                    zzbdo.zzb(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar);
                    break;
                case 29:
                    zzbdo.zzi(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 30:
                    zzbdo.zzm(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 31:
                    zzbdo.zzl(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 32:
                    zzbdo.zzg(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 33:
                    zzbdo.zzj(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 34:
                    zzbdo.zze(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, false);
                    break;
                case 35:
                    zzbdo.zza(this.zzdwg[i2], (List<Double>) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 36:
                    zzbdo.zzb(this.zzdwg[i2], (List<Float>) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 37:
                    zzbdo.zzc(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 38:
                    zzbdo.zzd(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 39:
                    zzbdo.zzh(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 40:
                    zzbdo.zzf(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 41:
                    zzbdo.zzk(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 42:
                    zzbdo.zzn(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 43:
                    zzbdo.zzi(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 44:
                    zzbdo.zzm(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 45:
                    zzbdo.zzl(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 46:
                    zzbdo.zzg(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 47:
                    zzbdo.zzj(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 48:
                    zzbdo.zze(this.zzdwg[i2], (List) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, true);
                    break;
                case 49:
                    zzbdo.zzb(this.zzdwg[i2], (List<?>) zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar, zzcq(i2));
                    break;
                case 50:
                    zza(zzbeyVar, i3, zzbek.zzp(t, 1048575 & iZzct2), i2);
                    break;
                case 51:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zza(i3, zzf(t, 1048575 & iZzct2));
                    }
                    break;
                case 52:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zza(i3, zzg(t, 1048575 & iZzct2));
                    }
                    break;
                case 53:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzi(i3, zzi(t, 1048575 & iZzct2));
                    }
                    break;
                case 54:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zza(i3, zzi(t, 1048575 & iZzct2));
                    }
                    break;
                case 55:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzm(i3, zzh(t, 1048575 & iZzct2));
                    }
                    break;
                case 56:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzc(i3, zzi(t, 1048575 & iZzct2));
                    }
                    break;
                case 57:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzp(i3, zzh(t, 1048575 & iZzct2));
                    }
                    break;
                case 58:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzf(i3, zzj(t, 1048575 & iZzct2));
                    }
                    break;
                case 59:
                    if (zza(t, i3, i2)) {
                        zza(i3, zzbek.zzp(t, 1048575 & iZzct2), zzbeyVar);
                    }
                    break;
                case 60:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zza(i3, zzbek.zzp(t, 1048575 & iZzct2), zzcq(i2));
                    }
                    break;
                case 61:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zza(i3, (zzbah) zzbek.zzp(t, 1048575 & iZzct2));
                    }
                    break;
                case 62:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzn(i3, zzh(t, 1048575 & iZzct2));
                    }
                    break;
                case 63:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzx(i3, zzh(t, 1048575 & iZzct2));
                    }
                    break;
                case 64:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzw(i3, zzh(t, 1048575 & iZzct2));
                    }
                    break;
                case 65:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzj(i3, zzi(t, 1048575 & iZzct2));
                    }
                    break;
                case 66:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzo(i3, zzh(t, 1048575 & iZzct2));
                    }
                    break;
                case 67:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzb(i3, zzi(t, 1048575 & iZzct2));
                    }
                    break;
                case 68:
                    if (zza(t, i3, i2)) {
                        zzbeyVar.zzb(i3, zzbek.zzp(t, 1048575 & iZzct2), zzcq(i2));
                    }
                    break;
            }
            i2 += 4;
            entry5 = entry6;
        }
        while (entry5 != null) {
            this.zzdww.zza(zzbeyVar, entry5);
            entry5 = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzdwv, t, zzbeyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zza(T t, byte[] bArr, int i, int i2, zzbae zzbaeVar) throws IOException {
        zzbbt zzbbtVarZzbm;
        if (!this.zzdwo) {
            zza(t, bArr, i, i2, 0, zzbaeVar);
            return;
        }
        Unsafe unsafe = zzdwf;
        int iZza = i;
        while (iZza < i2) {
            int iZza2 = iZza + 1;
            int i3 = bArr[iZza];
            if (i3 < 0) {
                iZza2 = zzbad.zza(i3, bArr, iZza2, zzbaeVar);
                i3 = zzbaeVar.zzdpl;
            }
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            int iZzcw = zzcw(i4);
            if (iZzcw >= 0) {
                int i6 = this.zzdwg[iZzcw + 1];
                int i7 = (267386880 & i6) >>> 20;
                long j = 1048575 & i6;
                if (i7 <= 17) {
                    switch (i7) {
                        case 0:
                            if (i5 == 1) {
                                zzbek.zza(t, j, zzbad.zzg(bArr, iZza2));
                                iZza = iZza2 + 8;
                            }
                            break;
                        case 1:
                            if (i5 == 5) {
                                zzbek.zza((Object) t, j, zzbad.zzh(bArr, iZza2));
                                iZza = iZza2 + 4;
                            }
                            break;
                        case 2:
                        case 3:
                            if (i5 == 0) {
                                iZza = zzbad.zzb(bArr, iZza2, zzbaeVar);
                                unsafe.putLong(t, j, zzbaeVar.zzdpm);
                            }
                            break;
                        case 4:
                        case 11:
                            if (i5 == 0) {
                                iZza = zzbad.zza(bArr, iZza2, zzbaeVar);
                                unsafe.putInt(t, j, zzbaeVar.zzdpl);
                            }
                            break;
                        case 5:
                        case 14:
                            if (i5 == 1) {
                                unsafe.putLong(t, j, zzbad.zzf(bArr, iZza2));
                                iZza = iZza2 + 8;
                            }
                            break;
                        case 6:
                        case 13:
                            if (i5 == 5) {
                                unsafe.putInt(t, j, zzbad.zze(bArr, iZza2));
                                iZza = iZza2 + 4;
                            }
                            break;
                        case 7:
                            if (i5 == 0) {
                                iZza = zzbad.zzb(bArr, iZza2, zzbaeVar);
                                zzbek.zza(t, j, zzbaeVar.zzdpm != 0);
                            }
                            break;
                        case 8:
                            if (i5 == 2) {
                                int iZzc = (536870912 & i6) == 0 ? zzbad.zzc(bArr, iZza2, zzbaeVar) : zzbad.zzd(bArr, iZza2, zzbaeVar);
                                unsafe.putObject(t, j, zzbaeVar.zzdpn);
                                iZza = iZzc;
                            }
                            break;
                        case 9:
                            if (i5 == 2) {
                                iZza = zza(zzcq(iZzcw), bArr, iZza2, i2, zzbaeVar);
                                Object object = unsafe.getObject(t, j);
                                if (object != null) {
                                    unsafe.putObject(t, j, zzbbq.zza(object, zzbaeVar.zzdpn));
                                } else {
                                    unsafe.putObject(t, j, zzbaeVar.zzdpn);
                                }
                            }
                            break;
                        case 10:
                            if (i5 == 2) {
                                iZza = zzbad.zze(bArr, iZza2, zzbaeVar);
                                unsafe.putObject(t, j, zzbaeVar.zzdpn);
                            }
                            break;
                        case 12:
                            if (i5 == 0) {
                                iZza = zzbad.zza(bArr, iZza2, zzbaeVar);
                                unsafe.putInt(t, j, zzbaeVar.zzdpl);
                            }
                            break;
                        case 15:
                            if (i5 == 0) {
                                iZza = zzbad.zza(bArr, iZza2, zzbaeVar);
                                unsafe.putInt(t, j, zzbaq.zzbu(zzbaeVar.zzdpl));
                            }
                            break;
                        case 16:
                            if (i5 == 0) {
                                iZza = zzbad.zzb(bArr, iZza2, zzbaeVar);
                                unsafe.putLong(t, j, zzbaq.zzl(zzbaeVar.zzdpm));
                            }
                            break;
                        default:
                            iZza = iZza2;
                            iZza = zza(i3, bArr, iZza, i2, t, zzbaeVar);
                            break;
                    }
                } else if (i7 == 27) {
                    if (i5 == 2) {
                        zzbbt zzbbtVar = (zzbbt) unsafe.getObject(t, j);
                        if (zzbbtVar.zzaay()) {
                            zzbbtVarZzbm = zzbbtVar;
                        } else {
                            int size = zzbbtVar.size();
                            zzbbtVarZzbm = zzbbtVar.zzbm(size == 0 ? 10 : size << 1);
                            unsafe.putObject(t, j, zzbbtVarZzbm);
                        }
                        iZza = zza((zzbdm<?>) zzcq(iZzcw), i3 == true ? 1 : 0, bArr, iZza2, i2, (zzbbt<?>) zzbbtVarZzbm, zzbaeVar);
                    }
                } else if (i7 <= 49) {
                    iZza = zza(t, bArr, iZza2, i2, i3, i4, i5, iZzcw, i6, i7, j, zzbaeVar);
                    if (iZza == iZza2) {
                        iZza = zza(i3, bArr, iZza, i2, t, zzbaeVar);
                    }
                } else if (i7 != 50) {
                    iZza = zza(t, bArr, iZza2, i2, i3 == true ? 1 : 0, i4, i5, i6, i7, j, iZzcw, zzbaeVar);
                    if (iZza == iZza2) {
                        iZza = zza(i3, bArr, iZza, i2, t, zzbaeVar);
                    }
                } else if (i5 == 2) {
                    iZza = zza(t, bArr, iZza2, i2, iZzcw, i4, j, zzbaeVar);
                    if (iZza == iZza2) {
                        iZza = zza(i3, bArr, iZza, i2, t, zzbaeVar);
                    }
                }
            }
            iZza = iZza2;
            iZza = zza(i3, bArr, iZza, i2, t, zzbaeVar);
        }
        if (iZza != i2) {
            throw zzbbu.zzadr();
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0108  */
    /* JADX WARN: Code duplicated, block: B:70:0x0120 A[PHI: r0
      0x0120: PHI (r0v12 int) = (r0v11 int), (r0v59 int) binds: [B:11:0x0021, B:13:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31, types: [com.google.android.gms.internal.ads.zzbdm] */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.google.android.gms.internal.ads.zzbdm] */
    @Override // com.google.android.gms.internal.ads.zzbdm
    public final boolean zzaa(T t) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        if (this.zzdwq == null || this.zzdwq.length == 0) {
            return true;
        }
        int i3 = -1;
        int i4 = 0;
        int[] iArr = this.zzdwq;
        int length = iArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = iArr[i5];
            int iZzcw = zzcw(i6);
            int iZzct = zzct(iZzcw);
            int i7 = 0;
            if (this.zzdwo) {
                i = i7;
                i2 = i3;
            } else {
                int i8 = this.zzdwg[iZzcw + 2];
                i2 = i8 & 1048575;
                i7 = 1 << (i8 >>> 20);
                if (i2 != i3) {
                    i4 = zzdwf.getInt(t, i2);
                    i = i7;
                } else {
                    i = i7;
                    i2 = i3;
                }
            }
            if (((268435456 & iZzct) != 0) && !zza(t, iZzcw, i4, i)) {
                return false;
            }
            switch ((267386880 & iZzct) >>> 20) {
                case 9:
                case 17:
                    if (zza(t, iZzcw, i4, i) && !zza(t, iZzct, zzcq(iZzcw))) {
                        return false;
                    }
                    break;
                    break;
                case 27:
                case 49:
                    List list = (List) zzbek.zzp(t, 1048575 & iZzct);
                    if (list.isEmpty()) {
                        z2 = true;
                    } else {
                        ?? Zzcq = zzcq(iZzcw);
                        int i9 = 0;
                        while (true) {
                            if (i9 >= list.size()) {
                                z2 = true;
                            } else if (Zzcq.zzaa(list.get(i9))) {
                                i9++;
                            } else {
                                z2 = false;
                            }
                        }
                    }
                    if (!z2) {
                        return false;
                    }
                    break;
                    break;
                case 50:
                    Map<?, ?> mapZzt = this.zzdwx.zzt(zzbek.zzp(t, 1048575 & iZzct));
                    if (mapZzt.isEmpty()) {
                        z = true;
                    } else {
                        if (this.zzdwx.zzx(zzcr(iZzcw)).zzdwa.zzagl() == zzbex.MESSAGE) {
                            ?? Zze = 0;
                            Iterator<?> it = mapZzt.values().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object next = it.next();
                                    if (Zze == 0) {
                                        Zze = Zze;
                                        Zze = zzbdg.zzaeo().zze(next.getClass());
                                    }
                                    Zze = Zze;
                                    if (!Zze.zzaa(next)) {
                                        z = false;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        } else {
                            z = true;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                    break;
                    break;
                case 60:
                case 68:
                    if (zza(t, i6, iZzcw) && !zza(t, iZzct, zzcq(iZzcw))) {
                        return false;
                    }
                    break;
                    break;
            }
            i5++;
            i3 = i2;
        }
        return !this.zzdwm || this.zzdww.zzm(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zzc(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.zzdwg.length; i += 4) {
            int iZzct = zzct(i);
            long j = 1048575 & iZzct;
            int i2 = this.zzdwg[i];
            switch ((iZzct & 267386880) >>> 20) {
                case 0:
                    if (zza(t2, i)) {
                        zzbek.zza(t, j, zzbek.zzo(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 1:
                    if (zza(t2, i)) {
                        zzbek.zza((Object) t, j, zzbek.zzn(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 2:
                    if (zza(t2, i)) {
                        zzbek.zza((Object) t, j, zzbek.zzl(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 3:
                    if (zza(t2, i)) {
                        zzbek.zza((Object) t, j, zzbek.zzl(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 4:
                    if (zza(t2, i)) {
                        zzbek.zzb(t, j, zzbek.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 5:
                    if (zza(t2, i)) {
                        zzbek.zza((Object) t, j, zzbek.zzl(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 6:
                    if (zza(t2, i)) {
                        zzbek.zzb(t, j, zzbek.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 7:
                    if (zza(t2, i)) {
                        zzbek.zza(t, j, zzbek.zzm(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 8:
                    if (zza(t2, i)) {
                        zzbek.zza(t, j, zzbek.zzp(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza(t2, i)) {
                        zzbek.zza(t, j, zzbek.zzp(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 11:
                    if (zza(t2, i)) {
                        zzbek.zzb(t, j, zzbek.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 12:
                    if (zza(t2, i)) {
                        zzbek.zzb(t, j, zzbek.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 13:
                    if (zza(t2, i)) {
                        zzbek.zzb(t, j, zzbek.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 14:
                    if (zza(t2, i)) {
                        zzbek.zza((Object) t, j, zzbek.zzl(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 15:
                    if (zza(t2, i)) {
                        zzbek.zzb(t, j, zzbek.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 16:
                    if (zza(t2, i)) {
                        zzbek.zza((Object) t, j, zzbek.zzl(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzdwu.zza(t, t2, j);
                    break;
                case 50:
                    zzbdo.zza(this.zzdwx, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza(t2, i2, i)) {
                        zzbek.zza(t, j, zzbek.zzp(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza(t2, i2, i)) {
                        zzbek.zza(t, j, zzbek.zzp(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        if (this.zzdwo) {
            return;
        }
        zzbdo.zza(this.zzdwv, t, t2);
        if (this.zzdwm) {
            zzbdo.zza(this.zzdww, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final void zzo(T t) {
        if (this.zzdwr != null) {
            for (int i : this.zzdwr) {
                long jZzct = zzct(i) & 1048575;
                Object objZzp = zzbek.zzp(t, jZzct);
                if (objZzp != null) {
                    zzbek.zza(t, jZzct, this.zzdwx.zzv(objZzp));
                }
            }
        }
        if (this.zzdws != null) {
            for (int i2 : this.zzdws) {
                this.zzdwu.zzb(t, i2);
            }
        }
        this.zzdwv.zzo(t);
        if (this.zzdwm) {
            this.zzdww.zzo(t);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdm
    public final int zzy(T t) {
        int i;
        if (this.zzdwo) {
            Unsafe unsafe = zzdwf;
            int iZzc = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.zzdwg.length) {
                    return zza(this.zzdwv, t) + iZzc;
                }
                int iZzct = zzct(i3);
                int i4 = (267386880 & iZzct) >>> 20;
                int i5 = this.zzdwg[i3];
                long j = iZzct & 1048575;
                int i6 = (i4 < zzbbj.DOUBLE_LIST_PACKED.id() || i4 > zzbbj.SINT64_LIST_PACKED.id()) ? 0 : this.zzdwg[i3 + 2] & 1048575;
                switch (i4) {
                    case 0:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzb(i5, 0.0d);
                        }
                        break;
                    case 1:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzb(i5, 0.0f);
                        }
                        break;
                    case 2:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzd(i5, zzbek.zzl(t, j));
                        }
                        break;
                    case 3:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zze(i5, zzbek.zzl(t, j));
                        }
                        break;
                    case 4:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzq(i5, zzbek.zzk(t, j));
                        }
                        break;
                    case 5:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzg(i5, 0L);
                        }
                        break;
                    case 6:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzt(i5, 0);
                        }
                        break;
                    case 7:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzg(i5, true);
                        }
                        break;
                    case 8:
                        if (zza(t, i3)) {
                            Object objZzp = zzbek.zzp(t, j);
                            iZzc = !(objZzp instanceof zzbah) ? iZzc + zzbav.zzg(i5, (String) objZzp) : iZzc + zzbav.zzc(i5, (zzbah) objZzp);
                        }
                        break;
                    case 9:
                        if (zza(t, i3)) {
                            iZzc += zzbdo.zzc(i5, zzbek.zzp(t, j), zzcq(i3));
                        }
                        break;
                    case 10:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzc(i5, (zzbah) zzbek.zzp(t, j));
                        }
                        break;
                    case 11:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzr(i5, zzbek.zzk(t, j));
                        }
                        break;
                    case 12:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzv(i5, zzbek.zzk(t, j));
                        }
                        break;
                    case 13:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzu(i5, 0);
                        }
                        break;
                    case 14:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzh(i5, 0L);
                        }
                        break;
                    case 15:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzs(i5, zzbek.zzk(t, j));
                        }
                        break;
                    case 16:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzf(i5, zzbek.zzl(t, j));
                        }
                        break;
                    case 17:
                        if (zza(t, i3)) {
                            iZzc += zzbav.zzc(i5, (zzbcu) zzbek.zzp(t, j), zzcq(i3));
                        }
                        break;
                    case 18:
                        iZzc += zzbdo.zzw(i5, zze(t, j), false);
                        break;
                    case 19:
                        iZzc += zzbdo.zzv(i5, zze(t, j), false);
                        break;
                    case 20:
                        iZzc += zzbdo.zzo(i5, zze(t, j), false);
                        break;
                    case 21:
                        iZzc += zzbdo.zzp(i5, zze(t, j), false);
                        break;
                    case 22:
                        iZzc += zzbdo.zzs(i5, zze(t, j), false);
                        break;
                    case 23:
                        iZzc += zzbdo.zzw(i5, zze(t, j), false);
                        break;
                    case 24:
                        iZzc += zzbdo.zzv(i5, zze(t, j), false);
                        break;
                    case 25:
                        iZzc += zzbdo.zzx(i5, zze(t, j), false);
                        break;
                    case 26:
                        iZzc += zzbdo.zzc(i5, zze(t, j));
                        break;
                    case 27:
                        iZzc += zzbdo.zzc(i5, (List<?>) zze(t, j), zzcq(i3));
                        break;
                    case 28:
                        iZzc += zzbdo.zzd(i5, (List<zzbah>) zze(t, j));
                        break;
                    case 29:
                        iZzc += zzbdo.zzt(i5, zze(t, j), false);
                        break;
                    case 30:
                        iZzc += zzbdo.zzr(i5, zze(t, j), false);
                        break;
                    case 31:
                        iZzc += zzbdo.zzv(i5, zze(t, j), false);
                        break;
                    case 32:
                        iZzc += zzbdo.zzw(i5, zze(t, j), false);
                        break;
                    case 33:
                        iZzc += zzbdo.zzu(i5, zze(t, j), false);
                        break;
                    case 34:
                        iZzc += zzbdo.zzq(i5, zze(t, j), false);
                        break;
                    case 35:
                        int iZzan = zzbdo.zzan((List) unsafe.getObject(t, j));
                        if (iZzan > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzan);
                            }
                            iZzc += iZzan + zzbav.zzcd(i5) + zzbav.zzcf(iZzan);
                        }
                        break;
                    case 36:
                        int iZzam = zzbdo.zzam((List) unsafe.getObject(t, j));
                        if (iZzam > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzam);
                            }
                            iZzc += iZzam + zzbav.zzcd(i5) + zzbav.zzcf(iZzam);
                        }
                        break;
                    case 37:
                        int iZzaf = zzbdo.zzaf((List) unsafe.getObject(t, j));
                        if (iZzaf > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzaf);
                            }
                            iZzc += iZzaf + zzbav.zzcd(i5) + zzbav.zzcf(iZzaf);
                        }
                        break;
                    case 38:
                        int iZzag = zzbdo.zzag((List) unsafe.getObject(t, j));
                        if (iZzag > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzag);
                            }
                            iZzc += iZzag + zzbav.zzcd(i5) + zzbav.zzcf(iZzag);
                        }
                        break;
                    case 39:
                        int iZzaj = zzbdo.zzaj((List) unsafe.getObject(t, j));
                        if (iZzaj > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzaj);
                            }
                            iZzc += iZzaj + zzbav.zzcd(i5) + zzbav.zzcf(iZzaj);
                        }
                        break;
                    case 40:
                        int iZzan2 = zzbdo.zzan((List) unsafe.getObject(t, j));
                        if (iZzan2 > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzan2);
                            }
                            iZzc += iZzan2 + zzbav.zzcd(i5) + zzbav.zzcf(iZzan2);
                        }
                        break;
                    case 41:
                        int iZzam2 = zzbdo.zzam((List) unsafe.getObject(t, j));
                        if (iZzam2 > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzam2);
                            }
                            iZzc += iZzam2 + zzbav.zzcd(i5) + zzbav.zzcf(iZzam2);
                        }
                        break;
                    case 42:
                        int iZzao = zzbdo.zzao((List) unsafe.getObject(t, j));
                        if (iZzao > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzao);
                            }
                            iZzc += iZzao + zzbav.zzcd(i5) + zzbav.zzcf(iZzao);
                        }
                        break;
                    case 43:
                        int iZzak = zzbdo.zzak((List) unsafe.getObject(t, j));
                        if (iZzak > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzak);
                            }
                            iZzc += iZzak + zzbav.zzcd(i5) + zzbav.zzcf(iZzak);
                        }
                        break;
                    case 44:
                        int iZzai = zzbdo.zzai((List) unsafe.getObject(t, j));
                        if (iZzai > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzai);
                            }
                            iZzc += iZzai + zzbav.zzcd(i5) + zzbav.zzcf(iZzai);
                        }
                        break;
                    case 45:
                        int iZzam3 = zzbdo.zzam((List) unsafe.getObject(t, j));
                        if (iZzam3 > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzam3);
                            }
                            iZzc += iZzam3 + zzbav.zzcd(i5) + zzbav.zzcf(iZzam3);
                        }
                        break;
                    case 46:
                        int iZzan3 = zzbdo.zzan((List) unsafe.getObject(t, j));
                        if (iZzan3 > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzan3);
                            }
                            iZzc += iZzan3 + zzbav.zzcd(i5) + zzbav.zzcf(iZzan3);
                        }
                        break;
                    case 47:
                        int iZzal = zzbdo.zzal((List) unsafe.getObject(t, j));
                        if (iZzal > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzal);
                            }
                            iZzc += iZzal + zzbav.zzcd(i5) + zzbav.zzcf(iZzal);
                        }
                        break;
                    case 48:
                        int iZzah = zzbdo.zzah((List) unsafe.getObject(t, j));
                        if (iZzah > 0) {
                            if (this.zzdwp) {
                                unsafe.putInt(t, i6, iZzah);
                            }
                            iZzc += iZzah + zzbav.zzcd(i5) + zzbav.zzcf(iZzah);
                        }
                        break;
                    case 49:
                        iZzc += zzbdo.zzd(i5, zze(t, j), zzcq(i3));
                        break;
                    case 50:
                        iZzc += this.zzdwx.zzb(i5, zzbek.zzp(t, j), zzcr(i3));
                        break;
                    case 51:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzb(i5, 0.0d);
                        }
                        break;
                    case 52:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzb(i5, 0.0f);
                        }
                        break;
                    case 53:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzd(i5, zzi(t, j));
                        }
                        break;
                    case 54:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zze(i5, zzi(t, j));
                        }
                        break;
                    case 55:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzq(i5, zzh(t, j));
                        }
                        break;
                    case 56:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzg(i5, 0L);
                        }
                        break;
                    case 57:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzt(i5, 0);
                        }
                        break;
                    case 58:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzg(i5, true);
                        }
                        break;
                    case 59:
                        if (zza(t, i5, i3)) {
                            Object objZzp2 = zzbek.zzp(t, j);
                            iZzc = !(objZzp2 instanceof zzbah) ? iZzc + zzbav.zzg(i5, (String) objZzp2) : iZzc + zzbav.zzc(i5, (zzbah) objZzp2);
                        }
                        break;
                    case 60:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbdo.zzc(i5, zzbek.zzp(t, j), zzcq(i3));
                        }
                        break;
                    case 61:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzc(i5, (zzbah) zzbek.zzp(t, j));
                        }
                        break;
                    case 62:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzr(i5, zzh(t, j));
                        }
                        break;
                    case 63:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzv(i5, zzh(t, j));
                        }
                        break;
                    case 64:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzu(i5, 0);
                        }
                        break;
                    case 65:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzh(i5, 0L);
                        }
                        break;
                    case 66:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzs(i5, zzh(t, j));
                        }
                        break;
                    case 67:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzf(i5, zzi(t, j));
                        }
                        break;
                    case 68:
                        if (zza(t, i5, i3)) {
                            iZzc += zzbav.zzc(i5, (zzbcu) zzbek.zzp(t, j), zzcq(i3));
                        }
                        break;
                }
                i2 = i3 + 4;
            }
        } else {
            int i7 = 0;
            Unsafe unsafe2 = zzdwf;
            int i8 = -1;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                int iZzc2 = i7;
                if (i10 >= this.zzdwg.length) {
                    int iZza = zza(this.zzdwv, t) + iZzc2;
                    return this.zzdwm ? iZza + this.zzdww.zzm(t).zzacw() : iZza;
                }
                int iZzct2 = zzct(i10);
                int i11 = this.zzdwg[i10];
                int i12 = (267386880 & iZzct2) >>> 20;
                int i13 = 0;
                if (i12 <= 17) {
                    i = this.zzdwg[i10 + 2];
                    int i14 = 1048575 & i;
                    if (i14 != i8) {
                        i9 = unsafe2.getInt(t, i14);
                        i8 = i14;
                    }
                    i13 = 1 << (i >>> 20);
                } else {
                    i = (!this.zzdwp || i12 < zzbbj.DOUBLE_LIST_PACKED.id() || i12 > zzbbj.SINT64_LIST_PACKED.id()) ? 0 : this.zzdwg[i10 + 2] & 1048575;
                }
                long j2 = iZzct2 & 1048575;
                switch (i12) {
                    case 0:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzb(i11, 0.0d);
                        }
                        break;
                    case 1:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzb(i11, 0.0f);
                        }
                        break;
                    case 2:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzd(i11, unsafe2.getLong(t, j2));
                        }
                        break;
                    case 3:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zze(i11, unsafe2.getLong(t, j2));
                        }
                        break;
                    case 4:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzq(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 5:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzg(i11, 0L);
                        }
                        break;
                    case 6:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzt(i11, 0);
                        }
                        break;
                    case 7:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzg(i11, true);
                        }
                        break;
                    case 8:
                        if ((i13 & i9) != 0) {
                            Object object = unsafe2.getObject(t, j2);
                            iZzc2 = !(object instanceof zzbah) ? iZzc2 + zzbav.zzg(i11, (String) object) : iZzc2 + zzbav.zzc(i11, (zzbah) object);
                        }
                        break;
                    case 9:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbdo.zzc(i11, unsafe2.getObject(t, j2), zzcq(i10));
                        }
                        break;
                    case 10:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzc(i11, (zzbah) unsafe2.getObject(t, j2));
                        }
                        break;
                    case 11:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzr(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 12:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzv(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 13:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzu(i11, 0);
                        }
                        break;
                    case 14:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzh(i11, 0L);
                        }
                        break;
                    case 15:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzs(i11, unsafe2.getInt(t, j2));
                        }
                        break;
                    case 16:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzf(i11, unsafe2.getLong(t, j2));
                        }
                        break;
                    case 17:
                        if ((i13 & i9) != 0) {
                            iZzc2 += zzbav.zzc(i11, (zzbcu) unsafe2.getObject(t, j2), zzcq(i10));
                        }
                        break;
                    case 18:
                        iZzc2 += zzbdo.zzw(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 19:
                        iZzc2 += zzbdo.zzv(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 20:
                        iZzc2 += zzbdo.zzo(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 21:
                        iZzc2 += zzbdo.zzp(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 22:
                        iZzc2 += zzbdo.zzs(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 23:
                        iZzc2 += zzbdo.zzw(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 24:
                        iZzc2 += zzbdo.zzv(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 25:
                        iZzc2 += zzbdo.zzx(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 26:
                        iZzc2 += zzbdo.zzc(i11, (List) unsafe2.getObject(t, j2));
                        break;
                    case 27:
                        iZzc2 += zzbdo.zzc(i11, (List<?>) unsafe2.getObject(t, j2), zzcq(i10));
                        break;
                    case 28:
                        iZzc2 += zzbdo.zzd(i11, (List<zzbah>) unsafe2.getObject(t, j2));
                        break;
                    case 29:
                        iZzc2 += zzbdo.zzt(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 30:
                        iZzc2 += zzbdo.zzr(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 31:
                        iZzc2 += zzbdo.zzv(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 32:
                        iZzc2 += zzbdo.zzw(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 33:
                        iZzc2 += zzbdo.zzu(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 34:
                        iZzc2 += zzbdo.zzq(i11, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 35:
                        int iZzan4 = zzbdo.zzan((List) unsafe2.getObject(t, j2));
                        if (iZzan4 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzan4);
                            }
                            iZzc2 += iZzan4 + zzbav.zzcd(i11) + zzbav.zzcf(iZzan4);
                        }
                        break;
                    case 36:
                        int iZzam4 = zzbdo.zzam((List) unsafe2.getObject(t, j2));
                        if (iZzam4 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzam4);
                            }
                            iZzc2 += iZzam4 + zzbav.zzcd(i11) + zzbav.zzcf(iZzam4);
                        }
                        break;
                    case 37:
                        int iZzaf2 = zzbdo.zzaf((List) unsafe2.getObject(t, j2));
                        if (iZzaf2 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzaf2);
                            }
                            iZzc2 += iZzaf2 + zzbav.zzcd(i11) + zzbav.zzcf(iZzaf2);
                        }
                        break;
                    case 38:
                        int iZzag2 = zzbdo.zzag((List) unsafe2.getObject(t, j2));
                        if (iZzag2 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzag2);
                            }
                            iZzc2 += iZzag2 + zzbav.zzcd(i11) + zzbav.zzcf(iZzag2);
                        }
                        break;
                    case 39:
                        int iZzaj2 = zzbdo.zzaj((List) unsafe2.getObject(t, j2));
                        if (iZzaj2 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzaj2);
                            }
                            iZzc2 += iZzaj2 + zzbav.zzcd(i11) + zzbav.zzcf(iZzaj2);
                        }
                        break;
                    case 40:
                        int iZzan5 = zzbdo.zzan((List) unsafe2.getObject(t, j2));
                        if (iZzan5 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzan5);
                            }
                            iZzc2 += iZzan5 + zzbav.zzcd(i11) + zzbav.zzcf(iZzan5);
                        }
                        break;
                    case 41:
                        int iZzam5 = zzbdo.zzam((List) unsafe2.getObject(t, j2));
                        if (iZzam5 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzam5);
                            }
                            iZzc2 += iZzam5 + zzbav.zzcd(i11) + zzbav.zzcf(iZzam5);
                        }
                        break;
                    case 42:
                        int iZzao2 = zzbdo.zzao((List) unsafe2.getObject(t, j2));
                        if (iZzao2 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzao2);
                            }
                            iZzc2 += iZzao2 + zzbav.zzcd(i11) + zzbav.zzcf(iZzao2);
                        }
                        break;
                    case 43:
                        int iZzak2 = zzbdo.zzak((List) unsafe2.getObject(t, j2));
                        if (iZzak2 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzak2);
                            }
                            iZzc2 += iZzak2 + zzbav.zzcd(i11) + zzbav.zzcf(iZzak2);
                        }
                        break;
                    case 44:
                        int iZzai2 = zzbdo.zzai((List) unsafe2.getObject(t, j2));
                        if (iZzai2 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzai2);
                            }
                            iZzc2 += iZzai2 + zzbav.zzcd(i11) + zzbav.zzcf(iZzai2);
                        }
                        break;
                    case 45:
                        int iZzam6 = zzbdo.zzam((List) unsafe2.getObject(t, j2));
                        if (iZzam6 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzam6);
                            }
                            iZzc2 += iZzam6 + zzbav.zzcd(i11) + zzbav.zzcf(iZzam6);
                        }
                        break;
                    case 46:
                        int iZzan6 = zzbdo.zzan((List) unsafe2.getObject(t, j2));
                        if (iZzan6 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzan6);
                            }
                            iZzc2 += iZzan6 + zzbav.zzcd(i11) + zzbav.zzcf(iZzan6);
                        }
                        break;
                    case 47:
                        int iZzal2 = zzbdo.zzal((List) unsafe2.getObject(t, j2));
                        if (iZzal2 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzal2);
                            }
                            iZzc2 += iZzal2 + zzbav.zzcd(i11) + zzbav.zzcf(iZzal2);
                        }
                        break;
                    case 48:
                        int iZzah2 = zzbdo.zzah((List) unsafe2.getObject(t, j2));
                        if (iZzah2 > 0) {
                            if (this.zzdwp) {
                                unsafe2.putInt(t, i, iZzah2);
                            }
                            iZzc2 += iZzah2 + zzbav.zzcd(i11) + zzbav.zzcf(iZzah2);
                        }
                        break;
                    case 49:
                        iZzc2 += zzbdo.zzd(i11, (List) unsafe2.getObject(t, j2), zzcq(i10));
                        break;
                    case 50:
                        iZzc2 += this.zzdwx.zzb(i11, unsafe2.getObject(t, j2), zzcr(i10));
                        break;
                    case 51:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzb(i11, 0.0d);
                        }
                        break;
                    case 52:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzb(i11, 0.0f);
                        }
                        break;
                    case 53:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzd(i11, zzi(t, j2));
                        }
                        break;
                    case 54:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zze(i11, zzi(t, j2));
                        }
                        break;
                    case 55:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzq(i11, zzh(t, j2));
                        }
                        break;
                    case 56:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzg(i11, 0L);
                        }
                        break;
                    case 57:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzt(i11, 0);
                        }
                        break;
                    case 58:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzg(i11, true);
                        }
                        break;
                    case 59:
                        if (zza(t, i11, i10)) {
                            Object object2 = unsafe2.getObject(t, j2);
                            iZzc2 = !(object2 instanceof zzbah) ? iZzc2 + zzbav.zzg(i11, (String) object2) : iZzc2 + zzbav.zzc(i11, (zzbah) object2);
                        }
                        break;
                    case 60:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbdo.zzc(i11, unsafe2.getObject(t, j2), zzcq(i10));
                        }
                        break;
                    case 61:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzc(i11, (zzbah) unsafe2.getObject(t, j2));
                        }
                        break;
                    case 62:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzr(i11, zzh(t, j2));
                        }
                        break;
                    case 63:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzv(i11, zzh(t, j2));
                        }
                        break;
                    case 64:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzu(i11, 0);
                        }
                        break;
                    case 65:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzh(i11, 0L);
                        }
                        break;
                    case 66:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzs(i11, zzh(t, j2));
                        }
                        break;
                    case 67:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzf(i11, zzi(t, j2));
                        }
                        break;
                    case 68:
                        if (zza(t, i11, i10)) {
                            iZzc2 += zzbav.zzc(i11, (zzbcu) unsafe2.getObject(t, j2), zzcq(i10));
                        }
                        break;
                }
                i7 = iZzc2;
                i10 += 4;
            }
        }
    }
}
