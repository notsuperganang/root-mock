package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class zzac {
    final String name;
    final long zzahv;
    final long zzahw;
    final long zzahx;
    final long zzahy;
    final Long zzahz;
    final Long zzaia;
    final Long zzaib;
    final Boolean zzaic;
    final String zztt;

    zzac(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(j2 >= 0);
        Preconditions.checkArgument(j4 >= 0);
        this.zztt = str;
        this.name = str2;
        this.zzahv = j;
        this.zzahw = j2;
        this.zzahx = j3;
        this.zzahy = j4;
        this.zzahz = l;
        this.zzaia = l2;
        this.zzaib = l3;
        this.zzaic = bool;
    }

    final zzac zza(long j, long j2) {
        return new zzac(this.zztt, this.name, this.zzahv, this.zzahw, this.zzahx, j, Long.valueOf(j2), this.zzaia, this.zzaib, this.zzaic);
    }

    final zzac zza(Long l, Long l2, Boolean bool) {
        return new zzac(this.zztt, this.name, this.zzahv, this.zzahw, this.zzahx, this.zzahy, this.zzahz, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    final zzac zzae(long j) {
        return new zzac(this.zztt, this.name, this.zzahv, this.zzahw, j, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic);
    }
}
