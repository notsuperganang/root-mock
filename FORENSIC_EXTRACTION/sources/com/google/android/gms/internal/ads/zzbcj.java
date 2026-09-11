package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbcj implements zzbdn {
    private static final zzbct zzdvw = new zzbck();
    private final zzbct zzdvv;

    public zzbcj() {
        this(new zzbcl(zzbbn.zzadc(), zzaea()));
    }

    private zzbcj(zzbct zzbctVar) {
        this.zzdvv = (zzbct) zzbbq.zza(zzbctVar, "messageInfoFactory");
    }

    private static boolean zza(zzbcs zzbcsVar) {
        return zzbcsVar.zzaeh() == zzbbo.zze.zzdui;
    }

    private static zzbct zzaea() {
        try {
            return (zzbct) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return zzdvw;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdn
    public final <T> zzbdm<T> zzd(Class<T> cls) {
        zzbdo.zzf(cls);
        zzbcs zzbcsVarZzb = this.zzdvv.zzb(cls);
        if (zzbcsVarZzb.zzaei()) {
            return zzbbo.class.isAssignableFrom(cls) ? zzbda.zza(zzbdo.zzafp(), zzbbf.zzact(), zzbcsVarZzb.zzaej()) : zzbda.zza(zzbdo.zzafn(), zzbbf.zzacu(), zzbcsVarZzb.zzaej());
        }
        if (zzbbo.class.isAssignableFrom(cls)) {
            return zza(zzbcsVarZzb) ? zzbcy.zza(cls, zzbcsVarZzb, zzbde.zzaem(), zzbce.zzadz(), zzbdo.zzafp(), zzbbf.zzact(), zzbcr.zzaef()) : zzbcy.zza(cls, zzbcsVarZzb, zzbde.zzaem(), zzbce.zzadz(), zzbdo.zzafp(), (zzbbd<?>) null, zzbcr.zzaef());
        }
        return zza(zzbcsVarZzb) ? zzbcy.zza(cls, zzbcsVarZzb, zzbde.zzael(), zzbce.zzady(), zzbdo.zzafn(), zzbbf.zzacu(), zzbcr.zzaee()) : zzbcy.zza(cls, zzbcsVarZzb, zzbde.zzael(), zzbce.zzady(), zzbdo.zzafo(), (zzbbd<?>) null, zzbcr.zzaee());
    }
}
