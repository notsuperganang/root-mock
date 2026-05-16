package com.research.fakegps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/** SQLite helper for persisting and retrieving favorite locations. */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME    = "fakegps.db";
    private static final int    DB_VERSION = 1;

    private static final String TABLE      = "favorites";
    private static final String COL_ID     = "id";
    private static final String COL_NAME   = "name";
    private static final String COL_LAT    = "latitude";
    private static final String COL_LON    = "longitude";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE " + TABLE + " (" +
            COL_ID   + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT NOT NULL, " +
            COL_LAT  + " REAL NOT NULL, " +
            COL_LON  + " REAL NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    /** Inserts a new favorite. Returns the new row ID, or -1 on failure. */
    public long insert(String name, double latitude, double longitude) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_LAT, latitude);
        values.put(COL_LON, longitude);
        return getWritableDatabase().insert(TABLE, null, values);
    }

    /** Returns all saved favorites ordered by name. */
    public List<FavoriteLocation> getAll() {
        List<FavoriteLocation> list = new ArrayList<>();
        Cursor cursor = getReadableDatabase().query(
            TABLE,
            new String[]{COL_ID, COL_NAME, COL_LAT, COL_LON},
            null, null, null, null, COL_NAME + " ASC"
        );
        while (cursor.moveToNext()) {
            list.add(new FavoriteLocation(
                cursor.getLong(0),
                cursor.getString(1),
                cursor.getDouble(2),
                cursor.getDouble(3)
            ));
        }
        cursor.close();
        return list;
    }

    /** Deletes a favorite by ID. */
    public void delete(long id) {
        getWritableDatabase().delete(TABLE, COL_ID + "=?", new String[]{String.valueOf(id)});
    }
}
