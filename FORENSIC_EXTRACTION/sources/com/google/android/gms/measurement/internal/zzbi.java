package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class zzbi {
    private String value;
    private boolean zzanv;
    private final /* synthetic */ zzbd zzanw;
    private final String zzaob;
    private final String zzoj;

    public zzbi(zzbd zzbdVar, String str, String str2) {
        this.zzanw = zzbdVar;
        Preconditions.checkNotEmpty(str);
        this.zzoj = str;
        this.zzaob = null;
    }

    @WorkerThread
    public final void zzcd(String str) {
        if (zzfx.zzv(str, this.value)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.zzanw.zzju().edit();
        editorEdit.putString(this.zzoj, str);
        editorEdit.apply();
        this.value = str;
    }

    @WorkerThread
    public final String zzkd() {
        if (!this.zzanv) {
            this.zzanv = true;
            this.value = this.zzanw.zzju().getString(this.zzoj, null);
        }
        return this.value;
    }
}
