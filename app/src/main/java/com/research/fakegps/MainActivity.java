package com.research.fakegps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.MapEventsOverlay;
import org.osmdroid.events.MapEventsReceiver;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;

    private EditText editLatitude;
    private EditText editLongitude;
    private Button btnSetLocation;
    private Button btnStopFake;
    private Button btnSaveFavorite;
    private Button btnViewFavorites;
    private TextView tvStatus;
    private TextView tvRootStatus;
    private MapView mapView;
    private Marker selectedMarker;

    private GPSInjector gpsInjector;
    private RootChecker rootChecker;
    private DatabaseHelper dbHelper;

    private static final double DEFAULT_LAT = -6.2088;
    private static final double DEFAULT_LON = 106.8456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        Configuration.getInstance().setUserAgentValue(getPackageName());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initMap();
        initManagers();
        requestPermissions();
        checkRootStatus();
        setupListeners();
    }

    private void initViews() {
        editLatitude     = findViewById(R.id.edit_latitude);
        editLongitude    = findViewById(R.id.edit_longitude);
        btnSetLocation   = findViewById(R.id.btn_set_location);
        btnStopFake      = findViewById(R.id.btn_stop_fake);
        btnSaveFavorite  = findViewById(R.id.btn_save_favorite);
        btnViewFavorites = findViewById(R.id.btn_view_favorites);
        tvStatus         = findViewById(R.id.tv_status);
        tvRootStatus     = findViewById(R.id.tv_root_status);
        mapView          = findViewById(R.id.map_view);

        editLatitude.setText(String.valueOf(DEFAULT_LAT));
        editLongitude.setText(String.valueOf(DEFAULT_LON));
    }

    private void initMap() {
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);
        mapView.setBuiltInZoomControls(true);
        mapView.getController().setZoom(15.0);
        mapView.getController().setCenter(new GeoPoint(DEFAULT_LAT, DEFAULT_LON));

        selectedMarker = new Marker(mapView);
        selectedMarker.setPosition(new GeoPoint(DEFAULT_LAT, DEFAULT_LON));
        selectedMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        selectedMarker.setTitle("Lokasi Fake GPS");
        mapView.getOverlays().add(selectedMarker);

        MapEventsReceiver mapEventsReceiver = new MapEventsReceiver() {
            @Override
            public boolean singleTapConfirmedHelper(GeoPoint p) {
                updateSelectedLocation(p.getLatitude(), p.getLongitude());
                return true;
            }

            @Override
            public boolean longPressHelper(GeoPoint p) {
                return false;
            }
        };
        mapView.getOverlays().add(0, new MapEventsOverlay(mapEventsReceiver));
    }

    private void updateSelectedLocation(double lat, double lon) {
        editLatitude.setText(String.format("%.6f", lat));
        editLongitude.setText(String.format("%.6f", lon));

        GeoPoint point = new GeoPoint(lat, lon);
        selectedMarker.setPosition(point);
        mapView.getController().animateTo(point);
        mapView.invalidate();
    }

    private void initManagers() {
        gpsInjector = new GPSInjector(this);
        rootChecker = new RootChecker();
        dbHelper    = new DatabaseHelper(this);
    }

    private void checkRootStatus() {
        boolean isRooted = rootChecker.isDeviceRooted();

        if (isRooted) {
            tvRootStatus.setText("● Siap");
            tvRootStatus.setTextColor(0xFF69F0AE);
            btnSetLocation.setEnabled(true);
        } else {
            tvRootStatus.setText("● Tidak ada root");
            tvRootStatus.setTextColor(0xFFFF6E6E);
            btnSetLocation.setEnabled(false);
        }
    }

    private void requestPermissions() {
        String[] permissions = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        };
        ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
    }

    private void setupListeners() {
        btnSetLocation.setOnClickListener(v -> setFakeLocation());
        btnStopFake.setOnClickListener(v -> stopFakeLocation());
        btnSaveFavorite.setOnClickListener(v -> showSaveFavoriteDialog());
        btnViewFavorites.setOnClickListener(v -> showFavoritesDialog());
    }

    // ── Favorites ────────────────────────────────────────────────────────────

    private void showSaveFavoriteDialog() {
        String latStr = editLatitude.getText().toString();
        String lonStr = editLongitude.getText().toString();

        if (latStr.isEmpty() || lonStr.isEmpty()) {
            Toast.makeText(this, "Pilih lokasi terlebih dahulu.", Toast.LENGTH_SHORT).show();
            return;
        }

        final double lat;
        final double lon;
        try {
            lat = Double.parseDouble(latStr);
            lon = Double.parseDouble(lonStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Koordinat tidak valid.", Toast.LENGTH_SHORT).show();
            return;
        }

        final EditText nameInput = new EditText(this);
        nameInput.setHint("Nama lokasi (contoh: Kantor BKD)");

        int dp = (int) (getResources().getDisplayMetrics().density * 20);
        FrameLayout container = new FrameLayout(this);
        container.setPadding(dp, dp / 2, dp, 0);
        container.addView(nameInput);

        new MaterialAlertDialogBuilder(this)
            .setTitle("Simpan Lokasi Favorit")
            .setView(container)
            .setPositiveButton("Simpan", (dialog, which) -> {
                String name = nameInput.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(this, "Nama tidak boleh kosong.", Toast.LENGTH_SHORT).show();
                    return;
                }
                long id = dbHelper.insert(name, lat, lon);
                if (id != -1) {
                    Toast.makeText(this, "\"" + name + "\" disimpan ke favorit.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Gagal menyimpan favorit.", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Batal", null)
            .show();
    }

    private void showFavoritesDialog() {
        List<FavoriteLocation> favorites = dbHelper.getAll();

        if (favorites.isEmpty()) {
            Toast.makeText(this, "Belum ada lokasi favorit.", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] items = new String[favorites.size()];
        for (int i = 0; i < favorites.size(); i++) {
            items[i] = favorites.get(i).toString();
        }

        new MaterialAlertDialogBuilder(this)
            .setTitle("Lokasi Favorit")
            .setItems(items, (dialog, which) -> {
                FavoriteLocation selected = favorites.get(which);
                updateSelectedLocation(selected.getLatitude(), selected.getLongitude());
                mapView.getController().setZoom(16.0);
                Toast.makeText(this, "Navigasi ke: " + selected.getName(), Toast.LENGTH_SHORT).show();
            })
            .setNeutralButton("Hapus...", (dialog, which) -> showDeleteFavoriteDialog(favorites))
            .setNegativeButton("Tutup", null)
            .show();
    }

    private void showDeleteFavoriteDialog(List<FavoriteLocation> favorites) {
        String[] items = new String[favorites.size()];
        for (int i = 0; i < favorites.size(); i++) {
            items[i] = favorites.get(i).toString();
        }

        new MaterialAlertDialogBuilder(this)
            .setTitle("Hapus Favorit")
            .setItems(items, (dialog, which) -> {
                FavoriteLocation toDelete = favorites.get(which);
                new MaterialAlertDialogBuilder(this)
                    .setTitle("Konfirmasi Hapus")
                    .setMessage("Hapus \"" + toDelete.getName() + "\"?")
                    .setPositiveButton("Hapus", (d, w) -> {
                        dbHelper.delete(toDelete.getId());
                        Toast.makeText(this, "\"" + toDelete.getName() + "\" dihapus.", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Batal", null)
                    .show();
            })
            .setNegativeButton("Batal", null)
            .show();
    }

    // ── GPS Injection ─────────────────────────────────────────────────────────

    private void setFakeLocation() {
        String latStr = editLatitude.getText().toString();
        String lonStr = editLongitude.getText().toString();

        if (latStr.isEmpty() || lonStr.isEmpty()) {
            Toast.makeText(this, "Pilih lokasi di peta atau isi koordinat!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double latitude  = Double.parseDouble(latStr);
            double longitude = Double.parseDouble(lonStr);

            if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
                Toast.makeText(this, "Koordinat tidak valid!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean success = gpsInjector.setFakeLocation(latitude, longitude);

            if (success) {
                tvStatus.setText("Status: AKTIF - Fake GPS berjalan");
                tvStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                btnStopFake.setEnabled(true);
                Toast.makeText(this,
                    String.format("Fake GPS aktif: %.6f, %.6f", latitude, longitude),
                    Toast.LENGTH_LONG).show();
            } else {
                tvStatus.setText("Status: GAGAL - Cek akses root");
                tvStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Format angka tidak valid!", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopFakeLocation() {
        boolean success = gpsInjector.stopFakeLocation();

        if (success) {
            tvStatus.setText("Status: BERHENTI - GPS asli aktif");
            tvStatus.setTextColor(getResources().getColor(android.R.color.darker_gray));
            btnStopFake.setEnabled(false);
            Toast.makeText(this, "Fake GPS dihentikan.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Gagal menghentikan fake GPS!", Toast.LENGTH_SHORT).show();
        }
    }

    // ── Lifecycle ─────────────────────────────────────────────────────────────

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gpsInjector.cleanup();
        dbHelper.close();
    }
}
