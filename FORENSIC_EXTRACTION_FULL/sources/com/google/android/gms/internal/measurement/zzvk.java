package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzvk implements zzwm {
    private static final zzvu zzcai = new zzvl();
    private final zzvu zzcah;

    public zzvk() {
        this(new zzvm(zzun.zzwe(), zzxf()));
    }

    private zzvk(zzvu zzvuVar) {
        this.zzcah = (zzvu) zzuq.zza(zzvuVar, "messageInfoFactory");
    }

    private static boolean zza(zzvt zzvtVar) {
        return zzvtVar.zzxm() == zzuo.zze.zzbyu;
    }

    private static zzvu zzxf() {
        try {
            return (zzvu) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return zzcai;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwm
    public final <T> zzwl<T> zzh(Class<T> cls) {
        zzwn.zzj(cls);
        zzvt zzvtVarZzf = this.zzcah.zzf(cls);
        if (zzvtVarZzf.zzxn()) {
            return zzuo.class.isAssignableFrom(cls) ? zzwa.zza(zzwn.zzxz(), zzue.zzvu(), zzvtVarZzf.zzxo()) : zzwa.zza(zzwn.zzxx(), zzue.zzvv(), zzvtVarZzf.zzxo());
        }
        if (zzuo.class.isAssignableFrom(cls)) {
            return zza(zzvtVarZzf) ? zzvz.zza(cls, zzvtVarZzf, zzwe.zzxr(), zzvf.zzxe(), zzwn.zzxz(), zzue.zzvu(), zzvs.zzxk()) : zzvz.zza(cls, zzvtVarZzf, zzwe.zzxr(), zzvf.zzxe(), zzwn.zzxz(), null, zzvs.zzxk());
        }
        return zza(zzvtVarZzf) ? zzvz.zza(cls, zzvtVarZzf, zzwe.zzxq(), zzvf.zzxd(), zzwn.zzxx(), zzue.zzvv(), zzvs.zzxj()) : zzvz.zza(cls, zzvtVarZzf, zzwe.zzxq(), zzvf.zzxd(), zzwn.zzxy(), null, zzvs.zzxj());
    }
}
