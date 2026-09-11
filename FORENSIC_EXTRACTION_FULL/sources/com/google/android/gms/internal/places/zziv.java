package com.google.android.gms.internal.places;

import java.lang.reflect.Field;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zziv {
    private final int flags;
    private final Object[] zzvb;
    private final int zzvc;
    private final int zzvd;
    private final int zzve;
    private final int[] zzvk;
    private final zziw zzvz;
    private Class<?> zzwa;
    private final int zzwb;
    private final int zzwc;
    private final int zzwd;
    private final int zzwe;
    private final int zzwf;
    private final int zzwg;
    private int zzwh;
    private int zzwi;
    private int zzwj = Integer.MAX_VALUE;
    private int zzwk = Integer.MIN_VALUE;
    private int zzwl = 0;
    private int zzwm = 0;
    private int zzwn = 0;
    private int zzwo = 0;
    private int zzwp = 0;
    private int zzwq;
    private int zzwr;
    private int zzws;
    private int zzwt;
    private int zzwu;
    private Field zzwv;
    private Object zzww;
    private Object zzwx;
    private Object zzwy;

    zziv(Class<?> cls, String str, Object[] objArr) {
        this.zzwa = cls;
        this.zzvz = new zziw(str);
        this.zzvb = objArr;
        this.flags = this.zzvz.next();
        this.zzwb = this.zzvz.next();
        if (this.zzwb == 0) {
            this.zzwc = 0;
            this.zzwd = 0;
            this.zzvc = 0;
            this.zzvd = 0;
            this.zzwe = 0;
            this.zzwf = 0;
            this.zzve = 0;
            this.zzwg = 0;
            this.zzvk = null;
            return;
        }
        this.zzwc = this.zzvz.next();
        this.zzwd = this.zzvz.next();
        this.zzvc = this.zzvz.next();
        this.zzvd = this.zzvz.next();
        this.zzwf = this.zzvz.next();
        this.zzve = this.zzvz.next();
        this.zzwe = this.zzvz.next();
        this.zzwg = this.zzvz.next();
        int next = this.zzvz.next();
        this.zzvk = next != 0 ? new int[next] : null;
        this.zzwh = (this.zzwc << 1) + this.zzwd;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            throw new RuntimeException(new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length()).append("Field ").append(str).append(" for ").append(name).append(" not found. Known fields are ").append(string).toString());
        }
    }

    private final Object zzfm() {
        Object[] objArr = this.zzvb;
        int i = this.zzwh;
        this.zzwh = i + 1;
        return objArr[i];
    }

    private final boolean zzfo() {
        return (this.flags & 1) == 1;
    }

    final boolean next() {
        if (!this.zzvz.hasNext()) {
            return false;
        }
        this.zzwq = this.zzvz.next();
        this.zzwr = this.zzvz.next();
        this.zzws = this.zzwr & 255;
        if (this.zzwq < this.zzwj) {
            this.zzwj = this.zzwq;
        }
        if (this.zzwq > this.zzwk) {
            this.zzwk = this.zzwq;
        }
        if (this.zzws == zzgt.MAP.id()) {
            this.zzwl++;
        } else if (this.zzws >= zzgt.DOUBLE_LIST.id() && this.zzws <= zzgt.GROUP_LIST.id()) {
            this.zzwm++;
        }
        this.zzwp++;
        if (zzja.zzd(this.zzwj, this.zzwq, this.zzwp)) {
            this.zzwo = this.zzwq + 1;
            this.zzwn = this.zzwo - this.zzwj;
        } else {
            this.zzwn++;
        }
        if ((this.zzwr & 1024) != 0) {
            int[] iArr = this.zzvk;
            int i = this.zzwi;
            this.zzwi = i + 1;
            iArr[i] = this.zzwq;
        }
        this.zzww = null;
        this.zzwx = null;
        this.zzwy = null;
        if (zzfp()) {
            this.zzwt = this.zzvz.next();
            if (this.zzws == zzgt.MESSAGE.id() + 51 || this.zzws == zzgt.GROUP.id() + 51) {
                this.zzww = zzfm();
            } else if (this.zzws == zzgt.ENUM.id() + 51 && zzfo()) {
                this.zzwx = zzfm();
            }
        } else {
            this.zzwv = zzb(this.zzwa, (String) zzfm());
            if (zzft()) {
                this.zzwu = this.zzvz.next();
            }
            if (this.zzws == zzgt.MESSAGE.id() || this.zzws == zzgt.GROUP.id()) {
                this.zzww = this.zzwv.getType();
            } else if (this.zzws == zzgt.MESSAGE_LIST.id() || this.zzws == zzgt.GROUP_LIST.id()) {
                this.zzww = zzfm();
            } else if (this.zzws == zzgt.ENUM.id() || this.zzws == zzgt.ENUM_LIST.id() || this.zzws == zzgt.ENUM_LIST_PACKED.id()) {
                if (zzfo()) {
                    this.zzwx = zzfm();
                }
            } else if (this.zzws == zzgt.MAP.id()) {
                this.zzwy = zzfm();
                if ((this.zzwr & 2048) != 0) {
                    this.zzwx = zzfm();
                }
            }
        }
        return true;
    }

    final int zzbg() {
        return this.zzwq;
    }

    final int zzfn() {
        return this.zzws;
    }

    final boolean zzfp() {
        return this.zzws > zzgt.MAP.id();
    }

    final Field zzfq() {
        int i = this.zzwt << 1;
        Object obj = this.zzvb[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field fieldZzb = zzb(this.zzwa, (String) obj);
        this.zzvb[i] = fieldZzb;
        return fieldZzb;
    }

    final Field zzfr() {
        int i = (this.zzwt << 1) + 1;
        Object obj = this.zzvb[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field fieldZzb = zzb(this.zzwa, (String) obj);
        this.zzvb[i] = fieldZzb;
        return fieldZzb;
    }

    final Field zzfs() {
        return this.zzwv;
    }

    final boolean zzft() {
        return zzfo() && this.zzws <= zzgt.GROUP.id();
    }

    final Field zzfu() {
        int i = (this.zzwu / 32) + (this.zzwc << 1);
        Object obj = this.zzvb[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field fieldZzb = zzb(this.zzwa, (String) obj);
        this.zzvb[i] = fieldZzb;
        return fieldZzb;
    }

    final int zzfv() {
        return this.zzwu % 32;
    }

    final boolean zzfw() {
        return (this.zzwr & 256) != 0;
    }

    final boolean zzfx() {
        return (this.zzwr & 512) != 0;
    }

    final Object zzfy() {
        return this.zzww;
    }

    final Object zzfz() {
        return this.zzwx;
    }

    final Object zzga() {
        return this.zzwy;
    }
}
