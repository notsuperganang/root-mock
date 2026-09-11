package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ReportFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.SimpleArrayMap;
import android.widget.Toast;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.zza;
import com.tiket.git.base;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SupportActivity extends Activity implements LifecycleOwner {
    private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap = new SimpleArrayMap<>();
    public String[] opsi = {Base64Utils.zza("aHR0cHM6Ly90Lm1lL1JlYWxHUFM="), Base64Utils.zza("b3JnLnRlbGVncmFtLm1lc3Nlbmdlcg==")};
    private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class ExtraData {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public <T extends ExtraData> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
        Opsi(2);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
        Opsi(2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void putExtraData(ExtraData extraData) {
        this.mExtraDataMap.put((Class<? extends ExtraData>) extraData.getClass(), extraData);
    }

    public String prefs(String str) {
        return get().getString(str, base.opsi[65]);
    }

    public void Opsi() {
        if (get().getBoolean(base.opsi[45], true)) {
            base.alert(this, null, 0);
        } else if (!PING()) {
            Toast.makeText(this, base.opsi[66], 0).show();
        }
    }

    public boolean PING() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public boolean permission() {
        return ActivityCompat.permission(this);
    }

    public SharedPreferences get() {
        return ActivityCompat.prefs(this);
    }

    public void Join() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.opsi[0]));
            intent.setPackage(this.opsi[1]);
            startActivity(intent);
        } catch (Exception e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.opsi[0])));
        }
    }

    public void Opsi(int i) {
        if (i == 1) {
            ActivityCompat.startActivity(this);
        } else if (i == 2) {
            Opsi();
            zza.zze(this);
        }
    }
}
