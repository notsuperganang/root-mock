package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class ImageLoader {
    private final ImageCache mCache;
    private final RequestQueue mRequestQueue;
    private Runnable mRunnable;
    private int mBatchResponseDelayMs = 100;
    private final HashMap<String, BatchedImageRequest> mInFlightRequests = new HashMap<>();
    private final HashMap<String, BatchedImageRequest> mBatchedResponses = new HashMap<>();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    public ImageLoader(RequestQueue requestQueue, ImageCache imageCache) {
        this.mRequestQueue = requestQueue;
        this.mCache = imageCache;
    }

    public static ImageListener getImageListener(ImageView imageView, int i, int i2) {
        return new ImageListener(i2, imageView, i) { // from class: com.android.volley.toolbox.ImageLoader.1
            final int val$defaultImageResId;
            final int val$errorImageResId;
            final ImageView val$view;

            {
                this.val$errorImageResId = i2;
                this.val$view = imageView;
                this.val$defaultImageResId = i;
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                if (this.val$errorImageResId != 0) {
                    this.val$view.setImageResource(this.val$errorImageResId);
                }
            }

            @Override // com.android.volley.toolbox.ImageLoader.ImageListener
            public void onResponse(ImageContainer imageContainer, boolean z) {
                if (imageContainer.getBitmap() != null) {
                    this.val$view.setImageBitmap(imageContainer.getBitmap());
                } else if (this.val$defaultImageResId != 0) {
                    this.val$view.setImageResource(this.val$defaultImageResId);
                }
            }
        };
    }

    public boolean isCached(String str, int i, int i2) {
        return isCached(str, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public boolean isCached(String str, int i, int i2, ImageView.ScaleType scaleType) {
        throwIfNotOnMainThread();
        return this.mCache.getBitmap(getCacheKey(str, i, i2, scaleType)) != null;
    }

    public ImageContainer get(String str, ImageListener imageListener) {
        return get(str, imageListener, 0, 0);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2) {
        return get(str, imageListener, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2, ImageView.ScaleType scaleType) {
        throwIfNotOnMainThread();
        String cacheKey = getCacheKey(str, i, i2, scaleType);
        Bitmap bitmap = this.mCache.getBitmap(cacheKey);
        if (bitmap != null) {
            ImageContainer imageContainer = new ImageContainer(this, bitmap, str, null, null);
            imageListener.onResponse(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer(this, null, str, cacheKey, imageListener);
        imageListener.onResponse(imageContainer2, true);
        BatchedImageRequest batchedImageRequest = this.mInFlightRequests.get(cacheKey);
        if (batchedImageRequest != null) {
            batchedImageRequest.addContainer(imageContainer2);
            return imageContainer2;
        }
        Request<Bitmap> requestMakeImageRequest = makeImageRequest(str, i, i2, scaleType, cacheKey);
        this.mRequestQueue.add(requestMakeImageRequest);
        this.mInFlightRequests.put(cacheKey, new BatchedImageRequest(this, requestMakeImageRequest, imageContainer2));
        return imageContainer2;
    }

    protected Request<Bitmap> makeImageRequest(String str, int i, int i2, ImageView.ScaleType scaleType, String str2) {
        return new ImageRequest(str, new Response.Listener<Bitmap>(this, str2) { // from class: com.android.volley.toolbox.ImageLoader.2
            final ImageLoader this$0;
            final String val$cacheKey;

            {
                this.this$0 = this;
                this.val$cacheKey = str2;
            }

            @Override // com.android.volley.Response.Listener
            public void onResponse(Bitmap bitmap) {
                this.this$0.onGetImageSuccess(this.val$cacheKey, bitmap);
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565, new Response.ErrorListener(this, str2) { // from class: com.android.volley.toolbox.ImageLoader.3
            final ImageLoader this$0;
            final String val$cacheKey;

            {
                this.this$0 = this;
                this.val$cacheKey = str2;
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                this.this$0.onGetImageError(this.val$cacheKey, volleyError);
            }
        });
    }

    public void setBatchedResponseDelay(int i) {
        this.mBatchResponseDelayMs = i;
    }

    protected void onGetImageSuccess(String str, Bitmap bitmap) {
        this.mCache.putBitmap(str, bitmap);
        BatchedImageRequest batchedImageRequestRemove = this.mInFlightRequests.remove(str);
        if (batchedImageRequestRemove == null) {
            return;
        }
        batchedImageRequestRemove.mResponseBitmap = bitmap;
        batchResponse(str, batchedImageRequestRemove);
    }

    protected void onGetImageError(String str, VolleyError volleyError) {
        BatchedImageRequest batchedImageRequestRemove = this.mInFlightRequests.remove(str);
        if (batchedImageRequestRemove != null) {
            batchedImageRequestRemove.setError(volleyError);
            batchResponse(str, batchedImageRequestRemove);
        }
    }

    public class ImageContainer {
        private Bitmap mBitmap;
        private final String mCacheKey;
        private final ImageListener mListener;
        private final String mRequestUrl;
        final ImageLoader this$0;

        public ImageContainer(ImageLoader imageLoader, Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.this$0 = imageLoader;
            this.mBitmap = bitmap;
            this.mRequestUrl = str;
            this.mCacheKey = str2;
            this.mListener = imageListener;
        }

        public void cancelRequest() {
            if (this.mListener != null) {
                BatchedImageRequest batchedImageRequest = (BatchedImageRequest) this.this$0.mInFlightRequests.get(this.mCacheKey);
                if (batchedImageRequest == null) {
                    BatchedImageRequest batchedImageRequest2 = (BatchedImageRequest) this.this$0.mBatchedResponses.get(this.mCacheKey);
                    if (batchedImageRequest2 != null) {
                        batchedImageRequest2.removeContainerAndCancelIfNecessary(this);
                        if (batchedImageRequest2.mContainers.size() == 0) {
                            this.this$0.mBatchedResponses.remove(this.mCacheKey);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (batchedImageRequest.removeContainerAndCancelIfNecessary(this)) {
                    this.this$0.mInFlightRequests.remove(this.mCacheKey);
                }
            }
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public String getRequestUrl() {
            return this.mRequestUrl;
        }
    }

    private class BatchedImageRequest {
        private final LinkedList<ImageContainer> mContainers = new LinkedList<>();
        private VolleyError mError;
        private final Request<?> mRequest;
        private Bitmap mResponseBitmap;
        final ImageLoader this$0;

        public BatchedImageRequest(ImageLoader imageLoader, Request<?> request, ImageContainer imageContainer) {
            this.this$0 = imageLoader;
            this.mRequest = request;
            this.mContainers.add(imageContainer);
        }

        public void setError(VolleyError volleyError) {
            this.mError = volleyError;
        }

        public VolleyError getError() {
            return this.mError;
        }

        public void addContainer(ImageContainer imageContainer) {
            this.mContainers.add(imageContainer);
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
            this.mContainers.remove(imageContainer);
            if (this.mContainers.size() != 0) {
                return false;
            }
            this.mRequest.cancel();
            return true;
        }
    }

    private void batchResponse(String str, BatchedImageRequest batchedImageRequest) {
        this.mBatchedResponses.put(str, batchedImageRequest);
        if (this.mRunnable == null) {
            this.mRunnable = new Runnable(this) { // from class: com.android.volley.toolbox.ImageLoader.4
                final ImageLoader this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    for (BatchedImageRequest batchedImageRequest2 : this.this$0.mBatchedResponses.values()) {
                        for (ImageContainer imageContainer : batchedImageRequest2.mContainers) {
                            if (imageContainer.mListener != null) {
                                if (batchedImageRequest2.getError() == null) {
                                    imageContainer.mBitmap = batchedImageRequest2.mResponseBitmap;
                                    imageContainer.mListener.onResponse(imageContainer, false);
                                } else {
                                    imageContainer.mListener.onErrorResponse(batchedImageRequest2.getError());
                                }
                            }
                        }
                    }
                    this.this$0.mBatchedResponses.clear();
                    this.this$0.mRunnable = null;
                }
            };
            this.mHandler.postDelayed(this.mRunnable, this.mBatchResponseDelayMs);
        }
    }

    private void throwIfNotOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private static String getCacheKey(String str, int i, int i2, ImageView.ScaleType scaleType) {
        return new StringBuilder(str.length() + 12).append("#W").append(i).append("#H").append(i2).append("#S").append(scaleType.ordinal()).append(str).toString();
    }
}
