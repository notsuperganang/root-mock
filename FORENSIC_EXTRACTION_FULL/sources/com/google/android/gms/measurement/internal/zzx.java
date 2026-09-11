package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzx {
    static void zza(zzas zzasVar, SQLiteDatabase sQLiteDatabase) {
        if (zzasVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzasVar.zzjj().zzby("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzasVar.zzjj().zzby("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzasVar.zzjj().zzby("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzasVar.zzjj().zzby("Failed to turn on database write permission for owner");
    }

    @WorkerThread
    static void zza(zzas zzasVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzasVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(zzasVar, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            if (zzasVar == null) {
                throw new IllegalArgumentException("Monitor must not be null");
            }
            Set<String> setZzb = zzb(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!setZzb.remove(str4)) {
                    throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length()).append("Table ").append(str).append(" is missing required column: ").append(str4).toString());
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!setZzb.remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (setZzb.isEmpty()) {
                return;
            }
            zzasVar.zzjj().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", setZzb));
        } catch (SQLiteException e) {
            zzasVar.zzjg().zzg("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0046  */
    @WorkerThread
    private static boolean zza(zzas zzasVar, SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        if (zzasVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        try {
            cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                try {
                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                    if (cursorQuery == null) {
                        return zMoveToFirst;
                    }
                    cursorQuery.close();
                    return zMoveToFirst;
                } catch (SQLiteException e) {
                    e = e;
                    zzasVar.zzjj().zze("Error querying for table", str, e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }
}
