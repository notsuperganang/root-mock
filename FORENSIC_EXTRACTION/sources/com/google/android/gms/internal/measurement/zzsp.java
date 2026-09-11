package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzsp implements zzsb {

    @GuardedBy("SharedPreferencesLoader.class")
    static final Map<String, zzsp> zzbsb = new HashMap();
    private volatile Map<String, ?> zzbrg;
    private final SharedPreferences zzbsc;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzbsd = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.measurement.zzsq
        private final zzsp zzbse;

        {
            this.zzbse = this;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            this.zzbse.zza(sharedPreferences, str);
        }
    };
    private final Object zzbrf = new Object();

    @GuardedBy("this")
    private final List<zzsa> zzbrh = new ArrayList();

    private zzsp(SharedPreferences sharedPreferences) {
        this.zzbsc = sharedPreferences;
        this.zzbsc.registerOnSharedPreferenceChangeListener(this.zzbsd);
    }

    static zzsp zzi(Context context, String str) {
        zzsp zzspVar;
        SharedPreferences sharedPreferences;
        if (!((!zzrw.zztj() || str.startsWith("direct_boot:")) ? true : zzrw.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzsp.class) {
            try {
                zzspVar = zzbsb.get(str);
                if (zzspVar == null) {
                    if (str.startsWith("direct_boot:")) {
                        if (zzrw.zztj()) {
                            context = context.createDeviceProtectedStorageContext();
                        }
                        sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                    } else {
                        sharedPreferences = context.getSharedPreferences(str, 0);
                    }
                    zzsp zzspVar2 = new zzsp(sharedPreferences);
                    zzbsb.put(str, zzspVar2);
                    zzspVar = zzspVar2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzspVar;
    }

    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzbrf) {
            this.zzbrg = null;
            zzsi.zztq();
        }
        synchronized (this) {
            Iterator<zzsa> it = this.zzbrh.iterator();
            while (it.hasNext()) {
                it.next().zztp();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzsb
    public final Object zzfn(String str) {
        Map<String, ?> all = this.zzbrg;
        if (all == null) {
            synchronized (this.zzbrf) {
                all = this.zzbrg;
                if (all == null) {
                    all = this.zzbsc.getAll();
                    this.zzbrg = all;
                }
            }
        }
        if (all != null) {
            return all.get(str);
        }
        return null;
    }
}
