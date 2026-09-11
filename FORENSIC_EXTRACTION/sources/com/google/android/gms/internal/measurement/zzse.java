package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.annotation.GuardedBy;
import android.support.v4.content.PermissionChecker;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzse implements zzsb {

    @GuardedBy("GservicesLoader.class")
    static zzse zzbrl;
    private final Context zzri;

    private zzse() {
        this.zzri = null;
    }

    private zzse(Context context) {
        this.zzri = context;
        this.zzri.getContentResolver().registerContentObserver(zzru.CONTENT_URI, true, new zzsg(this, null));
    }

    static zzse zzad(Context context) {
        zzse zzseVar;
        synchronized (zzse.class) {
            try {
                if (zzbrl == null) {
                    zzbrl = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzse(context) : new zzse();
                }
                zzseVar = zzbrl;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzseVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzsb
    /* JADX INFO: renamed from: zzfo, reason: merged with bridge method [inline-methods] */
    public final String zzfn(final String str) {
        if (this.zzri == null) {
            return null;
        }
        try {
            return (String) zzsc.zza(new zzsd(this, str) { // from class: com.google.android.gms.internal.measurement.zzsf
                private final zzse zzbrm;
                private final String zzbrn;

                {
                    this.zzbrm = this;
                    this.zzbrn = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzsd
                public final Object zzto() {
                    return this.zzbrm.zzfp(this.zzbrn);
                }
            });
        } catch (SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    final /* synthetic */ String zzfp(String str) {
        return zzru.zza(this.zzri.getContentResolver(), str, (String) null);
    }
}
