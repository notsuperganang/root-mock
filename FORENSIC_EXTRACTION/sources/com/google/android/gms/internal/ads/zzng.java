package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzng {
    private final Collection<zzna<?>> zzats = new ArrayList();
    private final Collection<zzna<String>> zzatt = new ArrayList();
    private final Collection<zzna<String>> zzatu = new ArrayList();

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzna<?> zznaVar : this.zzats) {
            if (zznaVar.getSource() == 1) {
                zznaVar.zza(editor, zznaVar.zzb(jSONObject));
            }
        }
    }

    public final void zza(zzna zznaVar) {
        this.zzats.add(zznaVar);
    }

    public final void zzb(zzna<String> zznaVar) {
        this.zzatt.add(zznaVar);
    }

    public final void zzc(zzna<String> zznaVar) {
        this.zzatu.add(zznaVar);
    }

    public final List<String> zzjb() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzna<String>> it = this.zzatt.iterator();
        while (it.hasNext()) {
            String str = (String) zzkb.zzik().zzd(it.next());
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> zzjc() {
        List<String> listZzjb = zzjb();
        Iterator<zzna<String>> it = this.zzatu.iterator();
        while (it.hasNext()) {
            String str = (String) zzkb.zzik().zzd(it.next());
            if (str != null) {
                listZzjb.add(str);
            }
        }
        return listZzjb;
    }
}
