package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzsm extends zzsi<Double> {
    zzsm(zzso zzsoVar, String str, Double d) {
        super(zzsoVar, str, d, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzsi
    /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
    public final Double zzs(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException e) {
            }
        }
        String strZztr = super.zztr();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", new StringBuilder(String.valueOf(strZztr).length() + 27 + String.valueOf(strValueOf).length()).append("Invalid double value for ").append(strZztr).append(": ").append(strValueOf).toString());
        return null;
    }
}
