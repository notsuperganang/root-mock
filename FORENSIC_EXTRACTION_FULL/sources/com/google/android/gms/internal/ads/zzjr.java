package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public class zzjr {
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private zzld zzari;
    private final zzjh zzarj;
    private final zzjg zzark;
    private final zzme zzarl;
    private final zzrv zzarm;
    private final zzahi zzarn;
    private final zzaao zzaro;
    private final zzrw zzarp;

    @VisibleForTesting
    abstract class zza<T> {
        zza() {
        }

        @Nullable
        protected abstract T zza(zzld zzldVar) throws RemoteException;

        @Nullable
        protected abstract T zzib() throws RemoteException;

        @Nullable
        protected final T zzic() {
            zzld zzldVarZzia = zzjr.this.zzia();
            if (zzldVarZzia == null) {
                zzane.zzdk("ClientApi class cannot be loaded.");
                return null;
            }
            try {
                return zza(zzldVarZzia);
            } catch (RemoteException e) {
                zzane.zzc("Cannot invoke local loader using ClientApi class", e);
                return null;
            }
        }

        @Nullable
        protected final T zzid() {
            try {
                return zzib();
            } catch (RemoteException e) {
                zzane.zzc("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public zzjr(zzjh zzjhVar, zzjg zzjgVar, zzme zzmeVar, zzrv zzrvVar, zzahi zzahiVar, zzaao zzaaoVar, zzrw zzrwVar) {
        this.zzarj = zzjhVar;
        this.zzark = zzjgVar;
        this.zzarl = zzmeVar;
        this.zzarm = zzrvVar;
        this.zzarn = zzahiVar;
        this.zzaro = zzaaoVar;
        this.zzarp = zzrwVar;
    }

    @VisibleForTesting
    static <T> T zza(Context context, boolean z, zza<T> zzaVar) {
        boolean z2 = z;
        if (!z2) {
            zzkb.zzif();
            if (!zzamu.zzbe(context)) {
                zzane.zzck("Google Play Services is not available");
                z2 = true;
            }
        }
        zzkb.zzif();
        int iZzbg = zzamu.zzbg(context);
        zzkb.zzif();
        boolean z3 = iZzbg <= zzamu.zzbf(context) ? z2 : true;
        zznk.initialize(context);
        if (((Boolean) zzkb.zzik().zzd(zznk.zzber)).booleanValue()) {
            z3 = false;
        }
        if (z3) {
            T tZzic = zzaVar.zzic();
            return tZzic == null ? zzaVar.zzid() : tZzic;
        }
        T tZzid = zzaVar.zzid();
        return tZzid == null ? zzaVar.zzic() : tZzid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzkb.zzif().zza(context, (String) null, "gmob-apps", bundle, true);
    }

    @Nullable
    private static zzld zzhz() {
        zzld zzldVarAsInterface;
        try {
            Object objNewInstance = zzjr.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (objNewInstance instanceof IBinder) {
                zzldVarAsInterface = zzle.asInterface((IBinder) objNewInstance);
            } else {
                zzane.zzdk("ClientApi class is not an instance of IBinder");
                zzldVarAsInterface = null;
            }
            return zzldVarAsInterface;
        } catch (Exception e) {
            zzane.zzc("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final zzld zzia() {
        zzld zzldVar;
        synchronized (this.mLock) {
            if (this.zzari == null) {
                this.zzari = zzhz();
            }
            zzldVar = this.zzari;
        }
        return zzldVar;
    }

    public final zzqa zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzqa) zza(context, false, (zza) new zzjx(this, frameLayout, frameLayout2, context));
    }

    public final zzqf zza(View view, HashMap<String, View> map, HashMap<String, View> map2) {
        return (zzqf) zza(view.getContext(), false, (zza) new zzjy(this, view, map, map2));
    }

    @Nullable
    public final zzaap zzb(Activity activity) {
        boolean booleanExtra = false;
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            zzane.e("useClientJar flag not found in activity intent extras.");
        }
        return (zzaap) zza(activity, booleanExtra, new zzka(this, activity));
    }

    public final zzkn zzb(Context context, String str, zzxn zzxnVar) {
        return (zzkn) zza(context, false, (zza) new zzjv(this, context, str, zzxnVar));
    }
}
