package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzdq extends zzko<zzdq> {
    public String[] zzhw = zzkx.zzaaz;
    public int[] zzhx = zzkx.zzaau;
    public byte[][] zzhy = zzkx.zzaba;

    public zzdq() {
        this.zzaaf = null;
        this.zzaap = -1;
    }

    public static zzdq zzb(byte[] bArr) throws zzkt {
        return (zzdq) zzku.zzb(new zzdq(), bArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdq)) {
            return false;
        }
        zzdq zzdqVar = (zzdq) obj;
        if (zzks.equals(this.zzhw, zzdqVar.zzhw) && zzks.equals(this.zzhx, zzdqVar.zzhx) && zzks.zzb(this.zzhy, zzdqVar.zzhy)) {
            if (this.zzaaf == null || this.zzaaf.isEmpty()) {
                return zzdqVar.zzaaf == null || zzdqVar.zzaaf.isEmpty();
            }
            return this.zzaaf.equals(zzdqVar.zzaaf);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzaaf == null || this.zzaaf.isEmpty()) ? 0 : this.zzaaf.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzks.hashCode(this.zzhw)) * 31) + zzks.hashCode(this.zzhx)) * 31) + zzks.zzb(this.zzhy)) * 31);
    }

    @Override // com.google.android.gms.internal.places.zzko, com.google.android.gms.internal.places.zzku
    protected final int zzal() {
        int length;
        int iZzal = super.zzal();
        if (this.zzhw == null || this.zzhw.length <= 0) {
            length = iZzal;
        } else {
            int iZzl = 0;
            int i = 0;
            for (int i2 = 0; i2 < this.zzhw.length; i2++) {
                String str = this.zzhw[i2];
                if (str != null) {
                    i++;
                    iZzl += zzkm.zzl(str);
                }
            }
            length = iZzal + iZzl + (i * 1);
        }
        if (this.zzhx != null && this.zzhx.length > 0) {
            int iZzat = 0;
            for (int i3 = 0; i3 < this.zzhx.length; i3++) {
                iZzat += zzkm.zzat(this.zzhx[i3]);
            }
            length = length + iZzat + (this.zzhx.length * 1);
        }
        if (this.zzhy == null || this.zzhy.length <= 0) {
            return length;
        }
        int iZzj = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzhy.length; i5++) {
            byte[] bArr = this.zzhy[i5];
            if (bArr != null) {
                i4++;
                iZzj += zzkm.zzj(bArr);
            }
        }
        return length + iZzj + (i4 * 1);
    }

    @Override // com.google.android.gms.internal.places.zzku
    public final /* synthetic */ zzku zzb(zzkl zzklVar) throws IOException {
        while (true) {
            int iZzcj = zzklVar.zzcj();
            switch (iZzcj) {
                case 0:
                    break;
                case 10:
                    int iZzc = zzkx.zzc(zzklVar, 10);
                    int length = this.zzhw == null ? 0 : this.zzhw.length;
                    String[] strArr = new String[iZzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzhw, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzklVar.readString();
                        zzklVar.zzcj();
                        length++;
                    }
                    strArr[length] = zzklVar.readString();
                    this.zzhw = strArr;
                    break;
                case 16:
                    int iZzc2 = zzkx.zzc(zzklVar, 16);
                    int length2 = this.zzhx == null ? 0 : this.zzhx.length;
                    int[] iArr = new int[iZzc2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzhx, 0, iArr, 0, length2);
                    }
                    while (length2 < iArr.length - 1) {
                        iArr[length2] = zzklVar.zzcm();
                        zzklVar.zzcj();
                        length2++;
                    }
                    iArr[length2] = zzklVar.zzcm();
                    this.zzhx = iArr;
                    break;
                case 18:
                    int iZzak = zzklVar.zzak(zzklVar.zzcm());
                    int position = zzklVar.getPosition();
                    int i = 0;
                    while (zzklVar.zzhb() > 0) {
                        zzklVar.zzcm();
                        i++;
                    }
                    zzklVar.zzbr(position);
                    int length3 = this.zzhx == null ? 0 : this.zzhx.length;
                    int[] iArr2 = new int[i + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzhx, 0, iArr2, 0, length3);
                    }
                    while (length3 < iArr2.length) {
                        iArr2[length3] = zzklVar.zzcm();
                        length3++;
                    }
                    this.zzhx = iArr2;
                    zzklVar.zzal(iZzak);
                    break;
                case 26:
                    int iZzc3 = zzkx.zzc(zzklVar, 26);
                    int length4 = this.zzhy == null ? 0 : this.zzhy.length;
                    byte[][] bArr = new byte[iZzc3 + length4][];
                    if (length4 != 0) {
                        System.arraycopy(this.zzhy, 0, bArr, 0, length4);
                    }
                    while (length4 < bArr.length - 1) {
                        bArr[length4] = zzklVar.readBytes();
                        zzklVar.zzcj();
                        length4++;
                    }
                    bArr[length4] = zzklVar.readBytes();
                    this.zzhy = bArr;
                    break;
                default:
                    if (!super.zzb(zzklVar, iZzcj)) {
                    }
                    break;
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.places.zzko, com.google.android.gms.internal.places.zzku
    public final void zzb(zzkm zzkmVar) throws IOException {
        if (this.zzhw != null && this.zzhw.length > 0) {
            for (int i = 0; i < this.zzhw.length; i++) {
                String str = this.zzhw[i];
                if (str != null) {
                    zzkmVar.zzb(1, str);
                }
            }
        }
        if (this.zzhx != null && this.zzhx.length > 0) {
            for (int i2 = 0; i2 < this.zzhx.length; i2++) {
                zzkmVar.zze(2, this.zzhx[i2]);
            }
        }
        if (this.zzhy != null && this.zzhy.length > 0) {
            for (int i3 = 0; i3 < this.zzhy.length; i3++) {
                byte[] bArr = this.zzhy[i3];
                if (bArr != null) {
                    zzkmVar.zzb(3, bArr);
                }
            }
        }
        super.zzb(zzkmVar);
    }
}
