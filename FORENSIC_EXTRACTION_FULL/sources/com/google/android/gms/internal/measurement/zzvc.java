package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public class zzvc {
    private static final zzub zzbtm = zzub.zzvr();
    private zzte zzbzw;
    private volatile zzvv zzbzx;
    private volatile zzte zzbzy;

    private final zzvv zzh(zzvv zzvvVar) {
        if (this.zzbzx == null) {
            synchronized (this) {
                try {
                    if (this.zzbzx == null) {
                        try {
                            this.zzbzx = zzvvVar;
                            this.zzbzy = zzte.zzbts;
                        } catch (zzuv e) {
                            this.zzbzx = zzvvVar;
                            this.zzbzy = zzte.zzbts;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzbzx;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvc)) {
            return false;
        }
        zzvc zzvcVar = (zzvc) obj;
        zzvv zzvvVar = this.zzbzx;
        zzvv zzvvVar2 = zzvcVar.zzbzx;
        if (zzvvVar == null && zzvvVar2 == null) {
            return zztw().equals(zzvcVar.zztw());
        }
        if (zzvvVar == null || zzvvVar2 == null) {
            return zzvvVar != null ? zzvvVar.equals(zzvcVar.zzh(zzvvVar.zzwj())) : zzh(zzvvVar2.zzwj()).equals(zzvvVar2);
        }
        return zzvvVar.equals(zzvvVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzvv zzi(zzvv zzvvVar) {
        zzvv zzvvVar2 = this.zzbzx;
        this.zzbzw = null;
        this.zzbzy = null;
        this.zzbzx = zzvvVar;
        return zzvvVar2;
    }

    public final zzte zztw() {
        if (this.zzbzy != null) {
            return this.zzbzy;
        }
        synchronized (this) {
            if (this.zzbzy != null) {
                return this.zzbzy;
            }
            if (this.zzbzx == null) {
                this.zzbzy = zzte.zzbts;
            } else {
                this.zzbzy = this.zzbzx.zztw();
            }
            return this.zzbzy;
        }
    }

    public final int zzvx() {
        if (this.zzbzy != null) {
            return this.zzbzy.size();
        }
        if (this.zzbzx != null) {
            return this.zzbzx.zzvx();
        }
        return 0;
    }
}
