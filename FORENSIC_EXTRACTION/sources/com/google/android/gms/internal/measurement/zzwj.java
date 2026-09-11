package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzwj implements zzvt {
    private final int flags;
    private final String info;
    private final Object[] zzcat;
    private final zzvv zzcaw;

    zzwj(zzvv zzvvVar, String str, Object[] objArr) {
        this.zzcaw = zzvvVar;
        this.info = str;
        this.zzcat = objArr;
        int i = 1;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.flags = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        while (true) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 55296) {
                this.flags = (cCharAt2 << i3) | i2;
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i++;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzvt
    public final int zzxm() {
        return (this.flags & 1) == 1 ? zzuo.zze.zzbyu : zzuo.zze.zzbyv;
    }

    @Override // com.google.android.gms.internal.measurement.zzvt
    public final boolean zzxn() {
        return (this.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.zzvt
    public final zzvv zzxo() {
        return this.zzcaw;
    }

    final String zzxv() {
        return this.info;
    }

    final Object[] zzxw() {
        return this.zzcat;
    }
}
