package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzbff implements Cloneable {
    private Object value;
    private zzbfd<?, ?> zzebq;
    private List<zzbfk> zzebr = new ArrayList();

    zzbff() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzr()];
        zza(zzbfa.zzu(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzagp, reason: merged with bridge method [inline-methods] */
    public final zzbff clone() {
        int i = 0;
        zzbff zzbffVar = new zzbff();
        try {
            zzbffVar.zzebq = this.zzebq;
            if (this.zzebr == null) {
                zzbffVar.zzebr = null;
            } else {
                zzbffVar.zzebr.addAll(this.zzebr);
            }
            if (this.value != null) {
                if (this.value instanceof zzbfi) {
                    zzbffVar.value = (zzbfi) ((zzbfi) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzbffVar.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzbffVar.value = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzbffVar.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzbffVar.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzbffVar.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzbffVar.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzbffVar.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzbfi[]) {
                    zzbfi[] zzbfiVarArr = (zzbfi[]) this.value;
                    zzbfi[] zzbfiVarArr2 = new zzbfi[zzbfiVarArr.length];
                    zzbffVar.value = zzbfiVarArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzbfiVarArr.length) {
                            break;
                        }
                        zzbfiVarArr2[i3] = (zzbfi) zzbfiVarArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzbffVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbff)) {
            return false;
        }
        zzbff zzbffVar = (zzbff) obj;
        if (this.value == null || zzbffVar.value == null) {
            if (this.zzebr != null && zzbffVar.zzebr != null) {
                return this.zzebr.equals(zzbffVar.zzebr);
            }
            try {
                return Arrays.equals(toByteArray(), zzbffVar.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        if (this.zzebq != zzbffVar.zzebq) {
            return false;
        }
        if (!this.zzebq.zzebl.isArray()) {
            return this.value.equals(zzbffVar.value);
        }
        if (this.value instanceof byte[]) {
            return Arrays.equals((byte[]) this.value, (byte[]) zzbffVar.value);
        }
        if (this.value instanceof int[]) {
            return Arrays.equals((int[]) this.value, (int[]) zzbffVar.value);
        }
        if (this.value instanceof long[]) {
            return Arrays.equals((long[]) this.value, (long[]) zzbffVar.value);
        }
        if (this.value instanceof float[]) {
            return Arrays.equals((float[]) this.value, (float[]) zzbffVar.value);
        }
        if (this.value instanceof double[]) {
            return Arrays.equals((double[]) this.value, (double[]) zzbffVar.value);
        }
        return this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzbffVar.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzbffVar.value);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    final void zza(zzbfa zzbfaVar) throws IOException {
        if (this.value != null) {
            throw new NoSuchMethodError();
        }
        for (zzbfk zzbfkVar : this.zzebr) {
            zzbfaVar.zzde(zzbfkVar.tag);
            zzbfaVar.zzw(zzbfkVar.zzdpw);
        }
    }

    final void zza(zzbfk zzbfkVar) throws IOException {
        if (this.zzebr != null) {
            this.zzebr.add(zzbfkVar);
            return;
        }
        if (!(this.value instanceof zzbfi)) {
            if (this.value instanceof zzbfi[]) {
                Collections.singletonList(zzbfkVar);
                throw new NoSuchMethodError();
            }
            Collections.singletonList(zzbfkVar);
            throw new NoSuchMethodError();
        }
        byte[] bArr = zzbfkVar.zzdpw;
        zzbez zzbezVarZzi = zzbez.zzi(bArr, 0, bArr.length);
        int iZzacc = zzbezVarZzi.zzacc();
        if (iZzacc != bArr.length - zzbfa.zzce(iZzacc)) {
            throw zzbfh.zzagq();
        }
        zzbfi zzbfiVarZza = ((zzbfi) this.value).zza(zzbezVarZzi);
        this.zzebq = this.zzebq;
        this.value = zzbfiVarZza;
        this.zzebr = null;
    }

    final int zzr() {
        if (this.value != null) {
            throw new NoSuchMethodError();
        }
        Iterator<zzbfk> it = this.zzebr.iterator();
        int length = 0;
        while (true) {
            int i = length;
            if (!it.hasNext()) {
                return i;
            }
            zzbfk next = it.next();
            length = next.zzdpw.length + zzbfa.zzcl(next.tag) + 0 + i;
        }
    }
}
