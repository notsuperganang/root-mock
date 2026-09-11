package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzsl extends zzsi<Boolean> {
    zzsl(zzso zzsoVar, String str, Boolean bool) {
        super(zzsoVar, str, bool, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzsi
    final /* synthetic */ Boolean zzs(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzru.zzbqq.matcher(str).matches()) {
                return true;
            }
            if (zzru.zzbqr.matcher(str).matches()) {
                return false;
            }
        }
        String strZztr = super.zztr();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", new StringBuilder(String.valueOf(strZztr).length() + 28 + String.valueOf(strValueOf).length()).append("Invalid boolean value for ").append(strZztr).append(": ").append(strValueOf).toString());
        return null;
    }
}
