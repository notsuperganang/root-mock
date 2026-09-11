package com.android.volley.toolbox;

import android.R;
import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatImageView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.tiket.git.base;

/* JADX INFO: loaded from: classes.dex */
public class ImageLoaders implements Response.Listener<Bitmap>, Response.ErrorListener {
    private AppCompatImageView Img;

    public ImageLoaders(String str, AppCompatImageView appCompatImageView) {
        this.Img = appCompatImageView;
        Volley.newRequestQueue(base.ctx).add(new ImageRequests(str, this, this));
    }

    @Override // com.android.volley.Response.Listener
    public void onResponse(Bitmap bitmap) {
        if (bitmap != null) {
            this.Img.setImageBitmap(bitmap);
        }
    }

    @Override // com.android.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        this.Img.setImageResource(R.drawable.stat_notify_error);
    }
}
