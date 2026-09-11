package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzw implements zzv {
    private final IBinder zzbs;

    zzw(IBinder iBinder) {
        this.zzbs = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zzbs;
    }

    @Override // com.google.firebase.iid.zzv
    public final void send(Message message) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        parcelObtain.writeInt(1);
        message.writeToParcel(parcelObtain, 0);
        try {
            this.zzbs.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
