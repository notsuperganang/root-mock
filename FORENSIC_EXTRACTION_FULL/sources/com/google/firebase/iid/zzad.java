package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class zzad implements ServiceConnection {

    @GuardedBy("this")
    int state;
    final Messenger zzcb;
    zzai zzcc;

    @GuardedBy("this")
    final Queue<zzak<?>> zzcd;

    @GuardedBy("this")
    final SparseArray<zzak<?>> zzce;
    final /* synthetic */ zzab zzcf;

    private zzad(zzab zzabVar) {
        this.zzcf = zzabVar;
        this.state = 0;
        this.zzcb = new Messenger(new com.google.android.gms.internal.firebase_messaging.zzf(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.firebase.iid.zzae
            private final zzad zzcg;

            {
                this.zzcg = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.zzcg.zza(message);
            }
        }));
        this.zzcd = new ArrayDeque();
        this.zzce = new SparseArray<>();
    }

    private final void zzy() {
        this.zzcf.zzby.execute(new Runnable(this) { // from class: com.google.firebase.iid.zzag
            private final zzad zzcg;

            {
                this.zzcg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final zzak<?> zzakVarPoll;
                final zzad zzadVar = this.zzcg;
                while (true) {
                    synchronized (zzadVar) {
                        if (zzadVar.state != 2) {
                            return;
                        }
                        if (zzadVar.zzcd.isEmpty()) {
                            zzadVar.zzz();
                            return;
                        } else {
                            zzakVarPoll = zzadVar.zzcd.poll();
                            zzadVar.zzce.put(zzakVarPoll.zzcj, zzakVarPoll);
                            zzadVar.zzcf.zzby.schedule(new Runnable(zzadVar, zzakVarPoll) { // from class: com.google.firebase.iid.zzah
                                private final zzad zzcg;
                                private final zzak zzch;

                                {
                                    this.zzcg = zzadVar;
                                    this.zzch = zzakVarPoll;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.zzcg.zza(this.zzch.zzcj);
                                }
                            }, 30L, TimeUnit.SECONDS);
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String strValueOf = String.valueOf(zzakVarPoll);
                        Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(strValueOf).length() + 8).append("Sending ").append(strValueOf).toString());
                    }
                    Context context = zzadVar.zzcf.zzac;
                    Messenger messenger = zzadVar.zzcb;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = zzakVarPoll.what;
                    messageObtain.arg1 = zzakVarPoll.zzcj;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", zzakVarPoll.zzab());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", zzakVarPoll.zzcl);
                    messageObtain.setData(bundle);
                    try {
                        zzadVar.zzcc.send(messageObtain);
                    } catch (RemoteException e) {
                        zzadVar.zza(2, e.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            try {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Service connected");
                }
                if (iBinder == null) {
                    zza(0, "Null service connection");
                } else {
                    try {
                        this.zzcc = new zzai(iBinder);
                        this.state = 2;
                        zzy();
                    } catch (RemoteException e) {
                        zza(0, e.getMessage());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Service disconnected");
            }
            zza(2, "Service disconnected");
        }
    }

    final void zza(int i) {
        synchronized (this) {
            zzak<?> zzakVar = this.zzce.get(i);
            if (zzakVar != null) {
                Log.w("MessengerIpcClient", new StringBuilder(31).append("Timing out request: ").append(i).toString());
                this.zzce.remove(i);
                zzakVar.zza(new zzal(3, "Timed out waiting for response"));
                zzz();
            }
        }
    }

    final void zza(int i, String str) {
        synchronized (this) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(str);
                Log.d("MessengerIpcClient", strValueOf.length() != 0 ? "Disconnected: ".concat(strValueOf) : new String("Disconnected: "));
            }
            switch (this.state) {
                case 0:
                    throw new IllegalStateException();
                case 1:
                case 2:
                    if (Log.isLoggable("MessengerIpcClient", 2)) {
                        Log.v("MessengerIpcClient", "Unbinding service");
                    }
                    this.state = 4;
                    ConnectionTracker.getInstance().unbindService(this.zzcf.zzac, this);
                    zzal zzalVar = new zzal(i, str);
                    Iterator<zzak<?>> it = this.zzcd.iterator();
                    while (it.hasNext()) {
                        it.next().zza(zzalVar);
                    }
                    this.zzcd.clear();
                    for (int i2 = 0; i2 < this.zzce.size(); i2++) {
                        this.zzce.valueAt(i2).zza(zzalVar);
                    }
                    this.zzce.clear();
                    break;
                case 3:
                    this.state = 4;
                    break;
                case 4:
                    break;
                default:
                    throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
            }
        }
    }

    final boolean zza(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", new StringBuilder(41).append("Received response to request: ").append(i).toString());
        }
        synchronized (this) {
            zzak<?> zzakVar = this.zzce.get(i);
            if (zzakVar == null) {
                Log.w("MessengerIpcClient", new StringBuilder(50).append("Received response for unknown request: ").append(i).toString());
                return true;
            }
            this.zzce.remove(i);
            zzz();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                zzakVar.zza(new zzal(4, "Not supported by GmsCore"));
                return true;
            }
            zzakVar.zzb(data);
            return true;
        }
    }

    final void zzaa() {
        synchronized (this) {
            if (this.state == 1) {
                zza(1, "Timed out while binding");
            }
        }
    }

    final boolean zzb(zzak zzakVar) {
        boolean z = true;
        synchronized (this) {
            switch (this.state) {
                case 0:
                    this.zzcd.add(zzakVar);
                    Preconditions.checkState(this.state == 0);
                    if (Log.isLoggable("MessengerIpcClient", 2)) {
                        Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                    }
                    this.state = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (!ConnectionTracker.getInstance().bindService(this.zzcf.zzac, intent, this, 1)) {
                        zza(0, "Unable to bind to service");
                    } else {
                        this.zzcf.zzby.schedule(new Runnable(this) { // from class: com.google.firebase.iid.zzaf
                            private final zzad zzcg;

                            {
                                this.zzcg = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzcg.zzaa();
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    break;
                case 1:
                    this.zzcd.add(zzakVar);
                    break;
                case 2:
                    this.zzcd.add(zzakVar);
                    zzy();
                    break;
                case 3:
                case 4:
                    z = false;
                    break;
                default:
                    throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
            }
        }
        return z;
    }

    final void zzz() {
        synchronized (this) {
            if (this.state == 2 && this.zzcd.isEmpty() && this.zzce.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.state = 3;
                ConnectionTracker.getInstance().unbindService(this.zzcf.zzac, this);
            }
        }
    }
}
