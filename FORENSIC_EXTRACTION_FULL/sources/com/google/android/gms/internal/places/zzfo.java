package com.google.android.gms.internal.places;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzfo extends zzfm {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int tag;
    private final boolean zzno;
    private final int zznp;
    private int zznq;

    public zzfo(ByteBuffer byteBuffer, boolean z) {
        super(null);
        this.zzno = true;
        this.buffer = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.pos = iArrayOffset;
        this.zznp = iArrayOffset;
        this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final byte readByte() throws IOException {
        if (this.pos == this.limit) {
            throw zzhh.zzdz();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzaa(int i) throws IOException {
        zzx(i);
        if ((i & 3) != 0) {
            throw zzhh.zzef();
        }
    }

    private final void zzab(int i) throws IOException {
        if (this.pos != i) {
            throw zzhh.zzdz();
        }
    }

    private final Object zzb(zzke zzkeVar, Class<?> cls, zzgl zzglVar) throws IOException {
        switch (zzfn.zznn[zzkeVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbn());
            case 2:
                return zzbp();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbr());
            case 5:
                return Integer.valueOf(zzbm());
            case 6:
                return Long.valueOf(zzbl());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbk());
            case 9:
                return Long.valueOf(zzbj());
            case 10:
                return zzb(cls, zzglVar);
            case 11:
                return Integer.valueOf(zzbs());
            case 12:
                return Long.valueOf(zzbt());
            case 13:
                return Integer.valueOf(zzbu());
            case 14:
                return Long.valueOf(zzbv());
            case 15:
                return zzc(true);
            case 16:
                return Integer.valueOf(zzbq());
            case 17:
                return Long.valueOf(zzbi());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zzb(List<String> list, boolean z) throws IOException {
        int i;
        int i2;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzed();
        }
        if (!(list instanceof zzhq) || z) {
            do {
                list.add(zzc(z));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzhq zzhqVar = (zzhq) list;
        do {
            zzhqVar.zzd(zzbp());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    private final boolean zzbf() {
        return this.pos == this.limit;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0090 A[PHI: r2
      0x0090: PHI (r2v8 int) = (r2v7 int), (r2v10 int), (r2v12 int) binds: [B:24:0x0061, B:28:0x0071, B:32:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    private final int zzbw() throws IOException {
        int i;
        int i2 = this.pos;
        if (this.limit == this.pos) {
            throw zzhh.zzdz();
        }
        int i3 = i2 + 1;
        byte b = this.buffer[i2];
        if (b >= 0) {
            this.pos = i3;
            return b;
        }
        if (this.limit - i3 < 9) {
            return (int) zzby();
        }
        int i4 = i3 + 1;
        int i5 = b ^ (this.buffer[i3] << 7);
        if (i5 < 0) {
            i = i5 ^ (-128);
        } else {
            int i6 = i4 + 1;
            int i7 = i5 ^ (this.buffer[i4] << 14);
            if (i7 >= 0) {
                i = i7 ^ 16256;
                i4 = i6;
            } else {
                i4 = i6 + 1;
                int i8 = i7 ^ (this.buffer[i6] << 21);
                if (i8 < 0) {
                    i = i8 ^ (-2080896);
                } else {
                    int i9 = i4 + 1;
                    byte b2 = this.buffer[i4];
                    i = (i8 ^ (b2 << 28)) ^ 266354560;
                    if (b2 < 0) {
                        i4 = i9 + 1;
                        if (this.buffer[i9] < 0) {
                            i9 = i4 + 1;
                            if (this.buffer[i4] < 0) {
                                i4 = i9 + 1;
                                if (this.buffer[i9] < 0) {
                                    i9 = i4 + 1;
                                    if (this.buffer[i4] < 0) {
                                        i4 = i9 + 1;
                                        if (this.buffer[i9] < 0) {
                                            throw zzhh.zzeb();
                                        }
                                    } else {
                                        i4 = i9;
                                    }
                                }
                            } else {
                                i4 = i9;
                            }
                        }
                    } else {
                        i4 = i9;
                    }
                }
            }
        }
        this.pos = i4;
        return i;
    }

    private final long zzbx() throws IOException {
        long j;
        int i = this.pos;
        if (this.limit == i) {
            throw zzhh.zzdz();
        }
        byte[] bArr = this.buffer;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            this.pos = i2;
            return b;
        }
        if (this.limit - i2 < 9) {
            return zzby();
        }
        int i3 = i2 + 1;
        int i4 = b ^ (bArr[i2] << 7);
        if (i4 < 0) {
            j = i4 ^ (-128);
        } else {
            int i5 = i3 + 1;
            int i6 = i4 ^ (bArr[i3] << 14);
            if (i6 >= 0) {
                j = i6 ^ 16256;
                i3 = i5;
            } else {
                i3 = i5 + 1;
                int i7 = i6 ^ (bArr[i5] << 21);
                if (i7 < 0) {
                    j = i7 ^ (-2080896);
                } else {
                    int i8 = i3 + 1;
                    long j2 = ((long) i7) ^ (((long) bArr[i3]) << 28);
                    if (j2 >= 0) {
                        j = j2 ^ 266354560;
                        i3 = i8;
                    } else {
                        i3 = i8 + 1;
                        long j3 = j2 ^ (((long) bArr[i8]) << 35);
                        if (j3 < 0) {
                            j = j3 ^ (-34093383808L);
                        } else {
                            int i9 = i3 + 1;
                            long j4 = j3 ^ (((long) bArr[i3]) << 42);
                            if (j4 >= 0) {
                                j = j4 ^ 4363953127296L;
                                i3 = i9;
                            } else {
                                i3 = i9 + 1;
                                long j5 = j4 ^ (((long) bArr[i9]) << 49);
                                if (j5 < 0) {
                                    j = j5 ^ (-558586000294016L);
                                } else {
                                    int i10 = i3 + 1;
                                    j = (j5 ^ (((long) bArr[i3]) << 56)) ^ 71499008037633920L;
                                    if (j < 0) {
                                        i3 = i10 + 1;
                                        if (bArr[i10] < 0) {
                                            throw zzhh.zzeb();
                                        }
                                    } else {
                                        i3 = i10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.pos = i3;
        return j;
    }

    private final long zzby() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte b = readByte();
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw zzhh.zzeb();
    }

    private final int zzbz() throws IOException {
        zzx(4);
        return zzcb();
    }

    private final <T> T zzc(zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        int iZzbw = zzbw();
        zzx(iZzbw);
        int i = this.limit;
        int i2 = iZzbw + this.pos;
        this.limit = i2;
        try {
            T tNewInstance = zziyVar.newInstance();
            zziyVar.zzb(tNewInstance, this, zzglVar);
            zziyVar.zzd(tNewInstance);
            if (this.pos != i2) {
                throw zzhh.zzef();
            }
            this.limit = i;
            return tNewInstance;
        } catch (Throwable th) {
            this.limit = i;
            throw th;
        }
    }

    private final String zzc(boolean z) throws IOException {
        zzy(2);
        int iZzbw = zzbw();
        if (iZzbw == 0) {
            return "";
        }
        zzx(iZzbw);
        if (z && !zzjy.zzh(this.buffer, this.pos, this.pos + iZzbw)) {
            throw zzhh.zzeg();
        }
        String str = new String(this.buffer, this.pos, iZzbw, zzhb.UTF_8);
        this.pos = iZzbw + this.pos;
        return str;
    }

    private final long zzca() throws IOException {
        zzx(8);
        return zzcc();
    }

    private final int zzcb() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzcc() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final <T> T zze(zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        int i = this.zznq;
        this.zznq = ((this.tag >>> 3) << 3) | 4;
        try {
            T tNewInstance = zziyVar.newInstance();
            zziyVar.zzb(tNewInstance, this, zzglVar);
            zziyVar.zzd(tNewInstance);
            if (this.tag != this.zznq) {
                throw zzhh.zzef();
            }
            this.zznq = i;
            return tNewInstance;
        } catch (Throwable th) {
            this.zznq = i;
            throw th;
        }
    }

    private final void zzw(int i) throws IOException {
        zzx(i);
        this.pos += i;
    }

    private final void zzx(int i) throws IOException {
        if (i < 0 || i > this.limit - this.pos) {
            throw zzhh.zzdz();
        }
    }

    private final void zzy(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhh.zzed();
        }
    }

    private final void zzz(int i) throws IOException {
        zzx(i);
        if ((i & 7) != 0) {
            throw zzhh.zzef();
        }
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final double readDouble() throws IOException {
        zzy(1);
        return Double.longBitsToDouble(zzca());
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final float readFloat() throws IOException {
        zzy(5);
        return Float.intBitsToFloat(zzbz());
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final String readString() throws IOException {
        return zzc(false);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void readStringList(List<String> list) throws IOException {
        zzb(list, false);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final <T> T zzb(zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        zzy(2);
        return (T) zzc(zziyVar, zzglVar);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final <T> T zzb(Class<T> cls, zzgl zzglVar) throws IOException {
        zzy(2);
        return (T) zzc(zzis.zzfc().zzg(cls), zzglVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.places.zzix
    public final <T> void zzb(List<T> list, zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        int i;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzed();
        }
        int i2 = this.tag;
        do {
            list.add(zzc(zziyVar, zzglVar));
            if (zzbf()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzbw() == i2);
        this.pos = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.places.zzix
    public final <K, V> void zzb(Map<K, V> map, zzia<K, V> zziaVar, zzgl zzglVar) throws IOException {
        zzy(2);
        int iZzbw = zzbw();
        zzx(iZzbw);
        int i = this.limit;
        this.limit = iZzbw + this.pos;
        try {
            Object objZzb = zziaVar.zzuu;
            Object objZzb2 = zziaVar.zzss;
            while (true) {
                int iZzbg = zzbg();
                if (iZzbg == Integer.MAX_VALUE) {
                    map.put(objZzb, objZzb2);
                    this.limit = i;
                    return;
                }
                switch (iZzbg) {
                    case 1:
                        objZzb = zzb(zziaVar.zzut, (Class<?>) null, (zzgl) null);
                        continue;
                    case 2:
                        objZzb2 = zzb(zziaVar.zzuv, zziaVar.zzss.getClass(), zzglVar);
                        continue;
                    default:
                        try {
                            if (!zzbh()) {
                                throw new zzhh("Unable to parse map entry.");
                            }
                            continue;
                        } catch (zzhi e) {
                            if (!zzbh()) {
                                throw new zzhh("Unable to parse map entry.");
                            }
                        }
                }
                this.limit = i;
                throw th;
            }
        } catch (Throwable th) {
            this.limit = i;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbg() throws IOException {
        if (zzbf()) {
            return Integer.MAX_VALUE;
        }
        this.tag = zzbw();
        if (this.tag != this.zznq) {
            return this.tag >>> 3;
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final boolean zzbh() throws IOException {
        if (zzbf() || this.tag == this.zznq) {
            return false;
        }
        switch (this.tag & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    byte[] bArr = this.buffer;
                    int i = this.pos;
                    int i2 = 0;
                    while (i2 < 10) {
                        int i3 = i + 1;
                        if (bArr[i] >= 0) {
                            this.pos = i3;
                            return true;
                        }
                        i2++;
                        i = i3;
                    }
                }
                for (int i4 = 0; i4 < 10; i4++) {
                    if (readByte() >= 0) {
                        return true;
                    }
                }
                throw zzhh.zzeb();
            case 1:
                zzw(8);
                return true;
            case 2:
                zzw(zzbw());
                return true;
            case 3:
                int i5 = this.zznq;
                this.zznq = ((this.tag >>> 3) << 3) | 4;
                while (zzbg() != Integer.MAX_VALUE && zzbh()) {
                }
                if (this.tag != this.zznq) {
                    throw zzhh.zzef();
                }
                this.zznq = i5;
                return true;
            case 4:
            default:
                throw zzhh.zzed();
            case 5:
                zzw(4);
                return true;
        }
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbi() throws IOException {
        zzy(0);
        return zzbx();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbj() throws IOException {
        zzy(0);
        return zzbx();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbk() throws IOException {
        zzy(0);
        return zzbw();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbl() throws IOException {
        zzy(1);
        return zzca();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbm() throws IOException {
        zzy(5);
        return zzbz();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final boolean zzbn() throws IOException {
        zzy(0);
        return zzbw() != 0;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final String zzbo() throws IOException {
        return zzc(true);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final zzfr zzbp() throws IOException {
        zzy(2);
        int iZzbw = zzbw();
        if (iZzbw == 0) {
            return zzfr.zznt;
        }
        zzx(iZzbw);
        zzfr zzfrVarZzd = this.zzno ? zzfr.zzd(this.buffer, this.pos, iZzbw) : zzfr.zzc(this.buffer, this.pos, iZzbw);
        this.pos = iZzbw + this.pos;
        return zzfrVarZzd;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbq() throws IOException {
        zzy(0);
        return zzbw();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbr() throws IOException {
        zzy(0);
        return zzbw();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbs() throws IOException {
        zzy(5);
        return zzbz();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbt() throws IOException {
        zzy(1);
        return zzca();
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final int zzbu() throws IOException {
        zzy(0);
        return zzga.zzan(zzbw());
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final long zzbv() throws IOException {
        zzy(0);
        return zzga.zzd(zzbx());
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final <T> T zzc(Class<T> cls, zzgl zzglVar) throws IOException {
        zzy(3);
        return (T) zze(zzis.zzfc().zzg(cls), zzglVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.places.zzix
    public final <T> void zzc(List<T> list, zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        int i;
        if ((this.tag & 7) != 3) {
            throw zzhh.zzed();
        }
        int i2 = this.tag;
        do {
            list.add(zze(zziyVar, zzglVar));
            if (zzbf()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzbw() == i2);
        this.pos = i;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final <T> T zzd(zziy<T> zziyVar, zzgl zzglVar) throws IOException {
        zzy(3);
        return (T) zze(zziyVar, zzglVar);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zze(List<Double> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzgi)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzbw = zzbw();
                    zzz(iZzbw);
                    int i3 = iZzbw + this.pos;
                    while (this.pos < i3) {
                        list.add(Double.valueOf(Double.longBitsToDouble(zzcc())));
                    }
                    return;
                default:
                    throw zzhh.zzed();
            }
            do {
                list.add(Double.valueOf(readDouble()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzgi zzgiVar = (zzgi) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzbw2 = zzbw();
                zzz(iZzbw2);
                int i4 = iZzbw2 + this.pos;
                while (this.pos < i4) {
                    zzgiVar.zzd(Double.longBitsToDouble(zzcc()));
                }
                return;
            default:
                throw zzhh.zzed();
        }
        do {
            zzgiVar.zzd(readDouble());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzf(List<Float> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzgw)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzbw = zzbw();
                    zzaa(iZzbw);
                    int i3 = iZzbw + this.pos;
                    while (this.pos < i3) {
                        list.add(Float.valueOf(Float.intBitsToFloat(zzcb())));
                    }
                    return;
                case 3:
                case 4:
                default:
                    throw zzhh.zzed();
                case 5:
                    break;
            }
            do {
                list.add(Float.valueOf(readFloat()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzgw zzgwVar = (zzgw) list;
        switch (this.tag & 7) {
            case 2:
                int iZzbw2 = zzbw();
                zzaa(iZzbw2);
                int i4 = iZzbw2 + this.pos;
                while (this.pos < i4) {
                    zzgwVar.zzf(Float.intBitsToFloat(zzcb()));
                }
                return;
            case 3:
            case 4:
            default:
                throw zzhh.zzed();
            case 5:
                break;
        }
        do {
            zzgwVar.zzf(readFloat());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzg(List<Long> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbw = zzbw() + this.pos;
                    while (this.pos < iZzbw) {
                        list.add(Long.valueOf(zzbx()));
                    }
                    zzab(iZzbw);
                    return;
            }
            do {
                list.add(Long.valueOf(zzbi()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbw2 = zzbw() + this.pos;
                while (this.pos < iZzbw2) {
                    zzhvVar.zzp(zzbx());
                }
                zzab(iZzbw2);
                return;
        }
        do {
            zzhvVar.zzp(zzbi());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzh(List<Long> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbw = zzbw() + this.pos;
                    while (this.pos < iZzbw) {
                        list.add(Long.valueOf(zzbx()));
                    }
                    zzab(iZzbw);
                    return;
            }
            do {
                list.add(Long.valueOf(zzbj()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbw2 = zzbw() + this.pos;
                while (this.pos < iZzbw2) {
                    zzhvVar.zzp(zzbx());
                }
                zzab(iZzbw2);
                return;
        }
        do {
            zzhvVar.zzp(zzbj());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzi(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbw = zzbw() + this.pos;
                    while (this.pos < iZzbw) {
                        list.add(Integer.valueOf(zzbw()));
                    }
                    zzab(iZzbw);
                    return;
            }
            do {
                list.add(Integer.valueOf(zzbk()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbw2 = zzbw() + this.pos;
                while (this.pos < iZzbw2) {
                    zzhaVar.zzbe(zzbw());
                }
                zzab(iZzbw2);
                return;
        }
        do {
            zzhaVar.zzbe(zzbk());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzj(List<Long> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzbw = zzbw();
                    zzz(iZzbw);
                    int i3 = iZzbw + this.pos;
                    while (this.pos < i3) {
                        list.add(Long.valueOf(zzcc()));
                    }
                    return;
                default:
                    throw zzhh.zzed();
            }
            do {
                list.add(Long.valueOf(zzbl()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzbw2 = zzbw();
                zzz(iZzbw2);
                int i4 = iZzbw2 + this.pos;
                while (this.pos < i4) {
                    zzhvVar.zzp(zzcc());
                }
                return;
            default:
                throw zzhh.zzed();
        }
        do {
            zzhvVar.zzp(zzbl());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzk(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzbw = zzbw();
                    zzaa(iZzbw);
                    int i3 = iZzbw + this.pos;
                    while (this.pos < i3) {
                        list.add(Integer.valueOf(zzcb()));
                    }
                    return;
                case 3:
                case 4:
                default:
                    throw zzhh.zzed();
                case 5:
                    break;
            }
            do {
                list.add(Integer.valueOf(zzbm()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 2:
                int iZzbw2 = zzbw();
                zzaa(iZzbw2);
                int i4 = iZzbw2 + this.pos;
                while (this.pos < i4) {
                    zzhaVar.zzbe(zzcb());
                }
                return;
            case 3:
            case 4:
            default:
                throw zzhh.zzed();
            case 5:
                break;
        }
        do {
            zzhaVar.zzbe(zzbm());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzl(List<Boolean> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzfp)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbw = this.pos + zzbw();
                    while (this.pos < iZzbw) {
                        list.add(Boolean.valueOf(zzbw() != 0));
                    }
                    zzab(iZzbw);
                    return;
            }
            do {
                list.add(Boolean.valueOf(zzbn()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzfp zzfpVar = (zzfp) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbw2 = this.pos + zzbw();
                while (this.pos < iZzbw2) {
                    zzfpVar.addBoolean(zzbw() != 0);
                }
                zzab(iZzbw2);
                return;
        }
        do {
            zzfpVar.addBoolean(zzbn());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzm(List<String> list) throws IOException {
        zzb(list, true);
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzn(List<zzfr> list) throws IOException {
        int i;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzed();
        }
        do {
            list.add(zzbp());
            if (zzbf()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzo(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbw = zzbw() + this.pos;
                    while (this.pos < iZzbw) {
                        list.add(Integer.valueOf(zzbw()));
                    }
                    return;
            }
            do {
                list.add(Integer.valueOf(zzbq()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbw2 = zzbw() + this.pos;
                while (this.pos < iZzbw2) {
                    zzhaVar.zzbe(zzbw());
                }
                return;
        }
        do {
            zzhaVar.zzbe(zzbq());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzp(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbw = zzbw() + this.pos;
                    while (this.pos < iZzbw) {
                        list.add(Integer.valueOf(zzbw()));
                    }
                    return;
            }
            do {
                list.add(Integer.valueOf(zzbr()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbw2 = zzbw() + this.pos;
                while (this.pos < iZzbw2) {
                    zzhaVar.zzbe(zzbw());
                }
                return;
        }
        do {
            zzhaVar.zzbe(zzbr());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzq(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 2:
                    int iZzbw = zzbw();
                    zzaa(iZzbw);
                    int i3 = iZzbw + this.pos;
                    while (this.pos < i3) {
                        list.add(Integer.valueOf(zzcb()));
                    }
                    return;
                case 3:
                case 4:
                default:
                    throw zzhh.zzed();
                case 5:
                    break;
            }
            do {
                list.add(Integer.valueOf(zzbs()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 2:
                int iZzbw2 = zzbw();
                zzaa(iZzbw2);
                int i4 = iZzbw2 + this.pos;
                while (this.pos < i4) {
                    zzhaVar.zzbe(zzcb());
                }
                return;
            case 3:
            case 4:
            default:
                throw zzhh.zzed();
            case 5:
                break;
        }
        do {
            zzhaVar.zzbe(zzbs());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzr(List<Long> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int iZzbw = zzbw();
                    zzz(iZzbw);
                    int i3 = iZzbw + this.pos;
                    while (this.pos < i3) {
                        list.add(Long.valueOf(zzcc()));
                    }
                    return;
                default:
                    throw zzhh.zzed();
            }
            do {
                list.add(Long.valueOf(zzbt()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int iZzbw2 = zzbw();
                zzz(iZzbw2);
                int i4 = iZzbw2 + this.pos;
                while (this.pos < i4) {
                    zzhvVar.zzp(zzcc());
                }
                return;
            default:
                throw zzhh.zzed();
        }
        do {
            zzhvVar.zzp(zzbt());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzs(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzha)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbw = zzbw() + this.pos;
                    while (this.pos < iZzbw) {
                        list.add(Integer.valueOf(zzga.zzan(zzbw())));
                    }
                    return;
            }
            do {
                list.add(Integer.valueOf(zzbu()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzha zzhaVar = (zzha) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbw2 = zzbw() + this.pos;
                while (this.pos < iZzbw2) {
                    zzhaVar.zzbe(zzga.zzan(zzbw()));
                }
                return;
        }
        do {
            zzhaVar.zzbe(zzbu());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }

    @Override // com.google.android.gms.internal.places.zzix
    public final void zzt(List<Long> list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzhv)) {
            switch (this.tag & 7) {
                case 0:
                    break;
                case 1:
                default:
                    throw zzhh.zzed();
                case 2:
                    int iZzbw = zzbw() + this.pos;
                    while (this.pos < iZzbw) {
                        list.add(Long.valueOf(zzga.zzd(zzbx())));
                    }
                    return;
            }
            do {
                list.add(Long.valueOf(zzbv()));
                if (zzbf()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzbw() == this.tag);
            this.pos = i;
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        switch (this.tag & 7) {
            case 0:
                break;
            case 1:
            default:
                throw zzhh.zzed();
            case 2:
                int iZzbw2 = zzbw() + this.pos;
                while (this.pos < iZzbw2) {
                    zzhvVar.zzp(zzga.zzd(zzbx()));
                }
                return;
        }
        do {
            zzhvVar.zzp(zzbv());
            if (zzbf()) {
                return;
            } else {
                i2 = this.pos;
            }
        } while (zzbw() == this.tag);
        this.pos = i2;
    }
}
