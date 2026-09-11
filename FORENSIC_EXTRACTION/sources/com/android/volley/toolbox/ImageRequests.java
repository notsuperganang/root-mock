package com.android.volley.toolbox;

import android.graphics.Bitmap;
import com.android.volley.Response;
import com.tiket.git.base;

/* JADX INFO: loaded from: classes.dex */
public class ImageRequests extends ImageRequest {
    public ImageRequests(String str, Response.Listener<Bitmap> listener, Response.ErrorListener errorListener) {
        super(str, listener, base.size(80), base.size(80), Bitmap.Config.RGB_565, errorListener);
    }
}
