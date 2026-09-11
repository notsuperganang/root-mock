package com.tiket.git;

import android.app.AppOpsManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import bin.mt.signature.KillerApplication;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.zza;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class base extends KillerApplication {
    public static Context ctx;
    public static String[] opsi = {"Gofood", "Grabfood", "Shopee", "Go-Transit", "Nama", "Alamat", "Tikor", "Opsi", "Goride", "Gocar", "Grabbike", "Grabcar", "Tracar", "Pickup", "phone", "Random Start", "Device", "http://dpr.link/tiket/", "Favorite", "History", "Random", "Please Wait...", "Type", "ID", "Search", "Keyword", "Search....", "Clear", ", Tersimpan di ", ", Terhapus dari ", "Marker Clear", "Mode GPS", "Mode Maps", "Floating", "Random Tikor", "Akurasi", "Speed", "Bearing", "Ketinggian", "GPS Device", "GPS Network", "Standar", "Traffic", "Manual", "ON", "OFF", "Grab", "Go-ride", "Go-car", "Notice!", "OKE", "Klo Error Japri Admin..!", "ADS Nya Jangan Di block Boss..!", "Setting", "Mode Food", "Mode Pickup", "Icon", "List", "Trafood", "Versi", "Register", "Expired", "Info", "Device ID", "Copy Device ID anda lalu kirim ke admin\nSetelah kirim Close TAB APK ini secara berkala.", "", "Tidak Ada Koneksi Internet", "Angkot", "Busway", "BUS", "MRT", "Kereta", "Lokasi sudah ada di "};

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        ctx = getApplicationContext();
    }

    public static Drawable setIcon(int i, int i2, String str) {
        return new BitmapDrawable(ctx.getResources(), icon(i, i2, str));
    }

    public static SharedPreferences get() {
        return ctx.getSharedPreferences(ctx.getApplicationInfo().loadLabel(ctx.getPackageManager()).toString(), 0);
    }

    public static String Tikor() {
        return get().getString(opsi[6], "");
    }

    public static String[] Latlng() {
        return get().getString(opsi[6], "").split(",");
    }

    public static void add(String str, String str2, String str3) {
        add(str3);
        if (tikor(str, str3) != null) {
            if (!str.equals(opsi[19])) {
                Toast.makeText(ctx, String.valueOf(opsi[72]) + str, 0).show();
            }
        } else {
            new DB(ctx, str).getWritableDatabase().execSQL("INSERT into " + str + "(title, tikor) VALUES(?,?);", new Object[]{str2, str3});
            if (!str.equals(opsi[19])) {
                Toast.makeText(ctx, str2 + opsi[28] + str, 0).show();
            }
        }
    }

    public static void add(String str) {
        get().edit().putString(opsi[6], str).apply();
    }

    public static void clear(String str) {
        new DB(ctx, str).getReadableDatabase().delete(str, null, null);
    }

    public static void delete(String str, String str2, String str3) {
        new DB(ctx, str).getReadableDatabase().delete(str, "tikor =?", new String[]{String.valueOf(str3)});
        Toast.makeText(ctx, str2 + opsi[29] + str, 0).show();
    }

    public static String tikor(String str, String str2) {
        Cursor cursorQuery = new DB(ctx, str).getReadableDatabase().query(str, null, "tikor=?", new String[]{str2}, null, null, null);
        if (cursorQuery.moveToNext()) {
            return cursorQuery.getString(2);
        }
        return null;
    }

    public static Bitmap icon(int i, int i2, String str) {
        Bitmap bitmapDecodeResource;
        try {
            if (i2 != 0) {
                bitmapDecodeResource = setIcon(i, R.color.colorPrimary, android.R.color.white);
            } else {
                bitmapDecodeResource = BitmapFactory.decodeResource(ctx.getResources(), i);
            }
            Bitmap bitmapCopy = bitmapDecodeResource.copy(bitmapDecodeResource.getConfig(), true);
            Canvas canvas = new Canvas(bitmapCopy);
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(size(8));
            canvas.drawText(str, canvas.getWidth() / 2, bitmapCopy.getHeight() - i2, paint);
            return bitmapCopy;
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap setIcon(int i, int i2, int i3) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(ctx.getResources(), i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), bitmapDecodeResource.getConfig());
        Paint paint = new Paint();
        paint.setColor(ctx.getResources().getColor(i2));
        Paint paint2 = new Paint();
        paint2.setColorFilter(new LightingColorFilter(ctx.getResources().getColor(i3), 1));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawCircle(bitmapDecodeResource.getWidth() / 2, bitmapDecodeResource.getHeight() / 2, ((bitmapDecodeResource.getWidth() / 2) + (bitmapDecodeResource.getHeight() / 2)) / 2, paint);
        canvas.drawBitmap(bitmapDecodeResource, 0.0f, 0.0f, paint2);
        return bitmapCreateBitmap;
    }

    public static AppCompatTextView title(String str) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(ctx);
        appCompatTextView.setText(str);
        appCompatTextView.setGravity(17);
        appCompatTextView.setPadding(size(3), size(3), size(3), size(3));
        appCompatTextView.setTextSize(20.0f);
        appCompatTextView.setTypeface(appCompatTextView.getTypeface(), 3);
        appCompatTextView.setBackground(setBackground(R.color.colorPrimaryDark));
        appCompatTextView.setTextColor(-1);
        return appCompatTextView;
    }

    public static SpannableString message(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, spannableString.length(), 0);
        spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, spannableString.length(), 33);
        return spannableString;
    }

    public static Button button(Button button) {
        if (button == null) {
            return null;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, size(30));
        button.setBackgroundDrawable(setBackground(R.color.colorPrimaryDark));
        layoutParams.gravity = 17;
        button.setTextColor(-1);
        button.setTypeface(button.getTypeface(), 1);
        button.setTextSize(13.0f);
        button.setPadding(size(3), size(3), size(3), size(3));
        button.setLayoutParams(layoutParams);
        return button;
    }

    public static GradientDrawable setBackground(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ctx.getResources().getColor(i));
        gradientDrawable.setCornerRadius(40.0f);
        return gradientDrawable;
    }

    public static PaintDrawable Color(int i) {
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.getPaint().setColor(ctx.getResources().getColor(i));
        paintDrawable.setCornerRadius(20.0f);
        paintDrawable.getPaint().setStyle(Paint.Style.STROKE);
        paintDrawable.getPaint().setStrokeWidth(5.0f);
        return paintDrawable;
    }

    public static Drawable Progress() {
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setCornerRadius(20.0f);
        paintDrawable.getPaint().setStyle(Paint.Style.FILL);
        paintDrawable.getPaint().setColor(ctx.getResources().getColor(R.color.colorPrimaryDark));
        paintDrawable.getPaint().setStyle(Paint.Style.STROKE);
        paintDrawable.getPaint().setStrokeWidth(4.0f);
        paintDrawable.getPaint().setColor(ctx.getResources().getColor(R.color.colorPrimaryDark));
        PaintDrawable paintDrawable2 = new PaintDrawable();
        paintDrawable2.setCornerRadius(20.0f);
        paintDrawable2.getPaint().setStyle(Paint.Style.FILL);
        paintDrawable2.getPaint().setColor(ctx.getResources().getColor(R.color.colorAccent));
        return new LayerDrawable(new Drawable[]{new ClipDrawable(paintDrawable2, 3, 1), paintDrawable});
    }

    public static Drawable logo() {
        return new BitmapDrawable(ctx.getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) ctx.getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap(), size(25), size(25), true));
    }

    public static Drawable Logo() {
        return new BitmapDrawable(ctx.getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) ctx.getResources().getDrawable(R.mipmap.ic_logo)).getBitmap(), size(80), size(80), true));
    }

    public static FrameLayout.LayoutParams opsi(int i) {
        return new FrameLayout.LayoutParams(-2, -2, i);
    }

    public static String title(LatLng latLng) {
        return title(latLng.latitude, latLng.longitude);
    }

    public static String title(double d, double d2) {
        return String.format(Locale.US, "%.7f,%.7f", Double.valueOf(d), Double.valueOf(d2));
    }

    public static int size(float f) {
        return (int) ((ctx.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int size(int i) {
        return (int) TypedValue.applyDimension(1, i, ctx.getResources().getDisplayMetrics());
    }

    public static LinearLayoutCompat.LayoutParams size(int i, int i2) {
        return new LinearLayoutCompat.LayoutParams(i, i2);
    }

    public static RelativeLayout.LayoutParams Size(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(i, -1);
        layoutParams.addRule(i2, -1);
        return layoutParams;
    }

    public static Map<String, String> getDriver(JSONObject jSONObject, ProgressDialog progressDialog) {
        HashMap map = new HashMap();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(ctx.getApplicationInfo().loadLabel(ctx.getPackageManager()).toString());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                map.put(jSONObject2.getString(opsi[4]), jSONObject2.getString(opsi[6]));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        return map;
    }

    public static ArrayList<HashMap<String, String>> getFeed(JSONObject jSONObject, ProgressDialog progressDialog) {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(ctx.getApplicationInfo().loadLabel(ctx.getPackageManager()).toString());
            for (int i = 0; i < jSONArray.length(); i++) {
                HashMap<String, String> map = new HashMap<>();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                map.put(opsi[4], jSONObject2.getString(opsi[4]));
                map.put(opsi[5], jSONObject2.getString(opsi[5]));
                map.put(opsi[6], jSONObject2.getString(opsi[6]));
                map.put(opsi[7], jSONObject2.getString(opsi[7]));
                arrayList.add(map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        return arrayList;
    }

    public static String getTikor(JSONObject jSONObject, ProgressDialog progressDialog) {
        StringBuilder sb = new StringBuilder();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(ctx.getApplicationInfo().loadLabel(ctx.getPackageManager()).toString());
            for (int i = 0; i < jSONArray.length(); i++) {
                sb.append(jSONArray.getJSONObject(i).getString(opsi[6]));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        return sb.toString();
    }

    public static Cursor Ran() {
        Cursor cursorRawQuery = new DB(ctx, opsi[20]).getReadableDatabase().rawQuery("select * from " + opsi[20] + " ORDER BY RANDOM()", null);
        if (cursorRawQuery.moveToFirst()) {
            return cursorRawQuery;
        }
        return null;
    }

    public static ArrayList<HashMap<String, String>> List(String str) {
        Cursor cursorRawQuery = new DB(ctx, str).getReadableDatabase().rawQuery("select * from " + str, null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (cursorRawQuery.moveToNext()) {
            HashMap<String, String> map = new HashMap<>();
            map.put(opsi[4], cursorRawQuery.getString(1));
            map.put(opsi[6], cursorRawQuery.getString(2));
            arrayList.add(map);
        }
        cursorRawQuery.close();
        return arrayList;
    }

    public static JSONObject opsi(int i, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (i == 1) {
                jSONObject.put(opsi[22], str);
                jSONObject.put(opsi[6], str2);
                jSONObject.put(opsi[16], zza.zzb());
            } else if (i == 2) {
                jSONObject.put(opsi[22], str);
                jSONObject.put(opsi[6], str2);
                jSONObject.put(opsi[23], str3);
                jSONObject.put(opsi[16], zza.zzb());
            } else if (i == 3) {
                jSONObject.put(opsi[24], str);
                jSONObject.put(opsi[6], str2);
                jSONObject.put(opsi[25], str3);
                jSONObject.put(opsi[16], zza.zzb());
            } else {
                if (i == 4) {
                    jSONObject.put(opsi[22], str);
                    jSONObject.put(opsi[59], str2);
                    jSONObject.put(opsi[16], zza.zzb());
                }
                return jSONObject;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean allow() {
        boolean z = false;
        AppOpsManager appOpsManager = (AppOpsManager) ctx.getSystemService("appops");
        try {
            if (Build.VERSION.SDK_INT < 23) {
                z = !Settings.Secure.getString(ctx.getContentResolver(), "mock_location").equals("0");
            } else if (appOpsManager.checkOp("android:mock_location", Process.myUid(), ctx.getPackageName()) == 0) {
                z = true;
            }
        } catch (Exception e) {
        }
        return z;
    }

    public static void alert(Context context, DialogInterface.OnClickListener onClickListener, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCustomTitle(title(opsi[49]));
        if (i == -3) {
            builder.setMessage(message(opsi[51]));
            builder.setNeutralButton(opsi[50], onClickListener);
        } else {
            get().edit().putBoolean("mock", false).apply();
            builder.setView(Info(context));
        }
        builder.setCancelable(false);
        AlertDialog alertDialogShow = builder.show();
        alertDialogShow.getWindow().setBackgroundDrawable(setBackground(R.color.colorPrimary));
        button(alertDialogShow.getButton(-3));
    }

    public static LinearLayoutCompat Info(Context context) {
        LinearLayoutCompat.LayoutParams size = size(-1, -2);
        LinearLayoutCompat.LayoutParams size2 = size(-1, size(40));
        size2.setMargins(size(20), size(10), size(20), size(20));
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        AppCompatEditText appCompatEditText = new AppCompatEditText(context);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
        appCompatTextView.setText(opsi[63]);
        appCompatEditText.setText(zza.zzb());
        appCompatTextView2.setText(opsi[64]);
        appCompatEditText.setGravity(17);
        appCompatTextView.setGravity(17);
        appCompatTextView2.setGravity(17);
        appCompatEditText.setTextColor(-3355444);
        appCompatTextView.setTextColor(-1);
        appCompatTextView2.setTextColor(-1);
        appCompatTextView.setTextSize(size(7));
        appCompatTextView2.setTextSize(size(6));
        linearLayoutCompat.setLayoutParams(size2);
        appCompatEditText.setBackground(Color(android.R.color.white));
        appCompatTextView.setPadding(size(10), size(10), size(10), size(0));
        appCompatEditText.setPadding(size(10), size(10), size(10), size(10));
        appCompatTextView2.setPadding(size(10), size(0), size(10), size(10));
        appCompatEditText.setLayoutParams(size2);
        linearLayoutCompat.setLayoutParams(size);
        linearLayoutCompat.setOrientation(1);
        linearLayoutCompat.addView(appCompatTextView);
        linearLayoutCompat.addView(appCompatEditText);
        linearLayoutCompat.addView(appCompatTextView2);
        return linearLayoutCompat;
    }

    public static void Type(String str, RSS.Listener listener) {
        ctx.startActivity(new Intent(ctx, (Class<?>) RSS.class).putExtra(opsi[22], str).putExtra(opsi[7], listener));
    }

    public static LatLng rand(double d, double d2, int i) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        double d3 = i / 111000.0f;
        double dNextDouble = random.nextDouble();
        double dNextDouble2 = random.nextDouble();
        double dSqrt = Math.sqrt(dNextDouble);
        Double.isNaN(d3);
        double d4 = d3 * dSqrt;
        double d5 = dNextDouble2 * 6.283185307179586d;
        return new LatLng((Math.sin(d5) * d4) + d2, ((Math.cos(d5) * d4) / Math.cos(d2)) + d);
    }

    public static void onResponse(JSONObject jSONObject) {
        try {
            get().edit().putBoolean(opsi[44], jSONObject.getBoolean(opsi[44])).putBoolean(opsi[45], jSONObject.getBoolean(opsi[45])).putString(opsi[16], jSONObject.getString(opsi[16])).putString(opsi[23], jSONObject.getString(opsi[23])).putString(opsi[59], jSONObject.getString(opsi[59])).putString(opsi[60], jSONObject.getString(opsi[60])).putString(opsi[61], jSONObject.getString(opsi[61])).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean onStop() {
        String line;
        Boolean bool = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/etc/hosts")));
            do {
                line = bufferedReader.readLine();
                if (line == null) {
                }
                return bool.booleanValue();
            } while (!line.contains("admob"));
            bool = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bool.booleanValue();
    }

    public static boolean onStops() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 23) {
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasTransport(4);
        }
        for (Network network : connectivityManager.getAllNetworks()) {
            if (connectivityManager.getNetworkCapabilities(network).hasTransport(4)) {
                return true;
            }
        }
        return false;
    }
}
