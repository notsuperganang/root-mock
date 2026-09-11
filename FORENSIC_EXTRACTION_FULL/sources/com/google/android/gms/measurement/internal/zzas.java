package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.GuardedBy;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzas extends zzcs {
    private long zzade;
    private char zzalu;

    @GuardedBy("this")
    private String zzalv;
    private final zzau zzalw;
    private final zzau zzalx;
    private final zzau zzaly;
    private final zzau zzalz;
    private final zzau zzama;
    private final zzau zzamb;
    private final zzau zzamc;
    private final zzau zzamd;
    private final zzau zzame;

    zzas(zzbw zzbwVar) {
        super(zzbwVar);
        this.zzalu = (char) 0;
        this.zzade = -1L;
        this.zzalw = new zzau(this, 6, false, false);
        this.zzalx = new zzau(this, 6, true, false);
        this.zzaly = new zzau(this, 6, false, true);
        this.zzalz = new zzau(this, 5, false, false);
        this.zzama = new zzau(this, 5, true, false);
        this.zzamb = new zzau(this, 5, false, true);
        this.zzamc = new zzau(this, 4, false, false);
        this.zzamd = new zzau(this, 3, false, false);
        this.zzame = new zzau(this, 2, false, false);
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        Object objValueOf = obj instanceof Integer ? Long.valueOf(((Integer) obj).intValue()) : obj;
        if (objValueOf instanceof Long) {
            if (z && Math.abs(((Long) objValueOf).longValue()) >= 100) {
                String str = String.valueOf(objValueOf).charAt(0) == '-' ? "-" : "";
                String strValueOf = String.valueOf(Math.abs(((Long) objValueOf).longValue()));
                return new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, strValueOf.length() - 1))).append("...").append(str).append(Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d)).toString();
            }
            return String.valueOf(objValueOf);
        }
        if (objValueOf instanceof Boolean) {
            return String.valueOf(objValueOf);
        }
        if (!(objValueOf instanceof Throwable)) {
            if (objValueOf instanceof zzav) {
                return ((zzav) objValueOf).zzamn;
            }
            return z ? "-" : String.valueOf(objValueOf);
        }
        Throwable th = (Throwable) objValueOf;
        StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String strZzbx = zzbx(AppMeasurement.class.getCanonicalName());
        String strZzbx2 = zzbx(zzbw.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                String strZzbx3 = zzbx(className);
                if (strZzbx3.equals(strZzbx) || strZzbx3.equals(strZzbx2)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
            }
        }
        return sb.toString();
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String strZza = zza(z, obj);
        String strZza2 = zza(z, obj2);
        String strZza3 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(strZza)) {
            sb.append(str2);
            sb.append(strZza);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(strZza2)) {
            sb.append(str2);
            sb.append(strZza2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(strZza3)) {
            sb.append(str2);
            sb.append(strZza3);
        }
        return sb.toString();
    }

    protected static Object zzbw(String str) {
        if (str == null) {
            return null;
        }
        return new zzav(str);
    }

    private static String zzbx(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf != -1 ? str.substring(0, iLastIndexOf) : str;
    }

    @VisibleForTesting
    private final String zzjp() {
        String str;
        synchronized (this) {
            if (this.zzalv == null) {
                if (this.zzada.zzkq() != null) {
                    this.zzalv = this.zzada.zzkq();
                } else {
                    this.zzalv = zzq.zzhy();
                }
            }
            str = this.zzalv;
        }
        return str;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @VisibleForTesting
    protected final boolean isLoggable(int i) {
        return Log.isLoggable(zzjp(), i);
    }

    @VisibleForTesting
    protected final void zza(int i, String str) {
        Log.println(i, zzjp(), str);
    }

    protected final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && isLoggable(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzbr zzbrVarZzkl = this.zzada.zzkl();
        if (zzbrVarZzkl == null) {
            zza(6, "Scheduler not set. Not logging error/warn");
            return;
        }
        if (!zzbrVarZzkl.isInitialized()) {
            zza(6, "Scheduler not initialized. Not logging error/warn");
            return;
        }
        int i2 = i >= 0 ? i : 0;
        if (i2 >= 9) {
            i2 = 8;
        }
        zzbrVarZzkl.zzc(new zzat(this, i2, str, obj, obj2, obj3));
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfx zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.zzcs
    protected final boolean zzgy() {
        return false;
    }

    public final zzau zzjg() {
        return this.zzalw;
    }

    public final zzau zzjh() {
        return this.zzalx;
    }

    public final zzau zzji() {
        return this.zzaly;
    }

    public final zzau zzjj() {
        return this.zzalz;
    }

    public final zzau zzjk() {
        return this.zzama;
    }

    public final zzau zzjl() {
        return this.zzamb;
    }

    public final zzau zzjm() {
        return this.zzamc;
    }

    public final zzau zzjn() {
        return this.zzamd;
    }

    public final zzau zzjo() {
        return this.zzame;
    }

    public final String zzjq() {
        Pair<String, Long> pairZzfm = zzgu().zzanb.zzfm();
        if (pairZzfm == null || pairZzfm == zzbd.zzana) {
            return null;
        }
        String strValueOf = String.valueOf(pairZzfm.second);
        String str = (String) pairZzfm.first;
        return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(str).length()).append(strValueOf).append(":").append(str).toString();
    }
}
