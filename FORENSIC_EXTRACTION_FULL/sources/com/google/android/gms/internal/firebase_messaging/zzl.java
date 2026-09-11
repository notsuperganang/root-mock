package com.google.android.gms.internal.firebase_messaging;

/* JADX INFO: loaded from: classes.dex */
final class zzl extends zzi {
    private final zzj zzm = new zzj();

    zzl() {
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzi
    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.zzm.zza(th, true).add(th2);
    }
}
