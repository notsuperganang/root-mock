package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzfh;
import com.google.android.gms.internal.places.zzfi;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfh<MessageType extends zzfh<MessageType, BuilderType>, BuilderType extends zzfi<MessageType, BuilderType>> implements zzih {
    private static boolean zzni = false;
    protected int zznh = 0;

    @Override // com.google.android.gms.internal.places.zzih
    public final zzfr zzax() {
        try {
            zzfw zzfwVarZzag = zzfr.zzag(zzdg());
            zzc(zzfwVarZzag.zzci());
            return zzfwVarZzag.zzch();
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ").append("ByteString").append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    int zzay() {
        throw new UnsupportedOperationException();
    }

    void zzv(int i) {
        throw new UnsupportedOperationException();
    }
}
