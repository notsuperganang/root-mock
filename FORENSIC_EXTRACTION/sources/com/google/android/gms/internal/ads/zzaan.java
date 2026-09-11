package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzaan {

    @VisibleForTesting
    private zzatn zzbxh;
    private static final Object sLock = new Object();

    @VisibleForTesting
    @GuardedBy("sLock")
    private static boolean zzsh = false;

    @VisibleForTesting
    @GuardedBy("sLock")
    private static boolean zzbxg = false;

    @VisibleForTesting
    private final void zzj(Context context) {
        synchronized (sLock) {
            if (((Boolean) zzkb.zzik().zzd(zznk.zzbet)).booleanValue() && !zzbxg) {
                try {
                    zzbxg = true;
                    this.zzbxh = zzato.zzab(DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.ads.dynamite").instantiate("com.google.android.gms.ads.omid.DynamiteOmid"));
                } catch (DynamiteModule.LoadingException e) {
                    zzane.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Nullable
    public final String getVersion(Context context) {
        if (!((Boolean) zzkb.zzik().zzd(zznk.zzbet)).booleanValue()) {
            return null;
        }
        try {
            zzj(context);
            String strValueOf = String.valueOf(this.zzbxh.getVersion());
            return strValueOf.length() != 0 ? "a.".concat(strValueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzane.zzd("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        synchronized (sLock) {
            if (!((Boolean) zzkb.zzik().zzd(zznk.zzbet)).booleanValue() || !zzsh) {
                return null;
            }
            try {
                return this.zzbxh.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4);
            } catch (RemoteException | NullPointerException e) {
                zzane.zzd("#007 Could not call remote method.", e);
                return null;
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (sLock) {
            if (((Boolean) zzkb.zzik().zzd(zznk.zzbet)).booleanValue() && zzsh) {
                try {
                    this.zzbxh.zza(iObjectWrapper, ObjectWrapper.wrap(view));
                } catch (RemoteException | NullPointerException e) {
                    zzane.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean zzi(Context context) {
        synchronized (sLock) {
            if (!((Boolean) zzkb.zzik().zzd(zznk.zzbet)).booleanValue()) {
                return false;
            }
            if (zzsh) {
                return true;
            }
            try {
                zzj(context);
                boolean zZzy = this.zzbxh.zzy(ObjectWrapper.wrap(context));
                zzsh = zZzy;
                return zZzy;
            } catch (RemoteException | NullPointerException e) {
                zzane.zzd("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final void zzm(IObjectWrapper iObjectWrapper) {
        synchronized (sLock) {
            if (((Boolean) zzkb.zzik().zzd(zznk.zzbet)).booleanValue() && zzsh) {
                try {
                    this.zzbxh.zzm(iObjectWrapper);
                } catch (RemoteException | NullPointerException e) {
                    zzane.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        synchronized (sLock) {
            if (((Boolean) zzkb.zzik().zzd(zznk.zzbet)).booleanValue() && zzsh) {
                try {
                    this.zzbxh.zzn(iObjectWrapper);
                } catch (RemoteException | NullPointerException e) {
                    zzane.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
