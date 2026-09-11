package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zziu implements zzif {
    private final String info;
    private final zzih zzvf;
    private final zziv zzvy;

    zziu(zzih zzihVar, String str, Object[] objArr) {
        this.zzvf = zzihVar;
        this.info = str;
        this.zzvy = new zziv(zzihVar.getClass(), str, objArr);
    }

    public final int getFieldCount() {
        return this.zzvy.zzwb;
    }

    @Override // com.google.android.gms.internal.places.zzif
    public final int zzev() {
        return (this.zzvy.flags & 1) == 1 ? zzgz.zzh.zztd : zzgz.zzh.zzte;
    }

    @Override // com.google.android.gms.internal.places.zzif
    public final boolean zzew() {
        return (this.zzvy.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.places.zzif
    public final zzih zzex() {
        return this.zzvf;
    }

    final zziv zzfe() {
        return this.zzvy;
    }

    public final int zzff() {
        return this.zzvy.zzvc;
    }

    public final int zzfg() {
        return this.zzvy.zzvd;
    }

    public final int zzfh() {
        return this.zzvy.zzwe;
    }

    public final int zzfi() {
        return this.zzvy.zzwg;
    }

    final int[] zzfj() {
        return this.zzvy.zzvk;
    }

    public final int zzfk() {
        return this.zzvy.zzwf;
    }

    public final int zzfl() {
        return this.zzvy.zzve;
    }
}
