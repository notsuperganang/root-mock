package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzanf implements zzamx {

    @Nullable
    private final String zzcpq;

    public zzanf() {
        this(null);
    }

    public zzanf(@Nullable String str) {
        this.zzcpq = str;
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    @WorkerThread
    public final void zzcz(String str) {
        try {
            String strValueOf = String.valueOf(str);
            zzane.zzck(strValueOf.length() != 0 ? "Pinging URL: ".concat(strValueOf) : new String("Pinging URL: "));
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                zzkb.zzif();
                zzamu.zza(true, httpURLConnection, this.zzcpq);
                zzamy zzamyVar = new zzamy();
                zzamyVar.zza(httpURLConnection, (byte[]) null);
                int responseCode = httpURLConnection.getResponseCode();
                zzamyVar.zza(httpURLConnection, responseCode);
                if (responseCode < 200 || responseCode >= 300) {
                    zzane.zzdk(new StringBuilder(String.valueOf(str).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(str).toString());
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            String message = e.getMessage();
            zzane.zzdk(new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length()).append("Error while pinging URL: ").append(str).append(". ").append(message).toString());
        } catch (IndexOutOfBoundsException e2) {
            String message2 = e2.getMessage();
            zzane.zzdk(new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message2).length()).append("Error while parsing ping URL: ").append(str).append(". ").append(message2).toString());
        } catch (RuntimeException e3) {
            String message3 = e3.getMessage();
            zzane.zzdk(new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length()).append("Error while pinging URL: ").append(str).append(". ").append(message3).toString());
        }
    }
}
