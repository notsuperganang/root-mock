package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzak extends com.google.android.gms.internal.measurement.zzr implements zzaj {
    public zzak() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((zzag) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzag.CREATOR), (zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zza((zzfu) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzfu.CREATOR), (zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zza((zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zza((zzag) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzag.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzb((zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzfu> listZza = zza((zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR), com.google.android.gms.internal.measurement.zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza);
                return true;
            case 9:
                byte[] bArrZza = zza((zzag) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzag.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrZza);
                return true;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String strZzc = zzc((zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(strZzc);
                return true;
            case 12:
                zza((zzo) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzo.CREATOR), (zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zzb((zzo) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzfu> listZza2 = zza(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzs.zza(parcel), (zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza2);
                return true;
            case 15:
                List<zzfu> listZza3 = zza(parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza3);
                return true;
            case 16:
                List<zzo> listZza4 = zza(parcel.readString(), parcel.readString(), (zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza4);
                return true;
            case 17:
                List<zzo> listZze = zze(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(listZze);
                return true;
            case 18:
                zzd((zzk) com.google.android.gms.internal.measurement.zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
