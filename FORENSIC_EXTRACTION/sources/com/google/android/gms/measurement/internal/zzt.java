package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzxz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzt extends zzfm {
    private static final String[] zzagz = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] zzaha = {FirebaseAnalytics.Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzahb = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;"};
    private static final String[] zzahc = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzahd = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzahe = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzw zzahf;
    private final zzfi zzahg;

    zzt(zzfn zzfnVar) {
        super(zzfnVar);
        this.zzahg = new zzfi(zzbx());
        this.zzahf = new zzw(this, getContext(), "google_app_measurement.db");
    }

    @WorkerThread
    private final long zza(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = getWritableDatabase().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = getWritableDatabase().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzgt().zzjg().zzby("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzgt().zzjg().zzby("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzgt().zzjg().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Double) obj);
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, com.google.android.gms.internal.measurement.zzfj zzfjVar) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfjVar);
        if (TextUtils.isEmpty(zzfjVar.zzavn)) {
            zzgt().zzjj().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzas.zzbw(str), Integer.valueOf(i), String.valueOf(zzfjVar.zzavm));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfjVar.zzvx()];
            zzya zzyaVarZzk = zzya.zzk(bArr, 0, bArr.length);
            zzfjVar.zza(zzyaVarZzk);
            zzyaVarZzk.zzza();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzfjVar.zzavm);
            contentValues.put("event_name", zzfjVar.zzavn);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzgt().zzjg().zzg("Failed to insert event filter (got -1). appId", zzas.zzbw(str));
                }
                return true;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing event filter. appId", zzas.zzbw(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Configuration loss. Failed to serialize event filter. appId", zzas.zzbw(str), e2);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, com.google.android.gms.internal.measurement.zzfm zzfmVar) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfmVar);
        if (TextUtils.isEmpty(zzfmVar.zzawc)) {
            zzgt().zzjj().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzas.zzbw(str), Integer.valueOf(i), String.valueOf(zzfmVar.zzavm));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfmVar.zzvx()];
            zzya zzyaVarZzk = zzya.zzk(bArr, 0, bArr.length);
            zzfmVar.zza(zzyaVarZzk);
            zzyaVarZzk.zzza();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzfmVar.zzavm);
            contentValues.put("property_name", zzfmVar.zzawc);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert property filter (got -1). appId", zzas.zzbw(str));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing property filter. appId", zzas.zzbw(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Configuration loss. Failed to serialize property filter. appId", zzas.zzbw(str), e2);
            return false;
        }
    }

    private final boolean zza(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzcl();
        zzaf();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            long jZza = zza("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zzgv().zzb(str, zzai.zzajz)));
            if (jZza <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String strJoin = TextUtils.join(",", arrayList);
            String string = new StringBuilder(String.valueOf(strJoin).length() + 2).append("(").append(strJoin).append(")").toString();
            if (writableDatabase.delete("audience_filter_values", new StringBuilder(String.valueOf(string).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(string).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(iMax)}) > 0) {
                return true;
            }
            return false;
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Database error querying filters. appId", zzas.zzbw(str), e);
            return false;
        }
    }

    private final boolean zzip() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    public final void beginTransaction() {
        zzcl();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public final void endTransaction() {
        zzcl();
        getWritableDatabase().endTransaction();
    }

    @WorkerThread
    @VisibleForTesting
    final SQLiteDatabase getWritableDatabase() {
        zzaf();
        try {
            return this.zzahf.getWritableDatabase();
        } catch (SQLiteException e) {
            zzgt().zzjj().zzg("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public final void setTransactionSuccessful() {
        zzcl();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final long zza(com.google.android.gms.internal.measurement.zzfw zzfwVar) throws IOException {
        long jZzc;
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzfwVar);
        Preconditions.checkNotEmpty(zzfwVar.zztt);
        try {
            byte[] bArr = new byte[zzfwVar.zzvx()];
            zzya zzyaVarZzk = zzya.zzk(bArr, 0, bArr.length);
            zzfwVar.zza(zzyaVarZzk);
            zzyaVarZzk.zzza();
            zzft zzftVarZzjr = zzjr();
            Preconditions.checkNotNull(bArr);
            zzftVarZzjr.zzgr().zzaf();
            MessageDigest messageDigest = zzfx.getMessageDigest();
            if (messageDigest == null) {
                zzftVarZzjr.zzgt().zzjg().zzby("Failed to get MD5");
                jZzc = 0;
            } else {
                jZzc = zzfx.zzc(messageDigest.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzfwVar.zztt);
            contentValues.put("metadata_fingerprint", Long.valueOf(jZzc));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return jZzc;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing raw event metadata. appId", zzas.zzbw(zzfwVar.zztt), e);
                throw e;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Data loss. Failed to serialize event metadata. appId", zzas.zzbw(zzfwVar.zztt), e2);
            throw e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008f  */
    /* JADX WARN: Code duplicated, block: B:42:? A[SYNTHETIC] */
    public final Pair<com.google.android.gms.internal.measurement.zzft, Long> zza(String str, Long l) {
        Cursor cursor;
        Throwable th;
        Cursor cursorRawQuery;
        Pair<com.google.android.gms.internal.measurement.zzft, Long> pairCreate = null;
        zzaf();
        zzcl();
        try {
            cursorRawQuery = getWritableDatabase().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
            try {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        byte[] blob = cursorRawQuery.getBlob(0);
                        long j = cursorRawQuery.getLong(1);
                        zzxz zzxzVarZzj = zzxz.zzj(blob, 0, blob.length);
                        com.google.android.gms.internal.measurement.zzft zzftVar = new com.google.android.gms.internal.measurement.zzft();
                        try {
                            zzftVar.zza(zzxzVarZzj);
                            pairCreate = Pair.create(zzftVar, Long.valueOf(j));
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                        } catch (IOException e) {
                            zzgt().zzjg().zzd("Failed to merge main event. appId, eventId", zzas.zzbw(str), l, e);
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                        }
                    } else {
                        zzgt().zzjo().zzby("Main event not found");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzgt().zzjg().zzg("Error selecting main event", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
            } catch (Throwable th2) {
                cursor = cursorRawQuery;
                th = th2;
                if (cursor != null) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            if (cursor != null) {
                throw th;
            }
            cursor.close();
            throw th;
        }
        return pairCreate;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0132  */
    @WorkerThread
    public final zzu zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) throws Throwable {
        Cursor cursor;
        Cursor cursor2;
        SQLiteException e;
        Throwable th;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        zzu zzuVar = new zzu();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            Cursor cursorQuery = writableDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getLong(0) == j) {
                        zzuVar.zzahi = cursorQuery.getLong(1);
                        zzuVar.zzahh = cursorQuery.getLong(2);
                        zzuVar.zzahj = cursorQuery.getLong(3);
                        zzuVar.zzahk = cursorQuery.getLong(4);
                        zzuVar.zzahl = cursorQuery.getLong(5);
                    }
                    if (z) {
                        zzuVar.zzahi++;
                    }
                    if (z2) {
                        zzuVar.zzahh++;
                    }
                    if (z3) {
                        zzuVar.zzahj++;
                    }
                    if (z4) {
                        zzuVar.zzahk++;
                    }
                    if (z5) {
                        zzuVar.zzahl++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzuVar.zzahh));
                    contentValues.put("daily_events_count", Long.valueOf(zzuVar.zzahi));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzuVar.zzahj));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzuVar.zzahk));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzuVar.zzahl));
                    writableDatabase.update("apps", contentValues, "app_id=?", new String[]{str});
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } else {
                    zzgt().zzjj().zzg("Not updating daily counts, app is not known. appId", zzas.zzbw(str));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor2 = cursorQuery;
                try {
                    zzgt().zzjg().zze("Error updating daily counts. appId", zzas.zzbw(str), e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = cursorQuery;
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            cursor2 = null;
            e = e3;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return zzuVar;
    }

    @WorkerThread
    public final void zza(zzac zzacVar) {
        Long l = null;
        Preconditions.checkNotNull(zzacVar);
        zzaf();
        zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzacVar.zztt);
        contentValues.put("name", zzacVar.name);
        contentValues.put("lifetime_count", Long.valueOf(zzacVar.zzahv));
        contentValues.put("current_bundle_count", Long.valueOf(zzacVar.zzahw));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzacVar.zzahx));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzacVar.zzahy));
        contentValues.put("last_bundled_day", zzacVar.zzahz);
        contentValues.put("last_sampled_complex_event_id", zzacVar.zzaia);
        contentValues.put("last_sampling_rate", zzacVar.zzaib);
        if (zzacVar.zzaic != null && zzacVar.zzaic.booleanValue()) {
            l = 1L;
        }
        contentValues.put("last_exempt_from_sampling", l);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update event aggregates (got -1). appId", zzas.zzbw(zzacVar.zztt));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing event aggregates. appId", zzas.zzbw(zzacVar.zztt), e);
        }
    }

    @WorkerThread
    public final void zza(zzg zzgVar) {
        Preconditions.checkNotNull(zzgVar);
        zzaf();
        zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzal());
        contentValues.put("app_instance_id", zzgVar.getAppInstanceId());
        contentValues.put("gmp_app_id", zzgVar.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzgVar.zzhc());
        contentValues.put("last_bundle_index", Long.valueOf(zzgVar.zzhj()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzgVar.zzhd()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzgVar.zzhe()));
        contentValues.put("app_version", zzgVar.zzak());
        contentValues.put("app_store", zzgVar.zzhg());
        contentValues.put("gmp_version", Long.valueOf(zzgVar.zzhh()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzgVar.zzhi()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzgVar.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(zzgVar.zzhn()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzgVar.zzho()));
        contentValues.put("daily_events_count", Long.valueOf(zzgVar.zzhp()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzgVar.zzhq()));
        contentValues.put("config_fetched_time", Long.valueOf(zzgVar.zzhk()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzgVar.zzhl()));
        contentValues.put("app_version_int", Long.valueOf(zzgVar.zzhf()));
        contentValues.put("firebase_instance_id", zzgVar.getFirebaseInstanceId());
        contentValues.put("daily_error_events_count", Long.valueOf(zzgVar.zzhs()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzgVar.zzhr()));
        contentValues.put("health_monitor_sample", zzgVar.zzht());
        contentValues.put("android_id", Long.valueOf(zzgVar.zzhv()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzgVar.zzhw()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzgVar.zzhx()));
        contentValues.put("admob_app_id", zzgVar.zzhb());
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{zzgVar.zzal()}) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update app (got -1). appId", zzas.zzbw(zzgVar.zzal()));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing app. appId", zzas.zzbw(zzgVar.zzal()), e);
        }
    }

    @WorkerThread
    final void zza(String str, com.google.android.gms.internal.measurement.zzfi[] zzfiVarArr) {
        boolean z;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfiVarArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzcl();
            zzaf();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete("property_filters", "app_id=?", new String[]{str});
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (com.google.android.gms.internal.measurement.zzfi zzfiVar : zzfiVarArr) {
                zzcl();
                zzaf();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfiVar);
                Preconditions.checkNotNull(zzfiVar.zzavi);
                Preconditions.checkNotNull(zzfiVar.zzavh);
                if (zzfiVar.zzavg != null) {
                    int iIntValue = zzfiVar.zzavg.intValue();
                    com.google.android.gms.internal.measurement.zzfj[] zzfjVarArr = zzfiVar.zzavi;
                    int length = zzfjVarArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            com.google.android.gms.internal.measurement.zzfm[] zzfmVarArr = zzfiVar.zzavh;
                            int length2 = zzfmVarArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    com.google.android.gms.internal.measurement.zzfj[] zzfjVarArr2 = zzfiVar.zzavi;
                                    int length3 = zzfjVarArr2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length3) {
                                            z = true;
                                            break;
                                        } else {
                                            if (!zza(str, iIntValue, zzfjVarArr2[i3])) {
                                                z = false;
                                                break;
                                            }
                                            i3++;
                                        }
                                    }
                                    if (z) {
                                        com.google.android.gms.internal.measurement.zzfm[] zzfmVarArr2 = zzfiVar.zzavh;
                                        for (com.google.android.gms.internal.measurement.zzfm zzfmVar : zzfmVarArr2) {
                                            if (!zza(str, iIntValue, zzfmVar)) {
                                                z = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzcl();
                                        zzaf();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iIntValue)});
                                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iIntValue)});
                                        break;
                                    }
                                    break;
                                }
                                if (zzfmVarArr[i2].zzavm == null) {
                                    zzgt().zzjj().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", zzas.zzbw(str), zzfiVar.zzavg);
                                    break;
                                }
                                i2++;
                            }
                        } else {
                            if (zzfjVarArr[i].zzavm == null) {
                                zzgt().zzjj().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", zzas.zzbw(str), zzfiVar.zzavg);
                                break;
                            }
                            i++;
                        }
                    }
                } else {
                    zzgt().zzjj().zzg("Audience with no ID. appId", zzas.zzbw(str));
                }
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.zzfi zzfiVar2 : zzfiVarArr) {
                arrayList.add(zzfiVar2.zzavg);
            }
            zza(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public final boolean zza(com.google.android.gms.internal.measurement.zzfw zzfwVar, boolean z) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzfwVar);
        Preconditions.checkNotEmpty(zzfwVar.zztt);
        Preconditions.checkNotNull(zzfwVar.zzaxo);
        zzij();
        long jCurrentTimeMillis = zzbx().currentTimeMillis();
        if (zzfwVar.zzaxo.longValue() < jCurrentTimeMillis - zzq.zzib() || zzfwVar.zzaxo.longValue() > zzq.zzib() + jCurrentTimeMillis) {
            zzgt().zzjj().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzas.zzbw(zzfwVar.zztt), Long.valueOf(jCurrentTimeMillis), zzfwVar.zzaxo);
        }
        try {
            byte[] bArr = new byte[zzfwVar.zzvx()];
            zzya zzyaVarZzk = zzya.zzk(bArr, 0, bArr.length);
            zzfwVar.zza(zzyaVarZzk);
            zzyaVarZzk.zzza();
            byte[] bArrZzb = zzjr().zzb(bArr);
            zzgt().zzjo().zzg("Saving bundle, size", Integer.valueOf(bArrZzb.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzfwVar.zztt);
            contentValues.put("bundle_end_timestamp", zzfwVar.zzaxo);
            contentValues.put("data", bArrZzb);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzfwVar.zzayl != null) {
                contentValues.put("retry_count", zzfwVar.zzayl);
            }
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert bundle (got -1). appId", zzas.zzbw(zzfwVar.zztt));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing bundle. appId", zzas.zzbw(zzfwVar.zztt), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Data loss. Failed to serialize bundle. appId", zzas.zzbw(zzfwVar.zztt), e2);
            return false;
        }
    }

    public final boolean zza(zzab zzabVar, long j, boolean z) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzabVar);
        Preconditions.checkNotEmpty(zzabVar.zztt);
        com.google.android.gms.internal.measurement.zzft zzftVar = new com.google.android.gms.internal.measurement.zzft();
        zzftVar.zzaxe = Long.valueOf(zzabVar.zzaht);
        zzftVar.zzaxc = new com.google.android.gms.internal.measurement.zzfu[zzabVar.zzahu.size()];
        int i = 0;
        for (String str : zzabVar.zzahu) {
            com.google.android.gms.internal.measurement.zzfu zzfuVar = new com.google.android.gms.internal.measurement.zzfu();
            zzftVar.zzaxc[i] = zzfuVar;
            zzfuVar.name = str;
            zzjr().zza(zzfuVar, zzabVar.zzahu.get(str));
            i++;
        }
        try {
            byte[] bArr = new byte[zzftVar.zzvx()];
            zzya zzyaVarZzk = zzya.zzk(bArr, 0, bArr.length);
            zzftVar.zza(zzyaVarZzk);
            zzyaVarZzk.zzza();
            zzgt().zzjo().zze("Saving event, name, data size", zzgq().zzbt(zzabVar.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzabVar.zztt);
            contentValues.put("name", zzabVar.name);
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(zzabVar.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert raw event (got -1). appId", zzas.zzbw(zzabVar.zztt));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing raw event. appId", zzas.zzbw(zzabVar.zztt), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Data loss. Failed to serialize event params/data. appId", zzas.zzbw(zzabVar.zztt), e2);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(zzfw zzfwVar) {
        Preconditions.checkNotNull(zzfwVar);
        zzaf();
        zzcl();
        if (zzi(zzfwVar.zztt, zzfwVar.name) == null) {
            if (zzfx.zzct(zzfwVar.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzfwVar.zztt}) >= 25) {
                    return false;
                }
            } else if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzfwVar.zztt, zzfwVar.origin}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzfwVar.zztt);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, zzfwVar.origin);
        contentValues.put("name", zzfwVar.name);
        contentValues.put("set_timestamp", Long.valueOf(zzfwVar.zzaum));
        zza(contentValues, FirebaseAnalytics.Param.VALUE, zzfwVar.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update user property (got -1). appId", zzas.zzbw(zzfwVar.zztt));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing user property. appId", zzas.zzbw(zzfwVar.zztt), e);
        }
        return true;
    }

    @WorkerThread
    public final boolean zza(zzo zzoVar) {
        Preconditions.checkNotNull(zzoVar);
        zzaf();
        zzcl();
        if (zzi(zzoVar.packageName, zzoVar.zzags.name) == null && zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzoVar.packageName}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzoVar.packageName);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, zzoVar.origin);
        contentValues.put("name", zzoVar.zzags.name);
        zza(contentValues, FirebaseAnalytics.Param.VALUE, zzoVar.zzags.getValue());
        contentValues.put("active", Boolean.valueOf(zzoVar.active));
        contentValues.put("trigger_event_name", zzoVar.triggerEventName);
        contentValues.put("trigger_timeout", Long.valueOf(zzoVar.triggerTimeout));
        zzgr();
        contentValues.put("timed_out_event", zzfx.zza(zzoVar.zzagt));
        contentValues.put("creation_timestamp", Long.valueOf(zzoVar.creationTimestamp));
        zzgr();
        contentValues.put("triggered_event", zzfx.zza(zzoVar.zzagu));
        contentValues.put("triggered_timestamp", Long.valueOf(zzoVar.zzags.zzaum));
        contentValues.put("time_to_live", Long.valueOf(zzoVar.timeToLive));
        zzgr();
        contentValues.put("expired_event", zzfx.zza(zzoVar.zzagv));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update conditional user property (got -1)", zzas.zzbw(zzoVar.packageName));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing conditional user property", zzas.zzbw(zzoVar.packageName), e);
        }
        return true;
    }

    public final boolean zza(String str, Long l, long j, com.google.android.gms.internal.measurement.zzft zzftVar) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzftVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        try {
            byte[] bArr = new byte[zzftVar.zzvx()];
            zzya zzyaVarZzk = zzya.zzk(bArr, 0, bArr.length);
            zzftVar.zza(zzyaVarZzk);
            zzyaVarZzk.zzza();
            zzgt().zzjo().zze("Saving complex main event, appId, data size", zzgq().zzbt(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert complex main event (got -1). appId", zzas.zzbw(str));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing complex main event. appId", zzas.zzbw(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzas.zzbw(str), l, e2);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    public final String zzad(long j) throws Throwable {
        Cursor cursorRawQuery;
        String string = null;
        zzaf();
        zzcl();
        try {
            cursorRawQuery = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        string = cursorRawQuery.getString(0);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } else {
                        zzgt().zzjo().zzby("No expired configs for apps with pending events");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzgt().zzjg().zzg("Error selecting expired configs", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursorRawQuery = null;
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00fe  */
    @WorkerThread
    public final List<Pair<com.google.android.gms.internal.measurement.zzfw, Long>> zzb(String str, int i, int i2) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        List<Pair<com.google.android.gms.internal.measurement.zzfw, Long>> listEmptyList;
        int length;
        zzaf();
        zzcl();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        try {
            cursorQuery = getWritableDatabase().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (cursorQuery.moveToFirst()) {
                    listEmptyList = new ArrayList<>();
                    int i3 = 0;
                    while (true) {
                        long j = cursorQuery.getLong(0);
                        try {
                            byte[] bArrZza = zzjr().zza(cursorQuery.getBlob(1));
                            if (!listEmptyList.isEmpty() && bArrZza.length + i3 > i2) {
                                break;
                            }
                            zzxz zzxzVarZzj = zzxz.zzj(bArrZza, 0, bArrZza.length);
                            com.google.android.gms.internal.measurement.zzfw zzfwVar = new com.google.android.gms.internal.measurement.zzfw();
                            try {
                                zzfwVar.zza(zzxzVarZzj);
                                if (!cursorQuery.isNull(2)) {
                                    zzfwVar.zzayl = Integer.valueOf(cursorQuery.getInt(2));
                                }
                                length = bArrZza.length + i3;
                                listEmptyList.add(Pair.create(zzfwVar, Long.valueOf(j)));
                            } catch (IOException e) {
                                zzgt().zzjg().zze("Failed to merge queued bundle. appId", zzas.zzbw(str), e);
                                length = i3;
                            }
                            if (!cursorQuery.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e2) {
                            zzgt().zzjg().zze("Failed to unzip queued bundle. appId", zzas.zzbw(str), e2);
                            length = i3;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } else {
                    listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = cursorQuery;
                try {
                    zzgt().zzjg().zze("Error querying bundles. appId", zzas.zzbw(str), e);
                    listEmptyList = Collections.emptyList();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursorQuery = cursor;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
        return listEmptyList;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0103  */
    @WorkerThread
    public final List<zzfw> zzb(String str, String str2, String str3) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder sb = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                arrayList2.add(str2);
                sb.append(" and origin=?");
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                sb.append(" and name glob ?");
            }
            cursorQuery = getWritableDatabase().query("user_attributes", new String[]{"name", "set_timestamp", FirebaseAnalytics.Param.VALUE, FirebaseAnalytics.Param.ORIGIN}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", NativeContentAd.ASSET_HEADLINE);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return arrayList;
                    }
                    while (true) {
                        if (arrayList.size() >= 1000) {
                            zzgt().zzjg().zzg("Read more than the max allowed user properties, ignoring excess", 1000);
                            break;
                        }
                        String string = cursorQuery.getString(0);
                        long j = cursorQuery.getLong(1);
                        Object objZza = zza(cursorQuery, 2);
                        String string2 = cursorQuery.getString(3);
                        if (objZza == null) {
                            try {
                                zzgt().zzjg().zzd("(2)Read invalid user property value, ignoring it", zzas.zzbw(str), string2, str3);
                            } catch (SQLiteException e) {
                                e = e;
                                cursor = cursorQuery;
                                str2 = string2;
                                try {
                                    zzgt().zzjg().zzd("(2)Error querying user properties", zzas.zzbw(str), str2, e);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    cursorQuery = cursor;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            arrayList.add(new zzfw(str, string2, string, j, objZza));
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        str2 = string2;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0164  */
    public final List<zzo> zzb(String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        zzaf();
        zzcl();
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = getWritableDatabase().query("conditional_properties", new String[]{"app_id", FirebaseAnalytics.Param.ORIGIN, "name", FirebaseAnalytics.Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", NativeContentAd.ASSET_HEADLINE);
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                }
                do {
                    if (arrayList.size() >= 1000) {
                        zzgt().zzjg().zzg("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objZza = zza(cursorQuery, 3);
                    boolean z = cursorQuery.getInt(4) != 0;
                    String string4 = cursorQuery.getString(5);
                    long j = cursorQuery.getLong(6);
                    arrayList.add(new zzo(string, string2, new zzfu(string3, cursorQuery.getLong(10), objZza, string2), cursorQuery.getLong(8), z, string4, (zzag) zzjr().zza(cursorQuery.getBlob(7), zzag.CREATOR), j, (zzag) zzjr().zza(cursorQuery.getBlob(9), zzag.CREATOR), cursorQuery.getLong(11), (zzag) zzjr().zza(cursorQuery.getBlob(12), zzag.CREATOR)));
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    zzgt().zzjg().zzg("Error querying conditional user property value", e);
                    List<zzo> listEmptyList = Collections.emptyList();
                    if (cursor == null) {
                        return listEmptyList;
                    }
                    cursor.close();
                    return listEmptyList;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery = cursor;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ab  */
    @WorkerThread
    public final List<zzfw> zzbl(String str) throws Throwable {
        Cursor cursor;
        Cursor cursor2 = null;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = getWritableDatabase().query("user_attributes", new String[]{"name", FirebaseAnalytics.Param.ORIGIN, "set_timestamp", FirebaseAnalytics.Param.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    long j = cursorQuery.getLong(2);
                    Object objZza = zza(cursorQuery, 3);
                    if (objZza == null) {
                        zzgt().zzjg().zzg("Read invalid user property value, ignoring it. appId", zzas.zzbw(str));
                    } else {
                        arrayList.add(new zzfw(str, string2, string, j, objZza));
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    zzgt().zzjg().zze("Error querying user properties. appId", zzas.zzbw(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursorQuery;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0233  */
    @WorkerThread
    public final zzg zzbm(String str) throws Throwable {
        Cursor cursor;
        Cursor cursor2 = null;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        try {
            Cursor cursorQuery = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                zzg zzgVar = new zzg(this.zzamx.zzmh(), str);
                zzgVar.zzaj(cursorQuery.getString(0));
                zzgVar.zzak(cursorQuery.getString(1));
                zzgVar.zzam(cursorQuery.getString(2));
                zzgVar.zzt(cursorQuery.getLong(3));
                zzgVar.zzo(cursorQuery.getLong(4));
                zzgVar.zzp(cursorQuery.getLong(5));
                zzgVar.setAppVersion(cursorQuery.getString(6));
                zzgVar.zzao(cursorQuery.getString(7));
                zzgVar.zzr(cursorQuery.getLong(8));
                zzgVar.zzs(cursorQuery.getLong(9));
                zzgVar.setMeasurementEnabled(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                zzgVar.zzw(cursorQuery.getLong(11));
                zzgVar.zzx(cursorQuery.getLong(12));
                zzgVar.zzy(cursorQuery.getLong(13));
                zzgVar.zzz(cursorQuery.getLong(14));
                zzgVar.zzu(cursorQuery.getLong(15));
                zzgVar.zzv(cursorQuery.getLong(16));
                zzgVar.zzq(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                zzgVar.zzan(cursorQuery.getString(18));
                zzgVar.zzab(cursorQuery.getLong(19));
                zzgVar.zzaa(cursorQuery.getLong(20));
                zzgVar.zzap(cursorQuery.getString(21));
                zzgVar.zzac(cursorQuery.isNull(22) ? 0L : cursorQuery.getLong(22));
                zzgVar.zze(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                zzgVar.zzf(cursorQuery.isNull(24) || cursorQuery.getInt(24) != 0);
                zzgVar.zzal(cursorQuery.getString(25));
                zzgVar.zzha();
                if (cursorQuery.moveToNext()) {
                    zzgt().zzjg().zzg("Got multiple records for app, expected one. appId", zzas.zzbw(str));
                }
                if (cursorQuery == null) {
                    return zzgVar;
                }
                cursorQuery.close();
                return zzgVar;
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    zzgt().zzjg().zze("Error querying app. appId", zzas.zzbw(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery = cursor;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursorQuery;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final long zzbn(String str) {
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        try {
            return getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzgv().zzb(str, zzai.zzajj))))});
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error deleting over the limit events. appId", zzas.zzbw(str), e);
            return 0L;
        }
    }

    @WorkerThread
    public final byte[] zzbo(String str) {
        Cursor cursorQuery;
        Cursor cursor = null;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        try {
            cursorQuery = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    if (cursorQuery.moveToNext()) {
                        zzgt().zzjg().zzg("Got multiple records for app config, expected one. appId", zzas.zzbw(str));
                    }
                    if (cursorQuery == null) {
                        return blob;
                    }
                    cursorQuery.close();
                    return blob;
                } catch (SQLiteException e) {
                    e = e;
                    zzgt().zzjg().zze("Error querying remote config. appId", zzas.zzbw(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    final Map<Integer, com.google.android.gms.internal.measurement.zzfx> zzbp(String str) {
        Cursor cursorQuery;
        Cursor cursor = null;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        try {
            cursorQuery = getWritableDatabase().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    ArrayMap arrayMap = new ArrayMap();
                    do {
                        int i = cursorQuery.getInt(0);
                        byte[] blob = cursorQuery.getBlob(1);
                        zzxz zzxzVarZzj = zzxz.zzj(blob, 0, blob.length);
                        com.google.android.gms.internal.measurement.zzfx zzfxVar = new com.google.android.gms.internal.measurement.zzfx();
                        try {
                            zzfxVar.zza(zzxzVarZzj);
                            arrayMap.put(Integer.valueOf(i), zzfxVar);
                        } catch (IOException e) {
                            zzgt().zzjg().zzd("Failed to merge filter results. appId, audienceId, error", zzas.zzbw(str), Integer.valueOf(i), e);
                        }
                    } while (cursorQuery.moveToNext());
                    if (cursorQuery == null) {
                        return arrayMap;
                    }
                    cursorQuery.close();
                    return arrayMap;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzgt().zzjg().zze("Database error querying filter results. appId", zzas.zzbw(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    public final long zzbq(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    @WorkerThread
    public final List<zzo> zzc(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzb(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    @VisibleForTesting
    final void zzc(List<Long> list) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzip()) {
            String strJoin = TextUtils.join(",", list);
            String string = new StringBuilder(String.valueOf(strJoin).length() + 2).append("(").append(strJoin).append(")").toString();
            if (zza(new StringBuilder(String.valueOf(string).length() + 80).append("SELECT COUNT(1) FROM queue WHERE rowid IN ").append(string).append(" AND retry_count =  2147483647 LIMIT 1").toString(), (String[]) null) > 0) {
                zzgt().zzjj().zzby("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                getWritableDatabase().execSQL(new StringBuilder(String.valueOf(string).length() + 127).append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ").append(string).append(" AND (retry_count IS NULL OR retry_count < 2147483647)").toString());
            } catch (SQLiteException e) {
                zzgt().zzjg().zzg("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0138  */
    @WorkerThread
    public final zzac zzg(String str, String str2) {
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            cursorQuery = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                long j = cursorQuery.getLong(0);
                long j2 = cursorQuery.getLong(1);
                long j3 = cursorQuery.getLong(2);
                long j4 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                Boolean boolValueOf = null;
                if (!cursorQuery.isNull(7)) {
                    boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                }
                zzac zzacVar = new zzac(str, str2, j, j2, j3, j4, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                if (cursorQuery.moveToNext()) {
                    zzgt().zzjg().zzg("Got multiple records for event aggregates, expected one. appId", zzas.zzbw(str));
                }
                if (cursorQuery == null) {
                    return zzacVar;
                }
                cursorQuery.close();
                return zzacVar;
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    zzgt().zzjg().zzd("Error querying events. appId", zzas.zzbw(str), zzgq().zzbt(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery = cursor;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfm
    protected final boolean zzgy() {
        return false;
    }

    @WorkerThread
    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            zzgt().zzjo().zzg("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzgt().zzjg().zzd("Error deleting user attribute. appId", zzas.zzbw(str), zzgq().zzbv(str2), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x009d  */
    @WorkerThread
    public final zzfw zzi(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            cursorQuery = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", FirebaseAnalytics.Param.VALUE, FirebaseAnalytics.Param.ORIGIN}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                zzfw zzfwVar = new zzfw(str, cursorQuery.getString(2), str2, cursorQuery.getLong(0), zza(cursorQuery, 1));
                if (cursorQuery.moveToNext()) {
                    zzgt().zzjg().zzg("Got multiple records for user property, expected one. appId", zzas.zzbw(str));
                }
                if (cursorQuery == null) {
                    return zzfwVar;
                }
                cursorQuery.close();
                return zzfwVar;
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    zzgt().zzjg().zzd("Error querying user property. appId", zzas.zzbw(str), zzgq().zzbv(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery = cursor;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    @WorkerThread
    public final String zzih() throws Throwable {
        Cursor cursorRawQuery;
        String string = null;
        try {
            try {
                cursorRawQuery = getWritableDatabase().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        string = cursorRawQuery.getString(0);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } else if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzgt().zzjg().zzg("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursorRawQuery = null;
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
        return string;
    }

    public final boolean zzii() {
        return zza("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    @WorkerThread
    final void zzij() {
        int iDelete;
        zzaf();
        zzcl();
        if (zzip()) {
            long j = zzgu().zzanf.get();
            long jElapsedRealtime = zzbx().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - j) > zzai.zzajs.get().longValue()) {
                zzgu().zzanf.set(jElapsedRealtime);
                zzaf();
                zzcl();
                if (!zzip() || (iDelete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbx().currentTimeMillis()), String.valueOf(zzq.zzib())})) <= 0) {
                    return;
                }
                zzgt().zzjo().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    @WorkerThread
    public final long zzik() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    @WorkerThread
    public final long zzil() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final boolean zzim() {
        return zza("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzin() {
        return zza("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzio() {
        Cursor cursorRawQuery = null;
        long j = -1;
        try {
            cursorRawQuery = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (cursorRawQuery.moveToFirst()) {
                j = cursorRawQuery.getLong(0);
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zzg("Error querying raw events", e);
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x014c  */
    @WorkerThread
    public final zzo zzj(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            cursorQuery = getWritableDatabase().query("conditional_properties", new String[]{FirebaseAnalytics.Param.ORIGIN, FirebaseAnalytics.Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                String string = cursorQuery.getString(0);
                Object objZza = zza(cursorQuery, 1);
                boolean z = cursorQuery.getInt(2) != 0;
                String string2 = cursorQuery.getString(3);
                long j = cursorQuery.getLong(4);
                zzo zzoVar = new zzo(str, string, new zzfu(str2, cursorQuery.getLong(8), objZza, string), cursorQuery.getLong(6), z, string2, (zzag) zzjr().zza(cursorQuery.getBlob(5), zzag.CREATOR), j, (zzag) zzjr().zza(cursorQuery.getBlob(7), zzag.CREATOR), cursorQuery.getLong(9), (zzag) zzjr().zza(cursorQuery.getBlob(10), zzag.CREATOR));
                if (cursorQuery.moveToNext()) {
                    zzgt().zzjg().zze("Got multiple records for conditional property, expected one", zzas.zzbw(str), zzgq().zzbv(str2));
                }
                if (cursorQuery == null) {
                    return zzoVar;
                }
                cursorQuery.close();
                return zzoVar;
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    zzgt().zzjg().zzd("Error querying conditional property", zzas.zzbw(str), zzgq().zzbv(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery = cursor;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @WorkerThread
    public final int zzk(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzgt().zzjg().zzd("Error deleting conditional property", zzas.zzbw(str), zzgq().zzbv(str2), e);
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b7  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00b4: MOVE (r9 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x00b4 */
    final Map<Integer, List<com.google.android.gms.internal.measurement.zzfj>> zzl(String str, String str2) {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2 = null;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        try {
            try {
                cursorQuery = getWritableDatabase().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<com.google.android.gms.internal.measurement.zzfj>> mapEmptyMap = Collections.emptyMap();
                        if (cursorQuery == null) {
                            return mapEmptyMap;
                        }
                        cursorQuery.close();
                        return mapEmptyMap;
                    }
                    do {
                        byte[] blob = cursorQuery.getBlob(1);
                        zzxz zzxzVarZzj = zzxz.zzj(blob, 0, blob.length);
                        com.google.android.gms.internal.measurement.zzfj zzfjVar = new com.google.android.gms.internal.measurement.zzfj();
                        try {
                            zzfjVar.zza(zzxzVarZzj);
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzfjVar);
                        } catch (IOException e) {
                            zzgt().zzjg().zze("Failed to merge filter. appId", zzas.zzbw(str), e);
                        }
                    } while (cursorQuery.moveToNext());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayMap;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzgt().zzjg().zze("Database error querying filters. appId", zzas.zzbw(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b7  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00b4: MOVE (r9 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x00b4 */
    final Map<Integer, List<com.google.android.gms.internal.measurement.zzfm>> zzm(String str, String str2) {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2 = null;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        try {
            try {
                cursorQuery = getWritableDatabase().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<com.google.android.gms.internal.measurement.zzfm>> mapEmptyMap = Collections.emptyMap();
                        if (cursorQuery == null) {
                            return mapEmptyMap;
                        }
                        cursorQuery.close();
                        return mapEmptyMap;
                    }
                    do {
                        byte[] blob = cursorQuery.getBlob(1);
                        zzxz zzxzVarZzj = zzxz.zzj(blob, 0, blob.length);
                        com.google.android.gms.internal.measurement.zzfm zzfmVar = new com.google.android.gms.internal.measurement.zzfm();
                        try {
                            zzfmVar.zza(zzxzVarZzj);
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzfmVar);
                        } catch (IOException e) {
                            zzgt().zzjg().zze("Failed to merge filter", zzas.zzbw(str), e);
                        }
                    } while (cursorQuery.moveToNext());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayMap;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzgt().zzjg().zze("Database error querying filters. appId", zzas.zzbw(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x00b1 A[Catch: all -> 0x00e7, SQLiteException -> 0x00ec, TRY_LEAVE, TryCatch #0 {all -> 0x00e7, blocks: (B:3:0x0017, B:5:0x004a, B:7:0x0074, B:11:0x008a, B:13:0x00b1, B:15:0x00c6, B:19:0x00d2), top: B:27:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x00c6 A[Catch: all -> 0x00e7, SQLiteException -> 0x00ec, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00e7, blocks: (B:3:0x0017, B:5:0x004a, B:7:0x0074, B:11:0x008a, B:13:0x00b1, B:15:0x00c6, B:19:0x00d2), top: B:27:0x0017 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v14, types: [long] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r8v3, types: [long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00e3 -> B:26:0x0088). Please report as a decompilation issue!!! */
    @WorkerThread
    @VisibleForTesting
    protected final long zzn(String str, String str2) {
        ?? r0;
        SQLiteException sQLiteException;
        ?? r2;
        ContentValues contentValues;
        ?? r1 = -1;
        r1 = -1;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            try {
                long jZza = zza(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1L);
                r2 = jZza;
                if (jZza == -1) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put("first_open_count", (Integer) 0);
                    contentValues2.put("previous_install_count", (Integer) 0);
                    if (writableDatabase.insertWithOnConflict("app2", null, contentValues2, 5) == -1) {
                        zzau zzauVarZzjg = zzgt().zzjg();
                        zzauVarZzjg.zze("Failed to insert column (got -1). appId", zzas.zzbw(str), str2);
                        writableDatabase.endTransaction();
                        r2 = zzauVarZzjg;
                    } else {
                        r2 = 0;
                        try {
                            contentValues = new ContentValues();
                            contentValues.put("app_id", str);
                            contentValues.put(str2, Long.valueOf((long) (1 + r2)));
                            if (writableDatabase.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
                                zzgt().zzjg().zze("Failed to update column (got 0). appId", zzas.zzbw(str), str2);
                                writableDatabase.endTransaction();
                                r2 = r2;
                            } else {
                                writableDatabase.setTransactionSuccessful();
                                writableDatabase.endTransaction();
                                r1 = r2;
                                r2 = r2;
                            }
                        } catch (SQLiteException e) {
                            r0 = r2;
                            sQLiteException = e;
                            zzau zzauVarZzjg2 = zzgt().zzjg();
                            zzauVarZzjg2.zzd("Error inserting column. appId", zzas.zzbw(str), str2, sQLiteException);
                            writableDatabase.endTransaction();
                            r1 = r0;
                            r2 = zzauVarZzjg2;
                        }
                    }
                } else {
                    contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put(str2, Long.valueOf((long) (1 + r2)));
                    if (writableDatabase.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
                        zzgt().zzjg().zze("Failed to update column (got 0). appId", zzas.zzbw(str), str2);
                        writableDatabase.endTransaction();
                        r2 = r2;
                    } else {
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        r1 = r2;
                        r2 = r2;
                    }
                }
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLiteException e2) {
            r0 = 0;
            sQLiteException = e2;
            zzau zzauVarZzjg3 = zzgt().zzjg();
            zzauVarZzjg3.zzd("Error inserting column. appId", zzas.zzbw(str), str2, sQLiteException);
            writableDatabase.endTransaction();
            r1 = r0;
            r2 = zzauVarZzjg3;
        }
        return r1;
    }
}
