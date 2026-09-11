package com.tiket.git;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.android.gms.location.LocationClient;

/* JADX INFO: loaded from: classes.dex */
public class Floating extends Service implements View.OnClickListener, View.OnTouchListener {
    private static boolean Custom = false;
    private static int a;
    private static int b;
    private static int c;
    private static int d;
    private LinearLayoutCompat Layout;
    private LocationClient mClient;
    private WindowManager mWindow;
    private WindowManager.LayoutParams params;

    @Override // android.app.Service
    public void onCreate() {
        int i;
        super.onCreate();
        this.params = new WindowManager.LayoutParams();
        this.params.format = -3;
        this.params.flags = 8;
        WindowManager.LayoutParams layoutParams = this.params;
        if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        } else {
            i = 2005;
        }
        layoutParams.type = i;
        this.params.gravity = 17;
        this.params.width = -2;
        this.params.height = -2;
        this.params.x = 0;
        this.params.y = 100;
        this.mWindow = (WindowManager) getSystemService("window");
        this.Layout = new LinearLayoutCompat(this);
        AppCompatImageView appCompatImageView = new AppCompatImageView(this);
        appCompatImageView.setBackgroundResource(R.drawable.ic_pause);
        this.Layout.addView(appCompatImageView);
        this.Layout.setOnClickListener(this);
        this.Layout.setOnTouchListener(this);
        this.mWindow.addView(this.Layout, this.params);
        this.mClient = new LocationClient(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.Layout) {
            stopSelf();
            MainActivity.stop();
            stopService(new Intent(this, (Class<?>) Start.class));
            this.mClient.requestLocationUpdates();
            Toast.makeText(view.getContext(), base.opsi[45], 0).show();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.Layout != null) {
            this.mWindow.removeView(this.Layout);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i = a - c;
        int i2 = b - d;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a = (int) motionEvent.getRawX();
            b = (int) motionEvent.getRawY();
            c = a;
            d = b;
        } else if (actionMasked != 1 && actionMasked == 2) {
            int rawX = ((int) motionEvent.getRawX()) - a;
            int rawY = ((int) motionEvent.getRawY()) - b;
            a = (int) motionEvent.getRawX();
            b = (int) motionEvent.getRawY();
            if ((Math.abs(i) >= 5 || Math.abs(i2) >= 5) && motionEvent.getPointerCount() == 1) {
                this.params.x += rawX;
                this.params.y += rawY;
                Custom = true;
                if (this.mWindow != null) {
                    this.mWindow.updateViewLayout(this.Layout, this.params);
                }
            } else {
                Custom = false;
            }
        }
        return Custom;
    }
}
