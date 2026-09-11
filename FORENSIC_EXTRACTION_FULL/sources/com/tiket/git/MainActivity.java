package com.tiket.git;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationViews;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButtons;
import android.support.design.widget.FloatingActionsMenu;
import android.support.design.widget.FloatingButton;
import android.support.design.widget.FloatingMenu;
import android.support.design.widget.SubButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, LocationClient.LocationListeners, GoogleMap.InfoWindowAdapter, View.OnClickListener, DialogInterface.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, RSS.Listener, Req.Response, Serializable {
    private static LinearLayoutCompat Accuracy;
    private static AppCompatButton Add;
    private static LinearLayoutCompat Bearing;
    private static BottomSheetDialog Dialog;
    private static LinearLayoutCompat Floating;
    private static LinearLayoutCompat Food;
    private static FloatingActionButtons Gocar;
    private static FloatingActionButtons Goride;
    private static FloatingActionButtons Grabbike;
    private static FloatingActionButtons Grabcar;
    private static DrawerLayout Info;
    private static LinearLayoutCompat Mode;
    private static AppCompatEditText Nama;
    private static LinearLayoutCompat Pickup;
    private static LinearLayoutCompat Random;
    private static DrawerLayout Setting;
    private static LinearLayoutCompat Speed;
    private static LinearLayoutCompat Start;
    private static AppCompatEditText Tikor;
    private static LinearLayoutCompat Tinggi;
    private static FloatingActionButtons Tracar;
    private static LinearLayoutCompat Type;
    private static SwitchCompat aAccuracy;
    private static SwitchCompat aBearing;
    private static SwitchCompat aFloating;
    private static SwitchCompat aFood;
    private static SwitchCompat aMode;
    private static SwitchCompat aPickup;
    private static SwitchCompat aRandom;
    private static SwitchCompat aSpeed;
    private static SwitchCompat aStart;
    private static SwitchCompat aTinggi;
    private static SwitchCompat aType;
    private static AppCompatTextView bAccuracy;
    private static AppCompatTextView bBearing;
    private static AppCompatTextView bFloating;
    private static AppCompatTextView bFood;
    private static AppCompatTextView bMode;
    private static AppCompatTextView bPickup;
    private static AppCompatTextView bRandom;
    private static AppCompatTextView bSpeed;
    private static AppCompatTextView bStart;
    private static AppCompatTextView bTinggi;
    private static AppCompatTextView bType;
    private static AppCompatSeekBar cAccuracy;
    private static AppCompatSeekBar cBearing;
    private static AppCompatSeekBar cRandom;
    private static AppCompatSeekBar cSpeed;
    private static AppCompatSeekBar cStart;
    private static AppCompatSeekBar cTinggi;
    private static AppCompatTextView dAccuracy;
    private static AppCompatTextView dBearing;
    private static AppCompatTextView dFloating;
    private static AppCompatTextView dFood;
    private static AppCompatTextView dMode;
    private static AppCompatTextView dPickup;
    private static AppCompatTextView dRandom;
    private static AppCompatTextView dSpeed;
    private static AppCompatTextView dStart;
    private static AppCompatTextView dTinggi;
    private static AppCompatTextView dType;
    private static FrameLayout eAccuracy;
    private static FrameLayout eBearing;
    private static FrameLayout eFloating;
    private static FrameLayout eFood;
    private static FrameLayout eMode;
    private static FrameLayout ePickup;
    private static FrameLayout eRandom;
    private static FrameLayout eSpeed;
    private static FrameLayout eStart;
    private static FrameLayout eTinggi;
    private static FrameLayout eType;
    private static AppCompatTextView fAccuracy;
    private static AppCompatTextView fBearing;
    private static AppCompatTextView fFloating;
    private static AppCompatTextView fFood;
    private static AppCompatTextView fMode;
    private static AppCompatTextView fPickup;
    private static AppCompatTextView fRandom;
    private static AppCompatTextView fSpeed;
    private static AppCompatTextView fStart;
    private static AppCompatTextView fTinggi;
    private static AppCompatTextView fType;
    private static SubButton gocar;
    private static SubButton goride;
    private static SubButton grab;
    private static GoogleMap mMap;
    private static Marker mMarker;
    private static BottomNavigationViews menu;
    private static Marker nMarker;
    private static ProgressDialog notice;
    private static AppCompatImageView start;
    public static AppCompatImageView stop;
    private transient LocationClient LocationClient;

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        onPermission();
        Setting = (DrawerLayout) findViewById(R.id.Setting);
        Info = (DrawerLayout) findViewById(R.id.Info);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.Maps);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Layout);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) findViewById(R.id.setting);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) findViewById(R.id.info);
        View viewFindViewById = supportMapFragment.getView().findViewById(1);
        View viewFindViewById2 = supportMapFragment.getView().findViewById(4);
        LinearLayoutCompat linearLayoutCompat3 = new LinearLayoutCompat(this);
        BottomNavigationViews bottomNavigationViews = new BottomNavigationViews(this);
        FloatingActionsMenu floatingActionsMenu = new FloatingActionsMenu(this);
        FloatingButton floatingButtonBuild = new FloatingButton.Builder(this).setBackgroundDrawable(base.setIcon(R.drawable.pickup, 14, base.opsi[13])).setPosition(3).build();
        SubButton.Builder builder = new SubButton.Builder(this);
        start = new AppCompatImageView(this);
        stop = new AppCompatImageView(this);
        notice = new ProgressDialog(this);
        notice.setMessage(base.opsi[21]);
        supportMapFragment.getMapAsync(this);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams();
        RelativeLayout.LayoutParams layoutParamsSize = base.Size(11, 10);
        RelativeLayout.LayoutParams layoutParamsSize2 = base.Size(13, 12);
        layoutParamsSize.setMargins(base.size(10), base.size(100), base.size(10), base.size(10));
        layoutParamsSize2.setMargins(base.size(10), base.size(10), base.size(10), base.size(40));
        layoutParams.setMargins(base.size(10), base.size(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), base.size(10), base.size(10));
        layoutParams2.setMargins(base.size(10), base.size(10), base.size(10), base.size(100));
        start.setImageResource(R.drawable.ic_play);
        stop.setImageResource(R.drawable.ic_pause);
        linearLayoutCompat.setBackgroundDrawable(base.setBackground(R.color.colorPrimary));
        linearLayoutCompat2.setBackgroundDrawable(base.setBackground(R.color.colorPrimary));
        bottomNavigationViews.getMenu().add(0, 1, 0, base.opsi[0]).setIcon(R.drawable.ic_food);
        bottomNavigationViews.getMenu().add(0, 2, 0, base.opsi[1]).setIcon(R.drawable.ic_food);
        bottomNavigationViews.getMenu().add(0, 3, 0, "");
        bottomNavigationViews.getMenu().add(0, 4, 0, base.opsi[2]).setIcon(R.drawable.ic_food);
        bottomNavigationViews.getMenu().add(0, 5, 0, base.opsi[3]).setIcon(R.drawable.ic_transit);
        BottomNavigationViews.disable(bottomNavigationViews);
        Goride = new FloatingActionButtons(this);
        Goride.setIconDrawable(base.setIcon(R.drawable.ic_bike, 0, base.opsi[8]));
        Gocar = new FloatingActionButtons(this);
        Gocar.setIconDrawable(base.setIcon(R.drawable.ic_car, 0, base.opsi[9]));
        Grabbike = new FloatingActionButtons(this);
        Grabbike.setIconDrawable(base.setIcon(R.drawable.ic_bike, 0, base.opsi[10]));
        Grabcar = new FloatingActionButtons(this);
        Grabcar.setIconDrawable(base.setIcon(R.drawable.ic_car, 0, base.opsi[11]));
        Tracar = new FloatingActionButtons(this);
        Tracar.setIconDrawable(base.setIcon(R.drawable.ic_car, 0, base.opsi[12]));
        goride = builder.setBackgroundDrawable(base.setIcon(R.drawable.pickup, 14, base.opsi[8])).build();
        gocar = builder.setBackgroundDrawable(base.setIcon(R.drawable.pickup, 14, base.opsi[9])).build();
        grab = builder.setBackgroundDrawable(base.setIcon(R.drawable.pickup, 14, base.opsi[46])).build();
        new FloatingMenu.Builder(this).setStartAngle(130).setEndAngle(230).addSubActionView(grab).addSubActionView(gocar).addSubActionView(goride).attachTo(floatingButtonBuild).build();
        floatingActionsMenu.addButton(Goride);
        floatingActionsMenu.addButton(Grabbike);
        floatingActionsMenu.addButton(Gocar);
        floatingActionsMenu.addButton(Grabcar);
        floatingActionsMenu.addButton(Tracar);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams2.addRule(11);
        layoutParams2.addRule(12);
        linearLayoutCompat3.setOrientation(1);
        linearLayoutCompat3.addView(start);
        linearLayoutCompat3.addView(stop);
        linearLayoutCompat.addView(onCreate());
        linearLayoutCompat2.addView(Info());
        relativeLayout.addView(linearLayoutCompat3, layoutParamsSize);
        relativeLayout.addView(floatingActionsMenu, layoutParamsSize2);
        relativeLayout.addView(bottomNavigationViews, base.Size(13, 12));
        bottomNavigationViews.setOnNavigationItemSelectedListener(this);
        Goride.setOnClickListener(this);
        goride.setOnClickListener(this);
        Gocar.setOnClickListener(this);
        gocar.setOnClickListener(this);
        grab.setOnClickListener(this);
        Grabbike.setOnClickListener(this);
        Grabcar.setOnClickListener(this);
        Tracar.setOnClickListener(this);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        if (!get().getBoolean(getApplicationInfo().loadLabel(getPackageManager()).toString(), false)) {
            base.alert(this, this, -3);
            base.get().edit().putBoolean("mock", false).apply();
        }
        if (get().getBoolean("mock", true)) {
            start();
        } else {
            stop();
        }
    }

    public RelativeLayout Info() {
        LinearLayoutCompat.LayoutParams size = base.size(-1, -2);
        LinearLayoutCompat.LayoutParams size2 = base.size(-1, -2);
        size2.gravity = 17;
        size.setMargins(base.size(10), base.size(10), base.size(10), base.size(10));
        RelativeLayout relativeLayout = new RelativeLayout(this);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
        AppCompatImageView appCompatImageView = new AppCompatImageView(this);
        FrameLayout frameLayout = new FrameLayout(this);
        AppCompatTextView appCompatTextView = new AppCompatTextView(this);
        FrameLayout frameLayout2 = new FrameLayout(this);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(this);
        FrameLayout frameLayout3 = new FrameLayout(this);
        AppCompatTextView appCompatTextView3 = new AppCompatTextView(this);
        AppCompatTextView appCompatTextView4 = new AppCompatTextView(this);
        AppCompatTextView appCompatTextView5 = new AppCompatTextView(this);
        AppCompatTextView appCompatTextView6 = new AppCompatTextView(this);
        LinearLayoutCompat linearLayoutCompat2 = new LinearLayoutCompat(this);
        AppCompatTextView appCompatTextView7 = new AppCompatTextView(this);
        AppCompatEditText appCompatEditText = new AppCompatEditText(this);
        appCompatTextView.setText(base.opsi[59]);
        appCompatTextView5.setText(opsi(2));
        appCompatTextView2.setText(base.opsi[60]);
        appCompatTextView4.setText(opsi(3));
        appCompatTextView3.setText(base.opsi[61]);
        appCompatTextView6.setText(opsi(4));
        appCompatTextView7.setText(base.opsi[63]);
        appCompatEditText.setText(opsi(1));
        appCompatTextView.setTextColor(-1);
        appCompatTextView5.setTextColor(-3355444);
        appCompatTextView2.setTextColor(-1);
        appCompatTextView4.setTextColor(-3355444);
        appCompatTextView3.setTextColor(-1);
        appCompatTextView6.setTextColor(-3355444);
        appCompatTextView7.setTextColor(-1);
        appCompatEditText.setTextColor(-3355444);
        appCompatTextView7.setTextSize(base.size(10));
        appCompatTextView.setTypeface(appCompatTextView.getTypeface(), 1);
        appCompatTextView5.setTypeface(appCompatTextView5.getTypeface(), 1);
        appCompatTextView2.setTypeface(appCompatTextView2.getTypeface(), 1);
        appCompatTextView4.setTypeface(appCompatTextView4.getTypeface(), 1);
        appCompatTextView3.setTypeface(appCompatTextView3.getTypeface(), 1);
        appCompatTextView6.setTypeface(appCompatTextView6.getTypeface(), 1);
        appCompatTextView7.setTypeface(appCompatTextView7.getTypeface(), 1);
        appCompatEditText.setTypeface(appCompatEditText.getTypeface(), 1);
        appCompatImageView.setImageDrawable(base.Logo());
        appCompatImageView.setLayoutParams(size2);
        appCompatTextView.setLayoutParams(base.opsi(GravityCompat.START));
        appCompatTextView5.setLayoutParams(base.opsi(GravityCompat.END));
        appCompatTextView2.setLayoutParams(base.opsi(GravityCompat.START));
        appCompatTextView4.setLayoutParams(base.opsi(GravityCompat.END));
        appCompatTextView3.setLayoutParams(base.opsi(GravityCompat.START));
        appCompatTextView6.setLayoutParams(base.opsi(GravityCompat.END));
        appCompatImageView.setPadding(base.size(10), base.size(10), base.size(10), base.size(10));
        appCompatEditText.setBackground(base.Color(android.R.color.white));
        appCompatTextView7.setGravity(17);
        appCompatEditText.setGravity(17);
        frameLayout.setLayoutParams(size);
        frameLayout2.setLayoutParams(size);
        frameLayout3.setLayoutParams(size);
        linearLayoutCompat2.setLayoutParams(size);
        linearLayoutCompat.setLayoutParams(size);
        linearLayoutCompat2.setOrientation(1);
        linearLayoutCompat.setOrientation(1);
        frameLayout.addView(appCompatTextView);
        frameLayout.addView(appCompatTextView5);
        frameLayout2.addView(appCompatTextView2);
        frameLayout2.addView(appCompatTextView4);
        frameLayout3.addView(appCompatTextView3);
        frameLayout3.addView(appCompatTextView6);
        linearLayoutCompat2.addView(appCompatTextView7);
        linearLayoutCompat2.addView(appCompatEditText);
        linearLayoutCompat.addView(appCompatImageView);
        linearLayoutCompat.addView(linearLayoutCompat2);
        relativeLayout.addView(linearLayoutCompat);
        return relativeLayout;
    }

    public RelativeLayout onCreate() {
        LinearLayoutCompat.LayoutParams size = base.size(-1, -2);
        LinearLayoutCompat.LayoutParams size2 = base.size(-1, -2);
        size2.gravity = 17;
        LinearLayoutCompat.LayoutParams size3 = base.size(-1, base.size(40));
        size.setMargins(base.size(10), base.size(2), base.size(10), base.size(2));
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
        AppCompatImageView appCompatImageView = new AppCompatImageView(this);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        Random = new LinearLayoutCompat(this);
        Food = new LinearLayoutCompat(this);
        Pickup = new LinearLayoutCompat(this);
        Mode = new LinearLayoutCompat(this);
        Type = new LinearLayoutCompat(this);
        Start = new LinearLayoutCompat(this);
        Floating = new LinearLayoutCompat(this);
        Accuracy = new LinearLayoutCompat(this);
        Bearing = new LinearLayoutCompat(this);
        Speed = new LinearLayoutCompat(this);
        Tinggi = new LinearLayoutCompat(this);
        aRandom = new SwitchCompat(this);
        aFloating = new SwitchCompat(this);
        aFood = new SwitchCompat(this);
        aFood = new SwitchCompat(this);
        aPickup = new SwitchCompat(this);
        aMode = new SwitchCompat(this);
        aType = new SwitchCompat(this);
        aStart = new SwitchCompat(this);
        aAccuracy = new SwitchCompat(this);
        aBearing = new SwitchCompat(this);
        aSpeed = new SwitchCompat(this);
        aTinggi = new SwitchCompat(this);
        bRandom = new AppCompatTextView(this);
        bFloating = new AppCompatTextView(this);
        bFood = new AppCompatTextView(this);
        bPickup = new AppCompatTextView(this);
        bMode = new AppCompatTextView(this);
        bType = new AppCompatTextView(this);
        bStart = new AppCompatTextView(this);
        bAccuracy = new AppCompatTextView(this);
        bBearing = new AppCompatTextView(this);
        bSpeed = new AppCompatTextView(this);
        bTinggi = new AppCompatTextView(this);
        cRandom = new AppCompatSeekBar(this);
        cStart = new AppCompatSeekBar(this);
        cAccuracy = new AppCompatSeekBar(this);
        cBearing = new AppCompatSeekBar(this);
        cSpeed = new AppCompatSeekBar(this);
        cTinggi = new AppCompatSeekBar(this);
        dRandom = new AppCompatTextView(this);
        dStart = new AppCompatTextView(this);
        dAccuracy = new AppCompatTextView(this);
        dBearing = new AppCompatTextView(this);
        dSpeed = new AppCompatTextView(this);
        dTinggi = new AppCompatTextView(this);
        eRandom = new FrameLayout(this);
        eFloating = new FrameLayout(this);
        eFood = new FrameLayout(this);
        ePickup = new FrameLayout(this);
        eMode = new FrameLayout(this);
        eType = new FrameLayout(this);
        eStart = new FrameLayout(this);
        eAccuracy = new FrameLayout(this);
        eBearing = new FrameLayout(this);
        eSpeed = new FrameLayout(this);
        eTinggi = new FrameLayout(this);
        fRandom = new AppCompatTextView(this);
        fFloating = new AppCompatTextView(this);
        fFood = new AppCompatTextView(this);
        fPickup = new AppCompatTextView(this);
        fMode = new AppCompatTextView(this);
        fType = new AppCompatTextView(this);
        fStart = new AppCompatTextView(this);
        fAccuracy = new AppCompatTextView(this);
        fBearing = new AppCompatTextView(this);
        fSpeed = new AppCompatTextView(this);
        fTinggi = new AppCompatTextView(this);
        fRandom.setText(base.opsi[15]);
        fFood.setText(base.opsi[54]);
        fPickup.setText(base.opsi[55]);
        fMode.setText(base.opsi[31]);
        fType.setText(base.opsi[32]);
        fFloating.setText(base.opsi[33]);
        fStart.setText(base.opsi[34]);
        fAccuracy.setText(base.opsi[35]);
        fSpeed.setText(base.opsi[36]);
        fBearing.setText(base.opsi[37]);
        fTinggi.setText(base.opsi[38]);
        dRandom.setGravity(17);
        dStart.setGravity(17);
        dAccuracy.setGravity(17);
        dBearing.setGravity(17);
        dSpeed.setGravity(17);
        dTinggi.setGravity(17);
        bRandom.setTextColor(-1);
        bFloating.setTextColor(-1);
        bFood.setTextColor(-1);
        bPickup.setTextColor(-1);
        bMode.setTextColor(-1);
        bType.setTextColor(-1);
        bStart.setTextColor(-1);
        bAccuracy.setTextColor(-1);
        bBearing.setTextColor(-1);
        bSpeed.setTextColor(-1);
        bTinggi.setTextColor(-1);
        dRandom.setTextColor(-1);
        dStart.setTextColor(-1);
        dAccuracy.setTextColor(-1);
        dBearing.setTextColor(-1);
        dSpeed.setTextColor(-1);
        dTinggi.setTextColor(-1);
        fRandom.setTextColor(-1);
        fFloating.setTextColor(-1);
        fFood.setTextColor(-1);
        fPickup.setTextColor(-1);
        fMode.setTextColor(-1);
        fType.setTextColor(-1);
        fStart.setTextColor(-1);
        fAccuracy.setTextColor(-1);
        fBearing.setTextColor(-1);
        fSpeed.setTextColor(-1);
        fTinggi.setTextColor(-1);
        bRandom.setTypeface(bRandom.getTypeface(), 1);
        bFloating.setTypeface(bFloating.getTypeface(), 1);
        bFood.setTypeface(bFood.getTypeface(), 1);
        bPickup.setTypeface(bPickup.getTypeface(), 1);
        bMode.setTypeface(bMode.getTypeface(), 1);
        bType.setTypeface(bType.getTypeface(), 1);
        bStart.setTypeface(bStart.getTypeface(), 1);
        bAccuracy.setTypeface(bAccuracy.getTypeface(), 1);
        bBearing.setTypeface(bBearing.getTypeface(), 1);
        bSpeed.setTypeface(bSpeed.getTypeface(), 1);
        bTinggi.setTypeface(bTinggi.getTypeface(), 1);
        dRandom.setTypeface(dStart.getTypeface(), 1);
        dStart.setTypeface(dStart.getTypeface(), 1);
        dAccuracy.setTypeface(dAccuracy.getTypeface(), 1);
        dBearing.setTypeface(dBearing.getTypeface(), 1);
        dSpeed.setTypeface(dSpeed.getTypeface(), 1);
        dTinggi.setTypeface(dTinggi.getTypeface(), 1);
        fRandom.setTypeface(fStart.getTypeface(), 1);
        fFloating.setTypeface(fFloating.getTypeface(), 1);
        fFood.setTypeface(fFood.getTypeface(), 1);
        fPickup.setTypeface(fPickup.getTypeface(), 1);
        fMode.setTypeface(fMode.getTypeface(), 1);
        fType.setTypeface(fType.getTypeface(), 1);
        fStart.setTypeface(fStart.getTypeface(), 1);
        fAccuracy.setTypeface(fAccuracy.getTypeface(), 1);
        fBearing.setTypeface(fBearing.getTypeface(), 1);
        fSpeed.setTypeface(fSpeed.getTypeface(), 1);
        fTinggi.setTypeface(fTinggi.getTypeface(), 1);
        cRandom.setMax(30);
        cStart.setMax(30);
        cAccuracy.setMax(30);
        cBearing.setMax(360);
        cSpeed.setMax(30);
        cTinggi.setMax(30);
        cRandom.setThumb(base.logo());
        cStart.setThumb(base.logo());
        cAccuracy.setThumb(base.logo());
        cBearing.setThumb(base.logo());
        cSpeed.setThumb(base.logo());
        cTinggi.setThumb(base.logo());
        cRandom.setProgressDrawable(base.Progress());
        cStart.setProgressDrawable(base.Progress());
        cAccuracy.setProgressDrawable(base.Progress());
        cBearing.setProgressDrawable(base.Progress());
        cSpeed.setProgressDrawable(base.Progress());
        cTinggi.setProgressDrawable(base.Progress());
        appCompatImageView.setImageDrawable(base.Logo());
        appCompatImageView.setLayoutParams(size2);
        aRandom.setLayoutParams(base.opsi(17));
        aFloating.setLayoutParams(base.opsi(17));
        aFood.setLayoutParams(base.opsi(17));
        aPickup.setLayoutParams(base.opsi(17));
        aMode.setLayoutParams(base.opsi(17));
        aType.setLayoutParams(base.opsi(17));
        aStart.setLayoutParams(base.opsi(17));
        aAccuracy.setLayoutParams(base.opsi(17));
        aBearing.setLayoutParams(base.opsi(17));
        aSpeed.setLayoutParams(base.opsi(17));
        aTinggi.setLayoutParams(base.opsi(17));
        bRandom.setLayoutParams(base.opsi(GravityCompat.END));
        bFloating.setLayoutParams(base.opsi(GravityCompat.END));
        bFood.setLayoutParams(base.opsi(GravityCompat.END));
        bPickup.setLayoutParams(base.opsi(GravityCompat.END));
        bMode.setLayoutParams(base.opsi(GravityCompat.END));
        bType.setLayoutParams(base.opsi(GravityCompat.END));
        bStart.setLayoutParams(base.opsi(GravityCompat.END));
        bAccuracy.setLayoutParams(base.opsi(GravityCompat.END));
        bBearing.setLayoutParams(base.opsi(GravityCompat.END));
        bSpeed.setLayoutParams(base.opsi(GravityCompat.END));
        bTinggi.setLayoutParams(base.opsi(GravityCompat.END));
        fRandom.setLayoutParams(base.opsi(GravityCompat.START));
        fFloating.setLayoutParams(base.opsi(GravityCompat.START));
        fFood.setLayoutParams(base.opsi(GravityCompat.START));
        fPickup.setLayoutParams(base.opsi(GravityCompat.START));
        fMode.setLayoutParams(base.opsi(GravityCompat.START));
        fType.setLayoutParams(base.opsi(GravityCompat.START));
        fStart.setLayoutParams(base.opsi(GravityCompat.START));
        fAccuracy.setLayoutParams(base.opsi(GravityCompat.START));
        fBearing.setLayoutParams(base.opsi(GravityCompat.START));
        fSpeed.setLayoutParams(base.opsi(GravityCompat.START));
        fTinggi.setLayoutParams(base.opsi(GravityCompat.START));
        eRandom.setLayoutParams(size);
        eFloating.setLayoutParams(size);
        eFood.setLayoutParams(size);
        ePickup.setLayoutParams(size);
        eMode.setLayoutParams(size);
        eType.setLayoutParams(size);
        eStart.setLayoutParams(size);
        eAccuracy.setLayoutParams(size);
        eBearing.setLayoutParams(size);
        eSpeed.setLayoutParams(size);
        eTinggi.setLayoutParams(size);
        Random.setLayoutParams(size);
        Floating.setLayoutParams(size);
        Food.setLayoutParams(size);
        Pickup.setLayoutParams(size);
        Mode.setLayoutParams(size);
        Type.setLayoutParams(size);
        Start.setLayoutParams(size);
        Accuracy.setLayoutParams(size);
        Bearing.setLayoutParams(size);
        Speed.setLayoutParams(size);
        Tinggi.setLayoutParams(size);
        dRandom.setLayoutParams(size2);
        dStart.setLayoutParams(size2);
        dAccuracy.setLayoutParams(size2);
        dBearing.setLayoutParams(size2);
        dSpeed.setLayoutParams(size2);
        dTinggi.setLayoutParams(size2);
        cRandom.setLayoutParams(size3);
        cStart.setLayoutParams(size3);
        cAccuracy.setLayoutParams(size3);
        cBearing.setLayoutParams(size3);
        cSpeed.setLayoutParams(size3);
        cTinggi.setLayoutParams(size3);
        linearLayoutCompat.setLayoutParams(size);
        Random.setOrientation(1);
        Floating.setOrientation(1);
        Food.setOrientation(1);
        Pickup.setOrientation(1);
        Mode.setOrientation(1);
        Type.setOrientation(1);
        Start.setOrientation(1);
        Accuracy.setOrientation(1);
        Bearing.setOrientation(1);
        Speed.setOrientation(1);
        Tinggi.setOrientation(1);
        linearLayoutCompat.setOrientation(1);
        appCompatImageView.setPadding(base.size(10), base.size(10), base.size(10), base.size(10));
        eFood.addView(fFood);
        eFood.addView(aFood);
        eFood.addView(bFood);
        ePickup.addView(fPickup);
        ePickup.addView(aPickup);
        ePickup.addView(bPickup);
        eMode.addView(fMode);
        eMode.addView(aMode);
        eMode.addView(bMode);
        eType.addView(fType);
        eType.addView(aType);
        eType.addView(bType);
        eRandom.addView(fRandom);
        eRandom.addView(aRandom);
        eRandom.addView(bRandom);
        eStart.addView(fStart);
        eStart.addView(aStart);
        eStart.addView(bStart);
        eFloating.addView(fFloating);
        eFloating.addView(aFloating);
        eFloating.addView(bFloating);
        eAccuracy.addView(fAccuracy);
        eAccuracy.addView(aAccuracy);
        eAccuracy.addView(bAccuracy);
        eBearing.addView(fBearing);
        eBearing.addView(aBearing);
        eBearing.addView(bBearing);
        eSpeed.addView(fSpeed);
        eSpeed.addView(aSpeed);
        eSpeed.addView(bSpeed);
        eTinggi.addView(fTinggi);
        eTinggi.addView(aTinggi);
        eTinggi.addView(bTinggi);
        Random.addView(eRandom);
        Floating.addView(eFloating);
        Food.addView(eFood);
        Pickup.addView(ePickup);
        Mode.addView(eMode);
        Type.addView(eType);
        Start.addView(eStart);
        Accuracy.addView(eAccuracy);
        Bearing.addView(eBearing);
        Speed.addView(eSpeed);
        Tinggi.addView(eTinggi);
        linearLayoutCompat.addView(appCompatImageView);
        linearLayoutCompat.addView(Mode);
        linearLayoutCompat.addView(Type);
        linearLayoutCompat.addView(Food);
        linearLayoutCompat.addView(Pickup);
        linearLayoutCompat.addView(Floating);
        linearLayoutCompat.addView(Start);
        linearLayoutCompat.addView(Random);
        linearLayoutCompat.addView(Accuracy);
        linearLayoutCompat.addView(Speed);
        linearLayoutCompat.addView(Bearing);
        linearLayoutCompat.addView(Tinggi);
        relativeLayout.addView(linearLayoutCompat);
        if (get().getBoolean("Food", true)) {
            aFood.setChecked(true);
            bFood.setText(base.opsi[56]);
        } else {
            aFood.setChecked(false);
            bFood.setText(base.opsi[57]);
        }
        if (get().getBoolean("Pickup", true)) {
            aPickup.setChecked(true);
            bPickup.setText(base.opsi[56]);
        } else {
            aPickup.setChecked(false);
            bPickup.setText(base.opsi[57]);
        }
        if (get().getBoolean("Mode", true)) {
            aMode.setChecked(true);
            bMode.setText(base.opsi[39]);
        } else {
            aMode.setChecked(false);
            bMode.setText(base.opsi[40]);
        }
        if (get().getBoolean("Type", true)) {
            aType.setChecked(true);
            bType.setText(base.opsi[41]);
        } else {
            aType.setChecked(false);
            bType.setText(base.opsi[42]);
        }
        if (get().getBoolean("Floating", true)) {
            aFloating.setChecked(true);
            bFloating.setText(base.opsi[45]);
        } else {
            mPermission();
            aFloating.setChecked(false);
            bFloating.setText(base.opsi[44]);
        }
        if (get().getBoolean("Start", true)) {
            aStart.setChecked(true);
            bStart.setText(base.opsi[45]);
            Start.removeView(dStart);
            Start.removeView(cStart);
        } else {
            aStart.setChecked(false);
            dStart.setText("Meter " + get().getInt("start", 0));
            cStart.setProgress(get().getInt("start", 0));
            bStart.setText(base.opsi[44]);
            Start.addView(dStart);
            Start.addView(cStart);
        }
        if (get().getBoolean("Random", true)) {
            aRandom.setChecked(true);
            bRandom.setText(base.opsi[45]);
            Random.removeView(dRandom);
            Random.removeView(cRandom);
        } else {
            aRandom.setChecked(false);
            dRandom.setText("Menit " + get().getInt("random", 0));
            cRandom.setProgress(get().getInt("random", 0));
            bRandom.setText(base.opsi[44]);
            Random.addView(dRandom);
            Random.addView(cRandom);
        }
        if (get().getBoolean("Accuracy", true)) {
            aAccuracy.setChecked(true);
            bAccuracy.setText(base.opsi[20]);
            Accuracy.removeView(dAccuracy);
            Accuracy.removeView(cAccuracy);
        } else {
            aAccuracy.setChecked(false);
            dAccuracy.setText("Meter " + get().getInt("accuracy", 0));
            cAccuracy.setProgress(get().getInt("accuracy", 0));
            bAccuracy.setText(base.opsi[43]);
            Accuracy.addView(dAccuracy);
            Accuracy.addView(cAccuracy);
        }
        if (get().getBoolean("Bearing", true)) {
            aBearing.setChecked(true);
            bBearing.setText(base.opsi[20]);
            Bearing.removeView(dBearing);
            Bearing.removeView(cBearing);
        } else {
            aBearing.setChecked(false);
            dBearing.setText("Drajat " + get().getInt("bearing", 0));
            cBearing.setProgress(get().getInt("bearing", 0));
            bBearing.setText(base.opsi[43]);
            Bearing.addView(dBearing);
            Bearing.addView(cBearing);
        }
        if (get().getBoolean("Speed", true)) {
            aSpeed.setChecked(true);
            bSpeed.setText(base.opsi[20]);
            Speed.removeView(dSpeed);
            Speed.removeView(cSpeed);
        } else {
            aSpeed.setChecked(false);
            dSpeed.setText("Meter " + get().getInt("speed", 0));
            cSpeed.setProgress(get().getInt("speed", 0));
            bSpeed.setText(base.opsi[43]);
            Speed.addView(dSpeed);
            Speed.addView(cSpeed);
        }
        if (get().getBoolean("Tinggi", true)) {
            aTinggi.setChecked(true);
            bTinggi.setText(base.opsi[20]);
            Tinggi.removeView(dTinggi);
            Tinggi.removeView(cTinggi);
        } else {
            aTinggi.setChecked(false);
            dTinggi.setText("Meter " + get().getInt("tinggi", 0));
            cTinggi.setProgress(get().getInt("tinggi", 0));
            bTinggi.setText(base.opsi[43]);
            Tinggi.addView(dTinggi);
            Tinggi.addView(cTinggi);
        }
        cRandom.setOnSeekBarChangeListener(this);
        cStart.setOnSeekBarChangeListener(this);
        cAccuracy.setOnSeekBarChangeListener(this);
        cBearing.setOnSeekBarChangeListener(this);
        cSpeed.setOnSeekBarChangeListener(this);
        cTinggi.setOnSeekBarChangeListener(this);
        aFloating.setOnCheckedChangeListener(this);
        aFood.setOnCheckedChangeListener(this);
        aPickup.setOnCheckedChangeListener(this);
        aMode.setOnCheckedChangeListener(this);
        aType.setOnCheckedChangeListener(this);
        aRandom.setOnCheckedChangeListener(this);
        aStart.setOnCheckedChangeListener(this);
        aAccuracy.setOnCheckedChangeListener(this);
        aBearing.setOnCheckedChangeListener(this);
        aSpeed.setOnCheckedChangeListener(this);
        aTinggi.setOnCheckedChangeListener(this);
        return relativeLayout;
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(1);
        if (!get().getBoolean("Type", true)) {
            mMap.setTrafficEnabled(true);
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setOnMapClickListener(this);
        mMap.setInfoWindowAdapter(this);
    }

    public void Camera(LatLng latLng) {
        if (mMarker != null) {
            mMarker.remove();
        }
        if (latLng != null) {
            mMarker = mMap.addMarker(new MarkerOptions().position(latLng).title(getApplicationInfo().loadLabel(getPackageManager()).toString()).snippet(base.title(latLng)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
            base.add(base.title(latLng));
        }
    }

    @Override // com.google.android.gms.location.LocationClient.LocationListeners
    public void onLocationChanged(Location location) {
        if (TextUtils.isEmpty(base.Tikor())) {
            Camera(new LatLng(location.getLatitude(), location.getLongitude()));
        } else {
            Camera(new LatLng(Double.parseDouble(base.Latlng()[0]), Double.parseDouble(base.Latlng()[1])));
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        if (mMarker != null) {
            mMarker.remove();
        }
        mMarker = mMap.addMarker(new MarkerOptions().position(latLng).title(getApplicationInfo().loadLabel(getPackageManager()).toString()).snippet(base.title(latLng)));
        base.add(base.title(latLng));
    }

    private void Type(String str, int i, int i2, int i3) {
        if (!notice.isShowing()) {
            notice.show();
        }
        new Req(this, this, base.opsi(1, str, base.Tikor(), null), i, i2, i3, str);
    }

    @Override // com.tiket.git.Req.Response
    public void Response(JSONObject jSONObject, int i, int i2, int i3, String str) {
        for (Map.Entry<String, String> entry : base.getDriver(jSONObject, notice).entrySet()) {
            String[] strArrSplit = String.valueOf(entry.getValue()).split(",");
            nMarker = mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(strArrSplit[0]), Double.parseDouble(strArrSplit[1]))).title(String.valueOf(entry.getKey())).snippet(String.valueOf(entry.getValue())).icon(BitmapDescriptorFactory.fromBitmap(base.setIcon(i, i2, i3))));
            base.add(String.valueOf(entry.getValue()));
        }
    }

    @Override // com.tiket.git.RSS.Listener
    public void onResponse(String str, String str2) {
        if (mMarker != null) {
            mMarker.remove();
        }
        String[] strArrSplit = str.split(",");
        LatLng latLng = new LatLng(Double.parseDouble(strArrSplit[0]), Double.parseDouble(strArrSplit[1]));
        mMarker = mMap.addMarker(new MarkerOptions().position(latLng).title(str2).snippet(str));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        mMarker.showInfoWindow();
        base.add(base.title(latLng));
    }

    public void Save(String str, String str2) {
        Dialog = new BottomSheetDialog(this, R.style.BottomSheet);
        LinearLayoutCompat.LayoutParams size = base.size(-1, -2);
        LinearLayoutCompat.LayoutParams size2 = base.size(-1, base.size(40));
        size.setMargins(base.size(20), base.size(20), base.size(20), base.size(20));
        size2.setMargins(base.size(20), base.size(10), base.size(20), base.size(20));
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
        Nama = new AppCompatEditText(this);
        Tikor = new AppCompatEditText(this);
        Add = new AppCompatButton(this);
        Add.setText(base.opsi[50]);
        if (str == null) {
            Nama.setHint(base.opsi[4]);
        } else {
            Nama.setText(str);
        }
        if (str2 == null) {
            Tikor.setHint(base.opsi[6]);
        } else {
            Tikor.setText(str2);
        }
        Nama.setTextColor(R.dimen.action_button_size);
        Tikor.setTextColor(R.dimen.action_button_size);
        Add.setTextColor(-1);
        linearLayoutCompat.setLayoutParams(size);
        Nama.setLayoutParams(size2);
        Add.setLayoutParams(size2);
        Tikor.setLayoutParams(size2);
        Add.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        Nama.setBackground(base.Color(R.color.colorPrimary));
        Tikor.setBackground(base.Color(R.color.colorPrimary));
        Nama.setPadding(base.size(10), base.size(10), base.size(10), base.size(10));
        Tikor.setPadding(base.size(10), base.size(10), base.size(10), base.size(10));
        Add.setPadding(base.size(10), base.size(10), base.size(10), base.size(10));
        linearLayoutCompat.setOrientation(1);
        linearLayoutCompat.addView(Nama);
        linearLayoutCompat.addView(Tikor);
        linearLayoutCompat.addView(Add);
        Dialog.setContentView(linearLayoutCompat);
        Dialog.show();
        Add.setOnClickListener(this);
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
        AppCompatTextView appCompatTextView = new AppCompatTextView(this);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(this);
        appCompatTextView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        appCompatTextView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        appCompatTextView.setTypeface(appCompatTextView.getTypeface(), 1);
        appCompatTextView2.setTypeface(appCompatTextView2.getTypeface(), 2);
        appCompatTextView.setTextSize(base.size(5));
        appCompatTextView2.setTextSize(base.size(3));
        appCompatTextView.setText(marker.getTitle());
        appCompatTextView2.setText(marker.getSnippet());
        appCompatTextView.setGravity(17);
        appCompatTextView2.setGravity(17);
        linearLayoutCompat.setOrientation(1);
        linearLayoutCompat.setLayoutParams(layoutParams);
        linearLayoutCompat.addView(appCompatTextView);
        linearLayoutCompat.addView(appCompatTextView2);
        if (!marker.getTitle().equals(getApplicationInfo().loadLabel(getPackageManager()))) {
            base.add(base.opsi[19], marker.getTitle(), base.title(marker.getPosition()));
        }
        if (marker.getTitle().equals(getApplicationInfo().loadLabel(getPackageManager()))) {
            Save(marker.getTitle(), base.title(marker.getPosition()));
        }
        return linearLayoutCompat;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == start) {
            start();
            startService(new Intent(this, (Class<?>) Start.class));
            if (this.LocationClient != null) {
                this.LocationClient.removeLocationUpdates();
            }
            Toast.makeText(this, base.opsi[44], 0).show();
            return;
        }
        if (view == stop) {
            stop();
            stopService(new Intent(this, (Class<?>) Start.class));
            if (this.LocationClient != null) {
                this.LocationClient.requestLocationUpdates();
            }
            Toast.makeText(this, base.opsi[45], 0).show();
            return;
        }
        if (view == Goride) {
            Type(base.opsi[8], R.drawable.ic_bike, android.R.color.holo_green_dark, android.R.color.white);
            return;
        }
        if (view == Gocar) {
            Type(base.opsi[9], R.drawable.ic_car, R.color.blue, android.R.color.white);
            return;
        }
        if (view == Grabbike) {
            Type(base.opsi[10], R.drawable.ic_bike, android.R.color.black, android.R.color.white);
            return;
        }
        if (view == Grabcar) {
            Type(base.opsi[11], R.drawable.ic_car, R.color.green, android.R.color.white);
            return;
        }
        if (view == Tracar) {
            Type(base.opsi[12], R.drawable.ic_car, android.R.color.holo_red_dark, android.R.color.white);
            return;
        }
        if (view == goride) {
            Typex(base.opsi[47], this);
            return;
        }
        if (view == gocar) {
            Typex(base.opsi[48], this);
            return;
        }
        if (view == grab) {
            Typex(base.opsi[46], this);
            return;
        }
        if (view == Add) {
            String string = Nama.getText().toString();
            String string2 = Tikor.getText().toString();
            if (TextUtils.isEmpty(string)) {
                Toast.makeText(this, "Nama Gak boleh Kosong", 0).show();
            } else if (TextUtils.isEmpty(string2)) {
                Toast.makeText(this, "Tikor Gak boleh Kosong", 0).show();
            } else {
                base.add(base.opsi[18], string, string2);
                Dialog.dismiss();
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -3) {
            get().edit().putBoolean(getApplicationInfo().loadLabel(getPackageManager()).toString(), true).apply();
            dialogInterface.dismiss();
        }
    }

    public void Types(String str, RSS.Listener listener) {
        if (get().getBoolean("Food", true)) {
            if (str == base.opsi[0]) {
                Type(str, R.drawable.food, android.R.color.holo_green_dark, android.R.color.white);
                return;
            }
            if (str == base.opsi[1]) {
                Type(str, R.drawable.food, R.color.green, android.R.color.white);
                return;
            } else if (str == base.opsi[2]) {
                Type(str, R.drawable.food, R.color.orange, android.R.color.white);
                return;
            } else {
                if (str == base.opsi[3]) {
                    Type(str, R.drawable.ic_pickup, R.color.blue, android.R.color.white);
                    return;
                }
                return;
            }
        }
        base.Type(str, listener);
    }

    public void Typex(String str, RSS.Listener listener) {
        if (get().getBoolean("Pickup", true)) {
            if (str == base.opsi[46]) {
                Type(str, R.drawable.ic_pickup, R.color.green, android.R.color.white);
                return;
            } else if (str == base.opsi[47]) {
                Type(str, R.drawable.ic_pickup, android.R.color.holo_green_dark, android.R.color.white);
                return;
            } else {
                if (str == base.opsi[48]) {
                    Type(str, R.drawable.ic_pickup, R.color.blue, android.R.color.white);
                    return;
                }
                return;
            }
        }
        base.Type(str, listener);
    }

    @Override // android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 1) {
            Types(base.opsi[0], this);
            Toast.makeText(this, base.opsi[0], 0).show();
        } else if (itemId == 2) {
            Types(base.opsi[1], this);
            Toast.makeText(this, base.opsi[1], 0).show();
        } else if (itemId == 4) {
            Types(base.opsi[2], this);
            Toast.makeText(this, base.opsi[2], 0).show();
        } else if (itemId == 5) {
            Types(base.opsi[3], this);
            Toast.makeText(this, base.opsi[3], 0).show();
        }
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == aMode) {
            if (z) {
                get().edit().putBoolean("Mode", true).apply();
                bMode.setText(base.opsi[39]);
                return;
            } else {
                get().edit().putBoolean("Mode", false).apply();
                bMode.setText(base.opsi[40]);
                return;
            }
        }
        if (compoundButton == aFood) {
            if (z) {
                get().edit().putBoolean("Food", true).apply();
                bFood.setText(base.opsi[56]);
                return;
            } else {
                get().edit().putBoolean("Food", false).apply();
                bFood.setText(base.opsi[57]);
                return;
            }
        }
        if (compoundButton == aPickup) {
            if (z) {
                get().edit().putBoolean("Pickup", true).apply();
                bPickup.setText(base.opsi[56]);
                return;
            } else {
                get().edit().putBoolean("Pickup", false).apply();
                bPickup.setText(base.opsi[57]);
                return;
            }
        }
        if (compoundButton == aType) {
            if (z) {
                get().edit().putBoolean("Type", true).apply();
                bType.setText(base.opsi[41]);
                mMap.setTrafficEnabled(false);
                return;
            } else {
                get().edit().putBoolean("Type", false).apply();
                bType.setText(base.opsi[42]);
                mMap.setTrafficEnabled(true);
                return;
            }
        }
        if (compoundButton == aFloating) {
            if (z) {
                get().edit().putBoolean("Floating", true).apply();
                bFloating.setText(base.opsi[45]);
                return;
            } else {
                get().edit().putBoolean("Floating", false).apply();
                mPermission();
                bFloating.setText(base.opsi[44]);
                return;
            }
        }
        if (compoundButton == aStart) {
            if (z) {
                get().edit().putBoolean("Start", true).apply();
                bStart.setText(base.opsi[45]);
                Start.removeView(dStart);
                Start.removeView(cStart);
                return;
            }
            get().edit().putBoolean("Start", false).apply();
            dStart.setText("Meter " + get().getInt("start", 0));
            cStart.setProgress(get().getInt("start", 0));
            bStart.setText(base.opsi[44]);
            Start.addView(dStart);
            Start.addView(cStart);
            return;
        }
        if (compoundButton == aRandom) {
            if (z) {
                get().edit().putBoolean("Random", true).apply();
                bRandom.setText(base.opsi[45]);
                Random.removeView(dRandom);
                Random.removeView(cRandom);
                return;
            }
            get().edit().putBoolean("Random", false).apply();
            dRandom.setText("Menit " + get().getInt("random", 0));
            cRandom.setProgress(get().getInt("random", 0));
            bRandom.setText(base.opsi[44]);
            Random.addView(dRandom);
            Random.addView(cRandom);
            return;
        }
        if (compoundButton == aAccuracy) {
            if (z) {
                get().edit().putBoolean("Accuracy", true).apply();
                bAccuracy.setText(base.opsi[20]);
                Accuracy.removeView(dAccuracy);
                Accuracy.removeView(cAccuracy);
                return;
            }
            get().edit().putBoolean("Accuracy", false).apply();
            dAccuracy.setText("Meter " + get().getInt("accuracy", 0));
            cAccuracy.setProgress(get().getInt("accuracy", 0));
            bAccuracy.setText(base.opsi[43]);
            Accuracy.addView(dAccuracy);
            Accuracy.addView(cAccuracy);
            return;
        }
        if (compoundButton == aSpeed) {
            if (z) {
                get().edit().putBoolean("Speed", true).apply();
                bSpeed.setText(base.opsi[20]);
                Speed.removeView(dSpeed);
                Speed.removeView(cSpeed);
                return;
            }
            get().edit().putBoolean("Speed", false).apply();
            dSpeed.setText("Meter " + get().getInt("speed", 0));
            cSpeed.setProgress(get().getInt("speed", 0));
            bSpeed.setText(base.opsi[43]);
            Speed.addView(dSpeed);
            Speed.addView(cSpeed);
            return;
        }
        if (compoundButton == aBearing) {
            if (z) {
                get().edit().putBoolean("Bearing", true).apply();
                bBearing.setText(base.opsi[20]);
                Bearing.removeView(dBearing);
                Bearing.removeView(cBearing);
                return;
            }
            get().edit().putBoolean("Bearing", false).apply();
            dBearing.setText("Drajat " + get().getInt("bearing", 0));
            cBearing.setProgress(get().getInt("bearing", 0));
            bBearing.setText(base.opsi[43]);
            Bearing.addView(dBearing);
            Bearing.addView(cBearing);
            return;
        }
        if (compoundButton == aTinggi) {
            if (z) {
                get().edit().putBoolean("Tinggi", true).apply();
                bTinggi.setText(base.opsi[20]);
                Tinggi.removeView(dTinggi);
                Tinggi.removeView(cTinggi);
                return;
            }
            get().edit().putBoolean("Tinggi", false).apply();
            dTinggi.setText("Meter " + get().getInt("tinggi", 0));
            cTinggi.setProgress(get().getInt("tinggi", 0));
            bTinggi.setText(base.opsi[43]);
            Tinggi.addView(dTinggi);
            Tinggi.addView(cTinggi);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (seekBar == cRandom) {
            if (z) {
                get().edit().putInt("random", i / 1).apply();
                dRandom.setText("Menit " + get().getInt("random", 0));
                return;
            }
            return;
        }
        if (seekBar == cStart) {
            if (z) {
                get().edit().putInt("start", i / 1).apply();
                dStart.setText("Meter " + get().getInt("start", 0));
                return;
            }
            return;
        }
        if (seekBar == cAccuracy) {
            if (z) {
                get().edit().putInt("accuracy", i / 1).apply();
                dAccuracy.setText("Meter " + get().getInt("accuracy", 0));
                return;
            }
            return;
        }
        if (seekBar == cSpeed) {
            if (z) {
                get().edit().putInt("speed", i / 1).apply();
                dSpeed.setText("Meter " + get().getInt("speed", 0));
                return;
            }
            return;
        }
        if (seekBar == cBearing) {
            if (z) {
                get().edit().putInt("bearing", i / 1).apply();
                dBearing.setText("Drajat " + get().getInt("bearing", 0));
                return;
            }
            return;
        }
        if (seekBar == cTinggi && z) {
            get().edit().putInt("tinggi", i / 1).apply();
            dTinggi.setText("Meter " + get().getInt("tinggi", 0));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    private void onPermission() {
        if (permission()) {
            this.LocationClient = new LocationClient(this, this);
        } else {
            permission();
        }
    }

    private boolean mPermission() {
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this)) {
            return true;
        }
        startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 1);
        return false;
    }

    private void start() {
        start.setVisibility(8);
        stop.setVisibility(0);
        base.get().edit().putBoolean("mock", true).apply();
    }

    public static void stop() {
        start.setVisibility(0);
        stop.setVisibility(8);
        base.get().edit().putBoolean("mock", false).apply();
    }

    private void onPauses() {
        if (PING() && get().getBoolean(base.opsi[44], true)) {
            onStops(base.onStop(), base.onStops(), base.opsi[52]);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        onPauses();
        onPermission();
        if (get().getBoolean("mock", true)) {
            startService(new Intent(this, (Class<?>) Start.class));
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (get().getBoolean("mock", true)) {
            startService(new Intent(this, (Class<?>) Start.class));
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (get().getBoolean("mock", true)) {
            startService(new Intent(this, (Class<?>) Start.class));
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (get().getBoolean("mock", true)) {
            startService(new Intent(this, (Class<?>) Start.class));
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (get().getBoolean("mock", true)) {
            startService(new Intent(this, (Class<?>) Start.class));
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (get().getBoolean("mock", true)) {
            startService(new Intent(this, (Class<?>) Start.class));
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (get().getBoolean("mock", true)) {
            startService(new Intent(this, (Class<?>) Start.class));
        }
        if (Setting.isDrawerOpen(GravityCompat.START)) {
            Setting.closeDrawer(GravityCompat.START);
        } else if (Info.isDrawerOpen(GravityCompat.END)) {
            Info.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if ((i == 99 && iArr.length <= 0) || iArr[0] != 0) {
            onPermission();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu2) {
        menu2.add(0, 0, 0, base.opsi[7]).setIcon(R.drawable.ic_clear).setShowAsAction(2);
        menu2.add(0, 1, 0, base.opsi[18]);
        menu2.add(0, 2, 0, base.opsi[19]);
        menu2.add(0, 3, 0, base.opsi[20]);
        menu2.add(0, 4, 0, base.opsi[7]).setIcon(android.R.drawable.ic_menu_search).setShowAsAction(2);
        menu2.add(0, 5, 0, base.opsi[53]);
        menu2.add(0, 6, 0, base.opsi[62]);
        return super.onCreateOptionsMenu(menu2);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 0) {
            if (nMarker != null) {
                nMarker.remove();
                mMap.clear();
            }
            Toast.makeText(this, base.opsi[30], 0).show();
        } else if (menuItem.getItemId() == 1) {
            base.Type(base.opsi[18], this);
            Toast.makeText(this, base.opsi[18], 0).show();
        } else if (menuItem.getItemId() == 2) {
            base.Type(base.opsi[19], this);
            Toast.makeText(this, base.opsi[19], 0).show();
        } else if (menuItem.getItemId() == 3) {
            base.Type(base.opsi[20], this);
            Toast.makeText(this, base.opsi[15], 0).show();
        } else if (menuItem.getItemId() == 4) {
            base.Type(base.opsi[13], this);
        } else if (menuItem.getItemId() == 5) {
            Setting.openDrawer(GravityCompat.START);
        } else if (menuItem.getItemId() == 6) {
            Info.openDrawer(GravityCompat.END);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (!get().getBoolean("Floating", true)) {
                mPermission();
            }
        } else if (i == 2023) {
            Camera(PlaceAutocomplete.getPlace(this, intent).getLatLng());
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }
}
