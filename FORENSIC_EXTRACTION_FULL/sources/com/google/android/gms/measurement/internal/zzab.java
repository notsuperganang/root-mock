package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzab {
    final String name;
    private final String origin;
    final long timestamp;
    final long zzaht;
    final zzad zzahu;
    final String zztt;

    zzab(zzbw zzbwVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzad zzadVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zztt = str2;
        this.name = str3;
        this.origin = TextUtils.isEmpty(str) ? null : str;
        this.timestamp = j;
        this.zzaht = j2;
        if (this.zzaht != 0 && this.zzaht > this.timestamp) {
            zzbwVar.zzgt().zzjj().zzg("Event created with reverse previous/current timestamps. appId", zzas.zzbw(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzadVar = new zzad(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzbwVar.zzgt().zzjg().zzby("Param name can't be null");
                    it.remove();
                } else {
                    Object objZzh = zzbwVar.zzgr().zzh(next, bundle2.get(next));
                    if (objZzh == null) {
                        zzbwVar.zzgt().zzjj().zzg("Param value can't be null", zzbwVar.zzgq().zzbu(next));
                        it.remove();
                    } else {
                        zzbwVar.zzgr().zza(bundle2, next, objZzh);
                    }
                }
            }
            zzadVar = new zzad(bundle2);
        }
        this.zzahu = zzadVar;
    }

    private zzab(zzbw zzbwVar, String str, String str2, String str3, long j, long j2, zzad zzadVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzadVar);
        this.zztt = str2;
        this.name = str3;
        this.origin = TextUtils.isEmpty(str) ? null : str;
        this.timestamp = j;
        this.zzaht = j2;
        if (this.zzaht != 0 && this.zzaht > this.timestamp) {
            zzbwVar.zzgt().zzjj().zze("Event created with reverse previous/current timestamps. appId, name", zzas.zzbw(str2), zzas.zzbw(str3));
        }
        this.zzahu = zzadVar;
    }

    public final String toString() {
        String str = this.zztt;
        String str2 = this.name;
        String strValueOf = String.valueOf(this.zzahu);
        return new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(strValueOf).length()).append("Event{appId='").append(str).append("', name='").append(str2).append("', params=").append(strValueOf).append('}').toString();
    }

    final zzab zza(zzbw zzbwVar, long j) {
        return new zzab(zzbwVar, this.origin, this.zztt, this.name, this.timestamp, j, this.zzahu);
    }
}
