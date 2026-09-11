package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class zzru {
    private static HashMap<String, String> zzbqt;
    private static Object zzbqy;
    private static boolean zzbqz;
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbqp = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbqq = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbqr = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzbqs = new AtomicBoolean();
    private static final HashMap<String, Boolean> zzbqu = new HashMap<>();
    private static final HashMap<String, Integer> zzbqv = new HashMap<>();
    private static final HashMap<String, Long> zzbqw = new HashMap<>();
    private static final HashMap<String, Float> zzbqx = new HashMap<>();
    private static String[] zzbra = new String[0];

    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    public static String zza(ContentResolver contentResolver, String str, String str2) {
        String str3 = null;
        synchronized (zzru.class) {
            try {
                zza(contentResolver);
                Object obj = zzbqy;
                if (zzbqt.containsKey(str)) {
                    String str4 = zzbqt.get(str);
                    str3 = str4 != null ? str4 : null;
                } else {
                    for (String str5 : zzbra) {
                        if (str.startsWith(str5)) {
                            if (!zzbqz || zzbqt.isEmpty()) {
                                zzbqt.putAll(zza(contentResolver, zzbra));
                                zzbqz = true;
                                if (zzbqt.containsKey(str)) {
                                    String str6 = zzbqt.get(str);
                                    str3 = str6 != null ? str6 : null;
                                }
                            }
                        }
                    }
                    Cursor cursorQuery = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                String string = cursorQuery.getString(1);
                                if (string != null && string.equals(null)) {
                                    string = null;
                                }
                                zza(obj, str, string);
                                str3 = string != null ? string : null;
                            } else {
                                zza(obj, str, (String) null);
                            }
                        } finally {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    } else if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str3;
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor cursorQuery = contentResolver.query(zzbqp, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            cursorQuery.close();
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzbqt == null) {
            zzbqs.set(false);
            zzbqt = new HashMap<>();
            zzbqy = new Object();
            zzbqz = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzrv(null));
            return;
        }
        if (zzbqs.getAndSet(false)) {
            zzbqt.clear();
            zzbqu.clear();
            zzbqv.clear();
            zzbqw.clear();
            zzbqx.clear();
            zzbqy = new Object();
            zzbqz = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzru.class) {
            try {
                if (obj == zzbqy) {
                    zzbqt.put(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
