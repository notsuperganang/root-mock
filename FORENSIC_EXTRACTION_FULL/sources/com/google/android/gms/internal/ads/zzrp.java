package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzrp extends zzek implements zzro {
    public zzrp() {
        super("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzek
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                onUnconfirmedClickReceived(parcel.readString());
                break;
            case 2:
                onUnconfirmedClickCancelled();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
