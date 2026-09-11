package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzsk extends zzsi<Integer> {
    zzsk(zzso zzsoVar, String str, Integer num) {
        super(zzsoVar, str, num, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzsi
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final Integer zzs(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Long) {
            return Integer.valueOf(((Long) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException e) {
            }
        }
        String strZztr = super.zztr();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", new StringBuilder(String.valueOf(strZztr).length() + 24 + String.valueOf(strValueOf).length()).append("Invalid int value for ").append(strZztr).append(": ").append(strValueOf).toString());
        return null;
    }
}
