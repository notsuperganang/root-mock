package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.annotation.GuardedBy;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzrx implements zzsb {

    @GuardedBy("ConfigurationContentLoader.class")
    static final Map<Uri, zzrx> zzbrd = new ArrayMap();
    private static final String[] zzbri = {"key", FirebaseAnalytics.Param.VALUE};
    private final Uri uri;
    private final ContentResolver zzbre;
    private volatile Map<String, String> zzbrg;
    private final Object zzbrf = new Object();

    @GuardedBy("this")
    private final List<zzsa> zzbrh = new ArrayList();

    private zzrx(ContentResolver contentResolver, Uri uri) {
        this.zzbre = contentResolver;
        this.uri = uri;
        this.zzbre.registerContentObserver(uri, false, new zzrz(this, null));
    }

    public static zzrx zza(ContentResolver contentResolver, Uri uri) {
        zzrx zzrxVar;
        synchronized (zzrx.class) {
            try {
                zzrxVar = zzbrd.get(uri);
                if (zzrxVar == null) {
                    try {
                        zzrx zzrxVar2 = new zzrx(contentResolver, uri);
                        try {
                            zzbrd.put(uri, zzrxVar2);
                            zzrxVar = zzrxVar2;
                        } catch (SecurityException e) {
                            zzrxVar = zzrxVar2;
                        }
                    } catch (SecurityException e2) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzrxVar;
    }

    private final Map<String, String> zztm() {
        try {
            return (Map) zzsc.zza(new zzsd(this) { // from class: com.google.android.gms.internal.measurement.zzry
                private final zzrx zzbrj;

                {
                    this.zzbrj = this;
                }

                @Override // com.google.android.gms.internal.measurement.zzsd
                public final Object zzto() {
                    return this.zzbrj.zztn();
                }
            });
        } catch (SQLiteException | SecurityException e) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzsb
    public final /* synthetic */ Object zzfn(String str) {
        return zztk().get(str);
    }

    public final Map<String, String> zztk() {
        Map<String, String> mapZztm = this.zzbrg;
        if (mapZztm == null) {
            synchronized (this.zzbrf) {
                mapZztm = this.zzbrg;
                if (mapZztm == null) {
                    mapZztm = zztm();
                    this.zzbrg = mapZztm;
                }
            }
        }
        return mapZztm != null ? mapZztm : Collections.emptyMap();
    }

    public final void zztl() {
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

    final /* synthetic */ Map zztn() {
        Cursor cursorQuery = this.zzbre.query(this.uri, zzbri, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
            while (cursorQuery.moveToNext()) {
                arrayMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return arrayMap;
        } finally {
            cursorQuery.close();
        }
    }
}
