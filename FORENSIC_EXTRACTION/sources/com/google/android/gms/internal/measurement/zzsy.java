package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzsx;
import com.google.android.gms.internal.measurement.zzsy;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzsy<MessageType extends zzsx<MessageType, BuilderType>, BuilderType extends zzsy<MessageType, BuilderType>> implements zzvw {
    protected abstract BuilderType zza(MessageType messagetype);

    @Override // com.google.android.gms.internal.measurement.zzvw
    public final /* synthetic */ zzvw zza(zzvv zzvvVar) {
        if (zzwj().getClass().isInstance(zzvvVar)) {
            return zza((zzsx) zzvvVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // 
    /* JADX INFO: renamed from: zzty, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();
}
