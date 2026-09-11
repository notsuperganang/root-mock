package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzbcb {
    private static final zzbbb zzdph = zzbbb.zzacr();
    private zzbah zzdvk;
    private volatile zzbcu zzdvl;
    private volatile zzbah zzdvm;

    private final zzbcu zzk(zzbcu zzbcuVar) {
        if (this.zzdvl == null) {
            synchronized (this) {
                if (this.zzdvl == null) {
                    try {
                        this.zzdvl = zzbcuVar;
                        this.zzdvm = zzbah.zzdpq;
                    } catch (zzbbu e) {
                        this.zzdvl = zzbcuVar;
                        this.zzdvm = zzbah.zzdpq;
                    }
                }
            }
        }
        return this.zzdvl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbcb)) {
            return false;
        }
        zzbcb zzbcbVar = (zzbcb) obj;
        zzbcu zzbcuVar = this.zzdvl;
        zzbcu zzbcuVar2 = zzbcbVar.zzdvl;
        if (zzbcuVar == null && zzbcuVar2 == null) {
            return zzaav().equals(zzbcbVar.zzaav());
        }
        if (zzbcuVar == null || zzbcuVar2 == null) {
            return zzbcuVar != null ? zzbcuVar.equals(zzbcbVar.zzk(zzbcuVar.zzadg())) : zzk(zzbcuVar2.zzadg()).equals(zzbcuVar2);
        }
        return zzbcuVar.equals(zzbcuVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzbah zzaav() {
        if (this.zzdvm != null) {
            return this.zzdvm;
        }
        synchronized (this) {
            if (this.zzdvm != null) {
                return this.zzdvm;
            }
            if (this.zzdvl == null) {
                this.zzdvm = zzbah.zzdpq;
            } else {
                this.zzdvm = this.zzdvl.zzaav();
            }
            return this.zzdvm;
        }
    }

    public final int zzacw() {
        if (this.zzdvm != null) {
            return this.zzdvm.size();
        }
        if (this.zzdvl != null) {
            return this.zzdvl.zzacw();
        }
        return 0;
    }

    public final zzbcu zzl(zzbcu zzbcuVar) {
        zzbcu zzbcuVar2 = this.zzdvl;
        this.zzdvk = null;
        this.zzdvm = null;
        this.zzdvl = zzbcuVar;
        return zzbcuVar2;
    }
}
