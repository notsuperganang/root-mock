package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public final class zzfd extends zzf {
    private Handler handler;

    @VisibleForTesting
    private long zzatb;

    @VisibleForTesting
    private long zzatc;
    private final zzy zzatd;
    private final zzy zzate;

    zzfd(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzatd = new zzfe(this, this.zzada);
        this.zzate = new zzff(this, this.zzada);
        this.zzatb = zzbx().elapsedRealtime();
        this.zzatc = this.zzatb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzai(long j) {
        zzaf();
        zzlm();
        if (zzgv().zze(zzgk().zzal(), zzai.zzaky)) {
            zzgu().zzant.set(false);
        }
        zzgt().zzjo().zzg("Activity resumed, time", Long.valueOf(j));
        this.zzatb = j;
        this.zzatc = this.zzatb;
        if (zzgv().zzbi(zzgk().zzal())) {
            zzaj(zzbx().currentTimeMillis());
            return;
        }
        this.zzatd.cancel();
        this.zzate.cancel();
        if (zzgu().zzaf(zzbx().currentTimeMillis())) {
            zzgu().zzanp.set(true);
            zzgu().zzanr.set(0L);
        }
        if (zzgu().zzanp.get()) {
            this.zzatd.zzh(Math.max(0L, zzgu().zzann.get() - zzgu().zzanr.get()));
        } else {
            this.zzate.zzh(Math.max(0L, 3600000 - zzgu().zzanr.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzak(long j) {
        zzaf();
        zzlm();
        if (zzgv().zze(zzgk().zzal(), zzai.zzaky)) {
            zzgu().zzant.set(true);
        }
        this.zzatd.cancel();
        this.zzate.cancel();
        zzgt().zzjo().zzg("Activity paused, time", Long.valueOf(j));
        if (this.zzatb != 0) {
            zzgu().zzanr.set(zzgu().zzanr.get() + (j - this.zzatb));
        }
    }

    @WorkerThread
    private final void zzal(long j) {
        zzaf();
        zzgt().zzjo().zzg("Session started, time", Long.valueOf(zzbx().elapsedRealtime()));
        Long lValueOf = zzgv().zzbg(zzgk().zzal()) ? Long.valueOf(j / 1000) : null;
        Long l = zzgv().zzbh(zzgk().zzal()) ? -1L : null;
        zzgj().zza("auto", "_sid", lValueOf, j);
        zzgj().zza("auto", "_sno", l, j);
        zzgu().zzanp.set(false);
        Bundle bundle = new Bundle();
        if (zzgv().zzbg(zzgk().zzal())) {
            bundle.putLong("_sid", lValueOf.longValue());
        }
        zzgj().zza("auto", "_s", j, bundle);
        zzgu().zzanq.set(j);
    }

    private final void zzlm() {
        synchronized (this) {
            if (this.handler == null) {
                this.handler = new com.google.android.gms.internal.measurement.zzdl(Looper.getMainLooper());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzlq() {
        zzaf();
        zza(false, false);
        zzgi().zzm(zzbx().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    final void zza(long j, boolean z) {
        zzaf();
        zzlm();
        this.zzatd.cancel();
        this.zzate.cancel();
        if (zzgu().zzaf(j)) {
            zzgu().zzanp.set(true);
            zzgu().zzanr.set(0L);
        }
        if (z && zzgv().zzbj(zzgk().zzal())) {
            zzgu().zzanq.set(j);
        }
        if (zzgu().zzanp.get()) {
            zzal(j);
        } else {
            this.zzate.zzh(Math.max(0L, 3600000 - zzgu().zzanr.get()));
        }
    }

    @WorkerThread
    public final boolean zza(boolean z, boolean z2) {
        zzaf();
        zzcl();
        long jElapsedRealtime = zzbx().elapsedRealtime();
        zzgu().zzanq.set(zzbx().currentTimeMillis());
        long j = jElapsedRealtime - this.zzatb;
        if (!z && j < 1000) {
            zzgt().zzjo().zzg("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
            return false;
        }
        zzgu().zzanr.set(j);
        zzgt().zzjo().zzg("Recording user engagement, ms", Long.valueOf(j));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzdy.zza(zzgm().zzle(), bundle, true);
        if (zzgv().zzbk(zzgk().zzal())) {
            if (zzgv().zze(zzgk().zzal(), zzai.zzalc)) {
                if (!z2) {
                    zzlp();
                }
            } else if (z2) {
                bundle.putLong("_fr", 1L);
            } else {
                zzlp();
            }
        }
        if (!zzgv().zze(zzgk().zzal(), zzai.zzalc) || !z2) {
            zzgj().logEvent("auto", "_e", bundle);
        }
        this.zzatb = jElapsedRealtime;
        this.zzate.cancel();
        this.zzate.zzh(Math.max(0L, 3600000 - zzgu().zzanr.get()));
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @WorkerThread
    final void zzaj(long j) {
        zzaf();
        zzlm();
        zza(j, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zza zzgi() {
        return super.zzgi();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzda zzgj() {
        return super.zzgj();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzam zzgk() {
        return super.zzgk();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzeb zzgl() {
        return super.zzgl();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzdy zzgm() {
        return super.zzgm();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzao zzgn() {
        return super.zzgn();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzfd zzgo() {
        return super.zzgo();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfx zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzgy() {
        return false;
    }

    @WorkerThread
    final void zzln() {
        zzaf();
        this.zzatd.cancel();
        this.zzate.cancel();
        this.zzatb = 0L;
        this.zzatc = this.zzatb;
    }

    @WorkerThread
    @VisibleForTesting
    protected final void zzlo() {
        zzaf();
        zzal(zzbx().currentTimeMillis());
    }

    @WorkerThread
    @VisibleForTesting
    final long zzlp() {
        long jElapsedRealtime = zzbx().elapsedRealtime();
        long j = this.zzatc;
        this.zzatc = jElapsedRealtime;
        return jElapsedRealtime - j;
    }
}
