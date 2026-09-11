package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzxp extends IllegalArgumentException {
    zzxp(int i, int i2) {
        super(new StringBuilder(54).append("Unpaired surrogate at index ").append(i).append(" of ").append(i2).toString());
    }
}
