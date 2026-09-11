package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.ClientError;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static final int DEFAULT_POOL_SIZE = 4096;
    private static final int SLOW_REQUEST_THRESHOLD_MS = 3000;
    private final BaseHttpStack mBaseHttpStack;

    @Deprecated
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    @Deprecated
    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(4096));
    }

    @Deprecated
    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mBaseHttpStack = new AdaptedHttpStack(httpStack);
        this.mPool = byteArrayPool;
    }

    public BasicNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    public BasicNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.mBaseHttpStack = baseHttpStack;
        this.mHttpStack = baseHttpStack;
        this.mPool = byteArrayPool;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:74:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00e2 A[SYNTHETIC] */
    @Override // com.android.volley.Network
    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        byte[] bArr;
        int statusCode;
        NetworkResponse networkResponse;
        byte[] bArrInputStreamToBytes;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            List<Header> listEmptyList = Collections.emptyList();
            try {
                try {
                    HttpResponse httpResponseExecuteRequest = this.mBaseHttpStack.executeRequest(request, getCacheHeaders(request.getCacheEntry()));
                    try {
                        int statusCode2 = httpResponseExecuteRequest.getStatusCode();
                        listEmptyList = httpResponseExecuteRequest.getHeaders();
                        if (statusCode2 == 304) {
                            Cache.Entry cacheEntry = request.getCacheEntry();
                            if (cacheEntry == null) {
                                return new NetworkResponse(304, (byte[]) null, true, SystemClock.elapsedRealtime() - jElapsedRealtime, listEmptyList);
                            }
                            return new NetworkResponse(304, cacheEntry.data, true, SystemClock.elapsedRealtime() - jElapsedRealtime, combineHeaders(listEmptyList, cacheEntry));
                        }
                        InputStream content = httpResponseExecuteRequest.getContent();
                        if (content != null) {
                            bArrInputStreamToBytes = inputStreamToBytes(content, httpResponseExecuteRequest.getContentLength());
                        } else {
                            bArrInputStreamToBytes = new byte[0];
                        }
                        try {
                            logSlowRequests(SystemClock.elapsedRealtime() - jElapsedRealtime, request, bArrInputStreamToBytes, statusCode2);
                            if (statusCode2 < 200 || statusCode2 > 299) {
                                throw new IOException();
                            }
                            return new NetworkResponse(statusCode2, bArrInputStreamToBytes, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listEmptyList);
                        } catch (MalformedURLException e) {
                            e = e;
                            throw new RuntimeException("Bad URL " + request.getUrl(), e);
                        } catch (SocketTimeoutException e2) {
                            attemptRetryOnException("socket", request, new TimeoutError());
                        } catch (IOException e3) {
                            e = e3;
                            bArr = bArrInputStreamToBytes;
                            if (httpResponseExecuteRequest != null) {
                                statusCode = httpResponseExecuteRequest.getStatusCode();
                                VolleyLog.e("Unexpected response code %d for %s", Integer.valueOf(statusCode), request.getUrl());
                                if (bArr != null) {
                                    networkResponse = new NetworkResponse(statusCode, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listEmptyList);
                                    if (statusCode != 401) {
                                    }
                                    attemptRetryOnException("auth", request, new AuthFailureError(networkResponse));
                                } else {
                                    attemptRetryOnException("network", request, new NetworkError());
                                }
                            } else {
                                throw new NoConnectionError(e);
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                        httpResponse = httpResponseExecuteRequest;
                        bArr = null;
                        httpResponseExecuteRequest = httpResponse;
                        if (httpResponseExecuteRequest != null) {
                            statusCode = httpResponseExecuteRequest.getStatusCode();
                            VolleyLog.e("Unexpected response code %d for %s", Integer.valueOf(statusCode), request.getUrl());
                            if (bArr != null) {
                                networkResponse = new NetworkResponse(statusCode, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listEmptyList);
                                if (statusCode != 401 || statusCode == 403) {
                                    attemptRetryOnException("auth", request, new AuthFailureError(networkResponse));
                                } else {
                                    if (statusCode >= 400 && statusCode <= 499) {
                                        throw new ClientError(networkResponse);
                                    }
                                    if (statusCode >= 500 && statusCode <= 599) {
                                        if (request.shouldRetryServerErrors()) {
                                            attemptRetryOnException("server", request, new ServerError(networkResponse));
                                        } else {
                                            throw new ServerError(networkResponse);
                                        }
                                    } else {
                                        throw new ServerError(networkResponse);
                                    }
                                }
                            } else {
                                attemptRetryOnException("network", request, new NetworkError());
                            }
                        } else {
                            throw new NoConnectionError(e);
                        }
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (MalformedURLException e6) {
                e = e6;
            } catch (SocketTimeoutException e7) {
            }
        }
    }

    private void logSlowRequests(long j, Request<?> request, byte[] bArr, int i) {
        if (DEBUG || j > 3000) {
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", request, Long.valueOf(j), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(i), Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount()));
        }
    }

    private static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private Map<String, String> getCacheHeaders(Cache.Entry entry) {
        if (entry == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        if (entry.etag != null) {
            map.put("If-None-Match", entry.etag);
        }
        if (entry.lastModified > 0) {
            map.put("If-Modified-Since", HttpHeaderParser.formatEpochAsRfc1123(entry.lastModified));
            return map;
        }
        return map;
    }

    protected void logError(String str, String str2, long j) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    private byte[] inputStreamToBytes(InputStream inputStream, int i) throws ServerError, IOException {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, i);
        try {
            if (inputStream == null) {
                throw new ServerError();
            }
            byte[] buf = this.mPool.getBuf(1024);
            while (true) {
                int i2 = inputStream.read(buf);
                if (i2 == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(buf, 0, i2);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.mPool.returnBuf(buf);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.mPool.returnBuf(null);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    @Deprecated
    protected static Map<String, String> convertHeaders(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private static List<Header> combineHeaders(List<Header> list, Cache.Entry entry) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<Header> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().getName());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        if (entry.allResponseHeaders != null) {
            if (!entry.allResponseHeaders.isEmpty()) {
                for (Header header : entry.allResponseHeaders) {
                    if (!treeSet.contains(header.getName())) {
                        arrayList.add(header);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry2 : entry.responseHeaders.entrySet()) {
                if (!treeSet.contains(entry2.getKey())) {
                    arrayList.add(new Header(entry2.getKey(), entry2.getValue()));
                }
            }
        }
        return arrayList;
    }
}
