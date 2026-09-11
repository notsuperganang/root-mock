package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazy;
import com.google.android.gms.internal.ads.zzazz;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzazy<MessageType extends zzazy<MessageType, BuilderType>, BuilderType extends zzazz<MessageType, BuilderType>> implements zzbcu {
    private static boolean zzdpg = false;
    protected int zzdpf = 0;

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzacw()];
            zzbav zzbavVarZzq = zzbav.zzq(bArr);
            zzb(zzbavVarZzq);
            zzbavVarZzq.zzacl();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length()).append("Serializing ").append(name).append(" to a ").append("byte array").append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final zzbah zzaav() {
        try {
            zzbam zzbamVarZzbo = zzbah.zzbo(zzacw());
            zzb(zzbamVarZzbo.zzabj());
            return zzbamVarZzbo.zzabi();
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ").append("ByteString").append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    int zzaaw() {
        throw new UnsupportedOperationException();
    }

    void zzbj(int i) {
        throw new UnsupportedOperationException();
    }
}
