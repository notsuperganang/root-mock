package com.google.android.gms.internal.ads;

import android.support.v4.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
final class zzbbc {
    private final int number;
    private final Object object;

    zzbbc(Object obj, int i) {
        this.object = obj;
        this.number = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbbc)) {
            return false;
        }
        zzbbc zzbbcVar = (zzbbc) obj;
        return this.object == zzbbcVar.object && this.number == zzbbcVar.number;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
    }
}
