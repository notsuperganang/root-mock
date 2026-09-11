package com.android.volley;

import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class CacheDispatcher extends Thread {
    private static final boolean DEBUG = VolleyLog.DEBUG;
    private final Cache mCache;
    private final BlockingQueue<Request<?>> mCacheQueue;
    private final ResponseDelivery mDelivery;
    private final BlockingQueue<Request<?>> mNetworkQueue;
    private volatile boolean mQuit = false;
    private final WaitingRequestManager mWaitingRequestManager = new WaitingRequestManager(this);

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.mCacheQueue = blockingQueue;
        this.mNetworkQueue = blockingQueue2;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (DEBUG) {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.mCache.initialize();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException e) {
                if (this.mQuit) {
                    return;
                }
            }
        }
    }

    private void processRequest() throws InterruptedException {
        Request<?> requestTake = this.mCacheQueue.take();
        requestTake.addMarker("cache-queue-take");
        if (requestTake.isCanceled()) {
            requestTake.finish("cache-discard-canceled");
            return;
        }
        Cache.Entry entry = this.mCache.get(requestTake.getCacheKey());
        if (entry == null) {
            requestTake.addMarker("cache-miss");
            if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(requestTake)) {
                this.mNetworkQueue.put(requestTake);
                return;
            }
            return;
        }
        if (entry.isExpired()) {
            requestTake.addMarker("cache-hit-expired");
            requestTake.setCacheEntry(entry);
            if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(requestTake)) {
                this.mNetworkQueue.put(requestTake);
                return;
            }
            return;
        }
        requestTake.addMarker("cache-hit");
        Response<?> networkResponse = requestTake.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
        requestTake.addMarker("cache-hit-parsed");
        if (!entry.refreshNeeded()) {
            this.mDelivery.postResponse(requestTake, networkResponse);
            return;
        }
        requestTake.addMarker("cache-hit-refresh-needed");
        requestTake.setCacheEntry(entry);
        networkResponse.intermediate = true;
        if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(requestTake)) {
            this.mDelivery.postResponse(requestTake, networkResponse, new Runnable(this, requestTake) { // from class: com.android.volley.CacheDispatcher.1
                final CacheDispatcher this$0;
                final Request val$request;

                {
                    this.this$0 = this;
                    this.val$request = requestTake;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        this.this$0.mNetworkQueue.put(this.val$request);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        } else {
            this.mDelivery.postResponse(requestTake, networkResponse);
        }
    }

    private static class WaitingRequestManager implements Request.NetworkRequestCompleteListener {
        private final CacheDispatcher mCacheDispatcher;
        private final Map<String, List<Request<?>>> mWaitingRequests = new HashMap();

        WaitingRequestManager(CacheDispatcher cacheDispatcher) {
            this.mCacheDispatcher = cacheDispatcher;
        }

        @Override // com.android.volley.Request.NetworkRequestCompleteListener
        public void onResponseReceived(Request<?> request, Response<?> response) {
            List<Request<?>> listRemove;
            if (response.cacheEntry == null || response.cacheEntry.isExpired()) {
                onNoUsableResponseReceived(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                listRemove = this.mWaitingRequests.remove(cacheKey);
            }
            if (listRemove != null) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), cacheKey);
                }
                Iterator<Request<?>> it = listRemove.iterator();
                while (it.hasNext()) {
                    this.mCacheDispatcher.mDelivery.postResponse(it.next(), response);
                }
            }
        }

        @Override // com.android.volley.Request.NetworkRequestCompleteListener
        public void onNoUsableResponseReceived(Request<?> request) {
            synchronized (this) {
                String cacheKey = request.getCacheKey();
                List<Request<?>> listRemove = this.mWaitingRequests.remove(cacheKey);
                if (listRemove != null && !listRemove.isEmpty()) {
                    if (VolleyLog.DEBUG) {
                        VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), cacheKey);
                    }
                    Request<?> requestRemove = listRemove.remove(0);
                    this.mWaitingRequests.put(cacheKey, listRemove);
                    requestRemove.setNetworkRequestCompleteListener(this);
                    try {
                        this.mCacheDispatcher.mNetworkQueue.put(requestRemove);
                    } catch (InterruptedException e) {
                        VolleyLog.e("Couldn't add request to queue. %s", e.toString());
                        Thread.currentThread().interrupt();
                        this.mCacheDispatcher.quit();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean maybeAddToWaitingRequests(Request<?> request) {
            boolean z = false;
            synchronized (this) {
                String cacheKey = request.getCacheKey();
                if (this.mWaitingRequests.containsKey(cacheKey)) {
                    List<Request<?>> arrayList = this.mWaitingRequests.get(cacheKey);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    request.addMarker("waiting-for-response");
                    arrayList.add(request);
                    this.mWaitingRequests.put(cacheKey, arrayList);
                    if (VolleyLog.DEBUG) {
                        VolleyLog.d("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                        z = true;
                    } else {
                        z = true;
                    }
                } else {
                    this.mWaitingRequests.put(cacheKey, null);
                    request.setNetworkRequestCompleteListener(this);
                    if (VolleyLog.DEBUG) {
                        VolleyLog.d("new request, sending to network %s", cacheKey);
                    }
                }
            }
            return z;
        }
    }
}
