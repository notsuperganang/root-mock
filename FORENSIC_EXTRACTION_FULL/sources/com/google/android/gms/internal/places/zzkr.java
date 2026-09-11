package com.google.android.gms.internal.places;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzkr implements Cloneable {
    private Object value;
    private zzkp<?, ?> zzaam;
    private List<zzkw> zzaan = new ArrayList();

    zzkr() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzal()];
        zzb(zzkm.zzi(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzhf, reason: merged with bridge method [inline-methods] */
    public final zzkr clone() {
        int i = 0;
        zzkr zzkrVar = new zzkr();
        try {
            zzkrVar.zzaam = this.zzaam;
            if (this.zzaan == null) {
                zzkrVar.zzaan = null;
            } else {
                zzkrVar.zzaan.addAll(this.zzaan);
            }
            if (this.value != null) {
                if (this.value instanceof zzku) {
                    zzkrVar.value = (zzku) ((zzku) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzkrVar.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzkrVar.value = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzkrVar.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzkrVar.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzkrVar.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzkrVar.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzkrVar.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzku[]) {
                    zzku[] zzkuVarArr = (zzku[]) this.value;
                    zzku[] zzkuVarArr2 = new zzku[zzkuVarArr.length];
                    zzkrVar.value = zzkuVarArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzkuVarArr.length) {
                            break;
                        }
                        zzkuVarArr2[i3] = (zzku) zzkuVarArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzkrVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkr)) {
            return false;
        }
        zzkr zzkrVar = (zzkr) obj;
        if (this.value == null || zzkrVar.value == null) {
            if (this.zzaan != null && zzkrVar.zzaan != null) {
                return this.zzaan.equals(zzkrVar.zzaan);
            }
            try {
                return Arrays.equals(toByteArray(), zzkrVar.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        if (this.zzaam != zzkrVar.zzaam) {
            return false;
        }
        if (!this.zzaam.zzaag.isArray()) {
            return this.value.equals(zzkrVar.value);
        }
        if (this.value instanceof byte[]) {
            return Arrays.equals((byte[]) this.value, (byte[]) zzkrVar.value);
        }
        if (this.value instanceof int[]) {
            return Arrays.equals((int[]) this.value, (int[]) zzkrVar.value);
        }
        if (this.value instanceof long[]) {
            return Arrays.equals((long[]) this.value, (long[]) zzkrVar.value);
        }
        if (this.value instanceof float[]) {
            return Arrays.equals((float[]) this.value, (float[]) zzkrVar.value);
        }
        if (this.value instanceof double[]) {
            return Arrays.equals((double[]) this.value, (double[]) zzkrVar.value);
        }
        return this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzkrVar.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzkrVar.value);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    final int zzal() {
        int length = 0;
        if (this.value == null) {
            for (zzkw zzkwVar : this.zzaan) {
                length = zzkwVar.zzoa.length + zzkm.zzba(zzkwVar.tag) + 0 + length;
            }
            return length;
        }
        zzkp<?, ?> zzkpVar = this.zzaam;
        Object obj = this.value;
        if (!zzkpVar.zzaah) {
            return zzkpVar.zzt(obj);
        }
        int length2 = Array.getLength(obj);
        int iZzt = 0;
        for (int i = 0; i < length2; i++) {
            if (Array.get(obj, i) != null) {
                iZzt += zzkpVar.zzt(Array.get(obj, i));
            }
        }
        return iZzt;
    }

    final void zzb(zzkm zzkmVar) throws IOException {
        if (this.value == null) {
            for (zzkw zzkwVar : this.zzaan) {
                zzkmVar.zzbt(zzkwVar.tag);
                zzkmVar.zzk(zzkwVar.zzoa);
            }
            return;
        }
        zzkp<?, ?> zzkpVar = this.zzaam;
        Object obj = this.value;
        if (!zzkpVar.zzaah) {
            zzkpVar.zzb(obj, zzkmVar);
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzkpVar.zzb(obj2, zzkmVar);
            }
        }
    }

    final void zzb(zzkw zzkwVar) throws IOException {
        Object objZzae;
        if (this.zzaan != null) {
            this.zzaan.add(zzkwVar);
            return;
        }
        if (this.value instanceof zzku) {
            byte[] bArr = zzkwVar.zzoa;
            zzkl zzklVarZzk = zzkl.zzk(bArr, 0, bArr.length);
            int iZzcm = zzklVarZzk.zzcm();
            if (iZzcm != bArr.length - zzkm.zzat(iZzcm)) {
                throw zzkt.zzhg();
            }
            objZzae = ((zzku) this.value).zzb(zzklVarZzk);
        } else if (this.value instanceof zzku[]) {
            zzku[] zzkuVarArr = (zzku[]) this.zzaam.zzae(Collections.singletonList(zzkwVar));
            zzku[] zzkuVarArr2 = (zzku[]) this.value;
            objZzae = (zzku[]) Arrays.copyOf(zzkuVarArr2, zzkuVarArr2.length + zzkuVarArr.length);
            System.arraycopy(zzkuVarArr, 0, objZzae, zzkuVarArr2.length, zzkuVarArr.length);
        } else {
            objZzae = this.zzaam.zzae(Collections.singletonList(zzkwVar));
        }
        this.zzaam = this.zzaam;
        this.value = objZzae;
        this.zzaan = null;
    }
}
