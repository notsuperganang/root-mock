package com.google.android.gms.internal.measurement;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzsr {
    private static final zzss zzbsf;
    private static final int zzbsg;

    static final class zza extends zzss {
        zza() {
        }

        @Override // com.google.android.gms.internal.measurement.zzss
        public final void zza(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }
    }

    static {
        zzss zzaVar;
        Integer numZztu = null;
        try {
            numZztu = zztu();
            if (numZztu == null || numZztu.intValue() < 19) {
                zzaVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new zzsv() : new zza();
            } else {
                zzaVar = new zzsw();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zza.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 132).append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zzaVar = new zza();
        }
        zzbsf = zzaVar;
        zzbsg = numZztu == null ? 1 : numZztu.intValue();
    }

    public static void zza(Throwable th, PrintStream printStream) {
        zzbsf.zza(th, printStream);
    }

    private static Integer zztu() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
