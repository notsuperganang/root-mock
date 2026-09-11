package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzwr extends zzwx {
    private final /* synthetic */ zzwo zzcca;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzwr(zzwo zzwoVar) {
        super(zzwoVar, null);
        this.zzcca = zzwoVar;
    }

    /* synthetic */ zzwr(zzwo zzwoVar, zzwp zzwpVar) {
        this(zzwoVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzwx, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzwq(this.zzcca, null);
    }
}
