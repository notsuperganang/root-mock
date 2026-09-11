package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzfh;
import com.google.android.gms.internal.places.zzfi;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfi<MessageType extends zzfh<MessageType, BuilderType>, BuilderType extends zzfi<MessageType, BuilderType>> implements zzii {
    @Override // 
    /* JADX INFO: renamed from: zzaz, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    protected abstract BuilderType zzb(MessageType messagetype);

    @Override // com.google.android.gms.internal.places.zzii
    public final /* synthetic */ zzii zzb(zzih zzihVar) {
        if (zzds().getClass().isInstance(zzihVar)) {
            return zzb((zzfh) zzihVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
