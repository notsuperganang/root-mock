package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzhw implements zziz {
    private static final zzig zzur = new zzhx();
    private final zzig zzuq;

    public zzhw() {
        this(new zzhy(zzgy.zzdn(), zzeo()));
    }

    private zzhw(zzig zzigVar) {
        this.zzuq = (zzig) zzhb.zzb(zzigVar, "messageInfoFactory");
    }

    private static boolean zzb(zzif zzifVar) {
        return zzifVar.zzev() == zzgz.zzh.zztd;
    }

    private static zzig zzeo() {
        try {
            return (zzig) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return zzur;
        }
    }

    @Override // com.google.android.gms.internal.places.zziz
    public final <T> zziy<T> zzf(Class<T> cls) {
        zzja.zzh(cls);
        zzif zzifVarZzd = this.zzuq.zzd(cls);
        if (zzifVarZzd.zzew()) {
            return zzgz.class.isAssignableFrom(cls) ? zzim.zzb(zzja.zzgd(), zzgp.zzdd(), zzifVarZzd.zzex()) : zzim.zzb(zzja.zzgb(), zzgp.zzde(), zzifVarZzd.zzex());
        }
        if (zzgz.class.isAssignableFrom(cls)) {
            return zzb(zzifVarZzd) ? zzil.zzb(cls, zzifVarZzd, zziq.zzfa(), zzhr.zzen(), zzja.zzgd(), zzgp.zzdd(), zzie.zzet()) : zzil.zzb(cls, zzifVarZzd, zziq.zzfa(), zzhr.zzen(), zzja.zzgd(), null, zzie.zzet());
        }
        return zzb(zzifVarZzd) ? zzil.zzb(cls, zzifVarZzd, zziq.zzez(), zzhr.zzem(), zzja.zzgb(), zzgp.zzde(), zzie.zzes()) : zzil.zzb(cls, zzifVarZzd, zziq.zzez(), zzhr.zzem(), zzja.zzgc(), null, zzie.zzes());
    }
}
