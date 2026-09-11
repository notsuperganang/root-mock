package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public final class zzcz {
    boolean zzadg;
    String zzadi;
    String zzapk;
    String zzapl;
    Boolean zzaqe;
    zzan zzaqz;
    final Context zzri;

    @VisibleForTesting
    public zzcz(Context context, zzan zzanVar) {
        this.zzadg = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzri = applicationContext;
        if (zzanVar != null) {
            this.zzaqz = zzanVar;
            this.zzadi = zzanVar.zzadi;
            this.zzapk = zzanVar.origin;
            this.zzapl = zzanVar.zzadh;
            this.zzadg = zzanVar.zzadg;
            if (zzanVar.zzadj != null) {
                this.zzaqe = Boolean.valueOf(zzanVar.zzadj.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
