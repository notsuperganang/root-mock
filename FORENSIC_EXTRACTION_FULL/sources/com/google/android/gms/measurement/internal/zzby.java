package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzby extends zzak {
    private final zzfn zzamx;
    private Boolean zzaql;

    @Nullable
    private String zzaqm;

    public zzby(zzfn zzfnVar) {
        this(zzfnVar, null);
    }

    private zzby(zzfn zzfnVar, @Nullable String str) {
        Preconditions.checkNotNull(zzfnVar);
        this.zzamx = zzfnVar;
        this.zzaqm = null;
    }

    @BinderThread
    private final void zzb(zzk zzkVar, boolean z) {
        Preconditions.checkNotNull(zzkVar);
        zzc(zzkVar.packageName, false);
        this.zzamx.zzgr().zzu(zzkVar.zzafi, zzkVar.zzafv);
    }

    @BinderThread
    private final void zzc(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.zzamx.zzgt().zzjg().zzby("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzaql == null) {
                    this.zzaql = Boolean.valueOf("com.google.android.gms".equals(this.zzaqm) || UidVerifier.isGooglePlayServicesUid(this.zzamx.getContext(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(this.zzamx.getContext()).isUidGoogleSigned(Binder.getCallingUid()));
                }
                if (this.zzaql.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zzamx.zzgt().zzjg().zzg("Measurement Service called with invalid calling package. appId", zzas.zzbw(str));
                throw e;
            }
        }
        if (this.zzaqm == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zzamx.getContext(), Binder.getCallingUid(), str)) {
            this.zzaqm = str;
        }
        if (str.equals(this.zzaqm)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @VisibleForTesting
    private final void zze(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (zzai.zzakn.get().booleanValue() && this.zzamx.zzgs().zzkf()) {
            runnable.run();
        } else {
            this.zzamx.zzgs().zzc(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final List<zzfu> zza(zzk zzkVar, boolean z) {
        zzb(zzkVar, false);
        try {
            List<zzfw> list = (List) this.zzamx.zzgs().zzb(new zzco(this, zzkVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzfw zzfwVar : list) {
                if (z || !zzfx.zzcy(zzfwVar.name)) {
                    arrayList.add(new zzfu(zzfwVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzamx.zzgt().zzjg().zze("Failed to get user attributes. appId", zzas.zzbw(zzkVar.packageName), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final List<zzo> zza(String str, String str2, zzk zzkVar) {
        zzb(zzkVar, false);
        try {
            return (List) this.zzamx.zzgs().zzb(new zzcg(this, zzkVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzamx.zzgt().zzjg().zzg("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final List<zzfu> zza(String str, String str2, String str3, boolean z) {
        zzc(str, true);
        try {
            List<zzfw> list = (List) this.zzamx.zzgs().zzb(new zzcf(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzfw zzfwVar : list) {
                if (z || !zzfx.zzcy(zzfwVar.name)) {
                    arrayList.add(new zzfu(zzfwVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzamx.zzgt().zzjg().zze("Failed to get user attributes. appId", zzas.zzbw(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final List<zzfu> zza(String str, String str2, boolean z, zzk zzkVar) {
        zzb(zzkVar, false);
        try {
            List<zzfw> list = (List) this.zzamx.zzgs().zzb(new zzce(this, zzkVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzfw zzfwVar : list) {
                if (z || !zzfx.zzcy(zzfwVar.name)) {
                    arrayList.add(new zzfu(zzfwVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzamx.zzgt().zzjg().zze("Failed to get user attributes. appId", zzas.zzbw(zzkVar.packageName), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        zze(new zzcq(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final void zza(zzag zzagVar, zzk zzkVar) {
        Preconditions.checkNotNull(zzagVar);
        zzb(zzkVar, false);
        zze(new zzcj(this, zzagVar, zzkVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final void zza(zzag zzagVar, String str, String str2) {
        Preconditions.checkNotNull(zzagVar);
        Preconditions.checkNotEmpty(str);
        zzc(str, true);
        zze(new zzck(this, zzagVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final void zza(zzfu zzfuVar, zzk zzkVar) {
        Preconditions.checkNotNull(zzfuVar);
        zzb(zzkVar, false);
        if (zzfuVar.getValue() == null) {
            zze(new zzcm(this, zzfuVar, zzkVar));
        } else {
            zze(new zzcn(this, zzfuVar, zzkVar));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final void zza(zzk zzkVar) {
        zzb(zzkVar, false);
        zze(new zzcp(this, zzkVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final void zza(zzo zzoVar, zzk zzkVar) {
        Preconditions.checkNotNull(zzoVar);
        Preconditions.checkNotNull(zzoVar.zzags);
        zzb(zzkVar, false);
        zzo zzoVar2 = new zzo(zzoVar);
        zzoVar2.packageName = zzkVar.packageName;
        if (zzoVar.zzags.getValue() == null) {
            zze(new zzca(this, zzoVar2, zzkVar));
        } else {
            zze(new zzcb(this, zzoVar2, zzkVar));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final byte[] zza(zzag zzagVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzagVar);
        zzc(str, true);
        this.zzamx.zzgt().zzjn().zzg("Log and bundle. event", this.zzamx.zzgq().zzbt(zzagVar.name));
        long jNanoTime = this.zzamx.zzbx().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zzamx.zzgs().zzc(new zzcl(this, zzagVar, str)).get();
            if (bArr == null) {
                this.zzamx.zzgt().zzjg().zzg("Log and bundle returned null. appId", zzas.zzbw(str));
                bArr = new byte[0];
            }
            this.zzamx.zzgt().zzjn().zzd("Log and bundle processed. event, size, time_ms", this.zzamx.zzgq().zzbt(zzagVar.name), Integer.valueOf(bArr.length), Long.valueOf((this.zzamx.zzbx().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zzamx.zzgt().zzjg().zzd("Failed to log and bundle. appId, event, error", zzas.zzbw(str), this.zzamx.zzgq().zzbt(zzagVar.name), e);
            return null;
        }
    }

    @VisibleForTesting
    final zzag zzb(zzag zzagVar, zzk zzkVar) {
        boolean z = false;
        if ("_cmp".equals(zzagVar.name) && zzagVar.zzahu != null && zzagVar.zzahu.size() != 0) {
            String string = zzagVar.zzahu.getString("_cis");
            if (!TextUtils.isEmpty(string) && (("referrer broadcast".equals(string) || "referrer API".equals(string)) && this.zzamx.zzgv().zzbe(zzkVar.packageName))) {
                z = true;
            }
        }
        if (!z) {
            return zzagVar;
        }
        this.zzamx.zzgt().zzjm().zzg("Event has been filtered ", zzagVar.toString());
        return new zzag("_cmpx", zzagVar.zzahu, zzagVar.origin, zzagVar.zzaig);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final void zzb(zzk zzkVar) {
        zzb(zzkVar, false);
        zze(new zzbz(this, zzkVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final void zzb(zzo zzoVar) {
        Preconditions.checkNotNull(zzoVar);
        Preconditions.checkNotNull(zzoVar.zzags);
        zzc(zzoVar.packageName, true);
        zzo zzoVar2 = new zzo(zzoVar);
        if (zzoVar.zzags.getValue() == null) {
            zze(new zzcc(this, zzoVar2));
        } else {
            zze(new zzcd(this, zzoVar2));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final String zzc(zzk zzkVar) {
        zzb(zzkVar, false);
        return this.zzamx.zzh(zzkVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final void zzd(zzk zzkVar) {
        zzc(zzkVar.packageName, false);
        zze(new zzci(this, zzkVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    @BinderThread
    public final List<zzo> zze(String str, String str2, String str3) {
        zzc(str, true);
        try {
            return (List) this.zzamx.zzgs().zzb(new zzch(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzamx.zzgt().zzjg().zzg("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }
}
