package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
final class zzbl implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzu zzaod;
    private final /* synthetic */ ServiceConnection zzaoe;
    private final /* synthetic */ zzbk zzaof;

    zzbl(zzbk zzbkVar, com.google.android.gms.internal.measurement.zzu zzuVar, ServiceConnection serviceConnection) {
        this.zzaof = zzbkVar;
        this.zzaod = zzuVar;
        this.zzaoe = serviceConnection;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:38:0x0114  */
    @Override // java.lang.Runnable
    public final void run() {
        zzbj zzbjVar = this.zzaof.zzaoc;
        String str = this.zzaof.packageName;
        com.google.android.gms.internal.measurement.zzu zzuVar = this.zzaod;
        ServiceConnection serviceConnection = this.zzaoe;
        Bundle bundleZza = zzbjVar.zza(str, zzuVar);
        zzbjVar.zzada.zzgs().zzaf();
        if (bundleZza != null) {
            long j = bundleZza.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzbjVar.zzada.zzgt().zzjg().zzby("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleZza.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzbjVar.zzada.zzgt().zzjg().zzby("No referrer defined in install referrer response");
                } else {
                    zzbjVar.zzada.zzgt().zzjo().zzg("InstallReferrer API result", string);
                    zzfx zzfxVarZzgr = zzbjVar.zzada.zzgr();
                    String strValueOf = String.valueOf(string);
                    Bundle bundleZza2 = zzfxVarZzgr.zza(Uri.parse(strValueOf.length() != 0 ? "?".concat(strValueOf) : new String("?")));
                    if (bundleZza2 == null) {
                        zzbjVar.zzada.zzgt().zzjg().zzby("No campaign params defined in install referrer result");
                    } else {
                        String string2 = bundleZza2.getString(FirebaseAnalytics.Param.MEDIUM);
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j2 = bundleZza.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzbjVar.zzada.zzgt().zzjg().zzby("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                bundleZza2.putLong("click_timestamp", j2);
                                if (j == zzbjVar.zzada.zzgu().zzani.get()) {
                                    zzbjVar.zzada.zzgw();
                                    zzbjVar.zzada.zzgt().zzjo().zzby("Campaign has already been logged");
                                } else {
                                    zzbjVar.zzada.zzgu().zzani.set(j);
                                    zzbjVar.zzada.zzgw();
                                    zzbjVar.zzada.zzgt().zzjo().zzg("Logging Install Referrer campaign from sdk with ", "referrer API");
                                    bundleZza2.putString("_cis", "referrer API");
                                    zzbjVar.zzada.zzgj().logEvent("auto", "_cmp", bundleZza2);
                                }
                            }
                        } else if (j == zzbjVar.zzada.zzgu().zzani.get()) {
                            zzbjVar.zzada.zzgw();
                            zzbjVar.zzada.zzgt().zzjo().zzby("Campaign has already been logged");
                        } else {
                            zzbjVar.zzada.zzgu().zzani.set(j);
                            zzbjVar.zzada.zzgw();
                            zzbjVar.zzada.zzgt().zzjo().zzg("Logging Install Referrer campaign from sdk with ", "referrer API");
                            bundleZza2.putString("_cis", "referrer API");
                            zzbjVar.zzada.zzgj().logEvent("auto", "_cmp", bundleZza2);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzbjVar.zzada.getContext(), serviceConnection);
        }
    }
}
