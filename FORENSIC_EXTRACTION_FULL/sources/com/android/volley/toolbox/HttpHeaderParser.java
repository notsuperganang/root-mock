package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class HttpHeaderParser {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String RFC1123_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public static Cache.Entry parseCacheHeaders(NetworkResponse networkResponse) {
        boolean z;
        boolean z2;
        long dateAsEpoch;
        long dateAsEpoch2;
        long j;
        long j2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse.headers;
        long dateAsEpoch3 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = map.get("Date");
        if (str != null) {
            dateAsEpoch3 = parseDateAsEpoch(str);
        }
        String str2 = map.get("Cache-Control");
        if (str2 == null) {
            z = false;
            z2 = false;
        } else {
            String[] strArrSplit = str2.split(",");
            int i = 0;
            z = false;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j3 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    try {
                        j4 = Long.parseLong(strTrim.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
                j4 = j4;
            }
            z2 = true;
        }
        String str3 = map.get("Expires");
        if (str3 == null) {
            dateAsEpoch = 0;
        } else {
            dateAsEpoch = parseDateAsEpoch(str3);
        }
        String str4 = map.get("Last-Modified");
        if (str4 == null) {
            dateAsEpoch2 = 0;
        } else {
            dateAsEpoch2 = parseDateAsEpoch(str4);
        }
        String str5 = map.get("ETag");
        if (z2) {
            long j5 = jCurrentTimeMillis + (1000 * j3);
            if (z) {
                j = j5;
                j2 = j5;
            } else {
                j = (1000 * j4) + j5;
                j2 = j5;
            }
        } else if (dateAsEpoch3 <= 0 || dateAsEpoch < dateAsEpoch3) {
            j = 0;
            j2 = 0;
        } else {
            long j6 = jCurrentTimeMillis + (dateAsEpoch - dateAsEpoch3);
            j = j6;
            j2 = j6;
        }
        Cache.Entry entry = new Cache.Entry();
        entry.data = networkResponse.data;
        entry.etag = str5;
        entry.softTtl = j2;
        entry.ttl = j;
        entry.serverDate = dateAsEpoch3;
        entry.lastModified = dateAsEpoch2;
        entry.responseHeaders = map;
        entry.allResponseHeaders = networkResponse.allHeaders;
        return entry;
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return newRfc1123Formatter().parse(str).getTime();
        } catch (ParseException e) {
            VolleyLog.e(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static String formatEpochAsRfc1123(long j) {
        return newRfc1123Formatter().format(new Date(j));
    }

    private static SimpleDateFormat newRfc1123Formatter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RFC1123_FORMAT, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String parseCharset(Map<String, String> map, String str) {
        String str2 = map.get(HEADER_CONTENT_TYPE);
        if (str2 != null) {
            String[] strArrSplit = str2.split(";");
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=");
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
            return str;
        }
        return str;
    }

    public static String parseCharset(Map<String, String> map) {
        return parseCharset(map, DEFAULT_CONTENT_CHARSET);
    }

    static Map<String, String> toHeaderMap(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header header : list) {
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }

    static List<Header> toAllHeaderList(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
