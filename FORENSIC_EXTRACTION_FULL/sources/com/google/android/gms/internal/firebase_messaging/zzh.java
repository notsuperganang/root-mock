package com.google.android.gms.internal.firebase_messaging;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    private static final zzi zzg;
    private static final int zzh;

    static final class zza extends zzi {
        zza() {
        }

        @Override // com.google.android.gms.internal.firebase_messaging.zzi
        public final void zza(Throwable th, Throwable th2) {
        }
    }

    static {
        zzi zzaVar;
        Integer numZzb = null;
        try {
            numZzb = zzb();
            if (numZzb == null || numZzb.intValue() < 19) {
                zzaVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new zzl() : new zza();
            } else {
                zzaVar = new zzm();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zza.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 133).append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zzaVar = new zza();
        }
        zzg = zzaVar;
        zzh = numZzb == null ? 1 : numZzb.intValue();
    }

    public static void zza(Throwable th, Throwable th2) {
        zzg.zza(th, th2);
    }

    private static Integer zzb() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
