package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzyf implements Cloneable {
    private Object value;
    private zzyd<?, ?> zzcfc;
    private List<zzyk> zzcfd = new ArrayList();

    zzyf() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzf()];
        zza(zzya.zzo(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzzc, reason: merged with bridge method [inline-methods] */
    public final zzyf clone() {
        int i = 0;
        zzyf zzyfVar = new zzyf();
        try {
            zzyfVar.zzcfc = this.zzcfc;
            if (this.zzcfd == null) {
                zzyfVar.zzcfd = null;
            } else {
                zzyfVar.zzcfd.addAll(this.zzcfd);
            }
            if (this.value != null) {
                if (this.value instanceof zzyi) {
                    zzyfVar.value = (zzyi) ((zzyi) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzyfVar.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzyfVar.value = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzyfVar.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzyfVar.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzyfVar.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzyfVar.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzyfVar.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzyi[]) {
                    zzyi[] zzyiVarArr = (zzyi[]) this.value;
                    zzyi[] zzyiVarArr2 = new zzyi[zzyiVarArr.length];
                    zzyfVar.value = zzyiVarArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzyiVarArr.length) {
                            break;
                        }
                        zzyiVarArr2[i3] = (zzyi) zzyiVarArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzyfVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyf)) {
            return false;
        }
        zzyf zzyfVar = (zzyf) obj;
        if (this.value == null || zzyfVar.value == null) {
            if (this.zzcfd != null && zzyfVar.zzcfd != null) {
                return this.zzcfd.equals(zzyfVar.zzcfd);
            }
            try {
                return Arrays.equals(toByteArray(), zzyfVar.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        if (this.zzcfc != zzyfVar.zzcfc) {
            return false;
        }
        if (!this.zzcfc.zzcew.isArray()) {
            return this.value.equals(zzyfVar.value);
        }
        if (this.value instanceof byte[]) {
            return Arrays.equals((byte[]) this.value, (byte[]) zzyfVar.value);
        }
        if (this.value instanceof int[]) {
            return Arrays.equals((int[]) this.value, (int[]) zzyfVar.value);
        }
        if (this.value instanceof long[]) {
            return Arrays.equals((long[]) this.value, (long[]) zzyfVar.value);
        }
        if (this.value instanceof float[]) {
            return Arrays.equals((float[]) this.value, (float[]) zzyfVar.value);
        }
        if (this.value instanceof double[]) {
            return Arrays.equals((double[]) this.value, (double[]) zzyfVar.value);
        }
        return this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzyfVar.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzyfVar.value);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    final void zza(zzya zzyaVar) throws IOException {
        if (this.value == null) {
            for (zzyk zzykVar : this.zzcfd) {
                zzyaVar.zzcd(zzykVar.tag);
                zzyaVar.zzp(zzykVar.zzbtz);
            }
            return;
        }
        zzyd<?, ?> zzydVar = this.zzcfc;
        Object obj = this.value;
        if (!zzydVar.zzcex) {
            zzydVar.zza(obj, zzyaVar);
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzydVar.zza(obj2, zzyaVar);
            }
        }
    }

    final void zza(zzyk zzykVar) throws IOException {
        Object objZzai;
        if (this.zzcfd != null) {
            this.zzcfd.add(zzykVar);
            return;
        }
        if (this.value instanceof zzyi) {
            byte[] bArr = zzykVar.zzbtz;
            zzxz zzxzVarZzj = zzxz.zzj(bArr, 0, bArr.length);
            int iZzvb = zzxzVarZzj.zzvb();
            if (iZzvb != bArr.length - zzya.zzbe(iZzvb)) {
                throw zzyh.zzzd();
            }
            objZzai = ((zzyi) this.value).zza(zzxzVarZzj);
        } else if (this.value instanceof zzyi[]) {
            zzyi[] zzyiVarArr = (zzyi[]) this.zzcfc.zzai(Collections.singletonList(zzykVar));
            zzyi[] zzyiVarArr2 = (zzyi[]) this.value;
            objZzai = (zzyi[]) Arrays.copyOf(zzyiVarArr2, zzyiVarArr2.length + zzyiVarArr.length);
            System.arraycopy(zzyiVarArr, 0, objZzai, zzyiVarArr2.length, zzyiVarArr.length);
        } else if (this.value instanceof zzvv) {
            objZzai = ((zzvv) this.value).zzwh().zza((zzvv) this.zzcfc.zzai(Collections.singletonList(zzykVar))).zzwo();
        } else if (this.value instanceof zzvv[]) {
            zzvv[] zzvvVarArr = (zzvv[]) this.zzcfc.zzai(Collections.singletonList(zzykVar));
            zzvv[] zzvvVarArr2 = (zzvv[]) this.value;
            objZzai = (zzvv[]) Arrays.copyOf(zzvvVarArr2, zzvvVarArr2.length + zzvvVarArr.length);
            System.arraycopy(zzvvVarArr, 0, objZzai, zzvvVarArr2.length, zzvvVarArr.length);
        } else {
            objZzai = this.zzcfc.zzai(Collections.singletonList(zzykVar));
        }
        this.zzcfc = this.zzcfc;
        this.value = objZzai;
        this.zzcfd = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final <T> T zzb(zzyd<?, T> zzydVar) {
        if (this.value == null) {
            this.zzcfc = zzydVar;
            this.value = zzydVar.zzai(this.zzcfd);
            this.zzcfd = null;
        } else if (!this.zzcfc.equals(zzydVar)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return (T) this.value;
    }

    final int zzf() {
        int length = 0;
        if (this.value == null) {
            for (zzyk zzykVar : this.zzcfd) {
                length = zzykVar.zzbtz.length + zzya.zzbl(zzykVar.tag) + 0 + length;
            }
            return length;
        }
        zzyd<?, ?> zzydVar = this.zzcfc;
        Object obj = this.value;
        if (!zzydVar.zzcex) {
            return zzydVar.zzao(obj);
        }
        int length2 = Array.getLength(obj);
        int iZzao = 0;
        for (int i = 0; i < length2; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                iZzao += zzydVar.zzao(obj2);
            }
        }
        return iZzao;
    }
}
