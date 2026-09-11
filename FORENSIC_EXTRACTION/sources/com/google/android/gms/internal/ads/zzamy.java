package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.JsonWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzamy {
    private static Object sLock = new Object();

    @GuardedBy("sLock")
    private static boolean zzcuv = false;

    @GuardedBy("sLock")
    private static boolean zzcuw = false;
    private static Clock zzcux = DefaultClock.getInstance();
    private static final Set<String> zzcuy = new HashSet(Arrays.asList(new String[0]));
    private final List<String> zzcuz;

    public zzamy() {
        this(null);
    }

    public zzamy(@Nullable String str) {
        List<String> listAsList;
        if (isEnabled()) {
            String string = UUID.randomUUID().toString();
            if (str == null) {
                String strValueOf = String.valueOf(string);
                listAsList = Arrays.asList(strValueOf.length() != 0 ? "network_request_".concat(strValueOf) : new String("network_request_"));
            } else {
                String strValueOf2 = String.valueOf(str);
                String strConcat = strValueOf2.length() != 0 ? "ad_request_".concat(strValueOf2) : new String("ad_request_");
                String strValueOf3 = String.valueOf(string);
                listAsList = Arrays.asList(strConcat, strValueOf3.length() != 0 ? "network_request_".concat(strValueOf3) : new String("network_request_"));
            }
        } else {
            listAsList = new ArrayList<>();
        }
        this.zzcuz = listAsList;
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (sLock) {
            z = zzcuv && zzcuw;
        }
        return z;
    }

    static final /* synthetic */ void zza(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        jsonWriter.endObject();
    }

    private static void zza(JsonWriter jsonWriter, @Nullable Map<String, ?> map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!zzcuy.contains(key)) {
                if (!(entry.getValue() instanceof List)) {
                    if (!(entry.getValue() instanceof String)) {
                        zzane.e("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                        break;
                    }
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(key);
                    jsonWriter.name(FirebaseAnalytics.Param.VALUE).value((String) entry.getValue());
                    jsonWriter.endObject();
                } else {
                    for (String str : (List) entry.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(key);
                        jsonWriter.name(FirebaseAnalytics.Param.VALUE).value(str);
                        jsonWriter.endObject();
                    }
                }
            }
        }
        jsonWriter.endArray();
    }

    static final /* synthetic */ void zza(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    private final void zza(String str, zzand zzandVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name(AppMeasurement.Param.TIMESTAMP).value(zzcux.currentTimeMillis());
            jsonWriter.name(NotificationCompat.CATEGORY_EVENT).value(str);
            jsonWriter.name("components").beginArray();
            Iterator<String> it = this.zzcuz.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next());
            }
            jsonWriter.endArray();
            zzandVar.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzane.zzb("unable to log", e);
        }
        zzdi(stringWriter.toString());
    }

    static final /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String strEncode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(strEncode);
        } else {
            String strZzde = zzamu.zzde(strEncode);
            if (strZzde != null) {
                jsonWriter.name("bodydigest").value(strZzde);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    public static void zzaf(boolean z) {
        synchronized (sLock) {
            zzcuv = true;
            zzcuw = z;
        }
    }

    private final void zzb(final String str, final String str2, @Nullable final Map<String, ?> map, @Nullable final byte[] bArr) {
        zza("onNetworkRequest", new zzand(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.zzamz
            private final Map zzbpq;
            private final String zzcva;
            private final byte[] zzcvb;
            private final String zzzo;

            {
                this.zzcva = str;
                this.zzzo = str2;
                this.zzbpq = map;
                this.zzcvb = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzand
            public final void zza(JsonWriter jsonWriter) throws IOException {
                zzamy.zza(this.zzcva, this.zzzo, this.zzbpq, this.zzcvb, jsonWriter);
            }
        });
    }

    private final void zzb(@Nullable final Map<String, ?> map, final int i) {
        zza("onNetworkResponse", new zzand(i, map) { // from class: com.google.android.gms.internal.ads.zzana
            private final Map zzbjl;
            private final int zzcvc;

            {
                this.zzcvc = i;
                this.zzbjl = map;
            }

            @Override // com.google.android.gms.internal.ads.zzand
            public final void zza(JsonWriter jsonWriter) throws IOException {
                zzamy.zza(this.zzcvc, this.zzbjl, jsonWriter);
            }
        });
    }

    public static boolean zzbl(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((Boolean) zzkb.zzik().zzd(zznk.zzazm)).booleanValue()) {
            return false;
        }
        try {
            return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        } catch (Exception e) {
            zzane.zzc("Fail to determine debug setting.", e);
            return false;
        }
    }

    private final void zzdh(@Nullable final String str) {
        zza("onNetworkRequestError", new zzand(str) { // from class: com.google.android.gms.internal.ads.zzanc
            private final String zzcva;

            {
                this.zzcva = str;
            }

            @Override // com.google.android.gms.internal.ads.zzand
            public final void zza(JsonWriter jsonWriter) throws IOException {
                zzamy.zza(this.zzcva, jsonWriter);
            }
        });
    }

    private static void zzdi(String str) {
        synchronized (zzamy.class) {
            try {
                zzane.zzdj("GMA Debug BEGIN");
                for (int i = 0; i < str.length(); i += 4000) {
                    String strValueOf = String.valueOf(str.substring(i, Math.min(i + 4000, str.length())));
                    zzane.zzdj(strValueOf.length() != 0 ? "GMA Debug CONTENT ".concat(strValueOf) : new String("GMA Debug CONTENT "));
                }
                zzane.zzdj("GMA Debug FINISH");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zzsj() {
        synchronized (sLock) {
            zzcuv = false;
            zzcuw = false;
            zzane.zzdk("Ad debug logging enablement is out of date.");
        }
    }

    public static boolean zzsk() {
        boolean z;
        synchronized (sLock) {
            z = zzcuv;
        }
        return z;
    }

    public final void zza(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        String responseMessage = null;
        if (isEnabled()) {
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String strValueOf = String.valueOf(e.getMessage());
                    zzane.zzdk(strValueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(strValueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzdh(responseMessage);
            }
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        if (isEnabled()) {
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void zza(@Nullable Map<String, ?> map, int i) {
        if (isEnabled()) {
            zzb(map, i);
            if (i < 200 || i >= 300) {
                zzdh(null);
            }
        }
    }

    public final void zzdg(@Nullable String str) {
        if (isEnabled() && str != null) {
            zzf(str.getBytes());
        }
    }

    public final void zzf(final byte[] bArr) {
        zza("onNetworkResponseBody", new zzand(bArr) { // from class: com.google.android.gms.internal.ads.zzanb
            private final byte[] zzcvd;

            {
                this.zzcvd = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzand
            public final void zza(JsonWriter jsonWriter) throws IOException {
                zzamy.zza(this.zzcvd, jsonWriter);
            }
        });
    }
}
