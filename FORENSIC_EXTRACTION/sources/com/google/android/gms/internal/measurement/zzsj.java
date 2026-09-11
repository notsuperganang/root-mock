package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzsj extends zzsi<Long> {
    zzsj(zzso zzsoVar, String str, Long l) {
        super(zzsoVar, str, l, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzsi
    /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
    public final Long zzs(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException e) {
            }
        }
        String strZztr = super.zztr();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", new StringBuilder(String.valueOf(strZztr).length() + 25 + String.valueOf(strValueOf).length()).append("Invalid long value for ").append(strZztr).append(": ").append(strValueOf).toString());
        return null;
    }
}
