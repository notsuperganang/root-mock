package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class zzat {
    private static int zzcj = 0;
    private static PendingIntent zzcv;
    private final Context zzac;
    private final zzan zzas;

    @GuardedBy("responseCallbacks")
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzcw = new SimpleArrayMap<>();
    private Messenger zzcx = new Messenger(new zzau(this, Looper.getMainLooper()));
    private Messenger zzcy;
    private zzl zzcz;

    public zzat(Context context, zzan zzanVar) {
        this.zzac = context;
        this.zzas = zzanVar;
    }

    private static void zza(Context context, Intent intent) {
        synchronized (zzat.class) {
            try {
                if (zzcv == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    zzcv = PendingIntent.getBroadcast(context, 0, intent2, 0);
                }
                intent.putExtra("app", zzcv);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zza(String str, Bundle bundle) {
        synchronized (this.zzcw) {
            TaskCompletionSource<Bundle> taskCompletionSourceRemove = this.zzcw.remove(str);
            if (taskCompletionSourceRemove != null) {
                taskCompletionSourceRemove.setResult(bundle);
            } else {
                String strValueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", strValueOf.length() != 0 ? "Missing callback for ".concat(strValueOf) : new String("Missing callback for "));
            }
        }
    }

    private static String zzah() {
        String string;
        synchronized (zzat.class) {
            try {
                int i = zzcj;
                zzcj = i + 1;
                string = Integer.toString(i);
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(new zzl.zza());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof zzl) {
                this.zzcz = (zzl) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.zzcy = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(action);
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Unexpected response action: ".concat(strValueOf) : new String("Unexpected response action: "));
                return;
            }
            return;
        }
        String stringExtra = intent2.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent2.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (!matcher.matches()) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String strValueOf2 = String.valueOf(stringExtra);
                    Log.d("FirebaseInstanceId", strValueOf2.length() != 0 ? "Unexpected response string: ".concat(strValueOf2) : new String("Unexpected response string: "));
                    return;
                }
                return;
            }
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            Bundle extras = intent2.getExtras();
            extras.putString("registration_id", strGroup2);
            zza(strGroup, extras);
            return;
        }
        String stringExtra2 = intent2.getStringExtra("error");
        if (stringExtra2 == null) {
            String strValueOf3 = String.valueOf(intent2.getExtras());
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf3).length() + 49).append("Unexpected response, no error or registration id ").append(strValueOf3).toString());
            return;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf4 = String.valueOf(stringExtra2);
            Log.d("FirebaseInstanceId", strValueOf4.length() != 0 ? "Received InstanceID error ".concat(strValueOf4) : new String("Received InstanceID error "));
        }
        if (!stringExtra2.startsWith("|")) {
            synchronized (this.zzcw) {
                for (int i = 0; i < this.zzcw.size(); i++) {
                    zza(this.zzcw.keyAt(i), intent2.getExtras());
                }
            }
            return;
        }
        String[] strArrSplit = stringExtra2.split("\\|");
        if (strArrSplit.length <= 2 || !"ID".equals(strArrSplit[1])) {
            String strValueOf5 = String.valueOf(stringExtra2);
            Log.w("FirebaseInstanceId", strValueOf5.length() != 0 ? "Unexpected structured response ".concat(strValueOf5) : new String("Unexpected structured response "));
            return;
        }
        String str = strArrSplit[2];
        String strSubstring = strArrSplit[3];
        if (strSubstring.startsWith(":")) {
            strSubstring = strSubstring.substring(1);
        }
        zza(str, intent2.putExtra("error", strSubstring).getExtras());
    }

    private final Bundle zzd(Bundle bundle) throws IOException {
        Bundle bundleZze = zze(bundle);
        if (bundleZze == null || !bundleZze.containsKey("google.messenger")) {
            return bundleZze;
        }
        Bundle bundleZze2 = zze(bundle);
        if (bundleZze2 == null || !bundleZze2.containsKey("google.messenger")) {
            return bundleZze2;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:43:0x0101  */
    private final Bundle zze(Bundle bundle) throws IOException {
        String strZzah = zzah();
        TaskCompletionSource<Bundle> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.zzcw) {
            this.zzcw.put(strZzah, taskCompletionSource);
        }
        if (this.zzas.zzac() == 0) {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.zzas.zzac() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        zza(this.zzac, intent);
        intent.putExtra("kid", new StringBuilder(String.valueOf(strZzah).length() + 5).append("|ID|").append(strZzah).append("|").toString());
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 8).append("Sending ").append(strValueOf).toString());
        }
        intent.putExtra("google.messenger", this.zzcx);
        if (this.zzcy != null || this.zzcz != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                if (this.zzcy != null) {
                    this.zzcy.send(messageObtain);
                } else {
                    this.zzcz.send(messageObtain);
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "Messenger failed, fallback to startService");
                }
                if (this.zzas.zzac() == 2) {
                    this.zzac.sendBroadcast(intent);
                } else {
                    this.zzac.startService(intent);
                }
            }
        } else if (this.zzas.zzac() == 2) {
            this.zzac.sendBroadcast(intent);
        } else {
            this.zzac.startService(intent);
        }
        try {
            try {
                Bundle bundle2 = (Bundle) Tasks.await(taskCompletionSource.getTask(), 30000L, TimeUnit.MILLISECONDS);
                synchronized (this.zzcw) {
                    this.zzcw.remove(strZzah);
                }
                return bundle2;
            } catch (InterruptedException e2) {
                Log.w("FirebaseInstanceId", "No response");
                throw new IOException("TIMEOUT");
            } catch (ExecutionException e3) {
                throw new IOException(e3);
            } catch (TimeoutException e4) {
                Log.w("FirebaseInstanceId", "No response");
                throw new IOException("TIMEOUT");
            }
        } catch (Throwable th) {
            synchronized (this.zzcw) {
                this.zzcw.remove(strZzah);
                throw th;
            }
        }
    }

    final Bundle zzc(Bundle bundle) throws IOException {
        if (this.zzas.zzaf() < 12000000) {
            return zzd(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzab.zzc(this.zzac).zzb(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 22).append("Error making request: ").append(strValueOf).toString());
            }
            if ((e.getCause() instanceof zzal) && ((zzal) e.getCause()).getErrorCode() == 4) {
                return zzd(bundle);
            }
            return null;
        }
    }
}
