package com.google.ads.mediation;

/* JADX INFO: loaded from: classes.dex */
final class zzb extends com.google.android.gms.ads.reward.zza {
    private final /* synthetic */ AbstractAdViewAdapter zzhd;

    zzb(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzhd = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.zza
    public final void zzt() {
        if (this.zzhd.zzha == null || this.zzhd.zzhb == null) {
            return;
        }
        this.zzhd.zzhb.zzc(this.zzhd.zzha.zzba());
    }
}
