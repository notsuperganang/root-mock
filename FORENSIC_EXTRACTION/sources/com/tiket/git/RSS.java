package com.tiket.git;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.android.volley.toolbox.ImageLoaders;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RSS extends AppCompatActivity implements ActionBar.TabListener, View.OnClickListener, SearchView.OnQueryTextListener, Req.Response {
    public static RecyclerView List;
    private AppCompatButton Add;
    private BottomSheetDialog Dialog;
    private AppCompatEditText Nama;
    private SearchView Search;
    private AppCompatEditText Tikor;
    private String Type;
    private ProgressDialog notice;
    private Listener response;

    public interface Listener extends Serializable {
        void onResponse(String str, String str2);
    }

    public class Feed extends RecyclerView.Adapter<List> {
        private String Type;
        private AppCompatImageView img;
        ArrayList<HashMap<String, String>> mMap;
        private Listener response;

        public class List extends RecyclerView.ViewHolder implements View.OnClickListener {
            public AppCompatTextView Alamat;
            public AppCompatImageView Delete;
            public AppCompatImageView Img;
            public LinearLayoutCompat Layout;
            public AppCompatImageView Marker;
            public AppCompatTextView Nama;
            public AppCompatTextView Opsi;
            public AppCompatImageView Random;
            public AppCompatImageView Save;
            public AppCompatTextView Tikor;
            private String Type;
            public LinearLayoutCompat aLayout;
            public LinearLayoutCompat bLayout;
            public LinearLayoutCompat cLayout;
            private ProgressDialog notice;
            private boolean okeSave;
            private Listener response;

            public List(FrameLayout frameLayout, String str, Listener listener) {
                super(frameLayout);
                this.response = listener;
                this.Type = str;
                LinearLayoutCompat.LayoutParams size = base.size(-1, base.size(1));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388693);
                this.Layout = new LinearLayoutCompat(frameLayout.getContext());
                this.aLayout = new LinearLayoutCompat(frameLayout.getContext());
                this.bLayout = new LinearLayoutCompat(frameLayout.getContext());
                this.cLayout = new LinearLayoutCompat(frameLayout.getContext());
                this.Img = new AppCompatImageView(frameLayout.getContext());
                this.Nama = new AppCompatTextView(frameLayout.getContext());
                this.Alamat = new AppCompatTextView(frameLayout.getContext());
                this.Tikor = new AppCompatTextView(frameLayout.getContext());
                this.Opsi = new AppCompatTextView(frameLayout.getContext());
                this.Random = new AppCompatImageView(frameLayout.getContext());
                this.Delete = new AppCompatImageView(frameLayout.getContext());
                this.Save = new AppCompatImageView(frameLayout.getContext());
                this.Marker = new AppCompatImageView(frameLayout.getContext());
                View view = new View(frameLayout.getContext());
                this.Nama.setTypeface(this.Nama.getTypeface(), 1);
                this.Nama.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.Alamat.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.Tikor.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.Opsi.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.Tikor.setTextSize(base.size(3));
                view.setBackgroundColor(ContextCompat.getColor(frameLayout.getContext(), android.R.color.black));
                this.Marker.setImageDrawable(ContextCompat.getDrawable(frameLayout.getContext(), android.R.drawable.ic_menu_mylocation));
                this.Random.setImageDrawable(ContextCompat.getDrawable(frameLayout.getContext(), android.R.drawable.ic_menu_rotate));
                this.Delete.setImageDrawable(ContextCompat.getDrawable(frameLayout.getContext(), android.R.drawable.ic_menu_delete));
                this.Save.setImageDrawable(ContextCompat.getDrawable(frameLayout.getContext(), android.R.drawable.ic_menu_save));
                this.Img.setPadding(base.size(5), base.size(5), base.size(10), base.size(5));
                this.Nama.setPadding(base.size(5), base.size(0), base.size(5), base.size(8));
                this.Alamat.setPadding(base.size(5), base.size(0), base.size(5), base.size(8));
                this.Tikor.setPadding(base.size(5), base.size(5), base.size(5), base.size(5));
                this.Opsi.setPadding(base.size(5), base.size(5), base.size(5), base.size(5));
                this.Delete.setPadding(base.size(5), base.size(5), base.size(5), base.size(5));
                this.Save.setPadding(base.size(5), base.size(5), base.size(5), base.size(5));
                this.Random.setPadding(base.size(5), base.size(5), base.size(50), base.size(5));
                view.setLayoutParams(size);
                this.Random.setLayoutParams(layoutParams);
                this.Delete.setLayoutParams(layoutParams);
                this.Save.setLayoutParams(layoutParams);
                this.bLayout.addView(this.Nama);
                if (this.Type.equals(base.opsi[46]) || this.Type.equals(base.opsi[47]) || this.Type.equals(base.opsi[48]) || this.Type.equals(base.opsi[13])) {
                    this.bLayout.addView(this.Alamat);
                }
                if (!this.Type.equals(base.opsi[18]) && !this.Type.equals(base.opsi[19]) && !this.Type.equals(base.opsi[20]) && !this.Type.equals(base.opsi[46]) && !this.Type.equals(base.opsi[47]) && !this.Type.equals(base.opsi[48]) && !this.Type.equals(base.opsi[13])) {
                    this.aLayout.addView(this.Img);
                    this.bLayout.addView(this.Opsi);
                }
                this.cLayout.addView(this.Marker);
                this.cLayout.addView(this.Tikor);
                this.aLayout.setOrientation(0);
                this.cLayout.setOrientation(0);
                this.bLayout.setOrientation(1);
                this.Layout.setOrientation(1);
                this.aLayout.addView(this.bLayout);
                this.Layout.addView(this.aLayout);
                this.Layout.addView(this.cLayout);
                this.Layout.addView(view);
                frameLayout.addView(this.Layout);
                if (!this.Type.equals(base.opsi[18]) && !this.Type.equals(base.opsi[19]) && !this.Type.equals(base.opsi[20])) {
                    frameLayout.addView(this.Random);
                    frameLayout.addView(this.Save);
                } else if (this.Type.equals(base.opsi[18])) {
                    frameLayout.addView(this.Random);
                    frameLayout.addView(this.Delete);
                } else if (this.Type.equals(base.opsi[19])) {
                    frameLayout.addView(this.Save);
                } else if (this.Type.equals(base.opsi[20])) {
                    frameLayout.addView(this.Delete);
                }
                this.Layout.setOnClickListener(this);
                this.Random.setOnClickListener(this);
                this.Delete.setOnClickListener(this);
                this.Save.setOnClickListener(this);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == this.Layout) {
                    this.response.onResponse(this.Tikor.getText().toString(), this.Nama.getText().toString());
                    ((Activity) view.getContext()).finish();
                    return;
                }
                if (view == this.Save) {
                    if (this.Type.equals(base.opsi[19])) {
                        RSS.this.Save(view.getContext(), this.Nama.getText().toString(), this.Tikor.getText().toString());
                        return;
                    } else {
                        base.add(base.opsi[18], this.Nama.getText().toString(), this.Tikor.getText().toString());
                        return;
                    }
                }
                if (view == this.Delete) {
                    base.delete(this.Type, this.Nama.getText().toString(), this.Tikor.getText().toString());
                    RSS.List.setAdapter(RSS.this.new Feed(base.List(this.Type), this.Type, this.response));
                } else if (view == this.Random) {
                    base.add(base.opsi[20], this.Nama.getText().toString(), this.Tikor.getText().toString());
                }
            }
        }

        public Feed(ArrayList<HashMap<String, String>> arrayList, String str, Listener listener) {
            this.mMap = new ArrayList<>();
            this.mMap = arrayList;
            this.response = listener;
            this.Type = str;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mMap.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public List onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            frameLayout.setLayoutParams(layoutParams);
            layoutParams.setMargins(base.size(10), base.size(10), base.size(10), base.size(10));
            return new List(frameLayout, this.Type, this.response);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(List list, int i) {
            new ImageLoaders(this.mMap.get(i).get(base.opsi[5]), list.Img);
            list.Nama.setText(this.mMap.get(i).get(base.opsi[4]));
            list.Alamat.setText(this.mMap.get(i).get(base.opsi[5]));
            list.Tikor.setText(this.mMap.get(i).get(base.opsi[6]));
            list.Opsi.setText(this.mMap.get(i).get(base.opsi[7]));
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Type = getIntent().getExtras().getString(base.opsi[22]);
        this.response = (Listener) getIntent().getSerializableExtra(base.opsi[7]);
        setTitle(this.Type);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.Search = new SearchView(this);
        this.Search.setQueryHint(base.opsi[26]);
        List = new RecyclerView(this);
        List.setLayoutManager(new LinearLayoutManager(List.getContext()));
        LinearLayoutCompat.LayoutParams size = base.size(-1, -2);
        size.setMargins(base.size(10), base.size(10), base.size(10), base.size(10));
        List.setLayoutParams(size);
        relativeLayout.setLayoutParams(base.size(-1, -1));
        this.notice = new ProgressDialog(this);
        this.notice.setMessage(base.opsi[21]);
        if (this.Type.equals(base.opsi[18]) || this.Type.equals(base.opsi[19]) || this.Type.equals(base.opsi[20])) {
            List.setAdapter(new Feed(base.List(this.Type), this.Type, this.response));
        } else if (this.Type.equals(base.opsi[3])) {
            if (!this.notice.isShowing()) {
                this.notice.show();
            }
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setDisplayShowTitleEnabled(false);
            supportActionBar.setNavigationMode(2);
            supportActionBar.addTab(supportActionBar.newTab().setText(base.opsi[67]).setTabListener(this));
            supportActionBar.addTab(supportActionBar.newTab().setText(base.opsi[68]).setTabListener(this));
            supportActionBar.addTab(supportActionBar.newTab().setText(base.opsi[69]).setTabListener(this));
            supportActionBar.addTab(supportActionBar.newTab().setText(base.opsi[70]).setTabListener(this));
            supportActionBar.addTab(supportActionBar.newTab().setText(base.opsi[71]).setTabListener(this));
        } else {
            if (!this.notice.isShowing()) {
                this.notice.show();
            }
            new Req(this, this, base.opsi(1, this.Type, base.Tikor(), null), 1, 0, 0, null);
        }
        this.Search.setOnQueryTextListener(this);
        relativeLayout.addView(List);
        setContentView(relativeLayout);
    }

    @Override // android.support.v7.app.ActionBar.TabListener
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int position = tab.getPosition();
        if (position == 0) {
            new Req(this, this, base.opsi(1, base.opsi[67], base.Tikor(), null), 1, 0, 0, null);
            return;
        }
        if (position == 1) {
            new Req(this, this, base.opsi(1, base.opsi[68], base.Tikor(), null), 1, 0, 0, null);
            return;
        }
        if (position == 2) {
            new Req(this, this, base.opsi(1, base.opsi[69], base.Tikor(), null), 1, 0, 0, null);
        } else if (position == 3) {
            new Req(this, this, base.opsi(1, base.opsi[70], base.Tikor(), null), 1, 0, 0, null);
        } else if (position == 4) {
            new Req(this, this, base.opsi(1, base.opsi[71], base.Tikor(), null), 1, 0, 0, null);
        }
    }

    @Override // android.support.v7.app.ActionBar.TabListener
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override // android.support.v7.app.ActionBar.TabListener
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override // android.support.v7.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        if (!this.notice.isShowing()) {
            this.notice.show();
        }
        new Req(this, this, base.opsi(3, this.Type, base.Tikor(), str), 3, 0, 0, null);
        return true;
    }

    @Override // android.support.v7.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        return false;
    }

    @Override // com.tiket.git.Req.Response
    public void Response(JSONObject jSONObject, int i, int i2, int i3, String str) {
        if (i == 1) {
            List.setAdapter(new Feed(base.getFeed(jSONObject, this.notice), this.Type, this.response));
        } else if (i == 3) {
            List.setAdapter(new Feed(base.getFeed(jSONObject, this.notice), this.Type, this.response));
        }
    }

    public void Save(Context context, String str, String str2) {
        this.Dialog = new BottomSheetDialog(context, R.style.BottomSheet);
        LinearLayoutCompat.LayoutParams size = base.size(-1, -2);
        LinearLayoutCompat.LayoutParams size2 = base.size(-1, base.size(40));
        size.setMargins(base.size(20), base.size(20), base.size(20), base.size(20));
        size2.setMargins(base.size(20), base.size(10), base.size(20), base.size(20));
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
        this.Nama = new AppCompatEditText(context);
        this.Tikor = new AppCompatEditText(context);
        this.Add = new AppCompatButton(context);
        this.Add.setText(base.opsi[50]);
        if (str == null) {
            this.Nama.setHint(base.opsi[4]);
        } else {
            this.Nama.setText(str);
        }
        if (str2 == null) {
            this.Tikor.setHint(base.opsi[6]);
        } else {
            this.Tikor.setText(str2);
        }
        this.Nama.setTextColor(R.dimen.action_button_size);
        this.Tikor.setTextColor(R.dimen.action_button_size);
        this.Add.setTextColor(-1);
        linearLayoutCompat.setLayoutParams(size);
        this.Nama.setLayoutParams(size2);
        this.Add.setLayoutParams(size2);
        this.Tikor.setLayoutParams(size2);
        this.Add.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        this.Nama.setBackground(base.Color(R.color.colorPrimary));
        this.Tikor.setBackground(base.Color(R.color.colorPrimary));
        this.Nama.setPadding(base.size(10), base.size(10), base.size(10), base.size(10));
        this.Tikor.setPadding(base.size(10), base.size(10), base.size(10), base.size(10));
        this.Add.setPadding(base.size(10), base.size(10), base.size(10), base.size(10));
        linearLayoutCompat.setOrientation(1);
        linearLayoutCompat.addView(this.Nama);
        linearLayoutCompat.addView(this.Tikor);
        linearLayoutCompat.addView(this.Add);
        this.Dialog.setContentView(linearLayoutCompat);
        this.Dialog.show();
        this.Add.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.Add) {
            String string = this.Nama.getText().toString();
            String string2 = this.Tikor.getText().toString();
            if (TextUtils.isEmpty(string)) {
                Toast.makeText(view.getContext(), "Nama Gak boleh Kosong", 0).show();
            } else {
                if (TextUtils.isEmpty(string2)) {
                    Toast.makeText(view.getContext(), "Tikor Gak boleh Kosong", 0).show();
                    return;
                }
                base.add(base.opsi[18], string, string2);
                List.setAdapter(new Feed(base.List(this.Type), this.Type, this.response));
                this.Dialog.dismiss();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!this.Type.equals(base.opsi[18]) && !this.Type.equals(base.opsi[19]) && !this.Type.equals(base.opsi[20])) {
            menu.add(base.opsi[7]).setActionView(this.Search).setShowAsAction(2);
        } else {
            menu.add(0, 0, 0, base.opsi[7]).setIcon(R.drawable.ic_clear).setShowAsAction(2);
        }
        if (this.Type.equals(base.opsi[18])) {
            menu.add(0, 1, 0, base.opsi[7]).setIcon(android.R.drawable.ic_menu_add).setShowAsAction(2);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 0) {
            base.clear(this.Type);
            List.setAdapter(new Feed(base.List(this.Type), this.Type, this.response));
            Toast.makeText(this, this.Type + " " + base.opsi[27], 0).show();
        } else if (menuItem.getItemId() == 1) {
            Save(this, null, null);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
