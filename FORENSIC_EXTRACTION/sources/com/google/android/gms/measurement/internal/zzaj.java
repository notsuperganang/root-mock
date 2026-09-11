package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface zzaj extends IInterface {
    List<zzfu> zza(zzk zzkVar, boolean z) throws RemoteException;

    List<zzo> zza(String str, String str2, zzk zzkVar) throws RemoteException;

    List<zzfu> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzfu> zza(String str, String str2, boolean z, zzk zzkVar) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(zzag zzagVar, zzk zzkVar) throws RemoteException;

    void zza(zzag zzagVar, String str, String str2) throws RemoteException;

    void zza(zzfu zzfuVar, zzk zzkVar) throws RemoteException;

    void zza(zzk zzkVar) throws RemoteException;

    void zza(zzo zzoVar, zzk zzkVar) throws RemoteException;

    byte[] zza(zzag zzagVar, String str) throws RemoteException;

    void zzb(zzk zzkVar) throws RemoteException;

    void zzb(zzo zzoVar) throws RemoteException;

    String zzc(zzk zzkVar) throws RemoteException;

    void zzd(zzk zzkVar) throws RemoteException;

    List<zzo> zze(String str, String str2, String str3) throws RemoteException;
}
