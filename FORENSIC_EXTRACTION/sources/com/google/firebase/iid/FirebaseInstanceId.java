package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseInstanceId {
    private static final long zzan = TimeUnit.HOURS.toSeconds(8);
    private static zzaw zzao;

    @VisibleForTesting
    @GuardedBy("FirebaseInstanceId.class")
    private static ScheduledThreadPoolExecutor zzap;
    private final Executor zzaq;
    private final FirebaseApp zzar;
    private final zzan zzas;
    private MessagingChannel zzat;
    private final zzaq zzau;
    private final zzba zzav;

    @GuardedBy("this")
    private boolean zzaw;
    private final zza zzax;

    /* JADX INFO: Access modifiers changed from: private */
    final class zza {
        private final Subscriber zzbe;

        @GuardedBy("this")
        @Nullable
        private EventHandler<DataCollectionDefaultChange> zzbf;
        private final boolean zzbd = zzu();

        @GuardedBy("this")
        @Nullable
        private Boolean zzbg = zzt();

        zza(Subscriber subscriber) {
            this.zzbe = subscriber;
            if (this.zzbg == null && this.zzbd) {
                this.zzbf = new EventHandler(this) { // from class: com.google.firebase.iid.zzq
                    private final FirebaseInstanceId.zza zzbi;

                    {
                        this.zzbi = this;
                    }

                    @Override // com.google.firebase.events.EventHandler
                    public final void handle(Event event) {
                        FirebaseInstanceId.zza zzaVar = this.zzbi;
                        synchronized (zzaVar) {
                            if (zzaVar.isEnabled()) {
                                FirebaseInstanceId.this.zzh();
                            }
                        }
                    }
                };
                subscriber.subscribe(DataCollectionDefaultChange.class, this.zzbf);
            }
        }

        @Nullable
        private final Boolean zzt() {
            ApplicationInfo applicationInfo;
            Context applicationContext = FirebaseInstanceId.this.zzar.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
            return null;
        }

        private final boolean zzu() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException e) {
                Context applicationContext = FirebaseInstanceId.this.zzar.getApplicationContext();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(applicationContext.getPackageName());
                ResolveInfo resolveInfoResolveService = applicationContext.getPackageManager().resolveService(intent, 0);
                return (resolveInfoResolveService == null || resolveInfoResolveService.serviceInfo == null) ? false : true;
            }
        }

        final boolean isEnabled() {
            boolean zBooleanValue;
            synchronized (this) {
                if (this.zzbg != null) {
                    zBooleanValue = this.zzbg.booleanValue();
                } else {
                    zBooleanValue = this.zzbd && FirebaseInstanceId.this.zzar.isDataCollectionDefaultEnabled();
                }
            }
            return zBooleanValue;
        }

        final void setEnabled(boolean z) {
            synchronized (this) {
                if (this.zzbf != null) {
                    this.zzbe.unsubscribe(DataCollectionDefaultChange.class, this.zzbf);
                    this.zzbf = null;
                }
                SharedPreferences.Editor editorEdit = FirebaseInstanceId.this.zzar.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
                editorEdit.putBoolean("auto_init", z);
                editorEdit.apply();
                if (z) {
                    FirebaseInstanceId.this.zzh();
                }
                this.zzbg = Boolean.valueOf(z);
            }
        }
    }

    FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber, UserAgentPublisher userAgentPublisher) {
        this(firebaseApp, new zzan(firebaseApp.getApplicationContext()), zzi.zzg(), zzi.zzg(), subscriber, userAgentPublisher);
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzan zzanVar, Executor executor, Executor executor2, Subscriber subscriber, UserAgentPublisher userAgentPublisher) {
        this.zzaw = false;
        if (zzan.zza(firebaseApp) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            try {
                if (zzao == null) {
                    zzao = new zzaw(firebaseApp.getApplicationContext());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.zzar = firebaseApp;
        this.zzas = zzanVar;
        if (this.zzat == null) {
            MessagingChannel messagingChannel = (MessagingChannel) firebaseApp.get(MessagingChannel.class);
            if (messagingChannel == null || !messagingChannel.isAvailable()) {
                this.zzat = new zzr(firebaseApp, zzanVar, executor, userAgentPublisher);
            } else {
                this.zzat = messagingChannel;
            }
        }
        this.zzat = this.zzat;
        this.zzaq = executor2;
        this.zzav = new zzba(zzao);
        this.zzax = new zza(subscriber);
        this.zzau = new zzaq(executor);
        if (this.zzax.isEnabled()) {
            zzh();
        }
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
    }

    private final void startSync() {
        synchronized (this) {
            if (!this.zzaw) {
                zza(0L);
            }
        }
    }

    private final Task<InstanceIdResult> zza(final String str, String str2) {
        final String strZzd = zzd(str2);
        return Tasks.forResult(null).continueWithTask(this.zzaq, new Continuation(this, str, strZzd) { // from class: com.google.firebase.iid.zzn
            private final FirebaseInstanceId zzay;
            private final String zzaz;
            private final String zzba;

            {
                this.zzay = this;
                this.zzaz = str;
                this.zzba = strZzd;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zzay.zza(this.zzaz, this.zzba, task);
            }
        });
    }

    private final <T> T zza(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    zzn();
                }
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        } catch (TimeoutException e3) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    static void zza(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            try {
                if (zzap == null) {
                    zzap = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
                }
                zzap.schedule(runnable, j, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    @Nullable
    private static zzax zzb(String str, String str2) {
        return zzao.zzb("", str, str2);
    }

    private static String zzd(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN) || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh() {
        zzax zzaxVarZzk = zzk();
        if (zzr() || zza(zzaxVarZzk) || this.zzav.zzap()) {
            startSync();
        }
    }

    private static String zzj() {
        return zzan.zza(zzao.zzg("").getKeyPair());
    }

    static boolean zzm() {
        return Log.isLoggable("FirebaseInstanceId", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3));
    }

    @WorkerThread
    public void deleteInstanceId() throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zza(this.zzat.deleteInstanceId(zzj()));
        zzn();
    }

    @WorkerThread
    public void deleteToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String strZzd = zzd(str2);
        zza(this.zzat.deleteToken(zzj(), zzax.zzb(zzb(str, strZzd)), str, strZzd));
        zzao.zzc("", str, strZzd);
    }

    public long getCreationTime() {
        return zzao.zzg("").getCreationTime();
    }

    @WorkerThread
    public String getId() {
        zzh();
        return zzj();
    }

    @NonNull
    public Task<InstanceIdResult> getInstanceId() {
        return zza(zzan.zza(this.zzar), "*");
    }

    @Nullable
    @Deprecated
    public String getToken() {
        zzax zzaxVarZzk = zzk();
        if (this.zzat.needsRefresh() || zza(zzaxVarZzk)) {
            startSync();
        }
        return zzax.zzb(zzaxVarZzk);
    }

    @WorkerThread
    public String getToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        return ((InstanceIdResult) zza(zza(str, str2))).getToken();
    }

    public final Task<Void> zza(String str) {
        Task<Void> taskZza;
        synchronized (this) {
            taskZza = this.zzav.zza(str);
            startSync();
        }
        return taskZza;
    }

    final /* synthetic */ Task zza(final String str, final String str2, Task task) throws Exception {
        final String strZzj = zzj();
        zzax zzaxVarZzb = zzb(str, str2);
        if (!this.zzat.needsRefresh() && !zza(zzaxVarZzb)) {
            return Tasks.forResult(new zzx(strZzj, zzaxVarZzb.zzbu));
        }
        final String strZzb = zzax.zzb(zzaxVarZzb);
        return this.zzau.zza(str, str2, new zzas(this, strZzj, strZzb, str, str2) { // from class: com.google.firebase.iid.zzo
            private final FirebaseInstanceId zzay;
            private final String zzaz;
            private final String zzba;
            private final String zzbb;
            private final String zzbc;

            {
                this.zzay = this;
                this.zzaz = strZzj;
                this.zzba = strZzb;
                this.zzbb = str;
                this.zzbc = str2;
            }

            @Override // com.google.firebase.iid.zzas
            public final Task zzs() {
                return this.zzay.zza(this.zzaz, this.zzba, this.zzbb, this.zzbc);
            }
        });
    }

    final /* synthetic */ Task zza(final String str, String str2, final String str3, final String str4) {
        return this.zzat.getToken(str, str2, str3, str4).onSuccessTask(this.zzaq, new SuccessContinuation(this, str3, str4, str) { // from class: com.google.firebase.iid.zzp
            private final FirebaseInstanceId zzay;
            private final String zzaz;
            private final String zzba;
            private final String zzbb;

            {
                this.zzay = this;
                this.zzaz = str3;
                this.zzba = str4;
                this.zzbb = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.zzay.zzb(this.zzaz, this.zzba, this.zzbb, (String) obj);
            }
        });
    }

    final void zza(long j) {
        synchronized (this) {
            zza(new zzay(this, this.zzas, this.zzav, Math.min(Math.max(30L, j << 1), zzan)), j);
            this.zzaw = true;
        }
    }

    final void zza(boolean z) {
        synchronized (this) {
            this.zzaw = z;
        }
    }

    final boolean zza(@Nullable zzax zzaxVar) {
        return zzaxVar == null || zzaxVar.zzj(this.zzas.zzad());
    }

    final /* synthetic */ Task zzb(String str, String str2, String str3, String str4) throws Exception {
        zzao.zza("", str, str2, str4, this.zzas.zzad());
        return Tasks.forResult(new zzx(str3, str4));
    }

    final void zzb(String str) throws IOException {
        zzax zzaxVarZzk = zzk();
        if (zza(zzaxVarZzk)) {
            throw new IOException("token not available");
        }
        zza(this.zzat.subscribeToTopic(zzj(), zzaxVarZzk.zzbu, str));
    }

    @VisibleForTesting
    public final void zzb(boolean z) {
        this.zzax.setEnabled(z);
    }

    final void zzc(String str) throws IOException {
        zzax zzaxVarZzk = zzk();
        if (zza(zzaxVarZzk)) {
            throw new IOException("token not available");
        }
        zza(this.zzat.unsubscribeFromTopic(zzj(), zzaxVarZzk.zzbu, str));
    }

    final FirebaseApp zzi() {
        return this.zzar;
    }

    @Nullable
    final zzax zzk() {
        return zzb(zzan.zza(this.zzar), "*");
    }

    final String zzl() throws IOException {
        return getToken(zzan.zza(this.zzar), "*");
    }

    final void zzn() {
        synchronized (this) {
            zzao.zzal();
            if (this.zzax.isEnabled()) {
                startSync();
            }
        }
    }

    final boolean zzo() {
        return this.zzat.isAvailable();
    }

    final void zzp() {
        zzao.zzh("");
        startSync();
    }

    @VisibleForTesting
    public final boolean zzq() {
        return this.zzax.isEnabled();
    }

    final boolean zzr() {
        return this.zzat.needsRefresh();
    }
}
