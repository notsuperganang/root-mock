package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public final class zzeb extends zzf {
    private final zzes zzase;
    private zzaj zzasf;
    private volatile Boolean zzasg;
    private final zzy zzash;
    private final zzfi zzasi;
    private final List<Runnable> zzasj;
    private final zzy zzask;

    protected zzeb(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzasj = new ArrayList();
        this.zzasi = new zzfi(zzbwVar.zzbx());
        this.zzase = new zzes(this);
        this.zzash = new zzec(this, zzbwVar);
        this.zzask = new zzek(this, zzbwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzaf();
        if (this.zzasf != null) {
            this.zzasf = null;
            zzgt().zzjo().zzg("Disconnected from device MeasurementService", componentName);
            zzaf();
            zzdj();
        }
    }

    static /* synthetic */ zzaj zza(zzeb zzebVar, zzaj zzajVar) {
        zzebVar.zzasf = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzcy() {
        zzaf();
        this.zzasi.start();
        this.zzash.zzh(zzai.zzaka.get().longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzcz() {
        zzaf();
        if (isConnected()) {
            zzgt().zzjo().zzby("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @WorkerThread
    private final void zzf(Runnable runnable) throws IllegalStateException {
        zzaf();
        if (isConnected()) {
            runnable.run();
        } else {
            if (this.zzasj.size() >= 1000) {
                zzgt().zzjg().zzby("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzasj.add(runnable);
            this.zzask.zzh(60000L);
            zzdj();
        }
    }

    @WorkerThread
    @Nullable
    private final zzk zzl(boolean z) {
        zzgw();
        return zzgk().zzbs(z ? zzgt().zzjq() : null);
    }

    private final boolean zzlh() {
        zzgw();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzlj() {
        zzaf();
        zzgt().zzjo().zzg("Processing queued up service tasks", Integer.valueOf(this.zzasj.size()));
        Iterator<Runnable> it = this.zzasj.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e) {
                zzgt().zzjg().zzg("Task exception while flushing queue", e);
            }
        }
        this.zzasj.clear();
        this.zzask.cancel();
    }

    @WorkerThread
    public final void disconnect() {
        zzaf();
        zzcl();
        this.zzase.zzlk();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzase);
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e2) {
        }
        this.zzasf = null;
    }

    @WorkerThread
    public final void getAppInstanceId(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zzaf();
        zzcl();
        zzf(new zzeg(this, zzl(false), zzdqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final boolean isConnected() {
        zzaf();
        zzcl();
        return this.zzasf != null;
    }

    @WorkerThread
    protected final void resetAnalyticsData() {
        zzaf();
        zzgg();
        zzcl();
        zzk zzkVarZzl = zzl(false);
        if (zzlh()) {
            zzgn().resetAnalyticsData();
        }
        zzf(new zzee(this, zzkVarZzl));
    }

    @WorkerThread
    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, zzag zzagVar, String str) {
        zzaf();
        zzcl();
        if (zzgr().zzs(12451000) == 0) {
            zzf(new zzej(this, zzagVar, str, zzdqVar));
        } else {
            zzgt().zzjj().zzby("Not bundling data. Service unavailable or out of date");
            zzgr().zza(zzdqVar, new byte[0]);
        }
    }

    @WorkerThread
    protected final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, String str, String str2, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzeq(this, str, str2, z, zzl(false), zzdqVar));
    }

    @WorkerThread
    @VisibleForTesting
    protected final void zza(zzaj zzajVar) {
        zzaf();
        Preconditions.checkNotNull(zzajVar);
        this.zzasf = zzajVar;
        zzcy();
        zzlj();
    }

    @WorkerThread
    @VisibleForTesting
    final void zza(zzaj zzajVar, AbstractSafeParcelable abstractSafeParcelable, zzk zzkVar) {
        List<AbstractSafeParcelable> listZzr;
        zzaf();
        zzgg();
        zzcl();
        boolean zZzlh = zzlh();
        int size = 100;
        for (int i = 0; i < 1001 && size == 100; i++) {
            ArrayList arrayList = new ArrayList();
            if (!zZzlh || (listZzr = zzgn().zzr(100)) == null) {
                size = 0;
            } else {
                arrayList.addAll(listZzr);
                size = listZzr.size();
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj = arrayList2.get(i2);
                i2++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzag) {
                    try {
                        zzajVar.zza((zzag) abstractSafeParcelable2, zzkVar);
                    } catch (RemoteException e) {
                        zzgt().zzjg().zzg("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzfu) {
                    try {
                        zzajVar.zza((zzfu) abstractSafeParcelable2, zzkVar);
                    } catch (RemoteException e2) {
                        zzgt().zzjg().zzg("Failed to send attribute to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzo) {
                    try {
                        zzajVar.zza((zzo) abstractSafeParcelable2, zzkVar);
                    } catch (RemoteException e3) {
                        zzgt().zzjg().zzg("Failed to send conditional property to the service", e3);
                    }
                } else {
                    zzgt().zzjg().zzby("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }

    @WorkerThread
    protected final void zza(zzdx zzdxVar) {
        zzaf();
        zzcl();
        zzf(new zzei(this, zzdxVar));
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzaf();
        zzcl();
        zzf(new zzef(this, atomicReference, zzl(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzo>> atomicReference, String str, String str2, String str3) {
        zzaf();
        zzcl();
        zzf(new zzeo(this, atomicReference, str, str2, str3, zzl(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzfu>> atomicReference, String str, String str2, String str3, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzep(this, atomicReference, str, str2, str3, z, zzl(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzfu>> atomicReference, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzed(this, atomicReference, zzl(false), z));
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @WorkerThread
    protected final void zzb(zzfu zzfuVar) {
        zzaf();
        zzcl();
        zzf(new zzer(this, zzlh() && zzgn().zza(zzfuVar), zzfuVar, zzl(true)));
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @WorkerThread
    protected final void zzc(zzag zzagVar, String str) {
        Preconditions.checkNotNull(zzagVar);
        zzaf();
        zzcl();
        boolean zZzlh = zzlh();
        zzf(new zzem(this, zZzlh, zZzlh && zzgn().zza(zzagVar), zzagVar, zzl(true), str));
    }

    @WorkerThread
    protected final void zzd(zzo zzoVar) {
        Preconditions.checkNotNull(zzoVar);
        zzaf();
        zzcl();
        zzgw();
        zzf(new zzen(this, true, zzgn().zzc(zzoVar), new zzo(zzoVar), zzl(true), zzoVar));
    }

    @WorkerThread
    final void zzdj() {
        boolean z;
        boolean z2;
        zzaf();
        zzcl();
        if (isConnected()) {
            return;
        }
        if (this.zzasg == null) {
            zzaf();
            zzcl();
            Boolean boolZzjx = zzgu().zzjx();
            if (boolZzjx == null || !boolZzjx.booleanValue()) {
                zzgw();
                if (zzgk().zzje() != 1) {
                    zzgt().zzjo().zzby("Checking service availability");
                    int iZzs = zzgr().zzs(12451000);
                    switch (iZzs) {
                        case 0:
                            zzgt().zzjo().zzby("Service available");
                            z = true;
                            z2 = true;
                            break;
                        case 1:
                            zzgt().zzjo().zzby("Service missing");
                            z = false;
                            z2 = true;
                            break;
                        case 2:
                            zzgt().zzjn().zzby("Service container out of date");
                            if (zzgr().zzml() >= 14500) {
                                Boolean boolZzjx2 = zzgu().zzjx();
                                z = boolZzjx2 == null || boolZzjx2.booleanValue();
                                z2 = false;
                            } else {
                                z = false;
                                z2 = true;
                            }
                            break;
                        case 3:
                            zzgt().zzjj().zzby("Service disabled");
                            z = false;
                            z2 = false;
                            break;
                        case 9:
                            zzgt().zzjj().zzby("Service invalid");
                            z = false;
                            z2 = false;
                            break;
                        case 18:
                            zzgt().zzjj().zzby("Service updating");
                            z = true;
                            z2 = true;
                            break;
                        default:
                            zzgt().zzjj().zzg("Unexpected service status", Integer.valueOf(iZzs));
                            z = false;
                            z2 = false;
                            break;
                    }
                } else {
                    z = true;
                    z2 = true;
                }
                if (!z && zzgv().zzif()) {
                    zzgt().zzjg().zzby("No way to upload. Consider using the full version of Analytics");
                    z2 = false;
                }
                if (z2) {
                    zzgu().zzg(z);
                }
            } else {
                z = true;
            }
            this.zzasg = Boolean.valueOf(z);
        }
        if (this.zzasg.booleanValue()) {
            this.zzase.zzll();
            return;
        }
        if (zzgv().zzif()) {
            return;
        }
        zzgw();
        List<ResolveInfo> listQueryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (!(listQueryIntentServices != null && listQueryIntentServices.size() > 0)) {
            zzgt().zzjg().zzby("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context context = getContext();
        zzgw();
        intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
        this.zzase.zzb(intent);
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
    protected final void zzld() {
        zzaf();
        zzcl();
        zzf(new zzeh(this, zzl(true)));
    }

    @WorkerThread
    protected final void zzlg() {
        zzaf();
        zzcl();
        zzf(new zzel(this, zzl(true)));
    }

    final Boolean zzli() {
        return this.zzasg;
    }
}
