package com.google.android.gms.internal.places;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzgn extends zzgm<zzgz.zzf> {
    zzgn() {
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final int zzb(Map.Entry<?, ?> entry) {
        return ((zzgz.zzf) entry.getKey()).number;
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final zzgq<zzgz.zzf> zzb(Object obj) {
        return ((zzgz.zze) obj).zzsm;
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final Object zzb(zzgl zzglVar, zzih zzihVar, int i) {
        return zzglVar.zzb(zzihVar, i);
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final <UT, UB> UB zzb(zzix zzixVar, Object obj, zzgl zzglVar, zzgq<zzgz.zzf> zzgqVar, UB ub, zzjq<UT, UB> zzjqVar) throws IOException {
        zzgz.zzg zzgVar = (zzgz.zzg) obj;
        int i = zzgVar.zzsu.number;
        Object objZzb = null;
        if (zzgVar.zzsu.zzso != zzke.zzzg) {
            switch (zzgo.zznn[zzgVar.zzsu.zzso.ordinal()]) {
                case 1:
                    objZzb = Double.valueOf(zzixVar.readDouble());
                    break;
                case 2:
                    objZzb = Float.valueOf(zzixVar.readFloat());
                    break;
                case 3:
                    objZzb = Long.valueOf(zzixVar.zzbj());
                    break;
                case 4:
                    objZzb = Long.valueOf(zzixVar.zzbi());
                    break;
                case 5:
                    objZzb = Integer.valueOf(zzixVar.zzbk());
                    break;
                case 6:
                    objZzb = Long.valueOf(zzixVar.zzbl());
                    break;
                case 7:
                    objZzb = Integer.valueOf(zzixVar.zzbm());
                    break;
                case 8:
                    objZzb = Boolean.valueOf(zzixVar.zzbn());
                    break;
                case 9:
                    objZzb = Integer.valueOf(zzixVar.zzbq());
                    break;
                case 10:
                    objZzb = Integer.valueOf(zzixVar.zzbs());
                    break;
                case 11:
                    objZzb = Long.valueOf(zzixVar.zzbt());
                    break;
                case 12:
                    objZzb = Integer.valueOf(zzixVar.zzbu());
                    break;
                case 13:
                    objZzb = Long.valueOf(zzixVar.zzbv());
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    objZzb = zzixVar.zzbp();
                    break;
                case 16:
                    objZzb = zzixVar.readString();
                    break;
                case 17:
                    objZzb = zzixVar.zzc(zzgVar.zzst.getClass(), zzglVar);
                    break;
                case 18:
                    objZzb = zzixVar.zzb(zzgVar.zzst.getClass(), zzglVar);
                    break;
            }
        } else {
            int iZzbk = zzixVar.zzbk();
            if (zzgVar.zzsu.zzsn.zzi(iZzbk) == null) {
                return (UB) zzja.zzb(i, iZzbk, ub, zzjqVar);
            }
            objZzb = Integer.valueOf(iZzbk);
        }
        switch (zzgo.zznn[zzgVar.zzsu.zzso.ordinal()]) {
            case 17:
            case 18:
                Object objZzb2 = zzgqVar.zzb(zzgVar.zzsu);
                if (objZzb2 != null) {
                    objZzb = zzhb.zzb(objZzb2, objZzb);
                }
                break;
        }
        zzgqVar.zzb(zzgVar.zzsu, objZzb);
        return ub;
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final void zzb(zzfr zzfrVar, Object obj, zzgl zzglVar, zzgq<zzgz.zzf> zzgqVar) throws IOException {
        byte[] bArr;
        zzgz.zzg zzgVar = (zzgz.zzg) obj;
        zzih zzihVarZzdw = zzgVar.zzst.zzdr().zzdw();
        int size = zzfrVar.size();
        if (size == 0) {
            bArr = zzhb.zztl;
        } else {
            bArr = new byte[size];
            zzfrVar.zzb(bArr, 0, 0, size);
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (!byteBufferWrap.hasArray()) {
            throw new IllegalArgumentException("Direct buffers not yet supported");
        }
        zzfo zzfoVar = new zzfo(byteBufferWrap, true);
        zzis.zzfc().zzp(zzihVarZzdw).zzb(zzihVarZzdw, zzfoVar, zzglVar);
        zzgqVar.zzb(zzgVar.zzsu, zzihVarZzdw);
        if (zzfoVar.zzbg() != Integer.MAX_VALUE) {
            throw zzhh.zzec();
        }
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final void zzb(zzix zzixVar, Object obj, zzgl zzglVar, zzgq<zzgz.zzf> zzgqVar) throws IOException {
        zzgz.zzg zzgVar = (zzgz.zzg) obj;
        zzgqVar.zzb(zzgVar.zzsu, zzixVar.zzb(zzgVar.zzst.getClass(), zzglVar));
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final void zzb(zzkk zzkkVar, Map.Entry<?, ?> entry) throws IOException {
        zzgz.zzf zzfVar = (zzgz.zzf) entry.getKey();
        switch (zzgo.zznn[zzfVar.zzso.ordinal()]) {
            case 1:
                zzkkVar.zzb(zzfVar.number, ((Double) entry.getValue()).doubleValue());
                break;
            case 2:
                zzkkVar.zzc(zzfVar.number, ((Float) entry.getValue()).floatValue());
                break;
            case 3:
                zzkkVar.zzj(zzfVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                zzkkVar.zzb(zzfVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 5:
                zzkkVar.zze(zzfVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 6:
                zzkkVar.zzd(zzfVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 7:
                zzkkVar.zzh(zzfVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 8:
                zzkkVar.zzc(zzfVar.number, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 9:
                zzkkVar.zzf(zzfVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 10:
                zzkkVar.zzo(zzfVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 11:
                zzkkVar.zzk(zzfVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 12:
                zzkkVar.zzg(zzfVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                zzkkVar.zzc(zzfVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 14:
                zzkkVar.zze(zzfVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                zzkkVar.zzb(zzfVar.number, (zzfr) entry.getValue());
                break;
            case 16:
                zzkkVar.zzb(zzfVar.number, (String) entry.getValue());
                break;
            case 17:
                zzkkVar.zzc(zzfVar.number, entry.getValue(), zzis.zzfc().zzg(entry.getValue().getClass()));
                break;
            case 18:
                zzkkVar.zzb(zzfVar.number, entry.getValue(), zzis.zzfc().zzg(entry.getValue().getClass()));
                break;
        }
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final void zzb(Object obj, zzgq<zzgz.zzf> zzgqVar) {
        ((zzgz.zze) obj).zzsm = zzgqVar;
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final zzgq<zzgz.zzf> zzc(Object obj) {
        zzgq<zzgz.zzf> zzgqVarZzb = zzb(obj);
        if (!zzgqVarZzb.isImmutable()) {
            return zzgqVarZzb;
        }
        zzgq<zzgz.zzf> zzgqVar = (zzgq) zzgqVarZzb.clone();
        zzb(obj, zzgqVar);
        return zzgqVar;
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final void zzd(Object obj) {
        zzb(obj).zzbb();
    }

    @Override // com.google.android.gms.internal.places.zzgm
    final boolean zzf(zzih zzihVar) {
        return zzihVar instanceof zzgz.zze;
    }
}
