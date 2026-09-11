package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class zzbf {
    private boolean value;
    private final boolean zzanu;
    private boolean zzanv;
    private final /* synthetic */ zzbd zzanw;
    private final String zzoj;

    public zzbf(zzbd zzbdVar, String str, boolean z) {
        this.zzanw = zzbdVar;
        Preconditions.checkNotEmpty(str);
        this.zzoj = str;
        this.zzanu = z;
    }

    @WorkerThread
    public final boolean get() {
        if (!this.zzanv) {
            this.zzanv = true;
            this.value = this.zzanw.zzju().getBoolean(this.zzoj, this.zzanu);
        }
        return this.value;
    }

    @WorkerThread
    public final void set(boolean z) {
        SharedPreferences.Editor editorEdit = this.zzanw.zzju().edit();
        editorEdit.putBoolean(this.zzoj, z);
        editorEdit.apply();
        this.value = z;
    }
}
