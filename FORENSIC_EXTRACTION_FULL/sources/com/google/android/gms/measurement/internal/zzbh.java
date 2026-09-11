package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public final class zzbh {
    private final long zzabv;
    private final /* synthetic */ zzbd zzanw;

    @VisibleForTesting
    private final String zzany;
    private final String zzanz;
    private final String zzaoa;

    private zzbh(zzbd zzbdVar, String str, long j) {
        this.zzanw = zzbdVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zzany = String.valueOf(str).concat(":start");
        this.zzanz = String.valueOf(str).concat(":count");
        this.zzaoa = String.valueOf(str).concat(":value");
        this.zzabv = j;
    }

    @WorkerThread
    private final void zzfl() {
        this.zzanw.zzaf();
        long jCurrentTimeMillis = this.zzanw.zzbx().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zzanw.zzju().edit();
        editorEdit.remove(this.zzanz);
        editorEdit.remove(this.zzaoa);
        editorEdit.putLong(this.zzany, jCurrentTimeMillis);
        editorEdit.apply();
    }

    @WorkerThread
    private final long zzfn() {
        return this.zzanw.zzju().getLong(this.zzany, 0L);
    }

    @WorkerThread
    public final void zzc(String str, long j) {
        this.zzanw.zzaf();
        if (zzfn() == 0) {
            zzfl();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zzanw.zzju().getLong(this.zzanz, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor editorEdit = this.zzanw.zzju().edit();
            editorEdit.putString(this.zzaoa, str);
            editorEdit.putLong(this.zzanz, 1L);
            editorEdit.apply();
            return;
        }
        boolean z = (this.zzanw.zzgr().zzmk().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / (j2 + 1);
        SharedPreferences.Editor editorEdit2 = this.zzanw.zzju().edit();
        if (z) {
            editorEdit2.putString(this.zzaoa, str);
        }
        editorEdit2.putLong(this.zzanz, j2 + 1);
        editorEdit2.apply();
    }

    @WorkerThread
    public final Pair<String, Long> zzfm() {
        long jAbs;
        this.zzanw.zzaf();
        this.zzanw.zzaf();
        long jZzfn = zzfn();
        if (jZzfn == 0) {
            zzfl();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jZzfn - this.zzanw.zzbx().currentTimeMillis());
        }
        if (jAbs < this.zzabv) {
            return null;
        }
        if (jAbs > (this.zzabv << 1)) {
            zzfl();
            return null;
        }
        String string = this.zzanw.zzju().getString(this.zzaoa, null);
        long j = this.zzanw.zzju().getLong(this.zzanz, 0L);
        zzfl();
        return (string == null || j <= 0) ? zzbd.zzana : new Pair<>(string, Long.valueOf(j));
    }
}
