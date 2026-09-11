package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class ProcessUtils {
    private static String zzhd = null;
    private static int zzhe = 0;

    private ProcessUtils() {
    }

    @KeepForSdk
    @Nullable
    public static String getMyProcessName() {
        if (zzhd == null) {
            if (zzhe == 0) {
                zzhe = Process.myPid();
            }
            zzhd = zzd(zzhe);
        }
        return zzhd;
    }

    @Nullable
    private static String zzd(int i) throws Throwable {
        BufferedReader bufferedReaderZzj;
        String strTrim = null;
        if (i > 0) {
            try {
                bufferedReaderZzj = zzj(new StringBuilder(25).append("/proc/").append(i).append("/cmdline").toString());
                try {
                    strTrim = bufferedReaderZzj.readLine().trim();
                    IOUtils.closeQuietly(bufferedReaderZzj);
                } catch (IOException e) {
                    IOUtils.closeQuietly(bufferedReaderZzj);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(bufferedReaderZzj);
                    throw th;
                }
            } catch (IOException e2) {
                bufferedReaderZzj = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReaderZzj = null;
            }
        }
        return strTrim;
    }

    private static BufferedReader zzj(String str) throws IOException {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
