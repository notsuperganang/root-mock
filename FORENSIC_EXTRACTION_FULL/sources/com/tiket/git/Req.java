package com.tiket.git;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Req implements com.android.volley.Response.Listener<JSONObject>, com.android.volley.Response.ErrorListener {
    private int Type;
    private int Typec;
    private int Types;
    private String Typex;
    private Response req;

    public interface Response {
        void Response(JSONObject jSONObject, int i, int i2, int i3, String str);
    }

    public Req(Context context, Response response, JSONObject jSONObject, int i, int i2, int i3, String str) {
        this.Type = i;
        this.Types = i2;
        this.Typec = i3;
        this.Typex = str;
        this.req = response;
        Volley.newRequestQueue(context).add(new JsonObjectRequest(jSONObject, this, this));
    }

    @Override // com.android.volley.Response.Listener
    public void onResponse(JSONObject jSONObject) {
        if (jSONObject != null && this.Type != 0) {
            this.req.Response(jSONObject, this.Type, this.Types, this.Typec, this.Typex);
        }
    }

    @Override // com.android.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        Toast.makeText(base.ctx, volleyError.getMessage(), 1).show();
    }
}
