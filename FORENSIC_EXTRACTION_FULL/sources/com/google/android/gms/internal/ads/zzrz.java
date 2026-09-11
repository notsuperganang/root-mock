package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzrz extends zzrd {
    private final NativeCustomTemplateAd.OnCustomClickListener zzbld;

    public zzrz(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzbld = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzrc
    public final void zzb(zzqs zzqsVar, String str) {
        this.zzbld.onCustomClick(zzqv.zza(zzqsVar), str);
    }
}
