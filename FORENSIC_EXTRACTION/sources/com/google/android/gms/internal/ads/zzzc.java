package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzzc {
    public static int zza(AdRequest.ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static MediationAdRequest zza(zzjj zzjjVar, boolean z) {
        AdRequest.Gender gender;
        HashSet hashSet = zzjjVar.zzapy != null ? new HashSet(zzjjVar.zzapy) : null;
        Date date = new Date(zzjjVar.zzapw);
        switch (zzjjVar.zzapx) {
            case 1:
                gender = AdRequest.Gender.MALE;
                break;
            case 2:
                gender = AdRequest.Gender.FEMALE;
                break;
            default:
                gender = AdRequest.Gender.UNKNOWN;
                break;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzjjVar.zzaqe);
    }
}
