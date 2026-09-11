package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzao extends zzf {
    private final zzap zzalo;
    private boolean zzalp;

    zzao(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzalo = new zzap(this, getContext(), "google_app_measurement_local.db");
    }

    @WorkerThread
    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (this.zzalp) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzalo.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzalp = true;
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0146  */
    @WorkerThread
    private final boolean zza(int i, byte[] bArr) throws Throwable {
        long j;
        zzgg();
        zzaf();
        if (this.zzalp) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppMeasurement.Param.TYPE, Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 5;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 5) {
                zzgt().zzjj().zzby("Failed to write entry to local database");
                return false;
            }
            SQLiteDatabase writableDatabase = null;
            Cursor cursorRawQuery = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    if (writableDatabase == null) {
                        this.zzalp = true;
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        return false;
                    }
                    try {
                        writableDatabase.beginTransaction();
                        cursorRawQuery = writableDatabase.rawQuery("select count(1) from messages", null);
                        if (cursorRawQuery != null) {
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    j = cursorRawQuery.getLong(0);
                                } else {
                                    j = 0;
                                }
                            } catch (SQLiteDatabaseLockedException e) {
                                SystemClock.sleep(i2);
                                i2 += 20;
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                }
                                i3 = i4 + 1;
                            } catch (SQLiteException e2) {
                                e = e2;
                                if (writableDatabase != null) {
                                    try {
                                        if (writableDatabase.inTransaction()) {
                                            writableDatabase.endTransaction();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                }
                                zzgt().zzjg().zzg("Error writing entry to local database", e);
                                this.zzalp = true;
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                }
                                i3 = i4 + 1;
                            }
                        } else {
                            j = 0;
                        }
                        if (j >= 100000) {
                            zzgt().zzjg().zzby("Data loss, local db full");
                            long j2 = (100000 - j) + 1;
                            long jDelete = writableDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                            if (jDelete != j2) {
                                zzgt().zzjg().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                            }
                        }
                        writableDatabase.insertOrThrow("messages", null, contentValues);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        return true;
                    } catch (SQLiteDatabaseLockedException e3) {
                        cursorRawQuery = null;
                    } catch (SQLiteException e4) {
                        e = e4;
                        cursorRawQuery = null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursorRawQuery = null;
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        throw th;
                    }
                } catch (SQLiteFullException e5) {
                    zzgt().zzjg().zzg("Error writing entry to local database", e5);
                    this.zzalp = true;
                    if (0 != 0) {
                        cursorRawQuery.close();
                    }
                    if (0 != 0) {
                        writableDatabase.close();
                    }
                }
            } catch (SQLiteDatabaseLockedException e6) {
                cursorRawQuery = null;
                writableDatabase = null;
            } catch (SQLiteException e7) {
                e = e7;
                cursorRawQuery = null;
                writableDatabase = null;
            } catch (Throwable th3) {
                th = th3;
                writableDatabase = null;
                cursorRawQuery = null;
            }
            i3 = i4 + 1;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final void resetAnalyticsData() {
        zzgg();
        zzaf();
        try {
            int iDelete = getWritableDatabase().delete("messages", null, null) + 0;
            if (iDelete > 0) {
                zzgt().zzjo().zzg("Reset local analytics data. records", Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zzg("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zza(zzag zzagVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzagVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zza(0, bArrMarshall);
        }
        zzgt().zzjj().zzby("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzfu zzfuVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzfuVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zza(1, bArrMarshall);
        }
        zzgt().zzjj().zzby("User property too long for local database. Sending directly to service");
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final boolean zzc(zzo zzoVar) {
        zzgr();
        byte[] bArrZza = zzfx.zza(zzoVar);
        if (bArrZza.length <= 131072) {
            return zza(2, bArrZza);
        }
        zzgt().zzjj().zzby("Conditional user property too long for local database. Sending directly to service");
        return false;
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

    /* JADX INFO: Removed unreachable split cross block B:152:0x000b */
    /* JADX WARN: Code duplicated, block: B:133:0x0214  */
    /* JADX WARN: Code duplicated, block: B:78:0x0136  */
    /* JADX WARN: Code duplicated, block: B:80:0x013b  */
    public final List<AbstractSafeParcelable> zzr(int i) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Throwable th;
        int i2;
        zzfu zzfuVarCreateFromParcel;
        zzo zzoVarCreateFromParcel;
        zzaf();
        zzgg();
        if (this.zzalp) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!getContext().getDatabasePath("google_app_measurement_local.db").exists()) {
            return arrayList;
        }
        int i3 = 5;
        int i4 = 0;
        while (i4 < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            SQLiteDatabase writableDatabase = null;
            try {
                writableDatabase = getWritableDatabase();
                try {
                    if (writableDatabase == null) {
                        this.zzalp = true;
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        return null;
                    }
                    writableDatabase.beginTransaction();
                    cursorQuery = writableDatabase.query("messages", new String[]{"rowid", AppMeasurement.Param.TYPE, "entry"}, null, null, null, null, "rowid asc", Integer.toString(100));
                    long j = -1;
                    while (cursorQuery.moveToNext()) {
                        try {
                            j = cursorQuery.getLong(0);
                            int i5 = cursorQuery.getInt(1);
                            byte[] blob = cursorQuery.getBlob(2);
                            if (i5 == 0) {
                                Parcel parcelObtain = Parcel.obtain();
                                try {
                                    try {
                                        parcelObtain.unmarshall(blob, 0, blob.length);
                                        parcelObtain.setDataPosition(0);
                                        zzag zzagVarCreateFromParcel = zzag.CREATOR.createFromParcel(parcelObtain);
                                        parcelObtain.recycle();
                                        if (zzagVarCreateFromParcel != null) {
                                            arrayList.add(zzagVarCreateFromParcel);
                                        }
                                    } catch (Throwable th2) {
                                        parcelObtain.recycle();
                                        throw th2;
                                    }
                                } catch (SafeParcelReader.ParseException e) {
                                    zzgt().zzjg().zzby("Failed to load event from local database");
                                    parcelObtain.recycle();
                                }
                            } else if (i5 == 1) {
                                Parcel parcelObtain2 = Parcel.obtain();
                                try {
                                    try {
                                        parcelObtain2.unmarshall(blob, 0, blob.length);
                                        parcelObtain2.setDataPosition(0);
                                        zzfuVarCreateFromParcel = zzfu.CREATOR.createFromParcel(parcelObtain2);
                                        parcelObtain2.recycle();
                                    } catch (Throwable th3) {
                                        parcelObtain2.recycle();
                                        throw th3;
                                    }
                                } catch (SafeParcelReader.ParseException e2) {
                                    zzgt().zzjg().zzby("Failed to load user property from local database");
                                    parcelObtain2.recycle();
                                    zzfuVarCreateFromParcel = null;
                                }
                                if (zzfuVarCreateFromParcel != null) {
                                    arrayList.add(zzfuVarCreateFromParcel);
                                }
                            } else if (i5 == 2) {
                                Parcel parcelObtain3 = Parcel.obtain();
                                try {
                                    try {
                                        parcelObtain3.unmarshall(blob, 0, blob.length);
                                        parcelObtain3.setDataPosition(0);
                                        zzoVarCreateFromParcel = zzo.CREATOR.createFromParcel(parcelObtain3);
                                        parcelObtain3.recycle();
                                    } catch (Throwable th4) {
                                        parcelObtain3.recycle();
                                        throw th4;
                                    }
                                } catch (SafeParcelReader.ParseException e3) {
                                    zzgt().zzjg().zzby("Failed to load user property from local database");
                                    parcelObtain3.recycle();
                                    zzoVarCreateFromParcel = null;
                                }
                                if (zzoVarCreateFromParcel != null) {
                                    arrayList.add(zzoVarCreateFromParcel);
                                }
                            } else {
                                zzgt().zzjg().zzby("Unknown record type in local database");
                            }
                        } catch (SQLiteDatabaseLockedException e4) {
                            cursor = cursorQuery;
                            sQLiteDatabase = writableDatabase;
                            try {
                                SystemClock.sleep(i3);
                                i2 = i3 + 20;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                i4++;
                                i3 = i2;
                            } catch (Throwable th5) {
                                th = th5;
                                cursorQuery = cursor;
                                th = th;
                                writableDatabase = sQLiteDatabase;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteFullException e5) {
                            e = e5;
                            try {
                                zzgt().zzjg().zzg("Error reading entries from local database", e);
                                this.zzalp = true;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                    i2 = i3;
                                } else {
                                    i2 = i3;
                                }
                                i4++;
                                i3 = i2;
                            } catch (Throwable th6) {
                                th = th6;
                                sQLiteDatabase = writableDatabase;
                                th = th;
                                writableDatabase = sQLiteDatabase;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e6) {
                            e = e6;
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    th = th;
                                    writableDatabase = sQLiteDatabase;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (writableDatabase != null) {
                                        writableDatabase.close();
                                    }
                                    throw th;
                                }
                            }
                            zzgt().zzjg().zzg("Error reading entries from local database", e);
                            this.zzalp = true;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                                i2 = i3;
                            } else {
                                i2 = i3;
                            }
                            i4++;
                            i3 = i2;
                        } catch (Throwable th8) {
                            th = th8;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                            throw th;
                        }
                    }
                    if (writableDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                        zzgt().zzjg().zzby("Fewer entries removed from local database than expected");
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    return arrayList;
                } catch (SQLiteDatabaseLockedException e7) {
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                } catch (SQLiteFullException e8) {
                    e = e8;
                    cursorQuery = null;
                } catch (SQLiteException e9) {
                    e = e9;
                    cursorQuery = null;
                    sQLiteDatabase = writableDatabase;
                } catch (Throwable th9) {
                    th = th9;
                    cursorQuery = null;
                }
            } catch (SQLiteDatabaseLockedException e10) {
                cursor = null;
                sQLiteDatabase = null;
            } catch (SQLiteFullException e11) {
                e = e11;
                cursorQuery = null;
            } catch (SQLiteException e12) {
                e = e12;
                cursorQuery = null;
            } catch (Throwable th10) {
                th = th10;
                cursorQuery = null;
                writableDatabase = null;
            }
        }
        zzgt().zzjj().zzby("Failed to read events from database in reasonable time");
        return null;
    }
}
