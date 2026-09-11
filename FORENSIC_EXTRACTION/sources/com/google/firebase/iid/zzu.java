package com.google.firebase.iid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzu implements Continuation<Bundle, String> {
    private final /* synthetic */ zzr zzbr;

    zzu(zzr zzrVar) {
        this.zzbr = zzrVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ String then(@NonNull Task<Bundle> task) throws Exception {
        Bundle result = task.getResult(IOException.class);
        zzr zzrVar = this.zzbr;
        return zzr.zza(result);
    }
}
