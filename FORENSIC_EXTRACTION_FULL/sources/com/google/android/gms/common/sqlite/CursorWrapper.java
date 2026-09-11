package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor zzez;

    @KeepForSdk
    public CursorWrapper(Cursor cursor) {
        super(cursor);
        Cursor wrappedCursor = cursor;
        for (int i = 0; i < 10 && (wrappedCursor instanceof android.database.CursorWrapper); i++) {
            wrappedCursor = ((android.database.CursorWrapper) wrappedCursor).getWrappedCursor();
        }
        if (!(wrappedCursor instanceof AbstractWindowedCursor)) {
            String strValueOf = String.valueOf(wrappedCursor.getClass().getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unknown type: ".concat(strValueOf) : new String("Unknown type: "));
        }
        this.zzez = (AbstractWindowedCursor) wrappedCursor;
    }

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public void fillWindow(int i, CursorWindow cursorWindow) {
        this.zzez.fillWindow(i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public CursorWindow getWindow() {
        return this.zzez.getWindow();
    }

    @Override // android.database.CursorWrapper
    public /* synthetic */ Cursor getWrappedCursor() {
        return this.zzez;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        return this.zzez.onMove(i, i2);
    }

    @KeepForSdk
    public void setWindow(CursorWindow cursorWindow) {
        this.zzez.setWindow(cursorWindow);
    }
}
