package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
public class zzho {
    private static final zzgl zznj = zzgl.zzda();
    private zzfr zzuf;
    private volatile zzih zzug;
    private volatile zzfr zzuh;

    private final zzih zzi(zzih zzihVar) {
        if (this.zzug == null) {
            synchronized (this) {
                try {
                    if (this.zzug == null) {
                        try {
                            this.zzug = zzihVar;
                            this.zzuh = zzfr.zznt;
                        } catch (zzhh e) {
                            this.zzug = zzihVar;
                            this.zzuh = zzfr.zznt;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzug;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzho)) {
            return false;
        }
        zzho zzhoVar = (zzho) obj;
        zzih zzihVar = this.zzug;
        zzih zzihVar2 = zzhoVar.zzug;
        if (zzihVar == null && zzihVar2 == null) {
            return zzax().equals(zzhoVar.zzax());
        }
        if (zzihVar == null || zzihVar2 == null) {
            return zzihVar != null ? zzihVar.equals(zzhoVar.zzi(zzihVar.zzds())) : zzi(zzihVar2.zzds()).equals(zzihVar2);
        }
        return zzihVar.equals(zzihVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzfr zzax() {
        if (this.zzuh != null) {
            return this.zzuh;
        }
        synchronized (this) {
            if (this.zzuh != null) {
                return this.zzuh;
            }
            if (this.zzug == null) {
                this.zzuh = zzfr.zznt;
            } else {
                this.zzuh = this.zzug.zzax();
            }
            return this.zzuh;
        }
    }

    public final int zzdg() {
        if (this.zzuh != null) {
            return this.zzuh.size();
        }
        if (this.zzug != null) {
            return this.zzug.zzdg();
        }
        return 0;
    }

    public final zzih zzj(zzih zzihVar) {
        zzih zzihVar2 = this.zzug;
        this.zzuf = null;
        this.zzuh = null;
        this.zzug = zzihVar;
        return zzihVar2;
    }
}
