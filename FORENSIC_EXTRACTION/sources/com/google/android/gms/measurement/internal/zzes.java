package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public final class zzes implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzeb zzasl;
    private volatile boolean zzasr;
    private volatile zzar zzass;

    protected zzes(zzeb zzebVar) {
        this.zzasl = zzebVar;
    }

    static /* synthetic */ boolean zza(zzes zzesVar, boolean z) {
        zzesVar.zzasr = false;
        return false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnected(@Nullable Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.zzasl.zzgs().zzc(new zzev(this, this.zzass.getService()));
            } catch (DeadObjectException | IllegalStateException e) {
                this.zzass = null;
                this.zzasr = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzas zzasVarZzkj = this.zzasl.zzada.zzkj();
        if (zzasVarZzkj != null) {
            zzasVarZzkj.zzjj().zzg("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzasr = false;
            this.zzass = null;
        }
        this.zzasl.zzgs().zzc(new zzex(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zzasl.zzgt().zzjn().zzby("Service connection suspended");
        this.zzasl.zzgs().zzc(new zzew(this));
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzaj zzalVar;
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            try {
                if (iBinder == null) {
                    this.zzasr = false;
                    this.zzasl.zzgt().zzjg().zzby("Service connected with null binder");
                    return;
                }
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        if (iBinder == null) {
                            zzalVar = null;
                        } else {
                            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                            zzalVar = iInterfaceQueryLocalInterface instanceof zzaj ? (zzaj) iInterfaceQueryLocalInterface : new zzal(iBinder);
                        }
                        try {
                            this.zzasl.zzgt().zzjo().zzby("Bound to IMeasurementService interface");
                        } catch (RemoteException e) {
                            this.zzasl.zzgt().zzjg().zzby("Service connect failed to get IMeasurementService");
                        }
                    } else {
                        this.zzasl.zzgt().zzjg().zzg("Got binder with a wrong descriptor", interfaceDescriptor);
                        zzalVar = null;
                    }
                } catch (RemoteException e2) {
                    zzalVar = null;
                }
                if (zzalVar == null) {
                    this.zzasr = false;
                    try {
                        ConnectionTracker.getInstance().unbindService(this.zzasl.getContext(), this.zzasl.zzase);
                    } catch (IllegalArgumentException e3) {
                    }
                } else {
                    this.zzasl.zzgs().zzc(new zzet(this, zzalVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zzasl.zzgt().zzjn().zzby("Service disconnected");
        this.zzasl.zzgs().zzc(new zzeu(this, componentName));
    }

    @WorkerThread
    public final void zzb(Intent intent) {
        this.zzasl.zzaf();
        Context context = this.zzasl.getContext();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzasr) {
                this.zzasl.zzgt().zzjo().zzby("Connection attempt already in progress");
                return;
            }
            this.zzasl.zzgt().zzjo().zzby("Using local app measurement service");
            this.zzasr = true;
            connectionTracker.bindService(context, intent, this.zzasl.zzase, 129);
        }
    }

    @WorkerThread
    public final void zzlk() {
        if (this.zzass != null && (this.zzass.isConnected() || this.zzass.isConnecting())) {
            this.zzass.disconnect();
        }
        this.zzass = null;
    }

    @WorkerThread
    public final void zzll() {
        this.zzasl.zzaf();
        Context context = this.zzasl.getContext();
        synchronized (this) {
            if (this.zzasr) {
                this.zzasl.zzgt().zzjo().zzby("Connection attempt already in progress");
                return;
            }
            if (this.zzass != null && (this.zzass.isConnecting() || this.zzass.isConnected())) {
                this.zzasl.zzgt().zzjo().zzby("Already awaiting connection attempt");
                return;
            }
            this.zzass = new zzar(context, Looper.getMainLooper(), this, this);
            this.zzasl.zzgt().zzjo().zzby("Connecting to remote service");
            this.zzasr = true;
            this.zzass.checkAvailabilityAndConnect();
        }
    }
}
