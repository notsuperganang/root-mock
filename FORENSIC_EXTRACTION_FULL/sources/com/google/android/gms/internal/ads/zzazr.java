package com.google.android.gms.internal.ads;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public final class zzazr {
    private static final zzazs zzdov;
    private static final int zzdow;

    static final class zza extends zzazs {
        zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzazs
        public final void zza(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    static {
        zzazs zzaVar;
        Integer numZzaau = null;
        try {
            numZzaau = zzaau();
            if (numZzaau == null || numZzaau.intValue() < 19) {
                zzaVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new zzazv() : new zza();
            } else {
                zzaVar = new zzazw();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zza.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 132).append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zzaVar = new zza();
        }
        zzdov = zzaVar;
        zzdow = numZzaau == null ? 1 : numZzaau.intValue();
    }

    public static void zza(Throwable th, PrintWriter printWriter) {
        zzdov.zza(th, printWriter);
    }

    private static Integer zzaau() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
