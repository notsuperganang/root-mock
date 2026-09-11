package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class zzbg {
    private long value;
    private boolean zzanv;
    private final /* synthetic */ zzbd zzanw;
    private final long zzanx;
    private final String zzoj;

    public zzbg(zzbd zzbdVar, String str, long j) {
        this.zzanw = zzbdVar;
        Preconditions.checkNotEmpty(str);
        this.zzoj = str;
        this.zzanx = j;
    }

    @WorkerThread
    public final long get() {
        if (!this.zzanv) {
            this.zzanv = true;
            this.value = this.zzanw.zzju().getLong(this.zzoj, this.zzanx);
        }
        return this.value;
    }

    @WorkerThread
    public final void set(long j) {
        SharedPreferences.Editor editorEdit = this.zzanw.zzju().edit();
        editorEdit.putLong(this.zzoj, j);
        editorEdit.apply();
        this.value = j;
    }
}
